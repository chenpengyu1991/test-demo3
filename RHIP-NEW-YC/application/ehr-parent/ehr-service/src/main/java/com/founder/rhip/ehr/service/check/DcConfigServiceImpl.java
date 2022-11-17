/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * <p/>
 * This software is the confidential and proprietary information of Founder.
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service.check;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.dcConfig.DcParam;
import com.founder.rhip.ehr.repository.ihm.IDcConfigDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("dcConfigService")
public class DcConfigServiceImpl implements IDcConfigService {

    @Resource(name = "dcConfigDao")
    private IDcConfigDao dcConfigDao;


    @Override
    public void saveDcParam(List<DcParam> dcParams) {
        dcConfigDao.batchInsert(dcParams);
    }

    @Override
    public void saveDcParam(DcParam dcParam) {
        Long id = dcParam.getId();
        if (ObjectUtil.isNotEmpty(id)) {
            dcConfigDao.update(dcParam);
        } else {
            dcConfigDao.insert(dcParam);
        }
    }

    @Override
    public PageList<DcParam> getDcParamList(Page page, Criteria criteria) {
        return dcConfigDao.getPageList(page, criteria, new Order("ID", false));
    }

    @Override
    public DcParam getDcParam(Criteria criteria) {
        return dcConfigDao.get(criteria);
    }

    @Override
    public int delete(Criteria criteria) {
        return dcConfigDao.delete(criteria);
    }

}