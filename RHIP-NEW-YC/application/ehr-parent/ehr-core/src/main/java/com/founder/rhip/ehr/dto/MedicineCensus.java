package com.founder.rhip.ehr.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class MedicineCensus implements Serializable{

	private static final long serialVersionUID = -4713759358751000501L;

	@Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;
	
	@Column(name = "ORG_CODE", columnDefinition = "VARCHAR2|填报单位编码||", length = 50, nullable = true)
    private String orgCode;
	
	@Column(name = "ORG_NAME", columnDefinition = "VARCHAR2|填报单位名称||", length = 50, nullable = true)
    private String orgName;
	
	@Column(name = "CENTER_ORG_CODE", columnDefinition = "VARCHAR2|中心名称||", length = 50, nullable = true)
	private String centerOrgCode;		

	@Column(name = "GB_CODE", columnDefinition = "VARCHAR2|区名称||", length = 50, nullable = true)
	private String gbCode;	
	
	@Column(name = "YEAR", columnDefinition = "NUMBER|年||", length = 2, nullable = true)
    private Integer year;
	
	@Column(name = "MONTH", columnDefinition = "NUMBER|月||", length = 2, nullable = true)
    private Integer month;

    @Column(name = "HOUSEHOLD_GREAT_SIXF_NUM", columnDefinition = "NUMBER|户籍>=65岁老年人数量||", length = 9, nullable = true)
    private Integer householdGreatSixfNum = 0;   
	
    @Column(name = "MEDICINE_GREAT_SIXF_NUM", columnDefinition = "NUMBER|接受中医药健康管理服务>=65岁老年人数量||", length = 9, nullable = true)
    private Integer medicineGreatSixfNum = 0;   
	
    @Column(name = "DI_COUNT", columnDefinition = "NUMBER|已管理糖尿病人数||", length = 9, nullable = true)
    private Integer diCount = 0;   
    
    @Column(name = "HBP_COUNT", columnDefinition = "NUMBER|已管理高血压人数||", length = 9, nullable = true)
    private Integer hbpCount = 0;   
    
    @Column(name = "DI_MANAGE_COUNT", columnDefinition = "NUMBER|接受中医药健康管理的糖尿病人数||", length = 9, nullable = true)
    private Integer diManageCount = 0;   
    				
    @Column(name = "HBP_SERVE_COUNT", columnDefinition = "NUMBER|接受中医药健康管理的高血压人数||", length = 9, nullable = true)
    private Integer hbpServeCount = 0;   
    
    @Column(name = "WOMEN_COUNT", columnDefinition = "NUMBER|已管理孕产妇人数||", length = 9, nullable = true)
    private Integer womenCount = 0;   
    				
    @Column(name = "WOMEN_SERVE_COUNT", columnDefinition = "NUMBER|接受中医药健康管理的孕产妇人数||", length = 9, nullable = true)
    private Integer womenServeCount = 0;        
	
    @Column(name = "CHILD_COUNT", columnDefinition = "NUMBER|已管理儿童人数||", length = 9, nullable = true)
    private Integer childCount = 0;     
    
	@Column(name = "CHILD_SERVE_COUNT", columnDefinition = "NUMBER|接受全部中医药服务儿童数||", length = 2, nullable = true)
    private Integer childServeCount = 0;   
    
	private Integer householdGreatSixfSum = 0;   
	private Integer medicineGreatSixfSum = 0;   
	private Integer diSum = 0;   
	private Integer hbpSum = 0;   
	private Integer diManageSum = 0;   
	private Integer hbpManageSum = 0;   
	private Integer womenSum = 0;   
	private Integer womenServeSum = 0;   
	private Integer childSum = 0;   
	private Integer childServeSum = 0;   
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getCenterOrgCode() {
		return centerOrgCode;
	}

	public void setCenterOrgCode(String centerOrgCode) {
		this.centerOrgCode = centerOrgCode;
	}

	public String getGbCode() {
		return gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getHouseholdGreatSixfNum() {
		return householdGreatSixfNum;
	}

	public void setHouseholdGreatSixfNum(Integer householdGreatSixfNum) {
		this.householdGreatSixfNum = householdGreatSixfNum;
	}

	public Integer getMedicineGreatSixfNum() {
		return medicineGreatSixfNum;
	}

	public void setMedicineGreatSixfNum(Integer medicineGreatSixfNum) {
		this.medicineGreatSixfNum = medicineGreatSixfNum;
	}

	public Integer getHouseholdGreatSixfSum() {
		return householdGreatSixfSum;
	}

	public void setHouseholdGreatSixfSum(Integer householdGreatSixfSum) {
		this.householdGreatSixfSum = householdGreatSixfSum;
	}

	public Integer getMedicineGreatSixfSum() {
		return medicineGreatSixfSum;
	}

	public void setMedicineGreatSixfSum(Integer medicineGreatSixfSum) {
		this.medicineGreatSixfSum = medicineGreatSixfSum;
	}

	public Integer getDiCount() {
		return diCount;
	}

	public void setDiCount(Integer diCount) {
		this.diCount = diCount;
	}

	public Integer getHbpCount() {
		return hbpCount;
	}

	public void setHbpCount(Integer hbpCount) {
		this.hbpCount = hbpCount;
	}

	public Integer getDiSum() {
		return diSum;
	}

	public void setDiSum(Integer diSum) {
		this.diSum = diSum;
	}

	public Integer getHbpSum() {
		return hbpSum;
	}

	public void setHbpSum(Integer hbpSum) {
		this.hbpSum = hbpSum;
	}

	public Integer getDiManageCount() {
		return diManageCount;
	}

	public void setDiManageCount(Integer diManageCount) {
		this.diManageCount = diManageCount;
	}

	public Integer getHbpServeCount() {
		return hbpServeCount;
	}

	public void setHbpServeCount(Integer hbpServeCount) {
		this.hbpServeCount = hbpServeCount;
	}

	public Integer getDiManageSum() {
		return diManageSum;
	}

	public void setDiManageSum(Integer diManageSum) {
		this.diManageSum = diManageSum;
	}

	public Integer getHbpManageSum() {
		return hbpManageSum;
	}

	public void setHbpManageSum(Integer hbpManageSum) {
		this.hbpManageSum = hbpManageSum;
	}

	public Integer getWomenCount() {
		return womenCount;
	}

	public void setWomenCount(Integer womenCount) {
		this.womenCount = womenCount;
	}

	public Integer getWomenServeCount() {
		return womenServeCount;
	}

	public void setWomenServeCount(Integer womenServeCount) {
		this.womenServeCount = womenServeCount;
	}

	public Integer getWomenSum() {
		return womenSum;
	}

	public void setWomenSum(Integer womenSum) {
		this.womenSum = womenSum;
	}

	public Integer getWomenServeSum() {
		return womenServeSum;
	}

	public void setWomenServeSum(Integer womenServeSum) {
		this.womenServeSum = womenServeSum;
	}

	public Integer getChildCount() {
		return childCount;
	}

	public void setChildCount(Integer childCount) {
		this.childCount = childCount;
	}

	public Integer getChildSum() {
		return childSum;
	}

	public void setChildSum(Integer childSum) {
		this.childSum = childSum;
	}

	public Integer getChildServeCount() {
		return childServeCount;
	}

	public void setChildServeCount(Integer childServeCount) {
		this.childServeCount = childServeCount;
	}

	public Integer getChildServeSum() {
		return childServeSum;
	}

	public void setChildServeSum(Integer childServeSum) {
		this.childServeSum = childServeSum;
	}
	
}
