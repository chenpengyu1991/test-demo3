package com.founder.rhip.ehr.entity.control.idm.notifiabledisease;

import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "IDM_REPORT")
public class IdmReport implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|本表唯一编码|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|本系统唯一编号|11|", length = 11, nullable = false)
	private Long idmId;

	@Column(name = "RECORD_NUMBER", columnDefinition = "VARCHAR2|传染病报告卡编号|20|", length = 20, nullable = true)
	private String recordNumber;

	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|个人信息唯一编号|11|", length = 11, nullable = true)
	private Long personId;

	@Column(name = "HEALTH_FILE_NO", columnDefinition = "VARCHAR2|城乡居民健康档案编号|17|", length = 17, nullable = true)
	private String healthFileNo;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|本人姓名|100|", length = 100, nullable = true)
	private String name;

	@Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
	private Date birthday;

	@Column(name = "PHONE_NUMBER", columnDefinition = "VARCHAR2|本人电话号码|20|", length = 20, nullable = true)
	private String phoneNumber;

	@Column(name = "OTHER_IDCARD_TYPE", columnDefinition = "VARCHAR2|其他证件类别代码|2|", length = 2, nullable = true)
	private String otherIdcardType;

	@Column(name = "OTHER_IDCARD", columnDefinition = "VARCHAR2|其他证件号码|20|", length = 20, nullable = true)
	private String otherIdcard;

	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证件号码|18|", length = 18, nullable = true)
	private String idcard;

	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别代码|1|", length = 1, nullable = true)
	private String gender;

	@Column(name = "HRPROVINCE", columnDefinition = "VARCHAR2|户籍地址-省(自治区、直辖市)|70|", length = 70, nullable = true)
	private String hrprovince;

	@Column(name = "HRCITY", columnDefinition = "VARCHAR2|户籍地址-市(地区、州)|70|", length = 70, nullable = true)
	private String hrcity;

	@Column(name = "HRCOUNTY", columnDefinition = "VARCHAR2|户籍地址-县(区)|70|", length = 70, nullable = true)
	private String hrcounty;

	@Column(name = "HRTOWN_SHIP", columnDefinition = "VARCHAR2|户籍地址-乡(镇、街道办事处)|70|", length = 70, nullable = true)
	private String hrtownShip;

	@Column(name = "HRSTREET", columnDefinition = "VARCHAR2|户籍地址-村(街、路、弄等)|70|", length = 70, nullable = true)
	private String hrstreet;

	@Column(name = "HRHOUSE_NUMBER", columnDefinition = "VARCHAR2|户籍地址-门牌号码|70|", length = 70, nullable = true)
	private String hrhouseNumber;

    @Column(name = "HR_ADDRESS", columnDefinition = "VARCHAR2|户籍地址-详细地址|100|", length = 100, nullable = true)
    private String hrAddress;

	@Column(name = "PAPROVINCE", columnDefinition = "VARCHAR2|现住地址-省(自治区、直辖市)|70|", length = 70, nullable = true)
	private String paprovince;

	@Column(name = "PACITY", columnDefinition = "VARCHAR2|现住地址-市(地区、州)|70|", length = 70, nullable = true)
	private String pacity;

	@Column(name = "PACOUNTY", columnDefinition = "VARCHAR2|现住地址-县(区)|70|", length = 70, nullable = true)
	private String pacounty;

	@Column(name = "PATOWN_SHIP", columnDefinition = "VARCHAR2|现住地址-乡(镇、街道办事处)|70|", length = 70, nullable = true)
	private String patownShip;

	@Column(name = "PASTREET", columnDefinition = "VARCHAR2|现住地址地址-村(街、路、弄等)|70|", length = 70, nullable = true)
	private String pastreet;

	@Column(name = "PAHOUSE_NUMBER", columnDefinition = "VARCHAR2|现住地址-门牌号码|70|", length = 70, nullable = true)
	private String pahouseNumber;

    @Column(name = "PA_ADDRESS", columnDefinition = "VARCHAR2|现住地址-详细地址|100|", length = 100, nullable = true)
    private String paAddress;

	@Column(name = "UAPROVINCE", columnDefinition = "VARCHAR2|工作单位地址-省(自治区、直辖市)|70|", length = 70, nullable = true)
	private String uaprovince;

	@Column(name = "UACITY", columnDefinition = "VARCHAR2|工作单位地址-市(地区、州)|70|", length = 70, nullable = true)
	private String uacity;

	@Column(name = "UACOUNTY", columnDefinition = "VARCHAR2|工作单位地址-县(区)|70|", length = 70, nullable = true)
	private String uacounty;

	@Column(name = "UATOWN_SHIP", columnDefinition = "VARCHAR2|工作单位地址-乡(镇、街道办事处)|70|", length = 70, nullable = true)
	private String uatownShip;

	@Column(name = "UASTREET", columnDefinition = "VARCHAR2|工作单位地址-村(街、路、弄等)|70|", length = 70, nullable = true)
	private String uastreet;

	@Column(name = "UAHOUSE_NUMBER", columnDefinition = "VARCHAR2|工作单位地址-门牌号码|70|", length = 70, nullable = true)
	private String uahouseNumber;

	@Column(name = "UNIT_PHONE", columnDefinition = "VARCHAR2|工作单位电话号码|20|", length = 20, nullable = true)
	private String unitPhone;

	@Column(name = "UNIT_NAME", columnDefinition = "VARCHAR2|工作单位名称|70|", length = 70, nullable = true)
	private String unitName;

	@Column(name = "POST_CODE", columnDefinition = "VARCHAR2|邮政编码|6|", length = 6, nullable = true)
	private String postCode;

	@Column(name = "PARENTS_NAME", columnDefinition = "VARCHAR2|家长姓名|50|", length = 50, nullable = true)
	private String parentsName;

	@Column(name = "FAMILY_PHONE", columnDefinition = "VARCHAR2|家人电话号码|20|", length = 20, nullable = true)
	private String familyPhone;

	@Column(name = "REPORT_DOCTOR_ID", columnDefinition = "VARCHAR2|报告医生ID|50|", length = 50, nullable = false)
	private String reportDoctorId;
	
	@Column(name = "REPORT_DOCTOR_NAME", columnDefinition = "VARCHAR2|报告医师姓名|50|", length = 50, nullable = true)
	private String reportDoctorName;

	@Column(name = "REPORT_CARD_TYPE_CODE", columnDefinition = "VARCHAR2|报卡类别代码|1|", length = 1, nullable = true)
	private String reportCardTypeCode;

	@Column(name = "BACK_CARD_CAUSE", columnDefinition = "VARCHAR2|退卡原因|100|", length = 100, nullable = true)
	private String backCardCause;

	@Column(name = "INFECTIOUS_ATTACK_TYPE", columnDefinition = "VARCHAR2|传染病发病类别代码|1|", length = 1, nullable = true)
	private String infectiousAttackType;

	@Column(name = "INFECTEDPERSON_BELONG", columnDefinition = "VARCHAR2|传染病患者属于代码|1|", length = 1, nullable = true)
	private String infectedpersonBelong;

	@Column(name = "OCCUPATION", columnDefinition = "VARCHAR2|传染病患者职业代码|11|", length = 11, nullable = true)
	private String occupation;

	@Column(name = "INFECTIOUS_TYPE", columnDefinition = "VARCHAR2|传染病类别代码|1|", length = 1, nullable = true)
	private String infectiousType;

	@Column(name = "INFECTIOUS_NAME", columnDefinition = "VARCHAR2|传染病名称|100|", length =100, nullable = true)
	private String infectiousName;
	
	@Column(name = "INFECTIOUS_CODE", columnDefinition = "VARCHAR2|传染病代码|20|", length = 20, nullable = true)
	private String infectiousCode;
	
	@Column(name = "AMEND_NAME", columnDefinition = "VARCHAR2|订正病名|70|", length = 70, nullable = true)
	private String amendName;

	@Column(name = "AMEND_DIAGNOSE", columnDefinition = "VARCHAR2|订正诊断|70|", length = 70, nullable = true)
	private String amendDiagnose;

	@Column(name = "OTHER_INFECTIOUS_NAME", columnDefinition = "VARCHAR2|其他法定管理以及重点监测传染病名称|20|", length = 20, nullable = true)
	private String otherInfectiousName;

	@Column(name = "FIRST_SYMPTOMS_DATE", columnDefinition = "DATE|首次出现症状日期||", nullable = true)
	private Date firstSymptomsDate;

	@Column(name = "DIAGNOSIS_STATUS", columnDefinition = "VARCHAR2|诊断状态代码|1|", length = 1, nullable = true)
	private String diagnosisStatus;

	@Column(name = "DIAGNOSIS_DATE", columnDefinition = "TIMESTAMP|诊断日期||", nullable = true)
	private Date diagnosisDate;

	@Column(name = "DEATH_DATE", columnDefinition = "TIMESTAMP|死亡日期||", nullable = true)
	private Date deathDate;
	
	@Column(name = "PATHOGENESIS_DATE", columnDefinition = "DATE|发病日期||", nullable = true)
	private Date pathogenesisDate;

	@Column(name = "FILL_ORGAN_PHONE", columnDefinition = "VARCHAR2|填报机构电话号码|20|", length = 20, nullable = true)
	private String fillOrganPhone;

	@Column(name = "FILL_ORGAN_CODE", columnDefinition = "VARCHAR2|填报机构编码|15|", length = 15, nullable = true)
	private String fillOrganCode;

	@Column(name = "GENRE_CODE", columnDefinition = "VARCHAR2|填报机构类别代码||", length = 20, nullable = true)
	private String genreCode;	
	
	@Column(name = "FILL_ORGAN_NAME", columnDefinition = "VARCHAR2|填报机构名称|70|", length = 70, nullable = true)
	private String fillOrganName;

	@Column(name = "FILL_DATE", columnDefinition = "TIMESTAMP|填报日期||", nullable = true)
	private Date fillDate;

	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除状态|1|", length = 1, nullable = true)
	private boolean isDelete;

	@Column(name = "AGE", columnDefinition = "VARCHAR2|实足年龄|20|", length = 20, nullable = true)
	private String age;

	@Column(name = "AGE_UNIT", columnDefinition = "VARCHAR2|年龄单位|1|", length = 1, nullable = true)
	private String ageUnit;

	@Column(name = "OCCUPATION_OTHER", columnDefinition = "VARCHAR2|职业-其他|30|", length = 30, nullable = true)
	private String occupationOther;

	@Column(name = "CASE_CATEGORY_FLAG", columnDefinition = "VARCHAR2|病例分类-急慢|1|", length = 1, nullable = true)
	private String caseCategoryFlag;

	@Column(name = "CASE_CATEGORY", columnDefinition = "VARCHAR2|病例分类|1|", length = 1, nullable = true)
	private String caseCategory;
	
	@Column(name = "COMMENTS", columnDefinition = "VARCHAR2|备注|400|", length = 400, nullable = true)
	private String comments;

    @Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况|2|", length = 2, nullable = true)
    private String marriage;

    @Column(name = "NATION", columnDefinition = "VARCHAR2|民族|2|", length = 2, nullable = true)
    private String nation;

    @Column(name = "EDUCATION", columnDefinition = "VARCHAR2|患者文化程度|5|", length = 5, nullable = true)
    private String education;

    @Column(name = "HR_CODE", columnDefinition = "VARCHAR2|户籍国标码|20|", length = 20, nullable = true)
    private String hrCode;

    @Column(name = "DELETE_CONTENT", columnDefinition = "VARCHAR2|作废说明|2|", length = 2, nullable = true)
    private String deleteContent;

    @Column(name = "DELETE_CONTENT_OTHER", columnDefinition = "VARCHAR2|作废说明其他|200|", length = 200, nullable = true)
    private String deleteContentOther;
    
	@Column(name = "PROCESS_STATUS", columnDefinition = "VARCHAR2|处理状态||", length = 1, nullable = true)
	private String processStatus = "0";
	
	@Column(name = "CURRENT_FILL_TIME", columnDefinition = "TIMESTAMP|当前填报时间||", nullable = true)
	private Date currentFillTime;
	
	@Column(name = "CURRENT_DIAGNOSIS_TIME", columnDefinition = "TIMESTAMP|当前诊断日期||", nullable = true)
	private Date currentDiagnosisTime;

	@Column(name = "HR_GROUP", columnDefinition = "VARCHAR2|户籍小组地址||", length = 2, nullable = true)
	private String hrGroup;

	@Column(name = "PA_GROUP", columnDefinition = "VARCHAR2|现住址小组地址||", length = 2, nullable = true)
	private String paGroup;

	/*当前诊断日期*/
	@Transient
	private String currentDiagnosisTimeS;
	
	/*当前填报时间*/
	@Transient
	private String currentFillTimeS;

	/*报卡状态*/
	@Transient
	private Integer reportStatus;

	/*患者信息*/
	@Transient
	private PersonInfo personInfo;
	
	/*审批状态 1防保科未审批，2防疫科已退回，3防疫科待审批，4防疫科审核通过，5防保科作废*/
	@Transient
	private String approvalFlg;
	
	/*诊断日期-小时*/
	@Transient
	private String diagnosisHour;
	
	/*填报日期-小时*/
	@Transient
	private String fillHour;
	
	/*死亡日期-小时*/
	@Transient
	private String deathHour;

	/*更新机构编码*/
	@Transient
	private String updateOrganCode;
	
	/*更新机构名称*/
	@Transient
	private String updateOrganName;
	
	/*是否填写麻风疑似报卡 填写后为1*/
	@Transient
	private Integer specialStatus;
	
	@Transient
	private Long statusId;
	
	/*更新人身份证*/
	@Transient
	private String updateIdCard;
	
	/*更新人名称*/
	@Transient
	private String updateName;

    /*更新时间*/
    @Transient
    private Date updateDate;

	/*个案状态*/
	@Transient
	private String caseStatus;

    /*采样状态*/
    @Transient
    private String tsStatus;

    /*随访状态*/
    @Transient
    private String frStatus;
    
    /*报卡来源*/
    @Transient
	private String reportSource;

    /*注销标志*/
    @Transient
    private Integer logoff;

	/*专项与法定区分字段*/
	@Transient
	private String idmType;
	
	/*当前用户有无报卡填写和修改的权限*/
	@Transient
	private int isOperate = 1;//1：可操纵：2：不可操作 3：专项 4：不处理

    @Transient
    private String idcardHtml;
    
    /*报卡审核通过后，SQZX进行修改时的标志*/
    @Transient
    private String updateFlag;

    /*调查单位*/
    private String modifySurveyOrg;

    @Transient
    private String inHospital;

    @Transient
    private String nameF;

    @Transient
    private String genderF;

    @Transient
    private String ageF;

    @Transient
    private String parentsNameF;

    @Transient
    private String phoneNumberF;

    @Transient
    private String paAddressF;

    @Transient
    private Date attackDt;

    @Transient
    private Date treatmentDt;

    @Transient
    private String treatmentUnit;
    
    @Transient
    private String genderDesc;
    
    @Transient
    private String pathogenesisDateDesc;
    
    @Transient
    private String infectedpersonBelongDesc;
    
    @Transient
    private String caseCategoryFlagDesc;
    
    @Transient
    private String caseCategoryDesc;
    
    @Transient
    private String diagnosisDateDesc;
    
    @Transient
    private String deathDateDesc;
    
    @Transient
    private String fillDateDesc;
    
    @Transient
    private String personName;
    
    @Transient
    private String sexCode;
    
    @Transient
    private String personBirthDay;
    
    @Transient
    private String occupationDesc;
    
    @Transient
    private String infectiousTypeDesc;
    
    @Transient
    private String fillOrganCode1;
    
    @Transient
    private String fillOrganAddr1;
    
    @Transient
    private String fillOrganName1;
    
    @Transient
    private String fillOrganPhone1;
    
    @Transient
    private String fillDate1;
    
    @Transient
  	private String relationDesc;
      
	  @Transient
	  private String infectiousAttackTypeDesc;
	  
	  @Transient
	  private String diagnosisStatusDesc;
	  
	  
	  @Transient
	  private String infectiousCodeDesc;
	  
	  @Transient
	  private String reportCardTypeCodeDesc;
	  
	  @Transient
	  private String assignmentStatus;
	  
	  @Transient
	  private String assignedToUnit;
	  
	  @Transient
	  private String currentUnit;
	  
	  @Transient
	  private String validCaseStatus;
	  
	  @Transient
	  private String  visitInst;

	  /*外部报卡上报人角色*/
	  @Transient
	  private String roleType;
	  
	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getValidCaseStatus() {
		return validCaseStatus;
	}

	public void setValidCaseStatus(String validCaseStatus) {
		this.validCaseStatus = validCaseStatus;
	}

	public String getCurrentUnit() {
		return currentUnit;
	}

	public void setCurrentUnit(String currentUnit) {
		this.currentUnit = currentUnit;
	}

	public String getAssignedToUnit() {
		return assignedToUnit;
	}

	public void setAssignedToUnit(String assignedToUnit) {
		this.assignedToUnit = assignedToUnit;
	}

	public String getAssignmentStatus() {
		return assignmentStatus;
	}

	public void setAssignmentStatus(String assignmentStatus) {
		this.assignmentStatus = assignmentStatus;
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

	public String getRecordNumber() {
		return this.recordNumber;
	}

	public void setRecordNumber(String recordNumber) {
		this.recordNumber = recordNumber;
	}

	public Long getPersonId() {
		return this.personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
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

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getOtherIdcardType() {
		return this.otherIdcardType;
	}

	public void setOtherIdcardType(String otherIdcardType) {
		this.otherIdcardType = otherIdcardType;
	}

	public String getOtherIdcard() {
		return this.otherIdcard;
	}

	public void setOtherIdcard(String otherIdcard) {
		this.otherIdcard = otherIdcard;
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

	public String getHrprovince() {
		return this.hrprovince;
	}

	public void setHrprovince(String hrprovince) {
		this.hrprovince = hrprovince;
	}

	public String getHrcity() {
		return this.hrcity;
	}

	public void setHrcity(String hrcity) {
		this.hrcity = hrcity;
	}

	public String getHrcounty() {
		return this.hrcounty;
	}

	public void setHrcounty(String hrcounty) {
		this.hrcounty = hrcounty;
	}

	public String getHrtownShip() {
		return this.hrtownShip;
	}

	public void setHrtownShip(String hrtownShip) {
		this.hrtownShip = hrtownShip;
	}

	public String getHrstreet() {
		return this.hrstreet;
	}

	public void setHrstreet(String hrstreet) {
		this.hrstreet = hrstreet;
	}

	public String getHrhouseNumber() {
		return this.hrhouseNumber;
	}

	public void setHrhouseNumber(String hrhouseNumber) {
		this.hrhouseNumber = hrhouseNumber;
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
		return this.pahouseNumber;
	}

	public void setPahouseNumber(String pahouseNumber) {
		this.pahouseNumber = pahouseNumber;
	}

    public String getPaAddress() {
        return paAddress;
    }

    public void setPaAddress(String paAddress) {
        this.paAddress = paAddress;
    }

    public String getUaprovince() {
		return this.uaprovince;
	}

	public void setUaprovince(String uaprovince) {
		this.uaprovince = uaprovince;
	}

	public String getUacity() {
		return this.uacity;
	}

	public void setUacity(String uacity) {
		this.uacity = uacity;
	}

	public String getUacounty() {
		return this.uacounty;
	}

	public void setUacounty(String uacounty) {
		this.uacounty = uacounty;
	}

	public String getUatownShip() {
		return this.uatownShip;
	}

	public void setUatownShip(String uatownShip) {
		this.uatownShip = uatownShip;
	}

	public String getUastreet() {
		return this.uastreet;
	}

	public void setUastreet(String uastreet) {
		this.uastreet = uastreet;
	}

	public String getUahouseNumber() {
		return this.uahouseNumber;
	}

	public void setUahouseNumber(String uahouseNumber) {
		this.uahouseNumber = uahouseNumber;
	}

	public String getUnitPhone() {
		return this.unitPhone;
	}

	public void setUnitPhone(String unitPhone) {
		this.unitPhone = unitPhone;
	}

	public String getUnitName() {
		return this.unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getPostCode() {
		return this.postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getParentsName() {
		return this.parentsName;
	}

	public void setParentsName(String parentsName) {
		this.parentsName = parentsName;
	}

	public String getFamilyPhone() {
		return this.familyPhone;
	}

	public void setFamilyPhone(String familyPhone) {
		this.familyPhone = familyPhone;
	}

	public String getReportDoctorName() {
		return this.reportDoctorName;
	}

	public void setReportDoctorName(String reportDoctorName) {
		this.reportDoctorName = reportDoctorName;
	}

	public String getReportCardTypeCode() {
		return this.reportCardTypeCode;
	}

	public void setReportCardTypeCode(String reportCardTypeCode) {
		this.reportCardTypeCode = reportCardTypeCode;
	}

	public String getBackCardCause() {
		return this.backCardCause;
	}

	public void setBackCardCause(String backCardCause) {
		this.backCardCause = backCardCause;
	}

	public String getInfectiousAttackType() {
		return this.infectiousAttackType;
	}

	public void setInfectiousAttackType(String infectiousAttackType) {
		this.infectiousAttackType = infectiousAttackType;
	}

	public String getInfectedpersonBelong() {
		return this.infectedpersonBelong;
	}

	public void setInfectedpersonBelong(String infectedpersonBelong) {
		this.infectedpersonBelong = infectedpersonBelong;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getInfectiousType() {
		return this.infectiousType;
	}

	public void setInfectiousType(String infectiousType) {
		this.infectiousType = infectiousType;
	}

	public String getInfectiousName() {
		return this.infectiousName;
	}

	public void setInfectiousName(String infectiousName) {
		this.infectiousName = infectiousName;
	}

	public String getInfectiousCode() {
		return infectiousCode;
	}

	public void setInfectiousCode(String infectiousCode) {
		this.infectiousCode = infectiousCode;
	}

	public String getAmendName() {
		return this.amendName;
	}

	public void setAmendName(String amendName) {
		this.amendName = amendName;
	}

	public String getAmendDiagnose() {
		return this.amendDiagnose;
	}

	public void setAmendDiagnose(String amendDiagnose) {
		this.amendDiagnose = amendDiagnose;
	}

	public String getOtherInfectiousName() {
		return this.otherInfectiousName;
	}

	public void setOtherInfectiousName(String otherInfectiousName) {
		this.otherInfectiousName = otherInfectiousName;
	}

	public Date getFirstSymptomsDate() {
		return this.firstSymptomsDate;
	}

	public void setFirstSymptomsDate(Date firstSymptomsDate) {
		this.firstSymptomsDate = firstSymptomsDate;
	}

	public String getDiagnosisStatus() {
		return this.diagnosisStatus;
	}

	public void setDiagnosisStatus(String diagnosisStatus) {
		this.diagnosisStatus = diagnosisStatus;
	}

	public Date getDiagnosisDate() {
		return this.diagnosisDate;
	}

	public void setDiagnosisDate(Date diagnosisDate) {
		this.diagnosisDate = diagnosisDate;
	}

	public Date getDeathDate() {
		return this.deathDate;
	}

	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	public String getFillOrganPhone() {
		return this.fillOrganPhone;
	}

	public void setFillOrganPhone(String fillOrganPhone) {
		this.fillOrganPhone = fillOrganPhone;
	}

	public String getFillOrganCode() {
		return this.fillOrganCode;
	}

	public void setFillOrganCode(String fillOrganCode) {
		this.fillOrganCode = fillOrganCode;
	}

	public String getFillOrganName() {
		return this.fillOrganName;
	}

	public void setFillOrganName(String fillOrganName) {
		this.fillOrganName = fillOrganName;
	}

	public Date getFillDate() {
		return this.fillDate;
	}

	public void setFillDate(Date fillDate) {
		this.fillDate = fillDate;
	}

	public boolean isIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAgeUnit() {
		return this.ageUnit;
	}

	public void setAgeUnit(String ageUnit) {
		this.ageUnit = ageUnit;
	}

	public String getOccupationOther() {
		return this.occupationOther;
	}

	public void setOccupationOther(String occupationOther) {
		this.occupationOther = occupationOther;
	}

	public String getCaseCategory() {
		return this.caseCategory;
	}

	public void setCaseCategory(String caseCategory) {
		this.caseCategory = caseCategory;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(Integer reportStatus) {
		this.reportStatus = reportStatus;
	}

	public String getCaseCategoryFlag() {
		return caseCategoryFlag;
	}

	public void setCaseCategoryFlag(String caseCategoryFlag) {
		this.caseCategoryFlag = caseCategoryFlag;
	}

	public Date getPathogenesisDate() {
		return pathogenesisDate;
	}

	public void setPathogenesisDate(Date pathogenesisDate) {
		this.pathogenesisDate = pathogenesisDate;
	}

	public String getReportDoctorId() {
		return reportDoctorId;
	}

	public void setReportDoctorId(String reportDoctorId) {
		this.reportDoctorId = reportDoctorId;
	}

	public PersonInfo getPersonInfo() {
		if(ObjectUtil.isNullOrEmpty(this.personInfo)){
			this.personInfo = new PersonInfo();
            ConvertUtils.register(new DateConverter(null), java.util.Date.class);
            try{
                BeanUtils.copyProperties(this.personInfo, this);
                /*--患者ID add by yjf 2014/01/07--*/
                if(ObjectUtil.isNotEmpty(this.personId)){
                	personInfo.setId(personId);
                }

            }catch(Exception e){
                throw new RuntimeException(e);
            }
		}
		return personInfo;
	}

	public String getUpdateOrganCode() {
		return updateOrganCode;
	}

	public void setUpdateOrganCode(String updateOrganCode) {
		this.updateOrganCode = updateOrganCode;
	}

	public String getUpdateOrganName() {
		return updateOrganName;
	}

	public void setUpdateOrganName(String updateOrganName) {
		this.updateOrganName = updateOrganName;
	}

	public String getUpdateIdCard() {
		return updateIdCard;
	}

	public void setUpdateIdCard(String updateIdCard) {
		this.updateIdCard = updateIdCard;
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
	 * @return the approvalFlg
	 */
	public String getApprovalFlg() {
		return approvalFlg;
	}

	/**
	 * @param approvalFlg the approvalFlg to set
	 */
	public void setApprovalFlg(String approvalFlg) {
		this.approvalFlg = approvalFlg;
	}

	/**
	 * @return the diagnosisHour
	 */
	public String getDiagnosisHour() {
		return diagnosisHour;
	}

	/**
	 * @param diagnosisHour the diagnosisHour to set
	 */
	public void setDiagnosisHour(String diagnosisHour) {
		this.diagnosisHour = diagnosisHour;
	}

    public String getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

	public int getIsOperate() {
		return isOperate;
	}

	public void setIsOperate(int isOperate) {
		this.isOperate = isOperate;
	}

	/**
	 * @return the idmType
	 */
	public String getIdmType() {
		return idmType;
	}

	/**
	 * @param idmType the idmType to set
	 */
	public void setIdmType(String idmType) {
		this.idmType = idmType;
	}

    public String getModifySurveyOrg() {
        return modifySurveyOrg;
    }

    public void setModifySurveyOrg(String modifySurveyOrg) {
        this.modifySurveyOrg = modifySurveyOrg;
    }

    public String getFrStatus() {
        return frStatus;
    }

    public void setFrStatus(String frStatus) {
        this.frStatus = frStatus;
    }

    public String getTsStatus() {
        return tsStatus;
    }

    public void setTsStatus(String tsStatus) {
        this.tsStatus = tsStatus;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getHrCode() {
        return hrCode;
    }

    public void setHrCode(String hrCode) {
        this.hrCode = hrCode;
    }

    public String getHrAddress() {
        return hrAddress;
    }
    

    public Integer getSpecialStatus() {
		return specialStatus;
	}

	public void setSpecialStatus(Integer specialStatus) {
		this.specialStatus = specialStatus;
	}

	public void setHrAddress(String hrAddress) {
        this.hrAddress = hrAddress;
    }

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}
	

    public String getIdcardHtml() {

        if (StringUtil.isNullOrEmpty(this.getIdcard())) {
            return "";
        }

        String[] noArray = StringUtil.split(this.getIdcard(),",");
        String idcardHtmlStr = "<s class=\"idcard\" style=\"width:90%;padding-left:0px;\"><span class=\"text\">身份证号：</span>";
        int i = 0;
        for (String arrayOne : noArray) {
            idcardHtmlStr = idcardHtmlStr + "<span>" + arrayOne + "</span>";
            i++;
        }

        idcardHtml = idcardHtmlStr + "</s>";

        return idcardHtml;
    }

	public String getGenreCode() {
		return genreCode;
	}

	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}

    public Integer getLogoff() {
        return logoff;
    }

    public void setLogoff(Integer logoff) {
        this.logoff = logoff;
    }

	public String getUpdateFlag() {
		return updateFlag;
	}

	public void setUpdateFlag(String updateFlag) {
		this.updateFlag = updateFlag;
	}

    public String getInHospital() {
        return inHospital;
    }

    public void setInHospital(String inHospital) {
        this.inHospital = inHospital;
    }

    public String getNameF() {
        return nameF;
    }

    public void setNameF(String nameF) {
        this.nameF = nameF;
    }

    public String getGenderF() {
        return genderF;
    }

    public void setGenderF(String genderF) {
        this.genderF = genderF;
    }

    public String getAgeF() {
        return ageF;
    }

    public void setAgeF(String ageF) {
        this.ageF = ageF;
    }

    public String getParentsNameF() {
        return parentsNameF;
    }

    public void setParentsNameF(String parentsNameF) {
        this.parentsNameF = parentsNameF;
    }

    public String getPhoneNumberF() {
        return phoneNumberF;
    }

    public void setPhoneNumberF(String phoneNumberF) {
        this.phoneNumberF = phoneNumberF;
    }

    public String getPaAddressF() {
        return paAddressF;
    }

    public void setPaAddressF(String paAddressF) {
        this.paAddressF = paAddressF;
    }

    public String getTreatmentUnit() {
        return treatmentUnit;
    }

    public void setTreatmentUnit(String treatmentUnit) {
        this.treatmentUnit = treatmentUnit;
    }

    public Date getTreatmentDt() {
        return treatmentDt;
    }

    public void setTreatmentDt(Date treatmentDt) {
        this.treatmentDt = treatmentDt;
    }

    public Date getAttackDt() {
        return attackDt;
    }

    public void setAttackDt(Date attackDt) {
        this.attackDt = attackDt;
    }

    public String getDeleteContent() {
        return deleteContent;
    }

    public void setDeleteContent(String deleteContent) {
        this.deleteContent = deleteContent;
    }

    public String getDeleteContentOther() {
        return deleteContentOther;
    }

    public void setDeleteContentOther(String deleteContentOther) {
        this.deleteContentOther = deleteContentOther;
    }

	
	public String getGenderDesc() {
		return genderDesc;
	}

	
	public void setGenderDesc(String genderDesc) {
		this.genderDesc = genderDesc;
	}

	
	public String getPathogenesisDateDesc() {
		return pathogenesisDateDesc;
	}

	
	public void setPathogenesisDateDesc(String pathogenesisDateDesc) {
		this.pathogenesisDateDesc = pathogenesisDateDesc;
	}

	
	public String getInfectedpersonBelongDesc() {
		return infectedpersonBelongDesc;
	}

	
	public void setInfectedpersonBelongDesc(String infectedpersonBelongDesc) {
		this.infectedpersonBelongDesc = infectedpersonBelongDesc;
	}

	public String getCaseCategoryFlagDesc() {
		return caseCategoryFlagDesc;
	}

	public void setCaseCategoryFlagDesc(String caseCategoryFlagDesc) {
		this.caseCategoryFlagDesc = caseCategoryFlagDesc;
	}

	
	public String getCaseCategoryDesc() {
		return caseCategoryDesc;
	}

	
	public void setCaseCategoryDesc(String caseCategoryDesc) {
		this.caseCategoryDesc = caseCategoryDesc;
	}

	
	public String getDiagnosisDateDesc() {
		return diagnosisDateDesc;
	}

	
	public void setDiagnosisDateDesc(String diagnosisDateDesc) {
		this.diagnosisDateDesc = diagnosisDateDesc;
	}

	
	public String getDeathDateDesc() {
		return deathDateDesc;
	}

	
	public void setDeathDateDesc(String deathDateDesc) {
		this.deathDateDesc = deathDateDesc;
	}

	
	public String getFillDateDesc() {
		return fillDateDesc;
	}

	
	public void setFillDateDesc(String fillDateDesc) {
		this.fillDateDesc = fillDateDesc;
	}

	
	public String getPersonName() {
		this.personName = this.name;
		return personName;
	}

	
	public void setPersonName(String personName) {
		this.personName = personName;
	}

	
	public String getSexCode() {
		this.sexCode = this.gender;
		return sexCode;
	}

	
	public void setSexCode(String sexCode) {
		this.sexCode = sexCode;
	}

	
	public String getPersonBirthDay() {
		return personBirthDay;
	}

	
	public void setPersonBirthDay(String personBirthDay) {
		this.personBirthDay = personBirthDay;
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	
	public String getOccupationDesc() {
		return occupationDesc;
	}

	
	public void setOccupationDesc(String occupationDesc) {
		this.occupationDesc = occupationDesc;
	}

	public String getInfectiousTypeDesc() {
		return infectiousTypeDesc;
	}

	public void setInfectiousTypeDesc(String infectiousTypeDesc) {
		this.infectiousTypeDesc = infectiousTypeDesc;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getFillOrganCode1() {
		return fillOrganCode1;
	}

	public void setFillOrganCode1(String fillOrganCode1) {
		this.fillOrganCode1 = fillOrganCode1;
	}

	public String getFillOrganAddr1() {
		return fillOrganAddr1;
	}

	public void setFillOrganAddr1(String fillOrganAddr1) {
		this.fillOrganAddr1 = fillOrganAddr1;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

	public void setIdcardHtml(String idcardHtml) {
		this.idcardHtml = idcardHtml;
	}

	public String getFillOrganName1() {
		return fillOrganName1;
	}

	public void setFillOrganName1(String fillOrganName1) {
		this.fillOrganName1 = fillOrganName1;
	}

	public String getFillOrganPhone1() {
		return fillOrganPhone1;
	}

	public void setFillOrganPhone1(String fillOrganPhone1) {
		this.fillOrganPhone1 = fillOrganPhone1;
	}

	public String getFillDate1() {
		return fillDate1;
	}

	public void setFillDate1(String fillDate1) {
		this.fillDate1 = fillDate1;
	}

	public String getRelationDesc() {
		return relationDesc;
	}

	public void setRelationDesc(String relationDesc) {
		this.relationDesc = relationDesc;
	}

	public String getInfectiousAttackTypeDesc() {
		return infectiousAttackTypeDesc;
	}

	public void setInfectiousAttackTypeDesc(String infectiousAttackTypeDesc) {
		this.infectiousAttackTypeDesc = infectiousAttackTypeDesc;
	}

	public String getDiagnosisStatusDesc() {
		return diagnosisStatusDesc;
	}

	public void setDiagnosisStatusDesc(String diagnosisStatusDesc) {
		this.diagnosisStatusDesc = diagnosisStatusDesc;
	}

	public String getInfectiousCodeDesc() {
		return infectiousCodeDesc;
	}

	public void setInfectiousCodeDesc(String infectiousCodeDesc) {
		this.infectiousCodeDesc = infectiousCodeDesc;
	}

	public String getReportCardTypeCodeDesc() {
		return reportCardTypeCodeDesc;
	}

	public void setReportCardTypeCodeDesc(String reportCardTypeCodeDesc) {
		this.reportCardTypeCodeDesc = reportCardTypeCodeDesc;
	}
	
	public String getReportSource() {
		return reportSource;
	}

	public void setReportSource(String reportSource) {
		this.reportSource = reportSource;
	}

	public String getFillHour() {
		return fillHour;
	}

	public void setFillHour(String fillHour) {
		this.fillHour = fillHour;
	}

	public String getDeathHour() {
		return deathHour;
	}

	public void setDeathHour(String deathHour) {
		this.deathHour = deathHour;
	}

	public Date getCurrentFillTime() {
		return currentFillTime;
	}

	public void setCurrentFillTime(Date currentFillTime) {
		this.currentFillTime = currentFillTime;
	}

	public Date getCurrentDiagnosisTime() {
		return currentDiagnosisTime;
	}

	public void setCurrentDiagnosisTime(Date currentDiagnosisTime) {
		this.currentDiagnosisTime = currentDiagnosisTime;
	}
	
	public String getCurrentDiagnosisTimeS() {
		return currentDiagnosisTimeS;
	}

	public void setCurrentDiagnosisTimeS(String currentDiagnosisTimeS) {
		this.currentDiagnosisTimeS = currentDiagnosisTimeS;
	}

	public String getCurrentFillTimeS() {
		return currentFillTimeS;
	}

	public void setCurrentFillTimeS(String currentFillTimeS) {
		this.currentFillTimeS = currentFillTimeS;
	}

	public String getVisitInst() {
		return visitInst;
	}

	public void setVisitInst(String visitInst) {
		this.visitInst = visitInst;
	}

	public String getHrGroup() {
		return hrGroup;
	}

	public void setHrGroup(String hrGroup) {
		this.hrGroup = hrGroup;
	}

	public String getPaGroup() {
		return paGroup;
	}

	public void setPaGroup(String paGroup) {
		this.paGroup = paGroup;
	}
}