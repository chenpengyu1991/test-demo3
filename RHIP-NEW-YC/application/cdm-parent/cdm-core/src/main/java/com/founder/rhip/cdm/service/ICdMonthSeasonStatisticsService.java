package com.founder.rhip.cdm.service;

import com.founder.rhip.ehr.statisticsdto.TumorMonthSeasonReport;

import java.util.List;
import java.util.Map;

/**
 * 慢病和肿瘤月报和季报
 * 
 * @author liuk
 * 
 */
public interface ICdMonthSeasonStatisticsService {

	/**
	 * 慢病月报
	 * 
	 * @param type
	 * @param orgCode
	 * @param month
	 * @param year
	 * @return
	 */
	List<Map<String, Object>> getCdMonthReport(String type, String gbCode, String orgCode, String month, String year);

	/**
	 * 慢病季报
	 *
	 * @param type
	 * @param orgCode
	 * @param season
	 * @param year
	 * @return
	 */
	List<Map<String, Object>> getCdSeasonReport(String type, String gbCode, String orgCode, String season, String year);

	/**
	 * 肿瘤月报
	 *
	 * @param type
	 * @param orgCode
	 * @param month
	 * @param year
	 * @return
	 */
	TumorMonthSeasonReport getTumorMonthReport(String type, String gbCode, String orgCode, String month, String year);

	/**
	 * 肿瘤季报
	 *
	 * @param type
	 * @param orgCode
	 * @param season
	 * @param year
	 * @return
	 */
	TumorMonthSeasonReport getTumorSeasonReport(String type, String gbCode, String orgCode, String season, String year);

}
