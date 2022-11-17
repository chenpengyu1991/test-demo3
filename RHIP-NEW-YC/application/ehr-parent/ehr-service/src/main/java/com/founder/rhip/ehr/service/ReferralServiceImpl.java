/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.dto.ReferralReportDTO;

@Service("referralService")
public class ReferralServiceImpl extends AbstractService implements IReferralService {

	/**
	 * 数据获取
	 * @param       ReferralReportDTO
	 * @return      ReferralReportDTO
	 */
	public ReferralReportDTO saveReferralData(ReferralReportDTO ReferralReportDTO) {
		ReferralReportDTO result = null;
		//TODO
		return result;
	}

	/**
	 * 查看转诊数据
	 * @param       Criteria
	 * @return      ReferralReportDTO
	 */
	public ReferralReportDTO getReferralReport(Criteria criteria) {
		ReferralReportDTO result = null;
		//TODO
		return result;
	}

	/**
	 * 导出转诊数据
	 * @param       Criteria
	 * @return      ReferralReportDTO
	 */
	public ReferralReportDTO exportReferralReport(Criteria criteria) {
		ReferralReportDTO result = null;
		//TODO
		return result;
	}

}