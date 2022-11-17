package com.founder.rhip.ehr.entity.clinic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "DA_CONSUMABLE_OUT")
public class ConsumableOut implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|唯一自增长编码|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "BATCH_NO", columnDefinition = "VARCHAR2|出库单号（出库批次号）|50|", length = 50, nullable = true)
	private String batchNo;

	@Column(name = "DELIVERY_DT", columnDefinition = "DATE|出库日期||", nullable = true)
	private Date deliveryDt;

	@Column(name = "DELIVERY_TYPE_CODE", columnDefinition = "VARCHAR2|出库方式编码（1药房请领；2科室请领；3盘亏出库；4其他）|1|", length = 1, nullable = true)
	private String deliveryTypeCode;

	@Column(name = "DELIVERY_TYPE_OTHER", columnDefinition = "VARCHAR2|出库方式其他|20|", length = 20, nullable = true)
	private String deliveryTypeOther;

	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|出库医疗机构编码|50|", length = 50, nullable = true)
	private String organCode;

	@Column(name = "ORGAN_NAME", columnDefinition = "VARCHAR2|出库医疗机构名称|100|", length = 100, nullable = true)
	private String organName;

	@Column(name = "APPLY_DEPARTMENT_CODE", columnDefinition = "VARCHAR2|请领科室编码|50|", length = 50, nullable = true)
	private String applyDepartmentCode;

	@Column(name = "APPLY_DEPARTMENT", columnDefinition = "VARCHAR2|请领科室名称|100|", length = 100, nullable = true)
	private String applyDepartmentName;

	@Column(name = "APPLY_PHARMACY_CODE", columnDefinition = "VARCHAR2|请领药房编码|50|", length = 50, nullable = true)
	private String applyPharmacyCode;

	@Column(name = "APPLY_PHARMACY_NAME", columnDefinition = "VARCHAR2|请领药房名称|100|", length = 100, nullable = true)
	private String applyPharmacyName;

	@Column(name = "APPLY_USER_CODE", columnDefinition = "VARCHAR2|请领人员编码|50|", length = 50, nullable = true)
	private String applyUserCode;

	@Column(name = "APPLY_USER_NAME", columnDefinition = "VARCHAR2|请领人员名称|50|", length = 50, nullable = true)
	private String applyUserName;

	@Column(name = "HANDLE_USER_CODE", columnDefinition = "VARCHAR2|经手人编码|50|", length = 50, nullable = true)
	private String handleUserCode;

	@Column(name = "HANDLE_USER_NAME", columnDefinition = "VARCHAR2|经手人名称|50|", length = 50, nullable = true)
	private String handleUserName;

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

	public String getApplyDepartmentCode() {
		return this.applyDepartmentCode;
	}

	public void setApplyDepartmentCode(String applyDepartmentCode) {
		this.applyDepartmentCode = applyDepartmentCode;
	}

	public String getApplyDepartmentName() {
		return this.applyDepartmentName;
	}

	public void setApplyDepartmentName(String applyDepartmentName) {
		this.applyDepartmentName = applyDepartmentName;
	}

	public String getApplyPharmacyCode() {
		return this.applyPharmacyCode;
	}

	public void setApplyPharmacyCode(String applyPharmacyCode) {
		this.applyPharmacyCode = applyPharmacyCode;
	}

	public String getApplyPharmacyName() {
		return this.applyPharmacyName;
	}

	public void setApplyPharmacyName(String applyPharmacyName) {
		this.applyPharmacyName = applyPharmacyName;
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

	public String getHandleUserCode() {
		return this.handleUserCode;
	}

	public void setHandleUserCode(String handleUserCode) {
		this.handleUserCode = handleUserCode;
	}

	public String getHandleUserName() {
		return this.handleUserName;
	}

	public void setHandleUserName(String handleUserName) {
		this.handleUserName = handleUserName;
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

}