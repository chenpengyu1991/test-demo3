package com.founder.rhip.ehr.entity.management;

import com.founder.rhip.ehr.common.EHRConstants;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "DM_HYPERTENSION_CONCLUSION")
public class DmHypertensionConclusion implements Serializable {

	private static final long serialVersionUID = 1483995121069749904L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = true)
	private Long id;

	@Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = true)
	private String ehrId;

	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|个人信息唯一编号||", length = 11, nullable = true)
	private Long personId;

	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|居民身份证/健康卡号||", length = 18, nullable = true)
	private String idcard;

	@Column(name = "HEALTH_FILE_NO", columnDefinition = "VARCHAR2|城乡居民健康档案编号||", length = 17, nullable = true)
	private String healthFileNo;

	@Column(name = "SBP", columnDefinition = "SMALLINT|收缩压(mmHg)||", nullable = true)
	private Integer sbp;

	@Column(name = "DBP", columnDefinition = "SMALLINT|舒张压(mmHg)||", nullable = true)
	private Integer dbp;

	@Column(name = "HYPERTENSION_MANAGEMENT_LEVEL", columnDefinition = "VARCHAR2|高血压管理级别||", length = 1, nullable = true)
	private String hypertensionManagementLevel;

	@Column(name = "CLASSIFICATION_OF_HEALTH", columnDefinition = "VARCHAR2|健康状况分级||", length = 1, nullable = true)
	private String classificationOfHealth;

	@Column(name = "HYPERTENSION_RISK_HIERARCHY", columnDefinition = "VARCHAR2|高血压危险分层||", length = 1, nullable = true)
	private String hypertensionRiskHierarchy;

	@Column(name = "FPG", columnDefinition = "DECIMAL|空腹血糖值(mmol/L)||", length = 5, scale = 2, nullable = true)
	private BigDecimal fpg;

	@Column(name = "GLU_VALUE", columnDefinition = "DECIMAL|餐后两小时血糖值(mmol/L)||", length = 5, scale = 2, nullable = true)
	private BigDecimal gluValue;

	@Column(name = "SACCHARIFICATION", columnDefinition = "SMALLINT|糖化血红蛋自值(%)||", nullable = true)
	private Integer saccharification;

	@Column(name = "AUXILIARY_EXAMINE_ITEM", columnDefinition = "VARCHAR2|辅助检查项目||", length = 100, nullable = true)
	private String auxiliaryExamineItem;

	@Column(name = "DIAGNOSIS", columnDefinition = "VARCHAR2|诊断结论||", length = 1, nullable = true)
	private String diagnosis;

	@Column(name = "MANAGE_LEVEL", columnDefinition = "VARCHAR2|管理级别||", length = 1, nullable = true)
	private String manageLevel;

	@Column(name = "CONCLUSIONS_OF_YEAR", columnDefinition = "SMALLINT|结论年度||", nullable = true)
	private Integer conclusionsOfYear;

	@Column(name = "ANNUAL_VISIT_TIMES", columnDefinition = "SMALLINT|每年随访次数||", nullable = true)
	private Integer annualVisitTimes;

	@Column(name = "CREATE_ORGAN_NAME", columnDefinition = "VARCHAR2|填报机构名称||", length = 70, nullable = true)
	private String createOrganName;

	@Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|填报机构编码||", length = 50, nullable = true)
	private String createOrganCode;

	@Column(name = "CREATE_DOCTOR_NAME", columnDefinition = "VARCHAR2|填报人姓名||", length = 50, nullable = true)
	private String createDoctorName;

	@Column(name = "CREATE_DOCTOR_CODE", columnDefinition = "VARCHAR2|填报人编码||", length = 18, nullable = true)
	private String createDoctorCode;

	@Column(name = "CREATE_DATE", columnDefinition = "TIMESTAMP|填报时间||", nullable = true)
	private Date createDate;

	@Column(name = "UPDATE_ORGAN_CODE", columnDefinition = "VARCHAR2|更新机构编码||", length = 50, nullable = true)
	private String updateOrganCode;

	@Column(name = "UPDATE_ORGAN_NAME", columnDefinition = "VARCHAR2|更新机构名称||", length = 70, nullable = true)
	private String updateOrganName;

	@Column(name = "UPDATE_DOCTOR_CODE", columnDefinition = "VARCHAR2|更新人编码||", length = 18, nullable = true)
	private String updateDoctorCode;

	@Column(name = "UPDATE_DOCTOR_NAME", columnDefinition = "VARCHAR2|更新人姓名||", length = 50, nullable = true)
	private String updateDoctorName;

	@Column(name = "UPDATE_DATE", columnDefinition = "TIMESTAMP|更新日期和时间||", nullable = true)
	private Date updateDate;

	@Column(name = "IS_DELETE", columnDefinition = "INT|删除状态||", nullable = true)
	private Integer isDelete = EHRConstants.DELETE_FLG_0;
	
	@Column(name = "DISEASE_TYPE", columnDefinition = "VARCHAR2|疾病类型||", nullable = true)
	private String diseaseType;
	
	@Column(name = "LAST_CONCLUSIONS_OF_YEAR", columnDefinition = "INT|最近一次做保健计划的年份||", nullable = true)
	private Integer lastConclusionsOfYear;
	
	@Column(name = "DEAL_TYPE", columnDefinition = "VARCHAR2|处理类型||", nullable = true)
	private String dealType;
	
	@Column(name = "CVD_ELEMENT", columnDefinition = "VARCHAR2|(1)心血管疾病（CVD）危险因素||", nullable = true)
	private String cvdElement;
	
	@Column(name = "NEXT_FOLLOWUP_DATE", columnDefinition = "TIMESTAMP|下次随访时间||", nullable = true)
	private Date nextFollowupDate;
	
	@Column(name = "RBG", columnDefinition = "DECIMAL|随机血糖值(mmol/L)||", length = 5, scale = 2, nullable = true)
	private BigDecimal rbg;
	
	@Column(name = "DOUBLE_CHECK", columnDefinition = "DECIMAL|复查血糖未达标(mmol/L)||", nullable = true)
	private Integer doubleCheck;
	
	@Column(name = "PROCESS", columnDefinition = "VARCHAR2|处理方案||", nullable = true)
	private String process;
	
	@Column(name = "FOLLOWUP_TIMES", columnDefinition = "DECIMAL|随访次数||", nullable = true)
	private Integer followupTimes;
	
	public Integer getFollowupTimes() {
		return followupTimes;
	}

	public void setFollowupTimes(Integer followupTimes) {
		this.followupTimes = followupTimes;
	}

	public String getDealType() {
		return dealType;
	}

	public BigDecimal getRbg() {
		return rbg;
	}

	public void setRbg(BigDecimal rbg) {
		this.rbg = rbg;
	}


	public Integer getDoubleCheck() {
		return doubleCheck;
	}

	public void setDoubleCheck(Integer doubleCheck) {
		this.doubleCheck = doubleCheck;
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public Date getNextFollowupDate() {
		return nextFollowupDate;
	}

	public void setNextFollowupDate(Date nextFollowupDate) {
		this.nextFollowupDate = nextFollowupDate;
	}

	public void setDealType(String dealType) {
		this.dealType = dealType;
	}

	public String getCvdElement() {
		return cvdElement;
	}

	public void setCvdElement(String cvdElement) {
		this.cvdElement = cvdElement;
	}

	public String getTrDamage() {
		return trDamage;
	}

	public void setTrDamage(String trDamage) {
		this.trDamage = trDamage;
	}

	public String getRelatedDiseases() {
		return relatedDiseases;
	}

	public void setRelatedDiseases(String relatedDiseases) {
		this.relatedDiseases = relatedDiseases;
	}

	@Column(name = "TR_DAMAGE", columnDefinition = "VARCHAR2|(2)靶器官损伤||", nullable = true)
	private String trDamage;
	
	@Column(name = "RELATED_DISEASES", columnDefinition = "VARCHAR2|处理类型||", nullable = true)
	private String relatedDiseases;

	@Transient
	private Date birthday;
	
	@Transient
	private String phoneNumber;
	
	@Transient
	private String paprovince;
	
	@Transient
	private String hbpFlag;
	
	@Transient
	private String diFlag;
	
	public String getDiseaseId() {
		return diseaseId;
	}

	public void setDiseaseId(String diseaseId) {
		this.diseaseId = diseaseId;
	}

	@Transient
	private String diseaseId;
	
	public String getStrokeFlag() {
		return strokeFlag;
	}

	public void setStrokeFlag(String strokeFlag) {
		this.strokeFlag = strokeFlag;
	}

	public String getTumorFlag() {
		return tumorFlag;
	}

	public void setTumorFlag(String tumorFlag) {
		this.tumorFlag = tumorFlag;
	}

	public String getCoronaryFlag() {
		return coronaryFlag;
	}

	public void setCoronaryFlag(String coronaryFlag) {
		this.coronaryFlag = coronaryFlag;
	}

	@Transient
	private String strokeFlag;
	
	@Transient
	private String tumorFlag;
	
	@Transient
	private String coronaryFlag;
	
	@Transient
	private String diDiagnosedOrganCode;
	
	public String getDiDiagnosedOrganCode() {
		return diDiagnosedOrganCode;
	}

	public void setDiDiagnosedOrganCode(String diDiagnosedOrganCode) {
		this.diDiagnosedOrganCode = diDiagnosedOrganCode;
	}

	public Date getDiDiagnosedDate() {
		return diDiagnosedDate;
	}

	public void setDiDiagnosedDate(Date diDiagnosedDate) {
		this.diDiagnosedDate = diDiagnosedDate;
	}

	@Transient
	private Date diDiagnosedDate;
	
	@Transient
	private String diType;
	
	public String getHbpFlag() {
		return hbpFlag;
	}

	public void setHbpFlag(String hbpFlag) {
		this.hbpFlag = hbpFlag;
	}

	public String getDiFlag() {
		return diFlag;
	}

	public void setDiFlag(String diFlag) {
		this.diFlag = diFlag;
	}

	public String getDiType() {
		return diType;
	}

	public void setDiType(String diType) {
		this.diType = diType;
	}

	public String getPaprovince() {
		return paprovince;
	}

	public void setPaprovince(String paprovince) {
		this.paprovince = paprovince;
	}

	public String getPacity() {
		return pacity;
	}

	public void setPacity(String pacity) {
		this.pacity = pacity;
	}

	public String getPacounty() {
		return pacounty;
	}

	public void setPacounty(String pacounty) {
		this.pacounty = pacounty;
	}

	public String getPatownShip() {
		return patownShip;
	}

	public void setPatownShip(String patownShip) {
		this.patownShip = patownShip;
	}

	public String getPastreet() {
		return pastreet;
	}

	public void setPastreet(String pastreet) {
		this.pastreet = pastreet;
	}

	public String getPahouseNumber() {
		return pahouseNumber;
	}

	public void setPahouseNumber(String pahouseNumber) {
		this.pahouseNumber = pahouseNumber;
	}

	@Transient
	private String pacity;
	
	@Transient
	private String pacounty;
	
	@Transient
	private String patownShip;
	
	@Transient
	private String pastreet;
	
	@Transient
	private String pahouseNumber;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Transient
	private String name;
	
	public Date getBirthday() {
		return birthday;
	}

	public Integer getLastConclusionsOfYear() {
		return lastConclusionsOfYear;
	}

	public void setLastConclusionsOfYear(Integer lastConclusionsOfYear) {
		this.lastConclusionsOfYear = lastConclusionsOfYear;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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

	@Transient
	private String gender;
	
	public Long getId() {
		return this.id;
	}

	public String getDiseaseType() {
		return diseaseType;
	}

	public void setDiseaseType(String diseaseType) {
		this.diseaseType = diseaseType;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEhrId() {
		return this.ehrId;
	}

	public void setEhrId(String ehrId) {
		this.ehrId = ehrId;
	}

	public Long getPersonId() {
		return this.personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getHealthFileNo() {
		return this.healthFileNo;
	}

	public void setHealthFileNo(String healthFileNo) {
		this.healthFileNo = healthFileNo;
	}

	public Integer getSbp() {
		return this.sbp;
	}

	public void setSbp(Integer sbp) {
		this.sbp = sbp;
	}

	public Integer getDbp() {
		return this.dbp;
	}

	public void setDbp(Integer dbp) {
		this.dbp = dbp;
	}

	public String getHypertensionManagementLevel() {
		return this.hypertensionManagementLevel;
	}

	public void setHypertensionManagementLevel(String hypertensionManagementLevel) {
		this.hypertensionManagementLevel = hypertensionManagementLevel;
	}

	public String getClassificationOfHealth() {
		return this.classificationOfHealth;
	}

	public void setClassificationOfHealth(String classificationOfHealth) {
		this.classificationOfHealth = classificationOfHealth;
	}

	public String getHypertensionRiskHierarchy() {
		return this.hypertensionRiskHierarchy;
	}

	public void setHypertensionRiskHierarchy(String hypertensionRiskHierarchy) {
		this.hypertensionRiskHierarchy = hypertensionRiskHierarchy;
	}

	public BigDecimal getFpg() {
		return this.fpg;
	}

	public void setFpg(BigDecimal fpg) {
		this.fpg = fpg;
	}

	public BigDecimal getGluValue() {
		return this.gluValue;
	}

	public void setGluValue(BigDecimal gluValue) {
		this.gluValue = gluValue;
	}

	public Integer getSaccharification() {
		return this.saccharification;
	}

	public void setSaccharification(Integer saccharification) {
		this.saccharification = saccharification;
	}

	public String getAuxiliaryExamineItem() {
		return this.auxiliaryExamineItem;
	}

	public void setAuxiliaryExamineItem(String auxiliaryExamineItem) {
		this.auxiliaryExamineItem = auxiliaryExamineItem;
	}

	public String getDiagnosis() {
		return this.diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getManageLevel() {
		return this.manageLevel;
	}

	public void setManageLevel(String manageLevel) {
		this.manageLevel = manageLevel;
	}

	public Integer getConclusionsOfYear() {
		return this.conclusionsOfYear;
	}

	public void setConclusionsOfYear(Integer conclusionsOfYear) {
		this.conclusionsOfYear = conclusionsOfYear;
	}

	public Integer getAnnualVisitTimes() {
		return this.annualVisitTimes;
	}

	public void setAnnualVisitTimes(Integer annualVisitTimes) {
		this.annualVisitTimes = annualVisitTimes;
	}

	public String getCreateOrganName() {
		return this.createOrganName;
	}

	public void setCreateOrganName(String createOrganName) {
		this.createOrganName = createOrganName;
	}

	public String getCreateOrganCode() {
		return this.createOrganCode;
	}

	public void setCreateOrganCode(String createOrganCode) {
		this.createOrganCode = createOrganCode;
	}

	public String getCreateDoctorName() {
		return this.createDoctorName;
	}

	public void setCreateDoctorName(String createDoctorName) {
		this.createDoctorName = createDoctorName;
	}

	public String getCreateDoctorCode() {
		return this.createDoctorCode;
	}

	public void setCreateDoctorCode(String createDoctorCode) {
		this.createDoctorCode = createDoctorCode;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateOrganCode() {
		return this.updateOrganCode;
	}

	public void setUpdateOrganCode(String updateOrganCode) {
		this.updateOrganCode = updateOrganCode;
	}

	public String getUpdateOrganName() {
		return this.updateOrganName;
	}

	public void setUpdateOrganName(String updateOrganName) {
		this.updateOrganName = updateOrganName;
	}

	public String getUpdateDoctorCode() {
		return this.updateDoctorCode;
	}

	public void setUpdateDoctorCode(String updateDoctorCode) {
		this.updateDoctorCode = updateDoctorCode;
	}

	public String getUpdateDoctorName() {
		return this.updateDoctorName;
	}

	public void setUpdateDoctorName(String updateDoctorName) {
		this.updateDoctorName = updateDoctorName;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}