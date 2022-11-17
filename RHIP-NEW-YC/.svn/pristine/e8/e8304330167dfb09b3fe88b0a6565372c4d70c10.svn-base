package com.founder.rhip.ehr.entity.control.dmbc;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "DMBC_TREATMENT_RECORD")
public class DmbcTreatmentRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, scale = 11, nullable = true)
	private Long id;

	@Column(name = "SEWAGE_TREATMENT_ID", columnDefinition = "NUMBER|污水处理基本情况ID||", length = 11, scale = 11, nullable = true)
	private Long sewageTreatmentId;

	@Column(name = "TREATMENT_DATE", columnDefinition = "DATE|处理日期||", nullable = true)
	private Date treatmentDate;

	@Column(name = "TREATMENT_QUANTITY", columnDefinition = "VARCHAR2|污水处理量||", length = 20, scale = 20, nullable = true)
	private String treatmentQuantity;

	@Column(name = "DOSING_QUANTITY", columnDefinition = "VARCHAR2|消毒剂投加量||", length = 20, scale = 20, nullable = true)
	private String dosingQuantity;

	@Column(name = "TREATMENT_TIME", columnDefinition = "VARCHAR2|处理时间||", length = 20, scale = 20, nullable = true)
	private String treatmentTime;

	@Column(name = "RESIDUAL_CHLORINE_VAL", columnDefinition = "VARCHAR2|余氯值||", length = 20, scale = 20, nullable = true)
	private String residualChlorineVal;

	@Column(name = "ASSIGNER", columnDefinition = "VARCHAR2|处理人||", length = 20, scale = 20, nullable = true)
	private String assigner;

	@Column(name = "CREATE_TIME", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createTime;

	@Column(name = "CREATE_BY", columnDefinition = "VARCHAR2|创建者||", length = 20, scale = 20, nullable = true)
	private String createBy;

	@Column(name = "UPDATE_TIME", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date updateTime;

	@Column(name = "UPDATE_BY", columnDefinition = "VARCHAR2|更新者||", length = 20, scale = 20, nullable = true)
	private String updateBy;

	@Column(name = "IS_DELETE", columnDefinition = "INT|删除状态||", nullable = true)
	private Integer isDelete;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSewageTreatmentId() {
		return this.sewageTreatmentId;
	}

	public void setSewageTreatmentId(Long sewageTreatmentId) {
		this.sewageTreatmentId = sewageTreatmentId;
	}

	public Date getTreatmentDate() {
		return this.treatmentDate;
	}

	public void setTreatmentDate(Date treatmentDate) {
		this.treatmentDate = treatmentDate;
	}

	public String getTreatmentQuantity() {
		return this.treatmentQuantity;
	}

	public void setTreatmentQuantity(String treatmentQuantity) {
		this.treatmentQuantity = treatmentQuantity;
	}

	public String getDosingQuantity() {
		return this.dosingQuantity;
	}

	public void setDosingQuantity(String dosingQuantity) {
		this.dosingQuantity = dosingQuantity;
	}

	public String getTreatmentTime() {
		return treatmentTime;
	}

	public void setTreatmentTime(String treatmentTime) {
		this.treatmentTime = treatmentTime;
	}

	public String getResidualChlorineVal() {
		return this.residualChlorineVal;
	}

	public void setResidualChlorineVal(String residualChlorineVal) {
		this.residualChlorineVal = residualChlorineVal;
	}

	public String getAssigner() {
		return this.assigner;
	}

	public void setAssigner(String assigner) {
		this.assigner = assigner;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateBy() {
		return this.updateBy;
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