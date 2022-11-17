package com.founder.rhip.ehr.entity.portal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ORGANIZATION_LINK")
public class OrganizationLink implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|自增长id|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "ORG_NAME", columnDefinition = "VARCHAR2|机构名称|100|", length = 100, nullable = true)
	private String orgName;

	@Column(name = "URL", columnDefinition = "VARCHAR2|网址|100|", length = 100, nullable = true)
	private String url;

	@Column(name = "STATUS", columnDefinition = "NUMBER|状态：已发布：1,未发布：0|1|", length = 200, nullable = true)
	private Integer status = 0;
	
	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除|1|", length = 2, nullable = true)
	private Integer isDelete = 0;

	@Column(name = "ORDER_NUM", columnDefinition = "NUMBER|序号|11|", length = 11, nullable = true)
	private Long orderNum;

	@Column(name = "CREATE_DATE", columnDefinition = "DATE|创建日期", length = 50, nullable = true)
	private Date createDate;

	@Column(name = "CREATE_ORG_CODE", columnDefinition = "VARCHAR2|创建机构|50|", length = 50, nullable = true)
	private String createOrgCode;

	@Column(name = "CREATE_USER_CODE", columnDefinition = "VARCHAR2|创建人|50|", length = 18, nullable = true)
	private String createUserCode;

	@Column(name = "UPDATE_DATE", columnDefinition = "DATE|更新日期|", length = 50, nullable = true)
	private Date updateDate;

	@Column(name = "UPDATE_ORG_CODE", columnDefinition = "VARCHAR2|更新机构|50|", length = 50, nullable = true)
	private String updateOrgCode;

	@Column(name = "UPDATE_USER_CODE", columnDefinition = "VARCHAR2|更新人|50|", length = 18, nullable = true)
	private String updateUserCode;

	private String operation;//1 查看 2 修改3增加
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateOrgCode() {
		return createOrgCode;
	}

	public void setCreateOrgCode(String createOrgCode) {
		this.createOrgCode = createOrgCode;
	}

	public String getCreateUserCode() {
		return createUserCode;
	}

	public void setCreateUserCode(String createUserCode) {
		this.createUserCode = createUserCode;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateOrgCode() {
		return updateOrgCode;
	}

	public void setUpdateOrgCode(String updateOrgCode) {
		this.updateOrgCode = updateOrgCode;
	}

	public String getUpdateUserCode() {
		return updateUserCode;
	}

	public void setUpdateUserCode(String updateUserCode) {
		this.updateUserCode = updateUserCode;
	}
}