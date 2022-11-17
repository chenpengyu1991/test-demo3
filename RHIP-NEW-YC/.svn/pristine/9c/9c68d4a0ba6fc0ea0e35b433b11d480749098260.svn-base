package com.founder.rhip.ehr.entity.basic;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Clob;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "FINGER_INFO")
public class FingerInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|人员ID|11|", length = 11, nullable = false)
    private Long personId;

    @Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证号|18|", length = 18, nullable = false)
    private String idcard;

    @Column(name = "FINGER_ID", columnDefinition = "VARCHAR2|手指编号|1|", length = 1, nullable = true)
    private String fingerId;

    @Column(name = "FINGER_TEMPLATE", columnDefinition = "CLOB|指纹模板|4000|", length = 4000, nullable = true)
    private String fingerTemplate;

    @Column(name = "FINGER_TEMPLATE_SEC", columnDefinition = "CLOB|指纹模板2|4000|", length = 4000, nullable = true)
    private String fingerTemplateSec;
    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getFingerId() {
        return fingerId;
    }

    public void setFingerId(String fingerId) {
        this.fingerId = fingerId;
    }

    public String getFingerTemplate() {
        return fingerTemplate;
    }

    public void setFingerTemplate(String fingerTemplate) {
        this.fingerTemplate = fingerTemplate;
    }

    public String getFingerTemplateSec() {
        return fingerTemplateSec;
    }

    public void setFingerTemplateSec(String fingerTemplateSec) {
        this.fingerTemplateSec = fingerTemplateSec;
    }
}