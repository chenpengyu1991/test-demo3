package com.founder.rhip.ehr.entity.women;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "WH_PREMARITAL_HEALTH_SERVICE")
@XmlRootElement
public class PremaritalHealthService implements Serializable {

    private static final long serialVersionUID = -1875328179556938368L;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = false)
    private String ehrId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    /**
     * 人员编码
     */
    @Column(name = "PERSON_ID")
    private Long personId;

    /**
     * 记录表单编号
     */
    @Column(name = "RECORD_NUMBER")
    private String recordNumber;

    /**
     * 城乡居民健康档案编号
     */
    @Column(name = "HEALTH_FILE_NO")
    private String healthFileNo;

    /**
     * 姓名
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 身份证件号码
     */
    @Column(name = "ID_CARD")
    private String idCard;

    /**
     * 出生日期
     */
    @Column(name = "BIRTHDAY")
    private Date birthday;

    /**
     * 民族代码
     */
    @Column(name = "NATION")
    private String nation;

    /**
     * 文化程度代码
     */
    @Column(name = "EDUCATION")
    private String education;

    /**
     * 国籍代码
     */
    @Column(name = "NATIONALITY_CODE")
    private String nationalityCode;

    /**
     * 本人电话号码
     */
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    /**
     * 职业类别代码(国标)
     */
    @Column(name = "OCCUPATION")
    private String occupation;

    /**
     * 工作单位名称
     */
    @Column(name = "UNIT_NAME")
    private String unitName;

    /**
     * 身份证件-类别代码
     */
    @Column(name = "IDCARD_TYPE")
    private String idcardType;

    /**
     * 行政区划代码
     */
    @Column(name = "AREA_CODE")
    private String areaCode;

    /**
     * 户籍地址-村(街、路、弄等)
     */
    @Column(name = "HRSTREET")
    private String hrstreet;

    /**
     * 户籍地址-门牌号码
     */
    @Column(name = "HRHOUSE_NUMBER")
    private String hrhouseNumber;

    /**
     * 户籍地址-省(自治区、直辖市)
     */
    @Column(name = "HRPROVINCE")
    private String hrprovince;

    /**
     * 户籍地址-市(地区、州)
     */
    @Column(name = "HRCITY")
    private String hrcity;

    /**
     * 户籍地址-县(区)
     */
    @Column(name = "HRCOUNTY")
    private String hrcounty;

    /**
     * 户籍地址-乡(镇、街道办事处)
     */
    @Column(name = "HRTOWN_SHIP")
    private String hrtownShip;

    /**
     * 户籍地址邮政编码
     */
    @Column(name = "HRPOST_CODE")
    private String hrpostCode;

    /**
     * 现住址-村(街、路、弄等)
     */
    @Column(name = "PASTREET")
    private String pastreet;

    /**
     * 现住址-门牌号码
     */
    @Column(name = "PAHOUSE_NUMBER")
    private String pahouseNumber;

    /**
     * 现住址-省(自治区、直辖市)
     */
    @Column(name = "PAPROVINCE")
    private String paprovince;

    /**
     * 现住址-市(地区、州)
     */
    @Column(name = "PACITY")
    private String pacity;

    /**
     * 现住址-县(区)
     */
    @Column(name = "PACOUNTY")
    private String pacounty;

    /**
     * 现住址-乡(镇、街道办事处)
     */
    @Column(name = "PATOWN_SHIP")
    private String patownShip;

    /**
     * 现住址邮政编码
     */
    @Column(name = "PAPOST_CODE")
    private String papostCode;

    /**
     * 对方记录表单编号
     */
    @Column(name = "OTHER_RECORD_NUMBER")
    private String otherRecordNumber;

    /**
     * 对方姓名
     */
    @Column(name = "OTHER_NAME")
    private String otherName;

    /**
     * 身高(cm)
     */
    @Column(name = "HEIGHT")
    private BigDecimal height;

    /**
     * 体重(kg)
     */
    @Column(name = "BODY_WEIGHT")
    private BigDecimal bodyWeight;

    /**
     * ABO血型代码
     */
    @Column(name = "ABO_BLOOD_TYPE")
    private String aboBloodType;

    /**
     * Rh血型代码
     */
    @Column(name = "RH_BLOOD_TYPE")
    private String rhBloodType;

    /**
     * 血缘关系代码
     */
    @Column(name = "BLOOD_RELATION")
    private String bloodRelation;

    /**
     * 既往疾病史
     */
    @Column(name = "PAST_MEDICAL_HISTORY")
    private String pastMedicalHistory;

    /**
     * 手术史
     */
    @Column(name = "OPERATION_HISTORY")
    private String operationHistory;

    /**
     * 现病史
     */
    @Column(name = "PRESENT_HISTORY")
    private String presentHistory;

    /**
     * 家族遗传性疾病史
     */
    @Column(name = "FAMILY_GENE_DISEASE_HISTORY")
    private String familyGeneDiseaseHistory;

    /**
     * 患者与本人关系代码
     */
    @Column(name = "PATIENT_RELATION")
    private String patientRelation;

    /**
     * 初潮年龄(岁)
     */
    @Column(name = "MENARCHE_AGE")
    private Integer menarcheAge;

    /**
     * 月经持续时间(d)
     */
    @Column(name = "MENSTRUAL_DURATION")
    private String menstrualDuration;

    /**
     * 月经出血量类别代码
     */
    @Column(name = "MENSTRUAL_BLEEDING_TYPE")
    private String menstrualBleedingType;

    /**
     * 月经周期(d)
     */
    @Column(name = "MENSTRUAL_CYCLE")
    private String menstrualCycle;

    /**
     * 痛经程度代码
     */
    @Column(name = "DYSMENORRHEA_DEGREE")
    private String dysmenorrheaDegree;

    /**
     * 末次月经日期
     */
    @Column(name = "LAST_MENSTRUAL_DATE")
    private Date lastMenstrualDate;

    /**
     * 足月产次数
     */
    @Column(name = "FULL_TERM_TIMES")
    private Integer fullTermTimes;

    /**
     * 早产次数
     */
    @Column(name = "PREMATURE_DELIVERY_TIMES")
    private Integer prematureDeliveryTimes;

    /**
     * 流产总次数
     */
    @Column(name = "ABORTION_TIMES")
    private Integer abortionTimes;

    /**
     * 婚姻状况类别代码
     */
    @Column(name = "MARRIAGE")
    private String marriage;

    /**
     * 生育女数
     */
    @Column(name = "BIRTH_WOMEN_NUMBER")
    private Integer birthWomenNumber;

    /**
     * 生育子数
     */
    @Column(name = "BIRTH_FERTILITY_NUMBER")
    private Integer birthFertilityNumber;

    /**
     * 子女患遗传性疾病情况
     */
    @Column(name = "GENETIC_DISEASE_STATE")
    private String geneticDiseaseState;

    /**
     * 家族近亲婚配标志
     */
    @Column(name = "FAMILY_MARRIAGE_FLAG")
    private String familyMarriageFlag;

    /**
     * 家族近亲婚配者与本人关系代码
     */
    @Column(name = "FAMILY_KIN_MARRIAGE_RELATION")
    private String familyKinMarriageRelation;

    /**
     * 收缩压(mmHg)
     */
    @Column(name = "SBP")
    private String sbp;

    /**
     * 舒张压(mmHg)
     */
    @Column(name = "DBP")
    private String dbp;

    /**
     * 特殊体态检查结果
     */
    @Column(name = "SPECIAL_BODY_CHECK_RESULT")
    private String specialBodyCheckResult;

    /**
     * 精神状态代码
     */
    @Column(name = "MENTAL_STATE_CODE")
    private String mentalStateCode;

    /**
     * 特殊面容检查结果
     */
    @Column(name = "SPECIAL_FACE_CHECK_RESULT")
    private String specialFaceCheckResult;

    /**
     * 五官检查结果
     */
    @Column(name = "FACIAL_FEATURES_CHECK_RESULT")
    private String facialFeaturesCheckResult;

    /**
     * 智力发育
     */
    @Column(name = "MENTAL_DEVELOPMENT")
    private String mentalDevelopment;

    /**
     * 心律
     */
    @Column(name = "CARDIOVERTER")
    private String cardioverter;

    /**
     * 心率(次/分钟)
     */
    @Column(name = "HEART_RATE")
    private String heartRate;

    /**
     * 心脏听诊结果
     */
    @Column(name = "CARDIAC_AUSCU_RESULT")
    private String cardiacAuscuResult;

    /**
     * 肺部听诊结果
     */
    @Column(name = "LUNG_AUSCU_RESULT")
    private String lungAuscuResult;

    /**
     * 肝脏触诊结果
     */
    @Column(name = "LIVER_PALP_RESULT")
    private String liverPalpResult;

    /**
     * 四肢检查结果
     */
    @Column(name = "LIMBS_CHECK_RESULT")
    private String limbsCheckResult;

    /**
     * 脊柱检查结果
     */
    @Column(name = "SPINE_CHECK_RESULT")
    private String spineCheckResult;

    /**
     * 皮肤毛发检查结果
     */
    @Column(name = "SKIN_HAIR_CHECK_RESULT")
    private String skinHairCheckResult;

    /**
     * 甲状腺检查结果
     */
    @Column(name = "THYROID_CHECK_RESULT")
    private String thyroidCheckResult;

    /**
     * 阴茎检查结果
     */
    @Column(name = "PENIS_CHECK_RESULT")
    private String penisCheckResult;

    /**
     * 包皮检查结果代码
     */
    @Column(name = "PREPUCE_CHECK_RESULT")
    private String prepuceCheckResult;

    /**
     * 左侧睾丸检查结果代码
     */
    @Column(name = "L_TESTIS_CHECK_RESULT")
    private String lTestisCheckResult;

    /**
     * 右侧睾丸检查结果代码
     */
    @Column(name = "R_TESTIS_CHECK_RESULT")
    private String rTestisCheckResult;

    /**
     * 左侧附睾检查结果代码
     */
    @Column(name = "L_EPIDIDYMIS_CHECK_RESULT")
    private String lEpididymisCheckResult;

    /**
     * 右侧附睾检查结果代码
     */
    @Column(name = "R_EPIDIDYMIS_CHECK_RESULT")
    private String rEpididymisCheckResult;

    /**
     * 附睾异常情况
     */
    @Column(name = "EPIDIDYMAL_ABNORMALITIES")
    private String epididymalAbnormalities;

    /**
     * 喉结检查结果
     */
    @Column(name = "ADAM_APPLE_CHECK_RESULT")
    private String adamAppleCheckResult;

    /**
     * 精索静脉曲张-标志
     */
    @Column(name = "VARICOCELE_FLAG")
    private String varicoceleFlag;

    /**
     * 精索静脉曲张-部位
     */
    @Column(name = "VARICOCELE_PART")
    private String varicocelePart;

    /**
     * 精索静脉曲张-程度代码
     */
    @Column(name = "VARICOCELE_DEGREE")
    private String varicoceleDegree;

    /**
     * 妇科检查方式代码
     */
    @Column(name = "GYNAECOLOGY_EXAM_WAY")
    private String gynaecologyExamWay;

    /**
     * 知情同意标志
     */
    @Column(name = "INFORMED_CONSENT_FLAG")
    private String informedConsentFlag;

    /**
     * 阴毛检查结果
     */
    @Column(name = "PUBES_CHECK_RESULT")
    private String pubesCheckResult;

    /**
     * 外阴检查结果
     */
    @Column(name = "VULVA_CHECK_RESULT")
    private String vulvaCheckResult;

    /**
     * 阴道检查结果
     */
    @Column(name = "VAGINA_CHECK_RESULT")
    private String vaginaCheckResult;

    /**
     * 子宫检查结果
     */
    @Column(name = "UTERUS_CHECK_RESULT")
    private String uterusCheckResult;

    /**
     * 左侧附件检查结果代码
     */
    @Column(name = "L_ATTACHMENT_CHECK_RESULT")
    private String lAttachmentCheckResult;

    /**
     * 右侧附件检查结果代码
     */
    @Column(name = "R_ATTACHMENT_CHECK_RESULT")
    private String rAttachmentCheckResult;

    /**
     * 宫颈检查结果
     */
    @Column(name = "CERVIX_CHECK_RESULT")
    private String cervixCheckResult;

    /**
     * 左侧乳腺检查结果代码
     */
    @Column(name = "L_BREAST_CHECK_RESULT")
    private String lBreastCheckResult;

    /**
     * 右侧乳腺检查结果代码
     */
    @Column(name = "R_BREAST_CHECK_RESULT")
    private String rBreastCheckResult;

    /**
     * 阴道分泌物性状描述
     */
    @Column(name = "VAGINA_SECRETIONS_DESC")
    private String vaginaSecretionsDesc;

    /**
     * 胸部X线检查结果
     */
    @Column(name = "CHEST_X_CHECK_RESULT")
    private String chestXCheckResult;

    /**
     * 白细胞分类结果
     */
    @Column(name = "LEUKOCYTE_TYPE")
    private String leukocyteType;

    /**
     * 白细胞计数值(G/L)
     */
    @Column(name = "LEUKOCYTE_COUNT")
    private BigDecimal leukocyteCount;

    /**
     * 红细胞计数值(G/L)
     */
    @Column(name = "ERYTHROCYTE_COUNT")
    private BigDecimal erythrocyteCount;

    /**
     * 血红蛋白值(g/L)
     */
    @Column(name = "HEMOGLOBIN_VALUE")
    private Integer hemoglobinValue;

    /**
     * 血小板计数值(G/L)
     */
    @Column(name = "PLATELET_COUNT")
    private Integer plateletCount;

    /**
     * 尿比重
     */
    @Column(name = "URINE_PROPORTION")
    private BigDecimal urineProportion;

    /**
     * 尿蛋白定量检测值(mg/24h)
     */
    @Column(name = "URINE_PRO_QUANTITATIVE_VALUE")
    private BigDecimal urineProQuantitativeValue;

    /**
     * 尿糖定量检测(mmol/L)
     */
    @Column(name = "URINE_SUG_QUANTITATIVE_DETECT")
    private BigDecimal urineSugQuantitativeDetect;

    /**
     * 尿液酸碱度
     */
    @Column(name = "URINE_PH")
    private BigDecimal urinePh;

    /**
     * 血清谷丙转氨酶值(U/L)
     */
    @Column(name = "SERUM_GPT_VALUE")
    private Integer serumGptValue;

    /**
     * 乙型肝炎病毒表面抗原检测结果代码
     */
    @Column(name = "HBSAG_DETECT_RESULT")
    private String hbsagDetectResult;

    /**
     * 淋球菌检查结果
     */
    @Column(name = "N_GONORRHOEAE_CHECK_RESULT")
    private String nGonorrhoeaeCheckResult;

    /**
     * 梅毒血清学试验结果代码
     */
    @Column(name = "SYPHILIS_SEROLOGY_CHECK_RESULT")
    private String syphilisSerologyCheckResult;

    /**
     * HIV抗体检测结果代码
     */
    @Column(name = "HIVLG_DETECT_RESULT")
    private String hivlgDetectResult;

    /**
     * 滴虫检测结果代码
     */
    @Column(name = "TRICHOMO_DETECT_RESULT")
    private String trichomoDetectResult;

    /**
     * 念珠菌检测结果代码
     */
    @Column(name = "CANDIDA_DETECT_RESULT")
    private String candidaDetectResult;

    /**
     * 阴道分泌物清洁度代码
     */
    @Column(name = "VAGINA_SECRETIONS_CLEANLINESS")
    private String vaginaSecretionsCleanliness;

    /**
     * 疾病诊断代码
     */
    @Column(name = "DISEASE_DIAGNOSIS_CODE")
    private String diseaseDiagnosisCode;

    /**
     * 婚前医学检查结果代码
     */
    @Column(name = "PRE_MEDICAL_CHECK_RESULT")
    private String preMedicalCheckResult;

    /**
     * 婚检医学意见代码
     */
    @Column(name = "PRE_MEDICAL_OPINION")
    private String preMedicalOpinion;

    /**
     * 婚前卫生指导内容
     */
    @Column(name = "PRE_HEALTH_GUIDANCE")
    private String preHealthGuidance;

    /**
     * 婚前卫生咨询内容
     */
    @Column(name = "PRE_HEALTH_ADVISORY")
    private String preHealthAdvisory;

    /**
     * 婚检咨询指导结果代码
     */
    @Column(name = "PRE_CONSULTATION_GUID_RESULT")
    private String preConsultationGuidResult;

    /**
     * 检查(测)日期
     */
    @Column(name = "CHECK_DATE")
    private Date checkDate;

    /**
     * 检查(测)人员姓名
     */
    @Column(name = "CHECK_NAME")
    private String checkName;

    /**
     * 检查(测)机构名称
     */
    @Column(name = "CHECK_ORGAN_NAME")
    private String checkOrganName;

    /**
     * 填报日期
     */
    @Column(name = "FILL_DATE")
    private Date fillDate;

    /**
     * 首诊医师姓名
     */
    @Column(name = "FIRST_VISIT_DOCTOR_NAME")
    private String firstVisitDoctorName;

    /**
     * 主检医师姓名
     */
    @Column(name = "MASTER_DOCTOR_NAME")
    private String masterDoctorName;

    /**
     * 转诊日期
     */
    @Column(name = "REFERRAL_DATE")
    private Date referralDate;

    /**
     * 转入医院名称
     */
    @Column(name = "REFERRAL_HOSPITAL_NAME")
    private String referralHospitalName;

    /**
     * 预约日期
     */
    @Column(name = "RESERVE_DATE")
    private Date reserveDate;

    /**
     * 出具《婚前医学检查证明》日期
     */
    @Column(name = "ISSUED_DATE")
    private Date issuedDate;

    /**
     * 删除状态
     */
    @Column(name = "IS_DELETE")
    private Integer isDelete;

    /**
     * 母亲身份证件-号码
     */
    @Column(name = "MOTHER_IDCARD")
    private String motherIdcard;

    /**
     * 宝宝卡号
     */
    @Column(name = "BABY_CARD_NO")
    private String babyCardNo;

    /**
     * 填报机构代码
     */
    @Column(name = "CREATE_ORGAN_CODE")
    private String createOrganCode;

    /**
     * 填报机构名称
     */
    @Column(name = "CREATE_ORGAN_NAME")
    private String createOrganName;

    /**
     * 处理状态
     */
    @Column(name = "PROCESS_STATUS")
    private String processStatus;

    /**
     * 采集日期
     */
    @Column(name = "GATHER_DATE")
    private Date gatherDate;

    /**
     * 检查人员工号
     */
    @Column(name = "CHECK_JOB_NUMBER")
    private String checkJobNumber;

    /**
     * 检查人员身份证
     */
    @Column(name = "CHECK_IDCARD")
    private String checkIdcard;

    @Transient
    private String menstrualBleedingTypeDesc;

    @Transient
    private String dysmenorrheaDegreeDesc;

    @Transient
    private String lastMenstrualDateDesc;

    @Transient
    private String patientRelationDesc;

    @Transient
    private String familyKinMarriageRelationDesc;

    @Transient
    private String specialBodyCheckResultDesc;

    @Transient
    private String specialFaceCheckResultDesc;

    @Transient
    private String facialFeaturesCheckResultDesc;

    @Transient
    private String mentalDevelopmentDesc;

    @Transient
    private String lungAuscuResultDesc;

    @Transient
    private String liverPalpResultDesc;

    @Transient
    private String uterusCheckResultDesc;

    @Transient
    private String syphilisSerologyCheckResultDesc;

    @Transient
    private String hivlgDetectResultDesc;

    @Transient
    private String checkDateDesc;

    @Transient
    private String bloodRelationDesc;

    @Transient
    private String mentalStateCodeDesc;

    @Transient
    private String cardioverterDesc;

    public Date getGatherDate() {
        return gatherDate;
    }

    public String getCheckJobNumber() {
        return checkJobNumber;
    }

    public String getCheckIdcard() {
        return checkIdcard;
    }

    public void setGatherDate(Date gatherDate) {
        this.gatherDate = gatherDate;
    }

    public void setCheckJobNumber(String checkJobNumber) {
        this.checkJobNumber = checkJobNumber;
    }

    public void setCheckIdcard(String checkIdcard) {
        this.checkIdcard = checkIdcard;
    }

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
    public String getHealthFileNo() {
        return this.healthFileNo;
    }

    public void setHealthFileNo(String healthFileNo) {
        this.healthFileNo = healthFileNo;
    }

    @XmlElement
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @XmlElement
    public String getNation() {
        return this.nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @XmlElement
    public String getEducation() {
        return this.education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @XmlElement
    public String getNationalityCode() {
        return this.nationalityCode;
    }

    public void setNationalityCode(String nationalityCode) {
        this.nationalityCode = nationalityCode;
    }

    @XmlElement
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @XmlElement
    public String getOccupation() {
        return this.occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @XmlElement
    public String getUnitName() {
        return this.unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    @XmlElement(name = "idCardType")
    public String getIdcardType() {
        return idcardType;
    }

    public void setIdcardType(String idcardType) {
        this.idcardType = idcardType;
    }

    @XmlElement
    public String getIdCard() {
        return idCard;
    }


    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }


    @XmlElement
    public String getAreaCode() {
        return this.areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    @XmlElement
    public String getHrstreet() {
        return this.hrstreet;
    }

    public void setHrstreet(String hrstreet) {
        this.hrstreet = hrstreet;
    }

    @XmlElement
    public String getHrhouseNumber() {
        return this.hrhouseNumber;
    }

    public void setHrhouseNumber(String hrhouseNumber) {
        this.hrhouseNumber = hrhouseNumber;
    }

    @XmlElement
    public String getHrprovince() {
        return this.hrprovince;
    }

    public void setHrprovince(String hrprovince) {
        this.hrprovince = hrprovince;
    }

    @XmlElement
    public String getHrcity() {
        return this.hrcity;
    }

    public void setHrcity(String hrcity) {
        this.hrcity = hrcity;
    }

    @XmlElement
    public String getHrcounty() {
        return this.hrcounty;
    }

    public void setHrcounty(String hrcounty) {
        this.hrcounty = hrcounty;
    }

    @XmlElement
    public String getHrtownShip() {
        return this.hrtownShip;
    }

    public void setHrtownShip(String hrtownShip) {
        this.hrtownShip = hrtownShip;
    }

    @XmlElement
    public String getHrpostCode() {
        return this.hrpostCode;
    }

    public void setHrpostCode(String hrpostCode) {
        this.hrpostCode = hrpostCode;
    }

    @XmlElement
    public String getPastreet() {
        return this.pastreet;
    }

    public void setPastreet(String pastreet) {
        this.pastreet = pastreet;
    }

    @XmlElement
    public String getPahouseNumber() {
        return this.pahouseNumber;
    }

    public void setPahouseNumber(String pahouseNumber) {
        this.pahouseNumber = pahouseNumber;
    }

    @XmlElement
    public String getPaprovince() {
        return this.paprovince;
    }

    public void setPaprovince(String paprovince) {
        this.paprovince = paprovince;
    }

    @XmlElement
    public String getPacity() {
        return this.pacity;
    }

    public void setPacity(String pacity) {
        this.pacity = pacity;
    }

    @XmlElement
    public String getPacounty() {
        return this.pacounty;
    }

    public void setPacounty(String pacounty) {
        this.pacounty = pacounty;
    }

    @XmlElement
    public String getPatownShip() {
        return this.patownShip;
    }

    public void setPatownShip(String patownShip) {
        this.patownShip = patownShip;
    }

    @XmlElement
    public String getPapostCode() {
        return this.papostCode;
    }

    public void setPapostCode(String papostCode) {
        this.papostCode = papostCode;
    }

    @XmlElement
    public String getOtherRecordNumber() {
        return this.otherRecordNumber;
    }

    public void setOtherRecordNumber(String otherRecordNumber) {
        this.otherRecordNumber = otherRecordNumber;
    }

    @XmlElement
    public String getOtherName() {
        return this.otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    @XmlElement
    public BigDecimal getHeight() {
        return this.height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    @XmlElement
    public BigDecimal getBodyWeight() {
        return this.bodyWeight;
    }

    public void setBodyWeight(BigDecimal bodyWeight) {
        this.bodyWeight = bodyWeight;
    }

    @XmlElement
    public String getAboBloodType() {
        return aboBloodType;
    }

    public void setAboBloodType(String aboBloodType) {
        this.aboBloodType = aboBloodType;
    }

    @XmlElement
    public String getRhBloodType() {
        return this.rhBloodType;
    }

    public void setRhBloodType(String rhBloodType) {
        this.rhBloodType = rhBloodType;
    }

    @XmlElement
    public String getBloodRelation() {
        return this.bloodRelation;
    }

    public void setBloodRelation(String bloodRelation) {
        this.bloodRelation = bloodRelation;
    }

    @XmlElement
    public String getPastMedicalHistory() {
        return this.pastMedicalHistory;
    }

    public void setPastMedicalHistory(String pastMedicalHistory) {
        this.pastMedicalHistory = pastMedicalHistory;
    }

    @XmlElement
    public String getOperationHistory() {
        return this.operationHistory;
    }

    public void setOperationHistory(String operationHistory) {
        this.operationHistory = operationHistory;
    }

    @XmlElement
    public String getPresentHistory() {
        return this.presentHistory;
    }

    public void setPresentHistory(String presentHistory) {
        this.presentHistory = presentHistory;
    }

    @XmlElement
    public String getFamilyGeneDiseaseHistory() {
        return familyGeneDiseaseHistory;
    }

    public void setFamilyGeneDiseaseHistory(String familyGeneDiseaseHistory) {
        this.familyGeneDiseaseHistory = familyGeneDiseaseHistory;
    }

    @XmlElement
    public String getPatientRelation() {
        return this.patientRelation;
    }

    public void setPatientRelation(String patientRelation) {
        this.patientRelation = patientRelation;
    }

    @XmlElement
    public Integer getMenarcheAge() {
        return this.menarcheAge;
    }

    public void setMenarcheAge(Integer menarcheAge) {
        this.menarcheAge = menarcheAge;
    }

    @XmlElement
    public String getMenstrualDuration() {
        return menstrualDuration;
    }

    public void setMenstrualDuration(String menstrualDuration) {
        this.menstrualDuration = menstrualDuration;
    }

    @XmlElement
    public String getMenstrualBleedingType() {
        return this.menstrualBleedingType;
    }

    public void setMenstrualBleedingType(String menstrualBleedingType) {
        this.menstrualBleedingType = menstrualBleedingType;
    }

    @XmlElement
    public String getMenstrualCycle() {
        return menstrualCycle;
    }

    public void setMenstrualCycle(String menstrualCycle) {
        this.menstrualCycle = menstrualCycle;
    }

    @XmlElement
    public String getDysmenorrheaDegree() {
        return this.dysmenorrheaDegree;
    }

    public void setDysmenorrheaDegree(String dysmenorrheaDegree) {
        this.dysmenorrheaDegree = dysmenorrheaDegree;
    }

    public Date getLastMenstrualDate() {
        return this.lastMenstrualDate;
    }

    public void setLastMenstrualDate(Date lastMenstrualDate) {
        this.lastMenstrualDate = lastMenstrualDate;
    }

    @XmlElement
    public Integer getFullTermTimes() {
        return this.fullTermTimes;
    }

    public void setFullTermTimes(Integer fullTermTimes) {
        this.fullTermTimes = fullTermTimes;
    }

    @XmlElement
    public Integer getPrematureDeliveryTimes() {
        return this.prematureDeliveryTimes;
    }

    public void setPrematureDeliveryTimes(Integer prematureDeliveryTimes) {
        this.prematureDeliveryTimes = prematureDeliveryTimes;
    }

    @XmlElement
    public Integer getAbortionTimes() {
        return this.abortionTimes;
    }

    public void setAbortionTimes(Integer abortionTimes) {
        this.abortionTimes = abortionTimes;
    }

    @XmlElement
    public String getMarriage() {
        return this.marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    @XmlElement
    public Integer getBirthWomenNumber() {
        return this.birthWomenNumber;
    }

    public void setBirthWomenNumber(Integer birthWomenNumber) {
        this.birthWomenNumber = birthWomenNumber;
    }

    @XmlElement
    public Integer getBirthFertilityNumber() {
        return this.birthFertilityNumber;
    }

    public void setBirthFertilityNumber(Integer birthFertilityNumber) {
        this.birthFertilityNumber = birthFertilityNumber;
    }

    @XmlElement
    public String getGeneticDiseaseState() {
        return geneticDiseaseState;
    }

    public void setGeneticDiseaseState(String geneticDiseaseState) {
        this.geneticDiseaseState = geneticDiseaseState;
    }

    @XmlElement
    public String getFamilyMarriageFlag() {
        return this.familyMarriageFlag;
    }

    public void setFamilyMarriageFlag(String familyMarriageFlag) {
        this.familyMarriageFlag = familyMarriageFlag;
    }

    @XmlElement
    public String getFamilyKinMarriageRelation() {
        return this.familyKinMarriageRelation;
    }

    public void setFamilyKinMarriageRelation(String familyKinMarriageRelation) {
        this.familyKinMarriageRelation = familyKinMarriageRelation;
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
    public String getSpecialBodyCheckResult() {
        return this.specialBodyCheckResult;
    }

    public void setSpecialBodyCheckResult(String specialBodyCheckResult) {
        this.specialBodyCheckResult = specialBodyCheckResult;
    }

    @XmlElement
    public String getMentalStateCode() {
        return this.mentalStateCode;
    }

    public void setMentalStateCode(String mentalStateCode) {
        this.mentalStateCode = mentalStateCode;
    }

    @XmlElement
    public String getSpecialFaceCheckResult() {
        return this.specialFaceCheckResult;
    }

    public void setSpecialFaceCheckResult(String specialFaceCheckResult) {
        this.specialFaceCheckResult = specialFaceCheckResult;
    }

    @XmlElement
    public String getFacialFeaturesCheckResult() {
        return this.facialFeaturesCheckResult;
    }

    public void setFacialFeaturesCheckResult(String facialFeaturesCheckResult) {
        this.facialFeaturesCheckResult = facialFeaturesCheckResult;
    }

    @XmlElement
    public String getMentalDevelopment() {
        return this.mentalDevelopment;
    }

    public void setMentalDevelopment(String mentalDevelopment) {
        this.mentalDevelopment = mentalDevelopment;
    }

    @XmlElement
    public String getCardioverter() {
        return this.cardioverter;
    }

    public void setCardioverter(String cardioverter) {
        this.cardioverter = cardioverter;
    }

    @XmlElement
    public String getHeartRate() {
        return heartRate;
    }


    public void setHeartRate(String heartRate) {
        this.heartRate = heartRate;
    }

    @XmlElement(name = "lungAUSCUResult")
    public String getLungAuscuResult() {
        return lungAuscuResult;
    }

    public void setLungAuscuResult(String lungAuscuResult) {
        this.lungAuscuResult = lungAuscuResult;
    }

    @XmlElement(name = "cardiacAUSCUResult")
    public String getCardiacAuscuResult() {
        return cardiacAuscuResult;
    }

    public void setCardiacAuscuResult(String cardiacAuscuResult) {
        this.cardiacAuscuResult = cardiacAuscuResult;
    }

    @XmlElement(name = "liverPALPResult")
    public String getLiverPalpResult() {
        return liverPalpResult;
    }

    public void setLiverPalpResult(String liverPalpResult) {
        this.liverPalpResult = liverPalpResult;
    }

    @XmlElement
    public String getLimbsCheckResult() {
        return this.limbsCheckResult;
    }

    public void setLimbsCheckResult(String limbsCheckResult) {
        this.limbsCheckResult = limbsCheckResult;
    }

    @XmlElement
    public String getSpineCheckResult() {
        return this.spineCheckResult;
    }

    public void setSpineCheckResult(String spineCheckResult) {
        this.spineCheckResult = spineCheckResult;
    }

    @XmlElement
    public String getSkinHairCheckResult() {
        return this.skinHairCheckResult;
    }

    public void setSkinHairCheckResult(String skinHairCheckResult) {
        this.skinHairCheckResult = skinHairCheckResult;
    }

    @XmlElement
    public String getThyroidCheckResult() {
        return this.thyroidCheckResult;
    }

    public void setThyroidCheckResult(String thyroidCheckResult) {
        this.thyroidCheckResult = thyroidCheckResult;
    }

    @XmlElement
    public String getPenisCheckResult() {
        return this.penisCheckResult;
    }

    public void setPenisCheckResult(String penisCheckResult) {
        this.penisCheckResult = penisCheckResult;
    }

    @XmlElement
    public String getPrepuceCheckResult() {
        return this.prepuceCheckResult;
    }

    public void setPrepuceCheckResult(String prepuceCheckResult) {
        this.prepuceCheckResult = prepuceCheckResult;
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
    public String getEpididymalAbnormalities() {
        return this.epididymalAbnormalities;
    }

    public void setEpididymalAbnormalities(String epididymalAbnormalities) {
        this.epididymalAbnormalities = epididymalAbnormalities;
    }

    @XmlElement
    public String getAdamAppleCheckResult() {
        return this.adamAppleCheckResult;
    }

    public void setAdamAppleCheckResult(String adamAppleCheckResult) {
        this.adamAppleCheckResult = adamAppleCheckResult;
    }

    @XmlElement
    public String getVaricoceleFlag() {
        return this.varicoceleFlag;
    }

    public void setVaricoceleFlag(String varicoceleFlag) {
        this.varicoceleFlag = varicoceleFlag;
    }

    @XmlElement
    public String getVaricocelePart() {
        return this.varicocelePart;
    }

    public void setVaricocelePart(String varicocelePart) {
        this.varicocelePart = varicocelePart;
    }

    @XmlElement
    public String getVaricoceleDegree() {
        return this.varicoceleDegree;
    }

    public void setVaricoceleDegree(String varicoceleDegree) {
        this.varicoceleDegree = varicoceleDegree;
    }

    @XmlElement
    public String getGynaecologyExamWay() {
        return this.gynaecologyExamWay;
    }

    public void setGynaecologyExamWay(String gynaecologyExamWay) {
        this.gynaecologyExamWay = gynaecologyExamWay;
    }

    @XmlElement
    public String getInformedConsentFlag() {
        return this.informedConsentFlag;
    }

    public void setInformedConsentFlag(String informedConsentFlag) {
        this.informedConsentFlag = informedConsentFlag;
    }

    @XmlElement
    public String getPubesCheckResult() {
        return this.pubesCheckResult;
    }

    public void setPubesCheckResult(String pubesCheckResult) {
        this.pubesCheckResult = pubesCheckResult;
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
    public String getUterusCheckResult() {
        return this.uterusCheckResult;
    }

    public void setUterusCheckResult(String uterusCheckResult) {
        this.uterusCheckResult = uterusCheckResult;
    }

    @XmlElement(name = "leftAttachmentCheckResult")
    public String getlAttachmentCheckResult() {
        return lAttachmentCheckResult;
    }

    public void setlAttachmentCheckResult(String lAttachmentCheckResult) {
        this.lAttachmentCheckResult = lAttachmentCheckResult;
    }

    @XmlElement(name = "rightAttachmentCheckResult")
    public String getrAttachmentCheckResult() {
        return rAttachmentCheckResult;
    }

    public void setrAttachmentCheckResult(String rAttachmentCheckResult) {
        this.rAttachmentCheckResult = rAttachmentCheckResult;
    }

    @XmlElement
    public String getCervixCheckResult() {
        return this.cervixCheckResult;
    }

    public void setCervixCheckResult(String cervixCheckResult) {
        this.cervixCheckResult = cervixCheckResult;
    }

    @XmlElement(name = "leftBreastCheckResult")
    public String getlBreastCheckResult() {
        return lBreastCheckResult;
    }

    public void setlBreastCheckResult(String lBreastCheckResult) {
        this.lBreastCheckResult = lBreastCheckResult;
    }

    @XmlElement(name = "rightBreastCheckResult")
    public String getrBreastCheckResult() {
        return rBreastCheckResult;
    }

    public void setrBreastCheckResult(String rBreastCheckResult) {
        this.rBreastCheckResult = rBreastCheckResult;
    }

    @XmlElement
    public String getVaginaSecretionsDesc() {
        return vaginaSecretionsDesc;
    }

    public void setVaginaSecretionsDesc(String vaginaSecretionsDesc) {
        this.vaginaSecretionsDesc = vaginaSecretionsDesc;
    }

    @XmlElement
    public String getChestXCheckResult() {
        return this.chestXCheckResult;
    }

    public void setChestXCheckResult(String chestXCheckResult) {
        this.chestXCheckResult = chestXCheckResult;
    }

    @XmlElement
    public String getLeukocyteType() {
        return this.leukocyteType;
    }

    public void setLeukocyteType(String leukocyteType) {
        this.leukocyteType = leukocyteType;
    }

    @XmlElement
    public BigDecimal getLeukocyteCount() {
        return this.leukocyteCount;
    }

    public void setLeukocyteCount(BigDecimal leukocyteCount) {
        this.leukocyteCount = leukocyteCount;
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
    public BigDecimal getUrineProportion() {
        return this.urineProportion;
    }

    public void setUrineProportion(BigDecimal urineProportion) {
        this.urineProportion = urineProportion;
    }

    @XmlElement
    public BigDecimal getUrineProQuantitativeValue() {
        return urineProQuantitativeValue;
    }

    public void setUrineProQuantitativeValue(BigDecimal urineProQuantitativeValue) {
        this.urineProQuantitativeValue = urineProQuantitativeValue;
    }

    @XmlElement
    public BigDecimal getUrineSugQuantitativeDetect() {
        return urineSugQuantitativeDetect;
    }

    public void setUrineSugQuantitativeDetect(BigDecimal urineSugQuantitativeDetect) {
        this.urineSugQuantitativeDetect = urineSugQuantitativeDetect;
    }

    @XmlElement
    public BigDecimal getUrinePh() {
        return urinePh;
    }

    public void setUrinePh(BigDecimal urinePh) {
        this.urinePh = urinePh;
    }

    @XmlElement
    public Integer getSerumGptValue() {
        return serumGptValue;
    }

    public void setSerumGptValue(Integer serumGptValue) {
        this.serumGptValue = serumGptValue;
    }

    @XmlElement(name = "hBsAgDetectResult")
    public String getHbsagDetectResult() {
        return hbsagDetectResult;
    }

    public void setHbsagDetectResult(String hbsagDetectResult) {
        this.hbsagDetectResult = hbsagDetectResult;
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
    public String getDiseaseDiagnosisCode() {
        return this.diseaseDiagnosisCode;
    }

    public void setDiseaseDiagnosisCode(String diseaseDiagnosisCode) {
        this.diseaseDiagnosisCode = diseaseDiagnosisCode;
    }

    @XmlElement
    public String getPreMedicalCheckResult() {
        return preMedicalCheckResult;
    }

    public void setPreMedicalCheckResult(String preMedicalCheckResult) {
        this.preMedicalCheckResult = preMedicalCheckResult;
    }

    @XmlElement
    public String getPreMedicalOpinion() {
        return preMedicalOpinion;
    }

    public void setPreMedicalOpinion(String preMedicalOpinion) {
        this.preMedicalOpinion = preMedicalOpinion;
    }

    @XmlElement
    public String getPreHealthGuidance() {
        return preHealthGuidance;
    }

    public void setPreHealthGuidance(String preHealthGuidance) {
        this.preHealthGuidance = preHealthGuidance;
    }

    @XmlElement
    public String getPreHealthAdvisory() {
        return preHealthAdvisory;
    }

    public void setPreHealthAdvisory(String preHealthAdvisory) {
        this.preHealthAdvisory = preHealthAdvisory;
    }

    @XmlElement(name = "premaritalConsultationGuidanceResult")
    public String getPreConsultationGuidResult() {
        return preConsultationGuidResult;
    }

    public void setPreConsultationGuidResult(String preConsultationGuidResult) {
        this.preConsultationGuidResult = preConsultationGuidResult;
    }

    public Date getCheckDate() {
        return this.checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
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

    public Date getFillDate() {
        return this.fillDate;
    }

    public void setFillDate(Date fillDate) {
        this.fillDate = fillDate;
    }

    @XmlElement
    public String getFirstVisitDoctorName() {
        return this.firstVisitDoctorName;
    }

    public void setFirstVisitDoctorName(String firstVisitDoctorName) {
        this.firstVisitDoctorName = firstVisitDoctorName;
    }

    @XmlElement
    public String getMasterDoctorName() {
        return this.masterDoctorName;
    }

    public void setMasterDoctorName(String masterDoctorName) {
        this.masterDoctorName = masterDoctorName;
    }

    public Date getReferralDate() {
        return this.referralDate;
    }

    public void setReferralDate(Date referralDate) {
        this.referralDate = referralDate;
    }

    @XmlElement
    public String getReferralHospitalName() {
        return this.referralHospitalName;
    }

    public void setReferralHospitalName(String referralHospitalName) {
        this.referralHospitalName = referralHospitalName;
    }

    public Date getReserveDate() {
        return this.reserveDate;
    }

    public void setReserveDate(Date reserveDate) {
        this.reserveDate = reserveDate;
    }

    public Date getIssuedDate() {
        return this.issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
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

    public String getnGonorrhoeaeCheckResult() {
        return nGonorrhoeaeCheckResult;
    }


    public void setnGonorrhoeaeCheckResult(String nGonorrhoeaeCheckResult) {
        this.nGonorrhoeaeCheckResult = nGonorrhoeaeCheckResult;
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


    public String getMenstrualBleedingTypeDesc() {
        return menstrualBleedingTypeDesc;
    }


    public void setMenstrualBleedingTypeDesc(String menstrualBleedingTypeDesc) {
        this.menstrualBleedingTypeDesc = menstrualBleedingTypeDesc;
    }


    public String getDysmenorrheaDegreeDesc() {
        return dysmenorrheaDegreeDesc;
    }


    public void setDysmenorrheaDegreeDesc(String dysmenorrheaDegreeDesc) {
        this.dysmenorrheaDegreeDesc = dysmenorrheaDegreeDesc;
    }


    public String getLastMenstrualDateDesc() {
        return lastMenstrualDateDesc;
    }


    public void setLastMenstrualDateDesc(String lastMenstrualDateDesc) {
        this.lastMenstrualDateDesc = lastMenstrualDateDesc;
    }


    public String getPatientRelationDesc() {
        return patientRelationDesc;
    }


    public void setPatientRelationDesc(String patientRelationDesc) {
        this.patientRelationDesc = patientRelationDesc;
    }


    public String getFamilyKinMarriageRelationDesc() {
        return familyKinMarriageRelationDesc;
    }


    public void setFamilyKinMarriageRelationDesc(String familyKinMarriageRelationDesc) {
        this.familyKinMarriageRelationDesc = familyKinMarriageRelationDesc;
    }


    public String getSpecialBodyCheckResultDesc() {
        return specialBodyCheckResultDesc;
    }


    public void setSpecialBodyCheckResultDesc(String specialBodyCheckResultDesc) {
        this.specialBodyCheckResultDesc = specialBodyCheckResultDesc;
    }


    public String getSpecialFaceCheckResultDesc() {
        return specialFaceCheckResultDesc;
    }


    public void setSpecialFaceCheckResultDesc(String specialFaceCheckResultDesc) {
        this.specialFaceCheckResultDesc = specialFaceCheckResultDesc;
    }


    public String getFacialFeaturesCheckResultDesc() {
        return facialFeaturesCheckResultDesc;
    }


    public void setFacialFeaturesCheckResultDesc(String facialFeaturesCheckResultDesc) {
        this.facialFeaturesCheckResultDesc = facialFeaturesCheckResultDesc;
    }


    public String getMentalDevelopmentDesc() {
        return mentalDevelopmentDesc;
    }


    public void setMentalDevelopmentDesc(String mentalDevelopmentDesc) {
        this.mentalDevelopmentDesc = mentalDevelopmentDesc;
    }


    public String getLungAuscuResultDesc() {
        return lungAuscuResultDesc;
    }


    public void setLungAuscuResultDesc(String lungAuscuResultDesc) {
        this.lungAuscuResultDesc = lungAuscuResultDesc;
    }


    public String getLiverPalpResultDesc() {
        return liverPalpResultDesc;
    }


    public void setLiverPalpResultDesc(String liverPalpResultDesc) {
        this.liverPalpResultDesc = liverPalpResultDesc;
    }


    public String getUterusCheckResultDesc() {
        return uterusCheckResultDesc;
    }


    public void setUterusCheckResultDesc(String uterusCheckResultDesc) {
        this.uterusCheckResultDesc = uterusCheckResultDesc;
    }


    public String getSyphilisSerologyCheckResultDesc() {
        return syphilisSerologyCheckResultDesc;
    }


    public void setSyphilisSerologyCheckResultDesc(String syphilisSerologyCheckResultDesc) {
        this.syphilisSerologyCheckResultDesc = syphilisSerologyCheckResultDesc;
    }


    public String getHivlgDetectResultDesc() {
        return hivlgDetectResultDesc;
    }


    public void setHivlgDetectResultDesc(String hivlgDetectResultDesc) {
        this.hivlgDetectResultDesc = hivlgDetectResultDesc;
    }


    public String getCheckDateDesc() {
        return checkDateDesc;
    }


    public void setCheckDateDesc(String checkDateDesc) {
        this.checkDateDesc = checkDateDesc;
    }


    public String getProcessStatus() {
        return processStatus;
    }


    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public String getBloodRelationDesc() {
        return bloodRelationDesc;
    }

    public void setBloodRelationDesc(String bloodRelationDesc) {
        this.bloodRelationDesc = bloodRelationDesc;
    }

    public String getMentalStateCodeDesc() {
        return mentalStateCodeDesc;
    }

    public void setMentalStateCodeDesc(String mentalStateCodeDesc) {
        this.mentalStateCodeDesc = mentalStateCodeDesc;
    }

    public String getCardioverterDesc() {
        return cardioverterDesc;
    }

    public void setCardioverterDesc(String cardioverterDesc) {
        this.cardioverterDesc = cardioverterDesc;
    }

}
