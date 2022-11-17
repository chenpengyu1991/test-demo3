package com.founder.rhip.ncp.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "NCP_MONITOR_PLAN")
public class NcpMonitorPlan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|主键|, length = 0, nullable =false")
    private BigDecimal id;
    @Column(name = "PID", columnDefinition = "NUMBER|新冠患者ID|, length = 0, nullable = false")
    private BigDecimal pid;
    @Column(name = "CARDNO", columnDefinition = "VARCHAR2|新冠患者证件号|, length = 18, nullable = false")
    private String cardno;
    @Column(name = "PLAN_DATE", columnDefinition = "DATE|计划日期|, length = 0, nullable = false")
    private Date planDate;
    @Column(name = "CREATE_TIME", columnDefinition = "DATE|创建时间|, length = 0, nullable = false")
    private Date createTime;
    @Column(name = "CREATE_STAFF_CODE", columnDefinition = "VARCHAR2|创建用户CODE|, length = 20, nullable = false")
    private String createStaffCode;
    @Column(name = "TYPE", columnDefinition = "NUMBER|1:监测 2:随访(3:复查 无需计划)|, length = 0, nullable = false")
    private BigDecimal type;

    @Column(name = "PLAN_TYPE", columnDefinition = "NUMBER|1:计划内 2:计划外|, length = 1, nullable = true")
    private String planType;

    @Transient
    private Date monitorDate;

    @Transient
    private BigDecimal monitorId;

    @Transient
    private Boolean notOverTime;//随访计划未超过时间范围

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public Boolean getNotOverTime() {
        return notOverTime;
    }

    public void setNotOverTime(Boolean notOverTime) {
        this.notOverTime = notOverTime;
    }

    public Date getMonitorDate() {
        return monitorDate;
    }

    public void setMonitorDate(Date monitorDate) {
        this.monitorDate = monitorDate;
    }

    public BigDecimal getMonitorId() {
        return monitorId;
    }

    public void setMonitorId(BigDecimal monitorId) {
        this.monitorId = monitorId;
    }

    public void setId(BigDecimal id){
        this.id=id;
    }
    public BigDecimal getId(){
        return id;
    }
    public void setPid(BigDecimal pid){
        this.pid=pid;
    }
    public BigDecimal getPid(){
        return pid;
    }
    public void setCardno(String cardno){
        this.cardno=cardno;
    }
    public String getCardno(){
        return cardno;
    }
    public void setPlanDate(Date planDate){
        this.planDate=planDate;
    }
    public Date getPlanDate(){
        return planDate;
    }
    public void setCreateTime(Date createTime){
        this.createTime=createTime;
    }
    public Date getCreateTime(){
        return createTime;
    }
    public String getCreateStaffCode() {
		return createStaffCode;
	}

	public void setCreateStaffCode(String createStaffCode) {
		this.createStaffCode = createStaffCode;
	}

	public void setType(BigDecimal type){
        this.type=type;
    }
    public BigDecimal getType(){
        return type;
    }
}

