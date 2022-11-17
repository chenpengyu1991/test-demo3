package com.founder.rhip.ehr.entity.hsa;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HSA_SUS_OCC_DIS_INFO")
public class SusOccDisInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = true)
	private Long id;
	
	@Column(name = "EHR_NO", columnDefinition = "VARCHAR2|门诊号||", length = 20, nullable = true)
	private String ehrNo;

	@Column(name = "REPORT_RECORD_ID", columnDefinition = "|报告登记编码||", nullable = true)
	private  Long  reportRecordId;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 50, nullable = true)
	private String name;

	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别代码||", length = 1, nullable = true)
	private String gender;

	@Column(name = "AGE", columnDefinition = "VARCHAR2|年龄||", length = 10, nullable = true)
	private String age;

	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|居民身份证||", length = 20, nullable = true)
	private String idcard;

	@Column(name = "OCCUPATION", columnDefinition = "VARCHAR2|职业类别代码（工种）||", length =100, nullable = true)
	private String occupation;

	@Column(name = "DOMICILE_TYPE", columnDefinition = "VARCHAR2|常住类型||", length = 2, nullable = true)
	private String domicileType;

	@Column(name = "HRPROVINCE", columnDefinition = "VARCHAR2|户籍地址-省(自治区、直辖市)||", length = 70, nullable = true)
	private String hrprovince;

	@Column(name = "HRCITY", columnDefinition = "VARCHAR2|户籍地址-市(地区、州)||", length = 70, nullable = true)
	private String hrcity;

	@Column(name = "HRCOUNTY", columnDefinition = "VARCHAR2|户籍地址-县(区)||", length = 70, nullable = true)
	private String hrcounty;

	@Column(name = "HRTOWN_SHIP", columnDefinition = "VARCHAR2|户籍地址-乡(镇、街道办事处)||", length = 70, nullable = true)
	private String hrtownShip;

	@Column(name = "HRSTREET", columnDefinition = "VARCHAR2|户籍地址-村(街、路、弄等)||", length = 70, nullable = true)
	private String hrstreet;

	@Column(name = "HRHOUSE_NUMBER", columnDefinition = "VARCHAR2|户籍地址-门牌号码||", length = 70, nullable = true)
	private String hrhouseNumber;

	@Column(name = "HRPOST_CODE", columnDefinition = "VARCHAR2|户籍地址邮政编码||", length = 6, nullable = true)
	private String hrpostCode;

	@Column(name = "PAPROVINCE", columnDefinition = "VARCHAR2|现住址-省(自治区、直辖市)||", length = 70, nullable = true)
	private String paprovince;

	@Column(name = "PACITY", columnDefinition = "VARCHAR2|现住址-市(地区、州)||", length = 70, nullable = true)
	private String pacity;

	@Column(name = "PACOUNTY", columnDefinition = "VARCHAR2|现住址-县(区)||", length = 70, nullable = true)
	private String pacounty;

	@Column(name = "PATOWN_SHIP", columnDefinition = "VARCHAR2|现住址-乡(镇、街道办事处)||", length = 70, nullable = true)
	private String patownShip;

	@Column(name = "PASTREET", columnDefinition = "VARCHAR2|现住址-村(街、路、弄等)||", length = 70, nullable = true)
	private String pastreet;

	@Column(name = "PAHOUSE_NUMBER", columnDefinition = "VARCHAR2|现住址-门牌号码||", length = 70, nullable = true)
	private String pahouseNumber;

	@Column(name = "PAPOST_CODE", columnDefinition = "VARCHAR2|现住址邮政编码||", length = 6, nullable = true)
	private String papostCode;

	@Column(name = "UNIT_NAME", columnDefinition = "VARCHAR2|单位/学校名称||", length = 70, nullable = true)
	private String unitName;

	@Column(name = "ADMISSION_ORGAN_NAME", columnDefinition = "VARCHAR2|接诊单位名称||", length = 70, nullable = true)
	private String admissionOrganName;

	@Column(name = "ADMISSION_ORGAN_CODE", columnDefinition = "VARCHAR2|接诊单位编码||", length = 50, nullable = true)
	private String admissionOrganCode;

	@Column(name = "ADMISSION_DEPT_NAME", columnDefinition = "VARCHAR2|接诊部门名称||", length = 70, nullable = true)
	private String admissionDeptName;

	@Column(name = "ADMISSION_DEPT_CODE", columnDefinition = "VARCHAR2|接诊部门编码||", length = 50, nullable = true)
	private String admissionDeptCode;

	@Column(name = "ADMISSION_DOCTOR_NAME", columnDefinition = "VARCHAR2|接诊人姓名||", length = 50, nullable = true)
	private String admissionDoctorName;

	@Column(name = "ADMISSION_DOCTOR_CODE", columnDefinition = "VARCHAR2|接诊人编码||", length = 50, nullable = true)
	private String admissionDoctorCode;

	@Column(name = "ADMISSION_DATE", columnDefinition = "TIMESTAMP|接诊时间||", nullable = true)
	private Date admissionDate;

	@Column(name = "UNIT_ADDRESS", columnDefinition = "VARCHAR2|工作单位地址||", length = 100, nullable = true)
	private String unitAddress;

	@Column(name = "CHIEF_COMPLAINT_SYMPTOMS", columnDefinition = "VARCHAR2|主要自诉症状||", length = 200, nullable = true)
	private String chiefComplaintSymptoms;

	@Column(name = "WORK_PALCE", columnDefinition = "VARCHAR2|工作场所||", length = 100, nullable = true)
	private String workPalce;

	@Column(name = "RISK_FACTORS_MAY_CONTACT", columnDefinition = "VARCHAR2|可能接触的危险因素||", length = 100, nullable = true)
	private String riskFactorsMayContact;

	@Column(name = "CONTACT_RISK_WORKING_TIME", columnDefinition = "TIMESTAMP|接害工作时间||", nullable = true)
	private Date contactRiskWorkingTime;

	@Column(name = "INCIDENCE_PROCESS", columnDefinition = "VARCHAR2|发病过程||", length = 200, nullable = true)
	private String incidenceProcess;

	@Column(name = "OTHER_CASES", columnDefinition = "VARCHAR2|其它情况||", length = 200, nullable = true)
	private String otherCases;

	@Column(name = "GUIDANCE_TIME", columnDefinition = "INT|指导时间(分钟)||", nullable = true)
	private Integer guidanceTime;

	@Column(name = "MAIN_CONTENT", columnDefinition = "VARCHAR2|主要内容||", length = 500, nullable = true)
	private String mainContent;

	@Column(name = "INFORME_FLAG", columnDefinition = "VARCHAR2|告知情况||", length = 1, nullable = true)
	private String informeFlag;

	@Column(name = "SUS_OCC_DISEASE_NAME", columnDefinition = "VARCHAR2|可疑职业病名称||", length = 100, nullable = true)
	private String susOccDiseaseName;

	@Column(name = "SUS_OCC_DISEASE_CODE", columnDefinition = "VARCHAR2|可疑职业病编码||", length = 50, nullable = true)
	private String susOccDiseaseCode;

	@Column(name = "UNIT_PHONE_NUMBER", columnDefinition = "VARCHAR2|工作单位电话||", length = 20, nullable = true)
	private String unitPhoneNumber;

	@Column(name = "PHONE_NUMBER", columnDefinition = "VARCHAR2|本人电话号码||", length = 20, nullable = true)
	private String phoneNumber;

	@Column(name = "RECIPIENT_UNIT", columnDefinition = "VARCHAR2|接报人单位||", length = 50, nullable = true)
	private String recipientUnit;

	@Column(name = "RECIPIENT_NAME", columnDefinition = "VARCHAR2|接报人姓名||", length = 50, nullable = true)
	private String recipientName;

	@Column(name = "RECIPIENT_PHONE", columnDefinition = "VARCHAR2|接报人电话||", length = 30, nullable = true)
	private String recipientPhone;

	@Column(name = "REPORTER_NAME", columnDefinition = "VARCHAR2|报告人姓名||", length = 50, nullable = true)
	private String reporterName;

	@Column(name = "REPORTER_CODE", columnDefinition = "VARCHAR2|报告人编码||", length = 50, nullable = true)
	private String reporterCode;

	@Column(name = "REPORT_DATE", columnDefinition = "TIMESTAMP|报告日期||", nullable = true)
	private Date reportDate;

	@Column(name = "CREATE_ORGAN_NAME", columnDefinition = "VARCHAR2|填报机构名称||", length = 70, nullable = true)
	private String createOrganName;

	@Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|填报机构编码||", length = 50, nullable = true)
	private String createOrganCode;

	@Column(name = "CREATE_DOCTOR_NAME", columnDefinition = "VARCHAR2|填报人姓名||", length = 50, nullable = true)
	private String createDoctorName;

	@Column(name = "CREATE_DOCTOR_CODE", columnDefinition = "VARCHAR2|填报人编码||", length = 18, nullable = true)
	private String createDoctorCode;

	@Column(name = "CREATE_DATE", columnDefinition = "TIMESTAMP|填报时间||", nullable = true)
	private Date createDate;

	@Column(name = "UPDATE_ORGAN_CODE", columnDefinition = "VARCHAR2|更新机构编码||", length = 50, nullable = true)
	private String updateOrganCode;

	@Column(name = "UPDATE_ORGAN_NAME", columnDefinition = "VARCHAR2|更新机构名称||", length = 70, nullable = true)
	private String updateOrganName;

	@Column(name = "UPDATE_DOCTOR_CODE", columnDefinition = "VARCHAR2|更新人编码||", length = 18, nullable = true)
	private String updateDoctorCode;

	@Column(name = "UPDATE_DOCTOR_NAME", columnDefinition = "VARCHAR2|更新人姓名||", length = 50, nullable = true)
	private String updateDoctorName;

	@Column(name = "UPDATE_DATE", columnDefinition = "TIMESTAMP|更新日期和时间||", nullable = true)
	private Date updateDate;
	
	@Column(name = "CREATE_CENTER_ORGAN_NAME", columnDefinition = "VARCHAR2|机构名称(中心)||", length = 70, nullable = true)
	private String createCenterOrganName;

	@Column(name = "CREATE_CENTER_ORGAN_CODE", columnDefinition = "VARCHAR2|机构编码||", length = 50, nullable = true)
	private String createCenterOrganCode;
	
	@Column(name = "CREATE_GBCODE", columnDefinition = "VARCHAR2|机构编码(镇)||", length = 50, nullable = true)
	private String createGbcode;

	@Column(name = "IS_DELETE", columnDefinition = "INT|删除状态||", nullable = true)
	private Integer isDelete;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long  getReportRecordId() {
		return this.reportRecordId;
	}

	public void setReportRecordId( Long reportRecordId) {
		this.reportRecordId = reportRecordId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getDomicileType() {
		return this.domicileType;
	}

	public void setDomicileType(String domicileType) {
		this.domicileType = domicileType;
	}

	public String getHrprovince() {
		return this.hrprovince;
	}

	public void setHrprovince(String hrprovince) {
		this.hrprovince = hrprovince;
	}

	public String getHrcity() {
		return this.hrcity;
	}

	public void setHrcity(String hrcity) {
		this.hrcity = hrcity;
	}

	public String getHrcounty() {
		return this.hrcounty;
	}

	public void setHrcounty(String hrcounty) {
		this.hrcounty = hrcounty;
	}

	public String getHrtownShip() {
		return this.hrtownShip;
	}

	public void setHrtownShip(String hrtownShip) {
		this.hrtownShip = hrtownShip;
	}

	public String getHrstreet() {
		return this.hrstreet;
	}

	public void setHrstreet(String hrstreet) {
		this.hrstreet = hrstreet;
	}

	public String getHrhouseNumber() {
		return this.hrhouseNumber;
	}

	public void setHrhouseNumber(String hrhouseNumber) {
		this.hrhouseNumber = hrhouseNumber;
	}

	public String getHrpostCode() {
		return this.hrpostCode;
	}

	public void setHrpostCode(String hrpostCode) {
		this.hrpostCode = hrpostCode;
	}

	public String getPaprovince() {
		return this.paprovince;
	}

	public void setPaprovince(String paprovince) {
		this.paprovince = paprovince;
	}

	public String getPacity() {
		return this.pacity;
	}

	public void setPacity(String pacity) {
		this.pacity = pacity;
	}

	public String getPacounty() {
		return this.pacounty;
	}

	public void setPacounty(String pacounty) {
		this.pacounty = pacounty;
	}

	public String getPatownShip() {
		return this.patownShip;
	}

	public void setPatownShip(String patownShip) {
		this.patownShip = patownShip;
	}

	public String getPastreet() {
		return this.pastreet;
	}

	public void setPastreet(String pastreet) {
		this.pastreet = pastreet;
	}

	public String getPahouseNumber() {
		return this.pahouseNumber;
	}

	public void setPahouseNumber(String pahouseNumber) {
		this.pahouseNumber = pahouseNumber;
	}

	public String getPapostCode() {
		return this.papostCode;
	}

	public void setPapostCode(String papostCode) {
		this.papostCode = papostCode;
	}

	public String getUnitName() {
		return this.unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getAdmissionOrganName() {
		return this.admissionOrganName;
	}

	public void setAdmissionOrganName(String admissionOrganName) {
		this.admissionOrganName = admissionOrganName;
	}

	public String getAdmissionOrganCode() {
		return this.admissionOrganCode;
	}

	public void setAdmissionOrganCode(String admissionOrganCode) {
		this.admissionOrganCode = admissionOrganCode;
	}

	public String getAdmissionDeptName() {
		return this.admissionDeptName;
	}

	public void setAdmissionDeptName(String admissionDeptName) {
		this.admissionDeptName = admissionDeptName;
	}

	public String getAdmissionDeptCode() {
		return this.admissionDeptCode;
	}

	public void setAdmissionDeptCode(String admissionDeptCode) {
		this.admissionDeptCode = admissionDeptCode;
	}

	public String getAdmissionDoctorName() {
		return this.admissionDoctorName;
	}

	public void setAdmissionDoctorName(String admissionDoctorName) {
		this.admissionDoctorName = admissionDoctorName;
	}

	public String getAdmissionDoctorCode() {
		return this.admissionDoctorCode;
	}

	public void setAdmissionDoctorCode(String admissionDoctorCode) {
		this.admissionDoctorCode = admissionDoctorCode;
	}

	public Date getAdmissionDate() {
		return this.admissionDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	public String getUnitAddress() {
		return this.unitAddress;
	}

	public void setUnitAddress(String unitAddress) {
		this.unitAddress = unitAddress;
	}

	public String getChiefComplaintSymptoms() {
		return this.chiefComplaintSymptoms;
	}

	public void setChiefComplaintSymptoms(String chiefComplaintSymptoms) {
		this.chiefComplaintSymptoms = chiefComplaintSymptoms;
	}

	public String getWorkPalce() {
		return this.workPalce;
	}

	public void setWorkPalce(String workPalce) {
		this.workPalce = workPalce;
	}

	public String getRiskFactorsMayContact() {
		return this.riskFactorsMayContact;
	}

	public void setRiskFactorsMayContact(String riskFactorsMayContact) {
		this.riskFactorsMayContact = riskFactorsMayContact;
	}

	public Date getContactRiskWorkingTime() {
		return this.contactRiskWorkingTime;
	}

	public void setContactRiskWorkingTime(Date contactRiskWorkingTime) {
		this.contactRiskWorkingTime = contactRiskWorkingTime;
	}

	public String getIncidenceProcess() {
		return this.incidenceProcess;
	}

	public void setIncidenceProcess(String incidenceProcess) {
		this.incidenceProcess = incidenceProcess;
	}

	public String getOtherCases() {
		return this.otherCases;
	}

	public void setOtherCases(String otherCases) {
		this.otherCases = otherCases;
	}

	public Integer getGuidanceTime() {
		return this.guidanceTime;
	}

	public void setGuidanceTime(Integer guidanceTime) {
		this.guidanceTime = guidanceTime;
	}

	public String getMainContent() {
		return this.mainContent;
	}

	public void setMainContent(String mainContent) {
		this.mainContent = mainContent;
	}

	public String getInformeFlag() {
		return this.informeFlag;
	}

	public void setInformeFlag(String informeFlag) {
		this.informeFlag = informeFlag;
	}

	public String getSusOccDiseaseName() {
		return this.susOccDiseaseName;
	}

	public void setSusOccDiseaseName(String susOccDiseaseName) {
		this.susOccDiseaseName = susOccDiseaseName;
	}

	public String getSusOccDiseaseCode() {
		return this.susOccDiseaseCode;
	}

	public void setSusOccDiseaseCode(String susOccDiseaseCode) {
		this.susOccDiseaseCode = susOccDiseaseCode;
	}

	public String getUnitPhoneNumber() {
		return this.unitPhoneNumber;
	}

	public void setUnitPhoneNumber(String unitPhoneNumber) {
		this.unitPhoneNumber = unitPhoneNumber;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRecipientUnit() {
		return this.recipientUnit;
	}

	public void setRecipientUnit(String recipientUnit) {
		this.recipientUnit = recipientUnit;
	}

	public String getRecipientName() {
		return this.recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getRecipientPhone() {
		return this.recipientPhone;
	}

	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
	}

	public String getReporterName() {
		return this.reporterName;
	}

	public void setReporterName(String reporterName) {
		this.reporterName = reporterName;
	}

	public String getReporterCode() {
		return this.reporterCode;
	}

	public void setReporterCode(String reporterCode) {
		this.reporterCode = reporterCode;
	}

	public Date getReportDate() {
		return this.reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getCreateOrganName() {
		return this.createOrganName;
	}

	public void setCreateOrganName(String createOrganName) {
		this.createOrganName = createOrganName;
	}

	public String getCreateOrganCode() {
		return this.createOrganCode;
	}

	public void setCreateOrganCode(String createOrganCode) {
		this.createOrganCode = createOrganCode;
	}

	public String getCreateDoctorName() {
		return this.createDoctorName;
	}

	public void setCreateDoctorName(String createDoctorName) {
		this.createDoctorName = createDoctorName;
	}

	public String getCreateDoctorCode() {
		return this.createDoctorCode;
	}

	public void setCreateDoctorCode(String createDoctorCode) {
		this.createDoctorCode = createDoctorCode;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateOrganCode() {
		return this.updateOrganCode;
	}

	public void setUpdateOrganCode(String updateOrganCode) {
		this.updateOrganCode = updateOrganCode;
	}

	public String getUpdateOrganName() {
		return this.updateOrganName;
	}

	public void setUpdateOrganName(String updateOrganName) {
		this.updateOrganName = updateOrganName;
	}

	public String getUpdateDoctorCode() {
		return this.updateDoctorCode;
	}

	public void setUpdateDoctorCode(String updateDoctorCode) {
		this.updateDoctorCode = updateDoctorCode;
	}

	public String getUpdateDoctorName() {
		return this.updateDoctorName;
	}

	public void setUpdateDoctorName(String updateDoctorName) {
		this.updateDoctorName = updateDoctorName;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getCreateCenterOrganName() {
		return createCenterOrganName;
	}

	public void setCreateCenterOrganName(String createCenterOrganName) {
		this.createCenterOrganName = createCenterOrganName;
	}

	public String getCreateCenterOrganCode() {
		return createCenterOrganCode;
	}

	public void setCreateCenterOrganCode(String createCenterOrganCode) {
		this.createCenterOrganCode = createCenterOrganCode;
	}

	public String getCreateGbcode() {
		return createGbcode;
	}

	public void setCreateGbcode(String createGbcode) {
		this.createGbcode = createGbcode;
	}

	public String getEhrNo() {
		return ehrNo;
	}

	public void setEhrNo(String ehrNo) {
		this.ehrNo = ehrNo;
	}


}