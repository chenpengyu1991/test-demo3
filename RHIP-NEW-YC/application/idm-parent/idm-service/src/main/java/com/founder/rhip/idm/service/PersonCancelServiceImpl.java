/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.idm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.IIdmStatusInfoDao;
import com.founder.rhip.ehr.service.IPersonCancelListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("personCancelService")
public class PersonCancelServiceImpl extends AbstractService implements IPersonCancelListener {

    @Resource(name = "idmStatusInfoDao")
    private IIdmStatusInfoDao idmStatusInfoDao;        //状态表

    @Override
    @Transactional
    public void cancelPerson(Long personId, String pixId) {
        if(ObjectUtil.isNotEmpty(personId)){
            Parameters parameters = new Parameters();
            parameters.add("LOGOFF", 1);
            idmStatusInfoDao.update(parameters, new Criteria("personId",personId));
        }
    }
}