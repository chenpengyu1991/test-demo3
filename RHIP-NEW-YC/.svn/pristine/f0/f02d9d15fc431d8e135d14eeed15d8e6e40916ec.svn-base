package com.founder.rhip.ehr.entity.ihm;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "RP_HM_OUTPATIENT")
public class HmOutpatient implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
    private Long id;

    @Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|医疗机构编码||", length = 20, nullable = true)
    private String organCode;

    @Column(name = "SUP_ORG_CODE", columnDefinition = "VARCHAR2|上级医疗机构编码||", length = 20, nullable = true)
    private String supOrgCode;

    @Column(name = "REG_NUM", columnDefinition = "NUMBER|挂号人次||", length = 10, nullable = true)
    private Long regNum;

    @Column(name = "OUTPATIENT_NUM", columnDefinition = "NUMBER|门诊人次||", length = 10, nullable = true)
    private Long outpatientNum;

    @Column(name = "EMERGENCY_NUM", columnDefinition = "NUMBER|急诊人次||", length = 10, nullable = true)
    private Long emergencyNum;

    @Column(name = "TREATMENT_NUM", columnDefinition = "NUMBER|就诊人次数||", length = 10, nullable = true)
    private Long treatmentNum;

    @Column(name = "STAY_NUM", columnDefinition = "NUMBER|留观人次数||", length = 10, nullable = true)
    private Long stayNum;

    @Column(name = "OUTPATIENT_FEE", columnDefinition = "NUMBER|急诊费用||", length = 16, scale = 4, precision = 2, nullable = true)
    private BigDecimal outpatientFee;

    @Column(name = "EMERGENCY_FEE", columnDefinition = "NUMBER|门诊费用||", length = 16, scale = 4, precision = 2, nullable = true)
    private BigDecimal emergencyFee;

    @Column(name = "OUTPATIENT_MEDICINAL_FEE", columnDefinition = "NUMBER|门诊药品费||", length = 16, scale = 4, precision = 2, nullable = true)
    private BigDecimal outpatientMedicinalFee;

    @Column(name = "OUTPATIENT_MEDICAL_FEE", columnDefinition = "NUMBER|门诊医疗费||", length = 16, scale = 4, precision = 2, nullable = true)
    private BigDecimal outpatientMedicalFee;

    @Column(name = "OUTPATIENT_CHECK_FEE", columnDefinition = "NUMBER|门诊检查费||", length = 16, scale = 4, precision = 2, nullable = true)
    private BigDecimal outpatientCheckFee;

    @Column(name = "OUTPATIENT_TEST_FEE", columnDefinition = "NUMBER|门诊检验费||", length = 16, scale = 4, precision = 2, nullable = true)
    private BigDecimal outpatientTestFee;

    @Column(name = "EMERGENCY_MEDICINAL_FEE", columnDefinition = "NUMBER|急诊药品费||", length = 16, scale = 4, precision = 2, nullable = true)
    private BigDecimal emergencyMedicinalFee;

    @Column(name = "EMERGENCY_MEDICAL_FEE", columnDefinition = "NUMBER|急诊医疗费||", length = 16, scale = 4, precision = 2, nullable = true)
    private BigDecimal emergencyMedicalFee;

    @Column(name = "EMERGENCY_CHECK_FEE", columnDefinition = "NUMBER|急诊检查费||", length = 16, scale = 4, precision = 2, nullable = true)
    private BigDecimal emergencyCheckFee;

    @Column(name = "EMERGENCY_TEST_FEE", columnDefinition = "NUMBER|急诊检验费||", length = 16, scale = 4, precision = 2, nullable = true)
    private BigDecimal emergencyTestFee;

    @Column(name = "EXPERT_TREAT_NUM", columnDefinition = "NUMBER|专家总诊疗人数||", length = 10, nullable = true)
    private Long expertTreatNum;

    @Column(name = "EXPERT_DAY", columnDefinition = "NUMBER|专家接诊总天数||", length = 10, nullable = true)
    private Long expertDay;

    @Column(name = "EXPERT_NUM", columnDefinition = "NUMBER|专家数||", length = 10, nullable = true)
    private Long expertNum;

    @Column(name = "OUTPATI_OPERATE_NUM", columnDefinition = "NUMBER|门诊手术例数||", length = 10, nullable = true)
    private Long outpatiOperateNum;

    @Column(name = "ANTIBIOTIC_OP_NUM", columnDefinition = "NUMBER|门诊抗生素处方数||", length = 10, nullable = true)
    private Long antibioticOpNum;

    @Column(name = "ANTIBIOTIC_EOP_NUM", columnDefinition = "NUMBER|急诊抗生素处方数||", length = 10, nullable = true)
    private Long antibioticEopNum;

    @Column(name = "ANTIBIOTIC_2_NUM", columnDefinition = "NUMBER|两联及以上抗生素处方数||", length = 10, nullable = true)
    private Long antibiotic2Num;

    @Column(name = "CREATE_DATE", columnDefinition = "DATE|创建时间||", nullable = true)
    private Date createDate;

    @Column(name = "UPDATE_DATE", columnDefinition = "DATE|更新时间||", nullable = true)
    private Date updateDate;

    @Column(name = "INTEGRATION_DATE", columnDefinition = "DATE|集成时间||", nullable = true)
    private Date integrationDate;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除标志||", length = 1, nullable = true)
    private Long isDelete;

    @Column(name = "INFUSION_NUM", columnDefinition = "NUMBER|门急诊输液处方人次||", length = 1, nullable = true)
    private Long infusionNum;

    @Column(name = "PRESCRIPTION_COUNT", columnDefinition = "NUMBER||门诊包含处方数", length = 5, nullable = true)
    private Integer prescriptionCount;

    @Transient
    private Double argOutpEmergencyFee;

    @Column(name = "OUTPATIENT_PERSONAL_FEE", columnDefinition = "NUMBER|门诊个人承担费用||", length = 16, scale = 4, precision = 2, nullable = true)
    private BigDecimal outpatientPersonalFee;

    @Column(name = "OUTPATIENT_INSURANCE_FEE", columnDefinition = "NUMBER|门诊医保承担费用||", length = 16, scale = 4, precision = 2, nullable = true)
    private BigDecimal outpatientInsuranceFee;

    @Column(name = "EMERGENCY_PERSONAL_FEE", columnDefinition = "NUMBER|急诊个人承担费用||", length = 16, scale = 4, precision = 2, nullable = true)
    private BigDecimal emergencyPersonalFee;

    @Column(name = "EMERGENCY_INSURANCE_FEE", columnDefinition = "NUMBER|急诊医保承担费用||", length = 16, scale = 4, precision = 2, nullable = true)
    private BigDecimal emergencyInsuranceFee;

    @Column(name = "COOPERATIVE_MEDICAL_FEE", columnDefinition = "NUMBER|新型农村合作医疗||",  scale = 10, precision = 2, nullable = true)
    private BigDecimal cooperativeMedicalFee;

    @Column(name = "OUTPATIENT_OPERATION_FEE", columnDefinition = "NUMBER|门诊手术收入||", length = 16, scale = 4, precision = 2, nullable = true)
    private BigDecimal outpatientOperationFee;
    
    @Column(name = "EMERGENCY_OPERATION_FEE", columnDefinition = "NUMBER|急诊手术收入||", length = 16, scale = 4, precision = 2, nullable = true)
    private BigDecimal emergencyOperationFee;
    
    @Transient
    private BigDecimal allFee;

    @Transient
    private String period;

    @Transient
    private Double medicinalFeePer;

    @Transient
    private Double infusionRate;

    @Transient
    private Double antibioticRate;

    @Transient
    private BigDecimal allNum;//门急诊人数

    @Transient
    private BigDecimal medicinalFee;//药品费用

    @Transient
    private BigDecimal personalFee;//个人承担费用

    @Transient
    private BigDecimal insuranceFee;//医疗保险费用

    @Transient
    private Integer type;

    public BigDecimal getOutpatientOperationFee() {
		return outpatientOperationFee;
	}

	public void setOutpatientOperationFee(BigDecimal outpatientOperationFee) {
		this.outpatientOperationFee = outpatientOperationFee;
	}

	public BigDecimal getEmergencyOperationFee() {
		return emergencyOperationFee;
	}

	public void setEmergencyOperationFee(BigDecimal emergencyOperationFee) {
		this.emergencyOperationFee = emergencyOperationFee;
	}

	public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getOutpatientPersonalFee() {
        return outpatientPersonalFee;
    }

    public void setOutpatientPersonalFee(BigDecimal outpatientPersonalFee) {
        this.outpatientPersonalFee = outpatientPersonalFee;
    }

    public BigDecimal getOutpatientInsuranceFee() {
        return outpatientInsuranceFee;
    }

    public void setOutpatientInsuranceFee(BigDecimal outpatientInsuranceFee) {
        this.outpatientInsuranceFee = outpatientInsuranceFee;
    }

    public BigDecimal getEmergencyPersonalFee() {
        return emergencyPersonalFee;
    }

    public void setEmergencyPersonalFee(BigDecimal emergencyPersonalFee) {
        this.emergencyPersonalFee = emergencyPersonalFee;
    }

    public BigDecimal getEmergencyInsuranceFee() {
        return emergencyInsuranceFee;
    }

    public void setEmergencyInsuranceFee(BigDecimal emergencyInsuranceFee) {
        this.emergencyInsuranceFee = emergencyInsuranceFee;
    }

    public Double getAntibioticRate() {
        return antibioticRate;
    }

    public void setAntibioticRate(Double antibioticRate) {
        this.antibioticRate = antibioticRate;
    }

    public Double getInfusionRate() {
        return infusionRate;
    }

    public void setInfusionRate(Double infusionRate) {
        this.infusionRate = infusionRate;
    }

    public Long getInfusionNum() {
        return infusionNum;
    }

    public void setInfusionNum(Long infusionNum) {
        this.infusionNum = infusionNum;
    }

    public Double getMedicinalFeePer() {
        return medicinalFeePer;
    }

    public void setMedicinalFeePer(Double medicinalFeePer) {
        this.medicinalFeePer = medicinalFeePer;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Double getArgOutpEmergencyFee() {
        return argOutpEmergencyFee;
    }

    public void setArgOutpEmergencyFee(Double argOutpEmergencyFee) {
        this.argOutpEmergencyFee = argOutpEmergencyFee;
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

    public Long getOutpatientNum() {
        return this.outpatientNum;
    }

    public void setOutpatientNum(Long outpatientNum) {
        this.outpatientNum = outpatientNum;
    }

    public Long getEmergencyNum() {
        return this.emergencyNum;
    }

    public void setEmergencyNum(Long emergencyNum) {
        this.emergencyNum = emergencyNum;
    }

    public BigDecimal getOutpatientFee() {
        return this.outpatientFee;
    }

    public void setOutpatientFee(BigDecimal outpatientFee) {
        this.outpatientFee = outpatientFee;
    }

    public BigDecimal getEmergencyFee() {
        return this.emergencyFee;
    }

    public void setEmergencyFee(BigDecimal emergencyFee) {
        this.emergencyFee = emergencyFee;
    }

    public BigDecimal getOutpatientMedicinalFee() {
        return this.outpatientMedicinalFee;
    }

    public void setOutpatientMedicinalFee(BigDecimal outpatientMedicinalFee) {
        this.outpatientMedicinalFee = outpatientMedicinalFee;
    }

    public BigDecimal getOutpatientMedicalFee() {
        return this.outpatientMedicalFee;
    }

    public void setOutpatientMedicalFee(BigDecimal outpatientMedicalFee) {
        this.outpatientMedicalFee = outpatientMedicalFee;
    }

    public BigDecimal getOutpatientCheckFee() {
        return this.outpatientCheckFee;
    }

    public void setOutpatientCheckFee(BigDecimal outpatientCheckFee) {
        this.outpatientCheckFee = outpatientCheckFee;
    }

    public BigDecimal getOutpatientTestFee() {
        return this.outpatientTestFee;
    }

    public void setOutpatientTestFee(BigDecimal outpatientTestFee) {
        this.outpatientTestFee = outpatientTestFee;
    }

    public BigDecimal getEmergencyMedicinalFee() {
        return this.emergencyMedicinalFee;
    }

    public void setEmergencyMedicinalFee(BigDecimal emergencyMedicinalFee) {
        this.emergencyMedicinalFee = emergencyMedicinalFee;
    }

    public BigDecimal getEmergencyMedicalFee() {
        return this.emergencyMedicalFee;
    }

    public void setEmergencyMedicalFee(BigDecimal emergencyMedicalFee) {
        this.emergencyMedicalFee = emergencyMedicalFee;
    }

    public BigDecimal getEmergencyCheckFee() {
        return this.emergencyCheckFee;
    }

    public void setEmergencyCheckFee(BigDecimal emergencyCheckFee) {
        this.emergencyCheckFee = emergencyCheckFee;
    }

    public BigDecimal getEmergencyTestFee() {
        return this.emergencyTestFee;
    }

    public void setEmergencyTestFee(BigDecimal emergencyTestFee) {
        this.emergencyTestFee = emergencyTestFee;
    }

    public Long getExpertTreatNum() {
        return this.expertTreatNum;
    }

    public void setExpertTreatNum(Long expertTreatNum) {
        this.expertTreatNum = expertTreatNum;
    }

    public Long getExpertDay() {
        return this.expertDay;
    }

    public void setExpertDay(Long expertDay) {
        this.expertDay = expertDay;
    }

    public Long getExpertNum() {
        return this.expertNum;
    }

    public void setExpertNum(Long expertNum) {
        this.expertNum = expertNum;
    }

    public Long getOutpatiOperateNum() {
        return this.outpatiOperateNum;
    }

    public void setOutpatiOperateNum(Long outpatiOperateNum) {
        this.outpatiOperateNum = outpatiOperateNum;
    }

    public Long getAntibioticOpNum() {
        return this.antibioticOpNum;
    }

    public void setAntibioticOpNum(Long antibioticOpNum) {
        this.antibioticOpNum = antibioticOpNum;
    }

    public Long getAntibioticEopNum() {
        return this.antibioticEopNum;
    }

    public void setAntibioticEopNum(Long antibioticEopNum) {
        this.antibioticEopNum = antibioticEopNum;
    }

    public Long getAntibiotic2Num() {
        return this.antibiotic2Num;
    }

    public void setAntibiotic2Num(Long antibiotic2Num) {
        this.antibiotic2Num = antibiotic2Num;
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

    public String getSupOrgCode() {
        return supOrgCode;
    }

    public void setSupOrgCode(String supOrgCode) {
        this.supOrgCode = supOrgCode;
    }

    public BigDecimal getAllFee() {
        return allFee;
    }

    public void setAllFee(BigDecimal allFee) {
        this.allFee = allFee;
    }

    public BigDecimal getAllNum() {
        return allNum;
    }

    public void setAllNum(BigDecimal allNum) {
        this.allNum = allNum;
    }

    public BigDecimal getMedicinalFee() {
        return medicinalFee;
    }

    public void setMedicinalFee(BigDecimal medicinalFee) {
        this.medicinalFee = medicinalFee;
    }

    public BigDecimal getPersonalFee() {
        return personalFee;
    }

    public void setPersonalFee(BigDecimal personalFee) {
        this.personalFee = personalFee;
    }

    public BigDecimal getInsuranceFee() {
        return insuranceFee;
    }

    public void setInsuranceFee(BigDecimal insuranceFee) {
        this.insuranceFee = insuranceFee;
    }

    public Long getTreatmentNum() {
        return treatmentNum;
    }

    public void setTreatmentNum(Long treatmentNum) {
        this.treatmentNum = treatmentNum;
    }

    public Long getStayNum() {
        return stayNum;
    }

    public void setStayNum(Long stayNum) {
        this.stayNum = stayNum;
    }

    public BigDecimal getCooperativeMedicalFee() {
        return cooperativeMedicalFee;
    }

    public void setCooperativeMedicalFee(BigDecimal cooperativeMedicalFee) {
        this.cooperativeMedicalFee = cooperativeMedicalFee;
    }

    public Integer getPrescriptionCount() {
        return prescriptionCount;
    }

    public void setPrescriptionCount(Integer prescriptionCount) {
        this.prescriptionCount = prescriptionCount;
    }

    public Long getRegNum() {
        return regNum;
    }

    public void setRegNum(Long regNum) {
        this.regNum = regNum;
    }
}