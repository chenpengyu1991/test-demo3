package com.founder.rhip.ehr.entity.control.idm.notifiabledisease;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "IDM_CASE_APPROVAL_INFO")
public class CaseApprovalInfo implements Serializable {

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

	@Column(name = "OPERATE_TYPE", columnDefinition = "VARCHAR2|操作类型|1|", length = 1, nullable = true)
	private String operateType;
	
	@Column(name = "UNIT_CODE", columnDefinition = "VARCHAR2|审核机构代码|50|", length = 100, nullable = true)
    private String unitCode;

    @Column(name = "BACK_TO_UNIT", columnDefinition = "VARCHAR2|退回机构代码|50|", length = 100, nullable = true)
    private String backToUnit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdmId() {
		return idmId;
	}

	public void setIdmId(Long idmId) {
		this.idmId = idmId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getBackToUnit() {
		return backToUnit;
	}

	public void setBackToUnit(String backToUnit) {
		this.backToUnit = backToUnit;
	}
	   
}