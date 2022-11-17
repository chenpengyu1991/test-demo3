/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * <p>
 * This software is the confidential and proprietary information of Founder.
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service;

import java.util.ArrayList;
import java.util.List;

import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.clinic.IExamineEventQueryDao;
import com.founder.rhip.ehr.repository.clinic.IStudyExamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.ExamReportDTO;
import com.founder.rhip.ehr.entity.clinic.ExamineDetail;
import com.founder.rhip.ehr.entity.clinic.ExamineEvent;
import com.founder.rhip.ehr.repository.clinic.IExamineDetailDao;
import com.founder.rhip.ehr.repository.clinic.IExamineEventDao;

import javax.annotation.Resource;

/**
 * 检验
 *
 * @author liuk
 *
 */
@Service("examService")
public class ExamServiceImpl extends AbstractService implements IExamService {

    @Autowired
    private IExamineDetailDao examineDetailDao;
    @Autowired
    private IExamineEventDao examineEventDao;

    @Resource(name = "examineQueryEventDao")
    private IExamineEventQueryDao examineEventQueryDao;

    @Resource(name = "personInfoDao")
    private IPersonInfoDao personInfoDao;

    @Override
    public ExamReportDTO saveExamData(ExamReportDTO examReportDTO) {
        ExamReportDTO result = null;
        // TODO 数据重复检查？
        if (ObjectUtil.isNotEmpty(examReportDTO)) {
            ExamineEvent examineEvent = examReportDTO.getExamineEvent();
            if (null != examineEvent) {
                examineEventDao.insert(examineEvent);
            }
            List<ExamineDetail> examineDetails = examReportDTO.getExamineDetails();
            if (null != examineDetails && examineDetails.size() > 0) {
                examineDetailDao.batchInsert(examineDetails);
            }
            result = examReportDTO;// TODO 需要返回什么数据
        }
        return result;
    }

    @Override
    public PageList<ExamineDetail> getExamDetailList(Page page, Criteria criteria) {
        PageList<ExamineDetail> examineDetails = examineDetailDao.getPageList(page, criteria);
        return examineDetails;
    }

    /**
     * 综合管理 检验查询页面用(没有身份证)
     *
     * @param page
     * @param criteria
     * @param order
     * @return
     */
    public PageList<ExamineEvent> getExamEventListWithIdcard1(Page page, Criteria criteria, Order order) {
        PageList<ExamineEvent> examineEvents = examineEventDao.getPageList(page, criteria, order);
        for (ExamineEvent examineEvent : examineEvents.getList()) {
            if (ObjectUtil.isNotEmpty(examineEvent.getPersonId())) {
                PersonInfo personInfo = personInfoDao.get(examineEvent.getPersonId());
                if (ObjectUtil.isNotEmpty(personInfo)) {
                    examineEvent.setIdcard(personInfo.getIdcard());
                }
            }
        }
        return examineEvents;
    }


    /**
     * 综合管理 检验查询页面用(有身份证)
     *
     * @param page
     * @param criteria
     * @param order
     * @return
     */
    public PageList<ExamineEvent> getExamEventListWithIdcard2(Page page, Criteria criteria, Order order) {
        PageList<ExamineEvent> examineEvents = examineEventQueryDao.getExamEventsWithIdCard(page, criteria, order);
        return examineEvents;
    }

    @Override
    public List<ExamineEvent> getExamList(Criteria criteria, Order order) {
        return examineEventDao.getList(criteria, order);
    }

    @Override
    public PageList<ExamineEvent> getExamEventList(Page page, Criteria criteria, Order order) {
        PageList<ExamineEvent> examineEvents = examineEventDao.getPagedListWithoutHiv(page, criteria, order);
        return examineEvents;
    }

    @Override
    public List<ExamReportDTO> getExamEventWithDetailList(Criteria criteria) {
        List<ExamineEvent> examineEvents = examineEventDao.getListWithoutHiv(criteria, null);
        List<ExamReportDTO> examReportsDtos = null;
        if (null != examineEvents) {
            examReportsDtos = new ArrayList<ExamReportDTO>();
            Order order = new Order("CHECK_DATE");// 事件详细默认排序
            for (ExamineEvent examineEvent : examineEvents) {
                ExamReportDTO examReportsDto = new ExamReportDTO();
                examReportsDtos.add(examReportsDto);
                // 根据事件查找到详细数据
                Criteria getDatailParamCriteria = new Criteria("ehrId", examineEvent.getEhrId());
                getDatailParamCriteria.add("personId", examineEvent.getPersonId());
                getDatailParamCriteria.add("examinationNumber", examineEvent.getExaminationNumber());
                List<ExamineDetail> examineDetails = examineDetailDao.getList(getDatailParamCriteria, order);
                examReportsDto.setExamineDetails(examineDetails);
                examReportsDto.setExamineEvent(examineEvent);
            }
        }
        return examReportsDtos;
    }

    @Override
    public ExamReportDTO getExamReport(Criteria criteria) {
        ExamReportDTO result = null;
        List<ExamineEvent> examineEvents = examineEventDao.getListWithoutHiv(criteria, null);
        if (ObjectUtil.isNotEmpty(examineEvents)) {
            ExamineEvent examineEvent = examineEvents.get(0);
            if (null != examineEvent) {
                result = new ExamReportDTO();
                Order order = new Order("CHECK_DATE", false);// 事件详细默认排序
                Criteria getDatailParamCriteria = new Criteria("ehrId", examineEvent.getEhrId());
                getDatailParamCriteria.add("personId", examineEvent.getPersonId());
                getDatailParamCriteria.add("examinationNumber", examineEvent.getExaminationNumber());
                List<ExamineDetail> examineDetails = examineDetailDao.getList(getDatailParamCriteria, order);
                result.setExamineEvent(examineEvent);
                result.setExamineDetails(examineDetails);
            }
        }
        return result;
    }

    @Override
    public ExamReportDTO exportExamReport(Criteria criteria) {
        // 一次检验的所有数据
        List<ExamineDetail> examineDetails = examineDetailDao.getList(criteria);
        ExamineEvent examineEvent = examineEventDao.get(criteria);
        ExamReportDTO result = new ExamReportDTO();
        result.setExamineDetails(examineDetails);
        result.setExamineEvent(examineEvent);
        return result;
    }

    @Override
    public PageList<ExamineEvent> getIDMExamsResults(Page page, Criteria criteria){
        PageList<ExamineEvent> examineEvents = examineEventQueryDao.getIDMExamsResult(page, criteria);
        return examineEvents;
    }

}