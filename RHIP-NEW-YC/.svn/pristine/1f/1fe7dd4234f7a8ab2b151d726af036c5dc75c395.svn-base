package com.founder.rhip.ehr.entity.control.dmbc;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "DMBC_ROACH_MONITOR")
public class DmbcRoachMonitor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, scale = 11, nullable = true)
	private Long id;

	@Column(name = "MONITOR_DATE", columnDefinition = "DATE|监测时间||", nullable = true)
	private Date monitorDate;

	@Column(name = "TOWN_SHIP", columnDefinition = "VARCHAR2|所属镇||", length = 20, scale = 20, nullable = true)
	private String townShip;

	@Column(name = "TEMP", columnDefinition = "VARCHAR2|气温||", length = 20, scale = 20, nullable = true)
	private String temp;

	@Column(name = "ENVIRONMENT", columnDefinition = "VARCHAR2|环境类型||", length = 20, scale = 20, nullable = true)
	private String environment;

	@Column(name = "ORG_NAME", columnDefinition = "VARCHAR2|单位名称||", length = 50, scale = 50, nullable = true)
	private String orgName;

	@Column(name = "RECYCLE_CNT", columnDefinition = "NUMBER|回收张数||", length = 11, scale = 11, nullable = true)
	private Long recycleCnt;

	@Column(name = "POSITIVE_CNT", columnDefinition = "NUMBER|阳性张数||", length = 10, scale = 10, nullable = true)
	private Long positiveCnt;

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

	public String getTemp() {
		return this.temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getEnvironment() {
		return this.environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Long getRecycleCnt() {
		return this.recycleCnt;
	}

	public void setRecycleCnt(Long recycleCnt) {
		this.recycleCnt = recycleCnt;
	}

	public Long getPositiveCnt() {
		return positiveCnt;
	}

	public void setPositiveCnt(Long positiveCnt) {
		this.positiveCnt = positiveCnt;
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