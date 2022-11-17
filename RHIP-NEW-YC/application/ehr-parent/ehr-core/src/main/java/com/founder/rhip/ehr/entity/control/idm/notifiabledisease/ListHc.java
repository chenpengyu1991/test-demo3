package com.founder.rhip.ehr.entity.control.idm.notifiabledisease;

import com.founder.fasf.util.StringUtil;

import java.io.Serializable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "IDM_LIST_HC")
public class ListHc implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = false)
	private Integer id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|本系统唯一编码||", length = 11, nullable = false)
	private Integer idmId;

	@Column(name = "ANIMAL_TYPE", columnDefinition = "VARCHAR2|动物种类||", length = 100, nullable = true)
	private String animalType;

	@Column(name = "ANIMAL_NUM", columnDefinition = "VARCHAR2|饲养数量||", length = 100, nullable = true)
	private String animalNum;

	@Column(name = "ANIMAL_DT", columnDefinition = "DATE|饲养时间||", nullable = true)
	private Date animalDt;

	@Column(name = "ACTIVITY_RANGE", columnDefinition = "VARCHAR2|活动范围||", length = 2, nullable = true)
	private String activityRange;

	@Column(name = "DUNG_RANGE", columnDefinition = "VARCHAR2|动物粪便可见范围||", length = 2, nullable = true)
	private String dungRange;

	@Column(name = "DIE_NUM", columnDefinition = "VARCHAR2|病死数量||", length = 100, nullable = true)
	private String dieNum;

	@Column(name = "DIE_DT", columnDefinition = "DATE|发病/死亡时间||", nullable = true)
	private Date dieDt;

	@Column(name = "DIE_REASON", columnDefinition = "VARCHAR2|死亡原因||", length = 100, nullable = true)
	private String dieReason;

	@Column(name = "PROCESS_MODE", columnDefinition = "VARCHAR2|处理方式||", length = 100, nullable = true)
	private String processMode;

	@Column(name = "SAMPLE_TYPE", columnDefinition = "VARCHAR2|采样种类||", length = 100, nullable = true)
	private String sampleType;

	@Column(name = "SAMPLE_DT", columnDefinition = "DATE|采样时间||", nullable = true)
	private Date sampleDt;

	@Column(name = "SAMPLE_ADDR", columnDefinition = "VARCHAR2|采样地点||", length = 100, nullable = true)
	private String sampleAddr;

	@Column(name = "SAMPLE_NUM", columnDefinition = "VARCHAR2|采样份数||", length = 100, nullable = true)
	private String sampleNum;

	@Column(name = "DETECTION_RESULT", columnDefinition = "VARCHAR2|检测结果||", length = 100, nullable = true)
	private String detectionResult;

	@Column(name = "DETECTION_UNIT", columnDefinition = "VARCHAR2|检测单位||", length = 100, nullable = true)
	private String detectionUnit;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|名称||", length = 100, nullable = true)
	private String name;

	@Column(name = "SEX", columnDefinition = "VARCHAR2|性别||", length = 2, nullable = true)
	private String sex;

	@Column(name = "AGE", columnDefinition = "VARCHAR2|年龄||", length = 100, nullable = true)
	private String age;

	@Column(name = "ATTACK", columnDefinition = "VARCHAR2|是否发病||", length = 100, nullable = true)
	private String attack;

	@Column(name = "DIE_ANIMAL_CATEGORY", columnDefinition = "VARCHAR2|接触病死动物种类||", length = 100, nullable = true)
	private String dieAnimalCategory;

	@Column(name = "DIE_ANIMAL_TYPE", columnDefinition = "VARCHAR2|接触病死动物方式||", length = 2, nullable = true)
	private String dieAnimalType;

    @Column(name = "ACTIVITY_RANGE_DETAIL", columnDefinition = "VARCHAR2|活动范围－文本||", length = 20, nullable = true)
    private String activityRangeDetail;

    @Column(name = "DUNG_RANGE_DETAIL", columnDefinition = "VARCHAR2|动物粪便可见范围－文本||", length = 20, nullable = true)
    private String dungRangeDetail;

    @Column(name = "DIE_ANIMAL_TYPE_DETAIL", columnDefinition = "VARCHAR2|接触病死动物方式－文本||", length = 20, nullable = true)
    private String dieAnimalTypeDetail;

    @Column(name = "FLAG", columnDefinition = "VARCHAR2|子表标识||", length = 20, nullable = true)
    private String flag;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdmId() {
		return this.idmId;
	}

	public void setIdmId(Integer idmId) {
		this.idmId = idmId;
	}

	public String getAnimalType() {
		return this.animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	public String getAnimalNum() {
		return this.animalNum;
	}

	public void setAnimalNum(String animalNum) {
		this.animalNum = animalNum;
	}

	public Date getAnimalDt() {
		return this.animalDt;
	}

	public void setAnimalDt(Date animalDt) {
		this.animalDt = animalDt;
	}

	public String getActivityRange() {
		return this.activityRange;
	}

	public void setActivityRange(String activityRange) {
		this.activityRange = activityRange;
	}

	public String getDungRange() {
		return this.dungRange;
	}

	public void setDungRange(String dungRange) {
		this.dungRange = dungRange;
	}

	public String getDieNum() {
		return this.dieNum;
	}

	public void setDieNum(String dieNum) {
		this.dieNum = dieNum;
	}

	public Date getDieDt() {
		return this.dieDt;
	}

	public void setDieDt(Date dieDt) {
		this.dieDt = dieDt;
	}

	public String getDieReason() {
		return this.dieReason;
	}

	public void setDieReason(String dieReason) {
		this.dieReason = dieReason;
	}

	public String getProcessMode() {
		return this.processMode;
	}

	public void setProcessMode(String processMode) {
		this.processMode = processMode;
	}

	public String getSampleType() {
		return this.sampleType;
	}

	public void setSampleType(String sampleType) {
		this.sampleType = sampleType;
	}

	public Date getSampleDt() {
		return this.sampleDt;
	}

	public void setSampleDt(Date sampleDt) {
		this.sampleDt = sampleDt;
	}

	public String getSampleAddr() {
		return this.sampleAddr;
	}

	public void setSampleAddr(String sampleAddr) {
		this.sampleAddr = sampleAddr;
	}

	public String getSampleNum() {
		return this.sampleNum;
	}

	public void setSampleNum(String sampleNum) {
		this.sampleNum = sampleNum;
	}

	public String getDetectionResult() {
		return this.detectionResult;
	}

	public void setDetectionResult(String detectionResult) {
		this.detectionResult = detectionResult;
	}

	public String getDetectionUnit() {
		return this.detectionUnit;
	}

	public void setDetectionUnit(String detectionUnit) {
		this.detectionUnit = detectionUnit;
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

	public String getAttack() {
		return this.attack;
	}

	public void setAttack(String attack) {
		this.attack = attack;
	}

	public String getDieAnimalCategory() {
		return this.dieAnimalCategory;
	}

	public void setDieAnimalCategory(String dieAnimalCategory) {
		this.dieAnimalCategory = dieAnimalCategory;
	}

	public String getDieAnimalType() {
		return this.dieAnimalType;
	}

	public void setDieAnimalType(String dieAnimalType) {
		this.dieAnimalType = dieAnimalType;
	}

    public String getActivityRangeDetail() {
        return activityRangeDetail;
    }

    public void setActivityRangeDetail(String activityRangeDetail) {
        this.activityRangeDetail = activityRangeDetail;
    }

    public String getDungRangeDetail() {
        return dungRangeDetail;
    }

    public void setDungRangeDetail(String dungRangeDetail) {
        this.dungRangeDetail = dungRangeDetail;
    }

    public String getDieAnimalTypeDetail() {
        return dieAnimalTypeDetail;
    }

    public void setDieAnimalTypeDetail(String dieAnimalTypeDetail) {
        this.dieAnimalTypeDetail = dieAnimalTypeDetail;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Transient
    private String sexStr;

    @Transient
    private String attackStr;

    public String getSexStr() {
        return StringUtil.isNotEmpty(sex)?("1".equals(sex)?"男":"女"):"";
    }

    public String getAttackStr() {
        return StringUtil.isNotEmpty(attack)?("1".equals(attack)?"是":"否"):"";
    }
}