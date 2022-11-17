package com.founder.rhip.ehr.entity.ihm;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "RP_HM_HOSPITALIZE")
public class HmHospitalize implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;

	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|医疗机构编码||", length = 20, nullable = true)
	private String organCode;

	@Column(name = "IN_HOSPITAL_NUM", columnDefinition = "NUMBER|入院总人次||", length = 10, nullable = true)
	private Long inHospitalNum;

	@Column(name = "CRITICAL_ILL_NUM", columnDefinition = "NUMBER|危重病人数||", length = 10, nullable = true)
	private Long criticalIllNum;

	@Column(name = "LEAVE_HOSPITAL_NUM", columnDefinition = "NUMBER|出院总人次||", length = 10, nullable = true)
	private Long leaveHospitalNum;

	@Column(name = "sickbed_count", columnDefinition = "NUMBER||在院人次||", length = 10, nullable = true)
	private Long sickbedCount;

	@Column(name = "anesthesia_num", columnDefinition = "NUMBER|麻醉人次||", length = 10, nullable = true)
	private Long anesthesiaNum;

	@Column(name = "LEAVE_HOS_CURE_NUM", columnDefinition = "NUMBER|出院治愈人次||", length = 10, nullable = true)
	private Long leaveHosCureNum;

	@Column(name = "LEAVE_HOS_IMPROVE_NUM", columnDefinition = "NUMBER|出院好转人次||", length = 10, nullable = true)
	private Long leaveHosImproveNum;

	@Column(name = "IN_HOS_DAY_NUM", columnDefinition = "NUMBER|住院天数||", length = 10, nullable = true)
	private Long inHosDayNum;

	@Column(name = "IN_HOS_FEE", columnDefinition = "NUMBER|住院总费用||", length = 18, scale = 4, precision = 2, nullable = true)
	private BigDecimal inHosFee;

	@Column(name = "IN_HOS_MEDICINAL_FEE", columnDefinition = "NUMBER|住院药品费||", length = 18, scale = 4, precision = 2, nullable = true)
	private BigDecimal inHosMedicinalFee;

	@Column(name = "IN_HOS_MEDICAL_FEE", columnDefinition = "NUMBER|住院医疗费||", length = 16, scale = 4, precision = 2, nullable = true)
	private BigDecimal inHosMedicalFee;

	@Column(name = "IN_HOS_CHECK_FEE", columnDefinition = "NUMBER|住院检查费||", length = 16, scale = 4, precision = 2, nullable = true)
	private BigDecimal inHosCheckFee;

	@Column(name = "IN_HOS_TEST_FEE", columnDefinition = "NUMBER|住院检验费||", length = 16, scale = 4, precision = 2, nullable = true)
	private BigDecimal inHosTestFee;

	@Column(name = "IN_HOS_NURSE_FEE", columnDefinition = "NUMBER|住院护理费||", length = 16, scale = 4, precision = 2, nullable = true)
	private BigDecimal inHosNurseFee;

	@Column(name = "IN_HOS_BED_FEE", columnDefinition = "NUMBER|住院床位费||", length = 16, scale = 4, precision = 2, nullable = true)
	private BigDecimal inHosBedFee;

	@Column(name = "USE_BED_NUM", columnDefinition = "NUMBER|实际占用床数||", length = 10, nullable = true)
	private Long useBedNum;

	@Column(name = "OPEN_BED_NUM", columnDefinition = "NUMBER|实际开放床数||", length = 10, nullable = true)
	private Long openBedNum;

	@Column(name = "OUT_HOSP_HEALED_NUM", columnDefinition = "NUMBER|出院患者未愈人次||", length = 10, nullable = true)
	private Long outHospHealedNum;

	@Column(name = "OUT_HOSP_DIED_NUM", columnDefinition = "NUMBER|出院患者病死数||", length = 10, nullable = true)
	private Long outHospDiedNum;

	@Column(name = "OUT_HOSP_INSURANCE_NUM", columnDefinition = "NUMBER|出院医保患者人次||", length = 10, nullable = true)
	private Long outHospInsuranceNum;

	@Column(name = "OUT_HOSP_INHOSP_FEE", columnDefinition = "NUMBER|出院医保患者住院总费用||", length = 16, scale = 4, precision = 2, nullable = true)
	private Long outHospInhospFee;

	@Column(name = "OUT_HOSP_INHOSP_DAYS", columnDefinition = "NUMBER|出院医保患者住院日||", length = 5, nullable = true)
	private Long outHospInhospDays;

	@Column(name = "BED_PER_DAY", columnDefinition = "NUMBER|日病床收容量||", length = 10, nullable = true)
	private Long bedPerDay;

	@Column(name = "OUT_HOSP_3DAY", columnDefinition = "NUMBER|出院患者中三日内确诊人数||", length = 10, nullable = true)
	private Long outHosp3day;

	@Column(name = "CLINIC_DIAG_ACCORD_NUM", columnDefinition = "NUMBER|门诊与出院诊断符合数||", length = 10, nullable = true)
	private Long clinicDiagAccordNum;

	@Column(name = "OUT_HOSP_RESCUE_NUM", columnDefinition = "NUMBER|出院患者中抢救人次||", length = 10, nullable = true)
	private Long outHospRescueNum;

	@Column(name = "RESCU_SUCCESS_NUM", columnDefinition = "NUMBER|抢救成功人次||", length = 10, nullable = true)
	private Long rescuSuccessNum;

	@Column(name = "RESCU_FAIL_NUM", columnDefinition = "NUMBER|抢救失败人次||", length = 10, nullable = true)
	private Long rescuFailNum;

	@Column(name = "ADMIT_DIAG_ACCORD_NUM", columnDefinition = "NUMBER|入院与出院诊断符合数||", length = 10, nullable = true)
	private Long admitDiagAccordNum;

	@Column(name = "INHOSP_OPERATE_NUM", columnDefinition = "NUMBER|住院手术例数||", length = 10, nullable = true)
	private Long inhospOperateNum;

	@Column(name = "OPERATE_ACCORD_NUM", columnDefinition = "NUMBER|手术前后诊断符合数||", length = 10, nullable = true)
	private Long operateAccordNum;

	@Column(name = "OPERATE_DISAGREE_NUM", columnDefinition = "NUMBER|手术前后诊断不符合数||", length = 10, nullable = true)
	private Long operateDisagreeNum;

	@Column(name = "PATHOLOGICAL_SECTION_TIME", columnDefinition = "NUMBER|临床与病理中切片次数||", length = 10, nullable = true)
	private Long pathologicalSectionTime;

	@Column(name = "PATHOLOGICAL_ACCORD_NUM", columnDefinition = "NUMBER|临床与病理中切片符合数||", length = 10, nullable = true)
	private Long pathologicalAccordNum;

	@Column(name = "PATHOLOGICAL_DISAGREE_NUM", columnDefinition = "NUMBER|临床与病理中切片不符合数||", length = 10, nullable = true)
	private Long pathologicalDisagreeNum;

	@Column(name = "IN_HOS_OPERATION_FEE", columnDefinition = "NUMBER|住院手术收入||", length = 10, nullable = true)
	private BigDecimal inHosOperationFee;

	@Column(name = "INPATIENT_MEDICAL_RECORD_NUM", columnDefinition = "NUMBER|病案数||", length = 10, nullable = true)
	private Long inpatientMedicalRecordNum;

	@Column(name = "CREATE_DATE", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createDate;

	@Column(name = "UPDATE_DATE", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date updateDate;

	@Column(name = "INTEGRATION_DATE", columnDefinition = "DATE|集成时间||", nullable = true)
	private Date integrationDate;

	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除标志||", length = 1, nullable = true)
	private Long isDelete;

	@Column(name = "OUT_HOSP_BED", columnDefinition = "NUMBER|出院患者占床日||", length = 10, nullable = true)
	private Long outHospBed;

	@Column(name = "ANTIBACTERIAL_NUM", columnDefinition = "NUMBER|出院患者使用抗菌药物总列数||", length = 10, nullable = true)
	private Long antibacterialNum;

	@Column(name = "IN_PERSONAL_FEE", columnDefinition = "NUMBER|个人承担费用||", length = 16, scale = 4, precision = 2, nullable = true)
	private BigDecimal inPersonalFee;

	@Column(name = "IN_INSURANCE_FEE", columnDefinition = "NUMBER|医保承担费用||", length = 16, scale = 4, precision = 2, nullable = true)
	private BigDecimal inInsuranceFee;

	@Transient
	private Double antibacterialRate;

	@Transient
	private Double medicinalFeePer;

	@Transient
	private Double avgFee;

	@Transient
	private String period;

	@Transient
	private Integer type;

	public BigDecimal getInHosOperationFee() {
		return inHosOperationFee;
	}

	public void setInHosOperationFee(BigDecimal inHosOperationFee) {
		this.inHosOperationFee = inHosOperationFee;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public BigDecimal getInPersonalFee() {
		return inPersonalFee;
	}

	public void setInPersonalFee(BigDecimal inPersonalFee) {
		this.inPersonalFee = inPersonalFee;
	}

	public BigDecimal getInInsuranceFee() {
		return inInsuranceFee;
	}

	public void setInInsuranceFee(BigDecimal inInsuranceFee) {
		this.inInsuranceFee = inInsuranceFee;
	}

	public Long getAntibacterialNum() {
		return antibacterialNum;
	}

	public void setAntibacterialNum(Long antibacterialNum) {
		this.antibacterialNum = antibacterialNum;
	}

	public Double getAntibacterialRate() {
		return antibacterialRate;
	}

	public void setAntibacterialRate(Double antibacterialRate) {
		this.antibacterialRate = antibacterialRate;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public Double getMedicinalFeePer() {
		return medicinalFeePer;
	}

	public void setMedicinalFeePer(Double medicinalFeePer) {
		this.medicinalFeePer = medicinalFeePer;
	}

	public Double getAvgFee() {
		return avgFee;
	}

	public void setAvgFee(Double avgFee) {
		this.avgFee = avgFee;
	}

	public Long getOutHospBed() {
		return outHospBed;
	}

	public void setOutHospBed(Long outHospBed) {
		this.outHospBed = outHospBed;
	}

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

	public Long getInHospitalNum() {
		return this.inHospitalNum;
	}

	public void setInHospitalNum(Long inHospitalNum) {
		this.inHospitalNum = inHospitalNum;
	}

	public Long getCriticalIllNum() {
		return this.criticalIllNum;
	}

	public void setCriticalIllNum(Long criticalIllNum) {
		this.criticalIllNum = criticalIllNum;
	}

	public Long getLeaveHospitalNum() {
		return this.leaveHospitalNum;
	}

	public void setLeaveHospitalNum(Long leaveHospitalNum) {
		this.leaveHospitalNum = leaveHospitalNum;
	}

	public Long getLeaveHosCureNum() {
		return this.leaveHosCureNum;
	}

	public void setLeaveHosCureNum(Long leaveHosCureNum) {
		this.leaveHosCureNum = leaveHosCureNum;
	}

	public Long getLeaveHosImproveNum() {
		return this.leaveHosImproveNum;
	}

	public void setLeaveHosImproveNum(Long leaveHosImproveNum) {
		this.leaveHosImproveNum = leaveHosImproveNum;
	}

	public Long getInHosDayNum() {
		return this.inHosDayNum;
	}

	public void setInHosDayNum(Long inHosDayNum) {
		this.inHosDayNum = inHosDayNum;
	}

	public BigDecimal getInHosFee() {
		return this.inHosFee;
	}

	public void setInHosFee(BigDecimal inHosFee) {
		this.inHosFee = inHosFee;
	}

	public BigDecimal getInHosMedicinalFee() {
		return this.inHosMedicinalFee;
	}

	public void setInHosMedicinalFee(BigDecimal inHosMedicinalFee) {
		this.inHosMedicinalFee = inHosMedicinalFee;
	}

	public BigDecimal getInHosMedicalFee() {
		return this.inHosMedicalFee;
	}

	public void setInHosMedicalFee(BigDecimal inHosMedicalFee) {
		this.inHosMedicalFee = inHosMedicalFee;
	}

	public BigDecimal getInHosCheckFee() {
		return this.inHosCheckFee;
	}

	public void setInHosCheckFee(BigDecimal inHosCheckFee) {
		this.inHosCheckFee = inHosCheckFee;
	}

	public BigDecimal getInHosTestFee() {
		return this.inHosTestFee;
	}

	public void setInHosTestFee(BigDecimal inHosTestFee) {
		this.inHosTestFee = inHosTestFee;
	}

	public BigDecimal getInHosNurseFee() {
		return this.inHosNurseFee;
	}

	public void setInHosNurseFee(BigDecimal inHosNurseFee) {
		this.inHosNurseFee = inHosNurseFee;
	}

	public BigDecimal getInHosBedFee() {
		return this.inHosBedFee;
	}

	public void setInHosBedFee(BigDecimal inHosBedFee) {
		this.inHosBedFee = inHosBedFee;
	}

	public Long getUseBedNum() {
		return this.useBedNum;
	}

	public void setUseBedNum(Long useBedNum) {
		this.useBedNum = useBedNum;
	}

	public Long getOpenBedNum() {
		return this.openBedNum;
	}

	public void setOpenBedNum(Long openBedNum) {
		this.openBedNum = openBedNum;
	}

	public Long getOutHospHealedNum() {
		return this.outHospHealedNum;
	}

	public void setOutHospHealedNum(Long outHospHealedNum) {
		this.outHospHealedNum = outHospHealedNum;
	}

	public Long getOutHospDiedNum() {
		return this.outHospDiedNum;
	}

	public void setOutHospDiedNum(Long outHospDiedNum) {
		this.outHospDiedNum = outHospDiedNum;
	}

	public Long getOutHospInsuranceNum() {
		return this.outHospInsuranceNum;
	}

	public void setOutHospInsuranceNum(Long outHospInsuranceNum) {
		this.outHospInsuranceNum = outHospInsuranceNum;
	}

	public Long getOutHospInhospFee() {
		return this.outHospInhospFee;
	}

	public void setOutHospInhospFee(Long outHospInhospFee) {
		this.outHospInhospFee = outHospInhospFee;
	}

	public Long getOutHospInhospDays() {
		return this.outHospInhospDays;
	}

	public void setOutHospInhospDays(Long outHospInhospDays) {
		this.outHospInhospDays = outHospInhospDays;
	}

	public Long getBedPerDay() {
		return this.bedPerDay;
	}

	public void setBedPerDay(Long bedPerDay) {
		this.bedPerDay = bedPerDay;
	}

	public Long getOutHosp3day() {
		return this.outHosp3day;
	}

	public void setOutHosp3day(Long outHosp3day) {
		this.outHosp3day = outHosp3day;
	}

	public Long getClinicDiagAccordNum() {
		return this.clinicDiagAccordNum;
	}

	public void setClinicDiagAccordNum(Long clinicDiagAccordNum) {
		this.clinicDiagAccordNum = clinicDiagAccordNum;
	}

	public Long getOutHospRescueNum() {
		return this.outHospRescueNum;
	}

	public void setOutHospRescueNum(Long outHospRescueNum) {
		this.outHospRescueNum = outHospRescueNum;
	}

	public Long getRescuSuccessNum() {
		return this.rescuSuccessNum;
	}

	public void setRescuSuccessNum(Long rescuSuccessNum) {
		this.rescuSuccessNum = rescuSuccessNum;
	}

	public Long getRescuFailNum() {
		return this.rescuFailNum;
	}

	public void setRescuFailNum(Long rescuFailNum) {
		this.rescuFailNum = rescuFailNum;
	}

	public Long getAdmitDiagAccordNum() {
		return this.admitDiagAccordNum;
	}

	public void setAdmitDiagAccordNum(Long admitDiagAccordNum) {
		this.admitDiagAccordNum = admitDiagAccordNum;
	}

	public Long getInhospOperateNum() {
		return this.inhospOperateNum;
	}

	public void setInhospOperateNum(Long inhospOperateNum) {
		this.inhospOperateNum = inhospOperateNum;
	}

	public Long getOperateAccordNum() {
		return this.operateAccordNum;
	}

	public void setOperateAccordNum(Long operateAccordNum) {
		this.operateAccordNum = operateAccordNum;
	}

	public Long getOperateDisagreeNum() {
		return this.operateDisagreeNum;
	}

	public void setOperateDisagreeNum(Long operateDisagreeNum) {
		this.operateDisagreeNum = operateDisagreeNum;
	}

	public Long getPathologicalSectionTime() {
		return this.pathologicalSectionTime;
	}

	public void setPathologicalSectionTime(Long pathologicalSectionTime) {
		this.pathologicalSectionTime = pathologicalSectionTime;
	}

	public Long getPathologicalAccordNum() {
		return this.pathologicalAccordNum;
	}

	public void setPathologicalAccordNum(Long pathologicalAccordNum) {
		this.pathologicalAccordNum = pathologicalAccordNum;
	}

	public Long getPathologicalDisagreeNum() {
		return this.pathologicalDisagreeNum;
	}

	public void setPathologicalDisagreeNum(Long pathologicalDisagreeNum) {
		this.pathologicalDisagreeNum = pathologicalDisagreeNum;
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

	public Date getIntegrationDate() {
		return this.integrationDate;
	}

	public void setIntegrationDate(Date integrationDate) {
		this.integrationDate = integrationDate;
	}

	public Long getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Long isDelete) {
		this.isDelete = isDelete;
	}

	public Long getSickbedCount() {
		return sickbedCount;
	}

	public void setSickbedCount(Long sickbedCount) {
		this.sickbedCount = sickbedCount;
	}

	public Long getAnesthesiaNum() {
		return anesthesiaNum;
	}

	public void setAnesthesiaNum(Long anesthesiaNum) {
		this.anesthesiaNum = anesthesiaNum;
	}

	public Long getInpatientMedicalRecordNum() {
		return inpatientMedicalRecordNum;
	}

	public void setInpatientMedicalRecordNum(Long inpatientMedicalRecordNum) {
		this.inpatientMedicalRecordNum = inpatientMedicalRecordNum;
	}
}