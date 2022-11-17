package com.founder.rhip.ehr.entity.healtheducation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "HE_PRESCRIPTION")
public class HePrescription implements Serializable {

	private static final long serialVersionUID = -4042562865383051809L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;
	
	@Column(name = "ORG_CODE", columnDefinition = "VARCHAR2|机构代码||", length = 18, nullable = true)
	private String orgCode;
	
	@Column(name = "CENTER_ORG_CODE", columnDefinition = "VARCHAR2|上级机构代码||", length = 18, nullable = true)
	private String centerOrgCode;

	@Column(name = "GBCODE", columnDefinition = "VARCHAR2|乡镇代码||", length = 18, nullable = true)
	private String gbcode;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|处方名称||", length = 50, nullable = true)
	private String name;

	@Column(name = "TYPE", columnDefinition = "VARCHAR2|处方类型||", length = 50, nullable = true)
	private String type;

	@Column(name = "OTHER_TYPE", columnDefinition = "VARCHAR2|其他处方类型||", length = 50, nullable = true)
	private String otherType;

	@Column(name = "CONTENT", columnDefinition = "VARCHAR2|处方内容||", length = 2000, nullable = true)
	private String content;

	@Column(name = "TITLE", columnDefinition = "VARCHAR2|处方标题||", length = 200, nullable = true)
	private String title;
	
	@Column(name = "CREATE_TIME", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createTime;
	
	@Column(name = "STATUS", columnDefinition = "VARCHAR2|状态||", length = 1, nullable = true)
	private String status;

	@Column(name = "APPROVE_STATUS", columnDefinition = "VARCHAR2|审批状态（0未审批，1审批）||", length = 1, nullable = true)
	private String approveStatus;

	@Column(name = "SHARE_STATUS", columnDefinition = "VARCHAR2|共享状态（0不共享，1共享）||", length = 1, nullable = true)
	private String shareStatus;

	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除状态 0：可用 1：删除|1|", length = 1, nullable = true)
	private Integer isDelete = 0;

	@Column(name = "TIMES", columnDefinition = "NUMBER|次数|11|", length = 11, nullable = true)
	private Long times = 0l;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOtherType() {
		return otherType;
	}

	public void setOtherType(String otherType) {
		this.otherType = otherType;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public Date getCreateTime() {
		return createTime;
	}

	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	
	public String getOrgCode() {
		return orgCode;
	}

	
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
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

	
	public String getStatus() {
		return status;
	}

	
	public void setStatus(String status) {
		this.status = status;
	}

	public String getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getShareStatus() {
		return shareStatus;
	}

	public void setShareStatus(String shareStatus) {
		this.shareStatus = shareStatus;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Long getTimes() {
		return times;
	}

	public void setTimes(Long times) {
		this.times = times;
	}
}