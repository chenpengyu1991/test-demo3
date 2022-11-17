/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.hm.service;


import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.rhip.ehr.entity.clinic.Consultation;

import java.util.List;

public interface IConsultationService {
	/**
	 * 会诊记录详细
	 */
	public Consultation getConsultation(Criteria criteria);

	/**
	 * 会诊记录列表
	 */
	public List<Consultation> getConsultationList(Criteria criteria, Order order, String[] properties);

	public List<Consultation> getConsultationList(Criteria criteria);

	/**
	 * 新增会诊记录
	 */
	public boolean saveConsultation(Consultation consultation);

}