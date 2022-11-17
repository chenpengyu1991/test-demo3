package com.founder.rhip.ihm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.ihm.service.IIdmAnalyseTargetService;

/**
 * 疾病控制-传染病疫情趋势分析,传染病分地区统计表 
 */
@Controller
@RequestMapping("/ihm/idm")
public class IdmAnalyseTargetController extends IHMBaseController {

	@Resource(name="idmAnalyseTargetService")
	private IIdmAnalyseTargetService idmAnalyseTargetService;
	
	/**
	 * 进入传染病疫情趋势分析查询
	 *
	 * @param request
	 * @param model
	 * @return
	 * @author Ye jianfei
	 */
    @RequestMapping("/trend/search")
    public String trendSearch(HttpServletRequest request,Model model) {
    	
    	model.addAttribute("organFlag", "1");
    	model.addAttribute("monthRangeFlag", "1");
    	model.addAttribute("quarterRangeFlag", "1");
    	model.addAttribute("rangeFlag", "1");
    	model.addAttribute("rangeFlag", "1");
    	model.addAttribute("trend", "1");
    	
    	initOrg(request,model);
        return "ihm.idm.trend.index";
    }	
    
    /**
     * 1~12月份传染病报卡数据
     *
     * @param request
     * @param form
     * @param model
     * @return
     * @author Ye jianfei
     */
    @RequestMapping("/trend/data")
    @ResponseBody
    public List<Object[]> trendList(HttpServletRequest request,TargetOrgQueryForm form, ModelMap model) {
		form.setYearDate();
    	Map<String, Object> result = idmAnalyseTargetService.getTrendMap(form.getBeginDate()
        		,form.getEndDate()
        		,form.getGenreCode()
        		,form.getGbCode()
        		,form.getSuperOrganCode()
        		,form.getOrganCode()
        		,form.getInfectiousCode());
    	List<Object[]> trend = new ArrayList<>(12);
    	for (int i=1;i<13;i++) {
    		Object[] data = new Object[2];
			data[0] = DateUtil.parseSimpleDate(form.getYearDate() + "/" + String.format("%02d",i), "yyyy/MM");
			data[1] = result.get(String.format("month%02d",i));
			trend.add(data);
    	}
        return trend;
    }
    
    
	/**
	 * 进入 传染病分地区统计表 查询
	 *
	 * @param request
	 * @param model
	 * @return
	 * @author Ye jianfei
	 */
    @RequestMapping("/region/search")
    public String regionSearch(HttpServletRequest request,Model model) {
    	//列表URL
    	model.addAttribute("searchUrl", "/ihm/idm/region/list");
    	//页面URL
    	model.addAttribute("listpath", "list.jsp");
    	initOrg(request,model);
        return "ihm.idm.region.index";
    }
    
    @RequestMapping("/region/list")
    public String regionlist(HttpServletRequest request,TargetOrgQueryForm form, Model model) {
		form.calTime();
		List<Map<String, Object>> reports = idmAnalyseTargetService.getRegionList(form.getBeginDate()
        		,form.getEndDate()
        		,form.getGenreCode()
        		,form.getGbCode()
        		,form.getSuperOrganCode()
        		,form.getOrganCode());
        model.addAttribute("reports", reports);
        model.addAttribute("genreCode",form.getGenreCode());
        return "ihm.idm.region.list";
    }    
 
}