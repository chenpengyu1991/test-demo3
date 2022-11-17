package com.founder.rhip.ehr.entity.portal;

import com.founder.rhip.ehr.common.JaxbDateSerializer;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "RESERVE_REGISTER")
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReserveRegister implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlTransient
	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|ID|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "REGISTER_SCHEDULE_TIME_ID", columnDefinition = "VARCHAR2|排班时段ID|11|", length = 11, nullable = false)
	private String registerScheduleTimeId;
	
	@Column(name = "NAME", columnDefinition = "VARCHAR2|姓名|30|", length = 30, nullable = false)
	private String name;

	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别|5|", length = 5, nullable = false)
	private String gender;

	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份号|18|", length = 18, nullable = false)
	private String idcard;

	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	@Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期||", nullable = true)
	private Date birthday;
	
	@Column(name = "IDCARD_ARCHIVES", columnDefinition = "VARCHAR2|一卡通号|30|", length = 30, nullable = true)
	private String idcardArchives;

	@XmlTransient
	@Column(name = "IDCARD_FARM", columnDefinition = "VARCHAR2|新农合号|30|", length = 30, nullable = true)
	private String idcardFarm;

	@XmlTransient
	@Column(name = "IDCARD_HOS", columnDefinition = "VARCHAR2|医保卡号|30|", length = 30, nullable = true)
	private String idcardHos;

	@Column(name = "PHONE_NUMBER", columnDefinition = "VARCHAR2|电话|15|", length = 15, nullable = false)
	private String phoneNumber;

	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	@Column(name = "REQUEST_DATE", columnDefinition = "DATE|到诊日期||", nullable = false)
	private Date requestDate;

	@Column(name = "AMPM", columnDefinition = "VARCHAR2|预约时段(a(上午)、p(下午))|1|", length = 1, nullable = false)
	private String ampm;

	@Column(name = "HOSPITAL_CODE", columnDefinition = "VARCHAR2|医院编码|15|", length = 15, nullable = false)
	private String hospitalCode;
	
	@Column(name = "DEPT_SN", columnDefinition = "VARCHAR2|科室编码|15|", length = 15, nullable = false)
	private String deptSn;

	@Column(name = "DOCTOR_SN", columnDefinition = "VARCHAR2|医生编码|15|", length = 15, nullable = false)
	private String doctorSn;
	
	@Column(name = "HOSPITAL_NAME", columnDefinition = "VARCHAR2|医院名称|50|", length = 50, nullable = false)
	private String hospitalName;
	
	@Column(name = "DEPT_NAME", columnDefinition = "VARCHAR2|科室名称|15|", length = 15, nullable = false)
	private String deptName;

	@Column(name = "DOCTOR_NAME", columnDefinition = "VARCHAR2|医生姓名|15|", length = 15, nullable = false)
	private String doctorName;

	@Column(name = "CLINIC_TYPE", columnDefinition = "VARCHAR2|就诊类型|15|", length = 15, nullable = false)
	private String clinicType;

	@Column(name = "REGISTER_FEE", columnDefinition = "NUMBER|挂号费用||", nullable = false)
	private Double registerFee;
	
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	@Column(name = "SUBMIT_DATE", columnDefinition = "DATE|预约日期||", nullable = false)
	private Date submitDate;
	
	@XmlTransient
	@Column(name = "SUBMIT_USER", columnDefinition = "NUMBER|提交者ID|11|" , length = 11,  nullable = false)
	private Long submitUser;
	
	@Column(name = "SUBMIT_ORG", columnDefinition = "VARCHAR2|提交机构,为空时是由患者自己预约|15|" , length = 15, nullable = false)
	private String submitOrg;

	@Column(name = "RESERVER_STAUTS", columnDefinition = "VARCHAR2|预约状态(01(尚未到诊)、02(已到诊)、03(逾期未到诊)、04(取消)、05(停诊))|1|", length = 1, nullable = false)
	private String reserverStauts;
	
	@Column(name = "SEARCH_CODE", columnDefinition = "VARCHAR2|查询码|15|" , length = 15, nullable = false)
	private String searchCode;
	
	@Column(name = "UNIT_NAME", columnDefinition = "VARCHAR2|单位/学校名称||", length = 140, nullable = true)
	private String unitName;
	
	@Column(name = "PATOWN_SHIP", columnDefinition = "VARCHAR2|现住址-乡(镇、街道办事处)||", length = 70, nullable = true)
	private String patownShip;
	
	@Column(name = "PASTREET", columnDefinition = "VARCHAR2|现住址-村(街、路、弄等)||", length = 70, nullable = true)
	private String pastreet;
	
	@Column(name = "PAHOUSE_NUMBER", columnDefinition = "VARCHAR2|现住址-门牌号码||", length = 50, nullable = true)
	private String pahouseNumber;
	
	@Column(name = "REG_FROM", columnDefinition = "VARCHAR2|来源||", length = 50, nullable = true)
	private String regFrom;
	
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	@Column(name = "CANCEL_TIME", columnDefinition = "VARCHAR2|取消操作者||", length = 50, nullable = true)
	private Date cancelTime;
	
	@Column(name = "CANCEL_USER", columnDefinition = "VARCHAR2|取消操作者||", length = 50, nullable = true)
	private String cancelUser;
	
	@Column(name = "CANCEL_FLAG", columnDefinition = "VARCHAR2|取消标记||", length = 1, nullable = true)
	private String cancelFlag;

	@Column(name = "TAKE_NO_TIME_START", columnDefinition = "VARCHAR2|取号开始时间如：07:30|15|", length = 15, nullable = false)
	private String takeNoTimeStart;

	@Column(name = "TAKE_NO_TIME_END", columnDefinition = "VARCHAR2|取号结束时间如：08:00|2|", length = 15, nullable = false)
	private String takeNoTimeEnd;

	@Column(name = "TIME_INTERVAL_START", columnDefinition = "VARCHAR2|挂号开始时间如: 08:00||", length = 15,nullable = false)
	private String timeIntervalStart;

	@Column(name = "TIME_INTERVAL_END", columnDefinition = "VARCHAR2|挂号结束时间如: 09:45|1|", length = 15, nullable = false)
	private String timeIntervalEnd;

	@XmlTransient
	@Column(name = "ACCOUNT_ID", columnDefinition = "NUMBER|用户ID|11|", length = 11, nullable = false)
	private Long accountId;

	@Transient
	private String submitUserName;
	
	/*妇幼返回用户就近一次的办卡时间*/
	private Date registTime;
	
	/*预约总数*/
	@XmlTransient
	@Transient
	private int total;
	/*到诊*/
	@XmlTransient
	@Transient
	private int future;
	/*到诊*/
	@XmlTransient
	@Transient
	private int time;
	/*逾期未到诊*/
	@XmlTransient
	@Transient
	private int fails;
	/*取消*/
	@XmlTransient
	private int cancel;
	/*停诊*/
	@XmlTransient
	@Transient
	private int stop;
	
	public Date getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}

	public String getCancelUser() {
		return cancelUser;
	}

	public void setCancelUser(String cancelUser) {
		this.cancelUser = cancelUser;
	}

	public String getCancelFlag() {
		return cancelFlag;
	}

	public void setCancelFlag(String cancelFlag) {
		this.cancelFlag = cancelFlag;
	}

	public Long getId() {
		return id;
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
		return gender;
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
	public String getIdcardArchives() {
		return this.idcardArchives;
	}

	public void setIdcardArchives(String idcardArchives) {
		this.idcardArchives = idcardArchives;
	}
	public String getIdcardFarm() {
		return this.idcardFarm;
	}

	public void setIdcardFarm(String idcardFarm) {
		this.idcardFarm = idcardFarm;
	}
	public String getIdcardHos() {
		return this.idcardHos;
	}

	public void setIdcardHos(String idcardHos) {
		this.idcardHos = idcardHos;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getRequestDate() {
		return this.requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	public String getAmpm() {
		return this.ampm;
	}

	public void setAmpm(String ampm) {
		this.ampm = ampm;
	}
	public String getDeptSn() {
		return this.deptSn;
	}

	public void setDeptSn(String deptSn) {
		this.deptSn = deptSn;
	}
	public String getDoctorSn() {
		return this.doctorSn;
	}

	public void setDoctorSn(String doctorSn) {
		this.doctorSn = doctorSn;
	}
	public String getClinicType() {
		return this.clinicType;
	}

	public void setClinicType(String clinicType) {
		this.clinicType = clinicType;
	}
	public Date getSubmitDate() {
		return this.submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}
	public String getReserverStauts() {
		return this.reserverStauts;
	}

	public void setReserverStauts(String reserverStauts) {
		this.reserverStauts = reserverStauts;
	}
	public String getHospitalCode() {
		return hospitalCode;
	}

	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}
	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public Long getSubmitUser() {
		return submitUser;
	}

	public void setSubmitUser(Long submitUser) {
		this.submitUser = submitUser;
	}

	public String getSubmitOrg() {
		return submitOrg;
	}

	public void setSubmitOrg(String submitOrg) {
		this.submitOrg = submitOrg;
	}
	public Double getRegisterFee() {
		return registerFee;
	}

	public void setRegisterFee(Double registerFee) {
		this.registerFee = registerFee;
	}

	public String getSearchCode() {
		return searchCode;
	}

	public void setSearchCode(String searchCode) {
		this.searchCode = searchCode;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getPatownShip() {
		return patownShip;
	}

	public void setPatownShip(String patownShip) {
		this.patownShip = patownShip;
	}

	public String getPastreet() {
		return pastreet;
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

	public String getSubmitUserName() {
		return submitUserName;
	}

	public void setSubmitUserName(String submitUserName) {
		this.submitUserName = submitUserName;
	}

	public String getRegFrom() {
		return regFrom;
	}

	public void setRegFrom(String regFrom) {
		this.regFrom = regFrom;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getFuture() {
		return future;
	}

	public void setFuture(int future) {
		this.future = future;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getFails() {
		return fails;
	}

	public void setFails(int fails) {
		this.fails = fails;
	}

	public int getCancel() {
		return cancel;
	}

	public void setCancel(int cancel) {
		this.cancel = cancel;
	}

	public int getStop() {
		return stop;
	}

	public void setStop(int stop) {
		this.stop = stop;
	}

	public String getTakeNoTimeStart() {
		return takeNoTimeStart;
	}

	public void setTakeNoTimeStart(String takeNoTimeStart) {
		this.takeNoTimeStart = takeNoTimeStart;
	}

	public String getTakeNoTimeEnd() {
		return takeNoTimeEnd;
	}

	public void setTakeNoTimeEnd(String takeNoTimeEnd) {
		this.takeNoTimeEnd = takeNoTimeEnd;
	}

	public String getTimeIntervalStart() {
		return timeIntervalStart;
	}

	public void setTimeIntervalStart(String timeIntervalStart) {
		this.timeIntervalStart = timeIntervalStart;
	}

	public String getTimeIntervalEnd() {
		return timeIntervalEnd;
	}

	public void setTimeIntervalEnd(String timeIntervalEnd) {
		this.timeIntervalEnd = timeIntervalEnd;
	}

	public String getRegisterScheduleTimeId() {
		return registerScheduleTimeId;
	}

	public void setRegisterScheduleTimeId(String registerScheduleTimeId) {
		this.registerScheduleTimeId = registerScheduleTimeId;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Date getRegistTime() {
		return registTime;
	}

	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}
	
}