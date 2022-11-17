package com.founder.rhip.ihm.controller;

import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.ihm.service.IMdTargetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 十八种住院重点疾病监测指标报表
 */
@Controller
@RequestMapping("/ihm/md")
public class MdTargetController extends IHMBaseController {

	@Resource(name="mdTargetService")
	private IMdTargetService mdTargetService;
	
	/**
	 * 进入传染病疫情趋势分析查询
	 *
	 * @param request
	 * @param model
	 * @return
	 * @author Ye jianfei
	 */
    @RequestMapping("/index")
    public String mdSearch(HttpServletRequest request,Model model) {
    	initOrg(request,model);
        return "ihm.md.index";
    }	
    
     @RequestMapping("/list")
    public String mdlist(HttpServletRequest request,TargetOrgQueryForm form, Model model) {
		form.calTime();
		List<Map<String, Object>> reports = mdTargetService.getMdList(form.getYearDate()
        		,form.getGenreCode()
        		,form.getGbCode()
        		,form.getSuperOrganCode());
        model.addAttribute("reports", reports);
        model.addAttribute("currentYear", form.getYearDate());
        model.addAttribute("genreCode",form.getGenreCode());
         model.addAttribute("gbCode",form.getGbCode());
         model.addAttribute("organCode",form.getSuperOrganCode());
        return "ihm.md.list";
    }    
 
}