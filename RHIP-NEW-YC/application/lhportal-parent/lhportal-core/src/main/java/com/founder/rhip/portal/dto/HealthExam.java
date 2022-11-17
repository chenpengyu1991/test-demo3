package com.founder.rhip.portal.dto;

import com.founder.rhip.ehr.common.JaxbDateSerializer;
import com.founder.rhip.ehr.entity.clinic.OutpatientInfoReponse;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

/**
 * Created by bagen on 2016/11/15.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class HealthExam {
    private Long personId;
    private String ehrId;
    private String hospitalName;
    private String physicalExamCode;
    private String name;
    private String age;
    private String physicalExamType;
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    private Date examinationDate;


    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getEhrId() {
        return ehrId;
    }

    public void setEhrId(String ehrId) {
        this.ehrId = ehrId;
    }

    public String getPhysicalExamCode() {
        return physicalExamCode;
    }

    public void setPhysicalExamCode(String physicalExamCode) {
        this.physicalExamCode = physicalExamCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhysicalExamType() {
        return physicalExamType;
    }

    public void setPhysicalExamType(String physicalExamType) {
        this.physicalExamType = physicalExamType;
    }

    public Date getExaminationDate() {
        return examinationDate;
    }

    public void setExaminationDate(Date examinationDate) {
        this.examinationDate = examinationDate;
    }
}


