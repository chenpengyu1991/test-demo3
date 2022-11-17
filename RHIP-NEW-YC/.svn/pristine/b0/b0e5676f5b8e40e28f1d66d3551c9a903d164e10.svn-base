/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.dto.DrugReportDTO;
import com.founder.rhip.ehr.entity.clinic.DrugUsage;
import com.founder.rhip.ehr.repository.clinic.IDrugUsageDao;
import com.founder.rhip.mdm.repository.IDicItemDao;

/**
 * 用药记录
 * 
 * @author liuk
 * 
 */
@Service("drugService")
public class DrugServiceImpl extends AbstractService implements IDrugService {

	@Autowired
	private IDrugUsageDao drugUsageDao;

	@Autowired
	private IDicItemDao dicItemDao;

	@Override
	public DrugReportDTO saveDrugData(DrugReportDTO drugReportDTO) {
		DrugReportDTO result = null;
		return result;
	}

	@Override
	public PageList<DrugUsage> getDrugUsage(Page page, Criteria criteria, Order order, String... properties) {
		PageList<DrugUsage> drugUsage = drugUsageDao.getPageList(page, criteria, order, properties);
		return drugUsage;
	}

	@Override
	public DrugReportDTO exportDrugReport(Criteria criteria) {
		return null;
	}

	@Override
	public List<DrugUsage> getDrugUsages(Criteria criteria, String... properties) {
		List<DrugUsage> drugUsageList = drugUsageDao.getList(criteria, properties);
		return drugUsageList;
	}
}
