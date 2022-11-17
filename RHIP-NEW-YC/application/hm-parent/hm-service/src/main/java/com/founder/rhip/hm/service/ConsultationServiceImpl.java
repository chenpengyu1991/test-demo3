/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.hm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.clinic.Consultation;
import com.founder.rhip.ehr.repository.clinic.IConsultationDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("personalConsultationService")
public class ConsultationServiceImpl extends AbstractService implements IConsultationService {
    @Resource(name = "consultationDao")
    private IConsultationDao consultationDao;

    @Override
    public Consultation getConsultation(Criteria criteria){
        return consultationDao.get(criteria);
    }

    @Override
    public List<Consultation> getConsultationList(Criteria criteria, Order order, String[] properties){
        return  consultationDao.getList(criteria,order,properties);
    }

    @Override
    public List<Consultation> getConsultationList(Criteria criteria){
        return  consultationDao.getList(criteria);
    }

    @Override
    public boolean saveConsultation(Consultation consultation) {
        if (!ObjectUtil.isNotEmpty(consultation)){
            return false;
        }

        if( ObjectUtil.isNotEmpty(consultation.getId())){
            consultationDao.update(consultation);
        }else{
            consultationDao.insert(consultation);
        }
        return true;
    }
}