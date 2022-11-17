package com.founder.rhip.ehr.entity.healtheducation;

import com.founder.rhip.ehr.common.EHRConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "HE_WORK_PLAN")
public class HeWorkPlan implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|自增长id|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "PLAN_TYPE", columnDefinition = "VARCHAR2|计划类型|10|", length = 10, nullable = true)
	private String planType;

	@Column(name = "PLAN_CONTENT", columnDefinition = "CLOB|计划内容|100|", nullable = true)
	private String planContent;

	@Column(name = "BEGIN_DATE", columnDefinition = "DATE|计划开始日期|", length = 200, nullable = true)
	private Date beginDate;
	
	@Column(name = "END_DATE", columnDefinition = "DATE|计划结束日期|",  nullable = true)
	private Date endDate;

	@Column(name = "CREATE_DATE", columnDefinition = "DATE|创建日期", length = 50, nullable = true)
	private Date createDate;

	@Column(name = "CREATE_GBCODE", columnDefinition = "VARCHAR2|创建机构上上级编码|50|", length = 50, nullable = true)
	private String createGbcode;

	@Column(name = "CREATE_CENTER_ORG_CODE", columnDefinition = "VARCHAR2|创建机构上级编码|50|", length = 50, nullable = true)
	private String createCenterOrgCode;

	@Column(name = "CREATE_ORG_CODE", columnDefinition = "VARCHAR2|创建机构|50|", length = 50, nullable = true)
	private String createOrgCode;

	@Column(name = "CREATE_USER_CODE", columnDefinition = "VARCHAR2|创建人|50|", length = 18, nullable = true)
	private String createUserCode;

	@Column(name = "UPDATE_DATE", columnDefinition = "DATE|更新日期|", length = 50, nullable = true)
	private Date updateDate;

	@Column(name = "UPDATE_GBCODE", columnDefinition = "VARCHAR2|更新机构上上级编码|50|", length = 50, nullable = true)
	private String updateGbcode;

	@Column(name = "UPDATE_CENTER_ORG_CODE", columnDefinition = "VARCHAR2|更新机构上级编码|50|", length = 50, nullable = true)
	private String updateCenterOrgCode;

	@Column(name = "UPDATE_ORG_CODE", columnDefinition = "VARCHAR2|更新机构|50|", length = 50, nullable = true)
	private String updateOrgCode;

	@Column(name = "UPDATE_USER_CODE", columnDefinition = "VARCHAR2|更新人|50|", length = 18, nullable = true)
	private String updateUserCode;

	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除标识（0正常，－1删除）|", length = 1, nullable = true)
	private Integer isDelete = EHRConstants.DELETE_FLG_0;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public String getPlanContent() {
		return planContent;
	}

	public void setPlanContent(String planContent) {
		this.planContent = planContent;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateOrgCode() {
		return createOrgCode;
	}

	public void setCreateOrgCode(String createOrgCode) {
		this.createOrgCode = createOrgCode;
	}

	public String getCreateUserCode() {
		return createUserCode;
	}

	public void setCreateUserCode(String createUserCode) {
		this.createUserCode = createUserCode;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateOrgCode() {
		return updateOrgCode;
	}

	public void setUpdateOrgCode(String updateOrgCode) {
		this.updateOrgCode = updateOrgCode;
	}

	public String getUpdateUserCode() {
		return updateUserCode;
	}

	public void setUpdateUserCode(String updateUserCode) {
		this.updateUserCode = updateUserCode;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getCreateGbcode() {
		return createGbcode;
	}

	public void setCreateGbcode(String createGbcode) {
		this.createGbcode = createGbcode;
	}

	public String getCreateCenterOrgCode() {
		return createCenterOrgCode;
	}

	public void setCreateCenterOrgCode(String createCenterOrgCode) {
		this.createCenterOrgCode = createCenterOrgCode;
	}

	public String getUpdateGbcode() {
		return updateGbcode;
	}

	public void setUpdateGbcode(String updateGbcode) {
		this.updateGbcode = updateGbcode;
	}

	public String getUpdateCenterOrgCode() {
		return updateCenterOrgCode;
	}

	public void setUpdateCenterOrgCode(String updateCenterOrgCode) {
		this.updateCenterOrgCode = updateCenterOrgCode;
	}
}