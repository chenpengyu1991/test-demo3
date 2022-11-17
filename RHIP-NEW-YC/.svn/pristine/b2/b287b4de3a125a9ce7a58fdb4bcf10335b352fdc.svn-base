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
import com.founder.rhip.ehr.dto.ClinicalChartBasicInfoDTO;
import com.founder.rhip.ehr.dto.ClinicalChartDataDTO;
import com.founder.rhip.ehr.dto.ClinicalChartParam;
import com.founder.rhip.ehr.dto.InpatientItemDTO;
import com.founder.rhip.ehr.dto.InpatientMedicalRecordDto;
import com.founder.rhip.ehr.dto.InpatientReportDTO;
import com.founder.rhip.ehr.dto.InpatientSummaryDTO;
import com.founder.rhip.ehr.dto.OuthostpitalSummaryDTO;
import com.founder.rhip.ehr.entity.clinic.InpatientInfo;

import java.util.List;

public interface IInpatientDataService {

    /**
     * 导出住院数据
     *
     * @param Criteria
     * @return InpatientReportDTO
     */
    InpatientReportDTO exportInpatientReport(Criteria criteria);

    /**
     * 获取住院信息列表
     *
     * @param page
     * @param criteria
     * @return
     */
    @Deprecated
    PageList<InpatientItemDTO> getInpatientList(Page page, Criteria criteria);

    /**
     * 获取临床图表基本信息和周数
     *
     * @param clinicalChartParam
     * @return
     */
    ClinicalChartBasicInfoDTO getClinicalChartBasicInfo(Criteria criteria);

    /**
     * 获取临床图表数据
     *
     * @param clinicalChartParam
     * @return
     */
    ClinicalChartDataDTO getClinicalChart(ClinicalChartParam clinicalChartParam);

    /**
     * 获取住院小结
     *
     * @param paramCriteria
     * @return
     */
    InpatientSummaryDTO getInpatientSummary(Criteria paramCriteria);

    /**
     * 获取出院小结
     *
     * @param paramCriteria
     * @return
     */
    OuthostpitalSummaryDTO getOuthospitalSummary(Criteria paramCriteria);

    /**
     * 病案首页
     *
     * @param criteria
     * @return
     */
    InpatientMedicalRecordDto getMedicalIndex(Criteria criteria);
    
    /**
     * 获取住院信息列表
     * @param page
     * @param criteria
     * @return
     */
    PageList<InpatientInfo> getInpatientPageList(Page page, Criteria criteria, Order order);
    
    /**
     * 获取住院信息
     * @param page
     * @param criteria
     * @return
     */
    InpatientInfo getInpatientInfo(Criteria criteria);

    /**
     * 获取单条住院信息记录
     * @param criteria
     * @return
     */
    List<InpatientInfo> getinpatientInfoList(Criteria criteria);

}