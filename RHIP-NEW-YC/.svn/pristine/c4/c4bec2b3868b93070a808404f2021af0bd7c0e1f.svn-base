package com.founder.rhip.fds.entity;

import java.io.Serializable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="TEAM")
public class Team implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID",columnDefinition="NUMBER|业务主键|11|",length=11,nullable=false)
	private Integer id;

	@Column(name="ORGAN_CODE",columnDefinition="VARCHAR2|管理机构|20|",length=20,nullable=true)
	private String organCode;

	@Column(name="TEAM_CODE",columnDefinition="VARCHAR2|团队编号|30|",length=30,nullable=true)
	private String teamCode;

	@Column(name="TEAM_NAME",columnDefinition="VARCHAR2|团队名称|30|",length=30,nullable=true)
	private String teamName;

	@Column(name="WORK_START_TIME",columnDefinition="VARCHAR2|工作开始时间|50|",length=50,nullable=true)
	private String workStartTime;

	@Column(name="WORK_END_TIME",columnDefinition="VARCHAR2|工作结束时间|50|",length=50,nullable=true)
	private String workEndTime;

	@Column(name="TEL",columnDefinition="VARCHAR2|联系方式|20|",length=20,nullable=true)
	private String tel;

	@Column(name="RESPONSIBILITY",columnDefinition="VARCHAR2|岗位职责定义|200|",length=200,nullable=true)
	private String responsibility;

	@Column(name="TEAM_SIZE",columnDefinition="NUMBER|团队人数|5|",length=5,nullable=true)
	private Integer teamSize;

	@Column(name="SIGNED_FAMILY",columnDefinition="NUMBER|签约家庭数|5|",length=5,nullable=true)
	private Integer signedFamily;

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

	//团队所在机构名称
	@Transient
	private String organName;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrganCode() {
		return this.organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getTeamCode() {
		return this.teamCode;
	}

	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}

	public String getTeamName() {
		return this.teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getWorkStartTime() {
		return this.workStartTime;
	}

	public void setWorkStartTime(String workStartTime) {
		this.workStartTime = workStartTime;
	}

	public String getWorkEndTime() {
		return this.workEndTime;
	}

	public void setWorkEndTime(String workEndTime) {
		this.workEndTime = workEndTime;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getResponsibility() {
		return this.responsibility;
	}

	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}

	public Integer getTeamSize() {
		return this.teamSize;
	}

	public void setTeamSize(Integer teamSize) {
		this.teamSize = teamSize;
	}

	public Integer getSignedFamily() {
		return this.signedFamily;
	}

	public void setSignedFamily(Integer signedFamily) {
		this.signedFamily = signedFamily;
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

	public String getOrganName() {
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}
}