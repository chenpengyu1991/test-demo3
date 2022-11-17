package com.founder.rhip.ehr.entity.ihm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "HM_TARGET_THRESHOLD")
public class HmTargetThreshold implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;

	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|医疗机构编码||", length = 20, nullable = true)
	private String organCode;

	@Column(name = "LOGIC_SYMBOL", columnDefinition = "VARCHAR2|逻辑符号||", length = 20, nullable = true)
	private String logicSymbol;

	@Column(name = "OPERATOR_SYMBOL", columnDefinition = "VARCHAR2|运算符号||", length = 20, nullable = true)
	private String operatorSymbol;

	@Column(name = "THRESHOLD_VALUE", columnDefinition = "NUMBER|阈值||", length = 16, scale = 4, precision = 2, nullable = true)
	private Long thresholdValue;

	@Column(name = "REMARK", columnDefinition = "VARCHAR2|备注||", length = 100, nullable = true)
	private String remark;

	@Column(name = "CREATE_DATE", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createDate;

	@Column(name = "UPDATE_DATE", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date updateDate;

	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除标志||", length = 1, nullable = true)
	private Long isDelete;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrganCode() {
		return this.organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getLogicSymbol() {
		return this.logicSymbol;
	}

	public void setLogicSymbol(String logicSymbol) {
		this.logicSymbol = logicSymbol;
	}

	public String getOperatorSymbol() {
		return this.operatorSymbol;
	}

	public void setOperatorSymbol(String operatorSymbol) {
		this.operatorSymbol = operatorSymbol;
	}

	public Long getThresholdValue() {
		return this.thresholdValue;
	}

	public void setThresholdValue(Long thresholdValue) {
		this.thresholdValue = thresholdValue;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Long getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Long isDelete) {
		this.isDelete = isDelete;
	}

}