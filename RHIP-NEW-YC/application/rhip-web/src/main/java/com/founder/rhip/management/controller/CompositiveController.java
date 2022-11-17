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
import com.founder.rhip.ihm.service.ICompositiveService;
import com.founder.rhip.ihm.service.IHospitalizeService;

@Controller
@RequestMapping("/ihm/compositive")
public class CompositiveController extends BaseController {
	
	
	
	@Resource(name="compositiveService")
    private ICompositiveService compositiveService;
	
    @RequestMapping("/search")
    public String birthCertificate(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/compositive/list");
        model.addAttribute("listpath", "compositiveList.jsp");
        return "ihm.compositive.search";
    }
    

    @RequestMapping("/list")
    public String studyAnalysList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        initOrg(request, model);
        List<Map<String, Object>> plist = compositiveService.getCompositives(form.getParamMap());
        model.addAttribute("compositiveList", plist);
        model.addAttribute("genreCode",form.getGenreCode());
        return "ihm.compositive.list";
    }
}