/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 * 传染病上报
 */

package com.founder.rhip.idm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmNcp;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.IIdmNcpDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("idmNcpService")
public class IdmNcpServiceImpl extends AbstractService implements IIdmNcpService {

    @Resource(name = "idmNcpDao")
    private IIdmNcpDao idmNcpDao;

    @Override
    public PageList<IdmNcp> getIdmNcpPageList(Criteria criteria, Page page) {

        Order order = new Order("NAME");
        return idmNcpDao.getPageList(page, criteria,order);
    }
}