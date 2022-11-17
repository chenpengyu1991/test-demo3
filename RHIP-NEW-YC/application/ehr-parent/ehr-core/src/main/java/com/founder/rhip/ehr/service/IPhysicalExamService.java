/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service;

import java.util.List;

import com.founder.rhip.ehr.dto.ExamSpecialDTO;
import com.founder.rhip.ehr.dto.PhysicalReportDTO;
import com.founder.rhip.ehr.entity.clinic.ExamineDetail;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;

public interface IPhysicalExamService {

    /**
     * 数据获取
     *
     * @param PhysicalReportDTO
     * @return PhysicalReportDTO
     */
    public PhysicalReportDTO savePhysicalData(PhysicalReportDTO PhysicalReportDTO);

    /**
     * 查看体检报告
     *
     * @param Criteria
     * @return PhysicalReportDTO
     */
    public PhysicalReportDTO getPhysicalReport(Criteria criteria);

    /**
     * 导出体检报告
     *
     * @param Criteria
     * @return PhysicalReportDTO
     */
    public PhysicalReportDTO exportPhysicalReport(Criteria criteria);
    
    /**
	 * 获取体检专项列表信息
	 * 
	 * @param page
	 * @param criteria
	 * @param order
	 * @return
	 */
	PageList<PhysiqueExamination> getPhysiqueExaminationList(Page page, Criteria criteria);
	
	/**
	 * 获取体检专项详细信息
	 * 
	 * @param criteria
	 * @return
	 */
	PhysiqueExamination getPhysiqueExamination(Criteria criteria);
}