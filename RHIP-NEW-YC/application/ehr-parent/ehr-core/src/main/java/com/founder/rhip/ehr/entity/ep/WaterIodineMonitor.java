package com.founder.rhip.ehr.entity.ep;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "EP_WATER_IODINE_MONITOR")
public class WaterIodineMonitor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;

	@Column(name = "FACTORY_NAME", columnDefinition = "VAR2|水厂名称||", length = 50 , nullable = true)
	private String factoryName;

	@Column(name = "MONITOR_ID", columnDefinition = "VAR2|监测点编号||", length = 50 , nullable = true)
	private String monitorId;

	@Column(name = "GB_CODE", columnDefinition = "VAR2|乡镇代码||", length = 18 , nullable = true)
	private String gbCode;
	
	@Column(name = "VILLAGE_CODE", columnDefinition = "VAR2|行政村代码||", length = 18 , nullable = true)
	private String villageCode;

	@Column(name = "FACTORY_ADDRESS", columnDefinition = "VAR2|水厂详细地址||", length = 50 , nullable = true)
	private String factoryAddress;

	@Column(name = "MONITOR_TYPE", columnDefinition = "VAR2|监测类型||", length = 50 , nullable = true)
	private String monitorType;

	@Column(name = "FACTORY_TYPE", columnDefinition = "VAR2|水厂类型||", length = 50 , nullable = true)
	private String factoryType;

	@Column(name = "FACTORY_CONSTRUCTION_TIME", columnDefinition = "DATE|建厂时间||", nullable = true)
	private Date factoryConstructionTime;

	@Column(name = "SELF_CHECKING_ABILITY", columnDefinition = "VAR2|自检能力||", length = 50 , nullable = true)
	private String selfCheckingAbility;

	@Column(name = "DISINFECT_SITUATION", columnDefinition = "VAR2|消毒情况||", length = 50 , nullable = true)
	private String disinfectSituation;

	@Column(name = "WATER_SOURCE_TYPE", columnDefinition = "VAR2|水源类型||", length = 50 , nullable = true)
	private String waterSourceType;

	@Column(name = "WELL_DEPTH", columnDefinition = "NUMBER|井深||", length = 5, nullable = true)
	private Integer wellDepth;

	@Column(name = "WATER_PROCESS_TYPE", columnDefinition = "VAR2|水处理方式||", length = 50 , nullable = true)
	private String waterProcessType;

	@Column(name = "WATER_SUPPLY_SCALE", columnDefinition = "NUMBER|供水规模||", length = 10, nullable = true)
	private Double waterSupplyScale;

	@Column(name = "COVERAGE_AREA", columnDefinition = "NUMBER|覆盖范围||", length = 10, nullable = true)
	private String coverageArea;

	@Column(name = "COVERAGE_POPULATION", columnDefinition = "NUMBER|覆盖人口||", length = 10, nullable = true)
	private Double coveragePopulation;

	@Column(name = "DRY_FINISHED_SAMPLES", columnDefinition = "NUMBER|枯水期出厂水水样数||", length = 5, nullable = true)
	private Integer dryFinishedSamples;

	@Column(name = "DRY_FINISHED_IODINE", columnDefinition = "NUMBER|枯水期出厂水水碘含量||", length = 5, nullable = true)
	private Double dryFinishedIodine;

	@Column(name = "DRY_TIP_SAMPLES", columnDefinition = "NUMBER|枯水期末梢水水样数||", length = 5, nullable = true)
	private Integer dryTipSamples;

	@Column(name = "DRY_TIP_IODINE", columnDefinition = "NUMBER|枯水期末梢水水碘含量||", length = 5, nullable = true)
	private Double dryTipIodine;

	@Column(name = "WET_FINISHED_SAMPLES", columnDefinition = "NUMBER|丰水期出厂水水样数||", length = 5, nullable = true)
	private Integer wetFinishedSamples;

	@Column(name = "WET_FINISHED_IODINE", columnDefinition = "NUMBER|丰水期出厂水水碘含量||", length = 5, nullable = true)
	private Double wetFinishedIodine;

	@Column(name = "WET_TIP_SAMPLES", columnDefinition = "NUMBER|丰水期末梢水水样数||", length = 5, nullable = true)
	private Integer wetTipSamples;

	@Column(name = "WET_TIP_IODINE", columnDefinition = "NUMBER|丰水期末梢水水碘含量||", length = 5, nullable = true)
	private Double wetTipIodine;

	@Column(name = "INVESTIGATOR", columnDefinition = "VAR2|调查人||", length = 50 , nullable = true)
	private String investigator;

	@Column(name = "INVESTIGATE_UNIT", columnDefinition = "VAR2|调查单位||", length = 50 , nullable = true)
	private String investigateUnit;

	@Column(name = "INVESTIGATE_TIME", columnDefinition = "DATE|调查日期||", nullable = true)
	private Date investigateTime;

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
	private Integer deleteFlag = 0;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFactoryName() {
		return this.factoryName;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

	public String getMonitorId() {
		return this.monitorId;
	}

	public void setMonitorId(String monitorId) {
		this.monitorId = monitorId;
	}

	public String getGbCode() {
		return this.gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	public String getFactoryAddress() {
		return this.factoryAddress;
	}

	public void setFactoryAddress(String factoryAddress) {
		this.factoryAddress = factoryAddress;
	}

	public String getMonitorType() {
		return this.monitorType;
	}

	public void setMonitorType(String monitorType) {
		this.monitorType = monitorType;
	}

	public String getFactoryType() {
		return this.factoryType;
	}

	public void setFactoryType(String factoryType) {
		this.factoryType = factoryType;
	}

	public Date getFactoryConstructionTime() {
		return this.factoryConstructionTime;
	}

	public void setFactoryConstructionTime(Date factoryConstructionTime) {
		this.factoryConstructionTime = factoryConstructionTime;
	}

	public String getSelfCheckingAbility() {
		return this.selfCheckingAbility;
	}

	public void setSelfCheckingAbility(String selfCheckingAbility) {
		this.selfCheckingAbility = selfCheckingAbility;
	}

	public String getDisinfectSituation() {
		return this.disinfectSituation;
	}

	public void setDisinfectSituation(String disinfectSituation) {
		this.disinfectSituation = disinfectSituation;
	}

	public String getWaterSourceType() {
		return this.waterSourceType;
	}

	public void setWaterSourceType(String waterSourceType) {
		this.waterSourceType = waterSourceType;
	}

	public Integer getWellDepth() {
		return this.wellDepth;
	}

	public void setWellDepth(Integer wellDepth) {
		this.wellDepth = wellDepth;
	}

	public String getWaterProcessType() {
		return this.waterProcessType;
	}

	public void setWaterProcessType(String waterProcessType) {
		this.waterProcessType = waterProcessType;
	}

	public Double getWaterSupplyScale() {
		return this.waterSupplyScale;
	}

	public void setWaterSupplyScale(Double waterSupplyScale) {
		this.waterSupplyScale = waterSupplyScale;
	}

	public String getCoverageArea() {
		return this.coverageArea;
	}

	public void setCoverageArea(String coverageArea) {
		this.coverageArea = coverageArea;
	}

	public Double getCoveragePopulation() {
		return this.coveragePopulation;
	}

	public void setCoveragePopulation(Double coveragePopulation) {
		this.coveragePopulation = coveragePopulation;
	}

	public Integer getDryFinishedSamples() {
		return this.dryFinishedSamples;
	}

	public void setDryFinishedSamples(Integer dryFinishedSamples) {
		this.dryFinishedSamples = dryFinishedSamples;
	}

	public Double getDryFinishedIodine() {
		return this.dryFinishedIodine;
	}

	public void setDryFinishedIodine(Double dryFinishedIodine) {
		this.dryFinishedIodine = dryFinishedIodine;
	}

	public Integer getDryTipSamples() {
		return this.dryTipSamples;
	}

	public void setDryTipSamples(Integer dryTipSamples) {
		this.dryTipSamples = dryTipSamples;
	}

	public Double getDryTipIodine() {
		return this.dryTipIodine;
	}

	public void setDryTipIodine(Double dryTipIodine) {
		this.dryTipIodine = dryTipIodine;
	}

	public Integer getWetFinishedSamples() {
		return this.wetFinishedSamples;
	}

	public void setWetFinishedSamples(Integer wetFinishedSamples) {
		this.wetFinishedSamples = wetFinishedSamples;
	}

	public Double getWetFinishedIodine() {
		return this.wetFinishedIodine;
	}

	public void setWetFinishedIodine(Double wetFinishedIodine) {
		this.wetFinishedIodine = wetFinishedIodine;
	}

	public Integer getWetTipSamples() {
		return this.wetTipSamples;
	}

	public void setWetTipSamples(Integer wetTipSamples) {
		this.wetTipSamples = wetTipSamples;
	}

	public Double getWetTipIodine() {
		return this.wetTipIodine;
	}

	public void setWetTipIodine(Double wetTipIodine) {
		this.wetTipIodine = wetTipIodine;
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

	public String getVillageCode() {
		return villageCode;
	}

	public void setVillageCode(String villageCode) {
		this.villageCode = villageCode;
	}

	public String getInvestigator() {
		return investigator;
	}

	public void setInvestigator(String investigator) {
		this.investigator = investigator;
	}

	public String getInvestigateUnit() {
		return investigateUnit;
	}

	public void setInvestigateUnit(String investigateUnit) {
		this.investigateUnit = investigateUnit;
	}

	public Date getInvestigateTime() {
		return investigateTime;
	}

	public void setInvestigateTime(Date investigateTime) {
		this.investigateTime = investigateTime;
	}

}