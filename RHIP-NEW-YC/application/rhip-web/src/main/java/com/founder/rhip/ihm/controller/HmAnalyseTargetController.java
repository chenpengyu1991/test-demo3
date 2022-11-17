package com.founder.rhip.ihm.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.ihm.service.IHmTargetService;

/**
 * 体检-体检人次月、季、年统计表
 */
@Controller
@RequestMapping("/ihm/physicalExam")
public class HmAnalyseTargetController extends IHMBaseController {

	@Resource(name="hmTargetService")
	private IHmTargetService hmTargetService;
	
	
	/**
	 * 体检人次月、季、年统计表查询
	 *
	 * @param request
	 * @param model
	 * @return
	 * @author Ye jianfei
	 */
    @RequestMapping("/statistics/index")
    public String statistics(HttpServletRequest request,Model model) {
    	//列表URL
    	model.addAttribute("searchUrl", "/ihm/physicalExam/statisticslist");
    	//页面URL
    	model.addAttribute("listpath", "physicalExamTarget/statisticslist.jsp");
    	initOrg(request,model);
        return "ihm.physicalExam.statistics.index";
    }	
    
    @RequestMapping("/statisticslist")
    public String statisticslist(HttpServletRequest request,TargetOrgQueryForm form, Model model) {
		form.initMedical();
		List<Map<String, Object>> reports = hmTargetService.getPersonTimeList(form.getBeginDate()
        		,form.getEndDate()
        		,form.getGenreCode()
        		,form.getGbCode()
        		,form.getSuperOrganCode()
        		,form.getOrganCode());
        model.addAttribute("reports", reports);
        model.addAttribute("genreCode",form.getGenreCode());
        return "ihm.physicalExam.statistics.list";
    }
}