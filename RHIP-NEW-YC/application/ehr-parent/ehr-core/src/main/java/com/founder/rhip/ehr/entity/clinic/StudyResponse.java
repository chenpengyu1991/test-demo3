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
public class StudyResponse {
    private Long id;
    private String name;
    private String inspectionItemName;
    private String hospitalName;
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    private Date checkDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInspectionItemName(String inspectionItemName) {
        this.inspectionItemName = inspectionItemName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public String getName() {
        return name;
    }

    public String getInspectionItemName() {
        return inspectionItemName;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public Date getCheckDate() {
        return checkDate;
    }
}
