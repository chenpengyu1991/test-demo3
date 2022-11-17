package com.founder.rhip.ehr.dto.ihm;

public class PatientInfoDTO {
	//就诊机构编码
	private String clinicOrganCode;
	//患者姓名
	private String name;
	//身份证号
	private String idcard;
	//门诊号
	private String medicalNo;
	//住院号
	private String hospitalNo;
	//人员ID
	private Long personId;
	//活动索引号
	private String ehrId;
	//住院信息ID
	private Long inpatientId;
	
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
	public String getMedicalNo() {
		return medicalNo;
	}
	public void setMedicalNo(String medicalNo) {
		this.medicalNo = medicalNo;
	}
	public String getHospitalNo() {
		return hospitalNo;
	}
	public void setHospitalNo(String hospitalNo) {
		this.hospitalNo = hospitalNo;
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
	public Long getInpatientId() {
		return inpatientId;
	}
	public void setInpatientId(Long inpatientId) {
		this.inpatientId = inpatientId;
	}
	public String getClinicOrganCode() {
		return clinicOrganCode;
	}
	public void setClinicOrganCode(String clinicOrganCode) {
		this.clinicOrganCode = clinicOrganCode;
	}
}
