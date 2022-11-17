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
import com.founder.rhip.ihm.service.ISimpleDiseaseService;

@Controller
@RequestMapping("/ihm/simpleDisease")
public class SimpleDiseaseController extends BaseController {
	
	
	
	@Resource(name="simpleDiseaseService")
    private ISimpleDiseaseService simpleDiseaseService;
	
    @RequestMapping("/search")
    public String search(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/simpleDisease/list");
        model.addAttribute("listpath", "simpleDiseaseList.jsp");
        return "ihm.simpleDisease.search";
    }
    

    @RequestMapping("/list")
    public String simpleDiseaseList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        initOrg(request, model);
        List<Map<String, Object>> plist = simpleDiseaseService.getSimpleDiseases(form.getParamMap());
        model.addAttribute("simpleDiseaseList", plist);
        model.addAttribute("genreCode",form.getGenreCode());
        return "ihm.simpleDisease.list";
    }
}