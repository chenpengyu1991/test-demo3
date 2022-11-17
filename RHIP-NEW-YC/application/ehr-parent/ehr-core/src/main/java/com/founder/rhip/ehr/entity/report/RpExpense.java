package com.founder.rhip.ehr.entity.report;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RP_EXPENSE")
public class RpExpense implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8312150381374338668L;
	
	
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
	
	@Column(name = "RP_TYPE", columnDefinition = "VARCHAR2|门急诊住院类型|1,2门诊3住院|", length = 5, nullable = true)
	private String rpType;
	
	@Column(name = "RP_PERSON_NUM", columnDefinition = "NUMBER|病人数||", length = 10, nullable = true)
	private Long rpPersonNum;
	
	@Column(name = "CHINESE_MEDICINE_FEE", columnDefinition = "NUMBER|中药费||", scale = 10, precision = 2, nullable = true)
	private BigDecimal chineseMedicineFee;
	
	@Column(name = "MEDICINE_FEE", columnDefinition = "NUMBER|中成药费||", scale = 10, precision = 2, nullable = true)
	private BigDecimal medicineFee;
	
	@Column(name = "WESTERN_MEDICINE_FEE", columnDefinition = "NUMBER|西药费||", scale = 10, precision = 2, nullable = true)
	private BigDecimal westernMedicineFee;
	
	@Column(name = "BASE_FEE", columnDefinition = "NUMBER|基药费||",  scale = 10, precision = 2, nullable = true)
	private BigDecimal baseFee;
	
	@Column(name = "NON_BASE_FEE", columnDefinition = "NUMBER|非基药费||",  scale = 10, precision = 2, nullable = true)
	private BigDecimal nonBaseFee;
	
	@Column(name = "INSPECTING_FEE", columnDefinition = "NUMBER|诊查费||",  scale = 10, precision = 2, nullable = true)
	private BigDecimal inspectingFee;
	
	@Column(name = "INSPECTION_FEE", columnDefinition = "NUMBER|检查费||", scale = 10, precision = 2, nullable = true)
	private BigDecimal inspectionFee;
	
	@Column(name = "LABORATORY_FEE", columnDefinition = "NUMBER|化验费||", scale = 10, precision = 2, nullable = true)
	private BigDecimal laboratoryFee;
	
	@Column(name = "RADIATION_FEE", columnDefinition = "NUMBER|放射费||", scale = 10, precision = 2, nullable = true)
	private BigDecimal radiationFee;
	
	@Column(name = "TREATMENT_FEE", columnDefinition = "NUMBER|治疗费||", scale = 10, precision = 2, nullable = true)
	private BigDecimal treatmentFee;
	
	@Column(name = "OPERATION_FEE", columnDefinition = "NUMBER|手术费||", scale = 10, precision = 2, nullable = true)
	private BigDecimal operationFee;
	
	@Column(name = "BLOOD_FEE", columnDefinition = "NUMBER|输血费||",  scale = 10, precision = 2, nullable = true)
	private BigDecimal bloodFee;
	
	@Column(name = "BED_FEE", columnDefinition = "NUMBER|床位费||",  scale = 10, precision = 2, nullable = true)
	private BigDecimal bedFee;
	
	@Column(name = "NURSING_FEE", columnDefinition = "NUMBER|护理费||",  scale = 10, precision = 2, nullable = true)
	private BigDecimal nursingFee;
	
	@Column(name = "ANESTHESIA_FEE", columnDefinition = "NUMBER|麻醉费||",  scale = 10, precision = 2, nullable = true)
	private BigDecimal anesthesiaFee;
	
	@Column(name = "OTHER_FEE", columnDefinition = "NUMBER|其他费||",  scale = 10, precision = 2, nullable = true)
	private BigDecimal otherFee;
	
	@Column(name = "CONSUMABLES_FEE", columnDefinition = "NUMBER|耗材费||",  scale = 10, precision = 2, nullable = true)
	private BigDecimal consumablesFee;
	
	@Column(name = "FEE_TOTAL", columnDefinition = "NUMBER|总费用（全部费用）||",  scale = 10, precision = 2, nullable = true)
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

	public String getRpType() {
		return rpType;
	}

	public void setRpType(String rpType) {
		this.rpType = rpType;
	}

	public BigDecimal getChineseMedicineFee() {
		return chineseMedicineFee;
	}

	public void setChineseMedicineFee(BigDecimal chineseMedicineFee) {
		this.chineseMedicineFee = chineseMedicineFee;
	}

	public BigDecimal getMedicineFee() {
		return medicineFee;
	}

	public void setMedicineFee(BigDecimal medicineFee) {
		this.medicineFee = medicineFee;
	}

	public BigDecimal getWesternMedicineFee() {
		return westernMedicineFee;
	}

	public void setWesternMedicineFee(BigDecimal westernMedicineFee) {
		this.westernMedicineFee = westernMedicineFee;
	}

	public BigDecimal getBaseFee() {
		return baseFee;
	}

	public void setBaseFee(BigDecimal baseFee) {
		this.baseFee = baseFee;
	}

	public BigDecimal getNonBaseFee() {
		return nonBaseFee;
	}

	public void setNonBaseFee(BigDecimal nonBaseFee) {
		this.nonBaseFee = nonBaseFee;
	}

	public BigDecimal getInspectingFee() {
		return inspectingFee;
	}

	public void setInspectingFee(BigDecimal inspectingFee) {
		this.inspectingFee = inspectingFee;
	}

	
	public BigDecimal getInspectionFee() {
		return inspectionFee;
	}

	public void setInspectionFee(BigDecimal inspectionFee) {
		this.inspectionFee = inspectionFee;
	}

	public BigDecimal getLaboratoryFee() {
		return laboratoryFee;
	}

	public void setLaboratoryFee(BigDecimal laboratoryFee) {
		this.laboratoryFee = laboratoryFee;
	}

	public BigDecimal getRadiationFee() {
		return radiationFee;
	}

	public void setRadiationFee(BigDecimal radiationFee) {
		this.radiationFee = radiationFee;
	}

	public BigDecimal getTreatmentFee() {
		return treatmentFee;
	}

	public void setTreatmentFee(BigDecimal treatmentFee) {
		this.treatmentFee = treatmentFee;
	}

	public BigDecimal getOperationFee() {
		return operationFee;
	}

	public void setOperationFee(BigDecimal operationFee) {
		this.operationFee = operationFee;
	}

	public BigDecimal getBloodFee() {
		return bloodFee;
	}

	public void setBloodFee(BigDecimal bloodFee) {
		this.bloodFee = bloodFee;
	}

	public BigDecimal getBedFee() {
		return bedFee;
	}

	public void setBedFee(BigDecimal bedFee) {
		this.bedFee = bedFee;
	}

	public BigDecimal getNursingFee() {
		return nursingFee;
	}

	public void setNursingFee(BigDecimal nursingFee) {
		this.nursingFee = nursingFee;
	}

	public BigDecimal getAnesthesiaFee() {
		return anesthesiaFee;
	}

	public void setAnesthesiaFee(BigDecimal anesthesiaFee) {
		this.anesthesiaFee = anesthesiaFee;
	}

	public BigDecimal getOtherFee() {
		return otherFee;
	}

	public void setOtherFee(BigDecimal otherFee) {
		this.otherFee = otherFee;
	}

	public BigDecimal getConsumablesFee() {
		return consumablesFee;
	}

	public void setConsumablesFee(BigDecimal consumablesFee) {
		this.consumablesFee = consumablesFee;
	}

	public BigDecimal getFeeTotal() {
		return feeTotal;
	}

	public void setFeeTotal(BigDecimal feeTotal) {
		this.feeTotal = feeTotal;
	}

	public Long getRpPersonNum() {
		return rpPersonNum;
	}

	public void setRpPersonNum(Long rpPersonNum) {
		this.rpPersonNum = rpPersonNum;
	}

}
