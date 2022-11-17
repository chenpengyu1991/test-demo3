package com.founder.rhip.ehr.controller.medicalservice;

import javax.servlet.http.HttpServletRequest;

import com.founder.fasf.beans.OP;
import com.founder.rhip.ehr.controller.EhrBaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.controller.FlashScope;
import com.founder.rhip.ehr.dto.StudyReportDTO;
import com.founder.rhip.ehr.entity.clinic.StudyEvent;
import com.founder.rhip.ehr.service.IStudyService;

/**
 * 检查
 * 
 * @author liuk
 * 
 */
@Controller
@RequestMapping("/study")
public class StudyController extends EhrBaseController{
	@Autowired
	private IStudyService studyService;
	
	private static Logger log = Logger.getLogger(StudyController.class);

	
	@RequestMapping("/search")
	public String search(@RequestParam(value = "personId", required = false) Long personId,Model model) {
		model.addAttribute("personId", personId);
		return "rhip.ehr.study.search";
	}

	@RequestMapping("/result")
	public String search(@RequestParam(value = "timeType", defaultValue = "1") String timeType, @RequestParam(value = "personId", required = false) String smpiId, HttpServletRequest request) {
		Criteria criteria = new Criteria();
		// 当前人
		if (ObjectUtil.isNotEmpty(smpiId)) {
			criteria.add("personId", smpiId);
		}

        if (isLimitEnabled()){
            criteria.add("hospitalCode", OP.NOTIN,getLimitedOrganCode());
        }
        criteria.add("IS_LIMIT",OP.LT,1);
        DateUtil.setStartDateRange(criteria, timeType.trim(), "checkDate");
		Order	order=new Order("CHECK_DATE",false).desc("rowid");
		PageList<StudyEvent> studyEvents = studyService.getStudyEventList(buildPage(request), criteria,order);
		request.setAttribute("studyEvents", studyEvents.getList());
		return "rhip.ehr.study.result";
	}

	@RequestMapping("/report/{id}")
	public String getExamSheet(@PathVariable("id") Long id, HttpServletRequest request) {
		Criteria criteria = new Criteria();
		criteria.add("id", id);
		StudyReportDTO studyReportDTO = studyService.getStudyReport(criteria);
		if(null == studyReportDTO){
			FlashScope.getCurrent(request).put("message", "没有检查数据");
		}else {
			request.setAttribute("studyReportDTO", studyReportDTO);
		}
		return "rhip.ehr.study.report";
	}

}
