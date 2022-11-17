/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.hm.service;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.clinic.ElderlyPhyExamination;
import com.founder.rhip.ehr.entity.clinic.HealthEvaluateAnomaly;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;

public interface IPhysiqueExaminationService {

	/**
	 * 数据获取
	 * @param       criteria
	 * @return      PhysiqueExamination
	 */
	public ElderlyPhyExamination getPhysiqueExamination(Criteria criteria);

//	/**
//	 * 获取体检数据
//	 * @param   examRecord
//	 * @return  PhysiqueExamination
//	 */
//	public ElderlyPhyExamination getPhysiqueExamination(PhysicalExamRecord examRecord);

	/**
	 * 更新健康指导
	 *
	 * @param   examination
	 * @param   anomalyDesc
	 * @param   examId
	 * @param examRecordId
	 * @return  boolean
	 */
	public int updateHealthGuide(ElderlyPhyExamination examination, String anomalyDesc, Long examId, Long examRecordId, String ehrId);

	/**
	 * 获取健康评价异常
	 * @param   criteria
	 * @return  List<HealthEvaluateAnomaly>
	 */
	public List<HealthEvaluateAnomaly> getHealthEvaluateAnomaly(Criteria criteria);

	/**
	 * 更新自我评估
	 * @param examination
	 * @param examId
	 * @param examRecordId
	 * @return int
	 */
	public int updateSelfAssessment(ElderlyPhyExamination examination, Long examId, Long examRecordId);

    /**
     * 更新自我评估（平台）
     * @param examination
     * @return int
     */
    public boolean updateSelfAssessment(ElderlyPhyExamination examination);

    public ElderlyPhyExamination getElderlyPhyExamination(Long personId, int year, String type);
	
	/**
	 * 同步体检信息到健康档案体检表
	 */
	public void syncEhrHealthExamination(String organCode);

	public PageList<ElderlyPhyExamination> getPhysiqueExaminationList(Page page, List<Long> idList, String examYear);

    public PageList<ElderlyPhyExamination> getPhysiqueExaminationTableList(Page page, Criteria criteria,
                                                                           String examinationDateStart, String examinationDateEnd,String year);
    
    void updateEchIdentification(PhysiqueExamination physiqueExamination);
}