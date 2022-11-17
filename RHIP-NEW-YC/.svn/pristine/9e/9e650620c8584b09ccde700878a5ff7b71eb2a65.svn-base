package com.founder.rhip.ehr.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.founder.rhip.ehr.common.RoleType;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.entity.basic.StatisticsByMonth;
import com.founder.rhip.ehr.service.statistics.IStatisticsByMonthService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;

/**
 * 公卫月报
 * @author ggf
 *
 */
@Controller
@RequestMapping("/statisByMonth")
public class StatisticsByMonthController extends BaseController {
	
	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;
	
	@Autowired
	private IStatisticsByMonthService statisticsByMonthService;

	/**
	 * 跳转到查询首页
	 * @param model
	 * @return
	 */
	@RequestMapping("/index")
	public String index(ModelMap model,HttpServletRequest request) {
		Organization org = SecurityUtils.getCurrentOrganization(request);
		model.addAttribute("statisticsByOrganCode", org.getOrganCode());
		return "rhip.ehr.statisbymonth.search";
	}

	/**
	 * 根据条件查询月报信息
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/result")
	public String getStatisticsResult(HttpServletRequest request, ModelMap model) {
		Criteria criteria=new Criteria();
		int year = 0,month = 0;
		if(ObjectUtil.isNotEmpty(request.getParameter("searchTime"))){
			String searchTime = (String) request.getParameter("searchTime");
			year = Integer.parseInt(searchTime.substring(0,4));
			month = Integer.parseInt(searchTime.substring(5,7));
		}else {
			Calendar now = Calendar.getInstance();
			year = now.get(Calendar.YEAR);
			month = now.get(Calendar.MONTH) + 1;
		}
		criteria.add("recordDate",OP.BETWEEN,getSearchDate(year, month));
		String townCode = request.getParameter("searchTown");
		String centerCode = request.getParameter("searchCenter");
		String centerOrg = request.getParameter("centerName");
		if(StringUtil.isNotEmpty(townCode) && StringUtil.isNotEmpty(centerCode)){
			List<String> codes = this.getOrgCodeByOrgCode(centerCode);
			if(ObjectUtil.isNotEmpty(codes)){
				criteria.add("organCode", OP.IN , codes);
			}else {
				criteria.add("organCode", OP.IN , EHRConstants.NO_RESULT);
			}
			
			criteria.add("organType", EHRConstants.STATION);
		}else if(StringUtil.isNotEmpty(townCode) && StringUtil.isNullOrEmpty(centerCode)){
			List<String> codes = this.getOrgCodeByGBCode(townCode);
			if(ObjectUtil.isNotEmpty(codes)){
				criteria.add("organCode", OP.IN , codes);
			}else {
				criteria.add("organCode", OP.IN , EHRConstants.NO_RESULT);
			}
			criteria.add("organType", EHRConstants.STATION);
		}else if(StringUtil.isNotEmpty(centerOrg)){
			Organization currentOrganization = SecurityUtils.getCurrentOrganization(request);
			List<String> codes = this.getOrgCodeByOrgCode(currentOrganization.getOrganCode());
			if(ObjectUtil.isNotEmpty(codes)){
				criteria.add("organCode", OP.IN , codes);
			}else {
				criteria.add("organCode", OP.IN , EHRConstants.NO_RESULT);
			}
			criteria.add("organType", EHRConstants.STATION);
		}else {
			criteria.add("organType", EHRConstants.TOWN);
		}
		// 常住类型
		if (StringUtils.isNotEmpty(request.getParameter("householdType"))) {
			int householdType = Integer.parseInt(request.getParameter("householdType"));
			if (householdType != -1){
				criteria.add("householdtype", request.getParameter("householdType"));
			}else{
				criteria.add("householdtype", EHRConstants.NO_HOUSE_HOLDER_TYPE);
			}
		}
		List<StatisticsByMonth> statisticsByMonths = statisticsByMonthService.getStatisticsByMonth(criteria);
		model.addAttribute("statisticsByMonths", statisticsByMonths);
		return "rhip.ehr.statisbymonth.result";
	}
	
	private Date[] getSearchDate(int year, int month){
		Date[] searchDate = new Date[2];
		Date end;
		Date start;
		Calendar cal = Calendar.getInstance();
		if(year == cal.get(Calendar.YEAR) && (month == cal.get(Calendar.MONTH) + 1)){
			cal.add(Calendar.DATE, 0);
			cal.set(Calendar.HOUR_OF_DAY, 23);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.SECOND, 59);
			end = cal.getTime();
			Calendar startDate = cal;
			startDate.set(Calendar.HOUR_OF_DAY, 00);
			startDate.set(Calendar.MINUTE, 00);
			startDate.set(Calendar.SECOND, 1);
			start = startDate.getTime();
			
		}else {
			cal.set(Calendar.YEAR, year);
			cal.set(Calendar.MONTH, month);
			int day = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			cal.set(Calendar.DAY_OF_MONTH, day);
			cal.set(Calendar.HOUR_OF_DAY, 23);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.SECOND, 59);
			end = cal.getTime();
			Calendar startDate = cal;
			startDate.set(Calendar.HOUR_OF_DAY, 00);
			startDate.set(Calendar.MINUTE, 00);
			startDate.set(Calendar.SECOND, 1);
			start = startDate.getTime();
		}
		searchDate[0] = start;
		searchDate[1] = end;
		
		return searchDate;
	}
	
	/**
	 * 根据GBCODE得到镇下面所有orgCode
	 * @param gbCode
	 * @return
	 */
	protected List<String> getOrgCodeByGBCode(String gbCode){
		List<String> orgCodesTowns = new ArrayList<String>();
		Criteria criteria = new Criteria("gbCode",gbCode);
		List<Organization> centers = organizationApp.queryOrganization(criteria); //镇下的中心
		if(ObjectUtil.isNotEmpty((centers))){
			List<String> centerCodes = new ArrayList<String>();
			for (Organization organization : centers) {
				centerCodes.add(organization.getOrganCode());
			}
			criteria = new Criteria();
			criteria.add(Organization.PARENT_CODE, OP.IN, centerCodes);
			List<Organization> organizationListThree = organizationApp.queryOrganization(criteria); //服务站
			if(!ObjectUtil.isNullOrEmpty(organizationListThree)){
				for (Organization organization : organizationListThree) {
					orgCodesTowns.add(organization.getOrganCode());
				}
			}
		}
		return orgCodesTowns;
	}
	
	/**
	 * 根据服务中心的orgCode得到下面所有orgCode
	 * @param orgCode
	 * @return
	 */
	protected List<String> getOrgCodeByOrgCode(String orgCode){
		List<String> orgCodes = new ArrayList<String>();
		Criteria criteria = new Criteria(Organization.PARENT_CODE,orgCode);
		List<Organization> organizationList = organizationApp.queryOrganization(criteria);
		if(ObjectUtil.isNullOrEmpty(organizationList)){  
			orgCodes.add(orgCode);
		}else{
			for (Organization organization : organizationList) {
				orgCodes.add(organization.getOrganCode());
			}
		}
		return orgCodes;
	}
}