package com.founder.rhip.ehr.entity.clinic;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REFERAL_RECORD")
public class ReferalRecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -542847432733914063L;

	@Id
    @Column(name = "ID", columnDefinition = "NUMBER|主键|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|人员ID平台表中关联使用|", length = 11, nullable = false)
    private Long personId;
    
    @Column(name = "REFERAL_ID", columnDefinition = "NUMBER|转诊记录表ID|", length = 11, nullable = false)
    private Long referalId;
    
    @Column(name = "RECEIVE_DEPT_NAME", columnDefinition = "VARCHAR2|接诊科室|", length = 200, nullable = false)
    private String receiveDeptName;
    
    @Column(name = "RECEIVE_DOCTOR", columnDefinition = "VARCHAR2|接诊医生|", length = 200, nullable = true)
    private String receiveDoctor;
    
    @Column(name = "RECEIVE_TIME", columnDefinition = "DATE|接诊时间|", nullable = false)
    private Date receiveTime;
    
    @Column(name = "REASON", columnDefinition = "VARCHAR2|退回原因|", length = 2000, nullable = true)
    private String reason;
    
    @Column(name = "STATUS", columnDefinition = "NUMBER|转诊状态(1:已接诊;2:退回)||", nullable = false)
    private Integer status = 0;
    
    @Column(name = "TIME_RANGE", columnDefinition = "VARCHAR2|接诊时段|", length = 200, nullable = true)
    private String timeRange;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public Long getReferalId() {
		return referalId;
	}

	public void setReferalId(Long referalId) {
		this.referalId = referalId;
	}

	public String getReceiveDeptName() {
		return receiveDeptName;
	}

	public void setReceiveDeptName(String receiveDeptName) {
		this.receiveDeptName = receiveDeptName;
	}

	public String getReceiveDoctor() {
		return receiveDoctor;
	}

	public void setReceiveDoctor(String receiveDoctor) {
		this.receiveDoctor = receiveDoctor;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTimeRange() {
		return timeRange;
	}

	public void setTimeRange(String timeRange) {
		this.timeRange = timeRange;
	}
    
	
}
