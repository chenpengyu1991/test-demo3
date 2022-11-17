package com.founder.rhip.ihm.service;

/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.clinic.TransBloodInfo;


public interface IHospitalBloodUseService {

    public PageList<TransBloodInfo> getHospitalBloodUseList(Page page, Criteria criteria);


    public TransBloodInfo getHospitalBloodUse(Criteria criteria);


}
