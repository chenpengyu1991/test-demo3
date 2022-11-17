package com.founder.rhip.ehr.entity.control;

import com.founder.rhip.ehr.annotation.RecordTrace;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "DC_VACCINATION_INFO")
public class VaccinationInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|PERSON号||", length = 11, nullable = true)
    private Long personId;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|EHR号||", length = 50, nullable = true)
    private String ehrId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "VACCINATION_FILE_NO", columnDefinition = "VARCHAR2|预防接种档案编号||", length = 18, nullable = true)
    private String vaccinationFileNo;
    
	@Column(name = "VACCINATION_CODE", columnDefinition = "VARCHAR2|预防接种卡号||", length = 18, nullable = true)
	private String vaccinationCode;

    @Column(name = "IMMUNE_TYPE_CODE", columnDefinition = "VARCHAR2|免疫类型代码||", length = 1, nullable = true)
    private String immuneTypeCode;

    @Column(name = "ADVERSE_SYMPTOM_CODE", columnDefinition = "VARCHAR2|疑似预防接种异常反应标志||", length = 50, nullable = true)
    private String adverseSymptomCode;

    @RecordTrace
    @Column(name = "VACCINE_NAME", columnDefinition = "VARCHAR2|疫苗名称||", length = 100, nullable = true)
    private String vaccineName;

    @Column(name = "IMMU_TYPE", columnDefinition = "VARCHAR2|接种性质||", length = 1, nullable = true)
    private String immuType;

    @Column(name = "IMMU_POSITION", columnDefinition = "VARCHAR2|接种部位||", length = 2, nullable = true)
    private String immuPosition;

    @Column(name = "IMMU_POSITIONCODE", columnDefinition = "VARCHAR2|接种部位代码||", length = 20, nullable = true)
    private String immuPositioncode;

    @Column(name = "IMMU_DOSES", columnDefinition = "VARCHAR2|接种剂次||", length = 1, nullable = true)
    private String immuDoses;

    @Column(name = "IMMU_TABOO", columnDefinition = "VARCHAR2|接种禁忌||", length = 100, nullable = true)
    private String immuTaboo;

    @Column(name = "IMMU_TABOOCODE", columnDefinition = "VARCHAR2|接种禁忌代码||", length = 1, nullable = true)
    private String immuTaboocode;

    @Column(name = "IMMU_UNIT_ID", columnDefinition = "VARCHAR2|接种机构代码||", length = 20, nullable = true)
    private String immuUnitId;

    @Column(name = "IMMU_UNIT_NAME", columnDefinition = "VARCHAR2|接种机构名称||", length = 70, nullable = true)
    private String immuUnitName;

    @Column(name = "ELECTRONIC_SUPERVISION_CODE", columnDefinition = "VARCHAR2|疫苗电子监管码||", length = 20, nullable = true)
    private String ElectronicSupervisionCode;

    @Column(name = "VACCINE_TYPE", columnDefinition = "VARCHAR2|疫苗种类||", length = 100, nullable = true)
    private String vaccineType;

    @Column(name = "VACCINE_LOT_NUMBER", columnDefinition = "VARCHAR2|疫苗批号||0", length = 30, nullable = true)
    private String vaccineLotNumber;

    @Column(name = "VACCINE_COMPANY_CODE", columnDefinition = "VARCHAR2|疫苗生产企业代码||", length = 2, nullable = true)
    private String vaccineCompanyCode;
    
    @Column(name = "VACCINE_ANOMALY_HISTORY", columnDefinition = "VARCHAR2|疫苗异常反应史||", length = 1000, nullable = true)
    private String vaccineAnomalyHistory;
  
	@RecordTrace
    @Column(name = "VACCINATION_DATE", columnDefinition = "DATE|疫苗接种日期||", nullable = true)
    private Date vaccinationDate;

    @Column(name = "VACCINATION_UNIT_CODE", columnDefinition = "VARCHAR2|疫苘接种单位代码||", length = 10, nullable = true)
    private String vaccinationUnitCode;

    @RecordTrace
    @Column(name = "VACCINATION_UNIT_NAME", columnDefinition = "VARCHAR2|疫苗接种单位名称||", length = 70, nullable = true)
    private String vaccinationUnitName;
    
	@Column(name = "VACCINE_COMPANY_NAME", columnDefinition = "VARCHAR2|疫苗生产企业名称||", length = 70, nullable = true)
	private String vaccineCompanyName;

    @Column(name = "VACCINATION_NAME", columnDefinition = "VARCHAR2|疫苗接种者姓名||", length = 30, nullable = true)
    private String vaccinationName;

    @Column(name = "VACCINATION_DOCTOR_NAME", columnDefinition = "VARCHAR2|疫苗接种医生姓名||", length = 50, nullable = true)
    private String vaccinationDoctorName;

    @Column(name = "VACCINE_MEASUREMENT", columnDefinition = "VARCHAR2|疫苗接种剂量||", nullable = true)
    private String vaccineMeasurement;

    @Column(name = "VACCINE_FACTORY", columnDefinition = "VARCHAR2|疫苗生产厂商||",  length = 100,nullable = true)
    private String vaccineFactory;
    
    @Column(name = "INOCULATION_TIMES", columnDefinition = "VARCHAR2|接种次数||", nullable = true)
    private String inoculationTimes;

    @Column(name = "VACCINATION_WEIGHT", columnDefinition = "VARCHAR2|患者体重||", nullable = true)
    private String vaccinationWeight;

    @Column(name = "VACCINATION_TYPE_NO", columnDefinition = "VARCHAR2|预防接种类型代码||", length = 1, nullable = true)
    private String vaccinationTypeNo;

    @Column(name = "SUSPECT_VACCINE_NAME", columnDefinition = "VARCHAR2|引起预防接种后不良反应的可疑疫苗名称代码||", length = 4, nullable = true)
    private String suspectVaccineName;

    @Column(name = "ADVERSE_PROCESS_RESULT", columnDefinition = "VARCHAR2|预防接种后不良反应处理结果||", length = 1000, nullable = true)
    private String adverseProcessResult;

    @Column(name = "ADVERSE_DATE", columnDefinition = "DATE|预防接种后不良反应发生日期||", nullable = true)
    private Date adverseDate;

    @Column(name = "ADVERSE_EVIDECE_CODE", columnDefinition = "VARCHAR2|预防接种后不良反应临床诊断代码||", length = 4, nullable = true)
    private String adverseEvideceCode;

    @Column(name = "WITHDRAWAL_FLAG", columnDefinition = "VARCHAR2|撤销标志||", length = 1, nullable = true)
    private String withdrawalsign;

    @Column(name = "EVACUATION_DATE", columnDefinition = "DATE|迁出日期||", nullable = true)
    private Date evacuationDate;

    @Column(name = "EVACUATION_CAUSE", columnDefinition = "VARCHAR2|迁出原因||", length = 100, nullable = true)
    private String evacuationCause;

    @Column(name = "IMMIGRATION_DATE", columnDefinition = "DATE|迁入日期||", nullable = true)
    private Date immigrationDate;

    @Column(name = "CREATE_CARD_NAME", columnDefinition = "VARCHAR2|建卡人姓名||", length = 50, nullable = true)
    private String createCardName;

	@Column(name = "CREATE_CARD_CODE", columnDefinition = "VARCHAR2|建卡人编号||", length = 50, nullable = true)
    private String createCardCode;

    @Column(name = "CREATE_CARD_DATE", columnDefinition = "DATE|建卡日期||", nullable = true)
    private Date createCardDate;
    
	@Column(name = "BACTERIN_NO", columnDefinition = "VARCHAR2|疫苗名称代码||", length = 4, nullable = true)
	private String bacterinNo;

	@Column(name = "CANCEL_DATE", columnDefinition = "DATE|取消时间||", nullable = true)
	private Date cancelDate;
	
	@Column(name = "CANCEL_REASON", columnDefinition = "VARCHAR2|取消原因||", length = 4, nullable = true)
	private String cancelReason;
	
	@Column(name = "EVALUATE", columnDefinition = "VARCHAR2|接种评价||", length = 500, nullable = true)
	private String evaluate;
	
	@Column(name = "FILL_ORGAN_NAME", columnDefinition = "VARCHAR2|填报机构名称||", length = 70, nullable = true)
	private String fillOrganName;
	
	@Column(name = "FILL_TIME", columnDefinition = "DATE|填报日期时间||", nullable = true)
	private Date fillTime;
	
	@Column(name = "FILL_USER_NAME", columnDefinition = "VARCHAR2|填报人姓名||", length = 50, nullable = true)
	private String fillUserName;
	
	@Column(name = "FREE_FLAG", columnDefinition = "VARCHAR2|是否免费||", length = 1, nullable = true)
	private String freeFlag;
	
	@Column(name = "IMMU_UNIT", columnDefinition = "VARCHAR2|门诊编码||", length = 20, nullable = true)
	private String immuUnit;
	
	@Column(name = "INPUT_DATE", columnDefinition = "DATE|建档日期和时间||", nullable = true)
	private Date inputDate;
	
	@Column(name = "INPUT_IDCARD", columnDefinition = "VARCHAR2|建档人身份证号||", length = 18, nullable = true)
	private String inputIdcard;
	
	@Column(name = "INPUT_MAN", columnDefinition = "VARCHAR2|建档人姓名||", length = 50, nullable = true)
	private String inputMan;
	
	@Column(name = "REMARK", columnDefinition = "VARCHAR2|备注||", length = 500, nullable = true)
	private String remark;
	
	@Column(name = "VACCINE_BATCH", columnDefinition = "VARCHAR2|批次||", length = 18, nullable = true)
	private String vaccineBatch;
	
	@Column(name = "VACCINE_DOSE", columnDefinition = "VARCHAR2|剂量||", length = 18, nullable = true)
	private String vaccineDose;
	
	@Column(name = "VACCINE_TOTAL_NEEDLE_TIMES", columnDefinition = "NUMBER|总针次||", length = 5, nullable = true)
	private Integer vaccineTotalNeedleTimes;
	
	@Column(name = "VACCINE_VALID_DATE", columnDefinition = "DATE|有效期||", nullable = true)
	private Date vaccineValidDate;
	
	@Column(name = "VACCINE_YEARS", columnDefinition = "VARCHAR2|年份||", length = 8, nullable = true)
	private String vaccineYears;
	
    @Column(name = "ADULT_SECONDARY_VACCINE", columnDefinition = "NUMBER|区分是不是成人二次疫苗（儿童为空）|", length = 1, nullable = true)
    private Integer adultSecondaryVaccine;
	
    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete = 0;
    
    @Column(name = "ANALYSIS_STATUS", columnDefinition = "VARCHAR2|是否分析处理状态||", length = 1, nullable = true)
    private String analysisStatus;
    
	@Column(name = "PROCESS_STATUS", columnDefinition = "VARCHAR2|处理状态||", length = 1, nullable = true)
	private String processStatus = "0";
	
	@Column(name = "OTHER_VACCINE_FACTORY", columnDefinition = "VARCHAR2|其他疫苗厂家||", length = 100, nullable = true)
	private String otherVaccineFactory;
	
	@Column(name = "VACCINATION_DOCTOR_CODE", columnDefinition = "VARCHAR2|疫苗接种医生编号||", length = 50, nullable = true)
	private String vaccinationDoctorCode;
	
	@Column(name = "IMMU_UNIT_ADDR", columnDefinition = "VARCHAR2|填报机构地址||", length = 200, nullable = true)
    private String immuUnitAddr;

    @Column(name = "IMMU_UNIT_TELE", columnDefinition = "VARCHAR2|填报机构电话||", length = 100, nullable = true)
    private String immuUnitTele;
    
    @Column(name = "CREATE_UNIT_ADDR", columnDefinition = "VARCHAR2|建卡机构地址||", length = 200, nullable = true)
    private String createUnitAddr;

    @Column(name = "CREATE_UNIT_NAME", columnDefinition = "VARCHAR2|建卡机构名称||", length = 200, nullable = true)
    private String createUnitName;
    
    @Column(name = "CREATE_UNIT_CODE", columnDefinition = "VARCHAR2|建卡机构代码||", length = 50, nullable = true)
    private String createUnitCode;
    
    // 23价疫苗增加字段开始   修改人：高飞  修改日期：20180402
    @Column(name = "VACCINE_SPEC", columnDefinition = "VARCHAR2|疫苗规格||", length = 2, nullable = true)
    private String vaccineSpec;
    
    @Column(name = "VACCINE_WAY", columnDefinition = "VARCHAR2|接种途径||", length = 2, nullable = true)
    private String vaccineWay;
    
    @Column(name = "FEE_FLAG", columnDefinition = "VARCHAR2|是否收费||", length = 2, nullable = true)
    private String feeFlag;
    
    @Column(name = "FEE", columnDefinition = "NUMBER|价格||", nullable = true)
    private BigDecimal fee;
    // 23价疫苗增加字段结束
    
	@Transient
    private VaccinationMgmt vaccinationMgmt;
    
	@Transient
    private String vaccinationDateDesc;
    
    @Transient
    private String inputDateDesc;
    
    @Transient
    private String immuneTypeCodeDesc;
    
    @Transient
    private String immuUnitId1;
    
    @Transient
    private String immuUnitName1;
    
    @Transient
    private String immuUnitId2;
    
    @Transient
    private String immuUnitAddr1;
    
    @Transient
    private String immuUnitName2;

    @Transient
    private String createCardDate1;

    public String getSuspectVaccineNameDesc() {
        return suspectVaccineNameDesc;
    }

    public void setSuspectVaccineNameDesc(String suspectVaccineNameDesc) {
        this.suspectVaccineNameDesc = suspectVaccineNameDesc;
    }

    public String getAdverseEvideceCodeDesc() {
        return adverseEvideceCodeDesc;
    }

    public void setAdverseEvideceCodeDesc(String adverseEvideceCodeDesc) {
        this.adverseEvideceCodeDesc = adverseEvideceCodeDesc;
    }

    //引起预防接种后不良反应的可疑疫苗名称
    @Transient
    private String suspectVaccineNameDesc;
    //预防接种后不良反应临床诊断名称
    @Transient
    private String adverseEvideceCodeDesc;
	
	public String getCreateCardCode() {
		return createCardCode;
	}

	public void setCreateCardCode(String createCardCode) {
		this.createCardCode = createCardCode;
	}
	
	public String getVaccinationDoctorCode() {
		return vaccinationDoctorCode;
	}

	public void setVaccinationDoctorCode(String vaccinationDoctorCode) {
		this.vaccinationDoctorCode = vaccinationDoctorCode;
	}

	public String getCreateCardDate1() {
		return createCardDate1;
	}

	public void setCreateCardDate1(String createCardDate1) {
		this.createCardDate1 = createCardDate1;
	}

    public String getImmuUnitAddr() {
		return immuUnitAddr;
	}

	public void setImmuUnitAddr(String immuUnitAddr) {
		this.immuUnitAddr = immuUnitAddr;
	}

	public String getImmuUnitId1() {
		return immuUnitId1;
	}

	public void setImmuUnitId1(String immuUnitId1) {
		this.immuUnitId1 = immuUnitId1;
	}

	public String getImmuUnitName1() {
		return immuUnitName1;
	}

	public void setImmuUnitName1(String immuUnitName1) {
		this.immuUnitName1 = immuUnitName1;
	}

	public String getImmuUnitId2() {
		return immuUnitId2;
	}

	public void setImmuUnitId2(String immuUnitId2) {
		this.immuUnitId2 = immuUnitId2;
	}

	public String getImmuUnitAddr1() {
		return immuUnitAddr1;
	}

	public void setImmuUnitAddr1(String immuUnitAddr1) {
		this.immuUnitAddr1 = immuUnitAddr1;
	}

	public String getImmuUnitName2() {
		return immuUnitName2;
	}

	public void setImmuUnitName2(String immuUnitName2) {
		this.immuUnitName2 = immuUnitName2;
	}

	public String getImmuUnitTele() {
		return immuUnitTele;
	}

	public void setImmuUnitTele(String immuUnitTele) {
		this.immuUnitTele = immuUnitTele;
	}

	public String getVaccinationFileNo() {
        return this.vaccinationFileNo;
    }

    public void setVaccinationFileNo(String vaccinationFileNo) {
        this.vaccinationFileNo = vaccinationFileNo;
    }

    public String getImmuneTypeCode() {
        return this.immuneTypeCode;
    }

    public void setImmuneTypeCode(String immuneTypeCode) {
        this.immuneTypeCode = immuneTypeCode;
    }

    public String getAdverseSymptomCode() {
        return this.adverseSymptomCode;
    }

    public void setAdverseSymptomCode(String adverseSymptomCode) {
        this.adverseSymptomCode = adverseSymptomCode;
    }

    public String getImmuType() {
        return this.immuType;
    }

    public void setImmuType(String immuType) {
        this.immuType = immuType;
    }

    public String getImmuPosition() {
        return this.immuPosition;
    }

    public void setImmuPosition(String immuPosition) {
        this.immuPosition = immuPosition;
    }

    public String getImmuPositioncode() {
        return this.immuPositioncode;
    }

    public void setImmuPositioncode(String immuPositioncode) {
        this.immuPositioncode = immuPositioncode;
    }

    public String getImmuDoses() {
        return this.immuDoses;
    }

    public void setImmuDoses(String immuDoses) {
        this.immuDoses = immuDoses;
    }

    public String getImmuTaboo() {
        return this.immuTaboo;
    }

    public void setImmuTaboo(String immuTaboo) {
        this.immuTaboo = immuTaboo;
    }

    public String getCreateUnitAddr() {
		return createUnitAddr;
	}

	public void setCreateUnitAddr(String createUnitAddr) {
		this.createUnitAddr = createUnitAddr;
	}

	public String getCreateUnitName() {
		return createUnitName;
	}

	public void setCreateUnitName(String createUnitName) {
		this.createUnitName = createUnitName;
	}

	public String getCreateUnitCode() {
		return createUnitCode;
	}

	public void setCreateUnitCode(String createUnitCode) {
		this.createUnitCode = createUnitCode;
	}

	public String getImmuTaboocode() {
        return this.immuTaboocode;
    }

    public void setImmuTaboocode(String immuTaboocode) {
        this.immuTaboocode = immuTaboocode;
    }

    public String getImmuUnitId() {
        return immuUnitId;
    }

    public void setImmuUnitId(String immuUnitId) {
        this.immuUnitId = immuUnitId;
    }

    public String getImmuUnitName() {
        return this.immuUnitName;
    }

    public void setImmuUnitName(String immuUnitName) {
        this.immuUnitName = immuUnitName;
    }

    public String getElectronicSupervisionCode() {
        return this.ElectronicSupervisionCode;
    }

    public void setElectronicSupervisionCode(String ElectronicSupervisionCode) {
        this.ElectronicSupervisionCode = ElectronicSupervisionCode;
    }

    public String getVaccineName() {
        return this.vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getVaccineType() {
        return vaccineType;
    }

    public void setVaccineType(String vaccineType) {
        this.vaccineType = vaccineType;
    }

    public String getVaccineLotNumber() {
        return this.vaccineLotNumber;
    }

    public void setVaccineLotNumber(String vaccineLotNumber) {
        this.vaccineLotNumber = vaccineLotNumber;
    }

    public String getVaccineCompanyCode() {
        return this.vaccineCompanyCode;
    }

    public void setVaccineCompanyCode(String vaccineCompanyCode) {
        this.vaccineCompanyCode = vaccineCompanyCode;
    }

    public String getVaccineAnomalyHistory() {
  		return vaccineAnomalyHistory;
  	}

  	public void setVaccineAnomalyHistory(String vaccineAnomalyHistory) {
  		this.vaccineAnomalyHistory = vaccineAnomalyHistory;
  	}


    public String getVaccinationUnitCode() {
        return this.vaccinationUnitCode;
    }

    public void setVaccinationUnitCode(String vaccinationUnitCode) {
        this.vaccinationUnitCode = vaccinationUnitCode;
    }

    public String getVaccinationUnitName() {
        return this.vaccinationUnitName;
    }

    public void setVaccinationUnitName(String vaccinationUnitName) {
        this.vaccinationUnitName = vaccinationUnitName;
    }

    public String getVaccinationName() {
        return this.vaccinationName;
    }

    public void setVaccinationName(String vaccinationName) {
        this.vaccinationName = vaccinationName;
    }

    public String getVaccinationDoctorName() {
        return this.vaccinationDoctorName;
    }

    public void setVaccinationDoctorName(String vaccinationDoctorName) {
        this.vaccinationDoctorName = vaccinationDoctorName;
    }

    public Date getVaccinationDate() {
        return this.vaccinationDate;
    }

    public void setVaccinationDate(Date vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

    public String getVaccinationTypeNo() {
        return this.vaccinationTypeNo;
    }

    public void setVaccinationTypeNo(String vaccinationTypeNo) {
        this.vaccinationTypeNo = vaccinationTypeNo;
    }

    public String getSuspectVaccineName() {
        return this.suspectVaccineName;
    }

    public void setSuspectVaccineName(String suspectVaccineName) {
        this.suspectVaccineName = suspectVaccineName;
    }

    public String getAdverseProcessResult() {
        return this.adverseProcessResult;
    }

    public void setAdverseProcessResult(String adverseProcessResult) {
        this.adverseProcessResult = adverseProcessResult;
    }

    public Date getAdverseDate() {
        return this.adverseDate;
    }

    public void setAdverseDate(Date adverseDate) {
        this.adverseDate = adverseDate;
    }

    public String getAdverseEvideceCode() {
        return this.adverseEvideceCode;
    }

    public void setAdverseEvideceCode(String adverseEvideceCode) {
        this.adverseEvideceCode = adverseEvideceCode;
    }

    public String getWithdrawalsign() {
        return this.withdrawalsign;
    }

    public void setWithdrawalsign(String withdrawalsign) {
        this.withdrawalsign = withdrawalsign;
    }

    public Date getEvacuationDate() {
        return this.evacuationDate;
    }

    public void setEvacuationDate(Date evacuationDate) {
        this.evacuationDate = evacuationDate;
    }

    public String getEvacuationCause() {
        return this.evacuationCause;
    }

    public void setEvacuationCause(String evacuationCause) {
        this.evacuationCause = evacuationCause;
    }

    public Date getImmigrationDate() {
        return this.immigrationDate;
    }

    public void setImmigrationDate(Date immigrationDate) {
        this.immigrationDate = immigrationDate;
    }

    public String getCreateCardName() {
        return this.createCardName;
    }

    public void setCreateCardName(String createCardName) {
        this.createCardName = createCardName;
    }

    public Date getCreateCardDate() {
        return this.createCardDate;
    }

    public void setCreateCardDate(Date createCardDate) {
        this.createCardDate = createCardDate;
    }


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

    public String getVaccineMeasurement() {
        return vaccineMeasurement;
    }

    public void setVaccineMeasurement(String vaccineMeasurement) {
        this.vaccineMeasurement = vaccineMeasurement;
    }

    public String getVaccineFactory() {
        return vaccineFactory;
    }

    public void setVaccineFactory(String vaccineFactory) {
        this.vaccineFactory = vaccineFactory;
    }

    public String getInoculationTimes() {
        return inoculationTimes;
    }

    public void setInoculationTimes(String inoculationTimes) {
        this.inoculationTimes = inoculationTimes;
    }

    public String getVaccinationWeight() {
        return vaccinationWeight;
    }

    public void setVaccinationWeight(String vaccinationWeight) {
        this.vaccinationWeight = vaccinationWeight;
    }

    public VaccinationMgmt getVaccinationMgmt() {
        return vaccinationMgmt;
    }

    public void setVaccinationMgmt(VaccinationMgmt vaccinationMgmt) {
        this.vaccinationMgmt = vaccinationMgmt;
    }

	
	public String getBacterinNo() {
		return bacterinNo;
	}

	
	public void setBacterinNo(String bacterinNo) {
		this.bacterinNo = bacterinNo;
	}

	
	public Date getCancelDate() {
		return cancelDate;
	}

	
	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	
	public String getCancelReason() {
		return cancelReason;
	}

	
	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	
	public String getEvaluate() {
		return evaluate;
	}

	
	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}

	
	public String getFillOrganName() {
		return fillOrganName;
	}

	
	public void setFillOrganName(String fillOrganName) {
		this.fillOrganName = fillOrganName;
	}

	
	public Date getFillTime() {
		return fillTime;
	}

	
	public void setFillTime(Date fillTime) {
		this.fillTime = fillTime;
	}

	
	public String getFillUserName() {
		return fillUserName;
	}

	
	public void setFillUserName(String fillUserName) {
		this.fillUserName = fillUserName;
	}

	
	public String getFreeFlag() {
		return freeFlag;
	}

	
	public void setFreeFlag(String freeFlag) {
		this.freeFlag = freeFlag;
	}

	
	public String getImmuUnit() {
		return immuUnit;
	}

	
	public void setImmuUnit(String immuUnit) {
		this.immuUnit = immuUnit;
	}

	
	public Date getInputDate() {
		return inputDate;
	}

	
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	
	public String getInputIdcard() {
		return inputIdcard;
	}

	
	public void setInputIdcard(String inputIdcard) {
		this.inputIdcard = inputIdcard;
	}

	
	public String getInputMan() {
		return inputMan;
	}

	
	public void setInputMan(String inputMan) {
		this.inputMan = inputMan;
	}

	
	public String getRemark() {
		return remark;
	}

	
	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	public String getVaccineBatch() {
		return vaccineBatch;
	}

	
	public void setVaccineBatch(String vaccineBatch) {
		this.vaccineBatch = vaccineBatch;
	}

	
	public String getVaccineDose() {
		return vaccineDose;
	}

	
	public void setVaccineDose(String vaccineDose) {
		this.vaccineDose = vaccineDose;
	}

	
	public Integer getVaccineTotalNeedleTimes() {
		return vaccineTotalNeedleTimes;
	}

	
	public void setVaccineTotalNeedleTimes(Integer vaccineTotalNeedleTimes) {
		this.vaccineTotalNeedleTimes = vaccineTotalNeedleTimes;
	}

	
	public Date getVaccineValidDate() {
		return vaccineValidDate;
	}

	
	public void setVaccineValidDate(Date vaccineValidDate) {
		this.vaccineValidDate = vaccineValidDate;
	}

	
	public String getVaccineYears() {
		return vaccineYears;
	}

	
	public void setVaccineYears(String vaccineYears) {
		this.vaccineYears = vaccineYears;
	}

	
	public Integer getIsDelete() {
		return isDelete;
	}

	
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getAdultSecondaryVaccine() {
		return adultSecondaryVaccine;
	}

	public void setAdultSecondaryVaccine(Integer adultSecondaryVaccine) {
		this.adultSecondaryVaccine = adultSecondaryVaccine;
	}

	
	public String getVaccineCompanyName() {
		return vaccineCompanyName;
	}

	
	public void setVaccineCompanyName(String vaccineCompanyName) {
		this.vaccineCompanyName = vaccineCompanyName;
	}

	
	public String getVaccinationCode() {
		return vaccinationCode;
	}

	
	public void setVaccinationCode(String vaccinationCode) {
		this.vaccinationCode = vaccinationCode;
	}

	
	public String getAnalysisStatus() {
		return analysisStatus;
	}

	
	public void setAnalysisStatus(String analysisStatus) {
		this.analysisStatus = analysisStatus;
	}

	
	public String getVaccinationDateDesc() {
		return vaccinationDateDesc;
	}

	
	public void setVaccinationDateDesc(String vaccinationDateDesc) {
		this.vaccinationDateDesc = vaccinationDateDesc;
	}

	
	public String getProcessStatus() {
		return processStatus;
	}

	
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	
	public String getInputDateDesc() {
		return inputDateDesc;
	}

	
	public void setInputDateDesc(String inputDateDesc) {
		this.inputDateDesc = inputDateDesc;
	}

	
	public String getOtherVaccineFactory() {
		return otherVaccineFactory;
	}

	
	public void setOtherVaccineFactory(String otherVaccineFactory) {
		this.otherVaccineFactory = otherVaccineFactory;
	}

	public String getImmuneTypeCodeDesc() {
		return immuneTypeCodeDesc;
	}

	public void setImmuneTypeCodeDesc(String immuneTypeCodeDesc) {
		this.immuneTypeCodeDesc = immuneTypeCodeDesc;
	}

	public String getVaccineSpec() {
		return vaccineSpec;
	}

	public void setVaccineSpec(String vaccineSpec) {
		this.vaccineSpec = vaccineSpec;
	}

	public String getVaccineWay() {
		return vaccineWay;
	}

	public void setVaccineWay(String vaccineWay) {
		this.vaccineWay = vaccineWay;
	}

	public String getFeeFlag() {
		return feeFlag;
	}

	public void setFeeFlag(String feeFlag) {
		this.feeFlag = feeFlag;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}
	
	
}
