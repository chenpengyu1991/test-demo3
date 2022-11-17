package com.founder.rhip.ehr.entity.control.dmbc;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "DMBC_CHILD_INST_MONITOR")
public class DmbcChildInstMonitor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, scale = 11, nullable = true)
	private Long id;

	@Column(name = "ORG_NAME", columnDefinition = "VARCHAR2|托儿机构名称||", length = 40, scale = 40, nullable = true)
	private String orgName;

	@Column(name = "MONITOR_DATE", columnDefinition = "DATE|监测时间||", nullable = true)
	private Date monitorDate;

	@Column(name = "ORG_TYPE", columnDefinition = "VARCHAR2|机构类型||", length = 40, scale = 40, nullable = true)
	private String orgType;

	@Column(name = "AIR_D_TOTAL", columnDefinition = "NUMBER|空气(动态)采样数||", length = 11, scale = 11, nullable = true)
	private Long airDTotal;

	@Column(name = "AIR_D_ACEPT_NUM", columnDefinition = "NUMBER|空气(动态)合格数||", length = 11, scale = 11, nullable = true)
	private Long airDAceptNum;

	@Column(name = "AIR_S_TOTAL", columnDefinition = "NUMBER|空气(静态)采样数||", length = 11, scale = 11, nullable = true)
	private Long airSTotal;

	@Column(name = "AIR_S_ACEPT_NUM", columnDefinition = "NUMBER|空气(静态)合格数||", length = 11, scale = 11, nullable = true)
	private Long airSAceptNum;

	@Column(name = "SURFACE_TOTAL", columnDefinition = "NUMBER|物体表面采样数||", length = 11, scale = 11, nullable = true)
	private Long surfaceTotal;

	@Column(name = "SURFACE_ACEPT_NUM", columnDefinition = "NUMBER|物体表面合格数||", length = 11, scale = 11, nullable = true)
	private Long surfaceAceptNum;

	@Column(name = "HAND_TOTAL", columnDefinition = "NUMBER|工作人员手采样数||", length = 11, scale = 11, nullable = true)
	private Long handTotal;

	@Column(name = "HAND_ACEPT_NUM", columnDefinition = "NUMBER|工作人员手合格数||", length = 11, scale = 11, nullable = true)
	private Long handAceptNum;

	@Column(name = "TABLEWARE_TOTAL", columnDefinition = "NUMBER|餐饮具采样数||", length = 11, scale = 11, nullable = true)
	private Long tablewareTotal;

	@Column(name = "TABLEWARE_ACEPT_NUM", columnDefinition = "NUMBER|餐饮具合格数||", length = 11, scale = 11, nullable = true)
	private Long tablewareAceptNum;

	@Column(name = "PLAY_POOL_TOTAL", columnDefinition = "NUMBER|游泳池戏水池采样数||", length = 11, scale = 11, nullable = true)
	private Long playPoolTotal;

	@Column(name = "PLAY_POOL_ACEPT_NUM", columnDefinition = "NUMBER|游泳池戏水池合格数||", length = 11, scale = 11, nullable = true)
	private Long playPoolAceptNum;

	@Column(name = "TOTAL", columnDefinition = "NUMBER|总采样数||", length = 11, scale = 11, nullable = true)
	private Long total;

	@Column(name = "ACEPT_NUM", columnDefinition = "NUMBER|总合格数||", length = 11, scale = 11, nullable = true)
	private Long aceptNum;

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

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Date getMonitorDate() {
		return this.monitorDate;
	}

	public void setMonitorDate(Date monitorDate) {
		this.monitorDate = monitorDate;
	}

	public String getOrgType() {
		return this.orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public Long getAirDTotal() {
		return this.airDTotal;
	}

	public void setAirDTotal(Long airDTotal) {
		this.airDTotal = airDTotal;
	}

	public Long getAirDAceptNum() {
		return this.airDAceptNum;
	}

	public void setAirDAceptNum(Long airDAceptNum) {
		this.airDAceptNum = airDAceptNum;
	}

	public Long getAirSTotal() {
		return this.airSTotal;
	}

	public void setAirSTotal(Long airSTotal) {
		this.airSTotal = airSTotal;
	}

	public Long getAirSAceptNum() {
		return this.airSAceptNum;
	}

	public void setAirSAceptNum(Long airSAceptNum) {
		this.airSAceptNum = airSAceptNum;
	}

	public Long getSurfaceTotal() {
		return this.surfaceTotal;
	}

	public void setSurfaceTotal(Long surfaceTotal) {
		this.surfaceTotal = surfaceTotal;
	}

	public Long getSurfaceAceptNum() {
		return this.surfaceAceptNum;
	}

	public void setSurfaceAceptNum(Long surfaceAceptNum) {
		this.surfaceAceptNum = surfaceAceptNum;
	}

	public Long getHandTotal() {
		return this.handTotal;
	}

	public void setHandTotal(Long handTotal) {
		this.handTotal = handTotal;
	}

	public Long getHandAceptNum() {
		return this.handAceptNum;
	}

	public void setHandAceptNum(Long handAceptNum) {
		this.handAceptNum = handAceptNum;
	}

	public Long getTablewareTotal() {
		return this.tablewareTotal;
	}

	public void setTablewareTotal(Long tablewareTotal) {
		this.tablewareTotal = tablewareTotal;
	}

	public Long getTablewareAceptNum() {
		return this.tablewareAceptNum;
	}

	public void setTablewareAceptNum(Long tablewareAceptNum) {
		this.tablewareAceptNum = tablewareAceptNum;
	}

	public Long getPlayPoolTotal() {
		return this.playPoolTotal;
	}

	public void setPlayPoolTotal(Long playPoolTotal) {
		this.playPoolTotal = playPoolTotal;
	}

	public Long getPlayPoolAceptNum() {
		return this.playPoolAceptNum;
	}

	public void setPlayPoolAceptNum(Long playPoolAceptNum) {
		this.playPoolAceptNum = playPoolAceptNum;
	}

	public Long getTotal() {
		return this.total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Long getAceptNum() {
		return this.aceptNum;
	}

	public void setAceptNum(Long aceptNum) {
		this.aceptNum = aceptNum;
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