package com.founder.rhip.ncp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "NCP_REEXAMINATION_ITEM")
public class NcpReexaminationItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|主键|, length = 0, nullable =false")
    private BigDecimal id;
    @Column(name = "PATIENT_ID", columnDefinition = "NUMBER|新冠患者ID|, length = 18, nullable = false")
    private BigDecimal patientId;
    @Column(name = "MONITOR_ID", columnDefinition = "VARCHAR2|监测随访表ID|, length = 2, nullable = false")
    private BigDecimal monitorId;

    @Column(name = "XT", columnDefinition = "VARCHAR2|血糖|, length = 18, nullable = false")
    private String xt;

    @Column(name = "XCG", columnDefinition = "VARCHAR2|血常规|, length = 18, nullable = false")
    private String xcg;

    @Column(name = "SH", columnDefinition = "VARCHAR2|生化|, length = 18, nullable = false")
    private String sh;

    @Column(name = "YBHD", columnDefinition = "VARCHAR2|痒饱和度|, length = 18, nullable = false")
    private String ybhd;

    @Column(name = "XBYX", columnDefinition = "VARCHAR2|胸部影响|, length = 18, nullable = false")
    private String xbyx;

    @Column(name = "BYXJC", columnDefinition = "VARCHAR2|新冠病原学检测|, length = 18, nullable = false")
    private String byxjc;

    @Column(name = "HXGN", columnDefinition = "VARCHAR2|呼吸功能|, length = 18, nullable = false")
    private String hxgn;

    @Column(name = "YDGN", columnDefinition = "VARCHAR2|运动功能|, length = 18, nullable = false")
    private String ydgn;

    @Column(name = "BXBS", columnDefinition = "VARCHAR2|白细胞数|, length = 18, nullable = false")
    private String bxbs;

    @Column(name = "LBXBS", columnDefinition = "VARCHAR2|淋巴细胞数|, length = 18, nullable = false")
    private String lbxbs;

    @Column(name = "LBXBBFB", columnDefinition = "VARCHAR2|淋巴细胞百分比|, length = 18, nullable = false")
    private String lbxbbfb;

    @Column(name = "ZXLXBBFB", columnDefinition = "VARCHAR2|中性粒细胞百分比|, length = 18, nullable = false")
    private String zxlxbbfb;

    @Column(name = "GBZAM", columnDefinition = "VARCHAR2|谷丙转氨酶|, length = 18, nullable = false")
    private String gbzam;

    @Column(name = "GCZAM", columnDefinition = "VARCHAR2|谷草转氨酶|, length = 18, nullable = false")
    private String gczam;

    @Column(name = "ZDHS", columnDefinition = "VARCHAR2|总胆红素|, length = 18, nullable = false")
    private String zdhs;

    @Column(name = "XQJG", columnDefinition = "VARCHAR2|血清肌酐|, length = 18, nullable = false")
    private String xqjg;

    @Column(name = "XLS", columnDefinition = "VARCHAR2|血尿素|, length = 18, nullable = false")
    private String xls;

    @Column(name = "CT_RESULT", columnDefinition = "VARCHAR2|CT结果(1正常:2异常)|, length = 18, nullable = false")
    private String ctResult;

    @Column(name = "HSJC", columnDefinition = "VARCHAR2|核酸检查(1阴性:2阳性)|, length = 18, nullable = false")
    private String hsjc;

    @Column(name = "IGMKT", columnDefinition = "VARCHAR2|IgM抗体(1阴性:2阳性)|, length = 18, nullable = false")
    private String igmkt;

    @Column(name = "IGGKT", columnDefinition = "VARCHAR2|IgG抗体(1阴性:2阳性)|, length = 18, nullable = false")
    private String iggkt;

    @Column(name = "HXGN_RESULT", columnDefinition = "VARCHAR2|呼吸功能(1正常:2异常)|, length = 18, nullable = false")
    private String hxgnResult;

    @Column(name = "YDGN_RESULT", columnDefinition = "VARCHAR2|运动功能(1正常:2异常)|, length = 18, nullable = false")
    private String ydgnResult;

    public String getBxbs() {
        return bxbs;
    }

    public void setBxbs(String bxbs) {
        this.bxbs = bxbs;
    }

    public String getLbxbs() {
        return lbxbs;
    }

    public void setLbxbs(String lbxbs) {
        this.lbxbs = lbxbs;
    }

    public String getLbxbbfb() {
        return lbxbbfb;
    }

    public void setLbxbbfb(String lbxbbfb) {
        this.lbxbbfb = lbxbbfb;
    }

    public String getZxlxbbfb() {
        return zxlxbbfb;
    }

    public void setZxlxbbfb(String zxlxbbfb) {
        this.zxlxbbfb = zxlxbbfb;
    }

    public String getGbzam() {
        return gbzam;
    }

    public void setGbzam(String gbzam) {
        this.gbzam = gbzam;
    }

    public String getGczam() {
        return gczam;
    }

    public void setGczam(String gczam) {
        this.gczam = gczam;
    }

    public String getZdhs() {
        return zdhs;
    }

    public void setZdhs(String zdhs) {
        this.zdhs = zdhs;
    }

    public String getXqjg() {
        return xqjg;
    }

    public void setXqjg(String xqjg) {
        this.xqjg = xqjg;
    }

    public String getXls() {
        return xls;
    }

    public void setXls(String xls) {
        this.xls = xls;
    }

    public String getCtResult() {
        return ctResult;
    }

    public void setCtResult(String ctResult) {
        this.ctResult = ctResult;
    }

    public String getHsjc() {
        return hsjc;
    }

    public void setHsjc(String hsjc) {
        this.hsjc = hsjc;
    }

    public String getIgmkt() {
        return igmkt;
    }

    public void setIgmkt(String igmkt) {
        this.igmkt = igmkt;
    }

    public String getIggkt() {
        return iggkt;
    }

    public void setIggkt(String iggkt) {
        this.iggkt = iggkt;
    }

    public String getHxgnResult() {
        return hxgnResult;
    }

    public void setHxgnResult(String hxgnResult) {
        this.hxgnResult = hxgnResult;
    }

    public String getYdgnResult() {
        return ydgnResult;
    }

    public void setYdgnResult(String ydgnResult) {
        this.ydgnResult = ydgnResult;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getPatientId() {
        return patientId;
    }

    public void setPatientId(BigDecimal patientId) {
        this.patientId = patientId;
    }

    public BigDecimal getMonitorId() {
        return monitorId;
    }

    public void setMonitorId(BigDecimal monitorId) {
        this.monitorId = monitorId;
    }

    public String getXt() {
        return xt;
    }

    public void setXt(String xt) {
        this.xt = xt;
    }

    public String getXcg() {
        return xcg;
    }

    public void setXcg(String xcg) {
        this.xcg = xcg;
    }

    public String getSh() {
        return sh;
    }

    public void setSh(String sh) {
        this.sh = sh;
    }

    public String getYbhd() {
        return ybhd;
    }

    public void setYbhd(String ybhd) {
        this.ybhd = ybhd;
    }

    public String getXbyx() {
        return xbyx;
    }

    public void setXbyx(String xbyx) {
        this.xbyx = xbyx;
    }

    public String getByxjc() {
        return byxjc;
    }

    public void setByxjc(String byxjc) {
        this.byxjc = byxjc;
    }

    public String getHxgn() {
        return hxgn;
    }

    public void setHxgn(String hxgn) {
        this.hxgn = hxgn;
    }

    public String getYdgn() {
        return ydgn;
    }

    public void setYdgn(String ydgn) {
        this.ydgn = ydgn;
    }
}
