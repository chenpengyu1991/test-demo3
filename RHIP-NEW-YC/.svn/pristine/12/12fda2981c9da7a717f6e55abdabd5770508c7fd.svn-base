package com.founder.rhip.ehr.entity.basic;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.founder.rhip.ehr.service.export.Item;

@Entity
public class PersonInfoExport implements Serializable {

	private static final long serialVersionUID = -7313564364933619294L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
	private Long id;


	@Item(index=1,column = "姓名")
	private String name;
	
	@Item(index=2,column ="身份证件号码")
	private String idcard;	

	@Item(index=7,column ="结案时间",isDate=true,datePattern="yyyy/MM/dd")
	private String canceledDate;
	
	@Item(index=8,column ="结案原因")
	private String canceledReason;
	
	@Item(index=9,column = "结案人")
	private String canceledName;
	
	@Item(index=10,column ="结案机构",isOrganization=true)
	private String canceledOrganCode;
	
	@Item(index=11,column ="现住址-县(区)",isDic=true,dicType="FS990001")
	private String pacounty;

	@Item(index=12,isDic=true,dicType="FS990001",column ="现住址乡镇")
	private String patownShip;

	@Item(index=13,isDic=true,dicType="FS990001",column ="现住址-村(街、路、弄等)")
	private String pastreet;

	@Item(index=14,column ="现住址详细")
	private String pahouseNumber;	

	@Item(index=15,column ="常住类型",isDic=true,dicType="FS10005")
	private String householdType;

	@Item(index=16,column ="户籍地址-县(区)",isDic=true,dicType="FS990001")
	private String hrcounty;

	@Item(index=17,isDic=true,dicType="FS990001",column ="户籍地址-乡镇")
	private String hrtownShip;

	@Item(index=18,isDic=true,dicType="FS990001",column ="户籍地址-村")
	private String hrstreet;

	@Item(index=19,column ="户籍地址详细")
	private String hrhouseNumber;	

	@Item(index=20,column ="联系电话")
	private String phoneNumber;

	@Item(index=21,column ="联系人电话")
	private String guardianPhoneOne;

	@Item(index=22,column ="建档机构",isOrganization=true)
	private String inputOrganCode;
	
	@Item(index=23,column ="建档人员")
	private String inputName;

	@Item(index=24,column ="责任医师")
	private String physiciansCaringName;

	@Item(index=25,column ="建档日期",isDate=true,datePattern="yyyy/MM/dd")
	private Date inputDate;

	@Item(index=26,column ="死亡日期",isDate=true,datePattern="yyyy/MM/dd")
	private Date canceledReasonDate;

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

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getCanceledDate() {
		return canceledDate;
	}

	public void setCanceledDate(String canceledDate) {
		this.canceledDate = canceledDate;
	}

	public String getCanceledReason() {
		return canceledReason;
	}

	public void setCanceledReason(String canceledReason) {
		this.canceledReason = canceledReason;
	}

	public String getCanceledName() {
		return canceledName;
	}

	public void setCanceledName(String canceledName) {
		this.canceledName = canceledName;
	}

	public String getCanceledOrganCode() {
		return canceledOrganCode;
	}

	public void setCanceledOrganCode(String canceledOrganCode) {
		this.canceledOrganCode = canceledOrganCode;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGuardianPhoneOne() {
		return guardianPhoneOne;
	}

	public void setGuardianPhoneOne(String guardianPhoneOne) {
		this.guardianPhoneOne = guardianPhoneOne;
	}

	public String getInputOrganCode() {
		return inputOrganCode;
	}

	public void setInputOrganCode(String inputOrganCode) {
		this.inputOrganCode = inputOrganCode;
	}

	public String getInputName() {
		return inputName;
	}

	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	public String getPhysiciansCaringName() {
		return physiciansCaringName;
	}

	public void setPhysiciansCaringName(String physiciansCaringName) {
		this.physiciansCaringName = physiciansCaringName;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public String getHealthFileNo() {
		return healthFileNo;
	}

	public void setHealthFileNo(String healthFileNo) {
		this.healthFileNo = healthFileNo;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getCanceledReasonDate() {
		return canceledReasonDate;
	}

	public void setCanceledReasonDate(Date canceledReasonDate) {
		this.canceledReasonDate = canceledReasonDate;
	}

	@Item(index=27,column ="档案编号")
	private String healthFileNo;
	@Item(index=28,column ="备注",isDic=true,dicType="FS990026")
	private String remarks;

	
}