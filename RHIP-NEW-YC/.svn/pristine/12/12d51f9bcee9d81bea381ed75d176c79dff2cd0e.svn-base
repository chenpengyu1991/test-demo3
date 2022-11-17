package com.founder.rhip.ehr.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by yuanzg on 2017/5/8.
 */
@Entity
@Table(name = "SR_INFECT_EMERGENCIES")
public class InfectEmergencies implements Serializable{

    private static final long serialVersionUID = -1398047229946590341L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "ORG_CODE", columnDefinition = "VARCHAR2|机构编码|50|", length = 50, nullable = true)
    private String orgCode;

    @Column(name = "ORG_NAME", columnDefinition = "VARCHAR2|机构名称|50|", length = 50, nullable = true)
    private String orgName;

    @Column(name = "PARENT_CODE", columnDefinition = "VARCHAR2|上级机构编码|50|", length = 50, nullable = true)
    private String parentCode;

    @Column(name = "PARENT_NAME", columnDefinition = "VARCHAR2|上级机构名称|50|", length = 50, nullable = true)
    private String parentName;

    @Column(name = "YEAR", columnDefinition = "NUMBER|年份|5|", length = 5, nullable = true)
    private Integer year;

    @Column(name = "QUARTER", columnDefinition = "NUMBER|季度|1|", length = 1, nullable = true)
    private Integer quarter;

    @Column(name = "REPORT_TIME", columnDefinition = "DATE|填报日期||", nullable = true)
    private Date reportTime;

    @Column(name = "COUNT_TYPE", columnDefinition = "VARCHAR2|统计类型|50|", length = 50, nullable = true)
    private String countType;
    
    @Column(name = "REGISTER_INFECTIOUS_NUM", columnDefinition = "NUMBER|登记传染病病例数||", nullable = true)
    private Integer registerInfectiousNum = 0;
 
    @Column(name = "NETWORK_INFECTIOUS_NUM", columnDefinition = "NUMBER|网络报告的传染病病例数||", nullable = true)
    private Integer networkInfectiousNum = 0;
    
    @Column(name = "OCCUR_INFECTIOUS_NUM", columnDefinition = "NUMBER|发生传染病病人数(人)||", nullable = true)
    private Integer occurInfectiousNum = 0;

    @Column(name = "REPORT_INFECTIOUS_NUM", columnDefinition = "NUMBER|报告传染病病人数(人)||", nullable = true)
    private Integer reportInfectiousNum = 0;

    @Column(name = "TIMELY_INFECTIOUS_NUM", columnDefinition = "NUMBER|报告及时的传染病病人数(人)||", nullable = true)
    private Integer timelyInfectiousNum = 0;

    @Column(name = "OCCUR_EMERGENCIES_NUM", columnDefinition = "NUMBER|应报告突发公共卫生事件相关信息数(次)||", nullable = true)
    private Integer occurEmergenciesNum = 0;

    @Column(name = "REPORT_EMERGENCIES_NUM", columnDefinition = "NUMBER|实报告突发公共卫生事件相关信息数(次)||", nullable = true)
    private Integer reportEmergenciesNum = 0;

    @Column(name = "TIMELY_EMERGENCIES_NUM", columnDefinition = "NUMBER|及时报告突发公共卫生事件相关信息(次)||", nullable = true)
    private Integer timelyEmergenciesNum = 0;

    @Column(name = "NET_REPORT_DEATHNUM", columnDefinition = "NUMBER|网络报告死亡数||", nullable = true)
    private Integer netReportDeathnum = 0;

    @Column(name = "YEAR_REGISTER_INFECTIOUS_NUM", columnDefinition = "NUMBER|年度累计登记传染病病例数||", nullable = true)
    private Integer yearRegisterInfectiousNum = 0;
 
    @Column(name = "YEAR_NETWORK_INFECTIOUS_NUM", columnDefinition = "NUMBER|年度累计网络报告的传染病病例数||", nullable = true)
    private Integer yearNetworkInfectiousNum = 0;
    
    @Column(name = "YEAR_OCCUR_INFECTIOUS_NUM", columnDefinition = "NUMBER|年度累计发生传染病病人数(人)||", nullable = true)
    private Integer yearOccurInfectiousNum = 0;

    @Column(name = "YEAR_REPORT_INFECTIOUS_NUM", columnDefinition = "NUMBER|年度累计报告传染病病人数(人)||", nullable = true)
    private Integer yearReportInfectiousNum = 0;

    @Column(name = "YEAR_TIMELY_INFECTIOUS_NUM", columnDefinition = "NUMBER|年度累计报告及时的传染病病人数(人)||", nullable = true)
    private Integer yearTimelyInfectiousNum = 0;

    @Column(name = "YEAR_OCCUR_EMERGENCIES_NUM", columnDefinition = "NUMBER|年度累计应报告突发公共卫生事件相关信息数(次)||", nullable = true)
    private Integer yearOccurEmergenciesNum = 0;

    @Column(name = "YEAR_REPORT_EMERGENCIES_NUM", columnDefinition = "NUMBER|年度累计实报告突发公共卫生事件相关信息数(次)||", nullable = true)
    private Integer yearReportEmergenciesNum = 0;

    @Column(name = "YEAR_TIMELY_EMERGENCIES_NUM", columnDefinition = "NUMBER|年度累计及时报告突发公共卫生事件相关信息(次)||", nullable = true)
    private Integer yearTimelyEmergenciesNum = 0;

    @Column(name = "YEAR_NET_REPORT_DEATHNUM", columnDefinition = "NUMBER|年度累计网络报告死亡数||", nullable = true)
    private Integer yearNetReportDeathnum = 0;

    @Column(name = "GENRE_CODE", columnDefinition = "VARCHAR2|机构类型|50|", length = 50, nullable = true)
    private String genreCode;

    @Column(name = "GB_CODE", columnDefinition = "VARCHAR2|12位行政区划代码|50", length = 50,nullable = true)
    private String gbCode;

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

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getQuarter() {
        return quarter;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public String getCountType() {
        return countType;
    }

    public void setCountType(String countType) {
        this.countType = countType;
    }

    public Integer getOccurInfectiousNum() {
        return occurInfectiousNum;
    }

    public void setOccurInfectiousNum(Integer occurInfectiousNum) {
        this.occurInfectiousNum = occurInfectiousNum;
    }

    public Integer getReportInfectiousNum() {
        return reportInfectiousNum;
    }

    public void setReportInfectiousNum(Integer reportInfectiousNum) {
        this.reportInfectiousNum = reportInfectiousNum;
    }

    public Integer getTimelyInfectiousNum() {
        return timelyInfectiousNum;
    }

    public void setTimelyInfectiousNum(Integer timelyInfectiousNum) {
        this.timelyInfectiousNum = timelyInfectiousNum;
    }

    public Integer getOccurEmergenciesNum() {
        return occurEmergenciesNum;
    }

    public void setOccurEmergenciesNum(Integer occurEmergenciesNum) {
        this.occurEmergenciesNum = occurEmergenciesNum;
    }

    public Integer getReportEmergenciesNum() {
        return reportEmergenciesNum;
    }

    public void setReportEmergenciesNum(Integer reportEmergenciesNum) {
        this.reportEmergenciesNum = reportEmergenciesNum;
    }

    public Integer getTimelyEmergenciesNum() {
        return timelyEmergenciesNum;
    }

    public void setTimelyEmergenciesNum(Integer timelyEmergenciesNum) {
        this.timelyEmergenciesNum = timelyEmergenciesNum;
    }

    public Integer getNetReportDeathnum() {
        return netReportDeathnum;
    }

    public void setNetReportDeathnum(Integer netReportDeathnum) {
        this.netReportDeathnum = netReportDeathnum;
    }

    public Integer getYearOccurInfectiousNum() {
        return yearOccurInfectiousNum;
    }

    public void setYearOccurInfectiousNum(Integer yearOccurInfectiousNum) {
        this.yearOccurInfectiousNum = yearOccurInfectiousNum;
    }

    public Integer getYearReportInfectiousNum() {
        return yearReportInfectiousNum;
    }

    public void setYearReportInfectiousNum(Integer yearReportInfectiousNum) {
        this.yearReportInfectiousNum = yearReportInfectiousNum;
    }

    public Integer getYearTimelyInfectiousNum() {
        return yearTimelyInfectiousNum;
    }

    public void setYearTimelyInfectiousNum(Integer yearTimelyInfectiousNum) {
        this.yearTimelyInfectiousNum = yearTimelyInfectiousNum;
    }

    public Integer getYearOccurEmergenciesNum() {
        return yearOccurEmergenciesNum;
    }

    public void setYearOccurEmergenciesNum(Integer yearOccurEmergenciesNum) {
        this.yearOccurEmergenciesNum = yearOccurEmergenciesNum;
    }

    public Integer getYearReportEmergenciesNum() {
        return yearReportEmergenciesNum;
    }

    public void setYearReportEmergenciesNum(Integer yearReportEmergenciesNum) {
        this.yearReportEmergenciesNum = yearReportEmergenciesNum;
    }

    public Integer getYearTimelyEmergenciesNum() {
        return yearTimelyEmergenciesNum;
    }

    public void setYearTimelyEmergenciesNum(Integer yearTimelyEmergenciesNum) {
        this.yearTimelyEmergenciesNum = yearTimelyEmergenciesNum;
    }

    public Integer getYearNetReportDeathnum() {
        return yearNetReportDeathnum;
    }

    public void setYearNetReportDeathnum(Integer yearNetReportDeathnum) {
        this.yearNetReportDeathnum = yearNetReportDeathnum;
    }

    public String getGenreCode() {
        return genreCode;
    }

    public void setGenreCode(String genreCode) {
        this.genreCode = genreCode;
    }

    public String getGbCode() {
        return gbCode;
    }

    public void setGbCode(String gbCode) {
        this.gbCode = gbCode;
    }

	public Integer getRegisterInfectiousNum() {
		return registerInfectiousNum;
	}

	public void setRegisterInfectiousNum(Integer registerInfectiousNum) {
		this.registerInfectiousNum = registerInfectiousNum;
	}

	public Integer getNetworkInfectiousNum() {
		return networkInfectiousNum;
	}

	public void setNetworkInfectiousNum(Integer networkInfectiousNum) {
		this.networkInfectiousNum = networkInfectiousNum;
	}

	public Integer getYearRegisterInfectiousNum() {
		return yearRegisterInfectiousNum;
	}

	public void setYearRegisterInfectiousNum(Integer yearRegisterInfectiousNum) {
		this.yearRegisterInfectiousNum = yearRegisterInfectiousNum;
	}

	public Integer getYearNetworkInfectiousNum() {
		return yearNetworkInfectiousNum;
	}

	public void setYearNetworkInfectiousNum(Integer yearNetworkInfectiousNum) {
		this.yearNetworkInfectiousNum = yearNetworkInfectiousNum;
	}
    
}
