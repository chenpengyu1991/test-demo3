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

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.repository.ihm.IDaTargetDao;
import com.founder.rhip.ihm.service.IDaTargetService;

@Service("daTargetService")
public class DaTargetServiceImpl extends AbstractService implements IDaTargetService {

	@Resource(name = "daTargetDao")
    private IDaTargetDao daTargetDao; 
	
	@Override
	public PageList<Map<String, Object>> getChangeTargetList(Page page, Criteria criteria, String orgType) {
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) && ObjectUtil.isNotEmpty(criteria)){
			result = daTargetDao.getChangeTargetList(page, criteria, orgType);
		}
		return result;
	}

	@Override
	public PageList<Map<String, Object>> getStorageTargetList(Page page, Criteria criteria, String orgType) {
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) && ObjectUtil.isNotEmpty(criteria)){
			result = daTargetDao.getStorageTargetList(page, criteria, orgType);
		}
		return result;
	}
	@Override
	public List<Map<String, Object>> getChangeTargetSum(Criteria criteria, String orgType) {
		List<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(criteria)){
			result = daTargetDao.getChangeTargetSum(criteria, orgType);
		}
		return result;
	}
	@Override
	public List<Map<String, Object>> getStorageTargetSum(Criteria criteria, String orgType) {
		List<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(criteria)){
			result = daTargetDao.getStorageTargetSum(criteria, orgType);
		}
		return result;
	}

	
}