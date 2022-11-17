package com.founder.rhip.report.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.report.RpStudyEvent;
import com.founder.rhip.ehr.service.report.IRpStudyEventService;
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
@RequestMapping("/report/rpStudyEvent")
public class RpStudyEventController extends BaseController {

	@Resource(name = "rpStudyEventService")
    private IRpStudyEventService rpStudyEventService;
    
    @Autowired
	private IDictionaryApp dictionaryApp;
	    
	 /**
     * 检查结果统计分析
     * @return
     */
    @RequestMapping("/index")
    public String studyAnalys(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/report/rpStudyEvent/list");
        model.addAttribute("listpath", "studyAnalysList.jsp");
        return "ihm.analys.search";
    }

    /**
     * 检查结果统计分析
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String studyAnalysList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
    	Map<String, String> paramMap = form.getParamMap();
		List<RpStudyEvent> result = rpStudyEventService.getStudyEventStatistics(paramMap);
		this.fillTown(paramMap, result);
        
        model.addAttribute("result", result);
        model.addAttribute("genreCode", paramMap.get("genreCode"));
        return "pam.analys.studyAnalys.list";
    }
    
    /**
     * 当查询条件按照镇查询时自动补充统计不到的镇
     * @param paramMap
     * @param rpObservationList
     */
    private void fillTown(Map<String, String> paramMap, List<RpStudyEvent> rpObservationList) {
    	if(ObjectUtil.equals(paramMap.get("genreCode"), "0") && ObjectUtil.isNullOrEmpty(paramMap.get("gbCode"))) {
			//将合计的数据放在列表的最后  目的是让页面更友好
			RpStudyEvent totalRp = rpObservationList.get(rpObservationList.size()-1);
			rpObservationList.remove(rpObservationList.size()-1);
			//获取所有的镇
			Criteria criteria = new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT);
			List<DicItem> dicItems = dictionaryApp.queryDicItem(criteria);
			for(DicItem dicItem : dicItems) {
				boolean flag = true;
				for(RpStudyEvent rpStudyEvent : rpObservationList) {
					if(ObjectUtil.equals(rpStudyEvent.getGbCode(), dicItem.getItemCode())) {
						flag = false;
					}
				}
				if(flag) {
					RpStudyEvent rpStudyEvent = new RpStudyEvent();
					rpStudyEvent.setGbCode(dicItem.getItemCode());
					rpObservationList.add(rpStudyEvent);
				}
			}
			rpObservationList.add(totalRp);
		}
    }
}