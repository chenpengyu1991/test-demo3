package com.founder.rhip.ehr.entity.control.idm.notifiabledisease;

import com.founder.fasf.util.StringUtil;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "IDM_LIST_EFC")
public class ListEfc implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = true)
	private Long id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
	private Long idmId;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 100, nullable = true)
	private String name;

	@Column(name = "SEX", columnDefinition = "VARCHAR2|性别||", length = 2, nullable = true)
	private String sex;

	@Column(name = "AGE", columnDefinition = "VARCHAR2|年龄||", length = 100, nullable = true)
	private String age;

	@Column(name = "RELATION", columnDefinition = "VARCHAR2|与病例(患者)关系||", length = 100, nullable = true)
	private String relation;

	@Column(name = "ATTACK_DT", columnDefinition = "DATE|发病时间||", nullable = true)
	private Date attackDt;

	@Column(name = "CLINICAL_DIAGNOSIS", columnDefinition = "VARCHAR2|临床诊断||", length = 100, nullable = true)
	private String clinicalDiagnosis;

	@Column(name = "CONTACT_BEGIN_DT", columnDefinition = "DATE|接触时间开始||", nullable = true)
	private Date contactBeginDt;

	@Column(name = "CONTACT_END_DT", columnDefinition = "DATE|接触时间结束||", nullable = true)
	private Date contactEndDt;

	@Column(name = "INHOSPITAL", columnDefinition = "VARCHAR2|是否住院||", length = 2, nullable = true)
	private String inhospital;

	@Column(name = "COMMENTS", columnDefinition = "VARCHAR2|备注||", length = 200, nullable = true)
	private String comments;

	@Column(name = "TEL", columnDefinition = "VARCHAR2|联系电话||", length = 100, nullable = true)
	private String tel;

	@Column(name = "UNIT_ADDR", columnDefinition = "VARCHAR2|单位或住址||", length = 100, nullable = true)
	private String unitAddr;

	@Column(name = "LAB_EXAMINATION", columnDefinition = "VARCHAR2|实验室检查||", length = 100, nullable = true)
	private String labExamination;

	@Column(name = "ACTIVITY_DT", columnDefinition = "DATE|活动时间||", nullable = true)
	private Date activityDt;

	@Column(name = "ACTIVITY_ADDR", columnDefinition = "VARCHAR2|活动地点||", length = 100, nullable = true)
	private String activityAddr;

	@Column(name = "DUNG_ADDR", columnDefinition = "VARCHAR2|解大便处||", length = 100, nullable = true)
	private String dungAddr;

	@Column(name = "VOMIT_ADDR", columnDefinition = "VARCHAR2|呕吐处||", length = 100, nullable = true)
	private String vomitAddr;

	@Column(name = "VEHICLE_POLLUTE", columnDefinition = "VARCHAR2|交通工具污染||", length = 100, nullable = true)
	private String vehiclePollute;

	@Column(name = "CONTACT_TYPE", columnDefinition = "VARCHAR2|接触方式||", length = 100, nullable = true)
	private String contactType;

	@Column(name = "LINKMAN", columnDefinition = "VARCHAR2|主要联系人||", length = 100, nullable = true)
	private String linkman;

	@Column(name = "CONTACT_NAME", columnDefinition = "VARCHAR2|接触者名单||", length = 100, nullable = true)
	private String contactName;

	@Column(name = "OBJECT", columnDefinition = "VARCHAR2|对象||", length = 2, nullable = true)
	private String object;

	@Column(name = "STERILIZE_DRUG", columnDefinition = "VARCHAR2|消毒药物||", length = 100, nullable = true)
	private String sterilizeDrug;

	@Column(name = "DRUG_CONCENTRATION", columnDefinition = "VARCHAR2|药物浓度||", length = 100, nullable = true)
	private String drugConcentration;

	@Column(name = "DRUG_NUM", columnDefinition = "VARCHAR2|数量||", length = 100, nullable = true)
	private String drugNum;

	@Column(name = "STERILIZE_DT", columnDefinition = "DATE|消毒时间||", nullable = true)
	private Date sterilizeDt;

	@Column(name = "STERILIZE_TYPE", columnDefinition = "VARCHAR2|消毒方式||", length = 100, nullable = true)
	private String sterilizeType;

	@Column(name = "PROFESSION", columnDefinition = "VARCHAR2|职业||", length = 100, nullable = true)
	private String profession;

	@Column(name = "SAME_RESIDE", columnDefinition = "VARCHAR2|同住||", length = 100, nullable = true)
	private String sameReside;

	@Column(name = "SAME_UNIT", columnDefinition = "VARCHAR2|同单位||", length = 100, nullable = true)
	private String sameUnit;

	@Column(name = "NEIGHBOR", columnDefinition = "VARCHAR2|邻居||", length = 100, nullable = true)
	private String neighbor;

	@Column(name = "VACCINE_HISTORY", columnDefinition = "VARCHAR2|疫苗接种史||", length = 100, nullable = true)
	private String vaccineHistory;

	@Column(name = "ATTACK_CONDITION", columnDefinition = "VARCHAR2|发病情况||", length = 100, nullable = true)
	private String attackCondition;

	@Column(name = "VACCINE_DT", columnDefinition = "DATE|预防接种日期||", nullable = true)
	private Date vaccineDt;

	@Column(name = "DELOUSING_DT", columnDefinition = "DATE|灭虱日期||", nullable = true)
	private Date delousingDt;

    @Column(name = "ATTACK", columnDefinition = "VARCHAR2|是否发病||", length = 2, nullable = true)
    private String attack;

    @Column(name = "FLAG", columnDefinition = "VARCHAR2|类型|20|", length = 20, nullable = true)
    private String flag;
    
    @Column(name = "MEDICAL_OBSERVATION_RESULTS", columnDefinition = "VARCHAR2|医学观察结果|100|", length = 100, nullable = true)
	private String medicalObservationResults;
    
	public String getMedicalObservationResults() {
		return medicalObservationResults;
	}

	public void setMedicalObservationResults(String medicalObservationResults) {
		this.medicalObservationResults = medicalObservationResults;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdmId() {
		return this.idmId;
	}

	public void setIdmId(Long idmId) {
		this.idmId = idmId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getRelation() {
		return this.relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public Date getAttackDt() {
		return this.attackDt;
	}

	public void setAttackDt(Date attackDt) {
		this.attackDt = attackDt;
	}

	public String getClinicalDiagnosis() {
		return this.clinicalDiagnosis;
	}

	public void setClinicalDiagnosis(String clinicalDiagnosis) {
		this.clinicalDiagnosis = clinicalDiagnosis;
	}

	public Date getContactBeginDt() {
		return this.contactBeginDt;
	}

	public void setContactBeginDt(Date contactBeginDt) {
		this.contactBeginDt = contactBeginDt;
	}

	public Date getContactEndDt() {
		return this.contactEndDt;
	}

	public void setContactEndDt(Date contactEndDt) {
		this.contactEndDt = contactEndDt;
	}

	public String getInhospital() {
		return this.inhospital;
	}

	public void setInhospital(String inhospital) {
		this.inhospital = inhospital;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getUnitAddr() {
		return this.unitAddr;
	}

	public void setUnitAddr(String unitAddr) {
		this.unitAddr = unitAddr;
	}

	public String getLabExamination() {
		return this.labExamination;
	}

	public void setLabExamination(String labExamination) {
		this.labExamination = labExamination;
	}

	public Date getActivityDt() {
		return this.activityDt;
	}

	public void setActivityDt(Date activityDt) {
		this.activityDt = activityDt;
	}

	public String getActivityAddr() {
		return this.activityAddr;
	}

	public void setActivityAddr(String activityAddr) {
		this.activityAddr = activityAddr;
	}

	public String getDungAddr() {
		return this.dungAddr;
	}

	public void setDungAddr(String dungAddr) {
		this.dungAddr = dungAddr;
	}

	public String getVomitAddr() {
		return this.vomitAddr;
	}

	public void setVomitAddr(String vomitAddr) {
		this.vomitAddr = vomitAddr;
	}

	public String getVehiclePollute() {
		return this.vehiclePollute;
	}

	public void setVehiclePollute(String vehiclePollute) {
		this.vehiclePollute = vehiclePollute;
	}

	public String getContactType() {
		return this.contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public String getLinkman() {
		return this.linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getObject() {
		return this.object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getSterilizeDrug() {
		return this.sterilizeDrug;
	}

	public void setSterilizeDrug(String sterilizeDrug) {
		this.sterilizeDrug = sterilizeDrug;
	}

	public String getDrugConcentration() {
		return this.drugConcentration;
	}

	public void setDrugConcentration(String drugConcentration) {
		this.drugConcentration = drugConcentration;
	}

	public String getDrugNum() {
		return this.drugNum;
	}

	public void setDrugNum(String drugNum) {
		this.drugNum = drugNum;
	}

	public Date getSterilizeDt() {
		return this.sterilizeDt;
	}

	public void setSterilizeDt(Date sterilizeDt) {
		this.sterilizeDt = sterilizeDt;
	}

	public String getSterilizeType() {
		return this.sterilizeType;
	}

	public void setSterilizeType(String sterilizeType) {
		this.sterilizeType = sterilizeType;
	}

	public String getProfession() {
		return this.profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getSameReside() {
		return this.sameReside;
	}

	public void setSameReside(String sameReside) {
		this.sameReside = sameReside;
	}

	public String getSameUnit() {
		return this.sameUnit;
	}

	public void setSameUnit(String sameUnit) {
		this.sameUnit = sameUnit;
	}

	public String getNeighbor() {
		return this.neighbor;
	}

	public void setNeighbor(String neighbor) {
		this.neighbor = neighbor;
	}

	public String getVaccineHistory() {
		return this.vaccineHistory;
	}

	public void setVaccineHistory(String vaccineHistory) {
		this.vaccineHistory = vaccineHistory;
	}

	public String getAttackCondition() {
		return this.attackCondition;
	}

	public void setAttackCondition(String attackCondition) {
		this.attackCondition = attackCondition;
	}

	public Date getVaccineDt() {
		return this.vaccineDt;
	}

	public void setVaccineDt(Date vaccineDt) {
		this.vaccineDt = vaccineDt;
	}

	public Date getDelousingDt() {
		return this.delousingDt;
	}

	public void setDelousingDt(Date delousingDt) {
		this.delousingDt = delousingDt;
	}

    public String getAttack() {
        return attack;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }

    @Transient
    private String inhospitalStr;

    @Transient
    private String sexStr;

    @Transient
    private String attackStr;

    @Transient
    private String contactTypeStr;
    
    @Transient
    private String attackConditionStr;
    
    @Transient
    private String vaccineHistoryStr;
    
    public String getVaccineHistoryStr(){
    	return StringUtil.isNotEmpty(vaccineHistory)?("1".equals(vaccineHistory)?"是":"否"):"";
    }
     
    public String getAttackConditionStr(){
    	return StringUtil.isNotEmpty(attackCondition)?("1".equals(attackCondition)?"是":"否"):"";
    }
    
    public String getInhospitalStr() {
        return StringUtil.isNotEmpty(inhospital)?("1".equals(inhospital)?"是":"否"):"";
    }

    public String getSexStr() {
        return StringUtil.isNotEmpty(sex)?("1".equals(sex)?"男":"女"):"";
    }

    public String getAttackStr() {
        return StringUtil.isNotEmpty(attack)?("1".equals(attack)?"是":"否"):"";
    }

    public String getContactTypeStr() {
        String result = "";
        if(StringUtil.isNotEmpty(contactType)){
            if("1".equals(contactType)){
                result = "同一家庭";
            }else if("2".equals(contactType)){
                result = "邻居来往";
            }else if("4".equals(contactType)){
                result = "同工作";
            }
        }
        return result;
    }

	/**
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
}