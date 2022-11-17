/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.da.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.repository.clinic.IConsumableBreakageDao;
import com.founder.rhip.ehr.repository.clinic.IConsumableInDao;
import com.founder.rhip.ehr.repository.clinic.IConsumableInDetailDao;
import com.founder.rhip.ehr.repository.clinic.IConsumableOutDao;
import com.founder.rhip.ehr.repository.clinic.IConsumableOutDetailDao;
import com.founder.rhip.ehr.repository.clinic.IConsumableStoreDao;

@Service("consumableMonitoringService")
public class ConsumableMonitoringServiceImpl extends AbstractService implements IConsumableMonitoringService {
 
	@Resource(name = "consumableStoreDao")
    private IConsumableStoreDao consumableStoreDao;
	
	@Resource(name = "consumableInDao")
    private IConsumableInDao consumableInDao;
	
	@Resource(name = "consumableInDetailDao")
    private IConsumableInDetailDao consumableInDetailDao;	

	@Resource(name = "consumableOutDao")
    private IConsumableOutDao consumableOutDao;
	
	@Resource(name = "consumableOutDetailDao")
    private IConsumableOutDetailDao consumableOutDetailDao;	
	
	@Resource(name = "consumableBreakageDao")
    private IConsumableBreakageDao consumableBreakageDao;

	@Override
	public PageList<Map<String, Object>> getInList(Page page, Criteria criteria) {
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) && ObjectUtil.isNotEmpty(criteria)){
			result = consumableInDao.getPageMapList(page, criteria);
		}
		return result;		
	} 
	
	@Override
	public PageList<Map<String, Object>> getInDetailList(Page page, Criteria criteria){
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) && ObjectUtil.isNotEmpty(criteria)){
			result = consumableInDetailDao.getPageMapList(page, criteria);
		}
		return result;		
	}

	@Override
	public PageList<Map<String, Object>> getOutList(Page page, Criteria criteria){
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) && ObjectUtil.isNotEmpty(criteria)){
			result = consumableOutDao.getPageMapList(page, criteria);
		}
		return result;			
	}
	
	@Override
	public PageList<Map<String, Object>> getOutDetailList(Page page, Criteria criteria){
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) && ObjectUtil.isNotEmpty(criteria)){
			result = consumableOutDetailDao.getPageMapList(page, criteria);
		}
		return result;			
	}
	
	@Override
	public PageList<Map<String, Object>> getStoreList(Page page, Criteria criteria){
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) && ObjectUtil.isNotEmpty(criteria)){
			result = consumableStoreDao.getPageMapList(page, criteria);
		}
		return result;			
	}	
	
	@Override
	public PageList<Map<String, Object>> getBreakageList(Page page, Criteria criteria){
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) && ObjectUtil.isNotEmpty(criteria)){
			result = consumableBreakageDao.getPageMapList(page, criteria);
		}
		return result;			
	}
}