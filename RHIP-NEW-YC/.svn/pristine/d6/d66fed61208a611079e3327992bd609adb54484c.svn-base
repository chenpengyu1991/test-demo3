package com.founder.rhip.ehr.entity.clinic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import java.util.Date;
import java.math.BigDecimal;

@Entity
@Table(name = "MS_HEALTH_EXAMINATION")
public class HealthExamination implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
	private Long personId;

	@Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = false)
	private String ehrId;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
	private Long id;
	
	@Column(name = "PHYSICAL_EXAM_CODE", columnDefinition = "VARCHAR2|健康体检表编号||", length = 18, nullable = true)
	private String physicalExamCode;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 50, nullable = true)
	private String name;

	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别||", length = 1, nullable = true)
	private String gender;

	@Column(name = "AGE", columnDefinition = "VARCHAR2|年龄||", length = 3, nullable = true)
	private String age;

	@Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
	private Date birthday;

	@Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况||", length = 3, nullable = true)
	private String marriage;

	@Column(name = "PHYSICAL_EXAM_COST", columnDefinition = "NUMBER|体检费用||", scale = 8, precision = 2, nullable = true)
	private BigDecimal physicalExamCost;

	@Column(name = "HEALTH_EVALUATE_RESULT", columnDefinition = "VARCHAR2|健康评价结果代码||", length = 1, nullable = true)
	private String healthEvaluateResult;

	@Column(name = "HEALTH_EVALUATE_ANOMALY_FLAG", columnDefinition = "CHAR|健康评价异常标志||", length = 1, nullable = true)
	private String healthEvaluationAnormalFlag;

	@Column(name = "HEALTH_EVALUATE_ANOMALY_DESC", columnDefinition = "VARCHAR2|健康评价异常描述||", length = 100, nullable = true)
	private String healthEvaluateAnomalyDesc;

	@Column(name = "EXAMINATION_RESULT", columnDefinition = "VARCHAR2|体检结果||", length = 400, nullable = true)
	private String examinationResult;

	@Column(name = "HEALTH_GUIDANCE", columnDefinition = "VARCHAR2|健康指导代码||", length = 10, nullable = true)
	private String healthGuidance;

	@Column(name = "SUGGESTION", columnDefinition = "VARCHAR2|其他医生建议||", length = 100, nullable = true)
	private String suggestion;

	@Column(name = "HOSPITAL_CODE", columnDefinition = "VARCHAR2|医疗机构代码||", length = 10, nullable = true)
	private String hospitalCode;

	@Column(name = "HOSPITAL_NAME", columnDefinition = "VARCHAR2|医疗机构名称||", length = 70, nullable = true)
	private String hospitalName;

	@Column(name = "MANA_DOCTOR_NO", columnDefinition = "VARCHAR2|责任医师工号||", length = 18, nullable = true)
	private String manaDoctorNo;
	
	@Column(name = "MANA_DOCTOR_ID", columnDefinition = "VARCHAR2|责任医师ID||", length = 50, nullable = true)
	private String manaDoctorId;

	@Column(name = "MANA_DOCTOR_NAME", columnDefinition = "VARCHAR2|责任医师姓名||", length = 50, nullable = true)
	private String manaDoctorName;

	@Column(name = "MANA_DOCTOR_IDCARD", columnDefinition = "VARCHAR2|责任医师身份证号||", length = 18, nullable = true)
	private String manaDoctorIdCard;

	@Column(name = "EXAMINATION_DATE", columnDefinition = "DATE|体检日期||", nullable = true)
	private Date examinationDate;
	
	@Column(name = "PHYSICAL_EXAM_TYPE", columnDefinition = "VARCHAR2|体检类型||",length = 10, nullable = true)
	private String physicalExamType;
	
	@Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
	private Integer isDelete;
	
	@Column(name = "SYMPTOM_DESC", columnDefinition = "VARCHAR2|症状描述||", length = 200, nullable = true)
	private String symptomDesc;
	
	@Column(name = "DIET_PRE_DESC", columnDefinition = "VARCHAR2|饮食偏好描述||", length = 100, nullable = true)
	private String dietPreDesc;
	
	@Column(name = "DRINK_TYPE_DESC", columnDefinition = "VARCHAR2|饮酒类型描述||", length = 100, nullable = true)
	private String drinkTypeDesc;
	
    @Column(name = "IS_LIMIT", columnDefinition = "NUMBER|是否限制||", length = 1, nullable = true)
    private Integer isLimit = -1;

    @Column(name = "EXAM_STATUS", columnDefinition = "NUMBER|老年人体检报告是否生成,0:未生成,1:已生成||", length = 1, nullable = true)
    private Integer examStatus = 0;
    
	@Column(name = "GATHER_DATE", columnDefinition = "DATE|采集时间||", nullable = true)
	private Date gatherDate;
    
	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getEhrId() {
		return ehrId;
	}

	public void setEhrId(String ehrId) {
		this.ehrId = ehrId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhysicalExamCode() {
		return physicalExamCode;
	}

	public void setPhysicalExamCode(String physicalExamCode) {
		this.physicalExamCode = physicalExamCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public BigDecimal getPhysicalExamCost() {
		return physicalExamCost;
	}

	public void setPhysicalExamCost(BigDecimal physicalExamCost) {
		this.physicalExamCost = physicalExamCost;
	}

	public String getHealthEvaluateResult() {
		return healthEvaluateResult;
	}

	public void setHealthEvaluateResult(String healthEvaluateResult) {
		this.healthEvaluateResult = healthEvaluateResult;
	}

	public String getHealthEvaluationAnormalFlag() {
		return healthEvaluationAnormalFlag;
	}

	public void setHealthEvaluationAnormalFlag(String healthEvaluationAnormalFlag) {
		this.healthEvaluationAnormalFlag = healthEvaluationAnormalFlag;
	}

	public String getHealthEvaluateAnomalyDesc() {
		return healthEvaluateAnomalyDesc;
	}

	public void setHealthEvaluateAnomalyDesc(String healthEvaluateAnomalyDesc) {
		this.healthEvaluateAnomalyDesc = healthEvaluateAnomalyDesc;
	}

	public String getExaminationResult() {
		return examinationResult;
	}

	public void setExaminationResult(String examinationResult) {
		this.examinationResult = examinationResult;
	}

	public String getHealthGuidance() {
		return healthGuidance;
	}

	public void setHealthGuidance(String healthGuidance) {
		this.healthGuidance = healthGuidance;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	public String getHospitalCode() {
		return hospitalCode;
	}

	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getManaDoctorNo() {
		return manaDoctorNo;
	}

	public void setManaDoctorNo(String manaDoctorNo) {
		this.manaDoctorNo = manaDoctorNo;
	}

	public String getManaDoctorName() {
		return manaDoctorName;
	}

	public void setManaDoctorName(String manaDoctorName) {
		this.manaDoctorName = manaDoctorName;
	}

	public String getManaDoctorIdCard() {
		return manaDoctorIdCard;
	}

	public void setManaDoctorIdCard(String manaDoctorIdCard) {
		this.manaDoctorIdCard = manaDoctorIdCard;
	}

	public Date getExaminationDate() {
		return examinationDate;
	}

	public void setExaminationDate(Date examinationDate) {
		this.examinationDate = examinationDate;
	}
	
	public String getPhysicalExamType() {
		return physicalExamType;
	}

	public void setPhysicalExamType(String physicalExamType) {
		this.physicalExamType = physicalExamType;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getManaDoctorId() {
		return manaDoctorId;
	}

	public void setManaDoctorId(String manaDoctorId) {
		this.manaDoctorId = manaDoctorId;
	}

	public String getSymptomDesc() {
		return symptomDesc;
	}

	public void setSymptomDesc(String symptomDesc) {
		this.symptomDesc = symptomDesc;
	}

	public String getDietPreDesc() {
		return dietPreDesc;
	}

	public void setDietPreDesc(String dietPreDesc) {
		this.dietPreDesc = dietPreDesc;
	}

	public String getDrinkTypeDesc() {
		return drinkTypeDesc;
	}

	public void setDrinkTypeDesc(String drinkTypeDesc) {
		this.drinkTypeDesc = drinkTypeDesc;
	}

	
	public Integer getIsLimit() {
		return isLimit;
	}

	
	public void setIsLimit(Integer isLimit) {
		this.isLimit = isLimit;
	}

	public Integer getExamStatus() {
		return examStatus;
	}

	public void setExamStatus(Integer examStatus) {
		this.examStatus = examStatus;
	}

	public Date getGatherDate() {
		return gatherDate;
	}

	public void setGatherDate(Date gatherDate) {
		this.gatherDate = gatherDate;
	}

	

	
}