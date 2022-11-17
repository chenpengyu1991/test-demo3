package com.founder.rhip.ehr.entity.healtheducation;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "HE_ACTIVE")
public class HeActive implements Serializable {

	
	private static final long serialVersionUID = 1963006323231286809L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;

	@Column(name = "ORG_CODE", columnDefinition = "VARCHAR2|机构代码||", length = 18, nullable = true)
	private String orgCode;
	
	@Column(name = "CENTER_ORG_CODE", columnDefinition = "VARCHAR2|上级机构代码||", length = 18, nullable = true)
	private String centerOrgCode;

	@Column(name = "GBCODE", columnDefinition = "VARCHAR2|乡镇代码||", length = 18, nullable = true)
	private String gbcode;

	@Column(name = "ACTIVE_PLACE", columnDefinition = "VARCHAR2|活动地点||", length = 100, nullable = true)
	private String activePlace;

	@Column(name = "ACTIVE_TYPE", columnDefinition = "VARCHAR2|活动类型||", length = 50, nullable = true)
	private String activeType;
	
	@Column(name = "OTHER_ACTIVE_TYPE", columnDefinition = "VARCHAR2|其他活动类型||", length = 50, nullable = true)
	private String otherActiveType;

	@Column(name = "ACTIVE_NAME", columnDefinition = "VARCHAR2|活动名称||", length = 50, nullable = true)
	private String activeName;

	@Column(name = "ACTIVE_THEME", columnDefinition = "VARCHAR2|活动主题||", length = 50, nullable = true)
	private String activeTheme;

	@Column(name = "EDUCATION_PERSON_TYPE", columnDefinition = "VARCHAR2|接受健康教育人员类别||", length = 50, nullable = true)
	private String educationPersonType;
	
	@Column(name = "OTHER_PERSON_TYPE", columnDefinition = "VARCHAR2|接受健康教育人员其他类别||", length = 50, nullable = true)
	private String otherPersonType;

	@Column(name = "ACTIVE_DETAIL", columnDefinition = "VARCHAR2|活动主要内容||", length = 2000, nullable = true)
	private String activeDetail;

	@Column(name = "WORK_PLAN", columnDefinition = "VARCHAR2|工作计划||", length = 2000, nullable = true)
	private String workPlan;

	@Column(name = "ACTIVE_TIME", columnDefinition = "DATE|活动时间||", nullable = true)
	private Date activeTime;

	@Column(name = "MEDICAL_PERSON_QUANTITY", columnDefinition = "NUMBER|出动医务人员数||", length = 5, nullable = true)
	private Integer medicalPersonQuantity;

	@Column(name = "OTHER_PERSON_QUANTITY", columnDefinition = "NUMBER|其他工作人员数||", length = 5, nullable = true)
	private Integer otherPersonQuantity;

	@Column(name = "LEADER", columnDefinition = "VARCHAR2|主要领导||", length = 100, nullable = true)
	private String leader;

	@Column(name = "ORGANIZER", columnDefinition = "VARCHAR2|组织者||", length = 50, nullable = true)
	private String organizer;

	@Column(name = "EDUCATION_PERSON_QUANTITY", columnDefinition = "NUMBER|接收健康教育人员数||", length = 5, nullable = true)
	private Integer educationPersonQuantity;

	@Column(name = "ACTIVE_TOTAL_EVAL", columnDefinition = "VARCHAR2|活动总体评价||", length = 2000, nullable = true)
	private String activeTotalEval;
	
	@Column(name = "SYSTEM_TYPE", columnDefinition = "VARCHAR2|类型标志,分区不同来源||", length = 1, nullable = true)
	private String systemType; 
	
	@Column(name = "INDUSTRY_TYPE", columnDefinition = "VARCHAR2|行业类型||", length = 1, nullable = true)
	private String industryType; 
	
	@Column(name = "BUSINESS_TYPE", columnDefinition = "VARCHAR2|行业类型||", length = 50, nullable = true)
	private String businessType;
	
	@Column(name = "OTHER_BUSINESS_TYPE", columnDefinition = "VARCHAR2|其他业务类型||", length = 50, nullable = true)
	private String otherBusinessType;
	
	@Column(name = "STATUS", columnDefinition = "VARCHAR2|状态||", length = 1, nullable = true)
	private String status;

	@Column(name = "TELL", columnDefinition = "VARCHAR2|电话|20|", length = 20, nullable = false)
	private String tell;

	@Column(name = "FILL_USER_CODE", columnDefinition = "VARCHAR2|填报用户|50|", length = 50, nullable = false)
	private String fillUserCode;

	@Column(name = "FILL_DATE", columnDefinition = "DATE|填报日期||", nullable = true)
	private Date fillDate;

	@Column(name = "PARTAKE_UNITS", columnDefinition = "VARCHAR2|参加单位|500|", length = 500, nullable = false)
	private String partakeUnits;

	@Column(name = "OTHER_CONTENT", columnDefinition = "VARCHAR2|请描述活动类别及教育人员数|100|", length = 100, nullable = false)
	private String otherContent;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrgCode() {
		return this.orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getActivePlace() {
		return this.activePlace;
	}

	public void setActivePlace(String activePlace) {
		this.activePlace = activePlace;
	}

	public String getActiveType() {
		return this.activeType;
	}

	public void setActiveType(String activeType) {
		this.activeType = activeType;
	}

	public String getActiveName() {
		return activeName;
	}

	public void setActiveName(String activeName) {
		this.activeName = activeName;
	}

	public String getActiveTheme() {
		return this.activeTheme;
	}

	public void setActiveTheme(String activeTheme) {
		this.activeTheme = activeTheme;
	}

	public String getEducationPersonType() {
		return this.educationPersonType;
	}

	public void setEducationPersonType(String educationPersonType) {
		this.educationPersonType = educationPersonType;
	}

	public String getActiveDetail() {
		return this.activeDetail;
	}

	public void setActiveDetail(String activeDetail) {
		this.activeDetail = activeDetail;
	}

	public Date getActiveTime() {
		return this.activeTime;
	}

	public void setActiveTime(Date activeTime) {
		this.activeTime = activeTime;
	}

	public Integer getMedicalPersonQuantity() {
		return this.medicalPersonQuantity;
	}

	public void setMedicalPersonQuantity(Integer medicalPersonQuantity) {
		this.medicalPersonQuantity = medicalPersonQuantity;
	}

	public Integer getOtherPersonQuantity() {
		return otherPersonQuantity;
	}

	public void setOtherPersonQuantity(Integer otherPersonQuantity) {
		this.otherPersonQuantity = otherPersonQuantity;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getOrganizer() {
		return this.organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	public Integer getEducationPersonQuantity() {
		return this.educationPersonQuantity;
	}

	public void setEducationPersonQuantity(Integer educationPersonQuantity) {
		this.educationPersonQuantity = educationPersonQuantity;
	}

	public String getActiveTotalEval() {
		return this.activeTotalEval;
	}

	public void setActiveTotalEval(String activeTotalEval) {
		this.activeTotalEval = activeTotalEval;
	}

	
	public String getCenterOrgCode() {
		return centerOrgCode;
	}

	
	public void setCenterOrgCode(String centerOrgCode) {
		this.centerOrgCode = centerOrgCode;
	}

	
	public String getGbcode() {
		return gbcode;
	}

	
	public void setGbcode(String gbcode) {
		this.gbcode = gbcode;
	}

	
	public String getOtherActiveType() {
		return otherActiveType;
	}

	
	public void setOtherActiveType(String otherActiveType) {
		this.otherActiveType = otherActiveType;
	}

	
	public String getOtherPersonType() {
		return otherPersonType;
	}

	
	public void setOtherPersonType(String otherPersonType) {
		this.otherPersonType = otherPersonType;
	}

	public String getSystemType() {
		return systemType;
	}

	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}

	public String getIndustryType() {
		return industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

	
	public String getBusinessType() {
		return businessType;
	}

	
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	
	public String getOtherBusinessType() {
		return otherBusinessType;
	}

	
	public void setOtherBusinessType(String otherBusinessType) {
		this.otherBusinessType = otherBusinessType;
	}

	
	public String getStatus() {
		return status;
	}

	
	public void setStatus(String status) {
		this.status = status;
	}

	public String getTell() {
		return tell;
	}

	public void setTell(String tell) {
		this.tell = tell;
	}

	public String getFillUserCode() {
		return fillUserCode;
	}

	public void setFillUserCode(String fillUserCode) {
		this.fillUserCode = fillUserCode;
	}

	public Date getFillDate() {
		return fillDate;
	}

	public void setFillDate(Date fillDate) {
		this.fillDate = fillDate;
	}

	public String getPartakeUnits() {
		return partakeUnits;
	}

	public void setPartakeUnits(String partakeUnits) {
		this.partakeUnits = partakeUnits;
	}

	public String getOtherContent() {
		return otherContent;
	}

	public void setOtherContent(String otherContent) {
		this.otherContent = otherContent;
	}

	public String getWorkPlan() {
		return workPlan;
	}

	public void setWorkPlan(String workPlan) {
		this.workPlan = workPlan;
	}
}
