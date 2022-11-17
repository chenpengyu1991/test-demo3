package com.founder.rhip.ehr.entity.clinic;

import com.founder.rhip.ehr.annotation.RecordTrace;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "MS_DRUG_USAGE")
public class DrugUsage implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
    private Long personId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @RecordTrace
    @Column(name = "DRUG_GENERIC_NAME", columnDefinition = "VARCHAR2|药物通用名||", length = 50, nullable = true)
    private String drugGenericName;

    @Column(name = "DRUG_TRADE_NAME", columnDefinition = "VARCHAR2|药物商用名||", length = 50, nullable = true)
    private String drugTradeName;

    @Column(name = "DRUG_SPECIFICATIONS", columnDefinition = "VARCHAR2|药品规格||", length = 20, nullable = true)
    private String drugSpecifications;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = true)
    private String ehrId;

    @Column(name = "RECORD_NUMBER", columnDefinition = "VARCHAR2|处方号／记录表单编号||", length = 20, nullable = true)
    private String recordNumber;

    @Column(name = "ADMISSION_NO", columnDefinition = "VARCHAR2|住院号||", length = 10, nullable = true)
    private String admissionNo;

    @Column(name = "REFERRAL_HOSPITAL_CODE", columnDefinition = "VARCHAR2|创建机构代码||", length = 10, nullable = true)
    private String referralHospitalCode;

    @Column(name = "REFERRAL_HOSPITAL_NAME", columnDefinition = "VARCHAR2|创建机构名称||", length = 70, nullable = true)
    private String referralHospitalName;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 50, nullable = true)
    private String name;

    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别||", length = 1, nullable = true)
    private String gender;

    @Column(name = "AGE", columnDefinition = "VARCHAR2|年龄||", length = 20, nullable = true)
    private String age;

    @Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况||", length = 3, nullable = true)
    private String marriage;

    @Column(name = "CM_TYPE", columnDefinition = "VARCHAR2|中药类别代码||", length = 2, nullable = true)
    private String cmType;

    @Column(name = "DRUG_TYPE", columnDefinition = "VARCHAR2|药物类型||", length = 20, nullable = true)
    private String drugType;

    @Column(name = "DRUG_DOSAGE", columnDefinition = "VARCHAR2|药物剂型代码||", length = 2, nullable = true)
    private String drugDosage;

    @Column(name = "DRUG_USE_DAYS", columnDefinition = "NUMBER|用药天数||", length = 5, nullable = true)
    private Integer drugUseDays;

    @Column(name = "DRUG_USE_FREQUENCY", columnDefinition = "VARCHAR2|药物使用频率||", length = 20, nullable = true)
    private String drugUseFrequency;

    @Column(name = "DRUG_USE_DOSE_UNIT", columnDefinition = "VARCHAR2|药物使用剂量单位||", length = 6, nullable = true)
    private String drugUseDoseUnit;

    @Column(name = "DRUG_USE_ROUTE_CODE", columnDefinition = "VARCHAR2|药物使用途径代码||", length = 3, nullable = true)
    private String drugUseRouteCode;

    @Column(name = "DRUG_USE_ROUTE_NAME", columnDefinition = "VARCHAR2|药物使用途径||", length = 3, nullable = true)
    private String drugUseRouteName;

    @Column(name = "DRUG_USE_DOSE", columnDefinition = "VARCHAR2|药物使用次剂量||", length = 10, nullable = true)
    private String drugUseDose;

    @Column(name = "DRUG_USE_TOTAL_DOSE", columnDefinition = "NUMBER|药物使用总剂量||", scale = 12, precision = 2, nullable = true)
    private BigDecimal drugUseTotalDose;

    @RecordTrace
    @Column(name = "START_DATE", columnDefinition = "TIMESTAMP|用药开始日期时间||", nullable = true)
    private Date startDate;

    @RecordTrace
    @Column(name = "STOP_DATE", columnDefinition = "TIMESTAMP|用药停止日期时间||", nullable = true)
    private Date stopDate;

    @Column(name = "DOCTOR_ADVICE", columnDefinition = "VARCHAR2|医嘱说明||", length = 200, nullable = true)
    private String doctorAdvice;

    @Column(name = "MEDICATION_COMPLIANCE", columnDefinition = "VARCHAR2|服药依从性代码||", length = 1, nullable = true)
    private String medicationCompliance;

    @Column(name = "MEDICATION_COMPLIANCE_NAME", columnDefinition = "VARCHAR2|服药依从性||", length = 1, nullable = true)
    private String medicationComplianceName;

    @Column(name = "PRODUCTION_UNIT_NAME", columnDefinition = "VARCHAR2|生产单位名称||", length = 50, nullable = true)
    private String productionUnitName;

    @Column(name = "EXECUTE_MARK", columnDefinition = "CHAR|执行标记||", length = 1, nullable = true)
    private String executeMark;

    @Column(name = "EXECUTE_FREQUENCY", columnDefinition = "VARCHAR2|执行频度文字描述||", length = 200, nullable = true)
    private String executeFrequency;

    @Column(name = "EXECUTE_RESULT", columnDefinition = "VARCHAR2|执行结果||", length = 200, nullable = true)
    private String executeResult;

    @Column(name = "UNIT_PRICE", columnDefinition = "NUMBER|单价||", scale = 5, precision = 2, nullable = true)
    private BigDecimal unitPrice;

    @Column(name = "SUBTOTAL", columnDefinition = "NUMBER|小计||", scale = 8, precision = 2, nullable = true)
    private BigDecimal subtotal;

    @Column(name = "REMARKS", columnDefinition = "VARCHAR2|备注||", length = 200, nullable = true)
    private String remarks;

    @Column(name = "FILL_USER_NAME", columnDefinition = "VARCHAR2|填报人姓名||", length = 50, nullable = true)
    private String fillUserName;

    @Column(name = "FILL_USER_IDCARD", columnDefinition = "VARCHAR2|填报身份证号||", length = 18, nullable = true)
    private String fillUserIdCard;

    @Column(name = "FILL_TIME", columnDefinition = "TIMESTAMP|填报日期时间||", nullable = true)
    private Date fillTime;

    @Column(name = "UPDATE_NAME", columnDefinition = "VARCHAR2|更新人姓名||", length = 50, nullable = true)
    private String updateName;

    @Column(name = "UPDATE_IDCARD", columnDefinition = "VARCHAR2|更新人身份证号||", length = 18, nullable = true)
    private String updateIdcard;

    @Column(name = "UPDATE_DATE", columnDefinition = "TIMESTAMP|更新日期和时间||", nullable = true)
    private Date updateDate;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;
    
    @Column(name = "BASE_DRUG_CODE", columnDefinition = "VARCHAR2|基药药品编码||", length = 50, nullable = true)
    private String baseDrugCode;
    
    @Column(name = "INTERNAL_DRUG_CODE", columnDefinition = "VARCHAR2|内部药品编码||", length = 50, nullable = true)
    private String internalDrugCode; 
    
    @Column(name = "DRUG_MEDICARE_CODE", columnDefinition = "VARCHAR2|药品医保编码||", length = 50, nullable = true)
    private String drugMedicareCode;
    
    @Column(name = "DRUG_AGRICULTURAL_CODE", columnDefinition = "VARCHAR2|药品农保编码||", length = 50, nullable = true)
    private String drugAgriculturalCode;
    
    @Column(name = "QUANTITY", columnDefinition = "NUMBER|药物数量||", scale = 8, precision = 2, nullable = true)
    private BigDecimal quantity;
    
    @Column(name = "QUANTITY_UNIT", columnDefinition = "VARCHAR2|药物数量单位||", length = 50, nullable = true)
    private String quantityUnit;
    
    @RecordTrace
    @Column(name = "DRUG_USE_STATE", columnDefinition = "VARCHAR2|药物使用情况(健康档案专用)||", length = 20, nullable = true)
    private String drugUseState;
    
	@Column(name = "DOCTOR_NO", columnDefinition = "VARCHAR2|责任医师编码||", length = 50, nullable = true)
	private String doctorNo;

	@Column(name = "DOCTOR_NAME", columnDefinition = "VARCHAR2|责任医师姓名||", length = 50, nullable = true)
	private String doctorName;

	@Column(name = "CLINIC_DATE", columnDefinition = "TIMESTAMP|处方开具时间||", nullable = true)
	private Date clinicDate;

	@Column(name = "CLINIC_MARK", columnDefinition = "NUMBER|门诊/急诊/住院标志||", length = 1, nullable = true)
	private Long clinicMark;

	@Column(name = "EXPENSE_TYPE", columnDefinition = "NUMBER|药品/耗材/处置等标志||", length = 1, nullable = true)
	private Long expenseType;

	@Column(name = "BATCH_NO", columnDefinition = "VARCHAR2|批次号||", length = 50, nullable = true)
	private String batchNo;

	@Column(name = "IF_CHARGE", columnDefinition = "VARCHAR2|是否收费标志||", length = 1, nullable = true)
	private String ifCharge;

	@Column(name = "BEGIN_TIME", columnDefinition = "TIMESTAMP|医嘱执行时间||", nullable = true)
	private Date beginTime;

	@Column(name = "ODRISU_DT", columnDefinition = "TIMESTAMP|医嘱下达时间||", nullable = true)
	private Date odrisuDt;

	@Column(name = "ODR_TYPE", columnDefinition = "VARCHAR2|医嘱类型（临时医嘱、长期医嘱）||", length = 1, nullable = true)
	private String odrType;

	@Column(name = "STOP_DT", columnDefinition = "TIMESTAMP|停止医嘱时间||", nullable = true)
	private Date stopDt;

	@Column(name = "STPDOC_IDCARD", columnDefinition = "VARCHAR2|停止医嘱医生||", length = 18, nullable = true)
	private String stpdocIdcard;
	
	@Column(name = "PROCESS_STATUS", columnDefinition = "VARCHAR2|处理状态||", length = 1, nullable = true)
	private String processStatus = "0";

    @Column(name = "IS_LIMIT", columnDefinition = "VARCHAR2|是否限制||", length = 1, nullable = true)
    private String isLimit;

    @Column(name = "BASE_DRUG_FLAG", columnDefinition = "VARCHAR2|0非基药，1基药||", length = 1, nullable = true)
    private String baseDrugFlag;
    
    @Column(name = "ANTIBACTERIALS_FLAG", columnDefinition = "VARCHAR2|抗菌药物标志-0非抗菌药物，1抗菌药物||", length = 1, nullable = true)
    private String antibacterialsFlag;
    
    @Column(name = "ANTIBIOTIC_FLAG", columnDefinition = "VARCHAR2|抗生素标志-0非抗生素，1抗生素||", length = 1, nullable = true)
    private String antibioticFlag;

    @Column(name = "NARCOTIC_FLAG", columnDefinition = "VARCHAR2|麻醉药品标志-0非麻醉，1麻醉||", length = 1, nullable = true)
    private String narcoticFlag;

    @Column(name = "TOXIC_FLAG", columnDefinition = "VARCHAR2|毒性药品标志-0非毒性，1毒性||", length = 1, nullable = true)
    private String toxicFlag;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getEhrId() {
        return this.ehrId;
    }

    public void setEhrId(String ehrId) {
        this.ehrId = ehrId;
    }

    public String getAdmissionNo() {
        return this.admissionNo;
    }

    public void setAdmissionNo(String admissionNo) {
        this.admissionNo = admissionNo;
    }

    public String getReferralHospitalCode() {
        return this.referralHospitalCode;
    }

    public void setReferralHospitalCode(String referralHospitalCode) {
        this.referralHospitalCode = referralHospitalCode;
    }

    public String getReferralHospitalName() {
        return this.referralHospitalName;
    }

    public void setReferralHospitalName(String referralHospitalName) {
        this.referralHospitalName = referralHospitalName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

	public String getAge() {
		return age;
	}
	
	public void setAge(String age) {
		this.age = age;
	}

	public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getCmType() {
        return this.cmType;
    }

    public void setCmType(String cmType) {
        this.cmType = cmType;
    }

    public String getDrugType() {
        return this.drugType;
    }

    public void setDrugType(String drugType) {
        this.drugType = drugType;
    }

    public String getDrugDosage() {
        return this.drugDosage;
    }

    public void setDrugDosage(String drugDosage) {
        this.drugDosage = drugDosage;
    }

    public Integer getDrugUseDays() {
        return this.drugUseDays;
    }

    public void setDrugUseDays(Integer drugUseDays) {
        this.drugUseDays = drugUseDays;
    }

    public String getDrugUseFrequency() {
        return this.drugUseFrequency;
    }

    public void setDrugUseFrequency(String drugUseFrequency) {
        this.drugUseFrequency = drugUseFrequency;
    }

    public String getDrugUseDoseUnit() {
        return this.drugUseDoseUnit;
    }

    public void setDrugUseDoseUnit(String drugUseDoseUnit) {
        this.drugUseDoseUnit = drugUseDoseUnit;
    }

    public String getDrugUseDose() {
		return drugUseDose;
	}

	public void setDrugUseDose(String drugUseDose) {
		this.drugUseDose = drugUseDose;
	}

	public BigDecimal getDrugUseTotalDose() {
        return this.drugUseTotalDose;
    }

    public void setDrugUseTotalDose(BigDecimal drugUseTotalDose) {
        this.drugUseTotalDose = drugUseTotalDose;
    }

    public String getDrugUseRouteCode() {
        return this.drugUseRouteCode;
    }

    public void setDrugUseRouteCode(String drugUseRouteCode) {
        this.drugUseRouteCode = drugUseRouteCode;
    }

    public String getMedicationCompliance() {
        return medicationCompliance;
    }

    public void setMedicationCompliance(String medicationCompliance) {
        this.medicationCompliance = medicationCompliance;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStopDate() {
        return this.stopDate;
    }

    public void setStopDate(Date stopDate) {
        this.stopDate = stopDate;
    }

    public String getDrugGenericName() {
        return this.drugGenericName;
    }

    public void setDrugGenericName(String drugGenericName) {
        this.drugGenericName = drugGenericName;
    }

    public String getDrugTradeName() {
        return this.drugTradeName;
    }

    public void setDrugTradeName(String drugTradeName) {
        this.drugTradeName = drugTradeName;
    }

    public String getDrugSpecifications() {
        return this.drugSpecifications;
    }

    public void setDrugSpecifications(String drugSpecifications) {
        this.drugSpecifications = drugSpecifications;
    }

    public String getDoctorAdvice() {
        return this.doctorAdvice;
    }

    public void setDoctorAdvice(String doctorAdvice) {
        this.doctorAdvice = doctorAdvice;
    }

    public String getProductionUnitName() {
        return this.productionUnitName;
    }

    public void setProductionUnitName(String productionUnitName) {
        this.productionUnitName = productionUnitName;
    }

    public String getExecuteMark() {
        return this.executeMark;
    }

    public void setExecuteMark(String executeMark) {
        this.executeMark = executeMark;
    }

    public String getExecuteFrequency() {
        return this.executeFrequency;
    }

    public void setExecuteFrequency(String executeFrequency) {
        this.executeFrequency = executeFrequency;
    }

    public String getExecuteResult() {
        return this.executeResult;
    }

    public void setExecuteResult(String executeResult) {
        this.executeResult = executeResult;
    }

    public BigDecimal getUnitPrice() {
        return this.unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getSubtotal() {
        return this.subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getFillUserName() {
        return this.fillUserName;
    }

    public void setFillUserName(String fillUserName) {
        this.fillUserName = fillUserName;
    }

    public String getFillUserIdCard() {
        return this.fillUserIdCard;
    }

    public void setFillUserIdCard(String fillUserIdCard) {
        this.fillUserIdCard = fillUserIdCard;
    }

    public Date getFillTime() {
        return this.fillTime;
    }

    public void setFillTime(Date fillTime) {
        this.fillTime = fillTime;
    }

    public String getUpdateName() {
        return this.updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public String getUpdateIdcard() {
        return this.updateIdcard;
    }

    public void setUpdateIdcard(String updateIdcard) {
        this.updateIdcard = updateIdcard;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getDrugUseRouteName() {
        return drugUseRouteName;
    }

    public void setDrugUseRouteName(String drugUseRouteName) {
        this.drugUseRouteName = drugUseRouteName;
    }

    public String getMedicationComplianceName() {
        return medicationComplianceName;
    }

    public void setMedicationComplianceName(String medicationComplianceName) {
        this.medicationComplianceName = medicationComplianceName;
    }

	
	public String getBaseDrugCode() {
		return baseDrugCode;
	}

	
	public void setBaseDrugCode(String baseDrugCode) {
		this.baseDrugCode = baseDrugCode;
	}

	
	public String getInternalDrugCode() {
		return internalDrugCode;
	}

	
	public void setInternalDrugCode(String internalDrugCode) {
		this.internalDrugCode = internalDrugCode;
	}

	
	public String getDrugMedicareCode() {
		return drugMedicareCode;
	}

	
	public void setDrugMedicareCode(String drugMedicareCode) {
		this.drugMedicareCode = drugMedicareCode;
	}

	
	public String getDrugAgriculturalCode() {
		return drugAgriculturalCode;
	}

	
	public void setDrugAgriculturalCode(String drugAgriculturalCode) {
		this.drugAgriculturalCode = drugAgriculturalCode;
	}

	
	public BigDecimal getQuantity() {
		return quantity;
	}

	
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public String getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}

	public String getDrugUseState() {
		return drugUseState;
	}

	public void setDrugUseState(String drugUseState) {
		this.drugUseState = drugUseState;
	}

	public Date getClinicDate() {
		return clinicDate;
	}

	public void setClinicDate(Date clinicDate) {
		this.clinicDate = clinicDate;
	}

	public String getDoctorNo() {
		return doctorNo;
	}

	public void setDoctorNo(String doctorNo) {
		this.doctorNo = doctorNo;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public Long getClinicMark() {
		return clinicMark;
	}

	public void setClinicMark(Long clinicMark) {
		this.clinicMark = clinicMark;
	}

	public Long getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(Long expenseType) {
		this.expenseType = expenseType;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getIfCharge() {
		return ifCharge;
	}

	public void setIfCharge(String ifCharge) {
		this.ifCharge = ifCharge;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getOdrisuDt() {
		return odrisuDt;
	}

	public void setOdrisuDt(Date odrisuDt) {
		this.odrisuDt = odrisuDt;
	}

	public String getOdrType() {
		return odrType;
	}

	public void setOdrType(String odrType) {
		this.odrType = odrType;
	}

	public Date getStopDt() {
		return stopDt;
	}

	public void setStopDt(Date stopDt) {
		this.stopDt = stopDt;
	}

	public String getStpdocIdcard() {
		return stpdocIdcard;
	}

	public void setStpdocIdcard(String stpdocIdcard) {
		this.stpdocIdcard = stpdocIdcard;
	}

	
	public String getProcessStatus() {
		return processStatus;
	}

	
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	
	public String getIsLimit() {
		return isLimit;
	}

	
	public void setIsLimit(String isLimit) {
		this.isLimit = isLimit;
	}

	public String getBaseDrugFlag() {
		return baseDrugFlag;
	}

	public void setBaseDrugFlag(String baseDrugFlag) {
		this.baseDrugFlag = baseDrugFlag;
	}

	
	public String getAntibacterialsFlag() {
		return antibacterialsFlag;
	}

	
	public void setAntibacterialsFlag(String antibacterialsFlag) {
		this.antibacterialsFlag = antibacterialsFlag;
	}

	
	public String getAntibioticFlag() {
		return antibioticFlag;
	}

	
	public void setAntibioticFlag(String antibioticFlag) {
		this.antibioticFlag = antibioticFlag;
	}

    public String getNarcoticFlag() {
        return narcoticFlag;
    }

    public void setNarcoticFlag(String narcoticFlag) {
        this.narcoticFlag = narcoticFlag;
    }

    public String getToxicFlag() {
        return toxicFlag;
    }

    public void setToxicFlag(String toxicFlag) {
        this.toxicFlag = toxicFlag;
    }
}
