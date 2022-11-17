package com.founder.rhip.cdm.controller.highRisk;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.cdm.controller.CdmBaseController;
import com.founder.rhip.cdm.service.IHighRisk135Service;
import com.founder.rhip.cdm.service.IHighRiskService;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.management.*;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.mdm.entity.Organization;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 高危人群
 * 
 */
@Controller
@RequestMapping("/cdm/highrisk")
public class HighRiskController extends CdmBaseController {

	private final static String CONTROLLER_NAME = "慢病高危人群";

	@Resource
	private IHighRiskService highRiskService;

	@Resource(name = "platformService")
	private IPlatformService platformService;

	@Resource
	private IHighRisk135Service highRisk135Service;

	/**
	 * 管理首页 待管理人员信息
	 * 
	 * @return
	 */
	@RequestMapping("/manageHome")
	public String manageHome() {
		return "rhip.cdm.highRisk.highRiskPersonInfo";
	}

	/**
	 * 管理计划首页
	 * 
	 * @return
	 */
	@RequestMapping("/planHome")
	public String planHome() {
		return "rhip.cdm.highRisk.highRiskManagePlanInfo";
	}

	/**
	 * 随访管理首页
	 * 
	 * @return
	 */
	@RequestMapping("/followUpHome")
	public String followUpManage() {
		return "csws.cdm.highRisk.followUpHome";
	}

	/**
	 * 预防管理
	 * 
	 * @return
	 */
	@RequestMapping("/preventionHome")
	public String preventionHome() {
		return "rhip.cdm.highRisk.preventiveManage";
	}
	@RequestMapping("/saveLcu")
	public @ResponseBody
	String saveLcu(){
		
		return "";	
	}

	/**
	 * 潜在人群列表
	 * 
	 * @return
	 */
	@RequestMapping("/preventiveManage")
	public String searchPreventionManage(HttpServletRequest request, ModelMap model) {
		Criteria criteria = createSearchCriteria(request);
		if (ObjectUtil.isNotEmpty(request.getParameter("idcard"))) {
			PersonInfo personInfo = platformService.queryPersonalInfo(null, request.getParameter("idcard").toUpperCase());
			if (ObjectUtil.isNotEmpty(personInfo)) {
				criteria.remove("idcard");
				criteria.add("personId", personInfo.getId());
			}
		}
		Page page = page(request);
		Organization organization = getCurrentOrg(request);
		if (RoleType.ZMB.equals(getRole(request))) {
			criteria.add("INPUT_ORGAN_CODE", organization.getOrganCode());
		} else if (RoleType.ZXMB.equals(getRole(request))) {
			criteria.add("INPUT_ORGAN_CODE", OP.IN, getStation(organization.getOrganCode()));
		}
		List<DmPotentialPersonInfo> personInfoList = highRiskService.searchPotentialPerson(criteria, page);
		model.addAttribute("personInfo", personInfoList);
		return "rhip.cdm.highRisk.preventiveManageList";
	}

	/**
	 * 慢病预防管理纳入检查是否已纳入、结束管理是否重新纳入管理
	 * 
	 * @return
	 */
	@RequestMapping("/intoManagementCheck")
	public @ResponseBody
	String intoManagementCheck(@RequestParam("personId") Long personId) {
		String status = highRiskService.checkIntoManage(personId);
		if ("operationFails".equals(status)) {// 无personId不能纳入操作失败
			return "operationFails";
		} else if ("intoManageAgain".equals(status)) {// 已结束管理 是否重新纳入挂历
			return "intoManageAgain";
		} else if ("alreadyIntoManage".equals(status)) {// 已纳入
			return "alreadyIntoManage";
		}
		return "intoManageCard";
	}

	/**
	 * 慢病预防管理个人危险因素
	 * 
	 * @return
	 */
	@RequestMapping("/preventionOfManageInfo")
	public String preventionOfManageInfo(@RequestParam("personId") Long personId, ModelMap model) {
		DmPotentialPersonInfo dmPotentialPersonInfo = highRiskService.searchPreventionPersonnelInfo(personId);
		model.addAttribute("dmPotentialPersonInfo", dmPotentialPersonInfo);
		return "rhip.cdm.highRisk.preventionOfManageInfo";
	}

	/**
	 * 高危纳入管理
	 * 
	 * @return
	 */
	@RequestMapping("/intoManage")
	public String intoManage(@RequestParam("personId") Long personId, HttpServletRequest request, ModelMap model) {
		Criteria ca = new Criteria("personId", personId);
		PersonInfo personInfo = platformService.queryPersonalInfo(personId);
		DmHighriskPersonInfo highriskPersonInfo = highRiskService.intoHighRiskGroup(ca, personInfo);
		if(ObjectUtil.isNullOrEmpty(highriskPersonInfo.getDmhighriskRiskFactors())) {
			DmHighriskRiskFactors riskFactorsInfo = new DmHighriskRiskFactors();
			DmPotentialPersonInfo dmPotentialPersonInfo = highRiskService.getPotentialInfo(new Criteria("personId", personId));
			//目前从一期迁移的数据只有这两类[{"id":"1","name": "超重"},{"id":"5","name": "油脂"}]
			if(ObjectUtil.isNotEmpty(dmPotentialPersonInfo.getDfCode())) {
				if(dmPotentialPersonInfo.getDfCode().contains("1")) {//超重
					riskFactorsInfo.setOverweight("1");
				} else if(dmPotentialPersonInfo.getDfCode().contains("5")) {//油脂
					riskFactorsInfo.setFoodGreasyFlag("1");
				}
			} else {
				setRiskFactorsInfo(dmPotentialPersonInfo, riskFactorsInfo);
			}
			highriskPersonInfo.setDmhighriskRiskFactors(riskFactorsInfo);
		}
		setDefaultValues(highriskPersonInfo, request);
		model.addAttribute("personInfo", highriskPersonInfo);
		return "csws.cdm.highRisk.factorsinfo";
	}

	/**
	 *  把根据筛查标准符合的条件赋给危险因素对象
	 * @param dmPotentialPersonInfo
	 * @param riskFactorsInfo
	 */
	private void setRiskFactorsInfo(DmPotentialPersonInfo dmPotentialPersonInfo, DmHighriskRiskFactors riskFactorsInfo) {
		Criteria ca = new Criteria("personId", dmPotentialPersonInfo.getPersonId());
		List<DmPotentialPersonParam> dmpotentialPersonParams = highRiskService.getDmPotentialPersonParams(ca);
		for(DmPotentialPersonParam dmPotentialPersonParam : dmpotentialPersonParams) {
			if(ObjectUtil.equals("CDM0000001", dmPotentialPersonParam.getParameterId())) {//第一类危险因素吸烟

			} else if(ObjectUtil.equals("CDM0000002", dmPotentialPersonParam.getParameterId())) {//第一类危险因素血糖

			} else if(ObjectUtil.equals("CDM0000003", dmPotentialPersonParam.getParameterId())) {//第一类危险因素血脂

			} else if(ObjectUtil.equals("CDM0000004", dmPotentialPersonParam.getParameterId())) {//第一类危险因素腰围(男)
				riskFactorsInfo.setOverweight("1");
				riskFactorsInfo.setWaostline(new BigDecimal(dmPotentialPersonParam.getResultValue()));
			} else if(ObjectUtil.equals("CDM0000005", dmPotentialPersonParam.getParameterId())) {//第一类危险因素腰围(女)
				riskFactorsInfo.setOverweight("1");
				riskFactorsInfo.setWaostline(new BigDecimal(dmPotentialPersonParam.getResultValue()));
			} else if(ObjectUtil.equals("CDM0000014", dmPotentialPersonParam.getParameterId())) {//第一类危险因素收缩压

			} else if(ObjectUtil.equals("CDM0000015", dmPotentialPersonParam.getParameterId())) {//第一类危险因素舒张压

			} else if(ObjectUtil.equals("CDM0000007", dmPotentialPersonParam.getParameterId())) {//第二类危险因素超重
				riskFactorsInfo.setOverweight("1");
				//riskFactorsInfo.setBodyMassIndex();
			} else if(ObjectUtil.equals("CDM0000008", dmPotentialPersonParam.getParameterId())) {//第二类危险因素缺少运动
				riskFactorsInfo.setNoTrain("1");
				riskFactorsInfo.setWeeklyTrain(Integer.valueOf(dmPotentialPersonParam.getResultValue()));
			} else if(ObjectUtil.equals("CDM0000009", dmPotentialPersonParam.getParameterId())) {//第二类危险因素吸烟
				riskFactorsInfo.setCurrSmokingFlag("1");
				riskFactorsInfo.setDailySmoke(new BigDecimal(dmPotentialPersonParam.getResultValue()));
			} else if(ObjectUtil.equals("CDM0000010", dmPotentialPersonParam.getParameterId())) {//第二类危险因素饮酒
				riskFactorsInfo.setLongtermDrinkingFlag("1");
				riskFactorsInfo.setWeeklyDrinnk(Integer.valueOf(dmPotentialPersonParam.getResultValue()));
			} else if(ObjectUtil.equals("CDM0000011", dmPotentialPersonParam.getParameterId())) {//第二类危险因素总胆固醇
				riskFactorsInfo.setFoodGreasyFlag("1");
				riskFactorsInfo.setTc(new BigDecimal(dmPotentialPersonParam.getResultValue()));
			} else if(ObjectUtil.equals("CDM0000012", dmPotentialPersonParam.getParameterId())) {//第二类危险因素甘油三酯
				riskFactorsInfo.setFoodGreasyFlag("1");
				riskFactorsInfo.setTriglycerideValue(new BigDecimal(dmPotentialPersonParam.getResultValue()));
			} else if(ObjectUtil.equals("CDM0000013", dmPotentialPersonParam.getParameterId())) {//第二类危险因素遗传
				riskFactorsInfo.setFamHistoryFlag("1");
			}

		}
	}
	/**
	 * 纳入管理时保存管理卡信息
	 * 
	 * @return
	 */
	@RequestMapping("/saveIntoManage")
	public @ResponseBody
	String saveIntoManage(DmHighriskPersonInfo dmHighriskPersonInfo, HttpServletRequest request) {
		String status = highRiskService.saveIntoManage(dmHighriskPersonInfo, getCurrentOrg(request));
		if (status == "intoManageSuccess") {// 纳入管理
			record(request, OperationName.ADD);
			return "intoManageSuccess";
		} else if (status == "operationFails") {// 纳入时无患者personId不能纳入操作失败
			return "operationFails";
		} else {// 已纳入不能重复纳入
			return "intoManagefailure";
		}
	}

	/**
	 * 生活事件心理应激测试评定量表
	 * @RequestParam("personId") Long personId,@RequestParam("id") Long riskFactorsId,ModelMap model
	 * @return
	 */
	@RequestMapping("/assessment")
	public String assessment() {
//		if(ObjectUtil.isNotEmpty(riskFactorsId) && ObjectUtil.isNotEmpty(personId)){
//			Criteria criteria = new Criteria("personId",personId);
//			criteria.add("id",riskFactorsId);
//			DmHighriskRiskFactors dmHighRiskFactors = highRiskService.getRiskFactorsInfo(criteria);
//			model.addAttribute("dmHighRiskFactors",dmHighRiskFactors);
//		}
		return "csws.cdm.highRisk.assessment";
	}

	/**
	 * 危险因素管理首页
	 * 
	 * @return
	 */
	@RequestMapping("/factorsInfo")
	public String factorsInfoHome(DmHighriskPersonInfo dmHighriskPersonInfo, ModelMap model) {
		Criteria ca = new Criteria("personId", dmHighriskPersonInfo.getPersonId());
		DmHighriskPersonInfo dhrpi = highRiskService.getPerson(ca);
		DmHighriskRiskFactors dhrf = highRiskService.getRiskFactorsInfo(ca);
		if (ObjectUtil.isNotEmpty(dhrf)) {
			dhrpi.setDmhighriskRiskFactors(dhrf);
		}
		model.addAttribute("personInfo", dhrpi);
		// 是否结束管理根据状态跳转到不同页面
		if (ObjectUtil.isNotEmpty(dhrpi.getRiskManageStatus()) && ObjectUtil.equals("1", dhrpi.getRiskManageStatus())) {
			return "csws.cdm.highRisk.canceledFactorsInfo";
		}
		return "csws.cdm.highRisk.factorsinfo";
	}

	/**
	 * 载入管理计划界面
	 * 
	 * @return
	 */
	@RequestMapping("/addManagePlan")
	public String addManagePlan(DmHighriskPersonInfo dmHighriskPersonInfo, ModelMap model) {
		Criteria ca = new Criteria("personId", dmHighriskPersonInfo.getPersonId());
		DmHighriskPersonInfo dhrpi = highRiskService.getPerson(ca);
		model.addAttribute("personInfo", dhrpi);
		return "rhip.cdm.highRisk.addManagePlan";
	}

	/**
	 * 载入制定管理计划列表界面
	 * 
	 * @return
	 */
	@RequestMapping("/managePlanForm")
	public String managePlanForm(DmHighriskManagePlan dmHighriskManagePlan, ModelMap model, HttpServletRequest request) {
		List<DmHighriskManagePlan> dhmpList = highRiskService.getManagePalnList(new Criteria("personId", dmHighriskManagePlan.getPersonId()));
		model.addAttribute("managePlanInfo", dhmpList);
		// //返回危险等级、需建计划数、已建计划数
		// Map<String, Integer> map =
		// highRiskService.messageAlert(dmHighriskManagePlan);
		// model.addAttribute("buildPlan",map.get("manageCount"));
		// model.addAttribute("riskLevel",map.get("riskLevel"));
		// model.addAttribute("currentManagePlan",map.get("currentManageCount"));
		return "rhip.cdm.highRisk.managePlanSearch";
	}

	/**
	 * 载入制定管理计划填写界面
	 * 
	 * @return
	 */
	@RequestMapping("/managePlanResult")
	public String managePlanResult(DmHighriskManagePlan dmHighriskManagePlan, ModelMap model, HttpServletRequest request) {
		if (ObjectUtil.isNotEmpty(dmHighriskManagePlan.getId())) {// 点击管理计划列表时显示此管理计划的详细信息
			// 根据选中的id显示该管理计划的详细信息
			Criteria criteria = new Criteria("id", dmHighriskManagePlan.getId());
			// 返回管理计划详细信息
			DmHighriskManagePlan manageInfo = highRiskService.getManagePlan(criteria);
			model.addAttribute("managePlanDelInfo", manageInfo);
//			model.addAttribute("startYear", String.valueOf(DateUtil.getCurrentYear()));
//			model.addAttribute("endYear", String.valueOf(DateUtil.getCurrentYear() + 2));
//			
			model.addAttribute("startYear", DateUtil.toDateString(new Date(), "yyyy-MM-dd"));
			model.addAttribute("endYear", DateUtil.toDateString(DateUtil.getYearsLater(new Date(), 2), "yyyy-MM-dd"));
			dmHighriskManagePlan.setPersonId(manageInfo.getPersonId());
		} else {// 管理计划页面载入时加载默认的值 如当前用户、当前年份
			//String currentUser = getCurrentUser(request).getName();
			String currentUser = String.valueOf(getCurrentUser(request).getUserCode());
			Map<String, Object> map = highRiskService.loadManageDefaultValues(dmHighriskManagePlan, currentUser);
			dmHighriskManagePlan.setYear(String.valueOf(DateUtil.getCurrentYear()));
			model.addAttribute("startYear", map.get("startYear"));
			model.addAttribute("endYear", map.get("endYear"));
			model.addAttribute("managePlanDelInfo", map.get("managePlanInfo"));
		}
		return "rhip.cdm.highRisk.managePlanResult";
	}

	/**
	 * 载入制定管理计划填写界面
	 *
	 * @return
	 */
	@RequestMapping("/manageResult")
	public String manageResult(String id, ModelMap model, HttpServletRequest request) {
		if (ObjectUtil.isNotEmpty(id)) {// 点击管理计划列表时显示此管理计划的详细信息
			// 根据选中的id显示该管理计划的详细信息
			Criteria criteria = new Criteria("id",id);
			// 返回管理计划详细信息
			DmHighriskManagePlan manageInfo = highRiskService.getManagePlan(criteria);
			model.addAttribute("managePlanDelInfo", manageInfo);
			model.addAttribute("startYear", String.valueOf(DateUtil.getCurrentYear()));
			model.addAttribute("endYear", String.valueOf(DateUtil.getCurrentYear() + 2));
		}
		return "rhip.cdm.highRisk.managePlanResult";
	}


	/**
	 * 载入管理计划制定的阶段
	 * 
	 * @return
	 */
	@RequestMapping("/loadStageMenu")
	public @ResponseBody
	List<String> managePlanStage(DmHighriskManagePlan dmHighriskManagePlan, ModelMap model) {
		List<String> stage = highRiskService.selectMenuStage(dmHighriskManagePlan);
		return stage;
	}

	/**
	 * 保存管理计划信息
	 * 
	 * @return
	 */
	@RequestMapping("/saveManagePlan")
	public @ResponseBody
	String saveManagePlanInfo(HttpServletRequest request, DmHighriskManagePlan dmHighriskManagePlan, ModelMap model) {
		Criteria criteria = new Criteria("personId", dmHighriskManagePlan.getPersonId());
		criteria.add("year", dmHighriskManagePlan.getYear());
		String status = highRiskService.saveManagePlan(dmHighriskManagePlan, criteria);
		if ("changeSuccess".equals(status)) {// 修改成功
			record(request, OperationName.ADD);
			return "chanageSuccess";
		}else if ("buildFollowup".equals(status)) {// 当保存管理计划后 是否立即创建随访记录
			return "buildFollowup";
		}else if ("notExistRiskLevel".equals(status)) {// 该患者无危险等级
			return "notExistRiskLevel";
		}else if("alreadyBuildFollowup".equals(status)){//已制定随访记录  不能修改计划的随访日期
			return "alreadyBuildFollowup";
		}else if("followupRecordUnfinished".equals(status)){//去年随访记录没有制定 不能制定新的管理计划
			return "followupRecordUnfinished";
		}else if("errorFollowupDate".equals(status)){//制定管理计划的随访日期必须大于上次最后一次随访日期
			return "errorFollowupDate";
		}else {// 保存失败
			return "failure";
		}
	}
	/**
	 * 删除管理计划
	 * 
	 * @return
	 */
	@RequestMapping("/removeManagePlan")
	public @ResponseBody
	String removeManagePlan(DmHighriskManagePlan dmHighriskManagePlan, ModelMap model) {
		// 根据personId和gradation判断该管理计划下是否存在随访计划添加状态不能删除
		DmHighriskManagePlan managePlanInfo = highRiskService.getManagePlan(new Criteria("id", dmHighriskManagePlan.getId()));
		Criteria criteria = new Criteria("personId", managePlanInfo.getPersonId());
		criteria.add("gradation", managePlanInfo.getGradation());
		criteria.add("year", managePlanInfo.getYear());
		boolean status = highRiskService.removeManagePlan(dmHighriskManagePlan, criteria);
		return status ? "success" : "failure";
	}

	/**
	 * 保存危险因素管理首页
	 * 
	 * 
	 * @return
	 */
	@RequestMapping("/saveRiskFactors")
	public @ResponseBody
	String saveRiskFactors(HttpServletRequest request, DmHighriskPersonInfo dmHighriskPersonInfo) {
		// 保存危险因素时 可修改该患者危险因素管理卡首页中患者信息指定字段
		boolean status = highRiskService.saveRiskFactors(dmHighriskPersonInfo,getCurrentOrg(request));
		if (status) {
			record(request, OperationName.UPDATE);
		}
		return status ? "success" : "failure";
	}

	/**
	 * 高危人群信息查询
	 *
	 * @return
	 */
	@RequestMapping("/searchHighRiskInfo")
	public String searchHighRiskInfo(HttpServletRequest request, ModelMap model) {
		Criteria criteria = createSearchCriteria(request);
		Page page = page(request);
		Organization organization = getCurrentOrg(request);
		if (RoleType.ZMB.equals(getRole(request))) {
			criteria.add("CREATE_ORGAN_CODE", organization.getOrganCode());
		} else if (RoleType.ZXMB.equals(getRole(request))) {
			Criteria temp = new Criteria("CREATE_CENTER_ORGAN_CODE", organization.getOrganCode());
			temp.add(LOP.OR, "CREATE_ORGAN_CODE", organization.getOrganCode());
			criteria.add(temp);
		}
		PageList<DmHighriskPersonInfo> dhrpi = highRiskService.getPersonList(page, criteria, getCurrentOrg(request), getHrRole(request));
		List<DmHighriskPersonInfo> dhrpiList = dhrpi.getList();
		model.addAttribute("personInfo", dhrpiList);
		model.addAttribute("page", dhrpi.getPage());
		return "rhip.cdm.highRisk.highRiskPersonInfoList";
	}

	/**
	 * 高危人群信息查询
	 *
	 * @return
	 */
	@RequestMapping("/question")
	public String question(HttpServletRequest request, String idcard, Model model) {
		Criteria criteriaQu = new Criteria();
		Criteria criteriaMg = new Criteria();

		if(ObjectUtil.isNotEmpty(idcard)) {
			criteriaQu.add("id_no", idcard);
			criteriaMg.add("IDCARD",idcard);
		}
		if (ObjectUtil.isNotEmpty(idcard)) {
			Dm135Question question = highRisk135Service.getQuestion(criteriaQu);
			model.addAttribute("question", question);
			DmHighriskPersonInfo personInfo = highRiskService.getPerson(criteriaMg);
			Dm135Mgmt dm = new Dm135Mgmt();
			dm.setName(personInfo.getName());
			dm.setIdNo(personInfo.getIdcard());
			model.addAttribute("dm", dm);
			int abc = 1;
			if(ObjectUtil.isNullOrEmpty(question)){
				abc = 2;
			}
			model.addAttribute("personInfo", personInfo);
			model.addAttribute("abc", abc);
			model.addAttribute("type", "2");
		}
		return "rhip.cdm.highRisk135.question.editQuestion";
	}

	/**
	 * 待建\已建管理计划 人员信息
	 * 
	 * @return
	 */
	@RequestMapping("/searchManagePlanInfo")
	public String searchManagePlanInfo(DmHighriskPersonInfo dmHighriskPersonInfo, HttpServletRequest request, ModelMap model) {
		Page page = page(request);
		Date[] ageDateRange = DateUtil.getDateRangeByAge(request.getParameter("beginAge"), request.getParameter("endAge"));
		PageList<DmHighriskPersonInfo> dhrpiList = highRiskService.getManagePlanPersonList(dmHighriskPersonInfo, page, ageDateRange, getCurrentOrg(request), getHrRole(request));
		List<DmHighriskPersonInfo> personInfoList = dhrpiList.getList();
		// 给管理计划中每个患者添加状态 已建管理和待建管理
		for (int i = 0; i < personInfoList.size(); i++) {
			DmHighriskManagePlan dhmp = highRiskService.getManagePlan(new Criteria("personId", personInfoList.get(i).getPersonId()));
			if (ObjectUtil.isNotEmpty(dhmp)) {
				personInfoList.get(i).setManagesStatus("1");// "1":已建管理计划
			} else {
				personInfoList.get(i).setManagesStatus("2");// "2":未建管理计划
			}
		}
		model.addAttribute("personInfo", personInfoList);
		model.addAttribute("page", dhrpiList.getPage());
		return "rhip.cdm.highRisk.highRiskManagePlanList";
	}

	/**
	 * 待建\已建随访计划 人员信息
	 * 
	 * @return
	 */
	@RequestMapping("/searchFollowUpPerson")
	public String searchFollowUpPerson(DmHighriskPersonInfo dmHighriskPersonInfo, HttpServletRequest request, ModelMap model) {
		Page page = page(request);
		Date[] Ages = DateUtil.getDateRangeByAge(request.getParameter("beginAge"), request.getParameter("endAge"));
		PageList<DmHighriskPersonInfo> dhrpiList = highRiskService.getFollowPersonList(dmHighriskPersonInfo, page, Ages, getCurrentOrg(request), getHrRole(request));
		List<DmHighriskPersonInfo> personInfoList = dhrpiList.getList();
		// 给随访管理中每个患者添加状态 已建记录和待建记录
		for (int i = 0; i < personInfoList.size(); i++) {
			DmHighriskFollowup followUpInfo = highRiskService.getFollowup(new Criteria("personId", personInfoList.get(i).getPersonId()));
			if (ObjectUtil.isNotEmpty(followUpInfo)) {
				personInfoList.get(i).setFollowUpStatus("1");// "1":已建随访记录
			} else {
				personInfoList.get(i).setFollowUpStatus("2");// "2":待建随访记录
			}
			DmHighriskConclusion conclusionInfo = highRiskService.getConclusion(new Criteria("personId", personInfoList.get(i).getPersonId()));
			if (ObjectUtil.isNotEmpty(conclusionInfo)) {
				personInfoList.get(i).setConclusionStatus("1");// "1":已建管理评论
			} else {
				personInfoList.get(i).setConclusionStatus("2");// "2":待建管理评论
			}
		}
		// Map<String, Integer> map = highRiskService.getFollowCount();
		model.addAttribute("personInfo", personInfoList);
		model.addAttribute("page", dhrpiList.getPage());
		return "rhip.cdm.highRisk.followUpPersonList";
	}

	/**
	 * 新增随访计划首页
	 * 
	 * @return
	 */
	@RequestMapping("/addFollowUp")
	public String addFollowUp(DmHighriskFollowup dmHighriskFollowup, ModelMap model) {
		Criteria ca = new Criteria("personId", dmHighriskFollowup.getPersonId());
		DmHighriskPersonInfo dhrpi = highRiskService.getPerson(ca);
		model.addAttribute("personIdAndIdcard", dhrpi);
		return "csws.cdm.highRisk.addFollowUp";
	}

	/**
	 * 加载随访计划列表界面
	 * 
	 * @return
	 */
	@RequestMapping("/loadFollowUpPlan")
	public String loadFollowUpPlan(DmHighriskFollowup dmHighriskFollowup, ModelMap model) {
		Criteria ca = new Criteria("personId", dmHighriskFollowup.getPersonId());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		List<DmHighriskFollowup> followUpInfoList = highRiskService.getFollowupPlanList(ca);
		model.addAttribute("followUpPlanInfo", followUpInfoList);
		if (ObjectUtil.isNotEmpty(dmHighriskFollowup.getYear())) {
			ca.add("planYear", dmHighriskFollowup.getYear());
			try {
				Date searchYear = sdf.parse(dmHighriskFollowup.getYear());
				model.addAttribute("searchYear", searchYear);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		List<DMFollowupPlan> list = highRiskService.searchDmFollowupPlan(ca, new Order("PLAN_DATE"));
		// Criteria ca = new
		// Criteria("personId",dmHighriskFollowup.getPersonId());
		// List<DmHighriskFollowup>followUpInfoList =
		// highRiskService.getFollowupPlanList(ca);
		// model.addAttribute("followUpPlanInfo", followUpInfoList);
		model.addAttribute("followUpPlanInfo", list);
		model.addAttribute("aMonthLater", DateUtil.makeTimeToMax(DateUtil.add(new Date(), Calendar.MONTH, 1)));
		model.addAttribute("aMonthBefore", DateUtil.makeTimeToZero(DateUtil.add(new Date(), Calendar.MONTH, -1)));
		return "rhip.cdm.highRisk.loadFollowUpPlan";
	}

	/**
	 * 加载随访计划填写界面
	 * 
	 * @return
	 */
	@RequestMapping("/loadFollowUpPlanResult")
	public String loadFollowUpPlanResult(DMFollowupPlan dmFollowupPlan, ModelMap model, HttpServletRequest request) {
		Criteria criteria = new Criteria("id", dmFollowupPlan.getId());
		DMFollowupPlan dmFollowupPlanInfo = highRiskService.searchDmFollowupPlanInfo(criteria);
		if (ObjectUtil.isNotEmpty(dmFollowupPlanInfo.getFollowupId())) {
			DmHighriskFollowup dmHighriskFollowup = highRiskService.getFollowup(new Criteria("id", dmFollowupPlanInfo.getFollowupId()));
			if(ObjectUtil.isNotEmpty(dmHighriskFollowup)) {
				dmHighriskFollowup.setDmFollowupPlan(dmFollowupPlan);
			}
			model.addAttribute("followUpPlanInfo", dmHighriskFollowup);
		} else {
			DmHighriskFollowup followup = new DmHighriskFollowup();
			followup.setDmFollowupPlan(dmFollowupPlan);
			//String currentUser = getCurrentUser(request).getName();
			String currentUser = String.valueOf(getCurrentUser(request).getUserCode());
			followup.setVisitCode(currentUser);
			followup.setVisitDate(new Date());
			model.addAttribute("followUpPlanInfo", followup);
		}
		// if(dmHighriskFollowup.getId() != null){//点击随访列表时显示此随访记录详情
		// loadFollowUpPlanList(dmHighriskFollowup,model,request);
		// }else{//随访记录页面加载时默认显示的信息
		// loadFollowUpPlanForm(dmHighriskFollowup,model,request);
		// }
		return "rhip.cdm.highRisk.loadFollowUpPlanResult";
	}

	/**
	 * 随访记录制定时 载入制定年度的管理计划
	 * 
	 * @return
	 */
	@RequestMapping("/loadManagePlan")
	public @ResponseBody
	List<String> loadManageStage(DmHighriskFollowup dmHighriskFollowup, ModelMap model) {
		List<String> status = highRiskService.chooseManageStage(dmHighriskFollowup);
		return status;
	}

	/**
	 * 保存随访记录填写的信息
	 * 
	 * @return
	 */
	@RequestMapping("/saveFollowUpPlan")
	public @ResponseBody
	String saveFollowUpPlan(HttpServletRequest request, DmHighriskFollowup dmHighriskFollowup, ModelMap model) {
		String status = highRiskService.saveFollowupPlan(dmHighriskFollowup);
		if ("success".equals(status)) {
			record(request, OperationName.ADD);
			return "success";
		} else if ("operateFailure".equals(status)) {
			return "operateFailure";
		} else {
			return "failure";
		}
	}

	/**
	 * 删除随访计划
	 * 
	 * @return
	 */
	@RequestMapping("/removeFollowUpPlan")
	public String removeFollowUpPlan(DmHighriskFollowup dmHighriskFollowup, ModelMap model) {
		Criteria ca = new Criteria("id", dmHighriskFollowup.getId());
		highRiskService.removeFollowUpPlan(ca);
		List<DmHighriskFollowup> followUpPlanList = highRiskService.getFollowupPlanList(new Criteria("personId", dmHighriskFollowup.getPersonId()));
		model.addAttribute("followUpPlanInfo", followUpPlanList);
		return "rhip.cdm.highRisk.loadFollowUpPlan";
	}

	/**
	 * 加载随访计划管理评价列表界面
	 * 
	 * @return
	 */
	@RequestMapping("/loadFollowConclusion")
	public String loadFollowConclusion(DmHighriskConclusion dmHighriskConclusion, ModelMap model) {
		Criteria ca = new Criteria("personId", dmHighriskConclusion.getPersonId());
		List<DmHighriskConclusion> ConclusionInfo = highRiskService.getConclusionList(ca);
		model.addAttribute("ConclusionInfo", ConclusionInfo);
		return "rhip.cdm.highRisk.loadFollowConclusion";
	}

	/**
	 * 加载随访计划管理评价填写界面
	 * 
	 * @return
	 */
	@RequestMapping("/loadFollowUpConclusionResult")
	public String loadFollowUpConclusionResult(DmHighriskConclusion dmHighriskConclusion, ModelMap model, HttpServletRequest request) {
		if (null != dmHighriskConclusion.getId()){
			Criteria ca = new Criteria("id", dmHighriskConclusion.getId());
			DmHighriskConclusion conclusionInfo = highRiskService.getConclusion(ca);
			dmHighriskConclusion.setPersonId(conclusionInfo.getPersonId());
		}
		String currentUser = String.valueOf(getCurrentUser(request).getUserCode());
		Map<String, Object> map=highRiskService.defaultConclusionValue(dmHighriskConclusion,currentUser);
		if (null != dmHighriskConclusion.getId()) {// 选中某一管理评价显示此评价的详细信息
			Criteria ca = new Criteria("id", dmHighriskConclusion.getId());
			DmHighriskConclusion conclusionInfo = highRiskService.getConclusion(ca);
			DmHighriskRiskFactors factorsInfo = highRiskService.getRiskFactorsInfo(new Criteria("id", conclusionInfo.getFactorId()));
			model.addAttribute("conclusionInfo", conclusionInfo);
			model.addAttribute("factorsInfo", factorsInfo);
		} else {// 管理评价界面载入时默认显示当前日期和制定人
			model.addAttribute("conclusionInfo",map.get("conclusion"));
		}
//		model.addAttribute("thisYear", map.get("thisYear"));
//		model.addAttribute("nextYear", map.get("nextYear"));
//		model.addAttribute("yearAfter",map.get("yearAfter"));
		model.addAttribute("yearList",map.get("yearString"));
		return "rhip.cdm.highRisk.loadFollowUpConclusionResult";
	}
	/**
	 * 保存随访计划管理评论填写的信息
	 * 
	 * @return
	 */
	@RequestMapping("/saveConclusion")
	public @ResponseBody
	String saveConclusion(HttpServletRequest request, DmHighriskRiskFactors dmHighriskRiskFactors, DmHighriskConclusion dmHighriskConclusion, ModelMap model) {
		String status = highRiskService.saveFollowupConclusion(dmHighriskRiskFactors, dmHighriskConclusion);
		if ("success".equals(status)) {
			// 如果状态为"1"则继续管理，状态为"2"结束管理
			if ("1".equals(dmHighriskConclusion.getContinueManageFlag())) {
				return "buildManagePlan";// 制定来年管理计划
			} else {
				record(request, OperationName.UPDATE);
				return "success";
			}
		} else if ("forbidBuild".equals(status)) {
			return "forbidBuild";// 该年度随访记录没有制定完成
		} else {
			return "failure";// 该年度管理计划已制定完成
		}
	}

	/**
	 * 删除管理评论
	 * 
	 * @return
	 */
	@RequestMapping("/removeConclusionPlan")
	public String removeConclusionPlan(DmHighriskConclusion dmHighriskConclusion, ModelMap model) {
		Criteria ca = new Criteria("id", dmHighriskConclusion.getId());
		// 删除管理评价
		highRiskService.removeConclusionPlan(ca);
		// 删除危险因素
		if (ObjectUtil.isNotEmpty(dmHighriskConclusion.getFactorId())) {
			highRiskService.removeRiskFactor(new Criteria("id", dmHighriskConclusion.getFactorId()));
		}
		List<DmHighriskConclusion> ConclusionList = highRiskService.getConclusionList(new Criteria("personId", dmHighriskConclusion.getPersonId()));
		model.addAttribute("ConclusionInfo", ConclusionList);
		return "rhip.cdm.highRisk.loadFollowConclusion";
	}

	/**
	 * 内部方法:创建查询条件对象
	 * 
	 * @return
	 */
	private Criteria createSearchCriteria(HttpServletRequest request) {
		Criteria criteria = new Criteria();
		// 姓名
		if (StringUtils.isNotEmpty(request.getParameter("name")))
			criteria.add("name", OP.LIKE, request.getParameter("name"));
		// 身份证
		if (StringUtils.isNotEmpty(request.getParameter("idcard")))
			criteria.add("idcard", request.getParameter("idcard").toUpperCase());
		// 性别
		if (StringUtils.isNotEmpty(request.getParameter("gender"))) {
			int genderCode = Integer.parseInt(request.getParameter("gender"));
			if (genderCode != -1)
				criteria.add("gender", request.getParameter("gender"));
		}
		// 年龄段
		Date[] ageDateRange = DateUtil.getDateRangeByAge(request.getParameter("beginAge"), request.getParameter("endAge"));
		if (ageDateRange != null) {
			if (ageDateRange[0] != null && ageDateRange[1] != null) {
				criteria.add("birthday", OP.BETWEEN, new Object[] { ageDateRange[0], ageDateRange[1] });
			} else if (ageDateRange[0] != null) {
				criteria.add("birthday", OP.GE, ageDateRange[0]);
			} else if (ageDateRange[1] != null) {
				criteria.add("birthday", OP.LE, ageDateRange[1]);
			}
		}
		// 危险等级
		if (StringUtils.isNotEmpty(request.getParameter("searchRiskLevel")))
			criteria.add("riskLevel", request.getParameter("searchRiskLevel"));
		return criteria;
	}

	/**
	 * 高危纳入管理填写管理卡时加载默认值
	 * 
	 * @return
	 */
	private DmHighriskPersonInfo setDefaultValues(DmHighriskPersonInfo highriskPersonInfo, HttpServletRequest request) {
		Organization organization = getCurrentOrg(request);
		User user = getCurrentUser(request);
		highriskPersonInfo.setCreateDoctorCode(user.getUserCode());
		highriskPersonInfo.setCreateDoctorName(user.getName());
		highriskPersonInfo.setCreateOrganCode(organization.getOrganCode());
		highriskPersonInfo.setCreateOrganName(organization.getOrganName());
		highriskPersonInfo.setCreateDate(new Date());
		return highriskPersonInfo;
	}

	/**
	 * 分页查询条件
	 * 
	 * @return
	 */
	private Page page(HttpServletRequest request) {
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		request.setAttribute("page", page);
		return page;
	}

	private RoleType getHrRole(HttpServletRequest request) {
		RoleType role = null;
		if (hasRole(RoleType.ZXMB, request)) {
			role = RoleType.ZXMB;
		} else if (hasRole(RoleType.YYMB, request)) {
			role = RoleType.YYMB;
		}else if (hasRole(RoleType.JKMBK, request)) {
			role = RoleType.JKMBK;
		} else if (hasRole(RoleType.ZMB, request)) {
			role = RoleType.ZMB;
		} else if (hasRole(RoleType.ADMIN, request)) {
			role = RoleType.ADMIN;
		}
		Assert.notNull(role, "没有权限,请更换用户登录");
		return role;
	}

	@Override
	protected String getActionName() {
		return CONTROLLER_NAME;
	}

	// private void loadFollowUpPlanForm(DmHighriskFollowup dmHighriskFollowup ,
	// ModelMap model ,HttpServletRequest request){
	// //默认显示当前年度和制定人
	// DmHighriskFollowup followup = new DmHighriskFollowup();
	// String currentUser = getCurrentUser(request).getName();
	// followup.setVisitName(currentUser);
	// followup.setYear(String.valueOf(DateUtil.getCurrentYear()));
	// followup.setVisitDate(new Date());
	// model.addAttribute("followUpPlanInfo",followup);
	// dmHighriskFollowup.setYear(String.valueOf(DateUtil.getCurrentYear()));
	// List<String> stage=highRiskService.chooseManageStage(dmHighriskFollowup);
	// model.addAttribute("stage",stage);
	// }
	// private void loadFollowUpPlanList(DmHighriskFollowup dmHighriskFollowup ,
	// ModelMap model ,HttpServletRequest request){
	// //点击列表显示详细信息
	// Criteria ca = new Criteria("id",dmHighriskFollowup.getId());
	// DmHighriskFollowup followUpInfo = highRiskService.getFollowup(ca);
	// dmHighriskFollowup.setPersonId(followUpInfo.getPersonId());
	// List<String> stage=highRiskService.chooseManageStage(dmHighriskFollowup);
	// stage.add(followUpInfo.getGradation().toString());
	// Collections.sort(stage);
	// model.addAttribute("stage",stage);
	// model.addAttribute("followUpPlanInfo",followUpInfo);
	// }

}