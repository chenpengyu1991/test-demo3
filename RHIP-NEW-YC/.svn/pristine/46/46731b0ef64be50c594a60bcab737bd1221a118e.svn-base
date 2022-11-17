package com.founder.rhip.ehr.entity.child;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "RESERVE_VACCINATION")
public class ReserveVaccination implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = true)
	private Long id;
	
	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|人员ID|11|", length = 11, nullable = true)
	private Long personId;

	@Column(name = "VACCINATION_CODE", columnDefinition = "VARCHAR2|受种者编码|18|", length = 18, nullable = true)
	private String vaccinationCode;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|姓名|50|", length = 50, nullable = true)
	private String name;

	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别|1|", length = 1, nullable = true)
	private String gender;

	@Column(name = "FATHER_NAME", columnDefinition = "VARCHAR2|父亲姓名|50|", length = 50, nullable = true)
	private String fatherName;

	@Column(name = "MOTHER_NAME", columnDefinition = "VARCHAR2|母亲姓名|50|", length = 50, nullable = true)
	private String motherName;

	@Column(name = "LAST_VACCINATE_TIME", columnDefinition = "DATE|前次接种时间||", nullable = true)
	private Date lastVaccinateTime;

	@Column(name = "VACCINE_NAME", columnDefinition = "VARCHAR2|疫苗简称|100|", length = 100, nullable = true)
	private String vaccineName;

	@Column(name = "VACCINE_TYPE", columnDefinition = "VARCHAR2|剂次种类(1: 基础  2：加强)|1|", length = 1, nullable = true)
	private String vaccineType;

	@Column(name = "TIMES", columnDefinition = "VARCHAR2|剂次|2|", length = 2, nullable = true)
	private String times;

	@Column(name = "VACCINATION_DATE", columnDefinition = "DATE|预约接种日期||", nullable = true)
	private Date vaccinationDate;

	@Column(name = "VACCINE_PRICE", columnDefinition = "VARCHAR2|疫苗价格|20|", length = 20, nullable = true)
	private String vaccinePrice;

	@Column(name = "RESERVE_TIMES", columnDefinition = "VARCHAR2|预约次数|2|", length = 2, nullable = true)
	private String reserveTimes;

	@Column(name = "RESERVE_RESOURCE", columnDefinition = "VARCHAR2|预约来源|50|", length = 50, nullable = true)
	private String reserveResource;

	@Column(name = "PRODUCT_NAME", columnDefinition = "VARCHAR2|制品名称|100|", length = 100, nullable = true)
	private String productName;

	@Column(name = "CREATE_DATE", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createDate;

	@Column(name = "ORGAN_NAME", columnDefinition = "NUMBER|预约检查机构|50|", length = 50, nullable = true)
	private String organName;

	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|预约检查机构code|50|", length = 50, nullable = true)
	private String organCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVaccinationCode() {
		return this.vaccinationCode;
	}

	public void setVaccinationCode(String vaccinationCode) {
		this.vaccinationCode = vaccinationCode;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFatherName() {
		return this.fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public Date getLastVaccinateTime() {
		return this.lastVaccinateTime;
	}

	public void setLastVaccinateTime(Date lastVaccinateTime) {
		this.lastVaccinateTime = lastVaccinateTime;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public String getVaccineType() {
		return vaccineType;
	}

	public void setVaccineType(String vaccineType) {
		this.vaccineType = vaccineType;
	}

	public String getTimes() {
		return this.times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public Date getVaccinationDate() {
		return this.vaccinationDate;
	}

	public void setVaccinationDate(Date vaccinationDate) {
		this.vaccinationDate = vaccinationDate;
	}

	public String getVaccinePrice() {
		return this.vaccinePrice;
	}

	public void setVaccinePrice(String vaccinePrice) {
		this.vaccinePrice = vaccinePrice;
	}

	public String getReserveTimes() {
		return this.reserveTimes;
	}

	public void setReserveTimes(String reserveTimes) {
		this.reserveTimes = reserveTimes;
	}

	public String getReserveResource() {
		return this.reserveResource;
	}

	public void setReserveResource(String reserveResource) {
		this.reserveResource = reserveResource;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getOrganName() {
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	
	
}