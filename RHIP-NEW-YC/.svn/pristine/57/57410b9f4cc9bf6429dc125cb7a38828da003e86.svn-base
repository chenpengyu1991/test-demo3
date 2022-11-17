package com.founder.rhip.ehr.entity.control.oh;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "OH_DOSE_DETECTION")
public class OhDoseDetection implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "HOSPITAL_ID", columnDefinition = "NUMBER|医院ID|11|", length = 11, nullable = true)
	private Long hospitalId;

	@Column(name = "DOSE_ID", columnDefinition = "NUMBER|个人剂量档案ID|11|", length = 11, nullable = true)
	private Long doseId;

	@Column(name = "DETECTION_QUARTER", columnDefinition = "VARCHAR2|检测时间|32|", length = 32, nullable = true)
	private String detectionQuarter;

	@Column(name = "DETECTION_RESULT", columnDefinition = "VARCHAR2|检测结果|32|", length = 32, nullable = true)
	private String detectionResult;

	@Column(name = "INPUT_TIME", columnDefinition = "DATE|录入时间||", nullable = true)
	private Date inputTime;

	@Column(name = "INPUT_PERSON", columnDefinition = "VARCHAR2|录入人|100|", length = 100, nullable = true)
	private String inputPerson;

	@Column(name = "CONFIRM_TIME", columnDefinition = "DATE|确认时间||", nullable = true)
	private Date confirmTime;

	@Column(name = "CONFIRM_PERSON", columnDefinition = "VARCHAR2|确认人|100|", length = 100, nullable = true)
	private String confirmPerson;

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

	public String getDetectionQuarter() {
		return this.detectionQuarter;
	}

	public void setDetectionQuarter(String detectionQuarter) {
		this.detectionQuarter = detectionQuarter;
	}

	public String getDetectionResult() {
		return this.detectionResult;
	}

	public void setDetectionResult(String detectionResult) {
		this.detectionResult = detectionResult;
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

	public Date getConfirmTime() {
		return this.confirmTime;
	}

	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
	}

	public String getConfirmPerson() {
		return this.confirmPerson;
	}

	public void setConfirmPerson(String confirmPerson) {
		this.confirmPerson = confirmPerson;
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