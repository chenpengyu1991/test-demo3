package com.founder.rhip.ehr.entity.jj;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "JJ_TTASK")
public class JjTtask implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "TASK_NO", columnDefinition = "VARCHAR2|任务编码|50|", length = 50, nullable = false)
	private String taskNo;

	@Column(name = "ACCEPT_NO", columnDefinition = "VARCHAR2|受理编码|50|", length = 50, nullable = true)
	private String acceptNo;

	@Column(name = "STATION_NO", columnDefinition = "VARCHAR2|分站编码|20|", length = 20, nullable = true)
	private String stationNo;

	@Column(name = "CAR_ID", columnDefinition = "VARCHAR2|车辆编码|20|", length = 20, nullable = true)
	private String carId;

	@Column(name = "IS_END", columnDefinition = "NUMBER|是否结束|1|", length = 1, nullable = true)
	private Long isEnd;

	@Column(name = "EXCEPTION_REASON", columnDefinition = "VARCHAR2|异常结束原因|50|", length = 50, nullable = true)
	private String exceptionReason;

	@Column(name = "GENERATION_TIME", columnDefinition = "DATE|生成任务时刻||", nullable = true)
	private Date generationTime;

	@Column(name = "ORDER_TIME", columnDefinition = "DATE|接收命令时刻||", nullable = true)
	private Date orderTime;

	@Column(name = "LEAVE_TIME", columnDefinition = "DATE|出车时刻||", nullable = true)
	private Date leaveTime;

	@Column(name = "ARRIVED_TIME", columnDefinition = "DATE|到达现场时刻||", nullable = true)
	private Date arrivedTime;

	@Column(name = "LEAVE_LOCAL_TIME", columnDefinition = "DATE|离开现场时刻||", nullable = true)
	private Date leaveLocalTime;

	@Column(name = "ARRIVED_HOSPITAL_TIME", columnDefinition = "DATE|到达医院时刻||", nullable = true)
	private Date arrivedHospitalTime;

	@Column(name = "END_TIME", columnDefinition = "DATE|完成时刻||", nullable = true)
	private Date endTime;

	@Column(name = "ARRIVED_STATION_TIME", columnDefinition = "DATE|返回站中时刻||", nullable = true)
	private Date arrivedStationTime;

	@Column(name = "DRIVER", columnDefinition = "VARCHAR2|司机|50|", length = 50, nullable = true)
	private String driver;

	@Column(name = "DOCTOR", columnDefinition = "VARCHAR2|医生|50|", length = 50, nullable = true)
	private String doctor;

	@Column(name = "NURSE", columnDefinition = "VARCHAR2|护士|50|", length = 50, nullable = true)
	private String nurse;

	@Column(name = "STRETCHER", columnDefinition = "VARCHAR2|担架工|50|", length = 50, nullable = true)
	private String stretcher;

	@Column(name = "SEND_TO_PLACE", columnDefinition = "VARCHAR2|实际送往地点|100|", length = 100, nullable = true)
	private String sendToPlace;

	public String getTaskNo() {
		return this.taskNo;
	}

	public void setTaskNo(String taskNo) {
		this.taskNo = taskNo;
	}

	public String getAcceptNo() {
		return this.acceptNo;
	}

	public void setAcceptNo(String acceptNo) {
		this.acceptNo = acceptNo;
	}

	public String getStationNo() {
		return this.stationNo;
	}

	public void setStationNo(String stationNo) {
		this.stationNo = stationNo;
	}

	public String getCarId() {
		return this.carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public Long getIsEnd() {
		return this.isEnd;
	}

	public void setIsEnd(Long isEnd) {
		this.isEnd = isEnd;
	}

	public String getExceptionReason() {
		return this.exceptionReason;
	}

	public void setExceptionReason(String exceptionReason) {
		this.exceptionReason = exceptionReason;
	}

	public Date getGenerationTime() {
		return this.generationTime;
	}

	public void setGenerationTime(Date generationTime) {
		this.generationTime = generationTime;
	}

	public Date getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Date getLeaveTime() {
		return this.leaveTime;
	}

	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}

	public Date getArrivedTime() {
		return this.arrivedTime;
	}

	public void setArrivedTime(Date arrivedTime) {
		this.arrivedTime = arrivedTime;
	}

	public Date getLeaveLocalTime() {
		return this.leaveLocalTime;
	}

	public void setLeaveLocalTime(Date leaveLocalTime) {
		this.leaveLocalTime = leaveLocalTime;
	}

	public Date getArrivedHospitalTime() {
		return this.arrivedHospitalTime;
	}

	public void setArrivedHospitalTime(Date arrivedHospitalTime) {
		this.arrivedHospitalTime = arrivedHospitalTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getArrivedStationTime() {
		return this.arrivedStationTime;
	}

	public void setArrivedStationTime(Date arrivedStationTime) {
		this.arrivedStationTime = arrivedStationTime;
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

	public String getSendToPlace() {
		return this.sendToPlace;
	}

	public void setSendToPlace(String sendToPlace) {
		this.sendToPlace = sendToPlace;
	}

}