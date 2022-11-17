/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service.personal.impl;

import org.springframework.stereotype.Service;

import com.founder.rhip.ehr.service.personal.IStatisticReportService;
import com.founder.fasf.service.AbstractService;

@Service("statisticReportService")
public class StatisticReportServiceImpl extends AbstractService implements IStatisticReportService {

	/**
	 * 星级的建档率
	 * @return      void
	 */
	public void statisticCreateRecordRateForStar() {
		//TODO
	}

}