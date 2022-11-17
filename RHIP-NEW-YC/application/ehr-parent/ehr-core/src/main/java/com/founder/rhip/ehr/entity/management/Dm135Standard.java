package com.founder.rhip.ehr.entity.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by jingqiu on 17-4-12.
 */
@Entity
@Table(name = "DM_135STANDARD")
public class Dm135Standard {
    @Id
    @Column(name = "ID", columnDefinition = "VARCHAR2|数据库唯一编号（自增长）||", length = 32, nullable = false)
    private String id;

    @Column(name = "WAIST_LINE_MAN", columnDefinition = "NUMBER|男性腰围||", nullable = true)
    private BigDecimal waistLineMan;

    @Column(name = "WAIST_LINE_WOMAN", columnDefinition = "NUMBER|女性腰围||", nullable = true)
    private BigDecimal waistLineWoman;

    @Column(name = "TRIGLYCERIDE", columnDefinition = "NUMBER|三酰甘油||", nullable = true)
    private BigDecimal triglyceride;

    @Column(name = "LHDLC_MAN", columnDefinition = "NUMBER|男性低高密度脂蛋白胆固醇||", nullable = true)
    private BigDecimal lhdlcMan;

    @Column(name = "LHDLC_WOMAN", columnDefinition = "NUMBER|女性低高密度脂蛋白胆固醇||", nullable = true)
    private BigDecimal lhdlcWoman;

    @Column(name = "SBP", columnDefinition = "NUMBER|收缩压||", nullable = true)
    private Integer sbp;

    @Column(name = "DBP", columnDefinition = "NUMBER|舒张压||", nullable = true)
    private Integer dbp;

    @Column(name = "FBG", columnDefinition = "NUMBER|空腹血糖||", nullable = true)
    private BigDecimal fbg;

    @Column(name = "TR_SYMBOL", columnDefinition = "NUMBER|三酰甘油单位||", nullable = true)
    private Integer trSymbol;

    @Column(name = "LH_MAN_SYMBOL", columnDefinition = "NUMBER|男性低高密度脂蛋白胆固醇单位||", nullable = true)
    private Integer lhManSymbol;

    @Column(name = "LH_WOMAN_SYMBOL", columnDefinition = "NUMBER|女性低高密度脂蛋白胆固醇单位||", nullable = true)
    private Integer lhWomanSymbol;

    @Column(name = "FBG_SYMBOL", columnDefinition = "NUMBER|空腹血糖单位||", nullable = true)
    private Integer fbgSymbol;

    @Column(name = "SET_STANDARD_FLAG", columnDefinition = "NUMBER|1是ATTP3，2是国家||", nullable = true)
    private Integer setStandardFlag;

    @Column(name = "IS_STARTUP", columnDefinition = "NUMBER|1是启用ATTP3标准||", nullable = true)
    private Integer isStartup;

    @Column(name = "BMI", columnDefinition = "NUMBER|身体质量指数||", nullable = true)
    private Integer bmi;

    @Column(name = "RSBP", columnDefinition = "NUMBER|高收缩压||", nullable = true)
    private Integer rsbp;

    @Column(name = "RDBP", columnDefinition = "NUMBER|高舒张压||", nullable = true)
    private Integer rdbp;

    @Column(name = "TC", columnDefinition = "NUMBER|血脂TC边缘升高||", nullable = true)
    private BigDecimal tc;

    @Column(name = "TG", columnDefinition = "NUMBER|血脂TG升高||", nullable = true)
    private BigDecimal tg;

    @Column(name = "RFBG", columnDefinition = "NUMBER|空腹血糖高值||", nullable = true)
    private BigDecimal rfbg;

    @Column(name = "CREATE_DATE", columnDefinition = "DATE|创建日期||", nullable = true)
    private Date createDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getWaistLineMan() {
        return waistLineMan;
    }

    public void setWaistLineMan(BigDecimal waistLineMan) {
        this.waistLineMan = waistLineMan;
    }

    public BigDecimal getWaistLineWoman() {
        return waistLineWoman;
    }

    public void setWaistLineWoman(BigDecimal waistLineWoman) {
        this.waistLineWoman = waistLineWoman;
    }

    public BigDecimal getTriglyceride() {
        return triglyceride;
    }

    public void setTriglyceride(BigDecimal triglyceride) {
        this.triglyceride = triglyceride;
    }

    public BigDecimal getLhdlcMan() {
        return lhdlcMan;
    }

    public void setLhdlcMan(BigDecimal lhdlcMan) {
        this.lhdlcMan = lhdlcMan;
    }

    public BigDecimal getLhdlcWoman() {
        return lhdlcWoman;
    }

    public void setLhdlcWoman(BigDecimal lhdlcWoman) {
        this.lhdlcWoman = lhdlcWoman;
    }

    public Integer getSbp() {
        return sbp;
    }

    public void setSbp(Integer sbp) {
        this.sbp = sbp;
    }

    public Integer getDbp() {
        return dbp;
    }

    public void setDbp(Integer dbp) {
        this.dbp = dbp;
    }

    public BigDecimal getFbg() {
        return fbg;
    }

    public void setFbg(BigDecimal fbg) {
        this.fbg = fbg;
    }

    public Integer getTrSymbol() {
        return trSymbol;
    }

    public void setTrSymbol(Integer trSymbol) {
        this.trSymbol = trSymbol;
    }

    public Integer getLhManSymbol() {
        return lhManSymbol;
    }

    public void setLhManSymbol(Integer lhManSymbol) {
        this.lhManSymbol = lhManSymbol;
    }

    public Integer getLhWomanSymbol() {
        return lhWomanSymbol;
    }

    public void setLhWomanSymbol(Integer lhWomanSymbol) {
        this.lhWomanSymbol = lhWomanSymbol;
    }

    public Integer getFbgSymbol() {
        return fbgSymbol;
    }

    public void setFbgSymbol(Integer fbgSymbol) {
        this.fbgSymbol = fbgSymbol;
    }

    public Integer getSetStandardFlag() {
        return setStandardFlag;
    }

    public void setSetStandardFlag(Integer setStandardFlag) {
        this.setStandardFlag = setStandardFlag;
    }

    public Integer getIsStartup() {
        return isStartup;
    }

    public void setIsStartup(Integer isStartup) {
        this.isStartup = isStartup;
    }

    public Integer getBmi() {
        return bmi;
    }

    public void setBmi(Integer bmi) {
        this.bmi = bmi;
    }

    public Integer getRsbp() {
        return rsbp;
    }

    public void setRsbp(Integer rsbp) {
        this.rsbp = rsbp;
    }

    public Integer getRdbp() {
        return rdbp;
    }

    public void setRdbp(Integer rdbp) {
        this.rdbp = rdbp;
    }

    public BigDecimal getTc() {
        return tc;
    }

    public void setTc(BigDecimal tc) {
        this.tc = tc;
    }

    public BigDecimal getTg() {
        return tg;
    }

    public void setTg(BigDecimal tg) {
        this.tg = tg;
    }

    public BigDecimal getRfbg() {
        return rfbg;
    }

    public void setRfbg(BigDecimal rfbg) {
        this.rfbg = rfbg;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
