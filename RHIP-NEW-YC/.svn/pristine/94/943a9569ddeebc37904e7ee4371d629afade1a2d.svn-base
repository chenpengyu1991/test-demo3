package com.founder.rhip.ehr.entity.ism;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "IS_REPORT_INFO")
public class ReportInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = true)
	private Long id;

	@Column(name = "HOSPITAL_CODE", columnDefinition = "VARCHAR2|监测医院编号||", length = 50, nullable = true)
	private String hospitalCode;

	@Column(name = "SMPI_ID", columnDefinition = "VARCHAR2|人员唯一编码||", length = 50, nullable = true)
	private String smpiId;

	@Column(name = "REPORT_NO", columnDefinition = "VARCHAR2|卡片编号||", length = 50, nullable = true)
	private String reportNo;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|本人姓名||", length = 50, nullable = true)
	private String name;

	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别代码||", length = 1, nullable = true)
	private String gender;

	@Column(name = "AGE", columnDefinition = "VARCHAR2|年龄||", length = 2, nullable = true)
	private String age;

	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|居民身份证/健康卡号||", length = 18, nullable = true)
	private String idcard;

	@Column(name = "REGISTRATION", columnDefinition = "VARCHAR2|户籍||", length = 2, nullable = true)
	private String registration;

	@Column(name = "EDUCATION", columnDefinition = "VARCHAR2|学历代码||", length = 2, nullable = true)
	private String education;

	@Column(name = "OCCUPATION", columnDefinition = "VARCHAR2|职业类别代码||", length = 8, nullable = true)
	private String occupation;

	@Column(name = "INHOS_DATE", columnDefinition = "TIMESTAMP|就诊日期||", nullable = true)
	private Date inhosDate;

	@Column(name = "OCCUR_TIME", columnDefinition = "TIMESTAMP|伤害发生日期时间||", nullable = true)
	private Date occurTime;

	@Column(name = "OCCUR_REASON_CODE", columnDefinition = "VARCHAR2|伤害发生原因代码||", length = 2, nullable = true)
	private String occurReasonCode;

	@Column(name = "OCCUR_PALCE_CODE", columnDefinition = "VARCHAR2|伤害发生地点代码||", length = 2, nullable = true)
	private String occurPalceCode;

	@Column(name = "OCCUR_BEHAVIOR_CODE", columnDefinition = "VARCHAR2|伤害发生时活动类别代码||", length = 2, nullable = true)
	private String occurBehaviorCode;

	@Column(name = "INTENDS_CODE", columnDefinition = "VARCHAR2|伤害意图类别代码||", length = 2, nullable = true)
	private String intendsCode;

	@Column(name = "NATURE_CODE", columnDefinition = "VARCHAR2|伤害性质代码||", length = 2, nullable = true)
	private String natureCode;

	@Column(name = "PART_CODE", columnDefinition = "VARCHAR2|伤害部位代码||", length = 2, nullable = true)
	private String partCode;

	@Column(name = "SEVERITY_CODE", columnDefinition = "VARCHAR2|伤害严重程度代码||", length = 2, nullable = true)
	private String severityCode;

	@Column(name = "CLINICAL_DIAGNOSIS", columnDefinition = "VARCHAR2|临床诊断||", length = 200, nullable = true)
	private String clinicalDiagnosis;

	@Column(name = "RESULT", columnDefinition = "VARCHAR2|伤害结局||", length = 2, nullable = true)
	private String result;

	@Column(name = "STATUS", columnDefinition = "VARCHAR2|状态||", length = 2, nullable = true)
	private String status;

	@Column(name = "CREATE_ORGAN_NAME", columnDefinition = "VARCHAR2|填报机构名称||", length = 70, nullable = true)
	private String createOrganName;

	@Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|填报机构编码||", length = 50, nullable = true)
	private String createOrganCode;

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
	
	@Column(name = "OCCUR_REASON_OTHER", columnDefinition = "VARCHAR2|伤害原因其他||",length = 100, nullable = true)
	private String occurReasonOther;
	
	@Column(name = "OCCUR_PLACE_OTHER", columnDefinition = "VARCHAR2|伤害发生地其他||",length = 100, nullable = true)
	private String occurPlaceOther;
	
	@Column(name = "OCCUR_BEHAVIOR_OTHER", columnDefinition = "VARCHAR2|伤害活动其他||",length = 100, nullable = true)
	private String occurBehaviorOther;
	
	@Column(name = "NATURE_OTHER", columnDefinition = "VARCHAR2|伤害性质其他||", length = 100,nullable = true)
	private String natureOther;
	
	@Column(name = "PART_OTHER", columnDefinition = "VARCHAR2|伤害部位其他||",length = 100, nullable = true)
	private String partOther;
	
	@Column(name = "RESULT_OTHER", columnDefinition = "VARCHAR2|伤害结局其他||",length = 100, nullable = true)
	private String resultOther;
	
	@Transient
	private String inhosDateToString;
	
	@Transient
	List<ReportInfo> reportInfoList;
	
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Transient
	private String comments;
	
	public List<ReportInfo> getReportInfoList() {
		return reportInfoList;
	}

	public void setReportInfoList(List<ReportInfo> reportInfoList) {
		this.reportInfoList = reportInfoList;
	}

	public String getInhosDateToString() {
		return inhosDateToString;
	}

	public void setInhosDateToString(String inhosDateToString) {
		this.inhosDateToString = inhosDateToString;
	}

	public String getOccurTimeToString() {
		return occurTimeToString;
	}

	public void setOccurTimeToString(String occurTimeToString) {
		this.occurTimeToString = occurTimeToString;
	}

	@Transient
	private String occurTimeToString;
	public Long getId() {
		return this.id;
	}

	public String getOccurReasonOther() {
		return occurReasonOther;
	}

	public void setOccurReasonOther(String occurReasonOther) {
		this.occurReasonOther = occurReasonOther;
	}

	public String getOccurBehaviorOther() {
		return occurBehaviorOther;
	}

	public void setOccurBehaviorOther(String occurBehaviorOther) {
		this.occurBehaviorOther = occurBehaviorOther;
	}

	public String getOccurPlaceOther() {
		return occurPlaceOther;
	}

	public void setOccurPlaceOther(String occurPlaceOther) {
		this.occurPlaceOther = occurPlaceOther;
	}

	public String getNatureOther() {
		return natureOther;
	}

	public void setNatureOther(String natureOther) {
		this.natureOther = natureOther;
	}

	public String getPartOther() {
		return partOther;
	}

	public void setPartOther(String partOther) {
		this.partOther = partOther;
	}

	public String getResultOther() {
		return resultOther;
	}

	public void setResultOther(String resultOther) {
		this.resultOther = resultOther;
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

	public String getSmpiId() {
		return this.smpiId;
	}

	public void setSmpiId(String smpiId) {
		this.smpiId = smpiId;
	}

	public String getReportNo() {
		return this.reportNo;
	}

	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
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

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getRegistration() {
		return this.registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Date getInhosDate() {
		return this.inhosDate;
	}

	public void setInhosDate(Date inhosDate) {
		this.inhosDate = inhosDate;
	}

	public Date getOccurTime() {
		return this.occurTime;
	}

	public void setOccurTime(Date occurTime) {
		this.occurTime = occurTime;
	}

	public String getOccurReasonCode() {
		return this.occurReasonCode;
	}

	public void setOccurReasonCode(String occurReasonCode) {
		this.occurReasonCode = occurReasonCode;
	}

	public String getOccurPalceCode() {
		return this.occurPalceCode;
	}

	public void setOccurPalceCode(String occurPalceCode) {
		this.occurPalceCode = occurPalceCode;
	}

	public String getOccurBehaviorCode() {
		return this.occurBehaviorCode;
	}

	public void setOccurBehaviorCode(String occurBehaviorCode) {
		this.occurBehaviorCode = occurBehaviorCode;
	}

	public String getIntendsCode() {
		return this.intendsCode;
	}

	public void setIntendsCode(String intendsCode) {
		this.intendsCode = intendsCode;
	}

	public String getNatureCode() {
		return this.natureCode;
	}

	public void setNatureCode(String natureCode) {
		this.natureCode = natureCode;
	}

	public String getPartCode() {
		return this.partCode;
	}

	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}

	public String getSeverityCode() {
		return this.severityCode;
	}

	public void setSeverityCode(String severityCode) {
		this.severityCode = severityCode;
	}


	public String getResult() {
		return this.result;
	}

	public String getClinicalDiagnosis() {
		return clinicalDiagnosis;
	}

	public void setClinicalDiagnosis(String clinicalDiagnosis) {
		this.clinicalDiagnosis = clinicalDiagnosis;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

}