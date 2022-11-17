package com.founder.rhip.ehr.entity.management;

import com.founder.rhip.ehr.service.export.Item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "DC_INOCULATION_APPOINTMENT")
public class InoculationAppointment implements Serializable{

	private static final long serialVersionUID = 6357650276614927375L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|业务主键|11|", length = 11, nullable = false)
	private Long id;
	
	@Column(name = "PERSON_ID" ,columnDefinition = "NUMBER|服务对象ID|11|", length = 11, nullable = false)
    private Long personId;
	@Item(index =1, code = "PERSON_NAME", column = "姓名")
    @Column(name = "PERSON_NAME",columnDefinition = "VARCHAR2|签约对象名称||", length = 100, nullable = true)
    private String personName;
	@Item(index =2, code = "PERSON_IDCARD", column = "身份证")
    @Column(name = "PERSON_IDCARD",columnDefinition = "VARCHAR2|签约对象身份证||", length = 18, nullable = true)
    private String personIdcard;
	@Item(index =3, code = "PHONE_NUMBER", column = "电话号码")
    @Column(name = "PHONE_NUMBER",columnDefinition = "VARCHAR2|电话号码||", length = 20, nullable = true)
    private String phoneNumber;
    
    @Column(name = "PERSON_GENDER",columnDefinition = "VARCHAR2|签约对象性别||", length = 2, nullable = true)
    private String personGender;
   // @Item(index =4, code = "PA_ADDRESS", column = "住址")
    @Column(name = "PERSON_ADDRESS",columnDefinition = "VARCHAR2|签约居民地址||", length = 100, nullable = true)
    private String personAddress;

    @Column(name = "INOCULATION_TIME",columnDefinition = "DATE|预约时间||", nullable = true)
    private Date inoculationTime;

    @Column(name = "DESCRIPTION",columnDefinition = "VARCHAR2|描述||", length = 2000, nullable = true)
    private String description;

    @Column(name = "ORGAN_CODE",columnDefinition = "VARCHAR2|机构编码||", length = 20, nullable = true)
    private String organCode;

    @Column(name = "TEAM_CODE",columnDefinition = "VARCHAR2|团队编码||", length = 50, nullable = true)
    private String teamCode;

    @Column(name = "DOCTOR_ID",columnDefinition = "NUMBER|服务医生ID|11|", length = 11, nullable = true)
    private Long doctorId;

    @Column(name = "DOCTOR_NAME",columnDefinition = "VARCHAR2|签约医生姓名||", length = 100, nullable = true)
    private String doctorName;

    @Column(name = "DOCTOR_IDCARD",columnDefinition = "VARCHAR2|服务医生身份证号码||", length = 18, nullable = true)
    private String doctorIdcard;

    @Column(name = "DOCTOR_OPINION",columnDefinition = "VARCHAR2|医生意见||", length = 200, nullable = true)
    private String doctorOpinion;

    @Column(name = "STATUS",columnDefinition = "CHAR|状态（1：预约中；2：预约成功；3：预约失败；4：取消预约；5：删除预约）||", length = 1, nullable = false)
    private String status;

    @Column(name = "CREATE_USER",columnDefinition = "VARCHAR2|创建人||", length = 64, nullable = true)
    private String createUser;
    @Item(index =5, code = "CREATE_DATE", column = "预约时间")
    @Column(name = "CREATE_DATE",columnDefinition = "DATE|创建日期||", nullable = true)
    private Date createDate;

    @Column(name = "UPDATE_USER",columnDefinition = "VARCHAR2|更新人||", length = 64, nullable = true)
    private String updateUser;

    @Column(name = "UPDATE_DATE",columnDefinition = "DATE|更新日期|", nullable = true)
    private Date updateDate;

    @Column(name = "VACCINE_TYPE",columnDefinition = "CHAR|疫苗类型||", nullable = true)
    private String vaccineType;
    
    @Column(name = "INOCULATE_MARK",columnDefinition = "CHAR|接种标记 0：未接种 1：已接种 -1:放弃接种||", nullable = true)
    private String inoculateMark;
    
    private String diseaseHistory;
    
    private String pneumoniaVaccFlag;
    
    @Item(index =6, code = "ORGAN_NAME", column = "预约机构")
    private String organName;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonIdcard() {
		return personIdcard;
	}

	public void setPersonIdcard(String personIdcard) {
		this.personIdcard = personIdcard;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPersonGender() {
		return personGender;
	}

	public void setPersonGender(String personGender) {
		this.personGender = personGender;
	}

	public String getPersonAddress() {
		return personAddress;
	}

	public void setPersonAddress(String personAddress) {
		this.personAddress = personAddress;
	}

	public Date getInoculationTime() {
		return inoculationTime;
	}

	public void setInoculationTime(Date inoculationTime) {
		this.inoculationTime = inoculationTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getTeamCode() {
		return teamCode;
	}

	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorIdcard() {
		return doctorIdcard;
	}

	public void setDoctorIdcard(String doctorIdcard) {
		this.doctorIdcard = doctorIdcard;
	}

	public String getDoctorOpinion() {
		return doctorOpinion;
	}

	public void setDoctorOpinion(String doctorOpinion) {
		this.doctorOpinion = doctorOpinion;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getDiseaseHistory() {
		return diseaseHistory;
	}

	public void setDiseaseHistory(String diseaseHistory) {
		this.diseaseHistory = diseaseHistory;
	}

	public String getOrganName() {
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public String getVaccineType() {
		return vaccineType;
	}

	public void setVaccineType(String vaccineType) {
		this.vaccineType = vaccineType;
	}

	public String getInoculateMark() {
		return inoculateMark;
	}

	public void setInoculateMark(String inoculateMark) {
		this.inoculateMark = inoculateMark;
	}

	public String getPneumoniaVaccFlag() {
		return pneumoniaVaccFlag;
	}

	public void setPneumoniaVaccFlag(String pneumoniaVaccFlag) {
		this.pneumoniaVaccFlag = pneumoniaVaccFlag;
	}
}
