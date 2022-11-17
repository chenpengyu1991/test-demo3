package com.founder.rhip.cdm.controller.report;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.cdm.controller.CdmBaseController;
import com.founder.rhip.cdm.service.IYearReportServie;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.service.IPopulaceService;
import com.founder.rhip.ehr.statisticsdto.DmYearReport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 慢病和肿瘤年报
 * 
 * @author liuk
 * 
 */
@Controller
@RequestMapping("/cdm/statistics")
public class CdYearReportController extends CdmBaseController {

	@Resource(name = "yearReportService")
	private IYearReportServie reportServie;

	@Resource(name = "populaceService")
	private IPopulaceService populaceService;

	/**
	 * 慢病年报
	 * 
	 * @return
	 */
	@RequestMapping("/cdYearReport")
	public String cdmYearReport(ModelMap model) {
		model.put("currentDate", new Date());
		return "rhip.cdm.base.report.cdYearReport";
	}

	@RequestMapping("/cdYearReport/byGengerReslut")
	public String yearReportsByGenger(QueryForm form, ModelMap model, HttpServletRequest request) {
		String currentYear = form.getCurrentYear();
		Map<String, Object> populaceMap = populaceService.getTotalCountByYear(new Criteria("COUNT_YEAR", currentYear));
		Criteria criteria = form.toCriteria();
		Map<String, List<DmYearReport>> resultMap = reportServie.getCdYearReportsByGenger(populaceMap, criteria);
		model.put("cdYearReport", resultMap);
		model.put("populaceMap", populaceMap);
		model.put("currentYear", currentYear);
		setCurrentUesrInfo(model, request);
		return "rhip.cdm.base.report.cdYearReportByGenderResult";
	}

	@RequestMapping("/cdYearReport/byAgeReslut")
	public String yearReportByAge(QueryForm form, ModelMap model, HttpServletRequest request) {
		Criteria criteria = form.toCriteria();
		Map<String, List<DmYearReport>> resultMap = reportServie.getCdYearReportByAge(null, criteria);
		model.put("cdYearReport", resultMap);
		model.put("currentYear", form.getCurrentYear());
		setCurrentUesrInfo(model, request);
		return "rhip.cdm.base.report.cdYearReportByAgeResult";
	}

	private void setCurrentUesrInfo(ModelMap model, HttpServletRequest request) {
		model.put("currentDate", new Date());
		model.put("currentUserName", getCurrentUser(request).getName());
		model.put("currentOrgName", getCurrentOrg(request).getOrganName());
	}

	/**
	 * 肿瘤年报
	 * 
	 * @return
	 */
	@RequestMapping("/tumorYearReport")
	public String tumorYearReport(ModelMap model) {
		model.put("currentDate", new Date());
		return "rhip.cdm.base.report.tumorYearReport";
	}

	@RequestMapping("/tumorYearReport/byGengerReslut")
	public String tumorYearReportsByGenger(QueryForm form, ModelMap model, HttpServletRequest request) {
		form.setDisType(EHRConstants.DM_TUMOR_TYPE);
		String currentYear = form.getCurrentYear();
		Map<String, Object> populaceMap = populaceService.getTotalCountByYear(new Criteria("COUNT_YEAR", currentYear));
		Criteria criteria = form.toCriteria();
		Map<String, List<DmYearReport>> resultMap = reportServie.getTumorYearReportsByGenger(populaceMap, criteria);
		model.put("cdYearReport", resultMap);
		model.put("populaceMap", populaceMap);
		model.put("currentYear", currentYear);
		setCurrentUesrInfo(model, request);
		return "rhip.cdm.base.report.tumorYearReportByGenderResult";
	}

	@RequestMapping("/tumorYearReport/byAgeReslut")
	public String tumorYearReportByAge(QueryForm form, ModelMap model, HttpServletRequest request) {
		form.setDisType(EHRConstants.DM_TUMOR_TYPE);
		Criteria criteria = form.toCriteria();
		Map<String, List<DmYearReport>> resultMap = reportServie.getTumorYearReportByAge(null, criteria);
		model.put("cdYearReport", resultMap);
		model.put("currentYear", form.getCurrentYear());
		setCurrentUesrInfo(model, request);
		return "rhip.cdm.base.report.tumorYearReportByAgeResult";
	}

	@RequestMapping("/tumorYearReport/deathByGengerReslut")
	public String tumorDeathYearReportsByGenger(QueryForm form, ModelMap model, HttpServletRequest request) {
		form.setDisType(EHRConstants.DM_TUMOR_TYPE);
		String currentYear = form.getCurrentYear();
		Map<String, Object> populaceMap = populaceService.getTotalCountByYear(new Criteria("COUNT_YEAR", currentYear));
		Criteria criteria = form.toCriteria();
		List<DmYearReport> resultMap = reportServie.getTumorDeathYearReportByGenger(populaceMap, criteria);
		model.put("cdYearReport", resultMap);
		model.put("populaceMap", populaceMap);
		model.put("currentYear", currentYear);
		model.put("currentUser", new Date());
		setCurrentUesrInfo(model, request);
		return "rhip.cdm.base.report.tumorDeathYearReportByGenderResult";
	}

	@RequestMapping("/tumorYearReport/deathByAgeReslut")
	public String tumorDeathYearReportByAge(QueryForm form, ModelMap model, HttpServletRequest request) {
		form.setDisType(EHRConstants.DM_TUMOR_TYPE);
		Criteria criteria = form.toCriteria();
		List<DmYearReport> resultMap = reportServie.getTumorDeathYearReportsByAge(null, criteria);
		model.put("cdYearReport", resultMap);
		model.put("currentYear", form.getCurrentYear());
		setCurrentUesrInfo(model, request);
		return "rhip.cdm.base.report.tumorDeathYearReportByAgeResult";
	}

}
