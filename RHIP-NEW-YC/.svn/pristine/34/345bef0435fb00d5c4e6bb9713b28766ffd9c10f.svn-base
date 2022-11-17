package com.founder.rhip.ehr.entity.control.oh;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "OH_CONDITION")
public class OhCondition implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "ENTERPRISE_INFO_ID", columnDefinition = "NUMBER|企业基本信息ID|11|", length = 11, nullable = true)
	private Long enterpriseInfoId;

	@Column(name = "EMPLOYEE_NUM", columnDefinition = "NUMBER|职工总数|11|", length = 11, nullable = true)
	private Long employeeNum;

	@Column(name = "WORKINGWOMAN_NUM", columnDefinition = "NUMBER|女工总数|11|", length = 11, nullable = true)
	private Long workingwomanNum;

	@Column(name = "WORKER_NUM", columnDefinition = "NUMBER|生产工人总数|11|", length = 11, nullable = true)
	private Long workerNum;

	@Column(name = "DUST_NUM", columnDefinition = "NUMBER|粉尘|11|", length = 11, nullable = true)
	private Long dustNum;

	@Column(name = "POISON_NUM", columnDefinition = "NUMBER|毒物|11|", length = 11, nullable = true)
	private Long poisonNum;

	@Column(name = "PHYSICAL_FACTOR_NUM", columnDefinition = "NUMBER|物理因素|11|", length = 11, nullable = true)
	private Long physicalFactorNum;

	@Column(name = "OTHER_NUM", columnDefinition = "NUMBER|其他|11|", length = 11, nullable = true)
	private Long otherNum;

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

	public Long getEmployeeNum() {
		return this.employeeNum;
	}

	public void setEmployeeNum(Long employeeNum) {
		this.employeeNum = employeeNum;
	}

	public Long getWorkingwomanNum() {
		return this.workingwomanNum;
	}

	public void setWorkingwomanNum(Long workingwomanNum) {
		this.workingwomanNum = workingwomanNum;
	}

	public Long getWorkerNum() {
		return this.workerNum;
	}

	public void setWorkerNum(Long workerNum) {
		this.workerNum = workerNum;
	}

	public Long getDustNum() {
		return this.dustNum;
	}

	public void setDustNum(Long dustNum) {
		this.dustNum = dustNum;
	}

	public Long getPoisonNum() {
		return this.poisonNum;
	}

	public void setPoisonNum(Long poisonNum) {
		this.poisonNum = poisonNum;
	}

	public Long getPhysicalFactorNum() {
		return this.physicalFactorNum;
	}

	public void setPhysicalFactorNum(Long physicalFactorNum) {
		this.physicalFactorNum = physicalFactorNum;
	}

	public Long getOtherNum() {
		return this.otherNum;
	}

	public void setOtherNum(Long otherNum) {
		this.otherNum = otherNum;
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

}