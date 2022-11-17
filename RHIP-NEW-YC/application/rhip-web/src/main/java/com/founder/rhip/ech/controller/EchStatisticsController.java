package com.founder.rhip.ech.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ech.controller.form.EchManageQueryForm;
import com.founder.rhip.ech.service.IEchManageService;
import com.founder.rhip.ech.service.IEchStatisticsService;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.PhysicalExamRecord;
import com.founder.rhip.hm.service.IPhysicalExamRecordService;
import com.founder.rhip.mdm.entity.Organization;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/ech/statistics")
public class EchStatisticsController extends BaseController {

	@Resource
	private IPhysicalExamRecordService physicalExamRecordService;

	@Resource(name = "echStatisticsService")
	private IEchStatisticsService echStatisticsService;
	
	@RequestMapping("/search")
	public String search(HttpServletRequest request,Model model) {
		initOrg(request, model);
		model.addAttribute("currentYear", new Date());
		return "rhip.ech.statistics.search";
	}

	/**
	 * 查询健康管理统计报表
	 * @param form
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String search(EchManageQueryForm form, ModelMap model, HttpServletRequest request) {
		Criteria criteria = initCriteria(form, request);
		if(hasRole(RoleType.QWGZX,request) && !criteria.contains("gbcode")){
			criteria.add("gbcode",getCurrentOrg(request).getGbCode());
		}
		List<Map<String, Object>> list = echStatisticsService.getStatistics(criteria);
		model.addAttribute("statistics", list);
//		boolean centreFlag = false;
//		if (criteria.contains("inputSuperOrganCode")){
//			centreFlag = true;
//		}
//		model.addAttribute("total", totalStatistics(list,centreFlag));
		model.addAttribute("total", totalStatistics(list,false));
		return "rhip.ech.statistics.list";
	}

	/**
	 * 统计结果合计
	 *
	 * @param list
	 * @param centreFlag
	 * @return
	 * @author Ye jianfei
	 */
	private Map<String, Object> totalStatistics(List<Map<String, Object>> list,boolean centreFlag){
		Map<String, Object> total = new HashMap<String,Object>();
		Integer householdNum = 0;
		Integer manageNum = 0;
		Integer tcmNum = 0;
		Float  manageRate = 0f;
		if(ObjectUtil.isNotEmpty(list)){
			if(centreFlag){
				householdNum += NumberUtil.convert(list.get(0).get("householdNum").toString(),Integer.class);
				manageNum += NumberUtil.convert(list.get(0).get("manageNum").toString(),Integer.class);
				tcmNum += NumberUtil.convert(list.get(0).get("tcmNum").toString(),Integer.class);
			}else{
				for(Map<String, Object> statistic:list){
					householdNum += NumberUtil.convert(statistic.get("householdNum").toString(),Integer.class);
					manageNum += NumberUtil.convert(statistic.get("manageNum").toString(),Integer.class);
					tcmNum += NumberUtil.convert(statistic.get("tcmNum").toString(),Integer.class);
				}				
			}
		}
		if(householdNum > 0){
			manageRate = (float)manageNum/householdNum;
		}
		total.put("householdNum", householdNum);
		total.put("manageNum", manageNum);
		total.put("tcmNum", tcmNum);
		total.put("manageRate", manageRate);
		return total;
	}
	private Criteria initCriteria(EchManageQueryForm form, HttpServletRequest request) {
		Criteria criteria = form.statisticsCriteria();
		Organization org = getCurrentOrg(request);
		String organCode = "";
		if(criteria.contains("inputOrganCode")){
			organCode = criteria.get("inputOrganCode").toString();
		}
		if (StringUtil.isNullOrEmpty(organCode)) {
			if (hasRole(RoleType.ZXZYY, request)) {
				criteria.add("inputSuperOrganCode", org.getOrganCode());
			} else if (hasRole(RoleType.ZZYY, request)) {
				criteria.add("inputOrganCode", org.getOrganCode());
			}
		}else{
			//如果中心登录，选择中心时，查询本中心的数据
			if (hasRole(RoleType.ZXZYY, request) && organCode.equals(org.getOrganCode())) {
				criteria.add("inputSuperOrganCode", organCode);
			}			
		}
		return criteria;
	}
}
