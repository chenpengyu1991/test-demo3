package com.founder.rhip.ce.controller;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ce.controller.form.ContinueEducationQueryForm;
import com.founder.rhip.ce.service.IContinueEducationService;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.dto.ce.ContinueEducationDTO;
import com.founder.rhip.ehr.entity.ce.ContinueEducation;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.controller.StaffController;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.entity.Staff;
import com.founder.rhip.mdm.service.IOrganizationService;
import com.founder.rhip.mdm.service.IStaffService;
import com.founder.rhip.sr.controller.form.SrStaffQueryForm;

/**
 * description 继续教育学分
 * Created by chen_wenbo on 2014/04/02.
 */
@Controller
@RequestMapping(value = "/ce")
public class ContinueEducationController extends BaseController {

    @Resource(name="continueEducationService")
    private IContinueEducationService continueEducationService;
    
    @Resource(name = "organizationApp")
    private IOrganizationApp organizationApp;
    
    @Resource(name = "mdmOrganizationService")
    private IOrganizationService organizationService;

    @Resource(name = "mdmStaffService")
    private IStaffService staffService;

	@RequestMapping("/search")
	public String search(HttpServletRequest request, ModelMap modelMap) {
		return "rhip.ce.search";
	}

	@RequestMapping("/list")
	public String list(HttpServletRequest request, ModelMap modelMap, int pageIndex, ContinueEducationQueryForm form) {
		Page page = super.getPage(request, pageIndex);
		Criteria criteria = form.toCriteria();
		this.getCriteriaOrgCodes(criteria, form.getTown(),form.getCentre(), form.getStation());
		PageList<ContinueEducation> list = continueEducationService.getPageStaffCodeList(page, criteria);
		List<ContinueEducation> staffCodeList  = list.getList();
		
		List<ContinueEducation> ceList = null;
		if(staffCodeList  != null && staffCodeList .size() > 0)
		{
            criteria.add("staffCode", OP.IN, Convert2Array(list.getList(), "staffCode") );
            criteria.remove("ORGAN_CODE");
			criteria.remove("TECHNICAL");
			criteria.remove("NAME");
			criteria.remove("ID_CARD");
			ceList = continueEducationService.getList(criteria);
		}
		
		//合并smpiId相同的数据
		List<ContinueEducationDTO> dtolist = new ArrayList<ContinueEducationDTO>();
		List<ContinueEducation> tempCeList = null;
		ContinueEducationDTO dto = null;
		String staffCode = null;
		
		if(staffCodeList  != null && staffCodeList .size() > 0)
		{
			for(ContinueEducation con: staffCodeList )
			{
				dto = new ContinueEducationDTO();
				staffCode = con.getStaffCode();
				tempCeList = new ArrayList<ContinueEducation>();
				
				for(ContinueEducation conTemp: ceList)
				{
					if(staffCode.equalsIgnoreCase(conTemp.getStaffCode()))
					{
						tempCeList.add(conTemp);
					}
				}
				
				dto.setCeList(tempCeList);
				dto.setStaffCode(staffCode);
				
				dtolist.add(dto);
			}
		}
		
		modelMap.addAttribute("dtoList", dtolist);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("pageIndex", pageIndex);
		return "rhip.ce.list";
	}
	
	/**
	 * 根据查询条件中的镇中心站来形成查询条件
	 * @param criteria
	 */
	private void getCriteriaOrgCodes(Criteria criteria, String town, String centre, String station) {
		if(StringUtil.isNotEmpty(station)) {
			criteria.add("ORGAN_CODE", station);
		} else if(StringUtil.isNotEmpty(centre) && StringUtil.isNullOrEmpty(station)) {
			criteria.add("ORGAN_CODE", centre);
		} else if((StringUtil.isNullOrEmpty(centre) && StringUtil.isNullOrEmpty(station) && StringUtil.isNotEmpty(town))) {
			List<Organization> centres = organizationApp.queryOrganization(new Criteria("GB_CODE", town).add("GENRE_CODE", OrgGenreCode.CENTRE.getValue()));
			List<String> orgCodes = new ArrayList<String>();
			//所属中心人员
			orgCodes.addAll(this.getOrgCodeList(centres));
			for(Organization org: centres) {
				//所属中心下属站的人员
				List<Organization> stations = organizationApp.queryOrganization(new Criteria(Organization.PARENT_CODE, org.getOrganCode()));
				orgCodes.addAll(this.getOrgCodeList(stations));
			}
			criteria.add("ORGAN_CODE", OP.IN, orgCodes);
		}
	}
	
	/**
	 * 根据机构的集合获取其机构代码的集合
	 * @param centres
	 * @return
	 */
	private List<String> getOrgCodeList(@NotEmpty List<Organization> centres) {
		List<String> orgCodes = new ArrayList<String>();
		for(Organization centre :centres ) {
			orgCodes.add(centre.getOrganCode());
		}
		return orgCodes;
	}
	
	@RequestMapping("/add")
	public String add(ModelMap model, HttpServletRequest request){
		ContinueEducation continueEducation = new ContinueEducation();
		Staff staff = new Staff();
		model.addAttribute("continueEducation", continueEducation);
		model.addAttribute("staff", staff);
		return "rhip.ce.add";
	}
	
	@RequestMapping("/edit")
	public String edit(ModelMap model, HttpServletRequest request, String staffCode){
		Criteria criteria = new Criteria();
		criteria.add("staffCode", staffCode);
		Staff sf = continueEducationService.getStaff(criteria);
		criteria.remove("staffCode");
		criteria.add("staffCode", staffCode);
		List<ContinueEducation> list = continueEducationService.getList(criteria);
		model.addAttribute("continueEducationList", list);
		model.addAttribute("staff", sf);
		return "rhip.ce.edit";
	}
	
	@RequestMapping("/updateStaff")
	@ResponseBody
	public void updateStaff(HttpServletRequest request, Staff staff){
		if(staff == null) return;
		List<Staff> staffList = staffService.queryStaff(new Criteria().add("smpiId",staff.getSmpiId()));
		if(staffList == null || staffList.size() == 0) return;
		Staff sf = staffList.get(0);
		sf.setPeriod(staff.getPeriod());
		sf.setCreditA(staff.getCreditA());
		sf.setCreditB(staff.getCreditB());
		sf.setStaffCode(staff.getStaffCode());
		continueEducationService.updateStaff(sf);
	}

	@RequestMapping("/saveEducation")
	@ResponseBody
	public Object saveEducation(HttpServletRequest request, ModelMap modelMap, ContinueEducation continueEducation){
		try {
			if(continueEducation.getId() != null){
				continueEducationService.delete(new Criteria("id",continueEducation.getId()));
				continueEducation.setId(null);
				continueEducation.setUpdateDate(new Date());
				continueEducation.setUpdateOrganCode(getCurrentOrg(request).getOrganCode());
				continueEducation.setUpdateUserCode(getCurrentUser(request).getId().toString());
			}
			Calendar.getInstance();
			continueEducation.setCreateDate(new Date());
			continueEducation.setCreateOrganCode(getCurrentOrg(request).getOrganCode());
			continueEducation.setCreateUserCode(getCurrentUser(request).getId().toString());
			continueEducationService.save(continueEducation);
		} catch (Exception e) {
			return null; 
		}
		Criteria criteria = new Criteria();
		criteria.add("staffCode", continueEducation.getStaffCode());
		List<ContinueEducation> list = continueEducationService.getList(criteria, new Order("id", true));
		return list;
	}
	
	@RequestMapping("/getProject")
	@ResponseBody
	public Object getProject(ModelMap model, HttpServletRequest request, String staffCode){
		Criteria criteria = new Criteria();
		criteria.add("staffCode", staffCode);
		List<ContinueEducation> list = continueEducationService.getList(criteria, new Order("id", true));
		return list;
	}
	
	@RequestMapping("/addProject")
	public String addProject(ModelMap model, HttpServletRequest request, String staffCode){
		ContinueEducation continueEducation = new ContinueEducation();
		continueEducation.setStaffCode(staffCode);
		model.addAttribute("continueEducation", continueEducation);
		return "rhip.ce.addProject";
	}
	
	@RequestMapping("/editProject")
	public String editProject(HttpServletRequest request, ModelMap modelMap, Long id){
		Criteria criteria = new Criteria();
		criteria.add("id", id);
		ContinueEducation continueEducation = continueEducationService.getContinueEducation(criteria);
		modelMap.addAttribute("continueEducation", continueEducation);
		return "rhip.ce.editProject";
	}
	
	@RequestMapping("/delProject")
	@ResponseBody
	public Object delProject(HttpServletRequest request, ModelMap modelMap, String staffCode, Long id){
		Criteria criteria = new Criteria();
		criteria.add("id", id);
		continueEducationService.delete(criteria);
		criteria.remove("id");
		criteria.add("staffCode", staffCode);
		List<ContinueEducation> list = continueEducationService.getList(criteria, new Order("id", true));
		return list;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public ModelMap delete(HttpServletRequest request, Long id) {
		ModelMap modelMap = new ModelMap();
		try {
			int result = continueEducationService.delete(new Criteria("ID",id));
			if (result != 0) {
				modelMap.addAttribute("success", true);
				modelMap.addAttribute("message", "删除成功！");
			} else {
				modelMap.addAttribute("success", false);
				modelMap.addAttribute("message", "删除失败！");
			}
		} catch (Exception e) {
			modelMap.addAttribute("success", false);
			modelMap.addAttribute("message", "删除失败！" + e.getMessage());
		}
		return modelMap;
	}

	@RequestMapping("/view")
	public String view(ModelMap modelMap, Long id) {
        ContinueEducation continueEducation = continueEducationService.getContinueEducation(new Criteria("id", id));
		modelMap.addAttribute("continueEducation", continueEducation);
		return  "rhip.ce.view";
	}
	
	@RequestMapping("/viewByStaff")
	public String viewByStaff(ModelMap model, HttpServletRequest request, String staffCode){
		Criteria criteria = new Criteria();
		criteria.add("staffCode", staffCode);
		Staff sf = continueEducationService.getStaff(criteria);
		criteria.remove("staffCode");
		criteria.add("staffCode", staffCode);
		List<ContinueEducation> list = continueEducationService.getList(criteria);
		model.addAttribute("continueEducationList", list);
		model.addAttribute("staff", sf);
		return "rhip.ce.viewByStaff";
	}
	
	@RequestMapping("/staffSearch")
    public String personManage(ModelMap model,HttpServletRequest request) {
        StaffController.StaffSearchForm condition = new StaffController.StaffSearchForm();
        model.addAttribute("condition", condition);
        addByZX(model, request);
        return "rhip.ce.staffSearch";
    }

	private void addByZX(ModelMap model,HttpServletRequest request){
        if(hasRole(RoleType.ZX_GLY, request)){
            List<Organization> orgList = new ArrayList<>();
            Organization org = getCurrentOrg(request);
            orgList.add(org);
            orgList.addAll(organizationApp.queryOrganization(new Criteria(Organization.PARENT_CODE, org.getOrganCode())));
            model.addAttribute("orgList", orgList);
        }
    }
	
    @RequestMapping("/staffList")
    public String staffList(int indexPage, ModelMap model, HttpServletRequest request, SrStaffQueryForm condition) {
    	Page page = super.getPage(request, indexPage);
		Criteria criteria = condition.getCriteria();
		if(this.hasRole(RoleType.Z_GLY, request)) {
			criteria.add("organCode", condition.getOrganCode());
		} else {
			this.getCriteriaOrgCodes(criteria, condition.getTown(),condition.getVillage(), condition.getStation());
		}
    	PageList<Staff> list = staffService.queryStaff(page, criteria);
        model.addAttribute("staffList", list.getList());
        model.addAttribute("page", list.getPage());
        model.addAttribute("indexPage", indexPage);
        return "rhip.ce.staffList";
    }
    
    private <T> Object[] Convert2Array(List<T> list, String fieldName){
		Object[] ta = new Object[list.size()];
		if(CollectionUtils.isEmpty(list)) return ta;
		Method method;
		try {
			method = list.get(0).getClass().getDeclaredMethod("get"+fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
			for(int i = 0; i < list.size(); i++){
				ta[i] = method.invoke(list.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ta;
	}
}
