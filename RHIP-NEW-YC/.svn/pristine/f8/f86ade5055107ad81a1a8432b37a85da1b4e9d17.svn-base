package com.founder.rhip.ehr.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by yuanzg on 2017/5/18.
 */
@Entity
@Table(name = "SR_MENTAL_EPILEPSY_PATIENT")
public class MentalEpilepsyPatient implements Serializable {
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

    @Column(name = "MENTAL_NUM", columnDefinition = "NUMBER|季度统计精神患者数||", nullable = true)
    private Integer mentalNum = 0;
    
    @Column(name = "STABLE_DISEASE_NUM", columnDefinition = "NUMBER|季度统计病情稳定患者数||", nullable = true)
    private Integer stableDiseaseNum = 0;

    @Column(name = "EPILEPSY_NUM", columnDefinition = "NUMBER|季度统计癫痫患者数||", nullable = true)
    private Integer epilepsyNum = 0;
    
    @Column(name = "YEAR_MENTAL_NUM", columnDefinition = "NUMBER|年度统计精神患者数||", nullable = true)
    private Integer yearMentalNum;

    @Column(name = "YEAR_STABLE_DISEASE_NUM", columnDefinition = "NUMBER|年度统计病情稳定患者数||", nullable = true)
    private Integer yearStableDiseaseNum;

    @Column(name = "YEAR_EPILEPSY_NUM", columnDefinition = "NUMBER|年度统计癫痫患者数||", nullable = true)
    private Integer yearEpilepsyNum;

    @Column(name = "MENTAL_MANAGE_NUM", columnDefinition = "NUMBER|季度统计按照规范要求进行管理的严重精神障碍患者人数||", nullable = true)
    private Integer mentalManageNum = 0;
    
    @Column(name = "EPILEPSY_CONTROL_NUM", columnDefinition = "NUMBER|季度统计癫痫发作有效控制人数||", nullable = true)
    private Integer epilepsyControlNum = 0;


    @Column(name = "YEAR_MENTAL_MANAGE_NUM", columnDefinition = "NUMBER|年度统计按照规范要求进行管理的严重精神障碍患者人数||", nullable = true)
    private Integer yearMentalManageNum = 0;
    
    @Column(name = "YEAR_EPILEPSY_CONTROL_NUM", columnDefinition = "NUMBER|年度统计癫痫发作有效控制人数||", nullable = true)
    private Integer yearEpilepsyControlNum = 0;
    
    @Transient
    private String ORGANNAME;

    @Transient
    private String ORGANCODE;

    @Transient
    private Integer MENTALNUM;

    @Transient
    private Integer STABLEDISEASENUM;

    @Transient
    private Integer EPILEPSYNUM;
    
    @Transient
    private Integer MENTALMANAGENUM;
    
    @Transient
    private Integer EPILEPSYCONTROLNUM;    
    

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

    public Integer getMentalNum() {
        return mentalNum;
    }

    public void setMentalNum(Integer mentalNum) {
        this.mentalNum = mentalNum;
    }

    public Integer getStableDiseaseNum() {
        return stableDiseaseNum;
    }

    public void setStableDiseaseNum(Integer stableDiseaseNum) {
        this.stableDiseaseNum = stableDiseaseNum;
    }

    public Integer getEpilepsyNum() {
        return epilepsyNum;
    }

    public void setEpilepsyNum(Integer epilepsyNum) {
        this.epilepsyNum = epilepsyNum;
    }

    public Integer getYearMentalNum() {
        return yearMentalNum;
    }

    public void setYearMentalNum(Integer yearMentalNum) {
        this.yearMentalNum = yearMentalNum;
    }

    public Integer getYearStableDiseaseNum() {
        return yearStableDiseaseNum;
    }

    public void setYearStableDiseaseNum(Integer yearStableDiseaseNum) {
        this.yearStableDiseaseNum = yearStableDiseaseNum;
    }

    public Integer getYearEpilepsyNum() {
        return yearEpilepsyNum;
    }

    public void setYearEpilepsyNum(Integer yearEpilepsyNum) {
        this.yearEpilepsyNum = yearEpilepsyNum;
    }

    public String getORGANNAME() {
        return ORGANNAME;
    }

    public void setORGANNAME(String ORGANNAME) {
        this.ORGANNAME = ORGANNAME;
    }

    public String getORGANCODE() {
        return ORGANCODE;
    }

    public void setORGANCODE(String ORGANCODE) {
        this.ORGANCODE = ORGANCODE;
    }

    public Integer getMENTALNUM() {
        return MENTALNUM;
    }

    public void setMENTALNUM(Integer MENTALNUM) {
        this.MENTALNUM = MENTALNUM;
    }

    public Integer getSTABLEDISEASENUM() {
        return STABLEDISEASENUM;
    }

    public void setSTABLEDISEASENUM(Integer STABLEDISEASENUM) {
        this.STABLEDISEASENUM = STABLEDISEASENUM;
    }

    public Integer getEPILEPSYNUM() {
        return EPILEPSYNUM;
    }

    public void setEPILEPSYNUM(Integer EPILEPSYNUM) {
        this.EPILEPSYNUM = EPILEPSYNUM;
    }

	public Integer getMentalManageNum() {
		return mentalManageNum;
	}

	public void setMentalManageNum(Integer mentalManageNum) {
		this.mentalManageNum = mentalManageNum;
	}

	public Integer getEpilepsyControlNum() {
		return epilepsyControlNum;
	}

	public void setEpilepsyControlNum(Integer epilepsyControlNum) {
		this.epilepsyControlNum = epilepsyControlNum;
	}

	public Integer getYearMentalManageNum() {
		return yearMentalManageNum;
	}

	public void setYearMentalManageNum(Integer yearMentalManageNum) {
		this.yearMentalManageNum = yearMentalManageNum;
	}

	public Integer getYearEpilepsyControlNum() {
		return yearEpilepsyControlNum;
	}

	public void setYearEpilepsyControlNum(Integer yearEpilepsyControlNum) {
		this.yearEpilepsyControlNum = yearEpilepsyControlNum;
	}

	public Integer getMENTALMANAGENUM() {
		return MENTALMANAGENUM;
	}

	public void setMENTALMANAGENUM(Integer mENTALMANAGENUM) {
		MENTALMANAGENUM = mENTALMANAGENUM;
	}

	public Integer getEPILEPSYCONTROLNUM() {
		return EPILEPSYCONTROLNUM;
	}

	public void setEPILEPSYCONTROLNUM(Integer ePILEPSYCONTROLNUM) {
		EPILEPSYCONTROLNUM = ePILEPSYCONTROLNUM;
	}
}
