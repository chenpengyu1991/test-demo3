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
public interface IDmStatisticsService {
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
	 * @return the population statistics data
	 */
	public List<Map<String, Object>> getCdmStatisticsData(String orgType, String townCode, String centreCode, String stationCode, Date inputBeginDate, Date inputEndDate);
}
