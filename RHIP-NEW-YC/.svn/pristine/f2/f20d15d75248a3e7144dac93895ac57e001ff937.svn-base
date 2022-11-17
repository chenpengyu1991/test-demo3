package com.founder.rhip.report.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.service.report.IRpPhysicalExaminationService;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/report/rpPhysicalExamination")
public class RpPhysicalExaminationController extends BaseController {

	@Resource(name = "rpPhysicalExaminationService")
	private IRpPhysicalExaminationService rpPhysicalExaminationService;
    //居民体检人次统计
	@RequestMapping("/search")
	public String search(HttpServletRequest request, Model model) {
		//列表URL
    	model.addAttribute("searchUrl", "/report/rpPhysicalExamination/list");
    	//页面URL
    	model.addAttribute("listpath", "physicalExamTarget/statisticslist.jsp");
    	initOrg(request,model);
        return "ihm.physicalExam.statistics.index";
	}

	@RequestMapping("/list")
	public String list(HttpServletRequest request,
			TargetOrgQueryForm form, Model model) {
		Map<String, String> paramMap = form.getParamMap();
		List<Map<String, Object>> results = rpPhysicalExaminationService.getPhysicalExaminationMapList(paramMap);
				
		model.addAttribute("results", results);
		model.addAttribute("genreCode", form.getGenreCode());
		return "ihm.physicalExam.statistics.list";
	}
	
}