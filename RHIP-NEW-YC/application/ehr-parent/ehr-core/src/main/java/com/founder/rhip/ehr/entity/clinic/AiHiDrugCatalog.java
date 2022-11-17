package com.founder.rhip.ehr.entity.clinic;

import com.founder.rhip.ehr.annotation.RecordTrace;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "AI_HI_DRUG_CATALOG")
public class AiHiDrugCatalog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|数据表唯一标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "DRUGID", columnDefinition = "VARCHAR2|编号|20|", length = 20, nullable = true)
    private String drugId;

    @Column(name = "DRUGNAME", columnDefinition = "VARCHAR2|药品名|50|", length = 50, nullable = true)
    private String drugName;

    @Column(name = "COMMNAME", columnDefinition = "VARCHAR2|通用名|50|", length = 50, nullable = true)
    private String commname;

    @Column(name = "SPEC", columnDefinition = "VARCHAR2|规格|50|", length = 50, nullable = true)
    private String spec;

    @Column(name = "UNIT", columnDefinition = "VARCHAR2|包装规格|10|", length = 10, nullable = true)
    private String unit;

    @Column(name = "RATE", columnDefinition = "NUMBER|包装计量||", scale = 10, precision = 2, nullable = true)
    private BigDecimal rate;

    @Column(name = "PRICE", columnDefinition = "NUMBER|价格||", scale = 10, precision = 2, nullable = true)
    private BigDecimal price;

    @Column(name = "DOSE_METHOD_CD", columnDefinition = "VARCHAR2|服用方式代码|10|", length = 10, nullable = true)
    private String doseMethodCd;

    @Column(name = "DOSE_METHOD_NAME", columnDefinition = "VARCHAR2|服用方式名称|20|", length = 20, nullable = true)
    private String doseMethodName;

    @Column(name = "COMMDOSAGE", columnDefinition = "NUMBER|单位计量||", scale = 10, precision = 2, nullable = true)
    private BigDecimal commdosage;

    @Column(name = "DOSAGEUNIT", columnDefinition = "VARCHAR2|计量单位|10|", length = 10, nullable = true)
    private String dosageunit;

    @Column(name = "COOP_INSURANCE_CD", columnDefinition = "VARCHAR2|农保编码|20|", length = 20, nullable = true)
    private String coopInsuranceCd;

    @Column(name = "PUBMEDI_CD", columnDefinition = "VARCHAR2|医保编码|20|", length = 20, nullable = true)
    private String pubmediCd;

    @Column(name = "CLASSNAME", columnDefinition = "VARCHAR2|药品分类|20|", length = 20, nullable = true)
    private String classname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getCommname() {
        return commname;
    }

    public void setCommname(String commname) {
        this.commname = commname;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDoseMethodCd() {
        return doseMethodCd;
    }

    public void setDoseMethodCd(String doseMethodCd) {
        this.doseMethodCd = doseMethodCd;
    }

    public String getDoseMethodName() {
        return doseMethodName;
    }

    public void setDoseMethodName(String doseMethodName) {
        this.doseMethodName = doseMethodName;
    }

    public BigDecimal getCommdosage() {
        return commdosage;
    }

    public void setCommdosage(BigDecimal commdosage) {
        this.commdosage = commdosage;
    }

    public String getDosageunit() {
        return dosageunit;
    }

    public void setDosageunit(String dosageunit) {
        this.dosageunit = dosageunit;
    }

    public String getCoopInsuranceCd() {
        return coopInsuranceCd;
    }

    public void setCoopInsuranceCd(String coopInsuranceCd) {
        this.coopInsuranceCd = coopInsuranceCd;
    }

    public String getPubmediCd() {
        return pubmediCd;
    }

    public void setPubmediCd(String pubmediCd) {
        this.pubmediCd = pubmediCd;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }
}
