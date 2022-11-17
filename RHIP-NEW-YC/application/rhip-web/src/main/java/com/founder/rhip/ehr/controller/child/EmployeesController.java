package com.founder.rhip.ehr.controller.child;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.child.EmployeesHealthChecklist;
import com.founder.rhip.ehr.service.basic.IEHRNumberService;
import com.founder.rhip.hm.service.IPersonInfoService;
import com.founder.rhip.ihm.controller.form.WChQueryForm;
import com.founder.rhip.ihm.service.IEmpSearchService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "/employees")
public class EmployeesController extends BaseController {
	@Resource(name = "empSearchService")
	private IEmpSearchService empSearchService;
	
	@Autowired
    private IOrganizationApp organizationApp;
	
	@Resource
    private IPersonInfoService personInfoService;
	@Resource(name = "EHRNumberService")
	private IEHRNumberService EHRNumberService;
	@RequestMapping("/search")
	public String search(HttpServletRequest request, Model model) {
		initOrg(request, model);
		return "rhip.ehr.child.employees.search";
	}

	@RequestMapping("/list")
	public String healthCheck(HttpServletRequest request, WChQueryForm form, Model model) {
		int currentPage = Integer.valueOf(request.getParameter("pageIndex"));
		Page page = super.getPage(request, currentPage);
		Boolean flg = SecurityUtils.hasRole(RoleType.ZX_GLY, request) || hasRole(RoleType.QWGZX,request) || hasRole(RoleType.ADMIN,request);
		List<String> orgCodes = this.getOrgCodeByOrgCode(request);
		PageList<EmployeesHealthChecklist> plist = empSearchService.getEmployeesHealthChecklist(flg,orgCodes,form.getParamMap(), page);
		model.addAttribute("employeesList", plist.getList());
		model.addAttribute("page", plist.getPage());

		return "rhip.ehr.child.employees.list";
	}
	
	@RequestMapping("/add")
	public String addHealthCheck(ModelMap model, EmployeesHealthChecklist employeesHealthChecklist){
		employeesHealthChecklist=empSearchService.getHealthCheck(new Criteria("ID", employeesHealthChecklist.getId()));
		model.addAttribute("employeesHealthChecklist", employeesHealthChecklist);
		model.addAttribute("flag", "1");
		return "rhip.ehr.child.employees.add";
	}
	
	@RequestMapping("/addHealthCard")
	public String addHealCard(ModelMap model, String idStr){
		/*employeesHealthChecklist=empSearchService.getHealthCheck(new Criteria("ID", employeesHealthChecklist.getId()));
		model.addAttribute("employeesHealthChecklist", employeesHealthChecklist);*/
		String []idList=idStr.split(",");
		List<EmployeesHealthChecklist> employeesHealthChecklist=new ArrayList<>();
		for (int i = 1; i < idList.length; i++) {
			if(ObjectUtil.isNotEmpty(idList[i])){
				EmployeesHealthChecklist employeesHealthCheck=empSearchService.getHealthCheck(new Criteria("ID", idList[i]));
				employeesHealthChecklist.add(employeesHealthCheck);
			}
			
			
		}
		model.addAttribute("employeesHealthCheckList", employeesHealthChecklist);
		model.addAttribute("flag", "2");
		return "rhip.ehr.child.employees.addHealthCard";
	}
	
	@RequestMapping("/view")
	public String view(ModelMap model, EmployeesHealthChecklist employeesHealthChecklist){
		employeesHealthChecklist=empSearchService.getHealthCheck(new Criteria("ID", employeesHealthChecklist.getId()));
		model.addAttribute("employeesHealthChecklist", employeesHealthChecklist);
		model.addAttribute("flag", "2");
		return "rhip.ehr.child.employees.add";
	}
	@ResponseBody
	@RequestMapping("/saveEmployees")
	public String saveEmployees(HttpServletRequest request, ModelMap model, EmployeesHealthChecklist employeesHealthChecklist) {
		CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
		employeesHealthChecklist.setChest(employeesHealthChecklist.getChest().trim());
		if(ObjectUtil.isNullOrEmpty(employeesHealthChecklist.getId())){
			employeesHealthChecklist.setCreateTime(new Date());
			if(hasRole(RoleType.QWGZX,request)){
				employeesHealthChecklist.setCreateOrganCode(currentLoginInfo.getOrganization().getGbCode());
			}else{
				employeesHealthChecklist.setCreateOrganCode(currentLoginInfo.getOrganization().getOrganCode());
			}
			
			employeesHealthChecklist.setCreaPerson(currentLoginInfo.getUser().getName());
		}else{
			EmployeesHealthChecklist employeesHealthChecklist1=empSearchService.getHealthCheck(new Criteria("ID", employeesHealthChecklist.getId()));
			employeesHealthChecklist.setUpdatePerson(currentLoginInfo.getUser().getName());
			employeesHealthChecklist.setUpdateTime(new Date());
			employeesHealthChecklist.setCreateOrganCode(employeesHealthChecklist1.getCreateOrganCode());
			employeesHealthChecklist.setCreaPerson(employeesHealthChecklist1.getCreaPerson());
			employeesHealthChecklist.setCreateTime(employeesHealthChecklist1.getCreateTime());
		}
		//PersonInfo personInfo = personInfoDto.getPersonInfo();
		int num=empSearchService.saveEmployees(employeesHealthChecklist);
		if(num==1){
			return "1";
		}else{
			return "0";
		}
	}
	
	@RequestMapping("/getChildInfo")
    @ResponseBody
    public Map<String, Object> getChildInfo(String idCard, String personId,String physicalExaminationDate,String id) throws ParseException {
        Criteria criteria = new Criteria();
        if (StringUtil.isNotEmpty(idCard)) {
        	if(idCard.length()==15){
        		if(IDCardUtil.validateIdCard15(idCard)){
        			idCard= IDCardUtil.conver15CardTo18(idCard);
        		}
        		
        		
        	}
            criteria.add("idcard", idCard);
            criteria.add("FILING_FLAG","1");
        } else {
            return null;
        }
        PersonInfo personInfo = personInfoService.getPersonInfoId(criteria);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
        if (ObjectUtil.isNotEmpty(personInfo)) {
        	Map<String, Object> result = new HashMap<>();
            result.put("id", personInfo.getId());
            result.put("name", personInfo.getName());
            result.put("gender", personInfo.getGender());
            /*String ehrNo = EHRNumberService.getHealthFileNo(personInfo.getPastreet());
            result.put("physicalExaminationNo", DateUtil.formatDate(new Date(), "yyyy-MM-dd").substring(0, 4)+ehrNo.substring(12, personInfo.getHealthFileNo().length()));*/
            if(ObjectUtil.isNotEmpty(personInfo.getBirthday())){
                result.put("birthday", sdf.format(personInfo.getBirthday()));
            }
            if(ObjectUtil.isNotEmpty(idCard)){
            	result.put("idCard", idCard);
            }else{
            	result.put("idCard", personInfo.getIdcard());
            }
            
            result.put("personId", personInfo.getId());
            List<EmployeesHealthChecklist> employeesHealthChecklist=empSearchService.getHealthCheckList(new Criteria("PERSON_ID", personInfo.getId()),new Order("physical_examination_date desc"));
            double num=0;
            if(ObjectUtil.isNotEmpty(id)){
            	
            	if(ObjectUtil.isNotEmpty(employeesHealthChecklist)){
            		//修改自身
            		if(employeesHealthChecklist.get(0).getId().toString().equals(id)){
            			if(employeesHealthChecklist.size()==1){
            				result.put("timeFlag", "0");
            			}else if(employeesHealthChecklist.size()>1){
            				num=   com.founder.fasf.util.DateUtil.getAgeByBirthday(employeesHealthChecklist.get(1).getPhysicalExaminationDate(),new Date(physicalExaminationDate)  );
            				if(num>=1){
            	           	 	result.put("timeFlag", "0");
            	            }else{
            	            	
            	            	result.put("timeFlag", "1");
            	            }
            			}
            		}
            	}
            }else{
            	if(ObjectUtil.isNotEmpty(employeesHealthChecklist)){
            		num=  com.founder.fasf.util.DateUtil.getAgeByBirthday(employeesHealthChecklist.get(0).getPhysicalExaminationDate(),new Date(physicalExaminationDate) );
    				if(num>=1){
    	           	 	result.put("timeFlag", "0");
    	            }else{
    	            	
    	            	result.put("timeFlag", "1");
    	            }
            	}else{
            		result.put("timeFlag", "0");
            	}
            }
            
            
            
           

            //num == 0 ? 1 : Math.abs(result);
            
            /* List<NeonatalFamilyVisit> list= neonatalFamilyVisitDao.getList(new Criteria("PERSON_ID", personInfo.getId()), new Order("CREATE_DATE,ID"));
            if(ObjectUtil.isNotEmpty(list)){
            	result.put("fatherName", list.get(0).getFatherName());
            	result.put("fatherPhone", list.get(0).getFatherPhone());
            	result.put("motherName", list.get(0).getMotherName());
            	result.put("matherPhone", list.get(0).getMatherPhone());
            	result.put("fatherOccupationalGroupCode", list.get(0).getFatherOccupationalGroupCode());
            	result.put("fatherBirthday", DateUtil.formatDate(list.get(0).getFatherBirthday(), "yyyy/MM/dd"));
            	result.put("motherOccupationalGroupCode", list.get(0).getMotherOccupationalGroupCode());
            	result.put("motherBirthday", DateUtil.formatDate(list.get(0).getMotherBirthday(), "yyyy/MM/dd"));
            }*/
            return result;
        }
        return null;
        
        
    }
	
	public List<String> getOrgCodeByOrgCode(HttpServletRequest request){
    	//卫管角色-机构
		String searchTown=request.getParameter("searchTown");
		String searchCenter = request.getParameter("searchCenter");
		String searchStation = request.getParameter("searchStation");
		String orgCode = getCurrentOrg(request).getOrganCode();
        List<String> orgCodes = new ArrayList<String>();
		Criteria criteria = new Criteria();
		if(hasRole(RoleType.QWGZX,request)){
			if(StringUtil.isNotEmpty(searchCenter) && StringUtil.isNullOrEmpty(searchStation)){
				criteria.add(Organization.PARENT_CODE,searchCenter);
				orgCodes.add(searchCenter);
				List<Organization> organizationList = organizationApp.queryOrganization(criteria);
				if(ObjectUtil.isNotEmpty(organizationList)){
					for (Organization organization : organizationList) {
						orgCodes.add(organization.getOrganCode());
						orgCodes.add(organization.getParentCode());
					}
				}
			}else if(StringUtil.isNotEmpty(searchStation)){
				orgCodes.add(searchStation);
			}else {
				criteria.add("gbCode", getCurrentOrg(request).getGbCode());
				criteria.add("genreCode", OP.IN, new String[]{"B1", "B2"});
				List<Organization> organizationList = organizationApp.queryOrganization(criteria);
				if(ObjectUtil.isNotEmpty(organizationList)){
					for (Organization organization : organizationList) {
						orgCodes.add(organization.getOrganCode());
						orgCodes.add(organization.getGbCode());
					}
				}
			}
		}else if(hasRole(RoleType.ZX_GLY,request)){
        criteria.add(Organization.PARENT_CODE,orgCode);
        List<Organization> organizationList = organizationApp.queryOrganization(criteria);
        orgCodes.add(orgCode);
        if(ObjectUtil.isNotEmpty(organizationList)){
            for (Organization organization : organizationList) {
                orgCodes.add(organization.getOrganCode());
                orgCodes.add(organization.getParentCode());
            }
            
        }
		}
        return orgCodes;
    }
}
