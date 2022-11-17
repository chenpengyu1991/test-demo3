
package com.founder.rhip.ehr.entity.basic;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.service.export.Item;

@Entity
@Table(name = "ECH_PHYSICAL_EXAM_RECORD")
public class PhysicalExamRecord implements Serializable {

	private static final long serialVersionUID = -5855449473770467211L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;

	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|EHR平台人员ID||", length = 11, nullable = true)
	private Long personId;

//	@Column(name = "EXAM_NUMBER", columnDefinition = "VARCHAR2|体检编号||", length = 18, nullable = true)
//	private String examNumber;//字段作废，暂不删除

	@Item(index=1,column ="姓名")
	@Column(name = "NAME", columnDefinition = "VARCHAR2|姓名||", length = 50, nullable = true)
	private String name;

	@Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
	private Date birthday;

	@Column(name = "CONFIRM", columnDefinition = "NUMBER|是否确认||", nullable = true)
	private Integer confirm;

	@Item(index=2,column ="性别",isDic = true,dicType = "GBT226112003")
	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别||", length = 1, nullable = true)
	private String gender;
	@Item(index=4,column ="身份证号")
	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证件号码||", length = 18, nullable = true)
	private String idcard;

	@Column(name = "PHYSICAL_EXAM_TYPE", columnDefinition = "VARCHAR2|体检类别||", length = 20, nullable = true)
	private String physicalExamType;

	@Column(name = "INPUT_SUPER_ORGAN_CODE", columnDefinition = "VARCHAR2|上级建档机构编码||", length = 15, nullable = true)
	private String inputSuperOrganCode;

	@Column(name = "INPUT_ORGAN_CODE", columnDefinition = "VARCHAR2|建档机构编码||", length = 20, nullable = true)
	private String inputOrganCode;

//	@Column(name = "EXAM_STATUS", columnDefinition = "NUMBER|体检状态||", nullable = true)
//	private Integer examStatus;//字段作废，暂不删除

//	@Column(name = "HEALTH_GUIDE_STATUS", columnDefinition = "NUMBER|中医指导状态||", nullable = true)
//	private Integer healthGuideStatus;//字段作废，暂不删除
	
//	@Column(name = "ESTIMATE_STATUS", columnDefinition = "NUMBER|健康评估状态||", nullable = true)
//	private Integer estimateStatus;//字段作废，暂不删除

	@Column(name = "EXAM_YEAR", columnDefinition = "DATE|管理年份||", nullable = true)
	private Date examYear;

	@Column(name = "GBCODE", columnDefinition = "VARCHAR2|现住地12位行政区划代码||", length = 12, nullable = true)
	private String gbcode;
	
	@Column(name = "PAYMENT_PATTERN_CODE", columnDefinition = "VARCHAR2|支付方式代码||", length = 12, nullable = true)
	private String paymentPatternCode;
	
//	@Column(name = "EXAM_DATA_STATUS", columnDefinition = "VARCHAR2|体检数据状态||", nullable = true)
//	private Integer examDataStatus;//字段作废，暂不删除

	@Column(name = "MARRIAGE", columnDefinition = "VARCHAR2|婚姻状况||",  length = 10, nullable = true)
	private String marriage;
	
	@Column(name = "TELEPHONE", columnDefinition = "VARCHAR2|住宅电话||",  length = 30, nullable = true)
	private String telephone;
	
	@Column(name = "MOIBLE", columnDefinition = "VARCHAR2|本人电话号码||",  length = 30, nullable = true)
	private String moible;
	
	@Column(name = "EMPOYEE_NUMBER", columnDefinition = "VARCHAR2|员工工号||",  length = 50, nullable = true)
	private String empoyeeNumber;
	
	@Column(name = "DEPARTMENT", columnDefinition = "VARCHAR2|部门||",  length = 50, nullable = true)
	private String department;
	
	@Column(name = "E_MAIL", columnDefinition = "VARCHAR2|电子邮件地址||",  length = 50, nullable = true)
	private String eMail;
	
//	@Column(name = "TCM_STATUS", columnDefinition = "NUMBER|体质辨识状态(0:未管理，1:已管理)|2|",length=2, nullable = true)
//	private Integer tcmStatus;//字段作废，暂不删除

//	@Item(index=6,column ="体质类型")
//	@Column(name = "TCM_CONCLUSION", columnDefinition = "VARCHAR2|体质辨识结论|200|",length=200, nullable = true)
//	private String tcmConclusion;//字段作废，暂不删除
	
	@Column(name = "LOGOFF", columnDefinition = "NUMBER|注销标志（0正常，1注销）|1|", length = 1, nullable = false)
    private Integer logoff = 0;

	@Transient
	private String healthFileNo;

	@Transient
	private String remarks;
	@Transient
	private String tcmNum;
	@Transient
	@Item(index=3,column ="年龄")
	private Integer age;

	@Transient
	@Item(index=5,column ="体检机构")
	private String orgName;

	@Transient
	@Item(index=7,column ="是否辨识")
	private String sfbs;

	private Integer isCriterionExamination;//是否规范年检
	private Integer isEstimateStatus;//是否健康评估
	private Integer isHealthGuideStatus;//是否中医指导
	private Integer isExam;//是否体检
	private Integer isTcm;//是否体质辨识
	
	public String getTcmNum() {
		return tcmNum;
	}

	public void setTcmNum(String tcmNum) {
		this.tcmNum = tcmNum;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getSfbs() {
		return sfbs;
	}

	public void setSfbs(String sfbs) {
		this.sfbs = sfbs;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPersonId() {
		return this.personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
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

	public String getPhysicalExamType() {
		return this.physicalExamType;
	}

	public void setPhysicalExamType(String physicalExamType) {
		this.physicalExamType = physicalExamType;
	}

	public String getInputOrganCode() {
		return this.inputOrganCode;
	}

	public void setInputOrganCode(String inputOrganCode) {
		this.inputOrganCode = inputOrganCode;
	}
	
	public Date getExamYear() {
		return examYear;
	}

	
	public void setExamYear(Date examYear) {
		this.examYear = examYear;
	}

	public String getInputSuperOrganCode() {
		return inputSuperOrganCode;
	}

	public void setInputSuperOrganCode(String inputSuperOrganCode) {
		this.inputSuperOrganCode = inputSuperOrganCode;
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

	public Integer getConfirm() {
		return confirm;
	}

	public void setConfirm(Integer confirm) {
		this.confirm = confirm;
	}

	public String getGbcode() {
		return gbcode;
	}
	
	public void setGbcode(String gbcode) {
		this.gbcode = gbcode;
	}

	public Integer getAge() {
		return DateUtil.getAgeByBirthday(birthday);
	}

	
	public String getPaymentPatternCode() {
		return paymentPatternCode;
	}

	
	public void setPaymentPatternCode(String paymentPatternCode) {
		this.paymentPatternCode = paymentPatternCode;
	}

	public String getMarriage() {
		return marriage;
	}

	
	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	
	public String getTelephone() {
		return telephone;
	}

	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	
	public String getMoible() {
		return moible;
	}

	
	public void setMoible(String moible) {
		this.moible = moible;
	}

	
	public String getEmpoyeeNumber() {
		return empoyeeNumber;
	}

	
	public void setEmpoyeeNumber(String empoyeeNumber) {
		this.empoyeeNumber = empoyeeNumber;
	}

	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String geteMail() {
		return eMail;
	}
	
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public Integer getLogoff() {
		return logoff;
	}

	public void setLogoff(Integer logoff) {
		this.logoff = logoff;
	}

	public String getHealthFileNo() {
		return healthFileNo;
	}

	public void setHealthFileNo(String healthFileNo) {
		this.healthFileNo = healthFileNo;
	}

	public Integer getIsCriterionExamination() {
		return isCriterionExamination;
	}

	public void setIsCriterionExamination(Integer isCriterionExamination) {
		this.isCriterionExamination = isCriterionExamination;
	}

	public Integer getIsEstimateStatus() {
		return isEstimateStatus;
	}

	public void setIsEstimateStatus(Integer isEstimateStatus) {
		this.isEstimateStatus = isEstimateStatus;
	}

	public Integer getIsHealthGuideStatus() {
		return isHealthGuideStatus;
	}

	public void setIsHealthGuideStatus(Integer isHealthGuideStatus) {
		this.isHealthGuideStatus = isHealthGuideStatus;
	}

	public Integer getIsExam() {
		return isExam;
	}

	public void setIsExam(Integer isExam) {
		this.isExam = isExam;
	}

	public Integer getIsTcm() {
		return isTcm;
	}

	public void setIsTcm(Integer isTcm) {
		this.isTcm = isTcm;
	}
	
}