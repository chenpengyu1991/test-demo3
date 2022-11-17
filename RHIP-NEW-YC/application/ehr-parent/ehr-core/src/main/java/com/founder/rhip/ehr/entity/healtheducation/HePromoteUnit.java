package com.founder.rhip.ehr.entity.healtheducation;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "HE_PROMOTE_UNIT")
public class HePromoteUnit implements Serializable {
	
	private static final long serialVersionUID = -4563061732317594238L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|单位名称||", length = 20, nullable = true)
	private String name;

	@Column(name = "TYPE", columnDefinition = "VARCHAR2|创建类别||", length = 20, nullable = true)
	private String type;
	
	@Column(name = "OTHER_TYPE", columnDefinition = "VARCHAR2|其他创建类别||", length = 20, nullable = true)
	private String otherType;

	@Column(name = "UNIT_LEVEL", columnDefinition = "VARCHAR2|创建级别||", length = 20, nullable = true)
	private String unitLevel;
	
	@Column(name = "OTHER_UNIT_LEVEL", columnDefinition = "VARCHAR2|创建级别||", length = 20, nullable = true)
	private String otherUnitLevel;

	@Column(name = "GRANT_TIME", columnDefinition = "DATE|授予时间||", nullable = true)
	private Date grantTime;
	
	@Column(name = "STATUS", columnDefinition = "VARCHAR2|状态||", length = 1, nullable = true)
	private String status;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUnitLevel() {
		return this.unitLevel;
	}

	public void setUnitLevel(String unitLevel) {
		this.unitLevel = unitLevel;
	}

	public Date getGrantTime() {
		return this.grantTime;
	}

	public void setGrantTime(Date grantTime) {
		this.grantTime = grantTime;
	}

	
	public String getOtherType() {
		return otherType;
	}

	
	public void setOtherType(String otherType) {
		this.otherType = otherType;
	}

	
	public String getOtherUnitLevel() {
		return otherUnitLevel;
	}

	
	public void setOtherUnitLevel(String otherUnitLevel) {
		this.otherUnitLevel = otherUnitLevel;
	}

	
	public String getStatus() {
		return status;
	}

	
	public void setStatus(String status) {
		this.status = status;
	}

	
}