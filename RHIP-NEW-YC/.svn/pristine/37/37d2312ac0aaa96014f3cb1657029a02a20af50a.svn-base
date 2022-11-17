package com.founder.rhip.ncp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "NCP_SYMPTOMS")
public class NcpSymptioms implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|主键|, length = 0, nullable =false")
    private BigDecimal id;
    @Column(name = "MONITOR_ID", columnDefinition = "NUMBER|检测表ID|, length = 0, nullable = false")
    private BigDecimal monitorId;
    @Column(name = "SYMPTOM_CODE", columnDefinition = "VARCHAR2|症状编号|, length = 5, nullable = false")
    private String symptomCode;

    public void setId(BigDecimal id){
        this.id=id;
    }
    public BigDecimal getId(){
        return id;
    }
    public void setMonitorId(BigDecimal monitorId){
        this.monitorId=monitorId;
    }
    public BigDecimal getMonitorId(){
        return monitorId;
    }
    public void setSymptomCode(String symptomCode){
        this.symptomCode=symptomCode;
    }
    public String getSymptomCode(){
        return symptomCode;
    }
}

