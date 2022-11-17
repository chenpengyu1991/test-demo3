package com.founder.rhip.ehr.entity.ep;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "EP_IODINE_NUTRITION_MONITOR")
public class IodineNutritionMonitor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String CROWD_CHILDREN = "1";//0-8岁儿童
	
	public static final String CROWD_WORMEN = "2";//育龄妇女

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;

	@Column(name = "SAMPLING_ID", columnDefinition = "NUMBER|抽样ID||", length = 11, nullable = true)
	private Long samplingId;

	@Column(name = "CROWD", columnDefinition = "VAR2|调查人群||", length = 50 , nullable = true)
	private String crowd = "1";

	@Column(name = "SURVEY_NO", columnDefinition = "VAR2|编号||", length = 50 , nullable = true)
	private String surveyNo;

	@Column(name = "NAME", columnDefinition = "VAR2|姓名||", length = 50 , nullable = true)
	private String name;

	@Column(name = "AGE", columnDefinition = "NUMBER|年龄||", length = 3, nullable = true)
	private Integer age;

	@Column(name = "GENDER", columnDefinition = "VAR2|性别||", length = 50 , nullable = true)
	private String gender;

	@Column(name = "ID_CARD", columnDefinition = "VAR2|身份证号||", length = 50 , nullable = true)
	private String idCard;
	
	@Column(name = "BASE_INFO", columnDefinition = "VAR2|基本情况||", length = 20 , nullable = true)
	private String baseInfo;

	@Column(name = "GB_CODE", columnDefinition = "VAR2|乡镇代码||", length = 18 , nullable = true)
	private String gbCode;

	@Column(name = "VILLAGE_CODE", columnDefinition = "VAR2|行政村代码||", length = 18 , nullable = true)
	private String villageCode;

	@Column(name = "VILLAGE_GROUP", columnDefinition = "VAR2|村民小组||", length = 50 , nullable = true)
	private String villageGroup;

	@Column(name = "NATURAL_VILLAGE", columnDefinition = "VAR2|自然村||", length = 50 , nullable = true)
	private String naturalVillage;

	@Column(name = "SCHOOL_NAME", columnDefinition = "VAR2|学校名称||", length = 50 , nullable = true)
	private String schoolName;

	@Column(name = "CLASS_NAME", columnDefinition = "VAR2|班级名称||", length = 50 , nullable = true)
	private String className;

	@Column(name = "SALT_SOURCE", columnDefinition = "VAR2|食盐来源||", length = 20 , nullable = true)
	private String saltSource;

	@Column(name = "SALT_TYPE", columnDefinition = "VAR2|食盐种类||", length = 50 , nullable = true)
	private String saltType;

	@Column(name = "IODIZED_OIL_CAPSULE", columnDefinition = "VAR2|一年内是否服用碘油丸||", length = 1 , nullable = true)
	private String iodizedOilCapsule;

	@Column(name = "URINE_TEST_RESULT", columnDefinition = "NUMBER|尿样检测结果||", length = 10, nullable = true)
	private Double urineTestResult;

	@Column(name = "SALT_IODINE_CONTENT", columnDefinition = "NUMBER|盐碘含量||", length = 10, nullable = true)
	private Double saltIodineContent;

	@Column(name = "THYROID_PALPATION", columnDefinition = "VAR2|甲状腺触诊||", length = 1 , nullable = true)
	private String thyroidPalpation;

	@Column(name = "INTELLIGENCE_QUEST_SCORE", columnDefinition = "NUMBER|智商题答对数||", length = 3, nullable = true)
	private Integer intelligenceQuestScore;

	@Column(name = "TYROID_LEFT_WIDTH", columnDefinition = "NUMBER|甲状腺左宽||", length = 10, nullable = true)
	private Double tyroidLeftWidth;

	@Column(name = "TYROID_RIGHT_WIDTH", columnDefinition = "NUMBER|甲状腺右宽||", length = 10, nullable = true)
	private Double tyroidRightWidth;

	@Column(name = "TYROID_LEFT_LENGTH", columnDefinition = "NUMBER|甲状腺左长||", length = 10, nullable = true)
	private Double tyroidLeftLength;

	@Column(name = "TYROID_RIGHT_LENGTH", columnDefinition = "NUMBER|甲状腺右长||", length = 10, nullable = true)
	private Double tyroidRightLength;

	@Column(name = "TYROID_LEFT_HEIGHT", columnDefinition = "NUMBER|甲状腺左厚||", length = 10, nullable = true)
	private Double tyroidLeftHeight;

	@Column(name = "TYROID_RIGHT_HEIGHT", columnDefinition = "NUMBER|甲状腺右厚||", length = 10, nullable = true)
	private Double tyroidRightHeight;

	@Column(name = "FAMILY_MEMBERS", columnDefinition = "NUMBER|家庭人口数||", length = 2, nullable = true)
	private Integer familyMembers;

	@Column(name = "SALTCELLAR_WEIGHT_BEFORE", columnDefinition = "NUMBER|第1天早餐前盐罐重量||", length = 5, nullable = true)
	private Double saltcellarWeightBefore;

	@Column(name = "SALTCELLAR_WEIGHT_AFTER", columnDefinition = "NUMBER|第3天晚餐后盐罐重量||", length = 5, nullable = true)
	private Double saltcellarWeightAfter;

	@Column(name = "THREE_DAYS_DINING_PT_SALT", columnDefinition = "NUMBER|3天用餐总人次（摄盐量）||", length = 5, nullable = true)
	private Integer threeDaysDiningPtSalt = 0;

	@Column(name = "AVERAGE_SALT_INTAKE", columnDefinition = "NUMBER|日人均摄盐量||", scale = 5, precision = 2, nullable = true)
	private Double averageSaltIntake = 0.0;

	@Column(name = "SALT_INTAKE_REMARK", columnDefinition = "VAR2|摄盐量备注||", length = 100 , nullable = true)
	private String saltIntakeRemark;

	@Column(name = "SOY_WEIGHT_BEFORE", columnDefinition = "NUMBER|第1天早餐前酱油重量||", length = 5, nullable = true)
	private Double soyWeightBefore;

	@Column(name = "SOY_WEIGHT_AFTER", columnDefinition = "NUMBER|第3天晚餐后酱油重量||", length = 5, nullable = true)
	private Double soyWeightAfter;

	@Column(name = "THREE_DAYS_DINING_PT_SOY", columnDefinition = "NUMBER|3天用餐总人次（酱油摄入量）||", length = 5, nullable = true)
	private Integer threeDaysDiningPtSoy = 0;

	@Column(name = "AVERAGE_SOY_INTAKE", columnDefinition = "NUMBER|日人均酱油摄入量||", scale = 5, precision = 2, nullable = true)
	private Double averageSoyIntake = 0.0;

	@Column(name = "SOY_INTAKE_REMARK", columnDefinition = "VAR2|酱油摄入量备注||", length = 100 , nullable = true)
	private String soyIntakeRemark;

	@Column(name = "ZERO_DAY_SUPPER_PT", columnDefinition = "NUMBER|前一天晚餐人次||", length = 3, nullable = true)
	private Integer zeroDaySupperPt;

	@Column(name = "FIRST_BREAKFIRST_PT", columnDefinition = "NUMBER|第一天早餐人次||", length = 3, nullable = true)
	private Integer firstBreakfirstPt;

	@Column(name = "FIRST_LUNCH_PT", columnDefinition = "NUMBER|第一天午餐人次||", length = 3, nullable = true)
	private Integer firstLunchPt;

	@Column(name = "FIRST_SUPPER_PT", columnDefinition = "NUMBER|第一天晚餐人次||", length = 3, nullable = true)
	private Integer firstSupperPt;

	@Column(name = "SECOND_BREAKFIRST_PT", columnDefinition = "NUMBER|第二天早餐人次||", length = 3, nullable = true)
	private Integer secondBreakfirstPt;

	@Column(name = "SECOND_LUNCH_PT", columnDefinition = "NUMBER|第二天午餐人次||", length = 3, nullable = true)
	private Integer secondLunchPt;

	@Column(name = "SECOND_SUPPER_PT", columnDefinition = "NUMBER|第二天晚餐人次||", length = 3, nullable = true)
	private Integer secondSupperPt;

	@Column(name = "THIRD_BREAKFIRST_PT", columnDefinition = "NUMBER|第三天早餐人次||", length = 3, nullable = true)
	private Integer thirdBreakfirstPt;

	@Column(name = "THIRD_LUNCH_PT", columnDefinition = "NUMBER|第三天午餐人次||", length = 3, nullable = true)
	private Integer thirdLunchPt;

	@Column(name = "THIRD_SUPPER_PT", columnDefinition = "NUMBER|第三天晚餐人次||", length = 3, nullable = true)
	private Integer thirdSupperPt;

	@Column(name = "FOURTH_BREAKFIRST_PT", columnDefinition = "NUMBER|第四天早餐人次||", length = 3, nullable = true)
	private Integer fourthBreakfirstPt;

	@Column(name = "INVESTIGATOR", columnDefinition = "VAR2|调查人||", length = 50 , nullable = true)
	private String investigator;

	@Column(name = "VERIFIER", columnDefinition = "VAR2|审核人||", length = 50 , nullable = true)
	private String verifier;

	@Column(name = "INVESTIGATE_UNIT", columnDefinition = "VAR2|调查单位||", length = 50 , nullable = true)
	private String investigateUnit;

	@Column(name = "INVESTIGATOR_PHONE", columnDefinition = "VAR2|调查人联系电话||", length = 50 , nullable = true)
	private String investigatorPhone;

	@Column(name = "INVESTIGATE_TIME", columnDefinition = "DATE|调查日期||", nullable = true)
	private Date investigateTime;

	@Column(name = "CREATE_PERSON", columnDefinition = "VAR2|创建人||", length = 50 , nullable = true)
	private String createPerson;

	@Column(name = "CREATE_ORGAN", columnDefinition = "VAR2|创建机构||", length = 50 , nullable = true)
	private String createOrgan;

	@Column(name = "CREATE_TIME", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createTime;

	@Column(name = "UPDATE_PERSON", columnDefinition = "VAR2|更新人||", length = 50 , nullable = true)
	private String updatePerson;

	@Column(name = "UPDATE_ORGAN", columnDefinition = "VAR2|更新机构||", length = 50 , nullable = true)
	private String updateOrgan;

	@Column(name = "UPDATE_TIME", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date updateTime;

	@Column(name = "DELETE_FLAG", columnDefinition = "VAR2|删除标识||", length = 1 , nullable = true)
	private Integer deleteFlag = 0;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSamplingId() {
		return this.samplingId;
	}

	public void setSamplingId(Long samplingId) {
		this.samplingId = samplingId;
	}

	public String getCrowd() {
		return this.crowd;
	}

	public void setCrowd(String crowd) {
		this.crowd = crowd;
	}

	public String getSurveyNo() {
		return this.surveyNo;
	}

	public void setSurveyNo(String surveyNo) {
		this.surveyNo = surveyNo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getGbCode() {
		return this.gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	public String getVillageCode() {
		return this.villageCode;
	}

	public void setVillageCode(String villageCode) {
		this.villageCode = villageCode;
	}

	public String getVillageGroup() {
		return this.villageGroup;
	}

	public void setVillageGroup(String villageGroup) {
		this.villageGroup = villageGroup;
	}

	public String getNaturalVillage() {
		return this.naturalVillage;
	}

	public void setNaturalVillage(String naturalVillage) {
		this.naturalVillage = naturalVillage;
	}

	public String getSchoolName() {
		return this.schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSaltSource() {
		return this.saltSource;
	}

	public void setSaltSource(String saltSource) {
		this.saltSource = saltSource;
	}

	public String getSaltType() {
		return this.saltType;
	}

	public void setSaltType(String saltType) {
		this.saltType = saltType;
	}

	public String getIodizedOilCapsule() {
		return this.iodizedOilCapsule;
	}

	public void setIodizedOilCapsule(String iodizedOilCapsule) {
		this.iodizedOilCapsule = iodizedOilCapsule;
	}

	public Double getUrineTestResult() {
		return this.urineTestResult;
	}

	public void setUrineTestResult(Double urineTestResult) {
		this.urineTestResult = urineTestResult;
	}

	public Double getSaltIodineContent() {
		return this.saltIodineContent;
	}

	public void setSaltIodineContent(Double saltIodineContent) {
		this.saltIodineContent = saltIodineContent;
	}

	public String getThyroidPalpation() {
		return this.thyroidPalpation;
	}

	public void setThyroidPalpation(String thyroidPalpation) {
		this.thyroidPalpation = thyroidPalpation;
	}

	public Integer getIntelligenceQuestScore() {
		return this.intelligenceQuestScore;
	}

	public void setIntelligenceQuestScore(Integer intelligenceQuestScore) {
		this.intelligenceQuestScore = intelligenceQuestScore;
	}

	public Double getTyroidLeftWidth() {
		return this.tyroidLeftWidth;
	}

	public void setTyroidLeftWidth(Double tyroidLeftWidth) {
		this.tyroidLeftWidth = tyroidLeftWidth;
	}

	public Double getTyroidRightWidth() {
		return this.tyroidRightWidth;
	}

	public void setTyroidRightWidth(Double tyroidRightWidth) {
		this.tyroidRightWidth = tyroidRightWidth;
	}

	public Double getTyroidLeftLength() {
		return this.tyroidLeftLength;
	}

	public void setTyroidLeftLength(Double tyroidLeftLength) {
		this.tyroidLeftLength = tyroidLeftLength;
	}

	public Double getTyroidRightLength() {
		return this.tyroidRightLength;
	}

	public void setTyroidRightLength(Double tyroidRightLength) {
		this.tyroidRightLength = tyroidRightLength;
	}

	public Double getTyroidLeftHeight() {
		return this.tyroidLeftHeight;
	}

	public void setTyroidLeftHeight(Double tyroidLeftHeight) {
		this.tyroidLeftHeight = tyroidLeftHeight;
	}

	public Double getTyroidRightHeight() {
		return this.tyroidRightHeight;
	}

	public void setTyroidRightHeight(Double tyroidRightHeight) {
		this.tyroidRightHeight = tyroidRightHeight;
	}

	public Integer getFamilyMembers() {
		return this.familyMembers;
	}

	public void setFamilyMembers(Integer familyMembers) {
		this.familyMembers = familyMembers;
	}

	public Double getSaltcellarWeightBefore() {
		return this.saltcellarWeightBefore;
	}

	public void setSaltcellarWeightBefore(Double saltcellarWeightBefore) {
		this.saltcellarWeightBefore = saltcellarWeightBefore;
	}

	public Double getSaltcellarWeightAfter() {
		return this.saltcellarWeightAfter;
	}

	public void setSaltcellarWeightAfter(Double saltcellarWeightAfter) {
		this.saltcellarWeightAfter = saltcellarWeightAfter;
	}

	public Integer getThreeDaysDiningPtSalt() {
		return this.threeDaysDiningPtSalt;
	}

	public void setThreeDaysDiningPtSalt(Integer threeDaysDiningPtSalt) {
		this.threeDaysDiningPtSalt = threeDaysDiningPtSalt;
	}

	public Double getAverageSaltIntake() {
		return this.averageSaltIntake;
	}

	public void setAverageSaltIntake(Double averageSaltIntake) {
		this.averageSaltIntake = averageSaltIntake;
	}

	public String getSaltIntakeRemark() {
		return this.saltIntakeRemark;
	}

	public void setSaltIntakeRemark(String saltIntakeRemark) {
		this.saltIntakeRemark = saltIntakeRemark;
	}

	public Double getSoyWeightBefore() {
		return this.soyWeightBefore;
	}

	public void setSoyWeightBefore(Double soyWeightBefore) {
		this.soyWeightBefore = soyWeightBefore;
	}

	public Double getSoyWeightAfter() {
		return this.soyWeightAfter;
	}

	public void setSoyWeightAfter(Double soyWeightAfter) {
		this.soyWeightAfter = soyWeightAfter;
	}

	public Integer getThreeDaysDiningPtSoy() {
		return this.threeDaysDiningPtSoy;
	}

	public void setThreeDaysDiningPtSoy(Integer threeDaysDiningPtSoy) {
		this.threeDaysDiningPtSoy = threeDaysDiningPtSoy;
	}

	public Double getAverageSoyIntake() {
		return this.averageSoyIntake;
	}

	public void setAverageSoyIntake(Double averageSoyIntake) {
		this.averageSoyIntake = averageSoyIntake;
	}

	public String getSoyIntakeRemark() {
		return this.soyIntakeRemark;
	}

	public void setSoyIntakeRemark(String soyIntakeRemark) {
		this.soyIntakeRemark = soyIntakeRemark;
	}

	public Integer getZeroDaySupperPt() {
		return this.zeroDaySupperPt;
	}

	public void setZeroDaySupperPt(Integer zeroDaySupperPt) {
		this.zeroDaySupperPt = zeroDaySupperPt;
	}

	public Integer getFirstBreakfirstPt() {
		return this.firstBreakfirstPt;
	}

	public void setFirstBreakfirstPt(Integer firstBreakfirstPt) {
		this.firstBreakfirstPt = firstBreakfirstPt;
	}

	public Integer getFirstLunchPt() {
		return this.firstLunchPt;
	}

	public void setFirstLunchPt(Integer firstLunchPt) {
		this.firstLunchPt = firstLunchPt;
	}

	public Integer getFirstSupperPt() {
		return this.firstSupperPt;
	}

	public void setFirstSupperPt(Integer firstSupperPt) {
		this.firstSupperPt = firstSupperPt;
	}

	public Integer getSecondBreakfirstPt() {
		return this.secondBreakfirstPt;
	}

	public void setSecondBreakfirstPt(Integer secondBreakfirstPt) {
		this.secondBreakfirstPt = secondBreakfirstPt;
	}

	public Integer getSecondLunchPt() {
		return this.secondLunchPt;
	}

	public void setSecondLunchPt(Integer secondLunchPt) {
		this.secondLunchPt = secondLunchPt;
	}

	public Integer getSecondSupperPt() {
		return this.secondSupperPt;
	}

	public void setSecondSupperPt(Integer secondSupperPt) {
		this.secondSupperPt = secondSupperPt;
	}

	public Integer getThirdBreakfirstPt() {
		return this.thirdBreakfirstPt;
	}

	public void setThirdBreakfirstPt(Integer thirdBreakfirstPt) {
		this.thirdBreakfirstPt = thirdBreakfirstPt;
	}

	public Integer getThirdLunchPt() {
		return this.thirdLunchPt;
	}

	public void setThirdLunchPt(Integer thirdLunchPt) {
		this.thirdLunchPt = thirdLunchPt;
	}

	public Integer getThirdSupperPt() {
		return this.thirdSupperPt;
	}

	public void setThirdSupperPt(Integer thirdSupperPt) {
		this.thirdSupperPt = thirdSupperPt;
	}

	public Integer getFourthBreakfirstPt() {
		return this.fourthBreakfirstPt;
	}

	public void setFourthBreakfirstPt(Integer fourthBreakfirstPt) {
		this.fourthBreakfirstPt = fourthBreakfirstPt;
	}

	public String getInvestigator() {
		return this.investigator;
	}

	public void setInvestigator(String investigator) {
		this.investigator = investigator;
	}

	public String getVerifier() {
		return this.verifier;
	}

	public void setVerifier(String verifier) {
		this.verifier = verifier;
	}

	public String getInvestigateUnit() {
		return this.investigateUnit;
	}

	public void setInvestigateUnit(String investigateUnit) {
		this.investigateUnit = investigateUnit;
	}

	public String getInvestigatorPhone() {
		return this.investigatorPhone;
	}

	public void setInvestigatorPhone(String investigatorPhone) {
		this.investigatorPhone = investigatorPhone;
	}

	public Date getInvestigateTime() {
		return this.investigateTime;
	}

	public void setInvestigateTime(Date investigateTime) {
		this.investigateTime = investigateTime;
	}

	public String getCreatePerson() {
		return this.createPerson;
	}

	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}

	public String getCreateOrgan() {
		return this.createOrgan;
	}

	public void setCreateOrgan(String createOrgan) {
		this.createOrgan = createOrgan;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdatePerson() {
		return this.updatePerson;
	}

	public void setUpdatePerson(String updatePerson) {
		this.updatePerson = updatePerson;
	}

	public String getUpdateOrgan() {
		return this.updateOrgan;
	}

	public void setUpdateOrgan(String updateOrgan) {
		this.updateOrgan = updateOrgan;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getBaseInfo() {
		return baseInfo;
	}

	public void setBaseInfo(String baseInfo) {
		this.baseInfo = baseInfo;
	}

}