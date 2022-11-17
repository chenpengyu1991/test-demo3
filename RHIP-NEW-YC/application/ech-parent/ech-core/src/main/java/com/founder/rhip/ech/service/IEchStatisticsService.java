/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ech.service;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;

public interface IEchStatisticsService {

	/**
	 * 获取体检统计结果
	 * @param criteria
	 * @return
	 */
	public List<Map<String, Object>> getStatistics(Criteria criteria);
}