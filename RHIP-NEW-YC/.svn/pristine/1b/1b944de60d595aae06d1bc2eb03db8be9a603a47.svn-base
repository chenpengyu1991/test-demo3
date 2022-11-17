package com.founder.rhip.portal.controller;

import com.founder.fasf.beans.*;
import com.founder.rhip.ehr.common.EventType;
import com.founder.rhip.ehr.dto.ExamReportDTO;
import com.founder.rhip.ehr.dto.HealthEventItemDTO;
import com.founder.rhip.ehr.dto.StudyReportDTO;
import com.founder.rhip.ehr.entity.clinic.DrugUsage;
import com.founder.rhip.ehr.entity.clinic.ExamineEvent;
import com.founder.rhip.ehr.entity.clinic.StudyEvent;
import com.founder.rhip.ehr.entity.control.RemindStatistics;
import com.founder.rhip.ehr.service.*;
import com.founder.rhip.ehr.service.personal.IPersonalRecordManagmentService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/userSpace/service")
public class EhrbrowserController extends BaseController {

	@Resource(name = "personalRecordManagmentService")
	private IPersonalRecordManagmentService personalRecordManagmentService;

	@Autowired
	private IPersonalRecordService personalRecordService;

	@Autowired
	private IDrugService drugService;

	@Autowired
	private IExamService examService;

	@Autowired
	private IStudyService studyService;

	@Autowired
	private IHealthEventService healthEventService;

    @Resource(name = "remindStatisticsService")
    private IRemindStatisticsService remindStatisticsService;

    @Resource(name = "organizationApp")
    private IOrganizationApp organizationApp;

	@RequestMapping(value = "/result")
	public String serviceResult( ModelMap model, HttpServletRequest request) {
		/*if (!checkLoginStatus(request)) return "lhportal.info.login";*/
		Long id = this.getPersonId(request);

		if (id == null) {
			return "lhportal.ehr.service.result";
		}

		Page page = new Page(50, 1);
		Criterion criterion = new Criterion("personId", id);

		// 事件活动
		Criteria criteria = new Criteria();
		criteria.addCriterion(criterion);
		Order order = new Order("CLINIC_DATE", false);
		criteria.add("ehrType", OP.IN, Arrays.asList(EventType.INPATIENT.getCode(), EventType.OUTPATIENT.getCode(), EventType.PHYSICAL_EXAMINATION.getCode()));
		PageList<HealthEventItemDTO> HealthEventItem = healthEventService.getMedicalSeviceHealthEventList(page, criteria, order);
		model.addAttribute("healthEventItems", HealthEventItem.getList());
		return "lhportal.ehr.service.result";
	}
    //检验
	@RequestMapping(value = "/lis")
	public String lis( ModelMap model, HttpServletRequest request) {
		Long id = this.getPersonId(request);

		if (id == null) {
			return "lhportal.ehr.service.lis";
		}
		Page page = new Page(50, 1);
		Criterion criterion = new Criterion("personId", id);
		// 检验
		Criteria criteria = new Criteria();
		criteria.addCriterion(criterion);
		Order order = new Order("CHECK_DATE", false);
		PageList<ExamineEvent> examineEvents = examService.getExamEventList(page, criteria, order);
		model.addAttribute("examineEvents", examineEvents.getList());

		return "lhportal.ehr.service.lis";
	}
    //检验详细信息
    @RequestMapping("/lisDetail")
    public String examDetail(HttpServletRequest request,Model model, String ehrId, Long personId, String examinationNumber) {
        Criteria criteria = new Criteria();
        criteria.add("ehrId", ehrId);
        criteria.add("personId", personId);
//		criteria.add("examinationNumber", examinationNumber);
        ExamReportDTO examReportDTO = examService.getExamReport(criteria);
        request.setAttribute("examReport", examReportDTO);
          /* 插入一条记录到检验提醒统计表REMIND_STATISTICS     add by chenqin  */
            RemindStatistics remindSt = new RemindStatistics();
            remindSt.setOrganCode(examReportDTO.getExamineEvent().getHospitalCode());
            Criteria c1 = new Criteria();
            c1.add("organCode", examReportDTO.getExamineEvent().getHospitalCode());
            List<Organization> organization = organizationApp.queryOrganization(c1);
            remindSt.setOrganName(organization.get(0).getOrganName());
            remindSt.setOrgType(organization.get(0).getGenreCode()==null?"":organization.get(0).getGenreCode());
            remindSt.setGbcode(organization.get(0).getGbCode()==null?"":organization.get(0).getGbCode());
            remindSt.setSupOrganCode(organization.get(0).getParentCode()==null?"":organization.get(0).getParentCode());
                    remindSt.setUserCode(examReportDTO.getExamineEvent().getId().toString());
                    remindSt.setUserName(examReportDTO.getExamineEvent().getName());

             remindSt.setCategoryType("8");
             remindSt.setCreateDate(new Date());
             remindStatisticsService.save(remindSt);
             /* 插入一条记录到检验提醒统计表REMIND_STATISTICS */
        return "lhportal.ehr.service.lisReport";
    }

	@RequestMapping(value = "/ris")
	public String ris( ModelMap model, HttpServletRequest request) {
		Long id = this.getPersonId(request);

		if (id == null) {
			return "lhportal.ehr.service.ris";
		}
		Page page = new Page(50, 1);
		Criterion criterion = new Criterion("personId", id);
		// 检查
		Criteria criteria = new Criteria();
		criteria.addCriterion(criterion);
		Order order = new Order("CHECK_DATE", false);
		PageList<StudyEvent> studyEvents = studyService.getStudyEventList(page, criteria,order);
		model.addAttribute("studyEvents", studyEvents.getList());

		return "lhportal.ehr.service.ris";
	}
    //检查详细信息
    @RequestMapping("/risDetail")
    public String inspectDetail(HttpServletRequest request,Model model, String ehrId, Long personId, String id) {
        Criteria criteria = new Criteria();
//		criteria.add("ehrId", ehrId);
//		criteria.add("personId", personId);
        criteria.add("ID", id);
        StudyReportDTO studyReportDTO = studyService.getStudyReport(criteria);
        request.setAttribute("studyReportDTO", studyReportDTO);
        /* 插入一条记录到检查提醒统计表REMIND_STATISTICS     add by chenqin  */
        RemindStatistics remindSt = new RemindStatistics();
        remindSt.setOrganCode(studyReportDTO.getStudyEvent().getHospitalCode());
        Criteria c1 = new Criteria();
        c1.add("organCode", studyReportDTO.getStudyEvent().getHospitalCode());
        List<Organization> organization = organizationApp.queryOrganization(c1);
        remindSt.setOrganName(organization.get(0).getOrganName());
        remindSt.setOrgType(organization.get(0).getGenreCode()==null?"":organization.get(0).getGenreCode());
        remindSt.setGbcode(organization.get(0).getGbCode()==null?"":organization.get(0).getGbCode());
        remindSt.setSupOrganCode(organization.get(0).getParentCode()==null?"":organization.get(0).getParentCode());
        remindSt.setUserCode(studyReportDTO.getStudyEvent().getId().toString());
        remindSt.setUserName(studyReportDTO.getStudyEvent().getName());

        remindSt.setCategoryType("7");
        remindSt.setCreateDate(new Date());
        remindStatisticsService.save(remindSt);
        /* 插入一条记录到检查提醒统计表REMIND_STATISTICS */
        return "lhportal.ehr.service.risReport";
    }
	
	@RequestMapping(value = "/drug")
	public String drug( ModelMap model, HttpServletRequest request) {
		Long id = this.getPersonId(request);

		if (id == null) {
			return "lhportal.ehr.service.drug";
		}
		Page page = new Page(50, 1);
		Criterion criterion = new Criterion("personId", id);

		Criteria criteria = new Criteria();
		criteria.addCriterion(criterion);
		Order order=new Order("START_DATE",false);
		PageList<DrugUsage> drugUsages = drugService.getDrugUsage(page, criteria,order);
		model.addAttribute("drugUsages", drugUsages.getList());
		
		return "lhportal.ehr.service.drug";
	}
    /**
     * map中获取String值 ,null则返回""
     *
     * @param map
     * @param key
     * @return
     */
    private String getFieldValue(Map<String, Object[]> map, String key) {
        if (!map.containsKey(key)) {
            return "";
        }
        return map.get(key)[0].toString();
    }
}
