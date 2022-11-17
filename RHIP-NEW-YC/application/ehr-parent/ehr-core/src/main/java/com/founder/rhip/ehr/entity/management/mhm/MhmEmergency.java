package com.founder.rhip.ehr.entity.management.mhm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "MHM_EMERGENCY")
public class MhmEmergency implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "EVENT_ID", columnDefinition = "NUMBER|本系统唯一编码|11|", length = 11, nullable = false)
	private Long eventId;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|姓名|50|", length = 50, nullable = true)
	private String name;

	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别|1|", length = 1, nullable = true)
	private String gender;

	@Column(name = "AGE", columnDefinition = "NUMBER|年龄|3|", length = 3, nullable = true)
	private Integer age;

	@Column(name = "PATIENT_CODE", columnDefinition = "VARCHAR2|患者编号|100|", length = 100, nullable = true)
	private String patientCode;

	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证号|18|", length = 18, nullable = true)
	private String idcard;

	@Column(name = "EMERGEMCY_ORGAN", columnDefinition = "VARCHAR2|应急处置单位|100|", length = 100, nullable = true)
	private String emergemcyOrgan;

	@Column(name = "EMERGEMCY_ADDRESS", columnDefinition = "VARCHAR2|第一处置地点|100|", length = 100, nullable = true)
	private String emergemcyAddress;

	@Column(name = "REPORT_USER", columnDefinition = "VARCHAR2|报告人|50|", length = 50, nullable = true)
	private String reportUser;

	@Column(name = "REPORT_DT", columnDefinition = "DATE|报告时间||", nullable = true)
	private Date reportDt;

	@Column(name = "REPORT_WAY", columnDefinition = "VARCHAR2|报告途径|100|", length = 100, nullable = true)
	private String reportWay;

	@Column(name = "REPORT_IDENTITY", columnDefinition = "VARCHAR2|报告人身份|2|", length = 2, nullable = true)
	private String reportIdentity;

	@Column(name = "REPORT_IDENTITY_OTHER", columnDefinition = "VARCHAR2|报告人身份其他|20|", length = 20, nullable = true)
	private String reportIdentityOther;

	@Column(name = "START_DT", columnDefinition = "DATE|处置开始时间||", nullable = true)
	private Date startDt;

	@Column(name = "END_DT", columnDefinition = "DATE|处置结束时间||", nullable = true)
	private Date endDt;

	@Column(name = "COMMENTS", columnDefinition = "VARCHAR2|现场处置情况简要|400|", length = 400, nullable = true)
	private String comments;

	@Column(name = "HURT_NUM", columnDefinition = "VARCHAR2|受伤人数|20|", length = 20, nullable = true)
	private String hurtNum;

	@Column(name = "DIE_NUM", columnDefinition = "VARCHAR2|死亡人数|20|", length = 20, nullable = true)
	private String dieNum;

	@Column(name = "LOSS", columnDefinition = "VARCHAR2|财务损失估计|100|", length = 100, nullable = true)
	private String Loss;

	@Column(name = "DOCTOR_1", columnDefinition = "VARCHAR2|精神科医师1|50|", length = 50, nullable = true)
	private String doctor_1;

	@Column(name = "DOCTOR_2", columnDefinition = "VARCHAR2|精神科医师2|50|", length = 50, nullable = true)
	private String doctor_2;

	@Column(name = "NURSE_1", columnDefinition = "VARCHAR2|精神科护士1|50|", length = 50, nullable = true)
	private String nurse_1;

	@Column(name = "NURSE_2", columnDefinition = "VARCHAR2|精神科护士2|50|", length = 50, nullable = true)
	private String nurse_2;

	@Column(name = "REPORT_DISPOSE_ORGAN", columnDefinition = "VARCHAR2|报送处置单位|100|", length = 100, nullable = true)
	private String reportDisposeOrgan;

	@Column(name = "REPORT_DISPOSE_PEOPLE", columnDefinition = "VARCHAR2|报送处置人|50|", length = 50, nullable = true)
	private String reportDisposePeople;

	@Column(name = "DISPOSER_REASON", columnDefinition = "VARCHAR2|处置缘由|200|", length = 200, nullable = true)
	private String disposerReason;

	@Column(name = "DISPOSER_REASON_OTHER", columnDefinition = "VARCHAR2|处置缘由其他|100|", length = 100, nullable = true)
	private String disposerReasonOther;

	@Column(name = "TEMPORARILY", columnDefinition = "VARCHAR2|临时性处置|20|", length = 20, nullable = true)
	private String temporarily;

	@Column(name = "STRETCHER_AFTERWARD", columnDefinition = "VARCHAR2|门急诊留观|20|", length = 20, nullable = true)
	private String stretcherAfterward;

	@Column(name = "IN_HOSPITAL", columnDefinition = "VARCHAR2|紧急住院|20|", length = 20, nullable = true)
	private String inHospital;

	@Column(name = "CONSULTATION", columnDefinition = "VARCHAR2|会诊|20|", length = 20, nullable = true)
	private String consultation;

	@Column(name = "DISPOSER_MEASURE_OTHER", columnDefinition = "VARCHAR2|主要处置措施其他|100|", length = 100, nullable = true)
	private String disposerMeasureOther;

	@Column(name = "DIAGNOSIS", columnDefinition = "VARCHAR2|确定诊断|100|", length = 100, nullable = true)
	private String diagnosis;

	@Column(name = "SUSPECTED", columnDefinition = "VARCHAR2|疑似诊断|100|", length = 100, nullable = true)
	private String suspected;

	@Column(name = "DISPOSER_NATURE", columnDefinition = "VARCHAR2|处置性质|2|", length = 2, nullable = true)
	private String disposerNature;

	@Column(name = "TRANSFER", columnDefinition = "VARCHAR2|资料移交|2|", length = 2, nullable = true)
	private String transfer;

	@Column(name = "EFFECT", columnDefinition = "VARCHAR2|处置效果|2|", length = 2, nullable = true)
	private String effect;

	@Column(name = "RESOURCES", columnDefinition = "VARCHAR2|处置对象来源|2|", length = 2, nullable = true)
	private String resources;

	@Column(name = "PAY_WAY", columnDefinition = "VARCHAR2|费用支付方式|2|", length = 2, nullable = true)
	private String payWay;

	@Column(name = "FILL_ORGAN_CODE", columnDefinition = "VARCHAR2|填报机构|100|", length = 100, nullable = true)
	private String fillOrganCode;

	@Column(name = "FILL_DOCTOR_ID", columnDefinition = "VARCHAR2|填写医生|50|", length = 50, nullable = true)
	private String fillDoctorId;

	@Column(name = "FILL_DATE", columnDefinition = "DATE|填写日期||", nullable = true)
	private Date fillDate;

	@Column(name = "MODIFY_ORGAN_CODE", columnDefinition = "VARCHAR2|修改机构|100|", length = 100, nullable = true)
	private String modifyOrganCode;

	@Column(name = "MODIFY_DOCTOR_ID", columnDefinition = "VARCHAR2|修改医生|50|", length = 50, nullable = true)
	private String modifyDoctorId;

	@Column(name = "MODIFY_DATE", columnDefinition = "DATE|修改日期||", nullable = true)
	private Date modifyDate;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEventId() {
		return this.eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
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

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPatientCode() {
		return this.patientCode;
	}

	public void setPatientCode(String patientCode) {
		this.patientCode = patientCode;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getEmergemcyOrgan() {
		return this.emergemcyOrgan;
	}

	public void setEmergemcyOrgan(String emergemcyOrgan) {
		this.emergemcyOrgan = emergemcyOrgan;
	}

	public String getEmergemcyAddress() {
		return this.emergemcyAddress;
	}

	public void setEmergemcyAddress(String emergemcyAddress) {
		this.emergemcyAddress = emergemcyAddress;
	}

	public String getReportUser() {
		return this.reportUser;
	}

	public void setReportUser(String reportUser) {
		this.reportUser = reportUser;
	}

	public Date getReportDt() {
		return this.reportDt;
	}

	public void setReportDt(Date reportDt) {
		this.reportDt = reportDt;
	}

	public String getReportWay() {
		return this.reportWay;
	}

	public void setReportWay(String reportWay) {
		this.reportWay = reportWay;
	}

	public String getReportIdentity() {
		return this.reportIdentity;
	}

	public void setReportIdentity(String reportIdentity) {
		this.reportIdentity = reportIdentity;
	}

	public String getReportIdentityOther() {
		return this.reportIdentityOther;
	}

	public void setReportIdentityOther(String reportIdentityOther) {
		this.reportIdentityOther = reportIdentityOther;
	}

	public Date getStartDt() {
		return this.startDt;
	}

	public void setStartDt(Date startDt) {
		this.startDt = startDt;
	}

	public Date getEndDt() {
		return this.endDt;
	}

	public void setEndDt(Date endDt) {
		this.endDt = endDt;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getHurtNum() {
		return this.hurtNum;
	}

	public void setHurtNum(String hurtNum) {
		this.hurtNum = hurtNum;
	}

	public String getDieNum() {
		return this.dieNum;
	}

	public void setDieNum(String dieNum) {
		this.dieNum = dieNum;
	}

	public String getLoss() {
		return this.Loss;
	}

	public void setLoss(String Loss) {
		this.Loss = Loss;
	}

	public String getDoctor_1() {
		return doctor_1;
	}

	public void setDoctor_1(String doctor_1) {
		this.doctor_1 = doctor_1;
	}

	public String getDoctor_2() {
		return doctor_2;
	}

	public void setDoctor_2(String doctor_2) {
		this.doctor_2 = doctor_2;
	}

	public String getNurse_1() {
		return nurse_1;
	}

	public void setNurse_1(String nurse_1) {
		this.nurse_1 = nurse_1;
	}

	public String getNurse_2() {
		return nurse_2;
	}

	public void setNurse_2(String nurse_2) {
		this.nurse_2 = nurse_2;
	}

	public String getReportDisposeOrgan() {
		return this.reportDisposeOrgan;
	}

	public void setReportDisposeOrgan(String reportDisposeOrgan) {
		this.reportDisposeOrgan = reportDisposeOrgan;
	}

	public String getReportDisposePeople() {
		return this.reportDisposePeople;
	}

	public void setReportDisposePeople(String reportDisposePeople) {
		this.reportDisposePeople = reportDisposePeople;
	}

	public String getDisposerReason() {
		return this.disposerReason;
	}

	public void setDisposerReason(String disposerReason) {
		this.disposerReason = disposerReason;
	}

	public String getDisposerReasonOther() {
		return this.disposerReasonOther;
	}

	public void setDisposerReasonOther(String disposerReasonOther) {
		this.disposerReasonOther = disposerReasonOther;
	}

	public String getTemporarily() {
		return this.temporarily;
	}

	public void setTemporarily(String temporarily) {
		this.temporarily = temporarily;
	}

	public String getStretcherAfterward() {
		return this.stretcherAfterward;
	}

	public void setStretcherAfterward(String stretcherAfterward) {
		this.stretcherAfterward = stretcherAfterward;
	}

	public String getInHospital() {
		return this.inHospital;
	}

	public void setInHospital(String inHospital) {
		this.inHospital = inHospital;
	}

	public String getConsultation() {
		return this.consultation;
	}

	public void setConsultation(String consultation) {
		this.consultation = consultation;
	}

	public String getDisposerMeasureOther() {
		return this.disposerMeasureOther;
	}

	public void setDisposerMeasureOther(String disposerMeasureOther) {
		this.disposerMeasureOther = disposerMeasureOther;
	}

	public String getDiagnosis() {
		return this.diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getSuspected() {
		return this.suspected;
	}

	public void setSuspected(String suspected) {
		this.suspected = suspected;
	}

	public String getDisposerNature() {
		return this.disposerNature;
	}

	public void setDisposerNature(String disposerNature) {
		this.disposerNature = disposerNature;
	}

	public String getTransfer() {
		return this.transfer;
	}

	public void setTransfer(String transfer) {
		this.transfer = transfer;
	}

	public String getEffect() {
		return this.effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public String getResources() {
		return this.resources;
	}

	public void setResources(String resources) {
		this.resources = resources;
	}

	public String getPayWay() {
		return this.payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public String getFillOrganCode() {
		return this.fillOrganCode;
	}

	public void setFillOrganCode(String fillOrganCode) {
		this.fillOrganCode = fillOrganCode;
	}

	public String getFillDoctorId() {
		return this.fillDoctorId;
	}

	public void setFillDoctorId(String fillDoctorId) {
		this.fillDoctorId = fillDoctorId;
	}

	public Date getFillDate() {
		return this.fillDate;
	}

	public void setFillDate(Date fillDate) {
		this.fillDate = fillDate;
	}

	public String getModifyOrganCode() {
		return this.modifyOrganCode;
	}

	public void setModifyOrganCode(String modifyOrganCode) {
		this.modifyOrganCode = modifyOrganCode;
	}

	public String getModifyDoctorId() {
		return this.modifyDoctorId;
	}

	public void setModifyDoctorId(String modifyDoctorId) {
		this.modifyDoctorId = modifyDoctorId;
	}

	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

}