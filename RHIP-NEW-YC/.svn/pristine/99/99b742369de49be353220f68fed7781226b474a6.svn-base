/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 * 精神卫生规范管理
 */

package com.founder.rhip.mhm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.entity.management.mhm.MhmDrug;
import com.founder.rhip.ehr.repository.management.mhm.IMhmStatisticsDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("mhmStatisticsService")
public class MhmStatisticsServiceImpl extends AbstractService implements IMhmStatisticsService {

    @Resource(name = "mhmStatisticsDao")
    private IMhmStatisticsDao mhmStatisticsDao;
	
    @Override
    public PageList<MhmDrug> getDrugResult(Criteria criteria, Page page) {

        return mhmStatisticsDao.getDrugResult(criteria, page);
    }

    @Override
    public List<MhmDrug> getDrugList(Criteria criteria) {

        return mhmStatisticsDao.getDrugList(criteria);
    }

    @Override
    public PageList<MhmDrug> getPatientResult(Criteria criteria, Page page) {
        return mhmStatisticsDao.getPatientResult(criteria, page);
    }

    @Override
    public List<MhmDrug> getPatientList(Criteria criteria) {
        return mhmStatisticsDao.getPatientList(criteria);
    }
}