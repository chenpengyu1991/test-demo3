package com.founder.rhip.idm.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.clinic.ExamineEvent;
import com.founder.rhip.ehr.service.IExamService;
import com.founder.rhip.idm.controller.form.OutpatientLogQueryForm;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Department;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IDepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping(value = "/idm/inspection")
public class InspectionResultController extends BaseController {

	@Resource(name = "mdmDepartmentService")
	private IDepartmentService departmentService;
	
	@Resource(name = "examService")
	private IExamService examService;
	
	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;
	
    /**
	 * 进入查询画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/search")
	public String search(HttpServletRequest request, ModelMap model) {
		String orgCode = getCurrentOrg(request).getOrganCode();
		if(hasRole(RoleType.YYCRB, request) || hasRole(RoleType.ZCRB, request) || hasRole(RoleType.ZXCRB, request)){
			model.addAttribute("clinicOrganCode", orgCode);
		}
		if (StringUtil.isNotEmpty(orgCode)) {
			List<Department> deptList = departmentService.getDepartments(new Criteria("organCode", orgCode));
			model.addAttribute("deptList", deptList);
		}
		model.addAttribute("deginDate", DateUtil.firstDateOfMonth(new Date()));
		return "rhip.idm.inspection.search";
	}

	/**
	 * 查询检查检验列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list")
	public String getInspectionList(HttpServletRequest request, OutpatientLogQueryForm queryForm, ModelMap model) {
		String url = "rhip.idm.inspection.list";
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = queryForm.getCriteria();
		Organization org = getCurrentOrg(request);
		List<String> organCodes = new ArrayList<String>();
		if(hasRole(RoleType.ZXCRB, request) && StringUtil.isNullOrEmpty(queryForm.getClinicOrganCode())){//中心登录（中心及下属站）
			
			for(Organization organ : getSubOrgans(new Criteria("parentCode",org.getOrganCode()))){
				organCodes.add(organ.getOrganCode());
			}
			organCodes.add(org.getOrganCode());
			ca.add("e.hospital_Code", OP.IN, organCodes.toArray());
		} else {
			if("1".equals(queryForm.getCenterAndStation())){//疾控登录（中心及下属站）
				for(Organization organ : getSubOrgans(new Criteria("parentCode",queryForm.getClinicOrganCode()))){
					organCodes.add(organ.getOrganCode());
				}
				organCodes.add(queryForm.getClinicOrganCode());
				ca.add("e.hospital_Code", OP.IN, organCodes.toArray());
			}else{
				if(ObjectUtil.isNotEmpty(ca.get("clinicOrganCode"))){
					ca.add("e.hospital_Code", ca.get("clinicOrganCode"));		
				}
			}
		}
		ca.remove("clinicOrganCode");
		PageList<ExamineEvent> plist = examService.getIDMExamsResults(page, ca);
		model.addAttribute("page", plist.getPage());
		model.addAttribute("results", plist.getList());
		return url;
	}

	@RequestMapping("/getDeptList")
	@ResponseBody
	public List<Department> getDeptList(String organCode) {
		return departmentService.getDepartments(new Criteria("organCode", organCode));
	}
	
	private List<Organization> getSubOrgans(Criteria criteria){
		List<Organization> organs = organizationApp.queryOrganization(criteria);
		return organs;
	}

}
