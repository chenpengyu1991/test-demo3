package com.founder.rhip.ehr.entity.hsa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HSA_FAMILY_INFO")
public class FamilyInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = true)
	private Long id;

	@Column(name = "HOUSEHOLDER_NAME", columnDefinition = "VARCHAR2|户主姓名||", length = 50, nullable = true)
	private String householderName;

	@Column(name = "ADDRESS", columnDefinition = "VARCHAR2|家庭地址||", length = 200, nullable = true)
	private String address;
	
	@Column(name = "PHONE_NUMBER", columnDefinition = "VARCHAR2|联系电话||", length = 20, nullable = true)
	private String phoneNumber;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHouseholderName() {
		return this.householderName;
	}

	public void setHouseholderName(String householderName) {
		this.householderName = householderName;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}