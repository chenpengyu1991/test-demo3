package com.founder.rhip.ehr.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@Table(name = "SR_TUBERCULOSIS")
@XmlRootElement
public class Tuberculosis implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7712033714006710659L;

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
	
	@Column(name = "REPORTING_TIME", columnDefinition = "DATE|填报时间||", nullable = true)
    private Date reportingTime;
	
	@Column(name = "UPDATE_REPORTING_TIME", columnDefinition = "DATE|填报时间||", nullable = true)
    private Date updateReportingTime;
	
	@Column(name = "REFERRAL_TB_NUM", columnDefinition = "NUMBER|推介转诊结核病患者人数||", nullable = true)
    private Integer referralTbNum=0;
	
	@Column(name = "FOLLOW_UP_TUBERCULOSIS", columnDefinition = "NUMBER|随访管理结核病患者人数||",  nullable = true)
    private Integer followUpTuberculosis=0;
	
	@Column(name = "TUBERC_NUM", columnDefinition = "NUMBER|辖区同期内经上级定点医疗机构确诊并通知基层医疗卫生机构管理的肺结核患者人数||", nullable = true)
    private Integer tubercNum=0;
	
	@Column(name = "TUBERC_MANAGE_NUM", columnDefinition = "NUMBER|已管理的肺结核患者人数||", nullable = true)
    private Integer tubercManageNum=0;	
	
	@Column(name = "TUBERC_CURE_NUM", columnDefinition = "NUMBER|同期辖区内已完成治疗的肺结核患者人数||", nullable = true)
    private Integer tubercCureNum=0;	
	
	@Column(name = "TUBERC_MEDICATION_NUM", columnDefinition = "NUMBER|按照要求规则服药的肺结核患者人数||", nullable = true)
    private Integer tubercMedicationNum=0;	
	
    private Integer householdNum=0;		
	
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

	public Date getReportingTime() {
		return reportingTime;
	}

	public void setReportingTime(Date reportingTime) {
		this.reportingTime = reportingTime;
	}

	public Date getUpdateReportingTime() {
		return updateReportingTime;
	}

	public void setUpdateReportingTime(Date updateReportingTime) {
		this.updateReportingTime = updateReportingTime;
	}

	public Integer getReferralTbNum() {
		return referralTbNum;
	}

	public void setReferralTbNum(Integer referralTbNum) {
		this.referralTbNum = referralTbNum;
	}

	public Integer getFollowUpTuberculosis() {
		return followUpTuberculosis;
	}

	public void setFollowUpTuberculosis(Integer followUpTuberculosis) {
		this.followUpTuberculosis = followUpTuberculosis;
	}

	public Integer getTubercNum() {
		return tubercNum;
	}

	public void setTubercNum(Integer tubercNum) {
		this.tubercNum = tubercNum;
	}

	public Integer getTubercManageNum() {
		return tubercManageNum;
	}

	public void setTubercManageNum(Integer tubercManageNum) {
		this.tubercManageNum = tubercManageNum;
	}

	public Integer getTubercCureNum() {
		return tubercCureNum;
	}

	public void setTubercCureNum(Integer tubercCureNum) {
		this.tubercCureNum = tubercCureNum;
	}

	public Integer getTubercMedicationNum() {
		return tubercMedicationNum;
	}

	public void setTubercMedicationNum(Integer tubercMedicationNum) {
		this.tubercMedicationNum = tubercMedicationNum;
	}

	public Integer getHouseholdNum() {
		return householdNum;
	}

	public void setHouseholdNum(Integer householdNum) {
		this.householdNum = householdNum;
	}
	
}
