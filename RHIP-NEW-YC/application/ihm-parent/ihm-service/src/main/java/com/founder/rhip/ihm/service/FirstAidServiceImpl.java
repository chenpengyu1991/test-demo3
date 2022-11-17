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
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.entity.blood.BsBlood2hos;
import com.founder.rhip.ehr.entity.blood.BsBloodDonorInfo;
import com.founder.rhip.ehr.entity.blood.BsBloodbank;
import com.founder.rhip.ehr.entity.blood.BsReimbursement;
import com.founder.rhip.ehr.entity.jj.JjTacceptevent;
import com.founder.rhip.ehr.entity.jj.JjTalarmevent;
import com.founder.rhip.ehr.entity.jj.JjTambulance;
import com.founder.rhip.ehr.entity.jj.JjTtask;
import com.founder.rhip.ehr.repository.ihm.*;
import com.founder.rhip.mdm.service.IDictionaryService;
import com.founder.rhip.mdm.service.IOrganizationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("firstAidService")
public class FirstAidServiceImpl extends AbstractService implements IFirstAidService {

	@Resource(name = "callEventsDao")
    private ICallEventsDao callEventsDao;
	
	@Resource(name="ambulanceDao")
    private IAmbulanceDao ambulanceDao;
	
	@Resource(name="acceptEventDao")
	private IAcceptEventsDao acceptEventsDao;

    @Resource(name="taskDao")
    private ITaskDao taskDao;


    @Override
    public PageList<JjTacceptevent> getAcceptEventList(Page page, Criteria criteria) {
        return acceptEventsDao.getPageList(page, criteria, new Order("ACCEPT_NO", false));
    }

    @Override
    public PageList<JjTambulance> getAmbulanceList(Page page, Criteria criteria) {
        return ambulanceDao.getPageList(page, criteria, new Order("TAMBULANCE_NO", false));
    }

    @Override
    public PageList<JjTalarmevent> getCallEventList(Page page, Criteria criteria) {
        return callEventsDao.getPageList(page, criteria, new Order("EVENT_NO", false));
    }

    @Override
    public PageList<JjTtask> getTaskList(Page page, Criteria criteria) {
        return taskDao.getPageList(page, criteria, new Order("TASK_NO", false));
    }

    @Override
    public JjTacceptevent getAcceptEvent(Criteria criteria) {
        return acceptEventsDao.get(criteria);
    }

    @Override
    public JjTambulance getAmbulance(Criteria criteria) {
        return ambulanceDao.get(criteria);
    }

    @Override
    public JjTalarmevent getCallEvent(Criteria criteria) {
        return callEventsDao.get(criteria);
    }

    @Override
    public JjTtask getTask(Criteria criteria) {
        return taskDao.get(criteria);
    }
}