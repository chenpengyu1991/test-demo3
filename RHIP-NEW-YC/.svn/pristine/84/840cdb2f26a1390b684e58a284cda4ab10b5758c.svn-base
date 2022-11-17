package com.founder.rhip.ehr.entity.management.mhm;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "MHM_CASE")
public class MhmCase implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "EVENT_ID", columnDefinition = "NUMBER|本系统唯一编码|11|", length = 11, nullable = false)
	private Long eventId;

	@Column(name = "CREATE_DATE", columnDefinition = "DATE|定制日期||", nullable = true)
	private Date createDate;

	@Column(name = "CREATE_NUMBER", columnDefinition = "NUMBER|制定次数|5|", length = 5, nullable = true)
	private Integer createNumber;

	@Column(name = "RISK_EVALUATE", columnDefinition = "VARCHAR2|危险性评估|20|", length = 20, nullable = true)
	private String riskEvaluate;

	@Column(name = "TREATMENT_MODE", columnDefinition = "VARCHAR2|目前就医方式|20|", length = 20, nullable = true)
	private String treatmentMode;

	@Column(name = "UNTREATED_REASON", columnDefinition = "VARCHAR2|未治原因|20|", length = 20, nullable = true)
	private String untreatedReason;

	@Column(name = "UNTREATED_REASON_OTHER", columnDefinition = "VARCHAR2|未治原因-其他|100|", length = 100, nullable = true)
	private String untreatedReasonOther;

	@Column(name = "MANAGEMENT_LEVEL", columnDefinition = "VARCHAR2|目前管理级别|20|", length = 20, nullable = true)
	private String managementLevel;

	@Column(name = "TAKE_MEDICINE_WAY", columnDefinition = "VARCHAR2|服药方式|20|", length = 20, nullable = true)
	private String takeMedicineWay;

	@Column(name = "ADVERSE_REACTION", columnDefinition = "VARCHAR2|药物不良反应|20|", length = 20, nullable = true)
	private String adverseReaction;

	@Column(name = "ADVERSE_REACTION_OTHER", columnDefinition = "VARCHAR2|药物不良反应-其他|100|", length = 100, nullable = true)
	private String adverseReactionOther;

	@Column(name = "RECOVERY_PLACE", columnDefinition = "VARCHAR2|康复地点|20|", length = 20, nullable = true)
	private String recoveryPlace;

	@Column(name = "RECOVERY_PLACE_OTHER", columnDefinition = "VARCHAR2|康复地点-其他|100|", length = 100, nullable = true)
	private String recoveryPlaceOther;

	@Column(name = "INCOME", columnDefinition = "VARCHAR2|劳动水平收入|2|", length = 2, nullable = true)
	private String income;

    @Column(name = "INCOME_PRE", columnDefinition = "VARCHAR2|劳动水平收入/月|20|", length = 20, nullable = true)
    private String incomePre;

	@Column(name = "NEXT_MANAGEMENT_LEVEL", columnDefinition = "VARCHAR2|下阶段拟管理级别|20|", length = 20, nullable = true)
	private String nextManagementLevel;

	@Column(name = "CONSIDERING_FIELD", columnDefinition = "VARCHAR2|考虑领域|20|", length = 20, nullable = true)
	private String consideringField;

	@Column(name = "FILL_ORGAN_CODE", columnDefinition = "VARCHAR2|填写机构|100|", length = 100, nullable = true)
	private String fillOrganCode;

	@Column(name = "FILL_DOCTOR_ID", columnDefinition = "VARCHAR2|填写医生|50|", length = 50, nullable = true)
	private String fillDoctorId;

	@Column(name = "FILL_DATE", columnDefinition = "DATE|填写时间||", nullable = true)
	private Date fillDate;

	@Column(name = "MODIFY_DOCTOR_ID", columnDefinition = "VARCHAR2|修改医生|50|", length = 50, nullable = true)
	private String modifyDoctorId;

	@Column(name = "MODIFY_ORGAN_CODE", columnDefinition = "VARCHAR2|修改机构|20|", length = 20, nullable = true)
	private String modifyOrganCode;

	@Column(name = "MODIFY_DATE", columnDefinition = "DATE|修改日期||", nullable = true)
	private Date modifyDate;

	@Transient
	private List<MhmCaseDetail> caseDetails;
	
	@Transient
	private String caseDetailJson;
	
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

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getCreateNumber() {
		return this.createNumber;
	}

	public void setCreateNumber(Integer createNumber) {
		this.createNumber = createNumber;
	}

	public String getRiskEvaluate() {
		return this.riskEvaluate;
	}

	public void setRiskEvaluate(String riskEvaluate) {
		this.riskEvaluate = riskEvaluate;
	}

	public String getTreatmentMode() {
		return this.treatmentMode;
	}

	public void setTreatmentMode(String treatmentMode) {
		this.treatmentMode = treatmentMode;
	}

	public String getUntreatedReason() {
		return this.untreatedReason;
	}

	public void setUntreatedReason(String untreatedReason) {
		this.untreatedReason = untreatedReason;
	}

	public String getUntreatedReasonOther() {
		return this.untreatedReasonOther;
	}

	public void setUntreatedReasonOther(String untreatedReasonOther) {
		this.untreatedReasonOther = untreatedReasonOther;
	}

	public String getManagementLevel() {
		return this.managementLevel;
	}

	public void setManagementLevel(String managementLevel) {
		this.managementLevel = managementLevel;
	}

	public String getTakeMedicineWay() {
		return this.takeMedicineWay;
	}

	public void setTakeMedicineWay(String takeMedicineWay) {
		this.takeMedicineWay = takeMedicineWay;
	}

	public String getAdverseReaction() {
		return this.adverseReaction;
	}

	public void setAdverseReaction(String adverseReaction) {
		this.adverseReaction = adverseReaction;
	}

	public String getAdverseReactionOther() {
		return this.adverseReactionOther;
	}

	public void setAdverseReactionOther(String adverseReactionOther) {
		this.adverseReactionOther = adverseReactionOther;
	}

	public String getRecoveryPlace() {
		return this.recoveryPlace;
	}

	public void setRecoveryPlace(String recoveryPlace) {
		this.recoveryPlace = recoveryPlace;
	}

	public String getRecoveryPlaceOther() {
		return this.recoveryPlaceOther;
	}

	public void setRecoveryPlaceOther(String recoveryPlaceOther) {
		this.recoveryPlaceOther = recoveryPlaceOther;
	}

	public String getIncome() {
		return this.income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

    public String getIncomePre() {
        return incomePre;
    }

    public void setIncomePre(String incomePre) {
        this.incomePre = incomePre;
    }

    public String getNextManagementLevel() {
		return this.nextManagementLevel;
	}

	public void setNextManagementLevel(String nextManagementLevel) {
		this.nextManagementLevel = nextManagementLevel;
	}

	public String getConsideringField() {
		return this.consideringField;
	}

	public void setConsideringField(String consideringField) {
		this.consideringField = consideringField;
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

	public List<MhmCaseDetail> getCaseDetails() {
		return caseDetails;
	}

	public void setCaseDetails(List<MhmCaseDetail> caseDetails) {
		this.caseDetails = caseDetails;
	}

	public String getCaseDetailJson() {
		return caseDetailJson;
	}

	public void setCaseDetailJson(String caseDetailJson) {
		this.caseDetailJson = caseDetailJson;
	}
}