package com.founder.rhip.dref.controller.outTransfer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.Base64Util;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.dref.controller.form.OutTransferQueryForm;
import com.founder.rhip.ehr.common.ExcelUtils;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.basic.UserOperationLog;
import com.founder.rhip.ehr.entity.clinic.OutTransfer;
import com.founder.rhip.ehr.service.IOutTransferService;
import com.founder.rhip.ehr.service.basic.IEhrSecurityService;
import com.founder.rhip.ehr.service.basic.IUserOperationLogService;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IOrganizationService;

@Controller
@RequestMapping(value = "/outTransfer")
public class OutTransferController extends BaseController {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Resource
    private IPlatformService platformService;

    @Resource
    private IOutTransferService outTransferService;

    @Resource(name = "userOperationLogService")
    private IUserOperationLogService userOperationLogService;

    @Resource(name = "dictionaryApp")
    private IDictionaryApp dictionaryApp;

    @Resource(name = "ehrSecurityService")
    private IEhrSecurityService ehrSecurityService;

    @Resource(name = "mdmOrganizationService")
    private IOrganizationService mdmOrganizationService;

	@RequestMapping("/search")
	public String search() {
		return "rhip.dref.outTransfer.search";
	}

	@RequestMapping("/list")
	public String list(HttpServletRequest request, ModelMap modelMap, int indexPage, OutTransferQueryForm form) {
		Page page = super.getPage(request, indexPage);
		Criteria criteria = form.toCriteria();
//		if (hasRole(RoleType.SJYYYWK, request)) {
//			Organization currentOrgan = getCurrentOrg(request);
//			criteria.add("FROM_ORGAN_CODE", currentOrgan.getOrganCode());
//		}
		PageList<OutTransfer> list = outTransferService.getPageList(page, criteria);
		modelMap.addAttribute("outTransferList", list.getList());
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("indexPage", indexPage);
		return "rhip.dref.outTransfer.list";
	}

	@RequestMapping("/initEdit")
	public String edit(HttpServletRequest request, ModelMap modelMap, Long id) {
		if (id != null) {
            User user = getCurrentUser(request);
			OutTransfer outTransfer = outTransferService.getOutTransfer(new Criteria("id", id));
            outTransfer.setMedicalDeptUserCode(String.valueOf(user.getId()));
            outTransfer.setMedicalDeptDt(new Date());
//            outTransfer.setCenterUser(centerUser);
//            outTransfer.setCenterDt(new Date());
            modelMap.addAttribute("outTransfer", outTransfer);
		}
		return "rhip.dref.outTransfer.edit";
	}

    @RequestMapping("/print1")
    public String print1(HttpServletRequest request, ModelMap modelMap, Long id) {
        if (id != null) {
            OutTransfer outTransfer = outTransferService.getOutTransfer(new Criteria("id", id));
            modelMap.addAttribute("outTransfer", outTransfer);
        }
        return "rhip.dref.outTransfer.print1";
    }

    @RequestMapping("/print2")
    public String print2(HttpServletRequest request, ModelMap modelMap, Long id) {
        if (id != null) {
            OutTransfer outTransfer = outTransferService.getOutTransfer(new Criteria("id", id));
            modelMap.addAttribute("outTransfer", outTransfer);
        }
        return "rhip.dref.outTransfer.print2";
    }

    /**
     * 判断编码规则
     */
    private Map<String, Object[]> decryptCharset(HttpServletRequest request, ModelMap model) {
    	//先用UTF-8解析看有没有编码参数
        Map<String, Object[]> map = null;
        String parameters = "";
        parameters = Base64Util.decrypt((request.getQueryString()), "UTF-8");

        if (ObjectUtil.isNotEmpty(parameters)){
            try{
                map = convertQueryToReport(parameters);
            }catch (Exception e) {
                logger.error("报卡上报接口,参数解析失败", e);
                model.put("errorMessage", "报卡上报接口,参数解析失败");
            }
        }
        //以下判断按照什么编码原则解析参数
        String charsetName = "";
        charsetName = getFieldValue(map, "charsetName");
        //没有编码参数默认是GB2312
        if (!ObjectUtil.isNotEmpty(charsetName)) {
            // 默认中文编码是GB2312
            parameters = Base64Util.decrypt((request.getQueryString()), "GB2312");
        }
        //由编码参数但是不是UTF-8
        else if(!charsetName.equalsIgnoreCase("UTF-8")){
            parameters = Base64Util.decrypt((request.getQueryString()), charsetName);
        }
      //以下按照什么编码原则分拆参数
        try {
            if (ObjectUtil.isNotEmpty(parameters) && !ObjectUtil.isNotEmpty(charsetName)) {
                map = convertQueryToReport(parameters);
            }else if(ObjectUtil.isNotEmpty(parameters) && !charsetName.equalsIgnoreCase("UTF-8")){
                map = convertQueryToReport(parameters);
            }
        } catch (Exception e) {
            logger.error("参数解析失败", e);
            model.put("errorMessage", "参数解析失败");
            return null;
        }
        return map;
    }

	@RequestMapping("/initAdd")
	public String initAdd(HttpServletRequest request, ModelMap model) {
		
		Map<String, Object[]> map = this.decryptCharset(request, model);
        if(ObjectUtil.isNullOrEmpty(map)) {
        	return "rhip.idm.report.error";
        }
        Map<String, Object>  checkMap = checkInputParams(map);
        if(!(boolean)checkMap.get("result")){
            model.put("errorMessage", checkMap.get("message").toString());
            return "rhip.idm.report.error";
        }

        OutTransfer outTransfer = setOutTransfer(map);
        model.put("outTransfer", outTransfer);
        return "rhip.dref.outTransfer.add";
	}

	/**
	 * 将值赋给OutTransfer
	 * @param map
	 * @return
	 */
	private OutTransfer setOutTransfer(Map<String, Object[]> map) {
		 OutTransfer outTransfer = new OutTransfer();
        if(ObjectUtil.isNotEmpty(map.get("idcard"))){
            outTransfer.setIdcard((String) map.get("idcard")[0]);
        }

        outTransfer.setFromOrganCode((String)map.get("fromOrganCode")[0]);
        String inFromOrganCode = OrganMap.OrganMap().get(map.get("fromOrganCode")[0]);
        outTransfer.setInFromOrganCode(inFromOrganCode);
        outTransfer.setSerialNumber(getSeqNumber(inFromOrganCode));

        outTransfer.setIcdCode((String) map.get("icdCode")[0]);

        outTransfer.setFromType((String) map.get("fromType")[0]);

        outTransfer.setFromOfficeCode((String) map.get("fromOfficeCode")[0]);

        outTransfer.setFromOfficeName((String) map.get("fromOfficeName")[0]);

        outTransfer.setIcdName((String) map.get("icdName")[0]);

        if(ObjectUtil.isNotEmpty(map.get("name"))){
            outTransfer.setName((String) map.get("name")[0]);
        }
        if(ObjectUtil.isNotEmpty(map.get("gender"))){
            outTransfer.setGender((String) map.get("gender")[0]);
        }
        if(ObjectUtil.isNotEmpty(map.get("birthday"))){
            outTransfer.setBirthdate(DateUtil.parseSimpleDate((String)map.get("birthday")[0], "yyyy/MM/dd"));
        }
        outTransfer.setOutNo((String) map.get("outNo")[0]);

        outTransfer.setInsuranceNo((String) map.get("insuranceNo")[0]);

        if(ObjectUtil.isNotEmpty(map.get("toOrganCode"))){
            outTransfer.setToOrganCode((String) map.get("toOrganCode")[0]);
        }

        outTransfer.setPatientType((String) map.get("patientType")[0]);

        outTransfer.setDoctor((String) map.get("doctor")[0]);

        outTransfer.setTransferDt(DateUtil.parseSimpleDate((String)map.get("transferDt")[0],"yyyy/MM/dd"));

        outTransfer.setCreateTransferUserCode((String) map.get("createTransferUserCode")[0]);

        outTransfer.setCreateTransferUser((String) map.get("createTransferUser")[0]);

        if(ObjectUtil.isNotEmpty(map.get("summary"))){
            outTransfer.setSummary((String) map.get("summary")[0]);
        }

        if(ObjectUtil.isNotEmpty(map.get("toOrganCode"))){
            outTransfer.setToOrganCode((String)map.get("toOrganCode")[0]);
        }
        return outTransfer;
	}
	
    public Map<String, Object>  checkInputParams(Map<String, Object[]> map){
        boolean result = true;
        StringBuilder message = new StringBuilder();
        Map<String, Object> checkMap = new HashMap<String, Object>();
        String charsetName = ObjectUtil.isNotEmpty(map.get("charsetName"))?(String)map.get("charsetName")[0]:"";
        String name = ObjectUtil.isNotEmpty(map.get("name"))?(String)map.get("name")[0]:"";
        String gender = ObjectUtil.isNotEmpty(map.get("gender"))?(String)map.get("gender")[0]:"";
        String birthday = ObjectUtil.isNotEmpty(map.get("birthday"))?(String)map.get("birthday")[0]:"";
        String outNo = ObjectUtil.isNotEmpty(map.get("outNo"))?(String)map.get("outNo")[0]:"";
        String insuranceNo = ObjectUtil.isNotEmpty(map.get("insuranceNo"))?(String)map.get("insuranceNo")[0]:"";
        String patientType = ObjectUtil.isNotEmpty(map.get("patientType"))?(String)map.get("patientType")[0]:"";
        String doctor = ObjectUtil.isNotEmpty(map.get("doctor"))?(String)map.get("doctor")[0]:"";
        String icdCode = ObjectUtil.isNotEmpty(map.get("icdCode"))?(String)map.get("icdCode")[0]:"";
        String icdName = ObjectUtil.isNotEmpty(map.get("icdName"))?(String)map.get("icdName")[0]:"";
        String createTransferUserCode = ObjectUtil.isNotEmpty(map.get("createTransferUserCode"))?(String)map.get("createTransferUserCode")[0]:"";
        String createTransferUser = ObjectUtil.isNotEmpty(map.get("createTransferUser"))?(String)map.get("createTransferUser")[0]:"";
        String fromOrganCode = ObjectUtil.isNotEmpty(map.get("fromOrganCode"))?(String)map.get("fromOrganCode")[0]:"";
        String transferDt = ObjectUtil.isNotEmpty(map.get("transferDt"))?(String)map.get("transferDt")[0]:"";

        String fromType = ObjectUtil.isNotEmpty(map.get("fromType"))?(String)map.get("fromType")[0]:"";
        String fromOfficeCode = ObjectUtil.isNotEmpty(map.get("fromOfficeCode"))?(String)map.get("fromOfficeCode")[0]:"";
        String fromOfficeName = ObjectUtil.isNotEmpty(map.get("fromOfficeName"))?(String)map.get("fromOfficeName")[0]:"";

        if(StringUtil.isNullOrEmpty(charsetName)){
            result = false;
            message.append("参数charsetName不正确    ");
        }
        if(StringUtil.isNullOrEmpty(name)){
            result = false;
            message.append("参数name不正确    ");
        }
//        if(StringUtil.isEmpty(idcard)){
//            result = false;
//            message.append("参数idcard不正确    ");
//        }
        if(StringUtil.isNullOrEmpty(gender)){
            result = false;
            message.append("参数gender不正确    ");
        }
        if(StringUtil.isNullOrEmpty(birthday)){
            result = false;
            message.append("参数birthday不正确    ");
        }
        if(StringUtil.isNullOrEmpty(outNo) || outNo.length()>32){
            result = false;
            message.append("参数outNo不正确    ");
        }
        if(StringUtil.isNullOrEmpty(insuranceNo) || ("03".equals(patientType) && insuranceNo.length()>8)){
            result = false;
            message.append("参数insuranceNo不正确    ");
        }
        if("00000000".equals(insuranceNo) && !(("04".equals(patientType) || "07".equals(patientType)))){
            result = false;
            message.append("医保编号00000000只适用自费或者救助的病人    ");
        }
        if(StringUtil.isNullOrEmpty(patientType)){
            result = false;
            message.append("参数patientType不正确    ");
        }
        if(StringUtil.isNullOrEmpty(doctor) || doctor.length()>16){
            result = false;
            message.append("参数doctor不正确    ");
        }
//        if(StringUtil.isEmpty(director) || director.length()>16){
//            result = false;
//            message.append("参数director不正确    ");
//        }
        if(StringUtil.isNullOrEmpty(icdCode) || icdCode.length() > 10){
            result = false;
            message.append("参数icdCode不正确    ");
        }
        if(StringUtil.isNullOrEmpty(icdName)){
            result = false;
            message.append("参数icdName不正确    ");
        }
        if(StringUtil.isNullOrEmpty(createTransferUserCode)){
            result = false;
            message.append("参数createTransferUserCode不正确    ");
        }
        if(StringUtil.isNullOrEmpty(createTransferUser)){
            result = false;
            message.append("参数createTransferUser不正确    ");
        }
        if(StringUtil.isNullOrEmpty(fromOrganCode)){
            result = false;
            message.append("参数fromOrganCode不正确    ");
        }
        if(StringUtil.isNullOrEmpty(transferDt) || transferDt.length() !=10){
            result = false;
            message.append("参数transferDt不正确    ");
        }
        if(StringUtil.isNullOrEmpty(fromType) || ((!fromType.equals("0"))&&(!fromType.equals("1")))){
            result = false;
            message.append("参数fromType不正确    ");
        }
        if(StringUtil.isNullOrEmpty(fromOfficeCode)){
            result = false;
            message.append("参数fromOfficeCode不正确    ");
        }
        if(StringUtil.isNullOrEmpty(fromOfficeName)){
            result = false;
            message.append("参数fromOfficeName不正确    ");
        }

        checkMap.put("result", result);
        checkMap.put("message", message);
        return checkMap;
    }

    @RequestMapping("/view")
    public String view(HttpServletRequest request, ModelMap modelMap, Long id) {
        if (id != null) {
            OutTransfer outTransfer = outTransferService.getOutTransfer(new Criteria("id", id));
            modelMap.addAttribute("outTransfer", outTransfer);
        }

        return "rhip.dref.outTransfer.view";
    }

    @RequestMapping("/save")
    @ResponseBody
    public ModelMap save(HttpServletRequest request, OutTransfer outTransfer) {
        ModelMap modelMap = new ModelMap();
        try {
            outTransfer.setCreateTransferDt(new Date());
            outTransfer.setInToOrganCode(outTransfer.getToOrganCode());
            //需求变更，新增判重流程，2014-03-18
            String checkRepeatStr = "";
            if(outTransfer.getPatientType().equalsIgnoreCase("03") || outTransfer.getPatientType().equalsIgnoreCase("02")){
                checkRepeatStr = checkRepeat(outTransfer);
            }
            if(!checkRepeatStr.isEmpty()){
                modelMap.addAttribute("success", false);
                modelMap.addAttribute("message", checkRepeatStr);
            }else{
                Number result = outTransferService.save(outTransfer);
                try {
                    this.createOperationLog(request, RhipModuleName.DREF, "市外转诊", OperationName.ADD, outTransfer.getFromOrganCode(), outTransfer.getCreateTransferUser());
                } catch (Exception e) {
                    log.error("市外转诊操作日志失败:", e);
                }
                modelMap.addAttribute("id", result);
                if (result.longValue() != -1L) {
                    modelMap.addAttribute("success", true);
                    modelMap.addAttribute("message", "保存成功！");
                } else {
                    modelMap.addAttribute("success", false);
                    modelMap.addAttribute("message", "保存失败！");
                }
            }
        } catch (Exception e) {
            modelMap.addAttribute("success", false);
            modelMap.addAttribute("message", "保存失败！" + e.getMessage());
            log.error("市外转诊:",e);
        }
        return modelMap;
    }

    @RequestMapping("/edit")
    @ResponseBody
    public ModelMap edit(HttpServletRequest request, OutTransfer outTransfer) {
        ModelMap modelMap = new ModelMap();
        boolean result = false;
        outTransfer.setMedicalDeptDt(new Date());
        Map resultMap = new HashMap();
        try {
            //新农合病人要连合管中心审批
            if(outTransfer.getPatientType().equals("03") || outTransfer.getPatientType().equals("02")){
                resultMap = outTransferService.editWithCenterAudit(outTransfer);

            }else{
                outTransferService.update(outTransfer);
            }
            createOperationLog(request, RhipModuleName.DREF, "市外转诊审核", OperationName.UPDATE);
            result = true;
            modelMap.addAttribute("id", outTransfer.getId());
            if (result) {
                modelMap.addAttribute("success", true);
                if("2".equals(resultMap.get("centerAudit"))){
                    modelMap.addAttribute("message", resultMap.get("centerMsg"));
                }else {
                    modelMap.addAttribute("message", "保存成功！");
                }
            } else {
                modelMap.addAttribute("success", false);
                modelMap.addAttribute("message", "保存失败！");
            }
        } catch (Exception e) {
            modelMap.addAttribute("success", false);
            modelMap.addAttribute("message", "保存失败！" + e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping("/centerApprove")
    @ResponseBody
    public ModelMap centerApprove(HttpServletRequest request, OutTransfer outTransfer, String id, String medicalDeptUserCode, String medicalDeptOpinion) {
        ModelMap modelMap = new ModelMap();
        OutTransfer ot = outTransferService.getOutTransfer(new Criteria("id", id));
        boolean result = outTransferService.getCenterApprove(ot);
        modelMap.addAttribute("success", result);
        return modelMap;
    }

    /**
     *
     *	导出外部转诊EXCEL
     * @param request
     * @param response
     * @param form
     * @throws Exception
     */
    @RequestMapping("/downOTExcel")
    @ResponseBody
    public void downDrugExcel(OutTransferQueryForm form , HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            ExcelUtils excel = new ExcelUtils(getExcelPath("../views/dref/template/outTransfer.xls"));
            Criteria criteria = form.toCriteria();
//            if (hasRole(RoleType.SJYYYWK, request)) {
//                Organization currentOrgan = getCurrentOrg(request);
//                criteria.add("FROM_ORGAN_CODE", currentOrgan.getOrganCode());
//            }
            List<OutTransfer> outTransfers = outTransferService.getList(criteria);
            int totalRows = 8;
            int beginRowIndex = 8;
            int line = 0;
            excel.shiftRows(beginRowIndex-1 , totalRows,outTransfers.size());//
            for (OutTransfer outTransfer : outTransfers) {
                List<Object> objects = getDrugExcelValues(line, outTransfer);
                excel.writeLineWithFormat(objects,line + beginRowIndex-1);
                line++;
            }
            excel.shiftRows(beginRowIndex + line , totalRows + line, -1);//删除多余行
            excel.shiftRows(beginRowIndex-1, totalRows + line-1, -1);//删除多余行
            setExcelContent(response, "市外转诊统计表.xls");
            excel.save(response.getOutputStream());

            outTransfers.clear();
            outTransfers = null;
        } catch (Exception e) {
            log.error("下载《市外转诊统计表》出错", e);
            throw e;
        }
    }

    /**
     * 生成市外转诊一行数据
     *
     * @param outTransfer
     * @return
     */
    private List<Object> getDrugExcelValues(int rowNumber,OutTransfer outTransfer) {
        List<Object> line = new ArrayList<Object>();
        line.add(rowNumber + 1);//
        line.add(outTransfer.getName());//姓名
        line.add(dictionaryApp.queryDicItemName("GBT226112003", outTransfer.getGender()));  //性别
        line.add(DateUtil.toDateString(outTransfer.getBirthdate(), "yyyy/MM/dd"));//出生日期
        line.add(outTransfer.getOutNo());//门诊/住院号
        line.add(outTransfer.getIcdName());//初步诊断
        line.add(dictionaryApp.queryDicItemName("CV0710003", outTransfer.getPatientType()));//病人类型
        line.add(outTransfer.getDoctor());//诊治医生
        line.add(outTransfer.getFromOfficeName());//科室
        line.add(outTransfer.getDirector());//科主任
        line.add(outTransfer.getSummary());//病情摘要

        Organization organ = mdmOrganizationService.getOrganization(outTransfer.getFromOrganCode());
        if(ObjectUtil.isNotEmpty(organ)){
            line.add(organ.getOrganName());//转出机构
        }else {
            line.add("");//转出机构
        }
        line.add(DateUtil.toDateString(outTransfer.getTransferDt(), "yyyy/MM/dd"));//转出日期
        line.add(dictionaryApp.queryDicItemName("OT00002", outTransfer.getToOrganCode()));//转入机构
        String medicalAudit = StringUtil.isNullOrEmpty(outTransfer.getMedicalDeptAudit())?"":outTransfer.getMedicalDeptAudit();
        line.add( "1".equals(medicalAudit)?"通过":("2".equals(medicalAudit)?"不通过":""));//医院（医务科）意见
        String userId = outTransfer.getMedicalDeptUserCode();
        String userName = "";
        if(StringUtil.isNotEmpty(userId)){
            Long userIdLong = Long.valueOf(userId);
            userName = ehrSecurityService.getUser(userIdLong).getName();
        }
        line.add(userName);//医院（医务科）经办人
        line.add(DateUtil.toDateString(outTransfer.getMedicalDeptDt(), "yyyy/MM/dd"));//医院（医务科）经办日期
        String centerAudit = StringUtil.isNullOrEmpty(outTransfer.getCenterAudit())?"":outTransfer.getCenterAudit();
        line.add("1".equals(centerAudit)?"通过":("2".equals(centerAudit)?"不通过":""));//市居医（农合）中心审批意见
        line.add(outTransfer.getCenterUser());//市居医（农合）中心经办人
        line.add(DateUtil.toDateString(outTransfer.getCenterDt(), "yyyy/MM/dd"));//市居医（农合）中心经办日期
        return line;
    }

    /**
     * 将报卡参数字符串转换为map
     *
     * @param query
     * @return
     */
    private Map<String, Object[]> convertQueryToReport(String query) {
        Map<String, Object[]> map = new HashMap<String, Object[]>();
        String params[] = query.split("&");
        for (String param : params) {
            if (param.indexOf("=") > 0) {
                String keyValues[] = param.split("=");
                if (keyValues.length == 2) {
                    String value=keyValues[1] ;
                    value=value==null?"":value.trim();
                    map.put(keyValues[0], new Object[] { value});
                } else if (keyValues.length == 1) {
                    map.put(keyValues[0], new Object[] { "" });
                }
            }
        }
        return map;
    }

    /**
     * map中获取String值 ,null则返回""
     *
     * @param map
     * @param key
     * @return
     */
    private String getFieldValue(Map<String, Object[]> map, String key) {
        if (!map.containsKey(key)) {
            return "";
        }
        return map.get(key)[0].toString();
    }

    public PersonInfo getPersonInfo(String idCard) {
        PersonInfo personInfo = platformService.queryPersonalInfo(null, idCard);
        return ObjectUtil.isNotEmpty(personInfo) ? personInfo : new PersonInfo();
    }

    /**
     * 根据当前日期获取编号
     *
     * @return
     */
    private String getSeqNumber(String inFromOrganCode) {
        String seqNumber = inFromOrganCode;

        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        String time = df.format(date);
        Long id = outTransferService.getCount(new Criteria("SERIAL_NUMBER", OP.LIKE, time + "%"), "ID");
        if (id > 1) {
            id = id + 1;
        } else {
            id = 1L;
        }
        seqNumber += time;
        seqNumber += String.format("%04d", id);
        return seqNumber;
    }

    /**
     * 判重
     * 条件：同转出机构、同人、同病、同天
     * @return
     */
    private String checkRepeat(OutTransfer outTransfer){
        String result = "";
        Criteria criteria = new Criteria();
        criteria.add("fromOrganCode",outTransfer.getFromOrganCode());
        criteria.add("idcard",outTransfer.getIdcard());
        criteria.add("icdCode",outTransfer.getIcdCode());
        criteria.add("transferDt",outTransfer.getTransferDt());
        criteria.add("patientType", outTransfer.getPatientType());
        List<OutTransfer> outTransferList = outTransferService.getList(criteria);
        int tg = 0;  //通过
        int btg = 0; //不通过
        int dsh = 0; //待审核
        if(outTransferList.size()>0){
            for(int i=0; i<outTransferList.size(); i++){
                String mda = outTransferList.get(i).getMedicalDeptAudit();
                if(null != mda){
                    if(mda.equalsIgnoreCase("1")){
                        tg +=1;
                    }else if(outTransferList.get(i).getMedicalDeptAudit().equalsIgnoreCase("2")){
                        btg += 1;
                    }else if((!outTransferList.get(i).getMedicalDeptAudit().equalsIgnoreCase("1")) && (!outTransferList.get(i).getMedicalDeptAudit().equalsIgnoreCase("2"))){
                        dsh += 1;
                    }
                }else{
                    dsh += 1;
                }
            }
            if(tg>0){
                result = "该患者已经转诊，并且审核通过！";
                return result;
            }
            if((btg>0 && dsh>0) || dsh>0){
                result = "该患者已经转诊，正在等待审核！";
                return result;
            }
        }
        return result;
    }

    /**
     * 非登陆的操作日志
     * @param request
     * @param moduleName
     * @param actionName
     * @param operationName
     * @param organCode
     * @param userName
     */
    protected void createOperationLog(HttpServletRequest request, RhipModuleName moduleName,String actionName, OperationName operationName, String organCode, String userName) {
        UserOperationLog userOperationLog = new UserOperationLog();
        userOperationLog.setUserName(userName);
        userOperationLog.setUserIp(getRequestIp(request));
        userOperationLog.setUserRequest(request.getRequestURI());
        userOperationLog.setModuleName(moduleName.getZhName());
        userOperationLog.setActionName(actionName);
        userOperationLog.setOrgCode(organCode);
        userOperationLog.setOperationTime(new Date());
        userOperationLogService.createOperationLog(userOperationLog);
    }
}

