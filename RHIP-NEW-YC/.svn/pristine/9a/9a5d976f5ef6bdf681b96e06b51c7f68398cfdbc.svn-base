package com.founder.rhip.ehr.entity.ihm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "HM_TARGET_INFO")
public class HmTargetInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;

	@Column(name = "SYS_MODEL_CODE", columnDefinition = "VARCHAR2|所属模块编号||", length = 20, nullable = true)
	private String sysModelCode;

	@Column(name = "TARGET_CODE", columnDefinition = "VARCHAR2|指标编号||", length = 20, nullable = true)
	private String targetCode;

	@Column(name = "TARGET_NAME", columnDefinition = "VARCHAR2|指标名称||", length = 80, nullable = true)
	private String targetName;

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

	public String getSysModelCode() {
		return this.sysModelCode;
	}

	public void setSysModelCode(String sysModelCode) {
		this.sysModelCode = sysModelCode;
	}

	public String getTargetCode() {
		return this.targetCode;
	}

	public void setTargetCode(String targetCode) {
		this.targetCode = targetCode;
	}

	public String getTargetName() {
		return this.targetName;
	}

	public void setTargetName(String targetName) {
		this.targetName = targetName;
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