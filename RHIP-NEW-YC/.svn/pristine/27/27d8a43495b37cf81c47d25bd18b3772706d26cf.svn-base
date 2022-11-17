package com.founder.rhip.ihm.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.ihm.service.IMedicalTargetService;

/**
 * 临床路径统计
 */
@Controller
@RequestMapping("/ihm/clinicalPathway")
public class ClinicalPathwayController extends IHMBaseController {

	@Resource(name="medicalTargetService")
	private IMedicalTargetService medicalTargetService;

    /**
     * 进入查询页面(服务能力指标)
     * @return
     */
    @RequestMapping("/index")
    public String search(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/ihm/clinicalPathway/statistics");
        model.addAttribute("listpath", "listSt.jsp");
        return "ihm.clinicalPathway.index";
    }
    
    @RequestMapping("/statistics")
    public String statistics(HttpServletRequest request,TargetOrgQueryForm form, Model model) {
		form.initMedical();
		List<Map<String, Object>> result = medicalTargetService.getClinicalPathwayStatistics(form.getParamMap() );
        model.addAttribute("summaryList", result);
        model.addAttribute("genreCode",form.getGenreCode());
        return "ihm.clinicalPathway.statistics";
    }

}