/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service;

import java.util.List;

import com.founder.rhip.ehr.dto.DrugReportDTO;
import com.founder.rhip.ehr.entity.clinic.DrugUsage;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;

public interface IDrugService {

    /**
     * 数据获取
     *
     * @param drugReportDTO
     * @return DrugReportDTO
     */
    DrugReportDTO saveDrugData(DrugReportDTO drugReportDTO);

    /**
     * 导出用药数据
     *
     * @param criteria
     * @return DrugReportDTO
     */
    DrugReportDTO exportDrugReport(Criteria criteria);

    /**
     * 用药列表
     *
     * @param page
     * @param criteria
     * @param order
     * @return
     */
    PageList<DrugUsage> getDrugUsage(Page page, Criteria criteria, Order order,String... properties);

    /**
     * 不同类型用药列表
     *
     * @param criteria
     * @return
     */
    List<DrugUsage> getDrugUsages(Criteria criteria,String... properties);

}