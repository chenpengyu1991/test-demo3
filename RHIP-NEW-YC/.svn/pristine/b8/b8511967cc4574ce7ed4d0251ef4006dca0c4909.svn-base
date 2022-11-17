package com.founder.rhip.ehr.entity.women;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Entity
@Table(name = "WH_WOMAN_DISEASE_CENSUS")
@XmlRootElement
public class WomanDiseaseCensus implements Serializable {

    private static final long serialVersionUID = 7909088838852025172L;

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
     * 妇科及乳腺不适症状代码
     */
    @Column(name = "G_BDISCOMFORT_CODE")
    private String gBdiscomfortCode;

    /**
     * 心率(次/分钟)
     */
    @Column(name = "HEART_RATE")
    private String heartRate;

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
     * 初潮年龄(岁)
     */
    @Column(name = "MENARCHE_AGE")
    private Integer menarcheAge;

    /**
     * 月经周期(d)
     */
    @Column(name = "MENSTRUAL_CYCLE")
    private String menstrualCycle;

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
     * 痛经标志
     */
    @Column(name = "DYSMENORRHEA_FLAG")
    private String dysmenorrheaFlag;

    /**
     * 末次月经日期
     */
    @Column(name = "LAST_MENSTRUAL_DATE")
    private Date lastMenstrualDate;

    /**
     * 绝经标志
     */
    @Column(name = "MENOPAUSE_FLAG")
    private String menopauseFlag;

    /**
     * 手术绝经标志
     */
    @Column(name = "OPERATION_MENOPAUSE_FLAG")
    private String operationMenopauseFlag;

    /**
     * 绝经年龄(岁)
     */
    @Column(name = "MENOPAUSE_AGE")
    private Integer menopauseAge;

    /**
     * 孕次
     */
    @Column(name = "GRAVIDITY_TIMES")
    private Integer gravidityTimes;

    /**
     * 产次
     */
    @Column(name = "PRODUCTION_TIMES")
    private Integer productionTimes;

    /**
     * 自然流产次数
     */
    @Column(name = "SPONTANEOUS_ABORTION_TIMES")
    private Integer spontaneousAbortionTimes;

    /**
     * 人工流产次数
     */
    @Column(name = "ARTIFICIAL_ABORTION_TIMES")
    private Integer artificialAbortionTimes;

    /**
     * 阴道助产次数
     */
    @Column(name = "VAGINA_DELIVERY_TIMES")
    private Integer vaginaDeliveryTimes;

    /**
     * 剖宫产次数
     */
    @Column(name = "CESAREAN_SECTION_TIMES")
    private Integer cesareanSectionTimes;

    /**
     * 死胎例数
     */
    @Column(name = "STILLBIRTH_CASES_NUMBER")
    private Integer stillbirthCasesNumber;

    /**
     * 死产例数
     */
    @Column(name = "STILLBORN_CASES_NUMBER")
    private Integer stillbornCasesNumber;

    /**
     * 出生缺陷儿例数
     */
    @Column(name = "BIRTH_DEFECTS_NUMBER")
    private Integer birthDefectsNumber;

    /**
     * 末次妊娠终止日期
     */
    @Column(name = "LAST_PREGNANCY_END_DATE")
    private Date lastPregnancyEndDate;

    /**
     * 末次妊娠终止方式代码
     */
    @Column(name = "LAST_PREGNANCY_WAY")
    private String lastPregnancyWay;

    /**
     * 末次分娩日期
     */
    @Column(name = "LAST_DELIVERY_DATE")
    private Date lastDeliveryDate;

    /**
     * 末次分娩方式代码
     */
    @Column(name = "LAST_DELIVERY_WAY")
    private String lastDeliveryWay;

    /**
     * 避孕方式代码
     */
    @Column(name = "CONTRACEPTIVE_WAY")
    private String contraceptiveWay;

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
     * 阴道检查结果
     */
    @Column(name = "VAGINA_CHECK_RESULT")
    private String vaginaCheckResult;

    /**
     * 外阴检查结果
     */
    @Column(name = "VULVA_CHECK_RESULT")
    private String vulvaCheckResult;

    /**
     * 子宫检查结果
     */
    @Column(name = "UTERUS_CHECK_RESULT")
    private String uterusCheckResult;

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
     * 阴道细胞学诊断结果代码
     */
    @Column(name = "VAGINA_DIAGNOSIS_RESULT")
    private String vaginaDiagnosisResult;

    /**
     * 乳腺X线检查结果
     */
    @Column(name = "BREAST_X_CHECK_RESULT")
    private String breastXCheckResult;

    /**
     * 乳腺B超检查结果
     */
    @Column(name = "BREAST_B_CHECK_RESULT")
    private String breastBCheckResult;

    /**
     * 阴道镜检查结果
     */
    @Column(name = "COLPOSCOPY_CHECK_RESULT")
    private String colposcopyCheckResult;

    /**
     * 阴道分泌物性状描述
     */
    @Column(name = "VAGINA_SECRETIONS_DESC")
    private String vaginaSecretionsDesc;

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
     * 体检结果
     */
    @Column(name = "EXAMINATION_RESULT")
    private String examinationResult;

    /**
     * 处理及指导意见
     */
    @Column(name = "MG_OPINION")
    private String mgOpinion;

    /**
     * 主检医师姓名
     */
    @Column(name = "MASTER_DOCTOR_NAME")
    private String masterDoctorName;

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
     * 文化程度代码
     */
    @Column(name = "EDUCATION")
    private String education;

    /**
     * 身份证件类别代码
     */
    @Column(name = "IDCARD_TYPE")
    private String idcardType;

    /**
     * 身份证件号码
     */
    @Column(name = "ID_CARD")
    private String idCard;

    /**
     * 婚姻状况类别代码
     */
    @Column(name = "MARRIAGE")
    private String marriage;

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
     * 性交出血史
     */
    @Column(name = "COITAL_BLEEDING_HISTORY")
    private String coitalBleedingHistory;

    /**
     * 妊娠合并症/并发症史
     */
    @Column(name = "COMPLICATION_HISTORY")
    private String complicationHistory;

    /**
     * 既往疾病史
     */
    @Column(name = "PAST_MEDICAL_HISTORY")
    private String pastMedicalHistory;

    /**
     * 家族肿瘤史
     */
    @Column(name = "FAMILY_CANCER_HISTORY")
    private String familyCancerHistory;

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
    public String getGBdiscomfortCode() {
        return this.gBdiscomfortCode;
    }

    public void setGBdiscomfortCode(String gBdiscomfortCode) {
        this.gBdiscomfortCode = gBdiscomfortCode;
    }

    @XmlElement
    public String getHeartRate() {
        return heartRate;
    }


    public String getProcessStatus() {
        return processStatus;
    }

    public Date getGatherDate() {
        return gatherDate;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public void setGatherDate(Date gatherDate) {
        this.gatherDate = gatherDate;
    }

    public void setHeartRate(String heartRate) {
        this.heartRate = heartRate;
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
    public Integer getMenarcheAge() {
        return this.menarcheAge;
    }

    public void setMenarcheAge(Integer menarcheAge) {
        this.menarcheAge = menarcheAge;
    }

    @XmlElement
    public void setMenstrualCycle(String menstrualCycle) {
        this.menstrualCycle = menstrualCycle;
    }

    public String getMenstrualCycle() {
        return menstrualCycle;
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
    public String getDysmenorrheaFlag() {
        return this.dysmenorrheaFlag;
    }

    public void setDysmenorrheaFlag(String dysmenorrheaFlag) {
        this.dysmenorrheaFlag = dysmenorrheaFlag;
    }

    public Date getLastMenstrualDate() {
        return this.lastMenstrualDate;
    }

    public void setLastMenstrualDate(Date lastMenstrualDate) {
        this.lastMenstrualDate = lastMenstrualDate;
    }

    @XmlElement
    public String getMenopauseFlag() {
        return this.menopauseFlag;
    }

    public void setMenopauseFlag(String menopauseFlag) {
        this.menopauseFlag = menopauseFlag;
    }

    @XmlElement
    public String getOperationMenopauseFlag() {
        return this.operationMenopauseFlag;
    }

    public void setOperationMenopauseFlag(String operationMenopauseFlag) {
        this.operationMenopauseFlag = operationMenopauseFlag;
    }

    @XmlElement
    public Integer getMenopauseAge() {
        return this.menopauseAge;
    }

    public void setMenopauseAge(Integer menopauseAge) {
        this.menopauseAge = menopauseAge;
    }

    @XmlElement
    public Integer getGravidityTimes() {
        return this.gravidityTimes;
    }

    public void setGravidityTimes(Integer gravidityTimes) {
        this.gravidityTimes = gravidityTimes;
    }

    @XmlElement
    public Integer getProductionTimes() {
        return this.productionTimes;
    }

    public void setProductionTimes(Integer productionTimes) {
        this.productionTimes = productionTimes;
    }

    @XmlElement
    public Integer getSpontaneousAbortionTimes() {
        return this.spontaneousAbortionTimes;
    }

    public void setSpontaneousAbortionTimes(Integer spontaneousAbortionTimes) {
        this.spontaneousAbortionTimes = spontaneousAbortionTimes;
    }

    @XmlElement
    public Integer getArtificialAbortionTimes() {
        return this.artificialAbortionTimes;
    }

    public void setArtificialAbortionTimes(Integer artificialAbortionTimes) {
        this.artificialAbortionTimes = artificialAbortionTimes;
    }

    @XmlElement
    public Integer getVaginaDeliveryTimes() {
        return vaginaDeliveryTimes;
    }

    public void setVaginaDeliveryTimes(Integer vaginaDeliveryTimes) {
        this.vaginaDeliveryTimes = vaginaDeliveryTimes;
    }

    @XmlElement
    public Integer getCesareanSectionTimes() {
        return this.cesareanSectionTimes;
    }

    public void setCesareanSectionTimes(Integer cesareanSectionTimes) {
        this.cesareanSectionTimes = cesareanSectionTimes;
    }

    @XmlElement
    public Integer getStillbirthCasesNumber() {
        return this.stillbirthCasesNumber;
    }

    public void setStillbirthCasesNumber(Integer stillbirthCasesNumber) {
        this.stillbirthCasesNumber = stillbirthCasesNumber;
    }

    @XmlElement
    public Integer getStillbornCasesNumber() {
        return this.stillbornCasesNumber;
    }

    public void setStillbornCasesNumber(Integer stillbornCasesNumber) {
        this.stillbornCasesNumber = stillbornCasesNumber;
    }

    @XmlElement
    public Integer getBirthDefectsNumber() {
        return this.birthDefectsNumber;
    }

    public void setBirthDefectsNumber(Integer birthDefectsNumber) {
        this.birthDefectsNumber = birthDefectsNumber;
    }

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

    public Date getLastDeliveryDate() {
        return this.lastDeliveryDate;
    }

    public void setLastDeliveryDate(Date lastDeliveryDate) {
        this.lastDeliveryDate = lastDeliveryDate;
    }

    @XmlElement
    public String getLastDeliveryWay() {
        return this.lastDeliveryWay;
    }

    public void setLastDeliveryWay(String lastDeliveryWay) {
        this.lastDeliveryWay = lastDeliveryWay;
    }

    @XmlElement
    public String getContraceptiveWay() {
        return this.contraceptiveWay;
    }

    public void setContraceptiveWay(String contraceptiveWay) {
        this.contraceptiveWay = contraceptiveWay;
    }

    @XmlElement(name = "LAttachmentCheckResult")
    public String getlAttachmentCheckResult() {
        return lAttachmentCheckResult;
    }

    public void setlAttachmentCheckResult(String lAttachmentCheckResult) {
        this.lAttachmentCheckResult = lAttachmentCheckResult;
    }

    @XmlElement(name = "RAttachmentCheckResult")
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

    @XmlElement
    public String getVaginaCheckResult() {
        return this.vaginaCheckResult;
    }

    public void setVaginaCheckResult(String vaginaCheckResult) {
        this.vaginaCheckResult = vaginaCheckResult;
    }

    @XmlElement
    public String getVulvaCheckResult() {
        return this.vulvaCheckResult;
    }

    public void setVulvaCheckResult(String vulvaCheckResult) {
        this.vulvaCheckResult = vulvaCheckResult;
    }

    @XmlElement
    public String getUterusCheckResult() {
        return this.uterusCheckResult;
    }

    public void setUterusCheckResult(String uterusCheckResult) {
        this.uterusCheckResult = uterusCheckResult;
    }

    @XmlElement(name = "LBreastCheckResult")
    public String getlBreastCheckResult() {
        return lBreastCheckResult;
    }

    public void setlBreastCheckResult(String lBreastCheckResult) {
        this.lBreastCheckResult = lBreastCheckResult;
    }

    @XmlElement(name = "RBreastCheckResult")
    public String getrBreastCheckResult() {
        return rBreastCheckResult;
    }

    public void setrBreastCheckResult(String rBreastCheckResult) {
        this.rBreastCheckResult = rBreastCheckResult;
    }

    @XmlElement
    public String getVaginaDiagnosisResult() {
        return vaginaDiagnosisResult;
    }

    public void setVaginaDiagnosisResult(String vaginaDiagnosisResult) {
        this.vaginaDiagnosisResult = vaginaDiagnosisResult;
    }

    @XmlElement
    public String getBreastXCheckResult() {
        return this.breastXCheckResult;
    }

    public void setBreastXCheckResult(String breastXCheckResult) {
        this.breastXCheckResult = breastXCheckResult;
    }

    @XmlElement
    public String getBreastBCheckResult() {
        return this.breastBCheckResult;
    }

    public void setBreastBCheckResult(String breastBCheckResult) {
        this.breastBCheckResult = breastBCheckResult;
    }

    @XmlElement
    public String getColposcopyCheckResult() {
        return this.colposcopyCheckResult;
    }

    public void setColposcopyCheckResult(String colposcopyCheckResult) {
        this.colposcopyCheckResult = colposcopyCheckResult;
    }

    @XmlElement
    public String getVaginaSecretionsDesc() {
        return this.vaginaSecretionsDesc;
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
    public String getExaminationResult() {
        return this.examinationResult;
    }

    public void setExaminationResult(String examinationResult) {
        this.examinationResult = examinationResult;
    }

    @XmlElement
    public String getMgOpinion() {
        return this.mgOpinion;
    }

    public void setMgOpinion(String mgOpinion) {
        this.mgOpinion = mgOpinion;
    }

    @XmlElement
    public String getMasterDoctorName() {
        return this.masterDoctorName;
    }

    public void setMasterDoctorName(String masterDoctorName) {
        this.masterDoctorName = masterDoctorName;
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
    public String getgBdiscomfortCode() {
        return gBdiscomfortCode;
    }


    public void setgBdiscomfortCode(String gBdiscomfortCode) {
        this.gBdiscomfortCode = gBdiscomfortCode;
    }

    @XmlElement
    public String getnGonorrhoeaeCheckResult() {
        return nGonorrhoeaeCheckResult;
    }


    public void setnGonorrhoeaeCheckResult(String nGonorrhoeaeCheckResult) {
        this.nGonorrhoeaeCheckResult = nGonorrhoeaeCheckResult;
    }

    @XmlElement
    public String getHealthFileNo() {
        return healthFileNo;
    }

    public void setHealthFileNo(String healthFileNo) {
        this.healthFileNo = healthFileNo;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }


    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @XmlElement
    public String getNation() {
        return nation;
    }


    public void setNation(String nation) {
        this.nation = nation;
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
    public String getEducation() {
        return education;
    }


    public void setEducation(String education) {
        this.education = education;
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
    public String getCoitalBleedingHistory() {
        return coitalBleedingHistory;
    }


    public void setCoitalBleedingHistory(String coitalBleedingHistory) {
        this.coitalBleedingHistory = coitalBleedingHistory;
    }

    @XmlElement
    public String getComplicationHistory() {
        return complicationHistory;
    }

    public void setComplicationHistory(String complicationHistory) {
        this.complicationHistory = complicationHistory;
    }

    @XmlElement
    public String getPastMedicalHistory() {
        return pastMedicalHistory;
    }


    public void setPastMedicalHistory(String pastMedicalHistory) {
        this.pastMedicalHistory = pastMedicalHistory;
    }

    @XmlElement
    public String getFamilyCancerHistory() {
        return familyCancerHistory;
    }


    public void setFamilyCancerHistory(String familyCancerHistory) {
        this.familyCancerHistory = familyCancerHistory;
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
}

