package com.founder.rhip.portal.dto;

import com.founder.rhip.ehr.entity.clinic.OutpatientInfoReponse;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by bagen on 2016/11/15.
 */
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetHealthExamsListResponse {
    private static final long serialVersionUID = -1893167872644876493L;
    private String rtnCode;
    private String rtnMessage;

    @XmlElementWrapper(name = "HealthExams")
    @XmlElement(name = "healthExam")
    private List<HealthExam> HealthExam;

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

    public List<com.founder.rhip.portal.dto.HealthExam> getHealthExam() {
        return HealthExam;
    }

    public void setHealthExam(List<com.founder.rhip.portal.dto.HealthExam> healthExam) {
        HealthExam = healthExam;
    }
}


