package com.founder.rhip.ehr.entity.portal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "OUT_CLINIC")
@XmlRootElement(name = "outClinic")
@XmlAccessorType(XmlAccessType.FIELD)
public class OutClinic implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|ID|11|", length = 11, nullable = false)
	private Long id;
	
	@Column(name = "HOSPITAL_CODE", columnDefinition = "VARCHAR2|医院编码|15|", length = 15, nullable = false)
	private String hospitalCode;

	@Column(name = "DEPT_SN", columnDefinition = "VARCHAR2|科室编码|15|", length = 15, nullable = false)
	private String deptSn;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|科室名称|70|", length = 70, nullable = false)
	private String name;

	@XmlTransient
	@Column(name = "ABB_CODE", columnDefinition = "VARCHAR2|备用|70|", length = 70, nullable = false)
	private String abbCode;

	@XmlTransient
	@Column(name = "ABB_NAME", columnDefinition = "VARCHAR2|备用|70|", length = 70, nullable = false)
	private String abbName;
	
	@Column(name = "PY_Code", columnDefinition = "VARCHAR2|拼音代码|", length = 70, nullable = false)
	private String pyCode;
	
	@Transient
	private String clinicType;
	
	@Transient
	private String hospitalName;
	
	@Transient
	private String hospitalInfo;
	
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

	public String getDeptSn() {
		return this.deptSn;
	}

	public void setDeptSn(String deptSn) {
		this.deptSn = deptSn;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbCode() {
		return this.abbCode;
	}

	public void setAbbCode(String abbCode) {
		this.abbCode = abbCode;
	}

	public String getAbbName() {
		return this.abbName;
	}

	public void setAbbName(String abbName) {
		this.abbName = abbName;
	}

	public String getPyCode() {
		return pyCode;
	}

	public void setPyCode(String pyCode) {
		this.pyCode = pyCode;
	}

	public String getClinicType() {
		return clinicType;
	}

	public void setClinicType(String clinicType) {
		this.clinicType = clinicType;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHospitalInfo() {
		return hospitalInfo;
	}

	public void setHospitalInfo(String hospitalInfo) {
		this.hospitalInfo = hospitalInfo;
	}

}