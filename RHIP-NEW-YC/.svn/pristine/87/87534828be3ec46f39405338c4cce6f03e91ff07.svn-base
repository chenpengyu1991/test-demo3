package com.founder.rhip.ehr.controller.medicalservice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.dto.ClinicalChartBasicInfoDTO;
import com.founder.rhip.ehr.dto.ClinicalChartDataDTO;
import com.founder.rhip.ehr.dto.ClinicalChartParam;
import com.founder.rhip.ehr.dto.ExamReportDTO;
import com.founder.rhip.ehr.dto.InpatientItemDTO;
import com.founder.rhip.ehr.dto.InpatientMedicalRecordDto;
import com.founder.rhip.ehr.dto.InpatientSummaryDTO;
import com.founder.rhip.ehr.dto.OuthostpitalSummaryDTO;
import com.founder.rhip.ehr.entity.clinic.InpatientInfo;
import com.founder.rhip.ehr.entity.clinic.StudyEvent;
import com.founder.rhip.ehr.service.IExamService;
import com.founder.rhip.ehr.service.IInpatientDataService;

/**
 * 住院
 * 
 * @author liuk
 * 
 */
@Controller
@RequestMapping("/inpatient")
public class InpatientDataController extends BaseController {
	private static Logger log = Logger.getLogger(ExamController.class);
	@Autowired
	private IInpatientDataService inpatientDataService;
	@Autowired
	private IExamService examService;

	@RequestMapping("/search")
	public String search() {
		return "rhip.ehr.inpatient.search";
	}

	@RequestMapping("/result")
	public String searchResult(@RequestParam(value = "timeType", defaultValue = "1") String timeType, @RequestParam(value = "personId", required = false) String smpiId, HttpServletRequest request,
			Model model) {
		Criteria criteria = new Criteria();
		// pix
		if (ObjectUtil.isNotEmpty(smpiId)) {
			criteria.add("personId", smpiId);
		}
		DateUtil.setStartDateRange(criteria, timeType.trim(), "inhosDate");
		PageList<InpatientItemDTO> inpatientItemDTOs = inpatientDataService.getInpatientList(buildPage(request), criteria);
		model.addAttribute("inpatientItems", inpatientItemDTOs.getList());
		return "rhip.ehr.inpatient.result";
	}

	/**
	 * 获取临床图表基本信息
	 * 
	 * @param ehrIndexId
	 *            医疗活动的id
	 * @param model
	 * @return
	 */
	@RequestMapping("/chart/{ehrIndexId}")
	public String getChartBasicInfo(@PathVariable("ehrIndexId") Long ehrIndexId, Model model) {
		Criteria criteria = new Criteria("id", ehrIndexId);
		ClinicalChartBasicInfoDTO clinicalChartBasicInfo = inpatientDataService.getClinicalChartBasicInfo(criteria);
		model.addAttribute("clinicalChartBasicInfo", clinicalChartBasicInfo);
		return "rhip.ehr.inpatient.chart";
	}

	/**
	 * 获取临床图表数据
	 * 
	 * @param id
	 *            住院摘要id
	 * @param week
	 * @param model
	 * @return
	 */
	@RequestMapping("/chartdata/id/{id}/week/{week}")
	public String getChartData(@PathVariable("id") Long id, @PathVariable("week") Integer week, Model model) {
		ClinicalChartParam clinicalChartParam = new ClinicalChartParam(id, week);
		ClinicalChartDataDTO clinicalChartData = inpatientDataService.getClinicalChart(clinicalChartParam);
		model.addAttribute("clinicalChartData", clinicalChartData);
		return "rhip.ehr.inpatient.chartdata";
	}

	/**
	 * 获取住院摘要
	 * 
	 * @param id
	 *            住院摘要id
	 * @param model
	 * @return
	 */
	@RequestMapping("/summary/{id}")
	public String getSummary(@PathVariable("id") Long id, Model model) {
		InpatientSummaryDTO inpatientSummary = inpatientDataService.getInpatientSummary(new Criteria("id", id));
		// 获取相关的检验数据
		List<StudyEvent> studyEvent = null;
		List<ExamReportDTO> examReportDtos = null;
		if (null != inpatientSummary) {
			studyEvent = inpatientSummary.getStudyEvents();
			InpatientInfo inpatientInfo = inpatientSummary.getInpatientInfo();
			if (null != inpatientInfo) {
				Criteria paramCriteria = new Criteria();
				paramCriteria.add("ehrId", inpatientInfo.getEhrId());
				paramCriteria.add("personId", inpatientInfo.getPersonId());
				examReportDtos = examService.getExamEventWithDetailList(paramCriteria);
			}
		}
		model.addAttribute("examReportsDtos", examReportDtos);
		model.addAttribute("studyEvents", studyEvent);
		model.addAttribute("inpatientSummary", inpatientSummary);
		return "rhip.ehr.inpatient.summary";
	}

	/**
	 * 获取病案首页
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/cindex/{id}")
	public String cIndex(@PathVariable("id") Long id, Model model) {
		Criteria paramCriteria = new Criteria();
		paramCriteria.add("id", id);
		InpatientMedicalRecordDto inpatientMedicalRecordDto = inpatientDataService.getMedicalIndex(paramCriteria);
		model.addAttribute("inpatientMedicalRecordDto", inpatientMedicalRecordDto);
		return "rhip.ehr.inpatient.cindex";
	}

	/**
	 * 出院小结
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/detail/{id}")
	public String getOutHostpitalSummary(@PathVariable("id") Long id, HttpServletRequest request) {
		Criteria criteria = new Criteria();
		criteria.add("id", id);
		OuthostpitalSummaryDTO outhospitalSummaryDto = inpatientDataService.getOuthospitalSummary(criteria);
		request.setAttribute("outhospitalSummaryDto", outhospitalSummaryDto);
		return "rhip.ehr.inpatient.outhospitalsummary";
	}
}
