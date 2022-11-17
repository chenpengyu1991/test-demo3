package com.founder.rhip.ehr.entity.clinic;

import com.founder.rhip.ehr.common.JaxbDateSerializer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**
 * Created by yuanzg on 2016/12/19.
 */
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class PatientbedStatusResponse {
    private String hospitalCode;
    private String depCode;
    private String depName;
    private String sumBed;
    private String residueBed;
    private String telNo;
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    private Date createTime;
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    private Date updateTime;

    public String getHospitalCode() {
        return hospitalCode;
    }

    public String getDepCode() {
        return depCode;
    }

    public String getDepName() {
        return depName;
    }

    public String getSumBed() {
        return sumBed;
    }

    public String getResidueBed() {
        return residueBed;
    }

    public String getTelNo() {
        return telNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }


    public void setHospitalCode(String hospitalCode) {
        this.hospitalCode = hospitalCode;
    }

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public void setSumBed(String sumBed) {
        this.sumBed = sumBed;
    }

    public void setResidueBed(String residueBed) {
        this.residueBed = residueBed;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
