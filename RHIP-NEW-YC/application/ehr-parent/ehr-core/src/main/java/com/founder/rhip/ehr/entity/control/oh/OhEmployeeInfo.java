package com.founder.rhip.ehr.entity.control.oh;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "OH_EMPLOYEE_INFO")
public class OhEmployeeInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|姓名|50|", length = 50, nullable = true)
	private String name;

	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别|2|", length = 2, nullable = true)
	private String gender;

	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证号|50|", length = 50, nullable = true)
	private String idcard;

	@Column(name = "BIRTHDATE", columnDefinition = "DATE|出生日期||", nullable = true)
	private Date birthdate;

	@Column(name = "HOUSEHOLD_TYPE", columnDefinition = "VARCHAR2|本地外地|2|", length = 2, nullable = true)
	private String householdType;
	
	@Column(name = "PAPROVINCE", columnDefinition = "VARCHAR2|省|20|", length = 20, nullable = true)
	private String paprovince;

	@Column(name = "PACITY", columnDefinition = "VARCHAR2|市|20|", length = 20, nullable = true)
	private String pacity;

	@Column(name = "PACOUNTY", columnDefinition = "VARCHAR2|县|20|", length = 20, nullable = true)
	private String pacounty;


	@Column(name = "JOB_TYPE", columnDefinition = "VARCHAR2|工种|20|", length = 20, nullable = true)
	private String jobType;

	@Column(name = "DOC_TYPE", columnDefinition = "VARCHAR2|档案类型|20|", length = 20, nullable = true)
	private String docType;

	@Column(name = "START_DATE", columnDefinition = "DATE|开始接尘/触危日期||", nullable = true)
	private Date startDate;

	@Column(name = "TOTAL_YEAR", columnDefinition = "NUMBER|实际接尘/触危年|4|", length = 4, nullable = true)
	private Long totalYear;

	@Column(name = "TOTAL_MONTH", columnDefinition = "NUMBER|实际接尘/触危月|2|", length = 2, nullable = true)
	private Long totalMonth;

	@Column(name = "TOTAL_Days", columnDefinition = "NUMBER|实际接尘/触危天|4|", length = 4, nullable = true)
	private Long totalDays;

	@Column(name = "TOTAL_HOURS", columnDefinition = "NUMBER|实际接尘/触危小时|4|", length = 4, nullable = true)
	private Long totalHours;

	@Column(name = "TOTAL_MINUTES", columnDefinition = "NUMBER|实际接尘/触危分钟|4|", length = 4, nullable = true)
	private Long totalMinutes;

	@Column(name = "PNEUMOCONIOSIS_TYPE", columnDefinition = "VARCHAR2|尘肺种类|50|", length = 50, nullable = true)
	private String pneumoconiosisType;

	@Column(name = "DEATH_DATE", columnDefinition = "DATE|死亡日期||", nullable = true)
	private Date deathDate;

	@Column(name = "DIED_REASON", columnDefinition = "VARCHAR2|死因|50|", length = 50, nullable = true)
	private String diedReason;

	@Column(name = "OTHER_INFO", columnDefinition = "VARCHAR2|其他信息|50|", length = 50, nullable = true)
	private String otherInfo;

	@Column(name = "XLINE_NO", columnDefinition = "VARCHAR2|X射线胸片号|20|", length = 20, nullable = true)
	private String xlineNo;

	@Column(name = "EDUCATION", columnDefinition = "VARCHAR2|文化程度|20|", length = 20, nullable = true)
	private String education;

	@Column(name = "PHONE", columnDefinition = "VARCHAR2|联系电话（固定）|20|", length = 20, nullable = true)
	private String phone;

	@Column(name = "MOBILE", columnDefinition = "VARCHAR2|手机|20|", length = 20, nullable = true)
	private String mobile;

	@Column(name = "OTHER_CONTACTS", columnDefinition = "VARCHAR2|其他联系方式|50|", length = 50, nullable = true)
	private String otherContacts;

	@Column(name = "CONTACT_NAME", columnDefinition = "VARCHAR2|联系人姓名|50|", length = 50, nullable = true)
	private String contactName;

	@Column(name = "CONTACT_ADDR", columnDefinition = "VARCHAR2|联系人住址|50|", length = 50, nullable = true)
	private String contactAddr;

	@Column(name = "CONTACT_PHONE", columnDefinition = "VARCHAR2|联系人电话（固定）|20|", length = 20, nullable = true)
	private String contactPhone;

	@Column(name = "CONTACT_MOBILEPHONE", columnDefinition = "VARCHAR2|手机|20|", length = 20, nullable = true)
	private String contactMobilephone;

	@Column(name = "FIRST_DIAGNOSIS_DT", columnDefinition = "DATE|诊断一期时间||", nullable = true)
	private Date firstDiagnosisDt;

	@Column(name = "FIRST_RESULT", columnDefinition = "INT|合并肺结核||", nullable = true)
	private Integer firstResult;

	@Column(name = "FIRST_ORG", columnDefinition = "VARCHAR2|诊断机构|50|", length = 50, nullable = true)
	private String firstOrg;

	@Column(name = "SEC_DIAGNOSIS_DT", columnDefinition = "DATE|诊断二期时间||", nullable = true)
	private Date secDiagnosisDt;

	@Column(name = "SEC_RESULT", columnDefinition = "INT|合并肺结核||", nullable = true)
	private Integer secResult;

	@Column(name = "SEC_ORG", columnDefinition = "VARCHAR2|诊断机构|50|", length = 50, nullable = true)
	private String secOrg;

	@Column(name = "TH_DIAGNOSIS_DT", columnDefinition = "DATE|诊断三期时间||", nullable = true)
	private Date thDiagnosisDt;

	@Column(name = "TH_RESULT", columnDefinition = "INT|合并肺结核||", nullable = true)
	private Integer thResult;

	@Column(name = "TH_ORG", columnDefinition = "VARCHAR2|诊断机构|50|", length = 50, nullable = true)
	private String thOrg;

	@Column(name = "OCCU_DISEASE_TYPE", columnDefinition = "VARCHAR2|职业病种类|50|", length = 50, nullable = true)
	private String occuDiseaseType;

	@Column(name = "OCCU_DISEAS_NAME", columnDefinition = "VARCHAR2|职业病名|50|", length = 50, nullable = true)
	private String occuDiseasName;

	@Column(name = "DIAGNOSIS_DT", columnDefinition = "DATE|诊断时间||", nullable = true)
	private Date diagnosisDt;

	@Column(name = "DIAGNOSIS_ORG", columnDefinition = "VARCHAR2|诊断机构|50|", length = 50, nullable = true)
	private String diagnosisOrg;

	@Column(name = "VERIFY_STATE", columnDefinition = "VARCHAR2|审核状态|2|", length = 2, nullable = true)
	private String verifyState;

	@Column(name = "VERIFY_DATE", columnDefinition = "DATE|审核时间||", nullable = true)
	private Date verifyDate;

	@Column(name = "VERIFIER", columnDefinition = "VARCHAR2|审核人|20|", length = 20, nullable = true)
	private String verifier;

	@Column(name = "CREATE_TIME", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createTime;

	@Column(name = "CREATE_BY", columnDefinition = "VARCHAR2|创建者|50|", length = 50, nullable = true)
	private String createBy;

	@Column(name = "UPDATE_TIME", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date updateTime;

	@Column(name = "UPDATE_BY", columnDefinition = "VARCHAR2|更新者|50|", length = 50, nullable = true)
	private String updateBy;

	@Column(name = "IS_DELETE", columnDefinition = "INT|删除状态||", nullable = true)
	private Integer isDelete;

	@Column(name = "PATOWN_SHIP", columnDefinition = "VARCHAR2|乡镇|20|", length = 20, nullable = true)
	private String patownShip;
	
	@Column(name = "PASTREET", columnDefinition = "VARCHAR2|现住址-村(街、路、弄等)||", length = 50, nullable = true)
	private String pastreet;
	
	@Column(name = "PA_GROUP", columnDefinition = "VARCHAR2|现住址小组地址||", length = 2, nullable = true)
	private String paGroup;

	@Column(name = "PAHOUSE_NUMBER", columnDefinition = "VARCHAR2|现住址-门牌号码||", length = 50, nullable = true)
	private String pahouseNumber;

	@Column(name = "OTHER_FLAG", columnDefinition = "INT|是否外地诊断||", nullable = true)
	private Integer otherFlag;

	@Column(name = "OTHER_ORG", columnDefinition = "VARCHAR2|外地诊断机构|50|", length = 50, nullable = true)
	private String otherOrg;

	@Column(name = "FIRST_OTHER_FLAG", columnDefinition = "INT|是否外地诊断||", nullable = true)
	private Integer firstOtherFlag;

	@Column(name = "FIRST_OTHER_ORG", columnDefinition = "VARCHAR2|外地诊断机构|50|", length = 50, nullable = true)
	private String firstOtherOrg;

	@Column(name = "SEC_OTHER_FLAG", columnDefinition = "INT|是否外地诊断||", nullable = true)
	private Integer secOtherFlag;

	@Column(name = "SEC_OTHER_ORG", columnDefinition = "VARCHAR2|外地诊断机构|50|", length = 50, nullable = true)
	private String secOtherOrg;

	@Column(name = "TH_OTHER_FLAG", columnDefinition = "INT|是否外地诊断||", nullable = true)
	private Integer thOtherFlag;

	@Column(name = "TH_OTHER_ORG", columnDefinition = "VARCHAR2|外地诊断机构|50|", length = 50, nullable = true)
    private String thOtherOrg;

    @Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|创建机构|50|", length = 50, nullable = true)
    private String createOrganCode;

    @Column(name = "UPDATE_ORGAN_CODE", columnDefinition = "VARCHAR2|修改机构|50|", length = 50, nullable = true)
    private String updateOrganCode;
    
    /****新增上级机构编码和gbcode add by Kevin Ro 2018-08-13 start****/
	@Column(name = "CREATE_SUPER_ORGAN_CODE", columnDefinition = "VARCHAR2|上级建档机构编码||", length = 15, nullable = true)
	private String createSuperOrganCode;

	@Column(name = "GBCODE", columnDefinition = "VARCHAR2|现住地12位行政区划代码||", length = 12, nullable = true)
	private String gbcode;
	/****新增上级机构编码和gbcode add by Kevin Ro 2018-08-13 end****/
	
	

	public String getPastreet() {
		return pastreet;
	}

	public String getPaGroup() {
		return paGroup;
	}

	public void setPaGroup(String paGroup) {
		this.paGroup = paGroup;
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

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
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

	public String getJobType() {
		return this.jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getDocType() {
		return this.docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Long getTotalYear() {
		return this.totalYear;
	}

	public void setTotalYear(Long totalYear) {
		this.totalYear = totalYear;
	}

	public Long getTotalMonth() {
		return this.totalMonth;
	}

	public void setTotalMonth(Long totalMonth) {
		this.totalMonth = totalMonth;
	}

	public String getPneumoconiosisType() {
		return this.pneumoconiosisType;
	}

	public void setPneumoconiosisType(String pneumoconiosisType) {
		this.pneumoconiosisType = pneumoconiosisType;
	}

	public Date getDeathDate() {
		return this.deathDate;
	}

	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	public String getDiedReason() {
		return this.diedReason;
	}

	public void setDiedReason(String diedReason) {
		this.diedReason = diedReason;
	}

	public String getOtherInfo() {
		return this.otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public String getXlineNo() {
		return this.xlineNo;
	}

	public void setXlineNo(String xlineNo) {
		this.xlineNo = xlineNo;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOtherContacts() {
		return this.otherContacts;
	}

	public void setOtherContacts(String otherContacts) {
		this.otherContacts = otherContacts;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactAddr() {
		return this.contactAddr;
	}

	public void setContactAddr(String contactAddr) {
		this.contactAddr = contactAddr;
	}

	public String getContactPhone() {
		return this.contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactMobilephone() {
		return this.contactMobilephone;
	}

	public void setContactMobilephone(String contactMobilephone) {
		this.contactMobilephone = contactMobilephone;
	}

	public Date getFirstDiagnosisDt() {
		return this.firstDiagnosisDt;
	}

	public void setFirstDiagnosisDt(Date firstDiagnosisDt) {
		this.firstDiagnosisDt = firstDiagnosisDt;
	}

	public Integer getFirstResult() {
		return this.firstResult;
	}

	public void setFirstResult(Integer firstResult) {
		this.firstResult = firstResult;
	}

	public String getFirstOrg() {
		return this.firstOrg;
	}

	public void setFirstOrg(String firstOrg) {
		this.firstOrg = firstOrg;
	}

	public Date getSecDiagnosisDt() {
		return this.secDiagnosisDt;
	}

	public void setSecDiagnosisDt(Date secDiagnosisDt) {
		this.secDiagnosisDt = secDiagnosisDt;
	}

	public Integer getSecResult() {
		return this.secResult;
	}

	public void setSecResult(Integer secResult) {
		this.secResult = secResult;
	}

	public String getSecOrg() {
		return this.secOrg;
	}

	public void setSecOrg(String secOrg) {
		this.secOrg = secOrg;
	}

	public Date getThDiagnosisDt() {
		return this.thDiagnosisDt;
	}

	public void setThDiagnosisDt(Date thDiagnosisDt) {
		this.thDiagnosisDt = thDiagnosisDt;
	}

	public Integer getThResult() {
		return this.thResult;
	}

	public void setThResult(Integer thResult) {
		this.thResult = thResult;
	}

	public String getThOrg() {
		return this.thOrg;
	}

	public void setThOrg(String thOrg) {
		this.thOrg = thOrg;
	}

	public String getOccuDiseaseType() {
		return this.occuDiseaseType;
	}

	public void setOccuDiseaseType(String occuDiseaseType) {
		this.occuDiseaseType = occuDiseaseType;
	}

	public String getOccuDiseasName() {
		return this.occuDiseasName;
	}

	public void setOccuDiseasName(String occuDiseasName) {
		this.occuDiseasName = occuDiseasName;
	}

	public Date getDiagnosisDt() {
		return this.diagnosisDt;
	}

	public void setDiagnosisDt(Date diagnosisDt) {
		this.diagnosisDt = diagnosisDt;
	}

	public String getDiagnosisOrg() {
		return this.diagnosisOrg;
	}

	public void setDiagnosisOrg(String diagnosisOrg) {
		this.diagnosisOrg = diagnosisOrg;
	}

	public String getVerifyState() {
		return this.verifyState;
	}

	public void setVerifyState(String verifyState) {
		this.verifyState = verifyState;
	}

	public Date getVerifyDate() {
		return this.verifyDate;
	}

	public void setVerifyDate(Date verifyDate) {
		this.verifyDate = verifyDate;
	}

	public String getVerifier() {
		return this.verifier;
	}

	public void setVerifier(String verifier) {
		this.verifier = verifier;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Long getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(Long totalDays) {
		this.totalDays = totalDays;
	}

	public Long getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(Long totalHours) {
		this.totalHours = totalHours;
	}

	public Long getTotalMinutes() {
		return totalMinutes;
	}

	public void setTotalMinutes(Long totalMinutes) {
		this.totalMinutes = totalMinutes;
	}

	public Integer getOtherFlag() {
		return otherFlag;
	}

	public void setOtherFlag(Integer otherFlag) {
		this.otherFlag = otherFlag;
	}

	public String getOtherOrg() {
		return otherOrg;
	}

	public void setOtherOrg(String otherOrg) {
		this.otherOrg = otherOrg;
	}

	public Integer getFirstOtherFlag() {
		return firstOtherFlag;
	}

	public void setFirstOtherFlag(Integer firstOtherFlag) {
		this.firstOtherFlag = firstOtherFlag;
	}

	public String getFirstOtherOrg() {
		return firstOtherOrg;
	}

	public void setFirstOtherOrg(String firstOtherOrg) {
		this.firstOtherOrg = firstOtherOrg;
	}

	public Integer getSecOtherFlag() {
		return secOtherFlag;
	}

	public void setSecOtherFlag(Integer secOtherFlag) {
		this.secOtherFlag = secOtherFlag;
	}

	public String getSecOtherOrg() {
		return secOtherOrg;
	}

	public void setSecOtherOrg(String secOtherOrg) {
		this.secOtherOrg = secOtherOrg;
	}

	public Integer getThOtherFlag() {
		return thOtherFlag;
	}

	public void setThOtherFlag(Integer thOtherFlag) {
		this.thOtherFlag = thOtherFlag;
	}

	public String getThOtherOrg() {
		return thOtherOrg;
	}

	public void setThOtherOrg(String thOtherOrg) {
		this.thOtherOrg = thOtherOrg;
	}

	public String getHouseholdType() {
		return householdType;
	}

	public void setHouseholdType(String householdType) {
		this.householdType = householdType;
	}

    public String getCreateOrganCode() {
        return createOrganCode;
    }

    public void setCreateOrganCode(String createOrganCode) {
        this.createOrganCode = createOrganCode;
    }

    public String getUpdateOrganCode() {
        return updateOrganCode;
    }

    public void setUpdateOrganCode(String updateOrganCode) {
        this.updateOrganCode = updateOrganCode;
    }

	public String getCreateSuperOrganCode() {
		return createSuperOrganCode;
	}

	public void setCreateSuperOrganCode(String createSuperOrganCode) {
		this.createSuperOrganCode = createSuperOrganCode;
	}

	public String getGbcode() {
		return gbcode;
	}

	public void setGbcode(String gbcode) {
		this.gbcode = gbcode;
	}
    
    
}