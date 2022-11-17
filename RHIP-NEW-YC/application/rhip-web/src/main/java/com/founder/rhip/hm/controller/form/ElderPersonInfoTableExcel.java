package com.founder.rhip.hm.controller.form;

import com.founder.rhip.ehr.service.export.Item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class ElderPersonInfoTableExcel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -567943543341661818L;
	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|标识|11|", length = 11, nullable = false)
	private Long id;
	@Item(index=1,column ="体检日期",isDate=true,datePattern="yyyy/MM/dd")
	private Date examinationDate;
	@Item(index=2,column = "姓名")
	private String name;
	@Item(index=3,column ="性别",isDic=true,dicType="GBT226112003")
	private String gender;
	@Item(index=4,column = "年龄")
	private String age;
	@Item(index=5,column ="联系电话")
	private String phoneNumber;
	@Item(index=6,column ="体温")
	private String temperature;
	@Item(index=7,column ="脉率(次/min)")
	private String pulseRate;
	@Item(index=8,column ="呼吸频率(次/min)")
	private String respiratoryRate;
	@Item(index=9,column ="左侧收缩压(mmHg)")
	private String leftSbp;
	@Item(index=10,column ="左侧舒张压(mmHg)")
	private String leftDbp;
	@Item(index=11,column ="右侧收缩压(mmHg)")
	private String rightSbp;
	@Item(index=12,column ="右侧舒张压(mmHg)")
	private String rightDbp;
	@Item(index=13,column ="身高(cm)")
	private String height;
	@Item(index=14,column ="体重(kg)")
	private String bodyWeight;
	@Item(index=15,column ="腰围(cm)")
	private String waostline;
	@Item(index=16,column ="体质指数(BMI)")
	private String indexOfBodyCharacteristics;
	@Item(index=17,column ="老年人健康状态自我评估",isDic=true,dicType="CV0401013")
	private String healthSelfAssessment;
	@Item(index=18,column ="老年人生活自理能力自我评估",isDic=true,dicType="CV0401014")
	private String lifeAbilitySelfAssessment;
	@Item(index=19,column ="老年人认知功能")
	private String cognitionScreenResult;
	@Item(index=20,column ="老年人情感状态")
	private String emotionScreenResult;
	@Item(index=21,column ="锻炼频率",isDic=true,dicType="FS10208")
	private String trainFrequencyTypeCode;
	@Item(index=22,column ="饮食习惯")
	private String dietaryHabit;
	@Item(index=23,column ="吸烟情况",isDic=true,dicType="CV0300101")
	private String smodeStatusCode;
	@Item(index=24,column ="饮酒情况",isDic=true,dicType="CV0300104" )
	private String drinkFrequency;
	@Item(index=25,column ="血红蛋白值(g/L)")
	private String hemoglobinValue;
	@Item(index=26,column ="白细胞计数值(G/L)")
	private String leukocyteCount;
	@Item(index=27,column ="血小板计数值(G/L)")
	private String plateletCount;
	@Item(index=28,column ="尿蛋白定量检测值(mg/24h)")
	private String urineProQuantitativeValue;
	@Item(index=29,column ="尿糖定量检测值(mmol/L)")
	private String urineSugQuantitativeValue;
	@Item(index=30,column ="尿酮体定量检测值")
	private String ketQuantitativeValue;
	@Item(index=31,column ="尿潜血定量检测值")
	private String eryQuantitativeValue;
	@Item(index=32,column ="空腹血糖左(mg／dL)")
	private String fpgMmol;
	@Item(index=33,column ="空腹血糖右(mg／dL)")
	private String fpgMg;
	@Item(index=34,column ="心电图异常标志")
	private String ecgAnomalyFlag;
	@Item(index=35,column ="尿微量血蛋白(mg/dL)")
	private String urineMicroTongAlbumin;
	@Item(index=36,column ="大便潜血")
	private String fecalOccultBlood;
	@Item(index=37,column ="糖化血红蛋白值(%)")
	private String hgb;
	@Item(index=38,column ="乙型肝炎病毒表面抗原检测结果")
	private String hbsagDetectResult;
	@Item(index=39,column ="血清谷丙转氨酶值(U/L)")
	private String serumGptValue;
	@Item(index=40,column ="血清谷草转氨酶值(U/L)")
	private String serumAstValue;
	@Item(index=41,column ="总胆红素(umol/L)")
	private String totalBilirubin;
	@Item(index=42,column ="血清肌酐值(umol/L)")
	private String creatinine;
	@Item(index=43,column ="血尿素氮检测值(mmol/L)")
	private String bloodUreaNitrogenValue;
	@Item(index=44,column ="总胆固醇(mmol/L)")
	private String tc;
	@Item(index=45,column ="甘油三酯值(mmol/L)")
	private String triglycerideValue;
	@Item(index=46,column ="血清低密度脂蛋白胆固醇检测值(mmol/L)")
	private String ldlcDetectValue;
	@Item(index=47,column ="血清高密度脂蛋自胆固醇检测值(mmol/L)")
	private String hdlcDetectValue;
	@Item(index=48,column ="腹部B超")
	private String bmodeAnomalyfFlag;
	@Item(index=49,column ="脑血管疾病" ,isDic=true,dicType="MH00051")
	private String cvascularFlag;
	@Item(index=50,column ="肾脏疾病" ,isDic=true,dicType="MH00051")
	private String kidneyDiseaseFlag;
	@Item(index=51,column ="心脏疾病" ,isDic=true,dicType="MH00051")
	private String heartDiseaseFlag;
	@Item(index=52,column ="血管疾病" ,isDic=true,dicType="MH00051")
	private String arteryDiseaseFlag;
	@Item(index=53,column ="眼部疾病" ,isDic=true,dicType="MH00051")
	private String eyeDiseasesFlag;
	@Item(index=54,column ="神经系统疾病" ,isDic=true,dicType="MH00051")
	private String nervousDiseasesFlag;
	@Item(index=55,column ="其他系统疾病" ,isDic=true,dicType="MH00051")
	private String healthOther;
	//------------------------
	private String dietHunsuEquilibrium;
	private String dietMeatMain;
	private String dietVegetarian;
	private String dietHalophilic;
	private String dietAddictedOil;
	private String dietSugarCravings;
	private String personId;
	
	
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getDietHunsuEquilibrium() {
		return dietHunsuEquilibrium;
	}
	public void setDietHunsuEquilibrium(String dietHunsuEquilibrium) {
		this.dietHunsuEquilibrium = dietHunsuEquilibrium;
	}
	public String getDietMeatMain() {
		return dietMeatMain;
	}
	public void setDietMeatMain(String dietMeatMain) {
		this.dietMeatMain = dietMeatMain;
	}
	public String getDietVegetarian() {
		return dietVegetarian;
	}
	public void setDietVegetarian(String dietVegetarian) {
		this.dietVegetarian = dietVegetarian;
	}
	public String getDietHalophilic() {
		return dietHalophilic;
	}
	public void setDietHalophilic(String dietHalophilic) {
		this.dietHalophilic = dietHalophilic;
	}
	public String getDietAddictedOil() {
		return dietAddictedOil;
	}
	public void setDietAddictedOil(String dietAddictedOil) {
		this.dietAddictedOil = dietAddictedOil;
	}
	public String getDietSugarCravings() {
		return dietSugarCravings;
	}
	public void setDietSugarCravings(String dietSugarCravings) {
		this.dietSugarCravings = dietSugarCravings;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getExaminationDate() {
		return examinationDate;
	}
	public void setExaminationDate(Date examinationDate) {
		this.examinationDate = examinationDate;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getPulseRate() {
		return pulseRate;
	}
	public void setPulseRate(String pulseRate) {
		this.pulseRate = pulseRate;
	}
	public String getRespiratoryRate() {
		return respiratoryRate;
	}
	public void setRespiratoryRate(String respiratoryRate) {
		this.respiratoryRate = respiratoryRate;
	}
	public String getLeftSbp() {
		return leftSbp;
	}
	public void setLeftSbp(String leftSbp) {
		this.leftSbp = leftSbp;
	}
	public String getLeftDbp() {
		return leftDbp;
	}
	public void setLeftDbp(String leftDbp) {
		this.leftDbp = leftDbp;
	}
	public String getRightSbp() {
		return rightSbp;
	}
	public void setRightSbp(String rightSbp) {
		this.rightSbp = rightSbp;
	}
	public String getRightDbp() {
		return rightDbp;
	}
	public void setRightDbp(String rightDbp) {
		this.rightDbp = rightDbp;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getBodyWeight() {
		return bodyWeight;
	}
	public void setBodyWeight(String bodyWeight) {
		this.bodyWeight = bodyWeight;
	}
	public String getWaostline() {
		return waostline;
	}
	public void setWaostline(String waostline) {
		this.waostline = waostline;
	}
	public String getIndexOfBodyCharacteristics() {
		return indexOfBodyCharacteristics;
	}
	public void setIndexOfBodyCharacteristics(String indexOfBodyCharacteristics) {
		this.indexOfBodyCharacteristics = indexOfBodyCharacteristics;
	}
	public String getHealthSelfAssessment() {
		return healthSelfAssessment;
	}
	public void setHealthSelfAssessment(String healthSelfAssessment) {
		this.healthSelfAssessment = healthSelfAssessment;
	}
	public String getLifeAbilitySelfAssessment() {
		return lifeAbilitySelfAssessment;
	}
	public void setLifeAbilitySelfAssessment(String lifeAbilitySelfAssessment) {
		this.lifeAbilitySelfAssessment = lifeAbilitySelfAssessment;
	}
	public String getCognitionScreenResult() {
		return cognitionScreenResult;
	}
	public void setCognitionScreenResult(String cognitionScreenResult) {
		this.cognitionScreenResult = cognitionScreenResult;
	}
	public String getEmotionScreenResult() {
		return emotionScreenResult;
	}
	public void setEmotionScreenResult(String emotionScreenResult) {
		this.emotionScreenResult = emotionScreenResult;
	}
	public String getTrainFrequencyTypeCode() {
		return trainFrequencyTypeCode;
	}
	public void setTrainFrequencyTypeCode(String trainFrequencyTypeCode) {
		this.trainFrequencyTypeCode = trainFrequencyTypeCode;
	}
	public String getDietaryHabit() {
		return dietaryHabit;
	}
	public void setDietaryHabit(String dietaryHabit) {
		this.dietaryHabit = dietaryHabit;
	}
	
	public String getSmodeStatusCode() {
		return smodeStatusCode;
	}
	public void setSmodeStatusCode(String smodeStatusCode) {
		this.smodeStatusCode = smodeStatusCode;
	}
	public String getDrinkFrequency() {
		return drinkFrequency;
	}
	public void setDrinkFrequency(String drinkFrequency) {
		this.drinkFrequency = drinkFrequency;
	}
	public String getHemoglobinValue() {
		return hemoglobinValue;
	}
	public void setHemoglobinValue(String hemoglobinValue) {
		this.hemoglobinValue = hemoglobinValue;
	}
	public String getLeukocyteCount() {
		return leukocyteCount;
	}
	public void setLeukocyteCount(String leukocyteCount) {
		this.leukocyteCount = leukocyteCount;
	}
	public String getPlateletCount() {
		return plateletCount;
	}
	public void setPlateletCount(String plateletCount) {
		this.plateletCount = plateletCount;
	}
	public String getUrineProQuantitativeValue() {
		return urineProQuantitativeValue;
	}
	public void setUrineProQuantitativeValue(String urineProQuantitativeValue) {
		this.urineProQuantitativeValue = urineProQuantitativeValue;
	}
	public String getUrineSugQuantitativeValue() {
		return urineSugQuantitativeValue;
	}
	public void setUrineSugQuantitativeValue(String urineSugQuantitativeValue) {
		this.urineSugQuantitativeValue = urineSugQuantitativeValue;
	}
	public String getKetQuantitativeValue() {
		return ketQuantitativeValue;
	}
	public void setKetQuantitativeValue(String ketQuantitativeValue) {
		this.ketQuantitativeValue = ketQuantitativeValue;
	}
	public String getEryQuantitativeValue() {
		return eryQuantitativeValue;
	}
	public void setEryQuantitativeValue(String eryQuantitativeValue) {
		this.eryQuantitativeValue = eryQuantitativeValue;
	}
	public String getFpgMmol() {
		return fpgMmol;
	}
	public void setFpgMmol(String fpgMmol) {
		this.fpgMmol = fpgMmol;
	}
	public String getFpgMg() {
		return fpgMg;
	}
	public void setFpgMg(String fpgMg) {
		this.fpgMg = fpgMg;
	}
	public String getEcgAnomalyFlag() {
		return ecgAnomalyFlag;
	}
	public void setEcgAnomalyFlag(String ecgAnomalyFlag) {
		this.ecgAnomalyFlag = ecgAnomalyFlag;
	}
	public String getUrineMicroTongAlbumin() {
		return urineMicroTongAlbumin;
	}
	public void setUrineMicroTongAlbumin(String urineMicroTongAlbumin) {
		this.urineMicroTongAlbumin = urineMicroTongAlbumin;
	}
	public String getFecalOccultBlood() {
		return fecalOccultBlood;
	}
	public void setFecalOccultBlood(String fecalOccultBlood) {
		this.fecalOccultBlood = fecalOccultBlood;
	}
	public String getHgb() {
		return hgb;
	}
	public void setHgb(String hgb) {
		this.hgb = hgb;
	}
	public String getHbsagDetectResult() {
		return hbsagDetectResult;
	}
	public void setHbsagDetectResult(String hbsagDetectResult) {
		this.hbsagDetectResult = hbsagDetectResult;
	}
	public String getSerumGptValue() {
		return serumGptValue;
	}
	public void setSerumGptValue(String serumGptValue) {
		this.serumGptValue = serumGptValue;
	}
	public String getSerumAstValue() {
		return serumAstValue;
	}
	public void setSerumAstValue(String serumAstValue) {
		this.serumAstValue = serumAstValue;
	}
	public String getTotalBilirubin() {
		return totalBilirubin;
	}
	public void setTotalBilirubin(String totalBilirubin) {
		this.totalBilirubin = totalBilirubin;
	}
	public String getCreatinine() {
		return creatinine;
	}
	public void setCreatinine(String creatinine) {
		this.creatinine = creatinine;
	}
	public String getBloodUreaNitrogenValue() {
		return bloodUreaNitrogenValue;
	}
	public void setBloodUreaNitrogenValue(String bloodUreaNitrogenValue) {
		this.bloodUreaNitrogenValue = bloodUreaNitrogenValue;
	}
	public String getTc() {
		return tc;
	}
	public void setTc(String tc) {
		this.tc = tc;
	}
	public String getTriglycerideValue() {
		return triglycerideValue;
	}
	public void setTriglycerideValue(String triglycerideValue) {
		this.triglycerideValue = triglycerideValue;
	}
	public String getLdlcDetectValue() {
		return ldlcDetectValue;
	}
	public void setLdlcDetectValue(String ldlcDetectValue) {
		this.ldlcDetectValue = ldlcDetectValue;
	}
	public String getHdlcDetectValue() {
		return hdlcDetectValue;
	}
	public void setHdlcDetectValue(String hdlcDetectValue) {
		this.hdlcDetectValue = hdlcDetectValue;
	}
	public String getBmodeAnomalyfFlag() {
		return bmodeAnomalyfFlag;
	}
	public void setBmodeAnomalyfFlag(String bmodeAnomalyfFlag) {
		this.bmodeAnomalyfFlag = bmodeAnomalyfFlag;
	}
	public String getCvascularFlag() {
		return cvascularFlag;
	}
	public void setCvascularFlag(String cvascularFlag) {
		this.cvascularFlag = cvascularFlag;
	}
	public String getKidneyDiseaseFlag() {
		return kidneyDiseaseFlag;
	}
	public void setKidneyDiseaseFlag(String kidneyDiseaseFlag) {
		this.kidneyDiseaseFlag = kidneyDiseaseFlag;
	}
	public String getHeartDiseaseFlag() {
		return heartDiseaseFlag;
	}
	public void setHeartDiseaseFlag(String heartDiseaseFlag) {
		this.heartDiseaseFlag = heartDiseaseFlag;
	}
	public String getArteryDiseaseFlag() {
		return arteryDiseaseFlag;
	}
	public void setArteryDiseaseFlag(String arteryDiseaseFlag) {
		this.arteryDiseaseFlag = arteryDiseaseFlag;
	}
	public String getEyeDiseasesFlag() {
		return eyeDiseasesFlag;
	}
	public void setEyeDiseasesFlag(String eyeDiseasesFlag) {
		this.eyeDiseasesFlag = eyeDiseasesFlag;
	}
	public String getNervousDiseasesFlag() {
		return nervousDiseasesFlag;
	}
	public void setNervousDiseasesFlag(String nervousDiseasesFlag) {
		this.nervousDiseasesFlag = nervousDiseasesFlag;
	}
	public String getHealthOther() {
		return healthOther;
	}
	public void setHealthOther(String healthOther) {
		this.healthOther = healthOther;
	}
	
	

}
