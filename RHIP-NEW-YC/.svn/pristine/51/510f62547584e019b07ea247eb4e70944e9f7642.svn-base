package com.founder.rhip.vaccine.controller;

import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.idm.controller.form.SchQueryForm;
import com.founder.rhip.idm.service.IApprovalService;
import com.founder.rhip.idm.service.IHaInterfaceService;
import com.founder.rhip.idm.service.ISchistosomeService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.Organization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/vaccine/statistics/report")
public class VaccineReportController extends BaseController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	private static  CustomDateEditor  dateEditor =  
			new CustomDateEditor(new SimpleDateFormat("yyyy/MM/dd"), true);

	@InitBinder
	@Override
	public void initBinder(WebDataBinder binder) {	    
	    binder.registerCustomEditor(Date.class, dateEditor);
	}

	/**
	 * 进入报卡统计首页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request,ModelMap model) {
		return "rhip.vaccine.report.index";
	}
	/**
	 * 进入执行情况自查首页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/selfcheck/index")
	public String selfcheckIndex(HttpServletRequest request,ModelMap model) {
		/*防疫科显示所有机构数据*/
		if (hasRole(RoleType.JKYFJZ, request)){
			model.addAttribute("RoleType", "JKYFJZ");
		}
		return "rhip.vaccine.statistics.report.selfcheck.index";
	}	

	/**
	 * 进入传染病管理月报表首页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/monthReport/index")
	public String monthReportIndex(HttpServletRequest request,ModelMap model) {
		return "rhip.vaccine.report.monthReport.index";
	}
	
	/**
	 * 进入急性传染病防治首页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/acuteReport/index")
	public String acuteReportIndex(HttpServletRequest request,ModelMap model) {
		return "rhip.vaccine.report.acuteReport.index";
	}	
}
