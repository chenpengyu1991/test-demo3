package com.founder.elb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "MDM_ROLE")
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|子增长字段|5|", length = 5, nullable = false)
	private Integer id;

    @Id
    @Column(name = "ROLE_CODE", columnDefinition = "VARCHAR2|角色标识|10|", length = 10, nullable = false)
    private String roleCode;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|角色名称|200|", length = 200, nullable = true)
	private String name;

	@Column(name = "STATUS", columnDefinition = "NUMBER|是否可用|1|", length = 1, nullable = true)
	private Integer status;//1可用，0不可用

	@Column(name = "DESCRIPTION", columnDefinition = "VARCHAR2|角色描述|500|", length = 500, nullable = true)
	private String description;

	@Column(name = "CREATOR", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = true)
	private Long creator;

	@Column(name = "CREATE_TIME", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createTime;

	@Column(name = "UPDATER", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = true)
	private Long updater;

	@Column(name = "UPDATE_TIME", columnDefinition = "DATE|修改时间||", nullable = true)
	private Date updateTime;

	private String accesses;   //用户所有权限id，以逗号(,)分隔符连接
	
	private Integer hasRole; 
	
    private Integer isCheck=0; //是否被选中，敏感数据隐藏中使用
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCreator() {
		return this.creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getUpdater() {
		return this.updater;
	}

	public void setUpdater(Long updater) {
		this.updater = updater;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getAccesses() {
		return accesses;
	}

	public void setAccesses(String accesses) {
		this.accesses = accesses;
	}

	public Integer getHasRole() {
		return hasRole;
	}

	public void setHasRole(Integer hasRole) {
		this.hasRole = hasRole;
	}

	public Integer getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(Integer isCheck) {
		this.isCheck = isCheck;
	}

	
}