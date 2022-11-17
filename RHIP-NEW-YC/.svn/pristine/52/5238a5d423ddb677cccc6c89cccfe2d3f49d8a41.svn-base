package com.founder.rhip.ehr.entity.control.idm.special;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "IDM_LIST_TS")
public class ListTs implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = false)
	private Long id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|本系统唯一编码||", length = 11, nullable = false)
	private Long idmId;

	@Column(name = "MEDI_RECORD_NUM", columnDefinition = "VARCHAR2|病例编号|20|", length = 20, nullable = true)
	private String mediRecordNum;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|姓名|100|", length = 100, nullable = true)
    private String name;

    @Column(name = "PARENTS_NAME", columnDefinition = "VARCHAR2|家长姓名|50|", length = 50, nullable = true)
    private String parentsName;

    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别|1|", length = 1, nullable = true)
    private String gender;

    @Column(name = "BIRTHDAY", columnDefinition = "DATE|出生年月||", nullable = true)
    private Date birthday;

    @Column(name = "ATTACK_DT", columnDefinition = "DATE|发病日期||", nullable = true)
    private Date attackDt;

    @Column(name = "TREAT_DT", columnDefinition = "DATE|就诊日期||", nullable = true)
    private Date treatDt;

    @Column(name = "SAMPLE_DT", columnDefinition = "DATE|采样日期||", nullable = true)
    private Date sampleDt;

    @Column(name = "TEMPERATURE", columnDefinition = "VARCHAR2|体温|20|", length = 20, nullable = true)
    private String temperature;

    @Column(name = "OUTPATIENT", columnDefinition = "VARCHAR2|门诊病例|20|", length = 20, nullable = true)
    private String outpatient;

    @Column(name = "HOSPITALIZATION", columnDefinition = "VARCHAR2|住院病例|20|", length = 20, nullable = true)
    private String hospitalization;

    @Column(name = "THROAT_SWAB", columnDefinition = "VARCHAR2|标本－咽拭子|20|", length = 20, nullable = true)
    private String throatSwab;

    @Column(name = "PERCOLATE", columnDefinition = "VARCHAR2|标本－疱内渗出液|20|", length = 20, nullable = true)
    private String percolate;

    @Column(name = "EXCREMENT", columnDefinition = "VARCHAR2|标本－粪便|20|", length = 20, nullable = true)
    private String excrement;

    @Column(name = "ANUS_SWAB", columnDefinition = "VARCHAR2|标本－肛拭子|20|", length = 20, nullable = true)
    private String anusSwab;

    @Column(name = "CSF", columnDefinition = "VARCHAR2|标本－脑脊液|20|", length = 20, nullable = true)
    private String csf;

    @Column(name = "ACUTE_SERUM", columnDefinition = "VARCHAR2|标本－急性期血清|20|", length = 20, nullable = true)
    private String acuteSerum;

    @Column(name = "CONVALESCENT_SERUM", columnDefinition = "VARCHAR2|标本－恢复期血清|20|", length = 20, nullable = true)
    private String convalescentSerum;

    @Column(name = "OTHER", columnDefinition = "VARCHAR2|标本－其他|20|", length = 20, nullable = true)
    private String other;

    @Column(name = "LAB_RESULT", columnDefinition = "VARCHAR2|实验室结果|400|", length = 400, nullable = true)
    private String labResult;

    @Column(name = "CREATE_UNIT", columnDefinition = "VARCHAR2|新增单位||", length = 100, nullable = true)
    private String createUnit;

    @Column(name = "CREATE_DT", columnDefinition = "DATE|新增时间||", nullable = true)
    private Date createDt;

    @Column(name = "CREATE_USER", columnDefinition = "VARCHAR2|新增人||", length = 50, nullable = true)
    private String createUser;

    @Column(name = "MODIFY_UNIT", columnDefinition = "VARCHAR2|修改单位||", length = 100, nullable = true)
    private String modifyUnit;

	@Column(name = "GENRE_CODE", columnDefinition = "VARCHAR2|填报机构类别代码||", length = 20, nullable = true)
	private String genreCode;	
	
    @Column(name = "MODIFY_DT", columnDefinition = "DATE|修改时间||", nullable = true)
    private Date modifyDt;

    @Column(name = "MODIFY_USER", columnDefinition = "VARCHAR2|修改人||", length = 50, nullable = true)
    private String mofigyUser;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除标识||", length = 1, nullable = true)
    private Integer isDelete;

    @Column(name = "FLAG", columnDefinition = "VARCHAR2|类型||", length = 20, nullable = true)
    private String flag;

    @Column(name = "DIAGNOSIS_HFMD", columnDefinition = "VARCHAR2|诊断－手足口病||", length = 20, nullable = true)
    private String diagnosisHfmd;

    @Column(name = "DIAGNOSIS_ANGINA", columnDefinition = "VARCHAR2|诊断－疱疹性咽峡炎||", length = 20, nullable = true)
    private String diagnosisAngina;

    @Column(name = "DIAGNOSIS_MENINGITIS", columnDefinition = "VARCHAR2|诊断－无菌性脑膜炎||", length = 20, nullable = true)
    private String diagnosisMeningitis;

    @Column(name = "DIAGNOSIS_ENCEPHALITIS", columnDefinition = "VARCHAR2|诊断－脑干脑炎||", length = 20, nullable = true)
    private String diagnosisEncephalitis;

    @Column(name = "DIAGNOSIS_OTHER", columnDefinition = "VARCHAR2|诊断－其他||", length = 20, nullable = true)
    private String diagnosisOther;

    @Column(name = "DISEASE_CODE", columnDefinition = "VARCHAR2|疾病编码（字典）||", length = 20, nullable = true)
    private String diseaseCode;

    @Column(name = "BLOOD", columnDefinition = "VARCHAR2|标本－全血||", length = 20, nullable = true)
    private String blood;

    @Column(name = "SERUM", columnDefinition = "VARCHAR2|标本－血清||", length = 20, nullable = true)
    private String serum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdmId() {
        return idmId;
    }

    public void setIdmId(Long idmId) {
        this.idmId = idmId;
    }

    public String getMediRecordNum() {
        return mediRecordNum;
    }

    public void setMediRecordNum(String mediRecordNum) {
        this.mediRecordNum = mediRecordNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentsName() {
        return parentsName;
    }

    public void setParentsName(String parentsName) {
        this.parentsName = parentsName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getAttackDt() {
        return attackDt;
    }

    public void setAttackDt(Date attackDt) {
        this.attackDt = attackDt;
    }

    public Date getTreatDt() {
        return treatDt;
    }

    public void setTreatDt(Date treatDt) {
        this.treatDt = treatDt;
    }

    public Date getSampleDt() {
        return sampleDt;
    }

    public void setSampleDt(Date sampleDt) {
        this.sampleDt = sampleDt;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getOutpatient() {
        return outpatient;
    }

    public void setOutpatient(String outpatient) {
        this.outpatient = outpatient;
    }

    public String getHospitalization() {
        return hospitalization;
    }

    public void setHospitalization(String hospitalization) {
        this.hospitalization = hospitalization;
    }

    public String getThroatSwab() {
        return throatSwab;
    }

    public void setThroatSwab(String throatSwab) {
        this.throatSwab = throatSwab;
    }

    public String getPercolate() {
        return percolate;
    }

    public void setPercolate(String percolate) {
        this.percolate = percolate;
    }

    public String getExcrement() {
        return excrement;
    }

    public void setExcrement(String excrement) {
        this.excrement = excrement;
    }

    public String getAnusSwab() {
        return anusSwab;
    }

    public void setAnusSwab(String anusSwab) {
        this.anusSwab = anusSwab;
    }

    public String getCsf() {
        return csf;
    }

    public void setCsf(String csf) {
        this.csf = csf;
    }

    public String getAcuteSerum() {
        return acuteSerum;
    }

    public void setAcuteSerum(String acuteSerum) {
        this.acuteSerum = acuteSerum;
    }

    public String getConvalescentSerum() {
        return convalescentSerum;
    }

    public void setConvalescentSerum(String convalescentSerum) {
        this.convalescentSerum = convalescentSerum;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getLabResult() {
        return labResult;
    }

    public void setLabResult(String labResult) {
        this.labResult = labResult;
    }

    public String getCreateUnit() {
        return createUnit;
    }

    public void setCreateUnit(String createUnit) {
        this.createUnit = createUnit;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getModifyUnit() {
        return modifyUnit;
    }

    public void setModifyUnit(String modifyUnit) {
        this.modifyUnit = modifyUnit;
    }

    public Date getModifyDt() {
        return modifyDt;
    }

    public void setModifyDt(Date modifyDt) {
        this.modifyDt = modifyDt;
    }

    public String getMofigyUser() {
        return mofigyUser;
    }

    public void setMofigyUser(String mofigyUser) {
        this.mofigyUser = mofigyUser;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        isDelete = isDelete;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getDiagnosisHfmd() {
        return diagnosisHfmd;
    }

    public void setDiagnosisHfmd(String diagnosisHfmd) {
        this.diagnosisHfmd = diagnosisHfmd;
    }

    public String getDiagnosisAngina() {
        return diagnosisAngina;
    }

    public void setDiagnosisAngina(String diagnosisAngina) {
        this.diagnosisAngina = diagnosisAngina;
    }

    public String getDiagnosisMeningitis() {
        return diagnosisMeningitis;
    }

    public void setDiagnosisMeningitis(String diagnosisMeningitis) {
        this.diagnosisMeningitis = diagnosisMeningitis;
    }

    public String getDiagnosisEncephalitis() {
        return diagnosisEncephalitis;
    }

    public void setDiagnosisEncephalitis(String diagnosisEncephalitis) {
        this.diagnosisEncephalitis = diagnosisEncephalitis;
    }

    public String getDiagnosisOther() {
        return diagnosisOther;
    }

    public void setDiagnosisOther(String diagnosisOther) {
        this.diagnosisOther = diagnosisOther;
    }

    public String getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode;
    }

	public String getGenreCode() {
		return genreCode;
	}

	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getSerum() {
        return serum;
    }

    public void setSerum(String serum) {
        this.serum = serum;
    }
}