package com.founder.rhip.ehr.entity.jj;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "JJ_TAMBULANCE")
public class JjTambulance implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "TAMBULANCE_NO", columnDefinition = "VARCHAR2|车辆编码|20|", length = 20, nullable = false)
	private String tambulanceNo;

	@Column(name = "STATION_NO", columnDefinition = "VARCHAR2|分站编码|20|", length = 20, nullable = true)
	private String stationNo;

	@Column(name = "ACTUAL_MARK", columnDefinition = "VARCHAR2|实际标识|50|", length = 50, nullable = true)
	private String actualMark;

	@Column(name = "BUS_NO", columnDefinition = "VARCHAR2|车牌号码|20|", length = 20, nullable = true)
	private String busNo;

	@Column(name = "VEHICLE_TYPE", columnDefinition = "VARCHAR2|车辆类型|50|", length = 50, nullable = true)
	private String vehicleType;

	@Column(name = "TASK_NUM", columnDefinition = "VARCHAR2|任务编码|50|", length = 50, nullable = true)
	private String taskNum;

	@Column(name = "STATE_NO", columnDefinition = "INTEGER|工作状态编码||", nullable = true)
	private Long stateNo;

	@Column(name = "DRIVER", columnDefinition = "VARCHAR2|司机|50|", length = 50, nullable = true)
	private String driver;

	@Column(name = "DOCTOR", columnDefinition = "VARCHAR2|医生|50|", length = 50, nullable = true)
	private String doctor;

	@Column(name = "NURSE", columnDefinition = "VARCHAR2|护士|50|", length = 50, nullable = true)
	private String nurse;

	@Column(name = "STRETCHER", columnDefinition = "VARCHAR2|担架工|50|", length = 50, nullable = true)
	private String stretcher;

	@Column(name = "CAR_TELPHONE", columnDefinition = "VARCHAR2|车载电话|20|", length = 20, nullable = true)
	private String carTelphone;

	@Column(name = "GPS_TIME", columnDefinition = "DATE|GPS时间||", nullable = true)
	private Date gpsTime;

	@Column(name = "LONGITUDE", columnDefinition = "FLOAT|经度||", nullable = true)
	private BigDecimal longitude;

	@Column(name = "LATITUDE", columnDefinition = "FLOAT|纬度||", nullable = true)
	private BigDecimal latitude;

	@Column(name = "HEIGHT", columnDefinition = "FLOAT|高度||", nullable = true)
	private BigDecimal height;

	@Column(name = "SPEED", columnDefinition = "FLOAT|速度||", nullable = true)
	private BigDecimal speed;

	@Column(name = "DIRECTION", columnDefinition = "FLOAT|方向||", nullable = true)
	private BigDecimal direction;

	@Column(name = "CENTER_NO", columnDefinition = "VARCHAR2|中心编码|20|", length = 20, nullable = true)
	private BigDecimal centerNo;

	@Column(name = "IS_VALID", columnDefinition = "NUMBER|是否有效|1|", length = 1, nullable = true)
	private Long isValid;

	public String getTambulanceNo() {
		return this.tambulanceNo;
	}

	public void setTambulanceNo(String tambulanceNo) {
		this.tambulanceNo = tambulanceNo;
	}

	public String getStationNo() {
		return this.stationNo;
	}

	public void setStationNo(String stationNo) {
		this.stationNo = stationNo;
	}

	public String getActualMark() {
		return this.actualMark;
	}

	public void setActualMark(String actualMark) {
		this.actualMark = actualMark;
	}

	public String getBusNo() {
		return this.busNo;
	}

	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}

	public String getVehicleType() {
		return this.vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getTaskNum() {
		return this.taskNum;
	}

	public void setTaskNum(String taskNum) {
		this.taskNum = taskNum;
	}

	public Long getStateNo() {
		return this.stateNo;
	}

	public void setStateNo(Long stateNo) {
		this.stateNo = stateNo;
	}

	public String getDriver() {
		return this.driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getDoctor() {
		return this.doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getNurse() {
		return this.nurse;
	}

	public void setNurse(String nurse) {
		this.nurse = nurse;
	}

	public String getStretcher() {
		return this.stretcher;
	}

	public void setStretcher(String stretcher) {
		this.stretcher = stretcher;
	}

	public String getCarTelphone() {
		return this.carTelphone;
	}

	public void setCarTelphone(String carTelphone) {
		this.carTelphone = carTelphone;
	}

	public Date getGpsTime() {
		return this.gpsTime;
	}

	public void setGpsTime(Date gpsTime) {
		this.gpsTime = gpsTime;
	}

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getSpeed() {
        return speed;
    }

    public void setSpeed(BigDecimal speed) {
        this.speed = speed;
    }

    public BigDecimal getDirection() {
        return direction;
    }

    public void setDirection(BigDecimal direction) {
        this.direction = direction;
    }

    public BigDecimal getCenterNo() {
        return centerNo;
    }

    public void setCenterNo(BigDecimal centerNo) {
        this.centerNo = centerNo;
    }

    public Long getIsValid() {
		return this.isValid;
	}

	public void setIsValid(Long isValid) {
		this.isValid = isValid;
	}

}