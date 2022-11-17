package com.founder.rhip.fdm.entity;

import javax.persistence.*;

import com.founder.rhip.ehr.service.export.Item;

import java.io.Serializable;
import java.util.Date;

/**
 * FoodborneReport
 * @author liuk
 *
 */
@Entity
@Table(name = "FD_FOODBORNE_REPORT")
public class FoodBorneReport implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|本表唯一编码|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|个人信息唯一编号||", length = 11, nullable = true)
	private Long personId;

	@Column(name = "STATUS", columnDefinition = "VARCHAR2|状态（1上报未审批；2审批通过；3作废）|2|", length = 2, nullable = true)
	private String status;

	@Column(name = "OUTPATIENT_NO", columnDefinition = "VARCHAR2|门诊号|20|", length = 20, nullable = true)
	private String outpatientNo;

	@Column(name = "NO1", columnDefinition = "VARCHAR2|病例编号1|20|", length = 20, nullable = true)
	private String no1;

	@Column(name = "NO2", columnDefinition = "VARCHAR2|病例编号2|20|", length = 20, nullable = true)
	private String no2;
	@Item(index =1, code = "NAME", column = "姓名")
	@Column(name = "NAME", columnDefinition = "VARCHAR2|本人姓名|50|", length = 50, nullable = true)
	private String name;

	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别代码|1|", length = 1, nullable = true)
	private String gender;
	@Item(index =2, code = "BIRTHDAY", column = "出生日期", isDate = true)
	@Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
	private Date birthday;
	@Item(index =3, code = "IDCARD", column = "身份证")
	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证件号码|18|", length = 18, nullable = true)
	private String idcard;
	@Item(index =4, code = "PHONE_NUMBER", column = "联系方式")
	@Column(name = "PHONE_NUMBER", columnDefinition = "VARCHAR2|本人电话号码|20|", length = 20, nullable = true)
	private String phoneNumber;

	@Column(name = "FLOAT_POPULATION", columnDefinition = "VARCHAR2|是否流动人口|20|", length = 20, nullable = true)
	private String floatPopulation;

	@Column(name = "HRTOWN_SHIP", columnDefinition = "VARCHAR2|户籍地址-乡(镇、街道办事处)|70|", length = 70, nullable = true)
	private String hrtownShip;

	@Column(name = "HRSTREET", columnDefinition = "VARCHAR2|户籍地址-村(街、路、弄等)|70|", length = 70, nullable = true)
	private String hrstreet;

	@Column(name = "HRHOUSE_NUMBER", columnDefinition = "VARCHAR2|户籍地址-门牌号码|70|", length = 70, nullable = true)
	private String hrhouseNumber;

	@Column(name = "HR_ADDRESS", columnDefinition = "VARCHAR2|户籍住址详细|100|", length = 100, nullable = true)
	private String hrAddress;

	@Column(name = "PATOWN_SHIP", columnDefinition = "VARCHAR2|现住地址-乡(镇、街道办事处)|70|", length = 70, nullable = true)
	private String patownShip;

	@Column(name = "PASTREET", columnDefinition = "VARCHAR2|现住地址地址-村(街、路、弄等)|70|", length = 70, nullable = true)
	private String pastreet;
	@Item(index =5, code = "PAHOUSE_NUMBER", column = "联系地址")
	@Column(name = "PAHOUSE_NUMBER", columnDefinition = "VARCHAR2|现住地址-门牌号码|70|", length = 70, nullable = true)
	private String pahouseNumber;

	@Column(name = "PA_ADDRESS", columnDefinition = "VARCHAR2|现住址详细|100|", length = 100, nullable = true)
	private String paAddress;

	@Column(name = "PARENTS_NAME", columnDefinition = "VARCHAR2|监护人姓名|50|", length = 50, nullable = true)
	private String parentsName;

	@Column(name = "INFECTEDPERSON_OCCUPATION", columnDefinition = "VARCHAR2|职业|3|", length = 3, nullable = true)
	private String infectedpersonOccupation;

	@Column(name = "OCCUPATION_OTHER", columnDefinition = "VARCHAR2|职业-其他|20|", length = 20, nullable = true)
	private String occupationOther;

	@Column(name = "INFECTIOUS_CODE", columnDefinition = "VARCHAR2|传染病名称代码|20|", length = 20, nullable = true)
	private String infectiousCode;

	@Column(name = "INFECTIOUS_NAME", columnDefinition = "VARCHAR2|传染病名称名称|100|", length = 100, nullable = true)
	private String infectiousName;

	@Column(name = "DIAGNOSIS_DATE", columnDefinition = "DATE|诊断日期||", nullable = true)
	private Date diagnosisDate;

	@Column(name = "PATHOGENESIS_DATE", columnDefinition = "DATE|发病日期||", nullable = true)
	private Date pathogenesisDate;

	@Column(name = "FILL_ORGAN_CODE", columnDefinition = "VARCHAR2|填报机构编码|100|", length = 100, nullable = true)
	private String fillOrganCode;
	@Item(index =6, code = "FILL_ORGAN_NAME", column = "上报机构")
	@Column(name = "FILL_ORGAN_NAME", columnDefinition = "VARCHAR2|填报机构名称|100|", length = 100, nullable = true)
	private String fillOrganName;

	@Column(name = "REPORT_DOCTOR_ID", columnDefinition = "VARCHAR2|报告医生ID|100|", length = 100, nullable = true)
	private String reportDoctorId;

	@Column(name = "REPORT_DOCTOR_NAME", columnDefinition = "VARCHAR2|报告医师姓名|50|", length = 50, nullable = true)
	private String reportDoctorName;
	@Item(index =7, code = "FILL_DATE", column = "上报日期" , isDate = true)
	@Column(name = "FILL_DATE", columnDefinition = "DATE|填报日期||", nullable = true)
	private Date fillDate;

	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除状态|1|", length = 1, nullable = true)
	private boolean isDelete;

	@Column(name = "EMESIS_NUM", columnDefinition = "VARCHAR2|呕吐次数|50|", length = 50, nullable = true)
	private String emesisNum;

	@Column(name = "WHOLE_BODY", columnDefinition = "VARCHAR2|全身|100|", length = 100, nullable = true)
	private String wholeBody;

	@Column(name = "TOXICATION", columnDefinition = "VARCHAR2|中毒|100|", length = 100, nullable = true)
	private String toxication;

	@Column(name = "INTESTINAL_INFECTION", columnDefinition = "VARCHAR2|肠道感染|100|", length = 100, nullable = true)
	private String intestinalInfection;

	@Column(name = "LAX_SYMPTOM", columnDefinition = "VARCHAR2|腹泻性状|100|", length = 100, nullable = true)
	private String laxSymptom;

	@Column(name = "LAX_COUNT", columnDefinition = "VARCHAR2|腹泻次数|20|", length = 20, nullable = true)
	private String laxCount;

	@Column(name = "FEVER_TEMP", columnDefinition = "VARCHAR2|发热温度|20|", length = 20, nullable = true)
	private String feverTemp;

	@Column(name = "INFECT", columnDefinition = "VARCHAR2|一般感染|100|", length = 100, nullable = true)
	private String infect;

	@Column(name = "PART_INFECT", columnDefinition = "VARCHAR2|局部感染|100|", length = 100, nullable = true)
	private String partInfect;

	@Column(name = "NERVE_SYMPTOM", columnDefinition = "VARCHAR2|神经症状|100|", length = 100, nullable = true)
	private String nerveSymptom;

	@Column(name = "PUPIL_EXCEPTION", columnDefinition = "VARCHAR2|瞳孔异常|20|", length = 20, nullable = true)
	private String pupilException;

	@Column(name = "SYMPTOM", columnDefinition = "VARCHAR2|首发症状|100|", length = 100, nullable = true)
	private String symptom;

	@Column(name = "SYMPTOM_OTHER", columnDefinition = "VARCHAR2|其他症状|100|", length = 100, nullable = true)
	private String symptomOther;

	@Column(name = "PREVIOUS_HISTORY", columnDefinition = "VARCHAR2|既往史|100|", length = 100, nullable = true)
	private String previousHistory;

	@Column(name = "PREVIOUS_HISTORY_OTHER", columnDefinition = "VARCHAR2|既往史其他|100|", length = 100, nullable = true)
	private String previousHistoryOther;

	@Column(name = "CLINICAL_DIAGNOSIS", columnDefinition = "VARCHAR2|临床初步诊断|100|", length = 100, nullable = true)
	private String clinicalDiagnosis;

	@Column(name = "IN_HOSPITAL", columnDefinition = "VARCHAR2|是否住院|2|", length = 2, nullable = true)
	private String inHospital;

	@Column(name = "ANTIBIOTIC", columnDefinition = "VARCHAR2|是否抗生素|2|", length = 2, nullable = true)
	private String antibiotic;

	@Column(name = "FOOD_CAUSE", columnDefinition = "VARCHAR2|怀疑食物引起|2|", length = 2, nullable = true)
	private String foodCause;

	@Column(name = "FOOD_HISTORY", columnDefinition = "VARCHAR2|饮食史|100|", length = 100, nullable = true)
	private String foodHistory;

	@Column(name = "FOOD_HISTORY_OTHER", columnDefinition = "VARCHAR2|饮食史其他|100|", length = 100, nullable = true)
	private String foodHistoryOther;

	@Column(name = "FOOD1", columnDefinition = "VARCHAR2|食品名称1|100|", length = 100, nullable = true)
	private String food1;

	@Column(name = "ADDRESS1", columnDefinition = "VARCHAR2|场所1|2|", length = 2, nullable = true)
	private String address1;

	@Column(name = "PACK1", columnDefinition = "VARCHAR2|加工或包装方式1|50|", length = 50, nullable = true)
	private String pack1;

	@Column(name = "FOOD_DATE1", columnDefinition = "DATE|进食时间1||", nullable = true)
	private Date foodDate1;

	@Column(name = "FOOD_NUM1", columnDefinition = "VARCHAR2|进食人数1|20|", length = 20, nullable = true)
	private String foodNum1;

	@Column(name = "ATTACK1", columnDefinition = "VARCHAR2|其他人是否发病1|2|", length = 2, nullable = true)
	private String attack1;

	@Column(name = "FOOD2", columnDefinition = "VARCHAR2|食品名称2|100|", length = 100, nullable = true)
	private String food2;

	@Column(name = "ADDRESS2", columnDefinition = "VARCHAR2|场所2|2|", length = 2, nullable = true)
	private String address2;

	@Column(name = "PACK2", columnDefinition = "VARCHAR2|加工或包装方式2|50|", length = 50, nullable = true)
	private String pack2;

	@Column(name = "FOOD_DATE2", columnDefinition = "DATE|进食时间2||", nullable = true)
	private Date foodDate2;

	@Column(name = "FOOD_NUM2", columnDefinition = "VARCHAR2|进食人数2|20|", length = 20, nullable = true)
	private String foodNum2;

	@Column(name = "ATTACK2", columnDefinition = "VARCHAR2|其他人是否发病2|2|", length = 2, nullable = true)
	private String attack2;

	@Column(name = "WEEK_CONDITION", columnDefinition = "VARCHAR2|发病前一周情况|100|", length = 100, nullable = true)
	private String weekCondition;

	@Column(name = "SPECIMEN", columnDefinition = "VARCHAR2|是否标本|2|", length = 2, nullable = true)
	private String specimen;

	@Column(name = "SPECIMEN_TYPE", columnDefinition = "VARCHAR2|标本类型|2|", length = 2, nullable = true)
	private String specimenType;

	@Column(name = "SPECIMENNO1", columnDefinition = "VARCHAR2|标本编号1|20|", length = 20, nullable = true)
	private String specimenno1;

	@Column(name = "SPECIMENNO2", columnDefinition = "VARCHAR2|标本编号2|20|", length = 20, nullable = true)
	private String specimenno2;

	@Column(name = "TEST_ID", columnDefinition = "NUMBER|检验表ID|11|", length = 11, nullable = true)
	private String testId;

	@Column(name = "CREATE_TIME", columnDefinition = "DATE|系统创建时间|", nullable = true)
	private Date createTime;

	@Column(name = "JY_RESULT", columnDefinition = "VARCHAR2|是否录入检验结果0:否1:是|", nullable = true)
	private String jyResult;

	@Column(name = "YEAR", columnDefinition = "NUMBER|年份|4|", length = 4, nullable = true)
	private Integer  year;

	@Column(name = "BACKREASON", columnDefinition = "VARCHAR2|退回原因|200|", length = 200, nullable = true)
	private String  backReason;

	@Column(name = "EATPLACE", columnDefinition = "VARCHAR2|进食地点|200|", length = 200, nullable = true)
	private String  eatPlace;

	@Column(name = "BUYPLACE", columnDefinition = "VARCHAR2|购买地点|200|", length = 200, nullable = true)
	private String  buyPlace;

	@Column(name = "EAT_TOWN_ADDRESS", columnDefinition = "VARCHAR2|进食地点-镇|100|", length = 100, nullable = true)
	private String  eatTownAddress;

	@Column(name = "EAT_VILLAGE_ADDRESS", columnDefinition = "VARCHAR2|进食地点-村委会|100|", length = 100, nullable = true)
	private String  eatVillageAddress;

	@Column(name = "BUY_TOWN_ADDRESS", columnDefinition = "VARCHAR2|购买地点-镇 |100|", length = 100, nullable = true)
	private String  buyTownAddress;

	@Column(name = "BUY_VILLAGE_ADDRESS", columnDefinition = "VARCHAR2|购买地点-村委会|100|", length = 100, nullable = true)
	private String  buyVillageAddress;

	@Transient
	private String genderDesc;

	public String getGenderDesc() {
		return genderDesc;
	}

	public void setGenderDesc(String genderDesc) {
		this.genderDesc = genderDesc;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getJyResult() {
		return jyResult;
	}

	public void setJyResult(String jyResult) {
		this.jyResult = jyResult;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOutpatientNo() {
		return this.outpatientNo;
	}

	public void setOutpatientNo(String outpatientNo) {
		this.outpatientNo = outpatientNo;
	}

	public String getNo1() {
		return this.no1;
	}

	public void setNo1(String no1) {
		this.no1 = no1;
	}

	public String getNo2() {
		return this.no2;
	}

	public void setNo2(String no2) {
		this.no2 = no2;
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

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFloatPopulation() {
		return this.floatPopulation;
	}

	public void setFloatPopulation(String floatPopulation) {
		this.floatPopulation = floatPopulation;
	}

	public String getHrtownShip() {
		return this.hrtownShip;
	}

	public void setHrtownShip(String hrtownShip) {
		this.hrtownShip = hrtownShip;
	}

	public String getHrstreet() {
		return this.hrstreet;
	}

	public void setHrstreet(String hrstreet) {
		this.hrstreet = hrstreet;
	}

	public String getHrhouseNumber() {
		return this.hrhouseNumber;
	}

	public void setHrhouseNumber(String hrhouseNumber) {
		this.hrhouseNumber = hrhouseNumber;
	}

	public String getHrAddress() {
		return this.hrAddress;
	}

	public void setHrAddress(String hrAddress) {
		this.hrAddress = hrAddress;
	}

	public String getPatownShip() {
		return this.patownShip;
	}

	public void setPatownShip(String patownShip) {
		this.patownShip = patownShip;
	}

	public String getPastreet() {
		return this.pastreet;
	}

	public void setPastreet(String pastreet) {
		this.pastreet = pastreet;
	}

	public String getPahouseNumber() {
		return this.pahouseNumber;
	}

	public void setPahouseNumber(String pahouseNumber) {
		this.pahouseNumber = pahouseNumber;
	}

	public String getPaAddress() {
		return this.paAddress;
	}

	public void setPaAddress(String paAddress) {
		this.paAddress = paAddress;
	}

	public String getParentsName() {
		return this.parentsName;
	}

	public void setParentsName(String parentsName) {
		this.parentsName = parentsName;
	}

	public String getInfectedpersonOccupation() {
		return this.infectedpersonOccupation;
	}

	public void setInfectedpersonOccupation(String infectedpersonOccupation) {
		this.infectedpersonOccupation = infectedpersonOccupation;
	}

	public String getOccupationOther() {
		return this.occupationOther;
	}

	public void setOccupationOther(String occupationOther) {
		this.occupationOther = occupationOther;
	}

	public String getInfectiousCode() {
		return this.infectiousCode;
	}

	public void setInfectiousCode(String infectiousCode) {
		this.infectiousCode = infectiousCode;
	}

	public String getInfectiousName() {
		return this.infectiousName;
	}

	public void setInfectiousName(String infectiousName) {
		this.infectiousName = infectiousName;
	}

	public Date getDiagnosisDate() {
		return this.diagnosisDate;
	}

	public void setDiagnosisDate(Date diagnosisDate) {
		this.diagnosisDate = diagnosisDate;
	}

	public Date getPathogenesisDate() {
		return this.pathogenesisDate;
	}

	public void setPathogenesisDate(Date pathogenesisDate) {
		this.pathogenesisDate = pathogenesisDate;
	}

	public String getFillOrganCode() {
		return this.fillOrganCode;
	}

	public void setFillOrganCode(String fillOrganCode) {
		this.fillOrganCode = fillOrganCode;
	}

	public String getFillOrganName() {
		return this.fillOrganName;
	}

	public void setFillOrganName(String fillOrganName) {
		this.fillOrganName = fillOrganName;
	}

	public String getReportDoctorId() {
		return this.reportDoctorId;
	}

	public void setReportDoctorId(String reportDoctorId) {
		this.reportDoctorId = reportDoctorId;
	}

	public String getReportDoctorName() {
		return this.reportDoctorName;
	}

	public void setReportDoctorName(String reportDoctorName) {
		this.reportDoctorName = reportDoctorName;
	}

	public Date getFillDate() {
		return this.fillDate;
	}

	public void setFillDate(Date fillDate) {
		this.fillDate = fillDate;
	}

	public boolean isIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getWholeBody() {
		return this.wholeBody;
	}

	public void setWholeBody(String wholeBody) {
		this.wholeBody = wholeBody;
	}

	public String getToxication() {
		return this.toxication;
	}

	public void setToxication(String toxication) {
		this.toxication = toxication;
	}

	public String getIntestinalInfection() {
		return this.intestinalInfection;
	}

	public void setIntestinalInfection(String intestinalInfection) {
		this.intestinalInfection = intestinalInfection;
	}

	public String getLaxSymptom() {
		return this.laxSymptom;
	}

	public void setLaxSymptom(String laxSymptom) {
		this.laxSymptom = laxSymptom;
	}

	public String getLaxCount() {
		return this.laxCount;
	}

	public void setLaxCount(String laxCount) {
		this.laxCount = laxCount;
	}

	public String getFeverTemp() {
		return this.feverTemp;
	}

	public void setFeverTemp(String feverTemp) {
		this.feverTemp = feverTemp;
	}

	public String getInfect() {
		return this.infect;
	}

	public void setInfect(String infect) {
		this.infect = infect;
	}

	public String getPartInfect() {
		return this.partInfect;
	}

	public void setPartInfect(String partInfect) {
		this.partInfect = partInfect;
	}

	public String getNerveSymptom() {
		return this.nerveSymptom;
	}

	public void setNerveSymptom(String nerveSymptom) {
		this.nerveSymptom = nerveSymptom;
	}

	public String getPupilException() {
		return this.pupilException;
	}

	public void setPupilException(String pupilException) {
		this.pupilException = pupilException;
	}

	public String getSymptom() {
		return this.symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public String getSymptomOther() {
		return this.symptomOther;
	}

	public void setSymptomOther(String symptomOther) {
		this.symptomOther = symptomOther;
	}

	public String getPreviousHistory() {
		return this.previousHistory;
	}

	public void setPreviousHistory(String previousHistory) {
		this.previousHistory = previousHistory;
	}

	public String getPreviousHistoryOther() {
		return this.previousHistoryOther;
	}

	public void setPreviousHistoryOther(String previousHistoryOther) {
		this.previousHistoryOther = previousHistoryOther;
	}

	public String getClinicalDiagnosis() {
		return clinicalDiagnosis==null?"急性胃肠炎":clinicalDiagnosis;
	}

	public void setClinicalDiagnosis(String clinicalDiagnosis) {
		this.clinicalDiagnosis = clinicalDiagnosis;
	}

	public String getInHospital() {
		return this.inHospital;
	}

	public void setInHospital(String inHospital) {
		this.inHospital = inHospital;
	}

	public String getAntibiotic() {
		return this.antibiotic;
	}

	public void setAntibiotic(String antibiotic) {
		this.antibiotic = antibiotic;
	}

	public String getFoodCause() {
		return this.foodCause;
	}

	public void setFoodCause(String foodCause) {
		this.foodCause = foodCause;
	}

	public String getFoodHistory() {
		return this.foodHistory;
	}

	public void setFoodHistory(String foodHistory) {
		this.foodHistory = foodHistory;
	}

	public String getFoodHistoryOther() {
		return this.foodHistoryOther;
	}

	public void setFoodHistoryOther(String foodHistoryOther) {
		this.foodHistoryOther = foodHistoryOther;
	}

	public String getFood1() {
		return this.food1;
	}

	public void setFood1(String food1) {
		this.food1 = food1;
	}

	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public Date getFoodDate1() {
		return this.foodDate1;
	}

	public void setFoodDate1(Date foodDate1) {
		this.foodDate1 = foodDate1;
	}

	public String getFoodNum1() {
		return this.foodNum1;
	}

	public void setFoodNum1(String foodNum1) {
		this.foodNum1 = foodNum1;
	}

	public String getAttack1() {
		return this.attack1;
	}

	public void setAttack1(String attack1) {
		this.attack1 = attack1;
	}

	public String getFood2() {
		return this.food2;
	}

	public void setFood2(String food2) {
		this.food2 = food2;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public Date getFoodDate2() {
		return this.foodDate2;
	}

	public void setFoodDate2(Date foodDate2) {
		this.foodDate2 = foodDate2;
	}

	public String getFoodNum2() {
		return this.foodNum2;
	}

	public void setFoodNum2(String foodNum2) {
		this.foodNum2 = foodNum2;
	}

	public String getAttack2() {
		return this.attack2;
	}

	public void setAttack2(String attack2) {
		this.attack2 = attack2;
	}

	public String getWeekCondition() {
		return this.weekCondition;
	}

	public void setWeekCondition(String weekCondition) {
		this.weekCondition = weekCondition;
	}

	public String getSpecimen() {
		return this.specimen;
	}

	public void setSpecimen(String specimen) {
		this.specimen = specimen;
	}

	public String getSpecimenType() {
		return this.specimenType;
	}

	public void setSpecimenType(String specimenType) {
		this.specimenType = specimenType;
	}

	public String getSpecimenno1() {
		return specimenno1;
	}

	public void setSpecimenno1(String specimenno1) {
		this.specimenno1 = specimenno1;
	}

	public String getSpecimenno2() {
		return specimenno2;
	}

	public void setSpecimenno2(String specimenno2) {
		this.specimenno2 = specimenno2;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean delete) {
		isDelete = delete;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	private String reportRecordId;

	public String getReportRecordId() {
		return reportRecordId;
	}

	public void setReportRecordId(String reportRecordId) {
		this.reportRecordId = reportRecordId;
	}

	public String getPack1() {
		return pack1;
	}

	public void setPack1(String pack1) {
		this.pack1 = pack1;
	}

	public String getPack2() {
		return pack2;
	}

	public void setPack2(String pack2) {
		this.pack2 = pack2;
	}

	public String getBackReason() {
		return backReason;
	}

	public void setBackReason(String backReason) {
		this.backReason = backReason;
	}

	public String getEatPlace() {
		return eatPlace;
	}

	public void setEatPlace(String eatPlace) {
		this.eatPlace = eatPlace;
	}

	public String getBuyPlace() {
		return buyPlace;
	}

	public void setBuyPlace(String buyPlace) {
		this.buyPlace = buyPlace;
	}

	public String getEatVillageAddress() {
		return eatVillageAddress;
	}

	public void setEatVillageAddress(String eatVillageAddress) {
		this.eatVillageAddress = eatVillageAddress;
	}

	public String getEatTownAddress() {
		return eatTownAddress;
	}

	public void setEatTownAddress(String eatTownAddress) {
		this.eatTownAddress = eatTownAddress;
	}

	public String getBuyVillageAddress() {
		return buyVillageAddress;
	}

	public void setBuyVillageAddress(String buyVillageAddress) {
		this.buyVillageAddress = buyVillageAddress;
	}

	public String getBuyTownAddress() {
		return buyTownAddress;
	}

	public void setBuyTownAddress(String buyTownAddress) {
		this.buyTownAddress = buyTownAddress;
	}

	public String getEmesisNum() {
		return emesisNum;
	}

	public void setEmesisNum(String emesisNum) {
		this.emesisNum = emesisNum;
	}

}