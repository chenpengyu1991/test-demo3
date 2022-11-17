package com.founder.rhip.ehr.entity.child;


import com.founder.rhip.ehr.common.JaxbDateSerializer;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "CH_FRAIL_CHILD_FOLLOWUP")
@XmlRootElement
public class FrailChildFollowup implements Serializable {

	private static final long serialVersionUID = 7964168450739936165L;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = false)
    private String ehrId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
    private Long personId;
    
    @Column(name = "HEALTH_FILE_NO", columnDefinition = "VARCHAR2|城乡居民健康档案编号||", length = 17, nullable = true)
    private String healthFileNo;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 30, nullable = true)
    private String name;
    
    @Column(name = "ID_CARD", columnDefinition = "VARCHAR2|身份证件号码||", length = 18, nullable = true)
    private String idCard;

    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别||", length = 1, nullable = true)
    private String gender;

    @Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
    private Date birthday;

    @Column(name = "MOTHER_NAME", columnDefinition = "VARCHAR2|母亲姓名||", length = 30, nullable = true)
    private String motherName;

    @Column(name = "FATHER_NAME", columnDefinition = "VARCHAR2|父亲姓名||", length = 30, nullable = true)
    private String fatherName;

    @Column(name = "HRPROVINCE", columnDefinition = "VARCHAR2|户籍地址一省(自治区、直辖市)||", length = 70, nullable = true)
    private String hrprovince;

    @Column(name = "HRCITY", columnDefinition = "VARCHAR2|户籍地址-市(地区、州)||", length = 70, nullable = true)
    private String hrcity;

    @Column(name = "HRCOUNTY", columnDefinition = "VARCHAR2|户籍地址-县(区)||", length = 70, nullable = true)
    private String hrcounty;

    @Column(name = "HRTOWN_SHIP", columnDefinition = "VARCHAR2|户籍地址-乡(镇、街道办事处)||", length = 70, nullable = true)
    private String hrtownShip;

    @Column(name = "HRSTREET", columnDefinition = "VARCHAR2|户籍地址-村(街、路、弄等)||", length = 70, nullable = true)
    private String hrstreet;

    @Column(name = "HRHOUSE_NUMBER", columnDefinition = "VARCHAR2|户籍地址-门牌号码||", length = 70, nullable = true)
    private String hrhouseNumber;

    @Column(name = "HRPOST_CODE", columnDefinition = "VARCHAR2|户籍地址邮政编码||", length = 6, nullable = true)
    private String hrpostCode;

    @Column(name = "PAPROVINCE", columnDefinition = "VARCHAR2|现住地址-省(自治区、直辖市)||", length = 70, nullable = true)
    private String paprovince;

    @Column(name = "PACITY", columnDefinition = "VARCHAR2|现住地址一市(地区、州)||", length = 70, nullable = true)
    private String pacity;

    @Column(name = "PACOUNTY", columnDefinition = "VARCHAR2|现住地址-县(区)||", length = 70, nullable = true)
    private String pacounty;

    @Column(name = "PATOWN_SHIP", columnDefinition = "VARCHAR2|现住地址一乡(镇、街道办事处)||", length = 70, nullable = true)
    private String patownShip;

    @Column(name = "PASTREET", columnDefinition = "VARCHAR2|现住地址-村(街、路、弄等)||", length = 70, nullable = true)
    private String pastreet;

    @Column(name = "PAHOUSE_NUMBER", columnDefinition = "VARCHAR2|现住地址-门牌号码||", length = 70, nullable = true)
    private String pahouseNumber;

    @Column(name = "PAPOST_CODE", columnDefinition = "VARCHAR2|现住址邮政编码||", length = 6, nullable = true)
    private String papostCode;

    @Column(name = "TEL_TYPE", columnDefinition = "VARCHAR2|联系电话-类别||", length = 20, nullable = true)
    private String telType;

    @Column(name = "TEL_NUMBER", columnDefinition = "VARCHAR2|联系电话-号码||", length = 20, nullable = true)
    private String telNumber;


    @Column(name = "RECORD_NUMBER", columnDefinition = "VARCHAR2|记录表单编号||", length = 20, nullable = true)
    private String recordNumber;

    @Column(name = "FEEDING_TYPE", columnDefinition = "VARCHAR2|喂养方式类别代码||", length = 1, nullable = true)
    private String feedingType;

    @Column(name = "FOLLOW_UP_MONTH", columnDefinition = "NUMBER|随诊月龄||", length = 5, nullable = true)
    private Integer followUpMonth;

    @Column(name = "CHILDREN_DEBILITY_TYPE", columnDefinition = "VARCHAR2|儿童体弱原因类别代码||", length = 2, nullable = true)
    private String childrenDebilityType;

    @Column(name = "SYMPTOM", columnDefinition = "VARCHAR2|症状||", length = 100, nullable = true)
    private String symptom;

    @Column(name = "SIGNS", columnDefinition = "VARCHAR2|体征||", length = 100, nullable = true)
    private String signs;

    @Column(name = "MG_OPINION", columnDefinition = "VARCHAR2|处理及指导意见||", length = 500, nullable = true)
    private String mgOpinion;

    @Column(name = "RESERVE_DATE", columnDefinition = "DATE|预约日期||", nullable = true)
    private Date reserveDate;

    @Column(name = "CHILDREN_PROGNOSIS_CODE", columnDefinition = "VARCHAR2|体弱儿童转归代码||", length = 1, nullable = true)
    private String childrenPrognosisCode;

    @Column(name = "CLOSED_DATE", columnDefinition = "DATE|结案日期||", nullable = true)
    private Date closedDate;

    @Column(name = "CLOSED_DOCTOR_NAME", columnDefinition = "VARCHAR2|结案医师姓名||", length = 30, nullable = true)
    private String closedDoctorName;

    @Column(name = "CLOSED_UNIT_NAME", columnDefinition = "VARCHAR2|结案单位名称||", length = 70, nullable = true)
    private String closedUnitName;

    @Column(name = "INPUT_DATE", columnDefinition = "DATE|建档日期||", nullable = true)
    private Date inputDate;

    @Column(name = "AE_ITEM_NAME", columnDefinition = "VARCHAR2|辅助检查-项目名称||", length = 100, nullable = true)
    private String aeItemName;

    @Column(name = "AE_RESULT", columnDefinition = "VARCHAR2|辅助检查-结果||", length = 100, nullable = true)
    private String aeResult;

    @Column(name = "CHECK_DATE", columnDefinition = "DATE|检查(测)日期||", nullable = true)
    private Date checkDate;

    @Column(name = "CHECK_NAME", columnDefinition = "VARCHAR2|检查(测)人员姓名||", length = 30, nullable = true)
    private String checkName;

    @Column(name = "CHECK_JOB_NUMBER", columnDefinition = "VARCHAR2|检查人员工号||", length = 50, nullable = true)
    private String checkJobNumber;
    
    @Column(name = "CHECK_IDCARD", columnDefinition = "VARCHAR2|检查人员身份证||", length = 18, nullable = true)
    private String checkIdcard;
    
    @Column(name = "CHECK_ORGAN_NAME", columnDefinition = "VARCHAR2|检查(测)机构名称||", length = 70, nullable = true)
    private String checkOrganName;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;
    
	@Column(name = "PROCESS_STATUS", columnDefinition = "VARCHAR2|处理状态||", length = 1, nullable = true)
	private String processStatus = "0";
    
    @Transient
    private String feedingTypeDesc;
    
    @Transient
    private String effectiveTime;
    
    @Transient
	private String systemTime;
    
	@Transient
	private String versionNumber;
	
	@Transient
	private String  childrenDebilityTypeDesc;
	
	@Transient
	private String childrenPrognosisCodeDesc;

    
  	@Column(name = "MOTHER_IDCARD", columnDefinition = "VARCHAR2|母亲身份证件-号码||", length = 18, nullable = true)
	private String motherIdcard;
	
	@Column(name = "BABY_CARD_NO", columnDefinition = "VARCHAR2|宝宝卡号||", length = 13, nullable = true)
	private String babyCardNo;
	
	@Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|填报机构代码||", length = 20, nullable = true)
	private String createOrganCode;
	
	@Column(name = "CREATE_ORGAN_NAME", columnDefinition = "VARCHAR2|填报机构名称||", length = 70, nullable = true)
	private String createOrganName;
	
	@Column(name = "GATHER_DATE", columnDefinition = "DATE|采集时间||", nullable = true)
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
    public String getFeedingType() {
        return this.feedingType;
    }

    public void setFeedingType(String feedingType) {
        this.feedingType = feedingType;
    }

    @XmlElement
    public Integer getFollowUpMonth() {
        return this.followUpMonth;
    }

    public void setFollowUpMonth(Integer followUpMonth) {
        this.followUpMonth = followUpMonth;
    }

    @XmlElement
    public String getChildrenDebilityType() {
        return this.childrenDebilityType;
    }

    public void setChildrenDebilityType(String childrenDebilityType) {
        this.childrenDebilityType = childrenDebilityType;
    }

    @XmlElement
    public String getSymptom() {
        return this.symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    @XmlElement
    public String getSigns() {
        return this.signs;
    }

    public void setSigns(String signs) {
        this.signs = signs;
    }

    @XmlElement
    public String getMgOpinion() {
        return this.mgOpinion;
    }

    public void setMgOpinion(String mgOpinion) {
        this.mgOpinion = mgOpinion;
    }

    @XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    public Date getReserveDate() {
        return this.reserveDate;
    }

    public void setReserveDate(Date reserveDate) {
        this.reserveDate = reserveDate;
    }

    @XmlElement(name = "debilityChildrenPrognosisCode")
    public String getChildrenPrognosisCode() {
		return childrenPrognosisCode;
	}

	public void setChildrenPrognosisCode(String childrenPrognosisCode) {
		this.childrenPrognosisCode = childrenPrognosisCode;
	}

    @XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    public Date getClosedDate() {
        return this.closedDate;
    }

    public void setClosedDate(Date closedDate) {
        this.closedDate = closedDate;
    }

    @XmlElement
    public String getClosedDoctorName() {
        return this.closedDoctorName;
    }

    public void setClosedDoctorName(String closedDoctorName) {
        this.closedDoctorName = closedDoctorName;
    }

    @XmlElement
    public String getClosedUnitName() {
        return this.closedUnitName;
    }

    public void setClosedUnitName(String closedUnitName) {
        this.closedUnitName = closedUnitName;
    }

    @XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    public Date getInputDate() {
        return this.inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    @XmlElement
    public String getAeItemName() {
        return this.aeItemName;
    }

    public void setAeItemName(String aeItemName) {
        this.aeItemName = aeItemName;
    }

    @XmlElement
    public String getAeResult() {
        return this.aeResult;
    }

    public void setAeResult(String aeResult) {
        this.aeResult = aeResult;
    }

    @XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
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

	@XmlElement
	public String getGender() {
		return gender;
	}

	
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getMotherName() {
		return motherName;
	}

	
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	@XmlElement
	public String getFatherName() {
		return fatherName;
	}

	
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
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
	public String getHrpostCode() {
		return hrpostCode;
	}

	
	public void setHrpostCode(String hrpostCode) {
		this.hrpostCode = hrpostCode;
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
	public String getPapostCode() {
		return papostCode;
	}

	
	public void setPapostCode(String papostCode) {
		this.papostCode = papostCode;
	}

	@XmlElement
	public String getTelType() {
		return telType;
	}

	
	public void setTelType(String telType) {
		this.telType = telType;
	}

	@XmlElement
	public String getTelNumber() {
		return telNumber;
	}

	
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	
	public Long getPersonId() {
		return personId;
	}

	
	public void setPersonId(Long personId) {
		this.personId = personId;
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
	
	public String getFeedingTypeDesc() {
		return feedingTypeDesc;
	}

	
	public void setFeedingTypeDesc(String feedingTypeDesc) {
		this.feedingTypeDesc = feedingTypeDesc;
	}

	
	public String getProcessStatus() {
		return processStatus;
	}

	
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	
	public String getEffectiveTime() {
		return effectiveTime;
	}

	
	public void setEffectiveTime(String effectiveTime) {
		this.effectiveTime = effectiveTime;
	}

	
	public String getSystemTime() {
		return systemTime;
	}

	
	public void setSystemTime(String systemTime) {
		this.systemTime = systemTime;
	}

	
	public String getVersionNumber() {
		return versionNumber;
	}

	
	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}

	
	public String getChildrenDebilityTypeDesc() {
		return childrenDebilityTypeDesc;
	}

	
	public void setChildrenDebilityTypeDesc(String childrenDebilityTypeDesc) {
		this.childrenDebilityTypeDesc = childrenDebilityTypeDesc;
	}

	
	public String getChildrenPrognosisCodeDesc() {
		return childrenPrognosisCodeDesc;
	}

	
	public void setChildrenPrognosisCodeDesc(String childrenPrognosisCodeDesc) {
		this.childrenPrognosisCodeDesc = childrenPrognosisCodeDesc;
	}

	public Date getGatherDate() {
		return gatherDate;
	}

	public void setGatherDate(Date gatherDate) {
		this.gatherDate = gatherDate;
	}

	public String getCheckJobNumber() {
		return checkJobNumber;
	}

	public void setCheckJobNumber(String checkJobNumber) {
		this.checkJobNumber = checkJobNumber;
	}

	public String getCheckIdcard() {
		return checkIdcard;
	}

	public void setCheckIdcard(String checkIdcard) {
		this.checkIdcard = checkIdcard;
	}

	
}
