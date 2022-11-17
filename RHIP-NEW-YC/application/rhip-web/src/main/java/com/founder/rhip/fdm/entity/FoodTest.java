package com.founder.rhip.fdm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Cary
 *
 */
@Entity
@Table(name = "FD_TEST")
public class FoodTest implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|本表唯一编码|11|", length = 11, nullable = false)
	private Long id;

    @Column(name = "REPORT_ID", columnDefinition = "NUMBER|报卡id||", length = 11, nullable = false)
    private Long reportId;

	@Column(name = "SALMONELLA", columnDefinition = "VARCHAR2|沙门氏菌|30|", length = 30, nullable = true)
	private String salmonella;

	@Column(name = "VPA", columnDefinition = "VARCHAR2|副溶血性弧菌|30|", length = 30, nullable = true)
	private String vpa;

	@Column(name = "SHIGELLA", columnDefinition = "VARCHAR2|志贺氏菌|30|", length = 30, nullable = true)
	private String shigella;

	@Column(name = "STA", columnDefinition = "VARCHAR2|金黄色葡萄球菌|30|", length = 30, nullable = true)
	private String sta;

	@Column(name = "PROTEUS_MIRABILIS", columnDefinition = "VARCHAR2|变形杆菌|30|", length = 30, nullable = true)
	private String proteusMirabilis;

	@Column(name = "PEC", columnDefinition = "VARCHAR2|致病性大肠杆菌|30|", length = 30, nullable = true)
	private String pec;

	@Column(name = "EJP", columnDefinition = "VARCHAR2|小肠结肠炎耶尔森氏菌|30|", length = 30, nullable = true)
	private String ejp;

	@Column(name = "ROTAVIRUS", columnDefinition = "VARCHAR2|轮状病毒|30|", length = 30, nullable = true)
	private String rotavirus;

	@Column(name = "NOROVIRUS", columnDefinition = "VARCHAR2|诺如病毒|30|", length = 30, nullable = true)
	private String norovirus;

	@Column(name = "ASTROVIRUS", columnDefinition = "VARCHAR2|星状病毒|30|", length = 30, nullable = true)
	private String astrovirus;

	@Column(name = "ADENOVIRUS", columnDefinition = "VARCHAR2|腺病毒|30|", length = 30, nullable = true)
	private String adenovirus;

	@Column(name = "SAPOVIRUS", columnDefinition = "VARCHAR2|札如病毒|30|", length = 30, nullable = true)
	private String sapovirus;

    @Column(name = "CHECK_DATE", columnDefinition = "DATE|检验日期||", nullable = true)
    private Date checkDate;

    @Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|送检医院编码|50|", length = 50, nullable = true)
	private String organCode;

	@Column(name = "ORGAN_NAME", columnDefinition = "VARCHAR2|送检医院名称|50|", length = 50, nullable = true)
	private String organName;

    @Column(name = "PATHOGENS_TEST", columnDefinition = "VARCHAR2|致病菌检测|30|", length = 30, nullable = true)
    private String pathogensTest;

    @Column(name = "VIRUSES_TEXT", columnDefinition = "VARCHAR2|病毒检测|30|", length = 30, nullable = true)
    private String virusesTest;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getSalmonella() {
        return salmonella;
    }

    public void setSalmonella(String salmonella) {
        this.salmonella = salmonella;
    }

    public String getVpa() {
        return vpa;
    }

    public void setVpa(String vpa) {
        this.vpa = vpa;
    }

    public String getShigella() {
        return shigella;
    }

    public void setShigella(String shigella) {
        this.shigella = shigella;
    }

    public String getSta() {
        return sta;
    }

    public void setSta(String sta) {
        this.sta = sta;
    }

    public String getProteusMirabilis() {
        return proteusMirabilis;
    }

    public void setProteusMirabilis(String proteusMirabilis) {
        this.proteusMirabilis = proteusMirabilis;
    }

    public String getPec() {
        return pec;
    }

    public void setPec(String pec) {
        this.pec = pec;
    }

    public String getEjp() {
        return ejp;
    }

    public void setEjp(String ejp) {
        this.ejp = ejp;
    }

    public String getRotavirus() {
        return rotavirus;
    }

    public void setRotavirus(String rotavirus) {
        this.rotavirus = rotavirus;
    }

    public String getNorovirus() {
        return norovirus;
    }

    public void setNorovirus(String norovirus) {
        this.norovirus = norovirus;
    }

    public String getAstrovirus() {
        return astrovirus;
    }

    public void setAstrovirus(String astrovirus) {
        this.astrovirus = astrovirus;
    }

    public String getAdenovirus() {
        return adenovirus;
    }

    public void setAdenovirus(String adenovirus) {
        this.adenovirus = adenovirus;
    }

    public String getSapovirus() {
        return sapovirus;
    }

    public void setSapovirus(String sapovirus) {
        this.sapovirus = sapovirus;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public String getOrganCode() {
        return organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public String getPathogensTest() {
        return pathogensTest;
    }

    public void setPathogensTest(String pathogensTest) {
        this.pathogensTest = pathogensTest;
    }

    public String getVirusesTest() {
        return virusesTest;
    }

    public void setVirusesTest(String virusesTest) {
        this.virusesTest = virusesTest;
    }
}