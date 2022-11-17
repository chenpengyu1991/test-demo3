package com.founder.rhip.ehr.service;

import java.util.List;

import com.founder.rhip.ehr.dto.HealthEventItemDTO;
import com.founder.rhip.ehr.dto.OutpatientReportDTO;
import com.founder.rhip.ehr.entity.clinic.DiseaseDiagnosisInfo;
import com.founder.rhip.ehr.entity.clinic.EHRHealthEvent;
import com.founder.rhip.ehr.entity.clinic.ExamineEvent;
import com.founder.rhip.ehr.entity.clinic.StudyEvent;
import com.founder.rhip.ehr.entity.management.DMFollowupPlan;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;

public interface IHealthEventService {
    /**
     * 获取医疗服务活动索引
     *
     * @param page
     * @param criteria
     * @return
     */
    PageList<HealthEventItemDTO> getMedicalSeviceHealthEventList(Page page, Criteria criteria, Order order);

    /**
     * 获取活动信息
     *
     * @param criteria
     * @return
     */
    EHRHealthEvent getEHRHealthEvent(Criteria criteria);
    
    /**
     * 获取活动信息
     *
     * @param criteria
     * @return
     */
    List<EHRHealthEvent> getEHRHealthEvents(Criteria criteria,String... properties);

    List<EHRHealthEvent> getEHRHealthEvents(Criteria criteria, Order order,String... properties);

    /**
     * 检查是否存在活动记录
     *
     * @param criteria
     * @return
     */
    boolean checkHealthEvent(Criteria criteria);

    /**
     * 个人健康档案建档完成情况
     *
     * @param criteria
     * @return
     */
    int checkPersonRecordStatus(Criteria criteria);

    /**
     * 得到随访记录
     * @param personId the person id
     * @return dm followuped plans
     */
    List<DMFollowupPlan> getDmFollowupedPlans(Long personId);

	/**
	 * 获取相关机构
	 * @param personId
	 * @return
	 */
	List<String> getRelationOrganCodes(Long personId);

	/**
	 * 获取健康事件列表
	 */
	PageList<EHRHealthEvent> getEHRHealthEventPageList(Page page, Criteria criteria,String... properties);

	/**
	 * 获取疾病信息列表
	 */
	public PageList<DiseaseDiagnosisInfo> getDiseaseDiagnosisInfoPageList(Page page, Criteria criteria);

	/**
	 * 获取疾病信息列表
	 */
	public List<DiseaseDiagnosisInfo> getDiseaseDiagnosisInfoList(Criteria criteria);

	/**
	 * 获取检查列表
	 */
	public List<StudyEvent> getStudyEventList(Criteria criteria);

	/**
	 * 获取检验列表
	 */
	public List<ExamineEvent> getExamineEventList(Criteria criteria);

	/**
	 * 生命周期——获取随访
	 * @param personId
	 * @param dmType
	 * @return
	 */
	List<DMFollowupPlan> getLifeEventByFollowupPlans(Long personId, String dmType);
	
}
