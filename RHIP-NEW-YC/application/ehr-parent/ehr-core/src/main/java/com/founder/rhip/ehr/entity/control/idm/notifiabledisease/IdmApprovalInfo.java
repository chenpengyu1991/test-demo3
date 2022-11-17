package com.founder.rhip.ehr.entity.control.idm.notifiabledisease;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "IDM_APPROVAL_INFO")
public class IdmApprovalInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|审批表ID|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|状态表ID|11|", length = 11, nullable = false)
	private Long idmId;

	@Column(name = "USER_ID", columnDefinition = "VARCHAR2|审批人|20|", length = 20, nullable = true)
	private String userId;

	@Column(name = "USER_NAME", columnDefinition = "VARCHAR2|审批人姓名|50|", length = 50, nullable = true)
	private String userName;

	@Column(name = "APPROVAL_DATE", columnDefinition = "TIMESTAMP|审批时间||", nullable = true)
	private Date approvalDate;

	@Column(name = "STATUS", columnDefinition = "VARCHAR2|审批状态|20|", length = 20, nullable = true)
	private String status;

	@Column(name = "COMMENTS", columnDefinition = "VARCHAR2|审批意见|100|", length = 100, nullable = true)
	private String comments;

	@Column(name = "UNIT_CODE", columnDefinition = "VARCHAR2|当前机构代码|50|", length = 100, nullable = true)
    private String unitCode;

    @Column(name = "NEXT_UNIT", columnDefinition = "VARCHAR2|下一步骤机构代码|50|", length = 100, nullable = true)
    private String nextUnit;
	    
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdmId() {
		return this.idmId;
	}

	public void setIdmId(Long idmId) {
		this.idmId = idmId;
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

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getNextUnit() {
		return nextUnit;
	}

	public void setNextUnit(String nextUnit) {
		this.nextUnit = nextUnit;
	}
	
}