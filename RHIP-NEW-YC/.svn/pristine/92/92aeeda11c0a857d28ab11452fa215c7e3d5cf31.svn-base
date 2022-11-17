package com.founder.rhip.report.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.service.report.IRpPremaritalExaminationService;
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
@RequestMapping("/report/rpPremaritalExamination")
public class RpPremaritalExaminationController extends BaseController {
	
	@Resource(name = "rpPremaritalExaminationService")
	private IRpPremaritalExaminationService rpPremaritalExaminationService;

	@Autowired
	private IDictionaryApp dictionaryApp;
	
    //男女婚检统计分析
	/**
    * 进入 男女婚检统计页面
    * @param model
    * @return
    */
   @RequestMapping("/search/premarital")
   public String searchPremarital(HttpServletRequest request, Model model) {
       model.addAttribute("searchUrl", "/report/rpPremaritalExamination/premarital/list");
       model.addAttribute("listpath", "premaritalCheckStatisticsList.jsp");
       initOrg(request, model);
       return "ihm.fp.statistics";
   }

   /**
    * 男女婚检统计列表
    * @param model
    * @return
    */
   @RequestMapping("/premarital/list")
   public String premaritalList(HttpServletRequest request,TargetOrgQueryForm form, Model model) {
       List<Map<String, Object>> statisticslist = rpPremaritalExaminationService.getPremaritalExaminationMapList(form.getParamMap());
       model.addAttribute("statisticslist", statisticslist);
       model.addAttribute("genreCode",form.getGenreCode());
       return "ihm.fp.statisticslist";
   }

    //男女婚检工作量考核(机构)
   
   /**
    * 男女婚检工作量考核
    * @return
    */
   @RequestMapping("/performanceOrg/index")
   public String searchPremaritalExamination(HttpServletRequest request, Model model) {
       initOrg(request, model);
       model.addAttribute("searchUrl", "/report/rpPremaritalExamination/performanceOrg/list");
       model.addAttribute("listpath", "premaritalList.jsp");
       model.addAttribute("flagOrg", 1);
       return "pam.organPerformance.index";
   }
   
   /**
    * 男女婚检工作量考核列表
    * @param request
    * @param form
    * @param model
    * @return
    */
   @RequestMapping("/performanceOrg/list")
   public String viewPremaritalExaminationList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
   	Map<String, String> paramMap = form.getParamMap();
   	List<Map<String, Object>> result = rpPremaritalExaminationService.getPremaritalPerformanceOrg(paramMap);
       this.fillTown(paramMap, result);
       
       model.addAttribute("result", result);
       model.addAttribute("genreCode", paramMap.get("genreCode"));
		return "pam.organPerformance.premarital.performance.list";
   }
   
   /**
    * 当查询条件按照镇查询时自动补充统计不到的镇
    * @param paramMap
    * @param rpInhospitalList
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