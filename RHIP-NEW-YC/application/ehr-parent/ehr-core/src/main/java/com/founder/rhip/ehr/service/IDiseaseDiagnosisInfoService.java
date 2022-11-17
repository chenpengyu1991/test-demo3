/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.clinic.DiseaseDiagnosisInfo;

import java.util.List;

public interface IDiseaseDiagnosisInfoService {

    /**
     * 诊断列表
     *
     * @param page
     * @return
     */
    PageList<DiseaseDiagnosisInfo> getDiseaseDiagnosisInfoForCdm(Page page, Criteria criteria);

    /**
     * 获取相关机构
     * @param personId
     * @return
     */
    List<String> getRelationOrganCodes(Long personId);

    /**
     * 获取疾病名称
     * @param criteria
     * @return
     */
    String getDiseaseName(Criteria criteria);
}