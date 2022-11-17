package com.founder.rhip.im.entity.medical;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Date;
import java.math.BigDecimal;

@Entity
@Table(name="RD_OUTPATIENT_COMPOSITIVE")
@XmlRootElement
public class RdOutpatientCompositive implements Serializable {

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

	@Column(name="OUTPATIENT_INCOME",columnDefinition="NUMBER|门诊收入||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal outpatientIncome;

	@Column(name="MEDICAL_INSURANCE_COST",columnDefinition="NUMBER|医保支付费用||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal medicalInsuranceCost;

	@Column(name="OWN_EXPENSES",columnDefinition="NUMBER|个人承担费用||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal ownExpenses;

	@Column(name="AVG_MEDICAL_FEE",columnDefinition="NUMBER|门诊病人次均医疗费用||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal avgMedicalFee;

	@Column(name="AVG_DRUG_COST",columnDefinition="NUMBER|门诊病人次均药费||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal avgDrugCost;

	@Column(name="VISIT_DOCTORS_NUM",columnDefinition="NUMBER|出诊医生总人数|12|",length=12,nullable=true)
	private Integer visitDoctorsNum;

	@Column(name="TOTAL_DOCTORS_NUM",columnDefinition="NUMBER|医生号源总数|12|",length=12,nullable=true)
	private Integer totalDoctorsNum;

	@Column(name="BESPOKE_REG_NUM",columnDefinition="NUMBER|预约挂号开放数|12|",length=12,nullable=true)
	private Integer bespokeRegNum;

	@Column(name="AVG_OUTPATIENT_NUM",columnDefinition="NUMBER|医生平均门急诊量||",length=12,scale=12,precision=2,nullable=true)
	private double avgOutpatientNum;

	@Column(name="TOTAL_CLINIC_NUM",columnDefinition="NUMBER|总诊疗人次数|12|",length=12,nullable=true)
	private Integer totalClinicNum;

	@Column(name="OUTPATIENT_CLINIC_NUM",columnDefinition="NUMBER|门诊人次数|12|",length=12,nullable=true)
	private Integer outpatientClinicNum;

	@Column(name="EME_CLINIC_NUM",columnDefinition="NUMBER|急诊人次数|12|",length=12,nullable=true)
	private Integer emeClinicNum;

	@Column(name="BESPOKE_CLINIC_NUM",columnDefinition="NUMBER|预约诊疗人次数|12|",length=12,nullable=true)
	private Integer bespokeClinicNum;

	@Column(name="CHECK_NUM",columnDefinition="NUMBER|健康检查人次数|12|",length=12,nullable=true)
	private Integer checkNum;

	@Column(name="PRESCRIBEN_NUM",columnDefinition="NUMBER|处方数量|12|",length=12,nullable=true)
	private Integer prescribenNum;

	@Column(name="PRESCRIBE_AMOUNT",columnDefinition="NUMBER|处方总额||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal prescribeAmount;

	@Column(name="ANTIMICROBIAL_PRE_NUM",columnDefinition="NUMBER|抗菌药物处方数|12|",length=12,nullable=true)
	private Integer antimicrobialPreNum;

	@Column(name="DRIP_PRESCRIBE_NUM",columnDefinition="NUMBER|输液处方数|12|",length=12,nullable=true)
	private Integer dripPrescribeNum;

	@Column(name="TRA_CHN_PRESCRIBE_NUM",columnDefinition="NUMBER|中医处方数|12|",length=12,nullable=true)
	private Integer traChnPrescribeNum;

	@Column(name="AVG_PRESCRIBE_NUM",columnDefinition="NUMBER|医生平均处方数量||",length=12,scale=12,precision=2,nullable=true)
	private double avgPrescribeNum;

	@Column(name="AVG_CLINIC_NUM",columnDefinition="NUMBER|医师日均担负诊疗人次||",length=12,scale=12,precision=2,nullable=true)
	private double avgClinicNum;

	@Column(name="PER_PRESCRIBE_COST",columnDefinition="NUMBER|人均处方金额||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal perPrescribeCost;

	@Column(name="AVG_PRESCRIBE_COST",columnDefinition="NUMBER|平均处方金额||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal avgPrescribeCost;

	@Column(name="OWN_PRESCRIBE_COST",columnDefinition="NUMBER|自费最大处方||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal ownPrescribeCost;

	@Column(name="OTHER_PRESCRIBE_COST",columnDefinition="NUMBER|其它最大处方||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal otherPrescribeCost;

	@Column(name="DRUG_INCOME",columnDefinition="NUMBER|门诊药品收入||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal drugIncome;

	@Column(name="DRUG_INCOME_SCALE",columnDefinition="NUMBER|门诊药品收入比例||",length=12,scale=12,precision=2,nullable=true)
	private double drugIncomeScale;

	@Column(name="OTHER_DRUG_AMOUNT",columnDefinition="NUMBER|其它病人药品收入||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal otherDrugAmount;

	@Column(name="OTHER_DRUG_SCALE",columnDefinition="NUMBER|其它病人药品收入比例||",length=12,scale=12,precision=2,nullable=true)
	private double otherDrugScale;

	@Column(name="OWN_DRUG_AMOUNT",columnDefinition="NUMBER|自费病人药品收入||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal ownDrugAmount;

	@Column(name="OWN_DRUG_SCALE",columnDefinition="NUMBER|自费病人药品收入比例||",length=12,scale=12,precision=2,nullable=true)
	private double ownDrugScale;

	@Column(name="MED_AMOUNT",columnDefinition="NUMBER|门诊医疗收入||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal medAmount;

	@Column(name="MED_AMOUNT_SCALE",columnDefinition="NUMBER|门诊医疗收入比例||",length=12,scale=12,precision=2,nullable=true)
	private double medAmountScale;

	@Column(name="OTHER_MED_AMOUNT",columnDefinition="NUMBER|其它病人医疗收入||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal otherMedAmount;

	@Column(name="OTHER_MED_SCALE",columnDefinition="NUMBER|其它病人医疗收入比例||",length=12,scale=12,precision=2,nullable=true)
	private double otherMedScale;

	@Column(name="OWN_MED_AMOUNT",columnDefinition="NUMBER|自费病人医疗收入||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal ownMedAmount;

	@Column(name="OWN_MED_SCALE",columnDefinition="NUMBER|自费病人医疗收入比例||",length=12,scale=12,precision=2,nullable=true)
	private double ownMedScale;
	
	@Column(name="REGISTRATION_NUM",columnDefinition="NUMBER|挂号人次数|12|",length=12,nullable=true)
	private Integer registrationNum;
	
	@Column(name="OBSERVING_NUM",columnDefinition="NUMBER|留观人次数|12|",length=12,nullable=true)
	private Integer observingNum;
	
	@Column(name="VISIT_NUM",columnDefinition="NUMBER|已就诊人数|12|",length=12,nullable=true)
	private Integer visitNum;
	
	@Column(name="NON_ATTEND_NUM",columnDefinition="NUMBER|已退号人数|12|",length=12,nullable=true)
	private Integer nonAttendNum;

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

	@XmlElement
	public String getOrganCode() {
		return this.organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	@XmlElement
	public String getOrganName() {
		return this.organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	@XmlElement
	public String getGbCode() {
		return this.gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	@XmlElement
	public String getCenterCode() {
		return this.centerCode;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}

	@XmlElement
	public String getGenreCode() {
		return this.genreCode;
	}

	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}

	@XmlElement
	public Date getYearMonth() {
		return this.yearMonth;
	}

	public void setYearMonth(Date yearMonth) {
		this.yearMonth = yearMonth;
	}

	@XmlElement
	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@XmlElement
	public Integer getHalfYear() {
		return this.halfYear;
	}

	public void setHalfYear(Integer halfYear) {
		this.halfYear = halfYear;
	}

	@XmlElement
	public Integer getQuarter() {
		return this.quarter;
	}

	public void setQuarter(Integer quarter) {
		this.quarter = quarter;
	}

	@XmlElement
	public Integer getMonth() {
		return this.month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	@XmlElement
	public Integer getReportType() {
		return this.reportType;
	}

	public void setReportType(Integer reportType) {
		this.reportType = reportType;
	}

	@XmlElement
	public BigDecimal getOutpatientIncome() {
		return this.outpatientIncome;
	}

	public void setOutpatientIncome(BigDecimal outpatientIncome) {
		this.outpatientIncome = outpatientIncome;
	}

	@XmlElement
	public BigDecimal getMedicalInsuranceCost() {
		return this.medicalInsuranceCost;
	}

	public void setMedicalInsuranceCost(BigDecimal medicalInsuranceCost) {
		this.medicalInsuranceCost = medicalInsuranceCost;
	}

	@XmlElement
	public BigDecimal getOwnExpenses() {
		return this.ownExpenses;
	}

	public void setOwnExpenses(BigDecimal ownExpenses) {
		this.ownExpenses = ownExpenses;
	}

	@XmlElement
	public BigDecimal getAvgMedicalFee() {
		return this.avgMedicalFee;
	}

	public void setAvgMedicalFee(BigDecimal avgMedicalFee) {
		this.avgMedicalFee = avgMedicalFee;
	}

	@XmlElement
	public BigDecimal getAvgDrugCost() {
		return this.avgDrugCost;
	}

	public void setAvgDrugCost(BigDecimal avgDrugCost) {
		this.avgDrugCost = avgDrugCost;
	}

	@XmlElement
	public Integer getVisitDoctorsNum() {
		return this.visitDoctorsNum;
	}

	public void setVisitDoctorsNum(Integer visitDoctorsNum) {
		this.visitDoctorsNum = visitDoctorsNum;
	}

	@XmlElement
	public Integer getTotalDoctorsNum() {
		return this.totalDoctorsNum;
	}

	public void setTotalDoctorsNum(Integer totalDoctorsNum) {
		this.totalDoctorsNum = totalDoctorsNum;
	}

	@XmlElement
	public Integer getBespokeRegNum() {
		return this.bespokeRegNum;
	}

	public void setBespokeRegNum(Integer bespokeRegNum) {
		this.bespokeRegNum = bespokeRegNum;
	}

	@XmlElement
	public double getAvgOutpatientNum() {
		return this.avgOutpatientNum;
	}

	public void setAvgOutpatientNum(double avgOutpatientNum) {
		this.avgOutpatientNum = avgOutpatientNum;
	}

	@XmlElement
	public Integer getTotalClinicNum() {
		return this.totalClinicNum;
	}

	public void setTotalClinicNum(Integer totalClinicNum) {
		this.totalClinicNum = totalClinicNum;
	}

	@XmlElement
	public Integer getOutpatientClinicNum() {
		return this.outpatientClinicNum;
	}

	public void setOutpatientClinicNum(Integer outpatientClinicNum) {
		this.outpatientClinicNum = outpatientClinicNum;
	}

	@XmlElement
	public Integer getEmeClinicNum() {
		return this.emeClinicNum;
	}

	public void setEmeClinicNum(Integer emeClinicNum) {
		this.emeClinicNum = emeClinicNum;
	}

	@XmlElement
	public Integer getBespokeClinicNum() {
		return this.bespokeClinicNum;
	}

	public void setBespokeClinicNum(Integer bespokeClinicNum) {
		this.bespokeClinicNum = bespokeClinicNum;
	}

	@XmlElement
	public Integer getCheckNum() {
		return this.checkNum;
	}

	public void setCheckNum(Integer checkNum) {
		this.checkNum = checkNum;
	}

	@XmlElement
	public Integer getPrescribenNum() {
		return this.prescribenNum;
	}

	public void setPrescribenNum(Integer prescribenNum) {
		this.prescribenNum = prescribenNum;
	}

	@XmlElement
	public BigDecimal getPrescribeAmount() {
		return this.prescribeAmount;
	}

	public void setPrescribeAmount(BigDecimal prescribeAmount) {
		this.prescribeAmount = prescribeAmount;
	}

	@XmlElement
	public Integer getAntimicrobialPreNum() {
		return this.antimicrobialPreNum;
	}

	public void setAntimicrobialPreNum(Integer antimicrobialPreNum) {
		this.antimicrobialPreNum = antimicrobialPreNum;
	}

	@XmlElement
	public Integer getDripPrescribeNum() {
		return this.dripPrescribeNum;
	}

	public void setDripPrescribeNum(Integer dripPrescribeNum) {
		this.dripPrescribeNum = dripPrescribeNum;
	}

	@XmlElement
	public Integer getTraChnPrescribeNum() {
		return this.traChnPrescribeNum;
	}

	public void setTraChnPrescribeNum(Integer traChnPrescribeNum) {
		this.traChnPrescribeNum = traChnPrescribeNum;
	}

	@XmlElement
	public double getAvgPrescribeNum() {
		return this.avgPrescribeNum;
	}

	public void setAvgPrescribeNum(double avgPrescribeNum) {
		this.avgPrescribeNum = avgPrescribeNum;
	}

	@XmlElement
	public double getAvgClinicNum() {
		return this.avgClinicNum;
	}

	public void setAvgClinicNum(double avgClinicNum) {
		this.avgClinicNum = avgClinicNum;
	}

	@XmlElement
	public BigDecimal getPerPrescribeCost() {
		return this.perPrescribeCost;
	}

	public void setPerPrescribeCost(BigDecimal perPrescribeCost) {
		this.perPrescribeCost = perPrescribeCost;
	}

	@XmlElement
	public BigDecimal getAvgPrescribeCost() {
		return this.avgPrescribeCost;
	}

	public void setAvgPrescribeCost(BigDecimal avgPrescribeCost) {
		this.avgPrescribeCost = avgPrescribeCost;
	}

	@XmlElement
	public BigDecimal getOwnPrescribeCost() {
		return this.ownPrescribeCost;
	}

	public void setOwnPrescribeCost(BigDecimal ownPrescribeCost) {
		this.ownPrescribeCost = ownPrescribeCost;
	}

	@XmlElement
	public BigDecimal getOtherPrescribeCost() {
		return this.otherPrescribeCost;
	}

	public void setOtherPrescribeCost(BigDecimal otherPrescribeCost) {
		this.otherPrescribeCost = otherPrescribeCost;
	}

	@XmlElement
	public BigDecimal getDrugIncome() {
		return this.drugIncome;
	}

	public void setDrugIncome(BigDecimal drugIncome) {
		this.drugIncome = drugIncome;
	}

	@XmlElement
	public double getDrugIncomeScale() {
		return this.drugIncomeScale;
	}

	public void setDrugIncomeScale(double drugIncomeScale) {
		this.drugIncomeScale = drugIncomeScale;
	}

	@XmlElement
	public BigDecimal getOtherDrugAmount() {
		return this.otherDrugAmount;
	}

	public void setOtherDrugAmount(BigDecimal otherDrugAmount) {
		this.otherDrugAmount = otherDrugAmount;
	}

	@XmlElement
	public double getOtherDrugScale() {
		return this.otherDrugScale;
	}

	public void setOtherDrugScale(double otherDrugScale) {
		this.otherDrugScale = otherDrugScale;
	}

	@XmlElement
	public BigDecimal getOwnDrugAmount() {
		return this.ownDrugAmount;
	}

	public void setOwnDrugAmount(BigDecimal ownDrugAmount) {
		this.ownDrugAmount = ownDrugAmount;
	}

	@XmlElement
	public double getOwnDrugScale() {
		return this.ownDrugScale;
	}

	public void setOwnDrugScale(double ownDrugScale) {
		this.ownDrugScale = ownDrugScale;
	}

	@XmlElement
	public BigDecimal getMedAmount() {
		return this.medAmount;
	}

	public void setMedAmount(BigDecimal medAmount) {
		this.medAmount = medAmount;
	}

	@XmlElement
	public double getMedAmountScale() {
		return this.medAmountScale;
	}

	public void setMedAmountScale(double medAmountScale) {
		this.medAmountScale = medAmountScale;
	}

	@XmlElement
	public BigDecimal getOtherMedAmount() {
		return this.otherMedAmount;
	}

	public void setOtherMedAmount(BigDecimal otherMedAmount) {
		this.otherMedAmount = otherMedAmount;
	}

	@XmlElement
	public double getOtherMedScale() {
		return this.otherMedScale;
	}

	public void setOtherMedScale(double otherMedScale) {
		this.otherMedScale = otherMedScale;
	}

	@XmlElement
	public BigDecimal getOwnMedAmount() {
		return this.ownMedAmount;
	}

	public void setOwnMedAmount(BigDecimal ownMedAmount) {
		this.ownMedAmount = ownMedAmount;
	}

	@XmlElement
	public double getOwnMedScale() {
		return this.ownMedScale;
	}

	public void setOwnMedScale(double ownMedScale) {
		this.ownMedScale = ownMedScale;
	}

	@XmlElement
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@XmlElement
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getRegistrationNum() {
		return registrationNum;
	}

	public void setRegistrationNum(Integer registrationNum) {
		this.registrationNum = registrationNum;
	}

	public Integer getObservingNum() {
		return observingNum;
	}

	public void setObservingNum(Integer observingNum) {
		this.observingNum = observingNum;
	}

	public Integer getVisitNum() {
		return visitNum;
	}

	public void setVisitNum(Integer visitNum) {
		this.visitNum = visitNum;
	}

	public Integer getNonAttendNum() {
		return nonAttendNum;
	}

	public void setNonAttendNum(Integer nonAttendNum) {
		this.nonAttendNum = nonAttendNum;
	}

	
}