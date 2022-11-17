package com.founder.rhip.ehr.entity.control.idm.notifiabledisease;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "IDM_ANORECTA_REPORT_TABLE")
public class IdmAnorectaReportTable implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "REPORT_DATE", columnDefinition = "TIMESTAMP|报表日期||", nullable = true)
    private Date reportDate;
	
    @Column(name = "TS_DIA_REG_NUM", columnDefinition = "NUMBER|乡级及以上腹泻病人登记数|", length = 20, nullable = true)
    private Integer tsDiaRegNum; 

	@Column(name = "VI_DIA_REG_NUM", columnDefinition = "NUMBER|村级腹泻病人登记数|20|", length = 20, nullable = true)
    private Integer viDiaRegNum;

    @Column(name = "ST_DIA_REG_NUM", columnDefinition = "NUMBER|小计腹泻病人登记数|20|", length = 20, nullable = true)
    private Integer stDiaRegNum;
		
	@Column(name = "RETRIEVAL_NUM", columnDefinition = "NUMBER|检索数|", length = 20, nullable = true)
    private Integer retrievalNum;

	@Column(name = "RETRIEVAL_RATE", columnDefinition = "VARCHAR2|检索率%||", length = 20, nullable = true)
    private String retrievalRate;

    @Column(name = "CHOLERA_POSI_O1", columnDefinition = "NUMBER|Ｏ1群霍乱检索阳性数|20|", length = 20, nullable = true)
    private Integer choleraPosiO1;
    
    @Column(name = "CHOLERA_POSI_O139", columnDefinition = "NUMBER|Ｏ139霍乱群霍乱检索阳性数|20|", length = 20, nullable = true)
    private Integer choleraPosiO139;
    	
    @Column(name = "FILL_USER_NAME", columnDefinition = "VARCHAR2|填表人||", length = 50, nullable = true)
    private String fillUserName;
    
    @Column(name = "FILL_USER_CODE", columnDefinition = "VARCHAR2|填表人编码||", length = 50, nullable = true)
    private String fillUserCode;

    @Column(name = "FILL_TIME", columnDefinition = "TIMESTAMP|填报日期时间||", nullable = true)
    private Date fillTime;
	
    @Column(name = "FILL_ORGAN_CODE", columnDefinition = "VARCHAR2|报告单位编码|100|", length = 100, nullable = true)
    private String fillOrganCode;

	public String getFillUserCode() {
		return fillUserCode;
	}

	public void setFillUserCode(String fillUserCode) {
		this.fillUserCode = fillUserCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	
	public Integer getTsDiaRegNum() {
		return tsDiaRegNum;
	}

	public void setTsDiaRegNum(Integer tsDiaRegNum) {
		this.tsDiaRegNum = tsDiaRegNum;
	}

	public Integer getViDiaRegNum() {
		return viDiaRegNum;
	}

	public void setViDiaRegNum(Integer viDiaRegNum) {
		this.viDiaRegNum = viDiaRegNum;
	}

	public Integer getStDiaRegNum() {
		return stDiaRegNum;
	}

	public void setStDiaRegNum(Integer stDiaRegNum) {
		this.stDiaRegNum = stDiaRegNum;
	}

	public Integer getRetrievalNum() {
		return retrievalNum;
	}

	public void setRetrievalNum(Integer retrievalNum) {
		this.retrievalNum = retrievalNum;
	}

	public String getRetrievalRate() {
		return retrievalRate;
	}

	public void setRetrievalRate(String retrievalRate) {
		this.retrievalRate = retrievalRate;
	}

	public Integer getCholeraPosiO1() {
		return choleraPosiO1;
	}

	public void setCholeraPosiO1(Integer choleraPosiO1) {
		this.choleraPosiO1 = choleraPosiO1;
	}

	public Integer getCholeraPosiO139() {
		return choleraPosiO139;
	}

	public void setCholeraPosiO139(Integer choleraPosiO139) {
		this.choleraPosiO139 = choleraPosiO139;
	}

	public String getFillUserName() {
		return fillUserName;
	}

	public void setFillUserName(String fillUserName) {
		this.fillUserName = fillUserName;
	}

	public Date getFillTime() {
		return fillTime;
	}

	public void setFillTime(Date fillTime) {
		this.fillTime = fillTime;
	}

	public String getFillOrganCode() {
		return fillOrganCode;
	}

	public void setFillOrganCode(String fillOrganCode) {
		this.fillOrganCode = fillOrganCode;
	}
     
}
