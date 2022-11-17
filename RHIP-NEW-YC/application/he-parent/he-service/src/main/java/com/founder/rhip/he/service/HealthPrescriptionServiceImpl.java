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
import com.founder.rhip.ehr.entity.healtheducation.HealthPrescription;
import com.founder.rhip.ehr.repository.healtheducation.IHealthPrescriptionDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("healthPrescriptionService")
public class HealthPrescriptionServiceImpl extends AbstractService implements IHealthPrescriptionService {

	@Resource(name = "healthPrescriptionDao")
	private IHealthPrescriptionDao healthPrescriptionDao;

	@Override
	public int createHealthPrescription(HealthPrescription healthPrescription) {
		int result = 0;
		try {
			healthPrescriptionDao.insert(healthPrescription);
			result = 1;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	@Override
	public int updateHealthPrescription(HealthPrescription healthPrescription, String... properties) {
		int result = 0;
		try {
			healthPrescriptionDao.update(healthPrescription, properties);
			result = 1;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	@Override
	public int deleteHealthPrescription(Long... ids) {
		int result = 0;
		try {
			healthPrescriptionDao.update(new Parameters("IS_DELETE", "1"), new Criteria("ID", OP.IN, ids));
			result = 1;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	@Override
	public PageList<HealthPrescription> findHealthPrescription(Criteria criteria, Page page) {
		criteria.add("IS_DELETE", OP.NE, 1);
		return healthPrescriptionDao.getPageList(page, criteria, new Order("CREATE_TIME", false));
	}

	@Override
	public HealthPrescription getHealthPrescription(Criteria criteria) {
		return healthPrescriptionDao.get(criteria);
	}

	@Override
	public int updateStatus(Parameters parameters, Criteria criteria) {
		return healthPrescriptionDao.update(parameters, criteria);
	}

}