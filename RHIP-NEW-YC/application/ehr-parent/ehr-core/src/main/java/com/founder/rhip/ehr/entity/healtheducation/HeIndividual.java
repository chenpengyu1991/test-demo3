package com.founder.rhip.ehr.entity.healtheducation;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HE_INDIVIDUAL")
public class HeIndividual implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;
	
	@Column(name = "individual_Name", columnDefinition = "VARCHAR|名称||", length = 50, nullable = true)
	private String individualName;
	
	@Column(name = "GENDER", columnDefinition = "VARCHAR|性别||", length = 2, nullable = true)
	private String gender;
	
	@Column(name = "AGE", columnDefinition = "VARCHAR|年龄||", length = 20, nullable = true)
	private String age;
	
	@Column(name = "PHONE_NUMBER", columnDefinition = "VARCHAR|联系电话||", length = 20, nullable = true)
	private String phoneNumber;
	
	@Column(name = "IDCARD", columnDefinition = "VARCHAR|身份证号码||", length = 20, nullable = true)
	private String idcard;
	
	@Column(name = "PATOWN_SHIP", columnDefinition = "VARCHAR|现住址-乡(镇、街道办事处)||", length = 70, nullable = true)
	private String patownShip;
	
	@Column(name = "PASTREET", columnDefinition = "VARCHAR|现住址-村(街、路、弄等)||", length = 70, nullable = true)
	private String pastreet;
	
	@Column(name = "PA_GROUP", columnDefinition = "VARCHAR|现住址小组地址||", length = 50, nullable = true)
	private String paGroup;
	
	@Column(name = "PAHOUSE_NUMBER", columnDefinition = "VARCHAR|现住址-门牌号码||", length = 70, nullable = true)
	private String pahouseNumber;
	
	@Column(name = "INDIVIDUAL_TYPE", columnDefinition = "VARCHAR|个体化健康教育方式||", length = 50, nullable = true)
	private String individualType;
	
	@Column(name = "INDIVIDUAL_DESC", columnDefinition = "VARCHAR|个体化健康教育方式其他描述||", length = 200, nullable = true)
	private String individualDesc;
	
	@Column(name = "EDUCATION_DESC", columnDefinition = "VARCHAR|教育对象其他描述||", length = 200, nullable = true)
	private String educationDesc;
	
	@Column(name = "EDUCATION_TYPE", columnDefinition = "VARCHAR|教育对象类型||", length = 50, nullable = true)
	private String educationType;
	@Column(name = "preceptor", columnDefinition = "VARCHAR|指导医生||", length = 50, nullable = true)
	private String preceptor;
	
	@Column(name = "GUIDANCE_TIME", columnDefinition = "Date|指导时间||", length = 50, nullable = true)
	private Date guidanceTime;
	
	@Column(name = "PLACE_NAME", columnDefinition = "VARCHAR|地点名称||", length = 50, nullable = true)
	private String placeName;
	
	@Column(name = "PLACE_DESC", columnDefinition = "VARCHAR|地点名称其他描述||", length = 200, nullable = true)
	private String placeDesc;
	
	@Column(name = "HEALTH_DESC", columnDefinition = "VARCHAR|现存主要健康问题||", length = 200, nullable = true)
	private String healthDesc;
	
	@Column(name = "GUIDANCE_ADVICE", columnDefinition = "VARCHAR|指导意见||", length = 50, nullable = true)
	private String guidanceAdvice;
	
	@Column(name = "GUIDANCE_ADVICE_DESC", columnDefinition = "VARCHAR|其他指导意见||", length = 200, nullable = true)
	private String guidanceAdviceDesc;
	
	@Column(name = "RISK_QUIT_SMOKING", columnDefinition = "CHAR|危险因素戒烟||", length = 1, nullable = true)
    private String riskQuitSmoking;

    @Column(name = "RISK_HEALTH_DRINK", columnDefinition = "CHAR|危险因素健康饮酒||", length = 1, nullable = true)
    private String riskHealthDrink;

    @Column(name = "RISK_DIET", columnDefinition = "CHAR|危险因素饮食||", length = 1, nullable = true)
    private String riskDiet;

    @Column(name = "RISK_EXERCISE", columnDefinition = "CHAR|危险因素锻炼||", length = 1, nullable = true)
    private String riskExercise;

    @Column(name = "RISK_WEIGHT_REDUCTION", columnDefinition = "CHAR|危险因素减体重||", length = 1, nullable = true)
    private String riskWeightReduction;

    @Column(name = "RISK_WEIGHT_TARGET", columnDefinition = "VARCHAR2|危险因素减体重目标描述||", length = 7, nullable = true)
    private String riskWeightTarget;

    @Column(name = "GUIDE_VACCINATION", columnDefinition = "CHAR|健康指导接种疫苗||", length = 1, nullable = true)
    private String guideVaccination;

    @Column(name = "GUIDE_VACCINATION_DESC", columnDefinition = "VARCHAR2|健康指导接种疫苗描述||", length = 100, nullable = true)
    private String guideVaccinationDesc;

    @Column(name = "RISK_OTHER", columnDefinition = "CHAR|危险因素其他||", length = 1, nullable = true)
    private String riskOther;

    @Column(name = "RISK_OTHER_DESC", columnDefinition = "VARCHAR2|危险因素其他描述||", length = 100, nullable = true)
    private String riskOtherDesc;
	
    @Column(name = "RISK_HYGIENE", columnDefinition = "CHAR|危险因注意卫生||", length = 1, nullable = true)
    private String riskHygiene;
    
    @Column(name = "RISK_NURSING", columnDefinition = "CHAR|危险因素注意护理||", length = 1, nullable = true)
    private String riskNursing;
    
    @Column(name = "ORG_CODE", columnDefinition = "VARCHAR2|医疗机构||", length = 50, nullable = true)
    private String orgCode;
    
    @Column(name = "CENTER_ORG_CODE", columnDefinition = "VARCHAR2|上级机构代码||", length = 18, nullable = true)
	private String centerOrgCode;

	@Column(name = "GBCODE", columnDefinition = "VARCHAR2|乡镇代码||", length = 18, nullable = true)
	private String gbcode;

    @Column(name = "SERVICE_UNIT", columnDefinition = "VARCHAR2|服务单位||", length = 50, nullable = true)
    private String serviceUnit;

    @Column(name = "status", columnDefinition = "VARCHAR2|状态||", length = 2, nullable = true)
    private String status;
    
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getPreceptor() {
		return preceptor;
	}


	public void setPreceptor(String preceptor) {
		this.preceptor = preceptor;
	}


	public String getOrgCode() {
		return orgCode;
	}


	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}


	public String getCenterOrgCode() {
		return centerOrgCode;
	}


	public void setCenterOrgCode(String centerOrgCode) {
		this.centerOrgCode = centerOrgCode;
	}


	public String getGbcode() {
		return gbcode;
	}


	public void setGbcode(String gbcode) {
		this.gbcode = gbcode;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getIndividualName() {
		return individualName;
	}


	public void setIndividualName(String individualName) {
		this.individualName = individualName;
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


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getIdcard() {
		return idcard;
	}


	public void setIdcard(String idcard) {
		this.idcard = idcard;
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


	public String getPaGroup() {
		return paGroup;
	}


	public void setPaGroup(String paGroup) {
		this.paGroup = paGroup;
	}


	public String getPahouseNumber() {
		return pahouseNumber;
	}


	public void setPahouseNumber(String pahouseNumber) {
		this.pahouseNumber = pahouseNumber;
	}


	public String getIndividualType() {
		return individualType;
	}


	public void setIndividualType(String individualType) {
		this.individualType = individualType;
	}


	public String getIndividualDesc() {
		return individualDesc;
	}


	public void setIndividualDesc(String individualDesc) {
		this.individualDesc = individualDesc;
	}


	public String getEducationDesc() {
		return educationDesc;
	}


	public void setEducationDesc(String educationDesc) {
		this.educationDesc = educationDesc;
	}


	public String getEducationType() {
		return educationType;
	}


	public void setEducationType(String educationType) {
		this.educationType = educationType;
	}


	public Date getGuidanceTime() {
		return guidanceTime;
	}


	public void setGuidanceTime(Date guidanceTime) {
		this.guidanceTime = guidanceTime;
	}


	public String getPlaceName() {
		return placeName;
	}


	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}


	public String getPlaceDesc() {
		return placeDesc;
	}


	public void setPlaceDesc(String placeDesc) {
		this.placeDesc = placeDesc;
	}


	public String getHealthDesc() {
		return healthDesc;
	}


	public void setHealthDesc(String healthDesc) {
		this.healthDesc = healthDesc;
	}


	public String getGuidanceAdvice() {
		return guidanceAdvice;
	}


	public void setGuidanceAdvice(String guidanceAdvice) {
		this.guidanceAdvice = guidanceAdvice;
	}


	public String getGuidanceAdviceDesc() {
		return guidanceAdviceDesc;
	}


	public void setGuidanceAdviceDesc(String guidanceAdviceDesc) {
		this.guidanceAdviceDesc = guidanceAdviceDesc;
	}


	public String getRiskQuitSmoking() {
		return riskQuitSmoking;
	}


	public void setRiskQuitSmoking(String riskQuitSmoking) {
		this.riskQuitSmoking = riskQuitSmoking;
	}


	public String getRiskHealthDrink() {
		return riskHealthDrink;
	}


	public void setRiskHealthDrink(String riskHealthDrink) {
		this.riskHealthDrink = riskHealthDrink;
	}


	public String getRiskDiet() {
		return riskDiet;
	}


	public void setRiskDiet(String riskDiet) {
		this.riskDiet = riskDiet;
	}


	public String getRiskExercise() {
		return riskExercise;
	}


	public void setRiskExercise(String riskExercise) {
		this.riskExercise = riskExercise;
	}


	public String getRiskWeightReduction() {
		return riskWeightReduction;
	}


	public void setRiskWeightReduction(String riskWeightReduction) {
		this.riskWeightReduction = riskWeightReduction;
	}


	public String getRiskWeightTarget() {
		return riskWeightTarget;
	}


	public void setRiskWeightTarget(String riskWeightTarget) {
		this.riskWeightTarget = riskWeightTarget;
	}


	public String getGuideVaccination() {
		return guideVaccination;
	}


	public void setGuideVaccination(String guideVaccination) {
		this.guideVaccination = guideVaccination;
	}


	public String getGuideVaccinationDesc() {
		return guideVaccinationDesc;
	}


	public void setGuideVaccinationDesc(String guideVaccinationDesc) {
		this.guideVaccinationDesc = guideVaccinationDesc;
	}


	public String getRiskOther() {
		return riskOther;
	}


	public void setRiskOther(String riskOther) {
		this.riskOther = riskOther;
	}


	public String getRiskOtherDesc() {
		return riskOtherDesc;
	}


	public void setRiskOtherDesc(String riskOtherDesc) {
		this.riskOtherDesc = riskOtherDesc;
	}


	public String getRiskHygiene() {
		return riskHygiene;
	}


	public void setRiskHygiene(String riskHygiene) {
		this.riskHygiene = riskHygiene;
	}


	public String getRiskNursing() {
		return riskNursing;
	}


	public void setRiskNursing(String riskNursing) {
		this.riskNursing = riskNursing;
	}




	public String getServiceUnit() {
		return serviceUnit;
	}


	public void setServiceUnit(String serviceUnit) {
		this.serviceUnit = serviceUnit;
	}
    
    
}
