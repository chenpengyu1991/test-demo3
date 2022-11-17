package com.founder.rhip.portal.dto;

import com.founder.rhip.ehr.entity.clinic.*;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by yuanzg on 2016/12/6.
 */
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetEhrResponse {
    private static final long serialVersionUID = -1893167872644876493L;
    private String rtnCode;
    private String rtnMessage;

    @XmlElementWrapper(name = "ExamineEventList")
    @XmlElement(name = "ExamineEvent")
    private List<ExamResponse> ExamResponseList;//检验列表

    @XmlElementWrapper(name = "StudyEventList")
    @XmlElement(name = "StudyEvent")
    private List<StudyResponse> StudyResponseList;//检查列表

    @XmlElement(name = "StudyDetail")
    private List<StudyDetailResponse> StudyDetailResponseList;//检查详情

    @XmlElementWrapper(name = "DrugList")
    @XmlElement(name = "Drug")
    private List<DrugResponse> drugResponseList;//用药信息

    @XmlElementWrapper(name = "PatientbedStatusList")
    @XmlElement(name = "PatientbedStatus")
    private List<PatientbedStatusResponse> patientbedStatusResponseList;//床位信息

    public String getRtnCode() {
        return rtnCode;
    }

    public String getRtnMessage() {
        return rtnMessage;
    }

    public List<ExamResponse> getExamResponseList() {
        return ExamResponseList;
    }

    public void setRtnCode(String rtnCode) {
        this.rtnCode = rtnCode;
    }

    public void setRtnMessage(String rtnMessage) {
        this.rtnMessage = rtnMessage;
    }

    public void setExamResponseList(List<ExamResponse> examResponseList) {
        ExamResponseList = examResponseList;
    }

    public List<StudyResponse> getStudyResponseList() {
        return StudyResponseList;
    }

    public void setStudyResponseList(List<StudyResponse> studyResponseList) {
        StudyResponseList = studyResponseList;
    }

    public List<StudyDetailResponse> getStudyDetailResponseList() {
        return StudyDetailResponseList;
    }

    public void setStudyDetailResponseList(List<StudyDetailResponse> studyDetailResponseList) {
        StudyDetailResponseList = studyDetailResponseList;
    }

    public List<DrugResponse> getDrugResponseList() {
        return drugResponseList;
    }

    public void setDrugResponseList(List<DrugResponse> drugResponseList) {
        this.drugResponseList = drugResponseList;
    }

    public List<PatientbedStatusResponse> getPatientbedStatusResponseList() {
        return patientbedStatusResponseList;
    }

    public void setPatientbedStatusResponseList(List<PatientbedStatusResponse> patientbedStatusResponseList) {
        this.patientbedStatusResponseList = patientbedStatusResponseList;
    }
}
