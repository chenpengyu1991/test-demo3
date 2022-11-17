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
import com.founder.rhip.ehr.entity.blood.BsBlood2hos;
import com.founder.rhip.ehr.entity.blood.BsBloodDonorInfo;
import com.founder.rhip.ehr.entity.blood.BsBloodbank;
import com.founder.rhip.ehr.entity.blood.BsReimbursement;

import java.util.Map;

public interface IBloodMgntService {

    public PageList<BsBloodDonorInfo> getBloodDonationList(Page page, Criteria criteria);

	public PageList<BsReimbursement> getBloodUseList(Page page, Criteria criteria);

    public PageList<BsBloodbank> getBloodBankList(Page page, Criteria criteria);

    public PageList<BsBlood2hos> getBlood2HosList(Page page, Criteria criteria);

    public BsBloodDonorInfo getBloodDonation(Criteria criteria);

    public BsReimbursement getBloodUse(Criteria criteria);

    public BsBloodbank getBloodBank(Criteria criteria);

    public BsBlood2hos getBlood2Hos(Criteria criteria);

}