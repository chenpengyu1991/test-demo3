package com.founder.rhip.ehr.entity.control.oh;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "OH_WORKLOAD")
public class OhWorkload implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "HOSPITAL_ID", columnDefinition = "NUMBER|医院ID|11|", length = 11, nullable = true)
	private Long hospitalId;

	@Column(name = "DOSE_ID", columnDefinition = "NUMBER|个人剂量档案ID|11|", length = 11, nullable = true)
	private Long doseId;

	@Column(name = "YEAR", columnDefinition = "VARCHAR2|年份|4|", length = 4, nullable = true)
	private String year;

	@Column(name = "PERSPECTIVE", columnDefinition = "VARCHAR2|透视|100|", length = 100, nullable = true)
	private String perspective;

	@Column(name = "STOMACH_INTESTINE", columnDefinition = "VARCHAR2|胃肠|100|", length = 100, nullable = true)
	private String stomachIntestine;

	@Column(name = "X_RAY", columnDefinition = "VARCHAR2|拍片|100|", length = 100, nullable = true)
	private String xRay;

	@Column(name = "INTERVENE", columnDefinition = "VARCHAR2|介入|100|", length = 100, nullable = true)
	private String intervene;

	@Column(name = "ORTHOPEDICS_REPST", columnDefinition = "VARCHAR2|骨科复位|100|", length = 100, nullable = true)
	private String orthopedicsRepst;

	@Column(name = "FOREIGN_FORCEPS", columnDefinition = "VARCHAR2|镊取异物|100|", length = 100, nullable = true)
	private String foreignForceps;

	@Column(name = "INPUT_TIME", columnDefinition = "DATE|录入时间||", nullable = true)
	private Date inputTime;

	@Column(name = "INPUT_PERSON", columnDefinition = "VARCHAR2|录入人|100|", length = 100, nullable = true)
	private String inputPerson;

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

	public Long getDoseId() {
		return this.doseId;
	}

	public void setDoseId(Long doseId) {
		this.doseId = doseId;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getPerspective() {
		return this.perspective;
	}

	public void setPerspective(String perspective) {
		this.perspective = perspective;
	}

	public String getStomachIntestine() {
		return this.stomachIntestine;
	}

	public void setStomachIntestine(String stomachIntestine) {
		this.stomachIntestine = stomachIntestine;
	}

	public String getXRay() {
		return this.xRay;
	}

	public void setXRay(String xRay) {
		this.xRay = xRay;
	}

	public String getIntervene() {
		return this.intervene;
	}

	public void setIntervene(String intervene) {
		this.intervene = intervene;
	}

	public String getOrthopedicsRepst() {
		return this.orthopedicsRepst;
	}

	public void setOrthopedicsRepst(String orthopedicsRepst) {
		this.orthopedicsRepst = orthopedicsRepst;
	}

	public String getForeignForceps() {
		return this.foreignForceps;
	}

	public void setForeignForceps(String foreignForceps) {
		this.foreignForceps = foreignForceps;
	}

	public Date getInputTime() {
		return this.inputTime;
	}

	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}

	public String getInputPerson() {
		return this.inputPerson;
	}

	public void setInputPerson(String inputPerson) {
		this.inputPerson = inputPerson;
	}

	public String getxRay() {
		return xRay;
	}

	public void setxRay(String xRay) {
		this.xRay = xRay;
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