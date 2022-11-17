package com.founder.rhip.report.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.util.ArrayUtil;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.RpDrugStatisticsType;
import com.founder.rhip.ehr.entity.report.RpInhospital;
import com.founder.rhip.ehr.service.report.IRpExpenseService;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/report/rpExpense")
public class RpExpenseController extends BaseController {
	
	@Resource(name = "rpExpenseService")
	private IRpExpenseService rpExpenseService;

	@Autowired
	private IDictionaryApp dictionaryApp;
    
	/**
	 * 医院费用查询
	 *
	 * @param request
	 * @param model
	 * @return
	 * 
	 */
    @RequestMapping("/hospitalCosts")
    public String hospitalCosts(HttpServletRequest request,Model model) {
    	//列表URL
    	model.addAttribute("searchUrl", "/report/rpExpense/hospitalCostslist");
    	//页面URL
    	model.addAttribute("listpath", "medicalTarget/hospitalCostsList.jsp");
    	model.addAttribute("opEmHpMarkFlag","1");
    	initOrg(request,model);
        return "ihm.medical.hospitalCosts";
    }

    @RequestMapping("/hospitalCostslist")
    public String hospitalCostslist(HttpServletRequest request,TargetOrgQueryForm form, Model model) {
		Map<String, String> paramMap = form.getParamMap();
		List<Map<String, Object>> reports = rpExpenseService.getRpExpenseMapList(paramMap);
        model.addAttribute("reports", reports);
        model.addAttribute("genreCode",form.getGenreCode());
        return "ihm.medical.hospitalCostslist";
    }

    /**
  	 * 进入门诊费用药品比例查询画面
  	 * @param request
  	 * @param model
  	 * @return
  	 */
  	@RequestMapping("/drug/search/{type}")
  	public String outpatientDrugSearch(@PathVariable String type,HttpServletRequest request,Model model) {
  		Assert.notNull(type);
  		if (!ArrayUtil.contains(RpDrugStatisticsType.getRpDrugStatisticsTypes().toArray(), type)) {
			return null;
		}
  		//列表URL
    	model.addAttribute("searchUrl", "/report/rpExpense/drug/list/"+type);
    	//页面URL
    	model.addAttribute("listpath", "medicalTarget/drugList.jsp");
    	initOrg(request,model);
    	model.addAttribute("type", type);
  		return "rhip.medical.drug.search";
  	} 
  	
      /**
       * 药品比例查询结果画面
       * @param request
       * @param model
       * @return
       */
      @RequestMapping("/drug/list/{type}")
      public String outpatientDrugList(@PathVariable String type, TargetOrgQueryForm form,HttpServletRequest request,ModelMap model) {
    	  Map<String, String> paramMap = form.getParamMap();
    	  paramMap.put("type", type);
          List<Map<String, Object>> reports = rpExpenseService.getRpExpenseMapList(paramMap);
          model.addAttribute("reports", reports);
          model.addAttribute("genreCode",form.getGenreCode());
          return "rhip.medical.drug.list";
      }
      
      /**
		 * 进入疾病经济负担查询画面
		 * @param request
		 * @param model
		 * @return
	  */
    	@RequestMapping("/burden/search")
    	public String burdenSearch(HttpServletRequest request,Model model) {
	    	 initOrg(request, model);
	      	 Page page = super.getPage(request, 1);
	      	 model.addAttribute("page", page);
	         model.addAttribute("searchUrl", "/report/rpExpense/burden/list");
	         model.addAttribute("listpath", "burden/list.jsp");
	         return "rhip.medical.burden.search";
    	} 
    	
       /**
         * 疾病经济负担查询结果画面
         * @param request
         * @param model
         * @return
         */
        @RequestMapping("/burden/list")
        public String burdenList(TargetOrgQueryForm form,HttpServletRequest request,ModelMap model) {
        	Map<String, String> paramMap = form.getParamMap();
        	List<Map<String, Object>> reports = rpExpenseService.getBurdenRpExpenseMapList(paramMap);
    		
    		model.addAttribute("genreCode", paramMap.get("genreCode"));
    		model.addAttribute("results", reports);
    		return "rhip.medical.burden.list";
        }
        
        /**
         * 当查询条件按照镇查询时自动补充统计不到的镇
         * @param paramMap
         * @param rpInhospitalList
         */
        private void fillTown(Map<String, String> paramMap, List<RpInhospital> rpInhospitalList) {
        	if(ObjectUtil.equals(paramMap.get("genreCode"), "0") && ObjectUtil.isNullOrEmpty(paramMap.get("gbCode"))) {
    			//将合计的数据放在列表的最后  目的是让页面更友好
    			RpInhospital totalRp = rpInhospitalList.get(rpInhospitalList.size()-1);
    			rpInhospitalList.remove(rpInhospitalList.size()-1);
    			//获取所有的镇
    			Criteria criteria = new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT);
    			List<DicItem> dicItems = dictionaryApp.queryDicItem(criteria);
    			for(DicItem dicItem : dicItems) {
    				boolean flag = true;
    				for(RpInhospital rpInhospital : rpInhospitalList) {
    					if(ObjectUtil.equals(rpInhospital.getGbCode(), dicItem.getItemCode())) {
    						flag = false;
    					}
    				}
    				if(flag) {
    					RpInhospital rpInhospital = new RpInhospital();
    					rpInhospital.setGbCode(dicItem.getItemCode());
    					rpInhospitalList.add(rpInhospital);
    				}
    			}
    			rpInhospitalList.add(totalRp);
    		}
        }
}