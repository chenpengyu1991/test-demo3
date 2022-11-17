package com.founder.rhip.ehr.entity.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "MDM_STANDARD_PARAMETER_CONFIG")
public class StandParameterCfg implements Serializable {

    private static final long serialVersionUID = 1234436031513104682L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = true)
    private Long id;

    @Column(name = "STANDARD_NAME", columnDefinition = "VARCHAR2|标准名称||", length = 200, nullable = true)
    private String standardName;

    @Column(name = "STANDARD_CODE", columnDefinition = "VARCHAR2|标准编码||", length = 50, nullable = true)
    private String standardCode;

    @Column(name = "PARAMETER_CODE", columnDefinition = "VARCHAR2|标准参数编码||", length = 50, nullable = true)
    private String parameterCode;

    @Column(name = "PARAMETER_NAME", columnDefinition = "VARCHAR2|标准参数名称||", length = 200, nullable = true)
    private String parameterName;

    @Column(name = "PARAMETER_VALUE", columnDefinition = "VARCHAR2|标准参数值||", length = 200, nullable = true)
    private String parameterValue;

    @Column(name = "STATUS", columnDefinition = "NUMBER|状态||", length = 1, nullable = true)
    private Long status;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStandardName() {
        return this.standardName;
    }

    public void setStandardName(String standardName) {
        this.standardName = standardName;
    }

    public String getStandardCode() {
        return this.standardCode;
    }

    public void setStandardCode(String standardCode) {
        this.standardCode = standardCode;
    }

    public String getParameterCode() {
        return this.parameterCode;
    }

    public void setParameterCode(String parameterCode) {
        this.parameterCode = parameterCode;
    }

    public String getParameterName() {
        return this.parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParameterValue() {
        return this.parameterValue;
    }

    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }

    public Long getStatus() {
        return this.status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

}