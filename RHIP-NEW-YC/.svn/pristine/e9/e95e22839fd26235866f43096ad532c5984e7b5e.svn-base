package com.founder.rhip.ehr.entity.control.oh;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.founder.rhip.ehr.annotation.Star;
import com.founder.rhip.ehr.common.StarType;

import java.util.Date;

@Entity
@Table(name = "OH_POISON_REPORT")
public class OhPoisonReport implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "CARD_TYPE", columnDefinition = "NUMBER|报卡类别|11|", length = 11, nullable = true)
	private Long cardType;

	@Column(name = "CARD_NO", columnDefinition = "VARCHAR2|卡片序列号|20|", length = 20, nullable = true)
	private String cardNo;

	@Column(name = "PAPROVINCE", columnDefinition = "VARCHAR2|省|20|", length = 20, nullable = true)
	private String paprovince;

	@Column(name = "PACITY", columnDefinition = "VARCHAR2|市|20|", length = 20, nullable = true)
	private String pacity;

	@Column(name = "PACOUNTY", columnDefinition = "VARCHAR2|县|20|", length = 20, nullable = true)
	private String pacounty;

	@Column(name = "PATOWN_SHIP", columnDefinition = "VARCHAR2|乡镇|20|", length = 20, nullable = true)
	private String patownShip;

	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证号|20|", length = 20, nullable = true)
	private String idcard;

	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别|20|", length = 20, nullable = true)
	private String gender;

	@Column(name = "EDUCATION", columnDefinition = "VARCHAR2|文化程度|20|", length = 20, nullable = true)
	private String education;

	@Column(name = "DRUG_NAME", columnDefinition = "VARCHAR2|中毒农药名称|20|", length = 20, nullable = true)
	private String drugName;

	@Column(name = "DRUG_TYPE", columnDefinition = "VARCHAR2|中毒农药种类|2|", length = 2, nullable = true)
	private String drugType;

	@Column(name = "POISON_TYPE", columnDefinition = "VARCHAR2|中毒类型|2|", length = 2, nullable = true)
	private String poisonType;

	@Column(name = "POISON_REASON_CODE", columnDefinition = "VARCHAR2|中毒原因大类|2|", length = 2, nullable = true)
	private String poisonReasonCode;

	@Column(name = "POISON_REASON_SUBCODE", columnDefinition = "VARCHAR2|中毒原因子类|2|", length = 2, nullable = true)
	private String poisonReasonSubcode;

	@Column(name = "REMARK", columnDefinition = "VARCHAR2|备注|200|", length = 200, nullable = true)
	private String remark;

	@Column(name = "POISON_LEVEL", columnDefinition = "VARCHAR2|中毒程度|20|", length = 20, nullable = true)
	private String poisonLevel;

	@Column(name = "OUTCOME", columnDefinition = "VARCHAR2|转归|2|", length = 2, nullable = true)
	private String outcome;

	@Column(name = "DIAGNOSIS_DT", columnDefinition = "DATE|诊断日期||", nullable = true)
	private Date diagnosisDt;

	@Column(name = "DEATH_DATE", columnDefinition = "DATE|死亡日期||", nullable = true)
	private Date deathDate;

	@Column(name = "DIAGNOSIS_ORG", columnDefinition = "VARCHAR2|诊断机构|50|", length = 50, nullable = true)
	private String diagnosisOrg;

	@Column(name = "HEAD_UNIT", columnDefinition = "VARCHAR2|单位负责人|50|", length = 50, nullable = true)
	private String headUnit;

	@Column(name = "REPORTER", columnDefinition = "VARCHAR2|报告人|20|", length = 20, nullable = true)
	private String reporter;

	@Column(name = "REPORTER_TEL", columnDefinition = "VARCHAR2|报告人联系电话|20|", length = 20, nullable = true)
	private String reporterTel;

	@Column(name = "REPORT_DATE", columnDefinition = "DATE|报告日期||", nullable = true)
	private Date reportDate;

	@Column(name = "VERIFY_STATE", columnDefinition = "VARCHAR2|审核状态|2|", length = 2, nullable = true)
	private String verifyState;

	@Column(name = "VERIFY_DATE", columnDefinition = "DATE|审核时间||", nullable = true)
	private Date verifyDate;

	@Column(name = "VERIFIER", columnDefinition = "VARCHAR2|审核人|20|", length = 20, nullable = true)
	private String verifier;

	@Column(name = "CREATE_TIME", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createTime;

	@Column(name = "CREATE_BY", columnDefinition = "VARCHAR2|创建者|50|", length = 50, nullable = true)
	private String createBy;

	@Column(name = "UPDATE_TIME", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date updateTime;

	@Column(name = "UPDATE_BY", columnDefinition = "VARCHAR2|更新者|50|", length = 50, nullable = true)
	private String updateBy;

	@Column(name = "IS_DELETE", columnDefinition = "INT|删除状态||", nullable = true)
	private Integer isDelete;

	@Column(name = "AGE", columnDefinition = "INT|年龄||", nullable = true)
	private Integer age;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|姓名|50|", length = 50, nullable = true)
	private String name;

	@Column(name = "PASTREET", columnDefinition = "VARCHAR2|现住址-村(街、路、弄等)||", length = 50, nullable = true)
	private String pastreet;

	@Column(name = "PA_GROUP", columnDefinition = "VARCHAR2|现住址小组地址||", length = 2, nullable = true)
	private String paGroup;

	@Column(name = "PAHOUSE_NUMBER", columnDefinition = "VARCHAR2|现住址-门牌号码||", length = 50, nullable = true)
	private String pahouseNumber;

	@Column(name = "OTHER_FLAG", columnDefinition = "INT|是否外地诊断||", nullable = true)
	private Integer otherFlag;

	@Column(name = "OTHER_ORG", columnDefinition = "VARCHAR2|外地诊断机构|50|", length = 50, nullable = true)
	private String otherOrg;

	@Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|创建机构|50|", length = 50, nullable = true)
	private String createOrganCode;

	@Column(name = "UPDATE_ORGAN_CODE", columnDefinition = "VARCHAR2|修改机构|50|", length = 50, nullable = true)
	private String updateOrganCode;

	public String getPaGroup() {
		return paGroup;
	}

	public void setPaGroup(String paGroup) {
		this.paGroup = paGroup;
	}

	public Integer getOtherFlag() {
		return otherFlag;
	}

	public void setOtherFlag(Integer otherFlag) {
		this.otherFlag = otherFlag;
	}

	public String getOtherOrg() {
		return otherOrg;
	}

	public void setOtherOrg(String otherOrg) {
		this.otherOrg = otherOrg;
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

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCardType() {
		return this.cardType;
	}

	public void setCardType(Long cardType) {
		this.cardType = cardType;
	}

	public String getCardNo() {
		return this.cardNo;
	}


	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getPaprovince() {
		return this.paprovince;
	}

	public void setPaprovince(String paprovince) {
		this.paprovince = paprovince;
	}

	public String getPacity() {
		return this.pacity;
	}

	public void setPacity(String pacity) {
		this.pacity = pacity;
	}

	public String getPacounty() {
		return this.pacounty;
	}

	public void setPacounty(String pacounty) {
		this.pacounty = pacounty;
	}

	public String getPatownShip() {
		return this.patownShip;
	}

	public void setPatownShip(String patownShip) {
		this.patownShip = patownShip;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getDrugName() {
		return this.drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getDrugType() {
		return this.drugType;
	}

	public void setDrugType(String drugType) {
		this.drugType = drugType;
	}

	public String getPoisonType() {
		return this.poisonType;
	}

	public void setPoisonType(String poisonType) {
		this.poisonType = poisonType;
	}

	public String getPoisonReasonCode() {
		return poisonReasonCode;
	}

	public void setPoisonReasonCode(String poisonReasonCode) {
		this.poisonReasonCode = poisonReasonCode;
	}

	public String getPoisonReasonSubcode() {
		return poisonReasonSubcode;
	}

	public void setPoisonReasonSubcode(String poisonReasonSubcode) {
		this.poisonReasonSubcode = poisonReasonSubcode;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPoisonLevel() {
		return this.poisonLevel;
	}

	public void setPoisonLevel(String poisonLevel) {
		this.poisonLevel = poisonLevel;
	}

	public String getOutcome() {
		return this.outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public Date getDiagnosisDt() {
		return this.diagnosisDt;
	}

	public void setDiagnosisDt(Date diagnosisDt) {
		this.diagnosisDt = diagnosisDt;
	}

	public Date getDeathDate() {
		return this.deathDate;
	}

	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	public String getDiagnosisOrg() {
		return this.diagnosisOrg;
	}

	public void setDiagnosisOrg(String diagnosisOrg) {
		this.diagnosisOrg = diagnosisOrg;
	}

	public String getHeadUnit() {
		return this.headUnit;
	}

	public void setHeadUnit(String headUnit) {
		this.headUnit = headUnit;
	}

	public String getReporter() {
		return this.reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public String getReporterTel() {
		return this.reporterTel;
	}

	public void setReporterTel(String reporterTel) {
		this.reporterTel = reporterTel;
	}

	public Date getReportDate() {
		return this.reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getVerifyState() {
		return this.verifyState;
	}

	public void setVerifyState(String verifyState) {
		this.verifyState = verifyState;
	}

	public Date getVerifyDate() {
		return this.verifyDate;
	}

	public void setVerifyDate(Date verifyDate) {
		this.verifyDate = verifyDate;
	}

	public String getVerifier() {
		return this.verifier;
	}

	public void setVerifier(String verifier) {
		this.verifier = verifier;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Integer getIsDelete() {
		return this.isDelete;
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

	public String getUpdateOrganCode() {
		return updateOrganCode;
	}

	public void setUpdateOrganCode(String updateOrganCode) {
		this.updateOrganCode = updateOrganCode;
	}
}