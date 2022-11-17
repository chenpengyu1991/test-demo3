/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ihm.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.repository.ihm.IFamilyPlanningDao;

@Service("familyPlanningService")
public class FamilyPlanningServiceImpl implements IFamilyPlanningService {

	@Resource(name = "familyPlanningDao")
    private IFamilyPlanningDao familyPlanningDao;

	@Override
	public PageList<Map<String, Object>> getChildBearingList(Page page,
			Criteria criteria) {
		return familyPlanningDao.getChildBearingList(page, criteria);
	}

	@Override
	public PageList<Map<String, Object>> getWomenDiseaseList(Page page,
			Criteria criteria) {
		return familyPlanningDao.getWomenDiseaseList(page, criteria);
	}

	@Override
	public PageList<Map<String, Object>> getPremaritalHealthList(Page page,
			Criteria criteria) {
		return familyPlanningDao.getPremaritalHealthList(page, criteria);
	}

	@Override
	public Object getChildBearing(String id) {
		return familyPlanningDao.getChildBearing(id);
	}

	@Override
	public Object getWomenDisease(String id) {
		return familyPlanningDao.getWomenDisease(id);
	}

	@Override
	public Object getPremaritalHealth(String id) {
		return familyPlanningDao.getPremaritalHealth(id);
	}

}