package com.founder.rhip.ehr.entity.control.oh;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "OH_RADIOLOGICAL_APPARATUS")
public class OhRadiologicalApparatus implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "HOSPITAL_ID", columnDefinition = "NUMBER|医院ID|11|", length = 11, nullable = true)
	private Long hospitalId;

	@Column(name = "EQUIPMENT_CODE", columnDefinition = "VARCHAR2|装置编号|50|", length = 50, nullable = true)
	private String equipmentCode;

	@Column(name = "MODEL_NAME", columnDefinition = "VARCHAR2|装置型号及名称|50|", length = 50, nullable = true)
	private String modelName;

	@Column(name = "MANUFACUTRER", columnDefinition = "VARCHAR2|生产厂家|50|", length = 50, nullable = true)
	private String manufacutrer;

	@Column(name = "PRODUCTION_DATE", columnDefinition = "DATE|出厂时间||", nullable = true)
	private Date productionDate;

	@Column(name = "ACTIVE_DATE", columnDefinition = "DATE|启用时间||", nullable = true)
	private Date activeDate;

	@Column(name = "KEY_PARA", columnDefinition = "VARCHAR2|主要参数(Kv/mA)|50|", length = 50, nullable = true)
	private String keyPara;

	@Column(name = "TUBE_NUM", columnDefinition = "NUMBER|球管数|11|", length = 11, nullable = true)
	private Long tubeNum;

	@Column(name = "OPERATING_MODE", columnDefinition = "VARCHAR2|操作方式|50|", length = 50, nullable = true)
	private String operatingMode;

	@Column(name = "PURPOSE", columnDefinition = "VARCHAR2|用途|50|", length = 50, nullable = true)
	private String purpose;

	@Column(name = "REMARK", columnDefinition = "VARCHAR2|备注|20|", length = 20, nullable = true)
	private String remark;

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
	
	@Column(name = "STOP_DATE", columnDefinition = "DATE|停用时间||", nullable = true)
	private Date stopDate;
	

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getHospitalId() {
		return this.hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getEquipmentCode() {
		return this.equipmentCode;
	}

	public void setEquipmentCode(String equipmentCode) {
		this.equipmentCode = equipmentCode;
	}

	public String getModelName() {
		return this.modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getManufacutrer() {
		return this.manufacutrer;
	}

	public void setManufacutrer(String manufacutrer) {
		this.manufacutrer = manufacutrer;
	}

	public Date getProductionDate() {
		return this.productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public Date getActiveDate() {
		return this.activeDate;
	}

	public void setActiveDate(Date activeDate) {
		this.activeDate = activeDate;
	}

	public String getKeyPara() {
		return this.keyPara;
	}

	public void setKeyPara(String keyPara) {
		this.keyPara = keyPara;
	}

	public Long getTubeNum() {
		return this.tubeNum;
	}

	public void setTubeNum(Long tubeNum) {
		this.tubeNum = tubeNum;
	}

	public String getOperatingMode() {
		return this.operatingMode;
	}

	public void setOperatingMode(String operatingMode) {
		this.operatingMode = operatingMode;
	}

	public String getPurpose() {
		return this.purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public Date getStopDate() {
		return stopDate;
	}

	public void setStopDate(Date stopDate) {
		this.stopDate = stopDate;
	}

}