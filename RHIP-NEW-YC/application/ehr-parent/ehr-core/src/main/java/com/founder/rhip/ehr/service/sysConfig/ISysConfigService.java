/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * <p/>
 * This software is the confidential and proprietary information of Founder.
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service.sysConfig;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.entity.sysConfig.ReportRefreshTime;

/**
 * 系统配置
 *
 * @version 1.0, 2016-05-03
 * @author Cary
 */
public interface ISysConfigService {

    public void saveRefreshTime(ReportRefreshTime reportRefreshTime);

    public ReportRefreshTime getReportRefreshTime(Criteria criteria);


}