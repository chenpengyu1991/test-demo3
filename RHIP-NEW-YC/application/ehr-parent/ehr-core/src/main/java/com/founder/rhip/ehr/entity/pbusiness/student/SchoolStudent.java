package com.founder.rhip.ehr.entity.pbusiness.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "BI_SCHOOL_STUDENT")
public class SchoolStudent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|班级ID||", length = 11, nullable = true)
	private Long id;
	
	@Column(name = "YEAR", columnDefinition = "VARCHAR2|年份||", length = 20, nullable = true)
	private String year;

	@Column(name = "SCHOOL_CODE", columnDefinition = "VARCHAR2|学校编码||", length = 20, nullable = true)
	private String schoolCode;
	
	@Column(name = "SCHOOL_NAME", columnDefinition = "VARCHAR2|学校名称||", length = 20, nullable = true)
	private String schoolName;

	@Column(name = "FS_MNUMBER", columnDefinition = "NUMBER|男生数||", length = 2, nullable = true)
	private Integer fsMnumber;

	@Column(name = "FS_FNUMBER", columnDefinition = "NUMBER|女生数||", length = 2, nullable = true)
	private Integer fsFnumber;

	@Column(name = "FS_TNUMBER", columnDefinition = "NUMBER|总数||", length = 2, nullable = true)
	private Integer fsTnumber;

	@Column(name = "OPERATOR", columnDefinition = "VARCHAR2|操作者||", length = 50, nullable = true)
	private String operator;

	@Column(name = "OPERATE_ORGAN", columnDefinition = "VARCHAR2|操作机构||", length = 30, nullable = true)
	private String operateOrgan;

	@Column(name = "OPERATE_TIME", columnDefinition = "NUMBER|操作时间||", length = 15, nullable = true)
	private Date operateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSchoolCode() {
		return schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public Integer getFsMnumber() {
		return fsMnumber;
	}

	public void setFsMnumber(Integer fsMnumber) {
		this.fsMnumber = fsMnumber;
	}

	public Integer getFsFnumber() {
		return fsFnumber;
	}

	public void setFsFnumber(Integer fsFnumber) {
		this.fsFnumber = fsFnumber;
	}

	public Integer getFsTnumber() {
		return fsTnumber;
	}

	public void setFsTnumber(Integer fsTnumber) {
		this.fsTnumber = fsTnumber;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperateOrgan() {
		return operateOrgan;
	}

	public void setOperateOrgan(String operateOrgan) {
		this.operateOrgan = operateOrgan;
	}

	public Date getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

}