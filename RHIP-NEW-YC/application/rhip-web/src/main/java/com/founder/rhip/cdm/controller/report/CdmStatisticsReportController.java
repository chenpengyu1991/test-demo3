package com.founder.rhip.cdm.controller.report;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.cdm.service.ICdmStatisticsReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 慢病分析
 * 
 */
@Controller
@RequestMapping("/statistics")
public class CdmStatisticsReportController extends BaseController {

	@Resource
	private ICdmStatisticsReportService cdmStatisticsReportService;

    @RequestMapping("/analysis")
    public String cdmManageAnalysis(ModelMap model) {
        return "rhip.cdm.base.manageAnalysis.index";
    }

	@RequestMapping("/searchHbp")
     public String hbpInit(ModelMap model) {
        model.addAttribute("searchUrl", "/statistics/searchManageAnalysis/hbp");
        model.addAttribute("listpath", "hbpList.jsp");
        model.addAttribute("currentYear",new Date());
        return "rhip.cdm.base.manageAnalysis.search";
//        return "rhip.cdm.base.manageAnalysis.hbpList";
    }

    @RequestMapping("/searchDi")
    public String searchDi(ModelMap model) {
        model.addAttribute("searchUrl", "/statistics/searchManageAnalysis/di");
        model.addAttribute("listpath", "diList.jsp");
        model.addAttribute("currentYear",new Date());
        return "rhip.cdm.base.manageAnalysis.search";
    }

	// 查询高血压分析统计报表
	@RequestMapping("/searchManageAnalysis/hbp")
	public String searchCdmManageAnalysis(ModelMap model, HttpServletRequest request) {
		model.addAttribute("cdmsStatistsList", cdmStatisticsReportService.getCdmsStatisticsList(getCriteria(request)));
		return "rhip.cdm.base.manageAnalysis.hbpList";
	}

    // 查询糖尿病分析统计报表
    @RequestMapping("/searchManageAnalysis/di")
    public String searchCdmManageAnalysis1(ModelMap model, HttpServletRequest request) {
        model.addAttribute("cdmsStatistsList", cdmStatisticsReportService.getCdmsStatisticsList(getCriteria(request)));
        return "rhip.cdm.base.manageAnalysis.diList";
    }

    private Criteria getCriteria(HttpServletRequest request) {
        Criteria criteria = new Criteria();
        if(ObjectUtil.isNullOrEmpty(request.getParameter("createDate"))) {
            criteria = new Criteria("createDate", DateUtil.getCurrentYear());
        } else {
            criteria = new Criteria("createDate", request.getParameter("createDate"));
        }
        return criteria;
    }
}
