package com.founder.rhip.portal.dto;

import com.founder.rhip.ehr.entity.clinic.InpatientInfo;
import com.founder.rhip.ehr.entity.clinic.InpatientInfoResponse;
import com.founder.rhip.ehr.entity.clinic.OutpatientInfo;
import com.founder.rhip.ehr.entity.clinic.OutpatientInfoReponse;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * Created by f on 2016/11/8.
 */
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetOutpatientInfoResponse {
    private static final long serialVersionUID = -1893167872644876493L;
    private String rtnCode;
    private String rtnMessage;
    @XmlElementWrapper(name = "inpatientInfos")
    @XmlElement(name = "inpatientInfo")
    private List<OutpatientInfoReponse> outpatientInfoReponseLists;

    @XmlElementWrapper(name = "inpatientInfos")
    @XmlElement(name = "inpatientInfo")
    private List<InpatientInfoResponse> inpatientInfoResponsesList;

    private InpatientInfoResponse inpatientInfoResponse;

    private OutpatientInfoReponse outpatientInfoReponse;

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

    public void setOutpatientInfoReponseLists(List<OutpatientInfoReponse> outpatientInfoReponseLists) {
        this.outpatientInfoReponseLists = outpatientInfoReponseLists;
    }

    public List<OutpatientInfoReponse> getOutpatientInfoReponseLists() {
        return outpatientInfoReponseLists;
    }

    public void setInpatientInfoResponsesList(List<InpatientInfoResponse> inpatientInfoResponsesList) {
        this.inpatientInfoResponsesList = inpatientInfoResponsesList;
    }

    public List<InpatientInfoResponse> getInpatientInfoResponsesList() {
        return inpatientInfoResponsesList;
    }

    public OutpatientInfoReponse getOutpatientInfoReponse() {
        return outpatientInfoReponse;
    }

    public void setOutpatientInfoReponse(OutpatientInfoReponse outpatientInfoReponse) {
        this.outpatientInfoReponse = outpatientInfoReponse;
    }

    public InpatientInfoResponse getInpatientInfoResponse() {
        return inpatientInfoResponse;
    }

    public void setInpatientInfoResponse(InpatientInfoResponse inpatientInfoResponse) {
        this.inpatientInfoResponse = inpatientInfoResponse;
    }
}


