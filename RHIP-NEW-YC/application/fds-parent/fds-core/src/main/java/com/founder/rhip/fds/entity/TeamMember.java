package com.founder.rhip.fds.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="TEAM_MEMBER")
public class TeamMember implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID",columnDefinition="NUMBER|业务主键|11|",length=11,nullable=false)
	private Integer id;

	@Column(name="TEAM_CODE",columnDefinition="VARCHAR2|团队编号|30|",length=30,nullable=true)
	private String teamCode;

	@Column(name="ORGAN_CODE",columnDefinition="VARCHAR2|医生机构编号|30|",length=30,nullable=true)
	private String organCode;

	@Column(name="DOCTOR_ID",columnDefinition="NUMBER|医生ID|11|",length=11,nullable=true)
	private Integer doctorId;

	@Column(name="DOCTOR_NAME",columnDefinition="VARCHAR2|医生姓名|20|",length=20,nullable=true)
	private String doctorName;

	@Column(name="DOCTOR_GENDER",columnDefinition="CHAR|医生性别|1|",length=1,nullable=true)
	private String doctorGender;

	@Column(name="DOCTOR_ID_CARD",columnDefinition="VARCHAR2|医生身份证号|20|",length=20,nullable=true)
	private String doctorIdCard;

	@Column(name="DOCTOR_TECHNICAL",columnDefinition="VARCHAR2|医生职称等级|1|",length=1,nullable=true)
	private String doctorTechnical;

	@Column(name="DOCTOR_PRACTICE_SUBJECT",columnDefinition="VARCHAR2|医生执业科目|100|",length=100,nullable=true)
	private String doctorPracticeSubject;

	@Column(name="TEAM_LEADER_FLAG",columnDefinition="VARCHAR2|队长标识|1|",length=1,nullable=true)
	private String teamLeaderFlag;

	@Column(name="VALID",columnDefinition="CHAR|有效性（1：有效，0：无效）|1|",length=1,nullable=true)
	private String valid;

	@Column(name="CREATE_USER",columnDefinition="VARCHAR2|创建人|64|",length=64,nullable=true)
	private String createUser;

	@Column(name="CREATE_DATE",columnDefinition="DATE|创建日期||",nullable=true)
	private Date createDate;

	@Column(name="UPDATE_USER",columnDefinition="VARCHAR2|更新人|64|",length=64,nullable=true)
	private String updateUser;

	@Column(name="UPDATE_DATE",columnDefinition="DATE|更新日期||",nullable=true)
	private Date updateDate;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTeamCode() {
		return this.teamCode;
	}

	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}

	public String getOrganCode() {
		return this.organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public Integer getDoctorId() {
		return this.doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return this.doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorGender() {
		return this.doctorGender;
	}

	public void setDoctorGender(String doctorGender) {
		this.doctorGender = doctorGender;
	}

	public String getDoctorIdCard() {
		return this.doctorIdCard;
	}

	public void setDoctorIdCard(String doctorIdCard) {
		this.doctorIdCard = doctorIdCard;
	}

	public String getDoctorTechnical() {
		return this.doctorTechnical;
	}

	public void setDoctorTechnical(String doctorTechnical) {
		this.doctorTechnical = doctorTechnical;
	}

	public String getDoctorPracticeSubject() {
		return this.doctorPracticeSubject;
	}

	public void setDoctorPracticeSubject(String doctorPracticeSubject) {
		this.doctorPracticeSubject = doctorPracticeSubject;
	}

	public String getTeamLeaderFlag() {
		return this.teamLeaderFlag;
	}

	public void setTeamLeaderFlag(String teamLeaderFlag) {
		this.teamLeaderFlag = teamLeaderFlag;
	}

	public String getValid() {
		return this.valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}