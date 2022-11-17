package com.founder.rhip.ehr.entity.ihm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.math.BigDecimal;

@Entity
@Table(name="RD_INPATIENT_COMPOSITIVE")
public class RdInpatientCompositive implements Serializable {

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

	@Column(name="INCOME",columnDefinition="NUMBER|住院收入||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal income;

	@Column(name="MEDICARE_COST",columnDefinition="NUMBER|医保支付费用||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal medicareCost;

	@Column(name="OWN_COST",columnDefinition="NUMBER|个人承担费用||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal ownCost;

	@Column(name="PER_LEVEL_COST",columnDefinition="NUMBER|出院人均次费用||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal perLevelCost;

	@Column(name="ACCOUNT_NUM",columnDefinition="NUMBER|结算人次|12|",length=12,nullable=true)
	private Integer accountNum;

	@Column(name="AVG_ACCOUNT",columnDefinition="NUMBER|结算均次费用||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal avgAccount;

	@Column(name="AVG_DAY_BED_NUM",columnDefinition="NUMBER|医师日均担负住院床日||",length=12,scale=12,precision=2,nullable=true)
	private double avgDayBedNum;

	@Column(name="ADMISSION_NUM",columnDefinition="NUMBER|入院人数|12|",length=12,nullable=true)
	private Integer admissionNum;

	@Column(name="IN_HOSPITAL_NUM",columnDefinition="NUMBER|在院人数|12|",length=12,nullable=true)
	private Integer inHospitalNum;

	@Column(name="CRITICAL_NUM",columnDefinition="NUMBER|危重人数|12|",length=12,nullable=true)
	private Integer criticalNum;

	@Column(name="OBSERVE_NUM",columnDefinition="NUMBER|观察人数|12|",length=12,nullable=true)
	private Integer observeNum;

	@Column(name="DELIVERY_ROOM_NUM",columnDefinition="NUMBER|产房人数|12|",length=12,nullable=true)
	private Integer deliveryRoomNum;

	@Column(name="ICU_NUM",columnDefinition="NUMBER|ICU人数|12|",length=12,nullable=true)
	private Integer icuNum;

	@Column(name="OPERATION_NUM",columnDefinition="NUMBER|手术人数|12|",length=12,nullable=true)
	private Integer operationNum;
	
	@Column(name="OPERATION_NUM_ALL",columnDefinition="NUMBER|手术人次数|12|",length=12,nullable=true)
	private Integer operationNumAll;
	
	@Column(name="BESPOKE_NUM",columnDefinition="NUMBER|预约手术|12|",length=12,nullable=true)
	private Integer bespokeNum;

	@Column(name="CONSULTATION_NUM",columnDefinition="NUMBER|会诊人数|12|",length=12,nullable=true)
	private Integer consultationNum;

	@Column(name="LEAVE_NUM",columnDefinition="NUMBER|出院人数|12|",length=12,nullable=true)
	private Integer leaveNum;

	@Column(name="DIE_NUM",columnDefinition="NUMBER|死亡人数|12|",length=12,nullable=true)
	private Integer dieNum;

	@Column(name="AVG_INHOSPITAL_DAY",columnDefinition="NUMBER|平均住院日||",length=12,scale=12,precision=2,nullable=true)
	private double avgInhospitalDay;

	@Column(name="USE_BED",columnDefinition="NUMBER|使用床位|12|",length=12,nullable=true)
	private Integer useBed;

	@Column(name="RATED_BED",columnDefinition="NUMBER|额定床位|12|",length=12,nullable=true)
	private Integer ratedBed;

	@Column(name="BED_USE_RATIO",columnDefinition="NUMBER|病床使用率||",length=12,scale=12,precision=2,nullable=true)
	private double bedUseRatio;

	@Column(name="BED_TURNOVER_NUM",columnDefinition="NUMBER|病床周转次数|12|",length=12,nullable=true)
	private Integer bedTurnoverNum;

	@Column(name="SETTLEMENT_AMOUNT",columnDefinition="NUMBER|结算金额||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal settlementAmount;

	@Column(name="ANTIBACTERIAL_RATIO",columnDefinition="NUMBER|住院患者抗菌药物占比||",length=12,scale=12,precision=2,nullable=true)
	private double antibacterialRatio;

	@Column(name="DRUG_AMOUNT",columnDefinition="NUMBER|住院药品收入||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal drugAmount;

	@Column(name="DRUG_SCALE",columnDefinition="NUMBER|住院药品收入比例||",length=12,scale=12,precision=2,nullable=true)
	private double drugScale;

	@Column(name="OTHER_DRUG_AMOUNT",columnDefinition="NUMBER|其它病人药品收入||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal otherDrugAmount;

	@Column(name="OTHER_DRUG_SCALE",columnDefinition="NUMBER|其它病人药品收入比例||",length=12,scale=12,precision=2,nullable=true)
	private double otherDrugScale;

	@Column(name="OWN_DRUG_AMOUNT",columnDefinition="NUMBER|自费病人药品收入||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal ownDrugAmount;

	@Column(name="OWN_DRUG_SCALE",columnDefinition="NUMBER|自费病人药品收入比例||",length=12,scale=12,precision=2,nullable=true)
	private double ownDrugScale;

	@Column(name="MED_AMOUNT",columnDefinition="NUMBER|住院医疗收入||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal medAmount;

	@Column(name="MED_SCALE",columnDefinition="NUMBER|住院医疗收入比例||",length=12,scale=12,precision=2,nullable=true)
	private double medScale;

	@Column(name="OTHER_MED_AMOUNT",columnDefinition="NUMBER|其它病人医疗收入||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal otherMedAmount;

	@Column(name="OTHER_MED_SCALE",columnDefinition="NUMBER|其它病人医疗收入比例||",length=12,scale=12,precision=2,nullable=true)
	private double otherMedScale;

	@Column(name="OWN_MED_AMOUNT",columnDefinition="NUMBER|自费病人医疗收入||",length=12,scale=12,precision=2,nullable=true)
	private BigDecimal ownMedAmount;

	@Column(name="OWN_MED_SCALE",columnDefinition="NUMBER|自费病人医疗收入比例||",length=12,scale=12,precision=2,nullable=true)
	private double ownMedScale;

	@Column(name="CREATE_DATE",columnDefinition="TIMESTAMP|创建时间||",nullable=true)
	private Date createDate;

	@Column(name="UPDATE_DATE",columnDefinition="TIMESTAMP|更新时间||",nullable=true)
	private Date updateDate;
	
	@Column(name="DISCHARGE_CURE_NUM",columnDefinition="NUMBER|出院治愈人数|12|",length=12,nullable=true)
	private Integer dischargeCureNum;
	
	@Column(name="DISCHARGE_BETTER_NUM",columnDefinition="NUMBER|出院好转人数|12|",length=12,nullable=true)
	private Integer dischargeBetterNum;
	
	@Column(name="DISCHARGE_STABLE_NUM",columnDefinition="NUMBER|出院稳定人数|12|",length=12,nullable=true)
	private Integer dischargeStableNum;
	
	@Column(name="DISCHARGE_WORSE_NUM",columnDefinition="NUMBER|出院恶化人数|12|",length=12,nullable=true)
	private Integer dischargeWorseNum;
	
	@Column(name="DISCHARGE_OTHER_NUM",columnDefinition="NUMBER|出院其他人数|12|",length=12,nullable=true)
	private Integer dischargeOtherNum;
	

	public Integer getOperationNumAll() {
		return operationNumAll;
	}

	public void setOperationNumAll(Integer operationNumAll) {
		this.operationNumAll = operationNumAll;
	}

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

	public BigDecimal getIncome() {
		return this.income;
	}

	public void setIncome(BigDecimal income) {
		this.income = income;
	}

	public BigDecimal getMedicareCost() {
		return this.medicareCost;
	}

	public void setMedicareCost(BigDecimal medicareCost) {
		this.medicareCost = medicareCost;
	}

	public BigDecimal getOwnCost() {
		return this.ownCost;
	}

	public void setOwnCost(BigDecimal ownCost) {
		this.ownCost = ownCost;
	}

	public BigDecimal getPerLevelCost() {
		return this.perLevelCost;
	}

	public void setPerLevelCost(BigDecimal perLevelCost) {
		this.perLevelCost = perLevelCost;
	}

	public Integer getAccountNum() {
		return this.accountNum;
	}

	public void setAccountNum(Integer accountNum) {
		this.accountNum = accountNum;
	}

	public BigDecimal getAvgAccount() {
		return this.avgAccount;
	}

	public void setAvgAccount(BigDecimal avgAccount) {
		this.avgAccount = avgAccount;
	}

	public double getAvgDayBedNum() {
		return this.avgDayBedNum;
	}

	public void setAvgDayBedNum(double avgDayBedNum) {
		this.avgDayBedNum = avgDayBedNum;
	}

	public Integer getAdmissionNum() {
		return this.admissionNum;
	}

	public void setAdmissionNum(Integer admissionNum) {
		this.admissionNum = admissionNum;
	}

	public Integer getInHospitalNum() {
		return this.inHospitalNum;
	}

	public void setInHospitalNum(Integer inHospitalNum) {
		this.inHospitalNum = inHospitalNum;
	}

	public Integer getCriticalNum() {
		return this.criticalNum;
	}

	public void setCriticalNum(Integer criticalNum) {
		this.criticalNum = criticalNum;
	}

	public Integer getObserveNum() {
		return this.observeNum;
	}

	public void setObserveNum(Integer observeNum) {
		this.observeNum = observeNum;
	}

	public Integer getDeliveryRoomNum() {
		return this.deliveryRoomNum;
	}

	public void setDeliveryRoomNum(Integer deliveryRoomNum) {
		this.deliveryRoomNum = deliveryRoomNum;
	}

	public Integer getIcuNum() {
		return this.icuNum;
	}

	public void setIcuNum(Integer icuNum) {
		this.icuNum = icuNum;
	}

	public Integer getOperationNum() {
		return this.operationNum;
	}

	public void setOperationNum(Integer operationNum) {
		this.operationNum = operationNum;
	}

	public Integer getBespokeNum() {
		return this.bespokeNum;
	}

	public void setBespokeNum(Integer bespokeNum) {
		this.bespokeNum = bespokeNum;
	}

	public Integer getConsultationNum() {
		return this.consultationNum;
	}

	public void setConsultationNum(Integer consultationNum) {
		this.consultationNum = consultationNum;
	}

	public Integer getLeaveNum() {
		return this.leaveNum;
	}

	public void setLeaveNum(Integer leaveNum) {
		this.leaveNum = leaveNum;
	}

	public Integer getDieNum() {
		return this.dieNum;
	}

	public void setDieNum(Integer dieNum) {
		this.dieNum = dieNum;
	}

	public double getAvgInhospitalDay() {
		return this.avgInhospitalDay;
	}

	public void setAvgInhospitalDay(double avgInhospitalDay) {
		this.avgInhospitalDay = avgInhospitalDay;
	}

	public Integer getUseBed() {
		return this.useBed;
	}

	public void setUseBed(Integer useBed) {
		this.useBed = useBed;
	}

	public Integer getRatedBed() {
		return this.ratedBed;
	}

	public void setRatedBed(Integer ratedBed) {
		this.ratedBed = ratedBed;
	}

	public double getBedUseRatio() {
		return this.bedUseRatio;
	}

	public void setBedUseRatio(double bedUseRatio) {
		this.bedUseRatio = bedUseRatio;
	}

	public Integer getBedTurnoverNum() {
		return this.bedTurnoverNum;
	}

	public void setBedTurnoverNum(Integer bedTurnoverNum) {
		this.bedTurnoverNum = bedTurnoverNum;
	}

	public BigDecimal getSettlementAmount() {
		return this.settlementAmount;
	}

	public void setSettlementAmount(BigDecimal settlementAmount) {
		this.settlementAmount = settlementAmount;
	}

	public double getAntibacterialRatio() {
		return this.antibacterialRatio;
	}

	public void setAntibacterialRatio(double antibacterialRatio) {
		this.antibacterialRatio = antibacterialRatio;
	}

	public BigDecimal getDrugAmount() {
		return this.drugAmount;
	}

	public void setDrugAmount(BigDecimal drugAmount) {
		this.drugAmount = drugAmount;
	}

	public double getDrugScale() {
		return this.drugScale;
	}

	public void setDrugScale(double drugScale) {
		this.drugScale = drugScale;
	}

	public BigDecimal getOtherDrugAmount() {
		return this.otherDrugAmount;
	}

	public void setOtherDrugAmount(BigDecimal otherDrugAmount) {
		this.otherDrugAmount = otherDrugAmount;
	}

	public double getOtherDrugScale() {
		return this.otherDrugScale;
	}

	public void setOtherDrugScale(double otherDrugScale) {
		this.otherDrugScale = otherDrugScale;
	}

	public BigDecimal getOwnDrugAmount() {
		return this.ownDrugAmount;
	}

	public void setOwnDrugAmount(BigDecimal ownDrugAmount) {
		this.ownDrugAmount = ownDrugAmount;
	}

	public double getOwnDrugScale() {
		return this.ownDrugScale;
	}

	public void setOwnDrugScale(double ownDrugScale) {
		this.ownDrugScale = ownDrugScale;
	}

	public BigDecimal getMedAmount() {
		return this.medAmount;
	}

	public void setMedAmount(BigDecimal medAmount) {
		this.medAmount = medAmount;
	}

	public double getMedScale() {
		return this.medScale;
	}

	public void setMedScale(double medScale) {
		this.medScale = medScale;
	}

	public BigDecimal getOtherMedAmount() {
		return this.otherMedAmount;
	}

	public void setOtherMedAmount(BigDecimal otherMedAmount) {
		this.otherMedAmount = otherMedAmount;
	}

	public double getOtherMedScale() {
		return this.otherMedScale;
	}

	public void setOtherMedScale(double otherMedScale) {
		this.otherMedScale = otherMedScale;
	}

	public BigDecimal getOwnMedAmount() {
		return this.ownMedAmount;
	}

	public void setOwnMedAmount(BigDecimal ownMedAmount) {
		this.ownMedAmount = ownMedAmount;
	}

	public double getOwnMedScale() {
		return this.ownMedScale;
	}

	public void setOwnMedScale(double ownMedScale) {
		this.ownMedScale = ownMedScale;
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

	public Integer getDischargeCureNum() {
		return dischargeCureNum;
	}

	public void setDischargeCureNum(Integer dischargeCureNum) {
		this.dischargeCureNum = dischargeCureNum;
	}

	public Integer getDischargeBetterNum() {
		return dischargeBetterNum;
	}

	public void setDischargeBetterNum(Integer dischargeBetterNum) {
		this.dischargeBetterNum = dischargeBetterNum;
	}

	public Integer getDischargeStableNum() {
		return dischargeStableNum;
	}

	public void setDischargeStableNum(Integer dischargeStableNum) {
		this.dischargeStableNum = dischargeStableNum;
	}

	public Integer getDischargeWorseNum() {
		return dischargeWorseNum;
	}

	public void setDischargeWorseNum(Integer dischargeWorseNum) {
		this.dischargeWorseNum = dischargeWorseNum;
	}

	public Integer getDischargeOtherNum() {
		return dischargeOtherNum;
	}

	public void setDischargeOtherNum(Integer dischargeOtherNum) {
		this.dischargeOtherNum = dischargeOtherNum;
	}

	
}