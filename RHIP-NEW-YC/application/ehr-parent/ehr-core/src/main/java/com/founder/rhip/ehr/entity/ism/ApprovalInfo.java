package com.founder.rhip.ehr.entity.ism;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "ISM_APPROVAL_INFO")
public class ApprovalInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|审批表ID|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "REPORT_ID", columnDefinition = "NUMBER|报卡表ID|11|", length = 11, nullable = false)
	private Long reportId;

	@Column(name = "USER_ID", columnDefinition = "VARCHAR2|审批人|20|", length = 20, nullable = true)
	private String userId;

	@Column(name = "USER_NAME", columnDefinition = "VARCHAR2|审批人姓名|50|", length = 50, nullable = true)
	private String userName;
	
	@Column(name = "ORG_CODE", columnDefinition = "VARCHAR2|审批机构编码|50|", length = 50, nullable = true)
	private String orgCode;
	
	@Column(name = "ORG_NAME", columnDefinition = "VARCHAR2|审批机构名称|50|", length = 500, nullable = true)
	private String orgName;

	@Column(name = "APPROVAL_DATE", columnDefinition = "DATE|审批时间||", nullable = true)
	private Date approvalDate;

	@Column(name = "STATUS", columnDefinition = "VARCHAR2|审批状态|20|", length = 20, nullable = true)
	private String status;

	@Column(name = "COMMENTS", columnDefinition = "VARCHAR2|审批意见|100|", length = 100, nullable = true)
	private String comments;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getApprovalDate() {
		return this.approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Long getReportId() {
		return reportId;
	}

	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}

}