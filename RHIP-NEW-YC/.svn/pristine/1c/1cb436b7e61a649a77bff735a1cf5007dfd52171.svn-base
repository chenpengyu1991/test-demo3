/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.idm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmOutpatientLog;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.IIdmOutpatientLogDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("idmOutpatientLogService")
public class IdmOutpatientLogServiceImpl extends AbstractService implements IIdmOutpatientLogService {

    @Resource(name = "idmOutpatientLogDao")
    private IIdmOutpatientLogDao idmOutpatientLogDao;

    @Override
    public PageList<IdmOutpatientLog> getPageList(Page page, Criteria ca) {
        PageList<IdmOutpatientLog> plist = idmOutpatientLogDao.getPageList(page, ca);
        return plist;
    }
}