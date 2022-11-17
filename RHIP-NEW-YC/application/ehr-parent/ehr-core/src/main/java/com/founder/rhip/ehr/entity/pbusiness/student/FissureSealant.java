package com.founder.rhip.ehr.entity.pbusiness.student;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FISSURE_SEALANT")
public class FissureSealant implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "FISSURE_SEALANT_ID", columnDefinition = "NUMBER|窝沟封闭ID||", length = 11, nullable = true)
	private Long fissureSealantId;

	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证件号码||", length = 18, nullable = true)
	private String idcard;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 50, nullable = true)
	private String name;

	@Column(name = "NATIVE_STUDENT", columnDefinition = "VARCHAR2|是否本地学生||", length = 10, nullable = true)
	private String nativeStudent;
	
	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别||", length = 1, nullable = true)
	private String gender;

	@Column(name = "TEETH_NUMBER", columnDefinition = "NUMBER|检查牙数||", length = 2, nullable = true)
	private Integer teethNumber;

	@Column(name = "HAS_DENTAL_CARIES", columnDefinition = "NUMBER|是否患龋||", length = 10, nullable = true)
	private String hasDentalCaries;
	
	@Column(name = "DENTAL_CARIES", columnDefinition = "NUMBER|龋齿数||", length = 2, nullable = true)
	private Integer dentalCaries;

	@Column(name = "NEED_NUMBER", columnDefinition = "NUMBER|可窝沟封闭牙数||", length = 2, nullable = true)
	private Integer needNumber;

	@Column(name = "REAL_NUMBER", columnDefinition = "NUMBER|实际窝沟封闭牙数||", length = 2, nullable = true)
	private Integer realNumber;
	
	@Column(name = "CLOSE_DATE", columnDefinition = "DATE|封闭时间||", nullable = true)
	private Date closeDate;

	@Column(name = "DOCTOR", columnDefinition = "VARCHAR2|医生||", length = 20, nullable = true)
	private String doctor;

	@Column(name = "POSITION", columnDefinition = "VARCHAR2|牙位||", length = 50, nullable = true)
	private String position;

	@Column(name = "SCHOOL_CODE", columnDefinition = "VARCHAR2|学校编码||", length = 20, nullable = true)
	private String schoolCode;

	@Column(name = "SCHOOL_NAME", columnDefinition = "VARCHAR2|学校名称||", length = 50, nullable = true)
	private String schoolName;
	
	@Column(name = "GRADE_CODE", columnDefinition = "VARCHAR2|年级编码||", length = 10, nullable = true)
	private String gradeCode;

	@Column(name = "GRADE_NAME", columnDefinition = "VARCHAR2|年级名称||", length = 50, nullable = true)
	private String gradeName;
	
	@Column(name = "CLASS_CODE", columnDefinition = "VARCHAR2|班级编码||", length = 10, nullable = true)
	private String classCode;

	@Column(name = "CLASS_NAME", columnDefinition = "VARCHAR2|班级名称||", length = 50, nullable = true)
	private String className;

	@Column(name = "EXAM_YEAR", columnDefinition = "VARCHAR2|体检年份||", length = 4, nullable = true)
	private String examYear;
	
	@Column(name = "PERSON_INFO_ID", columnDefinition = "VARCHAR2|平台唯一编码||", length = 11, nullable = true)
	private String personInfoId;

	@Column(name = "OPERATOR", columnDefinition = "VARCHAR2|操作者||", length = 50, nullable = true)
	private String operator;

	@Column(name = "OPERATE_TYPE", columnDefinition = "VARCHAR2|操作类型||", length = 30, nullable = true)
	private String operateType;

	@Column(name = "OPERATE_TIME", columnDefinition = "NUMBER|操作时间||", length = 15, nullable = true)
	private Long operateTime;

	public Long getFissureSealantId() {
		return this.fissureSealantId;
	}

	public void setFissureSealantId(Long fissureSealantId) {
		this.fissureSealantId = fissureSealantId;
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

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getTeethNumber() {
		return this.teethNumber;
	}

	public void setTeethNumber(Integer teethNumber) {
		this.teethNumber = teethNumber;
	}

	public Integer getDentalCaries() {
		return this.dentalCaries;
	}

	public void setDentalCaries(Integer dentalCaries) {
		this.dentalCaries = dentalCaries;
	}

	public Integer getNeedNumber() {
		return this.needNumber;
	}

	public void setNeedNumber(Integer needNumber) {
		this.needNumber = needNumber;
	}

	public Integer getRealNumber() {
		return this.realNumber;
	}

	public void setRealNumber(Integer realNumber) {
		this.realNumber = realNumber;
	}

	public String getDoctor() {
		return this.doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSchoolCode() {
		return this.schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	public String getSchoolName() {
		return this.schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getExamYear() {
		return this.examYear;
	}

	public void setExamYear(String examYear) {
		this.examYear = examYear;
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

	public String getClassCode() {
		return classCode;
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
		return gradeCode;
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

	public String getPersonInfoId() {
		return personInfoId;
	}

	public void setPersonInfoId(String personInfoId) {
		this.personInfoId = personInfoId;
	}

	public String getNativeStudent() {
		return nativeStudent;
	}

	public void setNativeStudent(String nativeStudent) {
		this.nativeStudent = nativeStudent;
	}

	public String getHasDentalCaries() {
		return hasDentalCaries;
	}

	public void setHasDentalCaries(String hasDentalCaries) {
		this.hasDentalCaries = hasDentalCaries;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

}