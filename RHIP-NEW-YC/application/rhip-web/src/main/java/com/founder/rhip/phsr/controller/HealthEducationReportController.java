package com.founder.rhip.phsr.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.dto.HealthEducationReport;
import com.founder.rhip.ehr.dto.HealthEducationReportSummary;
import com.founder.rhip.he.common.CriteriaOrganizer;
import com.founder.rhip.he.controller.VisitController;
import com.founder.rhip.he.service.IHealthEducationStatisticsService;
import com.founder.rhip.phsr.controller.form.HealthEducationQueryForm;


/**
 * 健康教育报表统计
 * 
 * @author GaoFei
 *
 */
@Controller
@RequestMapping(value = "/phsr/he/report")
public class HealthEducationReportController extends VisitController {
	
	@Resource(name = "healthEducationStatisticsService")
	private IHealthEducationStatisticsService healthEducationStatisticsService;
	
	/**
	 * 查看健康教育报表
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/search")
	public String search(HttpServletRequest request, ModelMap model) {
		model.addAttribute("currentYear",new Date());
		return "rhip.phsr.he.report.search";
	}
	
	/**
	 * 列表显示健康教育报表
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/list")
	public String list(HttpServletRequest request, ModelMap model, HealthEducationQueryForm queryForm) {
		Criteria criteria = queryForm.toCriteria();
		// 不同身份查询条件
		organizeCriteria(criteria, model, request);
		CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
		if(SecurityUtils.hasRole(RoleType.QWGZX, request)){
			criteria.add("qwgzxCode",currentLoginInfo.getOrganization().getGbCode());
		}
		List<HealthEducationReport> reports = healthEducationStatisticsService.getEduCensusList(criteria);
		model.addAttribute("reports", reports);
		
		
//		Criteria criteria = CriteriaOrganizer.initCriteriaCondition(request.getParameterMap());
//		if(hasRole(RoleType.QWGZX,request) && !criteria.contains("gbcode")){
//			criteria.add("gbcode",getCurrentOrg(request).getGbCode());
//		}
//		criteria.remove("date"); // 去除多余的条件
//		String summaryType = request.getParameter("summaryType");
//		if("1".equals(summaryType)){//按月
//			criteria.remove("createBeginTime");
//			criteria.remove("createEndTime");
//		}else if("2".equals(summaryType)){//按年
//			criteria.remove("month");
//		}
//		criteria.remove("summaryType");
//		// 不同身份查询条件
//		organizeCriteria(criteria, model, request);
//		List<HealthEducationReport> reports = healthEducationStatisticsService.statisticsHealthEducation(criteria);
//		model.addAttribute("reports", reports);
//		model.addAttribute("reportSummary", new HealthEducationReportSummary(reports));
		return "rhip.phsr.he.report.list";
	}
	
	public void export() {
		
	}
}
