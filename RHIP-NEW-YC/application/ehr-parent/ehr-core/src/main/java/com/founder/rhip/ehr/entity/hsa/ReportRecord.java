package com.founder.rhip.ehr.entity.hsa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HSA_REPORT_RECORD")
public class ReportRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = true)
	private Long id;

	@Column(name = "INSP_REOCRD_ID", columnDefinition = "NUMBER|巡查记录编号||", length = 11, nullable = true)
	private Long inspReocrdId;

	@Column(name = "DISCOVERY_DATE", columnDefinition = "TIMESTAMP|发现时间||", nullable = true)
	private Date discoveryDate;

	@Column(name = "INFO_CONTENT", columnDefinition = "VARCHAR2|信息内容||", length = 500, nullable = true)
	private String infoContent;

	@Column(name = "INFO_TYPE_NAME", columnDefinition = "VARCHAR2|信息类别名称||", length = 50, nullable = true)
	private String infoTypeName;

	@Column(name = "INFO_TYPE_CODE", columnDefinition = "VARCHAR2|信息类别编码||", length = 2, nullable = true)
	private String infoTypeCode;

	@Column(name = "ILLEGAL_FLAG", columnDefinition = "VARCHAR2|违法标志||", length = 2, nullable = true)
	private String illegalFlag;
	
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
	
	@Column(name = "STATUS", columnDefinition = "VARCHAR2|状态||", length = 1, nullable = true)
	private String status;
	
	@Column(name = "DEAL_ADVICE", columnDefinition = "VARCHAR2|处理意见||", length = 200, nullable = true)
	private String dealAdvice;
	
	@Column(name = "DEAL_DATE", columnDefinition = "TIMESTAMP|处理日期和时间||", nullable = true)
	private Date dealDate;

	@Column(name = "VISIT_FLAG", columnDefinition = "VARCHAR2|回访标志||", length = 2, nullable = true)
	private String visitFlag;
	
	@Column(name = "VISIT_DATE", columnDefinition = "TIMESTAMP|回访日期和时间||", nullable = true)
	private Date visitDate;
	
	@Column(name = "VISIT_ADVICE", columnDefinition = "VARCHAR2|回访意见||", length = 200, nullable = true)
	private String visitAdvice;
	
	@Column(name = "RECEIVE_ORGANIZATION", columnDefinition = "VARCHAR2|接收机构||", length = 50, nullable = true)
	private String receiveOrganization;
	
	@Column(name = "RECEIVE_DATE", columnDefinition = "TIMESTAMP|接收日期和时间||", nullable = true)
	private Date receiveDate;
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getInspReocrdId() {
		return this.inspReocrdId;
	}

	public void setInspReocrdId(Long inspReocrdId) {
		this.inspReocrdId = inspReocrdId;
	}


	public Date getDiscoveryDate() {
		return this.discoveryDate;
	}

	public void setDiscoveryDate(Date discoveryDate) {
		this.discoveryDate = discoveryDate;
	}

	public String getInfoContent() {
		return this.infoContent;
	}

	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}

	public String getInfoTypeName() {
		return this.infoTypeName;
	}

	public void setInfoTypeName(String infoTypeName) {
		this.infoTypeName = infoTypeName;
	}

	public String getInfoTypeCode() {
		return this.infoTypeCode;
	}

	public void setInfoTypeCode(String infoTypeCode) {
		this.infoTypeCode = infoTypeCode;
	}


	public String getIllegalFlag() {
		return illegalFlag;
	}

	public void setIllegalFlag(String illegalFlag) {
		this.illegalFlag = illegalFlag;
	}

	public String getCreateOrganName() {
		return createOrganName;
	}

	public void setCreateOrganName(String createOrganName) {
		this.createOrganName = createOrganName;
	}

	public String getCreateOrganCode() {
		return createOrganCode;
	}

	public void setCreateOrganCode(String createOrganCode) {
		this.createOrganCode = createOrganCode;
	}

	public String getCreateDoctorName() {
		return createDoctorName;
	}

	public void setCreateDoctorName(String createDoctorName) {
		this.createDoctorName = createDoctorName;
	}

	public String getCreateDoctorCode() {
		return createDoctorCode;
	}

	public void setCreateDoctorCode(String createDoctorCode) {
		this.createDoctorCode = createDoctorCode;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateOrganCode() {
		return updateOrganCode;
	}

	public void setUpdateOrganCode(String updateOrganCode) {
		this.updateOrganCode = updateOrganCode;
	}

	public String getUpdateOrganName() {
		return updateOrganName;
	}

	public void setUpdateOrganName(String updateOrganName) {
		this.updateOrganName = updateOrganName;
	}

	public String getUpdateDoctorCode() {
		return updateDoctorCode;
	}

	public void setUpdateDoctorCode(String updateDoctorCode) {
		this.updateDoctorCode = updateDoctorCode;
	}

	public String getUpdateDoctorName() {
		return updateDoctorName;
	}

	public void setUpdateDoctorName(String updateDoctorName) {
		this.updateDoctorName = updateDoctorName;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDealAdvice() {
		return dealAdvice;
	}

	public void setDealAdvice(String dealAdvice) {
		this.dealAdvice = dealAdvice;
	}

	public String getVisitFlag() {
		return visitFlag;
	}

	public void setVisitFlag(String visitFlag) {
		this.visitFlag = visitFlag;
	}

	public String getVisitAdvice() {
		return visitAdvice;
	}

	public void setVisitAdvice(String visitAdvice) {
		this.visitAdvice = visitAdvice;
	}

	public String getReceiveOrganization() {
		return receiveOrganization;
	}

	public void setReceiveOrganization(String receiveOrganization) {
		this.receiveOrganization = receiveOrganization;
	}

	public Date getDealDate() {
		return dealDate;
	}

	public void setDealDate(Date dealDate) {
		this.dealDate = dealDate;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public Date getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}

}