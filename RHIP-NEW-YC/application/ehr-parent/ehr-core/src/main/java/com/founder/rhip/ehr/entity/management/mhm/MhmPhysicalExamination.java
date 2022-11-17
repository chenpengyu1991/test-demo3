package com.founder.rhip.ehr.entity.management.mhm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "MHM_PHYSICAL_EXAMINATION")
public class MhmPhysicalExamination implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "EVENT_ID", columnDefinition = "NUMBER|本系统唯一编码|11|", length = 11, nullable = false)
	private Long eventId;

	@Column(name = "HEALTH_FILE_NO", columnDefinition = "VARCHAR2|健康档案编号|17|", length = 17, nullable = true)
	private String healthFileNo;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|病人姓名|50|", length = 50, nullable = true)
	private String name;

	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证号|18|", length = 18, nullable = true)
	private String idcard;

	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别|1|", length = 1, nullable = true)
	private String gender;

	@Column(name = "BIRTHDATE", columnDefinition = "DATE|出生日期||", nullable = true)
	private Date birthdate;

	@Column(name = "PAPROVINCE", columnDefinition = "VARCHAR2|现居住地省|20|", length = 20, nullable = true)
	private String paprovince;

	@Column(name = "PACITY", columnDefinition = "VARCHAR2|现居住地市|20|", length = 20, nullable = true)
	private String pacity;

	@Column(name = "PACOUNTY", columnDefinition = "VARCHAR2|现居住地县区|20|", length = 20, nullable = true)
	private String pacounty;

	@Column(name = "PATOWN_SHIP", columnDefinition = "VARCHAR2|现居住地乡街道|100|", length = 100, nullable = true)
	private String patownShip;
	
	@Column(name = "PA_GROUP", columnDefinition = "VARCHAR2|现住址小组地址||", length = 2, nullable = true)
	private String paGroup;
    
	@Column(name = "PASTREET", columnDefinition = "VARCHAR2|现居住地村社区|100|", length = 100, nullable = true)
	private String pastreet;

	@Column(name = "PAHOUSE_NUMBER", columnDefinition = "VARCHAR2|现居住地门牌号|100|", length = 100, nullable = true)
	private String pahouseNumber;

	@Column(name = "CONTACT_PHONE", columnDefinition = "VARCHAR2|联系电话|20|", length = 20, nullable = true)
	private String contactPhone;

	@Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况|2|", length = 2, nullable = true)
	private String marriage;

	@Column(name = "RIGHT_SBP", columnDefinition = "NUMBER|血压－收缩压||", length = 4, nullable = true)
	private Integer rightSbp;

	@Column(name = "RIGHT_DBP", columnDefinition = "NUMBER|血压－舒张压||", length = 4, nullable = true)
	private Integer rightDbp;

	@Column(name = "LUNG", columnDefinition = "VARCHAR2|两肺|100|", length = 100, nullable = true)
	private String lung;

	@Column(name = "HEART", columnDefinition = "VARCHAR2|心脏|100|", length = 100, nullable = true)
	private String heart;

	@Column(name = "BODY_WEIGHT", columnDefinition = "NUMBER|体重||", scale = 6, precision = 2, nullable = true)
	private BigDecimal bodyWeight;

	@Column(name = "HEIGHT", columnDefinition = "NUMBER|身高||",scale = 5, precision = 2, nullable = true)
	private BigDecimal height;

	@Column(name = "IRRITABILITY", columnDefinition = "VARCHAR2|过敏史|100|", length = 100, nullable = true)
	private String irritability;

	@Column(name = "MEDICINE_DOCTOR", columnDefinition = "VARCHAR2|内科医生|50|", length = 50, nullable = true)
	private String medicineDoctor;

	@Column(name = "CHRONIC_DISEASE", columnDefinition = "VARCHAR2|是否慢性病患者|2|", length = 2, nullable = true)
	private String chronicDisease;

	@Column(name = "DISEASE_TYPE", columnDefinition = "VARCHAR2|慢性病患者情况|50|", length = 50, nullable = true)
	private String diseaseType;

	@Column(name = "DISEASE_OTHER", columnDefinition = "VARCHAR2|其他疾病|100|", length = 100, nullable = true)
	private String diseaseOther;

	@Column(name = "FPG_MMOL", columnDefinition = "NUMBER|空腹血糖值(mmol／L)||",scale = 3, precision = 1, nullable = true)
	private BigDecimal fpgMmol;

	@Column(name = "FPG_MG", columnDefinition = "NUMBER|空腹血糖值(mg／dL)||",scale = 3, precision = 1, nullable = true)
	private BigDecimal fpgMg;

	@Column(name = "AMINOPHERASE", columnDefinition = "VARCHAR2|转氨酶|100|", length = 100, nullable = true)
	private String aminopherase;

	@Column(name = "BLOOD_ROUTINE_OTHER_DESC", columnDefinition = "VARCHAR2|血常规|100|", length = 100, nullable = true)
	private String bloodRoutineOtherDesc;

	@Column(name = "ABO_BLOOD_TYPE", columnDefinition = "VARCHAR2|血型|1|", length = 1, nullable = true)
	private String aboBloodType;

	@Column(name = "RH_BLOOD_TYPE", columnDefinition = "VARCHAR2|血型分析|1|", length = 1, nullable = true)
	private String rhBloodType;

	@Column(name = "ECG", columnDefinition = "VARCHAR2|心电图检查|100|", length = 100, nullable = true)
	private String ecg;

	@Column(name = "ECG_DOCTOR", columnDefinition = "VARCHAR2|心电图医生|50|", length = 50, nullable = true)
	private String ecgDoctor;

	@Column(name = "LIVER", columnDefinition = "VARCHAR2|肝|100|", length = 100, nullable = true)
	private String liver;

	@Column(name = "SPLEEN", columnDefinition = "VARCHAR2|脾|100|", length = 100, nullable = true)
	private String spleen;

	@Column(name = "KIDNEY", columnDefinition = "VARCHAR2|双肾|100|", length = 100, nullable = true)
	private String kidney;

	@Column(name = "ULTRASONOGRAPHY_DOCTOR", columnDefinition = "VARCHAR2|超声检查医生|50|", length = 50, nullable = true)
	private String ultrasonographyDoctor;

	@Column(name = "URINE_ROUTINE_OTHER_DESC", columnDefinition = "VARCHAR2|尿常规|100|", length = 100, nullable = true)
	private String urineRoutineOtherDesc;

	@Column(name = "EXAMINE_DOCTOR", columnDefinition = "VARCHAR2|检验项目医生|50|", length = 50, nullable = true)
	private String examineDoctor;

	@Column(name = "CONCLUSION_DESC", columnDefinition = "VARCHAR2|体检结论|400|", length = 400, nullable = true)
	private String conclusionDesc;

	@Column(name = "SUGGESTION", columnDefinition = "VARCHAR2|医生建议|400|", length = 400, nullable = true)
	private String suggestion;

	@Column(name = "EXAMINATION_ORGAN_CODE", columnDefinition = "VARCHAR2|检查机构|100|", length = 100, nullable = true)
	private String examinationOrganCode;

	@Column(name = "EXAMINATION_ORGAN_OTHER", columnDefinition = "VARCHAR2|检查机构其他|100|", length = 100, nullable = true)
	private String examinationOrganOther;

	@Column(name = "MAIN_DOCTOR", columnDefinition = "VARCHAR2|主检医生|50|", length = 50, nullable = true)
	private String mainDoctor;

	@Column(name = "ISSUE_DT", columnDefinition = "DATE|签发日期||", nullable = true)
	private Date issueDt;

	@Column(name = "CONSULTATION_QUESTION", columnDefinition = "VARCHAR2|心理咨询|400|", length = 400, nullable = true)
	private String consultationQuestion;

	@Column(name = "SUMMARY_DOCTOR", columnDefinition = "VARCHAR2|总结医生|50|", length = 50, nullable = true)
	private String summaryDoctor;

	@Column(name = "FILL_ORGAN_CODE", columnDefinition = "VARCHAR2|填写机构|100|", length = 100, nullable = true)
	private String fillOrganCode;

	@Column(name = "FILL_DOCTOR_ID", columnDefinition = "VARCHAR2|填写医生|50|", length = 50, nullable = true)
	private String fillDoctorId;

	@Column(name = "FILL_DATE", columnDefinition = "DATE|填写日期||", nullable = true)
	private Date fillDate;

	@Column(name = "MODIFY_DOCTOR_ID", columnDefinition = "VARCHAR2|修改医生|50|", length = 50, nullable = true)
	private String modifyDoctorId;

	@Column(name = "MODIFY_ORGAN_CODE", columnDefinition = "VARCHAR2|修改机构|100|", length = 100, nullable = true)
	private String modifyOrganCode;

	@Column(name = "MODIFY_DATE", columnDefinition = "DATE|修改日期||", nullable = true)
	private Date modifyDate;

	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除状态（0正常，1删除）|1|0", length = 1, nullable = true)
	private Integer isDelete;

    @Column(name = "PHYSICAL_DT", columnDefinition = "DATE|体检日期||", nullable = true)
    private Date physicalDt;

	public String getPaGroup() {
		return paGroup;
	}

	public void setPaGroup(String paGroup) {
		this.paGroup = paGroup;
	}

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

	public String getHealthFileNo() {
		return this.healthFileNo;
	}

	public void setHealthFileNo(String healthFileNo) {
		this.healthFileNo = healthFileNo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getPaprovince() {
		return this.paprovince;
	}

	public void setPaprovince(String paprovince) {
		this.paprovince = paprovince;
	}

	public String getPacity() {
		return this.pacity;
	}

	public void setPacity(String pacity) {
		this.pacity = pacity;
	}

	public String getPacounty() {
		return this.pacounty;
	}

	public void setPacounty(String pacounty) {
		this.pacounty = pacounty;
	}

	public String getPatownShip() {
		return this.patownShip;
	}

	public void setPatownShip(String patownShip) {
		this.patownShip = patownShip;
	}

	public String getPastreet() {
		return this.pastreet;
	}

	public void setPastreet(String pastreet) {
		this.pastreet = pastreet;
	}

    public String getPahouseNumber() {
        return pahouseNumber;
    }

    public void setPahouseNumber(String pahouseNumber) {
        this.pahouseNumber = pahouseNumber;
    }

    public String getContactPhone() {
		return this.contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getMarriage() {
		return this.marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

    public Integer getRightSbp() {
        return rightSbp;
    }

    public void setRightSbp(Integer rightSbp) {
        this.rightSbp = rightSbp;
    }

    public Integer getRightDbp() {
        return rightDbp;
    }

    public void setRightDbp(Integer rightDbp) {
        this.rightDbp = rightDbp;
    }

    public String getLung() {
		return this.lung;
	}

	public void setLung(String lung) {
		this.lung = lung;
	}

	public String getHeart() {
		return this.heart;
	}

	public void setHeart(String heart) {
		this.heart = heart;
	}

	public BigDecimal getBodyWeight() {
		return this.bodyWeight;
	}

	public void setBodyWeight(BigDecimal bodyWeight) {
		this.bodyWeight = bodyWeight;
	}

	public BigDecimal getHeight() {
		return this.height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public String getIrritability() {
		return this.irritability;
	}

	public void setIrritability(String irritability) {
		this.irritability = irritability;
	}

	public String getMedicineDoctor() {
		return this.medicineDoctor;
	}

	public void setMedicineDoctor(String medicineDoctor) {
		this.medicineDoctor = medicineDoctor;
	}

	public String getChronicDisease() {
		return this.chronicDisease;
	}

	public void setChronicDisease(String chronicDisease) {
		this.chronicDisease = chronicDisease;
	}

	public String getDiseaseType() {
		return this.diseaseType;
	}

	public void setDiseaseType(String diseaseType) {
		this.diseaseType = diseaseType;
	}

	public String getDiseaseOther() {
		return this.diseaseOther;
	}

	public void setDiseaseOther(String diseaseOther) {
		this.diseaseOther = diseaseOther;
	}

	public BigDecimal getFpgMmol() {
		return this.fpgMmol;
	}

	public void setFpgMmol(BigDecimal fpgMmol) {
		this.fpgMmol = fpgMmol;
	}

	public BigDecimal getFpgMg() {
		return this.fpgMg;
	}

	public void setFpgMg(BigDecimal fpgMg) {
		this.fpgMg = fpgMg;
	}

	public String getAminopherase() {
		return this.aminopherase;
	}

	public void setAminopherase(String aminopherase) {
		this.aminopherase = aminopherase;
	}

	public String getBloodRoutineOtherDesc() {
		return this.bloodRoutineOtherDesc;
	}

	public void setBloodRoutineOtherDesc(String bloodRoutineOtherDesc) {
		this.bloodRoutineOtherDesc = bloodRoutineOtherDesc;
	}

	public String getAboBloodType() {
		return this.aboBloodType;
	}

	public void setAboBloodType(String aboBloodType) {
		this.aboBloodType = aboBloodType;
	}

	public String getRhBloodType() {
		return this.rhBloodType;
	}

	public void setRhBloodType(String rhBloodType) {
		this.rhBloodType = rhBloodType;
	}

	public String getEcg() {
		return this.ecg;
	}

	public void setEcg(String ecg) {
		this.ecg = ecg;
	}

	public String getEcgDoctor() {
		return this.ecgDoctor;
	}

	public void setEcgDoctor(String ecgDoctor) {
		this.ecgDoctor = ecgDoctor;
	}

	public String getLiver() {
		return this.liver;
	}

	public void setLiver(String liver) {
		this.liver = liver;
	}

	public String getSpleen() {
		return this.spleen;
	}

	public void setSpleen(String spleen) {
		this.spleen = spleen;
	}

	public String getKidney() {
		return this.kidney;
	}

	public void setKidney(String kidney) {
		this.kidney = kidney;
	}

	public String getUltrasonographyDoctor() {
		return this.ultrasonographyDoctor;
	}

	public void setUltrasonographyDoctor(String ultrasonographyDoctor) {
		this.ultrasonographyDoctor = ultrasonographyDoctor;
	}

	public String getUrineRoutineOtherDesc() {
		return this.urineRoutineOtherDesc;
	}

	public void setUrineRoutineOtherDesc(String urineRoutineOtherDesc) {
		this.urineRoutineOtherDesc = urineRoutineOtherDesc;
	}

	public String getExamineDoctor() {
		return this.examineDoctor;
	}

	public void setExamineDoctor(String examineDoctor) {
		this.examineDoctor = examineDoctor;
	}

	public String getConclusionDesc() {
		return this.conclusionDesc;
	}

	public void setConclusionDesc(String conclusionDesc) {
		this.conclusionDesc = conclusionDesc;
	}

	public String getSuggestion() {
		return this.suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	public String getExaminationOrganCode() {
		return this.examinationOrganCode;
	}

	public void setExaminationOrganCode(String examinationOrganCode) {
		this.examinationOrganCode = examinationOrganCode;
	}

	public String getExaminationOrganOther() {
		return this.examinationOrganOther;
	}

	public void setExaminationOrganOther(String examinationOrganOther) {
		this.examinationOrganOther = examinationOrganOther;
	}

	public String getMainDoctor() {
		return this.mainDoctor;
	}

	public void setMainDoctor(String mainDoctor) {
		this.mainDoctor = mainDoctor;
	}

	public Date getIssueDt() {
		return this.issueDt;
	}

	public void setIssueDt(Date issueDt) {
		this.issueDt = issueDt;
	}

	public String getConsultationQuestion() {
		return this.consultationQuestion;
	}

	public void setConsultationQuestion(String consultationQuestion) {
		this.consultationQuestion = consultationQuestion;
	}

	public String getSummaryDoctor() {
		return this.summaryDoctor;
	}

	public void setSummaryDoctor(String summaryDoctor) {
		this.summaryDoctor = summaryDoctor;
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

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

    public Date getPhysicalDt() {
        return physicalDt;
    }

    public void setPhysicalDt(Date physicalDt) {
        this.physicalDt = physicalDt;
    }
}