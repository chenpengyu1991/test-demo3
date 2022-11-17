package com.founder.rhip.ihm.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.blood.BsBlood2hos;
import com.founder.rhip.ehr.entity.blood.BsBloodDonorInfo;
import com.founder.rhip.ehr.entity.blood.BsBloodbank;
import com.founder.rhip.ehr.entity.blood.BsReimbursement;
import com.founder.rhip.ihm.controller.form.BloodJJQueryForm;
import com.founder.rhip.ihm.service.IBloodMgntService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 血液管理
 * 
 * @author Cary
 * @since 2014年7月30日 14:59:24
 */
@Controller
@RequestMapping("/bloodMgnt")
public class BloodMgntController extends IHMBaseController {

	@Resource(name = "bloodMgntService")
	private IBloodMgntService bloodMgntService;

	/**
	 * 献血查询
	 */
	@RequestMapping("/bloodDonation/index")
	public String bloodDonationSearch(Model model) {
		model.addAttribute("searchUrl", "/bloodMgnt/bloodDonation/list");
		return "ihm.bloodMgnt.searchBloodDonation";
	}

	@RequestMapping("/bloodDonation/list")
	public String bloodDonationList(HttpServletRequest request,
			BloodJJQueryForm form, Model model) {
		int currentPage = Integer.valueOf(request.getParameter("pageIndex"));
		Page page = super.getPage(request, currentPage);
		PageList<BsBloodDonorInfo> plist = bloodMgntService
				.getBloodDonationList(page, form.getBloodDonorInfoCriteria());
		model.addAttribute("resultList", plist.getList());
		model.addAttribute("page", plist.getPage());
		return "ihm.bloodMgnt.bloodDonationList";
	}

	@RequestMapping("/bloodDonation/detail")
	public String bloodDonationDetail(HttpServletRequest request, String id,
			Model model) {
		BsBloodDonorInfo result = bloodMgntService
				.getBloodDonation(new Criteria("ID", id));
		model.addAttribute("result", result);
		return "ihm.bloodMgnt.bloodDonationDetail";
	}

	/**
	 * 用血查询
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/bloodUse/index")
	public String bloodUseSearch(Model model) {
		 model.addAttribute("searchUrl", "/bloodMgnt/bloodUse/list");
		return "ihm.bloodMgnt.searchBloodUse";
	}

	@RequestMapping("/bloodUse/list")
	public String bloodUseList(HttpServletRequest request,
			BloodJJQueryForm form, Model model) {
		int currentPage = Integer.valueOf(request.getParameter("pageIndex"));
		Page page = super.getPage(request, currentPage);
		PageList<BsReimbursement> plist = bloodMgntService.getBloodUseList(
				page, form.getReimbursementCriteria());
		model.addAttribute("resultList", plist.getList());
		model.addAttribute("page", plist.getPage());
		return "ihm.bloodMgnt.bloodUseList";
	}

	@RequestMapping("/bloodUse/detail")
	public String bloodUseDetail(HttpServletRequest request, String id,
			Model model) {
		BsReimbursement result = bloodMgntService.getBloodUse(new Criteria("ID",
				id));
		model.addAttribute("result", result);
		return "ihm.bloodMgnt.bloodUseDetail";
	}

	/**
	 * 血液库存
	 */
	@RequestMapping("/bloodBank/index")
	public String bloodBankSearch(Model model) {
		model.addAttribute("searchUrl", "/bloodMgnt/bloodBank/list");
		return "ihm.bloodMgnt.searchBloodBank";
	}

	@RequestMapping("/bloodBank/list")
	public String bloodBankList(HttpServletRequest request,
			BloodJJQueryForm form, Model model) {
		int currentPage = Integer.valueOf(request.getParameter("pageIndex"));
		Page page = super.getPage(request, currentPage);
		PageList<BsBloodbank> plist = bloodMgntService.getBloodBankList(page,
				form.getBloodBankCriteria());
		model.addAttribute("resultList", plist.getList());
		model.addAttribute("page", plist.getPage());
		return "ihm.bloodMgnt.bloodBankList";
	}

	@RequestMapping("/bloodBank/detail")
	public String bloodBankDetail(HttpServletRequest request, String id,
			Model model) {
		BsBloodbank result = bloodMgntService
				.getBloodBank(new Criteria("ID", id));
		model.addAttribute("result", result);
		return "ihm.bloodMgnt.bloodBankDetail";
	}

	/**
	 * 血液出库
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/blood2Hos/index")
	public String blood2HosSearch(Model model) {
//		model.addAttribute("searchUrl", "/ihm/ehr/star/result");
//		// 不需要按市级医院查询
//		model.addAttribute("hospitalFlag", 1);
		model.addAttribute("searchUrl", "/bloodMgnt/blood2Hos/list");
		return "ihm.bloodMgnt.searchBlood2Hos";
	}

	@RequestMapping("/blood2Hos/list")
	public String blood2HosList(HttpServletRequest request,
			BloodJJQueryForm form, Model model) {
		int currentPage = Integer.valueOf(request.getParameter("pageIndex"));
		Page page = super.getPage(request, currentPage);
		PageList<BsBlood2hos> plist = bloodMgntService.getBlood2HosList(page,
				form.getBlood2HosCriteria());
		model.addAttribute("resultList", plist.getList());
		model.addAttribute("page", plist.getPage());
		return "ihm.bloodMgnt.blood2HosList";
	}

	@RequestMapping("/blood2Hos/detail")
	public String blood2HosDetail(HttpServletRequest request, String id,
			Model model) {
		BsBlood2hos result = bloodMgntService
				.getBlood2Hos(new Criteria("ID", id));
		model.addAttribute("result", result);
		return "ihm.bloodMgnt.blood2HosDetail";
	}
}
