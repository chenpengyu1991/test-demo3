package com.founder.rhip.ehr.entity.clinic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;

import com.founder.fasf.util.ObjectUtil;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "MS_INPATIENT_MEDICAL_RECORD")
public class InpatientMedicalRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
    private Long personId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = true)
    private String ehrId;

    @Column(name = "MEDICAL_RECORD_NO", columnDefinition = "VARCHAR2|病案号||", length = 18, nullable = true)
    private String medicalRecordNo;

    @Column(name = "ADMISSION_NO", columnDefinition = "VARCHAR2|住院号||", length = 10, nullable = true)
    private String admissionNo;

    @Column(name = "HOSPITAL_CODE", columnDefinition = "VARCHAR2|医疗机构组织机构代码||", length = 10, nullable = true)
    private String hospitalCode;

    @Column(name = "HOSPITAL_NAME", columnDefinition = "VARCHAR2|医疗机构组织机构名称||", length = 70, nullable = true)
    private String hospitalName;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 50, nullable = true)
    private String name;

    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别||", length = 1, nullable = true)
    private String gender;

    @Column(name = "AGE", columnDefinition = "VARCHAR2|年龄||", length = 20, nullable = true)
    private String age;

    @Column(name = "MONTH_AGE", columnDefinition = "NUMBER|月龄||", length = 5, nullable = true)
    private Integer monthAge;

    @Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况||", length = 3, nullable = true)
    private String marriage;

    @Column(name = "NEONATAL_BIRTH_WEIGHT", columnDefinition = "NUMBER|新生儿出生体重||", length = 5, nullable = true)
    private Integer neonatalBirthWeight;

    @Column(name = "NEONATALINHOS_WEIGHT", columnDefinition = "NUMBER|新生儿入院体重||", length = 5, nullable = true)
    private Integer neonatalinhosWeight;

    @Column(name = "BIRTH_PROVINCE", columnDefinition = "VARCHAR2|出生地-省（区、市）||", length = 70, nullable = true)
    private String birthProvince;

    @Column(name = "BIRTH_CITY", columnDefinition = "VARCHAR2|出生地-市||", length = 70, nullable = true)
    private String birthCity;

    @Column(name = "BIRTH_COUNTRY", columnDefinition = "VARCHAR2|出生地-县||", length = 70, nullable = true)
    private String birthCountry;

    @Column(name = "INHOS_DATE", columnDefinition = "TIMESTAMP|入院日期时间||", nullable = true)
    private Date inhosDate;

    @Column(name = "INHOS_METHOD", columnDefinition = "VARCHAR2|入院途径||", length = 100, nullable = true)
    private String inhosMethod;

    @Column(name = "INHOS_DEPT_CODE", columnDefinition = "VARCHAR2|入院科室代码||", length = 5, nullable = true)
    private String inhosDeptCode;

    @Column(name = "INHOS_DEPT_NAME", columnDefinition = "VARCHAR2|入院科室名称||", length = 50, nullable = true)
    private String inhosDeptName;

    @Column(name = "INHOS_ROOM_CODE", columnDefinition = "VARCHAR2|入院病房号||", length = 5, nullable = true)
    private String inhosRoomCode;

    @Column(name = "INHOS_COUNT", columnDefinition = "NUMBER|住院患者住院次数||", length = 3, nullable = true)
    private Integer inhosCount;

    @Column(name = "INHOS_PATIENT_NAME", columnDefinition = "VARCHAR2|入院患者姓名||", length = 50, nullable = true)
    private String inhosPatientName;

    @Column(name = "TRANSITION_DEPT_CODE", columnDefinition = "VARCHAR2|住院患者转科科室代码||", length = 5, nullable = true)
    private String transitionDeptCode;

    @Column(name = "TRANSITION_DEPT_NAME", columnDefinition = "VARCHAR2|住院患者转科科室名称||", length = 50, nullable = true)
    private String transitionDeptName;

    @Column(name = "INHOS_RESCUE_TIMES", columnDefinition = "NUMBER|住院患者抢救次数||", length = 3, nullable = true)
    private Integer inhosRescueTimes;

    @Column(name = "INHOS_RESCUE_SUCCESS_TIMES", columnDefinition = "NUMBER|住院患者抢救成功次数||", length = 3, nullable = true)
    private Integer inhosRescueSuccessTimes;

    @Column(name = "INHOS_TREATMENT_RESULT", columnDefinition = "VARCHAR2|住院患者治疗结果代码||", length = 1, nullable = true)
    private String inhosTreatmentResult;

    @Column(name = "INHOS_CONDITION", columnDefinition = "VARCHAR2|住院患者入院病情||", length = 1, nullable = true)
    private String inhosCondition;

    @Column(name = "INHOS_ALLERGIC_START_DATE", columnDefinition = "DATE|住院患者过敏症状出现日期||", nullable = true)
    private Date inhosAllergicStartDate;

    @Column(name = "INHOS_BLOOD_TYPE_CODE", columnDefinition = "VARCHAR2|住院期间输血品种代码||", length = 1, nullable = true)
    private String inhosBloodTransTypeCode;

    @Column(name = "INHOS_BLOOD_VOLUME", columnDefinition = "NUMBER|住院期间输血量||", length = 5, nullable = true)
    private Integer inhosBloodTransVolume;

    @Column(name = "INHOS_BLOOD_VOLUME_COUNT", columnDefinition = "VARCHAR2|住院患者输血量计量单位||", length = 10, nullable = true)
    private String inhosBloodTransVolumeCount;

    @Column(name = "INHOS_BLOOD_REACTION_FLAG", columnDefinition = "CHAR|住院患者输血反应标志||", length = 1, nullable = true)
    private String inhosBloodTransReactionFlag;

    @Column(name = "INHOS_DAYS", columnDefinition = "NUMBER|住院患者住院天数||", length = 5, nullable = true)
    private Integer inhosDays;

    @Column(name = "INHOS_COUNTS", columnDefinition = "NUMBER|住院患者住院次数||", length = 5, nullable = true)
    private Integer inhosCounts;

    @Column(name = "INHOS_AUTOPSY_FLAG", columnDefinition = "CHAR|住院患者尸检标志||", length = 1, nullable = true)
    private String inhosAutopsyFlag;

    @Column(name = "INHOS_TEACH_CASE_FLAG", columnDefinition = "CHAR|住院患者示教病例标志||", length = 1, nullable = true)
    private String inhosTeachCaseFlag;

    @Column(name = "INHOS_MEDICAL_QUALITY_CODE", columnDefinition = "VARCHAR2|住院病例病案质量代码||", length = 1, nullable = true)
    private String inhosMedicalQualityCode;

    @Column(name = "OUTHOS_METHOD", columnDefinition = "VARCHAR2|离院方式||", length = 100, nullable = true)
    private String outhosMethod;

    @Column(name = "OUTHOS_FLAG", columnDefinition = "CHAR|出院31天内再住院标志||", length = 1, nullable = true)
    private String outhosFlag;
    
    @Column(name = "OUTHOS15_FLAG", columnDefinition = "CHAR|出院15天内再住院标志||", length = 1, nullable = true)
    private String outhos15Flag;

    @Column(name = "OUTHOS_PURPOSE", columnDefinition = "VARCHAR2|出院31天内再住院目的||", length = 100, nullable = true)
    private String outhosPurpose;

    @Column(name = "BEF_INHO_SMU_DATE", columnDefinition = "TIMESTAMP|颅脑损伤患者入院前昏迷日期时间||", nullable = true)
    private Date befInhoSmuDate;

    @Column(name = "AFT_INHO_SMU_DATE", columnDefinition = "TIMESTAMP|颅脑损伤患者入院后昏迷日期时间||", nullable = true)
    private Date aftInhoSmuDate;

    @Column(name = "MEDICAL_PAY_WAY", columnDefinition = "VARCHAR2|医疗费用支付方式代码||", length = 1, nullable = true)
    private String medicalPayWay;

    @Column(name = "MEDICAL_SETTLEMENT_WAY_CODE", columnDefinition = "VARCHAR2|医疗费用结算方式代码||", length = 2, nullable = true)
    private String medicalSettlementWayCode;

    @Column(name = "PERSONAL_EXPENSES", columnDefinition = "NUMBER|个人承担费用(元)||", scale = 8, precision = 2, nullable = true)
    private BigDecimal personalExpenses;

    @Column(name = "MEDICAL_INSURANCE_COST_SUM", columnDefinition = "NUMBER|医疗保险金额(元)||", scale = 8, precision = 2, nullable = true)
    private BigDecimal medicalInsuranceCostSum;

    @Column(name = "OTHER_SUBSIDIES_COST_SUM", columnDefinition = "NUMBER|其他补助金额(元)||", scale = 8, precision = 2, nullable = true)
    private BigDecimal otherSubsidiesCostSum;

    @Column(name = "ADMISSION_TOTAL_AMOUNT", columnDefinition = "NUMBER|住院总费用（元）||", scale = 10, precision = 2, nullable = true)
    private BigDecimal admissionTotalAmount;

    @Column(name = "DEPT_MASTER_SIGNATURE", columnDefinition = "VARCHAR2|科主任签名||", length = 50, nullable = true)
    private String deptMasterSignature;

    @Column(name = "DIRECTOR_DOCTOR_SIGNATURE", columnDefinition = "VARCHAR2|主任（副主任）医师签名||", length = 50, nullable = true)
    private String directorDoctorSignature;

    @Column(name = "ATTENDING_DOCTOR_SIGNATURE", columnDefinition = "VARCHAR2|主治医师签名||", length = 50, nullable = true)
    private String attendingDoctorSignature;

    @Column(name = "ADMISSION_DOCTOR_SIGNATURE", columnDefinition = "VARCHAR2|住院医师签名||", length = 50, nullable = true)
    private String admissionDoctorSignature;

    @Column(name = "PRIMARY_NURSE_SIGNATURE", columnDefinition = "VARCHAR2|责任护士签名||", length = 50, nullable = true)
    private String primaryNurseSignature;

    @Column(name = "REFRESHER_DOCTORS_SIGNATURE", columnDefinition = "VARCHAR2|进修医师签名||", length = 50, nullable = true)
    private String refresherDoctorsSignature;

    @Column(name = "INTERN_SIGNATURE", columnDefinition = "VARCHAR2|实习医师签名||", length = 50, nullable = true)
    private String internSignature;

    @Column(name = "MEDICAL_RECORD_SIGNATURE", columnDefinition = "VARCHAR2|病案编码员签名||", length = 50, nullable = true)
    private String medicalRecordSignature;

    @Column(name = "QC_DOCTOR_SIGNATURE", columnDefinition = "VARCHAR2|质控医师签名||", length = 50, nullable = true)
    private String qcDoctorSignature;

    @Column(name = "QC_NURSE_SIGNATURE", columnDefinition = "VARCHAR2|质控护士签名||", length = 50, nullable = true)
    private String qcNurseSignature;

    @Column(name = "QC_DATE", columnDefinition = "DATE|质控日期||", nullable = true)
    private Date qcDate;

    @Column(name = "OUTHOS_ROOM", columnDefinition = "VARCHAR2|出院病房||", length = 5, nullable = true)
    private String outhosRoom;

    @Column(name = "OUTHOS_DEPT_NAME", columnDefinition = "VARCHAR2|出院科室名称||", length = 50, nullable = true)
    private String outhosDeptName;

    @Column(name = "OUT_HOSPITAL_DATE", columnDefinition = "DATE|出院日期||", nullable = true)
    private Date outHospitalDate;

    @Column(name = "INJURY_POSION_REASON", columnDefinition = "VARCHAR2|损伤、中毒的外部原因||", length = 100, nullable = true)
    private String injuryPosionReason;

	@Column(name = "INJURY_DISEASE_CODE", columnDefinition = "VARCHAR2|疾病编码||", length = 18, nullable = true)
	private String injuryDiseaseCode;

    @Column(name = "INJURY_PATHOLOGY_NO", columnDefinition = "VARCHAR2|病理号||", length = 18, nullable = true)
    private String injuryPathologyCode;

    @Column(name = "MEDICALS_EXPENSE", columnDefinition = "NUMBER|一般医疗服务费||", scale = 8, precision = 2, nullable = true)
    private BigDecimal medicalsExpense;
    
    @Column(name = "TREATMENT_EXPENSE", columnDefinition = "NUMBER|一般治疗操作费||", scale = 8, precision = 2, nullable = true)
    private BigDecimal treatmentExpense;
    
    @Column(name = "NURSE_EXPENSE", columnDefinition = "NUMBER|护理费||", scale = 8, precision = 2, nullable = true)
    private BigDecimal nurseExpense;
    
    @Column(name = "OTHER_MEDICALS_EXPENSE", columnDefinition = "NUMBER|医疗服务其他费用||", scale = 8, precision = 2, nullable = true)
    private BigDecimal otherMedicalsExpense;
    
    @Column(name = "PATHOLOGY_DIAGNOSIS_EXPENSE", columnDefinition = "NUMBER|病理诊断费||", scale = 8, precision = 2, nullable = true)
    private BigDecimal pathologyDiagnosisExpense;
    
    @Column(name = "LAB_DIAGNOSIS_EXPENSE", columnDefinition = "NUMBER|实验室诊断费||", scale = 8, precision = 2, nullable = true)
    private BigDecimal labDiagnosisExpense;
    
    @Column(name = "IMAGING_DIAGNOSIS_EXPENSE", columnDefinition = "NUMBER|影像学诊断费||", scale = 8, precision = 2, nullable = true)
    private BigDecimal imagingDiagnosisExpense;
    
    @Column(name = "CLINICAL_ITEM_EXPENSE", columnDefinition = "NUMBER|临床诊断项目费||", scale = 8, precision = 2, nullable = true)
    private BigDecimal clinicalItemExpense;
    
    @Column(name = "NON_SURGICAL_ITEM_EXPENSE", columnDefinition = "NUMBER|非手术治疗项目费||", scale = 8, precision = 2, nullable = true)
    private BigDecimal nonSurgicalItemExpense;
    
    @Column(name = "CLINICAL_THERAPY_EXPENSE", columnDefinition = "NUMBER|临床物理治疗费||", scale = 8, precision = 2, nullable = true)
    private BigDecimal clinicalTherapyExpense;
    
    @Column(name = "SURGERY_TREATMENT_EXPENSE", columnDefinition = "NUMBER|手术治疗费||", scale = 8, precision = 2, nullable = true)
    private BigDecimal surgeryTreatmentExpense;
    
    @Column(name = "ANESTHESIA_EXPENSE", columnDefinition = "NUMBER|麻醉费||", scale = 8, precision = 2, nullable = true)
    private BigDecimal anesthesiaExpense;
    
    @Column(name = "SURGERY_EXPENSE", columnDefinition = "NUMBER|手术费||", scale = 8, precision = 2, nullable = true)
    private BigDecimal surgeryExpense;
    
    @Column(name = "REHABILITATION_EXPENSE", columnDefinition = "NUMBER|康复费||", scale = 8, precision = 2, nullable = true)
    private BigDecimal rehabilitationExpense;
    
    @Column(name = "CM_TREATMENT_EXPENSE", columnDefinition = "NUMBER|中医治疗费||", scale = 8, precision = 2, nullable = true)
    private BigDecimal cmTreatmentExpense;
    
    @Column(name = "WM_EXPENSE", columnDefinition = "NUMBER|西药费||", scale = 8, precision = 2, nullable = true)
    private BigDecimal wmExpense;
    
    @Column(name = "ANTIBACTERIAL_EXPENSE", columnDefinition = "NUMBER|抗菌药物费用||", scale = 8, precision = 2, nullable = true)
    private BigDecimal antibacterialExpense;
    
    @Column(name = "PROPRIETARY_CM_EXPENSE", columnDefinition = "NUMBER|中成药费||", scale = 8, precision = 2, nullable = true)
    private BigDecimal proprietaryCmExpense;
    
    @Column(name = "CHM_EXPENSE", columnDefinition = "NUMBER|中草药费||", scale = 8, precision = 2, nullable = true)
    private BigDecimal chmExpense;
    
    @Column(name = "BLOOD_EXPENSE", columnDefinition = "NUMBER|血费||", scale = 8, precision = 2, nullable = true)
    private BigDecimal bloodExpense;
    
    @Column(name = "ALBUMIN_EXPENSE", columnDefinition = "NUMBER|白蛋白类制品费||", scale = 8, precision = 2, nullable = true)
    private BigDecimal albuminExpense;
    
    @Column(name = "GLOBULIN_EXPENSE", columnDefinition = "NUMBER|球蛋白类制品费||", scale = 8, precision = 2, nullable = true)
    private BigDecimal globulinExpense;
    
    @Column(name = "CLOTTING_FACTOR_EXPENSE", columnDefinition = "NUMBER|凝血因子类制品费||", scale = 8, precision = 2, nullable = true)
    private BigDecimal clottingFactorExpense;
    
    @Column(name = "CYTOKINES_EXPENSE", columnDefinition = "NUMBER|细胞因子类制品费||", scale = 8, precision = 2, nullable = true)
    private BigDecimal cytokinesExpense;
    
    @Column(name = "CHECK_DMM_EXPENSE", columnDefinition = "NUMBER|检查用一次性医用材料费||", scale = 8, precision = 2, nullable = true)
    private BigDecimal checkDmmExpense;
    
    @Column(name = "TREATMENT_DMM_EXPENSE", columnDefinition = "NUMBER|治疗用一次性医用材料费||", scale = 8, precision = 2, nullable = true)
    private BigDecimal treatmentDmmExpense;
    
    @Column(name = "SURGERY_DMM_EXPENSE", columnDefinition = "NUMBER|手术用一次性医用材料费||", scale = 8, precision = 2, nullable = true)
    private BigDecimal surgeryDmmExpense;
    
    @Column(name = "OTHER_EXPENSE", columnDefinition = "NUMBER|其他费用||", scale = 8, precision = 2, nullable = true)
    private BigDecimal otherExpense;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;
    
	@Column(name = "OTHERCARDTYPE", columnDefinition = "VARCHAR2|其他就医卡证类型||", length = 2, nullable = true)
	private String othercardtype;

	@Column(name = "OTHERCARDNO", columnDefinition = "VARCHAR2|其他就医卡证号码||", length = 50, nullable = true)
	private String othercardno;

	@Column(name = "HP_S_NO", columnDefinition = "VARCHAR2|住院流水号||", length = 50, nullable = true)
	private String hpSNo;

	@Column(name = "NATION", columnDefinition = "VARCHAR2|国籍||", length = 50, nullable = true)
	private String nation;

	@Column(name = "CURE_TYPE", columnDefinition = "VARCHAR2|治疗类别代码||", length = 2, nullable = true)
	private String cureType;

	@Column(name = "CPW_MANA_TYPE", columnDefinition = "VARCHAR2|是否实施临床路径||", length = 2, nullable = true)
	private String cpwManaType;

	@Column(name = "CPW_MANA_CODE", columnDefinition = "VARCHAR2|临床路径管理代码||", length = 2, nullable = true)
	private String cpwManaCode;

	@Column(name = "IF_CH_DP", columnDefinition = "VARCHAR2|使用医疗机构中药制剂||", length = 2, nullable = true)
	private String ifChDp;

	@Column(name = "IF_CH_EQPT", columnDefinition = "VARCHAR2|是否使用中医诊疗设备||", length = 2, nullable = true)
	private String ifChEqpt;

	@Column(name = "IF_CH_TECH", columnDefinition = "VARCHAR2|是否使用中医诊疗技术||", length = 2, nullable = true)
	private String ifChTech;

	@Column(name = "IF_DIAL_NU", columnDefinition = "VARCHAR2|辨证施护标志||", length = 2, nullable = true)
	private String ifDialNu;

	@Column(name = "CCASEDIAG_CI", columnDefinition = "VARCHAR2|临术与病例诊断符合标识||", length = 2, nullable = true)
	private String ccasediagCi;

	@Column(name = "OPHPDIAG_CI", columnDefinition = "VARCHAR2|门诊与住院诊断符合标识||", length = 2, nullable = true)
	private String ophpdiagCi;

	@Column(name = "ADDIAG_CI", columnDefinition = "VARCHAR2|入院与出院诊断符合标识||", length = 2, nullable = true)
	private String addiagCi;

	@Column(name = "OPERDIAG_CI", columnDefinition = "VARCHAR2|术前与术后诊断符合标识||", length = 2, nullable = true)
	private String operdiagCi;

	@Column(name = "RCASEDIAG_CI", columnDefinition = "VARCHAR2|放射与病例诊断符合标识||", length = 2, nullable = true)
	private String rcasediagCi;
	
	@Column(name = "PROCESS_STATUS", columnDefinition = "VARCHAR2|处理状态||", length = 1, nullable = true)
	private String processStatus;
	
    @Column(name = "IS_LIMIT", columnDefinition = "NUMBER|是否限制||", length = 1, nullable = true)
    private Integer isLimit = -1;
    
	@Column(name = "GATHER_DATE", columnDefinition = "DATE|采集时间||", nullable = true)
	private Date gatherDate;

	//新添字段--start---0178710: 【健康档案浏览器-医疗服务】病案首页个人信息部分修改为直接在ms_inpatient_medical_record表提取，需要添加部分字段
    @Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
    private Date birthday;

    @Column(name = "NATIVE_PLACE", columnDefinition = "VARCHAR2|籍贯|100|", length = 100, nullable = true)
    private String nativePlace;

    @Column(name = "NATION_CODE", columnDefinition = "VARCHAR2|民族|2|", length = 2, nullable = true)
    private String nationCode;

    @Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证号|18|", length = 18, nullable = true)
    private String idcard;

    @Column(name = "OCCUPATION", columnDefinition = "VARCHAR2|职业|11|", length = 11, nullable = true)
    private String occupation;

    @Column(name = "PA_ADDRESS", columnDefinition = "VARCHAR2|现住址|100|", length = 100, nullable = true)
    private String paAddress;

    @Column(name = "PHONE_NUMBER", columnDefinition = "VARCHAR2|电话|20|", length = 20, nullable = true)
    private String phoneNumber;

    @Column(name = "POSTCODE", columnDefinition = "VARCHAR2|邮编|10|", length = 10, nullable = true)
    private String postcode;

    @Column(name = "HR_PLACE", columnDefinition = "VARCHAR2|户籍地址|2|", length = 2, nullable = true)
    private String hrPlace;

    @Column(name = "WORK_UNIT", columnDefinition = "VARCHAR2|工作单位|20|", length = 20, nullable = true)
    private String workUnit;

    @Column(name = "CONTACT_NAME", columnDefinition = "VARCHAR2|联系人姓名|50|", length = 50, nullable = true)
    private String contactName;

    @Column(name = "RELATION", columnDefinition = "VARCHAR2|关系|2|", length = 2, nullable = true)
    private String relation;

    @Column(name = "CONTACT_PHONE", columnDefinition = "VARCHAR2|联系电话|20|", length = 20, nullable = true)
    private String contactPhone;
    //新添字段--end---

	@Transient
	private String inhosDateDesc;
	
	@Transient
	private String inhosMethodCode;
	
	@Transient
	private String outHospitalDateDesc;
	
	@Transient
	private String qcDateDesc;
	
	@Transient
	private String inhosMethodCodeDesc;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getNationCode() {
        return nationCode;
    }

    public void setNationCode(String nationCode) {
        this.nationCode = nationCode;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPaAddress() {
        return paAddress;
    }

    public void setPaAddress(String paAddress) {
        this.paAddress = paAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getHrPlace() {
        return hrPlace;
    }

    public void setHrPlace(String hrPlace) {
        this.hrPlace = hrPlace;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getInhosMethodCodeDesc() {
		return inhosMethodCodeDesc;
	}

	public void setInhosMethodCodeDesc(String inhosMethodCodeDesc) {
		this.inhosMethodCodeDesc = inhosMethodCodeDesc;
	}

	public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getMedicalRecordNo() {
        return this.medicalRecordNo;
    }

    public void setMedicalRecordNo(String medicalRecordNo) {
        this.medicalRecordNo = medicalRecordNo;
    }

    public String getAdmissionNo() {
        return this.admissionNo;
    }

    public void setAdmissionNo(String admissionNo) {
        this.admissionNo = admissionNo;
    }

    public String getHospitalCode() {
        return this.hospitalCode;
    }

    public void setHospitalCode(String hospitalCode) {
        this.hospitalCode = hospitalCode;
    }

    public String getHospitalName() {
        return this.hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    
	public String getAge() {
		return age;
	}

	
	public void setAge(String age) {
		this.age = age;
	}

	public Integer getMonthAge() {
        return this.monthAge;
    }

    public void setMonthAge(Integer monthAge) {
        this.monthAge = monthAge;
    }

    public Integer getNeonatalBirthWeight() {
        return this.neonatalBirthWeight;
    }

    public void setNeonatalBirthWeight(Integer neonatalBirthWeight) {
        this.neonatalBirthWeight = neonatalBirthWeight;
    }

    public Integer getNeonatalinhosWeight() {
        return this.neonatalinhosWeight;
    }

    public void setNeonatalinhosWeight(Integer neonatalinhosWeight) {
        this.neonatalinhosWeight = neonatalinhosWeight;
    }

    public String getBirthProvince() {
        return this.birthProvince;
    }

    public void setBirthProvince(String birthProvince) {
        this.birthProvince = birthProvince;
    }

    public String getBirthCity() {
        return this.birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public String getBirthCountry() {
        return this.birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public Date getInhosDate() {
        return this.inhosDate;
    }

    public void setInhosDate(Date inhosDate) {
        this.inhosDate = inhosDate;
    }

    public String getInhosMethod() {
        return this.inhosMethod;
    }

    public void setInhosMethod(String inhosMethod) {
        this.inhosMethod = inhosMethod;
    }

    public String getInhosDeptCode() {
        return this.inhosDeptCode;
    }

    public void setInhosDeptCode(String inhosDeptCode) {
        this.inhosDeptCode = inhosDeptCode;
    }

    public String getInhosDeptName() {
        return this.inhosDeptName;
    }

    public void setInhosDeptName(String inhosDeptName) {
        this.inhosDeptName = inhosDeptName;
    }

    public String getTransitionDeptCode() {
        return transitionDeptCode;
    }

    public void setTransitionDeptCode(String transitionDeptCode) {
        this.transitionDeptCode = transitionDeptCode;
    }

    public String getTransitionDeptName() {
        return transitionDeptName;
    }

    public void setTransitionDeptName(String transitionDeptName) {
        this.transitionDeptName = transitionDeptName;
    }

    public String getInhosRoomCode() {
        return this.inhosRoomCode;
    }

    public void setInhosRoomCode(String inhosRoomCode) {
        this.inhosRoomCode = inhosRoomCode;
    }

    public Integer getInhosCount() {
        return this.inhosCount;
    }

    public void setInhosCount(Integer inhosCount) {
        this.inhosCount = inhosCount;
    }

    public String getInhosPatientName() {
        return this.inhosPatientName;
    }

    public void setInhosPatientName(String inhosPatientName) {
        this.inhosPatientName = inhosPatientName;
    }

    public Integer getInhosRescueTimes() {
        return this.inhosRescueTimes;
    }

    public void setInhosRescueTimes(Integer inhosRescueTimes) {
        this.inhosRescueTimes = inhosRescueTimes;
    }

    public Integer getInhosRescueSuccessTimes() {
        return this.inhosRescueSuccessTimes;
    }

    public void setInhosRescueSuccessTimes(Integer inhosRescueSuccessTimes) {
        this.inhosRescueSuccessTimes = inhosRescueSuccessTimes;
    }

    public String getInhosTreatmentResult() {
        return this.inhosTreatmentResult;
    }

    public void setInhosTreatmentResult(String inhosTreatmentResult) {
        this.inhosTreatmentResult = inhosTreatmentResult;
    }

    public String getInhosCondition() {
        return this.inhosCondition;
    }

    public void setInhosCondition(String inhosCondition) {
        this.inhosCondition = inhosCondition;
    }

    public Date getInhosAllergicStartDate() {
        return this.inhosAllergicStartDate;
    }

    public void setInhosAllergicStartDate(Date inhosAllergicStartDate) {
        this.inhosAllergicStartDate = inhosAllergicStartDate;
    }

    public String getInhosBloodTransTypeCode() {
        return this.inhosBloodTransTypeCode;
    }

    public void setInhosBloodTransTypeCode(String inhosBloodTransTypeCode) {
        this.inhosBloodTransTypeCode = inhosBloodTransTypeCode;
    }

    public Integer getInhosBloodTransVolume() {
        return this.inhosBloodTransVolume;
    }

    public void setInhosBloodTransVolume(Integer inhosBloodTransVolume) {
        this.inhosBloodTransVolume = inhosBloodTransVolume;
    }

    public String getInhosBloodTransVolumeCount() {
        return this.inhosBloodTransVolumeCount;
    }

    public void setInhosBloodTransVolumeCount(String inhosBloodTransVolumeCount) {
        this.inhosBloodTransVolumeCount = inhosBloodTransVolumeCount;
    }

    public String getInhosBloodTransReactionFlag() {
        return this.inhosBloodTransReactionFlag;
    }

    public void setInhosBloodTransReactionFlag(String inhosBloodTransReactionFlag) {
        this.inhosBloodTransReactionFlag = inhosBloodTransReactionFlag;
    }

    public Integer getInhosDays() {
        return this.inhosDays;
    }

    public void setInhosDays(Integer inhosDays) {
        this.inhosDays = inhosDays;
    }

    public Integer getInhosCounts() {
        return this.inhosCounts;
    }

    public void setInhosCounts(Integer inhosCounts) {
        this.inhosCounts = inhosCounts;
    }

    public String getInhosAutopsyFlag() {
        return this.inhosAutopsyFlag;
    }

    public void setInhosAutopsyFlag(String inhosAutopsyFlag) {
        this.inhosAutopsyFlag = inhosAutopsyFlag;
    }

    public String getInhosTeachCaseFlag() {
        return this.inhosTeachCaseFlag;
    }

    public void setInhosTeachCaseFlag(String inhosTeachCaseFlag) {
        this.inhosTeachCaseFlag = inhosTeachCaseFlag;
    }

   

    public String getInhosMedicalQualityCode() {
		return inhosMedicalQualityCode;
	}

	public void setInhosMedicalQualityCode(String inhosMedicalQualityCode) {
		this.inhosMedicalQualityCode = inhosMedicalQualityCode;
	}

	public String getOuthosMethod() {
        return this.outhosMethod;
    }

    public void setOuthosMethod(String outhosMethod) {
        this.outhosMethod = outhosMethod;
    }

    public String getOuthosFlag() {
        return this.outhosFlag;
    }

    public void setOuthosFlag(String outhosFlag) {
        this.outhosFlag = outhosFlag;
    }

    public String getOuthosPurpose() {
        return this.outhosPurpose;
    }

    public void setOuthosPurpose(String outhosPurpose) {
        this.outhosPurpose = outhosPurpose;
    }

    public Date getBefInhoSmuDate() {
        return this.befInhoSmuDate;
    }

    public void setBefInhoSmuDate(Date befInhoSmuDate) {
        this.befInhoSmuDate = befInhoSmuDate;
    }

    public Date getAftInhoSmuDate() {
        return this.aftInhoSmuDate;
    }

    public void setAftInhoSmuDate(Date aftInhoSmuDate) {
        this.aftInhoSmuDate = aftInhoSmuDate;
    }

    public String getMedicalPayWay() {
        return this.medicalPayWay;
    }

    public void setMedicalPayWay(String medicalPayWay) {
        this.medicalPayWay = medicalPayWay;
    }

    public String getMedicalSettlementWayCode() {
        return this.medicalSettlementWayCode;
    }

    public void setMedicalSettlementWayCode(String medicalSettlementWayCode) {
        this.medicalSettlementWayCode = medicalSettlementWayCode;
    }

    public BigDecimal getPersonalExpenses() {
        return this.personalExpenses;
    }

    public void setPersonalExpenses(BigDecimal personalExpenses) {
        this.personalExpenses = personalExpenses;
    }

    public BigDecimal getMedicalInsuranceCostSum() {
        return this.medicalInsuranceCostSum;
    }

    public void setMedicalInsuranceCostSum(BigDecimal medicalInsuranceCostSum) {
        this.medicalInsuranceCostSum = medicalInsuranceCostSum;
    }

    public BigDecimal getOtherSubsidiesCostSum() {
        return this.otherSubsidiesCostSum;
    }

    public void setOtherSubsidiesCostSum(BigDecimal otherSubsidiesCostSum) {
        this.otherSubsidiesCostSum = otherSubsidiesCostSum;
    }

    public BigDecimal getAdmissionTotalAmount() {
        return this.admissionTotalAmount;
    }

    public void setAdmissionTotalAmount(BigDecimal admissionTotalAmount) {
        this.admissionTotalAmount = admissionTotalAmount;
    }

    public String getDeptMasterSignature() {
        return this.deptMasterSignature;
    }

    public void setDeptMasterSignature(String deptMasterSignature) {
        this.deptMasterSignature = deptMasterSignature;
    }

    public String getDirectorDoctorSignature() {
        return this.directorDoctorSignature;
    }

    public void setDirectorDoctorSignature(String directorDoctorSignature) {
        this.directorDoctorSignature = directorDoctorSignature;
    }

    public String getAttendingDoctorSignature() {
        return this.attendingDoctorSignature;
    }

    public void setAttendingDoctorSignature(String attendingDoctorSignature) {
        this.attendingDoctorSignature = attendingDoctorSignature;
    }

    public String getAdmissionDoctorSignature() {
        return this.admissionDoctorSignature;
    }

    public void setAdmissionDoctorSignature(String admissionDoctorSignature) {
        this.admissionDoctorSignature = admissionDoctorSignature;
    }

    public String getPrimaryNurseSignature() {
        return this.primaryNurseSignature;
    }

    public void setPrimaryNurseSignature(String primaryNurseSignature) {
        this.primaryNurseSignature = primaryNurseSignature;
    }

    public String getRefresherDoctorsSignature() {
        return this.refresherDoctorsSignature;
    }

    public void setRefresherDoctorsSignature(String refresherDoctorsSignature) {
        this.refresherDoctorsSignature = refresherDoctorsSignature;
    }

    public String getInternSignature() {
        return this.internSignature;
    }

    public void setInternSignature(String internSignature) {
        this.internSignature = internSignature;
    }

    public String getMedicalRecordSignature() {
        return this.medicalRecordSignature;
    }

    public void setMedicalRecordSignature(String medicalRecordSignature) {
        this.medicalRecordSignature = medicalRecordSignature;
    }


    public String getOuthosRoom() {
        return this.outhosRoom;
    }

    public void setOuthosRoom(String outhosRoom) {
        this.outhosRoom = outhosRoom;
    }

    public String getOuthosDeptName() {
        return this.outhosDeptName;
    }

    public void setOuthosDeptName(String outhosDeptName) {
        this.outhosDeptName = outhosDeptName;
    }

    public Date getOutHospitalDate() {
        return this.outHospitalDate;
    }

    public void setOutHospitalDate(Date outHospitalDate) {
        this.outHospitalDate = outHospitalDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEhrId() {
        return ehrId;
    }

    public void setEhrId(String ehrId) {
        this.ehrId = ehrId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getInjuryPosionReason() {
        return injuryPosionReason;
    }

    public void setInjuryPosionReason(String injuryPosionReason) {
        this.injuryPosionReason = injuryPosionReason;
    }

    public BigDecimal getMedicalsExpense() {
        return medicalsExpense;
    }

    public void setMedicalsExpense(BigDecimal medicalsExpense) {
        this.medicalsExpense = medicalsExpense;
    }

    public BigDecimal getTreatmentExpense() {
        return treatmentExpense;
    }

    public void setTreatmentExpense(BigDecimal treatmentExpense) {
        this.treatmentExpense = treatmentExpense;
    }

    public BigDecimal getNurseExpense() {
        return nurseExpense;
    }

    public void setNurseExpense(BigDecimal nurseExpense) {
        this.nurseExpense = nurseExpense;
    }

    public BigDecimal getOtherMedicalsExpense() {
        return otherMedicalsExpense;
    }

    public void setOtherMedicalsExpense(BigDecimal otherMedicalsExpense) {
        this.otherMedicalsExpense = otherMedicalsExpense;
    }

    public BigDecimal getPathologyDiagnosisExpense() {
        return pathologyDiagnosisExpense;
    }

    public void setPathologyDiagnosisExpense(BigDecimal pathologyDiagnosisExpense) {
        this.pathologyDiagnosisExpense = pathologyDiagnosisExpense;
    }

    public BigDecimal getLabDiagnosisExpense() {
        return labDiagnosisExpense;
    }

    public void setLabDiagnosisExpense(BigDecimal labDiagnosisExpense) {
        this.labDiagnosisExpense = labDiagnosisExpense;
    }

    public BigDecimal getImagingDiagnosisExpense() {
        return imagingDiagnosisExpense;
    }

    public void setImagingDiagnosisExpense(BigDecimal imagingDiagnosisExpense) {
        this.imagingDiagnosisExpense = imagingDiagnosisExpense;
    }

    public BigDecimal getClinicalItemExpense() {
        return clinicalItemExpense;
    }

    public void setClinicalItemExpense(BigDecimal clinicalItemExpense) {
        this.clinicalItemExpense = clinicalItemExpense;
    }

    public BigDecimal getNonSurgicalItemExpense() {
        return nonSurgicalItemExpense;
    }

    public void setNonSurgicalItemExpense(BigDecimal nonSurgicalItemExpense) {
        this.nonSurgicalItemExpense = nonSurgicalItemExpense;
    }

    public BigDecimal getClinicalTherapyExpense() {
        return clinicalTherapyExpense;
    }

    public void setClinicalTherapyExpense(BigDecimal clinicalTherapyExpense) {
        this.clinicalTherapyExpense = clinicalTherapyExpense;
    }

    public BigDecimal getSurgeryTreatmentExpense() {
        return surgeryTreatmentExpense;
    }

    public void setSurgeryTreatmentExpense(BigDecimal surgeryTreatmentExpense) {
        this.surgeryTreatmentExpense = surgeryTreatmentExpense;
    }

    public BigDecimal getAnesthesiaExpense() {
        return anesthesiaExpense;
    }

    public void setAnesthesiaExpense(BigDecimal anesthesiaExpense) {
        this.anesthesiaExpense = anesthesiaExpense;
    }

    public BigDecimal getSurgeryExpense() {
        return surgeryExpense;
    }

    public void setSurgeryExpense(BigDecimal surgeryExpense) {
        this.surgeryExpense = surgeryExpense;
    }

    public BigDecimal getRehabilitationExpense() {
        return rehabilitationExpense;
    }

    public void setRehabilitationExpense(BigDecimal rehabilitationExpense) {
        this.rehabilitationExpense = rehabilitationExpense;
    }

    public BigDecimal getCmTreatmentExpense() {
        return cmTreatmentExpense;
    }

    public void setCmTreatmentExpense(BigDecimal cmTreatmentExpense) {
        this.cmTreatmentExpense = cmTreatmentExpense;
    }

    public BigDecimal getWmExpense() {
        return wmExpense;
    }

    public void setWmExpense(BigDecimal wmExpense) {
        this.wmExpense = wmExpense;
    }

    public BigDecimal getAntibacterialExpense() {
        return antibacterialExpense;
    }

    public void setAntibacterialExpense(BigDecimal antibacterialExpense) {
        this.antibacterialExpense = antibacterialExpense;
    }

    public BigDecimal getProprietaryCmExpense() {
        return proprietaryCmExpense;
    }

    public void setProprietaryCmExpense(BigDecimal proprietaryCmExpense) {
        this.proprietaryCmExpense = proprietaryCmExpense;
    }

    public BigDecimal getChmExpense() {
        return chmExpense;
    }

    public void setChmExpense(BigDecimal chmExpense) {
        this.chmExpense = chmExpense;
    }

    public BigDecimal getBloodExpense() {
        return bloodExpense;
    }

    public void setBloodExpense(BigDecimal bloodExpense) {
        this.bloodExpense = bloodExpense;
    }

    public BigDecimal getAlbuminExpense() {
        return albuminExpense;
    }

    public void setAlbuminExpense(BigDecimal albuminExpense) {
        this.albuminExpense = albuminExpense;
    }

    public BigDecimal getGlobulinExpense() {
        return globulinExpense;
    }

    public void setGlobulinExpense(BigDecimal globulinExpense) {
        this.globulinExpense = globulinExpense;
    }

    public BigDecimal getClottingFactorExpense() {
        return clottingFactorExpense;
    }

    public void setClottingFactorExpense(BigDecimal clottingFactorExpense) {
        this.clottingFactorExpense = clottingFactorExpense;
    }

    public BigDecimal getCytokinesExpense() {
        return cytokinesExpense;
    }

    public void setCytokinesExpense(BigDecimal cytokinesExpense) {
        this.cytokinesExpense = cytokinesExpense;
    }

    public BigDecimal getCheckDmmExpense() {
        return checkDmmExpense;
    }

    public void setCheckDmmExpense(BigDecimal checkDmmExpense) {
        this.checkDmmExpense = checkDmmExpense;
    }

    public BigDecimal getTreatmentDmmExpense() {
        return treatmentDmmExpense;
    }

    public void setTreatmentDmmExpense(BigDecimal treatmentDmmExpense) {
        this.treatmentDmmExpense = treatmentDmmExpense;
    }

    public BigDecimal getSurgeryDmmExpense() {
        return surgeryDmmExpense;
    }

    public void setSurgeryDmmExpense(BigDecimal surgeryDmmExpense) {
        this.surgeryDmmExpense = surgeryDmmExpense;
    }

    public BigDecimal getOtherExpense() {
        return otherExpense;
    }

    public void setOtherExpense(BigDecimal otherExpense) {
        this.otherExpense = otherExpense;
    }

    public String getInjuryDiseaseCode() {
        return injuryDiseaseCode;
    }

    public void setInjuryDiseaseCode(String injuryDiseaseCode) {
        this.injuryDiseaseCode = injuryDiseaseCode;
    }

    public String getInjuryPathologyCode() {
        return injuryPathologyCode;
    }

    public void setInjuryPathologyCode(String injuryPathologyCode) {
        this.injuryPathologyCode = injuryPathologyCode;
    }

    public String getQcDoctorSignature() {
        return qcDoctorSignature;
    }

    public void setQcDoctorSignature(String qcDoctorSignature) {
        this.qcDoctorSignature = qcDoctorSignature;
    }

    public String getQcNurseSignature() {
        return qcNurseSignature;
    }

    public void setQcNurseSignature(String qcNurseSignature) {
        this.qcNurseSignature = qcNurseSignature;
    }

    public Date getQcDate() {
        return qcDate;
    }

    public void setQcDate(Date qcDate) {
        this.qcDate = qcDate;
    }

	public String getOthercardtype() {
		return othercardtype;
	}

	public void setOthercardtype(String othercardtype) {
		this.othercardtype = othercardtype;
	}

	public String getOthercardno() {
		return othercardno;
	}

	public void setOthercardno(String othercardno) {
		this.othercardno = othercardno;
	}

	public String getHpSNo() {
		return hpSNo;
	}

	public void setHpSNo(String hpSNo) {
		this.hpSNo = hpSNo;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getCureType() {
		return cureType;
	}

	public void setCureType(String cureType) {
		this.cureType = cureType;
	}

	public String getCpwManaType() {
		return cpwManaType;
	}

	public void setCpwManaType(String cpwManaType) {
		this.cpwManaType = cpwManaType;
	}

	public String getCpwManaCode() {
		return cpwManaCode;
	}

	public void setCpwManaCode(String cpwManaCode) {
		this.cpwManaCode = cpwManaCode;
	}

	public String getIfChDp() {
		return ifChDp;
	}

	public void setIfChDp(String ifChDp) {
		this.ifChDp = ifChDp;
	}

	public String getIfChEqpt() {
		return ifChEqpt;
	}

	public void setIfChEqpt(String ifChEqpt) {
		this.ifChEqpt = ifChEqpt;
	}

	public String getIfChTech() {
		return ifChTech;
	}

	public void setIfChTech(String ifChTech) {
		this.ifChTech = ifChTech;
	}

	public String getIfDialNu() {
		return ifDialNu;
	}

	public void setIfDialNu(String ifDialNu) {
		this.ifDialNu = ifDialNu;
	}

	public String getCcasediagCi() {
		return ccasediagCi;
	}

	public void setCcasediagCi(String ccasediagCi) {
		this.ccasediagCi = ccasediagCi;
	}

	public String getOphpdiagCi() {
		return ophpdiagCi;
	}

	public void setOphpdiagCi(String ophpdiagCi) {
		this.ophpdiagCi = ophpdiagCi;
	}

	public String getAddiagCi() {
		return addiagCi;
	}

	public void setAddiagCi(String addiagCi) {
		this.addiagCi = addiagCi;
	}

	public String getOperdiagCi() {
		return operdiagCi;
	}

	public void setOperdiagCi(String operdiagCi) {
		this.operdiagCi = operdiagCi;
	}

	public String getRcasediagCi() {
		return rcasediagCi;
	}

	public void setRcasediagCi(String rcasediagCi) {
		this.rcasediagCi = rcasediagCi;
	}

	
	public String getInhosDateDesc() {
		return inhosDateDesc;
	}

	
	public void setInhosDateDesc(String inhosDateDesc) {
		this.inhosDateDesc = inhosDateDesc;
	}

	
	public String getInhosMethodCode() {
		// 1:门诊 2：急诊 3:住院
		if (ObjectUtil.isNullOrEmpty(inhosMethod)) {
			this.inhosMethodCode = "1";
		} else if (StringUtils.contains(inhosMethod, "门诊")) {
			this.inhosMethodCode = "1";
		} else if (StringUtils.contains(inhosMethod, "急诊")) {
			this.inhosMethodCode = "2";
		} else if (StringUtils.contains(inhosMethod, "住院")) {
			this.inhosMethodCode = "3";
		}
		return inhosMethodCode;
	}

	
	public void setInhosMethodCode(String inhosMethodCode) {
		this.inhosMethodCode = inhosMethodCode;
	}

	
	public String getOutHospitalDateDesc() {
		return outHospitalDateDesc;
	}

	
	public void setOutHospitalDateDesc(String outHospitalDateDesc) {
		this.outHospitalDateDesc = outHospitalDateDesc;
	}

	
	public String getQcDateDesc() {
		return qcDateDesc;
	}

	
	public void setQcDateDesc(String qcDateDesc) {
		this.qcDateDesc = qcDateDesc;
	}

	
	public String getProcessStatus() {
		return processStatus;
	}

	
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	
	public Integer getIsLimit() {
		return isLimit;
	}

	
	public void setIsLimit(Integer isLimit) {
		this.isLimit = isLimit;
	}

	public Date getGatherDate() {
		return gatherDate;
	}

	public void setGatherDate(Date gatherDate) {
		this.gatherDate = gatherDate;
	}

	public String getOuthos15Flag() {
		return outhos15Flag;
	}

	public void setOuthos15Flag(String outhos15Flag) {
		this.outhos15Flag = outhos15Flag;
	}

	
	
    
	
}
