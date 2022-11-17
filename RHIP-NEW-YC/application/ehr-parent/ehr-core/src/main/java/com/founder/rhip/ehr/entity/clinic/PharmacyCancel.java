package com.founder.rhip.ehr.entity.clinic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "DA_PHARMACY_CANCEL")
public class PharmacyCancel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|唯一自增长编码|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "BATCH_NO", columnDefinition = "VARCHAR2|退药单号（入库批次号）|50|", length = 50, nullable = true)
	private String batchNo;

	@Column(name = "CANCEL_DT", columnDefinition = "DATE|退药日期||", nullable = true)
	private Date cancelDt;

	@Column(name = "CANCEL_REASON", columnDefinition = "VARCHAR2|退货原因|400|", length = 400, nullable = true)
	private String cancelReason;

	@Column(name = "CANCEL_TYPE_CODE", columnDefinition = "VARCHAR2|退药方式编码（1科室退药；2病人退药；3调拨；4其他）|1|", length = 1, nullable = true)
	private String cancelTypeCode;

	@Column(name = "CANCEL_TYPE_OTHER", columnDefinition = "VARCHAR2|退药方式其他|50|", length = 50, nullable = true)
	private String cancelTypeOther;

	@Column(name = "TRANSFER_SLIP", columnDefinition = "VARCHAR2|调拨单号|50|", length = 50, nullable = true)
	private String transferSlip;

	@Column(name = "TARGET_PHARMACY_TYPE", columnDefinition = "VARCHAR2|退往药房类型（1门诊药房；2病区药房；3科室；4其他）|1|", length = 1, nullable = true)
	private String targetPharmacyType;

	@Column(name = "TARGET_PHARMACY_OTHER", columnDefinition = "VARCHAR2|退往药房类型其他|50|", length = 50, nullable = true)
	private String targetPharmacyOther;

	@Column(name = "ORG_TYPE", columnDefinition = "VARCHAR2|机构类型(A1综合医院；B1中心；B2站；D400医务室；L监督所；R2其他)|4|", length = 4, nullable = true)
	private String orgType;
	
	@Column(name = "GBCODE", columnDefinition = "VARCHAR2|行政区划代码(镇）|50|", length = 50, nullable = true)
	private String gbcode;
	
	@Column(name = "SUP_ORGAN_CODE", columnDefinition = "VARCHAR2|上级机构编码(中心)|50|", length = 50, nullable = true)
	private String supOrganCode;
	
	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|退药医疗机构编码|50|", length = 50, nullable = true)
	private String organCode;

	@Column(name = "ORGAN_NAME", columnDefinition = "VARCHAR2|退药医疗机构名称|100|", length = 100, nullable = true)
	private String organName;

	@Column(name = "TARGET_PHARMACY_CODE", columnDefinition = "VARCHAR2|退往药房编码|50|", length = 50, nullable = true)
	private String targetPharmacyCode;

	@Column(name = "TARGET_PHARMACY_NAME", columnDefinition = "VARCHAR2|退往药房名称|100|", length = 100, nullable = true)
	private String targetPharmacyName;
	
	@Column(name = "CANCEL_DEPARTMENT_CODE", columnDefinition = "VARCHAR2|退药科室编码|50|", length = 50, nullable = true)
	private String cancelDepartmentCode;

	@Column(name = "CANCEL_DEPARTMENT_NAME", columnDefinition = "VARCHAR2|退药科室名称|100|", length = 100, nullable = true)
	private String cancelDepartmentName;

	@Column(name = "PATIENT_TYPE", columnDefinition = "VARCHAR2|病人类型（门诊；住院）|1|", length = 1, nullable = true)
	private String patientType;

	@Column(name = "PATIENT_IDCARD", columnDefinition = "VARCHAR2|病人身份证号|18|", length = 18, nullable = true)
	private String patientIdcard;

	@Column(name = "PATIENT_NAME", columnDefinition = "VARCHAR2|病人名称|50|", length = 50, nullable = true)
	private String patientName;

	@Column(name = "INVOICE_NO", columnDefinition = "VARCHAR2|发票号|50|", length = 50, nullable = true)
	private String invoiceNo;

	@Column(name = "PATIENT_MZH", columnDefinition = "VARCHAR2|病人门诊号/住院号|50|", length = 50, nullable = true)
	private String patientMzh;

	@Column(name = "PATIENT_CYH", columnDefinition = "VARCHAR2|病人处方号/医嘱号|50|", length = 50, nullable = true)
	private String patientCyh;

	@Column(name = "COMMENTS", columnDefinition = "VARCHAR2|备注|200|", length = 200, nullable = true)
	private String comments;

	@Column(name = "OPERATOR_CODE", columnDefinition = "VARCHAR2|退货人员编码|50|", length = 50, nullable = true)
	private String operatorCode;

	@Column(name = "OPERATOR_NAME", columnDefinition = "VARCHAR2|退货人员名称|50|", length = 50, nullable = true)
	private String operatorName;

	@Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|创建机构编码|50|", length = 50, nullable = true)
	private String createOrganCode;

	@Column(name = "CREATE_ORGAN_NAME", columnDefinition = "VARCHAR2|创建机构名称|100|", length = 100, nullable = true)
	private String createOrganName;

	@Column(name = "CREATE_DATE", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createDate;

	@Column(name = "UPDATE_ORGAN_CODE", columnDefinition = "VARCHAR2|更新机构编码|50|", length = 50, nullable = true)
	private String updateOrganCode;

	@Column(name = "UPDATE_ORGAN_NAME", columnDefinition = "VARCHAR2|更新机构名称|100|", length = 100, nullable = true)
	private String updateOrganName;

	@Column(name = "UPDATE_DATE", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date updateDate;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBatchNo() {
		return this.batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public Date getCancelDt() {
		return this.cancelDt;
	}

	public void setCancelDt(Date cancelDt) {
		this.cancelDt = cancelDt;
	}

	public String getCancelReason() {
		return this.cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public String getCancelTypeCode() {
		return this.cancelTypeCode;
	}

	public void setCancelTypeCode(String cancelTypeCode) {
		this.cancelTypeCode = cancelTypeCode;
	}

	public String getCancelTypeOther() {
		return this.cancelTypeOther;
	}

	public void setCancelTypeOther(String cancelTypeOther) {
		this.cancelTypeOther = cancelTypeOther;
	}

	public String getTransferSlip() {
		return this.transferSlip;
	}

	public void setTransferSlip(String transferSlip) {
		this.transferSlip = transferSlip;
	}

	public String getOrganCode() {
		return this.organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getOrganName() {
		return this.organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public String getCancelDepartmentCode() {
		return this.cancelDepartmentCode;
	}

	public void setCancelDepartmentCode(String cancelDepartmentCode) {
		this.cancelDepartmentCode = cancelDepartmentCode;
	}

	public String getCancelDepartmentName() {
		return this.cancelDepartmentName;
	}

	public void setCancelDepartmentName(String cancelDepartmentName) {
		this.cancelDepartmentName = cancelDepartmentName;
	}

	public String getPatientType() {
		return this.patientType;
	}

	public void setPatientType(String patientType) {
		this.patientType = patientType;
	}

	public String getPatientIdcard() {
		return this.patientIdcard;
	}

	public void setPatientIdcard(String patientIdcard) {
		this.patientIdcard = patientIdcard;
	}

	public String getPatientName() {
		return this.patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getInvoiceNo() {
		return this.invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getPatientMzh() {
		return this.patientMzh;
	}

	public void setPatientMzh(String patientMzh) {
		this.patientMzh = patientMzh;
	}

	public String getPatientCyh() {
		return this.patientCyh;
	}

	public void setPatientCyh(String patientCyh) {
		this.patientCyh = patientCyh;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getOperatorCode() {
		return this.operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	public String getOperatorName() {
		return this.operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getCreateOrganCode() {
		return this.createOrganCode;
	}

	public void setCreateOrganCode(String createOrganCode) {
		this.createOrganCode = createOrganCode;
	}

	public String getCreateOrganName() {
		return this.createOrganName;
	}

	public void setCreateOrganName(String createOrganName) {
		this.createOrganName = createOrganName;
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

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getTargetPharmacyType() {
		return targetPharmacyType;
	}

	public void setTargetPharmacyType(String targetPharmacyType) {
		this.targetPharmacyType = targetPharmacyType;
	}

	public String getTargetPharmacyOther() {
		return targetPharmacyOther;
	}

	public void setTargetPharmacyOther(String targetPharmacyOther) {
		this.targetPharmacyOther = targetPharmacyOther;
	}

	public String getTargetPharmacyCode() {
		return targetPharmacyCode;
	}

	public void setTargetPharmacyCode(String targetPharmacyCode) {
		this.targetPharmacyCode = targetPharmacyCode;
	}

	public String getTargetPharmacyName() {
		return targetPharmacyName;
	}

	public void setTargetPharmacyName(String targetPharmacyName) {
		this.targetPharmacyName = targetPharmacyName;
	}

	public String getGbcode() {
		return gbcode;
	}

	public void setGbcode(String gbcode) {
		this.gbcode = gbcode;
	}

	public String getSupOrganCode() {
		return supOrganCode;
	}

	public void setSupOrganCode(String supOrganCode) {
		this.supOrganCode = supOrganCode;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

}