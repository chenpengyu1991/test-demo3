package com.founder.rhip.ehr.entity.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "FS_RECORD_SERIAL_NUMBER")
public class RecordSerialNumber implements Serializable {

    private static final long serialVersionUID = -7468851471043672054L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|ID", length = 11, nullable = false)
    private Long id;

    @Column(name = "ADMINISTRATOR_AREA_ID", columnDefinition = "NUMBER|行政区划表主键", length = 11, nullable = false)
    private Long administratorAreaId; //行政区划表主键

    @Column(name = "NUMBER_TYPE", columnDefinition = "VARCHAR2|编号类型", length = 10, nullable = false)
    private String numberType;          //编号类型

    @Column(name = "SERIAL_NUMBER", columnDefinition = "NUMBER|流水号", length = 11, nullable = false)
    private Long serialNumber;      //流水号

    @Column(name = "PRE_FIX", columnDefinition = "VARCHAR2|编号前缀", length = 5, nullable = false)
    private String preFix;              //编号前缀

    @Column(name = "POST_FIX", columnDefinition = "VARCHAR2|编号后缀", length = 5, nullable = false)
    private String postFix;              //编号后缀

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdministratorAreaId() {
        return administratorAreaId;
    }

    public void setAdministratorAreaId(Long administratorAreaId) {
        this.administratorAreaId = administratorAreaId;
    }

    public String getNumberType() {
        return numberType;
    }

    public void setNumberType(String numberType) {
        this.numberType = numberType;
    }

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getPreFix() {
        return preFix;
    }

    public void setPreFix(String preFix) {
        this.preFix = preFix;
    }

    public String getPostFix() {
        return postFix;
    }

    public void setPostFix(String postFix) {
        this.postFix = postFix;
    }

}
