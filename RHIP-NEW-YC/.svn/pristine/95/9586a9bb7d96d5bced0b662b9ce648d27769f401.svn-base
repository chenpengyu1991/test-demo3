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
import com.founder.rhip.ehr.entity.jj.JjTacceptevent;
import com.founder.rhip.ehr.entity.jj.JjTalarmevent;
import com.founder.rhip.ehr.entity.jj.JjTambulance;
import com.founder.rhip.ehr.entity.jj.JjTtask;

public interface IFirstAidService {

    public PageList<JjTacceptevent> getAcceptEventList(Page page, Criteria criteria);

	public PageList<JjTambulance> getAmbulanceList(Page page, Criteria criteria);

    public PageList<JjTalarmevent> getCallEventList(Page page, Criteria criteria);

    public PageList<JjTtask> getTaskList(Page page, Criteria criteria);

    public JjTacceptevent getAcceptEvent(Criteria criteria);

    public JjTambulance getAmbulance(Criteria criteria);

    public JjTalarmevent getCallEvent(Criteria criteria);

    public JjTtask getTask(Criteria criteria);

}