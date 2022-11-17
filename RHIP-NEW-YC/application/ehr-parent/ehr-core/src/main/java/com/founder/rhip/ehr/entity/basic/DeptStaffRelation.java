package com.founder.rhip.ehr.entity.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "BI_DEPT_STAFF_RELATION")
public class DeptStaffRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "UNIQUE_I_D", columnDefinition = "VARCHAR2|唯一编号||", length = 32, nullable = true)
    private String uniqueID;

    @Column(name = "ORGANCODE", columnDefinition = "VARCHAR2|所在机构科室编码||", length = 5, nullable = true)
    private String organcode;

    @Column(name = "AGENCY_DEPARTMENT_ABBREVIATION", columnDefinition = "VARCHAR2|所在机构科室简称||", length = 50, nullable = true)
    private String agencyDepartmentAbbreviation;

    @Column(name = "AGENCY_DEPARTMENT_FULL_NAME", columnDefinition = "VARCHAR2|所在机构科室全称||", length = 70, nullable = true)
    private String agencyDepartmentFullName;

    @Column(name = "WORK_CARD_ID", columnDefinition = "VARCHAR2|工作证号||", length = 20, nullable = true)
    private String workCardId;

    @Column(name = "CARD_NUM", columnDefinition = "VARCHAR2|胸牌号||", length = 20, nullable = true)
    private String cardNum;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|职工姓名||", length = 50, nullable = true)
    private String name;

    @Column(name = "IDCARD", columnDefinition = "VARCHAR2|职工身份证号||", length = 18, nullable = true)
    private String idcard;

    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别代码||", length = 1, nullable = true)
    private String gender;

    @Column(name = "BIRTHDAY", columnDefinition = "DATE|职工生日||", nullable = true)
    private Date birthday;

    @Column(name = "NATIONCODE", columnDefinition = "VARCHAR2|职工民族编码||", length = 2, nullable = true)
    private String nationcode;

    @Column(name = "TYPE_CODE", columnDefinition = "VARCHAR2|职工类别代码||", length = 4, nullable = true)
    private String typeCode;

    @Column(name = "WORK", columnDefinition = "VARCHAR2|从事工种||", length = 70, nullable = true)
    private String work;

    @Column(name = "TECHNICAL", columnDefinition = "VARCHAR2|职称级别代码||", length = 1, nullable = true)
    private String technical;

    @Column(name = "TECHNICAL_TEXT", columnDefinition = "VARCHAR2|职称名称||", length = 30, nullable = true)
    private String technicalText;

    @Column(name = "BUSINESS", columnDefinition = "VARCHAR2|职务等级||", length = 2, nullable = true)
    private String business;

    @Column(name = "BUSINESS_NAME", columnDefinition = "VARCHAR2|职务名称||", length = 30, nullable = true)
    private String businessName;

    @Column(name = "OFFICE_TEL", columnDefinition = "VARCHAR2|办公室电话||", length = 20, nullable = true)
    private String officeTel;

    @Column(name = "OFFICE_FAX", columnDefinition = "VARCHAR2|办公室传真||", length = 20, nullable = true)
    private String officeFax;

    @Column(name = "START_WORK_DATE", columnDefinition = "DATE|参加工作日期||", nullable = true)
    private Date startWorkDate;

    @Column(name = "ORG_WORK_DATE", columnDefinition = "DATE|到本科室日期||", nullable = true)
    private Date orgWorkDate;

    @Column(name = "CREATE_DATE", columnDefinition = "DATE|创建日期||", nullable = true)
    private Date createDate;

    @Column(name = "CREATE_PERSON", columnDefinition = "VARCHAR2|创建人姓名||", length = 50, nullable = true)
    private String createPerson;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getUniqueID() {
        return this.uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getOrgancode() {
        return this.organcode;
    }

    public void setOrgancode(String organcode) {
        this.organcode = organcode;
    }

    public String getAgencyDepartmentAbbreviation() {
        return this.agencyDepartmentAbbreviation;
    }

    public void setAgencyDepartmentAbbreviation(String agencyDepartmentAbbreviation) {
        this.agencyDepartmentAbbreviation = agencyDepartmentAbbreviation;
    }

    public String getAgencyDepartmentFullName() {
        return this.agencyDepartmentFullName;
    }

    public void setAgencyDepartmentFullName(String agencyDepartmentFullName) {
        this.agencyDepartmentFullName = agencyDepartmentFullName;
    }

    public String getWorkCardId() {
        return this.workCardId;
    }

    public void setWorkCardId(String workCardId) {
        this.workCardId = workCardId;
    }

    public String getCardNum() {
        return this.cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdcard() {
        return this.idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNationcode() {
        return this.nationcode;
    }

    public void setNationcode(String nationcode) {
        this.nationcode = nationcode;
    }

    public String getTypeCode() {
        return this.typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getWork() {
        return this.work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getTechnical() {
        return this.technical;
    }

    public void setTechnical(String technical) {
        this.technical = technical;
    }

    public String getTechnicalText() {
        return this.technicalText;
    }

    public void setTechnicalText(String technicalText) {
        this.technicalText = technicalText;
    }

    public String getBusiness() {
        return this.business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getBusinessName() {
        return this.businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getOfficeTel() {
        return this.officeTel;
    }

    public void setOfficeTel(String officeTel) {
        this.officeTel = officeTel;
    }

    public String getOfficeFax() {
        return this.officeFax;
    }

    public void setOfficeFax(String officeFax) {
        this.officeFax = officeFax;
    }

    public Date getStartWorkDate() {
        return this.startWorkDate;
    }

    public void setStartWorkDate(Date startWorkDate) {
        this.startWorkDate = startWorkDate;
    }

    public Date getOrgWorkDate() {
        return this.orgWorkDate;
    }

    public void setOrgWorkDate(Date orgWorkDate) {
        this.orgWorkDate = orgWorkDate;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreatePerson() {
        return this.createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
