package com.founder.rhip.ehr.entity.clinic;

import com.founder.rhip.ehr.common.JaxbDateSerializer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**
 * Created by f on 2016/12/6.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
public class ExamResponse {

    private Long personId;
    private String ehrId;
    private String name;
    private String examinationName;
    private String hospitalName;
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    private Date checkDate;

    public Long getPersonId() {
        return personId;
    }

    public String getEhrId() {
        return ehrId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public void setEhrId(String ehrId) {
        this.ehrId = ehrId;
    }

    public String getName() {
        return name;
    }

    public String getExaminationName() {
        return examinationName;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExaminationName(String examinationName) {
        if (examinationName == null) {
            this.examinationName = "";
        } else {
            this.examinationName = examinationName;
        }
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }
}
