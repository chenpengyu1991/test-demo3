package com.founder.rhip.management.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.rhip.BaseController;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.ihm.service.IHospitalizeService;

@Controller
@RequestMapping("/ihm/hospitalize")
public class HospitalizeController extends BaseController {
	
	
	
	@Resource(name="hospitalizeService")
    private IHospitalizeService hospitalizeService;
	
    @RequestMapping("/search")
    public String birthCertificate(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/hospitalize/list");
        model.addAttribute("listpath", "hospitalizeList.jsp");
        return "ihm.hospitalize.search";
    }
    

    @RequestMapping("/list")
    public String studyAnalysList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        initOrg(request, model);
        List<Map<String, Object>> plist = hospitalizeService.getHospitalizes(form.getParamMap());
        model.addAttribute("hospitalizeList", plist);
        model.addAttribute("genreCode",form.getGenreCode());
        return "ihm.hospitalize.list";
    }
}