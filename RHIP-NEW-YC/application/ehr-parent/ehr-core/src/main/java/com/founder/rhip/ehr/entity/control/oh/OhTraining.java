package com.founder.rhip.ehr.entity.control.oh;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "OH_TRAINING")
public class OhTraining implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "HOSPITAL_ID", columnDefinition = "NUMBER|医院ID|11|", length = 11, nullable = true)
	private Long hospitalId;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|姓名|100|", length = 100, nullable = true)
	private String name;

	@Column(name = "TREATE_TIME", columnDefinition = "DATE|培训时间||", nullable = true)
	private Date treateTime;

	@Column(name = "TREATE_NO", columnDefinition = "VARCHAR2|培训证号|32|", length = 32, nullable = true)
	private String treateNo;

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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getTreateTime() {
		return this.treateTime;
	}

	public void setTreateTime(Date treateTime) {
		this.treateTime = treateTime;
	}

	public String getTreateNo() {
		return this.treateNo;
	}

	public void setTreateNo(String treateNo) {
		this.treateNo = treateNo;
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
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}