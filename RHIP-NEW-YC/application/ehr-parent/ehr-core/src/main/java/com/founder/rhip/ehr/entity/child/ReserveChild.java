
package com.founder.rhip.ehr.entity.child;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "RESERVE_CHILD")
@XmlRootElement
public class ReserveChild implements Serializable {

	private static final long serialVersionUID = -8941532920260997923L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
	private Long id;
	
	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
    private Long personId;
	
	@Column(name = "BABY_NAME", columnDefinition = "VARCHAR2|儿童姓名|11|", length = 11, nullable = false)
	private String babyName;

    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别|1|", length = 1, nullable = true)
    private String gender;

	@Column(name = "BABY_CARD_NO", columnDefinition = "VARCHAR2|宝宝卡号|50|", length = 50, nullable = true)
	private String babyCardNo;

	@Column(name = "HEALTH_NO", columnDefinition = "VARCHAR2|保健号|50|", length = 50, nullable = true)
	private String healthNo;

	@Column(name = "BIRTHDAY", columnDefinition = "TIMESTAMP|出生日期||", nullable = true)
	private Date birthday;

	@Column(name = "YEARS", columnDefinition = "VARCHAR2|年龄（岁）|10|", length = 10, nullable = true)
	private String years;

	@Column(name = "MONTHS", columnDefinition = "VARCHAR2|年龄（月）|10|", length = 10, nullable = true)
	private String months;

	@Column(name = "PHONE", columnDefinition = "VARCHAR2|电话|50|", length = 50, nullable = true)
	private String phone;

	@Column(name = "FATHER_NAME", columnDefinition = "VARCHAR2|父亲姓名|50|", length = 50, nullable = true)
	private String fatherName;

	@Column(name = "MOTHER_NAME", columnDefinition = "VARCHAR2|母亲姓名|50|", length = 50, nullable = true)
	private String motherName;

	@Column(name = "ADDRESS", columnDefinition = "VARCHAR2|居住地|150|", length = 150, nullable = true)
	private String address;

	@Column(name = "MOVING", columnDefinition = "VARCHAR2|是否迁出|1|", length = 1, nullable = true)
	private String moving;

	@Column(name = "APPOINTMENT_DATE", columnDefinition = "DATE|预约检查日期||", nullable = true)
	private Date appointmentDate;

	@Column(name = "ORGAN_NAME", columnDefinition = "NUMBER|预约检查机构|50|", length = 50, nullable = true)
	private String organName;

	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|预约检查机构code|50|", length = 50, nullable = true)
	private String organCode;
	
	@Column(name = "FATHER_IDCARD", columnDefinition = "VARCHAR2|父亲身份证|18|", length = 18, nullable = true)
	private String fatherIdcard;
	
	@Column(name = "MOTHER_IDCARD", columnDefinition = "VARCHAR2|母亲身份证|18|", length = 18, nullable = true)
	private String motherIdcard;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement
	public String getBabyName() {
		return babyName;
	}

	public void setBabyName(String babyName) {
		this.babyName = babyName;
	}

	@XmlElement
	public String getBabyCardNo() {
		return babyCardNo;
	}

	public void setBabyCardNo(String babyCardNo) {
		this.babyCardNo = babyCardNo;
	}

	@XmlElement
	public String getHealthNo() {
		return healthNo;
	}

	public void setHealthNo(String healthNo) {
		this.healthNo = healthNo;
	}

	@XmlElement
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@XmlElement
	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	@XmlElement
	public String getMonths() {
		return months;
	}

	public void setMonths(String months) {
		this.months = months;
	}

	@XmlElement
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@XmlElement
	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	@XmlElement
	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	@XmlElement
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@XmlElement
	public String getMoving() {
		return moving;
	}

	public void setMoving(String moving) {
		this.moving = moving;
	}

	@XmlElement
	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	@XmlElement
	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	@XmlElement
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@XmlElement
	public String getOrganName() {
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	@XmlElement
	public String getFatherIdcard() {
		return fatherIdcard;
	}

	public void setFatherIdcard(String fatherIdcard) {
		this.fatherIdcard = fatherIdcard;
	}

	@XmlElement
	public String getMotherIdcard() {
		return motherIdcard;
	}

	public void setMotherIdcard(String motherIdcard) {
		this.motherIdcard = motherIdcard;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	
	
}
