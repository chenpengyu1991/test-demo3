package com.founder.rhip.ihm.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.ihm.service.ICardMonitoringService;
import com.founder.rhip.mdm.controller.form.ReportRecordQueryForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by chen.q on 15-6-3.
 */
@Controller
@RequestMapping("/ihm/card")
public class CardMonitoringController  extends IHMBaseController {
    @Resource(name="cardMonitoringService")
    private ICardMonitoringService  cardMonitoringService;


    @RequestMapping("/monitor/search")
    public String regionIndex(HttpServletRequest request,Model model) {
        return "ihm.card.monitor.index";
    }
    @RequestMapping("/monitor/show")
    public String regionSearch(HttpServletRequest request,Model model) {
        //列表URL
        model.addAttribute("searchUrl", "/ihm/card/monitor/list");
        //页面URL
        model.addAttribute("listpath", "list.jsp");
        initOrg(request,model);
        return "ihm.card.monitor.search";
    }
    @RequestMapping("/monitor/list")
    public String regionlis(HttpServletRequest request,TargetOrgQueryForm form, Model model) {
        model.addAttribute("genreCode",form.getGenreCode());
        Map<String, String> paramMap=form.getParamMap();
        Criteria criteria=new Criteria();
        criteria.add("GENRE_CODE",paramMap.get("genreCode"));
        criteria.add("ORGAN_CODE",paramMap.get("organCode"));
        criteria.add("PARENT_CODE",paramMap.get("superOrganCode"));
        criteria.add("GB_CODE",paramMap.get("gbCode"));
        criteria.add("beginDate",paramMap.get("beginDate"));
        criteria.add("endDate", paramMap.get("endDate"));

        List<Map<String, Object>> reportRecords=cardMonitoringService.getCountReportMapList(criteria);
        model.addAttribute("reportRecordList", reportRecords);
        return "ihm.card.monitor.list";
    }
    @RequestMapping("/monitor/json")
    public @ResponseBody  Map<String,String> getCardMap(HttpServletRequest request, String statisticsDate) {
        Criteria criteria=new Criteria();
        criteria.add("GENRE_CODE","0");
        if(!("100").equals(statisticsDate)){
            criteria.add("statisticsDate",getDateRange(statisticsDate));
        }else{
        criteria.add("statisticsDate",statisticsDate);
        }
        Map<String,String>  reportRecordMap=cardMonitoringService.getCountReportMap(criteria);
        return reportRecordMap;
    }
    /**
     * 获取统计的日期时间范围
     * @param statisticsDate
     * @return
     */
    private Date[] getDateRange(String statisticsDate){
        Calendar cal = Calendar.getInstance();
        Date[] dateRange = new Date[2];
        switch(statisticsDate){
            case "1" :
                dateRange[0] = DateUtil.makeTimeToZero(cal.getTime());
                dateRange[1] =DateUtil.makeTimeToMax(cal.getTime());
                break;
            case "2" :
                dateRange = DateUtil.getDateRangeByMonth(cal.get(Calendar.MONTH));
                break;
            case "3" :
                dateRange = DateUtil.getDateRangeByYear(cal.get(Calendar.YEAR));
                break;
            default :
                dateRange[0] = null;
                dateRange[1] = null;
                break;
        }
        return dateRange;
    }
}
