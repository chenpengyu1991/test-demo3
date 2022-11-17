/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service.basic;

import java.util.List;
import java.util.Map;

import com.founder.rhip.ehr.entity.basic.StandParameterCfg;
import com.founder.fasf.beans.Criteria;

public interface IStandParameterCfgService {

    /**
     * 获取标准设置列表
     *
     * @return List
     */
    List<StandParameterCfg> getStandParameterList(String standardCode);

    /**
     * 获取标准设计详细
     *
     * @param criteria
     * @return
     */
    StandParameterCfg getStandParameterCfg(Criteria criteria);

    /**
     * 保存标准设计
     *
     * @param stands
     */
    void saveStandParameter(List<StandParameterCfg> stands);

	Map<String, Object> loadRiskFactorModelValues();

	boolean saveRiskFactorModel(List<StandParameterCfg> standParameterCfgList);

    /**
     * 保存标准设计
     *
     * @param standParameterCfg
     */
    void saveStandParameter(StandParameterCfg standParameterCfg);

    void updateStandParameter(String parameterCode, String parameterValue);
}