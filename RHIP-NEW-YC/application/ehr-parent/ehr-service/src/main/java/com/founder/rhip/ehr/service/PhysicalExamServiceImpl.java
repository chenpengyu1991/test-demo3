/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.dto.ExamSpecialDTO;
import com.founder.rhip.ehr.dto.PhysicalReportDTO;
import com.founder.rhip.ehr.entity.clinic.ExamineDetail;
import com.founder.rhip.ehr.entity.clinic.ExamineEvent;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.entity.clinic.StudyEvent;
import com.founder.rhip.ehr.repository.clinic.IExamineDetailDao;
import com.founder.rhip.ehr.repository.clinic.IExamineEventDao;
import com.founder.rhip.ehr.repository.clinic.IPhysiqueExaminationDao;
import com.founder.rhip.ehr.repository.clinic.IStudyEventDao;

@Service("physicalExamService")
public class PhysicalExamServiceImpl extends AbstractService implements IPhysicalExamService {
	
	@Resource(name = "physiqueExaminationDao")
	private IPhysiqueExaminationDao physiqueExaminationDao;
	
	@Autowired
	private IExamineEventDao examineEventDao;

	@Autowired
	private IStudyEventDao studyEventDao;
	
	@Autowired
	private IExamineDetailDao examineDetailDao;

	/**
	 * 数据获取
	 * @param       PhysicalReportDTO
	 * @return      PhysicalReportDTO
	 */
	public PhysicalReportDTO savePhysicalData(PhysicalReportDTO PhysicalReportDTO) {
		PhysicalReportDTO result = null;
		//TODO
		return result;
	}

	/**
	 * 查看体检报告
	 * @param       Criteria
	 * @return      PhysicalReportDTO
	 */
	public PhysicalReportDTO getPhysicalReport(Criteria criteria) {
		PhysicalReportDTO result = null;
		//TODO
		return result;
	}

	/**
	 * 导出体检报告
	 * @param       Criteria
	 * @return      PhysicalReportDTO
	 */
	public PhysicalReportDTO exportPhysicalReport(Criteria criteria) {
		PhysicalReportDTO result = null;
		//TODO
		return result;
	}
	
	@Override
	public PageList<PhysiqueExamination> getPhysiqueExaminationList(Page page,
			Criteria criteria) {
		return physiqueExaminationDao.getPhysiqueExaminations(criteria, page);
//		return physiqueExaminationDao.getPageList(page, criteria);
	}

	@Override
	public PhysiqueExamination getPhysiqueExamination(Criteria criteria) {
		return physiqueExaminationDao.get(criteria);
	}
}