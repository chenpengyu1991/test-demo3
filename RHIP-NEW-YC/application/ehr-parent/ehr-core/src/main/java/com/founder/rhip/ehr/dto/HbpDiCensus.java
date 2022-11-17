package com.founder.rhip.ehr.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class HbpDiCensus implements Serializable{

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
    
    @Column(name = "HBP_COUNT", columnDefinition = "NUMBER|辖区内已管理高血压患者人数||", length = 9, nullable = true)
    private Integer hbpCount = 0;
    				
    @Column(name = "HBP_MANAGE_COUNT", columnDefinition = "NUMBER|按照规范要求进行高血压患者健康管理的人数||", length = 9, nullable = true)
    private Integer hbpManageCount = 0;   
    
    @Column(name = "HBP_BP_COUNT", columnDefinition = "NUMBER|最后一次随访血压达标人数||", length = 9, nullable = true)
    private Integer hbpBpCount = 0;  
    
    @Column(name = "HBP_SIGN_COUNT", columnDefinition = "NUMBER|在管高血压患者家庭医生签约人数||", length = 9, nullable = true)
    private Integer hbpSignCount = 0;  

    @Column(name = "HBP_SHOULD_COUNT", columnDefinition = "NUMBER|高血压患者人数||", length = 9, nullable = true)
    private Integer hbpShouldCount = 0;  
    
    @Column(name = "DI_COUNT", columnDefinition = "NUMBER|辖区内已管理的2型糖尿病患者人数||", length = 9, nullable = true)
    private Integer diCount = 0;
    
    @Column(name = "DI_MANAGE_COUNT", columnDefinition = "NUMBER|按照规范要求进行2型糖尿病患者人数||", length = 9, nullable = true)
    private Integer diManageCount = 0;
 
    @Column(name = "DI_BS_COUNT", columnDefinition = "NUMBER|最近一次随访空腹血糖达标人数||", length = 9, nullable = true)
    private Integer diBsCount = 0;
 
    @Column(name = "DI_SHOULD_COUNT", columnDefinition = "NUMBER|糖尿病患者人数||", length = 9, nullable = true)
    private Integer diShouldCount = 0;

	@Column(name = "DI_SIGN_COUNT", columnDefinition = "NUMBER|在管糖尿病患者家庭医生签约人数||", length = 9, nullable = true)
	private Integer diSignCount = 0;

	@Column(name = "DI_TWOHOUR_COUNT", columnDefinition = "NUMBER|最近一次餐后2小时血糖达标人数||", length = 9, nullable = true)
	private Integer diTwohourCount = 0;

	private Integer hbpSum;
    private Integer hbpManageSum;
    private Integer hbpBpSum;
    private Integer hbpSignSum;
    private Integer hbpShouldSum;
    private Integer diSum;
    private Integer diManageSum;
    private Integer diBsSum;
    private Integer diShouldSum;
	private Integer diTwoHSum;

	public Integer getDiTwohourCount() {
		return diTwohourCount;
	}

	public void setDiTwohourCount(Integer diTwohourCount) {
		this.diTwohourCount = diTwohourCount;
	}

	public Integer getDiTwoHSum() {
		return diTwoHSum;
	}

	public void setDiTwoHSum(Integer diTwoHSum) {
		this.diTwoHSum = diTwoHSum;
	}

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
	public Integer getHbpCount() {
		return hbpCount;
	}
	public void setHbpCount(Integer hbpCount) {
		this.hbpCount = hbpCount;
	}
	public Integer getHbpManageCount() {
		return hbpManageCount;
	}
	public void setHbpManageCount(Integer hbpManageCount) {
		this.hbpManageCount = hbpManageCount;
	}
	public Integer getHbpSignCount() {
		return hbpSignCount;
	}
	public void setHbpSignCount(Integer hbpSignCount) {
		this.hbpSignCount = hbpSignCount;
	}
	public Integer getDiCount() {
		return diCount;
	}
	public void setDiCount(Integer diCount) {
		this.diCount = diCount;
	}
	public Integer getDiManageCount() {
		return diManageCount;
	}
	public void setDiManageCount(Integer diManageCount) {
		this.diManageCount = diManageCount;
	}
	public Integer getHbpSum() {
		return hbpSum;
	}
	public void setHbpSum(Integer hbpSum) {
		this.hbpSum = hbpSum;
	}
	public Integer getHbpManageSum() {
		return hbpManageSum;
	}
	public void setHbpManageSum(Integer hbpManageSum) {
		this.hbpManageSum = hbpManageSum;
	}
	public Integer getHbpSignSum() {
		return hbpSignSum;
	}
	public void setHbpSignSum(Integer hbpSignSum) {
		this.hbpSignSum = hbpSignSum;
	}
	public Integer getDiSum() {
		return diSum;
	}
	public void setDiSum(Integer diSum) {
		this.diSum = diSum;
	}
	public Integer getDiManageSum() {
		return diManageSum;
	}
	public void setDiManageSum(Integer diManageSum) {
		this.diManageSum = diManageSum;
	}
	public Integer getHbpBpCount() {
		return hbpBpCount;
	}
	public void setHbpBpCount(Integer hbpBpCount) {
		this.hbpBpCount = hbpBpCount;
	}
	public Integer getDiBsCount() {
		return diBsCount;
	}
	public void setDiBsCount(Integer diBsCount) {
		this.diBsCount = diBsCount;
	}
	public Integer getHbpBpSum() {
		return hbpBpSum;
	}
	public void setHbpBpSum(Integer hbpBpSum) {
		this.hbpBpSum = hbpBpSum;
	}
	public Integer getDiBsSum() {
		return diBsSum;
	}
	public void setDiBsSum(Integer diBsSum) {
		this.diBsSum = diBsSum;
	}
	public Integer getHbpShouldCount() {
		return hbpShouldCount;
	}
	public void setHbpShouldCount(Integer hbpShouldCount) {
		this.hbpShouldCount = hbpShouldCount;
	}
	public Integer getDiShouldCount() {
		return diShouldCount;
	}
	public void setDiShouldCount(Integer diShouldCount) {
		this.diShouldCount = diShouldCount;
	}
	public Integer getHbpShouldSum() {
		return hbpShouldSum;
	}
	public void setHbpShouldSum(Integer hbpShouldSum) {
		this.hbpShouldSum = hbpShouldSum;
	}
	public Integer getDiShouldSum() {
		return diShouldSum;
	}
	public void setDiShouldSum(Integer diShouldSum) {
		this.diShouldSum = diShouldSum;
	}

	public Integer getDiSignCount() {
		return diSignCount;
	}

	public void setDiSignCount(Integer diSignCount) {
		this.diSignCount = diSignCount;
	}


}
