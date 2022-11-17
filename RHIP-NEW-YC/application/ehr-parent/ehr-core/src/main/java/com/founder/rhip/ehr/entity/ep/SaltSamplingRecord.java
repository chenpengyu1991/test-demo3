package com.founder.rhip.ehr.entity.ep;

import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.common.EHRConstants;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "EP_SALT_SAMPLING_RECORD")
public class SaltSamplingRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;

	@Column(name = "MONITOR_PLACE_TYPE", columnDefinition = "VAR2|监测地区类别||", length = 50 , nullable = true)
	private String monitorPlaceType;

	@Column(name = "POSITION", columnDefinition = "VAR2|方向||", length = 18 , nullable = true)
	private String position;

	@Column(name = "GB_CODE", columnDefinition = "VAR2|乡镇代码||", length = 18 , nullable = true)
	private String gbCode;

	@Column(name = "VILLAGE_NAME", columnDefinition = "VAR2|抽检村1名称||", length = 50 , nullable = true)
	private String villageName;

	@Column(name = "VILLAGE_CODE", columnDefinition = "VAR2|抽检村1代码||", length = 50 , nullable = true)
	private String villageCode;

	@Column(name = "SAMPLING_PERSON", columnDefinition = "VAR2|抽样人||", length = 50 , nullable = true)
	private String samplingPerson;

	@Column(name = "VERIFIER", columnDefinition = "VAR2|审核人||", length = 50 , nullable = true)
	private String verifier;

	@Column(name = "SAMPLING_UNIT", columnDefinition = "VAR2|抽样单位||", length = 50 , nullable = true)
	private String samplingUnit;

	@Column(name = "SAMPLING_YEAR", columnDefinition = "VAR2|抽检年份||", length = 10 , nullable = true)
	private String samplingYear;

	@Column(name = "SAMPLING_TIME", columnDefinition = "DATE|抽检时间||", nullable = true)
	private Date samplingTime;

	@Column(name = "CREATE_PERSON", columnDefinition = "VAR2|创建人||", length = 50 , nullable = true)
	private String createPerson;

	@Column(name = "CREATE_ORGAN", columnDefinition = "VAR2|创建机构||", length = 50 , nullable = true)
	private String createOrgan;

	@Column(name = "CREATE_TIME", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createTime;

	@Column(name = "UPDATE_PERSON", columnDefinition = "VAR2|更新人||", length = 50 , nullable = true)
	private String updatePerson;

	@Column(name = "UPDATE_ORGAN", columnDefinition = "VAR2|更新机构||", length = 50 , nullable = true)
	private String updateOrgan;

	@Column(name = "UPDATE_TIME", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date updateTime;

	@Column(name = "DELETE_FLAG", columnDefinition = "VAR2|删除标识||", length = 1 , nullable = true)
	private Integer deleteFlag = EHRConstants.DELETE_FLG_0;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMonitorPlaceType() {
		return this.monitorPlaceType;
	}

	public void setMonitorPlaceType(String monitorPlaceType) {
		this.monitorPlaceType = monitorPlaceType;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getGbCode() {
		return this.gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	public String getVillageName() {
		return this.villageName;
	}

	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}

	public String getVillageCode() {
		return this.villageCode;
	}

	public void setVillageCode(String villageCode) {
		this.villageCode = villageCode;
	}

	public String getSamplingPerson() {
		return this.samplingPerson;
	}

	public void setSamplingPerson(String samplingPerson) {
		this.samplingPerson = samplingPerson;
	}

	public String getVerifier() {
		return this.verifier;
	}

	public void setVerifier(String verifier) {
		this.verifier = verifier;
	}

	public String getSamplingUnit() {
		return this.samplingUnit;
	}

	public void setSamplingUnit(String samplingUnit) {
		this.samplingUnit = samplingUnit;
	}

	public String getSamplingYear() {
		return this.samplingYear;
	}

	public void setSamplingYear(String samplingYear) {
		this.samplingYear = samplingYear;
	}

	public Date getSamplingTime() {
		return this.samplingTime;
	}

	public void setSamplingTime(Date samplingTime) {
		this.samplingTime = samplingTime;
		this.samplingYear = DateUtil.toDateString(samplingTime, "yyyy");
	}

	public String getCreatePerson() {
		return this.createPerson;
	}

	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}

	public String getCreateOrgan() {
		return this.createOrgan;
	}

	public void setCreateOrgan(String createOrgan) {
		this.createOrgan = createOrgan;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdatePerson() {
		return this.updatePerson;
	}

	public void setUpdatePerson(String updatePerson) {
		this.updatePerson = updatePerson;
	}

	public String getUpdateOrgan() {
		return this.updateOrgan;
	}

	public void setUpdateOrgan(String updateOrgan) {
		this.updateOrgan = updateOrgan;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}