package com.founder.rhip.ehr.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.entity.basic.HaStatistics;
import com.founder.rhip.ehr.service.statistics.IRecordStatisticsService;
import com.founder.rhip.ehr.service.statistics.RecordStatistics;
import com.founder.rhip.ehr.service.statistics.StarStatistics;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;

/**
 * @author liuk
 * 
 */
@Controller
@RequestMapping("/star")
public class StarStatisticsController extends BaseController {

	@Resource(name="recordStatisticsService")
	private IRecordStatisticsService recordStatisticsService;

	@Autowired
	private IDictionaryApp dictionaryApp;
	
	@Autowired
	private IOrganizationApp organizationApp;
	
	/**
	 * 档案统计
	 * 
	 * @param modelMap
	 * @param request
	 * @return
	 */
	@RequestMapping("/record/statistics/result")
	public String getRecordStatistics(ModelMap modelMap, HttpServletRequest request) {
		Criteria criteria = new Criteria();
		List<RecordStatistics> result = getRecordStatisticsData(criteria, request);
		modelMap.put("recordStatistics", result);
		return "rhip.ehr.statistics.record.admin.result";
	}

	/**
	 * 档案统计 JSON
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 */
	@RequestMapping("/record/statistics/result/json")
	public @ResponseBody List<RecordStatistics> getRecordStatisticsJson(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
		Criteria criteria = new Criteria();
		List<RecordStatistics> result = getRecordStatisticsData(criteria, request);
		return result;
	}

	/**
	 * 镇信息
	 * @return
	 */
	@RequestMapping("/record/statistics/twonorgs")
	public @ResponseBody Map<String, Object> getTwonOrgs(HttpServletRequest request) {
		return getOrgSelectData(request);
	}

	/**
	 * 星级统计 默认打开页面
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping({ "/statistics", "/statistics/sqzx" })
	public String searchIndex(ModelMap modelMap, HttpServletRequest request) {
		buildSearchItems(modelMap);
		return "rhip.ehr.statistics.star.admin";
	}

	/**
	 * 星级统计 搜索结果
	 * 
	 * @param modelMap
	 * @param request
	 * @return
	 */
	@RequestMapping("/statistics/result")
	public String searchIndexResult(ModelMap modelMap, HttpServletRequest request) {
		Criteria criteria = new Criteria();
		List<StarStatistics> result = getStarStatisticsData(criteria, request);
		modelMap.put("starStatisticsList", result);
		return "rhip.ehr.statistics.star.admin.result";
	}

	/**
	 *  星级统计 搜索结果
	 * @param modelMap
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/statistics/result/json")
	public @ResponseBody List<StarStatistics>  searchIndexResultJson(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
		Criteria criteria = new Criteria();
		List<StarStatistics> result = getStarStatisticsData(criteria, request);
		return result;
	}

	/**
	 * 获取档案统计数据
	 * 
	 * @param criteria
	 * @param request
	 * @return
	 */
	private List<RecordStatistics> getRecordStatisticsData(Criteria criteria, HttpServletRequest request) {
		List<RecordStatistics> result = null;
		if (authCheckAndGetOrgCode(criteria, request)) {
			buildRecordParam(request, criteria);
			result = recordStatisticsService.getRecordStatisticsData(criteria);
		}
		return result;
	}

	/**
	 * 获取星级统计数据
	 * 
	 * @param criteria
	 * @param request
	 * @return
	 */
	private List<StarStatistics> getStarStatisticsData(Criteria criteria, HttpServletRequest request) {
		List<StarStatistics> result = null;
		if (authCheckAndGetOrgCode(criteria, request)) {
			buildStarParam(request, criteria);
			result = recordStatisticsService.getStarStatisticsData(criteria);
		}
		return result;
	}

	/**
	 * 权限检查和获取orgId
	 * 
	 * @param criteria
	 * @param request
	 * @return
	 */
	private boolean authCheckAndGetOrgCode(Criteria criteria, HttpServletRequest request) {
		String orgCode = null;
		if (SecurityUtils.hasRole(RoleType.ADMIN, request)
				|| SecurityUtils.hasRole(RoleType.JKJKDN,request)) {
			orgCode = request.getParameter("orgCode");
		} else if (SecurityUtils.hasRole(RoleType.QWGZX,request) ||
				SecurityUtils.hasRole(RoleType.ZXJKDN, request)) {
			orgCode = request.getParameter("orgCode");
			if (ObjectUtil.isNullOrEmpty(orgCode)) {
				Organization organization = SecurityUtils.getCurrentOrganization(request);
				orgCode = organization.getOrganCode();
				if (ObjectUtil.isNullOrEmpty(orgCode)) {
					return false;// 如果orgCode为空,非法访问
				}
			}
		} else {
			return false;
		}
		if (!ObjectUtil.isNullOrEmpty(orgCode)) {
			criteria.add("orgCode", orgCode);
		}
		return true;
	}

	/**
	 * 解析档案统计查询参数
	 * 
	 * @param request
	 * @param criteria
	 */
	private void buildRecordParam(HttpServletRequest request, Criteria criteria) {
		/* 时间范围 */
		String startDateString = request.getParameter("startDate");
		String endDateString = request.getParameter("endDate");
		Date[] dates = DateUtil.getDateRange(startDateString, endDateString);

		if (null != dates[0]) {
			criteria.add("startDate", dates[0]);
		}
		if (null != dates[1]) {
			criteria.add("endDate", dates[1]);
		}

		/* 年龄范围 */
		String startAgeString = request.getParameter("startAge");
		String endAgeString = request.getParameter("endAge");
		Date[] dateAges = DateUtil.getDateRangeByAge(startAgeString, endAgeString);

		if (null != dateAges[0]) {
			criteria.add("birthDayStart", dateAges[0]);
		}
		if (null != dateAges[1]) {
			criteria.add("birthDayEnd", dateAges[1]);
		}

		String gender = request.getParameter("gender");
		if (ObjectUtil.isNotEmpty(gender) && !EHRConstants.NO_SELECTED_FLAG.equals(gender)) {
			criteria.add("gender", gender);// 为空或者是-1:全部
		}
	}

	/**
	 * 搜索参数
	 * 
	 * @param modelMap
	 */
	private void buildSearchItems(ModelMap modelMap) {
		Map<Integer, String> seasonsMap = DateUtil.getSeasonMap();
		Map<Integer, String> monthsmMap = DateUtil.getMonthMap();
		List<Integer> years = DateUtil.getBeforeYears(8);
		modelMap.put("seasonsMap", seasonsMap);
		modelMap.put("monthsmMap", monthsmMap);
		modelMap.put("years", years);
	}

	/**
	 * 解析星级统计查询参数
	 * 
	 * @param request
	 * @param criteria
	 */
	private void buildStarParam(HttpServletRequest request, Criteria criteria) {
		/* 常住类型 */
		String houseType = request.getParameter("houseType");
		if (null != houseType && EHRConstants.UN_HOUSE_HOLDER_LFAG.equals(houseType)) {
			criteria.add("houseType", EHRConstants.UN_HOUSE_HOLDER);
		}
		if (null != houseType && EHRConstants.HOUSE_HOLDER_LFAG.equals(houseType)) {
			criteria.add("houseType", EHRConstants.HOUSE_HOLDER);
		}
		/* 时间范围 */
		String rangeType = request.getParameter("rangeType");
		if (null != rangeType) {
			Date[] dates = null;
			switch (rangeType) {
			case EHRConstants.MONTH_RANGE_LFAG:
				/* 月份 */
				String monthString = request.getParameter("ranget_month");
				int month = Integer.parseInt(monthString);
				dates = DateUtil.getDateRangeByMonth(month);
				break;
			case EHRConstants.SEASON_RANGE_LFAG:
				/* 季节 */
				String seasonString = request.getParameter("ranget_season");
				int season = Integer.parseInt(seasonString);
				dates = DateUtil.getDateRangeBySeason(season);
				break;
			case EHRConstants.YEAR_RANGE_LFAG:
				/* 年 */
				String yearString = request.getParameter("ranget_year");
				String rangeYearType = request.getParameter("rangeYearType");
				int year = Integer.parseInt(yearString);
				/* 默认统计年 */
				if (null == rangeYearType || EHRConstants.STATIC_YEAR_FLAG.equals(rangeYearType)) {
					dates = DateUtil.getDateRangeByYearStatistics(year);
				} else {
					dates = DateUtil.getDateRangeByYear(year);
				}
				break;
			case EHRConstants.DATE_RANGE_LFAG:
				/* 自选时间段 */
				String startDateString = request.getParameter("startDate");
				String endDateString = request.getParameter("endDate");
				dates = DateUtil.getDateRange(startDateString, endDateString);
				break;
			}
			/* 解析后的开始和结束时间 */
			if (null != dates) {
				if (null != dates[0]) {
					criteria.add("startDate", dates[0]);
				}
				if (null != dates[1]) {
					criteria.add("endDate", dates[1]);
				}
			}
		}
	}

	/**
	 * 机构选择
	 * 
	 * @return
	 */
	private Map<String, Object> getOrgSelectData(HttpServletRequest request) {
		//TODO 直接使用控件
		Criteria criteria = new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT);
		if(!hasRole(RoleType.ADMIN, request) && !hasRole(RoleType.JKJKDN, request)) {
			criteria.add(DicItem.ITEM_CODE, getCurrentOrg(request).getGbCode());
		}
		List<DicItem> townDics = dictionaryApp.queryDicItem(criteria);
		Map<String, String> towns = new HashMap<>();
		if (null != townDics) {
			for (DicItem item : townDics) {
				towns.put(item.getItemCode(), item.getItemName());
			}
		}
		List<Organization> organizations = organizationApp.queryOrganization(new Criteria("GENRE_CODE", OrgGenreCode.CENTRE.getValue()));
		Map<String, List<Map<String, String>>> data = new HashMap<>();
		if (null != organizations) {
			for (Organization organization : organizations) {
				String gbCode = organization.getGbCode();
				/* 只要符合上面的gbcode,认为是town的二级数据 */
				if (null != gbCode && gbCode.trim().length() > 0) {
					List<Map<String, String>> orgs = data.get(gbCode);
					if (null == orgs) {
						orgs = new ArrayList<>();
						data.put(gbCode, orgs);
					}
					Map<String, String> note = new HashMap<>();
					note.put("key", organization.getOrganCode());
					note.put("value", organization.getOrganName());
					orgs.add(note);
				}
			}
		}
		Map<String, Object> result = new HashMap<>();
		result.put("towns", towns);
		result.put("orgs", data);
		return  result;
	}

}
