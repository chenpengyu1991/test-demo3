/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * 行政区划关系、机构区划关系，按年保存历史记录
 */
package com.founder.rhip.mdm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "MDM_ORG_VILLAGE_RELATION")
public class OrgVillageRelation implements Serializable {

	private static final long serialVersionUID = -3783853941045983055L;
	
	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|机构ID||", length = 11, nullable = false)
	private Long id;
	
	@Column(name = "YEAR", columnDefinition = "NUMBER|年份||", length = 4, nullable = false)
	private Integer year;

	@Column(name = "TOWN_CODE", columnDefinition = "VARCHAR2|镇编码||", length = 20, nullable = true)
	private String townCode;

	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|机构编码||", length = 20, nullable = false)
	private String organCode;

	@Column(name = "VILLAGE_CODE", columnDefinition = "VARCHAR2|区域编码||", length = 20, nullable = false)
	private String villageCode;

	@Column(name = "VILLAGE_NAME", columnDefinition = "VARCHAR2|区域名称||", length = 500, nullable = false)
	private String villageName;

	@Column(name = "TYPE", columnDefinition = "NUMBER|类型（1：行政区划历史，2：机构区划历史）||", length = 1, nullable = false)
	private Integer type;
	
	@Column(name = "CREATE_TIME", columnDefinition = "VARCHAR2|创建时间||", nullable = true)
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getTownCode() {
		return townCode;
	}

	public void setTownCode(String townCode) {
		this.townCode = townCode;
	}

	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getVillageCode() {
		return villageCode;
	}

	public void setVillageCode(String villageCode) {
		this.villageCode = villageCode;
	}

	public String getVillageName() {
		return villageName;
	}

	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}