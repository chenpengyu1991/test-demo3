package com.founder.rhip.ehr.entity.finance;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "FC_PUB_FINANCE_DETAILS")
public class FcPubFinanceDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = true)
	private Long id;

	@Column(name = "MONTH", columnDefinition = "CHAR|年月|6|", length = 6, nullable = true)
	private String month;

	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|单位|50|", length = 50, nullable = true)
	private String organCode;

	@Column(name = "INCOME_TOTAL", columnDefinition = "NUMBER|收入合计||", length = 15, nullable = true)
	private BigDecimal incomeTotal;

	@Column(name = "SUBSIDY_INCOME", columnDefinition = "NUMBER|财政补助收入||", length = 15, nullable = true)
	private BigDecimal subsidyIncome;

	@Column(name = "EXPENSES_TOTAL", columnDefinition = "NUMBER|支出合计||", length = 15, nullable = true)
	private BigDecimal expensesTotal;

	@Column(name = "PERSONNEL_FUNDS", columnDefinition = "NUMBER|人员经费||", length = 15, nullable = true)
	private BigDecimal personnelFunds;

	@Column(name = "SALARIES_BENEFITS", columnDefinition = "NUMBER|工资福利支出||", length = 15, nullable = true)
	private BigDecimal salariesBenefits;

	@Column(name = "FAMILY_SUBSIDY", columnDefinition = "NUMBER|对个人和家庭补助||", length = 15, nullable = true)
	private BigDecimal familySubsidy;

	@Column(name = "MATERIALS", columnDefinition = "NUMBER|卫生材料费||", length = 15, nullable = true)
	private BigDecimal materials;

	@Column(name = "PHARMACEUTICALS_FEE", columnDefinition = "NUMBER|药品费||", length = 15, nullable = true)
	private BigDecimal pharmaceuticalsFee;

	@Column(name = "DEPRECIATION", columnDefinition = "NUMBER|固定资产折旧||", length = 15, nullable = true)
	private BigDecimal depreciation;

	@Column(name = "VC_FUNDS", columnDefinition = "NUMBER|计提医疗风险基金||", length = 15, nullable = true)
	private BigDecimal vcFunds;

	@Column(name = "OTHER_FEE", columnDefinition = "NUMBER|其他费用||", length = 15, nullable = true)
	private BigDecimal otherFee;

	@Column(name = "GOODS_SERVICES_COST", columnDefinition = "NUMBER|商品和服务支出||", length = 15, nullable = true)
	private BigDecimal goodsServicesCost;

	@Column(name = "OFFICE_COST", columnDefinition = "NUMBER|办公费||", length = 15, nullable = true)
	private BigDecimal officeCost;

	@Column(name = "PRINTING_COST", columnDefinition = "NUMBER|印刷费||", length = 15, nullable = true)
	private BigDecimal printingCost;

	@Column(name = "WATER_COST", columnDefinition = "NUMBER|水费||", length = 15, nullable = true)
	private BigDecimal waterCost;

	@Column(name = "ELECTRICITY_COST", columnDefinition = "NUMBER|电费||", length = 15, nullable = true)
	private BigDecimal electriciryCost;

	@Column(name = "SECURITY_COST", columnDefinition = "NUMBER|保安费||", length = 15, nullable = true)
	private BigDecimal securityCost;

	@Column(name = "TRAVEL_COST", columnDefinition = "NUMBER|差旅费||", length = 15, nullable = true)
	private BigDecimal travelCost;

	@Column(name = "ABROAD_COST", columnDefinition = "NUMBER|出国费||", length = 15, nullable = true)
	private BigDecimal abroadCost;

	@Column(name = "MAINTENANCE_COST", columnDefinition = "NUMBER|维护费||", length = 15, nullable = true)
	private BigDecimal maintenanceCost;

	@Column(name = "MEETING_COST", columnDefinition = "NUMBER|会议费||", length = 15, nullable = true)
	private BigDecimal meetingCost;

	@Column(name = "TRAINING_COST", columnDefinition = "NUMBER|培训费||", length = 15, nullable = true)
	private BigDecimal trainingCost;

	@Column(name = "HOSTING_COST", columnDefinition = "NUMBER|公务接待费||", length = 15, nullable = true)
	private BigDecimal hostingCost;

	@Column(name = "OTHER_MATERIAL_COST", columnDefinition = "NUMBER|其他材料费||", length = 15, nullable = true)
	private BigDecimal otherMaterialCost;

	@Column(name = "LABOR_COST", columnDefinition = "NUMBER|劳务费||", length = 15, nullable = true)
	private BigDecimal laborCost;

	@Column(name = "COMMISSIONS_COST", columnDefinition = "NUMBER|委托业务费||", length = 15, nullable = true)
	private BigDecimal commissionsCost;

	@Column(name = "WELFARE_COST", columnDefinition = "NUMBER|福利费||", length = 15, nullable = true)
	private BigDecimal welfareCost;

	@Column(name = "CAR_COST", columnDefinition = "NUMBER|公务用车运行维护费||", length = 15, nullable = true)
	private BigDecimal carCost;

	@Column(name = "OTHER_GOODS_COST", columnDefinition = "NUMBER|其他商品和服务支出||", length = 15, nullable = true)
	private BigDecimal otherGoodsCost;

	@Column(name = "OTHER_COST", columnDefinition = "NUMBER|其他支出||", length = 15, nullable = true)
	private BigDecimal otherCost;

	@Column(name = "LOSSES_COST", columnDefinition = "NUMBER|坏账损失||", length = 15, nullable = true)
	private BigDecimal lossesCost;

	@Column(name = "INTEREST_PAYMENTS", columnDefinition = "NUMBER|银行利息支出||", length = 15, nullable = true)
	private BigDecimal interestPayments;

	@Column(name = "WASH_COST", columnDefinition = "NUMBER|洗涤费||", length = 15, nullable = true)
	private BigDecimal washCost;

	@Column(name = "PROCTER_COST", columnDefinition = "NUMBER|保洁费||", length = 15, nullable = true)
	private BigDecimal procterCost;

	@Column(name = "FUEL_COST", columnDefinition = "NUMBER|燃料费||", length = 15, nullable = true)
	private BigDecimal fuelCost;

	@Column(name = "OTHER", columnDefinition = "NUMBER|其他||", length = 15, nullable = true)
	private BigDecimal other;

	@Column(name = "CANTEEN_COST", columnDefinition = "NUMBER|食堂支出||", length = 15, nullable = true)
	private BigDecimal canteenCost;

	@Column(name = "BALANCE", columnDefinition = "NUMBER|收支结余（含财政补助）||", length = 15, nullable = true)
	private BigDecimal balance;

	@Column(name = "COMMENTS", columnDefinition = "VARCHAR2|说明|100|", length = 100, nullable = true)
	private String comments;

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

	public BigDecimal getIncomeTotal() {
		return this.incomeTotal;
	}

	public void setIncomeTotal(BigDecimal incomeTotal) {
		this.incomeTotal = incomeTotal;
	}

	public BigDecimal getSubsidyIncome() {
		return this.subsidyIncome;
	}

	public void setSubsidyIncome(BigDecimal subsidyIncome) {
		this.subsidyIncome = subsidyIncome;
	}

	public BigDecimal getExpensesTotal() {
		return this.expensesTotal;
	}

	public void setExpensesTotal(BigDecimal expensesTotal) {
		this.expensesTotal = expensesTotal;
	}

	public BigDecimal getPersonnelFunds() {
		return this.personnelFunds;
	}

	public void setPersonnelFunds(BigDecimal personnelFunds) {
		this.personnelFunds = personnelFunds;
	}

	public BigDecimal getSalariesBenefits() {
		return this.salariesBenefits;
	}

	public void setSalariesBenefits(BigDecimal salariesBenefits) {
		this.salariesBenefits = salariesBenefits;
	}

	public BigDecimal getFamilySubsidy() {
		return this.familySubsidy;
	}

	public void setFamilySubsidy(BigDecimal familySubsidy) {
		this.familySubsidy = familySubsidy;
	}

	public BigDecimal getMaterials() {
		return this.materials;
	}

	public void setMaterials(BigDecimal materials) {
		this.materials = materials;
	}

	public BigDecimal getPharmaceuticalsFee() {
		return this.pharmaceuticalsFee;
	}

	public void setPharmaceuticalsFee(BigDecimal pharmaceuticalsFee) {
		this.pharmaceuticalsFee = pharmaceuticalsFee;
	}

	public BigDecimal getDepreciation() {
		return this.depreciation;
	}

	public void setDepreciation(BigDecimal depreciation) {
		this.depreciation = depreciation;
	}

	public BigDecimal getVcFunds() {
		return this.vcFunds;
	}

	public void setVcFunds(BigDecimal vcFunds) {
		this.vcFunds = vcFunds;
	}

	public BigDecimal getOtherFee() {
		return this.otherFee;
	}

	public void setOtherFee(BigDecimal otherFee) {
		this.otherFee = otherFee;
	}

	public BigDecimal getGoodsServicesCost() {
		return this.goodsServicesCost;
	}

	public void setGoodsServicesCost(BigDecimal goodsServicesCost) {
		this.goodsServicesCost = goodsServicesCost;
	}

	public BigDecimal getOfficeCost() {
		return this.officeCost;
	}

	public void setOfficeCost(BigDecimal officeCost) {
		this.officeCost = officeCost;
	}

	public BigDecimal getPrintingCost() {
		return this.printingCost;
	}

	public void setPrintingCost(BigDecimal printingCost) {
		this.printingCost = printingCost;
	}

	public BigDecimal getWaterCost() {
		return this.waterCost;
	}

	public void setWaterCost(BigDecimal waterCost) {
		this.waterCost = waterCost;
	}

	public BigDecimal getElectriciryCost() {
		return this.electriciryCost;
	}

	public void setElectriciryCost(BigDecimal electriciryCost) {
		this.electriciryCost = electriciryCost;
	}

	public BigDecimal getSecurityCost() {
		return this.securityCost;
	}

	public void setSecurityCost(BigDecimal securityCost) {
		this.securityCost = securityCost;
	}

	public BigDecimal getTravelCost() {
		return this.travelCost;
	}

	public void setTravelCost(BigDecimal travelCost) {
		this.travelCost = travelCost;
	}

	public BigDecimal getAbroadCost() {
		return this.abroadCost;
	}

	public void setAbroadCost(BigDecimal abroadCost) {
		this.abroadCost = abroadCost;
	}

	public BigDecimal getMaintenanceCost() {
		return this.maintenanceCost;
	}

	public void setMaintenanceCost(BigDecimal maintenanceCost) {
		this.maintenanceCost = maintenanceCost;
	}

	public BigDecimal getMeetingCost() {
		return this.meetingCost;
	}

	public void setMeetingCost(BigDecimal meetingCost) {
		this.meetingCost = meetingCost;
	}

	public BigDecimal getTrainingCost() {
		return this.trainingCost;
	}

	public void setTrainingCost(BigDecimal trainingCost) {
		this.trainingCost = trainingCost;
	}

	public BigDecimal getHostingCost() {
		return this.hostingCost;
	}

	public void setHostingCost(BigDecimal hostingCost) {
		this.hostingCost = hostingCost;
	}

	public BigDecimal getOtherMaterialCost() {
		return this.otherMaterialCost;
	}

	public void setOtherMaterialCost(BigDecimal otherMaterialCost) {
		this.otherMaterialCost = otherMaterialCost;
	}

	public BigDecimal getLaborCost() {
		return this.laborCost;
	}

	public void setLaborCost(BigDecimal laborCost) {
		this.laborCost = laborCost;
	}

	public BigDecimal getCommissionsCost() {
		return this.commissionsCost;
	}

	public void setCommissionsCost(BigDecimal commissionsCost) {
		this.commissionsCost = commissionsCost;
	}

	public BigDecimal getWelfareCost() {
		return this.welfareCost;
	}

	public void setWelfareCost(BigDecimal welfareCost) {
		this.welfareCost = welfareCost;
	}

	public BigDecimal getCarCost() {
		return this.carCost;
	}

	public void setCarCost(BigDecimal carCost) {
		this.carCost = carCost;
	}

	public BigDecimal getOtherGoodsCost() {
		return this.otherGoodsCost;
	}

	public void setOtherGoodsCost(BigDecimal otherGoodsCost) {
		this.otherGoodsCost = otherGoodsCost;
	}

	public BigDecimal getOtherCost() {
		return this.otherCost;
	}

	public void setOtherCost(BigDecimal otherCost) {
		this.otherCost = otherCost;
	}

	public BigDecimal getLossesCost() {
		return this.lossesCost;
	}

	public void setLossesCost(BigDecimal lossesCost) {
		this.lossesCost = lossesCost;
	}

	public BigDecimal getInterestPayments() {
		return this.interestPayments;
	}

	public void setInterestPayments(BigDecimal interestPayments) {
		this.interestPayments = interestPayments;
	}

	public BigDecimal getWashCost() {
		return this.washCost;
	}

	public void setWashCost(BigDecimal washCost) {
		this.washCost = washCost;
	}

	public BigDecimal getProcterCost() {
		return this.procterCost;
	}

	public void setProcterCost(BigDecimal procterCost) {
		this.procterCost = procterCost;
	}

	public BigDecimal getFuelCost() {
		return this.fuelCost;
	}

	public void setFuelCost(BigDecimal fuelCost) {
		this.fuelCost = fuelCost;
	}

	public BigDecimal getOther() {
		return this.other;
	}

	public void setOther(BigDecimal other) {
		this.other = other;
	}

	public BigDecimal getCanteenCost() {
		return this.canteenCost;
	}

	public void setCanteenCost(BigDecimal canteenCost) {
		this.canteenCost = canteenCost;
	}

	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}