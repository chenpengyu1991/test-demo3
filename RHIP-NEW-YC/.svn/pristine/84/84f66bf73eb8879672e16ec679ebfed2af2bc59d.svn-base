/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 * 精神卫生规范管理
 */

package com.founder.rhip.mhm.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.repository.management.mhm.IMhmHealthTargetDao;
import com.founder.rhip.ehr.service.ihm.IPublicHealthTarget;

import org.springframework.stereotype.Service;

@Service("mhmHealthTargetService")
public class MhmHealthTargetServiceImpl extends AbstractService implements IPublicHealthTarget {

    @Resource(name = "mhmHealthTargetDao")
    private IMhmHealthTargetDao mhmHealthTargetDao;
    
	@Override
	public Float getEHRTarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
		return null;
	}

	@Override
	public Float getHETarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
		return null;
	}

	@Override
	public Float getVaccinateTarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
		return null;
	}

	@Override
	public Float getWomenChildrenTarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
		return null;
	}

	@Override
	public Float getHmTarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
		return null;
	}

	@Override
	public Float getCDMTarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
		return null;
	}

	@Override
	public Float getIDMTarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
		return null;
	}

	@Override
	public Float getHSATarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
		return null;
	}

	@Override
	public Float getMhmTarget(String orgCode,String orgType, Date startDate, Date endDate, String targetCode) {
		Float result = 0F;
		if(ObjectUtil.isNotEmpty(orgCode) 
				&& ObjectUtil.isNotEmpty(orgType)
				&& ObjectUtil.isNotEmpty(targetCode)){
			result = mhmHealthTargetDao.getMhmTarget(orgCode, orgType, startDate, endDate, targetCode);
		}
		return result;
	}

	
}