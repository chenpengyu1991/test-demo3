package com.founder.rhip.ehr.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yuanzg on 2017/6/28.
 */
@Entity
@Table(name = "SR_MATERNAL_HEALTH_MANAGE")
public class MaternalHealthManage implements Serializable{

    private static final long serialVersionUID = -1398047229946590341L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|登记机构编码|50|", length = 50, nullable = true)
    private String organCode;

    @Column(name = "ORGAN_NAME", columnDefinition = "VARCHAR2|登记机构名称|50|", length = 50, nullable = true)
    private String organName;

    @Column(name = "PARENT_CODE", columnDefinition = "VARCHAR2|上级机构编码|50|", length = 50, nullable = true)
    private String parentCode;

    @Column(name = "PARENT_NAME", columnDefinition = "VARCHAR2|上级机构名称|50|", length = 50, nullable = true)
    private String parentName;

    @Column(name = "GENRE_CODE", columnDefinition = "VARCHAR2|机构类型|50|", length = 50, nullable = true)
    private String genreCode;

    @Column(name = "GB_CODE", columnDefinition = "VARCHAR2|12位行政区划代码|50|", length = 50, nullable = true)
    private String gbCode;

    @Column(name = "YEAR", columnDefinition = "NUMBER|年份|5|", length = 5, nullable = true)
    private Integer year;

    @Column(name = "QUARTER", columnDefinition = "NUMBER|季度|1|", length = 1, nullable = true)
    private Integer quarter;

    @Column(name = "REPORT_TIME", columnDefinition = "DATE|填报日期||", nullable = true)
    private Date reportTime;

    @Column(name = "COUNT_TYPE", columnDefinition = "VARCHAR2|统计类型|50|", length = 50, nullable = true)
    private String countType;

    @Column(name = "LIVE_BIRTHS_NUM", columnDefinition = "NUMBER|该地改时间段内活产数||", nullable = true)
    private Integer liveBirthsNum = 0;

    @Column(name = "PREGNANT_THIRTWEEK_EXAM_NUM", columnDefinition = "NUMBER|辖区内孕13周之前建册并进行第一次产前检查的产妇人数||", nullable = true)
    private Integer pregnantThirtweekExaNum = 0;

    @Column(name = "thirtweekExaNum", columnDefinition = "NUMBER|辖区内孕13周之前建册并进行第一次产前检查的产妇人数||", nullable = true)
    private Integer thirtweekExaNum = 0;
    
    @Column(name = "EARLY_PREGNANCY_RATE", columnDefinition = "NUMBER|早孕建册率||", nullable = true)
    private BigDecimal earlyPregnancyRate;

    @Column(name = "LEAVEHOS_TWENTYEIGHT_DAY", columnDefinition = "NUMBER|辖区内产妇出院后28天内接受过产后访视的产妇人数||", nullable = true)
    private Integer leavehosTwentyeightDay = 0;

    @Column(name = "POSTPARTUM_VISIT_RATE", columnDefinition = "NUMBER|产后访视率||", nullable = true)
    private BigDecimal postpartumVisitRate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getLiveBirthsNum() {
        return liveBirthsNum;
    }

    public void setLiveBirthsNum(Integer liveBirthsNum) {
        this.liveBirthsNum = liveBirthsNum;
    }

    public Integer getPregnantThirtweekExaNum() {
        return pregnantThirtweekExaNum;
    }

    public void setPregnantThirtweekExaNum(Integer pregnantThirtweekExaNum) {
        this.pregnantThirtweekExaNum = pregnantThirtweekExaNum;
    }

    public BigDecimal getEarlyPregnancyRate() {
        return earlyPregnancyRate;
    }

    public void setEarlyPregnancyRate(BigDecimal earlyPregnancyRate) {
        this.earlyPregnancyRate = earlyPregnancyRate;
    }

    public Integer getLeavehosTwentyeightDay() {
        return leavehosTwentyeightDay;
    }

    public void setLeavehosTwentyeightDay(Integer leavehosTwentyeightDay) {
        this.leavehosTwentyeightDay = leavehosTwentyeightDay;
    }

    public BigDecimal getPostpartumVisitRate() {
        return postpartumVisitRate;
    }

    public void setPostpartumVisitRate(BigDecimal postpartumVisitRate) {
        this.postpartumVisitRate = postpartumVisitRate;
    }

	public Integer getThirtweekExaNum() {
		return thirtweekExaNum;
	}

	public void setThirtweekExaNum(Integer thirtweekExaNum) {
		this.thirtweekExaNum = thirtweekExaNum;
	}
    
}
