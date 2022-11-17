package com.founder.rhip.ehr.controller.external;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.beans.BeanUtil;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.Base64Util;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.entity.basic.ReportRecord;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmReport;
import com.founder.rhip.ehr.service.basic.IReportRecordService;
import com.founder.rhip.idm.common.ReportStatus;
import com.founder.rhip.idm.service.IReportService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IDiseaseApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Dictionary;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IDictionaryService;
import com.founder.rhip.mdm.service.IDiseaseService;
import com.founder.rhip.util.ConvertToolUtil;

/**
 * 外部报卡统一使用
 */
@Controller
@RequestMapping(value = "/external/report")
public class ExternalReportController extends BaseController {

	@Resource(name = "reportRecordService")
	private IReportRecordService reportRecordService;

	@Resource(name = "reportService")
	private IReportService reportService;

	@Resource(name="mdmDictionaryService")
	private IDictionaryService mdmDictionaryService;
	
	@Resource(name="dictionaryApp")
    private IDictionaryApp dictionaryApp;

	@Autowired
	IDiseaseApp diseaseApp;

	@Resource(name="mdmDiseaseService")
	private IDiseaseService diseaseService;

	static private Map<String, String> diseaseMap = new HashMap<>();
	static private Map<String, String> idmMap = new HashMap<>();
	static private Set<String> notReportICd10 = new HashSet<>();
	static private Set<String> orgCodeSet = new HashSet<>(); //需要显示上报按钮的机构

	private IcdTypeMapping icdTypeMapping;

	public ExternalReportController() {
		icdTypeMapping = new IcdTypeMapping();
		// 传染病慢病对应
		diseaseMap.put("1", "1");
		diseaseMap.put("2", "2");
		diseaseMap.put("3", "3");
		//慢病
		diseaseMap.put("6", "2");
		diseaseMap.put("7", "4");
		diseaseMap.put("8", "3");
		diseaseMap.put("9", "5");
		// 传染病ICD-10与字典对应
		idmMap.put("A20", "101");
		idmMap.put("A00", "102");



		idmMap.put("J10.0", "206");
		idmMap.put("B05", "207");

		idmMap.put("A82", "209");

		idmMap.put("A90", "211");



		idmMap.put("A01.0", "2151");
		idmMap.put("A01.1", "2152");
		idmMap.put("A01.2", "2152");
		idmMap.put("A01.3", "2152");
		idmMap.put("A01.4", "2152");
		idmMap.put("A01", "2151");

		//idmMap.put("A39", "216");
		idmMap.put("A37", "217");
		idmMap.put("A36", "218");
		idmMap.put("A33", "219");
		idmMap.put("A38", "220");
		idmMap.put("A23", "221");
		idmMap.put("A54", "222");
		idmMap.put("A27", "224");
		idmMap.put("B15", "2031");
		//乙肝
		idmMap.put("B16", "2032");
		idmMap.put("B17.0", "2032");
		idmMap.put("B18.0", "2032");
		idmMap.put("B18.1", "2032");
		//丙肝
		idmMap.put("B17.1", "2033");
		idmMap.put("B18.2", "2033");
		//戊肝
		idmMap.put("B17.2", "2034");
		//丁肝
		idmMap.put("B17.8", "2036");
		idmMap.put("B18.8", "2036");
		idmMap.put("B18.9", "2036");
		//肝炎（未分型）
		idmMap.put("B19", "2035");
		//hiv B20-B23
		idmMap.put("B20", "227");
		idmMap.put("B21", "227");
		idmMap.put("B22", "227");
		idmMap.put("B23", "227");
		idmMap.put("B24", "202");
		//梅毒	A50-A53
		/*idmMap.put("A50", "223");
		idmMap.put("A51", "223");
		idmMap.put("A52", "223");
		idmMap.put("A53", "223");*/
		//I期梅毒	A51.0-A51.2 A51.5 A51.9
		idmMap.put("A51.0", "2231");
		idmMap.put("A51.1", "2231");
		idmMap.put("A51.2", "2231");
		idmMap.put("A51.5", "2231");
		idmMap.put("A51.9", "2231");
		//II期梅毒	A51.3-A51.4
		idmMap.put("A51.3", "2232");
		idmMap.put("A51.4", "2232");
		//III期梅毒	A52
		idmMap.put("A52", "2233");
		//胎传梅毒	A50
		idmMap.put("A50", "2234");
		//隐性梅毒	A53.0
		idmMap.put("A53.0", "2235");
		//出血热	A98.5
		idmMap.put("A98.5", "208");
		//炭疽	A22
		idmMap.put("A22", "212");
		//肺炭疽	A22.1
		idmMap.put("A22.1", "2121");
		//皮肤炭疽	A22.0
		idmMap.put("A22.0", "2122");
		//炭疽（未分型）	A22.2-A22.9
		idmMap.put("A22.2", "2123");
		idmMap.put("A22.3", "2123");
		idmMap.put("A22.4", "2123");
		idmMap.put("A22.5", "2123");
		idmMap.put("A22.6", "2123");
		idmMap.put("A22.7", "2123");
		idmMap.put("A22.8", "2123");
		idmMap.put("A22.9", "2123");
		//斑疹伤寒	A75
		idmMap.put("A75", "306");
		//乙脑 A83.0
		idmMap.put("A83.0", "210");
		//流脑 A39.0
		idmMap.put("A39.0", "216");
		//黑热病	B55.0
		idmMap.put("B55.0", "307");
		//恶性虐
		idmMap.put("B50", "2262");
		//疟疾（未分型）	B53-B54
		idmMap.put("B53", "2263");
		idmMap.put("B54", "2263");
		//间日疟	B51
		idmMap.put("B51", "2261");
		//214 	肺结核	A15.0-A15.3 A16.0-A16.2
		//idmMap.put("214", "2141");
		//涂+	A15.0
		idmMap.put("A15.0", "2141");
		//菌-	A16.0
		idmMap.put("A16.0", "2143");
		//未痰检	A16.1
		idmMap.put("A16.1", "2144");
		idmMap.put("A15.2", "2144");
		idmMap.put("A15.3", "2144");
		idmMap.put("A16.3", "2144");
		//仅培阳	A15.1
		idmMap.put("A15.1", "2142");
		//idmMap.put("B33.803", "201");
		///传染性非典	U04
		idmMap.put("U04", "201");
		//血吸虫病	B65.2
		idmMap.put("B65.2", "225");
		//其他感染性腹泻	A09.0
		idmMap.put("A09.0", "310");
		//手足口病	B08.4
		idmMap.put("B08.4", "311");
		//人感染高致病性禽流感
		idmMap.put("J09.x01", "205");
		//急性出血性结膜炎	B30.3
		idmMap.put("B30.3", "304");
		//人感染H7N9禽流感
		idmMap.put("J09.x02", "228");

		//非淋病性尿道炎	N34.10
		idmMap.put("N34.10", "001");
		//尖锐湿疣	A63.0
		idmMap.put("A63.0", "002");
		//生殖性疱疹	A60.0 A60.9
		idmMap.put("A60.0", "003");
		idmMap.put("A60.9", "003");
		//不明原因肺炎

		//结核性胸膜炎	A15.6
		idmMap.put("A15.6", "004");
		//水痘	B01.00+ B01.10+ B01.20+ B01.80 B01.90
		idmMap.put("B01.00+", "005");
		idmMap.put("B01.10+", "005");
		idmMap.put("B01.20+", "005");
		idmMap.put("B01.80", "005");
		idmMap.put("B01.90", "005");
		//人感染猪链球菌	A28.80
		idmMap.put("A28.80", "006");
		//生殖道沙眼衣原体感染	A56.00
		idmMap.put("A56.00", "007");
		//肝吸虫病	B66.10
		idmMap.put("B66.10", "008");
		//羌虫病	A75.3
		idmMap.put("A75.3", "009");

		idmMap.put("A03", "2131");
		idmMap.put("A06.0", "2132");
		idmMap.put("J10", "301");
		idmMap.put("J11", "301");
		idmMap.put("B26", "302");
		idmMap.put("B06", "303");
		idmMap.put("A30", "305");
		idmMap.put("B67", "308");
		idmMap.put("B74", "309");
		//慢病ICD-10与字典对应
		idmMap.put("", "");

		notReportICd10.add("I69");

		orgCodeSet.add("46714063-X");  //一院
		orgCodeSet.add("46714062-1");  //二院
		orgCodeSet.add("46714062-11"); //二院城中分院
		orgCodeSet.add("46714062-12"); //二院琴枫分院
		orgCodeSet.add("320002991");   //二院传染病分院（结核病）
		orgCodeSet.add("46714117-3");  //三院
		orgCodeSet.add("46714077-9");  //五院
		orgCodeSet.add("46714077-91"); //新五院
		orgCodeSet.add("46714078-7");  //中医院
		orgCodeSet.add("46714078-71");//中医院（新区医院）外菱塘分院

	}

	@RequestMapping("/main")
	public String reportMain(HttpServletRequest request, ModelMap model) throws Exception {
		CurrentLoginInfo currentLoginInfo=new CurrentLoginInfo();
		User user=new User();
		Organization organization=new Organization();
		currentLoginInfo.setUser(user);
		currentLoginInfo.setOrganization(organization);
		request.getSession().setAttribute("currentUser", user);
//		request.getSession().setAttribute("currentLoginInfo", currentLoginInfo);
		String parameters = "";

		if (null == request.getQueryString() || request.getQueryString() == "") {
			model.put("errorMessage", "没有参数");
			return "rhip.idm.report.error";
		}

		Map<String, Object[]> map = null;

		//先用UTF-8解析看有没有编码参数
		parameters = Base64Util.decrypt((request.getQueryString()), "UTF-8");
		if (parameters.indexOf("=") == -1) {
			model.put("errorMessage", "没有参数或者参数错误");
			return "rhip.idm.report.error";
		}

		if (ObjectUtil.isNotEmpty(parameters)){
			try{
				map = ConvertToolUtil.convertQueryToMap(parameters);
			}catch (Exception e) {
				logger.error("报卡上报接口,参数解析失败", e);
				model.put("errorMessage", "报卡上报接口,参数解析失败");
				return "rhip.idm.report.error";
			}
		}

		//以下判断按照什么编码原则解析参数
		String charsetName = "";
		charsetName = ConvertToolUtil.getFieldValue(map, "charsetName");
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
				map = ConvertToolUtil.convertQueryToMap(parameters);
			}else if(ObjectUtil.isNotEmpty(parameters) && !charsetName.equalsIgnoreCase("UTF-8")){
				map = ConvertToolUtil.convertQueryToMap(parameters);
			}
		} catch (Exception e) {
			logger.error("报卡上报接口,参数解析失败", e);
			model.put("errorMessage", "报卡上报接口,参数解析失败");
			return "rhip.idm.report.error";
		}

		if (ObjectUtil.isNullOrEmpty(ConvertToolUtil.getFieldValue(map, "name"))) {
			model.put("errorMessage", "参数中必须有患者姓名");
			return "rhip.idm.report.error";
		}

		String diseaseCode = "";
		diseaseCode = ConvertToolUtil.getFieldValue(map, "diagnosisCode");

		// diagnosisCode转成diseaseCode
		map.put("diseaseCode", new Object[] { diseaseCode });

		if (ObjectUtil.isNullOrEmpty(diseaseCode)) {
			model.put("errorMessage", "参数中没有疾病编码或者编码错误");
			return "rhip.idm.report.error";
		}

		//增加无需报卡的icd10判断 ,先根据前三位进行判断,然后是全部
		String parDiseaseCode = diseaseCode.length() >= 3 ? diseaseCode.substring(0, 3) : diseaseCode;
		if (notReportICd10.contains(parDiseaseCode) || (!parDiseaseCode.equals(diseaseCode)&&notReportICd10.contains(diseaseCode))) {
			model.put("errorMessage", "无需报卡");
			return "rhip.idm.report.error";
		}

		// 返回疾病的类别
		IcdType icdType = icdTypeMapping.getType(diseaseCode);
		//传染病：2019/4/9修改为从字典查询是否为已绑定上报疾病
		if(null == icdType){
			icdType = getIdmIcdType(diseaseCode);
		}
		if (null == icdType) {
			model.put("errorMessage", "参数中疾病编码错误");
			return "rhip.idm.report.error";
		}
		String idcard = ConvertToolUtil.getFieldValue(map, "idcard");
		if (ObjectUtil.isNotEmpty(idcard)&&!IDCardUtil.validateCard(idcard)) {
			model.put("errorMessage", "参数中身份证不合法");
			return "rhip.idm.report.error";
		}
        /*diseaseType:传染病的甲乙丙，慢病的5种*/
		map.put("diseaseType", new Object[] { icdType.getType() });

		Long reportRecordId = null;

		String subDisType=icdType.getSubType();

		subDisType=null==subDisType?"":subDisType;

		//是否显示上报按钮，1不显示，0显示
		//request.setAttribute("orgFlag", orgFlag(ConvertToolUtil.getFieldValue(map, "fillOrganCode")));
		request.setAttribute("orgFlag", 0);

		// 是传染病
		if (IcdTypeMapping.ID_CATEGORY.equals(icdType.getCategory())) {

			//201704027  传染病修改为可传报卡页面所有字段（不包含各个传染病单独有的字段）
			//外部上报：市级医院医生，报卡状态1待审核；市级医院传染病，报卡状态为（1待审核 2 已审核）
			String roleType = ConvertToolUtil.getFieldValue(map, "roleType");
			if (ObjectUtil.isNullOrEmpty(roleType)) {
				model.put("errorMessage", "参数中必须有角色类别");
				return "rhip.idm.report.error";
			}
			String approvalType = ConvertToolUtil.getFieldValue(map, "approvalType");
			if (ObjectUtil.isNullOrEmpty(approvalType)) {
				model.put("errorMessage", "参数中必须有审核状态");
				return "rhip.idm.report.error";
			}
			if(ObjectUtil.equals(EHRConstants.IDM_APPROVED_YES, approvalType) && ObjectUtil.equals(EHRConstants.IDM_ROLE_YS, roleType) ){
				model.put("errorMessage", "参数中医生角色上报的报卡状态不可为已审核");
				return "rhip.idm.report.error";
			}
			map.put("diagnosisCode", new Object[] { icdType.getIdmCode()});
			//传染病修改为不查重  2016-12-6
			reportRecordId = reportRecordService.save(setReportRecord(EHRConstants.REPORT_IDM, EHRConstants.IDM_FIRST_NO, parameters, map));
			request.setAttribute("map", map);
			request.setAttribute("reportRecordId", reportRecordId);
			return "forward:/idm/report/report";

			//传染病查重
           /* //如果有身份证，且该人该病一周之内上报过，则不需要再报卡
            boolean returnFlag = true;
            //查该患者是否报过卡（有身份证，是乙肝报卡时才查重）
            if(ObjectUtil.isNotEmpty(idcard) && "2032".equals(getFieldValue(map, "diagnosisCode"))){
            	if(checkReview(request,idcard, "2032")){
                    model.put("errorMessage", "该患者乙肝已经上报过。关闭当前页面即可。");
                    return "rhip.idm.report.error";
                }
            } else if(!ObjectUtil.isNullOrEmpty(idcard)){
                returnFlag = checkReview(idcard, getFieldValue(map, "diagnosisCode"), null,request);
            }
            if(returnFlag){
                reportRecordId = reportRecordService.save(setReportRecord(EHRConstants.REPORT_IDM, EHRConstants.IDM_FIRST_NO, parameters, map));
                request.setAttribute("map", map);
                request.setAttribute("reportRecordId", reportRecordId);
                return "forward:/idm/report/report";
            }else{
                model.put("errorMessage", "此疾病一周之内已经上报过。关闭当前页面即可。");
                return "rhip.idm.report.error";
            }*/
		}
		// 是慢病
		else if (IcdTypeMapping.CD_CATEGORY.equals(icdType.getCategory())) {
			map.put("subDisType", new Object[] {subDisType });
			reportRecordId = reportRecordService.save(setReportRecord(EHRConstants.REPORT_CDM, EHRConstants.DM_REPORTE_NO, parameters, map));
			request.setAttribute("map", map);
			request.setAttribute("subDisType", subDisType);
			request.setAttribute("reportRecordId", reportRecordId);

			return "forward:/cdm/reportcard/hospitalreport";
		}else if (IcdTypeMapping.FD_CATEGORY.equals(icdType.getCategory())) {
			map.put("subDisType", new Object[] {subDisType });
			reportRecordId = reportRecordService.save(setReportRecord(EHRConstants.REPORT_CDM, EHRConstants.DM_REPORTE_NO, parameters, map));
			request.setAttribute("map", map);
			request.setAttribute("subDisType",subDisType);
			request.setAttribute("reportRecordId", reportRecordId);

			return "forward:/fdm/reportCard/report";
		}  else {
			model.put("errorMessage", "既不是传染病也不是慢病");
			return "rhip.idm.report.error";
		}
	
	}

	/**
	 * 生成报卡记录表内容
	 * @param status
	 * @param content
	 * @param map
	 * @return
	 */
	private ReportRecord setReportRecord(int type, int status, String content, Map<String, Object[]> map) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		ReportRecord reportRecord = BeanUtil.getBean(ReportRecord.class, map);

		if(type==EHRConstants.REPORT_IDM){
			reportRecord.setIllnessSecondCode(ConvertToolUtil.getFieldValue(map, "diagnosisCode"));
			reportRecord.setDiagnosisCode(ConvertToolUtil.getFieldValue(map, "diseaseCode"));
		}else if(type==EHRConstants.REPORT_CDM){
			reportRecord.setIllnessSecondCode(ConvertToolUtil.getFieldValue(map, "diseaseType"));
		}

		if(ObjectUtil.NotEmpty(ConvertToolUtil.getFieldValue(map, "birthday"))){
			reportRecord.setBirthday(sdf.parse(ConvertToolUtil.getFieldValue(map, "birthday")));//出生日期
		}
		if(ObjectUtil.NotEmpty(ConvertToolUtil.getFieldValue(map, "pathogenesisDate"))){
			reportRecord.setPathogenesisDate(sdf.parse(ConvertToolUtil.getFieldValue(map, "pathogenesisDate")));//发病日期
		}
		if(ObjectUtil.NotEmpty(ConvertToolUtil.getFieldValue(map, "diagnosisDate"))){
			reportRecord.setDiagnosisDate(sdf.parse(ConvertToolUtil.getFieldValue(map, "diagnosisDate")));//诊断日期
		}
		reportRecord.setType(type);
		reportRecord.setIllnessCode(ConvertToolUtil.getFieldValue(map, "diseaseCode"));
		reportRecord.setContent(content);
		reportRecord.setStatus(status);
		reportRecord.setCreateOrganCode(ConvertToolUtil.getFieldValue(map, "fillOrganCode"));
		reportRecord.setCreateUserCode(ConvertToolUtil.getFieldValue(map, "reportDoctorId"));
		reportRecord.setCreateDate(new Date());
		reportRecord.setIsDelete(0);
		return reportRecord;
	}

	/**
	 * 判断疾病是否存在过报卡(同人同病同机构)
	 * @param idcard  身份证
	 * @param diagnosisCode 疾病编码（字典的）
	 * @param organCode 上报机构code
	 * @return returnFlag  没有true，有flase
	 */
	private boolean checkReview(String idcard, String diagnosisCode, String organCode,HttpServletRequest request){
		Page page = super.getPage(request,  1);
		Criteria ca = new Criteria();
		ca.add("idcard", OP.LIKE, idcard);
		ca.add("infectiousCode", diagnosisCode);
		Date fillEndDate = new Date();
		Date fillBeginDate = DateUtil.add(fillEndDate, Calendar.DATE, -7);
		DateUtil.getCriteriaByDateRange(ca, "fillDate", fillBeginDate,fillEndDate);
		//外部报卡不要机构参数，中心要机构参数
		if(!ObjectUtil.isNullOrEmpty(organCode)){
			ca.add("fillOrganCode", organCode);
		}

		PageList<IdmReport> plist = reportService.findReport(ca, page);

		boolean returnFlag;
		//没有true，有flase
		if(ObjectUtil.isNullOrEmpty(plist) || ObjectUtil.isNullOrEmpty(plist.getList()) || plist.getList().size() <= 0){
			returnFlag =  true;
		}else{
			returnFlag = false;
		}
		return returnFlag;
	}
	/**
	 * 判断疾病是否存在过报卡(同人同病，目前暂时乙肝需要判断)
	 * @param idcard  身份证
	 * @param diagnosisCode 疾病编码（字典的）
	 * @return returnFlag  有true，没有flase
	 */
	private boolean checkReview(HttpServletRequest request,String idcard, String diagnosisCode){
		Page page = super.getPage(request,  1);
		Criteria ca = new Criteria();
		ca.add("idcard", idcard);
		ca.add("infectiousCode", diagnosisCode);
		ca.add("REPORT_STATUS",OP.EQ,ReportStatus.CANCEL.getValue());
		PageList<IdmReport> plist = reportService.findReport(ca, page);

		boolean returnFlag;
		if(ObjectUtil.isNullOrEmpty(plist) || ObjectUtil.isNullOrEmpty(plist.getList()) || plist.getList().size() <= 0){
			returnFlag =  false;
		}else{
			returnFlag = true;
		}
		return returnFlag;
	}

	/**
	 * 20140429
	 * 需求变更：当上报医院是1，2，3，5，中医院的时候，显示上报按钮
	 * 变更处理：刘洋
	 * @param orgCode
	 * @return
	 */
	private String orgFlag(String orgCode) {
		//1表示需要隐藏上报按钮，0表示不需要隐藏上报按钮
		String flag = "1";
		if(orgCodeSet.contains(orgCode)){
			flag = "0";
		}
		return flag;
	}
	/**
	 * 查询该icd疾病对应的字典传染病
	 * @param icd
	 * @return
	 */
	public DicItem getDicItem(String icd) {
		if (ObjectUtil.isNullOrEmpty(icd)) {
			return null;
		}
		int length = icd.length();
		DicItem dicItem = null;
		for (int i = length; i >= 3; i--) {
			if (i == 4) {
				continue;// .的情况去掉
			}
			dicItem = mdmDictionaryService.getDicItem(new Criteria(Dictionary.DIC_CODE, "CV0501017").add("icdCode", OP.LIKE, icd.substring(0, i)).add("status", 1));
			if (null != dicItem) {
				break;
			}
		}
		return dicItem;
	}
	
	public IcdType getIdmIcdType(String diseaseCode){
		List<DicItem> dicItems = dictionaryApp.queryDicItem(new Criteria("dicCode","CV0501017"));
		IcdType icdType = null;
	 	for(DicItem dicItem: dicItems){
		   String idmCode = dicItem.getItemCode(); 
		    if(StringUtil.isNotEmpty(dicItem.getIcdCode())){
		    	String icdCodeStr = dicItem.getIcdCode();
		    	String[] icdCodes = icdCodeStr.substring(0,icdCodeStr.length()-1).split(",");
		    	 for(String icdCode : icdCodes){
					 if(diseaseCode.indexOf(icdCode)==0){//此处不应该是全等，应该是取XX开头
		    			 icdType = new IcdType(diseaseCode, IcdTypeMapping.ID_CATEGORY, "", idmCode);
		    			 return icdType;
		    		 }
		    	 }
		    } 
	 	}
	 	return icdType;
	}
}
