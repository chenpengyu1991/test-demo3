package com.founder.rhip.report.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.service.report.IRpHealthRecordService;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/report/rpHealthRecord")
public class RpHealthRecordController extends BaseController {

    //居民基本信息建档率

    //居民基本信息及时更新信息

	@Resource(name = "rpHealthRecordService")
	private IRpHealthRecordService rpHealthRecordService;
	
    @Autowired
	private IDictionaryApp dictionaryApp;
	    
	@RequestMapping("/star")
	public String star(Model model, HttpServletRequest request) {
		initOrg(request, model);
		model.addAttribute("searchUrl", "/report/rpHealthRecord/star/result");
		// 不需要按市级医院查询
		model.addAttribute("hospitalFlag", 1);
		//时间需要具体到具体的一天
		model.addAttribute("dateFlag", 1);
		return "ihm.ehr.star.main";
	}

	@RequestMapping("/star/result")
	public String starResult(TargetOrgQueryForm form, Model model, @RequestParam(value = "householdType", required = false) String householdType) {
		Map<String, String> paramMap = form.getParamMap();
		paramMap.put("householdType", householdType);
		List<Map<String, Object>> result = rpHealthRecordService.getHealthRecordStatistics(paramMap);
		 this.fillTown(paramMap, result);
		 
		model.addAttribute("result", result);
        model.addAttribute("genreCode", paramMap.get("genreCode"));
		return "ihm.ehr.star.reslut";
	}
	
	/**
	 * Record string.
	 * 
	 * @return the string
	 */
	@RequestMapping("/recordupdate/index")
	public String recordupdate(HttpServletRequest request,Model model) {
        model.addAttribute("hospitalFlag", "1");//不要市级医院
        model.addAttribute("superOrganFlag", "1");//不要卫生院
		model.addAttribute("searchUrl", "/report/rpHealthRecord/recordupdate/list");
		model.addAttribute("listpath","ehrTarget/recordUpdate/list.jsp");
		initOrg(request,model);
		return "ihm.ehr.recordupdate.index";
	}
	
    /**
     * 健康档案指标
     *
     * @param request
     * @param form
     * @param model
     * @return
     * @author Ye jianfei
     */
    @RequestMapping("/recordupdate/list")
    public String recordupdateList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
    	Map<String, String> paramMap = form.getParamMap();
        List<Map<String, Object>> result = rpHealthRecordService.getModifyTraceStatistics(paramMap);
		this.fillTown(paramMap, result);
		 
		model.addAttribute("result", result);
        model.addAttribute("genreCode", paramMap.get("genreCode"));
        return "ihm.ehr.recordupdate.list";
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
    
    protected void initOrg(HttpServletRequest request, Model model) {
        Organization org = getCurrentOrg(request);
        model.addAttribute("orgCode",org.getOrganCode());
        model.addAttribute("currentBeginDate", new Date());
        model.addAttribute("currentEndDate",DateUtil.lastDateOfMonth(new Date()));
    }
    
}