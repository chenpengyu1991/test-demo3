package com.founder.rhip.ihm.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ihm.controller.form.PremaritalCheckStatisticsQueryForm;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.ihm.service.IPremaritalCheckStatisticsService;

/**
 *  男妇婚检统计
 * @author chen_wenbo
 *
 */
@Controller
@RequestMapping("/ihm/fp/")
public class PremaritalCheckStatisticsController{

	@Resource(name = "premaritalCheckStatisticsService")
    private IPremaritalCheckStatisticsService premaritalCheckStatisticsService;
	
	@RequestMapping("/statistics")
	public String statistics(HttpServletRequest request, PremaritalCheckStatisticsQueryForm form,
			Model model) {
		model.addAttribute("listpage", "premaritalCheckStatisticsList.jsp"); //查询结果列表页面
		model.addAttribute("queryPath", "/ihm/fp/statisticslist"); //查询请求路径
		model.addAttribute("currentBeginDate", DateUtil.firstDateOfMonth(new Date()));
        model.addAttribute("currentEndDate",DateUtil.lastDateOfMonth(new Date()));
		return "ihm.fp.statistics";
	}

	/**
	 * 男妇婚检统计
	 * @param request
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping("/statisticslist")
	public String statisticsList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
		
		List<Map<String, Object>> list = premaritalCheckStatisticsService.getstatisticsList(form.getParamMap());
		
		//区分页面的机构类型
		model.addAttribute("genreCodeFlag", "0".equalsIgnoreCase(form.getGenreCode())? "0": "1");
		model.addAttribute("statisticslist", list);
		return "ihm.fp.statisticslist";
	}
}
