package com.founder.rhip.ehr.entity.basic;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "BI_PERSON_INFO_TEMP")
public class PersonInfoTemp implements Serializable {
    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;
    
    @Column(name = "PERSON_INFO_ID", columnDefinition = "NUMBER|personInfo的主键|11|", length = 11, nullable = false)
    private Long personInfoId;
    
    @Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 100, nullable = true)
    private String name;
    
    @Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证件号码||", length = 18, nullable = true)
    private String idcard;
    
    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别||", length = 1, nullable = true)
    private String gender;

    @Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
    private Date birthday;
    
    @Column(name = "PHONE_NUMBER", columnDefinition = "VARCHAR2|本人电话号码||", length = 20, nullable = true)
    private String phoneNumber;

    @Column(name = "UNIT_NAME", columnDefinition = "VARCHAR2|单位/学校名称||", length = 140, nullable = true)
    private String unitName;

    @Column(name = "FIRST_GUARDIAN", columnDefinition = "VARCHAR2|第一监护人姓名||", length = 50, nullable = true)
    private String firstGuardian;

    @Column(name = "GUARDIAN_PHONE_ONE", columnDefinition = "VARCHAR2|第一监护人电话||", length = 20, nullable = true)
    private String guardianPhoneOne;
    
    @Column(name = "SECOND_GUARDIAN", columnDefinition = "VARCHAR2|第二监护人姓名||", length = 50, nullable = true)
    private String secondGuardian;

    @Column(name = "GUARDIAN_PHONE_TWO", columnDefinition = "VARCHAR2|第二监护人电话||", length = 20, nullable = true)
    private String guardianPhoneTwo;
    
    @Column(name = "NATION", columnDefinition = "VARCHAR2|民族||", length = 2, nullable = true)
    private String nation;

    @Column(name = "ABO_BLOOD_TYPE", columnDefinition = "VARCHAR2|ABO血型||", length = 1, nullable = true)
    private String aboBloodType;

    @Column(name = "RH_BLOOD_TYPE", columnDefinition = "VARCHAR2|Rh血型||", length = 1, nullable = true)
    private String rhBloodType;

    @Column(name = "EDUCATION", columnDefinition = "VARCHAR2|学历||", length = 5, nullable = true)
    private String education;

    @Column(name = "OCCUPATION", columnDefinition = "VARCHAR2|职业类别||", length = 3, nullable = true)
    private String occupation;

    @Column(name = "OCCUPATION_OTHER", columnDefinition = "VARCHAR2|职业其他||", length = 30, nullable = true)
    private String occupationOther;

    @Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况||", length = 2, nullable = true)
    private String marriage;

    @Column(name = "HOUSEHOLD_TYPE", columnDefinition = "VARCHAR2|常住类型||", length = 20, nullable = true)
    private String householdType;
    
    @Column(name = "OUT_WIND_TYPE", columnDefinition = "VARCHAR2|厨房排风设施||", length = 1, nullable = true)
    private String outWindType;

    @Column(name = "FUEL", columnDefinition = "VARCHAR2|燃料类型||", length = 1, nullable = true)
    private String fuel;

   @Column(name = "WATER", columnDefinition = "VARCHAR2|饮水||", length = 1, nullable = true)
    private String water;

    @Column(name = "HASTOILET", columnDefinition = "VARCHAR2|厕所||", length = 1, nullable = true)
    private String hastoilet;

    @Column(name = "FOWL_TYPE", columnDefinition = "VARCHAR2|禽畜栏||", length = 1, nullable = true)
    private String fowlType;

    @Column(name = "FILING_FLAG", columnDefinition = "VARCHAR2|建档状态||", length = 1, nullable = true)
    private String filingFlag; //0：未建档 1：已建档，3 已退回 9已注销 4待审核
    
    @Column(name = "EXPENSE_INFO_STR", columnDefinition = "VARCHAR2|医疗费用支付方式||", length = 30, nullable = true)
    private String expenseInfoStr; 
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPersonInfoId() {
		return personInfoId;
	}

	public void setPersonInfoId(Long personInfoId) {
		this.personInfoId = personInfoId;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getFirstGuardian() {
		return firstGuardian;
	}

	public void setFirstGuardian(String firstGuardian) {
		this.firstGuardian = firstGuardian;
	}

	public String getGuardianPhoneOne() {
		return guardianPhoneOne;
	}

	public void setGuardianPhoneOne(String guardianPhoneOne) {
		this.guardianPhoneOne = guardianPhoneOne;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getAboBloodType() {
		return aboBloodType;
	}

	public void setAboBloodType(String aboBloodType) {
		this.aboBloodType = aboBloodType;
	}

	public String getRhBloodType() {
		return rhBloodType;
	}

	public void setRhBloodType(String rhBloodType) {
		this.rhBloodType = rhBloodType;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getOccupationOther() {
		return occupationOther;
	}

	public void setOccupationOther(String occupationOther) {
		this.occupationOther = occupationOther;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getOutWindType() {
		return outWindType;
	}

	public void setOutWindType(String outWindType) {
		this.outWindType = outWindType;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getWater() {
		return water;
	}

	public void setWater(String water) {
		this.water = water;
	}

	public String getHastoilet() {
		return hastoilet;
	}

	public void setHastoilet(String hastoilet) {
		this.hastoilet = hastoilet;
	}

	public String getFowlType() {
		return fowlType;
	}

	public void setFowlType(String fowlType) {
		this.fowlType = fowlType;
	}

	public String getFilingFlag() {
		return filingFlag;
	}

	public void setFilingFlag(String filingFlag) {
		this.filingFlag = filingFlag;
	}

	public String getHouseholdType() {
		return householdType;
	}

	public void setHouseholdType(String householdType) {
		this.householdType = householdType;
	}

	public String getExpenseInfoStr() {
		return expenseInfoStr;
	}

	public void setExpenseInfoStr(String expenseInfoStr) {
		this.expenseInfoStr = expenseInfoStr;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecondGuardian() {
		return secondGuardian;
	}

	public void setSecondGuardian(String secondGuardian) {
		this.secondGuardian = secondGuardian;
	}

	public String getGuardianPhoneTwo() {
		return guardianPhoneTwo;
	}

	public void setGuardianPhoneTwo(String guardianPhoneTwo) {
		this.guardianPhoneTwo = guardianPhoneTwo;
	}
    
    
}
