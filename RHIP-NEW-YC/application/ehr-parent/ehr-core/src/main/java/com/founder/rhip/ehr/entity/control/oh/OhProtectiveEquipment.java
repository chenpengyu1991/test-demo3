package com.founder.rhip.ehr.entity.control.oh;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "OH_PROTECTIVE_EQUIPMENT")
public class OhProtectiveEquipment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "HOSPITAL_ID", columnDefinition = "NUMBER|医院ID|11|", length = 11, nullable = true)
	private Long hospitalId;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|防护用品名称|50|", length = 50, nullable = true)
	private String name;

	@Column(name = "LEAD_EQUIVALENT", columnDefinition = "VARCHAR2|防护铅当量|20|", length = 20, nullable = true)
	private String leadEquivalent;

	@Column(name = "COUNT", columnDefinition = "NUMBER|数量|11|", length = 11, nullable = true)
	private Long count;

	@Column(name = "CREATE_TIME", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createTime;

	@Column(name = "CREATE_BY", columnDefinition = "VARCHAR2|创建者|50|", length = 50, nullable = true)
	private String createBy;

	@Column(name = "UPDATE_TIME", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date updateTime;

	@Column(name = "UPDATE_BY", columnDefinition = "VARCHAR2|更新者|50|", length = 50, nullable = true)
	private String updateBy;

	@Column(name = "IS_DELETE", columnDefinition = "INT|删除状态||", nullable = true)
	private Integer isDelete;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getHospitalId() {
		return this.hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLeadEquivalent() {
		return this.leadEquivalent;
	}

	public void setLeadEquivalent(String leadEquivalent) {
		this.leadEquivalent = leadEquivalent;
	}

	public Long getCount() {
		return this.count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}