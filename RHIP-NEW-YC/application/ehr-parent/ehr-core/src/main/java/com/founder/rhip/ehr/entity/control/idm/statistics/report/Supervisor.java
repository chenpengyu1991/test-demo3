package com.founder.rhip.ehr.entity.control.idm.statistics.report;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "IDM_SUPERVISOR")
public class Supervisor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "LAST_MONTH_MISS", columnDefinition = "VARCHAR2|县督导情况-上月是否零缺报|2|", length = 2, nullable = true)
	private String lastMonthMiss;

	@Column(name = "SUPERVISOR_PROVINCE", columnDefinition = "VARCHAR2|县督导情况-是否开展督导-省级|2|", length = 2, nullable = true)
	private String supervisorProvince;

	@Column(name = "SUPERVISOR_CITY", columnDefinition = "VARCHAR2|县督导情况-是否开展督导-市级|2|", length = 2, nullable = true)
	private String supervisorCity;

	@Column(name = "ZERO_DEFECT_ORG_NUM", columnDefinition = "NUMBER|县督导情况-本级上月零缺报网络直报点数|10|", length = 10, nullable = true)
	private Integer zeroDefectOrgNum;

	@Column(name = "ZERO_DEFECT_MEDICAL_NUM", columnDefinition = "NUMBER|县督导情况-本级县以上医疗机构零缺报单位数|10|", length = 10, nullable = true)
	private Integer zeroDefectMedicalNum;

	@Column(name = "DIRECT_NUM_PROVINCE", columnDefinition = "NUMBER|县督导情况-督导网络直报点数-省级|10|", length = 10, nullable = true)
	private Integer directNumProvince;

	@Column(name = "DIRECT_NUM_CITY", columnDefinition = "NUMBER|县督导情况-督导网络直报点数-市级|10|", length = 10, nullable = true)
	private Integer directNumCity;

	@Column(name = "DIRECT_NUM_COUNTY", columnDefinition = "NUMBER|县督导情况-督导网络直报点数-县级|10|", length = 10, nullable = true)
	private Integer directNumCounty;

	@Column(name = "SUPERVISOR_NUM", columnDefinition = "NUMBER|县督导情况-督导应报传染病数|10|", length = 10, nullable = true)
	private Integer supervisorNum;

	@Column(name = "SUPERVISOR_MISS_NUM", columnDefinition = "NUMBER|县督导情况-传染病漏报数|10|", length = 10, nullable = true)
	private Integer supervisorMissNum;

	@Column(name = "SUPERVISOR_MISS_RATE", columnDefinition = "NUMBER|县督导情况-漏报率(%)||", scale = 5, precision = 2, nullable = true)
	private Double supervisorMissRate;

	@Column(name = "NETWORK_NUM_CITY", columnDefinition = "NUMBER|网络-督导或调查点数-市级|10|", length = 10, nullable = true)
	private Integer networkNumCity;

	@Column(name = "NETWORK_NUM_COUNTY", columnDefinition = "NUMBER|网络-督导或调查点数-县级|10|", length = 10, nullable = true)
	private Integer networkNumCounty;

	@Column(name = "SURVEY_FLAG_CITY", columnDefinition = "VARCHAR2|网络-是否开展传染病漏报专项调查-市级|2|", length = 2, nullable = true)
	private String surveyFlagCity;

	@Column(name = "SURVEY_FLAG_COUNTY", columnDefinition = "VARCHAR2|网络-是否开展传染病漏报专项调查-县级|2|", length = 2, nullable = true)
	private String surveyFlagCounty;

	@Column(name = "NETWORK_NUM", columnDefinition = "NUMBER|网络-应报传染病数|10|", length = 10, nullable = true)
	private Integer networkNum;

	@Column(name = "NETWORK_MISS_NUM", columnDefinition = "NUMBER|网络-传染病漏报数|10|", length = 10, nullable = true)
	private Integer networkMissNum;

	@Column(name = "NETWORK_MISS_RATE", columnDefinition = "NUMBER|网络-漏报率(%)||", scale = 5, precision = 2, nullable = true)
	private Double networkMissRate;

	@Column(name = "REPORT_MONTH", columnDefinition = "DATE|填报年月||", nullable = true)
	private Date reportMonth;

	@Column(name = "REPORT_DATE", columnDefinition = "DATE|填报日期||", nullable = true)
	private Date reportDate;

	@Column(name = "REPORT_UNIT_CODE", columnDefinition = "VARCHAR2|填报机构编码|100|", length = 100, nullable = true)
	private String reportUnitCode;
	
	@Column(name = "GENRE_CODE", columnDefinition = "VARCHAR2|填报机构类别代码||", length = 20, nullable = true)
	private String genreCode;

	@Column(name = "REPORT_USER_CODE", columnDefinition = "VARCHAR2|填报人编码|50|", length = 50, nullable = true)
	private String reportUserCode;

	@Column(name = "MODIFY_UNIT_CODE", columnDefinition = "VARCHAR2|更新机构编码|100|", length = 100, nullable = true)
	private String modifyUnitCode;

	@Column(name = "MODIFY_USER_CODE", columnDefinition = "VARCHAR2|更新人编码|50|", length = 50, nullable = true)
	private String modifyUserCode;

	@Column(name = "MODIFY_DATE", columnDefinition = "DATE|更新日期||", nullable = true)
	private Date modifyDate;

	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除标识|1|0", length = 1, nullable = true)
	private Integer isDelete;

	/*合计：县督导情况-本级上月零缺报网络直报点数*/
	@Transient
	private Integer sumZeroDefectOrgNum;
	
	/*合计：县督导情况-本级县以上医疗机构零缺报单位数*/
	@Transient
	private Integer sumZeroDefectMedicalNum;
	
	/*合计：县督导情况-督导网络直报点数-省级*/
	@Transient
	private Integer sumDirectNumProvince;
	
	/*合计：县督导情况-督导网络直报点数-市级*/
	@Transient
	private Integer sumDirectNumCity;
	
	/*合计：县督导情况-督导网络直报点数-县级*/
	@Transient
	private Integer sumDirectNumCounty;
	
	/*合计：县督导情况-督导应报传染病数*/
	@Transient
	private Integer sumSupervisorNum;
	
	/*合计：县督导情况-传染病漏报数*/
	@Transient
	private Integer sumSupervisorMissNum;
	
	/*平均：县督导情况-漏报率(%)*/
	@Transient
	private Double avgSupervisorMissRate;
	
	/*合计：网络-督导或调查点数-市级*/
	@Transient
	private Integer sumNetworkNumCity;
	
	/*合计：网络-督导或调查点数-县级*/
	@Transient
	private Integer sumNetworkNumCounty;
	
	/*合计：网络-应报传染病数*/
	@Transient
	private Integer sumNetworkNum;
	
	/*合计：网络-传染病漏报数*/
	@Transient
	private Integer sumNetworkMissNum;
	
	/*平均：网络-漏报率(%)*/
	@Transient
	private Double avgNetworkMissRate;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastMonthMiss() {
		return this.lastMonthMiss;
	}

	public void setLastMonthMiss(String lastMonthMiss) {
		this.lastMonthMiss = lastMonthMiss;
	}

	public String getSupervisorProvince() {
		return this.supervisorProvince;
	}

	public void setSupervisorProvince(String supervisorProvince) {
		this.supervisorProvince = supervisorProvince;
	}

	public String getSupervisorCity() {
		return this.supervisorCity;
	}

	public void setSupervisorCity(String supervisorCity) {
		this.supervisorCity = supervisorCity;
	}

	public Integer getZeroDefectOrgNum() {
		return this.zeroDefectOrgNum;
	}

	public void setZeroDefectOrgNum(Integer zeroDefectOrgNum) {
		this.zeroDefectOrgNum = zeroDefectOrgNum;
	}

	public Integer getZeroDefectMedicalNum() {
		return this.zeroDefectMedicalNum;
	}

	public void setZeroDefectMedicalNum(Integer zeroDefectMedicalNum) {
		this.zeroDefectMedicalNum = zeroDefectMedicalNum;
	}

	public Integer getDirectNumProvince() {
		return this.directNumProvince;
	}

	public void setDirectNumProvince(Integer directNumProvince) {
		this.directNumProvince = directNumProvince;
	}

	public Integer getDirectNumCity() {
		return this.directNumCity;
	}

	public void setDirectNumCity(Integer directNumCity) {
		this.directNumCity = directNumCity;
	}

	public Integer getDirectNumCounty() {
		return this.directNumCounty;
	}

	public void setDirectNumCounty(Integer directNumCounty) {
		this.directNumCounty = directNumCounty;
	}

	public Integer getSupervisorNum() {
		return this.supervisorNum;
	}

	public void setSupervisorNum(Integer supervisorNum) {
		this.supervisorNum = supervisorNum;
	}

	public Integer getSupervisorMissNum() {
		return this.supervisorMissNum;
	}

	public void setSupervisorMissNum(Integer supervisorMissNum) {
		this.supervisorMissNum = supervisorMissNum;
	}

	public Double getSupervisorMissRate() {
		return this.supervisorMissRate;
	}

	public void setSupervisorMissRate(Double supervisorMissRate) {
		this.supervisorMissRate = supervisorMissRate;
	}

	public Integer getNetworkNumCity() {
		return this.networkNumCity;
	}

	public void setNetworkNumCity(Integer networkNumCity) {
		this.networkNumCity = networkNumCity;
	}

	public Integer getNetworkNumCounty() {
		return this.networkNumCounty;
	}

	public void setNetworkNumCounty(Integer networkNumCounty) {
		this.networkNumCounty = networkNumCounty;
	}

	public String getSurveyFlagCity() {
		return this.surveyFlagCity;
	}

	public void setSurveyFlagCity(String surveyFlagCity) {
		this.surveyFlagCity = surveyFlagCity;
	}

	public String getSurveyFlagCounty() {
		return this.surveyFlagCounty;
	}

	public void setSurveyFlagCounty(String surveyFlagCounty) {
		this.surveyFlagCounty = surveyFlagCounty;
	}

	public Integer getNetworkNum() {
		return this.networkNum;
	}

	public void setNetworkNum(Integer networkNum) {
		this.networkNum = networkNum;
	}

	public Integer getNetworkMissNum() {
		return this.networkMissNum;
	}

	public void setNetworkMissNum(Integer networkMissNum) {
		this.networkMissNum = networkMissNum;
	}

	public Double getNetworkMissRate() {
		return this.networkMissRate;
	}

	public void setNetworkMissRate(Double networkMissRate) {
		this.networkMissRate = networkMissRate;
	}

	public Date getReportMonth() {
		return this.reportMonth;
	}

	public void setReportMonth(Date reportMonth) {
		this.reportMonth = reportMonth;
	}

	public Date getReportDate() {
		return this.reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getReportUnitCode() {
		return this.reportUnitCode;
	}

	public void setReportUnitCode(String reportUnitCode) {
		this.reportUnitCode = reportUnitCode;
	}

	public String getReportUserCode() {
		return this.reportUserCode;
	}

	public void setReportUserCode(String reportUserCode) {
		this.reportUserCode = reportUserCode;
	}

	public String getModifyUnitCode() {
		return this.modifyUnitCode;
	}

	public void setModifyUnitCode(String modifyUnitCode) {
		this.modifyUnitCode = modifyUnitCode;
	}

	public String getModifyUserCode() {
		return this.modifyUserCode;
	}

	public void setModifyUserCode(String modifyUserCode) {
		this.modifyUserCode = modifyUserCode;
	}

	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	
	/**
	 * @return the sumZeroDefectOrgNum
	 */
	public Integer getSumZeroDefectOrgNum() {
		return sumZeroDefectOrgNum;
	}

	
	/**
	 * @param sumZeroDefectOrgNum the sumZeroDefectOrgNum to set
	 */
	public void setSumZeroDefectOrgNum(Integer sumZeroDefectOrgNum) {
		this.sumZeroDefectOrgNum = sumZeroDefectOrgNum;
	}

	
	/**
	 * @return the sumZeroDefectMedicalNum
	 */
	public Integer getSumZeroDefectMedicalNum() {
		return sumZeroDefectMedicalNum;
	}

	
	/**
	 * @param sumZeroDefectMedicalNum the sumZeroDefectMedicalNum to set
	 */
	public void setSumZeroDefectMedicalNum(Integer sumZeroDefectMedicalNum) {
		this.sumZeroDefectMedicalNum = sumZeroDefectMedicalNum;
	}

	
	/**
	 * @return the sumDirectNumProvince
	 */
	public Integer getSumDirectNumProvince() {
		return sumDirectNumProvince;
	}

	
	/**
	 * @param sumDirectNumProvince the sumDirectNumProvince to set
	 */
	public void setSumDirectNumProvince(Integer sumDirectNumProvince) {
		this.sumDirectNumProvince = sumDirectNumProvince;
	}

	
	/**
	 * @return the sumDirectNumCity
	 */
	public Integer getSumDirectNumCity() {
		return sumDirectNumCity;
	}

	
	/**
	 * @param sumDirectNumCity the sumDirectNumCity to set
	 */
	public void setSumDirectNumCity(Integer sumDirectNumCity) {
		this.sumDirectNumCity = sumDirectNumCity;
	}

	
	/**
	 * @return the sumDirectNumCounty
	 */
	public Integer getSumDirectNumCounty() {
		return sumDirectNumCounty;
	}

	
	/**
	 * @param sumDirectNumCounty the sumDirectNumCounty to set
	 */
	public void setSumDirectNumCounty(Integer sumDirectNumCounty) {
		this.sumDirectNumCounty = sumDirectNumCounty;
	}

	
	/**
	 * @return the sumSupervisorNum
	 */
	public Integer getSumSupervisorNum() {
		return sumSupervisorNum;
	}

	
	/**
	 * @param sumSupervisorNum the sumSupervisorNum to set
	 */
	public void setSumSupervisorNum(Integer sumSupervisorNum) {
		this.sumSupervisorNum = sumSupervisorNum;
	}

	
	/**
	 * @return the sumSupervisorMissNum
	 */
	public Integer getSumSupervisorMissNum() {
		return sumSupervisorMissNum;
	}

	
	/**
	 * @param sumSupervisorMissNum the sumSupervisorMissNum to set
	 */
	public void setSumSupervisorMissNum(Integer sumSupervisorMissNum) {
		this.sumSupervisorMissNum = sumSupervisorMissNum;
	}

	
	/**
	 * @return the avgSupervisorMissRate
	 */
	public Double getAvgSupervisorMissRate() {
		return avgSupervisorMissRate;
	}

	
	/**
	 * @param avgSupervisorMissRate the avgSupervisorMissRate to set
	 */
	public void setAvgSupervisorMissRate(Double avgSupervisorMissRate) {
		this.avgSupervisorMissRate = avgSupervisorMissRate;
	}

	
	/**
	 * @return the sumNetworkNumCity
	 */
	public Integer getSumNetworkNumCity() {
		return sumNetworkNumCity;
	}

	
	/**
	 * @param sumNetworkNumCity the sumNetworkNumCity to set
	 */
	public void setSumNetworkNumCity(Integer sumNetworkNumCity) {
		this.sumNetworkNumCity = sumNetworkNumCity;
	}

	
	/**
	 * @return the sumNetworkNumCounty
	 */
	public Integer getSumNetworkNumCounty() {
		return sumNetworkNumCounty;
	}

	
	/**
	 * @param sumNetworkNumCounty the sumNetworkNumCounty to set
	 */
	public void setSumNetworkNumCounty(Integer sumNetworkNumCounty) {
		this.sumNetworkNumCounty = sumNetworkNumCounty;
	}

	
	/**
	 * @return the sumNetworkNum
	 */
	public Integer getSumNetworkNum() {
		return sumNetworkNum;
	}

	
	/**
	 * @param sumNetworkNum the sumNetworkNum to set
	 */
	public void setSumNetworkNum(Integer sumNetworkNum) {
		this.sumNetworkNum = sumNetworkNum;
	}

	
	/**
	 * @return the sumNetworkMissNum
	 */
	public Integer getSumNetworkMissNum() {
		return sumNetworkMissNum;
	}

	
	/**
	 * @param sumNetworkMissNum the sumNetworkMissNum to set
	 */
	public void setSumNetworkMissNum(Integer sumNetworkMissNum) {
		this.sumNetworkMissNum = sumNetworkMissNum;
	}

	
	/**
	 * @return the avgNetworkMissRate
	 */
	public Double getAvgNetworkMissRate() {
		return avgNetworkMissRate;
	}

	
	/**
	 * @param avgNetworkMissRate the avgNetworkMissRate to set
	 */
	public void setAvgNetworkMissRate(Double avgNetworkMissRate) {
		this.avgNetworkMissRate = avgNetworkMissRate;
	}

	public String getGenreCode() {
		return genreCode;
	}

	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}

}