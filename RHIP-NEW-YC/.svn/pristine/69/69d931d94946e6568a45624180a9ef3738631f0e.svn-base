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
import com.founder.rhip.ehr.service.personal.IPersonRecordActivateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("personActivateService")
public class PersonActivateServiceImpl extends AbstractService implements IPersonRecordActivateService {

    @Resource(name = "idmStatusInfoDao")
    private IIdmStatusInfoDao idmStatusInfoDao;        //状态表

    @Override
    /**
     * 根据PersonId激活人员档案
     */
    public void activatePerson(Long personId, String pixId) {
        if(ObjectUtil.isNotEmpty(pixId)){
            Parameters parameters = new Parameters();
            parameters.add("LOGOFF", 0);
            idmStatusInfoDao.update(parameters, new Criteria("pixId",pixId));
        }
    }
}