/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;

import com.founder.rhip.ehr.dto.HisWebServiceDto;
import com.founder.rhip.ehr.dto.StudyReportDTO;
import com.founder.rhip.ehr.entity.clinic.StudyEvent;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;

public interface IStudyService {

    /**
     * 数据获取
     *
     * @param StudyReportDTO
     * @return StudyReportDTO
     */
    public StudyReportDTO saveStudyData(StudyReportDTO StudyReportDTO);

    /**
     * 查看检查数据
     *
     * @param Criteria
     * @return StudyReportDTO
     */
    public StudyReportDTO getStudyReport(Criteria criteria);

    /**
     * 导出检查数据
     *
     * @param criteria
     * @return StudyReportDTO
     */
    public StudyReportDTO exportStudyReport(Criteria criteria);

    PageList<StudyEvent> getStudyEventList(Page page, Criteria criteria, Order order);

    /**
     * 综合管理查询页面用 (没有身份证)
     * @param page
     * @param criteria
     * @param order
     * @return
     */
    PageList<StudyEvent> getStudyEvents1(Page page, Criteria criteria, Order order);

    /**
     * 综合管理查询页面用 (有身份证)
     * @param page
     * @param criteria
     * @param order
     * @return
     */
    PageList<StudyEvent> getStudyEvents2(Page page, Criteria criteria, Order order);

    /** 
	* @Title: isStudy30days 
	* @Description: 患者在最近的三十天是否做过同样检查 1：是 0：否
	* @param @param requestXml
	* @param @return
	* @return String
	* @throws 
	*/
	public String isStudy30days(HisWebServiceDto hisWebServiceDto);
}