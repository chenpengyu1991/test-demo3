package com.founder.rhip.ehr.entity.pbusiness.student;

import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "CLASS_INFO")
public class ClassInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CLASS_ID", columnDefinition = "NUMBER|班级ID||", length = 11, nullable = true)
	private Long classId;

	@Column(name = "CLASS_CODE", columnDefinition = "VARCHAR2|班级编码||", length = 10, nullable = true)
	private String classCode;

	@Column(name = "CLASS_NAME", columnDefinition = "VARCHAR2|班级名称||", length = 10, nullable = true)
	private String className;

	@Column(name = "GRADE_CODE", columnDefinition = "VARCHAR2|年级编码||", length = 10, nullable = true)
	private String gradeCode;

	@Column(name = "GRADE_NAME", columnDefinition = "VARCHAR2|年级名称||", length = 50, nullable = true)
	private String gradeName;

	@Column(name = "SCHOOL_CODE", columnDefinition = "VARCHAR2|学校编码||", length = 20, nullable = true)
	private String schoolCode;

	@Column(name = "MNUMBER", columnDefinition = "NUMBER|男生数||", length = 2, nullable = true)
	private Integer mnumber;

	@Column(name = "FNUMBER", columnDefinition = "NUMBER|女生数||", length = 2, nullable = true)
	private Integer fnumber;

	@Column(name = "EMNUMBER", columnDefinition = "NUMBER|体检男生数||", length = 2, nullable = true)
	private Integer emnumber;

	@Column(name = "EFNUMBER", columnDefinition = "NUMBER|体检女生数||", length = 2, nullable = true)
	private Integer efnumber;

	@Column(name = "MANAGER", columnDefinition = "VARCHAR2|班主任姓名||", length = 50, nullable = true)
	private String manager;

	@Column(name = "PHONE", columnDefinition = "VARCHAR2|班主任手机||", length = 20, nullable = true)
	private String phone;

	@Column(name = "EMAIL", columnDefinition = "VARCHAR2|班主任邮箱||", length = 50, nullable = true)
	private String email;

	@Column(name = "OPERATOR", columnDefinition = "VARCHAR2|操作者||", length = 50, nullable = true)
	private String operator;

	@Column(name = "OPERATE_TYPE", columnDefinition = "VARCHAR2|操作类型||", length = 30, nullable = true)
	private String operateType;

	@Column(name = "OPERATE_TIME", columnDefinition = "NUMBER|操作时间||", length = 15, nullable = true)
	private Long operateTime;

	public Long getClassId() {
		return this.classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public String getClassCode() {
		return this.classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getGradeCode() {
		return this.gradeCode;
	}

	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}

	public String getGradeName() {
		return this.gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getSchoolCode() {
		return this.schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	public Integer getMnumber() {
		return this.mnumber;
	}

	public void setMnumber(Integer mnumber) {
		this.mnumber = mnumber;
	}

	public Integer getFnumber() {
		return this.fnumber;
	}

	public void setFnumber(Integer fnumber) {
		this.fnumber = fnumber;
	}

	public Integer getEmnumber() {
		return this.emnumber;
	}

	public void setEmnumber(Integer emnumber) {
		this.emnumber = emnumber;
	}

	public Integer getEfnumber() {
		return this.efnumber;
	}

	public void setEfnumber(Integer efnumber) {
		this.efnumber = efnumber;
	}

	public String getManager() {
		return this.manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperateType() {
		return this.operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	public Long getOperateTime() {
		return this.operateTime;
	}

	public void setOperateTime(Long operateTime) {
		this.operateTime = operateTime;
	}

	public boolean equals(Object classInfo) {
		if (classInfo == null) {
			return false;
		}
		ClassInfo info = (ClassInfo) classInfo;
		return this.gradeName.equals(info.getGradeName()) && this.className.equals(info.getClassName());
	}

	public int hashCode() {
		return new HashCodeBuilder().append(gradeName).append(className).toHashCode();
	}
}