/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * <p/>
 * This software is the confidential and proprietary information of Founder.
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service.sysConfig;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.sysConfig.ReportRefreshTime;
import com.founder.rhip.ehr.repository.sysConfig.IReportRefreshTimeDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("sysConfigService")
public class SysConfigServiceImpl implements ISysConfigService {

    @Resource(name = "reportRefreshTimeDao")
    private IReportRefreshTimeDao reportRefreshTimeDao;

    @Override
    public void saveRefreshTime(ReportRefreshTime reportRefreshTime) {
        Long id = reportRefreshTime.getId();
        if (ObjectUtil.isNotEmpty(id)) {
            reportRefreshTimeDao.update(reportRefreshTime);
        } else {
            reportRefreshTimeDao.insert(reportRefreshTime);
        }
    }

    @Override
    public ReportRefreshTime getReportRefreshTime(Criteria criteria) {
        return reportRefreshTimeDao.get(criteria);
    }
}