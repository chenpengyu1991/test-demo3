package com.founder.rhip.portal.controller;


import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.healtheducation.HealthPromorion;
import com.founder.rhip.he.common.CriteriaOrganizer;
import com.founder.rhip.he.service.IHealthPromorionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by chen.q on 15-6-9.
 */
@Controller
@RequestMapping(value = "/health/promorionMh")
public class HealthPromorionMhController  extends  BaseController{

    @Resource(name = "healthPromorionService")
    private IHealthPromorionService healthPromorionService;

    @RequestMapping("/list")
    public String list(HttpServletRequest request, HealthPromorion form, Model model,Integer indexPage){
        Page page;
        if(!("").equals(indexPage) &&  indexPage!=null){
            page= new Page(EHRConstants.PAGE_SIZE, indexPage);
        }else
        {
            page = new Page(EHRConstants.PAGE_SIZE, 1);
        }
        Criteria criteria = CriteriaOrganizer.initCriteria(request.getParameterMap(), HealthPromorion.class, "CREATE_TIME");
        PageList<HealthPromorion> pageList = healthPromorionService.findHealthPromorion(criteria, page);
        model.addAttribute("healthPromorions", pageList.getList());
        model.addAttribute("page", pageList.getPage());
        request.setAttribute("operation", "healthPromorion");
        model.addAttribute("operation", "healthPromorionClick");
        return "protal.ehr.health.promorionMh.list";
    }
    //查看健康宣传详情信息
    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable("id")Long id, ModelMap model) {
        if (ObjectUtil.isNotEmpty(id)) {
            HealthPromorion healthPromorion = healthPromorionService.getHealthPromorionById(new Criteria("ID", id));
            model.addAttribute("healthPromorion", healthPromorion);
        }
        model.addAttribute("operation", "healthPromorionClick");
        return "protal.ehr.health.promorionMh.detail";
    }
}
