package com.founder.rhip.ehr.entity.ihm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "HM_TARGET_DIVISOR")
public class HmTargetDivisor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;

	@Column(name = "DIVISOR_CODE", columnDefinition = "VARCHAR2|因子编号||", length = 20, nullable = true)
	private String divisorCode;

	@Column(name = "DIVISOR_NAME", columnDefinition = "VARCHAR2|因子名称||", length = 80, nullable = true)
	private String divisorName;

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

	public String getDivisorCode() {
		return this.divisorCode;
	}

	public void setDivisorCode(String divisorCode) {
		this.divisorCode = divisorCode;
	}

	public String getDivisorName() {
		return this.divisorName;
	}

	public void setDivisorName(String divisorName) {
		this.divisorName = divisorName;
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