package com.founder.rhip.ihm.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.ihm.service.IEpidemicTargetService;

/**
 * 疫情分析
 * 
 */
@Controller
@RequestMapping("/ihm/idm/epidemic")
public class IdmEpidemicTargetController extends IHMBaseController {
 
    @Resource(name = "epidemicTargetService")
    private IEpidemicTargetService epidemicTargetService;
	
	@RequestMapping("/index")
	public String index(Model model) {
		return "ihm.idm.epidemic.index";
	}
	
    @RequestMapping("/occupation")
    public String occupation(HttpServletRequest request,Model model) {
    	model.addAttribute("organFlag", 1);
    	model.addAttribute("searchUrl", "/ihm/idm/epidemic/occupationlist");
    	model.addAttribute("listpath", "idmTarget/epidemic/occupation/list.jsp");
    	List<Map<String, Object>> occupationTypelist = epidemicTargetService.getOccupationList(null);
        model.addAttribute("occupationTypelist",occupationTypelist);
        model.addAttribute("type", "ihmDa"); // 页面导航文字显示判断
        initOrg(request,model);
        return "ihm.idm.epidemic.search";
    }	
    
    @RequestMapping("/occupationlist")
    public String occupationlist(HttpServletRequest request,TargetOrgQueryForm form, Model model) {
		Criteria criteria = form.getEpidemicCriteria();
        List<Map<String, Object>> occupationTypelist = epidemicTargetService.getOccupationList(new Criteria().addAll(criteria));
        model.addAttribute("occupationTypelist",occupationTypelist);		
        List<Map<String, Object>> occupations = epidemicTargetService.getOccupationTargetList(criteria);
        model.addAttribute("occupationlist",occupations);
        model.addAttribute("genreCode",form.getGenreCode());
        return "ihm.idm.epidemic.occupationlist";
    }
    
    @RequestMapping("/age")
    public String age(HttpServletRequest request, Model model) {
    	model.addAttribute("organFlag", 1);
    	model.addAttribute("searchUrl", "/ihm/idm/epidemic/agelist");
    	model.addAttribute("listpath", "idmTarget/epidemic/age/list.jsp");
    	model.addAttribute("type", "ihmDa"); // 页面导航文字显示判断
    	initOrg(request,model);
        return "ihm.idm.epidemic.search";
    }	
    
    @RequestMapping("/agelist")
    public String storagelist(HttpServletRequest request,TargetOrgQueryForm form, Model model) {
		Criteria criteria = form.getEpidemicCriteria();
        List<Map<String, Object>> agelist = epidemicTargetService.getAgeTargetList(criteria);
        model.addAttribute("agelist", agelist);
        model.addAttribute("genreCode",form.getGenreCode());
        return "ihm.idm.epidemic.agelist";
    } 
}