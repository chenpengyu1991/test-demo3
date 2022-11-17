/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.HisWebServiceDto;
import com.founder.rhip.ehr.dto.StudyReportDTO;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.clinic.ImageIndex;
import com.founder.rhip.ehr.entity.clinic.StudyEvent;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.clinic.IImageIndexDao;
import com.founder.rhip.ehr.repository.clinic.IStudyEventDao;
import com.founder.rhip.ehr.repository.clinic.IStudyExamDao;
import com.founder.rhip.ehr.service.util.ValidateUtil;
import com.founder.rhip.ehr.service.util.XmlWebserviceForUtil;

/**
 * 检查服务
 * @author gaogf
 *
 */
@Service("studyService")
public class StudyServiceImpl extends AbstractService implements IStudyService {

	@Resource(name = "studyEventDao")
	private IStudyEventDao studyEventDao;

    @Resource(name = "studyExamDao")
    private IStudyExamDao studyExamDao;

	@Resource
	private IImageIndexDao imageIndexDao;

    @Resource(name = "personInfoDao")
    private IPersonInfoDao personInfoDao;

	/**
	 * 数据获取
	 * 
	 * @param studyReportDTO
	 * @return StudyReportDTO
	 */
	public StudyReportDTO saveStudyData(StudyReportDTO studyReportDTO) {
		StudyReportDTO result = new StudyReportDTO();
		List<StudyEvent> studyEventList = studyReportDTO.getStudyEventList();
		if(ObjectUtil.isNotEmpty(studyEventList)){
			studyEventDao.batchInsert(studyEventList);
			result.setStudyEventList(studyEventList);
		}
		return result;
	}

	/**
	 * 查看详细检查数据
	 * 
	 * @param criteria
	 * @return StudyReportDTO
	 */
	public StudyReportDTO getStudyReport(Criteria criteria) {
		StudyReportDTO result = new StudyReportDTO();
		StudyEvent studyEvent = studyEventDao.get(criteria);
		ImageIndex imageIndex = imageIndexDao.get(criteria);
		result.setStudyEvent(studyEvent);
		result.setImageIndex(imageIndex);
		return result;
	}
	
	/**
	 * 查看详细检查数据
	 * 
	 * @param Criteria
	 * @return StudyReportDTO
	 *//*
	public StudyReportDTO getStudyEvent(Criteria criteria) {
		StudyReportDTO result = new StudyReportDTO();
		StudyEvent studyEvent = studyEventDao.get(criteria);
		result.setStudyEvent(studyEvent);
		
		return result;
	}*/

	/**
	 * 导出检查数据
	 * 
	 * @param criteria
	 * @return StudyReportDTO
	 */
	public StudyReportDTO exportStudyReport(Criteria criteria) {
		StudyReportDTO result = new StudyReportDTO();
		List<StudyEvent> studyEventList = studyEventDao.getList(criteria);
		result.setStudyEventList(studyEventList);
		return result;
	}

	/**
	 * 查看影像数据
	 * 
	 * @param criteria
	 * @return StudyReportDTO
	 */
	public StudyReportDTO getStudyImage(Criteria criteria) {
		StudyReportDTO result = new StudyReportDTO();
		ImageIndex imageIndex = imageIndexDao.get(criteria);
		result.setImageIndex(imageIndex);
		return result;
	}
	
	/**
	 * 检查详细列表
	 * 
	 * @param criteria
	 * @return ExamReportDTO
	 */
	@Override
	public PageList<StudyEvent> getStudyEventList(Page page, Criteria criteria,Order order) {
		PageList<StudyEvent> studyEvents = studyEventDao.getPageList(page,criteria,order);
		return studyEvents;
	}


    /**
     * 综合管理 检查查询页面用(没有身份证)
     * @param page
     * @param criteria
     * @param order
     * @return
     */
    public PageList<StudyEvent> getStudyEvents1(Page page, Criteria criteria, Order order){
        PageList<StudyEvent> studyEvents = studyExamDao.getStudyEvents1(page, criteria, order);
        for(StudyEvent studyEvent : studyEvents.getList()){
            if(ObjectUtil.isNotEmpty(studyEvent.getPersonId())){
                PersonInfo personInfo = personInfoDao.get(studyEvent.getPersonId());
                if(ObjectUtil.isNotEmpty(personInfo)){
                    studyEvent.setIdCard(personInfo.getIdcard());
                }
            }
        }
        return studyEvents;
    }

    /**
     * 综合管理 检查查询页面用 (有身份证)
     * @param page
     * @param criteria
     * @param order
     * @return
     */
    public PageList<StudyEvent> getStudyEvents2(Page page, Criteria criteria, Order order){
        PageList<StudyEvent> studyEvents = studyExamDao.getStudyEvents2(page,criteria,order);
        return studyEvents;
    }

	@Override
	public String isStudy30days(HisWebServiceDto hisWebServiceDto) {
		String validateString = ValidateUtil.doValidate(hisWebServiceDto, "idcard","inspectionType");
		if(ObjectUtil.isNotEmpty(validateString)){
			return XmlWebserviceForUtil.returnError(validateString);
		}
		
		if( ObjectUtil.isNullOrEmpty(hisWebServiceDto.getIdcard()) || ObjectUtil.isNullOrEmpty(hisWebServiceDto.getInspectionType())){
			return XmlWebserviceForUtil.returnError("身份证编码和检查类别均不能为空");
		}
		Criteria criteria = new Criteria();
		Date endDate = DateUtil.getToday().getTime();
		Date nowDate= DateUtil.getBeforeDay(endDate, 30);
		PersonInfo personInfo = personInfoDao.get(new Criteria("IDCARD", hisWebServiceDto.getIdcard()));
		if(ObjectUtil.isNullOrEmpty(personInfo)) {
			return XmlWebserviceForUtil.getString("0",String.class);
		}
		criteria.add("EHR_ID", personInfo.getId()).add("INSPECTION_TYPE", hisWebServiceDto.getInspectionType());
		DateUtil.getCriteriaByDateRange(criteria, "CHECK_DATE", nowDate, endDate);
		List<StudyEvent> studyEvents = studyExamDao.getList(criteria);
		if(ObjectUtil.isNotEmpty(studyEvents)) {
			return XmlWebserviceForUtil.getString("1",String.class);
		}
		return XmlWebserviceForUtil.getString("0",String.class);
	}

}