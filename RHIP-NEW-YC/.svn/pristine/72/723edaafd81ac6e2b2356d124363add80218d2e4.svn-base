package com.founder.rhip.idm.controller.statistics.report;

import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.mdm.entity.Organization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/idm/statistics/report")
public class StatisticsController extends BaseController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	private static  CustomDateEditor  dateEditor =  
			new CustomDateEditor(new SimpleDateFormat("yyyy/MM/dd"), true);

	@InitBinder
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
	public String index(HttpServletRequest request, ModelMap model) {
		return "rhip.idm.statistics.report.index";
	}
	
	/**
	 * 进入传染病管理及督导首页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/supervisor/index")
	public String supervisorIndex(HttpServletRequest request, ModelMap model) {
		/*防疫科显示所有机构数据*/
		if (hasRole(RoleType.JKFYK, request)){
			model.addAttribute("RoleType", "JKFYK");
		}
		return "rhip.idm.statistics.report.supervisor.index";
	}
	
	/**
	 * 进入执行情况自查首页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/selfcheck/index")
	public String selfcheckIndex(HttpServletRequest request, ModelMap model) {
		/*防疫科显示所有机构数据*/
		if (hasRole(RoleType.JKFYK, request)){
			model.addAttribute("RoleType", "JKFYK");
		}
		return "rhip.idm.statistics.report.selfcheck.index";
	}	
	
	/**
	 * 进入手足口病采样登记首页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/takeSample/index")
	public String takeSampleIndex(HttpServletRequest request, ModelMap model) {
		/*根据当前机构，设置页面中的上报机构*/
		Organization org = getCurrentOrg(request);
		String currentOrgCode = org.getOrganCode();

		/*防疫科显示所有机构数据*/
		if (!hasRole(RoleType.JKFYK, request)){
			model.addAttribute("reportUnitCode", currentOrgCode);
		}else{
			model.addAttribute("RoleType", "JKFYK");
		}		
		
		return "rhip.idm.statistics.report.takeSample.search";
	}
	
	/**
	 * 进入传染病管理月报表首页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/monthReport/index")
	public String monthReportIndex(HttpServletRequest request, ModelMap model) {
		return "rhip.idm.statistics.report.monthReport.index";
	}
	
	/**
	 * 进入急性传染病防治首页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/acuteReport/index")
	public String acuteReportIndex(HttpServletRequest request, ModelMap model) {
		return "rhip.idm.statistics.report.acuteReport.index";
	}	
}
