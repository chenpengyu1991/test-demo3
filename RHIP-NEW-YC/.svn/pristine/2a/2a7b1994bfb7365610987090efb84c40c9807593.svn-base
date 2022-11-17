package com.founder.rhip.ehr.entity.healtheducation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "HE_AC_RE_LIST")
public class HeAcReList implements Serializable {

	
	private static final long serialVersionUID = 1963006323231286809L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;
	//现在该表名已经修改未HE_ACTIVE
	@Column(name = "HEALTH_EDUCATION_ACTIVE_ID", columnDefinition = "NUMBER|活动表ID||", length = 11, nullable = true)
	private Long healthEducationActiveId;

	@Column(name = "HEALTH_EDUCATION_RESOURCE_ID", columnDefinition = "NUMBER|宣传资料表ID||", length = 11, nullable = true)
	private Long healthEducationResourceId;

	@Column(name = "MATERIAL_TYPE", columnDefinition = "VARCHAR2|宣传材料类型||", length = 50, nullable = true)
	private String materialType;

	@Column(name = "MATERIAL_NAME", columnDefinition = "VARCHAR2|宣传材料||", length = 100, nullable = true)
	private String materialName;

	@Column(name = "HEALTH_EDUCATION_RESOURCE_NUM", columnDefinition = "NUMBER|发放数量||", length = 10, nullable = true)
	private Long healthEducationResourceNum;

	@Column(name = "STATUS", columnDefinition = "VARCHAR2|状态（0删除，1正常）||", length = 1, nullable = true)
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getHealthEducationActiveId() {
		return healthEducationActiveId;
	}

	public void setHealthEducationActiveId(Long healthEducationActiveId) {
		this.healthEducationActiveId = healthEducationActiveId;
	}

	public Long getHealthEducationResourceId() {
		return healthEducationResourceId;
	}

	public void setHealthEducationResourceId(Long healthEducationResourceId) {
		this.healthEducationResourceId = healthEducationResourceId;
	}

	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public Long getHealthEducationResourceNum() {
		return healthEducationResourceNum;
	}

	public void setHealthEducationResourceNum(Long healthEducationResourceNum) {
		this.healthEducationResourceNum = healthEducationResourceNum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}