package com.founder.rhip.ihm.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * The interface IEhrRecordStatisticsService.
 * 
 * @author liuk
 * @since 2014 /5/21 16:11
 */
public interface IEhrRecordStatisticsService {
	/**
	 * Gets star statistics data.
	 * 
	 * @param orgType
	 *            the org type
	 * @param townCode
	 *            the town code
	 * @param centreCode
	 *            the centre code
	 * @param stationCode
	 *            the station code
	 * @param inputBeginDate
	 *            the input begin date
	 * @param inputEndDate
	 *            the input end date
	 * @param householdType
	 *            the household type
	 * @return the star statistics data
	 */
	List<Map<String, Object>> getStarStatisticsData(String orgType, String townCode, String centreCode, String stationCode, Date inputBeginDate, Date inputEndDate, String householdType);

	/**
	 * Gets record statistics data.
	 * 
	 * @param orgType
	 *            the org type
	 * @param townCode
	 *            the town code
	 * @param centreCode
	 *            the centre code
	 * @param stationCode
	 *            the station code
	 * @param inputBeginDate
	 *            the input begin date
	 * @param inputEndDate
	 *            the input end date
	 * @param ageDateBegin
	 *            the age date begin
	 * @param ageDateEnd
	 *            the age date end
	 * @param gender
	 *            the gender
	 * @return the record statistics data
	 */
	List<Map<String, Object>> getRecordStatisticsData(String orgType, String townCode, String centreCode, String stationCode, Date inputBeginDate, Date inputEndDate, Date ageDateBegin, Date ageDateEnd, String gender);

	/**
	 * Gets population statistics data.
	 * 
	 * @param orgType
	 *            the org type
	 * @param townCode
	 *            the town code
	 * @param centreCode
	 *            the centre code
	 * @param stationCode
	 *            the station code
	 * @param gender
	 *            the gender
	 * @return the population statistics data
	 */
	public List<Map<String, Object>> getPopulationStatisticsData(String orgType, String townCode, String centreCode, String stationCode, Date inputBeginDate, Date inputEndDate, String householdType, String gender);

    public Map<String, Object> getIndexChartData();
}
