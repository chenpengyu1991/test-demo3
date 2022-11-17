package com.founder.rhip.ehr.entity.clinic;

import com.founder.rhip.ehr.common.JaxbDateSerializer;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

/**
 * Created by f on 2016/12/6.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
public class ExamDetailResponse {

    private String rtnCode;
    private String rtnMessage;
    private String name;
    private String checkListTitle;
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    private Date checkDate;
    private String sampleTypeName;
    private String checkPeopleName;
    private String auditName;
    @XmlElementWrapper(name = "ExamineDetailList")
    @XmlElement(name = "ExamineDetail")
    private List<ExamineDetail> ExamineDetailList;

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public String getRtnCode() {
        return rtnCode;
    }

    public String getRtnMessage() {
        return rtnMessage;
    }

    public void setRtnCode(String rtnCode) {
        this.rtnCode = rtnCode;
    }

    public void setRtnMessage(String rtnMessage) {
        this.rtnMessage = rtnMessage;
    }

    public String getName() {
        return name;
    }

    public String getCheckListTitle() {
        return checkListTitle;
    }

    public String getSampleTypeName() {
        return sampleTypeName;
    }

    public String getCheckPeopleName() {
        return checkPeopleName;
    }

    public String getAuditName() {
        return auditName;
    }

    public List<ExamineDetail> getExamineDetailList() {
        return ExamineDetailList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCheckListTitle(String checkListTitle) {
        this.checkListTitle = checkListTitle;
    }


    public void setSampleTypeName(String sampleTypeName) {
        this.sampleTypeName = sampleTypeName;
    }

    public void setCheckPeopleName(String checkPeopleName) {
        this.checkPeopleName = checkPeopleName;
    }

    public void setAuditName(String auditName) {
        this.auditName = auditName;
    }

    public void setExamineDetailList(List<ExamineDetail> examineDetailList) {
        ExamineDetailList = examineDetailList;
    }
}
