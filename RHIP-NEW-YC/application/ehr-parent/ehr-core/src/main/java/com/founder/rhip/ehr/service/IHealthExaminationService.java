package com.founder.rhip.ehr.service;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.dto.HealthExaminationDTO;
import com.founder.rhip.ehr.entity.clinic.ExamineDetail;
import com.founder.rhip.ehr.entity.clinic.ExamineEvent;
import com.founder.rhip.ehr.entity.clinic.HealthExamination;
import com.founder.rhip.ehr.entity.clinic.ObservationInfo;
import com.founder.rhip.ehr.entity.clinic.StudyEvent;

public interface IHealthExaminationService {
    /**
     * 数据获取
     *
     * @param OutpatientReportDTO
     * @return OutpatientReportDTO
     */
    public HealthExaminationDTO saveHealthExamination(HealthExaminationDTO healthExaminationDTO);

    /**
     * 获取体检列表
     * @param criteria
     * @param page
     * @return
     */
    public PageList<HealthExamination> getHealthExamList(Page page, Criteria criteria, Order order);

    
    /**
     * 获取体检列表(不包括没有扁平化的数据)
     * @param criteria
     * @param page
     * @return
     */
    public PageList<HealthExamination> getHealthExams(Page page, Criteria criteria, Order order);
    
    /**
     * 获取体检信息
     * @param criteria
     * @param page
     * @return
     */
    public HealthExamination getHealthExam(Criteria criteria);
    
    /**
     * 一般观察
     * @param criteria
     * @return
     */
    public List<ObservationInfo> getObservationInfos(Criteria criteria);
    
    /**
     * 检验
     * @param criteria
     * @return
     */
    public List<Map<String, Object>> getExamEvents(Criteria criteria);

    /**
     * 检验Bean形式
     * @param criteria
     * @return
     */
    public List<ExamineEvent> getExamEventsList(Criteria criteria);
    /**
     * 检验详细
     * @param criteria
     * @return
     */
    public List<ExamineDetail> getExamDetails(Criteria criteria);
    
    /**
     * 检查
     * @param criteria
     * @return
     */
    public List<StudyEvent> getStudyEvents(Criteria criteria);
    
    /**
     * 得到PersonId和EhrId
     * @param criteria
     * @return
     */
    public List<ObservationInfo> getPersonIdAndEhrId(int type);
    
    public HealthExamination getHealthExamination(String year, Long personId, String type);
    
    /**
     * 体检专项-指标分析列表
     *
     * @param page
     * @param criteria
     * @param order
     * @return
     * @author Ye jianfei
     */
    public PageList<HealthExamination> getAnalyzeHealthExams(Page page, Criteria criteria, Order order);

    /**
     * 获取体检专项列表
     * @param criteria
     * @param order
     * @return
     */
    public List<HealthExamination> getHealthExamsList(Criteria criteria,Order order);
}
