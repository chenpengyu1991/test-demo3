package com.founder.rhip.report.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.service.report.IRpPregantWomenHealthcareService;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/report/rpPregnantWomenHealthcare")
public class RpPregnantWomenHealthcareController extends BaseController {
	
	@Resource(name = "rpPregantWomenHealthcareService")
	private IRpPregantWomenHealthcareService rpPregantWomenHealthcareService;

	@Autowired
	private IDictionaryApp dictionaryApp;
	
    //孕产妇保健统计报表

	 /**
     * 进入保健统计页面
     * @param model
     * @return
     */
    @RequestMapping("/search/care")
    public String searchCare(HttpServletRequest request, Model model) {
        model.addAttribute("searchUrl", "/report/rpPregnantWomenHealthcare/care/list");
        model.addAttribute("listpath", "serviceList.jsp");
        initOrg(request, model);
        return "ihm.woman.summary.search";
    }

    /**
     * 保健服务统计列表
     * @param model
     * @return
     */
    @RequestMapping("/care/list")
    public String careList(HttpServletRequest request,TargetOrgQueryForm form, Model model) {
        List<Map<String, Object>> careList = rpPregantWomenHealthcareService.getPregantWomenHealthcareMapList(form.getParamMap());
        model.addAttribute("careList", careList);
        model.addAttribute("genreCode",form.getGenreCode());
        return "ihm.woman.summary";
    }

    //孕产妇保健工作量考核
    /**
     * 孕产妇保健工作量考核
     * @return
     */
    @RequestMapping("/pregant/performanceOrg/index")
    public String searchPregant(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/report/rpPregnantWomenHealthcare/pregant/performanceOrg/list");
        model.addAttribute("listpath", "pregantList.jsp");
        model.addAttribute("flagOrg", 1);
        return "pam.organPerformance.index";
    }
    
    /**
     * 孕产妇保健工作量考核列表
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/pregant/performanceOrg/list")
    public String viewPregantList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
    	Map<String, String> paramMap = form.getParamMap();
    	List<Map<String, Object>> result = rpPregantWomenHealthcareService.getPregantPerformanceOrg(paramMap);
        this.fillTown(paramMap, result);
        
        model.addAttribute("result", result);
        model.addAttribute("genreCode", paramMap.get("genreCode"));
 		return "pam.organPerformance.pregant.performance.list";
    }
    //育龄妇女保健工作量考核
    /**
     * 育龄妇女保健工作量考核
     * @return
     */
    @RequestMapping("/gestational/performanceOrg/index")
    public String searchGestational(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/report/rpPregnantWomenHealthcare/gestational/performanceOrg/list");
        model.addAttribute("listpath", "gestationalList.jsp");
        model.addAttribute("flagOrg", 1);
        return "pam.organPerformance.index";
    }
    
    /**
     * 育龄妇女保健考核列表
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/gestational/performanceOrg/list")
    public String viewGestationalList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
    	Map<String, String> paramMap = form.getParamMap();
    	List<Map<String, Object>> result = rpPregantWomenHealthcareService.getGestationalPerformanceOrg(paramMap);
        this.fillTown(paramMap, result);
        
        model.addAttribute("result", result);
        model.addAttribute("genreCode", paramMap.get("genreCode"));
 		return "pam.organPerformance.gestational.performance.list";
    }
    
    /**
     * 当查询条件按照镇查询时自动补充统计不到的镇
     * @param paramMap
     * @param rpExaminationList
     */
    private void fillTown(Map<String, String> paramMap, List<Map<String, Object>> rpExaminationList) {
    	if(ObjectUtil.equals(paramMap.get("genreCode"), "0") && ObjectUtil.isNullOrEmpty(paramMap.get("gbCode"))) {
 			//将合计的数据放在列表的最后  目的是让页面更友好
    		Map<String, Object> totalRp = rpExaminationList.get(rpExaminationList.size()-1);
 			rpExaminationList.remove(rpExaminationList.size()-1);
 			//获取所有的镇
 			Criteria criteria = new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT);
 			List<DicItem> dicItems = dictionaryApp.queryDicItem(criteria);
 			for(DicItem dicItem : dicItems) {
 				boolean flag = true;
 				for(Map<String, Object> map : rpExaminationList) {
 					if(ObjectUtil.equals(map.get("gb_code"), dicItem.getItemCode())) {
 						flag = false;
 					}
 				}
 				if(flag) {
 					Map<String, Object> tempMap = new HashMap<String, Object>();
 					tempMap.put("gb_code", dicItem.getItemCode());
 					rpExaminationList.add(tempMap);
 				}
 			}
 			rpExaminationList.add(totalRp);
 		}
    }
}