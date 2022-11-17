package com.founder.rhip.ehr.entity.sysConfig;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "IDM_REPORT_REFRESH_TIME")
public class ReportRefreshTime implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|ID|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "DIS_TYPE", columnDefinition = "VARCHAR2|疾病类型(1:传染病 2:慢病)|18|", length = 18, nullable = true)
    private String disType;

    @Column(name = "MINUTES", columnDefinition = "NUMBER|提醒频率（分）|11|", length = 11, nullable = true)
    private Long minutes;

    @Column(name = "IDM_FREQUENCY", columnDefinition = "NUMBER|传染病提醒频率（分）|11|", length = 11, nullable = true)
    private Long idmFrequency;

    @Column(name = "CMD_FREQUENCY", columnDefinition = "NUMBER|慢病提醒频率（分）|11|", length = 11, nullable = true)
    private Long cmdFrequency;

    @Column(name = "Fdm_FREQUENCY", columnDefinition = "NUMBER|食源性疾病提醒频率（分）|11|", length = 11, nullable = true)
    private Long fdmFrequency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisType() {
        return disType;
    }

    public void setDisType(String disType) {
        this.disType = disType;
    }

    public Long getMinutes() {
        return minutes;
    }

    public void setMinutes(Long minutes) {
        this.minutes = minutes;
    }

    public Long getIdmFrequency() {
        return idmFrequency;
    }

    public void setIdmFrequency(Long idmFrequency) {
        this.idmFrequency = idmFrequency;
    }

    public Long getCmdFrequency() {
        return cmdFrequency;
    }

    public void setCmdFrequency(Long cmdFrequency) {
        this.cmdFrequency = cmdFrequency;
    }

    public Long getFdmFrequency() {
        return fdmFrequency;
    }

    public void setFdmFrequency(Long fdmFrequency) {
        this.fdmFrequency = fdmFrequency;
    }
}