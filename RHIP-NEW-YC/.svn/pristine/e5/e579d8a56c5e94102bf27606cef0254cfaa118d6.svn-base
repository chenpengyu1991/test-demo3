/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ihm.service;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.clinic.ClinicalPathway;
import com.founder.rhip.ehr.entity.clinic.SickbedUseState;

/**
 * 传染病分析
 * 
 * 
 * @version 1.0, 2014-8-7
 * @author Ye jianfei
 */
public interface IIdmAnalyseTargetService {
	
	/**
	 * 传染病疫情趋势分析信息
	 *
	 * @param beginDate
	 * @param endDate
	 * @param genreCode
	 * @param gbCode
	 * @param parentCode
	 * @param organCode
	 * @param InfectiousCode
	 * @return
	 * @author Ye jianfei
	 */
	public Map<String, Object> getTrendMap(String beginDate
			,String endDate
			,String genreCode
			,String gbCode
			,String parentCode
			,String organCode
			,String infectiousCode);
	
	/**
	 * 传染病分地区统计表
	 *
	 * @param beginDate
	 * @param endDate
	 * @param genreCode
	 * @param gbCode
	 * @param parentCode
	 * @param organCode
	 * @return
	 * @author Ye jianfei
	 */
	public List<Map<String, Object>> getRegionList(String beginDate
			,String endDate
			,String genreCode
			,String gbCode
			,String parentCode
			,String organCode);

}