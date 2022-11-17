package com.founder.rhip.ehr.entity.control.oh;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "OH_CHEMICALS_USED")
public class OhChemicalsUsed implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "ENTERPRISE_INFO_ID", columnDefinition = "NUMBER|企业基本信息ID|11|", length = 11, nullable = true)
	private Long enterpriseInfoId;

	@Column(name = "WORKSHOP_NAME", columnDefinition = "VARCHAR2|车间|50|", length = 50, nullable = true)
	private String workshopName;

	@Column(name = "CHEMICAL_NAME", columnDefinition = "VARCHAR2|化学物质名称|50|", length = 50, nullable = true)
	private String chemicalName;

	@Column(name = "SOURCE", columnDefinition = "VARCHAR2|来源|50|", length = 50, nullable = true)
	private String source;

	@Column(name = "HARVEST_USAGE_AMOUNT", columnDefinition = "VARCHAR2|年产量/使用量|20|", length = 20, nullable = true)
	private String harvestUsageAmount;

	@Column(name = "CREATE_TIME", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createTime;

	@Column(name = "CREATE_BY", columnDefinition = "VARCHAR2|创建者|50|", length = 50, nullable = true)
	private String createBy;

	@Column(name = "UPDATE_TIME", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date updateTime;

	@Column(name = "UPDATE_BY", columnDefinition = "VARCHAR2|更新者|50|", length = 50, nullable = true)
	private String updateBy;

	@Column(name = "IS_DELETE", columnDefinition = "INT|删除状态||", nullable = true)
	private Integer isDelete;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEnterpriseInfoId() {
		return this.enterpriseInfoId;
	}

	public void setEnterpriseInfoId(Long enterpriseInfoId) {
		this.enterpriseInfoId = enterpriseInfoId;
	}

	public String getWorkshopName() {
		return this.workshopName;
	}

	public void setWorkshopName(String workshopName) {
		this.workshopName = workshopName;
	}

	public String getChemicalName() {
		return this.chemicalName;
	}

	public void setChemicalName(String chemicalName) {
		this.chemicalName = chemicalName;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getHarvestUsageAmount() {
		return this.harvestUsageAmount;
	}

	public void setHarvestUsageAmount(String harvestUsageAmount) {
		this.harvestUsageAmount = harvestUsageAmount;
	}

	

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}