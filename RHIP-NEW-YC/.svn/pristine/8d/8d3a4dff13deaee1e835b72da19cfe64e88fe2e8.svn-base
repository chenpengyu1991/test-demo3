package com.founder.rhip.report.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.service.report.IRpPaWomenChildHealthcareService;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;

@Controller
@RequestMapping("/report/rpPaWomenChildHealthcare")
public class RpPaWomenChildHealthcareController extends BaseController {
	
	@Resource(name = "rpPaWomenChildHealthcareService")
	private IRpPaWomenChildHealthcareService rpPaWomenChildHealthcareService;

    //妇幼保健工作量考核(个人)
	
	   /**
     * 进入查询页面
     * @return
     */
    @RequestMapping("/search")
    public String search(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("unSelectType", "0");//镇
        model.addAttribute("searchUrl", "/report/rpPaWomenChildHealthcare/list");
        model.addAttribute("listpath", "materialChildList.jsp");
        return "pam.personPerformance.index";
    }
    
	  /**
     * 妇幼保健考核
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        initOrg(request, model);
        Page page = buildPage(request);
        PageList<Map<String, Object>> pageList = rpPaWomenChildHealthcareService.getPaWomenChildHealthcarePageList(form.getParamMap(), page);
        model.addAttribute("summaryList", pageList.getList());
        model.addAttribute("page", pageList.getPage());
        return "pam.wch.list";
    }

}