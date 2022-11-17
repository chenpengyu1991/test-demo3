package com.founder.rhip.report.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.service.report.IRpHealthyPhysicalExamService;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/report/rpHealthyPhysicalExamination")
public class RpHealthyPhysicalExaminationController extends BaseController {

	@Resource(name = "rpHealthyPhysicalExamService")
	private IRpHealthyPhysicalExamService rpHealthyPhysicalExamService;
	
    //居民健康体检绩效考核
	@RequestMapping("/search")
	public String search(HttpServletRequest request, Model model) {
		//列表URL
    	model.addAttribute("searchUrl", "/report/rpHealthyPhysicalExamination/list");
    	//页面URL
    	model.addAttribute("listpath", "physicalExamTarget/healthy_exam_statisticslist.jsp");
    	initOrg(request,model);
        return "ihm.healthy.physical.exam.statistics.index";
	}

	@RequestMapping("/list")
	public String list(HttpServletRequest request,
			TargetOrgQueryForm form, Model model) {
		Map<String, String> paramMap = form.getParamMap();
		List<Map<String, Object>> results = rpHealthyPhysicalExamService.getHealthyPhysicalExamMapList(paramMap);
				
		model.addAttribute("results", results);
		model.addAttribute("genreCode", form.getGenreCode());
		return "ihm.healthy.physical.exam.statistics.list";
	}
}