package com.founder.rhip.ehr.entity.clinic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "DA_CONFIG")
public class DaConfig implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|唯一自增长编码|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|机构编码|50|", length = 50, nullable = true)
	private String organCode;

	@Column(name = "TECHNICIAN_NUM", columnDefinition = "NUMBER|药剂科从事药学专业技术工作人数|10|", length = 10, nullable = true)
	private BigDecimal technicianNum;

	@Column(name = "LEADER_NAME", columnDefinition = "VARCHAR2|药剂科负责人姓名|50|", length = 50, nullable = true)
	private String leaderName;

	@Column(name = "LEADER_PROFESSION", columnDefinition = "VARCHAR2|药剂科负责人职称|50|", length = 50, nullable = true)
	private String leaderProfession;

	@Column(name = "TEL_1", columnDefinition = "VARCHAR2|联系电话1|50|", length = 50, nullable = true)
	private String tel1;

	@Column(name = "TEL_2", columnDefinition = "VARCHAR2|联系电话2|50|", length = 50, nullable = true)
	private String tel2;

	@Column(name = "TEL_3", columnDefinition = "VARCHAR2|联系电话3|50|", length = 50, nullable = true)
	private String tel3;

	@Column(name = "TEL_4", columnDefinition = "VARCHAR2|联系电话4|50|", length = 50, nullable = true)
	private String tel4;

	@Column(name = "ALL_PHARMACY_AREA", columnDefinition = "NUMBER|药房总面积||", scale = 2, precision = 10, nullable = true)
	private BigDecimal allPharmacyArea;

	@Column(name = "OUTPATIENT_AREA", columnDefinition = "NUMBER|门诊药房面积||", scale = 2, precision = 10, nullable = true)
	private BigDecimal outpatientArea;

	@Column(name = "EMERGENCY_AREA", columnDefinition = "NUMBER|急诊药房面积||", scale = 2, precision = 10, nullable = true)
	private BigDecimal emergencyArea;

	@Column(name = "PHARMACY_CHINESE_AREA", columnDefinition = "NUMBER|中药房面积||", scale = 2, precision = 10, nullable = true)
	private BigDecimal pharmacyChineseArea;

	@Column(name = "PHARMACY_WESTERN_AREA", columnDefinition = "NUMBER|西药房面积||", scale = 2, precision = 10, nullable = true)
	private BigDecimal pharmacyWesternArea;

	@Column(name = "CENTER_AREA", columnDefinition = "NUMBER|中心药房总面积||", scale = 2, precision = 10, nullable = true)
	private BigDecimal centerArea;

	@Column(name = "CONGIF_CENTER_AREA", columnDefinition = "NUMBER|配置中心总面积||", scale = 2, precision = 10, nullable = true)
	private BigDecimal congifCenterArea;

	@Column(name = "OTHER_PHARMACY_AREA", columnDefinition = "NUMBER|其他面积||", scale = 2, precision = 10, nullable = true)
	private BigDecimal otherPharmacyArea;

	@Column(name = "STORAGE_AREA", columnDefinition = "NUMBER|药库总面积||", scale = 2, precision = 10, nullable = true)
	private BigDecimal storageArea;

	@Column(name = "STORAGE_CHINESE_AREA", columnDefinition = "NUMBER|中药库面积||", scale = 2, precision = 10, nullable = true)
	private BigDecimal storageChineseArea;

	@Column(name = "STORAGE_WESTERN_AREA", columnDefinition = "NUMBER|西药库面积||", scale = 2, precision = 10, nullable = true)
	private BigDecimal storageWesternArea;

	@Column(name = "DANGER_AREA", columnDefinition = "NUMBER|危险品库面积||", scale = 2, precision = 10, nullable = true)
	private BigDecimal dangerArea;

	@Column(name = "SPECIAL_AREA", columnDefinition = "NUMBER|特殊药品库面积||", scale = 2, precision = 10, nullable = true)
	private BigDecimal specialArea;

	@Column(name = "MANAGEMENT_NUM", columnDefinition = "NUMBER|管理专柜个数|10|", length = 10, nullable = true)
	private BigDecimal managementNum;

	@Column(name = "ROOM_AREA", columnDefinition = "NUMBER|常温库面积||", scale = 2, precision = 10, nullable = true)
	private BigDecimal roomArea;

	@Column(name = "COOL_TEMP_AREA", columnDefinition = "NUMBER|阴凉库面积||", scale = 2, precision = 10, nullable = true)
	private BigDecimal coolTempArea;

	@Column(name = "COLD_STORAGE_AREA", columnDefinition = "NUMBER|冷藏库容积||", scale = 2, precision = 10, nullable = true)
	private BigDecimal coldStorageArea;

	@Column(name = "COLD_CUPBOARD_NUM", columnDefinition = "NUMBER|冷藏柜个数|10|", length = 10, nullable = true)
	private BigDecimal coldCupboardNum;

	@Column(name = "OTHER_STORAGE_AREA", columnDefinition = "NUMBER|其他面积||", scale = 2, precision = 10, nullable = true)
	private BigDecimal otherStorageArea;

	@Column(name = "AIRCON_NUM", columnDefinition = "NUMBER|独立空调|10|", length = 10, nullable = true)
	private BigDecimal airconNum;

	@Column(name = "VRV_NUM", columnDefinition = "NUMBER|中央空调|10|", length = 10, nullable = true)
	private BigDecimal vrvNum;

	@Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|创建机构code|50|", length = 50, nullable = true)
	private String createOrganCode;

	@Column(name = "CREATE_ORGAN_NAME", columnDefinition = "VARCHAR2|创建机构名称|100|", length = 100, nullable = true)
	private String createOrganName;

	@Column(name = "CREATE_DATE", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createDate;

	@Column(name = "UPDATE_ORGAN_CODE", columnDefinition = "VARCHAR2|修改机构code|50|", length = 50, nullable = true)
	private String updateOrganCode;

	@Column(name = "UPDATE_ORGAN_NAME", columnDefinition = "VARCHAR2|修改机构名称|100|", length = 100, nullable = true)
	private String updateOrganName;

	@Column(name = "UPDATE_DATE", columnDefinition = "DATE|修改事件||", nullable = true)
	private Date updateDate;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrganCode() {
		return this.organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public BigDecimal getTechnicianNum() {
		return this.technicianNum;
	}

	public void setTechnicianNum(BigDecimal technicianNum) {
		this.technicianNum = technicianNum;
	}

	public String getLeaderName() {
		return this.leaderName;
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	public String getLeaderProfession() {
		return this.leaderProfession;
	}

	public void setLeaderProfession(String leaderProfession) {
		this.leaderProfession = leaderProfession;
	}

	public String getTel1() {
		return this.tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return this.tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getTel3() {
		return this.tel3;
	}

	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}

	public String getTel4() {
		return this.tel4;
	}

	public void setTel4(String tel4) {
		this.tel4 = tel4;
	}

	public BigDecimal getAllPharmacyArea() {
		return this.allPharmacyArea;
	}

	public void setAllPharmacyArea(BigDecimal allPharmacyArea) {
		this.allPharmacyArea = allPharmacyArea;
	}

	public BigDecimal getOutpatientArea() {
		return this.outpatientArea;
	}

	public void setOutpatientArea(BigDecimal outpatientArea) {
		this.outpatientArea = outpatientArea;
	}

	public BigDecimal getEmergencyArea() {
		return this.emergencyArea;
	}

	public void setEmergencyArea(BigDecimal emergencyArea) {
		this.emergencyArea = emergencyArea;
	}

	public BigDecimal getPharmacyChineseArea() {
		return this.pharmacyChineseArea;
	}

	public void setPharmacyChineseArea(BigDecimal pharmacyChineseArea) {
		this.pharmacyChineseArea = pharmacyChineseArea;
	}

	public BigDecimal getPharmacyWesternArea() {
		return this.pharmacyWesternArea;
	}

	public void setPharmacyWesternArea(BigDecimal pharmacyWesternArea) {
		this.pharmacyWesternArea = pharmacyWesternArea;
	}

	public BigDecimal getCenterArea() {
		return this.centerArea;
	}

	public void setCenterArea(BigDecimal centerArea) {
		this.centerArea = centerArea;
	}

	public BigDecimal getCongifCenterArea() {
		return this.congifCenterArea;
	}

	public void setCongifCenterArea(BigDecimal congifCenterArea) {
		this.congifCenterArea = congifCenterArea;
	}

	public BigDecimal getOtherPharmacyArea() {
		return this.otherPharmacyArea;
	}

	public void setOtherPharmacyArea(BigDecimal otherPharmacyArea) {
		this.otherPharmacyArea = otherPharmacyArea;
	}

	public BigDecimal getStorageArea() {
		return this.storageArea;
	}

	public void setStorageArea(BigDecimal storageArea) {
		this.storageArea = storageArea;
	}

	public BigDecimal getStorageChineseArea() {
		return this.storageChineseArea;
	}

	public void setStorageChineseArea(BigDecimal storageChineseArea) {
		this.storageChineseArea = storageChineseArea;
	}

	public BigDecimal getStorageWesternArea() {
		return this.storageWesternArea;
	}

	public void setStorageWesternArea(BigDecimal storageWesternArea) {
		this.storageWesternArea = storageWesternArea;
	}

	public BigDecimal getDangerArea() {
		return this.dangerArea;
	}

	public void setDangerArea(BigDecimal dangerArea) {
		this.dangerArea = dangerArea;
	}

	public BigDecimal getSpecialArea() {
		return this.specialArea;
	}

	public void setSpecialArea(BigDecimal specialArea) {
		this.specialArea = specialArea;
	}

	public BigDecimal getManagementNum() {
		return this.managementNum;
	}

	public void setManagementNum(BigDecimal managementNum) {
		this.managementNum = managementNum;
	}

	public BigDecimal getRoomArea() {
		return this.roomArea;
	}

	public void setRoomArea(BigDecimal roomArea) {
		this.roomArea = roomArea;
	}

	public BigDecimal getCoolTempArea() {
		return this.coolTempArea;
	}

	public void setCoolTempArea(BigDecimal coolTempArea) {
		this.coolTempArea = coolTempArea;
	}

	public BigDecimal getColdStorageArea() {
		return this.coldStorageArea;
	}

	public void setColdStorageArea(BigDecimal coldStorageArea) {
		this.coldStorageArea = coldStorageArea;
	}

	public BigDecimal getColdCupboardNum() {
		return this.coldCupboardNum;
	}

	public void setColdCupboardNum(BigDecimal coldCupboardNum) {
		this.coldCupboardNum = coldCupboardNum;
	}

	public BigDecimal getOtherStorageArea() {
		return this.otherStorageArea;
	}

	public void setOtherStorageArea(BigDecimal otherStorageArea) {
		this.otherStorageArea = otherStorageArea;
	}

	public BigDecimal getAirconNum() {
		return this.airconNum;
	}

	public void setAirconNum(BigDecimal airconNum) {
		this.airconNum = airconNum;
	}

	public BigDecimal getVrvNum() {
		return this.vrvNum;
	}

	public void setVrvNum(BigDecimal vrvNum) {
		this.vrvNum = vrvNum;
	}

	public String getCreateOrganCode() {
		return this.createOrganCode;
	}

	public void setCreateOrganCode(String createOrganCode) {
		this.createOrganCode = createOrganCode;
	}

	public String getCreateOrganName() {
		return this.createOrganName;
	}

	public void setCreateOrganName(String createOrganName) {
		this.createOrganName = createOrganName;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateOrganCode() {
		return this.updateOrganCode;
	}

	public void setUpdateOrganCode(String updateOrganCode) {
		this.updateOrganCode = updateOrganCode;
	}

	public String getUpdateOrganName() {
		return this.updateOrganName;
	}

	public void setUpdateOrganName(String updateOrganName) {
		this.updateOrganName = updateOrganName;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}