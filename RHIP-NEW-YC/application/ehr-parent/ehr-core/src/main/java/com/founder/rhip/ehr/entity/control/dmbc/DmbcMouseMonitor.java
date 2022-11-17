package com.founder.rhip.ehr.entity.control.dmbc;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "DMBC_MOUSE_MONITOR")
public class DmbcMouseMonitor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, scale = 11, nullable = false)
	private Long id;

	@Column(name = "MONITOR_DATE", columnDefinition = "DATE|监测时间||", nullable = true)
	private Date monitorDate;

	@Column(name = "TOWN_SHIP", columnDefinition = "VARCHAR2|所属镇||", length = 20, scale = 20, nullable = true)
	private String townShip;

	@Column(name = "ENVIRONMENT", columnDefinition = "VARCHAR2|布夹环境||", length = 20, scale = 20, nullable = true)
	private String environment;

	@Column(name = "TEMP", columnDefinition = "VARCHAR2|气温||", length = 20, scale = 20, nullable = true)
	private String temp;

	@Column(name = "TOTAL", columnDefinition = "NUMBER|布夹总数||", length = 5, scale = 5, nullable = true)
	private Long total;

	@Column(name = "RECOVERY_COUNT", columnDefinition = "NUMBER|回收总数||", length = 5, scale = 5, nullable = true)
	private Long recoveryCount;

	@Column(name = "INVALID_COUNT", columnDefinition = "NUMBER|无效夹总数||", length = 5, scale = 5, nullable = true)
	private Long invalidCount;

	@Column(name = "INDOOR_COUNT", columnDefinition = "NUMBER|室内布夹数||", length = 5, scale = 5, nullable = true)
	private Long indoorCount;

	@Column(name = "OUTDOOR_COUNT", columnDefinition = "NUMBER|室外布夹数||", length = 5, scale = 5, nullable = true)
	private Long outdoorCount;

	@Column(name = "PLACE", columnDefinition = "VARCHAR2|布夹地点||", length = 20, scale = 20, nullable = true)
	private String place;

	@Column(name = "DENSITY", columnDefinition = "VARCHAR2|鼠密度||", length = 20, scale = 20, nullable = true)
	private String density;

	@Column(name = "MONITOR", columnDefinition = "VARCHAR2|监测人||", length = 20, scale = 20, nullable = true)
	private String monitor;

	@Column(name = "VERIFIRY_DATE", columnDefinition = "DATE|审核日期||", nullable = true)
	private Date verifiryDate;

	@Column(name = "VERIFIER", columnDefinition = "VARCHAR2|审核人||", length = 20, scale = 20, nullable = true)
	private String verifier;

	@Column(name = "CREATE_TIME", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createTime;

	@Column(name = "CREATE_BY", columnDefinition = "VARCHAR2|创建者||", length = 20, scale = 20, nullable = true)
	private String createBy;

	@Column(name = "UPDATE_TIME", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date updateTime;

	@Column(name = "UPDATE_BY", columnDefinition = "VARCHAR2|更新者||", length = 20, scale = 20, nullable = true)
	private String updateBy;

	@Column(name = "IS_DELETE", columnDefinition = "INT|删除状态||", nullable = true)
	private Integer isDelete;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getMonitorDate() {
		return this.monitorDate;
	}

	public void setMonitorDate(Date monitorDate) {
		this.monitorDate = monitorDate;
	}

	public String getTownShip() {
		return this.townShip;
	}

	public void setTownShip(String townShip) {
		this.townShip = townShip;
	}

	public String getEnvironment() {
		return this.environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getTemp() {
		return this.temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public Long getTotal() {
		return this.total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Long getRecoveryCount() {
		return this.recoveryCount;
	}

	public void setRecoveryCount(Long recoveryCount) {
		this.recoveryCount = recoveryCount;
	}

	public Long getInvalidCount() {
		return this.invalidCount;
	}

	public void setInvalidCount(Long invalidCount) {
		this.invalidCount = invalidCount;
	}

	public Long getIndoorCount() {
		return this.indoorCount;
	}

	public void setIndoorCount(Long indoorCount) {
		this.indoorCount = indoorCount;
	}

	public Long getOutdoorCount() {
		return this.outdoorCount;
	}

	public void setOutdoorCount(Long outdoorCount) {
		this.outdoorCount = outdoorCount;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDensity() {
		return this.density;
	}

	public void setDensity(String density) {
		this.density = density;
	}

	public String getMonitor() {
		return this.monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	public Date getVerifiryDate() {
		return this.verifiryDate;
	}

	public void setVerifiryDate(Date verifiryDate) {
		this.verifiryDate = verifiryDate;
	}

	public String getVerifier() {
		return this.verifier;
	}

	public void setVerifier(String verifier) {
		this.verifier = verifier;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateBy() {
		return this.updateBy;
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