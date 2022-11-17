/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ihm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.repository.clinic.IDrugUsageDao;
import com.founder.rhip.ehr.repository.lda.ILdaDao;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("ldaService")
public class LdaServiceImpl extends IhmService implements IldaService {

    @Resource(name = "ldaDao")
    private ILdaDao ldaDao;
    
    @Resource(name = "drugUsageDao")
    private IDrugUsageDao drugUsageDao;

	@Override
	public PageList<Map<String, Object>> getUnusualPrescriptionList(Page page, Criteria criteria,Order order,String monitorIndex,Map<String,String> paramMap) {
		PageList<Map<String, Object>> result = null;
		if(ObjectUtil.isNotEmpty(page) && ObjectUtil.isNotEmpty(criteria)){
			result = ldaDao.getUnusualPrescriptionList(page, criteria,order,monitorIndex,paramMap);
		}
		return result;
	}

	@Override
	public PageList<Map<String, Object>> getAntibacterialsList(Map<String, String> paramMap, Page page) {
		PageList<Map<String, Object>> pageList = new PageList<>();
		if (paramMap == null) {
			return pageList;
		}
		
		return ldaDao.getAntibacterials(paramMap, page);
	}

	@Override
	public List<Map<String, Object>> getDoctors(String orgCode, String medicalCode, String beginDateA,String endDateA) {
		List<Map<String, Object>> results = new ArrayList<>();
		if (ObjectUtil.isNullOrEmpty(orgCode) || ObjectUtil.isNullOrEmpty(medicalCode)) {
			return results;
		}

		return ldaDao.getDoctors(orgCode, medicalCode, beginDateA, endDateA);
	}

	@Override
	public PageList<Map<String, Object>> getDrugStatisticsMapPageList(
			Map<String, String> paramMap, Page page) {
		return drugUsageDao.getDrugMapPageList(paramMap, page);
	}

}