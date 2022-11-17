package com.founder.rhip.ehr.entity.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "DM_HIGHRISK_RISK_FACTORS")
public class DmHighriskRiskFactors implements Serializable {
	
	private static final long serialVersionUID = 5125495890960570581L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = true)
	private Long id;

	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|个人信息唯一编号||", length = 11, nullable = true)
	private Long personId;
	
	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|居民身份证/健康卡号||", length = 18, nullable = true)
	private String idcard;

	@Column(name = "TYPE", columnDefinition = "VARCHAR2|类别(记录和变化)||", length = 1, nullable = true)
	private String type;
	
	@Column(name = "OVERWEIGHT", columnDefinition = "VARCHAR2|超重标志||", length = 1, nullable = true)
	private String overweight;

	@Column(name = "BODY_MASS_INDEX", columnDefinition = "DECIMAL|体重指数||", length = 2, scale = 2, nullable = true)
	private BigDecimal bodyMassIndex;

	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别代码||", length = 1, nullable = true)
	private String gender;

	@Column(name = "WAOSTLINE", columnDefinition = "DECIMAL|腰围(cm)||", length = 5, scale = 1, nullable = true)
	private BigDecimal waostline;

	@Column(name = "NO_TRAIN", columnDefinition = "VARCHAR2|不运动标志||", length = 1, nullable = true)
	private String noTrain;

	@Column(name = "WEEKLY_TRAIN", columnDefinition = "INT|运动（次/周）||", nullable = true)
	private Integer weeklyTrain;

	@Column(name = "CURR_SMOKING_FLAG", columnDefinition = "VARCHAR2|当前吸烟标志||", length = 1, nullable = true)
	private String currSmokingFlag;

	@Column(name = "DAILY_SMOKE", columnDefinition = "DECIMAL|日吸烟量(支)||", length = 5, scale = 1,  nullable = true)
	private BigDecimal dailySmoke;

	@Column(name = "LONGTERM_DRINKING_FLAG", columnDefinition = "VARCHAR2|长期饮酒标志||", length = 1, nullable = true)
	private String longtermDrinkingFlag;

	@Column(name = "WEEKLY_DRINNK", columnDefinition = "INT|饮酒（次/周）||", nullable = true)
	private Integer weeklyDrinnk;

	@Column(name = "FOOD_GREASY_FLAG", columnDefinition = "VARCHAR2|饮食偏油脂标志||", length = 1, nullable = true)
	private String foodGreasyFlag;

	@Column(name = "DAILY_EAT_FISH_FLAG", columnDefinition = "VARCHAR2|每天吃8两以上鱼肉标志||", length = 1, nullable = true)
	private String dailyEatFishFlag;
	
	@Column(name = "TC", columnDefinition = "DECIMAL|总胆固醇值(mmol/L)||", length = 5, scale = 2,  nullable = true)
	private BigDecimal tc;

	@Column(name = "TRIGLYCERIDE_VALUE", columnDefinition = "DECIMAL|甘油三酯值(mmol/L)||", length = 3, scale = 1,  nullable = true)
	private BigDecimal triglycerideValue;

	@Column(name = "MONTHLY_EAT_OIL_FLAG", columnDefinition = "VARCHAR2|每月吃油4斤以上标志||", length = 1, nullable = true)
	private String monthlyEatOilFlag;

	@Column(name = "FAM_HISTORY_FLAG", columnDefinition = "VARCHAR2|家族史标志||", length = 1, nullable = true)
	private String famHistoryFlag;

	@Column(name = "IMM_FAM_HP_DI_HIS_FLAG", columnDefinition = "VARCHAR2|直系亲属高血压、糖尿病病史||", length = 50, nullable = true)
	private String immFamHpDiHisFlag;

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
	private Integer isDelete;
	
	@Column(name = "RISK_LEVEL", columnDefinition = "INT|危险因素等级||", nullable = true)
	private Integer riskLevel;
	
	@Column(name = "CONSENTS", columnDefinition = "VARCHAR2|签订知情同意书标志||", length = 1, nullable = true)
	private String consents;
	
	@Column(name = "SIGNATURE_DATE", columnDefinition = "TIMESTAMP|签订时间||", nullable = true)
	private Date signatureDate;
	
	@Column(name = "LCU", columnDefinition = "VARCHAR2|心理应激评定值||", length = 100, nullable = true)
	private String lcu;
	
	public String getConsents() {
		return consents;
	}

	public void setConsents(String consents) {
		this.consents = consents;
	}

	public Date getSignatureDate() {
		return signatureDate;
	}

	public void setSignatureDate(Date signatureDate) {
		this.signatureDate = signatureDate;
	}

	public String getLcu() {
		return lcu;
	}

	public void setLcu(String lcu) {
		this.lcu = lcu;
	}

	public Integer getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(Integer riskLevel) {
		this.riskLevel = riskLevel;
	}
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getPersonId() {
		return personId;
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNoTrain() {
		return this.noTrain;
	}

	public void setNoTrain(String noTrain) {
		this.noTrain = noTrain;
	}

	public Integer getWeeklyTrain() {
		return this.weeklyTrain;
	}

	public void setWeeklyTrain(Integer weeklyTrain) {
		this.weeklyTrain = weeklyTrain;
	}

	public String getCurrSmokingFlag() {
		return this.currSmokingFlag;
	}

	public void setCurrSmokingFlag(String currSmokingFlag) {
		this.currSmokingFlag = currSmokingFlag;
	}

	public BigDecimal getDailySmoke() {
		return this.dailySmoke;
	}

	public void setDailySmoke(BigDecimal dailySmoke) {
		this.dailySmoke = dailySmoke;
	}

	public String getLongtermDrinkingFlag() {
		return this.longtermDrinkingFlag;
	}

	public void setLongtermDrinkingFlag(String longtermDrinkingFlag) {
		this.longtermDrinkingFlag = longtermDrinkingFlag;
	}

	public Integer getWeeklyDrinnk() {
		return this.weeklyDrinnk;
	}

	public void setWeeklyDrinnk(Integer weeklyDrinnk) {
		this.weeklyDrinnk = weeklyDrinnk;
	}

	public String getFoodGreasyFlag() {
		return this.foodGreasyFlag;
	}

	public void setFoodGreasyFlag(String foodGreasyFlag) {
		this.foodGreasyFlag = foodGreasyFlag;
	}
	
	public String getDailyEatFishFlag() {
		return dailyEatFishFlag;
	}

	public void setDailyEatFishFlag(String dailyEatFishFlag) {
		this.dailyEatFishFlag = dailyEatFishFlag;
	}

	public String getMonthlyEatOilFlag() {
		return monthlyEatOilFlag;
	}

	public void setMonthlyEatOilFlag(String monthlyEatOilFlag) {
		this.monthlyEatOilFlag = monthlyEatOilFlag;
	}

	public BigDecimal getTc() {
		return this.tc;
	}

	public void setTc(BigDecimal tc) {
		this.tc = tc;
	}

	public BigDecimal getTriglycerideValue() {
		return this.triglycerideValue;
	}

	public void setTriglycerideValue(BigDecimal triglycerideValue) {
		this.triglycerideValue = triglycerideValue;
	}

	public String getFamHistoryFlag() {
		return this.famHistoryFlag;
	}

	public void setFamHistoryFlag(String famHistoryFlag) {
		this.famHistoryFlag = famHistoryFlag;
	}

	public String getImmFamHpDiHisFlag() {
		return this.immFamHpDiHisFlag;
	}

	public void setImmFamHpDiHisFlag(String immFamHpDiHisFlag) {
		this.immFamHpDiHisFlag = immFamHpDiHisFlag;
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

	public String getOverweight() {
		return overweight;
	}

	public void setOverweight(String overweight) {
		this.overweight = overweight;
	}

	public BigDecimal getBodyMassIndex() {
		return bodyMassIndex;
	}

	public void setBodyMassIndex(BigDecimal bodyMassIndex) {
		this.bodyMassIndex = bodyMassIndex;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public BigDecimal getWaostline() {
		return waostline;
	}

	public void setWaostline(BigDecimal waostline) {
		this.waostline = waostline;
	}

}