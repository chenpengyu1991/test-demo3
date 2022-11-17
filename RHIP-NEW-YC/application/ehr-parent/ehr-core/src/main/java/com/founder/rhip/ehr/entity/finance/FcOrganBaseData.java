package com.founder.rhip.ehr.entity.finance;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "FC_ORGAN_BASE_DATA")
public class FcOrganBaseData implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = true)
	private Long id;

	@Column(name = "MONTH", columnDefinition = "CHAR|年月|6|", length = 6, nullable = true)
	private String month;

	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|单位|50|", length = 50, nullable = true)
	private String organCode;

	@Column(name = "INSTITUTIONS_NUMBER", columnDefinition = "NUMBER|机构数||", length = 15, nullable = true)
	private BigDecimal institutionsNumber;

	@Column(name = "AURHORIZED_STAFF", columnDefinition = "NUMBER|编制人数||", length = 15, nullable = true)
	private BigDecimal aurhorizedStaff;

	@Column(name = "FINAL_AURHORIZED_STAFF", columnDefinition = "NUMBER|期末在编在职人数||", length = 15, nullable = true)
	private BigDecimal finalAurhorizedStaff;

	@Column(name = "HEALTH_TECHNICIANS_ONJOB", columnDefinition = "NUMBER|卫技人员||", length = 15, nullable = true)
	private BigDecimal healthTechniciansOnjob;

	@Column(name = "STAFF_NUMBER_IN_SERVICE", columnDefinition = "NUMBER|平均在职职工人数||", length = 15, nullable = true)
	private BigDecimal staffNumberInService;

	@Column(name = "RETIRD_NUMBER", columnDefinition = "NUMBER|期末离退休人数||", length = 15, nullable = true)
	private BigDecimal retiredNumber;

	@Column(name = "TEMPORARY_WORKERS_NUMBER", columnDefinition = "NUMBER|临时工人数||", length = 15, nullable = true)
	private BigDecimal temporaryWorkersNumber;

	@Column(name = "HEALTH_TECHNICIANS_PARTTIME", columnDefinition = "NUMBER|卫技人员||", length = 15, nullable = true)
	private BigDecimal healthTechniciansParttime;

	@Column(name = "AURHORIZED_BED", columnDefinition = "NUMBER|编制床位||", length = 15, nullable = true)
	private BigDecimal aurhorizedBed;

	@Column(name = "OPEN_BED_FINAL", columnDefinition = "NUMBER|期末实际开放床位||", length = 15, nullable = true)
	private BigDecimal openBedFinal;

	@Column(name = "EMERGENCY_CARE_PERSON_NUMBER", columnDefinition = "NUMBER|门急诊人次数||", length = 15, nullable = true)
	private BigDecimal emergencyCarePersonNumber;

	@Column(name = "OPEN_BED_DAYS", columnDefinition = "NUMBER|实际开放总床日数||", length = 15, nullable = true)
	private BigDecimal openBedDays;

	@Column(name = "USE_BED_DAYS", columnDefinition = "NUMBER|实际占用总床日数||", length = 15, nullable = true)
	private BigDecimal useBedDays;

	@Column(name = "DISCHARGED_PERSON_NUMBER", columnDefinition = "NUMBER|出院人数||", length = 15, nullable = true)
	private BigDecimal dischargedPersonNuMber;

	@Column(name = "FIXED_ASSETS_YEAR_BEGIN", columnDefinition = "NUMBER|年初固定资产总值||", length = 15, nullable = true)
	private BigDecimal fixedAssetsYearBegin;

	@Column(name = "FIXED_ASSETS_YEAR_END", columnDefinition = "NUMBER|期末固定资产总值||", length = 15, nullable = true)
	private BigDecimal fixedAssetsYearEnd;

	@Column(name = "SPECIAL_DEVICE", columnDefinition = "NUMBER|专用设备||", length = 15, nullable = true)
	private BigDecimal specialDevice;

	@Column(name = "HOUSES_BUILDINGS", columnDefinition = "NUMBER|房屋及建筑物||", length = 15, nullable = true)
	private BigDecimal housesBuildings;

	@Column(name = "SERVICE_HOUSES", columnDefinition = "NUMBER|业务用房||", length = 15, nullable = true)
	private BigDecimal serviceHouses;

	@Column(name = "BUILDING_EREA_FINAL", columnDefinition = "NUMBER|期末房屋及建筑物面积||", length = 15, nullable = true)
	private BigDecimal buildingEreaFinal;

	@Column(name = "SERVICE_HOUSES_BUILDING", columnDefinition = "NUMBER|业务用房(房屋及建筑物面积)||", length = 15, nullable = true)
	private BigDecimal serviceHousesBuilding;

	@Column(name = "OTHER_ACCOUNT_OVER_YEAR", columnDefinition = "NUMBER|年以上其他应付款||", length = 15, nullable = true)
	private BigDecimal otherAccountOverYear;

	@Column(name = "CONSTRUCTION_DEBT", columnDefinition = "NUMBER|基本建设负债||", length = 15, nullable = true)
	private BigDecimal constructionDebt;

	@Column(name = "DEVICE_PURCHASE_DEBT", columnDefinition = "NUMBER|设备购置负债||", length = 15, nullable = true)
	private BigDecimal devicePurchaseDebt;

	@Column(name = "STAFF_TREATMENT_TIMES", columnDefinition = "NUMBER|每职工平均诊疗人次||", length = 15, nullable = true)
	private BigDecimal staffTreatmentTimes;

	@Column(name = "STAFF_HOSPITAL_DAYS", columnDefinition = "NUMBER|每职工平均住院床日||", length = 15, nullable = true)
	private BigDecimal staffHospitalDays;

	@Column(name = "STAFF_MEDICAL_INCOME", columnDefinition = "NUMBER|每职工平均医疗收入||", length = 15, nullable = true)
	private BigDecimal staffMedicalIncome;

	@Column(name = "BED_FIXED_ASSETS", columnDefinition = "NUMBER|每床位占用固定资产||", length = 15, nullable = true)
	private BigDecimal bedFixedAssets;

	@Column(name = "SPECIAL_DEVICE_BED", columnDefinition = "NUMBER|专用设备||", length = 15, nullable = true)
	private BigDecimal specialDeviceBed;

	@Column(name = "BED_USED_RATIO", columnDefinition = "NUMBER|病床使用率||", length = 15, nullable = true)
	private BigDecimal bedUsedRatio;

	@Column(name = "BED_TURNOVER_TIMES", columnDefinition = "NUMBER|病床周转次数||", length = 15, nullable = true)
	private BigDecimal bedTurnoverTimes;

	@Column(name = "HOSPITAL_DAYS", columnDefinition = "NUMBER|出院者平均住院天数||", length = 15, nullable = true)
	private BigDecimal hospitalDays;

	@Column(name = "FIXED_ASSETS_INCOME", columnDefinition = "NUMBER|百元固定资产医疗收入（不含药品收入）||", length = 15, nullable = true)
	private BigDecimal fixedAssetsIncome;

	@Column(name = "EMERGENCY_CARE_FEE", columnDefinition = "NUMBER|每门急诊人次平均收费水平||", length = 15, nullable = true)
	private BigDecimal emergencyCareFee;

	@Column(name = "PHARMACEUTICALS_FEE_OUT", columnDefinition = "NUMBER|药品费||", length = 15, nullable = true)
	private BigDecimal pharmaceuticalsFeeOut;

	@Column(name = "BED_FEE", columnDefinition = "NUMBER|每床日平均收费水平||", length = 15, nullable = true)
	private BigDecimal bedFee;

	@Column(name = "PHARMACEUTICALS_FEE", columnDefinition = "NUMBER|药品费||", length = 15, nullable = true)
	private BigDecimal pharmaceuticalsFee;

	@Column(name = "AVERAGE_MEDICAL_EXPENSES", columnDefinition = "NUMBER|出院者平均医药费用||", length = 15, nullable = true)
	private BigDecimal averageMedicalExpenses;

	@Column(name = "PHARMACEUTICALS_FEE_UNCG", columnDefinition = "NUMBER|药品费||", length = 15, nullable = true)
	private BigDecimal pharmaceuticalsFeeUncg;

	@Column(name = "SUBSIDY_INCOME_PROPORTION", columnDefinition = "NUMBER|财政补助收入占总支出比例||", length = 15, nullable = true)
	private BigDecimal subsidyIncomeProportion;

	@Column(name = "HEALTH_MATERIALS_CONSUMPTION", columnDefinition = "NUMBER|百元医疗收入消耗卫生材料（不含药品收入）||", length = 15, nullable = true)
	private BigDecimal healthMaterialsConsumption;

	@Column(name = "DEVICE_NUMBER", columnDefinition = "NUMBER|单价在10万元以上的专业设备台数||", length = 15, nullable = true)
	private BigDecimal deviceNumber;

	@Column(name = "DEVICE_PRICE", columnDefinition = "NUMBER|单价在11万元以上的专业设备金额||", length = 15, nullable = true)
	private BigDecimal devicePrice;

	@Column(name = "ASSETS_DEBTS_BALANCE", columnDefinition = "NUMBER|资产负债结余情况||", length = 15, nullable = true)
	private BigDecimal assetsDebtsBalance;

	@Column(name = "MONETARY_FUND", columnDefinition = "NUMBER|货币资金||", length = 15, nullable = true)
	private BigDecimal monetaryFund;

	@Column(name = "MEDICAL_ACCOUNT", columnDefinition = "NUMBER|应收医疗款||", length = 15, nullable = true)
	private BigDecimal medicalAccount;

	@Column(name = "OTHER_RECEIVABLE_ACCOUNT", columnDefinition = "NUMBER|其他应收款||", length = 15, nullable = true)
	private BigDecimal otherReceivableAccount;

	@Column(name = "INVENTORY", columnDefinition = "NUMBER|库存物资||", length = 15, nullable = true)
	private BigDecimal inventory;

	@Column(name = "PROJECT_IN_PROGRESS", columnDefinition = "NUMBER|在建工程||", length = 15, nullable = true)
	private BigDecimal projectInProgress;

	@Column(name = "SHORT_TERM_LOAN", columnDefinition = "NUMBER|短期借款||", length = 15, nullable = true)
	private BigDecimal shortTermLoan;

	@Column(name = "PAYABLE_ACCOUNT", columnDefinition = "NUMBER|应付账款||", length = 15, nullable = true)
	private BigDecimal payableAccount;

	@Column(name = "OTHER_PAYABLE_ACCOUNT", columnDefinition = "NUMBER|其他应付款||", length = 15, nullable = true)
	private BigDecimal otherPayableAccount;

	@Column(name = "FIXED_FUND", columnDefinition = "NUMBER|固定基金||", length = 15, nullable = true)
	private BigDecimal fixedFund;

	@Column(name = "ENTERPRISE_FUND", columnDefinition = "NUMBER|事业基金||", length = 15, nullable = true)
	private BigDecimal enterpriseFund;

	@Column(name = "DEDICATED_FUND", columnDefinition = "NUMBER|专用基金||", length = 15, nullable = true)
	private BigDecimal dedicatedFund;

	@Column(name = "FINANCE_SUBSIDY_BALANCE", columnDefinition = "NUMBER|财政专项补助结余||", length = 15, nullable = true)
	private BigDecimal financeSubsidyBalance;

	@Column(name = "PERIOD_BALANCE", columnDefinition = "NUMBER|本期结余||", length = 15, nullable = true)
	private BigDecimal periodBalance;

	@Column(name = "NET_ASSETS", columnDefinition = "NUMBER|净资产合计||", length = 15, nullable = true)
	private BigDecimal netAssets;

	@Column(name = "TOTAL_ASSETS", columnDefinition = "NUMBER|资产总计||", length = 15, nullable = true)
	private BigDecimal totalAssets;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMonth() {
		return this.month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getOrganCode() {
		return this.organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public BigDecimal getInstitutionsNumber() {
		return this.institutionsNumber;
	}

	public void setInstitutionsNumber(BigDecimal institutionsNumber) {
		this.institutionsNumber = institutionsNumber;
	}

	public BigDecimal getAurhorizedStaff() {
		return this.aurhorizedStaff;
	}

	public void setAurhorizedStaff(BigDecimal aurhorizedStaff) {
		this.aurhorizedStaff = aurhorizedStaff;
	}

	public BigDecimal getFinalAurhorizedStaff() {
		return this.finalAurhorizedStaff;
	}

	public void setFinalAurhorizedStaff(BigDecimal finalAurhorizedStaff) {
		this.finalAurhorizedStaff = finalAurhorizedStaff;
	}

	public BigDecimal getHealthTechniciansOnjob() {
		return this.healthTechniciansOnjob;
	}

	public void setHealthTechniciansOnjob(BigDecimal healthTechniciansOnjob) {
		this.healthTechniciansOnjob = healthTechniciansOnjob;
	}

	public BigDecimal getStaffNumberInService() {
		return this.staffNumberInService;
	}

	public void setStaffNumberInService(BigDecimal staffNumberInService) {
		this.staffNumberInService = staffNumberInService;
	}

	public BigDecimal getRetiredNumber() {
		return this.retiredNumber;
	}

	public void setRetiredNumber(BigDecimal retiredNumber) {
		this.retiredNumber = retiredNumber;
	}

	public BigDecimal getTemporaryWorkersNumber() {
		return this.temporaryWorkersNumber;
	}

	public void setTemporaryWorkersNumber(BigDecimal temporaryWorkersNumber) {
		this.temporaryWorkersNumber = temporaryWorkersNumber;
	}

	public BigDecimal getHealthTechniciansParttime() {
		return this.healthTechniciansParttime;
	}

	public void setHealthTechniciansParttime(BigDecimal healthTechniciansParttime) {
		this.healthTechniciansParttime = healthTechniciansParttime;
	}

	public BigDecimal getAurhorizedBed() {
		return this.aurhorizedBed;
	}

	public void setAurhorizedBed(BigDecimal aurhorizedBed) {
		this.aurhorizedBed = aurhorizedBed;
	}

	public BigDecimal getOpenBedFinal() {
		return this.openBedFinal;
	}

	public void setOpenBedFinal(BigDecimal openBedFinal) {
		this.openBedFinal = openBedFinal;
	}

	public BigDecimal getEmergencyCarePersonNumber() {
		return this.emergencyCarePersonNumber;
	}

	public void setEmergencyCarePersonNumber(BigDecimal emergencyCarePersonNumber) {
		this.emergencyCarePersonNumber = emergencyCarePersonNumber;
	}

	public BigDecimal getOpenBedDays() {
		return this.openBedDays;
	}

	public void setOpenBedDays(BigDecimal openBedDays) {
		this.openBedDays = openBedDays;
	}

	public BigDecimal getUseBedDays() {
		return this.useBedDays;
	}

	public void setUseBedDays(BigDecimal useBedDays) {
		this.useBedDays = useBedDays;
	}

	public BigDecimal getDischargedPersonNuMber() {
		return this.dischargedPersonNuMber;
	}

	public void setDischargedPersonNuMber(BigDecimal dischargedPersonNuMber) {
		this.dischargedPersonNuMber = dischargedPersonNuMber;
	}

	public BigDecimal getFixedAssetsYearBegin() {
		return this.fixedAssetsYearBegin;
	}

	public void setFixedAssetsYearBegin(BigDecimal fixedAssetsYearBegin) {
		this.fixedAssetsYearBegin = fixedAssetsYearBegin;
	}

	public BigDecimal getFixedAssetsYearEnd() {
		return this.fixedAssetsYearEnd;
	}

	public void setFixedAssetsYearEnd(BigDecimal fixedAssetsYearEnd) {
		this.fixedAssetsYearEnd = fixedAssetsYearEnd;
	}

	public BigDecimal getSpecialDevice() {
		return this.specialDevice;
	}

	public void setSpecialDevice(BigDecimal specialDevice) {
		this.specialDevice = specialDevice;
	}

	public BigDecimal getHousesBuildings() {
		return this.housesBuildings;
	}

	public void setHousesBuildings(BigDecimal housesBuildings) {
		this.housesBuildings = housesBuildings;
	}

	public BigDecimal getServiceHouses() {
		return this.serviceHouses;
	}

	public void setServiceHouses(BigDecimal serviceHouses) {
		this.serviceHouses = serviceHouses;
	}

	public BigDecimal getBuildingEreaFinal() {
		return this.buildingEreaFinal;
	}

	public void setBuildingEreaFinal(BigDecimal buildingEreaFinal) {
		this.buildingEreaFinal = buildingEreaFinal;
	}

	public BigDecimal getServiceHousesBuilding() {
		return this.serviceHousesBuilding;
	}

	public void setServiceHousesBuilding(BigDecimal serviceHousesBuilding) {
		this.serviceHousesBuilding = serviceHousesBuilding;
	}

	public BigDecimal getOtherAccountOverYear() {
		return this.otherAccountOverYear;
	}

	public void setOtherAccountOverYear(BigDecimal otherAccountOverYear) {
		this.otherAccountOverYear = otherAccountOverYear;
	}

	public BigDecimal getConstructionDebt() {
		return this.constructionDebt;
	}

	public void setConstructionDebt(BigDecimal constructionDebt) {
		this.constructionDebt = constructionDebt;
	}

	public BigDecimal getDevicePurchaseDebt() {
		return this.devicePurchaseDebt;
	}

	public void setDevicePurchaseDebt(BigDecimal devicePurchaseDebt) {
		this.devicePurchaseDebt = devicePurchaseDebt;
	}

	public BigDecimal getStaffTreatmentTimes() {
		return this.staffTreatmentTimes;
	}

	public void setStaffTreatmentTimes(BigDecimal staffTreatmentTimes) {
		this.staffTreatmentTimes = staffTreatmentTimes;
	}

	public BigDecimal getStaffHospitalDays() {
		return this.staffHospitalDays;
	}

	public void setStaffHospitalDays(BigDecimal staffHospitalDays) {
		this.staffHospitalDays = staffHospitalDays;
	}

	public BigDecimal getStaffMedicalIncome() {
		return this.staffMedicalIncome;
	}

	public void setStaffMedicalIncome(BigDecimal staffMedicalIncome) {
		this.staffMedicalIncome = staffMedicalIncome;
	}

	public BigDecimal getBedFixedAssets() {
		return this.bedFixedAssets;
	}

	public void setBedFixedAssets(BigDecimal bedFixedAssets) {
		this.bedFixedAssets = bedFixedAssets;
	}

	public BigDecimal getSpecialDeviceBed() {
		return this.specialDeviceBed;
	}

	public void setSpecialDeviceBed(BigDecimal specialDeviceBed) {
		this.specialDeviceBed = specialDeviceBed;
	}

	public BigDecimal getBedUsedRatio() {
		return this.bedUsedRatio;
	}

	public void setBedUsedRatio(BigDecimal bedUsedRatio) {
		this.bedUsedRatio = bedUsedRatio;
	}

	public BigDecimal getBedTurnoverTimes() {
		return this.bedTurnoverTimes;
	}

	public void setBedTurnoverTimes(BigDecimal bedTurnoverTimes) {
		this.bedTurnoverTimes = bedTurnoverTimes;
	}

	public BigDecimal getHospitalDays() {
		return this.hospitalDays;
	}

	public void setHospitalDays(BigDecimal hospitalDays) {
		this.hospitalDays = hospitalDays;
	}

	public BigDecimal getFixedAssetsIncome() {
		return this.fixedAssetsIncome;
	}

	public void setFixedAssetsIncome(BigDecimal fixedAssetsIncome) {
		this.fixedAssetsIncome = fixedAssetsIncome;
	}

	public BigDecimal getEmergencyCareFee() {
		return this.emergencyCareFee;
	}

	public void setEmergencyCareFee(BigDecimal emergencyCareFee) {
		this.emergencyCareFee = emergencyCareFee;
	}

	public BigDecimal getPharmaceuticalsFeeOut() {
		return this.pharmaceuticalsFeeOut;
	}

	public void setPharmaceuticalsFeeOut(BigDecimal pharmaceuticalsFeeOut) {
		this.pharmaceuticalsFeeOut = pharmaceuticalsFeeOut;
	}

	public BigDecimal getBedFee() {
		return this.bedFee;
	}

	public void setBedFee(BigDecimal bedFee) {
		this.bedFee = bedFee;
	}

	public BigDecimal getPharmaceuticalsFee() {
		return this.pharmaceuticalsFee;
	}

	public void setPharmaceuticalsFee(BigDecimal pharmaceuticalsFee) {
		this.pharmaceuticalsFee = pharmaceuticalsFee;
	}

	public BigDecimal getAverageMedicalExpenses() {
		return this.averageMedicalExpenses;
	}

	public void setAverageMedicalExpenses(BigDecimal averageMedicalExpenses) {
		this.averageMedicalExpenses = averageMedicalExpenses;
	}

	public BigDecimal getPharmaceuticalsFeeUncg() {
		return this.pharmaceuticalsFeeUncg;
	}

	public void setPharmaceuticalsFeeUncg(BigDecimal pharmaceuticalsFeeUncg) {
		this.pharmaceuticalsFeeUncg = pharmaceuticalsFeeUncg;
	}

	public BigDecimal getSubsidyIncomeProportion() {
		return this.subsidyIncomeProportion;
	}

	public void setSubsidyIncomeProportion(BigDecimal subsidyIncomeProportion) {
		this.subsidyIncomeProportion = subsidyIncomeProportion;
	}

	public BigDecimal getHealthMaterialsConsumption() {
		return this.healthMaterialsConsumption;
	}

	public void setHealthMaterialsConsumption(BigDecimal healthMaterialsConsumption) {
		this.healthMaterialsConsumption = healthMaterialsConsumption;
	}

	public BigDecimal getDeviceNumber() {
		return this.deviceNumber;
	}

	public void setDeviceNumber(BigDecimal deviceNumber) {
		this.deviceNumber = deviceNumber;
	}

	public BigDecimal getDevicePrice() {
		return this.devicePrice;
	}

	public void setDevicePrice(BigDecimal devicePrice) {
		this.devicePrice = devicePrice;
	}

	public BigDecimal getAssetsDebtsBalance() {
		return this.assetsDebtsBalance;
	}

	public void setAssetsDebtsBalance(BigDecimal assetsDebtsBalance) {
		this.assetsDebtsBalance = assetsDebtsBalance;
	}

	public BigDecimal getMonetaryFund() {
		return this.monetaryFund;
	}

	public void setMonetaryFund(BigDecimal monetaryFund) {
		this.monetaryFund = monetaryFund;
	}

	public BigDecimal getMedicalAccount() {
		return this.medicalAccount;
	}

	public void setMedicalAccount(BigDecimal medicalAccount) {
		this.medicalAccount = medicalAccount;
	}

	public BigDecimal getOtherReceivableAccount() {
		return this.otherReceivableAccount;
	}

	public void setOtherReceivableAccount(BigDecimal otherReceivableAccount) {
		this.otherReceivableAccount = otherReceivableAccount;
	}

	public BigDecimal getInventory() {
		return this.inventory;
	}

	public void setInventory(BigDecimal inventory) {
		this.inventory = inventory;
	}

	public BigDecimal getProjectInProgress() {
		return this.projectInProgress;
	}

	public void setProjectInProgress(BigDecimal projectInProgress) {
		this.projectInProgress = projectInProgress;
	}

	public BigDecimal getShortTermLoan() {
		return this.shortTermLoan;
	}

	public void setShortTermLoan(BigDecimal shortTermLoan) {
		this.shortTermLoan = shortTermLoan;
	}

	public BigDecimal getPayableAccount() {
		return this.payableAccount;
	}

	public void setPayableAccount(BigDecimal payableAccount) {
		this.payableAccount = payableAccount;
	}

	public BigDecimal getOtherPayableAccount() {
		return this.otherPayableAccount;
	}

	public void setOtherPayableAccount(BigDecimal otherPayableAccount) {
		this.otherPayableAccount = otherPayableAccount;
	}

	public BigDecimal getFixedFund() {
		return this.fixedFund;
	}

	public void setFixedFund(BigDecimal fixedFund) {
		this.fixedFund = fixedFund;
	}

	public BigDecimal getEnterpriseFund() {
		return this.enterpriseFund;
	}

	public void setEnterpriseFund(BigDecimal enterpriseFund) {
		this.enterpriseFund = enterpriseFund;
	}

	public BigDecimal getDedicatedFund() {
		return this.dedicatedFund;
	}

	public void setDedicatedFund(BigDecimal dedicatedFund) {
		this.dedicatedFund = dedicatedFund;
	}

	public BigDecimal getFinanceSubsidyBalance() {
		return this.financeSubsidyBalance;
	}

	public void setFinanceSubsidyBalance(BigDecimal financeSubsidyBalance) {
		this.financeSubsidyBalance = financeSubsidyBalance;
	}

	public BigDecimal getPeriodBalance() {
		return this.periodBalance;
	}

	public void setPeriodBalance(BigDecimal periodBalance) {
		this.periodBalance = periodBalance;
	}

	public BigDecimal getNetAssets() {
		return this.netAssets;
	}

	public void setNetAssets(BigDecimal netAssets) {
		this.netAssets = netAssets;
	}

	public BigDecimal getTotalAssets() {
		return this.totalAssets;
	}

	public void setTotalAssets(BigDecimal totalAssets) {
		this.totalAssets = totalAssets;
	}

}