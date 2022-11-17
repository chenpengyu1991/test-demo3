package com.founder.rhip.ehr.entity.management.mhm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "MHM_DRUG_RECORD")
public class MhmDrugRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "EVENT_ID", columnDefinition = "NUMBER|本系统唯一编码|11|", length = 11, nullable = false)
	private Long eventId;

	@Column(name = "DRUG_ID", columnDefinition = "NUMBER|药品ID|11|", length = 11, nullable = true)
	private Long drugId;

	@Column(name = "DRUG_NAME", columnDefinition = "VARCHAR2|药物名称|50|", length = 50, nullable = true)
	private String drugName;

	@Column(name = "DRUG_SPECIFICATIONS", columnDefinition = "VARCHAR2|药物规格|20|", length = 20, nullable = true)
	private String drugSpecifications;

	@Column(name = "DRUG_MORNING", columnDefinition = "NUMBER|早||", scale = 5, precision = 2, nullable = true)
	private BigDecimal drugMorning;

	@Column(name = "DRUG_NOON", columnDefinition = "NUMBER|中||", scale = 5, precision = 2, nullable = true)
	private BigDecimal drugNoon;

	@Column(name = "DRUG_EVENING", columnDefinition = "NUMBER|晚||", scale = 5, precision = 2, nullable = true)
	private BigDecimal drugEvening;

	@Column(name = "UNIT", columnDefinition = "VARCHAR2|单位|20|", length = 20, nullable = true)
	private String unit;

	@Column(name = "DRUG_SPECIAL", columnDefinition = "VARCHAR2|特殊情况|100|", length = 100, nullable = true)
	private String drugSpecial;

	@Column(name = "FILL_ORGAN_CODE", columnDefinition = "VARCHAR2|填写机构|100|", length = 100, nullable = true)
	private String fillOrganCode;

	@Column(name = "FILL_DOCTOR_ID", columnDefinition = "VARCHAR2|填写医生|50|", length = 50, nullable = true)
	private String fillDoctorId;

	@Column(name = "FILL_DATE", columnDefinition = "DATE|填写时间||", nullable = true)
	private Date fillDate;

	@Column(name = "MODIFY_DOCTOR_ID", columnDefinition = "VARCHAR2|修改医生|50|", length = 50, nullable = true)
	private String modifyDoctorId;

	@Column(name = "MODIFY_ORGAN_CODE", columnDefinition = "VARCHAR2|修改机构|100|", length = 100, nullable = true)
	private String modifyOrganCode;

	@Column(name = "MODIFY_DATE", columnDefinition = "DATE|修改日期||", nullable = true)
	private Date modifyDate;

	@Column(name = "TYPE", columnDefinition = "VARCHAR2|类型（随访、非随访）|2|", length = 2, nullable = true)
	private String type;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEventId() {
		return this.eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getDrugName() {
		return this.drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getDrugSpecifications() {
		return this.drugSpecifications;
	}

	public void setDrugSpecifications(String drugSpecifications) {
		this.drugSpecifications = drugSpecifications;
	}

	public BigDecimal getDrugMorning() {
		return this.drugMorning;
	}

	public void setDrugMorning(BigDecimal drugMorning) {
		this.drugMorning = drugMorning;
	}

	public BigDecimal getDrugNoon() {
		return this.drugNoon;
	}

	public void setDrugNoon(BigDecimal drugNoon) {
		this.drugNoon = drugNoon;
	}

	public BigDecimal getDrugEvening() {
		return this.drugEvening;
	}

	public void setDrugEvening(BigDecimal drugEvening) {
		this.drugEvening = drugEvening;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getDrugSpecial() {
		return this.drugSpecial;
	}

	public void setDrugSpecial(String drugSpecial) {
		this.drugSpecial = drugSpecial;
	}

	public String getFillOrganCode() {
		return this.fillOrganCode;
	}

	public void setFillOrganCode(String fillOrganCode) {
		this.fillOrganCode = fillOrganCode;
	}

	public String getFillDoctorId() {
		return this.fillDoctorId;
	}

	public void setFillDoctorId(String fillDoctorId) {
		this.fillDoctorId = fillDoctorId;
	}

	public Date getFillDate() {
		return this.fillDate;
	}

	public void setFillDate(Date fillDate) {
		this.fillDate = fillDate;
	}

	public String getModifyDoctorId() {
		return this.modifyDoctorId;
	}

	public void setModifyDoctorId(String modifyDoctorId) {
		this.modifyDoctorId = modifyDoctorId;
	}

	public String getModifyOrganCode() {
		return this.modifyOrganCode;
	}

	public void setModifyOrganCode(String modifyOrganCode) {
		this.modifyOrganCode = modifyOrganCode;
	}

	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

    public Long getDrugId() {
        return drugId;
    }

    public void setDrugId(Long drugId) {
        this.drugId = drugId;
    }
}