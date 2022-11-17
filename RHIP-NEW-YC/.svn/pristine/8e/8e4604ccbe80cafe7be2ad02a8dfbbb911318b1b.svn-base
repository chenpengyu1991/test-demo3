package com.founder.elb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MDM_ACCEZZ")
public class Access implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|自增长字段|11|", length = 11, nullable = false)
	private Integer id;

    @Id
    @Column(name = "ACCESS_CODE", columnDefinition = "VARCHAR2|权限标识|10|", length = 10, nullable = false)
    private String accessCode;

	@Column(name = "ACCESS_LEVEL", columnDefinition = "NUMBER|权限类型|11|", length = 11, nullable = false)
	private Integer accessLevel; //1系统，2菜单，3Action,4字段

	@Column(name = "SRC_ID", columnDefinition = "NUMBER|资源标识|8|", length = 8, nullable = true)
	private Integer srcId;

	@Column(name = "DESCRIPTION", columnDefinition = "VARCHAR2|描述|200|", length = 500, nullable = true)
	private String description;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccessCode() {
		return accessCode;
	}

	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}

	public Integer getAccessLevel() {
		return this.accessLevel;
	}

	public void setAccessLevel(Integer accessLevel) {
		this.accessLevel = accessLevel;
	}

	public Integer getSrcId() {
		return this.srcId;
	}

	public void setSrcId(Integer srcId) {
		this.srcId = srcId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}