package com.founder.rhip.ehr.entity.finance;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "FC_ORGAN_FINANCE_INFO")
public class FcOrganFinanceInfo implements Serializable {

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

	@Column(name = "FINANCE_SUBSIDY", columnDefinition = "NUMBER|财政补助||", length = 15, nullable = true)
	private BigDecimal financeSubsidy;

	@Column(name = "PERSONNEL_SUBSIDY", columnDefinition = "NUMBER|人员补助||", length = 15, nullable = true)
	private BigDecimal personnelSubsidy;

	@Column(name = "MEDICAL_INCOME", columnDefinition = "NUMBER|医疗收入||", length = 15, nullable = true)
	private BigDecimal medicalIncome;

	@Column(name = "PHARMACEUTICALS_INCOME", columnDefinition = "NUMBER|药品收入||", length = 15, nullable = true)
	private BigDecimal pharmaceuticalsIncome;

	@Column(name = "SERVICE_STATION_INCOME", columnDefinition = "NUMBER|社区卫生服务站收入||", length = 15, nullable = true)
	private BigDecimal serviceStationIncome;

	@Column(name = "EXPENSES_TOTAL", columnDefinition = "NUMBER|支出合计||", length = 15, nullable = true)
	private BigDecimal expensesTotal;

	@Column(name = "MEDICAL_HEALTH_COST", columnDefinition = "NUMBER|医疗卫生支出||", length = 15, nullable = true)
	private BigDecimal medicalHealthCost;

	@Column(name = "MEDICAL_COST", columnDefinition = "NUMBER|医疗支出||", length = 15, nullable = true)
	private BigDecimal medicalCost;

	@Column(name = "PUBLIC_HEALTH_COST", columnDefinition = "NUMBER|公共卫生支出||", length = 15, nullable = true)
	private BigDecimal publicHealthCost;

	@Column(name = "PHARMACEUTICALS_COST", columnDefinition = "NUMBER|药品支出||", length = 15, nullable = true)
	private BigDecimal pharmaceuticalsCost;

	@Column(name = "DIVISE_COST", columnDefinition = "NUMBER|财政基建设备补助支出||", length = 15, nullable = true)
	private BigDecimal deviceCost;

	@Column(name = "PERIOD_BALANCE", columnDefinition = "NUMBER|本期结余||", length = 15, nullable = true)
	private BigDecimal periodBalance;

	@Column(name = "PERIOD_BALANCE_NO_SUBSIDY", columnDefinition = "NUMBER|本期结余(不含财政补助）||", length = 15, nullable = true)
	private BigDecimal periodBalanceNoSubsidy;

	@Column(name = "DRUG_INCOME_PROPORTION", columnDefinition = "NUMBER|药品收入占业务总收入比例%||", length = 15, nullable = true)
	private BigDecimal drugIncomeProportion;

	@Column(name = "DRUG_INCOME_PAYOUT_RATE", columnDefinition = "NUMBER|药品收支差率%||", length = 15, nullable = true)
	private BigDecimal drugIncomePayoutRate;

	@Column(name = "INCOME_TOTAL_LAST_PERIED", columnDefinition = "NUMBER|收入合计(去年同期)||", length = 15, nullable = true)
	private BigDecimal incomeTotalLastPeriod;

	@Column(name = "FINANCE_SUBSIDY_LAST_PERIED", columnDefinition = "NUMBER|财政补助(去年同期)||", length = 15, nullable = true)
	private BigDecimal financeSubsidyLastPeriod;

	@Column(name = "BALANCE_LAST_PERIED", columnDefinition = "NUMBER|结余(去年同期)||", length = 15, nullable = true)
	private BigDecimal balanceLastPeriod;

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

	public BigDecimal getFinanceSubsidy() {
		return this.financeSubsidy;
	}

	public void setFinanceSubsidy(BigDecimal financeSubsidy) {
		this.financeSubsidy = financeSubsidy;
	}

	public BigDecimal getPersonnelSubsidy() {
		return this.personnelSubsidy;
	}

	public void setPersonnelSubsidy(BigDecimal personnelSubsidy) {
		this.personnelSubsidy = personnelSubsidy;
	}

	public BigDecimal getMedicalIncome() {
		return this.medicalIncome;
	}

	public void setMedicalIncome(BigDecimal medicalIncome) {
		this.medicalIncome = medicalIncome;
	}

	public BigDecimal getPharmaceuticalsIncome() {
		return this.pharmaceuticalsIncome;
	}

	public void setPharmaceuticalsIncome(BigDecimal pharmaceuticalsIncome) {
		this.pharmaceuticalsIncome = pharmaceuticalsIncome;
	}

	public BigDecimal getServiceStationIncome() {
		return this.serviceStationIncome;
	}

	public void setServiceStationIncome(BigDecimal serviceStationIncome) {
		this.serviceStationIncome = serviceStationIncome;
	}

	public BigDecimal getExpensesTotal() {
		return this.expensesTotal;
	}

	public void setExpensesTotal(BigDecimal expensesTotal) {
		this.expensesTotal = expensesTotal;
	}

	public BigDecimal getMedicalHealthCost() {
		return this.medicalHealthCost;
	}

	public void setMedicalHealthCost(BigDecimal medicalHealthCost) {
		this.medicalHealthCost = medicalHealthCost;
	}

	public BigDecimal getMedicalCost() {
		return this.medicalCost;
	}

	public void setMedicalCost(BigDecimal medicalCost) {
		this.medicalCost = medicalCost;
	}

	public BigDecimal getPublicHealthCost() {
		return this.publicHealthCost;
	}

	public void setPublicHealthCost(BigDecimal publicHealthCost) {
		this.publicHealthCost = publicHealthCost;
	}

	public BigDecimal getPharmaceuticalsCost() {
		return this.pharmaceuticalsCost;
	}

	public void setPharmaceuticalsCost(BigDecimal pharmaceuticalsCost) {
		this.pharmaceuticalsCost = pharmaceuticalsCost;
	}

	public BigDecimal getDeviceCost() {
		return this.deviceCost;
	}

	public void setDeviceCost(BigDecimal deviceCost) {
		this.deviceCost = deviceCost;
	}

	public BigDecimal getPeriodBalance() {
		return this.periodBalance;
	}

	public void setPeriodBalance(BigDecimal periodBalance) {
		this.periodBalance = periodBalance;
	}

	public BigDecimal getPeriodBalanceNoSubsidy() {
		return this.periodBalanceNoSubsidy;
	}

	public void setPeriodBalanceNoSubsidy(BigDecimal periodBalanceNoSubsidy) {
		this.periodBalanceNoSubsidy = periodBalanceNoSubsidy;
	}

	public BigDecimal getDrugIncomeProportion() {
		return this.drugIncomeProportion;
	}

	public void setDrugIncomeProportion(BigDecimal drugIncomeProportion) {
		this.drugIncomeProportion = drugIncomeProportion;
	}

	public BigDecimal getDrugIncomePayoutRate() {
		return this.drugIncomePayoutRate;
	}

	public void setDrugIncomePayoutRate(BigDecimal drugIncomePayoutRate) {
		this.drugIncomePayoutRate = drugIncomePayoutRate;
	}

	public BigDecimal getIncomeTotalLastPeriod() {
		return this.incomeTotalLastPeriod;
	}

	public void setIncomeTotalLastPeriod(BigDecimal incomeTotalLastPeriod) {
		this.incomeTotalLastPeriod = incomeTotalLastPeriod;
	}

	public BigDecimal getFinanceSubsidyLastPeriod() {
		return this.financeSubsidyLastPeriod;
	}

	public void setFinanceSubsidyLastPeriod(BigDecimal financeSubsidyLastPeriod) {
		this.financeSubsidyLastPeriod = financeSubsidyLastPeriod;
	}

	public BigDecimal getBalanceLastPeriod() {
		return this.balanceLastPeriod;
	}

	public void setBalanceLastPeriod(BigDecimal balanceLastPeriod) {
		this.balanceLastPeriod = balanceLastPeriod;
	}

}