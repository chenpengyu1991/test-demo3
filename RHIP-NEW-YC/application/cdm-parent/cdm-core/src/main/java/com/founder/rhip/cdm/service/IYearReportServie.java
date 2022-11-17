package com.founder.rhip.cdm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.entity.management.DmPopulaceInfo;
import com.founder.rhip.ehr.statisticsdto.DmYearReport;

import java.util.List;
import java.util.Map;

/**
 * 慢病年报和肿瘤年报
 * 
 * @author liuk
 * 
 */
public interface IYearReportServie {

	/**
	 * 获取慢病年龄年报
	 * 
	 * @param populaceInfo
	 * @param criteria
	 * @return
	 */
	Map<String, List<DmYearReport>> getCdYearReportByAge(DmPopulaceInfo populaceInfo, Criteria criteria);

	/**
	 * 获取慢病性别年报
	 * 
	 * @param populaceInfo
	 * @param criteria
	 * @return
	 */
	Map<String, List<DmYearReport>> getCdYearReportsByGenger(Map<String, Object> populaceMap, Criteria criteria);

	/**
	 * 肿瘤性别年报
	 * 
	 * @param populaceInfo
	 * @param criteria
	 * @return
	 */
	Map<String, List<DmYearReport>> getTumorYearReportsByGenger(Map<String, Object> populaceMap, Criteria criteria);

	/**
	 * 肿瘤年龄年报
	 * 
	 * @param populaceInfo
	 * @param criteria
	 * @return
	 */
	Map<String, List<DmYearReport>> getTumorYearReportByAge(DmPopulaceInfo populaceInfo, Criteria criteria);

	/**
	 * 肿瘤死亡年龄年报
	 * 
	 * @param populaceInfo
	 * @param criteria
	 * @return
	 */
	List<DmYearReport> getTumorDeathYearReportsByAge(Map<String, Object> populaceMap, Criteria criteria);

	/**
	 * 肿瘤死亡性别年报
	 * 
	 * @param populaceInfo
	 * @param criteria
	 * @return
	 */
	List<DmYearReport> getTumorDeathYearReportByGenger(Map<String, Object> populaceMap, Criteria criteria);

}
