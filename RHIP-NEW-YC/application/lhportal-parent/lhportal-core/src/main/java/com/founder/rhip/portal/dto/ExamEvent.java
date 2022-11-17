package com.founder.rhip.portal.dto;

import com.founder.rhip.ehr.entity.clinic.ExamineDetail;
import com.founder.rhip.ehr.entity.clinic.ExamineEvent;
import com.founder.rhip.ehr.entity.clinic.ObservationInfo;
import com.founder.rhip.ehr.entity.clinic.StudyEvent;

import javax.persistence.Column;
import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExamEvent {

    @XmlElement(name = "examTitle")
    private String checkListTitle;

    @XmlElement(name = "examPeoPle")
    private String checkPeopleName;

    @XmlElement(name = "examDate")
    private Date checkDate;

    @XmlElementWrapper(name = "examDetails")
    @XmlElement(name = "examDetail")
    private List<ExamineDetail> examineDetails;

    public String getCheckListTitle() {
        return checkListTitle;
    }

    public void setCheckListTitle(String checkListTitle) {
        this.checkListTitle = checkListTitle;
    }

    public String getCheckPeopleName() {
        return checkPeopleName;
    }

    public void setCheckPeopleName(String checkPeopleName) {
        this.checkPeopleName = checkPeopleName;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public List<ExamineDetail> getExamineDetails() {
        return examineDetails;
    }

    public void setExamineDetails(List<ExamineDetail> examineDetails) {
        this.examineDetails = examineDetails;
    }
}