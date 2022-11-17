package com.founder.rhip.portal.dto;

import com.founder.rhip.ehr.entity.clinic.ExamineEvent;
import com.founder.rhip.ehr.entity.clinic.ObservationInfo;
import com.founder.rhip.ehr.entity.clinic.StudyEvent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetPhyExamDetailResp {

	private String rtnCode;

	private String rtnMessage;


    @XmlElement(name = "healthExamination")
    private HealthExaminationDetail healthExaminationDetail;

    @XmlElementWrapper(name = "observationInfos")
    @XmlElement(name = "observationInfo")
    private List<ObservationInfo> observationInfos;

    @XmlElementWrapper(name = "examEvents")
    @XmlElement(name = "examEvent")
    private List<ExamEvent> examineEvents;



    @XmlElementWrapper(name = "studyEvents")
    @XmlElement(name = "studyEvent")
    private List<StudyEvent> studyEvents;


    public String getRtnCode() {
        return rtnCode;
    }

    public void setRtnCode(String rtnCode) {
        this.rtnCode = rtnCode;
    }

    public String getRtnMessage() {
        return rtnMessage;
    }

    public void setRtnMessage(String rtnMessage) {
        this.rtnMessage = rtnMessage;
    }

    public HealthExaminationDetail getHealthExaminationDetail() {
        return healthExaminationDetail;
    }

    public void setHealthExaminationDetail(HealthExaminationDetail healthExaminationDetail) {
        this.healthExaminationDetail = healthExaminationDetail;
    }

    public List<ObservationInfo> getObservationInfos() {
        return observationInfos;
    }

    public void setObservationInfos(List<ObservationInfo> observationInfos) {
        this.observationInfos = observationInfos;
    }

    public List<ExamEvent> getExamineEvents() {
        return examineEvents;
    }

    public void setExamineEvents(List<ExamEvent> examineEvents) {
        this.examineEvents = examineEvents;
    }

    public List<StudyEvent> getStudyEvents() {
        return studyEvents;
    }

    public void setStudyEvents(List<StudyEvent> studyEvents) {
        this.studyEvents = studyEvents;
    }
}