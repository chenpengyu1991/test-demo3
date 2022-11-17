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
import com.founder.rhip.ehr.entity.healtheducation.HePrescription;
import com.founder.rhip.ehr.repository.healtheducation.IHePrescriptionDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("hePrescriptionService")
public class HePrescriptionServiceImpl extends AbstractService implements IHePrescriptionService {

	@Resource(name = "hePrescriptionDao")
	private IHePrescriptionDao hePrescriptionDao;

	public int createHealthPrescription(HePrescription healthPrescription) {
		int result = 0;
		try {
			hePrescriptionDao.insert(healthPrescription);
			result = 1;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	public int updateHealthPrescription(HePrescription healthPrescription, String... properties) {
		int result = 0;
		try {
			hePrescriptionDao.update(healthPrescription, properties);
			result = 1;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	public int deleteHealthPrescription(Long... ids) {
		int result = 0;
		try {
			hePrescriptionDao.update(new Parameters("IS_DELETE", "1"), new Criteria("ID", OP.IN, ids));
			result = 1;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	public PageList<HePrescription> findHealthPrescription(Criteria criteria, Page page) {
		criteria.add("IS_DELETE", OP.NE, 1);
		return hePrescriptionDao.getPageList(page, criteria, new Order("CREATE_TIME", false));
	}

	@Override
	public HePrescription getHealthPrescription(Criteria criteria) {
		return hePrescriptionDao.get(criteria);
	}

	@Override
	public int updateStatus(Parameters parameters, Criteria criteria) {
		return hePrescriptionDao.update(parameters, criteria);
	}

}