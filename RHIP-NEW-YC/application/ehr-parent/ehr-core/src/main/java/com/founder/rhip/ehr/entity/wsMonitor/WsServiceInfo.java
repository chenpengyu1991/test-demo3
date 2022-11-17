package com.founder.rhip.ehr.entity.wsMonitor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="WS_SERVICE_INFO")
public class WsServiceInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID",columnDefinition="NUMBER|数据库唯一编号（自增长）|11|",length=11,nullable=false)
	private Long id;

	@Column(name="WEB_SERVICE_NAME",columnDefinition="VARCHAR2|接口名称(KEY)|50|",length=50,nullable=true)
	private String webServiceName;

	@Column(name="WSDL",columnDefinition="VARCHAR2|服务器地址|100|",length=100,nullable=true)
	private String wsdl;

	@Column(name="WEB_SERVICE_DESC",columnDefinition="VARCHAR2|接口描述|200|",length=200,nullable=true)
	private String webServiceDesc;

	@Column(name="SERVER_STATUS",columnDefinition="VARCHAR2|服务开关（0:关闭 1:开启）|1|",length=1,nullable=true)
	private String serverStatus;

	@Column(name="SERVER_FLAG",columnDefinition="VARCHAR2|服务状态（0:异常 1:正常）|1|",length=1,nullable=true)
	private String serverFlag;

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

	@Transient
	private String check;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWebServiceName() {
		return this.webServiceName;
	}

	public void setWebServiceName(String webServiceName) {
		this.webServiceName = webServiceName;
	}

	public String getWsdl() {
		return this.wsdl;
	}

	public void setWsdl(String wsdl) {
		this.wsdl = wsdl;
	}

	public String getWebServiceDesc() {
		return this.webServiceDesc;
	}

	public void setWebServiceDesc(String webServiceDesc) {
		this.webServiceDesc = webServiceDesc;
	}

	public String getServerStatus() {
		return this.serverStatus;
	}

	public void setServerStatus(String serverStatus) {
		this.serverStatus = serverStatus;
	}

	public String getServerFlag() {
		return this.serverFlag;
	}

	public void setServerFlag(String serverFlag) {
		this.serverFlag = serverFlag;
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

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}
}