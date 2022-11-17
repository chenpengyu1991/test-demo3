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
import com.founder.rhip.ihm.service.IOutpatientIhmService;

@Controller
@RequestMapping("/ihm/outpatient")
public class OutpatientIhmController extends BaseController {
	
	
	
	@Resource(name="outpatientIhmService")
    private IOutpatientIhmService outpatientIhmService;
	
    @RequestMapping("/search")
    public String search(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/outpatient/list");
        model.addAttribute("listpath", "outpatientList.jsp");
        return "ihm.outpatient.search";
    }
    

    @RequestMapping("/list")
    public String outpatientList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        initOrg(request, model);
        List<Map<String, Object>> plist = outpatientIhmService.getOutpatients(form.getParamMap());
        model.addAttribute("outpatientList", plist);
        model.addAttribute("genreCode",form.getGenreCode());
        return "ihm.outpatient.list";
    }
}