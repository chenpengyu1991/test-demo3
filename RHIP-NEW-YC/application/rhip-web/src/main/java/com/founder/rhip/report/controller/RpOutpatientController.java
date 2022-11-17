package com.founder.rhip.report.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.service.ihm.IYiZhengService;
import com.founder.rhip.ehr.service.report.IRpOutpatientService;
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
@RequestMapping("/report/rpOutpatient")
public class RpOutpatientController extends BaseController {

	@Resource(name = "rpOutpatientService")
	private IRpOutpatientService rpOutpatientService;

    @Resource(name = "ihmYiZhengService")
    private IYiZhengService yiZhengService;

	@Autowired
	private IDictionaryApp dictionaryApp;
	
	@RequestMapping("/outpatient")
	public String outpatient(HttpServletRequest request, Model model) {
		// 列表URL
		model.addAttribute("searchUrl", "/report/rpOutpatient/outpatientlist");
		// 页面URL
		model.addAttribute("listpath", "medicalTarget/outpatientList.jsp");
		initOrg(request, model);
		return "ihm.medical.outpatient";
	}

	@RequestMapping("/outpatientlist")
	public String outpatientlist(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
		Map<String, String> paramMap = form.getParamMap();
        List<Map<String, Object>> reports = yiZhengService.statisticsOutpatient(paramMap);
        if("320581100000".equals(reports.get(0).get("GB_CODE")) && "0".equals(form.getGenreCode())){
            reports.remove(0);
        };
        model.addAttribute("reports", reports);
        model.addAttribute("genreCode", form.getGenreCode());
		return "ihm.medical.outpatientlist";
	}

	//门急诊人均工作量考核(初始页面)
	@RequestMapping("/organ/outpatient/index")
	public String organOutpatient(HttpServletRequest request, Model model) {
		// 列表URL
		model.addAttribute("searchUrl", "/report/rpOutpatient/organ/outpatientlist");
		// 页面URL
		model.addAttribute("listpath", "outpatientPerformanceList.jsp");
		initOrg(request, model);
		return "pam.organPerformance.index";
	}

	@RequestMapping("/organ/outpatientlist")
	public String oragnOutpatientlist(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
		Map<String, String> paramMap = form.getParamMap();
		List<Map<String, Object>> reports = rpOutpatientService.getOutpatientPerformanceOrg(paramMap);
		this.fillTown(paramMap, reports);
	    
	    model.addAttribute("result", reports);
	    model.addAttribute("genreCode", paramMap.get("genreCode"));
		return "pam.organPerformance.outpatient.performance.list";
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
