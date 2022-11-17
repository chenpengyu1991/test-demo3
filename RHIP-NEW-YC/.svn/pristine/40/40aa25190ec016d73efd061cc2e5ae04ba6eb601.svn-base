package com.founder.rhip.ehr.entity.basic;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DM_STATISTICS_BY_MONTH")
public class StatisticsByMonth implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = false)
	private Long id;

	@Column(name = "SIXTY_FIVE_ELDER", columnDefinition = "NUMBER|65岁以上老年人||", length = 11, nullable = false)
	private Long sixtyFiveElder;

	@Column(name = "HYPERTENSION", columnDefinition = "NUMBER|高血压患者||", length = 11, nullable = false)
	private Long hypertension;

	@Column(name = "TYPE_TWO_DIABETES", columnDefinition = "NUMBER|2型糖尿病患者||", nullable = false)
	private Long typeTwoDiabetes;

	@Column(name = "TOTAL_RECORD", columnDefinition = "NUMBER|档案总数（含注销）||", length = 11, nullable = false)
	private Long totalRecord;

	@Column(name = "CHANGED_RECORD", columnDefinition = "NUMBER|有动态记录档案||", length = 11, nullable = false)
	private Long changedRecord;

	@Column(name = "UNCHANGED_RECORD", columnDefinition = "NUMBER|无动态记录档案||", length = 11, nullable = false)
	private Long unchangedRecord;

	@Column(name = "NEW_HYPERTENSION", columnDefinition = "NUMBER|新发现高血压数||", length = 11, nullable = true)
	private Long newHypertension;

	@Column(name = "CURED_HYPERTENSION", columnDefinition = "NUMBER|最近一次随访血压达标患者数||", length = 11, nullable = true)
	private Long curedHypertension;

	@Column(name = "NEW_TYPE_TWO_DIABETES", columnDefinition = "NUMBER|新发现2型糖尿病患者||", length = 11, nullable = true)
	private Long newTypeTwoDiabetes;

	@Column(name = "CURED_TYPE_TWO_DIABETES", columnDefinition = "NUMBER|最近一次随访血糖达标患者数||", length = 11, nullable = true)
	private Long curedTypeTwoDiabetes;

	@Column(name = "RECORD_DATE", columnDefinition = "DATE|记录日期||", nullable = true)
	private Date recordDate;

	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|机构编码||", length = 20, nullable = true)
	private String organCode;

	@Column(name = "ORGAN_NAME", columnDefinition = "VARCHAR2|机构名称||", length = 500, nullable = true)
	private String organName;
	
	@Column(name = "ORGAN_TYPE", columnDefinition = "VARCHAR2|机构类型||", length = 20, nullable = true)
	private String organType;

	@Column(name = "HOUSEHOLD_TYPE", columnDefinition = "VARCHAR2|常住类型||", length = 500, nullable = true)
	private String householdtype;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSixtyFiveElder() {
		return sixtyFiveElder;
	}

	public void setSixtyFiveElder(Long sixtyFiveElder) {
		this.sixtyFiveElder = sixtyFiveElder;
	}

	public Long getHypertension() {
		return hypertension;
	}

	public void setHypertension(Long hypertension) {
		this.hypertension = hypertension;
	}

	public Long getTypeTwoDiabetes() {
		return typeTwoDiabetes;
	}

	public void setTypeTwoDiabetes(Long typeTwoDiabetes) {
		this.typeTwoDiabetes = typeTwoDiabetes;
	}

	public Long getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Long totalRecord) {
		this.totalRecord = totalRecord;
	}

	public Long getChangedRecord() {
		return changedRecord;
	}

	public void setChangedRecord(Long changedRecord) {
		this.changedRecord = changedRecord;
	}

	public Long getUnchangedRecord() {
		return unchangedRecord;
	}

	public void setUnchangedRecord(Long unchangedRecord) {
		this.unchangedRecord = unchangedRecord;
	}

	public Long getNewHypertension() {
		return newHypertension;
	}

	public void setNewHypertension(Long newHypertension) {
		this.newHypertension = newHypertension;
	}

	public Long getCuredHypertension() {
		return curedHypertension;
	}

	public void setCuredHypertension(Long curedHypertension) {
		this.curedHypertension = curedHypertension;
	}

	public Long getNewTypeTwoDiabetes() {
		return newTypeTwoDiabetes;
	}

	public void setNewTypeTwoDiabetes(Long newTypeTwoDiabetes) {
		this.newTypeTwoDiabetes = newTypeTwoDiabetes;
	}

	public Long getCuredTypeTwoDiabetes() {
		return curedTypeTwoDiabetes;
	}

	public void setCuredTypeTwoDiabetes(Long curedTypeTwoDiabetes) {
		this.curedTypeTwoDiabetes = curedTypeTwoDiabetes;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
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

	public String getOrganType() {
		return organType;
	}

	public void setOrganType(String organType) {
		this.organType = organType;
	}

	public String getHouseholdtype() {
		return householdtype;
	}

	public void setHouseholdtype(String householdtype) {
		this.householdtype = householdtype;
	}

}
