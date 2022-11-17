
package com.founder.rhip.ehr.entity.healtheducation;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "HE_RESOURCE_RECORD")
public class HeResourceRecord implements Serializable {

	private static final long serialVersionUID = -1241439653931956709L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;

	@Column(name = "ACTIVE_ID", columnDefinition = "NUMBER|健康教育活动主键||", length = 11, nullable = true)
	private Long activeId;

	@Column(name = "ORG_CODE", columnDefinition = "VARCHAR2|机构代码||", length = 18, nullable = true)
	private String orgCode;

	@Column(name = "CENTER_ORG_CODE", columnDefinition = "VARCHAR2|上级机构代码||", length = 18, nullable = true)
	private String centerOrgCode;

	@Column(name = "GBCODE", columnDefinition = "VARCHAR2|乡镇代码||", length = 18, nullable = true)
	private String gbcode;

	@Column(name = "POSITION_TYPE", columnDefinition = "VARCHAR2|阵地类型||", length = 50, nullable = true)
	private String positionType;

	@Column(name = "PLACE", columnDefinition = "VARCHAR2|地点||", length = 100, nullable = true)
	private String place;

	@Column(name = "PAGE_QUANTITY", columnDefinition = "NUMBER|版面数量||", length = 5, nullable = true)
	private Integer pageQuantity;

	@Column(name = "FREQUENCY", columnDefinition = "VARCHAR2|频率||", length = 20, nullable = true)
	private String frequency;

	@Column(name = "PERIOD", columnDefinition = "VARCHAR2|期数||", length = 5, nullable = true)
	private Integer period;

	@Column(name = "CONTENT", columnDefinition = "VARCHAR2|主要内容||", length = 2000, nullable = true)
	private String content;

	@Column(name = "CONSTRUCT_TIME", columnDefinition = "DATE|建设时间||", nullable = true)
	private Date constructTime;

	@Column(name = "USE_TIME", columnDefinition = "DATE|使用时间||", nullable = true)
	private Date useTime;

	@Column(name = "MATERIAL_TYPE", columnDefinition = "VARCHAR2|资料类型||", length = 20, nullable = true)
	private String materialType;

	@Column(name = "OTHER_MATERIAL_TYPE", columnDefinition = "VARCHAR2|其他资料类型||", length = 20, nullable = true)
	private String otherMaterialType;

	@Column(name = "MATERIAL_NAME", columnDefinition = "VARCHAR2|资料名称||", length = 20, nullable = true)
	private String materialName;

	@Column(name = "ISSUE_UNIT", columnDefinition = "VARCHAR2|发放单位||", length = 20, nullable = true)
	private String issueUnit;

	@Column(name = "ISSUE_QUANTITY", columnDefinition = "NUMBER|发放数量||", length = 5, nullable = true)
	private Integer issueQuantity;

	@Column(name = "ISSUER", columnDefinition = "VARCHAR2|发放人||", length = 20, nullable = true)
	private String issuer;

	@Column(name = "RECEIVER", columnDefinition = "VARCHAR2|领取人||", length = 20, nullable = true)
	private String receiver;

	@Column(name = "ISSUE_TIME", columnDefinition = "DATE|发放时间||", nullable = true)
	private Date issueTime;

	@Column(name = "RESOURCE_TYPE", columnDefinition = "VARCHAR2|资源类型||", length = 1, nullable = true)
	private String resourceType;

	@Column(name = "CONTENT_TYPE", columnDefinition = "VARCHAR2|内容分类||", length = 100, nullable = true)
	private String contentType;

	@Column(name = "OTHER_CONTENT_TYPE", columnDefinition = "VARCHAR2|其他内容分类||", length = 100, nullable = true)
	private String otherContentType;

	@Column(name = "STATUS", columnDefinition = "VARCHAR2|状态||", length = 1, nullable = true)
	private String status;

	public Long getActiveId() {
		return activeId;
	}

	public void setActiveId(Long activeId) {
		this.activeId = activeId;
	}

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

	public String getPositionType() {
		return this.positionType;
	}

	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Integer getPageQuantity() {
		return this.pageQuantity;
	}

	public void setPageQuantity(Integer pageQuantity) {
		this.pageQuantity = pageQuantity;
	}

	public String getFrequency() {
		return this.frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public Integer getPeriod() {
		return this.period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getConstructTime() {
		return this.constructTime;
	}

	public void setConstructTime(Date constructTime) {
		this.constructTime = constructTime;
	}

	public Date getUseTime() {
		return this.useTime;
	}

	public void setUseTime(Date useTime) {
		this.useTime = useTime;
	}

	public String getMaterialType() {
		return this.materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public String getIssueUnit() {
		return this.issueUnit;
	}

	public void setIssueUnit(String issueUnit) {
		this.issueUnit = issueUnit;
	}

	public Integer getIssueQuantity() {
		return this.issueQuantity;
	}

	public void setIssueQuantity(Integer issueQuantity) {
		this.issueQuantity = issueQuantity;
	}

	public String getIssuer() {
		return this.issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public Date getIssueTime() {
		return this.issueTime;
	}

	public void setIssueTime(Date issueTime) {
		this.issueTime = issueTime;
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

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}


	public String getResourceType() {
		return resourceType;
	}


	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}


	public String getOtherMaterialType() {
		return otherMaterialType;
	}


	public void setOtherMaterialType(String otherMaterialType) {
		this.otherMaterialType = otherMaterialType;
	}


	public String getContentType() {
		return contentType;
	}


	public void setContentType(String contentType) {
		this.contentType = contentType;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getOtherContentType() {
		return otherContentType;
	}


	public void setOtherContentType(String otherContentType) {
		this.otherContentType = otherContentType;
	}


}