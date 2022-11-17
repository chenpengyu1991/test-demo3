package com.founder.rhip.ehr.entity.child;


import com.founder.rhip.ehr.common.JaxbDateSerializer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "CH_NEONATAL_DISEASE_SCREEN")
@XmlRootElement
public class NeonatalDiseaseScreen implements Serializable {

	private static final long serialVersionUID = 8178261165916819198L;

	@Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = false)
    private String ehrId;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;
    
    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
    private Long personId;

	@Column(name = "RECORD_NUMBER", columnDefinition = "VARCHAR2|记录表单编号||", length = 20, nullable = true)
    private String recordNumber;

    @Column(name = "NEONATAL_NAME", columnDefinition = "VARCHAR2|姓名||", length = 30, nullable = true)
    private String neonatalName;

    @Column(name = "NEONATAL_GENDER", columnDefinition = "VARCHAR2|性别||", length = 1, nullable = true)
    private String neonatalGender;

    @Column(name = "NEONATAL_BIRTHDAY", columnDefinition = "TIMESTAMP|出生日期||", nullable = true)
    private Date neonatalBirthday;

    @Column(name = "MOTHER_NAME", columnDefinition = "VARCHAR2|母亲姓名||", length = 30, nullable = true)
    private String motherName;

    @Column(name = "MOTHER_BIRTHDAY", columnDefinition = "DATE|母亲出生日期||", nullable = true)
    private Date motherBirthday;

    @Column(name = "MOTHER_IDCARD_TYPE", columnDefinition = "VARCHAR2|母亲身份证件-类别代码||", length = 1, nullable = true)
    private String motherIdcardType;

    @Column(name = "MOTHER_IDCARD", columnDefinition = "VARCHAR2|母亲身份证件-号码||", length = 18, nullable = true)
    private String motherIdcard;

    @Column(name = "AREA_CODE", columnDefinition = "VARCHAR2|行政区划代码||", length = 6, nullable = true)
    private String areaCode;

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

    @Column(name = "SPECIMEN_NUMBER", columnDefinition = "VARCHAR2|标本编号||", length = 20, nullable = true)
    private String specimenNumber;

    @Column(name = "SAMPLING_DATE", columnDefinition = "TIMESTAMP|采血日期时间||", nullable = true)
    private Date samplingDate;

    @Column(name = "SAMPLING_WAY", columnDefinition = "VARCHAR2|采血方式代码||", length = 1, nullable = true)
    private String samplingWay;

    @Column(name = "SAMPLING_PART", columnDefinition = "VARCHAR2|采血部位代码||", length = 1, nullable = true)
    private String samplingPart;

    @Column(name = "SAMPLING_ORGAN_NAME", columnDefinition = "VARCHAR2|采血机构名称||", length = 70, nullable = true)
    private String samplingOrganName;

    @Column(name = "BLOOD_PERSON_NAME", columnDefinition = "VARCHAR2|采血人员姓名||", length = 30, nullable = true)
    private String bloodPersonName;

    @Column(name = "NEONATAL_DISEASE_SCREEN_ITEM", columnDefinition = "VARCHAR2|新生儿疾病筛查项目代码||", length = 1, nullable = true)
    private String neonatalDiseaseScreenItem;

    @Column(name = "NEONATAL_DISEASE_SCREEN_METHOD", columnDefinition = "VARCHAR2|新生儿疾病筛查方法代码||", length = 1, nullable = true)
    private String neonatalDiseaseScreenMethod;

    @Column(name = "NEONATAL_DISEASE_SCREEN_RESULT", columnDefinition = "VARCHAR2|新生儿疾病筛查结果||", length = 100, nullable = true)
    private String neonatalDiseaseScreenResult;

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

    @Column(name = "SCREEN_NOTICE_DATE", columnDefinition = "DATE|筛查结果通知日期||", nullable = true)
    private Date screenNoticeDate;

    @Column(name = "RECALL_DATE", columnDefinition = "DATE|召回日期||", nullable = true)
    private Date recallDate;

    @Column(name = "CHECK_NOTICE", columnDefinition = "VARCHAR2|检查结果通知形式代码||", length = 1, nullable = true)
    private String checkNotice;

    @Column(name = "NOTICE_MASTER_NAME", columnDefinition = "VARCHAR2|通知到达人姓名||", length = 30, nullable = true)
    private String noticeMasterName;

    @Column(name = "NOTICE_RELATION", columnDefinition = "VARCHAR2|通知到达人与新生儿关系代码||", length = 2, nullable = true)
    private String noticeRelation;

    @Column(name = "NOTICE_NAME", columnDefinition = "VARCHAR2|通知者姓名||", length = 30, nullable = true)
    private String noticeName;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

	@Column(name = "BABY_CARD_NO", columnDefinition = "VARCHAR2|宝宝卡号||", length = 13, nullable = true)
	private String babyCardNo;
	
	@Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|填报机构代码||", length = 20, nullable = true)
	private String createOrganCode;
	
	@Column(name = "CREATE_ORGAN_NAME", columnDefinition = "VARCHAR2|填报机构名称||", length = 70, nullable = true)
	private String createOrganName;
	
	@Column(name = "GATHER_DATE", columnDefinition = "DATE|采集时间||", nullable = true)
	private Date gatherDate;
	
	
    @XmlElement
    public String getRecordNumber() {
        return this.recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }

    @XmlElement
    public String getNeonatalName() {
        return this.neonatalName;
    }

    public void setNeonatalName(String neonatalName) {
        this.neonatalName = neonatalName;
    }

    @XmlElement
    public String getNeonatalGender() {
        return this.neonatalGender;
    }

    public void setNeonatalGender(String neonatalGender) {
        this.neonatalGender = neonatalGender;
    }
    
    @XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    public Date getNeonatalBirthday() {
        return this.neonatalBirthday;
    }

    public void setNeonatalBirthday(Date neonatalBirthday) {
        this.neonatalBirthday = neonatalBirthday;
    }

    @XmlElement
    public String getMotherName() {
        return this.motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    @XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    public Date getMotherBirthday() {
        return this.motherBirthday;
    }

    public void setMotherBirthday(Date motherBirthday) {
        this.motherBirthday = motherBirthday;
    }

    @XmlElement(name = "motherIdCardType")
    public String getMotherIdcardType() {
		return motherIdcardType;
	}

	public void setMotherIdcardType(String motherIdcardType) {
		this.motherIdcardType = motherIdcardType;
	}

    @XmlElement(name = "motherIdCard")
	public String getMotherIdcard() {
		return motherIdcard;
	}

	public void setMotherIdcard(String motherIdcard) {
		this.motherIdcard = motherIdcard;
	}

	@XmlElement
    public String getAreaCode() {
        return this.areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
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
    public String getHrstreet() {
        return this.hrstreet;
    }

    public void setHrstreet(String hrstreet) {
        this.hrstreet = hrstreet;
    }

    @XmlElement(name="hrAddress")
    public String getHrhouseNumber() {
        return this.hrhouseNumber;
    }

    public void setHrhouseNumber(String hrhouseNumber) {
        this.hrhouseNumber = hrhouseNumber;
    }

    @XmlElement
    public String getHrpostCode() {
        return this.hrpostCode;
    }

    public void setHrpostCode(String hrpostCode) {
        this.hrpostCode = hrpostCode;
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
    public String getPapostCode() {
        return this.papostCode;
    }

    public void setPapostCode(String papostCode) {
        this.papostCode = papostCode;
    }

    @XmlElement
    public String getTelType() {
        return this.telType;
    }

    public void setTelType(String telType) {
        this.telType = telType;
    }

    @XmlElement
    public String getTelNumber() {
        return this.telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    @XmlElement
    public String getSpecimenNumber() {
        return this.specimenNumber;
    }

    public void setSpecimenNumber(String specimenNumber) {
        this.specimenNumber = specimenNumber;
    }

    @XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    public Date getSamplingDate() {
        return this.samplingDate;
    }

    public void setSamplingDate(Date samplingDate) {
        this.samplingDate = samplingDate;
    }

    @XmlElement
    public String getSamplingWay() {
        return this.samplingWay;
    }

    public void setSamplingWay(String samplingWay) {
        this.samplingWay = samplingWay;
    }

    @XmlElement
    public String getSamplingPart() {
        return this.samplingPart;
    }

    public void setSamplingPart(String samplingPart) {
        this.samplingPart = samplingPart;
    }

    @XmlElement
    public String getSamplingOrganName() {
        return this.samplingOrganName;
    }

    public void setSamplingOrganName(String samplingOrganName) {
        this.samplingOrganName = samplingOrganName;
    }

    @XmlElement
    public String getBloodPersonName() {
        return this.bloodPersonName;
    }

    public void setBloodPersonName(String bloodPersonName) {
        this.bloodPersonName = bloodPersonName;
    }

    @XmlElement
    public String getNeonatalDiseaseScreenItem() {
        return this.neonatalDiseaseScreenItem;
    }

    public void setNeonatalDiseaseScreenItem(String neonatalDiseaseScreenItem) {
        this.neonatalDiseaseScreenItem = neonatalDiseaseScreenItem;
    }

    @XmlElement
    public String getNeonatalDiseaseScreenMethod() {
        return this.neonatalDiseaseScreenMethod;
    }

    public void setNeonatalDiseaseScreenMethod(String neonatalDiseaseScreenMethod) {
        this.neonatalDiseaseScreenMethod = neonatalDiseaseScreenMethod;
    }

    @XmlElement
    public String getNeonatalDiseaseScreenResult() {
        return this.neonatalDiseaseScreenResult;
    }

    public void setNeonatalDiseaseScreenResult(String neonatalDiseaseScreenResult) {
        this.neonatalDiseaseScreenResult = neonatalDiseaseScreenResult;
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

    @XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    public Date getScreenNoticeDate() {
        return this.screenNoticeDate;
    }

    public void setScreenNoticeDate(Date screenNoticeDate) {
        this.screenNoticeDate = screenNoticeDate;
    }

    @XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    public Date getRecallDate() {
        return this.recallDate;
    }

    public void setRecallDate(Date recallDate) {
        this.recallDate = recallDate;
    }

    @XmlElement
    public String getCheckNotice() {
        return this.checkNotice;
    }

    public void setCheckNotice(String checkNotice) {
        this.checkNotice = checkNotice;
    }

    @XmlElement
    public String getNoticeMasterName() {
        return this.noticeMasterName;
    }

    public void setNoticeMasterName(String noticeMasterName) {
        this.noticeMasterName = noticeMasterName;
    }

    @XmlElement
    public String getNoticeRelation() {
        return this.noticeRelation;
    }

    public void setNoticeRelation(String noticeRelation) {
        this.noticeRelation = noticeRelation;
    }

    @XmlElement
    public String getNoticeName() {
        return this.noticeName;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
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
