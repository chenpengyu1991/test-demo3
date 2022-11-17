package com.founder.rhip.ehr.entity.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "BI_FAMILY_PERSON_RELATION")
public class FamilyPersonRelation implements Serializable {

    private static final long serialVersionUID = -879257635045588135L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "FAMILY_ID", columnDefinition = "NUMBER|家庭基本信息表主键||", length = 11, nullable = true)
    private Long familyId;

    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|个人基本信息表主键||", length = 11, nullable = true)
    private Long personId;

    @Column(name = "FAMILY_MEMBER_NAME", columnDefinition = "VARCHAR2|家庭成员姓名||", length = 50, nullable = true)
    private String familyMemberName;

    @Column(name = "HOUSEHOLDER_FLAG", columnDefinition = "VARCHAR2|户主标志||", length = 1, nullable = true)
    private String householderFlag;

    @Column(name = "FAMILY_MEM_IDCARD", columnDefinition = "VARCHAR2|家庭成员身份证件号||", length = 18, nullable = true)
    private String familyMemIdcard;

    @Column(name = "FAMILY_MEM_TYPE_CODE", columnDefinition = "VARCHAR2|家庭成员类别代码||", length = 10, nullable = true)
    private String familyMemTypeCode;

    @Column(name = "FAMILY_MEM_TYPE_NAME", columnDefinition = "VARCHAR2|家庭成员类别名称||", length = 10, nullable = true)
    private String familyMemTypeName;

    @Column(name = "FAMILY_MEM_MAN_STATUS", columnDefinition = "VARCHAR2|家庭成员管理状态||", length = 1, nullable = true)
    private String familyMemManStatus;

    @Column(name = "ACCOUNT_NUMBER", columnDefinition = "VARCHAR2|户口号||", length = 12, nullable = true)
    private String accountNumber;

    @Column(name = "GBCODE", columnDefinition = "VARCHAR2|行政区划代码||", length = 12, nullable = true)
    private String gbcode;

    @Column(name = "ZONE_GBCODE", columnDefinition = "VARCHAR2|行政区划代码||", length = 10, nullable = true)
    private String zoneCode;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getFamilyMemberName() {
        return this.familyMemberName;
    }

    public void setFamilyMemberName(String familyMemberName) {
        this.familyMemberName = familyMemberName;
    }

    public String getHouseholderFlag() {
        return this.householderFlag;
    }

    public void setHouseholderFlag(String householderFlag) {
        this.householderFlag = householderFlag;
    }

    public String getFamilyMemIdcard() {
        return this.familyMemIdcard;
    }

    public void setFamilyMemIdcard(String familyMemIdcard) {
        this.familyMemIdcard = familyMemIdcard;
    }

    public String getFamilyMemTypeCode() {
        return this.familyMemTypeCode;
    }

    public void setFamilyMemTypeCode(String familyMemTypeCode) {
        this.familyMemTypeCode = familyMemTypeCode;
    }

    public String getFamilyMemTypeName() {
        return this.familyMemTypeName;
    }

    public void setFamilyMemTypeName(String familyMemTypeName) {
        this.familyMemTypeName = familyMemTypeName;
    }

    public String getFamilyMemManStatus() {
        return this.familyMemManStatus;
    }

    public void setFamilyMemManStatus(String familyMemManStatus) {
        this.familyMemManStatus = familyMemManStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Long familyId) {
        this.familyId = familyId;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getGbcode() {
        return gbcode;
    }

    public void setGbcode(String gbcode) {
        this.gbcode = gbcode;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
