/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * <p>
 * This software is the confidential and proprietary information of Founder.
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service;

import java.util.List;

import com.founder.rhip.ehr.dto.ExamReportDTO;
import com.founder.rhip.ehr.entity.clinic.ExamineDetail;
import com.founder.rhip.ehr.entity.clinic.ExamineEvent;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;

public interface IExamService {

    ExamReportDTO exportExamReport(Criteria criteria);

    /**
     * 导出检验报告
     *
     * @param criteria
     * @return
     */
    ExamReportDTO getExamReport(Criteria criteria);

    /**
     * 保存检验数据
     *
     * @param examReportDTO
     * @return
     */
    ExamReportDTO saveExamData(ExamReportDTO examReportDTO);

    /**
     * 获取检验列表 包含详细
     *
     * @param criteria
     * @return
     */
    List<ExamReportDTO> getExamEventWithDetailList(Criteria criteria);

    /**
     * 获取检验列表
     *
     * @param page
     * @param criteria
     * @param order
     * @return
     */
    PageList<ExamineEvent> getExamEventList(Page page, Criteria criteria, Order order);

    /**
     * 获取检验详细列表
     *
     * @param page
     * @param criteria
     * @return
     */
    PageList<ExamineDetail> getExamDetailList(Page page, Criteria criteria);

    /**
     * 综合管理 检验查询页面用(没有身份证)
     *
     * @param page
     * @param criteria
     * @param order
     * @return
     */
    PageList<ExamineEvent> getExamEventListWithIdcard1(Page page, Criteria criteria, Order order);

    /**
     * 综合管理 检验查询页面用(有身份证)
     *
     * @param page
     * @param criteria
     * @param order
     * @return
     */
    PageList<ExamineEvent> getExamEventListWithIdcard2(Page page, Criteria criteria, Order order);

    /**
     * 获取检验列表（无页码）
     * @param criteria
     * @return
     */
    List<ExamineEvent> getExamList(Criteria criteria, Order order);

    PageList<ExamineEvent> getIDMExamsResults(Page page, Criteria criteria);

}