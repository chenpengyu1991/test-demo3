package com.founder.elb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "MDM_ROLE_ACCESS")
public class RoleAccess implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "ROLE_CODE", columnDefinition = "VARCHAR2|角色标识|10|", length = 5, nullable = true)
	private String roleCode;

	@Column(name = "ACCESS_CODE", columnDefinition = "VARCHAR2|权限标识|10|", length = 11, nullable = true)
	private String accessCode;

	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|机构标识|50|", length = 5, nullable = true)
	private String organCode;

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getAccessCode() {
		return accessCode;
	}

	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}

	public String getOrganCode() {
        return organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode;
    }
}