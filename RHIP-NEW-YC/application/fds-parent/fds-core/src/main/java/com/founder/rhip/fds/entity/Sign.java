package com.founder.rhip.fds.entity;

import java.io.Serializable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="SIGN")
public class Sign implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID",columnDefinition="NUMBER|业务主键|11|",length=11,nullable=false)
	private Long id;

	@Column(name="SIGN_NUMBER",columnDefinition="VARCHAR2|签约编号|50|",length=50,nullable=true)
	private String signNumber;

	@Column(name="SIGN_TYPE",columnDefinition="CHAR|签约类型 1：个人签约，2：家庭签约|1|",length=1,nullable=true)
	private String signType;

	@Column(name="ORGAN_CODE",columnDefinition="VARCHAR2|机构编码|20|",length=20,nullable=true)
	private String organCode;

	@Column(name="TEAM_CODE",columnDefinition="VARCHAR2|团队编码|50|",length=50,nullable=true)
	private String teamCode;

	@Column(name="DOCTOR_ID",columnDefinition="NUMBER|签约医生ID|11|",length=11,nullable=true)
	private Long doctorId;

	@Column(name="DOCTOR_IDCARD",columnDefinition="VARCHAR2|签约医生身份证|18|",length=18,nullable=true)
	private String doctorIdcard;

	@Column(name="DOCTOR_PHONE_NUMBER",columnDefinition="VARCHAR2|签约医生电话|20|",length=20,nullable=true)
	private String doctorPhoneNumber;

	@Column(name="SIGN_TIME",columnDefinition="DATE|签约时间||",nullable=true)
	private Date signTime;

	@Column(name="CANCEL_TIME",columnDefinition="DATE|解约时间||",nullable=true)
	private Date cancelTime;

	@Column(name="EFFECTIVE_START_DATE",columnDefinition="DATE|生效日期||",nullable=true)
	private Date effectiveStartDate;

	@Column(name="EFFECTIVE_END_DATE",columnDefinition="DATE|终止日期||",nullable=true)
	private Date effectiveEndDate;

	@Column(name="PAID_FLAG",columnDefinition="CHAR|付费标记 0：未付费，1：已付费|1|",length=1,nullable=true)
	private String paidFlag;

	@Column(name="PERSON_IDCARD",columnDefinition="VARCHAR2|签约居民身份证号码（个人签约时是签约者号码，家庭签约时是户主号码）|18|",length=18,nullable=true)
	private String personIdcard;

	@Column(name="VALID",columnDefinition="CHAR|有效性（1：有效，0：无效）|1|",length=1,nullable=true)
	private String valid;

	@Column(name="RESCIND_FLAG",columnDefinition="CHAR|解约标记（1：已解约，0：正常）|1|",length=1,nullable=true)
	private String rescindFlag;

	@Column(name="SYSTEM_TYPE",columnDefinition="VARCHAR2|签约来源系统(1:本系统，2：SASS,3:HIS)|2|",length=2,nullable=true)
	private String systemType;

	@Column(name="CREATE_USER",columnDefinition="VARCHAR2|创建人|64|",length=64,nullable=true)
	private String createUser;

	@Column(name="CREATE_DATE",columnDefinition="DATE|创建日期||",nullable=true)
	private Date createDate;

	@Column(name="UPDATE_USER",columnDefinition="VARCHAR2|更新人|64|",length=64,nullable=true)
	private String updateUser;

	@Column(name="UPDATE_DATE",columnDefinition="DATE|更新日期||",nullable=true)
	private Date updateDate;

	@Column(name = "MANUAL_PAID_FLAG",columnDefinition="VARCHAR2|手动付款标志（1：手动付款）||",nullable=true)
	private String manualPaidFlag;
	 
	@Column(name = "CONTRACT_STATUS",columnDefinition="CHAR|签约合同状态（1：生效，2：待生效，3:已过期）|1|",length=1,nullable=true)
	private String contractStatus = "1";

	@Column(name = "CONTRACT_TYPE",columnDefinition="CHAR|签约类型（1：新签，2：续签）|1|",length=1,nullable=true)
	private String contractType = "1";
	    
	@Column(name = "REFUSE_FLAG",columnDefinition="CHAR|拒绝体检标志（1：拒绝）|1|",length=1,nullable=true)
    private String refuseFlag;   
	//机构名称
	@Transient
	private String organName;

	//团队名称
	@Transient
	private String teamName;

	//医生名称
	@Transient
	private String doctorName;

	//服务包编码
	@Transient
	private String servicePackageCode;

	//服务包名称
	@Transient
	private String servicePackageName;

	//服务包价格
	@Transient
	private BigDecimal servicePackagePrice;

	//人群分类
	@Transient
	private String groupClassification;

	//签约居民
	@Transient
	private SignPerson signPerson;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSignNumber() {
		return this.signNumber;
	}

	public void setSignNumber(String signNumber) {
		this.signNumber = signNumber;
	}

	public String getSignType() {
		return this.signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getOrganCode() {
		return this.organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getTeamCode() {
		return this.teamCode;
	}

	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}

	public Long getDoctorId() {
		return this.doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorIdcard() {
		return this.doctorIdcard;
	}

	public void setDoctorIdcard(String doctorIdcard) {
		this.doctorIdcard = doctorIdcard;
	}

	public String getDoctorPhoneNumber() {
		return this.doctorPhoneNumber;
	}

	public void setDoctorPhoneNumber(String doctorPhoneNumber) {
		this.doctorPhoneNumber = doctorPhoneNumber;
	}

	public Date getSignTime() {
		return this.signTime;
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}

	public Date getCancelTime() {
		return this.cancelTime;
	}

	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}

	public Date getEffectiveStartDate() {
		return this.effectiveStartDate;
	}

	public void setEffectiveStartDate(Date effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}

	public Date getEffectiveEndDate() {
		return this.effectiveEndDate;
	}

	public void setEffectiveEndDate(Date effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
	}

	public String getPaidFlag() {
		return this.paidFlag;
	}

	public void setPaidFlag(String paidFlag) {
		this.paidFlag = paidFlag;
	}

	public String getPersonIdcard() {
		return this.personIdcard;
	}

	public void setPersonIdcard(String personIdcard) {
		this.personIdcard = personIdcard;
	}

	public String getValid() {
		return this.valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getRescindFlag() {
		return this.rescindFlag;
	}

	public void setRescindFlag(String rescindFlag) {
		this.rescindFlag = rescindFlag;
	}

	public String getSystemType() {
		return this.systemType;
	}

	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


	public String getServicePackageCode() {
		return servicePackageCode;
	}

	public void setServicePackageCode(String servicePackageCode) {
		this.servicePackageCode = servicePackageCode;
	}

	public String getServicePackageName() {
		return servicePackageName;
	}

	public void setServicePackageName(String servicePackageName) {
		this.servicePackageName = servicePackageName;
	}

	public BigDecimal getServicePackagePrice() {
		return servicePackagePrice;
	}

	public void setServicePackagePrice(BigDecimal servicePackagePrice) {
		this.servicePackagePrice = servicePackagePrice;
	}

	public String getGroupClassification() {
		return groupClassification;
	}

	public void setGroupClassification(String groupClassification) {
		this.groupClassification = groupClassification;
	}

	public SignPerson getSignPerson() {
		return signPerson;
	}

	public void setSignPerson(SignPerson signPerson) {
		this.signPerson = signPerson;
	}


	public String getOrganName() {
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getManualPaidFlag() {
		return manualPaidFlag;
	}

	public void setManualPaidFlag(String manualPaidFlag) {
		this.manualPaidFlag = manualPaidFlag;
	}

	public String getRefuseFlag() {
		return refuseFlag;
	}

	public void setRefuseFlag(String refuseFlag) {
		this.refuseFlag = refuseFlag;
	}
	
	
}