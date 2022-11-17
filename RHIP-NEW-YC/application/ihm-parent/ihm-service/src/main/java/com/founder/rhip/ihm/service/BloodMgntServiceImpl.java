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
import com.founder.rhip.ehr.entity.blood.BsBlood2hos;
import com.founder.rhip.ehr.entity.blood.BsBloodDonorInfo;
import com.founder.rhip.ehr.entity.blood.BsBloodbank;
import com.founder.rhip.ehr.entity.blood.BsReimbursement;
import com.founder.rhip.ehr.repository.ihm.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("bloodMgntService")
public class BloodMgntServiceImpl extends AbstractService implements IBloodMgntService {

	@Resource(name = "bloodDonationDao")
    private IBloodDonationDao bloodDonationDao;
	
	@Resource(name="bloodUseDao")
    private IBloodUseDao bloodUseDao;
	
	@Resource(name="blood2hosDao")
	private IBlood2hosDao bsBlood2hosDao;

    @Resource(name="bloodBankDao")
    private IBloodBankDao bloodBankDao;


    @Override
    public PageList<BsBloodDonorInfo> getBloodDonationList(Page page, Criteria criteria) {
        return bloodDonationDao.getPageList(page, criteria);
    }

    @Override
    public PageList<BsReimbursement> getBloodUseList(Page page, Criteria criteria) {
        return bloodUseDao.getPageList(page, criteria);
    }

    @Override
    public PageList<BsBloodbank> getBloodBankList(Page page, Criteria criteria) {
        return bloodBankDao.getPageList(page, criteria);
    }

    @Override
    public PageList<BsBlood2hos> getBlood2HosList(Page page, Criteria criteria) {
        return bsBlood2hosDao.getPageList(page, criteria);
    }

    @Override
    public BsBloodDonorInfo getBloodDonation(Criteria criteria) {
        return bloodDonationDao.get(criteria);
    }

    @Override
    public BsReimbursement getBloodUse(Criteria criteria) {
        return bloodUseDao.get(criteria);
    }

    @Override
    public BsBloodbank getBloodBank(Criteria criteria) {
        return bloodBankDao.get(criteria);
    }

    @Override
    public BsBlood2hos getBlood2Hos(Criteria criteria) {
        return bsBlood2hosDao.get(criteria);
    }
}