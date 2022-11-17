package com.founder.rhip.ph.dto.vaccine;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Transient;

import com.founder.rhip.ehr.service.export.Item;

public class VaccineValenceDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Item(index = 1, code = "", column = "患者姓名")
	private String name;

	@Item(index = 2, code = "", column = "性别", isDic = true, dicType = "GBT226112003")
	private String gender;

	@Item(index = 3, code = "", column = "身份证")
	private String idcard;

	@Item(index = 4, code = "", column = "联系电话")
	private String phoneNumber;
	
	@Item(index = 5, code = "", column = "住址")
	private String paaddress;

	@Item(index = 6, code = "", column = "接种日期",isDate = true,datePattern="yyyy-MM-dd" )
	private Date vaccinationDate;

	@Item(index = 7, code = "", column = "疫苗批号")
	private String vaccineLotNumber;

	@Item(index = 8, code = "", column = "生产厂家")
	private String vaccineFactory;

	@Item(index = 9, code = "IMMU_UNIT_ID", column = "接种单位", isOrganization = true)
	private String immuUnitId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getVaccinationDate() {
		return vaccinationDate;
	}

	public void setVaccinationDate(Date vaccinationDate) {
		this.vaccinationDate = vaccinationDate;
	}

	public String getVaccineLotNumber() {
		return vaccineLotNumber;
	}

	public void setVaccineLotNumber(String vaccineLotNumber) {
		this.vaccineLotNumber = vaccineLotNumber;
	}

	public String getVaccineFactory() {
		return vaccineFactory;
	}

	public void setVaccineFactory(String vaccineFactory) {
		this.vaccineFactory = vaccineFactory;
	}

	public String getImmuUnitId() {
		return immuUnitId;
	}

	public void setImmuUnitId(String immuUnitId) {
		this.immuUnitId = immuUnitId;
	}
}
