package com.founder.rhip.report.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.service.report.IRpPaVaccinationService;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/report/rpPaVaccination")
public class RpPaVaccinationController extends BaseController {
	
	@Resource(name = "rpPaVaccinationService")
	private IRpPaVaccinationService rpPaVaccinationService;

    //接种疫苗绩效考核(个人)
	 /**
	  * 进入查询页面
	  * @return
	  */
	 @RequestMapping("/search")
	 public String search(HttpServletRequest request, Model model) {
	     initOrg(request, model);
	     model.addAttribute("unSelectType", "0");//镇
	     model.addAttribute("searchUrl", "/report/rpPaVaccination/list");
	     model.addAttribute("listpath", "personVaccinationList.jsp");
	     return "pam.personPerformance.index";
	 }
	 
	 /**
	  * 接种疫苗医生工作量考核
	  * @param request
	  * @param form
	  * @param model
	  * @return
	  */
	 @RequestMapping("/list")
	 public String list(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
	     initOrg(request, model);
	     Page page = buildPage(request);
	     PageList<Map<String, Object>> pageList = rpPaVaccinationService.getPaVaccinationPageList(form.getParamMap(), page);
	     model.addAttribute("summaryList", pageList.getList());
	     model.addAttribute("page", pageList.getPage());
	     return "pam.person.vaccination.list";
	 }

}