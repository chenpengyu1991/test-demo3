package com.founder.rhip.ehr.entity.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.io.Serializable;


@Entity
@Table(name = "MDM_USER_ROLE")
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "USER_CODE", columnDefinition = "NUMBER|用户标识|10|", length = 10, nullable = true)
    private String userCode;

    @Column(name = "ROLE_CODE", columnDefinition = "NUMBER|角色标识|10|", length = 5, nullable = true)
    private String roleCode;

    @Column(name = "ORGAN_CODE", columnDefinition = "NUMBER|机构编码|50|", length = 5, nullable = true)
    private String organCode;

    @Column(name = "TYPE", columnDefinition = "NUMBER|类型|5|", length = 5, nullable = true)
    private Integer type;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}


	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public Integer getType() {
        return type;
    }

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public void setType(Integer type) {
        this.type = type;
    }

}