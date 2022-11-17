/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ihm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.entity.clinic.TransBloodInfo;
import com.founder.rhip.ehr.entity.nc.NcLog;
import com.founder.rhip.ehr.repository.ihm.*;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("newCitizenScoreService")
public class NewCitizenScoreServiceImpl extends AbstractService implements INewCitizenScoreService {

    
    @Resource(name = "newCitizenScoreDao")
    private INewCitizenScoreDao newCitizenScoreDao;
    
	@Override
	public PageList<NcLog> getNewCitizenScoreList(Page page, Criteria criteria) {
		return newCitizenScoreDao.getPageList(page, criteria);
	}

	@Override
	public NcLog getNewCitizenScore(Criteria criteria) {
		return newCitizenScoreDao.get(criteria);
	}
}
