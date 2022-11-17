package com.founder.rhip.ehr.entity.management;

import com.founder.fasf.util.ObjectUtil;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "DM_PERSON_INFO")
public class DmPersonInfo implements Serializable {

	private static final long serialVersionUID = 4873390692538962537L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = true)
	private Long id;

	@Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = true)
	private String ehrId;

	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|个人信息唯一编号||", length = 11, nullable = true)
	private Long personId;

	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|居民身份证/健康卡号||", length = 18, nullable = true)
	private String idcard;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|本人姓名||", length = 50, nullable = true)
	private String name;

	@Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
	private Date birthday;

	@Column(name = "NATION", columnDefinition = "VARCHAR2|民族||", length = 2, nullable = true)
	private String nation;

	@Column(name = "OTHER_NATION_DESC", columnDefinition = "VARCHAR2|少数名族名称||", length = 50, nullable = true)
	private String otherNationDesc;

	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别代码||", length = 1, nullable = true)
	private String gender;

	@Column(name = "OCCUPATION", columnDefinition = "VARCHAR2|职业类别代码||", length = 8, nullable = true)
	private String occupation;

	@Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况代码||", length = 2, nullable = true)
	private String marriage;

	@Column(name = "EDUCATION", columnDefinition = "VARCHAR2|学历代码||", length = 2, nullable = true)
	private String education;

	@Column(name = "PHONE_NUMBER", columnDefinition = "VARCHAR2|本人电话号码||", length = 20, nullable = true)
	private String phoneNumber;
	
	@Column(name = "HOUSEHOLD_TYPE", columnDefinition = "VARCHAR2|常住类型||", length = 20, nullable = true)
	private String householdType;

	@Column(name = "HRPROVINCE", columnDefinition = "VARCHAR2|户籍地址-省(自治区、直辖市)||", length = 70, nullable = true)
	private String hrprovince;

	@Column(name = "HRCITY", columnDefinition = "VARCHAR2|户籍地址-市(地区、州)||", length = 70, nullable = true)
	private String hrcity;

	@Column(name = "HRCOUNTY", columnDefinition = "VARCHAR2|户籍地址-县(区)||", length = 70, nullable = true)
	private String hrcounty;

	@Column(name = "HRTOWN_SHIP", columnDefinition = "VARCHAR2|户籍地址-乡(镇、街道办事处)||", length = 70, nullable = true)
	private String hrtownShip;

	@Column(name = "HRSTREET", columnDefinition = "VARCHAR2|户籍地址-村(街、路、弄等)||", length = 70, nullable = true)
	private String hrstreet;

	@Column(name = "HRGROUP", columnDefinition = "VARCHAR2|||", length = 70, nullable = true)
	private String hrGroup;
	
	@Column(name = "HRHOUSE_NUMBER", columnDefinition = "VARCHAR2|户籍地址-门牌号码||", length = 70, nullable = true)
	private String hrhouseNumber;

	@Column(name = "HRPOST_CODE", columnDefinition = "VARCHAR2|户籍地址邮政编码||", length = 6, nullable = true)
	private String hrpostCode;

	@Column(name = "PAPROVINCE", columnDefinition = "VARCHAR2|现住址-省(自治区、直辖市)||", length = 70, nullable = true)
	private String paprovince;

	@Column(name = "PACITY", columnDefinition = "VARCHAR2|现住址-市(地区、州)||", length = 70, nullable = true)
	private String pacity;

	@Column(name = "PACOUNTY", columnDefinition = "VARCHAR2|现住址-县(区)||", length = 70, nullable = true)
	private String pacounty;

	@Column(name = "PATOWN_SHIP", columnDefinition = "VARCHAR2|现住址-乡(镇、街道办事处)||", length = 70, nullable = true)
	private String patownShip;

	@Column(name = "PASTREET", columnDefinition = "VARCHAR2|现住址-村(街、路、弄等)||", length = 70, nullable = true)
	private String pastreet;

	@Column(name = "PAGROUP", columnDefinition = "VARCHAR2|组||", length = 70, nullable = true)
	private String paGroup;
	
	@Column(name = "PAHOUSE_NUMBER", columnDefinition = "VARCHAR2|现住址-门牌号码||", length = 70, nullable = true)
	private String pahouseNumber;

	@Column(name = "PAPOST_CODE", columnDefinition = "VARCHAR2|现住址邮政编码||", length = 6, nullable = true)
	private String papostCode;

	@Column(name = "HR_ADDRESS", columnDefinition = "VARCHAR2|现住址详细||", length = 100, nullable = true)
	private String hrAddress;
	
	@Column(name = "PA_ADDRESS", columnDefinition = "VARCHAR2|户籍地址详细||", length = 100, nullable = true)
	private String paAddress;
	
	@Column(name = "UNIT_NAME", columnDefinition = "VARCHAR2|单位/学校名称||", length = 70, nullable = true)
	private String unitName;

	@Column(name = "INPUT_ORGAN_NAME", columnDefinition = "VARCHAR2|健康档案管理机构名称||", length = 70, nullable = true)
	private String inputOrganName;

	@Column(name = "INPUT_ORGAN_CODE", columnDefinition = "VARCHAR2|健康档案管理机构编码||", length = 15, nullable = true)
	private String inputOrganCode;

	@Column(name = "CREATE_ORGAN_NAME", columnDefinition = "VARCHAR2|填报机构名称||", length = 70, nullable = true)
	private String createOrganName;

	@Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|填报机构编码||", length = 50, nullable = true)
	private String createOrganCode;
	
	@Column(name = "CREATE_CENTER_ORGAN_CODE", columnDefinition = "VARCHAR2|填报机构 中心冗余||", length = 50, nullable = true)
	private String createCenterOrganCode;
	
	@Column(name = "CREATE_GBCODE", columnDefinition = "VARCHAR2|填报镇||", length = 50, nullable = true)
	private String createGbcode;

	@Column(name = "CREATE_DOCTOR_NAME", columnDefinition = "VARCHAR2|填报人姓名||", length = 50, nullable = true)
	private String createDoctorName;

	@Column(name = "CREATE_DOCTOR_CODE", columnDefinition = "VARCHAR2|填报人编码||", length = 18, nullable = true)
	private String createDoctorCode;

	@Column(name = "CREATE_DATE", columnDefinition = "TIMESTAMP|填报时间||", nullable = true)
	private Date createDate;

	@Column(name = "UPDATE_ORGAN_CODE", columnDefinition = "VARCHAR2|更新机构编码||", length = 50, nullable = true)
	private String updateOrganCode;

	@Column(name = "UPDATE_ORGAN_NAME", columnDefinition = "VARCHAR2|更新机构名称||", length = 70, nullable = true)
	private String updateOrganName;

	@Column(name = "UPDATE_DOCTOR_CODE", columnDefinition = "VARCHAR2|更新人编码||", length = 18, nullable = true)
	private String updateDoctorCode;

	@Column(name = "UPDATE_DOCTOR_NAME", columnDefinition = "VARCHAR2|更新人姓名||", length = 50, nullable = true)
	private String updateDoctorName;

	@Column(name = "UPDATE_DATE", columnDefinition = "TIMESTAMP|更新日期和时间||", nullable = true)
	private Date updateDate;

	@Column(name = "IS_DELETE", columnDefinition = "INT|删除状态||", nullable = true)
	private Integer isDelete;
	
	@Column(name = "TYPE", columnDefinition = "VARCHAR2|类型 1:慢病报卡人员信息 2：慢病管理卡人员信息||", length = 1, nullable = true)
	private String type;

	@Transient
	private List<DmDiseaseInfo> diseaseInfoList; //疾病信息
	
	@Transient
	private List<DmReportInfo> reportInfoList; //报卡信息集合
	
	/**
	 * 高血压标志
	 */
	private String hbpFlag;
	
	/**
	 * 糖尿病标志
	 */
	private String diFlag;
	
	/**
	 * 脑卒中标志
	 */
	private String strokeFlag;
	
	/**
	 * 冠心病标志
	 */
	private String coronaryFlag;
	
	/**
	 * 肿瘤标志
	 */
	private String tumorFlag;
	
	/**
	 * 上报机构
	 */
	private String reportOrganName;
	
	/**
	 * 家庭地址
	 */
	private String address;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEhrId() {
		return this.ehrId;
	}

	public void setEhrId(String ehrId) {
		this.ehrId = ehrId;
	}

	public Long getPersonId() {
		return this.personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		if (ObjectUtil.isNotEmpty(idcard)) {
			this.idcard = idcard.toUpperCase();
		} else {
			this.idcard = idcard;
		}
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

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getMarriage() {
		return this.marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public String getHrpostCode() {
		return this.hrpostCode;
	}

	public void setHrpostCode(String hrpostCode) {
		this.hrpostCode = hrpostCode;
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

	public String getPapostCode() {
		return this.papostCode;
	}

	public void setPapostCode(String papostCode) {
		this.papostCode = papostCode;
	}

	public String getUnitName() {
		return this.unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getInputOrganName() {
		return this.inputOrganName;
	}

	public void setInputOrganName(String inputOrganName) {
		this.inputOrganName = inputOrganName;
	}

	public String getInputOrganCode() {
		return this.inputOrganCode;
	}

	public void setInputOrganCode(String inputOrganCode) {
		this.inputOrganCode = inputOrganCode;
	}


	public String getCreateOrganName() {
		return this.createOrganName;
	}

	public void setCreateOrganName(String createOrganName) {
		this.createOrganName = createOrganName;
	}

	public String getCreateOrganCode() {
		return this.createOrganCode;
	}

	public void setCreateOrganCode(String createOrganCode) {
		this.createOrganCode = createOrganCode;
	}

	public String getCreateDoctorName() {
		return this.createDoctorName;
	}

	public void setCreateDoctorName(String createDoctorName) {
		this.createDoctorName = createDoctorName;
	}

	public String getCreateDoctorCode() {
		return this.createDoctorCode;
	}

	public void setCreateDoctorCode(String createDoctorCode) {
		this.createDoctorCode = createDoctorCode;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateOrganCode() {
		return this.updateOrganCode;
	}

	public void setUpdateOrganCode(String updateOrganCode) {
		this.updateOrganCode = updateOrganCode;
	}

	public String getUpdateOrganName() {
		return this.updateOrganName;
	}

	public void setUpdateOrganName(String updateOrganName) {
		this.updateOrganName = updateOrganName;
	}

	public String getUpdateDoctorCode() {
		return this.updateDoctorCode;
	}

	public void setUpdateDoctorCode(String updateDoctorCode) {
		this.updateDoctorCode = updateDoctorCode;
	}

	public String getUpdateDoctorName() {
		return this.updateDoctorName;
	}

	public void setUpdateDoctorName(String updateDoctorName) {
		this.updateDoctorName = updateDoctorName;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getHouseholdType() {
		return householdType;
	}

	public void setHouseholdType(String householdType) {
		this.householdType = householdType;
	}
	
	public String getHbpFlag() {
		return hbpFlag;
	}

	public void setHbpFlag(String hbpFlag) {
		this.hbpFlag = hbpFlag;
	}

	public String getDiFlag() {
		return diFlag;
	}

	public void setDiFlag(String diFlag) {
		this.diFlag = diFlag;
	}

	public String getStrokeFlag() {
		return strokeFlag;
	}

	public void setStrokeFlag(String strokeFlag) {
		this.strokeFlag = strokeFlag;
	}

	public String getCoronaryFlag() {
		return coronaryFlag;
	}

	public void setCoronaryFlag(String coronaryFlag) {
		this.coronaryFlag = coronaryFlag;
	}

	public String getTumorFlag() {
		return tumorFlag;
	}

	public void setTumorFlag(String tumorFlag) {
		this.tumorFlag = tumorFlag;
	}

	public String getReportOrganName() {
		return reportOrganName;
	}

	public void setReportOrganName(String reportOrganName) {
		this.reportOrganName = reportOrganName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<DmReportInfo> getReportInfoList() {
		return reportInfoList;
	}

	public void setReportInfoList(List<DmReportInfo> reportInfoList) {
		this.reportInfoList = reportInfoList;
	}

	public List<DmDiseaseInfo> getDiseaseInfoList() {
		return diseaseInfoList;
	}

	public void setDiseaseInfoList(List<DmDiseaseInfo> diseaseInfoList) {
		this.diseaseInfoList = diseaseInfoList;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCreateGbcode() {
		return createGbcode;
	}

	public void setCreateGbcode(String createGbcode) {
		this.createGbcode = createGbcode;
	}

	public String getCreateCenterOrganCode() {
		return createCenterOrganCode;
	}

	public void setCreateCenterOrganCode(String createCenterOrganCode) {
		this.createCenterOrganCode = createCenterOrganCode;
	}

	public String getHrAddress() {
		return hrAddress;
	}

	public void setHrAddress(String hrAddress) {
		this.hrAddress = hrAddress;
	}

	public String getPaAddress() {
		return paAddress;
	}

	public void setPaAddress(String paAddress) {
		this.paAddress = paAddress;
	}

	public String getOtherNationDesc() {
		return otherNationDesc;
	}

	public void setOtherNationDesc(String otherNationDesc) {
		this.otherNationDesc = otherNationDesc;
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