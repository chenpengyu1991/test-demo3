package com.founder.rhip.mhm.controller;

import java.util.Date;
import java.util.List;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.dto.mhm.MhmStatisticsReportDto;
import com.founder.rhip.mhm.controller.form.MhmStatisticsReportQueryForm;
import com.founder.rhip.mhm.service.IMhmStatisticsReportService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/mhm/statistics/report")
public class MhmStatisticsReportController extends MhmBaseController {

	@Resource(name = "mhmStatisticsReportService")
	private IMhmStatisticsReportService mhmStatisticsReportService;
	
	/**
	 * 进入查询画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/search")
	public String reportSearch(HttpServletRequest request,ModelMap model) {
		model.put("defaultMonth", new Date());
		return "rhip.mhm.statistics.report.search";
	}	
	/**
	 * 列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String reportList(MhmStatisticsReportQueryForm form,HttpServletRequest request,ModelMap model) {
		String year="";
		String month="";
		Integer quarter=null;
		String townCode = form.getTownCode();
		String centerCode = form.getCenterCode();
		String stationCode = form.getStationCode();
		if(!form.getMhmReprtType().equals("3") 
				&& (StringUtil.isNotEmpty(centerCode) || StringUtil.isNotEmpty(stationCode))){
			model.put("monthFlag", "1");//如果中心编码或者站编码不为空，需要根据查询时间段显示每个月的数据
		}
    	if(form.getMhmReprtType().equals("1")){//按年查询
    		year = form.getReportYear();
    	}
    	if(form.getMhmReprtType().equals("2")){//按季度查询
    		year = form.getReportYear();
    		quarter = form.getReportQuarter();
    	}
    	if(form.getMhmReprtType().equals("3")){//按月查询
    		month = form.getReportMonth();
    	}      	
        if (hasRole(RoleType.ZXJFYS, request) ){
        	centerCode = getCurrentOrg(request).getOrganCode();
        	List<MhmStatisticsReportDto> reports = mhmStatisticsReportService.getStationResult(year,month,quarter,centerCode,stationCode);
        	model.put("reports", reports);
        }		
        if (hasRole(RoleType.JKJFZX, request) ){
        	List<MhmStatisticsReportDto> reports = mhmStatisticsReportService.getCentreResult(year,month,quarter,townCode,centerCode);
        	model.put("reports", reports);
        }
        if (hasRole(RoleType.ADMIN, request) ){
        	List<MhmStatisticsReportDto> reports = mhmStatisticsReportService.getCentreResult(year,month,quarter,townCode,centerCode);
        	model.put("reports", reports);
        }        
		return "rhip.mhm.statistics.report.list";
	}

    private static String CONTROLLER_NAME = "精神卫生报表";

    @RequestMapping("/operationLog")
    @ResponseBody
    private String operationLon(HttpServletRequest request){
        OperationName  opName = OperationName.EXP;
        record(request, opName);
        return null;
    }

    @Override
    protected String getActionName() {
        return CONTROLLER_NAME;
    }

}
