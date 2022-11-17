package com.founder.rhip.im.entity.medical;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="RD_MEDICAL_QUALITY")
public class RdMedicalQuality implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID",columnDefinition="NUMBER|业务主键|11|",length=11,nullable=false)
	private Long id;

	@Column(name="ORGAN_CODE",columnDefinition="VARCHAR2|机构代码|20|",length=20,nullable=true)
	private String organCode;

	@Column(name="ORGAN_NAME",columnDefinition="VARCHAR2|机构名称|100|",length=100,nullable=true)
	private String organName;

	@Column(name="GB_CODE",columnDefinition="VARCHAR2|镇—行政区划代码|20|",length=20,nullable=true)
	private String gbCode;

	@Column(name="CENTER_CODE",columnDefinition="VARCHAR2|中心—行政区划代码|20|",length=20,nullable=true)
	private String centerCode;

	@Column(name="GENRE_CODE",columnDefinition="VARCHAR2|机构类型|50|",length=50,nullable=true)
	private String genreCode;

	@Column(name="YEAR_MONTH",columnDefinition="DATE|日期—格式YYYY-MM||",nullable=true)
	private Date yearMonth;

	@Column(name="YEAR",columnDefinition="NUMBER|年度|4|",length=4,nullable=true)
	private Integer year;

	@Column(name="HALF_YEAR",columnDefinition="NUMBER|半年|1|",length=1,nullable=true)
	private Integer halfYear;

	@Column(name="QUARTER",columnDefinition="NUMBER|季度|1|",length=1,nullable=true)
	private Integer quarter;

	@Column(name="MONTH",columnDefinition="NUMBER|月度|2|",length=2,nullable=true)
	private Integer month;

	@Column(name="REPORT_TYPE",columnDefinition="NUMBER|报表类型（1：日报；2：月报）|2|",length=2,nullable=true)
	private Integer reportType;

	@Column(name="EMERGENCY_DEATH_NUM",columnDefinition="NUMBER|急诊死亡人数|12|",length=12,nullable=true)
	private Integer emergencyDeathNum;

	@Column(name="EMERGENCY_MORTALITY",columnDefinition="NUMBER|急诊死亡率||",length=12,scale=12,precision=2,nullable=true)
	private double emergencyMortality;

	@Column(name="OBSERVATION_DEATH_NUM",columnDefinition="NUMBER|观察室死亡人数|12|",length=12,nullable=true)
	private Integer observationDeathNum;

	@Column(name="OBSERVATION_MORTALITY",columnDefinition="NUMBER|观察室死亡率||",length=12,scale=12,precision=2,nullable=true)
	private double observationMortality;

	@Column(name="INHOSPITAL_MORTALITY",columnDefinition="NUMBER|住院死亡率||",length=12,scale=12,precision=2,nullable=true)
	private double inhospitalMortality;

	@Column(name="DIA_ACCORDANCE_NUM",columnDefinition="NUMBER|入院与出院诊断符合人数|12|",length=12,nullable=true)
	private Integer diaAccordanceNum;

	@Column(name="DIA_NO_ACCORDANCE_NUM",columnDefinition="NUMBER|入院与出院诊断不符合人数|12|",length=12,nullable=true)
	private Integer diaNoAccordanceNum;

	@Column(name="DIA_ACCORDANCE_RATE",columnDefinition="NUMBER|入院与出院诊断符合率||",length=12,scale=12,precision=2,nullable=true)
	private double diaAccordanceRate;

	@Column(name="CLI_PATH_DIA_NUM",columnDefinition="NUMBER|病理检查与临床诊断符合人数|12|",length=12,nullable=true)
	private Integer cliPathDiaNum;

	@Column(name="PATH_EXAM_NUM",columnDefinition="NUMBER|病理检查人数|12|",length=12,nullable=true)
	private Integer pathExamNum;

	@Column(name="CLI_PATH_DIA_RATE",columnDefinition="NUMBER|临床与病理诊断符合率||",length=12,scale=12,precision=2,nullable=true)
	private double cliPathDiaRate;

	@Column(name="GRADE_HEALING_FIR_NUM",columnDefinition="NUMBER|无菌手术甲级愈合例数|12|",length=12,nullable=true)
	private Integer gradeHealingFirNum;

	@Column(name="GRADE_HEALING_NUM",columnDefinition="NUMBER|无菌手术愈合例数|12|",length=12,nullable=true)
	private Integer gradeHealingNum;

	@Column(name="GRADE_HEALING_RATE",columnDefinition="NUMBER|无菌手术甲级愈合率||",length=12,scale=12,precision=2,nullable=true)
	private double gradeHealingRate;

	@Column(name="GRADE_HEALING_THR_NUM",columnDefinition="NUMBER|无菌手术丙级愈合例数|12|",length=12,nullable=true)
	private Integer gradeHealingThrNum;

	@Column(name="INFECTION_RATE",columnDefinition="NUMBER|无菌手术感染率||",length=12,scale=12,precision=2,nullable=true)
	private double infectionRate;

	@Column(name="ANTIBIOTIC_PRE_SCALE",columnDefinition="NUMBER|抗生素处方所占比重||",length=12,scale=12,precision=2,nullable=true)
	private double antibioticPreScale;

	@Column(name="CHN_MED_PRE_SCALE",columnDefinition="NUMBER|中医处方所占比重||",length=12,scale=12,precision=2,nullable=true)
	private double chnMedPreScale;

	@Column(name="DRUG_REACTION_NUM",columnDefinition="NUMBER|药物不良反应报告例数|12|",length=12,nullable=true)
	private Integer drugReactionNum;

	@Column(name="MEDICAL_DISPUTES_NUM",columnDefinition="NUMBER|医疗纠纷例数|12|",length=12,nullable=true)
	private Integer medicalDisputesNum;

	@Column(name="MEDICAL_ACCIDENTS_NUM",columnDefinition="NUMBER|医疗事故例数|12|",length=12,nullable=true)
	private Integer medicalAccidentsNum;

	@Column(name="FOUR_TYPES_SCALE",columnDefinition="NUMBER|四类手术占比||",length=12,scale=12,precision=2,nullable=true)
	private double fourTypesScale;

	@Column(name="CLINICAL_USE_BLOOD",columnDefinition="NUMBER|临床用血总量||",length=12,scale=12,precision=2,nullable=true)
	private double clinicalUseBlood;

	@Column(name="BLOOD_NUM",columnDefinition="NUMBER|全血量||",length=12,scale=12,precision=2,nullable=true)
	private double bloodNum;

	@Column(name="RED_CELL",columnDefinition="NUMBER|红细胞量||",length=12,scale=12,precision=2,nullable=true)
	private double redCell;

	@Column(name="PLASMA",columnDefinition="NUMBER|血浆量||",length=12,scale=12,precision=2,nullable=true)
	private double plasma;

	@Column(name="PLATELET",columnDefinition="NUMBER|血小板量||",length=12,scale=12,precision=2,nullable=true)
	private double platelet;

	@Column(name="CREATE_DATE",columnDefinition="TIMESTAMP|创建时间||",nullable=true)
	private Date createDate;

	@Column(name="UPDATE_DATE",columnDefinition="TIMESTAMP|更新时间||",nullable=true)
	private Date updateDate;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrganCode() {
		return this.organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getOrganName() {
		return this.organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public String getGbCode() {
		return this.gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	public String getCenterCode() {
		return this.centerCode;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}

	public String getGenreCode() {
		return this.genreCode;
	}

	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}

	public Date getYearMonth() {
		return this.yearMonth;
	}

	public void setYearMonth(Date yearMonth) {
		this.yearMonth = yearMonth;
	}

	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getHalfYear() {
		return this.halfYear;
	}

	public void setHalfYear(Integer halfYear) {
		this.halfYear = halfYear;
	}

	public Integer getQuarter() {
		return this.quarter;
	}

	public void setQuarter(Integer quarter) {
		this.quarter = quarter;
	}

	public Integer getMonth() {
		return this.month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getReportType() {
		return this.reportType;
	}

	public void setReportType(Integer reportType) {
		this.reportType = reportType;
	}

	public Integer getEmergencyDeathNum() {
		return this.emergencyDeathNum;
	}

	public void setEmergencyDeathNum(Integer emergencyDeathNum) {
		this.emergencyDeathNum = emergencyDeathNum;
	}

	public double getEmergencyMortality() {
		return this.emergencyMortality;
	}

	public void setEmergencyMortality(double emergencyMortality) {
		this.emergencyMortality = emergencyMortality;
	}

	public Integer getObservationDeathNum() {
		return this.observationDeathNum;
	}

	public void setObservationDeathNum(Integer observationDeathNum) {
		this.observationDeathNum = observationDeathNum;
	}

	public double getObservationMortality() {
		return this.observationMortality;
	}

	public void setObservationMortality(double observationMortality) {
		this.observationMortality = observationMortality;
	}

	public double getInhospitalMortality() {
		return this.inhospitalMortality;
	}

	public void setInhospitalMortality(double inhospitalMortality) {
		this.inhospitalMortality = inhospitalMortality;
	}

	public Integer getDiaAccordanceNum() {
		return this.diaAccordanceNum;
	}

	public void setDiaAccordanceNum(Integer diaAccordanceNum) {
		this.diaAccordanceNum = diaAccordanceNum;
	}

	public Integer getDiaNoAccordanceNum() {
		return this.diaNoAccordanceNum;
	}

	public void setDiaNoAccordanceNum(Integer diaNoAccordanceNum) {
		this.diaNoAccordanceNum = diaNoAccordanceNum;
	}

	public double getDiaAccordanceRate() {
		return this.diaAccordanceRate;
	}

	public void setDiaAccordanceRate(double diaAccordanceRate) {
		this.diaAccordanceRate = diaAccordanceRate;
	}

	public Integer getCliPathDiaNum() {
		return this.cliPathDiaNum;
	}

	public void setCliPathDiaNum(Integer cliPathDiaNum) {
		this.cliPathDiaNum = cliPathDiaNum;
	}

	public Integer getPathExamNum() {
		return this.pathExamNum;
	}

	public void setPathExamNum(Integer pathExamNum) {
		this.pathExamNum = pathExamNum;
	}

	public double getCliPathDiaRate() {
		return this.cliPathDiaRate;
	}

	public void setCliPathDiaRate(double cliPathDiaRate) {
		this.cliPathDiaRate = cliPathDiaRate;
	}

	public Integer getGradeHealingFirNum() {
		return this.gradeHealingFirNum;
	}

	public void setGradeHealingFirNum(Integer gradeHealingFirNum) {
		this.gradeHealingFirNum = gradeHealingFirNum;
	}

	public Integer getGradeHealingNum() {
		return this.gradeHealingNum;
	}

	public void setGradeHealingNum(Integer gradeHealingNum) {
		this.gradeHealingNum = gradeHealingNum;
	}

	public double getGradeHealingRate() {
		return this.gradeHealingRate;
	}

	public void setGradeHealingRate(double gradeHealingRate) {
		this.gradeHealingRate = gradeHealingRate;
	}

	public Integer getGradeHealingThrNum() {
		return this.gradeHealingThrNum;
	}

	public void setGradeHealingThrNum(Integer gradeHealingThrNum) {
		this.gradeHealingThrNum = gradeHealingThrNum;
	}

	public double getInfectionRate() {
		return this.infectionRate;
	}

	public void setInfectionRate(double infectionRate) {
		this.infectionRate = infectionRate;
	}

	public double getAntibioticPreScale() {
		return this.antibioticPreScale;
	}

	public void setAntibioticPreScale(double antibioticPreScale) {
		this.antibioticPreScale = antibioticPreScale;
	}

	public double getChnMedPreScale() {
		return this.chnMedPreScale;
	}

	public void setChnMedPreScale(double chnMedPreScale) {
		this.chnMedPreScale = chnMedPreScale;
	}

	public Integer getDrugReactionNum() {
		return this.drugReactionNum;
	}

	public void setDrugReactionNum(Integer drugReactionNum) {
		this.drugReactionNum = drugReactionNum;
	}

	public Integer getMedicalDisputesNum() {
		return this.medicalDisputesNum;
	}

	public void setMedicalDisputesNum(Integer medicalDisputesNum) {
		this.medicalDisputesNum = medicalDisputesNum;
	}

	public Integer getMedicalAccidentsNum() {
		return this.medicalAccidentsNum;
	}

	public void setMedicalAccidentsNum(Integer medicalAccidentsNum) {
		this.medicalAccidentsNum = medicalAccidentsNum;
	}

	public double getFourTypesScale() {
		return this.fourTypesScale;
	}

	public void setFourTypesScale(double fourTypesScale) {
		this.fourTypesScale = fourTypesScale;
	}

	public double getClinicalUseBlood() {
		return this.clinicalUseBlood;
	}

	public void setClinicalUseBlood(double clinicalUseBlood) {
		this.clinicalUseBlood = clinicalUseBlood;
	}

	public double getBloodNum() {
		return this.bloodNum;
	}

	public void setBloodNum(double bloodNum) {
		this.bloodNum = bloodNum;
	}

	public double getRedCell() {
		return this.redCell;
	}

	public void setRedCell(double redCell) {
		this.redCell = redCell;
	}

	public double getPlasma() {
		return this.plasma;
	}

	public void setPlasma(double plasma) {
		this.plasma = plasma;
	}

	public double getPlatelet() {
		return this.platelet;
	}

	public void setPlatelet(double platelet) {
		this.platelet = platelet;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}