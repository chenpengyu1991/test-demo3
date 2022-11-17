/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.mhm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.management.mhm.MhmDrug;

import java.util.List;

public interface IMhmStatisticsService {

    /**
     *
     * @param criteria
     * @return
     */
	public PageList<MhmDrug> getDrugResult(Criteria criteria, Page page);

    public List<MhmDrug> getDrugList(Criteria criteria);

    /**
     *
     * @param criteria
     * @return
     */
    public PageList<MhmDrug> getPatientResult(Criteria criteria, Page page);

    public List<MhmDrug> getPatientList(Criteria criteria);
}