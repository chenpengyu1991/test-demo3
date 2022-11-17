package com.founder.rhip.ihm.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.founder.fasf.beans.Criteria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.entity.cic.CicCitizenCard;
import com.founder.rhip.ehr.service.IHealthCardTargetService;
import com.founder.rhip.ihm.controller.form.EmrMedicalTargetQueryForm;
import com.founder.rhip.ihm.controller.form.HealthCardTargetForm;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.mdm.service.IOrganizationService;

/**
 * 市民卡
 * @author chen_tao
 *
 */
@Controller
@RequestMapping("/ihm/healthCard/")
public class HealthCardTargetController extends IHMBaseController {

	@Resource(name = "healthCardTargetService")
	private IHealthCardTargetService healthCardTargetService;
	
	@Resource(name="mdmOrganizationService")
	private IOrganizationService organizationService;
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request, EmrMedicalTargetQueryForm form,
			Model model) {
		Page page = new Page(0,0);
		model.addAttribute("pageIndex", page);
		model.addAttribute("page", page);
		return "ihm.healthCard.index";
	}

	@RequestMapping("/search")
	public String search(HttpServletRequest request,
			HealthCardTargetForm form, Model model) {
		int currentPage = Integer.valueOf(request.getParameter("indexPage"));
		Page page = super.getPage(request, currentPage); 
		
		PageList<CicCitizenCard> pagelist = healthCardTargetService.getCicCitizenCardList(form.getCriteria(), page);
		
		model.addAttribute("healthCardList", pagelist.getList());
		model.addAttribute("page", pagelist.getPage());
		
		return "ihm.healthCard.search";
	}
	
	@RequestMapping("/detail")
	public String detail(HttpServletRequest request, Model model, Long id) {
		CicCitizenCard card = healthCardTargetService.getCicCitizenCard((Long)id);
		model.addAttribute("healthCard", card);
		return "ihm.healthCard.detail";
	}

    @RequestMapping("/history")
    public String history(HttpServletRequest request, Model model,String paperType, String paperNo) {
        int currentPage = Integer.valueOf(request.getParameter("indexPage"));
        Page page = super.getPage(request, currentPage);
        Criteria ca = new Criteria("PAPER_NO", paperNo);
        ca.add("PAPER_TYPE", paperType);
        PageList<CicCitizenCard> pagelist = healthCardTargetService.getCicCitizenCardHistory(ca, page);
        model.addAttribute("healthCardList", pagelist.getList());
        model.addAttribute("page", pagelist.getPage());
        model.addAttribute("paperType", paperType);
        model.addAttribute("paperNo", paperNo);
        return "ihm.healthCard.history";
    }
	
	@RequestMapping("/statistic")
	public String statistic(HttpServletRequest request, HealthCardTargetForm form, Model model) {
		model.addAttribute("currentBeginDate",DateUtil.firstDateOfMonth(new Date()));
		model.addAttribute("currentEndDate",DateUtil.lastDateOfMonth(new Date()));
		return "ihm.healthCard.statistic";
	}
	
	@RequestMapping("/statisticSearch")
	public String statisticSearch(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
		List<Map<String,Object>> list = healthCardTargetService.getCicCitizenCardStatistic(form.getHealthCardCriteria());
		model.addAttribute("statisticList", list);
		model.addAttribute("genreCode",form.getGenreCode());
		return "ihm.healthCard.statisticSearch";
	}
}