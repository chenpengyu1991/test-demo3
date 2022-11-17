package com.founder.rhip.ehr.entity.pbusiness.student;

import com.founder.rhip.mdm.common.JsonDateSerializer;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "MDM_STUDENT_INFO")
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class StudentInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "STUDENT_ID", columnDefinition = "NUMBER|学生ID||", length = 11, nullable = true)
	private Long studentId;

	@Column(name = "PERSON_INFO_ID", columnDefinition = "NUMBER|健康档案ID||", length = 11, nullable = true)
	private String personInfoId;

	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证件号码||", length = 18, nullable = true)
	private String idcard;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 50, nullable = true)
	private String name;

	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别||", length = 1, nullable = true)
	private String gender;

	@Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
	private Date birthday;

	@Column(name = "NATION", columnDefinition = "VARCHAR2|民族||", length = 2, nullable = true)
	private String nation;

	@Column(name = "ABO_BLOOD_TYPE", columnDefinition = "VARCHAR2|ABO血型代码||", length = 1, nullable = true)
	private String aboBloodType;

	@Column(name = "STUDENT_NO", columnDefinition = "VARCHAR2|学籍卡号||", length = 18, nullable = true)
	private String studentNo;

	@Column(name = "IN_YEAR", columnDefinition = "VARCHAR2|入学年份||", length = 8, nullable = true)
	private String inYear;

	@Column(name = "ADDRESS", columnDefinition = "VARCHAR2|家庭地址||", length = 500, nullable = true)
	private String address;

	@Column(name = "GUARDIAN", columnDefinition = "VARCHAR2|家长姓名||", length = 50, nullable = true)
	private String guardian;

	@Column(name = "PHONE", columnDefinition = "VARCHAR2|联系电话||", length = 20, nullable = true)
	private String phone;

	@Column(name = "POST_CODE", columnDefinition = "VARCHAR2|邮编||", length = 6, nullable = true)
	private String postCode;

	@Column(name = "IDCARD_VAS", columnDefinition = "VARCHAR2|接种证号码||", length = 20, nullable = true)
	private String idcardVas;

	@Column(name = "CLASS_CODE", columnDefinition = "VARCHAR2|班级编码||", length = 10, nullable = true)
	private String classCode;

	@Column(name = "CLASS_NAME", columnDefinition = "VARCHAR2|班级名称||", length = 10, nullable = true)
	private String className;

	@Column(name = "GRADE_CODE", columnDefinition = "VARCHAR2|年级编码||", length = 10, nullable = true)
	private String gradeCode;

	@Column(name = "GRADE_NAME", columnDefinition = "VARCHAR2|年级名称||", length = 10, nullable = true)
	private String gradeName;

	@Column(name = "SCHOOL_CODE", columnDefinition = "VARCHAR2|学校编码||", length = 20, nullable = true)
	private String schoolCode;
	
	@Column(name = "SCHOOL_NAME", columnDefinition = "VARCHAR2|学校名称||", length = 50, nullable = true)
	private String schoolName;

	@Column(name = "OPERATOR", columnDefinition = "VARCHAR2|操作者||", length = 50, nullable = true)
	private String operator;

	@Column(name = "OPERATE_TYPE", columnDefinition = "VARCHAR2|操作机构||", length = 30, nullable = true)
	private String operateType;

	@Column(name = "OPERATE_TIME", columnDefinition = "NUMBER|操作时间||", length = 15, nullable = true)
	private Long operateTime;

	public Long getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getPersonInfoId() {
		return personInfoId;
	}

	public void setPersonInfoId(String personInfoId) {
		this.personInfoId = personInfoId;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
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

	public String getGenderName() {
		if ("1".equals(gender)) {
			return "男";
		} else if ("2".equals(gender)) {
			return "女";
		}
		return null;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getAboBloodType() {
		return this.aboBloodType;
	}

	public void setAboBloodType(String aboBloodType) {
		this.aboBloodType = aboBloodType;
	}

	public String getStudentNo() {
		return this.studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getInYear() {
		return this.inYear;
	}

	public void setInYear(String inYear) {
		this.inYear = inYear;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGuardian() {
		return this.guardian;
	}

	public void setGuardian(String guardian) {
		this.guardian = guardian;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostCode() {
		return this.postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getIdcardVas() {
		return this.idcardVas;
	}

	public void setIdcardVas(String idcardVas) {
		this.idcardVas = idcardVas;
	}

	public String getClassCode() {
		return this.classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getClassName() {
		return className;
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
		return gradeName;
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

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

}