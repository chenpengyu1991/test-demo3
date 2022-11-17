package com.founder.rhip.ehr.entity.child;

import com.founder.rhip.ehr.service.export.Item;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "WOMEN_CHILD_HEALTH")
@XmlRootElement
public class WomenChildHealth implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;
	
	@Item(index=1,column = "姓名")
	@Column(name = "NAME", columnDefinition = "VARCHAR2|名称||", length = 20, nullable = true)
    private String name;
	
	@Column(name = "ORG_CODE", columnDefinition = "VARCHAR2|填报机构代码||", length = 20, nullable = true)
    private String orgCode;

    @Column(name = "ORG_NAME", columnDefinition = "VARCHAR2|填报机构名称||", length = 100, nullable = true)
    private String orgName;
    
    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别||", length = 1, nullable = true)
    private String gender;

    @Column(name = "child_birthday", columnDefinition = "DATE|出生或分娩日期||", nullable = true)
    private Date childBirthday;

    @Column(name = "CREATE_DATE", columnDefinition = "DATE|创建日期||", nullable = true)
    @Item(index=32,column ="管理时间",isDate=true,datePattern="yyyy/MM/dd")
    private Date createDate;
    
    @Column(name = "UPDATE_DATE", columnDefinition = "DATE|更新日期||", nullable = true)
    private Date updateDate;
    
    @Column(name = "CREATE_PERSON", columnDefinition = "VARCHAR2|创建人||", length = 50, nullable = true)
    private String createPerson;
    @Column(name = "UPDATE_PERSON", columnDefinition = "VARCHAR2|更新人||", length = 50, nullable = true)
    private String updatePerson;
    @Column(name = "BABY_CARD_NO", columnDefinition = "VARCHAR2|宝宝卡号||", length = 13, nullable = true)
    private String babyCardNo;
    
    @Item(index=2,column ="身份证件号码")
    @Column(name = "ID_CARD", columnDefinition = "VARCHAR2|身份证号||", length = 20, nullable = true)
    private String idCard;
    @Column(name = "IDENTITY_TYPE", columnDefinition = "VARCHAR2|身份类型||", length = 20, nullable = true)
    private String identityType;
    @Column(name = "IS_DELETE", columnDefinition = "VARCHAR2|删除标识||", length = 20, nullable = true)
    private String isDelete;
    @Column(name = "PERSON_ID", columnDefinition = "VARCHAR2|", length = 100, nullable = true)
    private String personId;
    @Column(name = "HEALTH_FILE_NO", columnDefinition = "VARCHAR2|", length = 100, nullable = true)
    private String healthFileNo;
    
    @Item(index=31,column ="管理机构")
    @Transient
	private String updateOrganName;
    
    @Item(index=30,column ="建档人员")
    @Transient
	private String updateName;
    

	@Item(index=21,column ="联系电话")
	@Transient
	private String phoneNumber;

	@Item(index=7,column ="常住类型",isDic=true,dicType="FS10005")
	@Transient
	private String householdType;

	@Item(index=9,column ="户籍地址-县(区)",isDic=true,dicType="FS990001")
	@Transient
	private String hrcounty;

	@Item(index=10,isDic=true,dicType="FS990001",column ="户籍地址-乡镇")
	@Transient
	private String hrtownShip;

	@Item(index=11,isDic=true,dicType="FS990001",column ="户籍地址-村")
	@Transient
	private String hrstreet;

	@Item(index=13,column ="户籍地址详细")
	@Transient
	private String hrhouseNumber;

	@Item(index=3,column ="现住址-县(区)",isDic=true,dicType="FS990001")
	@Transient
	private String pacounty;

	@Item(index=4,isDic=true,dicType="FS990001",column ="现住址乡镇")
	@Transient
	private String patownShip;

	@Item(index=5,isDic=true,dicType="FS990001",column ="现住址-村(街、路、弄等)")
	@Transient
	private String pastreet;

	@Item(index=6,column ="现住址详细")
	@Transient
	private String pahouseNumber;

	@Item(index=22,column ="联系人电话")
	@Transient
	private String guardianPhoneOne;
	@Item(index=29,column ="责任医师")
	@Transient
	private String physiciansCaringName;

	@Item(index=33,column ="是否指导")
	@Transient
	private String healthGuideStatus;
    
	public String getHealthFileNo() {
		return healthFileNo;
	}

	public void setHealthFileNo(String healthFileNo) {
		this.healthFileNo = healthFileNo;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public String getIdentityType() {
		return identityType;
	}

	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}

	public String getBabyCardNo() {
		return babyCardNo;
	}

	public void setBabyCardNo(String babyCardNo) {
		this.babyCardNo = babyCardNo;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getChildBirthday() {
		return childBirthday;
	}

	public void setChildBirthday(Date childBirthday) {
		this.childBirthday = childBirthday;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getCreatePerson() {
		return createPerson;
	}

	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}

	public String getUpdatePerson() {
		return updatePerson;
	}

	public void setUpdatePerson(String updatePerson) {
		this.updatePerson = updatePerson;
	}

	public String getUpdateOrganName() {
		return updateOrganName;
	}

	public void setUpdateOrganName(String updateOrganName) {
		this.updateOrganName = updateOrganName;
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getHouseholdType() {
		return householdType;
	}

	public void setHouseholdType(String householdType) {
		this.householdType = householdType;
	}

	public String getHrcounty() {
		return hrcounty;
	}

	public void setHrcounty(String hrcounty) {
		this.hrcounty = hrcounty;
	}

	public String getHrtownShip() {
		return hrtownShip;
	}

	public void setHrtownShip(String hrtownShip) {
		this.hrtownShip = hrtownShip;
	}

	public String getHrstreet() {
		return hrstreet;
	}

	public void setHrstreet(String hrstreet) {
		this.hrstreet = hrstreet;
	}

	public String getHrhouseNumber() {
		return hrhouseNumber;
	}

	public void setHrhouseNumber(String hrhouseNumber) {
		this.hrhouseNumber = hrhouseNumber;
	}

	public String getPacounty() {
		return pacounty;
	}

	public void setPacounty(String pacounty) {
		this.pacounty = pacounty;
	}

	public String getPatownShip() {
		return patownShip;
	}

	public void setPatownShip(String patownShip) {
		this.patownShip = patownShip;
	}

	public String getPastreet() {
		return pastreet;
	}

	public void setPastreet(String pastreet) {
		this.pastreet = pastreet;
	}

	public String getPahouseNumber() {
		return pahouseNumber;
	}

	public void setPahouseNumber(String pahouseNumber) {
		this.pahouseNumber = pahouseNumber;
	}

	public String getGuardianPhoneOne() {
		return guardianPhoneOne;
	}

	public void setGuardianPhoneOne(String guardianPhoneOne) {
		this.guardianPhoneOne = guardianPhoneOne;
	}

	public String getPhysiciansCaringName() {
		return physiciansCaringName;
	}

	public void setPhysiciansCaringName(String physiciansCaringName) {
		this.physiciansCaringName = physiciansCaringName;
	}
    
    
    
}
