package com.founder.rhip.ehr.controller.medicalservice;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.controller.EhrBaseController;
import com.founder.rhip.ehr.dto.ExamReportDTO;
import com.founder.rhip.ehr.entity.clinic.ExamineEvent;
import com.founder.rhip.ehr.service.IExamService;

/**
 * 检验
 * 
 * @author liuk
 * 
 */
@Controller
@RequestMapping("/exam")
public class ExamController extends EhrBaseController{
	@Autowired
	private IExamService examService;

	private static Logger log = Logger.getLogger(ExamController.class);

	@RequestMapping("/search")
	public String search(@RequestParam(value = "personId", required = false) Long personId, Model model) {
		model.addAttribute("personId", personId);
		return "rhip.ehr.exam.list";
	}

	@RequestMapping("/result")
	public String search(@RequestParam(value = "org", required = false) String org, @RequestParam(value = "startDate", required = false) String startDateStr,
			@RequestParam(value = "timeType", defaultValue = "1", required = false) String timeType, @RequestParam(value = "personId", required = false) String smpiId, HttpServletRequest request) {
		Criteria criteria = new Criteria();
		// 当前人
		if (ObjectUtil.isNotEmpty(smpiId)) {
			criteria.add("personId", smpiId);
		}
		// 机构
		if (ObjectUtil.isNotEmpty(org)) {
			criteria.add("hospitalName", OP.LIKE, org);
		}

        if (isLimitEnabled()){
            criteria.add("hospitalCode",OP.NOTIN,getLimitedOrganCode());
        }
        criteria.add("IS_LIMIT",OP.LT,1);
		// 日期
		Date startDate = null;// 开始日期
		if (ObjectUtil.isNotEmpty(startDateStr)) {
			startDate = DateUtil.parseSimpleDate(startDateStr, "yyyy/MM/dd");
		}
		if (null == startDate) {
			DateUtil.setStartDateRange(criteria, timeType.trim(), "checkDate");
		} else {
			criteria.add("checkDate",OP.BETWEEN,new Object[]{DateUtil.makeTimeToZero(startDate),DateUtil.makeTimeToMax(startDate)});
		}

		Order order = new Order("CHECK_DATE",false).desc("rowid");
		PageList<ExamineEvent> examineEvents = examService.getExamEventList(buildPage(request), criteria, order);
		request.setAttribute("examineEvents", examineEvents.getList());
		return "rhip.ehr.exam.result";
	}

	@RequestMapping("/report/{id}")
	public String getExamEventWithDetalil(@PathVariable("id") Long id, HttpServletRequest request) {
		// 选中的检验数据
		Criteria criteria = new Criteria("id", id);
		ExamReportDTO examReportDTO = examService.getExamReport(criteria);
		request.setAttribute("examReport", examReportDTO);
		return "rhip.ehr.exam.report";
	}

}
