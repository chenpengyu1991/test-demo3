package com.founder.rhip.ehr.entity.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 管理卡撤销恢复操作日志
 */
@Entity
@Table(name = "DM_DISEASE_INFO_LOG")
public class DmDiseaseInfoLog implements Serializable {

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = true)
	private Long id;

	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|个人信息唯一编号||", length = 11, nullable = true)
	private Long personId;

	@Column(name = "DISEASE_INFO_ID", columnDefinition = "NUMBER|dm_disease_info表的id||", length = 11, nullable = true)
	private Long diseaseInfoId;

	@Column(name = "DIS_TYPE", columnDefinition = "VARCHAR2|慢病类型||", length = 50, nullable = true)
	private String disType;

	@Column(name = "OPERATE_TYPE", columnDefinition = "VARCHAR2|操作类型：2恢复 1撤销||", length = 50, nullable = true)
	private String operateType;

	@Column(name = "CREATE_DATE", columnDefinition = "TIMESTAMP|填报时间||", nullable = true)
	private Date createDate;

	@Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|填报机构编码||", length = 50, nullable = true)
	private String createOrganCode;

	@Column(name = "CREATE_DOCTOR_CODE", columnDefinition = "VARCHAR2|填报人编码||", length = 18, nullable = true)
	private String createDoctorCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public Long getDiseaseInfoId() {
		return diseaseInfoId;
	}

	public void setDiseaseInfoId(Long diseaseInfoId) {
		this.diseaseInfoId = diseaseInfoId;
	}

	public String getDisType() {
		return disType;
	}

	public void setDisType(String disType) {
		this.disType = disType;
	}

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateOrganCode() {
		return createOrganCode;
	}

	public void setCreateOrganCode(String createOrganCode) {
		this.createOrganCode = createOrganCode;
	}

	public String getCreateDoctorCode() {
		return createDoctorCode;
	}

	public void setCreateDoctorCode(String createDoctorCode) {
		this.createDoctorCode = createDoctorCode;
	}
}