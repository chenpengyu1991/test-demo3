package com.founder.elb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ROLE")
public class UserRole implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "USER_ID", columnDefinition = "varchar2|用户标识|10|", length = 10, nullable = true)
	private String userId;

	@Column(name = "ROLE_ID", columnDefinition = "varchar2|角色标识|10|", length = 10, nullable = true)
	private String roleId;

	@Column(name = "ORG_ID", columnDefinition = "varchar2|机构标识|50|", length = 50, nullable = true)
	private String orgId;
	
	@Column(name = "TYPE", columnDefinition = "NUMBER|类型|5|", length = 5, nullable = true)
	private Integer type;

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getOrgId() {
		return this.orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	
	public Integer getType() {
		return type;
	}

	
	public void setType(Integer type) {
		this.type = type;
	}

}