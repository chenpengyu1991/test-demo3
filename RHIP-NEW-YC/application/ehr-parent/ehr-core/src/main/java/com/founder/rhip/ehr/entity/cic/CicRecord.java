package com.founder.rhip.ehr.entity.cic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "CIC_RECORD")
public class CicRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号(自增长)|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "PERSON_ID", columnDefinition = "VARCHAR2|人员唯一编码|38|", length = 38, nullable = true)
	private String personId;

	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证号|18|", length = 18, nullable = true)
	private String idcard;

	@Column(name = "CITIZEN_CARD_NO", columnDefinition = "VARCHAR2|虞城通号|20|", length = 20, nullable = true)
	private String citizenCardNo;

	@Column(name = "ASTHMA_FLAG", columnDefinition = "VARCHAR2|哮喘标志|1|", length = 1, nullable = true)
	private String asthmaFlag;

	@Column(name = "HEART_DISEASE_FLAG", columnDefinition = "VARCHAR2|心脏病标志|1|", length = 1, nullable = true)
	private String heartDiseaseFlag;

	@Column(name = "CARDIOVASCULAR_FLAG", columnDefinition = "VARCHAR2|心脑血管病标志|1|", length = 1, nullable = true)
	private String cardiovascularFlag;

	@Column(name = "EPILEPSY_FLAG", columnDefinition = "VARCHAR2|癫痫病标志|1|", length = 1, nullable = true)
	private String epilepsyFlag;

	@Column(name = "MENTAL_FLAG", columnDefinition = "VARCHAR2|精神病标志|1|", length = 1, nullable = true)
	private String mentalFlag;

	@Column(name = "COAGULOPATHY_FLAG", columnDefinition = "VARCHAR2|凝血紊乱标志|1|", length = 1, nullable = true)
	private String coagulopathyFlag;

	@Column(name = "DIABETES_FLAG", columnDefinition = "VARCHAR2|糖尿病标志|1|", length = 1, nullable = true)
	private String diabetesFlag;

	@Column(name = "GLAUCOMA_FLAG", columnDefinition = "VARCHAR2|青光眼标志|1|", length = 1, nullable = true)
	private String glaucomaFlag;

	@Column(name = "HEART_PACEMAKER_FLAG", columnDefinition = "VARCHAR2|心脏起搏器标志|1|", length = 1, nullable = true)
	private String heartPacemakerFlag;

	@Column(name = "IRRITABILITY", columnDefinition = "VARCHAR2|过敏物质名称及反应(规则 名称:反应;名称:反应;)|4000|", length = 4000, nullable = true)
	private String irritability;

	@Column(name = "ABO_CODE", columnDefinition = "VARCHAR2|ABO血型代码|1|", length = 1, nullable = true)
	private String aboCode;

	@Column(name = "RH_CODE", columnDefinition = "VARCHAR2|RH血型代码|1|", length = 1, nullable = true)
	private String rhCode;

	@Column(name = "IMUNIZATION", columnDefinition = "VARCHAR2|免疫接种名称及时间(时间:YYYYMMDD)(规则 名称:时间;名称:时间;)|4000|", length = 4000, nullable = true)
	private String immunization;

	@Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|调用机构CODE|50|", length = 50, nullable = true)
	private String createOrganCode;

	@Column(name = "CREATE_ORGAN_NAME", columnDefinition = "VARCHAR2|调用机构|100|", length = 100, nullable = true)
	private String createOrganName;

	@Column(name = "CREATE_USER_ID", columnDefinition = "VARCHAR2|调用人ID|50|", length = 50, nullable = true)
	private String createUserId;

	@Column(name = "CREATE_USER_NAME", columnDefinition = "VARCHAR2|调用人|50|", length = 50, nullable = true)
	private String createUserName;

	@Column(name = "CREATE_DATE", columnDefinition = "DATE|调用时间||", nullable = true)
	private Date createDate;

	@Column(name = "WRITE_STATUS", columnDefinition = "VARCHAR2|市民卡写入状态(0失败，1成功)|1|", length = 1, nullable = true)
	private String writeStatus;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getCitizenCardNo() {
		return this.citizenCardNo;
	}

	public void setCitizenCardNo(String citizenCardNo) {
		this.citizenCardNo = citizenCardNo;
	}

	public String getAsthmaFlag() {
		return this.asthmaFlag;
	}

	public void setAsthmaFlag(String asthmaFlag) {
		this.asthmaFlag = asthmaFlag;
	}

	public String getHeartDiseaseFlag() {
		return this.heartDiseaseFlag;
	}

	public void setHeartDiseaseFlag(String heartDiseaseFlag) {
		this.heartDiseaseFlag = heartDiseaseFlag;
	}

	public String getCardiovascularFlag() {
		return this.cardiovascularFlag;
	}

	public void setCardiovascularFlag(String cardiovascularFlag) {
		this.cardiovascularFlag = cardiovascularFlag;
	}

	public String getEpilepsyFlag() {
		return this.epilepsyFlag;
	}

	public void setEpilepsyFlag(String epilepsyFlag) {
		this.epilepsyFlag = epilepsyFlag;
	}

	public String getMentalFlag() {
		return this.mentalFlag;
	}

	public void setMentalFlag(String mentalFlag) {
		this.mentalFlag = mentalFlag;
	}

	public String getCoagulopathyFlag() {
		return this.coagulopathyFlag;
	}

	public void setCoagulopathyFlag(String coagulopathyFlag) {
		this.coagulopathyFlag = coagulopathyFlag;
	}

	public String getDiabetesFlag() {
		return this.diabetesFlag;
	}

	public void setDiabetesFlag(String diabetesFlag) {
		this.diabetesFlag = diabetesFlag;
	}

	public String getGlaucomaFlag() {
		return this.glaucomaFlag;
	}

	public void setGlaucomaFlag(String glaucomaFlag) {
		this.glaucomaFlag = glaucomaFlag;
	}

	public String getHeartPacemakerFlag() {
		return this.heartPacemakerFlag;
	}

	public void setHeartPacemakerFlag(String heartPacemakerFlag) {
		this.heartPacemakerFlag = heartPacemakerFlag;
	}

	public String getIrritability() {
		return this.irritability;
	}

	public void setIrritability(String irritability) {
		this.irritability = irritability;
	}

	public String getAboCode() {
		return this.aboCode;
	}

	public void setAboCode(String aboCode) {
		this.aboCode = aboCode;
	}

	public String getRhCode() {
		return this.rhCode;
	}

	public void setRhCode(String rhCode) {
		this.rhCode = rhCode;
	}

	public String getImmunization() {
		return this.immunization;
	}

	public void setImmunization(String immunization) {
		this.immunization = immunization;
	}

	public String getCreateOrganCode() {
		return this.createOrganCode;
	}

	public void setCreateOrganCode(String createOrganCode) {
		this.createOrganCode = createOrganCode;
	}

	public String getCreateOrganName() {
		return this.createOrganName;
	}

	public void setCreateOrganName(String createOrganName) {
		this.createOrganName = createOrganName;
	}

	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserName() {
		return this.createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getWriteStatus() {
		return this.writeStatus;
	}

	public void setWriteStatus(String writeStatus) {
		this.writeStatus = writeStatus;
	}

}