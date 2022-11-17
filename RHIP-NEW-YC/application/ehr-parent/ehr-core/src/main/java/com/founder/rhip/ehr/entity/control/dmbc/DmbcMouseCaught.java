package com.founder.rhip.ehr.entity.control.dmbc;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.util.Date;

@Entity
@Table(name = "DMBC_MOUSE_CAUGHT")
public class DmbcMouseCaught implements Serializable {

	private static final long serialVersionUID = 1L;
	@Transient
	//@Column(name = "NUM", columnDefinition = "NUMBER|序号||", length = 11, scale = 11, nullable = false)
	private Long num;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, scale = 11, nullable = false)
	private Long id;

	@Column(name = "MONITOR_ID", columnDefinition = "NUMBER|鼠密度监测记录ID||", length = 11, scale = 11, nullable = true)
	private Long monitorId;

	@Column(name = "MOUSE_SPECIES", columnDefinition = "VARCHAR2|鼠种||", length = 20, scale = 20, nullable = true)
	private String mouseSpecies;

	@Column(name = "SITE", columnDefinition = "VARCHAR2|捕鼠地点||", length = 40, scale = 40, nullable = true)
	private String site;

	@Column(name = "ENVIRONMENT", columnDefinition = "VARCHAR2|室内、外||", length = 20, scale = 20, nullable = true)
	private String environment;

	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别||", length = 20, scale = 20, nullable = true)
	private String gender;

	@Column(name = "BODY_LENGTH", columnDefinition = "NUMBER|头体长||", length = 5, scale = 5, nullable = true)
	private Long bodyLength;

	@Column(name = "REMARKS", columnDefinition = "VARCHAR2|备注||", length = 40, scale = 40, nullable = true)
	private String remarks;

	@Column(name = "WEIGHT", columnDefinition = "VARCHAR2|体重||", length = 20, scale = 20, nullable = true)
	private String weight;

	@Column(name = "CREATE_TIME", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createTime;

	@Column(name = "CREATE_BY", columnDefinition = "VARCHAR2|创建者||", length = 20, scale = 20, nullable = true)
	private String createBy;

	@Column(name = "UPDATE_TIME", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date updateTime;

	@Column(name = "UPDATE_BY", columnDefinition = "VARCHAR2|更新者||", length = 20, scale = 20, nullable = true)
	private String updateBy;

	@Column(name = "IS_DELETE", columnDefinition = "INT|删除状态||", nullable = true)
	private Integer isDelete;

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMonitorId() {
		return this.monitorId;
	}

	public void setMonitorId(Long monitorId) {
		this.monitorId = monitorId;
	}

	public String getMouseSpecies() {
		return this.mouseSpecies;
	}

	public void setMouseSpecies(String mouseSpecies) {
		this.mouseSpecies = mouseSpecies;
	}

	public String getSite() {
		return this.site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getEnvironment() {
		return this.environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getBodyLength() {
		return this.bodyLength;
	}

	public void setBodyLength(Long bodyLength) {
		this.bodyLength = bodyLength;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateBy() {
		return this.updateBy;
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