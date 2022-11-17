package com.founder.rhip.ehr.entity.clinic;

import com.founder.rhip.ehr.common.JaxbDateSerializer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**
 * Created by f on 2016/12/7.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
public class StudyDetailResponse {
    private String name;
    private String hospitalName;
    private String inspectionItemName;
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    private Date applyDate;
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    private Date auditDate;
    private String ckptName;
    private String inspectionType;
    private String findings;
    private String conclusionDesc;
    private String suggestion;
    private String checkPeopleName;
    private String auditName;

    public String getName() {
        return name;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public String getInspectionItemName() {
        return inspectionItemName;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public String getCkptName() {
        return ckptName;
    }

    public String getInspectionType() {
        return inspectionType;
    }

    public String getFindings() {
        return findings;
    }

    public String getConclusionDesc() {
        return conclusionDesc;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public String getCheckPeopleName() {
        return checkPeopleName;
    }

    public String getAuditName() {
        return auditName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public void setInspectionItemName(String inspectionItemName) {
        if (inspectionItemName == null) {
            this.inspectionItemName = "";
        } else {
            this.inspectionItemName = inspectionItemName;
        }
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public void setCkptName(String ckptName) {
        if (ckptName == null) {
            this.ckptName = "";
        } else {
            this.ckptName = ckptName;
        }
    }

    public void setInspectionType(String inspectionType) {
        if (inspectionType == null) {
            this.inspectionType = "";
        } else {
            this.inspectionType = inspectionType;
        }
    }

    public void setFindings(String findings) {
        if (findings == null) {
            this.findings = "";
        } else {
            this.findings = findings;
        }
    }

    public void setConclusionDesc(String conclusionDesc) {
        if (conclusionDesc == null) {
            this.conclusionDesc = "";
        } else {
            this.conclusionDesc = conclusionDesc;
        }
    }

    public void setSuggestion(String suggestion) {
        if (suggestion == null) {
            this.suggestion = "";
        } else {
            this.suggestion = suggestion;
        }
    }

    public void setCheckPeopleName(String checkPeopleName) {
        if (checkPeopleName == null) {
            this.checkPeopleName = "";
        } else {
            this.checkPeopleName = checkPeopleName;
        }
    }

    public void setAuditName(String auditName) {
        if (auditName == null) {
            this.auditName = "";
        } else {
            this.auditName = auditName;
        }
    }
}
