package com.founder.rhip.phsr.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.dto.ChildCensus;
import com.founder.rhip.he.common.CriteriaOrganizer;
import com.founder.rhip.he.controller.VisitController;
import com.founder.rhip.ihm.service.IchildCensusService;

/**
 * 0-6岁儿童健康管理
 *
 */
@Controller
@RequestMapping(value = "/childCensus")
public class ChildCensusController extends VisitController{
	
	@Resource(name = "childCensusService")
	private IchildCensusService childCensusService;
	
	@RequestMapping("/search")
	public String search(HttpServletRequest request, ModelMap model) {
		model.addAttribute("currentYear",new Date());
		return "rhip.phsr.childCensus.search";
	}
	
	/**
	 * 报表
	 * @param request
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/list")
	public String list(HttpServletRequest request, ModelMap model) {
		Criteria criteria = CriteriaOrganizer.initCriteriaCondition(request.getParameterMap());
		if(hasRole(RoleType.QWGZX,request) && !criteria.contains("gbcode")){
			criteria.add("gbcode",getCurrentOrg(request).getGbCode());
		}
		criteria.remove("date"); // 去除多余的条件
		String summaryType = request.getParameter("summaryType");
		if("1".equals(summaryType)){//按月
			criteria.remove("createBeginTime");
			criteria.remove("createEndTime");
		}else if("2".equals(summaryType)){//按年
			criteria.remove("month");
		}
		criteria.remove("summaryType");
		// 不同身份查询条件
		organizeCriteria(criteria, model, request);
		
		List<ChildCensus> list = childCensusService.getChildCensusList(criteria);
		
		//统计合计信息
		ChildCensus census = new ChildCensus();
		if(ObjectUtil.isNotEmpty(list)){
			int deathSum = 0;
			int visitSum = 0;
			int examineSum1 = 0;
			int examineSum2 = 0;
			int examineSum6 = 0;
			
			int tcmSum1=0;
			int tcmSum2=0;
			int tcmSum6=0;
			
			for (ChildCensus cc : list) {
				deathSum += cc.getDeathCount() == null ? 0 : cc.getDeathCount();
				visitSum += cc.getVisitCount() == null ? 0 : cc.getVisitCount();
				examineSum1 += cc.getExamineCount1() == null ? 0 : cc.getExamineCount1();
				examineSum2 += cc.getExamineCount2() == null ? 0 : cc.getExamineCount2();
				examineSum6 += cc.getExamineCount6() == null ? 0 : cc.getExamineCount6();
				tcmSum1 += cc.getTcmCount1() == null ? 0 : cc.getTcmCount1();
				tcmSum2 += cc.getTcmCount2() == null ? 0 : cc.getTcmCount2();
				tcmSum6 += cc.getTcmCount6() == null ? 0 : cc.getTcmCount6();
			}
			census.setDeathSum(deathSum);
			census.setVisitSum(visitSum);
			census.setExamineSum1(examineSum1);
			census.setExamineSum2(examineSum2);
			census.setExamineSum6(examineSum6);
			census.setTcmSum1(tcmSum1);
			census.setTcmSum2(tcmSum2);
			census.setTcmSum6(tcmSum6);
		}
		
		model.addAttribute("reports", list);
		model.addAttribute("census", census);
		return "rhip.phsr.childCensus.list";
	}
	
}
