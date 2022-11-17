package com.founder.rhip.idm.controller.statistics.report;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.control.idm.statistics.report.Supervisor;
import com.founder.rhip.idm.controller.form.ReportStatisticsQueryForm;
import com.founder.rhip.idm.service.IReportStatisticsService;
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
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/idm/statistics/report/supervisor")
public class SupervisorController extends BaseController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "reportStatisticsService")
	private IReportStatisticsService reportStatisticsService;
	
    
	private static  CustomDateEditor  dateEditor =  
			new CustomDateEditor(new SimpleDateFormat("yyyy/MM/dd"), true);

	@InitBinder
	public void initBinder(WebDataBinder binder) {	    
	    binder.registerCustomEditor(Date.class, dateEditor);
	}
	/**
	 * 进入传染病管理及督导-填写查询画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/fillSearch")
	public String fillSearch(HttpServletRequest request, ModelMap model) {
		/*根据当前机构，设置页面中的上报机构*/
		Organization org = getCurrentOrg(request);
		String currentOrgCode = org.getOrganCode();

		/*防疫科显示所有机构数据*/
		if (!hasRole(RoleType.JKFYK, request)){
			model.addAttribute("reportUnitCode", currentOrgCode);
		}else{
			model.addAttribute("RoleType", "JKFYK");
		}	
		return "rhip.idm.statistics.report.supervisor.fillSearch";
	}	
	/**
	 * 传染病管理及督导-填写列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/fillList")
	public String fillList(ReportStatisticsQueryForm form, HttpServletRequest request, ModelMap model) {
		String indexPage = request.getParameter("indexPage");
        int currentPage = Integer.valueOf(indexPage);
        Page page = super.getPage(request, currentPage);
        Criteria ca = form.getSupervisorFillCriteria();
        PageList<Supervisor> plist = reportStatisticsService.findSupervisorFill(ca, page);
        model.addAttribute("supervisors", plist.getList());
        model.addAttribute("page", plist.getPage());	
        
		/*防疫科只能查看数据*/
		if (hasRole(RoleType.JKFYK, request)){
			 model.addAttribute("editFlag", "0");
		}else{
			model.addAttribute("editFlag", "1");
		}
		
		return "rhip.idm.statistics.report.supervisor.fillList";
	}

	/**
	 * 进入传染病管理及督导-新增/查看画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/addFill")
	public String addFill(HttpServletRequest request, String type, Long id, ModelMap model) {
		Supervisor supervisor = reportStatisticsService.getSupervisorFill(id);
        /*根据当前用户，设置页面中的调查机构*/
        if(ObjectUtil.isNullOrEmpty(supervisor)){
        	supervisor = new Supervisor();
	        Organization org = getCurrentOrg(request);
	        String organCode = org.getOrganCode();
	        Long userId = getCurrentUser(request).getId();
	        supervisor.setReportUnitCode(organCode);
	        supervisor.setModifyUnitCode(organCode);
	        supervisor.setReportUserCode(userId.toString());
	        supervisor.setModifyUserCode(userId.toString());
	        supervisor.setReportDate(new Date());
	        supervisor.setModifyDate(new Date());
        }
        model.put("supervisor", supervisor);
        model.put("type", type);
		return "rhip.idm.statistics.report.supervisor.addFill";
	}
	
	/**
	 * 保存传染病管理及督导
	 * @param request
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/saveFill")
	public String saveFill(Supervisor supervisor, HttpServletRequest request, ModelMap model) throws Exception {
		boolean result = false;
		if(ObjectUtil.isNotEmpty(supervisor)){
			String actionName = "直报统计-传染病管理及督导";
			OperationName op = OperationName.ADD;
			Organization org = getCurrentOrg(request);
	        String organCode = org.getOrganCode();
	        Long userId = getCurrentUser(request).getId();
			if(ObjectUtil.isNotEmpty(supervisor.getId())){
				op = OperationName.UPDATE;
		        supervisor.setModifyUnitCode(organCode);
		        supervisor.setModifyUserCode(userId.toString());
		        supervisor.setModifyDate(new Date());
			}else{
				supervisor.setGenreCode(org.getGenreCode());//机构类别代码
			}
			result = reportStatisticsService.saveSupervisorFill(supervisor);
			createOperationLog(request, RhipModuleName.IDM, actionName,op);
		}
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}
	
	/**
	 * 根据机构编码、填报月份查询是否已经填报
	 * @param reportMonth
	 * @param name
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping("/queryFill")
	public String queryFill(Date reportMonth, String reportUnitCode, HttpServletResponse response, ModelMap model) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		int count = 0;
		if(ObjectUtil.isNotEmpty(reportMonth) && ObjectUtil.isNotEmpty(reportUnitCode)){
			Criteria criteria = new Criteria("REPORT_MONTH",reportMonth);
			criteria.add("REPORT_UNIT_CODE",reportUnitCode);
			count = reportStatisticsService.getSupervisorFillCount(criteria);
			map.put("count", count);
		}
		return EHRMessageUtil.returnMsg(model, map);
	}
	
	/**
	 * 进入传染病管理及督导-汇总查询画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/summarySearch")
	public String summarySearch(HttpServletRequest request, ModelMap model) {
		/*根据当前机构，设置页面中的上报机构*/
		Organization org = getCurrentOrg(request);
		String currentOrgCode = org.getOrganCode();

		/*防疫科显示所有机构数据*/
		if (!hasRole(RoleType.JKFYK, request)){
			model.addAttribute("reportUnitCode", currentOrgCode);
		}else{
			model.addAttribute("RoleType", "JKFYK");
		}		
		model.addAttribute("defaultMonth", new Date());
		return "rhip.idm.statistics.report.supervisor.summarySearch";
	}	
	/**
	 * 传染病管理及督导-汇总列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/summaryList")
	public String summaryList(ReportStatisticsQueryForm form, String summaryType, HttpServletRequest request, ModelMap model) {

        Criteria ca = form.getSupervisorCriteria();
        List<Supervisor> supervisors = reportStatisticsService.findSupervisorFill(ca,summaryType);
        model.addAttribute("supervisors", supervisors);
        
        Supervisor supervisor = reportStatisticsService.getSupervisorSummary(ca,summaryType);
        model.addAttribute("supervisor", supervisor);
        model.addAttribute("summaryType", summaryType);
        if(summaryType.equals("1")){
        	Object reportMonth = ca.get("REPORT_MONTH");
        	Date reportMonthDate = DateUtil.parseSimpleDate(reportMonth.toString(), "yyy/MM");
        	model.addAttribute("reportMonth", reportMonthDate);
            /*中心显示填报日期*/
    		if (!hasRole(RoleType.JKFYK, request) && ObjectUtil.isNotEmpty(supervisors)){
    			model.addAttribute("reportDate", supervisors.get(0).getReportDate());
    			model.addAttribute("reportUserCode", supervisors.get(0).getReportUserCode());
    		}
        }

		return "rhip.idm.statistics.report.supervisor.summaryList";
	}
	
}
