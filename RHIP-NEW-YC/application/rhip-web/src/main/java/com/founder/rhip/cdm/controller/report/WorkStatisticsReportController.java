package com.founder.rhip.cdm.controller.report;

import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.cdm.controller.CdmBaseController;
import com.founder.rhip.cdm.service.ICdMonthSeasonStatisticsService;
import com.founder.rhip.cdm.service.ICdmWorkStatisticsReportService;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.statisticsdto.DmManageAndFollowup;
import com.founder.rhip.ehr.statisticsdto.TumorMonthSeasonReport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 工作统计
 * 
 * @author liuk
 * 
 */
@Controller
@RequestMapping("/cdm/statistics")
public class WorkStatisticsReportController extends CdmBaseController {

	@Resource
	private ICdmWorkStatisticsReportService cdmWorkStatisticsReportService;

	@Resource(name = "cdMonthSeasonStatisticsService")
	private ICdMonthSeasonStatisticsService cdMonthSeasonStatisticsService;

	@RequestMapping("/workStatistics")
	public String workStatistics(ModelMap model) {
		Date currentDate=new Date();
		model.put("currentDate", currentDate);
		model.put("defaultBeginDate", DateUtil.add(currentDate, Calendar.MONTH, -1));
		return "rhip.cdm.base.report.workStatistics";
	}

	
	private void setDefaultParam(QueryForm form, HttpServletRequest request) {
		RoleType roleType=getRole(request);
		if (roleType.equals(RoleType.ZXMB)) {
			String organCode=getCurrentOrg(request).getOrganCode();
			form.setOrganCode(organCode);
		}
	}
	
	@RequestMapping("/workStatistics/cdMoSeReport/reslut")
	public String cdMoSeReport(QueryForm form, ModelMap model, HttpServletRequest request) {
		setDefaultParam(form, request);
		String year = form.getCurrentYear();
		String month = form.getCurrentMonth();
		String type = form.getTimeType();
		String organCode = form.getOrganCode();
		String gbCode=form.getGbCode();

		RoleType roleType=getRole(request);
		if (roleType.equals(RoleType.ZMB)) {
			organCode=getCurrentOrg(request).getOrganCode();
		}

		List<Map<String, Object>> result = cdMonthSeasonStatisticsService.getCdMonthReport(type, gbCode,organCode, month, year);
		model.put("isGbcode", ObjectUtil.isNullOrEmpty(organCode)&& ObjectUtil.isNullOrEmpty(gbCode));
		model.put("cdMonthReport", result);
		model.put("currentYear", year);
		model.put("currentMonth", month);
		setCurrentUesrInfo(model, request);
		return "rhip.cdm.base.report.cdMonthReportResult";
	}

	@RequestMapping("/workStatistics/cdSeasonReport/reslut")
	public String cdSesonReport(QueryForm form, ModelMap model, HttpServletRequest request) {
		setDefaultParam(form, request);
		String year = form.getCurrentYear();
		String season = form.getCurrentSeason();
		String type = form.getTimeType();
		String organCode = form.getOrganCode();
		String gbCode=form.getGbCode();
		List<Map<String, Object>> result = cdMonthSeasonStatisticsService.getCdSeasonReport(type,gbCode, organCode, season, year);
		model.put("isGbcode", ObjectUtil.isNullOrEmpty(organCode)&& ObjectUtil.isNullOrEmpty(gbCode));
		model.put("cdMonthReport", result);
		model.put("currentYear", year);
		model.put("currentSeason", season);
		setCurrentUesrInfo(model, request);
		return "rhip.cdm.base.report.cdSesonReportResult";
	}
	
	@RequestMapping("/workStatistics/tumorMonthReport/reslut")
	public String tumorMonthReport(QueryForm form, ModelMap model, HttpServletRequest request) {
		setDefaultParam(form, request);
		String year = form.getCurrentYear();
		String month = form.getCurrentMonth();
		String type = form.getTimeType();
		String organCode = form.getOrganCode();
		String gbCode=form.getGbCode();

		RoleType roleType=getRole(request);
		if (roleType.equals(RoleType.ZMB)) {
			organCode=getCurrentOrg(request).getOrganCode();
		}

		TumorMonthSeasonReport result = cdMonthSeasonStatisticsService.getTumorMonthReport(type,gbCode, organCode, month, year);
		model.put("isGbcode", ObjectUtil.isNullOrEmpty(organCode)&& ObjectUtil.isNullOrEmpty(gbCode));
		model.put("cdMonthReport", result.getReports());
		model.put("malignants", result.getMalignants());
		model.put("nonMalignants",result.getNonMalignants());
		model.put("currentYear", year);
		model.put("currentMonth", month);
		setCurrentUesrInfo(model, request);
		return "rhip.cdm.base.report.tumorMonthReportResult";
	}

	@RequestMapping("/workStatistics/tumorSeasonReport/reslut")
	public String tumorSeasonReport(QueryForm form, ModelMap model, HttpServletRequest request) {
		setDefaultParam(form, request);
		String year = form.getCurrentYear();
		String season = form.getCurrentSeason();
		String type = form.getTimeType();
		String organCode = form.getOrganCode();
		String gbCode=form.getGbCode();
		TumorMonthSeasonReport result = cdMonthSeasonStatisticsService.getTumorSeasonReport(type,gbCode, organCode, season, year);
		model.put("isGbcode", ObjectUtil.isNullOrEmpty(organCode)&& ObjectUtil.isNullOrEmpty(gbCode));
		model.put("cdMonthReport", result.getReports());
		model.put("malignants", result.getMalignants());
		model.put("nonMalignants",result.getNonMalignants());
		model.put("currentYear", year);
		model.put("currentSeason", season);
		setCurrentUesrInfo(model, request);
		return "rhip.cdm.base.report.tumorSesonReportResult";
	}

	@RequestMapping("/tumorPathologyResult")
	public String tumorPathology(QueryForm form,ModelMap model,  HttpServletRequest request) {
		setDefaultParam(form, request);
		String beginDate = form.getBeginDate();
		String endDate =form.getEndDate();
		String gbCode = form.getGbCode();
		String orgCode=form.getOrganCode();
		List<Map<String, Object>> cdmWorkStatistice = cdmWorkStatisticsReportService.searchTumorPathologyResult(beginDate, endDate, gbCode,orgCode);
		setCurrentUesrInfo(model, request);
		model.addAttribute("cdmWorkStatistice", cdmWorkStatistice);
		model.addAttribute("beginDate", stringConcatenation(beginDate));
		model.addAttribute("endDate", stringConcatenation(endDate));
		return "rhip.cdm.base.report.tumorPathology";
	}

	@RequestMapping("/manageAndFollowup")
	public String manageAndFollowupResult(ModelMap model, HttpServletRequest request) {
		String beginAge = request.getParameter("mafr_beginAge");
		String endAge = request.getParameter("mafr_endAge");
		String gBCode = request.getParameter("gbCode");
		String centreCode = request.getParameter("centreCode");
		String stationCode = request.getParameter("stationCode");
		String cdmType = request.getParameter("cdmType");
		
		RoleType roleType=getRole(request);
		if (roleType.equals(RoleType.ZXMB)) {
			 centreCode=getCurrentOrg(request).getOrganCode();
		}else if (roleType.equals(RoleType.ZMB)) {
			stationCode=getCurrentOrg(request).getOrganCode();
		}
		
		List<DmManageAndFollowup> dmManageAndFollowup = cdmWorkStatisticsReportService.searchManageAndFollowup(beginAge, endAge, gBCode,centreCode, stationCode, cdmType);
		setCurrentUesrInfo(model, request);
		model.addAttribute("dmManageAndFollowup", dmManageAndFollowup);
		model.addAttribute("beginAge", stringConcatenation(beginAge));
		model.addAttribute("endAge", stringConcatenation(endAge));
		return "rhip.cdm.base.report.manageAndFollowup";
	}
	public String stringConcatenation(String date){
		if(ObjectUtil.isNullOrEmpty(date)){
			return "-";
		}
		String[] dateArray = date.split("/");
		String stringDate = dateArray[0]+"年"+dateArray[1]+"月"+dateArray[2]+"日";
		return stringDate;	
	}
	private void setCurrentUesrInfo(ModelMap model, HttpServletRequest request) {
		model.put("currentDate", new Date());
		model.put("currentUserName", getCurrentUser(request).getName());
		model.put("currentOrgName", getCurrentOrg(request).getOrganName());
	}
}
