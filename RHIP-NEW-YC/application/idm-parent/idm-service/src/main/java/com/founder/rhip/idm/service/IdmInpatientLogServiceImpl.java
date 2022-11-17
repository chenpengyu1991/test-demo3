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
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmInpatientLog;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.IIdmInpatientLogDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("idmInpatientLogService")
public class IdmInpatientLogServiceImpl extends AbstractService implements IIdmInpatientLogService {

    @Resource(name = "idmInpatientLogDao")
    private IIdmInpatientLogDao idmInpatientLogDao;
    @Override
    public PageList<IdmInpatientLog> getPageList(Page page, Criteria ca) {
        PageList<IdmInpatientLog> plist = idmInpatientLogDao.getPageList(page, ca);
        return plist;
    }
}