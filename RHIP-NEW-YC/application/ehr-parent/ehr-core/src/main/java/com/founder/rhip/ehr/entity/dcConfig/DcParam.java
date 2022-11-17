package com.founder.rhip.ehr.entity.dcConfig;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DC_PARAM")
public class DcParam implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|ID|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "TYPE", columnDefinition = "VARCHAR2|类别(1:重复检查，2：重复检验，3：重复用药)|50|", length = 50, nullable = true)
    private String type;

    @Column(name = "ITEM", columnDefinition = "VARCHAR2|项目描述|100|", length = 100, nullable = true)
    private String item;

    @Column(name = "ITEM_CODE", columnDefinition = "VARCHAR2|项目CODE|50|", length = 50, nullable = true)
    private String itemCode;

    @Column(name = "ITEM_VALUE", columnDefinition = "VARCHAR2|参数值|50|", length = 50, nullable = true)
    private String itemValue;

    @Column(name = "COOP_INSURANCE_CD", columnDefinition = "VARCHAR2|农保编码|20|", length = 20, nullable = true)
    private String coopInsuranceCd;

    @Column(name = "PUBMEDI_CD", columnDefinition = "VARCHAR2|医保编码|20|", length = 20, nullable = true)
    private String pubmediCd;

    @Transient
    private String dataJson;

    @Transient
    private int days;

    @Transient
    private int minutes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }

    public String getDataJson() {
        return dataJson;
    }

    public void setDataJson(String dataJson) {
        this.dataJson = dataJson;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String getPubmediCd() {
        return pubmediCd;
    }

    public void setPubmediCd(String pubmediCd) {
        this.pubmediCd = pubmediCd;
    }

    public String getCoopInsuranceCd() {
        return coopInsuranceCd;
    }

    public void setCoopInsuranceCd(String coopInsuranceCd) {
        this.coopInsuranceCd = coopInsuranceCd;
    }
}