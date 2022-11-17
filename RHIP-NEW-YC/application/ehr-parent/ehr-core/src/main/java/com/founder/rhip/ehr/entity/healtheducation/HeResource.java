package com.founder.rhip.ehr.entity.healtheducation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "HE_RESOURCE")
public class HeResource implements Serializable {
	
	private static final long serialVersionUID = -4189057679800236779L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;

	@Column(name = "ORG_CODE", columnDefinition = "VARCHAR2|机构代码||", length = 18, nullable = true)
	private String orgCode;

	@Column(name = "CENTER_ORG_CODE", columnDefinition = "VARCHAR2|上级机构代码||", length = 18, nullable = true)
	private String centerOrgCode;

	@Column(name = "GBCODE", columnDefinition = "VARCHAR2|乡镇代码||", length = 18, nullable = true)
	private String gbcode;

	@Column(name = "DEVICE_NAME", columnDefinition = "VARCHAR2|设备名称||", length = 50, nullable = true)
	private String deviceName;
	
	@Column(name = "OTHER_DEVICE_NAME", columnDefinition = "VARCHAR2|其他设备名称||", length = 50, nullable = true)
	private String otherDeviceName;

	@Column(name = "SPECIFICATION", columnDefinition = "VARCHAR2|规格型号||", length = 50, nullable = true)
	private String specification;

	@Column(name = "DEVICE_COST", columnDefinition = "VARCHAR2|价值||", length = 20, nullable = true)
	private String deviceCost;

	@Column(name = "CUSTODY_DEPT", columnDefinition = "VARCHAR2|保管部门||", length = 50, nullable = true)
	private String custodyDept;

	@Column(name = "PUBLISH_DEPT", columnDefinition = "VARCHAR2|出刊部门||", length = 50, nullable = true)
	private String publishDept;

	@Column(name = "GALLERY_QUANTITY", columnDefinition = "NUMBER|画廊(橱窗)数量||", length = 5, nullable = true)
	private Integer galleryQuantity;

	@Column(name = "BLACKBOARD_QUANTITY", columnDefinition = "NUMBER|黑板块数||", length = 5, nullable = true)
	private Integer blackboardQuantity;

	@Column(name = "LED_QUANTITY", columnDefinition = "NUMBER|LED显示屏数||", length = 5, nullable = true)
	private Integer ledQuantity;

	@Column(name = "BOARD_QUANTITY", columnDefinition = "NUMBER|阅报栏数||", length = 5, nullable = true)
	private Integer boardQuantity;

    @Column(name = "DISPLAY_STAND_QUANTITY", columnDefinition = "NUMBER|资料架数||", length = 5, nullable = true)
    private Integer displayStandQuantity;

	@Column(name = "POSITION_TYPE", columnDefinition = "VARCHAR2|宣传阵地类型||", length = 5, nullable = true)
	private String positionType;

	@Column(name = "RESOURCE_REMARK", columnDefinition = "VARCHAR2|资源备注||", length = 4000, nullable = true)
	private String resourceRemark;

	@Column(name = "MATERIAL_TYPE", columnDefinition = "VARCHAR2|资料类型||", length = 50, nullable = true)
	private String materialType;

	@Column(name = "MATERIAL_NAME", columnDefinition = "VARCHAR2|资料名称||", length = 20, nullable = true)
	private String materialName;

	@Column(name = "RESOURCEL_QUANTITY", columnDefinition = "NUMBER|资源数量||", length = 5, nullable = true)
	private Integer resourcelQuantity;

	@Column(name = "RESOURCE_TYPE", columnDefinition = "VARCHAR2|资源类型||", length = 50, nullable = true)
	private String resourceType;

	@Column(name = "RESOURCE_CREATER", columnDefinition = "VARCHAR2|资源创建人||", length = 50, nullable = true)
	private String resourceCreater;

	@Column(name = "RESOURCE_RECORD_TIME", columnDefinition = "VARCHAR2|教育资源记录日期||", length = 4, nullable = true)
	private Date resourceRecordTime;
	
	@Column(name = "OTHER_MATERIAL_NAME", columnDefinition = "VARCHAR2|其他资料名称||", length = 50, nullable = true)
	private String otherMaterialName;
	
	@Column(name = "STATUS", columnDefinition = "VARCHAR2|状态||", length = 1, nullable = true)
	private String status;

	@Column(name = "OTHER_POSITION_TYPE", columnDefinition = "VARCHAR2|其他阵地类型||", length = 5, nullable = true)
	private String otherPositionType;

	@Column(name = "POSITION_QUANTITY", columnDefinition = "NUMBER|阵地数量||", length = 5, nullable = true)
	private Integer positionQuantity;

	private Long healthEducationResourceNum;
	private Boolean isCheck;

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

	public String getCenterOrgCode() {
		return this.centerOrgCode;
	}

	public void setCenterOrgCode(String centerOrgCode) {
		this.centerOrgCode = centerOrgCode;
	}

	public String getGbcode() {
		return this.gbcode;
	}

	public void setGbcode(String gbcode) {
		this.gbcode = gbcode;
	}

	public String getDeviceName() {
		return this.deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getSpecification() {
		return this.specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getDeviceCost() {
		return this.deviceCost;
	}

	public void setDeviceCost(String deviceCost) {
		this.deviceCost = deviceCost;
	}

	public String getCustodyDept() {
		return this.custodyDept;
	}

	public void setCustodyDept(String custodyDept) {
		this.custodyDept = custodyDept;
	}

	public String getPublishDept() {
		return this.publishDept;
	}

	public void setPublishDept(String publishDept) {
		this.publishDept = publishDept;
	}

	public Integer getGalleryQuantity() {
		return this.galleryQuantity;
	}

	public void setGalleryQuantity(Integer galleryQuantity) {
		this.galleryQuantity = galleryQuantity;
	}

	public Integer getBlackboardQuantity() {
		return this.blackboardQuantity;
	}

	public void setBlackboardQuantity(Integer blackboardQuantity) {
		this.blackboardQuantity = blackboardQuantity;
	}

	public Integer getLedQuantity() {
		return this.ledQuantity;
	}

	public void setLedQuantity(Integer ledQuantity) {
		this.ledQuantity = ledQuantity;
	}

	public Integer getBoardQuantity() {
		return this.boardQuantity;
	}

	public void setBoardQuantity(Integer boardQuantity) {
		this.boardQuantity = boardQuantity;
	}

    public Integer getDisplayStandQuantity() {
        return displayStandQuantity;
    }

    public void setDisplayStandQuantity(Integer displayStandQuantity) {
        this.displayStandQuantity = displayStandQuantity;
    }

    public String getResourceRemark() {
		return this.resourceRemark;
	}

	public void setResourceRemark(String resourceRemark) {
		this.resourceRemark = resourceRemark;
	}

	public String getMaterialType() {
		return this.materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public String getMaterialName() {
		return this.materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public Integer getResourcelQuantity() {
		return this.resourcelQuantity;
	}

	public void setResourcelQuantity(Integer resourcelQuantity) {
		this.resourcelQuantity = resourcelQuantity;
	}

	public String getResourceType() {
		return this.resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getResourceCreater() {
		return this.resourceCreater;
	}

	public void setResourceCreater(String resourceCreater) {
		this.resourceCreater = resourceCreater;
	}

	
	public Date getResourceRecordTime() {
		return resourceRecordTime;
	}

	
	public void setResourceRecordTime(Date resourceRecordTime) {
		this.resourceRecordTime = resourceRecordTime;
	}

	
	public String getPositionType() {
		return positionType;
	}

	
	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}

	
	public String getOtherDeviceName() {
		return otherDeviceName;
	}

	
	public void setOtherDeviceName(String otherDeviceName) {
		this.otherDeviceName = otherDeviceName;
	}

	
	public String getOtherMaterialName() {
		return otherMaterialName;
	}

	
	public void setOtherMaterialName(String otherMaterialName) {
		this.otherMaterialName = otherMaterialName;
	}

	
	public String getStatus() {
		return status;
	}

	
	public void setStatus(String status) {
		this.status = status;
	}

	public Long getHealthEducationResourceNum() {
		return healthEducationResourceNum;
	}

	public void setHealthEducationResourceNum(Long healthEducationResourceNum) {
		this.healthEducationResourceNum = healthEducationResourceNum;
	}

	public Boolean getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(Boolean isCheck) {
		this.isCheck = isCheck;
	}

	public String getOtherPositionType() {
		return otherPositionType;
	}

	public void setOtherPositionType(String otherPositionType) {
		this.otherPositionType = otherPositionType;
	}

	public Integer getPositionQuantity() {
		return positionQuantity;
	}

	public void setPositionQuantity(Integer positionQuantity) {
		this.positionQuantity = positionQuantity;
	}
}