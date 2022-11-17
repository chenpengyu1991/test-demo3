package com.founder.rhip.ehr.entity.portal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import java.io.Serializable;

@Entity
@Table(name = "OUT_DOCTOR")
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class OutDoctor implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|ID|11|", length = 11, nullable = false)
	private Long id;
	
	@Column(name = "HOSPITAL_CODE", columnDefinition = "VARCHAR2|医院编码|15|", length = 15, nullable = false)
	private String hospitalCode;

	@Column(name = "DOCTOR_SN", columnDefinition = "VARCHAR2|医生编码(工号)|15|", length = 15, nullable = false)
	private String doctorSn;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|姓名|30|", length = 30, nullable = false)
	private String name;

	@Column(name = "PY_CODE", columnDefinition = "VARCHAR2|拼音缩写|10|", length = 10, nullable = false)
	@XmlTransient
	private String pyCode;

	@Column(name = "DEPT_NAME", columnDefinition = "VARCHAR2|科室名称|70|", length = 70, nullable = false)
	private String deptName;

	@Column(name = "EMP_TIT_NAME", columnDefinition = "VARCHAR2|职称|70|", length = 70, nullable = false)
	private String empTitName;

	@Column(name = "SOCIAL_NO", columnDefinition = "VARCHAR2|身份证号|18|", length = 18, nullable = true)
	private String socialNo;

	@Column(name = "DEPT_SN", columnDefinition = "VARCHAR2|科室编码|15|", length = 15, nullable = false)
	private String deptSn;

	@Column(name = "EMP_TIT_CODE", columnDefinition = "VARCHAR2|职称代码|15|", length = 15, nullable = true)
	@XmlTransient
	private String empTitCode;

	@Column(name = "SPECIALIZES", columnDefinition = "VARCHAR2|专长|70|", length = 70, nullable = true)
	private String specializes;

	@Column(name = "STATUS", columnDefinition = "NUMBER|审核状态：未审核：0, 已审核：1|1|", length = 1, nullable = true)
	@XmlTransient
	private Integer status = 0;

	@Column(name = "IS_HOT", columnDefinition = "VARCHAR2|是否热门专家: 否：0, 是：1|20|", length = 2, nullable = true)
	@XmlTransient
	private String isHot = "0";

	@Column(name = "WORK_EXPERIENCE", columnDefinition = "CLOB|工作经历|",  nullable = true)
	private String workExperience;

	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除|1|", length = 1, nullable = true)
	@XmlTransient
	private Integer isDelete = 0;

	private String hospitalName;

	/*附件的id*/
	private Long uploadFileId;
	
	/*专家照片连接*/
	private String imgSrc;

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public Long getId() {
		return id;
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

	public String getDoctorSn() {
		return this.doctorSn;
	}

	public void setDoctorSn(String doctorSn) {
		this.doctorSn = doctorSn;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPyCode() {
		return this.pyCode;
	}

	public void setPyCode(String pyCode) {
		this.pyCode = pyCode;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getEmpTitName() {
		return this.empTitName;
	}

	public void setEmpTitName(String empTitName) {
		this.empTitName = empTitName;
	}

	public String getSocialNo() {
		return this.socialNo;
	}

	public void setSocialNo(String socialNo) {
		this.socialNo = socialNo;
	}

	public String getDeptSn() {
		return this.deptSn;
	}

	public void setDeptSn(String deptSn) {
		this.deptSn = deptSn;
	}

	public String getEmpTitCode() {
		return this.empTitCode;
	}

	public void setEmpTitCode(String empTitCode) {
		this.empTitCode = empTitCode;
	}

	public String getSpecializes() {
		return this.specializes;
	}

	public void setSpecializes(String specializes) {
		this.specializes = specializes;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getIsHot() {
		return isHot;
	}

	public void setIsHot(String isHot) {
		this.isHot = isHot;
	}

	public String getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Long getUploadFileId() {
		return uploadFileId;
	}

	public void setUploadFileId(Long uploadFileId) {
		this.uploadFileId = uploadFileId;
	}
}