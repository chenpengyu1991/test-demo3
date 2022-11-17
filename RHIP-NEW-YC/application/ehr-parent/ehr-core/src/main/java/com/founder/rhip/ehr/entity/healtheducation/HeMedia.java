package com.founder.rhip.ehr.entity.healtheducation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 影响播放 add by Kevin Ro 2018-07-16
 */
@Entity
@Table(name = "HE_MEDIA")
public class HeMedia implements Serializable {

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
    private Long id;

    @Column(name = "ORG_CODE", columnDefinition = "VARCHAR2|机构代码||", length = 18, nullable = true)
    private String orgCode;

    @Column(name = "CENTER_ORG_CODE", columnDefinition = "VARCHAR2|上级机构代码||", length = 18, nullable = true)
    private String centerOrgCode;

    @Column(name = "GBCODE", columnDefinition = "VARCHAR2|乡镇代码||", length = 18, nullable = true)
    private String gbcode;

    @Column(name = "THEME", columnDefinition = "VARCHAR2|影响主题||", length = 50, nullable = true)
    private String theme;

    @Column(name = "TIMES", columnDefinition = "VARCHAR2|播放天数||", length = 10, nullable = true)
    private String times;

    @Column(name = "PERIOD", columnDefinition = "VARCHAR2|播放时长（单位分钟）||", length = 20, nullable = true)
    private String period;

    @Column(name = "PLAY_DATE", columnDefinition = "DATE|播放日期||", nullable = true)
    private Date playDate;

    @Column(name = "FILL_DATE", columnDefinition = "DATE|填报日期||", nullable = true)
    private Date fillDate;

    @Column(name = "RESOURCE_CREATER", columnDefinition = "VARCHAR2|资源创建人||", length = 50, nullable = true)
    private String resourceCreater;

    @Column(name = "TOTAL_PERIOD", columnDefinition = "VARCHAR2|总播放时长||", length = 50, nullable = true)
    private Long totalPeriod;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getCenterOrgCode() {
        return centerOrgCode;
    }

    public void setCenterOrgCode(String centerOrgCode) {
        this.centerOrgCode = centerOrgCode;
    }

    public String getGbcode() {
        return gbcode;
    }

    public void setGbcode(String gbcode) {
        this.gbcode = gbcode;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Date getPlayDate() {
        return playDate;
    }

    public void setPlayDate(Date playDate) {
        this.playDate = playDate;
    }

    public String getResourceCreater() {
        return resourceCreater;
    }

    public void setResourceCreater(String resourceCreater) {
        this.resourceCreater = resourceCreater;
    }

    public Date getFillDate() {
        return fillDate;
    }

    public void setFillDate(Date fillDate) {
        this.fillDate = fillDate;
    }

    public Long getTotalPeriod() {
        return totalPeriod;
    }

    public void setTotalPeriod(Long totalPeriod) {
        this.totalPeriod = totalPeriod;
    }
}
