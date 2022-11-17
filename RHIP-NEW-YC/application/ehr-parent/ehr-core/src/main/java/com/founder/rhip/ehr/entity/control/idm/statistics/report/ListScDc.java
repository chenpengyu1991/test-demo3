package com.founder.rhip.ehr.entity.control.idm.statistics.report;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "IDM_SC_DC")
public class ListScDc implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "SELF_CHECK_ID", columnDefinition = "NUMBER|自查表ID|11|", length = 11, nullable = false)
	private Long selfCheckId;
	
	@Column(name = "REPORT_MONTH", columnDefinition = "DATE|填报年月||", nullable = false)
	private Date reportMonth;

	@Column(name = "REPORT_UNIT_CODE", columnDefinition = "VARCHAR2|填报机构编码|100|", length = 100, nullable = false)
	private String reportUnitCode;

	@Column(name = "DEPARTMENT_CODE", columnDefinition = "VARCHAR2|部门编码|100|", length = 100, nullable = false)
	private String departmentCode;

	@Column(name = "INFECTIOUS_CODE", columnDefinition = "VARCHAR2|传染病编码|100|", length = 100, nullable = true)
	private String infectiousCode;

	@Column(name = "SHOULD_NUM", columnDefinition = "NUMBER|应报数|10|", length = 10, nullable = true)
	private Integer shouldNum;

	@Column(name = "MISS_NUM", columnDefinition = "NUMBER|漏报数|10|", length = 10, nullable = true)
	private Integer missNum;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSelfCheckId() {
		return selfCheckId;
	}

	public void setSelfCheckId(Long selfCheckId) {
		this.selfCheckId = selfCheckId;
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

	public String getInfectiousCode() {
		return this.infectiousCode;
	}

	public void setInfectiousCode(String infectiousCode) {
		this.infectiousCode = infectiousCode;
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
	
	

}