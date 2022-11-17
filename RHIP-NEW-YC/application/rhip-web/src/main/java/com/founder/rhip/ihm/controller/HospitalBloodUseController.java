package com.founder.rhip.ihm.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.clinic.TransBloodInfo;
import com.founder.rhip.ihm.controller.form.BloodJJQueryForm;
import com.founder.rhip.ihm.service.IHospitalBloodUseService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 血液管理
 * 
 * @author Joki
 * @since 2014年8月08日 16:59:24
 */
@Controller

public class HospitalBloodUseController extends IHMBaseController {

	@Resource(name = "hospitalBloodUseService")
	private IHospitalBloodUseService hospitalBloodUseService;

	/**
	 * 献血查询
	 */
	@RequestMapping("/ihm/ehr/blood")
	public String hospitalBloodUseSearch(Model model) {
		model.addAttribute("searchUrl", "/medicalTarget/hbu/hospitalBloodUse/list");
		return "ihm.medicalTarget.hospitalBloodUseSearch";
	}

	@RequestMapping("/medicalTarget/hbu/hospitalBloodUse/list")
	public String hospitalBloodUseList(HttpServletRequest request,
			BloodJJQueryForm form, Model model) {
		int currentPage = Integer.valueOf(request.getParameter("pageIndex"));
		Page page = super.getPage(request, currentPage);
		PageList<TransBloodInfo> plist = hospitalBloodUseService.getHospitalBloodUseList(page, form.getHospitalBloodUse2());
		model.addAttribute("resultList", plist.getList());
		model.addAttribute("page", plist.getPage());
		return "ihm.medicalTarget.hospitalBloodUseList";
	}

	@RequestMapping("/medicalTarget/hbu/hospitalBloodUse/detail")
	public String hospitalBloodUseDetail(HttpServletRequest request, String id,
			Model model) {
		TransBloodInfo result = hospitalBloodUseService
				.getHospitalBloodUse(new Criteria("ID", id));
		model.addAttribute("result", result);
		return "ihm.medicalTarget.hospitalBloodUseDetail";
	}


}
