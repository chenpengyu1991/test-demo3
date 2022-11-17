package com.founder.rhip.ehr.entity.wsMonitor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="WS_SERVICE_CLIENT")
public class WsServiceClient implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="SERVICE_ID",columnDefinition="NUMBER|服务信息表ID|11|",length=11,nullable=false)
	private Long serviceId;

	@Column(name="CLIENT_ID",columnDefinition="NUMBER|客户端信息表ID|11|",length=11,nullable=false)
	private Long clientId;

	@Column(name="CREATE_DATE",columnDefinition="DATE|创建日期||",nullable=true)
	private Date createDate;

	@Column(name="CREATE_ORG_CODE",columnDefinition="VARCHAR2|创建机构|50|",length=50,nullable=true)
	private String createOrgCode;

	@Column(name="CREATE_USER_CODE",columnDefinition="VARCHAR2|创建人|50|",length=50,nullable=true)
	private String createUserCode;

	@Column(name="UPDATE_DATE",columnDefinition="DATE|更新日期||",nullable=true)
	private Date updateDate;

	@Column(name="UPDATE_ORG_CODE",columnDefinition="VARCHAR2|更新机构|50|",length=50,nullable=true)
	private String updateOrgCode;

	@Column(name="UPDATE_USER_CODE",columnDefinition="VARCHAR2|更新人|50|",length=50,nullable=true)
	private String updateUserCode;

	@Column(name="REMARK",columnDefinition="VARCHAR2|备注|200|",length=200,nullable=true)
	private String remark;

	public Long getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public Long getClientId() {
		return this.clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateOrgCode() {
		return this.createOrgCode;
	}

	public void setCreateOrgCode(String createOrgCode) {
		this.createOrgCode = createOrgCode;
	}

	public String getCreateUserCode() {
		return this.createUserCode;
	}

	public void setCreateUserCode(String createUserCode) {
		this.createUserCode = createUserCode;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateOrgCode() {
		return this.updateOrgCode;
	}

	public void setUpdateOrgCode(String updateOrgCode) {
		this.updateOrgCode = updateOrgCode;
	}

	public String getUpdateUserCode() {
		return this.updateUserCode;
	}

	public void setUpdateUserCode(String updateUserCode) {
		this.updateUserCode = updateUserCode;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}