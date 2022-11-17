package com.founder.rhip.ehr.entity.control;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by wang_zhou on 2015/6/5.
 */
@Entity
@Table(name = "BRW_REMIND_STATISTICS")
public class RemindStatistics implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "CATEGORY_TYPE", columnDefinition = "VARCHAR2|调阅类型（FS990016）||", length = 2, nullable = true)
    private String categoryType;

    @Column(name = "ORG_TYPE", columnDefinition = "VARCHAR2|机构类型(A1综合医院；B1中心；B2站；D400医务室；L监督所；R2其他)||", length = 4, nullable = true)
    private String orgType;

    @Column(name = "GBCODE", columnDefinition = "VARCHAR2|行政区划代码(镇）||", length = 50, nullable = true)
    private String gbcode;

    @Column(name = "SUP_ORGAN_CODE", columnDefinition = "VARCHAR2|上级机构编码(中心)||", length = 50, nullable = true)
    private String supOrganCode;

    @Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|调阅机构代码||", length = 20, nullable = true)
    private String organCode;

    @Column(name = "ORGAN_NAME", columnDefinition = "VARCHAR2|调阅机构名称||", length = 70, nullable = true)
    private String organName;

    @Column(name = "USER_CODE", columnDefinition = "VARCHAR2|调阅人CODE||", length = 50, nullable = true)
    private String userCode;

    @Column(name = "USER_NAME", columnDefinition = "VARCHAR2|调阅人名||", length = 50, nullable = true)
    private String userName;

    @Column(name = "CREATE_DATE", columnDefinition = "DATE|调阅时间||", nullable = true)
    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getGbcode() {
        return gbcode;
    }

    public void setGbcode(String gbcode) {
        this.gbcode = gbcode;
    }

    public String getSupOrganCode() {
        return supOrganCode;
    }

    public void setSupOrganCode(String supOrganCode) {
        this.supOrganCode = supOrganCode;
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

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
