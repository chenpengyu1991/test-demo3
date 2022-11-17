package com.founder.rhip.ihm.controller.ehr;

import com.founder.elb.common.MessageUtils;
import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.service.IHeRecReadStatisticsService;
import com.founder.rhip.ihm.controller.IHMBaseController;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chen.q on 15-6-11.
 */
@Controller
@RequestMapping("/healthRecord/read")
public class HeRecReadStatisticsController extends IHMBaseController {
    @Resource(name = "heRecReadStatisticsService")
    private IHeRecReadStatisticsService heRecReadStatisticsService;

    @RequestMapping("/search")
    public String heRecordCharts(HttpServletRequest request,Model model) {
        return "healthRecord.read.statistics.searchChart";
    }

    @RequestMapping("/getHealthReadChart")
    public void getHealthReadChart(HttpServletRequest request, HttpServletResponse httpServletResponse,String statisticsDate) {
       Map<String, String> paramMap = new HashMap<>();
       paramMap.put("genreCode", "0");
        String beginDate = "";
        String endDate = "";
        if(statisticsDate.equals("2")){
            //月份
            String monthDate = DateUtil.getDateTime("yyyy/MM", new Date());
            Date tempDate = DateUtil.convert("yyyy/MM",monthDate);
            beginDate = monthDate + "/01";
            endDate = DateUtil.getDateTime("yyyy/MM/dd",DateUtil.lastDateOfMonth(tempDate));
            paramMap.put("beginDate",beginDate);
            paramMap.put("endDate",endDate);
        }else if(statisticsDate.equals("3")){
            //年份
            Integer yearDate = DateUtil.getCurrentYear();
            beginDate = yearDate + "/01/01";
            endDate =  yearDate + "/12/31";
            paramMap.put("beginDate",beginDate);
            paramMap.put("endDate",endDate);
        }
       List<Map<String, Object>> recReadChartList = heRecReadStatisticsService.getHeRecReadStatistics(paramMap);
       for(int i=0;i<recReadChartList.size();i++){
           if(recReadChartList.get(i).get("ORGANNAME").equals("合计")){
               recReadChartList.remove(i);
           }
       }
       MessageUtils.outputJSONResult(JSONArray.fromObject(recReadChartList).toString(), httpServletResponse);
    }

    @RequestMapping("/searchData")
    public String heRecordStatistics(HttpServletRequest request,Model model) {
        model.addAttribute("searchUrl", "/healthRecord/read/statistics/list");
        model.addAttribute("listpath","ehrTarget/readStatistics/readStatisticsList.jsp");
        model.addAttribute("fromHealthReadChart","fromHealthReadChart");
        initOrg(request,model);
        return "healthRecord.read.statistics.search";
    }
    @RequestMapping("/statistics/list")
    public String heRecordStatisticsList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        initOrg(request, model);
        List<Map<String, Object>> recReadStatisticsList = heRecReadStatisticsService.getHeRecReadStatistics(form.getParamMap());
        model.addAttribute("recReadStatisticsList", recReadStatisticsList);
        model.addAttribute("genreCode",form.getGenreCode());
        return "healthRecord.read.statistics.list";
    }
}
