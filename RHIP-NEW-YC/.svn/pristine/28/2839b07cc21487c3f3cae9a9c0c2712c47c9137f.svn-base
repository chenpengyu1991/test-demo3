package com.founder.rhip.ehr.entity.management;

import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.common.EHRConstants;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 随访计划表
 * 
 * @author liuk
 * 
 */
@Entity
@Table(name = "DM_FOLLOWUP_PLAN")
public class DMFollowupPlan implements Serializable {

	private static final long serialVersionUID = -2119999927357711727L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = true)
	private Long id;

	@Column(name = "PLAN_ID", columnDefinition = "NUMBER|保健计划id||", length = 11, nullable = true)
	private Long planId;

	@Column(name = "FOLLOWUP_ID", columnDefinition = "NUMBER|随访记录Id||", length = 11, nullable = true)
	private Long followupId;

	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|个人信息唯一编号||", length = 11, nullable = true)
	private Long personId;

	@Column(name = "DIS_TYPE", columnDefinition = "VARCHAR2|慢病类型||", length = 1, nullable = true)
	private String disType;

	@Column(name = "PLAN_YEAR", columnDefinition = "VARCHAR2|保健计划年度||", length = 70, nullable = true)
	private String planYear;

	@Column(name = "PLAN_DATE", columnDefinition = "TIMESTAMP|计划日期||", nullable = true)
	private Date planDate;

	@Column(name = "FOLLOWUP_DATE", columnDefinition = "TIMESTAMP|随访日期||", nullable = true)
	private Date followupDate;

	@Column(name = "CREATE_ORGAN_NAME", columnDefinition = "VARCHAR2|填报机构名称||", length = 70, nullable = true)
	private String createOrganName;

	@Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|填报机构编码||", length = 50, nullable = true)
	private String createOrganCode;

	@Column(name = "CREATE_DOCTOR_NAME", columnDefinition = "VARCHAR2|填报人姓名||", length = 50, nullable = true)
	private String createDoctorName;

	@Column(name = "CREATE_DOCTOR_CODE", columnDefinition = "VARCHAR2|填报人编码||", length = 18, nullable = true)
	private String createDoctorCode;

	@Column(name = "CREATE_DATE", columnDefinition = "TIMESTAMP|填报时间||", nullable = true)
	private Date createDate;

	@Column(name = "UPDATE_ORGAN_CODE", columnDefinition = "VARCHAR2|更新机构编码||", length = 50, nullable = true)
	private String updateOrganCode;

	@Column(name = "UPDATE_ORGAN_NAME", columnDefinition = "VARCHAR2|更新机构名称||", length = 70, nullable = true)
	private String updateOrganName;

	@Column(name = "UPDATE_DOCTOR_CODE", columnDefinition = "VARCHAR2|更新人编码||", length = 18, nullable = true)
	private String updateDoctorCode;

	@Column(name = "UPDATE_DOCTOR_NAME", columnDefinition = "VARCHAR2|更新人姓名||", length = 50, nullable = true)
	private String updateDoctorName;

	@Column(name = "UPDATE_DATE", columnDefinition = "TIMESTAMP|更新日期和时间||", nullable = true)
	private Date updateDate;

	@Column(name = "IS_DELETE", columnDefinition = "INT|删除状态||", nullable = true)
	private Integer isDelete = EHRConstants.DELETE_FLG_0;

	@Deprecated
	@Column(name = "TYPE", columnDefinition = "VARCHAR2|此字段已废弃使用||", length = 2, nullable = true)
	private String type;

	@Column(name = "PLAN_TYPE", columnDefinition = "VARCHAR2|随访类型 1:计划内 2:随访不满意新增随访 3:随访页面点击新增||", length = 2, nullable = true)
	private String planType;

	@Column(name = "REASON_FOLLOW_ID", columnDefinition = "NUMBER|因为上次随访指标不满意才生成的随访计划 上次随访的ID||", length = 11, nullable = true)
	private Long reasonFollowId;

	@Deprecated
	public String getType() {
		return type;
	}

	@Deprecated
	public void setType(String type) {
		this.type = type;
	}

	@Transient
	private String followupFlag;// 随访类型
	
	@Transient
	private Integer followupCount;// 随访次数

	@Transient
	private boolean repeatDateFlag;//日期是否重复

	public boolean getRepeatDateFlag() {
		return repeatDateFlag;
	}

	public void setRepeatDateFlag(boolean repeatDateFlag) {
		this.repeatDateFlag = repeatDateFlag;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPlanId() {
		return planId;
	}

	public void setPlanId(Long planId) {
		this.planId = planId;
	}

	public Long getFollowupId() {
		return followupId;
	}

	public void setFollowupId(Long followupId) {
		this.followupId = followupId;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getDisType() {
		return disType;
	}

	public void setDisType(String disType) {
		this.disType = disType;
	}

	public String getPlanYear() {
		return planYear;
	}

	public void setPlanYear(String planYear) {
		this.planYear = planYear;
	}

	public Date getPlanDate() {
		return planDate;
	}

	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}

	public Date getFollowupDate() {
		return followupDate;
	}

	public void setFollowupDate(Date followupDate) {
		this.followupDate = followupDate;
	}

	public String getCreateOrganName() {
		return createOrganName;
	}

	public void setCreateOrganName(String createOrganName) {
		this.createOrganName = createOrganName;
	}

	public String getCreateOrganCode() {
		return createOrganCode;
	}

	public void setCreateOrganCode(String createOrganCode) {
		this.createOrganCode = createOrganCode;
	}

	public String getCreateDoctorName() {
		return createDoctorName;
	}

	public void setCreateDoctorName(String createDoctorName) {
		this.createDoctorName = createDoctorName;
	}

	public String getCreateDoctorCode() {
		return createDoctorCode;
	}

	public void setCreateDoctorCode(String createDoctorCode) {
		this.createDoctorCode = createDoctorCode;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateOrganCode() {
		return updateOrganCode;
	}

	public void setUpdateOrganCode(String updateOrganCode) {
		this.updateOrganCode = updateOrganCode;
	}

	public String getUpdateOrganName() {
		return updateOrganName;
	}

	public void setUpdateOrganName(String updateOrganName) {
		this.updateOrganName = updateOrganName;
	}

	public String getUpdateDoctorCode() {
		return updateDoctorCode;
	}

	public void setUpdateDoctorCode(String updateDoctorCode) {
		this.updateDoctorCode = updateDoctorCode;
	}

	public String getUpdateDoctorName() {
		return updateDoctorName;
	}

	public void setUpdateDoctorName(String updateDoctorName) {
		this.updateDoctorName = updateDoctorName;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getFollowupFlag() {
		return followupFlag;
	}

	public void setFollowupFlag(String followupFlag) {
		this.followupFlag = followupFlag;
	}

	public Integer getFollowupCount() {
		return followupCount;
	}

	public void setFollowupCount(Integer followupCount) {
		this.followupCount = followupCount;
	}

	public Long getReasonFollowId() {
		return reasonFollowId;
	}

	public void setReasonFollowId(Long reasonFollowId) {
		this.reasonFollowId = reasonFollowId;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public boolean getPastVistFlag() {
		//逾期随访标记
		boolean b = false;
		Date n = new Date();
		if(planDate==null)
			return b;
		if(planDate.compareTo(n)>=0)
			return b;
		int days = DateUtil.getBetweenDays(planDate,n);
		if(days>30)
			b = true;
		return b;
	}

	/***
	 * 是否前后一个月内
	 * @return
	 */
	public boolean isBeForeOrAfteAMonth() {
		//逾期随访标记
		boolean b = false;
		if(planDate==null)
			return b;
		Date n = new Date();
		int days = DateUtil.getBetweenDays(planDate,n);
		if(days<=30&&days>=-30)
			b = true;
		return b;
	}

	public boolean getFthSeasonFlag() {
		//是否第四季度随访标记
		boolean b = false;
		int m = planDate.getMonth();
		if(m>=9)
			b = true;
		return b;
	}
}
