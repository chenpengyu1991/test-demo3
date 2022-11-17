package com.founder.rhip.portal.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.healtheducation.HealthPrescription;
import com.founder.rhip.he.common.CriteriaOrganizer;
import com.founder.rhip.he.service.IHealthPrescriptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by chen.q on 15-6-19.
 */
@Controller
@RequestMapping(value = "/health/prescriptionMh")
public class HealthPrescriptionMhController extends  BaseController{
    @Resource(name = "healthPrescriptionService")
    private IHealthPrescriptionService healthPrescriptionService;

    @RequestMapping("/list")
    public String list(HttpServletRequest request, ModelMap model,Integer indexPage) {
        request.setAttribute("operation", "healthPrescription");
        Page page;
        if(!("").equals(indexPage) &&  indexPage!=null){
            page= new Page(EHRConstants.PAGE_SIZE, indexPage);
        }else
        {
            page = new Page(EHRConstants.PAGE_SIZE, 1);
        }
        Criteria criteria = CriteriaOrganizer.initCriteria(request.getParameterMap(), HealthPrescription.class, "CREATE_TIME");
        PageList<HealthPrescription> pageList = healthPrescriptionService.findHealthPrescription(criteria.add("STATUS", "1"), page);
        model.addAttribute("healthPrescriptions", pageList.getList());
        model.addAttribute("page", pageList.getPage());
        model.addAttribute("operation", "prescriptionMhClick");
        return "protal.ehr.health.prescriptionMh.list";
    }

    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable("id")Long id, ModelMap model) {
        if (ObjectUtil.isNotEmpty(id)) {
            HealthPrescription healthPrescription = healthPrescriptionService.getHealthPrescription(new Criteria("ID", id));
            model.addAttribute("healthPrescription", healthPrescription);
        }
        model.addAttribute("operation", "prescriptionMhClick");
        return "protal.ehr.health.prescriptionMh.detail";
    }

}
