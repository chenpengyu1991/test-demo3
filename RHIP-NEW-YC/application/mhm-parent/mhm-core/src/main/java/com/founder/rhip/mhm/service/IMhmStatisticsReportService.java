/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.mhm.service;

import java.util.List;
import java.util.Map;

import com.founder.rhip.ehr.dto.mhm.MhmStatisticsReportDto;

public interface IMhmStatisticsReportService {

	/**
	 * 中心角色统计报表
	 *
	 * @param year
	 * @param month
	 * @param quarter
	 * @param centerCode
	 * @param stationCode
	 * @return
	 * @author Ye jianfei
	 */
	public List<MhmStatisticsReportDto> getStationResult(String year, String month, Integer quarter,String centerCode,String stationCode);
	
	/**
	 * 精防中心角色统计报表
	 *
	 * @param year
	 * @param month
	 * @param quarter
	 * @param townCode
	 * @param centreCode
	 * @return
	 * @author Ye jianfei
	 */
	public List<MhmStatisticsReportDto> getCentreResult(String year, String month, Integer quarter,String townCode,String centerCode);	
}