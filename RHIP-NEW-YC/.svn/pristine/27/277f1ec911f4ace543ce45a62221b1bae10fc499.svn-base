package com.founder.rhip.ehr.entity.control.oh;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "OH_RADIOLOGICAL_POSTION")
public class OhRadiologicalPostion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "HOSPITAL_ID", columnDefinition = "NUMBER|医院ID|11|", length = 11, nullable = true)
	private Long hospitalId;

	@Column(name = "LOCALTION_URL", columnDefinition = "VARCHAR2|放射科位置图|50|", length = 50, nullable = true)
	private String localtionUrl;

	@Column(name = "LAYOUT_URL", columnDefinition = "VARCHAR2|放射科布置图|50|", length = 50, nullable = true)
	private String layoutUrl;

	@Column(name = "CAUTION", columnDefinition = "VARCHAR2|警示标示有无|2|", length = 2, nullable = true)
	private String caution;

	@Column(name = "INDICATOR", columnDefinition = "VARCHAR2|工作指示灯有无|2|", length = 2, nullable = true)
	private String indicator;

	@Column(name = "DOOR_INTERLOCK", columnDefinition = "VARCHAR2|门机联锁装置|2|", length = 2, nullable = true)
	private String doorInterlock;

	@Column(name = "ALARM", columnDefinition = "VARCHAR2|报警仪有无|2|", length = 2, nullable = true)
	private String alarm;

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

	public Long getHospitalId() {
		return this.hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getLocaltionUrl() {
		return this.localtionUrl;
	}

	public void setLocaltionUrl(String localtionUrl) {
		this.localtionUrl = localtionUrl;
	}

	public String getLayoutUrl() {
		return this.layoutUrl;
	}

	public void setLayoutUrl(String layoutUrl) {
		this.layoutUrl = layoutUrl;
	}

	public String getCaution() {
		return this.caution;
	}

	public void setCaution(String caution) {
		this.caution = caution;
	}

	public String getIndicator() {
		return this.indicator;
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public String getDoorInterlock() {
		return this.doorInterlock;
	}

	public void setDoorInterlock(String doorInterlock) {
		this.doorInterlock = doorInterlock;
	}

	public String getAlarm() {
		return this.alarm;
	}

	public void setAlarm(String alarm) {
		this.alarm = alarm;
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