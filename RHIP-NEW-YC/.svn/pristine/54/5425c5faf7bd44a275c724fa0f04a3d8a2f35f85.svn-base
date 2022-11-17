package com.founder.rhip.ehr.entity.portal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.founder.rhip.ehr.common.JaxbDateSerializer;

@Entity
@Table(name="STOP_DOCTOR")
@XmlRootElement(name = "stopDoctor")
@XmlAccessorType(XmlAccessType.FIELD)
public class StopDoctor implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlTransient
	@Id
	@Column(name="ID",columnDefinition="NUMBER|标识",length=11,nullable=false)
	private Long id;

	@Column(name="DOCTOR_SN",columnDefinition="VARCHAR2|专家员工号",length=20,nullable=false)
	private String doctorSn;
	
	@Column(name="DEPT_SN",columnDefinition="VARCHAR2|科室编码",length=20,nullable=false)
	private String deptSn;

	@Column(name = "HOSPITAL_CODE", columnDefinition = "VARCHAR2|医院编码|15|", length = 15, nullable = false)
	private String hospitalCode;

	@Column(name="STOPING_STATUS",columnDefinition="VARCHAR2|停诊状态 0表示未停诊 1表示停诊 2表示已过期",length=10,nullable=false)
	private String stopingStatus;

	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	@Column(name = "START_DATE",columnDefinition="DATE|停诊日期", nullable = false)
	private Date startDate;
	
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	@Column(name = "END_DATE",columnDefinition="DATE|停诊结束日期", nullable = false)
	private Date endDate;
	
	@XmlTransient
	@Column(name = "PERIOD",columnDefinition="VARCHAR2|停诊时间段", length = 20, nullable = true)
	private String period; 

	@XmlTransient
	@Transient
	private String doctorName;
	
	@XmlTransient
	@Transient
	private String deptName;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getDoctorSn() {
		return doctorSn;
	}

	public void setDoctorSn(String doctorSn) {
		this.doctorSn = doctorSn;
	}
	public String getDeptSn() {
		return deptSn;
	}

	public void setDeptSn(String deptSn) {
		this.deptSn = deptSn;
	}
	public String getHospitalCode() {
		return hospitalCode;
	}

	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}
	public String getStopingStatus() {
		return stopingStatus;
	}

	public void setStopingStatus(String stopingStatus) {
		this.stopingStatus = stopingStatus;
	}
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}
	
	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
}