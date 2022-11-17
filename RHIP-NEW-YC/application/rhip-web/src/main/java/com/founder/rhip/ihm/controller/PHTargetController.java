package com.founder.rhip.ihm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.entity.ihm.HmOutpatient;
import com.founder.rhip.ihm.controller.form.StatisticsQueryForm;

/**
 *各种指标查询
 */
@Controller
@RequestMapping("/ph/target")
public class PHTargetController extends BaseController {

/*
	@RequestMapping("/index")
	public String chmHome(HttpServletRequest request, Model model) {
		return "rhip.ihm.mc.search";
	}
*/

    /**
     *健康档案统计内容
     */
    @RequestMapping(value = "/ehr/list")
    public String ehrTargetList(StatisticsQueryForm form,
                               HttpServletRequest request, ModelMap model) {
        String url = "rhip.ihm.mc.healthRecordList";
        String indexPage = request.getParameter("indexPage");
        int currentPage = Integer.valueOf(indexPage);
        Page page = super.getPage(request, currentPage);
        Criteria ca = null;
        ca = form.getCriteria();
        PageList<HmOutpatient> plist = null;//yiZhengService.statisticsOutpatient(ca,
//				page);

        model.addAttribute("reports", plist);
//		model.addAttribute("page", plist.getPage());
        return url;
    }

    /**
     *健康档案统计内容
     */
	@RequestMapping(value = "/healthEduList")
	public String healthEdu(StatisticsQueryForm form,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.ihm.mc.healthEduList";
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = null;
		ca = form.getCriteria();
		PageList<HmOutpatient> plist = null;//yiZhengService.statisticsOutpatient(ca,
//				page);

		model.addAttribute("reports", plist);
//		model.addAttribute("page", plist.getPage());
		return url;
	}
	
	/**
	 * 预防接种
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/vaccinateList")
	public String vaccinate(StatisticsQueryForm form,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.ihm.mc.vaccinateList";
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = null;
		ca = form.getCriteria();
		PageList<HmOutpatient> plist = null;//yiZhengService.statisticsOutpatient(ca,
//				page);

		model.addAttribute("reports", plist);
		//	model.addAttribute("page", plist.getPage());
		return url;
	}
	
	/**
	 * 儿童保健
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/childHealthList")
	public String childHealth(StatisticsQueryForm form,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.ihm.mc.childHealthList";
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = null;
		ca = form.getCriteria();
		PageList<HmOutpatient> plist = null;//yiZhengService.statisticsOutpatient(ca,
//				page);

		model.addAttribute("reports", plist);
		//model.addAttribute("page", plist.getPage());
		return url;
	}
	
	/**
	 * 孕产妇保健
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/pregnantWomanList")
	public String pregnantWoman(StatisticsQueryForm form,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.ihm.mc.pregnantWomanList";
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = null;
		ca = form.getCriteria();
		PageList<HmOutpatient> plist = null;//yiZhengService.statisticsOutpatient(ca,
//				page);

		model.addAttribute("reports", plist);
		//model.addAttribute("page", plist.getPage());
		return url;
	}
	
	/**
	 * 老年人健康管理
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/elderlyHealthList")
	public String elderlyHealth(StatisticsQueryForm form,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.ihm.mc.elderlyHealthList";
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = null;
		ca = form.getCriteria();
		PageList<HmOutpatient> plist = null;//yiZhengService.statisticsOutpatient(ca,
//				page);

		model.addAttribute("reports", plist);
		//model.addAttribute("page", plist.getPage());
		return url;
	}
	
	/**
	 * 高血压健康管理
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/hypertensionHealthList")
	public String hypertensionHealth(StatisticsQueryForm form,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.ihm.mc.hypertensionHealthList";
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = null;
		ca = form.getCriteria();
		PageList<HmOutpatient> plist = null;//yiZhengService.statisticsOutpatient(ca,
//				page);

		model.addAttribute("reports", plist);
		//model.addAttribute("page", plist.getPage());
		return url;
	}
	
	/**
	 * 2型糖尿病健康管理
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/diabetesHealthList")
	public String diabetesHealth(StatisticsQueryForm form,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.ihm.mc.diabetesHealthList";
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = null;
		ca = form.getCriteria();
		PageList<HmOutpatient> plist = null;//yiZhengService.statisticsOutpatient(ca,
//				page);

		model.addAttribute("reports", plist);
		//model.addAttribute("page", plist.getPage());
		return url;
	}
	
	/**
	 * 重性精神疾病患者管理
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/mentalIllnessList")
	public String mentalIllness(StatisticsQueryForm form,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.ihm.mc.mentalIllnessList";
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = null;
		ca = form.getCriteria();
		PageList<HmOutpatient> plist = null;//yiZhengService.statisticsOutpatient(ca,
//				page);

		model.addAttribute("reports", plist);
		//model.addAttribute("page", plist.getPage());
		return url;
	}
	
	/**
	 * 传染病及突发公共卫生事件报告和处理
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/infectiousDiseasesList")
	public String infectiousDiseases(StatisticsQueryForm form,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.ihm.mc.infectiousDiseasesList";
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = null;
		ca = form.getCriteria();
		PageList<HmOutpatient> plist = null;//yiZhengService.statisticsOutpatient(ca,
//				page);

		model.addAttribute("reports", plist);
		//model.addAttribute("page", plist.getPage());
		return url;
	}
	
	/**
	 * 卫生监督协管
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/healthSupervisionList")
	public String healthSupervision(StatisticsQueryForm form,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.ihm.mc.healthSupervisionList";
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = null;
		ca = form.getCriteria();
		PageList<HmOutpatient> plist = null;//yiZhengService.statisticsOutpatient(ca,
//				page);

		model.addAttribute("reports", plist);
		//model.addAttribute("page", plist.getPage());
		return url;
	}
	 
}
