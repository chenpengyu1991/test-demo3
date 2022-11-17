package com.founder.rhip.ehr.common;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.mdm.common.OrgGenreCode;
import org.apache.commons.lang.StringUtils;

import java.util.Date;
import java.util.Map;

public class HmQueryConditionHelper {

	/**
	 * 组织日期查询条件
	 * @param paramMap 条件参数包含日期
	 * @return
	 */
	public static Criteria organizeCriteria(Map<String, String> paramMap){
		Criteria criteria = new Criteria();
		String beginDateStr = paramMap.get("beginDate");
		String endDateStr = paramMap.get("endDate");
		Date beginDate = DateUtil.parseDateString(beginDateStr);
		Date endDate = DateUtil.parseDateString(endDateStr);
		DateUtil.getCriteriaByDateRange(criteria, "CREATE_DATE", beginDate,endDate);
		return criteria;
	}



	/**
	 * 组织机构查询条件
	 * @param paramMap 条件参数包含机构代码
	 * @return
	 */
	public static StringBuilder getOrganizationCondition(Map<String, String> paramMap) {
		StringBuilder orgCondtionBuilder = new StringBuilder();
		String superOrganCode = paramMap.get("superOrganCode");//中心、市级医院
		String organCode = paramMap.get("organCode");//站
		String gbCode = paramMap.get("gbCode");// 镇
		String genreCode = paramMap.get("genreCode");
		if(ObjectUtil.isNotEmpty(genreCode) && !StringUtils.equals("0", genreCode)){
			orgCondtionBuilder.append(" and organ_Type= '" + genreCode + "'");
		}
		if((StringUtils.equals(genreCode, OrgGenreCode.CENTRE.getValue()) || StringUtils.equals(genreCode, OrgGenreCode.HOSPITAL.getValue()))
				&& ObjectUtil.isNotEmpty(superOrganCode)){
			orgCondtionBuilder.append(" and org.organ_code= '" + superOrganCode + "'");
		}
		if(StringUtils.equals(genreCode, OrgGenreCode.STATION.getValue()) && ObjectUtil.isNotEmpty(superOrganCode)){
			orgCondtionBuilder.append(" and center_code= '" + superOrganCode + "'");
		}
		if(StringUtils.equals(genreCode, OrgGenreCode.STATION.getValue()) && ObjectUtil.isNotEmpty(organCode)){
			orgCondtionBuilder.append(" and org.organ_code= '" + organCode + "'");
		}
		if(ObjectUtil.isNotEmpty(gbCode)){
			orgCondtionBuilder.append(" and GB_CODE= '" + gbCode + "'");
		}
		return orgCondtionBuilder;
	}

	/**
	 * 组织机构查询条件
	 * @param paramMap 条件参数包含机构代码
	 * @return
	 */
	public static StringBuilder getVillageCondition(Map<String, String> paramMap) {
		StringBuilder orgCondtionBuilder = new StringBuilder();
		String gbCode = paramMap.get("paCounty");// 镇
		String villageCode = paramMap.get("paTownShip");
		if(ObjectUtil.isNotEmpty(gbCode)){
			orgCondtionBuilder.append(" and GB_CODE= '" + gbCode + "'");
		}
		if(ObjectUtil.isNotEmpty(villageCode)){
			orgCondtionBuilder.append(" and VILLAGE_CODE= '" + villageCode + "'");
		}
		return orgCondtionBuilder;
	}

}
