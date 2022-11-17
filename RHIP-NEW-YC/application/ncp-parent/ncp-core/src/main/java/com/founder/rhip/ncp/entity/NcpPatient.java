package com.founder.rhip.ncp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.mdm.entity.Organization;

@Entity
@Table(name = "NCP_PATIENT")
public class NcpPatient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = true)
	private Long id;
	
	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|个人信息唯一编号||", length = 11, nullable = true)
	private Long personId;
	
	@Column(name = "CARDNO", columnDefinition = "VARCHAR2|居民身份证||", length = 18, nullable = true)
	private String cardno;
	
	@Column(name = "CARD_TYPE", columnDefinition = "VARCHAR2|证件类型||", length = 2, nullable = true)
	private String cardType;
	
	@Column(name = "PATIENT_TYPE", columnDefinition = "VARCHAR2|疑似/确诊 编码||", length = 2, nullable = true)
	private String patientType;
	
	@Column(name = "CLINICAL_CLASS", columnDefinition = "VARCHAR2|临床分型||", length = 2, nullable = true)
	private String clinicalClass;
	
	@Column(name = "DIAGNOSTIC_DATE", columnDefinition = "DATE|确诊时间||", nullable = true)
	private Date diagnosticDate;
	
	@Column(name = "DIAGNOSTIC_HOSPITAL", columnDefinition = "VARCHAR2|确诊医院编码||", length = 10, nullable = true)
	private String diagnosticHospital;
	
	@Column(name = "DISCHARGE_DATE", columnDefinition = "DATE|出院时间||", nullable = true)
	private Date dischargeDate;
	
	@Column(name = "SEGREGATION_BEGIN", columnDefinition = "DATE|隔离开始时间||", nullable = true)
	private Date segregationBegin;
	
	@Column(name = "SEGREGATION_END", columnDefinition = "DATE|隔离结束时间||", nullable = true)
	private Date segregationEnd;
	
	@Column(name = "SEGREGATION_LOCATION", columnDefinition = "VARCHAR2|隔离地点||", length = 20, nullable = true)
	private String segregationLocation;
	
	@Column(name = "CREATE_DOCTOR_CODE", columnDefinition = "VARCHAR2|建卡医生编码||", length = 20, nullable = true)
	private String createDoctorCode;
	
	@Column(name = "CREATE_DOCTOR_NAME", columnDefinition = "VARCHAR2|建卡医生姓名||", length = 20, nullable = true)
	private String createDoctorName;
	
	@Column(name = "MANAGEMENT_ORG", columnDefinition = "VARCHAR2|管理机构编码||", length = 20, nullable = true)
	private String managementOrg;
	
	@Column(name = "CREATE_ORG", columnDefinition = "VARCHAR2|创建机构编码||", length = 20, nullable = true)
	private String createOrg;
	
	@Column(name = "CREATE_TIME", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createTime;
	
	@Column(name = "UPDATE_TIME", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date updateTime;
	
	@Column(name = "MANAGEMENT_TIME", columnDefinition = "DATE|管理时间||", nullable = true)
	private Date managementTime;
	
	@Column(name = "HEALTH_STATUS", columnDefinition = "VARCHAR2|健康评价状态1:正常0:异常||", length = 20, nullable = true)
	private String healthStatus;
	
	@Column(name = "REEXAMINE_STATUS", columnDefinition = "VARCHAR2|复查状态1:已复查0:未复查||", length = 20, nullable = true)
	private String reexamineStatus;
	
	@Column(name = "IS_DELETE", columnDefinition = "INT|删除状态||", nullable = true)
	private Integer isDelete;

	@Column(name = "ZL_TYPE", columnDefinition = "VARCHAR2|治疗类型1:县内治疗2：县外治疗||", length = 2, nullable = true)
	private String zlType;

	@Transient
	private String idcard;
	@Transient
	private String name;
	@Transient
	private String gender;
	@Transient
	private Date birthday;
	@Transient
	private String phoneNumber;
	@Transient
	private String inputOrganName;
	@Transient
	private String inputOrganCode;
	@Transient
	private String signFlag;
	@Transient
	private String filingFlag;
	@Transient
	private PersonInfo personInfo;// ehr人员信息

	@Transient
	private Organization currentOrganization;

	@Transient
	private User currentUser;

	@Transient
	private String monitorPlanId;

	@Transient
	private Date monitorPlanDate;

	public Date getMonitorPlanDate() {
		return monitorPlanDate;
	}

	public void setMonitorPlanDate(Date monitorPlanDate) {
		this.monitorPlanDate = monitorPlanDate;
	}

	public String getMonitorPlanId() {
		return monitorPlanId;
	}

	public void setMonitorPlanId(String monitorPlanId) {
		this.monitorPlanId = monitorPlanId;
	}

	public String getZlType() {
		return zlType;
	}

	public void setZlType(String zlType) {
		this.zlType = zlType;
	}

	public Date getManagementTime() {
		return managementTime;
	}

	public void setManagementTime(Date managementTime) {
		this.managementTime = managementTime;
	}

	public String getFilingFlag() {
		return filingFlag;
	}

	public void setFilingFlag(String filingFlag) {
		this.filingFlag = filingFlag;
	}

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

	public Organization getCurrentOrganization() {
		return currentOrganization;
	}

	public void setCurrentOrganization(Organization currentOrganization) {
		this.currentOrganization = currentOrganization;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getSignFlag() {
		return signFlag;
	}

	public void setSignFlag(String signFlag) {
		this.signFlag = signFlag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getInputOrganName() {
		return inputOrganName;
	}

	public void setInputOrganName(String inputOrganName) {
		this.inputOrganName = inputOrganName;
	}

	public String getInputOrganCode() {
		return inputOrganCode;
	}

	public void setInputOrganCode(String inputOrganCode) {
		this.inputOrganCode = inputOrganCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getPatientType() {
		return patientType;
	}

	public void setPatientType(String patientType) {
		this.patientType = patientType;
	}

	public String getClinicalClass() {
		return clinicalClass;
	}

	public void setClinicalClass(String clinicalClass) {
		this.clinicalClass = clinicalClass;
	}

	public Date getDiagnosticDate() {
		return diagnosticDate;
	}

	public void setDiagnosticDate(Date diagnosticDate) {
		this.diagnosticDate = diagnosticDate;
	}

	public String getDiagnosticHospital() {
		return diagnosticHospital;
	}

	public void setDiagnosticHospital(String diagnosticHospital) {
		this.diagnosticHospital = diagnosticHospital;
	}

	public Date getDischargeDate() {
		return dischargeDate;
	}

	public void setDischargeDate(Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

	public Date getSegregationBegin() {
		return segregationBegin;
	}

	public void setSegregationBegin(Date segregationBegin) {
		this.segregationBegin = segregationBegin;
	}

	public Date getSegregationEnd() {
		return segregationEnd;
	}

	public void setSegregationEnd(Date segregationEnd) {
		this.segregationEnd = segregationEnd;
	}

	public String getSegregationLocation() {
		return segregationLocation;
	}

	public void setSegregationLocation(String segregationLocation) {
		this.segregationLocation = segregationLocation;
	}

	public String getCreateDoctorCode() {
		return createDoctorCode;
	}

	public void setCreateDoctorCode(String createDoctorCode) {
		this.createDoctorCode = createDoctorCode;
	}

	public String getCreateDoctorName() {
		return createDoctorName;
	}

	public void setCreateDoctorName(String createDoctorName) {
		this.createDoctorName = createDoctorName;
	}

	public String getManagementOrg() {
		return managementOrg;
	}

	public void setManagementOrg(String managementOrg) {
		this.managementOrg = managementOrg;
	}

	public String getCreateOrg() {
		return createOrg;
	}

	public void setCreateOrg(String createOrg) {
		this.createOrg = createOrg;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	public String getHealthStatus() {
		return healthStatus;
	}

	public void setHealthStatus(String healthStatus) {
		this.healthStatus = healthStatus;
	}

	public String getReexamineStatus() {
		return reexamineStatus;
	}

	public void setReexamineStatus(String reexamineStatus) {
		this.reexamineStatus = reexamineStatus;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
	
}
