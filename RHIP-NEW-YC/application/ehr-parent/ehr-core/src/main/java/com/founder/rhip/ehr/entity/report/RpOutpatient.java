package com.founder.rhip.ehr.entity.report;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RP_OUTPATIENT")
public class RpOutpatient implements Serializable {


	private static final long serialVersionUID = -7359455699953380983L;
	
	
	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;

	@Column(name = "RP_NAME", columnDefinition = "VARCHAR2|表名（多名称用分号间隔）||", length = 100, nullable = true)
	private String rpName;
	
	@Column(name = "GB_CODE", columnDefinition = "VARCHAR2|所在镇编码||", length = 50, nullable = true)
	private String gbCode;
	
	@Column(name = "CENTER_CODE", columnDefinition = "VARCHAR2|中心编码||", length = 50, nullable = true)
	private String centerCode;
	
	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|机构编码||", length = 50, nullable = true)
	private String organCode;
	
	@Column(name = "ORGAN_TYPE", columnDefinition = "VARCHAR2|机构类型||", length = 5, nullable = true)
	private String organType;
	
	@Column(name = "RP_DATE", columnDefinition = "VARCHAR2|统计日期||", nullable = true)
	private Date rpDate;
	
	@Column(name = "DOCTOR_NUM", columnDefinition = "NUMBER|医技人员数||", length = 10, nullable = true)
	private Long doctorNum;
	
	@Column(name = "REGISTER_NUM", columnDefinition = "NUMBER|挂号人次数||", length = 10, nullable = true)
	private Long registerNum;
	
	@Column(name = "TREATMENT_NUM", columnDefinition = "NUMBER|就诊人次数||", length = 10, nullable = true)
	private Long treatmentNum;
	
	@Column(name = "STAY_NUM", columnDefinition = "NUMBER|留观人次数||", length = 10, nullable = true)
	private Long stayNum;
	
	@Column(name = "PRESCRIPTION_NUMM", columnDefinition = "NUMBER|处方数||", length = 10, nullable = true)
	private Long prescriptionNumm;
	
	@Column(name = "FEE_PRESCRIPTION_NUM", columnDefinition = "NUMBER|收费处方数||", length = 10, nullable = true)
	private Long feePrescriptionNum;
	
	@Column(name = "ANTIBACTERIAL_PRESCRIPTION_NUM", columnDefinition = "NUMBER|抗菌药物处方||", length = 10, nullable = true)
	private Long antibacterialPrescriptionNum;
	
	@Column(name = "MEDICAL_FEE", columnDefinition = "NUMBER|医保（门急诊收费）||", nullable = true)
	private BigDecimal medicalFee;
	
	@Column(name = "COOPERATIVE_MEDICAL_FEE", columnDefinition = "NUMBER|新型农村合作医疗（门急诊收费）||", nullable = true)
	private BigDecimal cooperativeMedicalFee;
	
	@Column(name = "PERSONAL_FEE", columnDefinition = "NUMBER|个人费用（门急诊收费）||", nullable = true)
	private BigDecimal personalFee;
	
	@Column(name = "FEE_TOTAL", columnDefinition = "NUMBER|合计费用（门急诊收费）||", nullable = true)
	private BigDecimal feeTotal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRpName() {
		return rpName;
	}

	public void setRpName(String rpName) {
		this.rpName = rpName;
	}

	public String getGbCode() {
		return gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	public String getCenterCode() {
		return centerCode;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}



	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getOrganType() {
		return organType;
	}

	public void setOrganType(String organType) {
		this.organType = organType;
	}

	public Date getRpDate() {
		return rpDate;
	}

	public void setRpDate(Date rpDate) {
		this.rpDate = rpDate;
	}

	
	public Long getDoctorNum() {
		return doctorNum;
	}

	public void setDoctorNum(Long doctorNum) {
		this.doctorNum = doctorNum;
	}

	public Long getRegisterNum() {
		return registerNum;
	}

	public void setRegisterNum(Long registerNum) {
		this.registerNum = registerNum;
	}

	public Long getTreatmentNum() {
		return treatmentNum;
	}

	public void setTreatmentNum(Long treatmentNum) {
		this.treatmentNum = treatmentNum;
	}

	public Long getStayNum() {
		return stayNum;
	}

	public void setStayNum(Long stayNum) {
		this.stayNum = stayNum;
	}

	public Long getPrescriptionNumm() {
		return prescriptionNumm;
	}

	public void setPrescriptionNumm(Long prescriptionNumm) {
		this.prescriptionNumm = prescriptionNumm;
	}

	public Long getFeePrescriptionNum() {
		return feePrescriptionNum;
	}

	public void setFeePrescriptionNum(Long feePrescriptionNum) {
		this.feePrescriptionNum = feePrescriptionNum;
	}

	public Long getAntibacterialPrescriptionNum() {
		return antibacterialPrescriptionNum;
	}

	public void setAntibacterialPrescriptionNum(Long antibacterialPrescriptionNum) {
		this.antibacterialPrescriptionNum = antibacterialPrescriptionNum;
	}

	public BigDecimal getMedicalFee() {
		return medicalFee;
	}

	public void setMedicalFee(BigDecimal medicalFee) {
		this.medicalFee = medicalFee;
	}

	public BigDecimal getCooperativeMedicalFee() {
		return cooperativeMedicalFee;
	}

	public void setCooperativeMedicalFee(BigDecimal cooperativeMedicalFee) {
		this.cooperativeMedicalFee = cooperativeMedicalFee;
	}

	public BigDecimal getPersonalFee() {
		return personalFee;
	}

	public void setPersonalFee(BigDecimal personalFee) {
		this.personalFee = personalFee;
	}

	public BigDecimal getFeeTotal() {
		return feeTotal;
	}

	public void setFeeTotal(BigDecimal feeTotal) {
		this.feeTotal = feeTotal;
	}
	
	

}
