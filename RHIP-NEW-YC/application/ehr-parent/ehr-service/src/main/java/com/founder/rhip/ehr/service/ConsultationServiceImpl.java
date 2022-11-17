/**
s * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.entity.clinic.ConsultationInfo;
import com.founder.rhip.ehr.repository.clinic.IConsultationInfoDao;

@Service("consultationService")
public class ConsultationServiceImpl extends AbstractService implements IConsultationService {

	@Resource(name = "consultationInfoDao")
	private IConsultationInfoDao consultationInfoDao;



	@Override
	public PageList<ConsultationInfo> getConsultationInfoList(Criteria criteria, Page page){
		return consultationInfoDao.getPageList(page, criteria);
	}

	@Override
	public ConsultationInfo getConsultationInfo(Criteria criteria) {
		return consultationInfoDao.get(criteria);
	}


}