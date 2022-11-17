package com.founder.rhip.ehr.entity.management.mhm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "MHM_APPROVAL_INFO")
public class MhmApprovalInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|审批表ID|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "STATUS_ID", columnDefinition = "NUMBER|状态表ID|11|", length = 11, nullable = false)
	private Long statusId;

	@Column(name = "USER_ID", columnDefinition = "VARCHAR2|审批人|50|", length = 50, nullable = true)
	private String userId;

	@Column(name = "USER_NAME", columnDefinition = "VARCHAR2|审批人姓名|50|", length = 50, nullable = true)
	private String userName;

	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|审批机构编码|100|", length = 100, nullable = true)
	private String organCode;

	@Column(name = "ORGAN_NAME", columnDefinition = "VARCHAR2|审批人姓名|100|", length = 100, nullable = true)
	private String organName;
	
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

	public Long getStatusId() {
		return this.statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
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

	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getOrganName() {
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

}