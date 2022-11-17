package com.founder.rhip.ehr.entity.control.idm.notifiabledisease;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "IDM_OUTPATIENT_LOG")
public class IdmOutpatientLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
    private Long personId;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = false)
    private String ehrId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "HEALTH_FILE_NO", columnDefinition = "VARCHAR2|城乡居民健康档案编号||", length = 17, nullable = true)
    private String healthfileNo;

    @Column(name = "OUTPATIENT_NO", columnDefinition = "VARCHAR2|门诊号||", length = 18, nullable = true)
    private String outpatientNo;

    @Column(name = "CLINIC_RECORD_NO", columnDefinition = "VARCHAR2|接诊记录表编号||", length = 20, nullable = true)
    private String clinicRecordNo;

    @Column(name = "REPORT_CARD_TYPE_CODE", columnDefinition = "VARCHAR2|就诊卡类型/报卡类别代码||", length = 1, nullable = true)
    private String reportCardTypeCode;

    @Column(name = "RECORD_NUMBER", columnDefinition = "VARCHAR2|就诊卡/报告卡编码||", length = 20, nullable = true)
    private String recordNumber;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 50, nullable = true)
    private String name;

    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别||", length = 1, nullable = true)
    private String gender;

    @Column(name = "AGE", columnDefinition = "VARCHAR2|年龄||", length = 20, nullable = true)
    private String age;

    @Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证件号码||", length = 18, nullable = true)
	private String idcard;
    
    @Column(name = "OCCUPATION", columnDefinition = "VARCHAR2|职业类别||", length = 20, nullable = true)
	private String occupation;
    
    @Column(name = "PA_ADDRESS", columnDefinition = "VARCHAR2|现住址地址||", length = 100, nullable = true)
	private String paAddress;
    
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

	@Column(name = "PAHOUSE_NUMBER", columnDefinition = "VARCHAR2|现住址-门牌号码||", length = 50, nullable = true)
	private String pahouseNumber;
	
	@Column(name = "UNIT_NAME", columnDefinition = "VARCHAR2|单位/学校名称||", length = 140, nullable = true)
	private String unitName;
	
	@Column(name = "PHONE_NUMBER", columnDefinition = "VARCHAR2|本人电话号码||", length = 20, nullable = true)
	private String phoneNumber;
	
	@Column(name = "DISEASE_CODE", columnDefinition = "VARCHAR2|诊断病名编码|", length = 100, nullable = true)
	private String diseaseCode;
	
	@Column(name = "DISEASE_NAME", columnDefinition = "VARCHAR2|诊断病名|", length = 200, nullable = true)
	private String diseaseName;
	
	@Column(name = "PATHOGENESIS_DATE", columnDefinition = "TIMESTAMP|发病日期时间||", nullable = true)
	private Date pathogenesisDate;

	@Column(name = "OUTPATIENT_TYPE", columnDefinition = "NUMBER|门诊类型初诊、复诊|", length = 1, nullable = true)
    private Integer outpatientType;
	    
	@Column(name = "PROCESS_STATUS", columnDefinition = "VARCHAR2|处理状态||", length = 1, nullable = true)
	private String processStatus = "0";
	
    @Column(name = "VISIT_STATUS", columnDefinition = "NUMBER|就诊状态|", length = 1, nullable = true)
    private Integer visitStatus;
    
    @Column(name = "DIAGNOSIS_STATUS", columnDefinition = "VARCHAR2|诊断状态代码||", length = 1, nullable = true)
	private String diagnosisStatus;
	
	@Column(name = "CLINIC_ORGAN_CODE", columnDefinition = "VARCHAR2|就诊机构代码||", length = 20, nullable = true)
    private String clinicOrganCode;

    @Column(name = "CLINIC_ORGAN_NAME", columnDefinition = "VARCHAR2|就诊机构名称||", length = 70, nullable = true)
    private String clinicOrganName;

    @Column(name = "MEDICAL_ROOM_CODE", columnDefinition = "VARCHAR2|就诊科室代码||", length = 20, nullable = true)
    private String medicalRoomCode;

    @Column(name = "MEDICAL_ROOM_NAME", columnDefinition = "VARCHAR2|就诊科室名称||", length = 70, nullable = true)
    private String medicalRoomName;

    @Column(name = "CLINIC_DATE", columnDefinition = "TIMESTAMP|就诊日期时间||", nullable = true)
    private Date clinicDate;
    
    @Column(name = "MANA_DOCTOR_NAME", columnDefinition = "VARCHAR2|就诊医师姓名||", length = 50, nullable = true)
    private String manaDoctorName;

    @Column(name = "MANA_DOCTOR_IDCARD", columnDefinition = "VARCHAR2|就诊医师身份证号||", length = 18, nullable = true)
    private String manaDoctorIdCard;

    @Column(name = "FILL_USER_NAME", columnDefinition = "VARCHAR2|填报人姓名||", length = 50, nullable = true)
    private String fillUserName;

    @Column(name = "FILL_USER_IDCARD", columnDefinition = "VARCHAR2|填报身份证号||", length = 18, nullable = true)
    private String fillUserIdCard;

    @Column(name = "FILL_TIME", columnDefinition = "TIMESTAMP|填报日期时间||", nullable = true)
    private Date fillTime;

    @Column(name = "UPDATE_NAME", columnDefinition = "VARCHAR2|更新人姓名||", length = 50, nullable = true)
    private String updateName;

    @Column(name = "UPDATE_IDCARD", columnDefinition = "VARCHAR2|更新人身份证号||", length = 18, nullable = true)
    private String updateIdcard;

    @Column(name = "UPDATE_DATE", columnDefinition = "TIMESTAMP|更新日期和时间||", nullable = true)
    private Date updateDate;
    
    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;
	    
	@Column(name = "GATHER_DATE", columnDefinition = "DATE|采集时间||", nullable = true)
	private Date gatherDate;
	
	@Column(name = "REGISTRATION_TYPE", columnDefinition = "NUMBER|类型门诊、急诊、其他|", length = 1, nullable = true)
    private Integer registrationType;

	public String getFillUserName() {
		return fillUserName;
	}

	public void setFillUserName(String fillUserName) {
		this.fillUserName = fillUserName;
	}

	public String getFillUserIdCard() {
		return fillUserIdCard;
	}

	public void setFillUserIdCard(String fillUserIdCard) {
		this.fillUserIdCard = fillUserIdCard;
	}

	public Date getFillTime() {
		return fillTime;
	}

	public void setFillTime(Date fillTime) {
		this.fillTime = fillTime;
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	public String getUpdateIdcard() {
		return updateIdcard;
	}

	public void setUpdateIdcard(String updateIdcard) {
		this.updateIdcard = updateIdcard;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getRegistrationType() {
		return registrationType;
	}

	public void setRegistrationType(Integer registrationType) {
		this.registrationType = registrationType;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getEhrId() {
		return ehrId;
	}

	public void setEhrId(String ehrId) {
		this.ehrId = ehrId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHealthfileNo() {
		return healthfileNo;
	}

	public void setHealthfileNo(String healthfileNo) {
		this.healthfileNo = healthfileNo;
	}

	public String getOutpatientNo() {
		return outpatientNo;
	}

	public void setOutpatientNo(String outpatientNo) {
		this.outpatientNo = outpatientNo;
	}

	public String getClinicRecordNo() {
		return clinicRecordNo;
	}

	public void setClinicRecordNo(String clinicRecordNo) {
		this.clinicRecordNo = clinicRecordNo;
	}

	public String getReportCardTypeCode() {
		return reportCardTypeCode;
	}

	public void setReportCardTypeCode(String reportCardTypeCode) {
		this.reportCardTypeCode = reportCardTypeCode;
	}

	public String getRecordNumber() {
		return recordNumber;
	}

	public void setRecordNumber(String recordNumber) {
		this.recordNumber = recordNumber;
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getPaAddress() {
		return paAddress;
	}

	public void setPaAddress(String paAddress) {
		this.paAddress = paAddress;
	}

	public String getPaprovince() {
		return paprovince;
	}

	public void setPaprovince(String paprovince) {
		this.paprovince = paprovince;
	}

	public String getPacity() {
		return pacity;
	}

	public void setPacity(String pacity) {
		this.pacity = pacity;
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

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDiseaseCode() {
		return diseaseCode;
	}

	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}

	public String getDiseaseName() {
		return diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public Date getPathogenesisDate() {
		return pathogenesisDate;
	}

	public void setPathogenesisDate(Date pathogenesisDate) {
		this.pathogenesisDate = pathogenesisDate;
	}

	public Integer getOutpatientType() {
		return outpatientType;
	}

	public void setOutpatientType(Integer outpatientType) {
		this.outpatientType = outpatientType;
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	public Integer getVisitStatus() {
		return visitStatus;
	}

	public void setVisitStatus(Integer visitStatus) {
		this.visitStatus = visitStatus;
	}

	public String getDiagnosisStatus() {
		return diagnosisStatus;
	}

	public void setDiagnosisStatus(String diagnosisStatus) {
		this.diagnosisStatus = diagnosisStatus;
	}

	public String getClinicOrganCode() {
		return clinicOrganCode;
	}

	public void setClinicOrganCode(String clinicOrganCode) {
		this.clinicOrganCode = clinicOrganCode;
	}

	public String getClinicOrganName() {
		return clinicOrganName;
	}

	public void setClinicOrganName(String clinicOrganName) {
		this.clinicOrganName = clinicOrganName;
	}

	public String getMedicalRoomCode() {
		return medicalRoomCode;
	}

	public void setMedicalRoomCode(String medicalRoomCode) {
		this.medicalRoomCode = medicalRoomCode;
	}

	public String getMedicalRoomName() {
		return medicalRoomName;
	}

	public void setMedicalRoomName(String medicalRoomName) {
		this.medicalRoomName = medicalRoomName;
	}

	public Date getClinicDate() {
		return clinicDate;
	}

	public void setClinicDate(Date clinicDate) {
		this.clinicDate = clinicDate;
	}

	public String getManaDoctorName() {
		return manaDoctorName;
	}

	public void setManaDoctorName(String manaDoctorName) {
		this.manaDoctorName = manaDoctorName;
	}

	public String getManaDoctorIdCard() {
		return manaDoctorIdCard;
	}

	public void setManaDoctorIdCard(String manaDoctorIdCard) {
		this.manaDoctorIdCard = manaDoctorIdCard;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Date getGatherDate() {
		return gatherDate;
	}

	public void setGatherDate(Date gatherDate) {
		this.gatherDate = gatherDate;
	}
	 
}
