package com.founder.rhip.ehr.controller.medicalservice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.founder.rhip.ehr.entity.clinic.SecrecyDegreeSet;
import com.founder.rhip.ehr.service.ISecrecyDegreeService;
import com.founder.rhip.mdm.entity.Organization;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.EventType;
import com.founder.rhip.ehr.controller.EhrBaseController;
import com.founder.rhip.ehr.dto.HealthEventItemDTO;
import com.founder.rhip.ehr.service.IHealthEventService;

/**
 * 医疗活动
 * 
 * @author liuk
 * 
 */
@Controller
@RequestMapping("/healthevent")
public class HealthEventController extends EhrBaseController{
	@Autowired
	private IHealthEventService healthEventService;

	@Autowired
	private ISecrecyDegreeService secrecyDegreeService;

	
	private static Logger log = Logger.getLogger(HealthEventController.class);

	@RequestMapping("/search")
	public String search(@RequestParam(value = "personId", required = false) Long personId,Model model) {
		model.addAttribute("personId", personId);
		return "rhip.ehr.healthevent.search";
	}

	@RequestMapping("/result")
	public String search(@RequestParam(value = "timeType", defaultValue = "1") String timeType, @RequestParam(value = "ehrType", defaultValue = "50") String ehrType,
			@RequestParam(value = "personId", required = false) String smpiId, HttpServletRequest request) {
		Criteria criteria = new Criteria();
		//删除标志,add by yejianfei 20140801 ,IS_DELETE<>1
		Criteria deleteCriteria = new Criteria("IS_DELETE",OP.NE,EHRConstants.DELETE_FLG_1);
		deleteCriteria.add(LOP.OR,"IS_DELETE",OP.IS,"NULL");
		criteria.add(deleteCriteria);
		/* 当前选中人的smpiId */
		if (ObjectUtil.isNotEmpty(smpiId)) {
			criteria.add("personId", smpiId);
		}

        if (isLimitEnabled()){
            criteria.add("clinicOrganCode",OP.NOTIN,getLimitedOrganCode());
        }
//		criteria.add("IS_LIMIT",OP.LT,1);
		//传染病保密设置
		Criteria limitc = new Criteria("IS_LIMIT", OP.IS, "NULL").add(LOP.OR, "IS_LIMIT", OP.NE, 1);
		SecrecyDegreeSet secrecyDegreeSet = getSecrecyDegreeSet(request);
		//如果没有设置保密等级，默认不可见
		if(ObjectUtil.isNotEmpty(secrecyDegreeSet)){
			Integer degree = secrecyDegreeSet.getSecrecyDegree();
			//传染病保密等级中，1:可见，2：不可见
			if(Integer.valueOf(2).equals(degree)){
				criteria.add(limitc);
			}
		}else{
			criteria.add(limitc);
		}
		/* 时间间隔 */
		DateUtil.setStartDateRange(criteria, timeType.trim(), "clinicDate");

		/* 活动类型,默认全部 */
		// 住院 门诊 体检
		if (EventType.INPATIENT.getCode().equals(ehrType) || EventType.OUTPATIENT.getCode().equals(ehrType) ) {
			criteria.add("ehrType", ehrType);
		} else if (EventType.PHYSICAL_EXAMINATION.getCode().equals(ehrType)) {
			criteria.add("ehrType", OP.IN, Arrays.asList(EventType.PHYSICAL_EXAMINATION.getCode(),
					EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode(), EventType.OTHER_PHYSICAL_EXAMINATION.getCode(),EventType.HEALTH_CERTIFICATE_EXAMINATION.getCode(),EventType.EMPLOYEE_PHYSICAL_EXAMINATION.getCode(),
					EventType.COMMERCIAL_PHYSICAL_EXAMINATION.getCode(),EventType.STUDENT_PHYSICAL_EXAMINATION.getCode(),
					EventType.WOMEN_PHYSICAL_EXAMINATION.getCode(), EventType.OCCUPATION_PHYSICAL_EXAMINATION.getCode(),EventType.CHRONIC_DISEASE_PHYSICAL_EXAMINATION.getCode()));
		} else{
			criteria.add("ehrType", OP.IN, Arrays.asList(EventType.OUTPATIENT.getCode(),EventType.INPATIENT.getCode(),EventType.PHYSICAL_EXAMINATION.getCode(),
					EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode(), EventType.OTHER_PHYSICAL_EXAMINATION.getCode(),EventType.HEALTH_CERTIFICATE_EXAMINATION.getCode(),EventType.EMPLOYEE_PHYSICAL_EXAMINATION.getCode(),
					EventType.COMMERCIAL_PHYSICAL_EXAMINATION.getCode(), EventType.STUDENT_PHYSICAL_EXAMINATION.getCode(),
					EventType.WOMEN_PHYSICAL_EXAMINATION.getCode(), EventType.OCCUPATION_PHYSICAL_EXAMINATION.getCode(),
					EventType.CHRONIC_DISEASE_PHYSICAL_EXAMINATION.getCode()));
		}
		Order order=new Order("CLINIC_DATE",false).desc("rowid");
		PageList<HealthEventItemDTO> studyEvents = healthEventService.getMedicalSeviceHealthEventList(buildPage(request), criteria,order);
		request.setAttribute("healthEventItems", studyEvents.getList());
		return "rhip.ehr.healthevent.result";
	}

	@RequestMapping("/resultForPhysical")
	public String searchForPhysical(@RequestParam(value = "timeType", defaultValue = "1") String timeType, @RequestParam(value = "ehrType", defaultValue = "50") String ehrType,
									@RequestParam(value = "personId", required = false) String smpiId, HttpServletRequest request) {
		Criteria criteria = new Criteria();
		//删除标志,add by yejianfei 20140801 ,IS_DELETE<>1
		Criteria deleteCriteria = new Criteria("IS_DELETE",OP.NE,EHRConstants.DELETE_FLG_1);
		deleteCriteria.add(LOP.OR,"IS_DELETE",OP.IS,"NULL");
		criteria.add(deleteCriteria);
		/* 当前选中人的smpiId */
		if (ObjectUtil.isNotEmpty(smpiId)) {
			criteria.add("personId", smpiId);
		}

		if (isLimitEnabled()){
			criteria.add("clinicOrganCode",OP.NOTIN,getLimitedOrganCode());
		}
		criteria.add("IS_LIMIT",OP.LT,1);
		/* 时间间隔 */
//		DateUtil.setStartDateRange(criteria, timeType.trim(), "clinicDate");

		criteria.add("ehrType", OP.IN, Arrays.asList(EventType.PERSON_RECORD_PHYSICIAL_EXAM.getCode(),EventType.PHYSICAL_EXAMINATION.getCode(),
				EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode(), EventType.OTHER_PHYSICAL_EXAMINATION.getCode(),EventType.HEALTH_CERTIFICATE_EXAMINATION.getCode(),EventType.EMPLOYEE_PHYSICAL_EXAMINATION.getCode(),
				EventType.COMMERCIAL_PHYSICAL_EXAMINATION.getCode(),EventType.STUDENT_PHYSICAL_EXAMINATION.getCode(),
				EventType.WOMEN_PHYSICAL_EXAMINATION.getCode(), EventType.OCCUPATION_PHYSICAL_EXAMINATION.getCode(),EventType.CHRONIC_DISEASE_PHYSICAL_EXAMINATION.getCode()));

		Order order=new Order("CLINIC_DATE",false).desc("rowid");
		PageList<HealthEventItemDTO> studyEvents = healthEventService.getMedicalSeviceHealthEventList(buildPage(request), criteria,order);
		request.setAttribute("healthEventItems", studyEvents.getList());
		return "rhip.ehr.healthevent.resultForPhysical";
	}

	@RequestMapping("/report/type/{type}/ehrid/{ehrid}/pix/{pix}")
	public String getReport(HttpServletRequest request) {
		return "rhip.ehr.healthevent.report";
	}

	/**
	 * 获取当前机构的传染病保密登记设置
	 * @param request
	 * @return
	 */
	private SecrecyDegreeSet getSecrecyDegreeSet(HttpServletRequest request){
		Organization currentOrg = getCurrentOrg(request);
		String organCode = "";
		if(ObjectUtil.isNullOrEmpty(currentOrg)){
			Map<String, String> explorerInfo = (HashMap)request.getSession().getAttribute("explorerInfo");
			organCode = explorerInfo.get("viewOrganCode");
		}else{
			organCode = getCurrentOrg(request).getOrganCode();
		}
		Criteria criteria = new Criteria("ORGAN_CODE",organCode);
		return  secrecyDegreeService.getSecrecyDegree(criteria);

	}

}
