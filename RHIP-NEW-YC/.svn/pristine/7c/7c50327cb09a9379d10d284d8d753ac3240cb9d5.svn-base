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
import com.founder.rhip.ehr.entity.healtheducation.HeWorkPlan;
import com.founder.rhip.ehr.repository.healtheducation.IHeWorkPlanDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("heWorkPlanService")
public class HeWorkPlanServiceImpl extends AbstractService implements IHeWorkPlanService {

	@Resource(name = "heWorkPlanDao")
	private IHeWorkPlanDao heWorkPlanDao;

	public int createHeWorkPlan(HeWorkPlan workPlan) {
		int result = 0;
		try {
			heWorkPlanDao.insert(workPlan);
			result = 1;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	public int updateHeWorkPlan(HeWorkPlan workPlan, String... properties) {
		int result = 0;
		try {
			heWorkPlanDao.update(workPlan, properties);
			result = 1;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	public int deleteHeWorkPlan(Long... ids) {
		int result = 0;
		try {
			heWorkPlanDao.update(new Parameters("IS_DELETE", "1"), new Criteria("ID", OP.IN, ids));
			result = 1;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	public PageList<HeWorkPlan> findHeWorkPlan(Criteria criteria, Page page) {
		criteria.add("IS_DELETE", OP.NE, 1);
		return heWorkPlanDao.getPageList(page, criteria, new Order("CREATE_DATE", false));
	}

	@Override
	public HeWorkPlan getHeWorkPlan(Criteria criteria) {
		return heWorkPlanDao.get(criteria);
	}
	
}