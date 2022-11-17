package com.founder.rhip.ehr.entity.wsMonitor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="WS_CLIENT_INFO")
public class WsClientInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID",columnDefinition="NUMBER|数据库唯一编号（自增长）|11|",length=11,nullable=false)
	private Long id;

	@Column(name="USER_IP",columnDefinition="VARCHAR2|来访机器IP地址|50|",length=50,nullable=true)
	private String userIp;

	@Column(name="ORG_CODE",columnDefinition="VARCHAR2|机构编码|50|",length=50,nullable=true)
	private String orgCode;

	@Column(name="ORG_NAME",columnDefinition="VARCHAR2|机构名称|100|",length=100,nullable=true)
	private String orgName;

	@Column(name="IS_OFF",columnDefinition="VARCHAR2|禁用标志（0:禁用 1:正常）|1|",length=1,nullable=true)
	private String isOff;

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

	//客户端访问次数
	@Transient
	private Integer accessCount;


	public Integer getAccessCount() {
		return accessCount;
	}

	public void setAccessCount(Integer accessCount) {
		this.accessCount = accessCount;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserIp() {
		return this.userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getOrgCode() {
		return this.orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getIsOff() {
		return this.isOff;
	}

	public void setIsOff(String isOff) {
		this.isOff = isOff;
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