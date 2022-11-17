package com.founder.rhip.ehr.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author admin
 *
 */
public class DoctorSignCensus implements Serializable{

	private static final long serialVersionUID = -711226344140669458L;

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
    
	@Column(name = "DOCTOR_TEAM_NUM", columnDefinition = "NUMBER|已组建家庭医生团队数（个）||", length = 9, nullable = true)
    private Integer doctorTeamNum = 0;
	
	@Column(name = "HOUSEHOLD_NUM", columnDefinition = "NUMBER|辖区户籍人口数（人）||", length = 9, nullable = true)
    private Integer householdNum = 0;
	
	@Column(name = "PERMANENT_NUM", columnDefinition = "NUMBER|辖区内常住居民数（人）||", length = 9, nullable = true)
    private Integer permanentNum = 0;
	
	@Column(name = "PERMANENT_SIGN_NUM", columnDefinition = "NUMBER|常住人口签约数（人）||", length = 9, nullable = true)
    private Integer permanentSignNum = 0;
	
	@Column(name = "FOCUS_GROUPS_NUM", columnDefinition = "NUMBER|辖区内重点人群总数（人）||", length = 9, nullable = true)
    private Integer focusGroupsNum = 0;
	
	@Column(name = "FOCUS_GROUPS_SIGN_NUM", columnDefinition = "NUMBER|重点人群签约数（人）||", length = 9, nullable = true)
    private Integer focusGroupsSignNum = 0;		
	
	@Column(name = "child_NUM", columnDefinition = "NUMBER|0-6岁儿童数（人）||", length = 9, nullable = true)
    private Integer childNum = 0;		
	
	@Column(name = "family_Visit_NUM", columnDefinition = "NUMBER|辖区内接受1次及以上随访的0-6岁儿童数（人）||", length = 9, nullable = true)
    private Integer familyVisitNum = 0;		
	
	@Column(name = "CHILD_SIGN_NUM", columnDefinition = "NUMBER|0-6岁儿童签约数||", length = 9, nullable = true)
    private Integer childSignNum = 0;	
	
	@Column(name = "HOUSEHOLD_GREAT_SIXF_NUM", columnDefinition = "NUMBER|辖区内65岁及以上常住居民数||", length = 9, nullable = true)
    private Integer householdGreatSixfNum = 0;	
	
	@Column(name = "GREAT_SIXF_HAS_NUM", columnDefinition = "NUMBER|辖区内65岁及以上已管理常住居民数||", length = 9, nullable = true)
    private Integer greatSixfHasNum = 0;	
	
	@Column(name = "GREAT_SIXF_SIGN_NUM", columnDefinition = "NUMBER|65岁及以上常住居民签约数||", length = 9, nullable = true)
    private Integer greatSixfSignNum = 0;	
	
	@Column(name = "WOMEN_NUM", columnDefinition = "NUMBER|辖区内孕13周之前建册并进行第一次产前检查的产妇人数(人)||", length = 9, nullable = true)
    private Integer womenNum = 0;	

	@Column(name = "WOMEN_SIGN_NUM", columnDefinition = "NUMBER|孕产妇签约数||", length = 9, nullable = true)
    private Integer womenSignNum = 0;	

	@Column(name = "HBP_NUM", columnDefinition = "NUMBER|年内辖区内高血压患者总人数||", length = 9, nullable = true)
    private Integer hbpNum = 0;	

	@Column(name = "HBP_HAS_NUM", columnDefinition = "NUMBER|辖区内已管理高血压患者人数||", length = 9, nullable = true)
    private Integer hbpHasNum = 0;	

	@Column(name = "HBP_SIGN_NUM", columnDefinition = "NUMBER|在管高血压患者家庭医生签约数||", length = 9, nullable = true)
    private Integer hbpSignNum = 0;	

	@Column(name = "DI_NUM", columnDefinition = "NUMBER|年内辖区内糖尿病患者总人数||", length = 9, nullable = true)
    private Integer diNum = 0;	

	@Column(name = "DI_HAS_NUM", columnDefinition = "NUMBER|辖区内已管理糖尿病患者人数||", length = 9, nullable = true)
    private Integer diHasNum = 0;	

	@Column(name = "DI_SIGN_NUM", columnDefinition = "NUMBER|在管糖尿病患者家庭医生签约数||", length = 9, nullable = true)
    private Integer diSignNum = 0;

	@Column(name = "TUBERC_MANAGE_NUM", columnDefinition = "NUMBER|已管理的肺结核患者人数||", length = 9, nullable = true)
    private Integer tubercManageNum = 0;	

	@Column(name = "TUBERC_SIGN_NUM", columnDefinition = "NUMBER|肺结核患者签约人数||", length = 9, nullable = true)
    private Integer tubercSignNum = 0;	

    @Column(name = "MENTAL_MANAGE_NUM", columnDefinition = "NUMBER|按照规范要求进行管理的严重精神障碍患者人数||", nullable = true)
    private Integer mentalManageNum = 0;

    @Column(name = "MENTAL_SIGN_NUM", columnDefinition = "NUMBER|严重精神障碍患者签约人数||", nullable = true)
    private Integer mentalSignNum = 0; 
    
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

	public Integer getDoctorTeamNum() {
		return doctorTeamNum;
	}

	public void setDoctorTeamNum(Integer doctorTeamNum) {
		this.doctorTeamNum = doctorTeamNum;
	}

	public Integer getHouseholdNum() {
		return householdNum;
	}

	public void setHouseholdNum(Integer householdNum) {
		this.householdNum = householdNum;
	}

	public Integer getPermanentNum() {
		return permanentNum;
	}

	public void setPermanentNum(Integer permanentNum) {
		this.permanentNum = permanentNum;
	}

	public Integer getPermanentSignNum() {
		return permanentSignNum;
	}

	public void setPermanentSignNum(Integer permanentSignNum) {
		this.permanentSignNum = permanentSignNum;
	}

	public Integer getFocusGroupsNum() {
		return focusGroupsNum;
	}

	public void setFocusGroupsNum(Integer focusGroupsNum) {
		this.focusGroupsNum = focusGroupsNum;
	}

	public Integer getFocusGroupsSignNum() {
		return focusGroupsSignNum;
	}

	public void setFocusGroupsSignNum(Integer focusGroupsSignNum) {
		this.focusGroupsSignNum = focusGroupsSignNum;
	}

	public Integer getChildNum() {
		return childNum;
	}

	public void setChildNum(Integer childNum) {
		this.childNum = childNum;
	}

	public Integer getFamilyVisitNum() {
		return familyVisitNum;
	}

	public void setFamilyVisitNum(Integer familyVisitNum) {
		this.familyVisitNum = familyVisitNum;
	}

	public Integer getChildSignNum() {
		return childSignNum;
	}

	public void setChildSignNum(Integer childSignNum) {
		this.childSignNum = childSignNum;
	}

	public Integer getHouseholdGreatSixfNum() {
		return householdGreatSixfNum;
	}

	public void setHouseholdGreatSixfNum(Integer householdGreatSixfNum) {
		this.householdGreatSixfNum = householdGreatSixfNum;
	}

	public Integer getGreatSixfHasNum() {
		return greatSixfHasNum;
	}

	public void setGreatSixfHasNum(Integer greatSixfHasNum) {
		this.greatSixfHasNum = greatSixfHasNum;
	}

	public Integer getGreatSixfSignNum() {
		return greatSixfSignNum;
	}

	public void setGreatSixfSignNum(Integer greatSixfSignNum) {
		this.greatSixfSignNum = greatSixfSignNum;
	}

	public Integer getWomenNum() {
		return womenNum;
	}

	public void setWomenNum(Integer womenNum) {
		this.womenNum = womenNum;
	}

	public Integer getWomenSignNum() {
		return womenSignNum;
	}

	public void setWomenSignNum(Integer womenSignNum) {
		this.womenSignNum = womenSignNum;
	}

	public Integer getHbpNum() {
		return hbpNum;
	}

	public void setHbpNum(Integer hbpNum) {
		this.hbpNum = hbpNum;
	}

	public Integer getHbpHasNum() {
		return hbpHasNum;
	}

	public void setHbpHasNum(Integer hbpHasNum) {
		this.hbpHasNum = hbpHasNum;
	}

	public Integer getHbpSignNum() {
		return hbpSignNum;
	}

	public void setHbpSignNum(Integer hbpSignNum) {
		this.hbpSignNum = hbpSignNum;
	}

	public Integer getDiNum() {
		return diNum;
	}

	public void setDiNum(Integer diNum) {
		this.diNum = diNum;
	}

	public Integer getDiHasNum() {
		return diHasNum;
	}

	public void setDiHasNum(Integer diHasNum) {
		this.diHasNum = diHasNum;
	}

	public Integer getDiSignNum() {
		return diSignNum;
	}

	public void setDiSignNum(Integer diSignNum) {
		this.diSignNum = diSignNum;
	}

	public Integer getTubercManageNum() {
		return tubercManageNum;
	}

	public void setTubercManageNum(Integer tubercManageNum) {
		this.tubercManageNum = tubercManageNum;
	}

	public Integer getTubercSignNum() {
		return tubercSignNum;
	}

	public void setTubercSignNum(Integer tubercSignNum) {
		this.tubercSignNum = tubercSignNum;
	}

	public Integer getMentalManageNum() {
		return mentalManageNum;
	}

	public void setMentalManageNum(Integer mentalManageNum) {
		this.mentalManageNum = mentalManageNum;
	}

	public Integer getMentalSignNum() {
		return mentalSignNum;
	}

	public void setMentalSignNum(Integer mentalSignNum) {
		this.mentalSignNum = mentalSignNum;
	}				
	
}
