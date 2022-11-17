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
import com.founder.rhip.ehr.repository.clinic.IEquipmentBreakageDao;
import com.founder.rhip.ehr.repository.clinic.IEquipmentStoreDao;

@Service("equipmentMonitoringService")
public class EquipmentMonitoringServiceImpl extends AbstractService implements IEquipmentMonitoringService {
 
	@Resource(name = "equipmentStoreDao")
    private IEquipmentStoreDao equipmentStoreDao;
	
	@Resource(name = "equipmentBreakageDao")
    private IEquipmentBreakageDao equipmentBreakageDao;
	
	@Override
	public PageList<Map<String, Object>> getStoreList(Page page, Criteria criteria){
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) && ObjectUtil.isNotEmpty(criteria)){
			result = equipmentStoreDao.getPageMapList(page, criteria);
		}
		return result;			
	}	
	
	@Override
	public PageList<Map<String, Object>> getBreakageList(Page page, Criteria criteria){
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) && ObjectUtil.isNotEmpty(criteria)){
			result = equipmentBreakageDao.getPageMapList(page, criteria);
		}
		return result;			
	}
}