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
import com.founder.fasf.beans.Order;

import com.founder.rhip.ehr.dto.OutpatientReportDTO;
import com.founder.rhip.ehr.entity.clinic.OutpatientInfo;
import com.founder.rhip.ehr.entity.clinic.OutpatientPrescription;

public interface IOutpatientService {

    /**
     * 数据获取
     *
     * @param OutpatientReportDTO
     * @return OutpatientReportDTO
     */
    public OutpatientReportDTO saveOutpatientData(OutpatientReportDTO outpatientReportDTO);

    /**
     * 查看门急诊报告
     *
     * @param Criteria
     * @return OutpatientReportDTO
     */
    public OutpatientReportDTO getOutpatientReport(Criteria criteria);

    /**
     * 导出门急诊报告
     *
     * @param Criteria
     * @return OutpatientReportDTO
     */
    public OutpatientReportDTO exportOutpatientReport(Criteria criteria);

    /**
     * 查看门诊处方详细
     *
     * @param Criteria
     * @return OutpatientReportDTO
     */
    public OutpatientReportDTO getOutpatientDrugDetail(Criteria criteria);

    /**
     * 查看门诊详细
     *
     * @param Criteria
     * @return OutpatientReportDTO
     */
    public OutpatientReportDTO getOutpatientReportDetail(Criteria criteria);
    
    /**
     * 查询门诊登记信息
     * @param page
     * @param criteria
     * @return
     */
    public PageList<OutpatientInfo> getOutpatientInfoList(Page page, Criteria criteria, Order order);
    
    /**
     * 处方查询
     *
     * @param page
     * @param criteria
     * @param order
     * @return
     * @author Ye jianfei
     */
    public PageList<OutpatientPrescription> getOutpatientPrescriptionList(Page page, Criteria criteria, Order order);

    /**
     * 查询门诊信息(有身份证)
     * @param page
     * @param criteria
     * @return
     */
    public PageList<OutpatientInfo> getOutpatientInfoWithIdCard(Page page, Criteria criteria, Order order);

    /**
     * 查询门诊信息(无身份证)
     * @param page
     * @param criteria
     * @return
     */
    public PageList<OutpatientInfo> getOutpatientInfoWithIdCard1(Page page, Criteria criteria, Order order);


}