package com.founder.rhip.ehr.common;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.mdm.common.OrgGenreCode;

public class RpQueryConditionHelper {
	
	/**
	 * 组织日期查询条件
	 * @param paramMap 条件参数包含日期
	 * @return
	 */
	public static Criteria organizeCriteria(Map<String, String> paramMap){
		Criteria criteria = new Criteria();
		String beginDateStr = paramMap.get("beginDate");
        String endDateStr = paramMap.get("endDate");
        Date beginDate = DateUtil.parseSimpleDate(beginDateStr, null);
		Date endDate = DateUtil.parseSimpleDate(endDateStr, null);
		DateUtil.getCriteriaByDateRange(criteria, "rpDate", beginDate,endDate);
		if (ObjectUtil.isNotEmpty(paramMap.get("opEmHpMark"))) {
			criteria.add("rpType", paramMap.get("opEmHpMark"));
		}
		// 统计药占比
		if (StringUtils.equals(paramMap.get("type"), RpDrugStatisticsType.outpatient.name())) {
			criteria.add("rpType", OP.NE, "3"); //过滤掉住院 1：门诊2：急诊3：住院
		}
		if (StringUtils.equals(paramMap.get("type"), RpDrugStatisticsType.inpatient.name())) {
			criteria.add("rpType", "3"); //过滤掉门诊、急诊1：门诊2：急诊3：住院
		}
		// 儿童年龄统计
		if (ObjectUtil.isNotEmpty(paramMap.get("paCounty"))) {
			criteria.add("paCounty", paramMap.get("paCounty"));
		}
		if (ObjectUtil.isNotEmpty(paramMap.get("paTownShip"))) {
			criteria.add("paTownShip", paramMap.get("paTownShip"));
		}
		if (ObjectUtil.isNotEmpty(paramMap.get("timePoint"))) {
			criteria.add("rpType", paramMap.get("timePoint"));
		}
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
        	orgCondtionBuilder.append(" and organ_code= '" + superOrganCode + "'");
        }
        if(StringUtils.equals(genreCode, OrgGenreCode.STATION.getValue()) && ObjectUtil.isNotEmpty(superOrganCode)){
        	orgCondtionBuilder.append(" and center_code= '" + superOrganCode + "'");
        }
        if(StringUtils.equals(genreCode, OrgGenreCode.STATION.getValue()) && ObjectUtil.isNotEmpty(organCode)){
        	orgCondtionBuilder.append(" and organ_code= '" + organCode + "'");
        }
        if(ObjectUtil.isNotEmpty(gbCode)){
        	orgCondtionBuilder.append(" and GB_CODE= '" + gbCode + "'");
        }
        return orgCondtionBuilder;
	}

}
