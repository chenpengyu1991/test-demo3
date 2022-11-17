package com.founder.rhip.ehr.entity.clinic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "IDM_SECRECY_DEGREE_SET")
public class SecrecyDegreeSet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "ICD_CODE", columnDefinition = "VARCHAR2|传染病代码（全部设置时传染病代码为0）|10|", length = 10, nullable = true)
    private String icdCode;

    @Column(name = "ICD_NAME", columnDefinition = "VARCHAR2|传染病名称（全部设置时传染病名称为null）||", length = 50, nullable = true)
    private String icdName;

    @Column(name = "SECRECY_DEGREE", columnDefinition = "NUMBER|传染病保密等级（1：一级；2：二级）||", length = 1, nullable = true)
    private int secrecyDegree;

    @Column(name = "CREATE_DATE", columnDefinition = "DATE|等级设置时间||", nullable = true)
    private Date createDate;

    @Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|机构编码|20|", length = 20, nullable = true)
    private String organCode;

    @Column(name = "ORGAN_NAME", columnDefinition = "VARCHAR2|机构名称|70|", length = 70, nullable = true)
    private String organName;

    @Column(name = "CREATE_USER_CODE", columnDefinition = "VARCHAR2|登录用户id||", length = 50, nullable = true)
    private String createUserCode;

    private String organCode_name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIcdCode() {
        return icdCode;
    }

    public void setIcdCode(String icdCode) {
        this.icdCode = icdCode;
    }

    public String getIcdName() {
        return icdName;
    }

    public void setIcdName(String icdName) {
        this.icdName = icdName;
    }

    public int getSecrecyDegree() {
        return secrecyDegree;
    }

    public void setSecrecyDegree(int secrecyDegree) {
        this.secrecyDegree = secrecyDegree;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getOrganCode() {
        return organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public String getCreateUserCode() {
        return createUserCode;
    }

    public void setCreateUserCode(String createUserCode) {
        this.createUserCode = createUserCode;
    }

    public String getOrganCode_name() {
        return organCode_name;
    }

    public void setOrganCode_name(String organCode_name) {
        this.organCode_name = organCode_name;
    }
}
