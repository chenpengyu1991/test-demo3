package com.founder.rhip.portal.dto;

import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created by f on 2016/11/7.
 */
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetPhysiqueExamineInfoResponse implements Serializable{
    private static final long serialVersionUID = -1893167872644876493L;
    private String rtnCode;
    private String rtnMessage;
    @XmlElement(name = "physiqueExamination")
    private PhysiqueExamination physiqueExaminations;

    public String getRtnCode() {
        return rtnCode;
    }

    public String getRtnMessage() {
        return rtnMessage;
    }

    public PhysiqueExamination getPhysiqueExaminations() {
        return physiqueExaminations;
    }

    public void setRtnCode(String rtnCode) {
        this.rtnCode = rtnCode;
    }

    public void setRtnMessage(String rtnMessage) {
        this.rtnMessage = rtnMessage;
    }

    public void setPhysiqueExaminations(PhysiqueExamination physiqueExaminations) {
        this.physiqueExaminations = physiqueExaminations;
    }
}
