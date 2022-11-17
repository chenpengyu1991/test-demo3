package com.founder.rhip.ehr.entity.clinic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
@Table(name = "MS_SICKBED_USE_STATE")
public class SickbedUseState implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlTransient
	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号(自增长)|11|", length = 11, nullable = false)
	private Long id;

	@NotEmpty(message="医院编码为空")
	@Column(name = "HOSPITAL_CODE", columnDefinition = "VARCHAR2|医院编码|50|", length = 50, nullable = true)
	private String hospitalCode;

	@NotEmpty(message="科室编码为空")
	@Length(max = 50,message="科室编码长度过长")
	@Column(name = "DEPARTMENT_CODE", columnDefinition = "VARCHAR2|科室编码|50|", length = 50, nullable = true)
	private String departmentCode;

	@NotEmpty(message="科室名称为空")
	@Length(max = 200,message="科室名称长度过长")
	@Column(name = "DEPARTMENT_NAME", columnDefinition = "VARCHAR2|科室名称|200|", length = 200, nullable = true)
	private String departmentName;

	@NotEmpty(message="所在病区为空")
	@Length(max = 200,message="所在病区长度过长")
	@Column(name = "SICK_AREA", columnDefinition = "VARCHAR2|所在病区|200|", length = 200, nullable = true)
	private String sickArea;

	@NotEmpty(message="病区床号为空")
	@Length(max = 10,message="病区床号长度过长")
	@Column(name = "SICKBED_NO", columnDefinition = "VARCHAR2|病区床号|10|", length = 10, nullable = true)
	private String sickbedNo;

	@NotEmpty(message="是否加床为空")
	@Pattern(regexp="s{0}|0|1",message="是否加床值非法")
	@Column(name = "EXTRA_BED_MARK", columnDefinition = "VARCHAR2|是否加床|2|", length = 2, nullable = true)
	private String extraBedMark;

	@NotEmpty(message="是否开放为空")
	@Pattern(regexp="s{0}|0|1",message="是否开放值非法")
	@Column(name = "AVIRABLE_BED_MARK", columnDefinition = "VARCHAR2|是否开放|2|", length = 2, nullable = true)
	private String avirableBedMark;

	@Length(max = 100,message="住院号长度过长")
	@Column(name = "ADMISSION_NO", columnDefinition = "VARCHAR2|住院号|100|", length = 100, nullable = true)
	private String admissionNo;

	@NotEmpty(message="性别限制为空")
	@Pattern(regexp="s{0}|0|1|2",message="性别限制值非法")
	@Column(name = "GENDER_LIMITED", columnDefinition = "VARCHAR2|性别限制|10|", length = 10, nullable = true)
	private String genderLimited;

	@XmlTransient
	@Column(name = "CREATE_DATE", columnDefinition = "TIMESTAMP|创建时间||", nullable = true)
	private Date createDate;

	@XmlTransient
	@Column(name = "CREATE_ORG", columnDefinition = "VARCHAR2|创建机构|50|", length = 50, nullable = true)
	private String createOrg;

	@XmlTransient
	@Column(name = "CREATE_USER", columnDefinition = "VARCHAR2|创建人|50|", length = 50, nullable = true)
	private String createUser;

	@XmlTransient
	@Column(name = "UPDATE_DATE", columnDefinition = "TIMESTAMP|更新时间||", nullable = true)
	private Date updateDate;

	@XmlTransient
	@Column(name = "UPDATE_ORG", columnDefinition = "VARCHAR2|更新机构|50|", length = 50, nullable = true)
	private String updateOrg;

	@XmlTransient
	@Column(name = "UPDATE_USER", columnDefinition = "VARCHAR2|更新人|50|", length = 50, nullable = true)
	private String updateUser;

	@Column(name = "GATHER_DATE", columnDefinition = "DATE|采集时间||", nullable = true)
	private Date gatherDate;
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHospitalCode() {
		return this.hospitalCode;
	}

	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}

	public String getDepartmentCode() {
		return this.departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getSickArea() {
		return this.sickArea;
	}

	public void setSickArea(String sickArea) {
		this.sickArea = sickArea;
	}

	public String getSickbedNo() {
		return this.sickbedNo;
	}

	public void setSickbedNo(String sickbedNo) {
		this.sickbedNo = sickbedNo;
	}

	public String getExtraBedMark() {
		return this.extraBedMark;
	}

	public void setExtraBedMark(String extraBedMark) {
		this.extraBedMark = extraBedMark;
	}

	public String getAvirableBedMark() {
		return this.avirableBedMark;
	}

	public void setAvirableBedMark(String avirableBedMark) {
		this.avirableBedMark = avirableBedMark;
	}

	public String getAdmissionNo() {
		return this.admissionNo;
	}

	public void setAdmissionNo(String admissionNo) {
		this.admissionNo = admissionNo;
	}

	public String getGenderLimited() {
		return this.genderLimited;
	}

	public void setGenderLimited(String genderLimited) {
		this.genderLimited = genderLimited;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateOrg() {
		return this.createOrg;
	}

	public void setCreateOrg(String createOrg) {
		this.createOrg = createOrg;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateOrg() {
		return this.updateOrg;
	}

	public void setUpdateOrg(String updateOrg) {
		this.updateOrg = updateOrg;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getGatherDate() {
		return gatherDate;
	}

	public void setGatherDate(Date gatherDate) {
		this.gatherDate = gatherDate;
	}

	
}