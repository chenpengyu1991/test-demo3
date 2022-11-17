package com.founder.rhip.phsr.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.common.VoUtil;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.dto.HealthEducationReport;
import com.founder.rhip.ehr.dto.HealthEducationReportSummary;
import com.founder.rhip.ehr.dto.PopulaceDTO;
import com.founder.rhip.ehr.dto.VaccinationService;
import com.founder.rhip.ehr.dto.VaccinationServiceDto;
import com.founder.rhip.he.common.CriteriaOrganizer;
import com.founder.rhip.he.controller.VisitController;
import com.founder.rhip.he.service.IHealthEducationStatisticsService;
import com.founder.rhip.ihm.service.IhealthVaccinationService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.Organization;

@Controller
@RequestMapping(value = "/healthVaccination")
public class HealthVaccinationServiceController  extends VisitController{
	@Resource(name = "healthVaccinationService")
	private IhealthVaccinationService healthVaccinationService;
	/**
	 * 查看预防接种服务
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/search")
	public String search(HttpServletRequest request, ModelMap model) {
		model.addAttribute("currentYear",new Date());
		return "rhip.phsr.he.vaccination.search";
	}
	
	/**
	 * 列表显示预防接种服务报表
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/list")
	public String list(HttpServletRequest request, ModelMap model) {
		Criteria criteria = CriteriaOrganizer.initCriteriaCondition(request.getParameterMap());
		/*if(criteria.contains("countType")){
			criteria.remove("countType");
		}*/
		criteria.remove("date"); // 去除多余的条件
		String summaryType = request.getParameter("countType");
		if("2".equals(summaryType)){//按月
			criteria.remove("createBeginTime");
			criteria.remove("createEndTime");
		}else if("1".equals(summaryType)){//按年
			criteria.remove("month");
		}
		
		criteria.remove("countType");
		// 不同身份查询条件
		organizeCriteria(criteria, model, request);
		CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
		if(SecurityUtils.hasRole(RoleType.QWGZX, request)){
			criteria.add("qwgzxCode",currentLoginInfo.getOrganization().getGbCode());
		}
		List<VaccinationService> reports = healthVaccinationService.VaccinationServiceList(criteria);
		if(SecurityUtils.hasRole(RoleType.QWGZX, request)){
			criteria.add("qwgzxCode",currentLoginInfo.getOrganization().getGbCode());
		}
		VaccinationService vaccinationServiceDto=healthVaccinationService.VaccinationServiceListSum(criteria);
		List<VaccinationService> reportList =new ArrayList<>();
		
		if(SecurityUtils.hasRole(RoleType.ZX_GLY, request) || SecurityUtils.hasRole(RoleType.Z_GLY, request)) {
			criteria.add("orgCode",currentLoginInfo.getOrganization().getOrganCode());
			reportList = healthVaccinationService.VaccinationServiceList(criteria);
		}else{
			reportList.addAll(reports);
		}
		
		criteria.remove("orgCode");
		model.addAttribute("currentLoginInfo", currentLoginInfo);
		model.addAttribute("reports", reports);
		model.addAttribute("reportList", reportList);
		model.addAttribute("vaccinationServiceDto", vaccinationServiceDto);
		
		return "rhip.phsr.he.vaccination.list";
	}
	@ResponseBody
	@RequestMapping("/saveVaccination")
	public String saveVaccination(HttpServletRequest request, ModelMap model) {
		VaccinationServiceDto vaccinationServiceDto = VoUtil.getFormData(request, VaccinationServiceDto.class);
		int num=0;
		for (int i = 0; i < vaccinationServiceDto.getVaccinationServiceList().size(); i++) {
			if(ObjectUtil.isNotEmpty(vaccinationServiceDto.getVaccinationServiceList().get(i))){
				if(ObjectUtil.isNotEmpty(vaccinationServiceDto.getVaccinationServiceList().get(i).getId())){
					vaccinationServiceDto.getVaccinationServiceList().get(i).setUpdateReportingTime(new Date());
					num=healthVaccinationService.updateVaccination(vaccinationServiceDto.getVaccinationServiceList().get(i));
				}else{
				    CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
				    vaccinationServiceDto.getVaccinationServiceList().get(i).setOrgCode(currentLoginInfo.getOrganization().getOrganCode());
				    vaccinationServiceDto.getVaccinationServiceList().get(i).setOrgName(currentLoginInfo.getOrganization().getOrganName());
				    if(SecurityUtils.hasRole(RoleType.ZX_GLY, request)) {
				    	 vaccinationServiceDto.getVaccinationServiceList().get(i).setCenterOrgCode(currentLoginInfo.getOrganization().getOrganCode());
				    }else if(SecurityUtils.hasRole(RoleType.Z_GLY, request)){
				    	 vaccinationServiceDto.getVaccinationServiceList().get(i).setCenterOrgCode(currentLoginInfo.getOrganization().getParentCode());
				    }
				   
				    vaccinationServiceDto.getVaccinationServiceList().get(i).setGbCode(currentLoginInfo.getOrganization().getGbCode());
				    vaccinationServiceDto.getVaccinationServiceList().get(i).setYear(Integer.parseInt(request.getParameter("year")));
				    vaccinationServiceDto.getVaccinationServiceList().get(i).setMonth(Integer.parseInt(request.getParameter("month")));
				    vaccinationServiceDto.getVaccinationServiceList().get(i).setReportingTime(new Date());
				    num=healthVaccinationService.addVaccination(vaccinationServiceDto.getVaccinationServiceList().get(i));
				}
			}
		}
		if(num>0){
			return "保存成功!";
		}else{
			return "保存失败!";
		}
	}
}
