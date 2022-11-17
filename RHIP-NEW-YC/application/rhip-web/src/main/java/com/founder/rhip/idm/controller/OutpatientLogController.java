package com.founder.rhip.idm.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmInpatientLog;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmOutpatientLog;
import com.founder.rhip.idm.controller.form.OutpatientLogQueryForm;
import com.founder.rhip.idm.service.IIdmInpatientLogService;
import com.founder.rhip.idm.service.IIdmOutpatientLogService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Department;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IDepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/idm/log")
public class OutpatientLogController extends BaseController {
	
	@Resource(name = "mdmDepartmentService")
	private IDepartmentService departmentService;
	
	@Resource(name = "idmInpatientLogService")
	private IIdmInpatientLogService idmInpatientLogService;

	@Resource(name = "idmOutpatientLogService")
	private IIdmOutpatientLogService idmOutpatientLogService;
	
	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;

	/**
	 * 进入查询画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/outpatient/search")
	public String searchOutpatientLog(HttpServletRequest request, ModelMap model) {
		String orgCode = getCurrentOrg(request).getOrganCode();
		if(hasRole(RoleType.YYCRB, request) || hasRole(RoleType.ZCRB, request) || hasRole(RoleType.ZXCRB, request)){
			model.addAttribute("clinicOrganCode", orgCode);
		}
		if (StringUtil.isNotEmpty(orgCode)) {
			List<Department> deptList = departmentService.getDepartments(new Criteria("organCode", orgCode));
			model.addAttribute("deptList", deptList);
		}
		return "rhip.idm.outpatientLog.search";
	}

	/**
	 * 查询门诊日志列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/outpatient/list")
	public String getOutpatientLogList(HttpServletRequest request, OutpatientLogQueryForm queryForm, ModelMap model) {
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = queryForm.getCriteria();
		Organization org = getCurrentOrg(request);
		List<String> organCodes = new ArrayList<String>();
		if(!hasRole(RoleType.JKFYK, request) && !hasRole(RoleType.ADMIN, request) && StringUtil.isNullOrEmpty(queryForm.getClinicOrganCode())){
			ca.remove("clinicOrganCode");
			if(hasRole(RoleType.ZXCRB, request)){
				for(Organization organ : getSubOrgans(new Criteria("parentCode",org.getOrganCode()))){
					organCodes.add(organ.getOrganCode());
				}
			}
			organCodes.add(org.getOrganCode());
			ca.add("clinicOrganCode", OP.IN, organCodes.toArray());
		} else {
			if("1".equals(queryForm.getCenterAndStation())){
				for(Organization organ : getSubOrgans(new Criteria("parentCode",queryForm.getClinicOrganCode()))){
					organCodes.add(organ.getOrganCode());
				}
				organCodes.add(queryForm.getClinicOrganCode());
				ca.remove("clinicOrganCode");
				ca.add("clinicOrganCode", OP.IN, organCodes.toArray());
			}
		}
		PageList<IdmOutpatientLog> plist = idmOutpatientLogService.getPageList(page, ca);
		String url = "rhip.idm.outpatientLog.list";
		model.addAttribute("page", plist.getPage());
		model.addAttribute("logs", plist.getList());
		return url;
	}
	
	 /**
	 * 出入院登记日志查询
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/register/search")
	public String searchRegisterLog(HttpServletRequest request, ModelMap model) {
		String orgCode = getCurrentOrg(request).getOrganCode();
		if(hasRole(RoleType.YYCRB, request) || hasRole(RoleType.ZCRB, request) || hasRole(RoleType.ZXCRB, request)){
			model.addAttribute("clinicOrganCode", orgCode);
		}
		if (StringUtil.isNotEmpty(orgCode)) {
			List<Department> deptList = departmentService.getDepartments(new Criteria("organCode", orgCode));
			model.addAttribute("deptList", deptList);
		}
		return "rhip.idm.registerLog.search";
	}

	/**
	 * 出入院登记日志查询列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/register/list")
	public String getRegisterLogList(HttpServletRequest request, OutpatientLogQueryForm queryForm, ModelMap model) {
		String url = "rhip.idm.registerLog.list";
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = queryForm.getCriteria();
		Organization org = getCurrentOrg(request);
		List<String> organCodes = new ArrayList<String>();
		if(!hasRole(RoleType.JKFYK, request) && !hasRole(RoleType.ADMIN, request) && StringUtil.isNullOrEmpty(queryForm.getClinicOrganCode())){
			ca.remove("clinicOrganCode");
			if(hasRole(RoleType.ZXCRB, request)){
				for(Organization organ : getSubOrgans(new Criteria("parentCode",org.getOrganCode()))){
					organCodes.add(organ.getOrganCode());
				}
			}
			organCodes.add(org.getOrganCode());
			ca.add("clinicOrganCode", OP.IN, organCodes.toArray());
		} else {
			if("1".equals(queryForm.getCenterAndStation())){
				for(Organization organ : getSubOrgans(new Criteria("parentCode",queryForm.getClinicOrganCode()))){
					organCodes.add(organ.getOrganCode());
				}
				organCodes.add(queryForm.getClinicOrganCode());
				ca.remove("clinicOrganCode");
				ca.add("clinicOrganCode", OP.IN, organCodes.toArray());
			}
		}
		PageList<IdmInpatientLog> plist = idmInpatientLogService.getPageList(page, ca);
		model.addAttribute("page", plist.getPage());
		model.addAttribute("logs", plist.getList());
		return url;
	}
	
	private List<Organization> getSubOrgans(Criteria criteria){
		List<Organization> organs = organizationApp.queryOrganization(criteria);
		return organs;
	}

}
