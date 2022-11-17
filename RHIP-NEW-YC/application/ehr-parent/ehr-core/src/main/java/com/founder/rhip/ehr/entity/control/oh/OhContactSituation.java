package com.founder.rhip.ehr.entity.control.oh;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "OH_CONTACT_SITUATION")
public class OhContactSituation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "ENTERPRISE_INFO_ID", columnDefinition = "NUMBER|企业基本信息ID|11|", length = 11, nullable = true)
	private Long enterpriseInfoId;

	@Column(name = "WORKSHOP_NAME", columnDefinition = "VARCHAR2|车间|50|", length = 50, nullable = true)
	private String workshopName;

	@Column(name = "POSITION", columnDefinition = "VARCHAR2|岗位|50|", length = 50, nullable = true)
	private String position;

	@Column(name = "HAZARD_FACTORS_NAME", columnDefinition = "VARCHAR2|危害因素名称|50|", length = 50, nullable = true)
	private String hazardFactorsName;

	@Column(name = "MAN_NUM", columnDefinition = "NUMBER|接触男性|11|", length = 11, nullable = true)
	private Long manNum;

	@Column(name = "WOMAN_NUM", columnDefinition = "NUMBER|接触女性|11|", length = 11, nullable = true)
	private Long womanNum;

	@Column(name = "SAFEGUARD_PROCEDURES", columnDefinition = "VARCHAR2|防护情况|50|", length = 50, nullable = true)
	private String safeguardProcedures;

	@Column(name = "CREATE_TIME", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createTime;

	@Column(name = "CREATE_BY", columnDefinition = "VARCHAR2|创建者|50|", length = 50, nullable = true)
	private String createBy;

	@Column(name = "UPDATE_TIME", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date updateTime;

	@Column(name = "UPDATE_BY", columnDefinition = "VARCHAR2|更新者|50|", length = 50, nullable = true)
	private String updateBy;

	@Column(name = "IS_DELETE", columnDefinition = "INT|删除状态||", nullable = true)
	private Integer isDelete;

	@Column(name = "PROTECTIVE_MEASURES", columnDefinition = "VARCHAR2|个人防护措施|100|", length = 100, nullable = true)
	private String protectiveMeasures;
	
	@Column(name = "DAY_CONTACT_TIME", columnDefinition = "VARCHAR2|日接触时间|100|", length = 100, nullable = true)
	private String dayContactTime;
	
		
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEnterpriseInfoId() {
		return this.enterpriseInfoId;
	}

	public void setEnterpriseInfoId(Long enterpriseInfoId) {
		this.enterpriseInfoId = enterpriseInfoId;
	}

	public String getWorkshopName() {
		return this.workshopName;
	}

	public void setWorkshopName(String workshopName) {
		this.workshopName = workshopName;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getHazardFactorsName() {
		return this.hazardFactorsName;
	}

	public void setHazardFactorsName(String hazardFactorsName) {
		this.hazardFactorsName = hazardFactorsName;
	}

	public Long getManNum() {
		return this.manNum;
	}

	public void setManNum(Long manNum) {
		this.manNum = manNum;
	}

	public Long getWomanNum() {
		return this.womanNum;
	}

	public void setWomanNum(Long womanNum) {
		this.womanNum = womanNum;
	}

	public String getSafeguardProcedures() {
		return this.safeguardProcedures;
	}

	public void setSafeguardProcedures(String safeguardProcedures) {
		this.safeguardProcedures = safeguardProcedures;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getProtectiveMeasures() {
		return protectiveMeasures;
	}

	public void setProtectiveMeasures(String protectiveMeasures) {
		this.protectiveMeasures = protectiveMeasures;
	}

	public String getDayContactTime() {
		return dayContactTime;
	}

	public void setDayContactTime(String dayContactTime) {
		this.dayContactTime = dayContactTime;
	}

}