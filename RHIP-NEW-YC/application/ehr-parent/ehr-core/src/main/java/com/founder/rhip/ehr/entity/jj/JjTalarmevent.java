package com.founder.rhip.ehr.entity.jj;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "JJ_TALARMEVENT")
public class JjTalarmevent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "EVENT_NO", columnDefinition = "VARCHAR2|事件编码|50|", length = 50, nullable = false)
	private String eventNo;

	@Column(name = "ALARM_NO", columnDefinition = "VARCHAR2|事故编码|50|", length = 50, nullable = true)
	private String alarmNo;

	@Column(name = "FIRST_CALL", columnDefinition = "VARCHAR2|首次呼救电话|20|", length = 20, nullable = true)
	private String firstCall;

	@Column(name = "EVENT_TITLE", columnDefinition = "VARCHAR2|事件名称|100|", length = 100, nullable = true)
	private String eventTitle;

	@Column(name = "FIRST_DISPATCHER", columnDefinition = "VARCHAR2|首次调度员|50|", length = 50, nullable = true)
	private String firstDispatcher;

	@Column(name = "FIRST_ACCEPT_TIME", columnDefinition = "DATE|首次受理时刻||", nullable = true)
	private Date firstAcceptTime;

	@Column(name = "IS_HOLD", columnDefinition = "NUMBER|是否挂起|1|", length = 1, nullable = true)
	private Long isHold;

	@Column(name = "IS_TEST", columnDefinition = "NUMBER|是否测试|1|", length = 1, nullable = true)
	private Long isTest;

	@Column(name = "IS_FLAG", columnDefinition = "NUMBER|是否标注|1|", length = 1, nullable = true)
	private Long isFlag;

	@Column(name = "LONGITUDE", columnDefinition = "FLOAT|经度||", nullable = true)
	private String longitude;

	@Column(name = "LATITUDE", columnDefinition = "FLOAT|纬度||", nullable = true)
	private String latitude;

	@Column(name = "CENTER_NO", columnDefinition = "VARCHAR2(20)|中心编码|20|", length = 20, nullable = true)
	private String centerNo;

	public String getEventNo() {
		return this.eventNo;
	}

	public void setEventNo(String eventNo) {
		this.eventNo = eventNo;
	}

	public String getAlarmNo() {
		return this.alarmNo;
	}

	public void setAlarmNo(String alarmNo) {
		this.alarmNo = alarmNo;
	}

	public String getFirstCall() {
		return this.firstCall;
	}

	public void setFirstCall(String firstCall) {
		this.firstCall = firstCall;
	}

	public String getEventTitle() {
		return this.eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public String getFirstDispatcher() {
		return this.firstDispatcher;
	}

	public void setFirstDispatcher(String firstDispatcher) {
		this.firstDispatcher = firstDispatcher;
	}

	public Date getFirstAcceptTime() {
		return this.firstAcceptTime;
	}

	public void setFirstAcceptTime(Date firstAcceptTime) {
		this.firstAcceptTime = firstAcceptTime;
	}

	public Long getIsHold() {
		return this.isHold;
	}

	public void setIsHold(Long isHold) {
		this.isHold = isHold;
	}

	public Long getIsTest() {
		return this.isTest;
	}

	public void setIsTest(Long isTest) {
		this.isTest = isTest;
	}

	public Long getIsFlag() {
		return this.isFlag;
	}

	public void setIsFlag(Long isFlag) {
		this.isFlag = isFlag;
	}

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getCenterNo() {
		return this.centerNo;
	}

	public void setCenterNo(String centerNo) {
		this.centerNo = centerNo;
	}

}