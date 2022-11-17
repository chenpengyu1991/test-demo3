package com.founder.rhip.ehr.entity.clinic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "DA_PHARMACY_OUT")
public class PharmacyOut implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|唯一自增长编码|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "BATCH_NO", columnDefinition = "VARCHAR2|出库单号（出库批次号）|50|", length = 50, nullable = true)
	private String batchNo;

	@Column(name = "DELIVERY_DT", columnDefinition = "DATE|出库日期||", nullable = true)
	private Date deliveryDt;

	@Column(name = "DELIVERY_TYPE_CODE", columnDefinition = "VARCHAR2|出库方式编码（1药房调拨；2科室请领；3病人发药；4盘亏出库；4其他）|1|", length = 1, nullable = true)
	private String deliveryTypeCode;

	@Column(name = "DELIVERY_TYPE_OTHER", columnDefinition = "VARCHAR2|出库方式其他|20|", length = 20, nullable = true)
	private String deliveryTypeOther;

	@Column(name = "TRANSFER_SLIP", columnDefinition = "VARCHAR2|调拨单号|50|", length = 50, nullable = true)
	private String transferSlip;

	@Column(name = "ORG_TYPE", columnDefinition = "VARCHAR2|机构类型(A1综合医院；B1中心；B2站；D400医务室；L监督所；R2其他)|4|", length = 4, nullable = true)
	private String orgType;
	
	@Column(name = "GBCODE", columnDefinition = "VARCHAR2|行政区划代码(镇）|50|", length = 50, nullable = true)
	private String gbcode;
	
	@Column(name = "SUP_ORGAN_CODE", columnDefinition = "VARCHAR2|上级机构编码(中心)|50|", length = 50, nullable = true)
	private String supOrganCode;
	
	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|出库医疗机构编码|50|", length = 50, nullable = true)
	private String organCode;

	@Column(name = "ORGAN_NAME", columnDefinition = "VARCHAR2|出库医疗机构名称|100|", length = 100, nullable = true)
	private String organName;

	@Column(name = "PHARMACY_TYPE_CODE", columnDefinition = "VARCHAR2|出库药房类型（1门诊药房；2病区药房；3科室；4其他|1|", length = 1, nullable = true)
	private String pharmacyTypeCode;

	@Column(name = "PHARMACY_TYPE_OTHER", columnDefinition = "VARCHAR2|出库药房其他|20|", length = 20, nullable = true)
	private String pharmacyTypeOther;

	@Column(name = "OUT_DEPARTMENT_CODE", columnDefinition = "VARCHAR2|出库药房/科室编码（药房调拨时存药房信息；科室请领时存科室信息；病人发药时存药房信息）|50|", length = 50, nullable = true)
	private String outDepartmentCode;

	@Column(name = "OUT_DEPARTMENT_NAME", columnDefinition = "VARCHAR2|出库药房/科室名称|100|", length = 100, nullable = true)
	private String outDepartmentName;

	@Column(name = "IN_DEPARTMENT_CODE", columnDefinition = "VARCHAR2|请领药房/科室编码（药房调拨时存药房信息；科室请领时存科室信息；病人发药时为空）|50|", length = 50, nullable = true)
	private String inDepartmentCode;

	@Column(name = "IN_DEPARTMENT_NAME", columnDefinition = "VARCHAR2|请领药房/科室名称|100|", length = 100, nullable = true)
	private String inDepartmentName;

	@Column(name = "APPLY_USER_CODE", columnDefinition = "VARCHAR2|请领人员编码|50|", length = 50, nullable = true)
	private String applyUserCode;

	@Column(name = "APPLY_USER_NAME", columnDefinition = "VARCHAR2|请领人员名称|50|", length = 50, nullable = true)
	private String applyUserName;

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

	@Column(name = "OPERATOR_CODE", columnDefinition = "VARCHAR2|出库人员编码|50|", length = 50, nullable = true)
	private String operatorCode;

	@Column(name = "OPERATOR_NAME", columnDefinition = "VARCHAR2|出库人员名称|50|", length = 50, nullable = true)
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

	public Date getDeliveryDt() {
		return this.deliveryDt;
	}

	public void setDeliveryDt(Date deliveryDt) {
		this.deliveryDt = deliveryDt;
	}

	public String getDeliveryTypeCode() {
		return this.deliveryTypeCode;
	}

	public void setDeliveryTypeCode(String deliveryTypeCode) {
		this.deliveryTypeCode = deliveryTypeCode;
	}

	public String getDeliveryTypeOther() {
		return this.deliveryTypeOther;
	}

	public void setDeliveryTypeOther(String deliveryTypeOther) {
		this.deliveryTypeOther = deliveryTypeOther;
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

	public String getPharmacyTypeCode() {
		return this.pharmacyTypeCode;
	}

	public void setPharmacyTypeCode(String pharmacyTypeCode) {
		this.pharmacyTypeCode = pharmacyTypeCode;
	}

	public String getPharmacyTypeOther() {
		return this.pharmacyTypeOther;
	}

	public void setPharmacyTypeOther(String pharmacyTypeOther) {
		this.pharmacyTypeOther = pharmacyTypeOther;
	}

	public String getApplyUserCode() {
		return this.applyUserCode;
	}

	public void setApplyUserCode(String applyUserCode) {
		this.applyUserCode = applyUserCode;
	}

	public String getApplyUserName() {
		return this.applyUserName;
	}

	public void setApplyUserName(String applyUserName) {
		this.applyUserName = applyUserName;
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

	public String getOutDepartmentCode() {
		return outDepartmentCode;
	}

	public void setOutDepartmentCode(String outDepartmentCode) {
		this.outDepartmentCode = outDepartmentCode;
	}

	public String getOutDepartmentName() {
		return outDepartmentName;
	}

	public void setOutDepartmentName(String outDepartmentName) {
		this.outDepartmentName = outDepartmentName;
	}

	public String getInDepartmentCode() {
		return inDepartmentCode;
	}

	public void setInDepartmentCode(String inDepartmentCode) {
		this.inDepartmentCode = inDepartmentCode;
	}

	public String getInDepartmentName() {
		return inDepartmentName;
	}

	public void setInDepartmentName(String inDepartmentName) {
		this.inDepartmentName = inDepartmentName;
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