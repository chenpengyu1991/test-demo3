package com.founder.rhip.ihm.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.service.IRemindStatisticsService;
import com.founder.rhip.ihm.controller.form.EquipmentQueryForm;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.mdm.controller.form.ReportRecordQueryForm;
import com.founder.rhip.mdm.entity.DicItem;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by chen.q on 15-6-5.
 */
@Controller
@RequestMapping("/ihm/remind")
public class RemindStatisticsController extends IHMBaseController {
    @Resource(name="remindStatisticsService")
    private IRemindStatisticsService remindStatisticsService;

    @RequestMapping("/statistics/search")
    public String regionSearch(HttpServletRequest request,Model model) {
        //列表URL
        model.addAttribute("searchUrl", "/ihm/remind/statistics/search");
        //页面URL
        List<DicItem> remindTypes=remindStatisticsService.getRemindList();
        model.addAttribute("remindTypes", remindTypes);
        model.addAttribute("listpath", "list.jsp");
        initOrg(request,model);
        return "ihm.remind.statistics.index";
    }
    @RequestMapping("/statistics/list")
    public String regionlis(HttpServletRequest request,TargetOrgQueryForm form, Model model) {
        MapSqlParameterSource mapSqlParameter=new MapSqlParameterSource();

        Map<String, String> paramMap=form.getParamMap();
        Criteria criteria=new Criteria();
        criteria.add("GENRE_CODE",paramMap.get("genreCode"));
        criteria.add("ORGAN_CODE",paramMap.get("organCode"));
        criteria.add("PARENT_CODE",paramMap.get("superOrganCode"));
        criteria.add("GB_CODE",paramMap.get("gbCode"));
        criteria.add("beginDate",paramMap.get("beginDate"));
        criteria.add("endDate", paramMap.get("endDate"));
         //Criteria criteria = queryForm.getCriteria();
        List<DicItem> remindTypes=remindStatisticsService.getRemindList();
        model.addAttribute("remindTypes", remindTypes);
         List<Map<String, Object>> remindStatisticsList=remindStatisticsService.getRemindStatisticsMapList(criteria);
         model.addAttribute("remindStatisticsList", remindStatisticsList);
        return "ihm.remind.statistics.list";
    }

    @RequestMapping("/statistics/withoutorgsearch")
    public String withoutOrgSearch(HttpServletRequest request,Model model) {
        //列表URL
        model.addAttribute("searchUrl", "/ihm/remind/statistics/withoutorgsearch");
        //页面URL
        List<DicItem> remindTypes=remindStatisticsService.getRemindList();
        model.addAttribute("remindTypes", remindTypes);
        model.addAttribute("listpath", "outOrgList.jsp");
        initOrg(request,model);
        return "ihm.remind.statistics.withoutorgindex";
    }
    @RequestMapping("/statistics/withoutorglist")
    public String withoutorgList(HttpServletRequest request,TargetOrgQueryForm form, Model model) {
        Map<String, String> paramMap=form.getParamMap();
        Criteria criteria=new Criteria();
        criteria.add("beginDate",paramMap.get("beginDate"));
        criteria.add("endDate", paramMap.get("endDate"));
        List<DicItem> remindTypes=remindStatisticsService.getRemindList();
        model.addAttribute("remindTypes", remindTypes);
        List<Map<String, Object>> remindStWithoutOrgList=remindStatisticsService.getOutOrgReStatisticsMapList(criteria);
        model.addAttribute("remindStWithoutOrgList", remindStWithoutOrgList);
        return "ihm.remind.statistics.withoutorglist";
    }
}
