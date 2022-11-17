package com.founder.rhip.ehr.entity.control.oh;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "OH_EQUIPMENT")
public class OhEquipment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "ENTERPRISE_INFO_ID", columnDefinition = "NUMBER|企业基本信息ID|11|", length = 11, nullable = true)
	private Long enterpriseInfoId;

	@Column(name = "SEQ_NO", columnDefinition = "VARCHAR2|序号|50|", length = 50, nullable = true)
	private String seqNo;
	
	@Column(name = "WORKSHOP_NAME", columnDefinition = "VARCHAR2|车间|50|", length = 50, nullable = true)
	private String workshopName;

	@Column(name = "EQUIPMENT_NAME", columnDefinition = "VARCHAR2|设备名称|50|", length = 50, nullable = true)
	private String equipmentName;

	@Column(name = "MODEL", columnDefinition = "VARCHAR2|设备型号|50|", length = 50, nullable = true)
	private String model;

	@Column(name = "COUNT", columnDefinition = "NUMBER|台数|11|", length = 11, nullable = true)
	private Long count;

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

	@Column(name = "POWERL", columnDefinition = "VARCHAR2|功率|20|", length = 20, nullable = true)
	private String powerl;
	
	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

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

	public String getEquipmentName() {
		return this.equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Long getCount() {
		return this.count;
	}

	public void setCount(Long count) {
		this.count = count;
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

	public String getPowerl() {
		return powerl;
	}

	public void setPowerl(String powerl) {
		this.powerl = powerl;
	}

}