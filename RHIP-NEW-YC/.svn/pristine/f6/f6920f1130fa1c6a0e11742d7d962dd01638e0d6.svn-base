package com.founder.rhip.fds.service;

import com.alibaba.fastjson.JSONObject;
import com.founder.fasf.beans.*;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.JaxbUtils;
import com.founder.rhip.ehr.common.URLUtils;
import com.founder.rhip.ehr.entity.basic.FamilyInfo;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.portal.AccountInfo;
import com.founder.rhip.ehr.repository.basic.IFamilyInfoDao;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.fds.common.FDSConstants;
import com.founder.rhip.fds.entity.*;
import com.founder.rhip.fds.repository.*;
import com.founder.rhip.fds.util.HttpClientUtil;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * 个人签约服务
 */
@Service("personSignService")
public class PersonSignServiceImpl implements PersonSignService {

    @Resource(name = "signDao")
    private ISignDao signDao;

    @Resource(name = "signPersonDao")
    private ISignPersonDao signPersonDao;

    @Resource(name = "signServicePackageDao")
    private ISignServicePackageDao signServicePackageDao;

    @Resource(name = "signServiceItemDao")
    private ISignServiceItemDao signServiceItemDao;

    @Resource(name = "servicePackageDao")
    private IServicePackageDao servicePackageDao;

    @Resource(name = "serviceRecordDao")
    private IServiceRecordDao serviceRecordDao;

    @Resource(name = "personInfoDao")
    private IPersonInfoDao personInfoDao;

    @Resource(name = "externalCallLogDao")
    private IExternalCallLogDao externalCallLogDao;

    @Resource(name = "signLogDao")
    private ISignLogDao signLogDao;

    @Resource(name = "doctorService")
    private DoctorService doctorService;

    @Resource(name = "systemConfigDao")
    private ISystemConfigDao systemConfigDao;

    @Resource(name = "signFamilyDao")
    private ISignFamilyDao signFamilyDao;

    @Resource(name = "familyInfoDao")
    private IFamilyInfoDao familyInfoDao;

    @Resource(name = "servicePackageService")
    private ServicePackageService servicePackageService;

    @Resource(name = "servicePlanDao")
    private IServicePlanDao servicePlanDao;
    /**
     * 个人签约
     * @param sign 签约记录
     * @param signPerson 签约居民
     * @param servicePackageCodes 服务包编码列表
     * @return
     */
    @Override
    @Transactional
    public void saveSignRecord(Sign sign, SignPerson signPerson, String[] servicePackageCodes) throws Exception {
        //判断是否只有基础服务包，如果只有基础服务包，则更新付费标记、更新健康档案
        String paidFlag = FDSConstants.PAID_FLAG_0;
        //判断是否都是基础包
        boolean basePackageFlag = true;
        List<ServicePackage> servicePackages = servicePackageDao.getList(new Criteria("code", OP.IN,servicePackageCodes));
        for(ServicePackage servicePackage:servicePackages){
        	
            if(!FDSConstants.PACKAGE_TYPE_01.equals(servicePackage.getType())){
            	 if(servicePackage.getCode().equals("160000002E") || servicePackage.getCode().equals("160000002F")){
                	 basePackageFlag = true;
                }else{
                	basePackageFlag = false;
                	break;
                }
            }
        }
        //如果都是基础包则更新健康档案签约标记为：已签约，否则为：待付款
        if(basePackageFlag){
            paidFlag = FDSConstants.PAID_FLAG_1;
        }
        saveSign(paidFlag,sign);
        saveSignPerson(paidFlag,signPerson,sign.getId());
        saveSignServicePackage(signPerson.getId(),paidFlag,sign.getId(),servicePackageCodes,sign.getCreateUser());
        createServicePlan(servicePackages, signPerson);
        if(basePackageFlag){
            //调用健康门户，创建帐号
            createAccount(signPerson.getIdcard(), signPerson.getName(), signPerson.getOrganCode(), signPerson.getUpdateUser(), signPerson.getPhoneNumber());
            updatePersonSignStatus(FDSConstants.SIGN_FLG_1,sign.getPersonIdcard());
            saveSignLog(sign,FDSConstants.LOG_TYPE_SIGN);//签约日志
        }else {
            //待付款状态
            updatePersonSignStatus(FDSConstants.SIGN_FLG_2,sign.getPersonIdcard());
        }
    }

    /**
     * 更新签约状态：本库签约信息，健康档案签约信息
     * @param
     * @param idcard
     * @param packageCode
     * @return 0:失败
     */
    @Override
    @Transactional
    public int updateSignStatus(String userName,Date paidTime,String idcard,Long signId,String packageCode){
        int result = 0;
        //1.更新签约服务包表付费标记
        //2.检查该身份证当前的签约服务包是否都已经付费
        //2.1如果都付费，更新签约记录表付费记录,20170619修改 不用检查所有的都付费
        //2.2如果都付费，更新健康档案签约标记（签约标记、签约开始时间、签约结束时间）
        // VALID ='1' AND RESCIND_FLAG ='0'
       /* Criteria criSignPerson = new Criteria("valid",FDSConstants.VALID_1);
        criSignPerson.add("rescindFlag",FDSConstants.RESCIND_FLAG_0);
        criSignPerson.add("idcard",idcard);
        SignPerson signPerson = signPersonDao.get(criSignPerson);*/

        //modify by yejianfei 20171130 续约
        Criteria criSignPerson = new Criteria();
        if(ObjectUtil.isNotEmpty(signId)) {
            criSignPerson.add("signId", signId);
        }else{
            //主要给外部接口调用，因为对方只有身份证号码
            criSignPerson.add("idcard", idcard);
            criSignPerson.add("paidFlag",FDSConstants.PAID_FLAG_0);//未付款
        }
        List<SignPerson> signPersonList = signPersonDao.getList(criSignPerson,new Order("SIGN_TIME",false));
        SignPerson signPerson = null;
        if(ObjectUtil.isNotEmpty(signPersonList)){
            signPerson = signPersonList.get(0);
            if(ObjectUtil.isNullOrEmpty(signId)) {
                signId = signPerson.getSignId();
            }
        }
        if(ObjectUtil.isNotEmpty(signPerson)){
            //更新签约服务包表
            Parameters parameters = new Parameters();
            parameters.add("paidFlag",FDSConstants.PAID_FLAG_1);//付费标记
            parameters.add("paidTime", paidTime);
            parameters.add("updateUser", userName);
            parameters.add("updateDate", new Date());
            Criteria criPackage = new Criteria("signId",signId);//签约ID
            criPackage.add("servicePackageCode",packageCode);//服务包编码
            signServicePackageDao.update(parameters,criPackage);
            //更新签约记录表
            Parameters paraSigns = new Parameters();
            paraSigns.add("paidFlag",FDSConstants.PAID_FLAG_1);//付费标记
/*            paraSigns.add("effectiveStartDate",paidTime);//合约生效开始日期
            paraSigns.add("effectiveEndDate",DateUtil.add(paidTime,Calendar.YEAR,1));//合约生效结束日期*/
            //modify by yejianfei 20171201
            checkUpdateEffectiveDate(signPerson.getSignId(),paidTime,paraSigns);
            paraSigns.add("updateUser", userName);
            paraSigns.add("updateDate", new Date());
            paraSigns.add("manualPaidFlag", FDSConstants.MANUAL_PAID_FLAG_1);
            signDao.update(paraSigns,new Criteria("id",signId));
            //签约居民
            Parameters paraPersons = new Parameters();
            paraPersons.add("paidFlag",FDSConstants.PAID_FLAG_1);//付费标记
/*            paraPersons.add("effectiveStartDate",paidTime);//合约生效开始日期
            paraPersons.add("effectiveEndDate",DateUtil.add(paidTime,Calendar.YEAR,1));//合约生效结束日期*/
            //modify by yejianfei 20171201
            checkUpdateEffectiveDate(signPerson.getSignId(),paidTime,paraPersons);
            paraPersons.add("updateUser", userName);
            paraPersons.add("updateDate", new Date());
            signPersonDao.update(paraPersons,new Criteria("id",signPerson.getId()));
            //签约日志
            Sign sign = new Sign();
            Doctor doctor = doctorService.getDoctor(signPerson.getDoctorId());
            if(ObjectUtil.isNotEmpty(doctor)){
                sign.setId(signId);
                sign.setPaidFlag(FDSConstants.PAID_FLAG_1);
                sign.setEffectiveStartDate(paidTime);
                sign.setEffectiveEndDate(DateUtil.add(paidTime,Calendar.YEAR,1));
                sign.setUpdateUser(userName);
                sign.setUpdateDate(new Date());
                sign.setTeamCode(signPerson.getTeamCode());
                sign.setOrganCode(signPerson.getOrganCode());
                sign.setDoctorId(doctor.getId());
                sign.setDoctorIdcard(doctor.getIdCard());
                sign.setOrganCode(sign.getOrganCode());
                sign.setPersonIdcard(signPerson.getIdcard());
                sign.setValid(FDSConstants.VALID_1);
                sign.setTeamCode(sign.getTeamCode());
                sign.setCreateUser(userName);
                sign.setCreateDate(new Date());
                sign.setSignTime(signPerson.getSignTime());
            }
            saveSignLog(sign,FDSConstants.LOG_TYPE_SIGN);//签约日志
            Parameters paraPersonInfos = new Parameters();
            paraPersonInfos.add("signFlag",FDSConstants.PAID_FLAG_1);//付费标记
            paraPersonInfos.add("updateDate",new Date());
            paraPersonInfos.add("updateName",doctor.getName());
            paraPersonInfos.add("updateIdcard",doctor.getIdCard());
            personInfoDao.update(paraPersonInfos,new Criteria("idcard",idcard));
            result = 1;
        }

        //调用健康门户，创建帐号
        createAccount(idcard, signPerson.getName(), signPerson.getOrganCode(), userName, signPerson.getPhoneNumber());
        return result;
    }

    /**
     * 判断是否需要更新合同生效日期
     * @param signId
     * @param parameters
     * @return
     */
    private boolean checkUpdateEffectiveDate(Long signId,Date paidTime,Parameters parameters){
        /**
         * 1.新签：需要更新
         * 2.如果是续约的合约
         *   (1).如果缴费日期小于合约生效日期（根据上一个合约结束日期+1得来），不需要更新
         *   (2).如果缴费日期大于合约生效日期（根据上一个合约结束日期+1得来），需要更新为当前日期
         * @Date: 10:53 2017/12/1
         * @author yejianfei
         */
        boolean result = false;
        Sign sign = signDao.get(signId);
        if(ObjectUtil.isNotEmpty(sign) && FDSConstants.CONTRACT_TYPE_2.equals(sign.getContractType())){
            //续签
            if(DateUtil.getBetweenDays(new Date(),sign.getEffectiveStartDate()) < 0){
                //缴费日期大于合约生效日期
                parameters.add("effectiveStartDate",paidTime);//合约生效开始日期
                parameters.add("effectiveEndDate",DateUtil.add(paidTime,Calendar.YEAR,1));//合约生效结束日期
                result = true;
            }
        }else{
            //新签：需要更新
            parameters.add("effectiveStartDate",paidTime);//合约生效开始日期
            parameters.add("effectiveEndDate",DateUtil.add(paidTime,Calendar.YEAR,1));//合约生效结束日期
            result = true;
        }
        return result;
    }

    @Override
    public Sign getSignRecord(Criteria criteria) {
        return signDao.get(criteria);
    }

    /**
     * 更新签约状态：健康档案签约信息
     * @param
     * @param idcard
     * @return 0:失败
     */
    private int updatePersonSignStatus(Integer signFlag,String idcard){
        Parameters paraPersonInfos = new Parameters();
        paraPersonInfos.add("signFlag",signFlag);//付费标记
        paraPersonInfos.add("updateDate",new Date());
        return  personInfoDao.update(paraPersonInfos,new Criteria("idcard",idcard));
    }
    /**
     * 根据身份证号码判断是否已经签约（包括付费及未付费）
     * @param idcard
     * @return 1:已签约，2:签约，但未付费，3:未签约
     */
    @Override
    public int checkPersonSignFlag(String idcard) {
        int result = 3;
        Criteria criteria = new Criteria();
        criteria.add("idcard",idcard);
        criteria.add("valid",FDSConstants.VALID_1);
        criteria.add("rescindFlag",OP.NE,FDSConstants.RESCIND_FLAG_1);
        List<SignPerson> signPersonList =  signPersonDao.getList(criteria,new Order("SIGN_TIME",false));
        if(ObjectUtil.isNotEmpty(signPersonList)){
            Long signId = signPersonList.get(0).getSignId();
            Sign sign = signDao.get(signId);
            //状态为：有效
            if(ObjectUtil.isNotEmpty(sign) && FDSConstants.CONTRACT_STATUS_1.equals(sign.getContractStatus())){
                result = sign.getPaidFlag().equals(FDSConstants.PAID_FLAG_0)?2:1;
            }
        }
        return result;
    }

    @Override
    public List<SignPerson> getSignPersonList(Criteria criteria) {
        return signPersonDao.getList(criteria);
    }

    @Override
    public PageList<SignPerson> getSignPersonList(Criteria criteria, Page page, Order order) {
        return signPersonDao.getPageList(page,criteria,order);
    }

    @Override
    public SignPerson getSignPersonById(Long id) {
        return signPersonDao.get(id);
    }

    @Override
    public List<Sign> getServicePackageList(String idcard,Long signId) {
        Criteria criteria = new Criteria();
        if(StringUtil.isNotEmpty(idcard)) {
            criteria.add("SIGN.PERSON_IDCARD",idcard);
        }
        if(ObjectUtil.isNotEmpty(signId)) {
            criteria.add("SIGN.ID",signId);
        }
        criteria.add("sign.valid",FDSConstants.VALID_1);
        criteria.add("sign.paid_Flag",FDSConstants.PAID_FLAG_1);
        return signDao.getServicePackageList(criteria);
    }

    @Override
    public List<Sign> getPaidServicePackageList(String idcard, Long signId,String valid) {
        Criteria criteria = new Criteria();
        if(StringUtil.isNotEmpty(idcard)) {
            criteria.add("PERSON_IDCARD",idcard);
        }
        if(ObjectUtil.isNotEmpty(signId)) {
            criteria.add("SIGN_ID",signId);
        }
        if(ObjectUtil.isNotEmpty(valid)) {
            criteria.add("sign.valid",valid);
        }
        return signDao.getServicePackageList(criteria);
    }

    @Override
    public List<Sign> getPaidServicePackageList(Criteria criteria) {
        return signDao.getServicePackageList(criteria);
    }

    @Override
    public List<SignServiceItem> getSignServiceItemList(String servicePackageCode,Long signId) {
        Criteria criteria = new Criteria();
        criteria.add("signId",signId);
        if(StringUtil.isNotEmpty(servicePackageCode)) {
            criteria.add("servicePackageCode",servicePackageCode);
        }
        return signServiceItemDao.getList(criteria);
    }

    @Override
    public List<ServiceRecord> getServiceRecordList(Criteria criteria) {
        return serviceRecordDao.getList(criteria);
    }

    @Override
    public PageList<ServiceRecord> getServiceRecordList(Criteria criteria, Page page, Order order) {
        return serviceRecordDao.getPageList(page, criteria, order);
    }

    @Override
    public Long getSignedNumberOfDoctor(Long doctorId, String teamCode) {
        Criteria criteria = new Criteria();
        criteria.add("doctorId", doctorId);
        criteria.add("teamCode", teamCode);
        return signPersonDao.getCount(criteria,"id",Long.class);
    }

    @Override
    public List<Sign> getSignList(Criteria criteria) {
        return signDao.getList(criteria);
    }

    @Override
    public PageList<Sign> getSignList(Criteria criteria, Page page, Order order) {
        return signDao.getPageList(page, criteria, order);
    }

    @Override
    public List<SignServicePackage> getSignServicePackageList(Criteria criteria) {
        return signServicePackageDao.getList(criteria);
    }

    @Override
    public void saveSignLog(Sign sign,String logType) {
        Criteria criteria = new Criteria();
        criteria.add("signId",sign.getId());
        criteria.add("logType",logType);
        List<SignLog> signLogs = signLogDao.getList(criteria);
        //检查是否已经存在签约日志
        if(ObjectUtil.isNullOrEmpty(signLogs)){
            SignLog signLog = new SignLog();
            BeanUtils.copyProperties(sign, signLog);
            signLog.setSignId(sign.getId());
            signLog.setLogType(logType);
            signLog.setId(signLogDao.getSequenceNextVal("SEQ_SIGN_LOG", Long.class));
            signLogDao.insert(signLog);
        }
    }

    @Override
    @Transactional
    public int cancelSign(Long signId, User user) {
        int result = 0;
        //查询签约记录
        Sign signRecord = getSignRecord(new Criteria("id",signId));
        if(ObjectUtil.isNotEmpty(signRecord)){
            Date cancelTime = new Date();//解约时间
            String doctorIdcard = user.getIdentityCard();
            Doctor currentDoctor = null;
            //医生ID，身份证
            if(StringUtil.isNotEmpty(doctorIdcard)) {
                currentDoctor = doctorService.getDoctor(doctorIdcard);
            }
            if(ObjectUtil.isNotEmpty(currentDoctor)){
                signRecord.setDoctorId(currentDoctor.getId());
            }
            signRecord.setDoctorIdcard(user.getIdentityCard());
            signRecord.setCancelTime(cancelTime);
            signRecord.setCreateDate(cancelTime);
            signRecord.setCreateUser(user.getUserName());
            signRecord.setUpdateDate(cancelTime);
            signRecord.setUpdateUser(user.getUserName());
            //签约日志：解约
            saveSignLog(signRecord,FDSConstants.LOG_TYPE_CANCEL);
            //签约服务包
            Criteria criteria = new Criteria();
            criteria.add("signId",signId);
            List<SignServicePackage> signServicePackageList = signServicePackageDao.getList(criteria);
            for(SignServicePackage signServicePackage:signServicePackageList) {
                signServicePackage.setRescindFlag(FDSConstants.RESCIND_FLAG_1);
                signServicePackage.setCancelTime(new Date());//解约时间
                signServicePackage.setUpdateUser(user.getUserName());
                signServicePackage.setUpdateDate(new Date());
                signServicePackageDao.update(signServicePackage,new String[]{"rescindFlag","cancelTime","updateUser","updateDate"});
            }
            //更新签约记录表
            Sign sign = new Sign();
            sign.setId(signId);
            sign.setRescindFlag(FDSConstants.RESCIND_FLAG_1);
            sign.setCancelTime(cancelTime);//解约时间
            sign.setUpdateUser(user.getUserName());
            sign.setUpdateDate(new Date());
            signDao.update(sign,new String[]{"rescindFlag","cancelTime","updateUser","updateDate"});
            //签约居民
            SignPerson signPerson = new SignPerson();
            signPerson.setSignId(signId);
            signPerson = signPersonDao.get(new Criteria("signId",signId));
            if(ObjectUtil.isNotEmpty(signPerson)) {
                signPerson.setRescindFlag(FDSConstants.RESCIND_FLAG_1);
                signPerson.setCancelTime(new Date());//解约时间
                signPerson.setUpdateUser(user.getUserName());
                signPerson.setUpdateDate(new Date());
                signPersonDao.update(signPerson,new String[]{"rescindFlag","cancelTime","updateUser","updateDate"});
            }
            //根据身份证更新健康档案签约标记
            Parameters paraPersonInfos = new Parameters();
            paraPersonInfos.add("signFlag",FDSConstants.PAID_FLAG_0);
            paraPersonInfos.add("updateDate",new Date());
            if(ObjectUtil.isNotEmpty(currentDoctor)) {
                paraPersonInfos.add("updateName",currentDoctor.getName());
                paraPersonInfos.add("updateIdcard",currentDoctor.getIdCard());
            }
            personInfoDao.update(paraPersonInfos,new Criteria("idcard",signPerson.getIdcard()));
        }
        return result;
    }

    @Override
    public List<SignLog> getSignLogList(Criteria criteria) {
        return signLogDao.getList(criteria);
    }

    @Override
    public SystemConfig getSystemConfig(Criteria criteria) {
        return systemConfigDao.get(criteria);
    }

    @Override
    public int checkRenewalsFlag(String idcard, PersonInfo personInfo) {
        int result = 0;
        Criteria criteria = new Criteria();
        criteria.add("personIdcard", idcard);
        criteria.add("valid", FDSConstants.VALID_1);
        criteria.add("rescindFlag",OP.NE, FDSConstants.RESCIND_FLAG_1);
        List<Sign> signList = signDao.getList(criteria,new Order("SIGN_TIME",false));
        Sign normalSign = null;//正常签约状态的
        Sign renewSign = null;//待生效的。
        if (ObjectUtil.isNotEmpty(signList)) {
            for(Sign sign:signList){
                String contractStatus = sign.getContractStatus();
                //有效
                if(FDSConstants.CONTRACT_STATUS_1.equals(contractStatus)){
                    normalSign = sign;
                }
                //待生效
                if(FDSConstants.CONTRACT_STATUS_2.equals(contractStatus)){
                    renewSign = sign;
                }
            }
            if(ObjectUtil.isNotEmpty(personInfo) && ObjectUtil.isNotEmpty(normalSign)){
                personInfo.setSignId(normalSign.getId());
            }
            //如果已经存在续签的记录则不能再续签
            if (ObjectUtil.isNotEmpty(renewSign)) {
                result = 2;//已经存在续签记录，不能续签
            } else if (ObjectUtil.isNotEmpty(normalSign)) {
                //存在正常状态的签约记录，判断过期日期
                //可以提前续约的天数
                Criteria criteriaConfig = new Criteria("name","ahead.renew.time");
                criteriaConfig.add("valid", FDSConstants.VALID_1);
                SystemConfig systemConfig = systemConfigDao.get(criteriaConfig);
                String aheadOfRenewTime = "";
                if(ObjectUtil.isNotEmpty(systemConfig)){
                    aheadOfRenewTime = systemConfig.getValue();
                }
                Integer aheadOfRenewDays = NumberUtil.convert(aheadOfRenewTime, Integer.class);
                //合同结束时间与当前时间相差的天数
                int days = DateUtil.getBetweenDays(new Date(), signList.get(0).getEffectiveEndDate());
                if (days <= aheadOfRenewDays) {
                    result = 1;//相差天数小于系统配置，可以续签
                } else {
                    result = 2;//相差天数大于系统配置，不能续签
                }
            }
        }
        return result;
    }

    /**
     * 在居民签约成功后，调用平台接口来给改签约居民创建健康门户用户
     * @param cardNo
     * @param realName
     * @param organCode
     * @param createUser
     * @param telephone  by Goofy 20180703
     */
    private void createAccount(String cardNo, String realName, String organCode, String createUser, String telephone) {
        // 组装居民信息
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setCardNo(cardNo);
        accountInfo.setRealName(realName);
        accountInfo.setTelephone(telephone); // 创建账号添加手机号码  Goofy 20180703
        String accountXml = JaxbUtils.marshal(accountInfo,AccountInfo.class);
        JSONObject param = new JSONObject();
        param.put("accountXml", accountXml);
        Criteria criteria = new Criteria("name","rhip.createAccount.url");
        criteria.add("valid", FDSConstants.VALID_1);
        SystemConfig systemConfig = systemConfigDao.get(criteria);
        String url = "";
        if(ObjectUtil.isNotEmpty(systemConfig)) {
            url = systemConfig.getValue();
        }
        // 记录日志
        ExternalCallLog externalCallLog = new ExternalCallLog();
        externalCallLog.setId(externalCallLogDao.getSequenceNextVal("SEQ_EXTERNAL_CALL_LOG", Long.class));
        externalCallLog.setOrganCode(organCode);
        if(ObjectUtil.isNotEmpty(systemConfig)) {
            externalCallLog.setRequestIp(systemConfig.getValue());
        }
        externalCallLog.setStartTime(new Date());
        externalCallLog.setRequestMsg(accountXml);
        externalCallLog.setServiceName("rhip.createAccount");
        externalCallLog.setCreateUser(createUser);
        externalCallLog.setUpdateUser(createUser);
        externalCallLog.setCreateDate(externalCallLog.getStartTime());
        externalCallLog.setUpdateDate(externalCallLog.getStartTime());
        try {
            //JSONObject result = HttpClientUtil.sendPost(url, param);
            String result = URLUtils.sendPost(url,"accountXml=" + accountXml);
            if (StringUtil.isNotEmpty(result)) {
                JSONObject resultJson = JSONObject.parseObject(result);
                externalCallLog.setResponseMsg(result.toString());
                if ("AA".equals(resultJson.getString("code"))) {
                    externalCallLog.setIsSuccess(FDSConstants.RESULT_SUCCESS);
                } else {
                    externalCallLog.setIsSuccess(FDSConstants.RESULT_FAILED);
                }
            }
        } catch (Exception e) {
            externalCallLog.setResponseMsg(e.getMessage());
            externalCallLog.setIsSuccess("0");
        }
        externalCallLog.setEndTime(new Date());
        externalCallLogDao.insert(externalCallLog);
    }

    /**
     * 保存签约记录
     * @param sign
     */
    private void saveSign(String paidFlag,Sign sign){
        if(ObjectUtil.isNotEmpty(sign)){
            //如果为空，默认为个人签约
            if(StringUtil.isNullOrEmpty(sign.getSignType())) {
                sign.setSignType(FDSConstants.SIGN_TYPE_1);//个人签约
            }
            sign.setPaidFlag(paidFlag);
            sign.setValid(FDSConstants.VALID_1);//有效
            sign.setRescindFlag(FDSConstants.RESCIND_FLAG_0);//正常
            sign.setSignTime(new Date());//签约时间
            //合约终止日期为开始时间后的一年
            sign.setEffectiveEndDate(DateUtil.add(sign.getEffectiveStartDate(),Calendar.YEAR,1));
            sign.setId(signDao.getSequenceNextVal("SEQ_SIGN", Long.class));
        }
        signDao.insert(sign);
    }

    /**
     * 保存签约居民
     * @param signPerson
     */
    private void saveSignPerson(String paidFlag,SignPerson signPerson,Long signId) throws Exception {
        if(ObjectUtil.isNotEmpty(signPerson)){
            signPerson.setSignId(signId);//签约记录表ID
            //默认为个人签约
            if(StringUtil.isNullOrEmpty(signPerson.getSignType())) {
                signPerson.setSignType(FDSConstants.SIGN_TYPE_1);//签约类型：个人
            }
            if(StringUtil.isNullOrEmpty(signPerson.getFamilyMemTypeCode())) {
                signPerson.setFamilyMemTypeCode(FDSConstants.FAMILY_MEM_TYPE_CODE_01);//家庭成员：本人
            }
            //家庭签约
            if(signPerson.getSignType().equals(FDSConstants.SIGN_TYPE_2)){
                //保存家庭信息
                saveSignFamily(signPerson.getAccountNumber(),signPerson.getCreateUser());
            }
            signPerson.setValid(FDSConstants.VALID_1);//有效
            signPerson.setPaidFlag(paidFlag);
            signPerson.setRescindFlag(FDSConstants.RESCIND_FLAG_0);//正常
            signPerson.setSignTime(new Date());
            //合约终止日期为开始时间后的一年
            signPerson.setEffectiveEndDate(DateUtil.add(signPerson.getEffectiveStartDate(),Calendar.YEAR,1));
            signPerson.setId(signPersonDao.getSequenceNextVal("SEQ_SIGN_PERSON", Long.class));
        }
        signPersonDao.insert(signPerson);
    }

    /**
     * 保存签约家庭信息
     * @param accountNumber
     * @return
     */
    private int saveSignFamily(String accountNumber,String userName) throws Exception {
        int result = 0;
        try{
            //首先查询家医中是否存在该家庭信息

            SignFamily signFamily = signFamilyDao.get(new Criteria("accountNumber", accountNumber));
            //如果不存在家庭信息，则需要将平台中的家庭信息保存至家庭医生数据库中
            if(ObjectUtil.isNullOrEmpty(signFamily)){
                FamilyInfo familyInfo = familyInfoDao.get(new Criteria("accountNumber", accountNumber));
                if(ObjectUtil.isNotEmpty(familyInfo)) {
                    signFamily = new SignFamily();
                    BeanUtils.copyProperties(familyInfo, signFamily);
                    signFamily.setId(null);
                    signFamily.setValid(FDSConstants.VALID_1);
                    signFamily.setRescindFlag(FDSConstants.RESCIND_FLAG_0);
                    signFamily.setSignFlag(FDSConstants.FAMILY_SIGN_FLAG_0);
                    signFamily.setCreateUser(userName);
                    signFamily.setCreateDate(new Date());
                    signFamily.setUpdateUser(userName);
                    signFamily.setUpdateDate(new Date());
                    signFamily.setId(signFamilyDao.getSequenceNextVal("SEQ_SIGN_FAMILY", Long.class));
                    result = signFamilyDao.insert(signFamily);
                }
            }
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
        return result;
    }
    /**
     * 自动生成服务计划
     * @param servicePackages
     */
    private void createServicePlan(List<ServicePackage> servicePackages,SignPerson signPerson){
    	 Doctor doctor = doctorService.getDoctor(signPerson.getDoctorId());  
    	    for(ServicePackage servicePackage : servicePackages){
    		//增值包为糖尿病包、老年人包、高血压、慢性呼吸道、活动性肺结核患者服务包、晚期血吸虫病人健康管理服务包，自动生成糖尿病包、老年人包、高血压、慢性呼吸道、活动性肺结核患者、晚期血吸虫病人的服务计划
    		if(servicePackage.getCode().equals("131200003") || servicePackage.getCode().equals("131200001") || servicePackage.getCode().equals("131200002") || servicePackage.getCode().equals("131200004")|| servicePackage.getCode().equals("160000002F")){
    			Date signTime = signPerson.getSignTime();
    			//每年6次健康管理（糖尿病，老年人）						
    			if(servicePackage.getCode().equals("131200003") || servicePackage.getCode().equals("131200001")){
    			for (int i = 1; i <= 6; i++) {
					ServicePlan servicePlan = new ServicePlan();
					servicePlan.setTeamCode(signPerson.getTeamCode());
					servicePlan.setDoctorId(signPerson.getDoctorId());
					servicePlan.setPlanDate(DateUtil.firstDateOfMonth(DateUtil.add(signTime, 2, i*2)));
					servicePlan.setValid("1");
					servicePlan.setCreateUser(signPerson.getCreateUser());
					servicePlan.setCreateDate(new Date());
					servicePlan.setUpdateUser(signPerson.getCreateUser());
					servicePlan.setUpdateDate(new Date());
					servicePlan.setDoctorIdcard(doctor.getIdCard());
					servicePlan.setPersonIdcard(signPerson.getIdcard());
					servicePlan.setContent("服务计划："+DateUtil.toFormatString("yyyy-MM-dd", servicePlan.getPlanDate())+"为"+signPerson.getName()+(servicePackage.getCode().equals("131200003")?"做空腹血糖、测量血压、健康指导服务":"做随访服务"));
					servicePlan.setOrganCode(signPerson.getOrganCode());
					servicePlan.setDataSrc("fds");
					servicePlan.setPlanYear(DateUtil.toFormatString("yyyy", servicePlan.getPlanDate()));
					servicePlan.setId(servicePlanDao.getSequenceNextVal("SEQ_SERVICE_PLAN", Long.class));
					servicePlanDao.insert(servicePlan);
    			}
    			}
    			//每年4次健康管理（高血压，慢病，吸血虫）
    			else if(servicePackage.getCode().equals("131200002")||servicePackage.getCode().equals("131200004")||servicePackage.getCode().equals("160000002F")){
    				for (int i = 1; i <= 4; i++) {
    					ServicePlan servicePlan = new ServicePlan();
    					servicePlan.setTeamCode(signPerson.getTeamCode());
    					servicePlan.setDoctorId(signPerson.getDoctorId());
    					if(i == 1){
    						servicePlan.setPlanDate(DateUtil.firstDateOfMonth(DateUtil.add(signTime, 2, i*2)));
    					}else{
    						servicePlan.setPlanDate(DateUtil.firstDateOfMonth(DateUtil.add(signTime, 2, i*3-1)));
    					}
    					servicePlan.setValid("1");
    					servicePlan.setCreateUser(signPerson.getCreateUser());
    					servicePlan.setCreateDate(new Date());
    					servicePlan.setUpdateUser(signPerson.getCreateUser());
    					servicePlan.setUpdateDate(new Date());
    					servicePlan.setDoctorIdcard(doctor.getIdCard());
    					servicePlan.setPersonIdcard(signPerson.getIdcard());
    					servicePlan.setContent("服务计划："+DateUtil.toFormatString("yyyy-MM-dd", servicePlan.getPlanDate())+"为"+signPerson.getName()+(servicePackage.getCode().equals("131200002")?"做空腹血糖、测量血压、健康指导服务":"做健康管理服务"));
    					servicePlan.setOrganCode(signPerson.getOrganCode());
    					servicePlan.setDataSrc("fds");
    					servicePlan.setPlanYear(DateUtil.toFormatString("yyyy", servicePlan.getPlanDate()));
    					servicePlan.setId(servicePlanDao.getSequenceNextVal("SEQ_SERVICE_PLAN", Long.class));
    					servicePlanDao.insert(servicePlan);
        			}
    			}
    			//健康评估（签约7个月后）
    			ServicePlan servicePlan = new ServicePlan();
				servicePlan.setTeamCode(signPerson.getTeamCode());
				servicePlan.setDoctorId(signPerson.getDoctorId());
				if(servicePackage.getCode().equals("131200003")||servicePackage.getCode().equals("131200004")||servicePackage.getCode().equals("160000002F")){
					servicePlan.setPlanDate(DateUtil.firstDateOfMonth(DateUtil.add(signTime, 2, 7)));
				}//健康评估（签约6个月后）
				else if(servicePackage.getCode().equals("131200001")||servicePackage.getCode().equals("131200002")){
					servicePlan.setPlanDate(DateUtil.firstDateOfMonth(DateUtil.add(signTime, 2, 6)));
				}
				servicePlan.setValid("1");
				servicePlan.setCreateUser(signPerson.getCreateUser());
				servicePlan.setCreateDate(new Date());
				servicePlan.setUpdateUser(signPerson.getCreateUser());
				servicePlan.setUpdateDate(new Date());
				servicePlan.setDoctorIdcard(doctor.getIdCard());
				servicePlan.setPersonIdcard(signPerson.getIdcard());
				servicePlan.setContent("服务计划："+DateUtil.toFormatString("yyyy-MM-dd", servicePlan.getPlanDate())+"为"+signPerson.getName()+"做健康评估服务");
				servicePlan.setOrganCode(signPerson.getOrganCode());
				servicePlan.setDataSrc("fds");
				servicePlan.setPlanYear(DateUtil.toFormatString("yyyy", servicePlan.getPlanDate()));
				servicePlan.setId(servicePlanDao.getSequenceNextVal("SEQ_SERVICE_PLAN", Long.class));
				servicePlanDao.insert(servicePlan);
    		}
    	}
    }

    /**
     * 保存签约服务包
     * @param servicePackageCodes
     */
    private void saveSignServicePackage(Long signPersonId,String paidFlag,Long signId,String[] servicePackageCodes,String userName){
        for(String code:servicePackageCodes){
            ServicePackage servicePackage = servicePackageService.getServicePackage(code);
            SignServicePackage signServicePackage = getSignServicePackage(signId,servicePackage,userName);
            //签约服务包
            if(FDSConstants.PACKAGE_TYPE_01.equals(servicePackage.getType())){
                //如果是基础包,则直接为付费状态
                signServicePackage.setPaidFlag(FDSConstants.PAID_FLAG_1);
            }else {
                signServicePackage.setPaidFlag(paidFlag);
            }
            signServicePackage.setPaidTime(new Date());
            signServicePackage.setSignPersonId(signPersonId);
            signServicePackage.setId(signServicePackageDao.getSequenceNextVal("SEQ_SIGN_SERVICE_PACKAGE", Long.class));
            signServicePackageDao.insert(signServicePackage);
            //签约服务项目
            signServiceItemDao.batchInsert(signServicePackage.getSignServiceItems());
        }
    }

    /**
     * 生成签约服务项目
     * @param signId
     * @param servicePackage
     * @return
     */
    private SignServicePackage getSignServicePackage(Long signId,ServicePackage servicePackage,String userName){
        SignServicePackage signServicePackage = new SignServicePackage();
        List<SignServiceItem> signServiceItemList  = new ArrayList<>();
        BeanUtils.copyProperties(servicePackage, signServicePackage);
        signServicePackage.setId(null);
        signServicePackage.setSignId(signId);
        signServicePackage.setServicePackageCode(servicePackage.getCode());
        signServicePackage.setServicePackageName(servicePackage.getName());
        signServicePackage.setServicePackagePrice(servicePackage.getPrice());
        signServicePackage.setCreateUser(userName);
        signServicePackage.setCreateDate(new Date());
        signServicePackage.setUpdateUser(userName);
        signServicePackage.setUpdateDate(new Date());
        for(ServiceItem item:servicePackage.getServiceItems()){
            SignServiceItem signServiceItem = new SignServiceItem();
            BeanUtils.copyProperties(item, signServiceItem);
            signServiceItem.setId(null);
            signServiceItem.setSignId(signId);
            signServiceItem.setServicePackageCode(servicePackage.getCode());
            signServiceItem.setServicePackageName(servicePackage.getName());
            signServiceItem.setServicePackagePrice(servicePackage.getPrice());
            signServiceItem.setServiceItemCode(item.getCode());
            signServiceItem.setServiceItemName(item.getName());
            signServiceItem.setServiceItemPrice(item.getPrice());
            signServiceItem.setGroupClassification(servicePackage.getGroupClassification());
            signServiceItem.setTimes(item.getTimes());
            signServiceItem.setNeedTimes(item.getNeedTimes());
            signServiceItem.setActualTimes(0);//实际服务次数，初始化为0
            signServiceItem.setValid(FDSConstants.VALID_1);//有效
            signServiceItem.setCreateUser(userName);
            signServiceItem.setCreateDate(new Date());
            signServiceItem.setUpdateUser(userName);
            signServiceItem.setUpdateDate(new Date());
            signServiceItem.setId(signServiceItemDao.getSequenceNextVal("SEQ_SIGN_SERVICE_ITEM", Long.class));
            signServiceItemList.add(signServiceItem);

        }
        signServicePackage.setSignServiceItems(signServiceItemList);
        return  signServicePackage;
    }

	@Override
	public int updateRefuseFlag(Long signId) {
		Parameters paraSigns = new Parameters();
		paraSigns.add("refuseFlag", "1");
		signDao.update(paraSigns, new Criteria("id",signId));
		return 0;
	}
}
