/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.clinic.SecrecyDegreeSet;

public interface ISecrecyDegreeService {

    /**
     * 保存设置
     *
     * @param secrecyDegreeSet
     * @return DrugReportDTO
     */
    void save(SecrecyDegreeSet secrecyDegreeSet);

    SecrecyDegreeSet getSecrecyDegree(Criteria criteria);

    /**
     * 设置列表
     *
     * @param page
     * @param criteria
     * @return
     */
    PageList<SecrecyDegreeSet> getSecrecyDegreeList(Page page, Criteria criteria);

    /**
     * 删除设置
     *
     * @param secrecyDegreeSet
     */
    void delete(SecrecyDegreeSet secrecyDegreeSet);

}