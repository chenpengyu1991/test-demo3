package com.founder.rhip.oh.controller;

import com.founder.elb.entity.Role;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.*;
import com.founder.rhip.ehr.dto.SelectDTO;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.control.OccupationDiseaseReport;
import com.founder.rhip.ehr.entity.control.oh.OhCompanyInfo;
import com.founder.rhip.ehr.entity.control.oh.OhEmployeeInfo;
import com.founder.rhip.ehr.entity.control.oh.OhEnterpriseInfo;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.mdm.app.IDiseaseApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Disease;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.oh.controller.form.OccPatientForm;
import com.founder.rhip.ph.service.oh.IEnterpriseDocService;
import com.founder.rhip.ph.service.oh.IOccPatientService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author mei_xingjian OccPatient controller
 */
@Controller
@RequestMapping("/oh/occPatient")
public class OccPatientController extends BaseController {

	@Resource(name = "ohOccPatientService")
	private IOccPatientService occPatientService;

	@Resource(name = "ohEnterpriseDocService")
	private IEnterpriseDocService enterpriseDocService;
	
	@Resource(name = "diseaseApp")
	private IDiseaseApp diseaseApp;
	
	@Resource(name = "platformService")
	private IPlatformService platformService;

	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;

	@InitBinder
	@Override
	public void initBinder(WebDataBinder binder) {
		 binder.registerCustomEditor(Date.class,"createTime", new CustomDateEditor(new SimpleDateFormat(EHRConstants.SPEC_DATE_PATTERN), true));
		 binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(EHRConstants.COMMON_DATE_PATTERN), true));
	 }
	 
	@RequestMapping("/index")
	public String occPatientHome(HttpServletRequest request, Model model) {
		return "rhip.oh.occPatient.search";
	}

	@RequestMapping(value = "/employeeInfolist")
	public String searchEmployeeInfoList(OccPatientForm form,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.oh.occPatient.list";
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = null;
		ca = form.getCriteria();
        if(hasRole(RoleType.ZX_GLY, request)||hasRole(RoleType.ZXZYB, request)||hasRole(RoleType.YYZYB, request)){
            ca.add("CREATE_ORGAN_CODE",getCurrentOrg(request).getOrganCode());
        }
		PageList<OhEmployeeInfo> plist = occPatientService
				.searchEmployeeInfoList(ca, page);
		model.addAttribute("employeeInfoList", plist);
		model.addAttribute("page", plist.getPage());
		return url;
	}

	@RequestMapping("/delEmployee")
	@ResponseBody
	public ModelMap delEmployee(Long id, HttpServletRequest request) {
		OhEmployeeInfo employee = new OhEmployeeInfo();
		employee.setUpdateBy(getCurrentUser(request).getUserName());
		employee.setUpdateTime(new Date());
		employee.setIsDelete(OHConstants.delete_1);
		employee.setId(id);
		Boolean rs = occPatientService.saveEmployeeInfo(employee, OHConstants.del, getCurrentUser(request), getCurrentOrg(request));
		ModelMap model = new ModelMap();
		if (rs) {
			model.addAttribute("result", true);
			model.addAttribute("message", "删除成功！");
			createOperationLog(request,  RhipModuleName.OH, "职业病病人档案-档案删除", OperationName.DELETE);
		} else {
			model.addAttribute("result", false);
			model.addAttribute("message", "删除失败！");
		}
		return model;
	}

	@RequestMapping(value = "/initAddView")
	public String initAdd(HttpServletRequest request, ModelMap model) {
		String url = "rhip.oh.occPatient.add";
		model.put("type", OHConstants.add);
		return url;
	}

	@RequestMapping(value = "/initEmployeeModify/{employeeId}")
	public String initEmployeeModify(
			@PathVariable("employeeId") Long employeeId, String operatorType,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.oh.occPatient.add";
		Criteria criteria = new Criteria();
		criteria.add("id", employeeId);
		OhEmployeeInfo employeeInfo = occPatientService
				.searchEmployeeInfo(criteria);
		model.addAttribute("employeeInfo", employeeInfo);
		model.put("type", operatorType != null ? operatorType
				: OHConstants.edit);
		return url;
	}

	@RequestMapping(value = "/saveEmployeeInfo")
	public String saveEmployeeInfo(OhEmployeeInfo employeeInfo, String type,
                                   HttpServletRequest request, ModelMap model) {
		String url = "rhip.oh.occPatient.employeeInfo";
		if (OHConstants.add.equals(type)){
			employeeInfo.setCreateBy(getCurrentUser(request).getUserName());
			employeeInfo.setCreateTime(new Date());
	        employeeInfo.setCreateOrganCode(getCurrentOrg(request).getOrganCode());
	        employeeInfo.setUpdateOrganCode(getCurrentOrg(request).getOrganCode());
	        employeeInfo.setCreateSuperOrganCode(getCurrentOrg(request).getParentCode());
		}else {
			OhEmployeeInfo temp = occPatientService.searchEmployeeInfo(new Criteria("ID",employeeInfo.getId()));
			employeeInfo.setCreateSuperOrganCode(temp.getCreateSuperOrganCode());
		}
		employeeInfo.setGbcode(getCurrentOrg(request).getGbCode());
		verifyStateSet(employeeInfo,request);
		employeeInfo.setUpdateBy(getCurrentUser(request).getUserName());
		employeeInfo.setUpdateTime(new Date());
        employeeInfo.setUpdateOrganCode(getCurrentOrg(request).getOrganCode());
		Boolean rs = occPatientService.saveEmployeeInfo(employeeInfo, type, getCurrentUser(request), getCurrentOrg(request));
		if(rs){
			//日记记录
			if(OHConstants.edit.equals(type)){
				createOperationLog(request,  RhipModuleName.OH, "职业病病人档案-修改劳动者信息", OperationName.UPDATE);
			}else if(OHConstants.add.equals(type)){
				createOperationLog(request,  RhipModuleName.OH, "职业病病人档案-新增劳动者信息", OperationName.ADD);
			}	
		}
		model.put("msg", rs);
		model.put("type", OHConstants.edit);
		model.put("employeeInfo", employeeInfo);
		return url;
	}

	@RequestMapping(value = "/initCompanyModify/{employeeId}")
	public String initCompanyModify(
			@PathVariable("employeeId") Long employeeId, String type,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.oh.occPatient.companyInfo";
		Criteria criteria = new Criteria();
		criteria.add("employeeId", employeeId);
		OhCompanyInfo companyInfo = occPatientService
				.searchCompanyInfo(criteria);
		model.addAttribute("companyInfo", companyInfo);
		model.put("companyOptType",
				OHConstants.view.equals(type) ? OHConstants.view
						: companyInfo != null ? OHConstants.edit
								: OHConstants.add);
		return url;
	}

	@RequestMapping(value = "/saveCompanyInfo")
	public String saveCompanyInfo(OhCompanyInfo companyInfo, String type,
                                  HttpServletRequest request, ModelMap model) {
		String url = "rhip.oh.occPatient.companyInfo";
		OhEmployeeInfo employeeInfo=new OhEmployeeInfo();
		employeeInfo.setId(companyInfo.getEmployeeId());
		employeeInfo.setUpdateBy(getCurrentUser(request).getUserName());
		Date now = new Date();
		employeeInfo.setUpdateTime(now);
		this.verifyStateSet(employeeInfo, request);
		
		if (OHConstants.add.equals(type)){
		companyInfo.setCreateBy(getCurrentUser(request).getUserName());
		companyInfo.setCreateTime(now);
		}
		companyInfo.setUpdateBy(getCurrentUser(request).getUserName());
		companyInfo.setUpdateTime(now);
		Boolean rs = occPatientService.saveCompanyInfo(companyInfo, type);
		if(rs){
			if(employeeInfo.getVerifyState()!=null){
				occPatientService.resetVerifyState(employeeInfo);
			}
			//日记记录
			if(OHConstants.edit.equals(type)){
				createOperationLog(request,  RhipModuleName.OH, "职业病病人档案-修改企业信息", OperationName.UPDATE);
			}else if(OHConstants.add.equals(type)){
				createOperationLog(request,  RhipModuleName.OH, "职业病病人档案-新增企业信息", OperationName.ADD);
			}	
		}
		model.put("msg", rs);
		model.put("companyOptType", OHConstants.edit);
		model.put("companyInfo", companyInfo);
		return url;
	}
	
	@ResponseBody
	@RequestMapping(value = "/verifyEmployeeInfo")
	public ModelMap verifyEmployeeInfo(
			HttpServletRequest request, String employeeInfoId, String opType) {
		Long[] idArr =convertToLong(employeeInfoId);// id
		OhEmployeeInfo employee = new OhEmployeeInfo();
		employee.setUpdateBy(getCurrentUser(request).getUserName());
		employee.setVerifier(getCurrentUser(request).getName());
		Date now = new Date();
		employee.setVerifyDate(now);
		employee.setUpdateTime(now);
		
		Boolean rs = occPatientService.verifyEmployeeInfo(employee, idArr, opType);
		ModelMap model = new ModelMap();
		if (rs) {
			model.addAttribute("result", true);
			model.addAttribute("message", "操作成功！");
			if(OHConstants.VERIFY_STATE_1.equals(opType)){
				createOperationLog(request,  RhipModuleName.OH, "职业病病人档案-审核通过", OperationName.UPDATE);
			}else if(OHConstants.VERIFY_STATE_2.equals(opType)){
				createOperationLog(request,  RhipModuleName.OH, "职业病病人档案-审核不通过", OperationName.UPDATE);
			}
		} else {
			model.addAttribute("result", false);
			model.addAttribute("message", "操作失败！");
		}
		return model;
	}
	
	@RequestMapping(value = "/autoComSel")
	@ResponseBody
	public SelectDTO<OhEnterpriseInfo> autoComSel(HttpServletRequest request, String inputValue, int currentPage) {
		Criteria criteria = new Criteria();
		Page page = super.getPage(request, currentPage);
		criteria.add("is_delete", 0);
		if(ObjectUtil.isNotEmpty(inputValue)){
			criteria.add("company_name", OP.LIKE ,inputValue);
		}
		PageList<OhEnterpriseInfo> enterpriseInfoList = enterpriseDocService.searchEnterpriseInfoList(criteria, page);
		return new SelectDTO<OhEnterpriseInfo>(enterpriseInfoList);
	}

	
	private void verifyStateSet(OhEmployeeInfo employeeInfo, HttpServletRequest request){
		Date now = new Date();
		if(employeeInfo==null){
			employeeInfo=new OhEmployeeInfo();
			employeeInfo.setUpdateBy(getCurrentUser(request).getUserName());
			employeeInfo.setUpdateTime(now);
		}
		List<Role> roleList = this.getCurrentUserRole(request);
		for(Role role:roleList){
			//职业卫生科默认审核通过
			if(OHConstants.ROLE_23.equals(role.getRoleCode()))
			{
				employeeInfo.setVerifyState(OHConstants.VERIFY_STATE_1);
				employeeInfo.setVerifier(getCurrentUser(request).getName());
				employeeInfo.setVerifyDate(now);
			}else{
				employeeInfo.setVerifyState(OHConstants.VERIFY_STATE_3);
			}
		}
	}
	
	public static Long[] convertToLong(String id) { // 工具类Long
		if (ObjectUtil.isNullOrEmpty(id)) {
			Long[] ids = null;
			return ids;
		} else {
			String[] sample = id.split(",");
			Long[] ids = new Long[sample.length];
			for (int i = 0; i < sample.length; i++) {
				ids[i] = Long.parseLong(sample[i]);
			}
			return ids;
		}
	}

	/**
	 * 职业病上报
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/reportIndex")
	public String occPatientReport(HttpServletRequest request, Model model) {
		return "rhip.oh.occPatient.reportSearch";
	}

	@RequestMapping("/reportList")
	public String searchReportList(OccPatientForm form, HttpServletRequest request, ModelMap model) {
		String url = "rhip.oh.occPatient.reportList";
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = null;
		ca = form.getCriteria();
		if(hasRole(RoleType.ZX_GLY, request)||hasRole(RoleType.ZXZYB, request)||hasRole(RoleType.YYZYB, request)){
			ca.add("CREATE_ORGAN_CODE",getCurrentOrg(request).getOrganCode());
		}
		PageList<OccupationDiseaseReport> plist = occPatientService.getOPReportList(ca, page);
		model.addAttribute("reportList", plist.getList());
		model.addAttribute("page", plist.getPage());
		return url;
	}
	
	/**
	 * 职业病报卡
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/initAddReport")
	public String reportint(ModelMap model, HttpServletRequest request) {
		OccupationDiseaseReport occupationDiseaseReport = new OccupationDiseaseReport();
		occupationDiseaseReport.setFillOrganName(getCurrentOrg(request).getOrganName());
		occupationDiseaseReport.setFillUserName(getCurrentUser(request).getName());
		occupationDiseaseReport.setFillTime(new Date());
		occupationDiseaseReport.setCreateOrganCode(getCurrentOrg(request).getOrganCode());
		Calendar a=Calendar.getInstance();
		int current_year=a.get(Calendar.YEAR);
		model.put("current_year", current_year);
		model.put("odReport", occupationDiseaseReport);
		model.put("from", "csws");
		return "rhip.oh.occPatient.report";
	}

	/**
	 * 职业病上报--保存
	 * @param report
	 * @param request
	 * @return
	 */
	@RequestMapping("/reportSave")
	public Object reportSave(OccupationDiseaseReport report, HttpServletRequest request, ModelMap model) {
		boolean result = false;
		try {
			final Organization organization = new Organization();
			organization.setOrganCode(report.getFillOrganName());
			final User user = new User();
			user.setName(report.getFillUserName());
			resetDate(report, request);
			report.setIsDelete(0);
			if(ObjectUtil.isNullOrEmpty(report.getId())){
				OhEmployeeInfo employeeInfo = generateEmployeeInfo(report);
				verifyStateSet(employeeInfo,request);
				Boolean rs = occPatientService.saveEmployeeInfo(employeeInfo, OHConstants.add, getCurrentUser(request), getCurrentOrg(request));
				if(rs){
					//日记记录
					createOperationLog(request,  RhipModuleName.OH, "职业病病人档案-新增劳动者信息", OperationName.ADD);
				}
			}
			occPatientService.saveReport(report);
			//occPatientService.saveReport(report, employeeInfo, organization, user, RoleType.YS);
			result = true;
		} catch (Exception e) {
			logger.error("保存报卡失败", e);
		}
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail") ;
	}
	
	//职业病诊断结果集
		@RequestMapping("/complete/odDisease")
		@ResponseBody
		public List<Disease> queryDisease(@RequestParam(required = false, value = "inputValue") String key) {
			List<Disease> f = diseaseApp.queryDiseases(new Criteria(Disease.ICD10MAIN, OP.FLIKE, "J6"));
			return f;
		}

	
	private void resetDate(OccupationDiseaseReport report, HttpServletRequest request) {
		String pathogenesisDate = request.getParameter("pathogenesisDate");
		if (ObjectUtil.isNotEmpty(pathogenesisDate)) {
			report.setDiagnosisDate(DateUtil.convert("yyyy/MM/dd HH:mm:ss", pathogenesisDate));
		}
		String diagnosisDate = request.getParameter("diagnosisDate");
		if (ObjectUtil.isNotEmpty(diagnosisDate)) {
			report.setDiagnosisDate(DateUtil.convert("yyyy/MM/dd HH:mm:ss", diagnosisDate));
		}
	}
	@RequestMapping(value = "/viewReport/{employeeId}")
	public String viewReport( @PathVariable("employeeId") Long employeeId, HttpServletRequest request, ModelMap model) {
		String url = "rhip.oh.occPatient.report";
		Criteria criteria = new Criteria();
		criteria.add("id", employeeId);
		OccupationDiseaseReport odReport = occPatientService .getOPReport(criteria);
		model.addAttribute("odReport", odReport);
		model.addAttribute("type", "view");
		return url;
	}

	
	private OhEmployeeInfo generateEmployeeInfo(OccupationDiseaseReport report){
		OhEmployeeInfo employeeInfo = new OhEmployeeInfo();
		employeeInfo.setName(report.getName());
		employeeInfo.setIdcard(report.getIdcard());
		employeeInfo.setGender(report.getGender());
		employeeInfo.setBirthdate(report.getBirthday());
		employeeInfo.setPacounty(report.getPacounty());
		employeeInfo.setPastreet(report.getPastreet());
		employeeInfo.setPahouseNumber(report.getPahouseNumber());
		employeeInfo.setEducation(report.getEducation());
		if(ObjectUtil.isNotEmpty(report.getActualHarmAge())){
			employeeInfo.setTotalYear(Long.valueOf(report.getActualHarmAge()));
		}
		employeeInfo.setDiagnosisOrg(report.getDiagnosisOrganName());
		employeeInfo.setDeathDate(report.getDeathDate());
		employeeInfo.setDiedReason(report.getUnderlyingDeathCode());
		employeeInfo.setPhone(report.getPhoneNumber());
		employeeInfo.setCreateOrganCode(report.getCreateOrganCode());
		employeeInfo.setUpdateOrganCode(report.getCreateOrganCode());
		employeeInfo.setCreateBy(report.getFillUserName());
		employeeInfo.setCreateTime(new Date());
		Organization createOrgan = organizationApp.queryOrgan(report.getCreateOrganCode());
		employeeInfo.setCreateSuperOrganCode(createOrgan.getParentCode());
		employeeInfo.setGbcode(createOrgan.getGbCode());
		employeeInfo.setUpdateBy(report.getFillUserName());
		employeeInfo.setUpdateTime(new Date());
		return employeeInfo;
	}
}
