package com.founder.rhip.ehr.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.clinic.OutTransfer;
import com.founder.rhip.ehr.repository.clinic.ICenterDao;
import com.founder.rhip.ehr.repository.clinic.IOutTransferDao;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.*;

@Service("outTransferService")
public class OutTransferServiceImpl extends AbstractService implements IOutTransferService {

    @Resource
    private IOutTransferDao outTransferDao;

    @Resource
    private IPlatformService platformService;

    @Resource(name = "otDataSource")
    private DataSource otDataSource;

    @Resource
    private ICenterDao centerDao;

    private String[] approveProperties = new String[]{"director","medicalDeptAudit", "medicalDeptOpinion", "medicalDeptUserCode", "medicalDeptDt", "centerAudit", "centerOpinion", "centerUser", "centerDt"};

    @Override
    public PageList<OutTransfer> getPageList(Page page, Criteria criteria) {
        Order order = new Order("MEDICAL_DEPT_AUDIT", false);
        order.desc("CREATE_TRANSFER_DT");
        order.desc("ID");
        return outTransferDao.getPageList(page, criteria, order);
    }

    @Override
    public List<OutTransfer> getList(Criteria criteria) {
        Order order = new Order("MEDICAL_DEPT_AUDIT", false);
        order.desc("CREATE_TRANSFER_DT");
        order.desc("ID");
        return outTransferDao.getList(criteria, order);
    }

    @Override
    public OutTransfer getOutTransfer(Criteria criteria) {
        return outTransferDao.get(criteria);
    }

    @Override
    public Number save(OutTransfer OutTransfer) {
        if (OutTransfer == null) {
            return 0;
        } else {
            //新建
            return outTransferDao.generatedKey(OutTransfer, "ID", null);
        }
    }

    public Map editWithCenterAudit(OutTransfer outTransfer){
        Map resultMap = new HashMap();
        boolean result = false;
        //更新医务科的审核结果
        outTransferDao.update(outTransfer, approveProperties);

        if("1".equals(outTransfer.getMedicalDeptAudit())){
            //获取合管中心的审核结果
            OutTransfer ot = getOutTransfer(new Criteria("id", outTransfer.getId()));
            ot.setDirector(outTransfer.getDirector());
            LinkedHashMap<String, String> paramMap = new LinkedHashMap<>();
            paramMap.put("PI_ZZLX", "6");//转诊类型 | 1 | 不可空(6-市外1-市内)
            paramMap.put("PI_GRBH", ot.getInsuranceNo()); // 保险编号（个人编码）| 8 |
            paramMap.put("PI_ZCYYDM", ot.getInFromOrganCode()); // 转出医院代码| 6 |
            paramMap.put("PI_ZCLX", ot.getFromType()); // 转出类型| 1 | 0门诊 1住院
            paramMap.put("PI_HM", ot.getOutNo()); // 号码| 32 | 门诊号/住院号
            paramMap.put("PI_ZCKSMC", ot.getFromOfficeName()); // 转出科室名称| 128 |
            paramMap.put("PI_SQYS", ot.getDoctor()); // 申请医师（诊治医师）姓名| 16 |
            paramMap.put("PI_KSZRXM", ot.getDirector()); // 科主任姓名| 16 |
            paramMap.put("PI_PZRXM", ot.getMedicalDeptUserCode()); // 批准人姓名| 16 |
            paramMap.put("PI_ICD10CODE", ot.getIcdCode()); // 初步诊断（ICD10）| 10 |
            paramMap.put("PI_ZRYYDM", ot.getInToOrganCode()); // 转入医院代码| 6 |
            paramMap.put("PI_BQZY", ot.getSummary()); // 病情摘要（转诊、院理由）| 256 |
            paramMap.put("PI_YYYJ", ot.getMedicalDeptOpinion()); // 医院（医务科）意见| 256 |
            if(null==outTransfer.getTransferDt()){
                paramMap.put("PI_ZZRQ", DateUtil.getDateTime("yyyy-MM-dd", new Date())); // 转诊日期| 10 | YYYY-MM-DD
            }else{
                paramMap.put("PI_ZZRQ", DateUtil.getDateTime("yyyy-MM-dd", outTransfer.getTransferDt())); // 转诊日期| 10 | YYYY-MM-DD
            }
            if(null==outTransfer.getMedicalDeptDt()){
                paramMap.put("PI_SHRQ", DateUtil.getDateTime("yyyy-MM-dd", new Date())); // 审核日期| 10 | YYYY-MM-DD
            }else{
                paramMap.put("PI_SHRQ", DateUtil.getDateTime("yyyy-MM-dd", outTransfer.getMedicalDeptDt())); // 审核日期| 10 | YYYY-MM-DD
            }
            Map centerMap = centerDao.approve(paramMap);
            //更新合管中心的审核结果
            Parameters parameters = new Parameters();
            parameters.add("HG_CODE", centerMap.get("hgCode"));
            parameters.add("CENTER_AUDIT", centerMap.get("result"));
            parameters.add("CENTER_OPINION", centerMap.get("msg"));
            parameters.add("CENTER_USER", "市居医（农合）中心");
            parameters.add("CENTER_DT", new Date());

            resultMap.put("centerAudit", centerMap.get("result").toString());
            resultMap.put("centerMsg", centerMap.get("msg"));

            outTransferDao.update(parameters, new Criteria("id", outTransfer.getId()));
        }
        result = true;
        resultMap.put("result", result);

        return resultMap;
    }


    public boolean getCenterApprove(OutTransfer outTransfer) {
        boolean result = false;
//        LinkedHashMap<String, String> paramMap = new LinkedHashMap<>();
//        paramMap.put("PI_ZZLX", "6");//转诊类型 | 1 | 不可空(6-市外1-市内)
//        paramMap.put("PI_GRBH", outTransfer.getInsuranceNo()); // 保险编号（个人编码）| 8 |
//        paramMap.put("PI_ZCYYDM", outTransfer.getInFromOrganCode()); // 转出医院代码| 6 |
//        paramMap.put("PI_ZCLX", outTransfer.getFromType()); // 转出类型| 1 | 0门诊 1住院
//        paramMap.put("PI_HM", outTransfer.getOutNo()); // 号码| 32 | 门诊号/住院号
//        paramMap.put("PI_ZCKSMC", outTransfer.getFromOfficeName()); // 转出科室名称| 128 |
//        paramMap.put("PI_SQYS", outTransfer.getDoctor()); // 申请医师（诊治医师）姓名| 16 |
//        paramMap.put("PI_KSZRXM", outTransfer.getDirector()); // 科主任姓名| 16 |
//        paramMap.put("PI_PZRXM", "abc"); // 批准人姓名| 16 |
//        paramMap.put("PI_ICD10CODE", outTransfer.getDiagnose()); // 初步诊断（ICD10）| 10 |
//        paramMap.put("PI_ZRYYDM", outTransfer.getInToOrganCode()); // 转入医院代码| 6 |
//        paramMap.put("PI_BQZY", outTransfer.getSummary()); // 病情摘要（转诊、院理由）| 256 |
//        paramMap.put("PI_YYYJ", "ddd"); // 医院（医务科）意见| 256 |
//        paramMap.put("PI_ZZRQ", DateUtil.getDateTime("yyyy-MM-dd", outTransfer.getTransferDt())); // 转诊日期| 10 | YYYY-MM-DD
//        paramMap.put("PI_SHRQ", DateUtil.getDateTime("yyyy-MM-dd", outTransfer.getMedicalDeptDt())); // 审核日期| 10 | YYYY-MM-DD
////        SimpleJdbcCall procReadActor = new SimpleJdbcCall(otDataSource).withFunctionName("FNC_TEST");
////        Map out = procReadActor.withReturnValue().execute(paramMap);
////        String poRegCode = (String)out.get("PO_REGCODE");
////        String poResult = (String)out.get("PO_RESULT");
//        Map approveMap = new HashMap();
//        approve2(paramMap);
//
//        Parameters parameters = new Parameters();
//        parameters.add("HG_CODE", approveMap.get("hgCode"));
//        parameters.add("CENTER_AUDIT", approveMap.get("result"));
//        parameters.add("CENTER_OPINION", approveMap.get("msg"));
//        outTransferDao.update(parameters, new Criteria("id", outTransfer.getId()));
//        result = true;
        return result;
    }

//    public void approve(final LinkedHashMap<String, String> map, final Map resultMap) {
//        String sql = "{?=call FNC_TRANS_TREAT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
//        new SimpleJdbcTemplate(otDataSource).getJdbcOperations().execute(sql, new CallableStatementCallback<Object>() {
//            @Override
//            public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
//                cs.registerOutParameter(1, OracleTypes.INTEGER);//
//                int i = 2;
//                for (String key : map.keySet()) {
//                    cs.setString(i, map.get(key));
//                    i++;
//                }
//                cs.registerOutParameter(17, OracleTypes.VARCHAR);
//                cs.registerOutParameter(18, OracleTypes.VARCHAR);
//                cs.execute();
//                String poRegCode = cs.getString(17);
//                String poResult = cs.getString(18);
//                int result = cs.getInt(1);
//                resultMap.put("result", result);
//                resultMap.put("hgCode", poRegCode);
//                resultMap.put("msg", poResult);
//                return result;
//            }
//        });
//    }

//    public Map approve(LinkedHashMap<String, String> map) {
//        Map resultMap = new HashMap();
//        String sql = "{?=call FNC_TRANS_TREAT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
//        try {
//            Connection conn = otDataSource.getConnection();
//            conn.setAutoCommit(false);
//            CallableStatement cstmt = conn.prepareCall(sql);
//            cstmt.registerOutParameter(1, OracleTypes.INTEGER);//
//            int i = 2;
//            for (String key : map.keySet()) {
//                cstmt.setString(i, map.get(key));
//                i++;
//            }
//            cstmt.registerOutParameter(17, OracleTypes.VARCHAR);
//            cstmt.registerOutParameter(18, OracleTypes.VARCHAR);
//            cstmt.execute();
//
//            String poRegCode = cstmt.getString(17);
//            String poResult = cstmt.getString(18);
//            int result = cstmt.getInt(1);
//            resultMap.put("result", result == 0 ? 1:2);
//            resultMap.put("hgCode", poRegCode);
//            resultMap.put("msg", poResult);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return resultMap;
//    }

    @Override
    public int update(OutTransfer outTransfer) {
//        return outTransferDao.update(parameters, criteria);
        return outTransferDao.update(outTransfer, approveProperties);
    }

    @Override
    public List<OutTransfer> queryOutTransferList(Long personId, Date beginDate, Date endDate) {
        Criteria criteria = new Criteria();
        criteria.add("personId", personId);
        if (ObjectUtil.isNotEmpty(beginDate)) {
            if (ObjectUtil.isNotEmpty(endDate)) {
                criteria.add("referralDate", OP.BETWEEN, new Date[]{beginDate, endDate});
            } else {
                criteria.add("referralDate", OP.GE, beginDate);
            }
        } else if (ObjectUtil.isNotEmpty(endDate)) {
            criteria.add("referralDate", OP.LE, endDate);
        }
        return outTransferDao.getList(criteria.add("integratedData", 0).add("isDelete", 0), new Order("REFERRAL_DATE", false));
    }

    @Override
    public List<OutTransfer> queryOutTransferList(String pixId, Date beginDate, Date endDate) {
        PersonInfo person = platformService.queryPersonalInfo(pixId);
        if (person == null) {
            return null;
        }
        Long personId = person.getId();
        return queryOutTransferList(personId, beginDate, endDate);
    }

    public Long getCount(Criteria criteria, String countPropertyName) {
        return outTransferDao.getCount(criteria, countPropertyName, Long.class);
    }
}
