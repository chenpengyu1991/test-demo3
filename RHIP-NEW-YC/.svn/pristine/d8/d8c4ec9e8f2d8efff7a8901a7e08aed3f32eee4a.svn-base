package com.founder.rhip.ehr.entity.portal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "REGISTER_SCHEDULE_TIME")
@XmlAccessorType(XmlAccessType.FIELD)
public class RegisterScheduleTime implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|ID|11|", length = 11, nullable = false)
	private Long id;
	
	@XmlTransient
	@Column(name = "REGISTER_SCHEDULE_ID", columnDefinition = "VARCHAR2|医院编码|15|", length = 15, nullable = false)
	private Long registerScheduleId;
	
	@Column(name = "TIME_INTERVAL_START", columnDefinition = "VARCHAR2|看病开始时间如: 08:00||", length = 10,nullable = false)
	private String timeIntervalStart;

	@Column(name = "TIME_INTERVAL_END", columnDefinition = "VARCHAR2|看病结束时间如: 09:45|1|", length = 10, nullable = false)
	private String timeIntervalEnd;

	@Column(name = "ADMIT_NUM", columnDefinition = "NUMBER|总的预约资源数||", nullable = false)
	private Long admitNum;

	@Column(name = "RESERVE_NUM", columnDefinition = "NUMBER|已预约数||", nullable = false)
	private Long reserveNum;

	@Column(name = "TAKE_NO_TIME_START", columnDefinition = "VARCHAR2|取号开始时间如：07:30|15|", length = 10, nullable = false)
	private String takeNoTimeStart;

	@Column(name = "TAKE_NO_TIME_END", columnDefinition = "VARCHAR2|取号结束时间如：08:00|2|", length = 10, nullable = false)
	private String takeNoTimeEnd;

	@XmlTransient
	@Column(name = "CREATE_TIME", columnDefinition = "VARCHAR2|创建时间||", length = 50, nullable = true)
	private Date createTime;
	
	@XmlTransient
	@Column(name = "UPDATE_TIME", columnDefinition = "VARCHAR2|更新时间||", length = 50, nullable = true)
	private Date updateTime;
	
	@XmlTransient
	@Column(name = "VERSION", columnDefinition = "VARCHAR2|版本控制||", nullable = true)
	private String version;

	@XmlTransient
	@Column(name = "CUTE_FLAG", columnDefinition = "VARCHAR2|当可预约数和既存不一致时记录1次变化数量||", length = 50, nullable = true)
	private Long cuteFlag;

	/**
	 * 判断是否预约满
	 * @return
	 */
	public boolean isFull(){
		if(admitNum == null){
			return true;
		}

		if(reserveNum == null){
			return false;
		}

		if(reserveNum < admitNum){
			return false;
		}
		return true;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRegisterScheduleId() {
		return registerScheduleId;
	}

	public void setRegisterScheduleId(Long registerScheduleId) {
		this.registerScheduleId = registerScheduleId;
	}

	public String getTimeIntervalStart() {
		return timeIntervalStart.trim();
	}

	public void setTimeIntervalStart(String timeIntervalStart) {
		this.timeIntervalStart = timeIntervalStart;
	}

	public String getTimeIntervalEnd() {
		return timeIntervalEnd.trim();
	}

	public void setTimeIntervalEnd(String timeIntervalEnd) {
		this.timeIntervalEnd = timeIntervalEnd;
	}

	public Long getAdmitNum() {
		return admitNum;
	}

	public void setAdmitNum(Long admitNum) {
		this.admitNum = admitNum;
	}

	public Long getReserveNum() {
		return reserveNum;
	}

	public void setReserveNum(Long reserveNum) {
		this.reserveNum = reserveNum;
	}

	public String getTakeNoTimeStart() {
		return takeNoTimeStart.trim();
	}

	public void setTakeNoTimeStart(String takeNoTimeStart) {
		this.takeNoTimeStart = takeNoTimeStart;
	}

	public String getTakeNoTimeEnd() {
		return takeNoTimeEnd.trim();
	}

	public void setTakeNoTimeEnd(String takeNoTimeEnd) {
		this.takeNoTimeEnd = takeNoTimeEnd;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Long getCuteFlag() {
		return cuteFlag;
	}

	public void setCuteFlag(Long cuteFlag) {
		this.cuteFlag = cuteFlag;
	}
}