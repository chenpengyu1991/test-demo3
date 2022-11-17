
package com.founder.rhip.ehr.entity.women;

import com.founder.rhip.ehr.common.JaxbDateSerializer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "RESERVE_MATERNAL")
@XmlRootElement
public class ReserveMaternal implements Serializable {

	private static final long serialVersionUID = -8941532920260997923L;
	
	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
	private Long id;
	
	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
	private Long personId;
	
	@Column(name = "NAME", columnDefinition = "VARCHAR2|姓名|50|", length = 50, nullable = false)
	private String name;

	@Column(name = "ID_CARD", columnDefinition = "VARCHAR2|身份证号|18|", length = 18, nullable = true)
	private String idCard;

	@Column(name = "HEALTH_NO", columnDefinition = "VARCHAR2|保健号|50|", length = 50, nullable = true)
	private String healthNo;

	@Column(name = "DUE_DATE", columnDefinition = "DATE|预产期||", nullable = true)
	private Date dueDate;

	@Column(name = "PHONE", columnDefinition = "VARCHAR2|电话|20|", length = 20, nullable = true)
	private String phone;

	@Column(name = "HUS_NAME", columnDefinition = "VARCHAR2|丈夫姓名|50|", length = 50, nullable = true)
	private String husName;

	@Column(name = "ADDRESS", columnDefinition = "VARCHAR2|居住地|150|", length = 150, nullable = true)
	private String address;

	@Column(name = "HIGH_RISK_MATERNAL", columnDefinition = "VARCHAR2|是否为高危产妇|1|", length = 1, nullable = true)
	private String highRiskMaternal;

	@Column(name = "APPOINTMENT_DATE", columnDefinition = "DATE|预约检查日期||", nullable = true)
	private Date  appointmentDate;

	@Column(name = "MESSAGE_SENT", columnDefinition = "NUMBER|短信发送次数|11|", length = 11, nullable = true)
	private Integer messageSent;

	@Column(name = "ORGAN_NAME", columnDefinition = "VARCHAR2|预约机构|50|", length = 50, nullable = true)
	private String organName;

	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|预约机构code|50|", length = 50, nullable = true)
	private String organCode;
	
	@Column(name = "MEDICAL_CARD_NO", columnDefinition = "VARCHAR2|医保编码|50|", length = 50, nullable = true)
	private String medicalCardNo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement
	public String getHealthNo() {
		return healthNo;
	}

	public void setHealthNo(String healthNo) {
		this.healthNo = healthNo;
	}

	@XmlElement
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	@XmlElement
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	@XmlElement
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@XmlElement
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@XmlElement
	public String getHusName() {
		return this.husName;
	}

	public void setHusName(String husName) {
		this.husName = husName;
	}

	@XmlElement
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@XmlElement
	public String getHighRiskMaternal() {
		return this.highRiskMaternal;
	}

	public void setHighRiskMaternal(String highRiskMaternal) {
		this.highRiskMaternal = highRiskMaternal;
	}

	@XmlElement
	public Integer getMessageSent() {
		return this.messageSent;
	}

	public void setMessageSent(Integer messageSent) {
		this.messageSent = messageSent;
	}

	@XmlElement
	public String getOrganName() {
		return this.organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	@XmlElement
	public String getOrganCode() {
		return this.organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	@XmlElement
	public String getMedicalCardNo() {
		return medicalCardNo;
	}

	public void setMedicalCardNo(String medicalCardNo) {
		this.medicalCardNo = medicalCardNo;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	
}
