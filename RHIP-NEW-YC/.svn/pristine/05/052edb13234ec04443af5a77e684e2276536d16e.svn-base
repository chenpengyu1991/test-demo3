package com.founder.rhip.ehr.entity.portal;

import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.common.JaxbDateSerializer;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "REGISTER_SCHEDULE")
@XmlRootElement(name = "registerSchedule")
@XmlAccessorType(XmlAccessType.FIELD)
public class RegisterSchedule implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlTransient
	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|ID|11|", length = 11, nullable = false)
	private Long id;
	
	@Column(name = "HOSPITAL_CODE", columnDefinition = "VARCHAR2|医院编码|15|", length = 15, nullable = false)
	private String hospitalCode;
	
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	@Column(name = "REQUEST_DATE", columnDefinition = "DATE|出诊日期||", nullable = false)
	private Date requestDate;

	@Column(name = "AMPM", columnDefinition = "VARCHAR2|出诊时间（上午/下午）|1|", length = 1, nullable = false)
	private String ampm;

	@Column(name = "DEPT_SN", columnDefinition = "VARCHAR2|科室编码|15|", length = 15, nullable = false)
	private String deptSn;

	@Column(name = "DOCTOR_SN", columnDefinition = "VARCHAR2|医生编码|15|", length = 15, nullable = false)
	private String doctorSn;

	@Column(name = "CLINIC_TYPE", columnDefinition = "VARCHAR2|就诊类型(就诊类型01：普通门诊  02:专家门诊)|2|", length = 2, nullable = false)
	private String clinicType;

	@Column(name = "REGISTER_FEE", columnDefinition = "NUMBER|挂号费用||", nullable = false)
	private Double registerFee;
	
	@Column(name = "CREATE_TIME", columnDefinition = "VARCHAR2|创建时间||", length = 50, nullable = true)
	private Date createTime;
	
	@Column(name = "UPDATE_TIME", columnDefinition = "VARCHAR2|更新时间||", length = 50, nullable = true)
	private Date updateTime;
	
	@Column(name = "RESERVE_STATUS", columnDefinition = "VARCHAR2|预约状态|2|", length = 2, nullable = false)
	private String reserveStatus;
	
	//1已推送 0或null 未推送
	@Column(name = "PUSH_JSPT", columnDefinition = "VARCHAR2|是否已推送至江苏平台||", nullable = true)
	private String pushJspt;

	private String subId;//银川第一人民医院的scheduleid过长,通过截取分别赋值到id和subId字段
	/**
	 * 周几
	 */
	@Transient
	private String weekDate;
	
	@Transient
	private String hospitalName;
	
	@Transient
	private String hospitalInfo;
	
	private String deptName;
	
	@Transient
	private String doctorName;
	
	@Transient
	private String empTitName;

	@Transient
	private String socialNo;

	@Transient
	private String empTitCode;

	@Transient
	private String specializes;

	 //此处的字段admitNum、reserveNum、cuteFlag用来同步以往接口的预约资源
	@Transient
	private Long admitNum;

	@Transient
	private Long reserveNum;

	@Transient
	private Long cuteFlag;
	
	//增加时间段预约
	@XmlElement(name = "timeInterval")
	@Transient
	private List<RegisterScheduleTime> registerScheduleTime;

	public List<RegisterScheduleTime> getRegisterScheduleTime() {
		return registerScheduleTime;
	}

	public void setRegisterScheduleTime(List<RegisterScheduleTime> registerScheduleTime) {
		this.registerScheduleTime = registerScheduleTime;
	}
	//增加就诊开始时间
	private String timeIntervalStart;

	//增加就诊结束时间
	private String timeIntervalEnd;

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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getPushJspt() {
		return pushJspt;
	}

	public void setPushJspt(String pushJspt) {
		this.pushJspt = pushJspt;
	}
	
	public String getRequestDateDetail(){
		String dateString = DateUtil.toFormatString("yyyy年MM月dd日", this.getRequestDate());
		
		String ap = " 上午";
		
		if(this.getAmpm().equals("p")){
			ap = " 下午";
		}
		
		return dateString + ap;
	}
	
	/**
	 * 判断是否预约满
	 * @return
	 */
	public String getTypeName(){
		if(clinicType.equals("01")){
			return "普通门诊";
		}
		return "专家门诊";
	}
	
	/**
	 * 判断是否预约满
	 * @return
	 */
	public boolean isFull(){
		//TODO 此字段移入到RegisterScheduleTime
//		if(admitNum == null){
//			return true;
//		}
//
//		if(reserveNum == null){
//			return false;
//		}
//
//		if(reserveNum < admitNum){
//			return false;
//		}
		return true;
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
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getHospitalCode() {
		return this.hospitalCode;
	}

	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
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

	public Double getRegisterFee() {
		return this.registerFee;
	}

	public void setRegisterFee(Double registerFee) {
		this.registerFee = registerFee;
	}
	public String getWeekDate() {
		return weekDate;
	}

	public void setWeekDate(String weekDate) {
		this.weekDate = weekDate;
	}

	public String getEmpTitName() {
		return empTitName;
	}

	public void setEmpTitName(String empTitName) {
		this.empTitName = empTitName;
	}

	public String getSocialNo() {
		return socialNo;
	}

	public void setSocialNo(String socialNo) {
		this.socialNo = socialNo;
	}

	public String getEmpTitCode() {
		return empTitCode;
	}

	public void setEmpTitCode(String empTitCode) {
		this.empTitCode = empTitCode;
	}

	public String getSpecializes() {
		return specializes;
	}

	public void setSpecializes(String specializes) {
		this.specializes = specializes;
	}

	public Long getAdmitNum() {
		return admitNum;
	}

	public void setAdmitNum(Long admitNum) {
		this.admitNum = admitNum;
	}

	public Long getReserveNum() {
		return reserveNum;
	}

	public void setReserveNum(Long reserveNum) {
		this.reserveNum = reserveNum;
	}

	public Long getCuteFlag() {
		return cuteFlag;
	}

	public void setCuteFlag(Long cuteFlag) {
		this.cuteFlag = cuteFlag;
	}

	public String getHospitalInfo() {
		return hospitalInfo;
	}

	public void setHospitalInfo(String hospitalInfo) {
		this.hospitalInfo = hospitalInfo;
	}

	public String getReserveStatus() {
		return reserveStatus;
	}

	public void setReserveStatus(String reserveStatus) {
		this.reserveStatus = reserveStatus;
	}

	public String getSubId() {
		return subId;
	}

	public void setSubId(String subId) {
		this.subId = subId;
	}
	
}