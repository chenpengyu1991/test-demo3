package com.founder.rhip.ehr.entity.women;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.founder.rhip.ehr.common.JaxbDateSerializer;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "WH_BIRTH_CONTROL_SERVICE")
@XmlRootElement(name = "birthControlService")
public class BirthControlService implements Serializable {

	private static final long serialVersionUID = -5827856787166695182L;

	@Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = false)
    private String ehrId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;
    
    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
    private Long personId;

    @Column(name = "HEALTH_FILE_NO", columnDefinition = "VARCHAR2|城乡居民健康档案编号||", length = 17, nullable = true)
    private String healthFileNo;

    @Column(name = "EHR_NO", columnDefinition = "VARCHAR2|门诊号||", length = 10, nullable = true)
    private String ehrNo;

    @Column(name = "ADMISSION_NO", columnDefinition = "VARCHAR2|住院号||", length = 10, nullable = true)
    private String admissionNo;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 30, nullable = true)
    private String name;
    
    @Column(name = "ID_CARD", columnDefinition = "VARCHAR2|身份证件号码||", length = 18, nullable = true)
    private String idCard;

    @Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
    private Date birthday;

    @Column(name = "PHONE_NUMBER", columnDefinition = "VARCHAR2|本人电话号码||", length = 20, nullable = true)
    private String phoneNumber;

    @Column(name = "OCCUPATION", columnDefinition = "VARCHAR2|职业类别代码(国标)||", length = 5, nullable = true)
    private String occupation;

    @Column(name = "UNIT_NAME", columnDefinition = "VARCHAR2|工作单位名称||", length = 70, nullable = true)
    private String unitName;

    @Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况类别代码||", length = 2, nullable = true)
    private String marriage;

    @Column(name = "AREA_CODE", columnDefinition = "VARCHAR2|行政区划代码||", length = 6, nullable = true)
    private String areaCode;

    @Column(name = "HRSTREET", columnDefinition = "VARCHAR2|户籍地址-村(街、路、弄等)||", length = 70, nullable = true)
    private String hrstreet;

    @Column(name = "HRHOUSE_NUMBER", columnDefinition = "VARCHAR2|户籍地址-门牌号码||", length = 70, nullable = true)
    private String hrhouseNumber;

    @Column(name = "HRPROVINCE", columnDefinition = "VARCHAR2|户籍地址-省(自治区、直辖市)||", length = 70, nullable = true)
    private String hrprovince;

    @Column(name = "HRCITY", columnDefinition = "VARCHAR2|户籍地址-市(地区、州)||", length = 70, nullable = true)
    private String hrcity;

    @Column(name = "HRCOUNTY", columnDefinition = "VARCHAR2|户籍地址-县(区)||", length = 70, nullable = true)
    private String hrcounty;

    @Column(name = "HRTOWN_SHIP", columnDefinition = "VARCHAR2|户籍地址-乡(镇、街道办事处)||", length = 70, nullable = true)
    private String hrtownShip;

    @Column(name = "HRPOST_CODE", columnDefinition = "VARCHAR2|户籍地址邮政编码||", length = 6, nullable = true)
    private String hrpostCode;

    @Column(name = "PASTREET", columnDefinition = "VARCHAR2|现住址-村(街、路、弄等)||", length = 70, nullable = true)
    private String pastreet;

    @Column(name = "PAHOUSE_NUMBER", columnDefinition = "VARCHAR2|现住址-门牌号码||", length = 70, nullable = true)
    private String pahouseNumber;

    @Column(name = "PAPROVINCE", columnDefinition = "VARCHAR2|现住址-省(自治区、直辖市)||", length = 70, nullable = true)
    private String paprovince;

    @Column(name = "PACITY", columnDefinition = "VARCHAR2|现住址-市(地区、州)||", length = 70, nullable = true)
    private String pacity;

    @Column(name = "PACOUNTY", columnDefinition = "VARCHAR2|现住址-县(区)||", length = 70, nullable = true)
    private String pacounty;

    @Column(name = "PATOWN_SHIP", columnDefinition = "VARCHAR2|现住址-乡(镇、街道办事处)||", length = 70, nullable = true)
    private String patownShip;

    @Column(name = "PAPOST_CODE", columnDefinition = "VARCHAR2|现住址邮政编码||", length = 6, nullable = true)
    private String papostCode;

    @Column(name = "PAST_MEDICAL_HISTORY", columnDefinition = "VARCHAR2|既往疾病史||", length = 100, nullable = true)
    private String pastMedicalHistory;

    @Column(name = "ALLERGIC_HISTORY", columnDefinition = "VARCHAR2|过敏史||", length = 100, nullable = true)
    private String allergicHistory;

    @Column(name = "CONTRACEPTIVE_HISTORY", columnDefinition = "VARCHAR2|避孕史||", length = 100, nullable = true)
    private String contraceptiveHistory;

    @Column(name = "RECORD_NUMBER", columnDefinition = "VARCHAR2|记录表单编号||", length = 20, nullable = true)
    private String recordNumber;

    @Column(name = "CHIEF_COMPLAINT", columnDefinition = "VARCHAR2|主诉||", length = 100, nullable = true)
    private String chiefComplaint;

    @Column(name = "MENARCHE_AGE", columnDefinition = "NUMBER|初潮年龄(岁)||", length = 3, nullable = true)
    private Integer menarcheAge;

    @Column(name = "MENSTRUAL_DURATION", columnDefinition = "NUMBER|月经持续时间(d)||", length = 50, nullable = true)
    private String menstrualDuration;

    @Column(name = "MENSTRUAL_CYCLE", columnDefinition = "NUMBER|月经周期(d)||", length = 50, nullable = true)
    private String menstrualCycle;

    @Column(name = "MENSTRUAL_BLEEDING_TYPE", columnDefinition = "VARCHAR2|月经出血量类别代码||", length = 1, nullable = true)
    private String menstrualBleedingType;

    @Column(name = "DYSMENORRHEA_DEGREE", columnDefinition = "VARCHAR2|痛经程度代码||", length = 1, nullable = true)
    private String dysmenorrheaDegree;

    @Column(name = "LAST_MENSTRUAL_DATE", columnDefinition = "DATE|末次月经日期||", nullable = true)
    private Date lastMenstrualDate;

    @Column(name = "GRAVIDITY_TIMES", columnDefinition = "NUMBER|孕次||", length = 2, nullable = true)
    private Integer gravidityTimes;

    @Column(name = "PRODUCTION_TIMES", columnDefinition = "NUMBER|产次||", length = 2, nullable = true)
    private Integer productionTimes;

    @Column(name = "LAST_PREGNANCY_END_DATE", columnDefinition = "DATE|末次妊娠终止日期||", nullable = true)
    private Date lastPregnancyEndDate;

    @Column(name = "LAST_PREGNANCY_WAY", columnDefinition = "VARCHAR2|末次妊娠终止方式代码||", length = 1, nullable = true)
    private String lastPregnancyWay;

    @Column(name = "ABORTION_TIMES", columnDefinition = "NUMBER|流产总次数||", length = 5, nullable = true)
    private Integer abortionTimes;

    @Column(name = "TEMPERATURE", columnDefinition = "NUMBER|体温(℃)||", scale = 4, precision = 1, nullable = true)
    private BigDecimal temperature;

    @Column(name = "SBP", columnDefinition = "NUMBER|收缩压(mmHg)||", length = 50, nullable = true)
    private String sbp;

    @Column(name = "DBP", columnDefinition = "NUMBER|舒张压(mmHg)||", length = 5, nullable = true)
    private String dbp;

    @Column(name = "HEART_RATE", columnDefinition = "NUMBER|心率(次/分钟)||", length = 50, nullable = true)
    private String heartRate;

    @Column(name = "CARDIAC_AUSCU_RESULT", columnDefinition = "VARCHAR2|心脏听诊结果||", length = 100, nullable = true)
    private String cardiacAuscuResult;

    @Column(name = "LUNG_AUSCU_RESULT", columnDefinition = "VARCHAR2|肺部听诊结果||", length = 100, nullable = true)
    private String lungAuscuResult;

    @Column(name = "VULVA_CHECK_RESULT", columnDefinition = "VARCHAR2|外阴检查结果||", length = 100, nullable = true)
    private String vulvaCheckResult;

    @Column(name = "VAGINA_CHECK_RESULT", columnDefinition = "VARCHAR2|阴道检查结果||", length = 100, nullable = true)
    private String vaginaCheckResult;

    @Column(name = "CERVIX_CHECK_RESULT", columnDefinition = "VARCHAR2|宫颈检查结果||", length = 100, nullable = true)
    private String cervixCheckResult;

    @Column(name = "UTERUS_CHECK_RESULT", columnDefinition = "VARCHAR2|子宫检查结果||", length = 100, nullable = true)
    private String uterusCheckResult;

    @Column(name = "UTERINE_PART", columnDefinition = "VARCHAR2|子宫位置代码||", length = 1, nullable = true)
    private String uterinePart;

    @Column(name = "UTERINE_SIZE", columnDefinition = "VARCHAR2|子宫大小代码||", length = 1, nullable = true)
    private String uterineSize;

    @Column(name = "L_FALLOPIAN_TUBE_CHECK_RESULT", columnDefinition = "VARCHAR2|左侧输卵管检查结果||", length = 100, nullable = true)
    private String lFallopianTubeCheckResult;

    @Column(name = "R_FALLOPIAN_TUBE_CHECK_RESULT", columnDefinition = "VARCHAR2|右侧输卵管检查结果||", length = 100, nullable = true)
    private String rFallopianTubeCheckResult;

    @Column(name = "L_OVARY_CHECK_RESULT", columnDefinition = "VARCHAR2|左侧卵巢检查结果||", length = 100, nullable = true)
    private String lOvaryCheckResult;

    @Column(name = "R_OVARY_CHECK_RESULT", columnDefinition = "VARCHAR2|右侧卵巢检查结果||", length = 100, nullable = true)
    private String rOvaryCheckResult;

    @Column(name = "L_ATTACHMENT_CHECK_RESULT", columnDefinition = "VARCHAR2|左侧附件检查结果代码||", length = 1, nullable = true)
    private String lAttachmentCheckResult;

    @Column(name = "R_ATTACHMENT_CHECK_RESULT", columnDefinition = "VARCHAR2|右侧附件检查结果代码||", length = 1, nullable = true)
    private String rAttachmentCheckResult;

    @Column(name = "L_EPIDIDYMIS_CHECK_RESULT", columnDefinition = "VARCHAR2|左侧附睾检查结果代码||", length = 1, nullable = true)
    private String lEpididymisCheckResult;

    @Column(name = "R_EPIDIDYMIS_CHECK_RESULT", columnDefinition = "VARCHAR2|右侧附睾检查结果代码||", length = 1, nullable = true)
    private String rEpididymisCheckResult;

    @Column(name = "L_TESTIS_CHECK_RESULT", columnDefinition = "VARCHAR2|左侧睾丸检查结果代码||", length = 1, nullable = true)
    private String lTestisCheckResult;

    @Column(name = "R_TESTIS_CHECK_RESULT", columnDefinition = "VARCHAR2|右侧睾丸检查结果代码||", length = 1, nullable = true)
    private String rTestisCheckResult;

    @Column(name = "L_VAS_DEFERENS_CHECK_RESULT", columnDefinition = "VARCHAR2|左侧输精管检查结果||", length = 100, nullable = true)
    private String lVasDeferensCheckResult;

    @Column(name = "R_VAS_DEFERENS_CHECK_RESULT", columnDefinition = "VARCHAR2|右侧输精管检查结果||", length = 100, nullable = true)
    private String rVasDeferensCheckResult;

    @Column(name = "SCROTUM_CHECK_RESULT", columnDefinition = "VARCHAR2|阴囊检查结果||", length = 100, nullable = true)
    private String scrotumCheckResult;

    @Column(name = "SPERMATIC_CHECK_RESULT", columnDefinition = "VARCHAR2|精索检查结果||", length = 100, nullable = true)
    private String spermaticCheckResult;

    @Column(name = "ERYTHROCYTE_COUNT", columnDefinition = "NUMBER|红细胞计数值(G/L)||", scale = 3, precision = 1, nullable = true)
    private BigDecimal erythrocyteCount;

    @Column(name = "HEMOGLOBIN_VALUE", columnDefinition = "NUMBER|血红蛋白值(g/L)||", length = 5, nullable = true)
    private Integer hemoglobinValue;

    @Column(name = "PLATELET_COUNT", columnDefinition = "NUMBER|血小板计数值(G/L)||", length = 5, nullable = true)
    private Integer plateletCount;

    @Column(name = "LEUKOCYTE_COUNT", columnDefinition = "NUMBER|白细胞计数值(G/L)||", scale = 4, precision = 1, nullable = true)
    private BigDecimal leukocyteCount;

    @Column(name = "LEUKOCYTE_TYPE", columnDefinition = "VARCHAR2|白细胞分类结果||", length = 100, nullable = true)
    private String leukocyteType;

    @Column(name = "BLEEDING_TIME", columnDefinition = "NUMBER|出血时间(s)||", length = 5, nullable = true)
    private Integer bleedingTime;

    @Column(name = "COAGULATION_TIME", columnDefinition = "NUMBER|凝血时间(s)||", length = 5, nullable = true)
    private Integer coagulationTime;

    @Column(name = "VAGINA_SECRETIONS_DESC", columnDefinition = "VARCHAR2|阴道分泌物性状描述||", length = 100, nullable = true)
    private String vaginaSecretionsDesc;

    @Column(name = "TRICHOMO_DETECT_RESULT", columnDefinition = "VARCHAR2|滴虫检测结果代码||", length = 1, nullable = true)
    private String trichomoDetectResult;

    @Column(name = "CANDIDA_DETECT_RESULT", columnDefinition = "VARCHAR2|念珠菌检测结果代码||", length = 1, nullable = true)
    private String candidaDetectResult;

    @Column(name = "VAGINA_SECRETIONS_CLEANLINESS", columnDefinition = "VARCHAR2|阴道分泌物清洁度代码||", length = 1, nullable = true)
    private String vaginaSecretionsCleanliness;

    @Column(name = "N_GONORRHOEAE_CHECK_RESULT", columnDefinition = "VARCHAR2|淋球菌检查结果||", length = 100, nullable = true)
    private String nGonorrhoeaeCheckResult;

    @Column(name = "SYPHILIS_SEROLOGY_CHECK_RESULT", columnDefinition = "VARCHAR2|梅毒血清学试验结果代码||", length = 1, nullable = true)
    private String syphilisSerologyCheckResult;

    @Column(name = "HIVLG_DETECT_RESULT", columnDefinition = "VARCHAR2|HIV抗体检测结果代码||", length = 1, nullable = true)
    private String hivlgDetectResult;

    @Column(name = "URINE_TEST_RESULT", columnDefinition = "VARCHAR2|尿妊娠试验结果代码||", length = 1, nullable = true)
    private String urineTestResult;

    @Column(name = "SERUM_BHCG_VALUE", columnDefinition = "NUMBER|血β-绒毛膜促性腺激素值(IU/L)||", scale = 4, precision = 1, nullable = true)
    private BigDecimal serumBhcgValue;

    @Column(name = "HBSAG_DETECT_RESULT", columnDefinition = "VARCHAR2|乙型肝炎病毒表面抗原检测结果代码||", length = 1, nullable = true)
    private String hbsagDetectResult;

    @Column(name = "BMODE_CHECK_RESULT", columnDefinition = "VARCHAR2|B超检查结果||", length = 100, nullable = true)
    private String bmodeCheckResult;

    @Column(name = "DISEASE_DIAGNOSIS", columnDefinition = "VARCHAR2|疾病诊断代码||", length = 7, nullable = true)
    private String diseaseDiagnosis;

    @Column(name = "IUD_PLACE_LIFE", columnDefinition = "NUMBER|宫内节育器放置年限||", length = 5, nullable = true)
    private Integer iudPlaceLife;

    @Column(name = "IUD_PLACE_TIME", columnDefinition = "VARCHAR2|宫内节育器放置时期代码||", length = 2, nullable = true)
    private String iudPlaceTime;

    @Column(name = "IUD_REMOVE_STATE", columnDefinition = "VARCHAR2|宫内节育器取出-情况代码||", length = 1, nullable = true)
    private String iudRemoveState;

    @Column(name = "IUD_REMOVE_ANOMALIES_DESC", columnDefinition = "VARCHAR2|宫内节育器取出-异常情况描述||", length = 100, nullable = true)
    private String iudRemoveAnomaliesDesc;

    @Column(name = "IUD_TYPE_CODE", columnDefinition = "VARCHAR2|宫内节育器种类代码||", length = 2, nullable = true)
    private String iudTypeCode;

    @Column(name = "NORPLANT_IMPLANTS_PERIOD", columnDefinition = "VARCHAR2|皮下埋植剂埋植时期代码||", length = 1, nullable = true)
    private String norplantImplantsPeriod;

    @Column(name = "NORPLANT_IMPLANTS_LIFE", columnDefinition = "NUMBER|皮下埋植剂埋植年限||", length = 5, nullable = true)
    private Integer norplantImplantsLife;

    @Column(name = "NORPLANT_IMPLANTS_PART", columnDefinition = "VARCHAR2|皮下埋植剂埋植部位代码||", length = 1, nullable = true)
    private String norplantImplantsPart;

    @Column(name = "REMOVEIMPLANTS_CHECK_RESULT", columnDefinition = "VARCHAR2|取出皮下埋植剂检查结果代码||", length = 1, nullable = true)
    private String removeimplantsCheckResult;

    @Column(name = "TUBAL_LIGATION_WAY", columnDefinition = "VARCHAR2|输卵管结扎手术方式代码||", length = 1, nullable = true)
    private String tubalLigationWay;

    @Column(name = "TUBAL_LIGATION_PART", columnDefinition = "VARCHAR2|输卵管结扎部位代码||", length = 1, nullable = true)
    private String tubalLigationPart;

    @Column(name = "VASECTOMY_WAY", columnDefinition = "VARCHAR2|输精管结扎手术方式代码||", length = 1, nullable = true)
    private String vasectomyWay;

    @Column(name = "L_VASECTOMY_LENGTH", columnDefinition = "NUMBER|左侧输精管切除长度(cm)||", scale = 4, precision = 1, nullable = true)
    private BigDecimal lVasectomyLength;

    @Column(name = "R_VASECTOMY_LENGTH", columnDefinition = "NUMBER|右侧输精管切除长度(cm)||", scale = 4, precision = 2, nullable = true)
    private BigDecimal rVasectomyLength;

    @Column(name = "L_EPIDIDYMIS_EMBED_FLAG", columnDefinition = "CHAR|左侧附睾端包埋操作标志||", length = 1, nullable = true)
    private String lEpididymisEmbedFlag;

    @Column(name = "R_EPIDIDYMIS_EMBED_FLAG", columnDefinition = "CHAR|右侧附睾端包埋操作标志||", length = 1, nullable = true)
    private String rEpididymisEmbedFlag;

    @Column(name = "CERVICAL_DILATATION_FLAG", columnDefinition = "CHAR|宫颈扩张标志||", length = 1, nullable = true)
    private String cervicalDilatationFlag;

    @Column(name = "SEE_FLUFF_FLAG", columnDefinition = "CHAR|见到绒毛标志||", length = 1, nullable = true)
    private String seeFluffFlag;

    @Column(name = "SAC_VISIBLE_FLAG", columnDefinition = "CHAR|胚囊-可见标志||", length = 1, nullable = true)
    private String sacVisibleFlag;

    @Column(name = "SAC_AVERAGE_DIAMETER", columnDefinition = "NUMBER|胚囊-平均直径(cm)||", scale = 4, precision = 1, nullable = true)
    private BigDecimal sacAverageDiameter;

    @Column(name = "PALACE_OPERATION_FLAG", columnDefinition = "CHAR|清宫操作标志||", length = 1, nullable = true)
    private String palaceOperationFlag;

    @Column(name = "ABORTION_METHOD", columnDefinition = "VARCHAR2|流产方法代码||", length = 1, nullable = true)
    private String abortionMethod;

    @Column(name = "MEDICA_ABORTION_DRUG_TYPE", columnDefinition = "VARCHAR2|药物流产使用药物类别代码||", length = 1, nullable = true)
    private String medicaAbortionDrugType;

    @Column(name = "MEDICATION_TIME", columnDefinition = "TIMESTAMP|给(服)药时间||", nullable = true)
    private Date medicationTime;

    @Column(name = "VOMITING_TIMES", columnDefinition = "NUMBER|呕吐次数||", length = 5, nullable = true)
    private Integer vomitingTimes;

    @Column(name = "DIARRHEA_TIMES", columnDefinition = "NUMBER|腹泻次数||", length = 5, nullable = true)
    private Integer diarrheaTimes;

    @Column(name = "ABDOMINAL_PAIN", columnDefinition = "VARCHAR2|腹痛程度代码||", length = 1, nullable = true)
    private String abdominalPain;

    @Column(name = "PATHOLOGICAL_EXAM_FLAG", columnDefinition = "CHAR|病理检查-标志||", length = 1, nullable = true)
    private String pathologicalExamFlag;

    @Column(name = "PATHOLOGICAL_EXAM_RESULT", columnDefinition = "VARCHAR2|病理检查-结果||", length = 100, nullable = true)
    private String pathologicalExamResult;

    @Column(name = "DRUG_NAME", columnDefinition = "VARCHAR2|药物名称||", length = 50, nullable = true)
    private String drugName;

    @Column(name = "DRUG_USAGE", columnDefinition = "VARCHAR2|药物用法||", length = 100, nullable = true)
    private String drugUsage;

    @Column(name = "EMBRYO_SAC_DISCHARGE_DATE", columnDefinition = "TIMESTAMP|胚囊排出日期时间||", nullable = true)
    private Date embryoSacDischargeDate;

    @Column(name = "QINGGONG_DATE", columnDefinition = "DATE|清宫日期||", nullable = true)
    private Date qinggongDate;

    @Column(name = "OPERATION_NAME", columnDefinition = "VARCHAR2|手术/操作-名称||", length = 50, nullable = true)
    private String operationName;

    @Column(name = "OPERATION_PROCESS_FLAG", columnDefinition = "CHAR|手术过程顺利标志||", length = 1, nullable = true)
    private String operationProcessFlag;

    @Column(name = "OPERATION_BLEEDING", columnDefinition = "NUMBER|手术出血量(ml)||", length = 5, nullable = true)
    private Integer operationBleeding;

    @Column(name = "OPERATION_PROCESS_DESC", columnDefinition = "VARCHAR2|手术过程描述||", length = 100, nullable = true)
    private String operationProcessDesc;

    @Column(name = "OPERATION_COMPLICATIONS_FLAG", columnDefinition = "VARCHAR2|手术并发症-标志||", length = 1, nullable = true)
    private String operationComplicationsFlag;

    @Column(name = "OPERATION_COMPLICATIONS_DESC", columnDefinition = "VARCHAR2|手术并发症-详细描述||", length = 100, nullable = true)
    private String operationComplicationsDesc;

    @Column(name = "SPECIAL_CASE_RECORD", columnDefinition = "VARCHAR2|特殊情况记录||", length = 100, nullable = true)
    private String specialCaseRecord;

    @Column(name = "MG_OPINION", columnDefinition = "VARCHAR2|处理及指导意见||", length = 100, nullable = true)
    private String mgOpinion;

    @Column(name = "FOLLOWED_CHECK_RESULT", columnDefinition = "VARCHAR2|随诊检查结果||", length = 100, nullable = true)
    private String followedCheckResult;

    @Column(name = "OPERATOR_NAME", columnDefinition = "VARCHAR2|手术者姓名||", length = 30, nullable = true)
    private String operatorName;

    @Column(name = "OPERATION_UNIT_NAME", columnDefinition = "VARCHAR2|手术机构名称||", length = 70, nullable = true)
    private String operationUnitName;

    @Column(name = "OPS_DATE", columnDefinition = "DATE|手术日期||", nullable = true)
    private Date opsDate;

    @Column(name = "CHECK_NAME", columnDefinition = "VARCHAR2|检查(测)人员姓名||", length = 30, nullable = true)
    private String checkName;

    @Column(name = "CHECK_ORGAN_NAME", columnDefinition = "VARCHAR2|检查(测)机构名称||", length = 70, nullable = true)
    private String checkOrganName;

    @Column(name = "CHECK_DATE", columnDefinition = "DATE|检查(测)日期||", nullable = true)
    private Date checkDate;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;

  	@Column(name = "MOTHER_IDCARD", columnDefinition = "VARCHAR2|母亲身份证件-号码||", length = 18, nullable = true)
	private String motherIdcard;
	
	@Column(name = "BABY_CARD_NO", columnDefinition = "VARCHAR2|宝宝卡号||", length = 13, nullable = true)
	private String babyCardNo;
	
	@Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|填报机构代码||", length = 20, nullable = true)
	private String createOrganCode;
	
	@Column(name = "CREATE_ORGAN_NAME", columnDefinition = "VARCHAR2|填报机构名称||", length = 70, nullable = true)
	private String createOrganName;
	
    @Column(name = "IS_ANALYSE", columnDefinition = "NUMBER|是否处理过敏史||", length = 1, nullable = true)
    private Integer isAnalyse = -1;
	
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @XmlElement
    public String getRecordNumber() {
        return this.recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }

    @XmlElement
    public String getChiefComplaint() {
        return this.chiefComplaint;
    }

    public void setChiefComplaint(String chiefComplaint) {
        this.chiefComplaint = chiefComplaint;
    }

    @XmlElement
    public Integer getMenarcheAge() {
        return this.menarcheAge;
    }

    public void setMenarcheAge(Integer menarcheAge) {
        this.menarcheAge = menarcheAge;
    }

    @XmlElement(name = "menstrualDuration")
    public String getMenstrualDuration() {
    	return menstrualDuration;
    }
    
    
	public void setMenstrualDuration(String menstrualDuration) {
		this.menstrualDuration = menstrualDuration;
	}


	@XmlElement
	public String getMenstrualCycle() {
		return menstrualCycle;
	}
	
	public void setMenstrualCycle(String menstrualCycle) {
		this.menstrualCycle = menstrualCycle;
	}

	@XmlElement
    public String getMenstrualBleedingType() {
        return this.menstrualBleedingType;
    }

    public void setMenstrualBleedingType(String menstrualBleedingType) {
        this.menstrualBleedingType = menstrualBleedingType;
    }

    @XmlElement
    public String getDysmenorrheaDegree() {
        return this.dysmenorrheaDegree;
    }

    public void setDysmenorrheaDegree(String dysmenorrheaDegree) {
        this.dysmenorrheaDegree = dysmenorrheaDegree;
    }

    @XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    public Date getLastMenstrualDate() {
        return this.lastMenstrualDate;
    }

    public void setLastMenstrualDate(Date lastMenstrualDate) {
        this.lastMenstrualDate = lastMenstrualDate;
    }

    @XmlElement
	public Integer getGravidityTimes() {
		return gravidityTimes;
	}

	
	public void setGravidityTimes(Integer gravidityTimes) {
		this.gravidityTimes = gravidityTimes;
	}

	@XmlElement
	public Integer getProductionTimes() {
		return productionTimes;
	}

	
	public void setProductionTimes(Integer productionTimes) {
		this.productionTimes = productionTimes;
	}

	@XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
	public Date getLastPregnancyEndDate() {
        return this.lastPregnancyEndDate;
    }

    public void setLastPregnancyEndDate(Date lastPregnancyEndDate) {
        this.lastPregnancyEndDate = lastPregnancyEndDate;
    }

    @XmlElement
    public String getLastPregnancyWay() {
        return this.lastPregnancyWay;
    }

    public void setLastPregnancyWay(String lastPregnancyWay) {
        this.lastPregnancyWay = lastPregnancyWay;
    }

    @XmlElement
    public Integer getAbortionTimes() {
        return this.abortionTimes;
    }

    public void setAbortionTimes(Integer abortionTimes) {
        this.abortionTimes = abortionTimes;
    }

    @XmlElement
    public BigDecimal getTemperature() {
        return this.temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

	@XmlElement
	public String getSbp() {
		return sbp;
	}
	
	public void setSbp(String sbp) {
		this.sbp = sbp;
	}
  

    @XmlElement
	public String getDbp() {
		return dbp;
	}

	public void setDbp(String dbp) {
		this.dbp = dbp;
	}

    @XmlElement
    public String getHeartRate() {
    	return heartRate;
    }


	public void setHeartRate(String heartRate) {
		this.heartRate = heartRate;
	}
   
    @XmlElement(name = "cardiacAUSCUResult")
    public String getCardiacAuscuResult() {
		return cardiacAuscuResult;
	}

	public void setCardiacAuscuResult(String cardiacAuscuResult) {
		this.cardiacAuscuResult = cardiacAuscuResult;
	}

	@XmlElement(name = "lungAUSCUResult")
	public String getLungAuscuResult() {
		return lungAuscuResult;
	}

	public void setLungAuscuResult(String lungAuscuResult) {
		this.lungAuscuResult = lungAuscuResult;
	}

	@XmlElement
    public String getVulvaCheckResult() {
        return this.vulvaCheckResult;
    }

    public void setVulvaCheckResult(String vulvaCheckResult) {
        this.vulvaCheckResult = vulvaCheckResult;
    }

    @XmlElement
    public String getVaginaCheckResult() {
        return this.vaginaCheckResult;
    }

    public void setVaginaCheckResult(String vaginaCheckResult) {
        this.vaginaCheckResult = vaginaCheckResult;
    }

    @XmlElement
    public String getCervixCheckResult() {
        return this.cervixCheckResult;
    }

    public void setCervixCheckResult(String cervixCheckResult) {
        this.cervixCheckResult = cervixCheckResult;
    }

    @XmlElement
    public String getUterusCheckResult() {
        return this.uterusCheckResult;
    }

    public void setUterusCheckResult(String uterusCheckResult) {
        this.uterusCheckResult = uterusCheckResult;
    }

    @XmlElement
    public String getUterinePart() {
        return this.uterinePart;
    }

    public void setUterinePart(String uterinePart) {
        this.uterinePart = uterinePart;
    }

    @XmlElement
    public String getUterineSize() {
        return this.uterineSize;
    }

    public void setUterineSize(String uterineSize) {
        this.uterineSize = uterineSize;
    }

    @XmlElement
    public String getlFallopianTubeCheckResult() {
		return lFallopianTubeCheckResult;
	}

	public void setlFallopianTubeCheckResult(String lFallopianTubeCheckResult) {
		this.lFallopianTubeCheckResult = lFallopianTubeCheckResult;
	}

	@XmlElement
	public String getrFallopianTubeCheckResult() {
		return rFallopianTubeCheckResult;
	}

	public void setrFallopianTubeCheckResult(String rFallopianTubeCheckResult) {
		this.rFallopianTubeCheckResult = rFallopianTubeCheckResult;
	}

	@XmlElement
	public String getlOvaryCheckResult() {
		return lOvaryCheckResult;
	}

	public void setlOvaryCheckResult(String lOvaryCheckResult) {
		this.lOvaryCheckResult = lOvaryCheckResult;
	}

	@XmlElement
	public String getrOvaryCheckResult() {
		return rOvaryCheckResult;
	}

	public void setrOvaryCheckResult(String rOvaryCheckResult) {
		this.rOvaryCheckResult = rOvaryCheckResult;
	}

	@XmlElement
	public String getlAttachmentCheckResult() {
		return lAttachmentCheckResult;
	}

	public void setlAttachmentCheckResult(String lAttachmentCheckResult) {
		this.lAttachmentCheckResult = lAttachmentCheckResult;
	}

	@XmlElement
	public String getrAttachmentCheckResult() {
		return rAttachmentCheckResult;
	}

	public void setrAttachmentCheckResult(String rAttachmentCheckResult) {
		this.rAttachmentCheckResult = rAttachmentCheckResult;
	}

	@XmlElement
	public String getlEpididymisCheckResult() {
		return lEpididymisCheckResult;
	}

	public void setlEpididymisCheckResult(String lEpididymisCheckResult) {
		this.lEpididymisCheckResult = lEpididymisCheckResult;
	}

	@XmlElement
	public String getrEpididymisCheckResult() {
		return rEpididymisCheckResult;
	}

	public void setrEpididymisCheckResult(String rEpididymisCheckResult) {
		this.rEpididymisCheckResult = rEpididymisCheckResult;
	}

	@XmlElement
	public String getlTestisCheckResult() {
		return lTestisCheckResult;
	}

	public void setlTestisCheckResult(String lTestisCheckResult) {
		this.lTestisCheckResult = lTestisCheckResult;
	}

	@XmlElement
	public String getrTestisCheckResult() {
		return rTestisCheckResult;
	}

	public void setrTestisCheckResult(String rTestisCheckResult) {
		this.rTestisCheckResult = rTestisCheckResult;
	}

	@XmlElement
	public String getlVasDeferensCheckResult() {
		return lVasDeferensCheckResult;
	}

	public void setlVasDeferensCheckResult(String lVasDeferensCheckResult) {
		this.lVasDeferensCheckResult = lVasDeferensCheckResult;
	}

	@XmlElement
	public String getrVasDeferensCheckResult() {
		return rVasDeferensCheckResult;
	}

	public void setrVasDeferensCheckResult(String rVasDeferensCheckResult) {
		this.rVasDeferensCheckResult = rVasDeferensCheckResult;
	}

	@XmlElement
    public String getScrotumCheckResult() {
        return this.scrotumCheckResult;
    }

    public void setScrotumCheckResult(String scrotumCheckResult) {
        this.scrotumCheckResult = scrotumCheckResult;
    }

    @XmlElement
    public String getSpermaticCheckResult() {
        return this.spermaticCheckResult;
    }

    public void setSpermaticCheckResult(String spermaticCheckResult) {
        this.spermaticCheckResult = spermaticCheckResult;
    }

    @XmlElement
    public BigDecimal getErythrocyteCount() {
        return this.erythrocyteCount;
    }

    public void setErythrocyteCount(BigDecimal erythrocyteCount) {
        this.erythrocyteCount = erythrocyteCount;
    }

    @XmlElement
    public Integer getHemoglobinValue() {
        return this.hemoglobinValue;
    }

    public void setHemoglobinValue(Integer hemoglobinValue) {
        this.hemoglobinValue = hemoglobinValue;
    }

    @XmlElement
    public Integer getPlateletCount() {
        return this.plateletCount;
    }

    public void setPlateletCount(Integer plateletCount) {
        this.plateletCount = plateletCount;
    }

    @XmlElement
    public BigDecimal getLeukocyteCount() {
        return this.leukocyteCount;
    }

    public void setLeukocyteCount(BigDecimal leukocyteCount) {
        this.leukocyteCount = leukocyteCount;
    }

    @XmlElement
    public String getLeukocyteType() {
        return this.leukocyteType;
    }

    public void setLeukocyteType(String leukocyteType) {
        this.leukocyteType = leukocyteType;
    }

    @XmlElement
    public Integer getBleedingTime() {
        return this.bleedingTime;
    }

    public void setBleedingTime(Integer bleedingTime) {
        this.bleedingTime = bleedingTime;
    }

    @XmlElement
    public Integer getCoagulationTime() {
        return this.coagulationTime;
    }

    public void setCoagulationTime(Integer coagulationTime) {
        this.coagulationTime = coagulationTime;
    }

    @XmlElement
    public String getVaginaSecretionsDesc() {
		return vaginaSecretionsDesc;
	}

	public void setVaginaSecretionsDesc(String vaginaSecretionsDesc) {
		this.vaginaSecretionsDesc = vaginaSecretionsDesc;
	}

	@XmlElement
    public String getTrichomoDetectResult() {
        return this.trichomoDetectResult;
    }

    public void setTrichomoDetectResult(String trichomoDetectResult) {
        this.trichomoDetectResult = trichomoDetectResult;
    }

    @XmlElement
    public String getCandidaDetectResult() {
        return this.candidaDetectResult;
    }

    public void setCandidaDetectResult(String candidaDetectResult) {
        this.candidaDetectResult = candidaDetectResult;
    }

    @XmlElement
    public String getVaginaSecretionsCleanliness() {
		return vaginaSecretionsCleanliness;
	}

	public void setVaginaSecretionsCleanliness(String vaginaSecretionsCleanliness) {
		this.vaginaSecretionsCleanliness = vaginaSecretionsCleanliness;
	}

	@XmlElement
    public String getNGonorrhoeaeCheckResult() {
        return this.nGonorrhoeaeCheckResult;
    }

    public void setNGonorrhoeaeCheckResult(String nGonorrhoeaeCheckResult) {
        this.nGonorrhoeaeCheckResult = nGonorrhoeaeCheckResult;
    }

    @XmlElement
    public String getSyphilisSerologyCheckResult() {
        return this.syphilisSerologyCheckResult;
    }

    public void setSyphilisSerologyCheckResult(String syphilisSerologyCheckResult) {
        this.syphilisSerologyCheckResult = syphilisSerologyCheckResult;
    }

    @XmlElement
    public String getHivlgDetectResult() {
        return this.hivlgDetectResult;
    }

    public void setHivlgDetectResult(String hivlgDetectResult) {
        this.hivlgDetectResult = hivlgDetectResult;
    }

    @XmlElement
    public String getUrineTestResult() {
        return this.urineTestResult;
    }

    public void setUrineTestResult(String urineTestResult) {
        this.urineTestResult = urineTestResult;
    }
    
    @XmlElement
    public BigDecimal getSerumBhcgValue() {
		return serumBhcgValue;
	}

	public void setSerumBhcgValue(BigDecimal serumBhcgValue) {
		this.serumBhcgValue = serumBhcgValue;
	}

	@XmlElement
    public String getHbsagDetectResult() {
		return hbsagDetectResult;
	}

	public void setHbsagDetectResult(String hbsagDetectResult) {
		this.hbsagDetectResult = hbsagDetectResult;
	}

	@XmlElement
    public String getBmodeCheckResult() {
		return bmodeCheckResult;
	}

	public void setBmodeCheckResult(String bmodeCheckResult) {
		this.bmodeCheckResult = bmodeCheckResult;
	}

	@XmlElement
    public String getDiseaseDiagnosis() {
        return this.diseaseDiagnosis;
    }

    public void setDiseaseDiagnosis(String diseaseDiagnosis) {
        this.diseaseDiagnosis = diseaseDiagnosis;
    }

    @XmlElement
    public Integer getIudPlaceLife() {
        return this.iudPlaceLife;
    }

    public void setIudPlaceLife(Integer iudPlaceLife) {
        this.iudPlaceLife = iudPlaceLife;
    }

    @XmlElement
    public String getIudPlaceTime() {
        return this.iudPlaceTime;
    }

    public void setIudPlaceTime(String iudPlaceTime) {
        this.iudPlaceTime = iudPlaceTime;
    }

    @XmlElement
    public String getIudRemoveState() {
		return iudRemoveState;
	}

	public void setIudRemoveState(String iudRemoveState) {
		this.iudRemoveState = iudRemoveState;
	}

	@XmlElement
    public String getIudRemoveAnomaliesDesc() {
        return this.iudRemoveAnomaliesDesc;
    }

    public void setIudRemoveAnomaliesDesc(String iudRemoveAnomaliesDesc) {
        this.iudRemoveAnomaliesDesc = iudRemoveAnomaliesDesc;
    }

    @XmlElement
    public String getIudTypeCode() {
        return this.iudTypeCode;
    }

    public void setIudTypeCode(String iudTypeCode) {
        this.iudTypeCode = iudTypeCode;
    }

    @XmlElement
    public String getNorplantImplantsPeriod() {
        return this.norplantImplantsPeriod;
    }

    public void setNorplantImplantsPeriod(String norplantImplantsPeriod) {
        this.norplantImplantsPeriod = norplantImplantsPeriod;
    }

    @XmlElement
    public Integer getNorplantImplantsLife() {
        return this.norplantImplantsLife;
    }

    public void setNorplantImplantsLife(Integer norplantImplantsLife) {
        this.norplantImplantsLife = norplantImplantsLife;
    }

    @XmlElement
    public String getNorplantImplantsPart() {
        return this.norplantImplantsPart;
    }

    public void setNorplantImplantsPart(String norplantImplantsPart) {
        this.norplantImplantsPart = norplantImplantsPart;
    }

    @XmlElement
    public String getRemoveimplantsCheckResult() {
        return this.removeimplantsCheckResult;
    }

    public void setRemoveimplantsCheckResult(String removeimplantsCheckResult) {
        this.removeimplantsCheckResult = removeimplantsCheckResult;
    }

    @XmlElement
    public String getTubalLigationWay() {
        return this.tubalLigationWay;
    }

    public void setTubalLigationWay(String tubalLigationWay) {
        this.tubalLigationWay = tubalLigationWay;
    }

    @XmlElement
    public String getTubalLigationPart() {
        return this.tubalLigationPart;
    }

    public void setTubalLigationPart(String tubalLigationPart) {
        this.tubalLigationPart = tubalLigationPart;
    }

    @XmlElement
    public String getVasectomyWay() {
        return this.vasectomyWay;
    }

    public void setVasectomyWay(String vasectomyWay) {
        this.vasectomyWay = vasectomyWay;
    }

    @XmlElement
    public BigDecimal getlVasectomyLength() {
		return lVasectomyLength;
	}

	public void setlVasectomyLength(BigDecimal lVasectomyLength) {
		this.lVasectomyLength = lVasectomyLength;
	}

	@XmlElement
	public BigDecimal getrVasectomyLength() {
		return rVasectomyLength;
	}

	public void setrVasectomyLength(BigDecimal rVasectomyLength) {
		this.rVasectomyLength = rVasectomyLength;
	}

	@XmlElement
	public String getlEpididymisEmbedFlag() {
		return lEpididymisEmbedFlag;
	}

	public void setlEpididymisEmbedFlag(String lEpididymisEmbedFlag) {
		this.lEpididymisEmbedFlag = lEpididymisEmbedFlag;
	}

	@XmlElement
	public String getrEpididymisEmbedFlag() {
		return rEpididymisEmbedFlag;
	}

	public void setrEpididymisEmbedFlag(String rEpididymisEmbedFlag) {
		this.rEpididymisEmbedFlag = rEpididymisEmbedFlag;
	}

	@XmlElement
    public String getCervicalDilatationFlag() {
        return this.cervicalDilatationFlag;
    }

    public void setCervicalDilatationFlag(String cervicalDilatationFlag) {
        this.cervicalDilatationFlag = cervicalDilatationFlag;
    }

    @XmlElement
    public String getSeeFluffFlag() {
        return this.seeFluffFlag;
    }

    public void setSeeFluffFlag(String seeFluffFlag) {
        this.seeFluffFlag = seeFluffFlag;
    }

    @XmlElement
    public String getSacVisibleFlag() {
        return this.sacVisibleFlag;
    }

    public void setSacVisibleFlag(String sacVisibleFlag) {
        this.sacVisibleFlag = sacVisibleFlag;
    }

    @XmlElement
    public BigDecimal getSacAverageDiameter() {
        return this.sacAverageDiameter;
    }

    public void setSacAverageDiameter(BigDecimal sacAverageDiameter) {
        this.sacAverageDiameter = sacAverageDiameter;
    }

    @XmlElement
    public String getPalaceOperationFlag() {
        return this.palaceOperationFlag;
    }

    public void setPalaceOperationFlag(String palaceOperationFlag) {
        this.palaceOperationFlag = palaceOperationFlag;
    }

    @XmlElement
    public String getAbortionMethod() {
        return this.abortionMethod;
    }

    public void setAbortionMethod(String abortionMethod) {
        this.abortionMethod = abortionMethod;
    }

    @XmlElement
    public String getMedicaAbortionDrugType() {
        return this.medicaAbortionDrugType;
    }

    public void setMedicaAbortionDrugType(String medicaAbortionDrugType) {
        this.medicaAbortionDrugType = medicaAbortionDrugType;
    }

    @XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    public Date getMedicationTime() {
        return this.medicationTime;
    }

    public void setMedicationTime(Date medicationTime) {
        this.medicationTime = medicationTime;
    }

    @XmlElement
    public Integer getVomitingTimes() {
        return this.vomitingTimes;
    }

    public void setVomitingTimes(Integer vomitingTimes) {
        this.vomitingTimes = vomitingTimes;
    }

    @XmlElement
    public Integer getDiarrheaTimes() {
        return this.diarrheaTimes;
    }

    public void setDiarrheaTimes(Integer diarrheaTimes) {
        this.diarrheaTimes = diarrheaTimes;
    }

    @XmlElement
    public String getAbdominalPain() {
        return this.abdominalPain;
    }

    public void setAbdominalPain(String abdominalPain) {
        this.abdominalPain = abdominalPain;
    }

    @XmlElement
    public String getPathologicalExamFlag() {
        return this.pathologicalExamFlag;
    }

    public void setPathologicalExamFlag(String pathologicalExamFlag) {
        this.pathologicalExamFlag = pathologicalExamFlag;
    }

    @XmlElement
    public String getPathologicalExamResult() {
        return this.pathologicalExamResult;
    }

    public void setPathologicalExamResult(String pathologicalExamResult) {
        this.pathologicalExamResult = pathologicalExamResult;
    }

    @XmlElement
    public String getDrugName() {
        return this.drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    @XmlElement
    public String getDrugUsage() {
        return this.drugUsage;
    }

    public void setDrugUsage(String drugUsage) {
        this.drugUsage = drugUsage;
    }

    @XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    public Date getEmbryoSacDischargeDate() {
        return this.embryoSacDischargeDate;
    }

    public void setEmbryoSacDischargeDate(Date embryoSacDischargeDate) {
        this.embryoSacDischargeDate = embryoSacDischargeDate;
    }

    @XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    public Date getQinggongDate() {
        return this.qinggongDate;
    }

    public void setQinggongDate(Date qinggongDate) {
        this.qinggongDate = qinggongDate;
    }

    @XmlElement
    public String getOperationName() {
        return this.operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    @XmlElement
    public String getOperationProcessFlag() {
        return this.operationProcessFlag;
    }

    public void setOperationProcessFlag(String operationProcessFlag) {
        this.operationProcessFlag = operationProcessFlag;
    }

    @XmlElement
    public Integer getOperationBleeding() {
        return this.operationBleeding;
    }

    public void setOperationBleeding(Integer operationBleeding) {
        this.operationBleeding = operationBleeding;
    }

    @XmlElement
    public String getOperationProcessDesc() {
        return this.operationProcessDesc;
    }

    public void setOperationProcessDesc(String operationProcessDesc) {
        this.operationProcessDesc = operationProcessDesc;
    }

    @XmlElement
    public String getOperationComplicationsFlag() {
        return this.operationComplicationsFlag;
    }

    public void setOperationComplicationsFlag(String operationComplicationsFlag) {
        this.operationComplicationsFlag = operationComplicationsFlag;
    }

    @XmlElement
    public String getOperationComplicationsDesc() {
        return this.operationComplicationsDesc;
    }

    public void setOperationComplicationsDesc(String operationComplicationsDesc) {
        this.operationComplicationsDesc = operationComplicationsDesc;
    }

    @XmlElement
    public String getSpecialCaseRecord() {
        return this.specialCaseRecord;
    }

    public void setSpecialCaseRecord(String specialCaseRecord) {
        this.specialCaseRecord = specialCaseRecord;
    }

    @XmlElement
    public String getMgOpinion() {
        return this.mgOpinion;
    }

    public void setMgOpinion(String mgOpinion) {
        this.mgOpinion = mgOpinion;
    }

    @XmlElement
    public String getFollowedCheckResult() {
        return this.followedCheckResult;
    }

    public void setFollowedCheckResult(String followedCheckResult) {
        this.followedCheckResult = followedCheckResult;
    }

    @XmlElement
    public String getOperatorName() {
        return this.operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    @XmlElement
    public String getOperationUnitName() {
        return this.operationUnitName;
    }

    public void setOperationUnitName(String operationUnitName) {
        this.operationUnitName = operationUnitName;
    }

    @XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    public Date getOpsDate() {
		return opsDate;
	}

	public void setOpsDate(Date opsDate) {
		this.opsDate = opsDate;
	}

    @XmlElement
    public String getCheckName() {
        return this.checkName;
    }
    
	public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    @XmlElement
    public String getCheckOrganName() {
        return this.checkOrganName;
    }

    public void setCheckOrganName(String checkOrganName) {
        this.checkOrganName = checkOrganName;
    }

    @XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    public Date getCheckDate() {
        return this.checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement
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

	@XmlElement
	public String getHealthFileNo() {
		return healthFileNo;
	}

	
	public void setHealthFileNo(String healthFileNo) {
		this.healthFileNo = healthFileNo;
	}

	@XmlElement
	public String getEhrNo() {
		return ehrNo;
	}

	
	public void setEhrNo(String ehrNo) {
		this.ehrNo = ehrNo;
	}

	@XmlElement
	public String getAdmissionNo() {
		return admissionNo;
	}

	
	public void setAdmissionNo(String admissionNo) {
		this.admissionNo = admissionNo;
	}

	@XmlElement
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
	public Date getBirthday() {
		return birthday;
	}

	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@XmlElement
	public String getPhoneNumber() {
		return phoneNumber;
	}

	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@XmlElement
	public String getOccupation() {
		return occupation;
	}

	
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	@XmlElement
	public String getUnitName() {
		return unitName;
	}

	
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	@XmlElement
	public String getMarriage() {
		return marriage;
	}

	
	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	@XmlElement
	public String getAreaCode() {
		return areaCode;
	}

	
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	@XmlElement
	public String getHrstreet() {
		return hrstreet;
	}

	
	public void setHrstreet(String hrstreet) {
		this.hrstreet = hrstreet;
	}

	@XmlElement
	public String getHrhouseNumber() {
		return hrhouseNumber;
	}

	
	public void setHrhouseNumber(String hrhouseNumber) {
		this.hrhouseNumber = hrhouseNumber;
	}

	@XmlElement
	public String getHrprovince() {
		return hrprovince;
	}

	
	public void setHrprovince(String hrprovince) {
		this.hrprovince = hrprovince;
	}

	@XmlElement
	public String getHrcity() {
		return hrcity;
	}

	
	public void setHrcity(String hrcity) {
		this.hrcity = hrcity;
	}

	@XmlElement
	public String getHrcounty() {
		return hrcounty;
	}

	
	public void setHrcounty(String hrcounty) {
		this.hrcounty = hrcounty;
	}

	@XmlElement
	public String getHrtownShip() {
		return hrtownShip;
	}

	
	public void setHrtownShip(String hrtownShip) {
		this.hrtownShip = hrtownShip;
	}

	@XmlElement
	public String getHrpostCode() {
		return hrpostCode;
	}

	
	public void setHrpostCode(String hrpostCode) {
		this.hrpostCode = hrpostCode;
	}

	@XmlElement
	public String getPastreet() {
		return pastreet;
	}

	
	public void setPastreet(String pastreet) {
		this.pastreet = pastreet;
	}

	@XmlElement
	public String getPahouseNumber() {
		return pahouseNumber;
	}

	
	public void setPahouseNumber(String pahouseNumber) {
		this.pahouseNumber = pahouseNumber;
	}

	@XmlElement
	public String getPaprovince() {
		return paprovince;
	}

	
	public void setPaprovince(String paprovince) {
		this.paprovince = paprovince;
	}

	@XmlElement
	public String getPacity() {
		return pacity;
	}

	
	public void setPacity(String pacity) {
		this.pacity = pacity;
	}

	@XmlElement
	public String getPacounty() {
		return pacounty;
	}

	
	public void setPacounty(String pacounty) {
		this.pacounty = pacounty;
	}

	@XmlElement
	public String getPatownShip() {
		return patownShip;
	}

	
	public void setPatownShip(String patownShip) {
		this.patownShip = patownShip;
	}

	@XmlElement
	public String getPapostCode() {
		return papostCode;
	}

	
	public void setPapostCode(String papostCode) {
		this.papostCode = papostCode;
	}

	@XmlElement
	public String getPastMedicalHistory() {
		return pastMedicalHistory;
	}

	
	public void setPastMedicalHistory(String pastMedicalHistory) {
		this.pastMedicalHistory = pastMedicalHistory;
	}

	@XmlElement
	public String getAllergicHistory() {
		return allergicHistory;
	}

	
	public void setAllergicHistory(String allergicHistory) {
		this.allergicHistory = allergicHistory;
	}

	@XmlElement
	public String getContraceptiveHistory() {
		return contraceptiveHistory;
	}

	
	public void setContraceptiveHistory(String contraceptiveHistory) {
		this.contraceptiveHistory = contraceptiveHistory;
	}

	@XmlElement
	public String getnGonorrhoeaeCheckResult() {
		return nGonorrhoeaeCheckResult;
	}

	
	public void setnGonorrhoeaeCheckResult(String nGonorrhoeaeCheckResult) {
		this.nGonorrhoeaeCheckResult = nGonorrhoeaeCheckResult;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	@XmlElement
	public String getMotherIdcard() {
		return motherIdcard;
	}

	public void setMotherIdcard(String motherIdcard) {
		this.motherIdcard = motherIdcard;
	}

	@XmlElement
	public String getBabyCardNo() {
		return babyCardNo;
	}

	public void setBabyCardNo(String babyCardNo) {
		this.babyCardNo = babyCardNo;
	}

	@XmlElement
	public String getCreateOrganCode() {
		return createOrganCode;
	}

	public void setCreateOrganCode(String createOrganCode) {
		this.createOrganCode = createOrganCode;
	}

	@XmlElement
	public String getCreateOrganName() {
		return createOrganName;
	}

	public void setCreateOrganName(String createOrganName) {
		this.createOrganName = createOrganName;
	}

	
	public Integer getIsAnalyse() {
		return isAnalyse;
	}

	
	public void setIsAnalyse(Integer isAnalyse) {
		this.isAnalyse = isAnalyse;
	}
	
	
}
