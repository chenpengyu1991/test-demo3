package com.founder.rhip.ism.controller.reportcard;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.founder.rhip.ehr.common.EHRConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Record;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.cdm.common.ApprovalState;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.ism.ApprovalInfo;
import com.founder.rhip.ehr.entity.ism.ReportInfo;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.ism.controller.IsmBaseController;
import com.founder.rhip.ism.service.IReportCardService;
import com.founder.rhip.mdm.entity.Organization;

/**
 * 伤害监测报卡
 * 
 * @author liuk
 * 
 */
@Controller
@RequestMapping("/ism/reportCard")
public class IsmReportCardController extends IsmBaseController {

	private final static String CONTROLLER_NAME = "伤害监测报卡";

	@Resource(name = "isReportCardService")
	private IReportCardService reportCardService;

	@Resource(name = "platformService")
	private IPlatformService platformService;

	public static final String REPORT_INPUT="1";

	public static final String REPORT_VIEW="2";

	public static final String REPORT_APP="3";

	public static final String REPORT_REPEAT="4";


	/**
	 * 伤害监测add界面
	 * @return
	 */
	@RequestMapping("/report")
	public String report(ModelMap model, HttpServletRequest request) {
		ReportInfo reportInfo = new ReportInfo();
		setReportInputInfo(true, reportInfo, request);
		model.addAttribute("reportInfo", reportInfo);
		model.addAttribute("reportFlag",REPORT_INPUT);
		return "rhip.ism.base.reportCard.add";
	}



	/**
	 * 伤害监测报卡查看页面列表
	 *
	 * @return
	 */
	@RequestMapping(value = "/viewList")
	public String viewListSearch(HttpServletRequest request, ModelMap model) {
		model.addAttribute("reportFlag",REPORT_VIEW);
		return "rhip.ism.base.reportCard.view";
	}

	/**
	 * 伤害监测报卡审核页面列表
	 *
	 * @return
	 */
	@RequestMapping(value = "/verifyList")
	public String verifyListSearch(HttpServletRequest request, ModelMap model) {
		model.addAttribute("reportFlag",REPORT_APP);
		return "rhip.ism.base.reportCard.verify";
	}

	/**
	 * 伤害监测报卡审核，查看页面返回的list数据
	 *
	 * @return
	 */
	@RequestMapping("/list")
	public String getReportsGroupByPerson(QueryForm queryForm, @RequestParam(value = "flag") String flag,HttpServletRequest request, ModelMap model) {
		Page pg = buildPage(request);
		Criteria criteria = queryForm.toCriteria();
        criteria.add("IS_DELETE", EHRConstants.DELETE_FLG_0);
		RoleType roleType = getRole(request);
		buildViewParam(criteria, roleType, getCurrentOrg(request),flag);
		PageList<ReportInfo> reportes =reportCardService.getReportsInfo(pg, criteria);
		model.addAttribute("reportInfoList", reportes.getList());
		if(flag.equals(REPORT_VIEW))
			model.addAttribute("reportFlag",REPORT_VIEW);
		if(flag.equals(REPORT_APP))
			model.addAttribute("reportFlag",REPORT_APP);
		return "rhip.ism.base.reportCard.viewList";
	}


	/**
	 * 新增上报
	 *
	 * @param ismReportInfo
	 * @param request
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Object save(ReportInfo ismReportInfo, HttpServletRequest request) {
		RoleType roleType = getRole(request);
		setReportInputInfo(true, ismReportInfo, request);
		if (reportCardService.saveReportCard(ismReportInfo, roleType, getCurrentUser(request), getCurrentOrg(request))) {
			record(request,OperationName.ADD);
			return "success";
		}
		return "error";
	}


	/**

	 * 获取输入人员信息和可报卡信息
	 *
	 * @param idCard
	 * @param name
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/load")
	public @ResponseBody
	Object load(@RequestParam(value = "personInfo.name", required = false) String name, @RequestParam("personInfo.idcard") String idCard, ModelMap model, HttpServletRequest request) {
		PersonInfo personInfo = platformService.queryPersonalInfo(null, idCard);
		if (ObjectUtil.isNullOrEmpty(personInfo)) {
			return null;
		}
		Map<String, Object> record = new Record(personInfo);
		Date birthday = setBirthday(personInfo);
		if (ObjectUtil.isNotEmpty(birthday)) {
			record.put("age", DateUtil.getAgeByBirthday(birthday));
		}
		return record;
	}

	@RequestMapping("/view/{id}")
	public String view(@PathVariable("id") Long id, ModelMap model, HttpServletRequest request) {
		return appAndView(id,model,request,REPORT_VIEW);
	}

	/**
	 * 根据人员Id查看报卡
	 *
	 * @param personId
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/app/{id}")
	public String app(@PathVariable("id") Long id, ModelMap model, HttpServletRequest request) {
		return appAndView(id,model,request,REPORT_APP);
	}

	private String appAndView(@PathVariable("id") Long id, ModelMap model, HttpServletRequest request,String type){
		PageList<ReportInfo> reportes = reportCardService.getReportsInfo(buildPage(request), new Criteria("ID",id));
		List<ApprovalInfo> approvalInfoList = reportCardService.getAppDetailsList(new Criteria("reportId",id));
		ApprovalInfo approvalInfo = null;
		if(!ObjectUtil.isNullOrEmpty(approvalInfoList)){
			approvalInfo=approvalInfoList.get(0);
			reportes.getList().get(0).setComments(approvalInfo.getComments());
		}
		model.addAttribute("reportInfo", reportes.getList().get(0));
		if(type.equals(REPORT_APP)){
			model.addAttribute("reportFlag",REPORT_APP);
			return "rhip.ism.base.reportCard.appReport";
		}else if(type.equals(REPORT_VIEW)){
			model.addAttribute("reportFlag",REPORT_VIEW);
			return "rhip.ism.base.reportCard.viewReport";
		}
		 return null;
	}

	/**
	 * 审核
	 *
	 * @param personId
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateApp")
	public @ResponseBody String updateApp(@RequestParam("operateFlag") int i,ReportInfo ismReportInfo,ModelMap model, HttpServletRequest request) {
			RoleType roleType = getRole(request);
			setReportInputInfo(false,ismReportInfo,request);
		  String returnStatus = reportCardService.appReportCard(ismReportInfo, roleType, getCurrentUser(request), getCurrentOrg(request),i,buildApprovalInfoAndInsert(ismReportInfo,request));
		  record(request,OperationName.UPDATE);
		  return returnStatus;
	}

	/**
	 * 设置查看的权限
	 *
	 * @param criteria
	 * @param viewType
	 * @param roleType
	 * @param organization
	 */
	private void buildViewParam(Criteria criteria, RoleType roleType, Organization organization,String flag) {
			Criteria criteriaOr=new Criteria() ;
			if(!flag.equals(REPORT_VIEW)){
				if (roleType.equals(RoleType.ZX_GLY)) {
					 criteriaOr = new Criteria("CREATE_ORGAN_CODE", organization.getOrganCode());
					/** 对应上报机构 */
					criteriaOr.add(LOP.AND, "status",OP.IN, new String[]{ApprovalState.REJECT.getValue(),ApprovalState.READY.getValue()});
				}else if(roleType.equals(RoleType.JKMBK)){
					criteriaOr.add(LOP.AND,"status", ApprovalState.VERIFIED_FIRST.getValue());
				}
				criteria.add(criteriaOr);
			}else{
				if (roleType.equals(RoleType.ZX_GLY)) {
					 criteriaOr = new Criteria("CREATE_ORGAN_CODE", organization.getOrganCode());
					criteria.add(criteriaOr);
				}
			}
	}

//	/**
//	 * 审核报卡
//	 *
//	 * @param report
//	 * @param model
//	 * @param request
//	 * @return
//	 */
//	@RequestMapping("/app")
//	public String app(ReportInfo reportInfo, ModelMap model, HttpServletRequest request) {
//		RoleType roleType = getRole(request);
//		User user = getCurrentUser(request);
//		setReportInputInfo(false,reportInfo,request);
//		reportCardService.appReportCard(reportInfo, roleType, user, getCurrentOrg(request),0);
//		record(request,OperationName.UPDATE);
//		return "rhip.ism.base.reportCard.viewReport";
//	}

	private ApprovalInfo buildApprovalInfoAndInsert(ReportInfo reportInfo, HttpServletRequest request) {
		Organization organization = getCurrentOrg(request);
		User user = getCurrentUser(request);
		Assert.notNull(organization, "非法登录");
		Assert.notNull(user, "非法登录");
		ApprovalInfo approvalInfo = new ApprovalInfo();
		approvalInfo.setApprovalDate(reportInfo.getCreateDate());
		approvalInfo.setOrgCode(organization.getOrganCode());
		approvalInfo.setOrgName(organization.getOrganName());
		approvalInfo.setReportId(reportInfo.getId());
		approvalInfo.setStatus(reportInfo.getStatus());
		approvalInfo.setUserId(user.getId() + "");
		approvalInfo.setUserName(user.getName());
		approvalInfo.setComments(reportInfo.getComments());
		return approvalInfo;
	}



	/**
	 * 设置报卡输入更新信息
	 *
	 * @param input
	 * @param ismReportInfo
	 * @param request
	 */
	private void setReportInputInfo(boolean input,ReportInfo ismReportInfo, HttpServletRequest request) {
		Organization organization = getCurrentOrg(request);
		User user = getCurrentUser(request);
		Assert.notNull(organization, "非法登录");
		Assert.notNull(user, "非法登录");
		if (input) {
			ismReportInfo.setCreateOrganCode(organization.getOrganCode());
			ismReportInfo.setCreateOrganName(organization.getOrganName());
			ismReportInfo.setCreateDoctorCode(user.getId() + "");
			ismReportInfo.setCreateDoctorName(user.getName());
			ismReportInfo.setCreateDate(ismReportInfo.getCreateDate()!=null?ismReportInfo.getCreateDate():new Date());
			ismReportInfo.setHospitalCode(organization.getOrganCode());
		} else {
			ismReportInfo.setUpdateOrganCode(organization.getOrganCode());
			ismReportInfo.setUpdateOrganName(organization.getOrganName());
			ismReportInfo.setUpdateDoctorCode(user.getId() + "");
			ismReportInfo.setUpdateDoctorName(user.getName());
			ismReportInfo.setUpdateDate(new Date());
		}

	}

	@RequestMapping("/repeatCard")
	public String repeatCardList() {
		return "rhip.ism.base.reportCard.repeat";
	}

	@RequestMapping("/repeatReportCardList")
	public String repeatReportCardList(RepeatForm form, HttpServletRequest request, ModelMap model) {
		Criteria criteria = form.toCriteria();
        criteria.add("IS_DELETE", EHRConstants.DELETE_FLG_0);
		PageList<ReportInfo> list = reportCardService.getRepeatCardList(buildPage(request), criteria, form.getRepeatConditions());
		if (null!=list){
            model.addAttribute("dmRepeatCardInfoList", list.getList());
        }
		return "rhip.ism.base.reportCard.repeatResult";
	}

	@RequestMapping("/del/{id}")
	@ResponseBody
	public String delRepeatCard(@PathVariable("id") Long id, ModelMap model, HttpServletRequest request) {
        try {
            reportCardService.deleteReport(id);
            record(request,OperationName.UPDATE);
        }catch (Exception e){
            return "error";
        }
        return "success";
	}

	@RequestMapping("/appDetails")
	public String appDetailsList(@RequestParam("id") Long id,HttpServletRequest request, ModelMap model) {
		List<ApprovalInfo> list = reportCardService.getAppDetailsList(new Criteria("reportId", id));
		model.addAttribute("appDetailsList",list);
		return "rhip.ism.base.approval.list";
	}

	@RequestMapping("/repeatList")
	public String repeatList() {
		return "rhip.ism.base.reportCard.repeatResult";
	}

	@Override
	protected String getActionName() {
		return CONTROLLER_NAME;
	}
}
