package com.founder.rhip.ehr.entity.management.mhm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "MHM_INHOSPITAL")
public class MhmInhospital implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "EVENT_ID", columnDefinition = "NUMBER|本系统唯一编码|11|", length = 11, nullable = false)
	private Long eventId;

	@Column(name = "INPATIENT_RECORD_NO", columnDefinition = "VARCHAR2|住院病案号|18|", length = 18, nullable = true)
	private String inpatientRecordNo;

	@Column(name = "OUTPATIENT_RECORD_NO", columnDefinition = "VARCHAR2|门诊病案号|18|", length = 18, nullable = true)
	private String outpatientRecordNo;

	@Column(name = "INPATIENT_DIAGNOSIS", columnDefinition = "VARCHAR2|住院诊断|18|", length = 18, nullable = true)
	private String inpatientDiagnosis;

	@Column(name = "INPATIENT_NO", columnDefinition = "VARCHAR2|住院编号|100|", length = 100, nullable = true)
	private String inpatientNo;

	@Column(name = "RECOVERY_MEASURE", columnDefinition = "VARCHAR2|住院康复措施|100|", length = 100, nullable = true)
	private String recoveryMeasure;

	@Column(name = "RECOVERY_MEASURE_OTHER", columnDefinition = "VARCHAR2|住院康复措施|100|", length = 100, nullable = true)
	private String recoveryMeasureOther;

	@Column(name = "ECONOMIC_GRANT_DEPT", columnDefinition = "VARCHAR2|住院经济补助部门|50|", length = 50, nullable = true)
	private String economicGrantDept;

	@Column(name = "NEXT_RECOVERY_MEASURE", columnDefinition = "VARCHAR2|住院康复措施|100|", length = 100, nullable = true)
	private String nextRecoveryMeasure;

	@Column(name = "NEXT_RECOVERY_MEASURE_OTHER", columnDefinition = "VARCHAR2|住院康复措施|100|", length = 100, nullable = true)
	private String nextRecoveryMeasureOther;

	@Column(name = "TREATING_PHYSICIAN", columnDefinition = "VARCHAR2|经治医生|50|", length = 50, nullable = true)
	private String treatingPhysician;

	@Column(name = "CONTACT_NUMBER", columnDefinition = "VARCHAR2|联系电话|20|", length = 20, nullable = true)
	private String contactNumber;

	@Column(name = "INPATIENT_ORGAN_CODE", columnDefinition = "VARCHAR2|住院医院|50|", length = 50, nullable = true)
	private String inpatientOrganCode;

    @Column(name = "INHOSPITAL_DATE", columnDefinition = "DATE|出院日期||", nullable = true)
    private Date inhospitalDate;

	@Column(name = "DISCHARGE_DATE", columnDefinition = "DATE|出院日期||", nullable = true)
	private Date dischargeDate;

	@Column(name = "INPATIENT_EFFECT", columnDefinition = "VARCHAR2|住院疗效|100|", length = 100, nullable = true)
	private String inpatientEffect;

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

	public String getInpatientRecordNo() {
		return this.inpatientRecordNo;
	}

	public void setInpatientRecordNo(String inpatientRecordNo) {
		this.inpatientRecordNo = inpatientRecordNo;
	}

	public String getOutpatientRecordNo() {
		return this.outpatientRecordNo;
	}

	public void setOutpatientRecordNo(String outpatientRecordNo) {
		this.outpatientRecordNo = outpatientRecordNo;
	}

	public String getInpatientDiagnosis() {
		return this.inpatientDiagnosis;
	}

	public void setInpatientDiagnosis(String inpatientDiagnosis) {
		this.inpatientDiagnosis = inpatientDiagnosis;
	}

	public String getInpatientNo() {
		return this.inpatientNo;
	}

	public void setInpatientNo(String inpatientNo) {
		this.inpatientNo = inpatientNo;
	}

	public String getRecoveryMeasure() {
		return this.recoveryMeasure;
	}

	public void setRecoveryMeasure(String recoveryMeasure) {
		this.recoveryMeasure = recoveryMeasure;
	}

	public String getRecoveryMeasureOther() {
		return this.recoveryMeasureOther;
	}

	public void setRecoveryMeasureOther(String recoveryMeasureOther) {
		this.recoveryMeasureOther = recoveryMeasureOther;
	}

	public String getEconomicGrantDept() {
		return this.economicGrantDept;
	}

	public void setEconomicGrantDept(String economicGrantDept) {
		this.economicGrantDept = economicGrantDept;
	}

	public String getNextRecoveryMeasure() {
		return this.nextRecoveryMeasure;
	}

	public void setNextRecoveryMeasure(String nextRecoveryMeasure) {
		this.nextRecoveryMeasure = nextRecoveryMeasure;
	}

	public String getNextRecoveryMeasureOther() {
		return this.nextRecoveryMeasureOther;
	}

	public void setNextRecoveryMeasureOther(String nextRecoveryMeasureOther) {
		this.nextRecoveryMeasureOther = nextRecoveryMeasureOther;
	}

	public String getTreatingPhysician() {
		return this.treatingPhysician;
	}

	public void setTreatingPhysician(String treatingPhysician) {
		this.treatingPhysician = treatingPhysician;
	}

	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getInpatientOrganCode() {
		return this.inpatientOrganCode;
	}

	public void setInpatientOrganCode(String inpatientOrganCode) {
		this.inpatientOrganCode = inpatientOrganCode;
	}

	public Date getDischargeDate() {
		return this.dischargeDate;
	}

	public void setDischargeDate(Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

	public String getInpatientEffect() {
		return this.inpatientEffect;
	}

	public void setInpatientEffect(String inpatientEffect) {
		this.inpatientEffect = inpatientEffect;
	}

    public Date getInhospitalDate() {
        return inhospitalDate;
    }

    public void setInhospitalDate(Date inhospitalDate) {
        this.inhospitalDate = inhospitalDate;
    }
}