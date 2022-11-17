package com.founder.rhip.report.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.service.report.IRpInhospitalTreatmentService;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;

@Controller
@RequestMapping("/report/rpInhospitalTreatment")
public class RpInhospitalTreatmentController extends BaseController {

    //18 种病住院治疗监测
	@Resource(name = "rpInhospitalTreatmentService")
	private IRpInhospitalTreatmentService rpInhospitalTreatmentService;

	@RequestMapping("/search")
	public String search(HttpServletRequest request, Model model) {
    	initOrg(request,model);
        return "ihm.md.index";
	}

	@RequestMapping("/list")
	public String list(HttpServletRequest request,
			TargetOrgQueryForm form, Model model) {
		Map<String, String> paramMap = form.getRpParamMap();
		List<Map<String, Object>> reports = rpInhospitalTreatmentService.getHospitalTreatmentMapList(paramMap);
		model.addAttribute("reports", reports);
		model.addAttribute("genreCode", form.getGenreCode());
		model.addAttribute("currentYear", paramMap.get("rpYear"));
		model.addAttribute("organCode", paramMap.get("organCode"));
		model.addAttribute("gbCode", paramMap.get("gbCode"));
		return "ihm.md.list";
	}

}