package com.founder.rhip.ehr.entity.control.idm.notifiabledisease;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "IDM_SETUP")
public class IdmSetup implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|自增长id|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "SET_YEAR", columnDefinition = "NUMBER|生效年份|11|", length = 11, nullable = true)
	private Integer setYear;

	@Column(name = "INFECTIOUS_CODE", columnDefinition = "VARCHAR2|疾病编码|100|", length = 100, nullable = true)
	private String infectiousCode;

    @Column(name = "INFECTIOUS_NAME", columnDefinition = "VARCHAR2|疾病名称|100|", length = 100, nullable = true)
    private String infectiousName;

	@Column(name = "CASE_ORGAN_CODE", columnDefinition = "VARCHAR2|机构编码|100|", length = 100, nullable = true)
	private String caseOrganCode;

	@Column(name = "CREATE_UNIT_CODE", columnDefinition = "VARCHAR2|新增机构|100|", length = 100, nullable = true)
	private String createUnitCode;

	@Column(name = "CREATE_USER_ID", columnDefinition = "VARCHAR2|新增人|100|", length = 100, nullable = true)
	private String createUserId;

	@Column(name = "CREATE_DT", columnDefinition = "DATE|新增时间||", nullable = true)
	private Date createDt;

	@Column(name = "MODIFY_UNIT_CODE", columnDefinition = "VARCHAR2|修改机构|100|", length = 100, nullable = true)
	private String modifyUnitCode;

	@Column(name = "MODIFY_USER_ID", columnDefinition = "VARCHAR2|修改人|100|", length = 100, nullable = true)
	private String modifyUserId;

	@Column(name = "MODIFY_DT", columnDefinition = "DATE|修改时间||", nullable = true)
	private Date modifyDt;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSetYear() {
		return this.setYear;
	}

	public void setSetYear(Integer setYear) {
		this.setYear = setYear;
	}

	public String getInfectiousCode() {
		return this.infectiousCode;
	}

	public void setInfectiousCode(String infectiousCode) {
		this.infectiousCode = infectiousCode;
	}

    public String getInfectiousName() {
        return this.infectiousName;
    }

    public void setInfectiousName(String infectiousName) {
        this.infectiousName = infectiousName;
    }

	public String getCaseOrganCode() {
		return this.caseOrganCode;
	}

	public void setCaseOrganCode(String caseOrganCode) {
		this.caseOrganCode = caseOrganCode;
	}

	public String getCreateUnitCode() {
		return this.createUnitCode;
	}

	public void setCreateUnitCode(String createUnitCode) {
		this.createUnitCode = createUnitCode;
	}

	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreateDt() {
		return this.createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public String getModifyUnitCode() {
		return this.modifyUnitCode;
	}

	public void setModifyUnitCode(String modifyUnitCode) {
		this.modifyUnitCode = modifyUnitCode;
	}

	public String getModifyUserId() {
		return this.modifyUserId;
	}

	public void setModifyUserId(String modifyUserId) {
		this.modifyUserId = modifyUserId;
	}

	public Date getModifyDt() {
		return this.modifyDt;
	}

	public void setModifyDt(Date modifyDt) {
		this.modifyDt = modifyDt;
	}

}