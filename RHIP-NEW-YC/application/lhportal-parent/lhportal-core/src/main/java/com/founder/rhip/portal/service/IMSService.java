package com.founder.rhip.portal.service;


import com.founder.rhip.ehr.entity.clinic.ExamResponse;
import com.founder.rhip.ehr.entity.clinic.PaitentbedStatus;
import com.founder.rhip.ehr.entity.clinic.StudyResponse;
import com.founder.rhip.mdm.entity.Department;
import com.founder.rhip.portal.dto.GetPhyExamDetailReq;
import com.founder.rhip.portal.dto.QueryReserve;

/**
 * Created by f on 2016/12/6.
 */
public interface IMSService {
    /**
     * 获取门诊列表
     * @param queryReserve  获取身份证号
     * @return
     */
    public String searchOutpatientInfo(QueryReserve queryReserve);

    /**
     * 获取住院列表
     * @param queryReserve  获取身份证号
     * @return
     */
    public String searchInpatientInfo(QueryReserve queryReserve);

    /**
     * 获取体检列表
     * @param queryReserve  获取身份证号
     * @return
     */
    public String getPhysiqueExaList(QueryReserve queryReserve);

    /**
     * 获取体检详情
     * @param getPhyExamDetailReq  获取personId
     * @return
     */
    public String getPhysiqueExaDetail(GetPhyExamDetailReq getPhyExamDetailReq);

    /**
     * 获取检验列表
      * @param queryReserve
     * @return
     */
    public String getExam(QueryReserve queryReserve);

    /**
     * 获取检验详情
     * @param examResponse
     * @return
     */
    public String getExamDetail(ExamResponse examResponse);

    /**
     * 获取检查列表
     * @param queryReserve
     * @return
     */
    public String getStudy(QueryReserve queryReserve);

    /**
     * 获取检查详情
     * @param studyResponse
     * @return
     */
    public String getStudyDetail(StudyResponse studyResponse);

    /**
     * 获取用药信息
     * @param queryReserve
     * @return
     */
    public String getDrug(QueryReserve queryReserve);

    /**
     * 获取床位信息
     * @param department
     * @return
     */
    public String getPatientbed(Department department);

}
