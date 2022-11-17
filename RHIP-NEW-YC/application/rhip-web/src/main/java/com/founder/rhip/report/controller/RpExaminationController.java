package com.founder.rhip.report.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.service.report.RpExaminationEventServiceImpl;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/report/rpExamination")
public class RpExaminationController extends BaseController {

	@Resource(name = "rpExaminationEventService")
    private RpExaminationEventServiceImpl rpExaminationEventService;
    
    @Autowired
	private IDictionaryApp dictionaryApp;
    
    /**
     * 检验结果统计分析
     * @return
     */
    @RequestMapping("/index")
    public String examAnalys(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/report/rpExamination/list");
        model.addAttribute("listpath", "examAnalysList.jsp");
        return "ihm.analys.search";
    }

    /**
     * 检验结果统计分析
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String examAnalysList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
    	Map<String, String> paramMap = form.getParamMap();
    	List<Map<String, Object>> result = rpExaminationEventService.getExaminationEventStatistics(paramMap);
        this.fillTown(paramMap, result);
        
        model.addAttribute("result", result);
        model.addAttribute("genreCode", paramMap.get("genreCode"));
        return "pam.analys.examAnalys.list";
    }

    protected void initOrg(HttpServletRequest request, Model model) {
        Organization org = getCurrentOrg(request);
        model.addAttribute("orgCode",org.getOrganCode());
        model.addAttribute("currentBeginDate", DateUtil.firstDateOfMonth(new Date()));
        model.addAttribute("currentEndDate",DateUtil.lastDateOfMonth(new Date()));
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