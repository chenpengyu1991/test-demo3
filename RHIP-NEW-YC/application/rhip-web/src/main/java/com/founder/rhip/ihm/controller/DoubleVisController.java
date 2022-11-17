package com.founder.rhip.ihm.controller;

import com.founder.elb.common.MessageUtils;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.dto.ihm.DoubleVisDTO;
import com.founder.rhip.ehr.dto.ihm.DoubleVisSummaryDTO;
import com.founder.rhip.ehr.service.IDualReferralService;
import com.founder.rhip.ihm.controller.IHMBaseController;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by wang_zhou on 2015/6/11.
 */
@Controller
@RequestMapping("/ihm/doublevis")
public class DoubleVisController extends IHMBaseController {
    @Resource(name="dualReferralService")
    private IDualReferralService dualReferralService;

    @Resource(name = "organizationApp")
    private IOrganizationApp organizationApp;

    @Autowired
    private IDictionaryApp dictionaryApp;
    /**
     * 双向就诊统计
     *
     * @param request
     * @param model
     * @return
     * @author wangzhou
     */
    @RequestMapping("/index")
    public String index(HttpServletRequest request,Model model) {
        model.addAttribute("currentBeginDate", DateUtil.firstDateOfMonth(new Date()));
        model.addAttribute("currentEndDate",DateUtil.lastDateOfMonth(new Date()));
        return "ihm.doublevis.searchChart";
    }

    @RequestMapping("/getDoubleVisChart")
    public void getDoubleVisChart(HttpServletRequest request, HttpServletResponse httpServletResponse,String statisticsDate,Model model) {
        Map<String, String> paramMap = new HashMap<>();;
        paramMap.put("genreCode", "0");
        String beginDate = "";
        String endDate = "";
        if(statisticsDate.equals("2")){
            //月份
            String monthDate = DateUtil.getDateTime("yyyy/MM", new Date());
            Date tempDate = DateUtil.convert("yyyy/MM",monthDate);
            beginDate = monthDate + "/01";
            endDate = DateUtil.getDateTime("yyyy/MM/dd",DateUtil.lastDateOfMonth(tempDate));
        }else if(statisticsDate.equals("3")){
            //年份
            Integer yearDate = DateUtil.getCurrentYear();
            beginDate = yearDate + "/01/01";
            endDate =  yearDate + "/12/31";
        }
        paramMap.put("beginDate",beginDate);
        paramMap.put("endDate",endDate);
        List<DoubleVisDTO> reports = dualReferralService.getDoubleVisList(paramMap);
        for(int i=0;i<reports.size();i++){
            DicItem dicItem = dictionaryApp.queryDicItem("FS990001",reports.get(i).getOrgCode());
            String organName = dicItem.getItemName();
            reports.get(i).setOrgName(organName);
        }
        model.addAttribute("reports", reports);
        MessageUtils.outputJSONResult(JSONArray.fromObject(reports).toString(), httpServletResponse);
    }

    @RequestMapping("/searchData")
    public String heRecordStatistics(HttpServletRequest request,Model model) {
/*        model.addAttribute("searchUrl", "/healthRecord/read/statistics/list");
        model.addAttribute("listpath","ehrTarget/readStatistics/readStatisticsList.jsp");
        model.addAttribute("fromHealthReadChart","fromHealthReadChart");*/
        initOrg(request,model);
        return "ihm.doublevis.index";
    }

    @RequestMapping("/doublevislist")
    public String doublevislist(HttpServletRequest request,TargetOrgQueryForm form, Model model) {
        List<DoubleVisDTO> reports = dualReferralService.getDoubleVisList(form.getParamMap());
        model.addAttribute("reports", reports);
        model.addAttribute("reportSummary", new DoubleVisSummaryDTO(reports));
        model.addAttribute("genreCodeFlag", form.getGenreCode());
        return "ihm.doublevis.doublevislist";
    }
}
