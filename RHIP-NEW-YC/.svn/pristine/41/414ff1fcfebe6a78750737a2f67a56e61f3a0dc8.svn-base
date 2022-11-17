package com.founder.rhip.mdm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BRW_EXPLORER_SET")
public class ExplorerSet implements Serializable {


	private static final long serialVersionUID = -4879125652749298904L;
	
	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;
	
	@Column(name = "DOCTOR_TYPE", columnDefinition = "VARCHAR2|调阅医生分类||", length = 5, nullable = true)
	private String doctorType;

	@Column(name = "SET_TYPE", columnDefinition = "VARCHAR2|浏览器配置类别||", length = 5, nullable = true)
	private String setType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDoctorType() {
		return doctorType;
	}

	public void setDoctorType(String doctorType) {
		this.doctorType = doctorType;
	}

	public String getSetType() {
		return setType;
	}

	public void setSetType(String setType) {
		this.setType = setType;
	}
	
	
}
