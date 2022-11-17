/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.he.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.entity.healtheducation.HePromoteUnit;
import com.founder.rhip.ehr.repository.healtheducation.IHePromoteUnitDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("hePromoteUnitService")
public class HePromoteUnitServiceImpl extends AbstractService implements IHePromoteUnitService {

	@Resource(name = "hePromoteUnitDao")
	private IHePromoteUnitDao hePromoteUnitDao;

	public int createHealthPromoteUnit(HePromoteUnit healthPromoteUnit) {
		int result = 0;
		try {
			hePromoteUnitDao.insert(healthPromoteUnit);
			result = 1;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	public int updateHealthPromoteUnit(HePromoteUnit healthPromoteUnit, String... properties) {
		int result = 0;
		try {
			hePromoteUnitDao.update(healthPromoteUnit, properties);
			result = 1;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	public int deleteHealthPromoteUnit(Long... ids) {
		int result = 0;
		try {
			//hePromoteUnitDao.delete(ids);
			hePromoteUnitDao.update(new Parameters("STATUS", "0"), new Criteria("ID", OP.IN, ids));
			result = 1;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	public PageList<HePromoteUnit> findHealthPromoteUnit(Criteria criteria, Page page) {
		return hePromoteUnitDao.getPageList(page, criteria);
	}

	@Override
	public HePromoteUnit getHealthPromoteUnit(Criteria criteria) {
		return hePromoteUnitDao.get(criteria);
	}

}