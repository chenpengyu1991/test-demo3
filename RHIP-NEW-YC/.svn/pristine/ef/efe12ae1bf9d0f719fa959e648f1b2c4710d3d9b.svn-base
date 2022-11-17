package com.founder.rhip.ehr.entity.control.idm.notifiabledisease;

import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "IDM_LIST_ES")
public class ListEs implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = true)
	private Long id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
	private Long idmId;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|患者姓名||", length = 100, nullable = true)
	private String name;

	@Column(name = "SEX", columnDefinition = "VARCHAR2|患者性别||", length = 100, nullable = true)
	private String sex;

	@Column(name = "AGE", columnDefinition = "VARCHAR2|患者年龄||", length = 100, nullable = true)
	private String age;

	@Column(name = "RELATION", columnDefinition = "VARCHAR2|与患者关系||", length = 20, nullable = true)
	private String relation;

	@Column(name = "ATTACK_CONDITION", columnDefinition = "VARCHAR2|发病情况||", length = 100, nullable = true)
	private String attackCondition;

	@Column(name = "ACTIVITY_DT", columnDefinition = "DATE|活动日期||", nullable = true)
	private Date activityDt;

	@Column(name = "ACTIVITY_CONTENT", columnDefinition = "VARCHAR2|活动内容||", length = 100, nullable = true)
	private String activityContent;

	@Column(name = "ACTIVITY_ADDR", columnDefinition = "VARCHAR2|活动地点||", length = 100, nullable = true)
	private String activityAddr;

	@Column(name = "CONTACT_NAME", columnDefinition = "VARCHAR2|接触人员||", length = 100, nullable = true)
	private String contactName;

	@Column(name = "ATTACK_DT", columnDefinition = "DATE|发病时间||", nullable = true)
	private Date attackDt;

	@Column(name = "CLINICAL_DIAGNOSIS", columnDefinition = "VARCHAR2|临床诊断||", length = 100, nullable = true)
	private String clinicalDiagnosis;

	@Column(name = "CONDACT_DT_LAST", columnDefinition = "DATE|最后接触时间||", nullable = true)
	private Date condactDtLast;

	@Column(name = "CONTACT_TYPE", columnDefinition = "VARCHAR2|接触方式||", length = 2, nullable = true)
	private String contactType;

	@Column(name = "CONTACT_RATE", columnDefinition = "VARCHAR2|接触频率||", length = 2, nullable = true)
	private String contactRate;

	@Column(name = "CONTACT_ADDR", columnDefinition = "VARCHAR2|接触地点||", length = 2, nullable = true)
	private String contactAddr;

	@Column(name = "CONTACT_ANIMAL_ADDR", columnDefinition = "VARCHAR2|接触动物地点||", length = 100, nullable = true)
	private String contactAnimalAddr;

	@Column(name = "CONTACT_ANIMAL_NAME", columnDefinition = "VARCHAR2|接触动物名称||", length = 100, nullable = true)
	private String contactAnimalName;

	@Column(name = "CONTACT_ANIMAL_SELL", columnDefinition = "VARCHAR2|接触动物方式-销售||", length = 100, nullable = true)
	private String contactAnimalSell;

	@Column(name = "CONTACT_ANIMAL_SLAUGHTER", columnDefinition = "VARCHAR2|接触动物方式-屠宰||", length = 100, nullable = true)
	private String contactAnimalSlaughter;

	@Column(name = "CONTACT_ANIMAL_EAT", columnDefinition = "VARCHAR2|接触动物方式-吃||", length = 100, nullable = true)
	private String contactAnimalEat;

	@Column(name = "CONTACT_ANIMAL_OTHER", columnDefinition = "VARCHAR2|接触动物方式-其他||", length = 100, nullable = true)
	private String contactAnimalOther;

    @Column(name = "CONTACT_BEGIN_DT", columnDefinition = "DATE|接触时间开始||", nullable = true)
    private Date contactBeginDt;

    @Column(name = "CONTACT_END_DT", columnDefinition = "DATE|接触时间结束||", nullable = true)
    private Date contactEndDt;

    @Column(name = "INHOSPITAL", columnDefinition = "VARCHAR2|是否住院||", length = 2, nullable = true)
    private String inhospital;

    @Column(name = "COMMENTS", columnDefinition = "VARCHAR2|备注||", length = 200, nullable = true)
    private String comments;

    @Column(name = "FLAG", columnDefinition = "VARCHAR2|类型|20|", length = 20, nullable = true)
    private String flag;
    
	/*接触动物方式*/
	@Transient
	private String[] contactAnimalType;
	
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

	public String getAttackCondition() {
		return this.attackCondition;
	}

	public void setAttackCondition(String attackCondition) {
		this.attackCondition = attackCondition;
	}

	public Date getActivityDt() {
		return this.activityDt;
	}

	public void setActivityDt(Date activityDt) {
		this.activityDt = activityDt;
	}

	public String getActivityContent() {
		return this.activityContent;
	}

	public void setActivityContent(String activityContent) {
		this.activityContent = activityContent;
	}

	public String getActivityAddr() {
		return this.activityAddr;
	}

	public void setActivityAddr(String activityAddr) {
		this.activityAddr = activityAddr;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
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

	public Date getCondactDtLast() {
		return this.condactDtLast;
	}

	public void setCondactDtLast(Date condactDtLast) {
		this.condactDtLast = condactDtLast;
	}

	public String getContactType() {
		return this.contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public String getContactRate() {
		return this.contactRate;
	}

	public void setContactRate(String contactRate) {
		this.contactRate = contactRate;
	}

	public String getContactAddr() {
		return this.contactAddr;
	}

	public void setContactAddr(String contactAddr) {
		this.contactAddr = contactAddr;
	}

	public String getContactAnimalAddr() {
		return this.contactAnimalAddr;
	}

	public void setContactAnimalAddr(String contactAnimalAddr) {
		this.contactAnimalAddr = contactAnimalAddr;
	}

	public String getContactAnimalName() {
		return this.contactAnimalName;
	}

	public void setContactAnimalName(String contactAnimalName) {
		this.contactAnimalName = contactAnimalName;
	}

	public String getContactAnimalSell() {
		return this.contactAnimalSell;
	}

	public void setContactAnimalSell(String contactAnimalSell) {
		this.contactAnimalSell = contactAnimalSell;
	}

	public String getContactAnimalSlaughter() {
		return this.contactAnimalSlaughter;
	}

	public void setContactAnimalSlaughter(String contactAnimalSlaughter) {
		this.contactAnimalSlaughter = contactAnimalSlaughter;
	}

	public String getContactAnimalEat() {
		return this.contactAnimalEat;
	}

	public void setContactAnimalEat(String contactAnimalEat) {
		this.contactAnimalEat = contactAnimalEat;
	}

	public String getContactAnimalOther() {
		return this.contactAnimalOther;
	}

	public void setContactAnimalOther(String contactAnimalOther) {
		this.contactAnimalOther = contactAnimalOther;
	}

    public Date getContactBeginDt() {
        return contactBeginDt;
    }

    public void setContactBeginDt(Date contactBeginDt) {
        this.contactBeginDt = contactBeginDt;
    }

    public Date getContactEndDt() {
        return contactEndDt;
    }

    public void setContactEndDt(Date contactEndDt) {
        this.contactEndDt = contactEndDt;
    }

    public String getInhospital() {
        return inhospital;
    }

    public void setInhospital(String inhospital) {
        this.inhospital = inhospital;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Transient
    private String inhospitalStr;

    @Transient
    private String sexStr;

    public String getInhospitalStr() {
        return StringUtil.isNotEmpty(inhospital)?("1".equals(inhospital)?"是":"否"):"";
    }

    public String getSexStr() {
        return StringUtil.isNotEmpty(sex)?("1".equals(sex)?"男":"女"):"";
    }

	/**
	 * @return the contactAnimalType
	 */
	public String[] getContactAnimalType() {
		if(StringUtil.isNotEmpty(this.contactAnimalSell) && ObjectUtil.isNullOrEmpty(this.contactAnimalType)){
			this.contactAnimalType = this.contactAnimalSell.split(",");
		}
		return contactAnimalType;
	}

	/**
	 * @param contactAnimalType the contactAnimalType to set
	 */
	public void setContactAnimalType(String[] contactAnimalType) {
		this.contactAnimalType = contactAnimalType;
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