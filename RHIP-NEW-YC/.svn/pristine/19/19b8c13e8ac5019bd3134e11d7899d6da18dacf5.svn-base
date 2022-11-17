package com.founder.rhip.ehr.entity.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "BI_ADMINISTRATIVE_AREA")
public class AdministrativeArea implements Serializable {

	private static final long serialVersionUID = -2909267352968554549L;

	@Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "GBCODE", columnDefinition = "VARCHAR2|12位行政区划代码||", length = 12, nullable = true)
    private String gbcode;

    @Column(name = "ZONE_GBCODE", columnDefinition = "VARCHAR2|10位行政区划代码||", length = 10, nullable = true)
    private String zoneGBCode;

    @Column(name = "AREA_CODE", columnDefinition = "VARCHAR2|辖区行政级别代码||", length = 1, nullable = true)
    private String areaCode;

    @Column(name = "AREA_NAME", columnDefinition = "VARCHAR2|地区名称||", length = 30, nullable = true)
    private String areaName;

    @Column(name = "DAPROVINCE", columnDefinition = "VARCHAR2|详细地区-省(自治区、直辖市)||", length = 70, nullable = true)
    private String daprovince;

    @Column(name = "DACITY", columnDefinition = "VARCHAR2|详细地区-市(地区、州)||", length = 70, nullable = true)
    private String dacity;

    @Column(name = "DACOUNTY", columnDefinition = "VARCHAR2|详细地区-县(区)||", length = 70, nullable = true)
    private String dacounty;

    @Column(name = "DATOWN_SHIP", columnDefinition = "VARCHAR2|详细地区-乡(镇、街道办事处)||", length = 70, nullable = true)
    private String datownShip;

    @Column(name = "DASTREET", columnDefinition = "VARCHAR2|详细地区-村(街、路、弄等)||", length = 70, nullable = true)
    private String dastreet;

    @Column(name = "DAHOUSE_NUMBER", columnDefinition = "VARCHAR2|详细地区-门牌号码||", length = 70, nullable = true)
    private String dahouseNumber;

    @Column(name = "DAPOST_CODE", columnDefinition = "VARCHAR2|详细地区邮政编码||", length = 6, nullable = true)
    private String dapostCode;

    @Column(name = "REGION_TOTAL_POPULATION", columnDefinition = "NUMBER|地区人口总数||", length = 8, nullable = true)
    private String regionTotalPopulation;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER|0表示可用 -1表示删除|", length = 1, nullable = true)
    private Integer isDelete = 0;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getGbcode() {
		return gbcode;
	}

	public void setGbcode(String gbcode) {
		this.gbcode = gbcode;
	}

	public String getZoneGBCode() {
        return this.zoneGBCode;
    }

    public void setZoneGBCode(String zoneGBCode) {
        this.zoneGBCode = zoneGBCode;
    }

    public String getAreaCode() {
        return this.areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return this.areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getDaprovince() {
        return this.daprovince;
    }

    public void setDaprovince(String daprovince) {
        this.daprovince = daprovince;
    }

    public String getDacity() {
        return this.dacity;
    }

    public void setDacity(String dacity) {
        this.dacity = dacity;
    }

    public String getDacounty() {
        return this.dacounty;
    }

    public void setDacounty(String dacounty) {
        this.dacounty = dacounty;
    }

    public String getDatownShip() {
        return this.datownShip;
    }

    public void setDatownShip(String datownShip) {
        this.datownShip = datownShip;
    }

    public String getDastreet() {
        return this.dastreet;
    }

    public void setDastreet(String dastreet) {
        this.dastreet = dastreet;
    }

    public String getDahouseNumber() {
        return this.dahouseNumber;
    }

    public void setDahouseNumber(String dahouseNumber) {
        this.dahouseNumber = dahouseNumber;
    }

    public String getDapostCode() {
        return this.dapostCode;
    }

    public void setDapostCode(String dapostCode) {
        this.dapostCode = dapostCode;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegionTotalPopulation() {
        return regionTotalPopulation;
    }

    public void setRegionTotalPopulation(String regionTotalPopulation) {
        this.regionTotalPopulation = regionTotalPopulation;
    }

}
