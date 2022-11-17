package com.founder.rhip.ehr.entity.ce;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTINUE_EDUCATION")
public class ContinueEducation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|自增长ID|11|", length = 11, nullable = true)
	private Long id;

	@Column(name = "STAFF_CODE", columnDefinition = "VARCHAR2|人员主索引标识||", length = 50, nullable = false)
	private String staffCode;

	@Column(name = "RECORD_YEAR", columnDefinition = "VARCHAR2|登记年份|4|", length = 4, nullable = true)
	private String recordYear;

	@Column(name = "PROJECT_NO", columnDefinition = "VARCHAR2|项目代号|200|", length = 200, nullable = true)
	private String projectNo;

	@Column(name = "PROJECT_NAME", columnDefinition = "VARCHAR2|项目名称|200|", length = 200, nullable = true)
	private String projectName;

	@Column(name = "ORGANIZER", columnDefinition = "VARCHAR2|举办单位|200|", length = 200, nullable = true)
	private String organizer;

	@Column(name = "PERIOD", columnDefinition = "VARCHAR2|学时数|10|", length = 10, nullable = true)
	private String period;

	@Column(name = "CREDIT_A", columnDefinition = "CHAR|一类学分|10|", length = 10, nullable = true)
	private String creditA;

	@Column(name = "CREDIT_B", columnDefinition = "VARCHAR2|二类学分|10|", length = 10, nullable = true)
	private String creditB;

	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除标示(0正常，-1删除)||", nullable = true)
	private Integer isDelete;

	@Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|创建机构编码|50|", length = 50, nullable = true)
	private String createOrganCode;

	@Column(name = "CREATE_USER_CODE", columnDefinition = "VARCHAR2|创建操作人|50|", length = 50, nullable = true)
	private String createUserCode;

	@Column(name = "CREATE_DATE", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createDate;

	@Column(name = "UPDATE_ORGAN_CODE", columnDefinition = "VARCHAR2|更新机构编码|50|", length = 50, nullable = true)
	private String updateOrganCode;

	@Column(name = "UPDATE_USER_CODE", columnDefinition = "VARCHAR2|更新操作人|50|", length = 50, nullable = true)
	private String updateUserCode;

	@Column(name = "UPDATE_DATE", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date updateDate;
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public String getRecordYear() {
		return recordYear;
	}

	public void setRecordYear(String recordYear) {
		this.recordYear = recordYear;
	}

	public String getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getCreditA() {
		return creditA;
	}

	public void setCreditA(String creditA) {
		this.creditA = creditA;
	}

	public String getCreditB() {
		return creditB;
	}

	public void setCreditB(String creditB) {
		this.creditB = creditB;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getCreateOrganCode() {
		return createOrganCode;
	}

	public void setCreateOrganCode(String createOrganCode) {
		this.createOrganCode = createOrganCode;
	}

	public String getCreateUserCode() {
		return createUserCode;
	}

	public void setCreateUserCode(String createUserCode) {
		this.createUserCode = createUserCode;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateOrganCode() {
		return updateOrganCode;
	}

	public void setUpdateOrganCode(String updateOrganCode) {
		this.updateOrganCode = updateOrganCode;
	}

	public String getUpdateUserCode() {
		return updateUserCode;
	}

	public void setUpdateUserCode(String updateUserCode) {
		this.updateUserCode = updateUserCode;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
}