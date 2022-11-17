package com.founder.rhip.ehr.controller.medicalservice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.dto.ExamReportDTO;
import com.founder.rhip.ehr.dto.OutpatientReportDTO;
import com.founder.rhip.ehr.entity.clinic.DrugUsage;
import com.founder.rhip.ehr.entity.clinic.EHRHealthEvent;
import com.founder.rhip.ehr.service.IDrugService;
import com.founder.rhip.ehr.service.IExamService;
import com.founder.rhip.ehr.service.IHealthEventService;
import com.founder.rhip.ehr.service.IOutpatientService;

/**
 * 门诊
 * @author gaogf
 *
 */

@Controller
@RequestMapping("/outpatient")
public class OutpatientController extends BaseController{
	@Autowired
	private IOutpatientService outpatientService;
	
	@Autowired
	private IHealthEventService healthEventService;
	
	@Autowired
	private IDrugService drugService;
	
	@Autowired
	private IExamService examService;
	
	/** 处方 */
	@RequestMapping("/drugReport/{id}")
	public String drugReport(
			@PathVariable(value = "id")String id,
			HttpServletRequest request){
		
		Criteria criteria = new Criteria();
		criteria.add("id", id);
		EHRHealthEvent ehrHealthEvent = healthEventService.getEHRHealthEvent(criteria);
		criteria.remove("id");
		criteria = new Criteria();
		criteria.add("ehrId",ehrHealthEvent.getEhrId());
		criteria.add("personId", ehrHealthEvent.getPersonId());
		OutpatientReportDTO outpatientReportDTO = outpatientService.getOutpatientDrugDetail(criteria);
		request.setAttribute("outpatientReportDTO", outpatientReportDTO);
		return "rhip.ehr.outpatient.drugReport";
	}
	
	/** 门诊 */
	@RequestMapping("/detailReport/{personId}/{ehrId}")
	public String detailReport(
			@PathVariable(value="personId") String personId,
			@PathVariable(value="ehrId") String ehrId,
			HttpServletRequest request){
		Criteria criteria = new Criteria();
		if(ObjectUtil.isNotEmpty(personId)){
			criteria.add("personId", personId);
		}
		if(ObjectUtil.isNotEmpty(ehrId)){
			criteria.add("ehrId", ehrId);
		}
		OutpatientReportDTO outpatientReportDTO = outpatientService.getOutpatientReportDetail(criteria);
		List<ExamReportDTO> examReportDtos = examService.getExamEventWithDetailList(criteria);
		List<DrugUsage> drugUsages = drugService.getDrugUsages(criteria,"unitPrice","subtotal","quantityUnit", "quantity", "drugTradeName", "drugGenericName", "drugSpecifications");
		request.setAttribute("examReportsDtos", examReportDtos);
		request.setAttribute("drugUsages", drugUsages);
		request.setAttribute("outpatientReportDTO", outpatientReportDTO);
		return "rhip.ehr.outpatient.detailReport";
	}
	
	/** 处方信息*/
	@RequestMapping("/detailDrug/{drugType}")
	public String detailDrug(
			@RequestParam(value="personId", required = false) String personId,
			@RequestParam(value="ehrId", required = false) String ehrId,
			@PathVariable(value="drugType") String drugType,
			HttpServletRequest request){
		Criteria criteria = new Criteria();
		if(ObjectUtil.isNotEmpty(personId)){
			criteria.add("personId", personId);
		}
		if(ObjectUtil.isNotEmpty(ehrId)){
			criteria.add("ehrId", ehrId);
		}
		if(ObjectUtil.isNotEmpty(drugType)){
			criteria.add("drugType", drugType);
		}
		OutpatientReportDTO outpatientReportDTO = outpatientService.getOutpatientDrugDetail(criteria);
		request.setAttribute("outpatientReportDTO", outpatientReportDTO);
		return "rhip.ehr.outpatient.detailDrug";
	}
}
