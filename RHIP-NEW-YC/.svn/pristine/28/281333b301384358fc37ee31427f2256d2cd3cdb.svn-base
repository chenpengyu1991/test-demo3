package com.founder.rhip.ehr.entity.summary;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.founder.rhip.ehr.annotation.RecordTrace;


@Entity
@Table(name = "DHS_DRUG_HISTORY")
public class DrugHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;
    
    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|PERSON号||", length = 50, nullable = true)
    private Long personId;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|EHR号||", length = 11, nullable = true)
    private String ehrId;

    @Column(name = "IDCARD", columnDefinition = "VARCHAR2|居民身份证/健康卡号||", length = 18, nullable = true)
    private String idcard;

    @RecordTrace
    @Column(name = "DRUG_USE_FREQUENCY", columnDefinition = "VARCHAR2|药物使用频率||", length = 20, nullable = false)
    private String drugUseFrequency;

    @RecordTrace
    @Column(name = "DRUG_USE_DOSE_UNIT", columnDefinition = "VARCHAR2|药物使用剂量单位||", length = 6, nullable = false)
    private String drugUseDoseUnit;

    @RecordTrace
    @Column(name = "DRUG_USE_STATE", columnDefinition = "VARCHAR2|药物使用次剂量||", length = 5, nullable = false)
    private String drugUseState;

    @Column(name = "DRUG_USE_ROUTE_CODE", columnDefinition = "VARCHAR2|药物使用途径代码||", length = 3, nullable = true)
    private String drugUseRouteCode;

    @RecordTrace
    @Column(name = "START_DATE", columnDefinition = "TIMESTAMP|用药开始日期时间||",  nullable = false)
    private Date startDate;

    @RecordTrace
    @Column(name = "STOP_DATE", columnDefinition = "TIMESTAMP|用药停止日期时间||",  nullable = false)
    private Date stopDate;

    @RecordTrace
    @Column(name = "DRUG_GENERIC_NAME", columnDefinition = "VARCHAR2|药物通用名||", length = 18, nullable = false)
    private String drugGenericName;
    
    @RecordTrace
    @Column(name = "MEDICATION_COMPLIANCE", columnDefinition = "VARCHAR2|服药依从性代码||", length = 1, nullable = false)
    private String medicationCompliance;

    @Column(name = "INPUT_NAME", columnDefinition = "VARCHAR2|建档人姓名||", length = 50, nullable = true)
    private String inputName;

    @Column(name = "INPUT_IDCARD", columnDefinition = "VARCHAR2|建档人身份证号||", length = 18, nullable = true)
    private String inputIdcard;

    @Column(name = "INPUT_ORGAN_CODE", columnDefinition = "VARCHAR2|建档机构编码||", length = 15, nullable = true)
    private String inputOrganCode;

    @Column(name = "INPUT_ORGAN_NAME", columnDefinition = "VARCHAR2|建档机构名称||", length = 70, nullable = true)
    private String inputOrganName;

    @Column(name = "INPUT_DATE", columnDefinition = "TIMESTAMP|建档日期和时间||", nullable = true)
    private Date inputDate;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getEhrId() {
		return ehrId;
	}

	public void setEhrId(String ehrId) {
		this.ehrId = ehrId;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getDrugUseFrequency() {
		return drugUseFrequency;
	}

	public void setDrugUseFrequency(String drugUseFrequency) {
		this.drugUseFrequency = drugUseFrequency;
	}

	public String getDrugUseDoseUnit() {
		return drugUseDoseUnit;
	}

	public void setDrugUseDoseUnit(String drugUseDoseUnit) {
		this.drugUseDoseUnit = drugUseDoseUnit;
	}

	public String getDrugUseState() {
		return drugUseState;
	}

	public void setDrugUseState(String drugUseState) {
		this.drugUseState = drugUseState;
	}

	public String getDrugUseRouteCode() {
		return drugUseRouteCode;
	}

	public void setDrugUseRouteCode(String drugUseRouteCode) {
		this.drugUseRouteCode = drugUseRouteCode;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getStopDate() {
		return stopDate;
	}

	public void setStopDate(Date stopDate) {
		this.stopDate = stopDate;
	}

	public String getDrugGenericName() {
		return drugGenericName;
	}

	public void setDrugGenericName(String drugGenericName) {
		this.drugGenericName = drugGenericName;
	}

	public String getMedicationCompliance() {
		return medicationCompliance;
	}

	public void setMedicationCompliance(String medicationCompliance) {
		this.medicationCompliance = medicationCompliance;
	}

	public String getInputName() {
		return inputName;
	}

	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	public String getInputIdcard() {
		return inputIdcard;
	}

	public void setInputIdcard(String inputIdcard) {
		this.inputIdcard = inputIdcard;
	}

	public String getInputOrganCode() {
		return inputOrganCode;
	}

	public void setInputOrganCode(String inputOrganCode) {
		this.inputOrganCode = inputOrganCode;
	}

	public String getInputOrganName() {
		return inputOrganName;
	}

	public void setInputOrganName(String inputOrganName) {
		this.inputOrganName = inputOrganName;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}
