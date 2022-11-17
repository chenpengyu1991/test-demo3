package com.founder.rhip.ihm.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.nc.NcLog;
import com.founder.rhip.ihm.controller.form.BloodJJQueryForm;
import com.founder.rhip.ihm.service.INewCitizenScoreService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 新市民积分调用查询
 * 
 * @author Joki
 * @since 2014年8月14日 13:59:24
 */
@Controller

public class NewCitizenScoreController extends IHMBaseController {

	@Resource(name = "newCitizenScoreService")
	private INewCitizenScoreService newCitizenScoreService;

	/**
	 * 献血查询
	 */
	@RequestMapping("ihm/ehr/citizenscore")
	public String newCitizenScoreSearch(Model model) {
		model.addAttribute("searchUrl", "/medicalTarget/ncs/newCitizenScore/list");
		return "ihm.medicalTarget.newCitizenScoreSearch";
	}

	@RequestMapping("/medicalTarget/ncs/newCitizenScore/list")
	public String newCitizenScoreList(HttpServletRequest request,
			BloodJJQueryForm form, Model model) {
		int currentPage = Integer.valueOf(request.getParameter("pageIndex"));
		Page page = super.getPage(request, currentPage);
		PageList<NcLog> plist = newCitizenScoreService.getNewCitizenScoreList(page, form.getNewCitizenScore());
		model.addAttribute("resultList", plist.getList());
		model.addAttribute("page", plist.getPage());
		return "ihm.medicalTarget.newCitizenScoreList";
	}

	@RequestMapping("/medicalTarget/ncs/newCitizenScore/detail")
	public String newCitizenScoreDetail(HttpServletRequest request, String id,
			Model model) {
		NcLog result = newCitizenScoreService
				.getNewCitizenScore(new Criteria("ID", id));
		model.addAttribute("result", result);
		return "ihm.medicalTarget.newCitizenScoreDetail";
	}


}
