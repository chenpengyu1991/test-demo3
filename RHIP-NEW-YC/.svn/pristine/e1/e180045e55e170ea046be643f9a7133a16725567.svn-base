package com.founder.rhip.ihm.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.dto.HealthEducationReport;
import com.founder.rhip.ehr.dto.HealthEducationReportSummary;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.ihm.service.IHealthEducationStatisticsService;


/**
 * 健康教育报表统计
 * 
 * @author GaoFei
 *
 */
@Controller
@RequestMapping(value = "/ihm/base/he/statistics")
public class HealthEducationStatisticsController{
	
	@Resource(name = "healthEducationStatisticsService_")
	private IHealthEducationStatisticsService healthEducationStatisticsService;
	
	/**
	 * 查看健康教育报表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/search")
	public String search(HttpServletRequest request, ModelMap model) {
        model.addAttribute("currentBeginDate", DateUtil.firstDateOfMonth(new Date()));
        model.addAttribute("currentEndDate",DateUtil.lastDateOfMonth(new Date()));
		return "ihm.base.he.statistics.search";
	}
	
	/**
	 * 列表显示健康教育报表
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, TargetOrgQueryForm form, ModelMap model) {
		List<HealthEducationReport> reports = healthEducationStatisticsService.statisticsHealthEducation(form.getParamMap());
		model.addAttribute("reports", reports);
		model.addAttribute("reportSummary", new HealthEducationReportSummary(reports));
		model.addAttribute("genreCodeFlag", form.getGenreCode());
		return "ihm.base.he.statistics.list";
	}
}
