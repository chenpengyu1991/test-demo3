package com.founder.rhip.report.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.report.RpTreatmentQuality;
import com.founder.rhip.ehr.service.report.IRpTreatmentQualityService;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/report/rpTreatmentQuality")
public class RpTreatmentQualityController extends BaseController {

	@Resource(name = "rpTreatmentQualityService")
    private IRpTreatmentQualityService rpTreatmentQualityService;
    
    @Autowired
	private IDictionaryApp dictionaryApp;

    /**
     * 治疗质量统计分析
     * @return
     */
    @RequestMapping("/index")
    public String vaccination(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/report/rpTreatmentQuality/list");
        model.addAttribute("listpath", "cureResultAnalysList.jsp");
        return "ihm.analys.search";
    }

    /**
     * 治疗质量统计分析
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String healthExamList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
    	Map<String, String> paramMap = form.getParamMap();
		List<RpTreatmentQuality> rpTreatmentQualityList = rpTreatmentQualityService.getTreatmentQuality(paramMap);
		this.fillTown(paramMap, rpTreatmentQualityList);
		
		model.addAttribute("genreCode", paramMap.get("genreCode"));
		model.addAttribute("results", rpTreatmentQualityList);
		
        return "pam.analys.cureResultAnalys.list";
    }

    /**
     * 当查询条件按照镇查询时自动补充统计不到的镇
     * @param paramMap
     * @param rpTreatmentQualityList
     */
    private void fillTown(Map<String, String> paramMap, List<RpTreatmentQuality> rpTreatmentQualityList) {
    	if(ObjectUtil.equals(paramMap.get("genreCode"), "0") && ObjectUtil.isNullOrEmpty(paramMap.get("gbCode"))) {
			//将合计的数据放在列表的最后  目的是让页面更友好
    		RpTreatmentQuality totalRp = rpTreatmentQualityList.get(rpTreatmentQualityList.size()-1);
			rpTreatmentQualityList.remove(rpTreatmentQualityList.size()-1);
			//获取所有的镇
			Criteria criteria = new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT);
			List<DicItem> dicItems = dictionaryApp.queryDicItem(criteria);
			for(DicItem dicItem : dicItems) {
				boolean flag = true;
				for(RpTreatmentQuality rpTreatmentQuality : rpTreatmentQualityList) {
					if(ObjectUtil.equals(rpTreatmentQuality.getGbCode(), dicItem.getItemCode())) {
						flag = false;
					}
				}
				if(flag) {
					RpTreatmentQuality rpTreatmentQuality = new RpTreatmentQuality();
					rpTreatmentQuality.setGbCode(dicItem.getItemCode());
					rpTreatmentQualityList.add(rpTreatmentQuality);
				}
			}
			rpTreatmentQualityList.add(totalRp);
		}
    }
}