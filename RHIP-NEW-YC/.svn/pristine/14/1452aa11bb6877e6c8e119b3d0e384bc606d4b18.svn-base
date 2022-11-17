package com.founder.rhip.ehr.entity.control.idm.statistics.report;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "IDM_SELF_CHECK")
public class SelfCheck implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "TYPE", columnDefinition = "VARCHAR2|类型|1|", length = 1, nullable = false)
	private String type;

	@Column(name = "REPORT_MONTH", columnDefinition = "DATE|填报年月||", nullable = false)
	private Date reportMonth;

	@Column(name = "REPORT_UNIT_CODE", columnDefinition = "VARCHAR2|填报机构编码|100|", length = 100, nullable = false)
	private String reportUnitCode;
	
	@Column(name = "GENRE_CODE", columnDefinition = "VARCHAR2|填报机构类别代码||", length = 20, nullable = true)
	private String genreCode;

	@Column(name = "DEPARTMENT_CODE", columnDefinition = "VARCHAR2|部门编码|100|", length = 100, nullable = false)
	private String departmentCode;

	@Column(name = "REPORT_USER_CODE", columnDefinition = "VARCHAR2|填报人编码|50|", length = 50, nullable = true)
	private String reportUserCode;

	@Column(name = "CHECK_NUM", columnDefinition = "NUMBER|抽查病例数|10|", length = 10, nullable = true)
	private Integer checkNum;

	@Column(name = "SHOULD_NUM", columnDefinition = "NUMBER|应报数|10|", length = 10, nullable = true)
	private Integer shouldNum;

	@Column(name = "MISS_NUM", columnDefinition = "NUMBER|漏报数|10|", length = 10, nullable = true)
	private Integer missNum;

	@Column(name = "MISS_RATE", columnDefinition = "NUMBER|漏报率%||", scale = 5, precision = 2, nullable = true)
	private Double missRate;

	@Column(name = "NEONATE_NUM", columnDefinition = "NUMBER|新生儿人数|10|", length = 10, nullable = true)
	private Integer neonateNum;

	@Column(name = "THREE_NEONATE_NUM", columnDefinition = "NUMBER|三类新生儿人数|10|", length = 10, nullable = true)
	private Integer threeNeonateNum;

	@Column(name = "HBV_SHOULD_NUM", columnDefinition = "NUMBER|乙肝疫苗应种人数|10|", length = 10, nullable = true)
	private Integer hbvShouldNum;

	@Column(name = "HBV_ACTUAL_NUM", columnDefinition = "NUMBER|乙肝疫苗实种人数|10|", length = 10, nullable = true)
	private Integer hbvActualNum;

	@Column(name = "HBV_ACTUAL_RATE", columnDefinition = "NUMBER|乙肝接种率||", scale = 5, precision = 2, nullable = true)
	private Double hbvActualRate;

	@Column(name = "BCG_SHOULD_NUM", columnDefinition = "NUMBER|卡介苗应种人数|10|", length = 10, nullable = true)
	private Integer bcgShouldNum;

	@Column(name = "BCG_ACTUAL_NUM", columnDefinition = "NUMBER|卡介苗实种人数|10|", length = 10, nullable = true)
	private Integer bcgActualNum;

	@Column(name = "BCG_ACTUAL_RATE", columnDefinition = "NUMBER|卡介苗接种率||", scale = 5, precision = 2, nullable = true)
	private Double bcgActualRate;

	@Column(name = "REPORT_DATE", columnDefinition = "DATE|填报日期||", nullable = false)
	private Date reportDate;
	
	@Column(name = "MODIFY_UNIT_CODE", columnDefinition = "VARCHAR2|更新机构编码|100|", length = 100, nullable = true)
	private String modifyUnitCode;

	@Column(name = "MODIFY_USER_CODE", columnDefinition = "VARCHAR2|更新人编码|50|", length = 50, nullable = true)
	private String modifyUserCode;

	@Column(name = "MODIFY_DATE", columnDefinition = "DATE|更新日期||", nullable = true)
	private Date modifyDate;

	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除标识|1|", length = 1, nullable = true)
	private Integer isDelete;

    /*传染病－列表*/
	@Transient
    private List<ListScDc> listScDcs;
    
    /*传染病－JSON字符串*/
	@Transient
    private String listScDcJson;
    
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getReportMonth() {
		return this.reportMonth;
	}

	public void setReportMonth(Date reportMonth) {
		this.reportMonth = reportMonth;
	}

	public String getReportUnitCode() {
		return this.reportUnitCode;
	}

	public void setReportUnitCode(String reportUnitCode) {
		this.reportUnitCode = reportUnitCode;
	}

	public String getDepartmentCode() {
		return this.departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getReportUserCode() {
		return this.reportUserCode;
	}

	public void setReportUserCode(String reportUserCode) {
		this.reportUserCode = reportUserCode;
	}

	public Integer getCheckNum() {
		return this.checkNum;
	}

	public void setCheckNum(Integer checkNum) {
		this.checkNum = checkNum;
	}

	public Integer getShouldNum() {
		return this.shouldNum;
	}

	public void setShouldNum(Integer shouldNum) {
		this.shouldNum = shouldNum;
	}

	public Integer getMissNum() {
		return this.missNum;
	}

	public void setMissNum(Integer missNum) {
		this.missNum = missNum;
	}

	public Double getMissRate() {
		return this.missRate;
	}

	public void setMissRate(Double missRate) {
		this.missRate = missRate;
	}

	public Integer getNeonateNum() {
		return this.neonateNum;
	}

	public void setNeonateNum(Integer neonateNum) {
		this.neonateNum = neonateNum;
	}

	public Integer getThreeNeonateNum() {
		return this.threeNeonateNum;
	}

	public void setThreeNeonateNum(Integer threeNeonateNum) {
		this.threeNeonateNum = threeNeonateNum;
	}

	public Integer getHbvShouldNum() {
		return this.hbvShouldNum;
	}

	public void setHbvShouldNum(Integer hbvShouldNum) {
		this.hbvShouldNum = hbvShouldNum;
	}

	public Integer getHbvActualNum() {
		return this.hbvActualNum;
	}

	public void setHbvActualNum(Integer hbvActualNum) {
		this.hbvActualNum = hbvActualNum;
	}

	public Double getHbvActualRate() {
		return this.hbvActualRate;
	}

	public void setHbvActualRate(Double hbvActualRate) {
		this.hbvActualRate = hbvActualRate;
	}

	public Integer getBcgShouldNum() {
		return this.bcgShouldNum;
	}

	public void setBcgShouldNum(Integer bcgShouldNum) {
		this.bcgShouldNum = bcgShouldNum;
	}

	public Integer getBcgActualNum() {
		return this.bcgActualNum;
	}

	public void setBcgActualNum(Integer bcgActualNum) {
		this.bcgActualNum = bcgActualNum;
	}

	public Double getBcgActualRate() {
		return this.bcgActualRate;
	}

	public void setBcgActualRate(Double bcgActualRate) {
		this.bcgActualRate = bcgActualRate;
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
	 * @return the reportDate
	 */
	public Date getReportDate() {
		return reportDate;
	}

	/**
	 * @param reportDate the reportDate to set
	 */
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	/**
	 * @return the listScDc
	 */
	public List<ListScDc> getListScDcs() {
		return listScDcs;
	}

	/**
	 * @param listScDc the listScDc to set
	 */
	public void setListScDcs(List<ListScDc> listScDcs) {
		this.listScDcs = listScDcs;
	}

	/**
	 * @return the listScDcJson
	 */
	public String getListScDcJson() {
		return listScDcJson;
	}

	/**
	 * @param listScDcJson the listScDcJson to set
	 */
	public void setListScDcJson(String listScDcJson) {
		this.listScDcJson = listScDcJson;
	}

	public String getGenreCode() {
		return genreCode;
	}

	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}
}