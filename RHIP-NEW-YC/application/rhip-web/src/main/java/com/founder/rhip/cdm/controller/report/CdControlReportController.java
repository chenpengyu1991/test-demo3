package com.founder.rhip.cdm.controller.report;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.cdm.controller.CdmBaseController;
import com.founder.rhip.cdm.service.ICdControlReportService;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.statisticsdto.HbpManageMonthReport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 慢病防治
 * @author liuk
 *
 */
@Controller
@RequestMapping("/cdm/statistics")
public class CdControlReportController extends CdmBaseController {
	
	@Resource(name = "cdControlReportService")
	private ICdControlReportService cdControlReportService;
	
	@RequestMapping("/cdControl")
	public String cdControl(ModelMap model) {
		model.put("currentDate", new Date());
		return "rhip.cdm.base.report.cdControl";
	}
	@RequestMapping("/manageMonthReport")
	public String manageMonthReport(ModelMap model,HttpServletRequest request){
		String gBCode = request.getParameter("gbCode");
		String centreCode = request.getParameter("centreCode");
		String stationCode = request.getParameter("stationCode");
		String mouth = request.getParameter("month");
		
		RoleType roleType=getRole(request);
		if (roleType.equals(RoleType.ZXMB)||roleType.equals(RoleType.YYMB)) {
			 centreCode=getCurrentOrg(request).getOrganCode();
		}else if (roleType.equals(RoleType.ZMB)) {
			stationCode=getCurrentOrg(request).getOrganCode();
		}
		
		
		List<HbpManageMonthReport> hbpManageMonthReport = cdControlReportService.getManageMonthReport(gBCode,centreCode,stationCode,mouth);
		setCurrentUesrInfo(model,request);
		if(ObjectUtil.isNotEmpty(mouth)){
			String date = mouth.replace("/", "年")+"月";
			model.addAttribute("mouth",date);
		}
		model.addAttribute("hbpManageMonthReport",hbpManageMonthReport);
		return "rhip.cdm.base.report.hbpManageMonthReport";
	}
	private void setCurrentUesrInfo(ModelMap model, HttpServletRequest request) {
		model.put("currentDate", new Date());
		model.put("currentUserName", getCurrentUser(request).getName());
		model.put("currentOrgName", getCurrentOrg(request).getOrganName());
	}
	
}
