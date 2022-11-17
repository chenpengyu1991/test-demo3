package com.founder.rhip.ehr.entity.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by f on 2018/7/2.
 */
@Entity
@Table(name = "DM_YI_SHARE")
public class DmYiShare implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "IDCARD", columnDefinition = "VARCHAR2|居民身份证/健康卡号||", length = 18, nullable = true)
    private String idcard;

    @Column(name = "CHECK_TIME", columnDefinition = "DATE|检查日期||", nullable = true)
    private Date checkTime;

    @Column(name = "SBP", columnDefinition = "NUMBER|收缩压||", length = 20, nullable = true)
    private Integer sbp;

    @Column(name = "DBP", columnDefinition = "NUMBER|舒张压||", length = 20, nullable = true)
    private Integer dbp;

    @Column(name = "HEIGHT", columnDefinition = "NUMBER|身高||", length = 20, nullable = true)
    private Double height;

    @Column(name = "WEIGHT", columnDefinition = "NUMBER|体重||", length = 20, nullable = true)
    private Double weight;

    @Column(name = "FETALHEART", columnDefinition = "NUMBER|心率||", length = 20, nullable = true)
    private Integer fetalheart;

    @Column(name = "GLU", columnDefinition = "NUMBER|血糖||", length = 20, nullable = true)
    private Double glu;

    @Column(name = "ANAL", columnDefinition = "VARCHAR2|心电图||", length = 18, nullable = true)
    private String anal;

    @Column(name = "MEMO1", columnDefinition = "VARCHAR2|血糖类型|0:空腹血糖1:随机血糖|", length = 20, nullable = true)
    private String memo1;

    @Column(name = "UNAME", columnDefinition = "VARCHAR2|姓名||", length = 20, nullable = true)
    private String uname;

    @Column(name = "ORG_NAME", columnDefinition = "VARCHAR2|姓名||", length = 20, nullable = true)
    private String orgName;

    @Column(name = "TEMP", columnDefinition = "VARCHAR2|体温||", length = 20, nullable = true)
    private String temp;

    @Column(name = "PULSE", columnDefinition = "VARCHAR2|脉率||", length = 20, nullable = true)
    private String pulse;

    @Column(name = "CHO", columnDefinition = "VARCHAR2|总胆固醇||", length = 20, nullable = true)
    private String cho;

    @Column(name = "BREATH", columnDefinition = "VARCHAR2|呼吸频率||", length = 20, nullable = true)
    private String breath;

    @Column(name = "TG", columnDefinition = "VARCHAR2|甘油三酯||", length = 20, nullable = true)
    private String tg;

    @Column(name = "HDL", columnDefinition = "VARCHAR2|高密度脂蛋白||", length = 20, nullable = true)
    private String hdl;

    @Column(name = "LDL", columnDefinition = "VARCHAR2|低密度脂蛋白||", length = 20, nullable = true)
    private String ldl;

    @Column(name = "NCG_BLO", columnDefinition = "VARCHAR2|隐血（潜血）||", length = 20, nullable = true)
    private String ncgBlo;

    @Column(name = "NCG_PRO", columnDefinition = "VARCHAR2|尿蛋白||", length = 20, nullable = true)
    private String ncgPro;

    @Column(name = "NCG_KET", columnDefinition = "VARCHAR2|酮体||", length = 20, nullable = true)
    private String ncgKet;

    @Column(name = "NCG_GLU", columnDefinition = "VARCHAR2|尿糖||", length = 20, nullable = true)
    private String ncgGlu;

    @Column(name = "NCG_BIL", columnDefinition = "VARCHAR2|胆红素||", length = 20, nullable = true)
    private String ncgBil;

    @Column(name = "NCG_LEU", columnDefinition = "VARCHAR2|白细胞||", length = 20, nullable = true)
    private String ncgLeu;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getPulse() {
        return pulse;
    }

    public void setPulse(String pulse) {
        this.pulse = pulse;
    }

    public String getCho() {
        return cho;
    }

    public void setCho(String cho) {
        this.cho = cho;
    }

    public String getBreath() {
        return breath;
    }

    public void setBreath(String breath) {
        this.breath = breath;
    }

    public String getTg() {
        return tg;
    }

    public void setTg(String tg) {
        this.tg = tg;
    }

    public String getHdl() {
        return hdl;
    }

    public void setHdl(String hdl) {
        this.hdl = hdl;
    }

    public String getLdl() {
        return ldl;
    }

    public void setLdl(String ldl) {
        this.ldl = ldl;
    }

    public String getNcgBlo() {
        return ncgBlo;
    }

    public void setNcgBlo(String ncgBlo) {
        this.ncgBlo = ncgBlo;
    }

    public String getNcgPro() {
        return ncgPro;
    }

    public void setNcgPro(String ncgPro) {
        this.ncgPro = ncgPro;
    }

    public String getNcgKet() {
        return ncgKet;
    }

    public void setNcgKet(String ncgKet) {
        this.ncgKet = ncgKet;
    }

    public String getNcgGlu() {
        return ncgGlu;
    }

    public void setNcgGlu(String ncgGlu) {
        this.ncgGlu = ncgGlu;
    }

    public String getNcgBil() {
        return ncgBil;
    }

    public void setNcgBil(String ncgBil) {
        this.ncgBil = ncgBil;
    }

    public String getNcgLeu() {
        return ncgLeu;
    }

    public void setNcgLeu(String ncgLeu) {
        this.ncgLeu = ncgLeu;
    }

    public Double getGlu() {
        return glu;
    }

    public void setGlu(Double glu) {
        this.glu = glu;
    }

    public String getAnal() {
        return anal;
    }

    public void setAnal(String anal) {
        this.anal = anal;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
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

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getFetalheart() {
        return fetalheart;
    }

    public void setFetalheart(Integer fetalheart) {
        this.fetalheart = fetalheart;
    }

    public String getMemo1() {
        return memo1;
    }

    public void setMemo1(String memo1) {
        this.memo1 = memo1;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}
