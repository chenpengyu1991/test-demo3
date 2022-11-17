package com.founder.rhip.ihm.controller.dm;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.founder.rhip.ihm.service.IDmStatisticsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ihm.controller.IHMBaseController;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.ihm.service.IEhrRecordStatisticsService;

/**
 * 疾病管理
 * 
 * @author liuk
 * @since 2014年5月30日 16:59:13
 */
@Controller
@RequestMapping("/ihm/dm")
public class DmTargetController extends IHMBaseController {

	@Resource(name = "dmStatisticsService")
	private IDmStatisticsService dmStatisticsService;

	/**
	 * Record string.
	 * 
	 * @return the string
	 */
	@RequestMapping("/cdm")
	public String record(Model model) {
		Date today = new Date();
		Date startDate = DateUtil.firstDateOfMonth(today);
		model.addAttribute("currentBeginDate", startDate);
		model.addAttribute("currentEndDate", today);
		model.addAttribute("searchUrl", "/ihm/dm/cdm/result");
		// 不需要按市级医院查询
        model.addAttribute("listpath","dmTarget/cdm/datagrid.jsp");
		model.addAttribute("hospitalFlag", 1);
		return "ihm.dm.cdm.main";
	}

	@RequestMapping("/cdm/result")
	public String recordResult(TargetOrgQueryForm form, Model model) {
		form.calTime();
		Date begin = ObjectUtil.isNotEmpty(form.getBeginDate()) ? DateUtil.parseSimpleDate(form.getBeginDate(), "yyyy/MM/dd") : null;
		Date end = ObjectUtil.isNotEmpty(form.getEndDate()) ? DateUtil.parseSimpleDate(form.getEndDate().trim()+" 23:59:59.999", "yyyy/MM/dd HH:mm:ss.S") : null;
		List<Map<String, Object>> data = dmStatisticsService.getCdmStatisticsData(form.getGenreCode(), form.getGbCode(), form.getSuperOrganCode(), form.getOrganCode(), begin, end);
		model.addAttribute("data", data);
		return "ihm.dm.cdm.reslut";
	}

}
