package com.founder.rhip.ehr.entity.hsa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "HSA_INSPECTION_RECORD")
public class InspectionRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = true)
	private Long id;

	@Column(name = "LOCATION_ID", columnDefinition = "NUMBER|查询地点信息编号||", length = 11, nullable = true)
	private Long locationId;

	@Column(name = "FIND_MAIN_PRO", columnDefinition = "VARCHAR2|发现主要问题||", length = 500, nullable = true)
	private String findMainPro;
	
	@Column(name = "inspection_Record", columnDefinition = "VARCHAR2|巡查笔录||", length = 500, nullable = true)
	private String inspectionRecord;

	@Column(name = "Health_supervision_opinion", columnDefinition = "VARCHAR2|卫生监督意见书||", length = 500, nullable = true)
	private String healthSupervisionOpinion;
	
	@Column(name = "INSP_DATE", columnDefinition = "TIMESTAMP|巡查日期||", nullable = true)
	private Date inspDate;

	@Column(name = "INSP_PERSON_CODE", columnDefinition = "VARCHAR2|巡查人代码||", length = 20, nullable = true)
	private String inspPersonCode;

	@Column(name = "INSP_PERSON_NAME", columnDefinition = "VARCHAR2|巡查人名称||", length = 50, nullable = true)
	private String inspPersonName;
	
	@Column(name = "SEC_INSP_PERSON_CODE", columnDefinition = "VARCHAR2|第二巡查人代码||", length = 20, nullable = true)
	private String secInspPersonCode;

	@Column(name = "SEC_INSP_PERSON_NAME", columnDefinition = "VARCHAR2|巡查人名称||", length = 50, nullable = true)
	private String secInspPersonName;
	
	@Column(name = "REMARK", columnDefinition = "VARCHAR2|备注||", length = 200, nullable = true)
	private String remark;

	@Column(name = "IS_GUIDE", columnDefinition = "VARCHAR2|是否巡查指导||", length = 1, nullable = true)
	private String isGuide;

	@Column(name = "IS_REPORT", columnDefinition = "VARCHAR2|是否报告登记||", length = 1, nullable = true)
	private String isReport;

	@Column(name = "INSP_LOC_TYPE", columnDefinition = "VARCHAR2|巡查地点类型||", length = 1, nullable = true)
	private String inspLocType;
	
	@Column(name = "INSP_HEALTH_PROFESSIONAL", columnDefinition = "VARCHAR2|巡查卫生专业||", length = 10, nullable = true)
	private String inspHealthProfessional;
	
	@Column(name = "STATUS", columnDefinition = "VARCHAR2状态||", length = 1, nullable = true)
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

	@Column(name = "CREATE_CENTER_ORGAN_CODE", columnDefinition = "VARCHAR2|填报中心机构编码||", length = 50, nullable = true)
	private String createCenterOrganCode;

	@Column(name = "CREATE_CENTER_ORGAN_NAME", columnDefinition = "VARCHAR2|填报中心机构||", length = 50, nullable = true)
	private String createCenterOrganName;

	@Column(name = "CREATE_GBCODE", columnDefinition = "VARCHAR2|填报镇构编码||", length = 50, nullable = true)
	private String createGbcode;
	
	@Transient
	private InspGuideRecord inspGuideRecord;

	@Transient
	private ReportRecord reportRecord;
	
	@Transient
	private FamilyInfo familyInfo;

	@Transient
	private String unitName;
	
	@Transient
	private String healthProfessional;

	@Transient
	private LocationInfo locationInfo;

	@Transient
	private String householderName;

	@Transient
	private String address;
	
	@Transient
	private Long familyId;
	
	@Transient
	private String phoneNumber;

	public String getCreateCenterOrganCode() {
		return createCenterOrganCode;
	}

	public void setCreateCenterOrganCode(String createCenterOrganCode) {
		this.createCenterOrganCode = createCenterOrganCode;
	}

	public String getCreateCenterOrganName() {
		return createCenterOrganName;
	}

	public void setCreateCenterOrganName(String createCenterOrganName) {
		this.createCenterOrganName = createCenterOrganName;
	}

	public String getCreateGbcode() {
		return createGbcode;
	}

	public void setCreateGbcode(String createGbcode) {
		this.createGbcode = createGbcode;
	}

	private List<SusOccDisInfo> susOccDisInfoList;

	public List<SusOccDisInfo> getSusOccDisInfoList() {
		return susOccDisInfoList;
	}

	public void setSusOccDisInfoList(List<SusOccDisInfo> susOccDisInfoList) {
		this.susOccDisInfoList = susOccDisInfoList;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLocationId() {
		return this.locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public Date getInspDate() {
		return this.inspDate;
	}

	public void setInspDate(Date inspDate) {
		this.inspDate = inspDate;
	}

	public String getInspPersonCode() {
		return this.inspPersonCode;
	}

	public void setInspPersonCode(String inspPersonCode) {
		this.inspPersonCode = inspPersonCode;
	}

	public String getInspPersonName() {
		return this.inspPersonName;
	}

	public void setInspPersonName(String inspPersonName) {
		this.inspPersonName = inspPersonName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIsGuide() {
		return this.isGuide;
	}

	public void setIsGuide(String isGuide) {
		this.isGuide = isGuide;
	}

	public String getIsReport() {
		return this.isReport;
	}

	public void setIsReport(String isReport) {
		this.isReport = isReport;
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
	
	public String getFindMainPro() {
		return findMainPro;
	}

	public void setFindMainPro(String findMainPro) {
		this.findMainPro = findMainPro;
	}

	public String getInspectionRecord() {
		return inspectionRecord;
	}

	public void setInspectionRecord(String inspectionRecord) {
		this.inspectionRecord = inspectionRecord;
	}

	public String getHealthSupervisionOpinion() {
		return healthSupervisionOpinion;
	}

	public void setHealthSupervisionOpinion(String healthSupervisionOpinion) {
		this.healthSupervisionOpinion = healthSupervisionOpinion;
	}

	public InspGuideRecord getInspGuideRecord() {
		return inspGuideRecord;
	}

	public void setInspGuideRecord(InspGuideRecord inspGuideRecord) {
		this.inspGuideRecord = inspGuideRecord;
	}

	public ReportRecord getReportRecord() {
		return reportRecord;
	}

	public void setReportRecord(ReportRecord reportRecord) {
		this.reportRecord = reportRecord;
	}

	public LocationInfo getLocationInfo() {
		return locationInfo;
	}

	public void setLocationInfo(LocationInfo locationInfo) {
		this.locationInfo = locationInfo;
	}

	public String getInspLocType() {
		return inspLocType;
	}

	public void setInspLocType(String inspLocType) {
		this.inspLocType = inspLocType;
	}

	public String getHouseholderName() {
		return householderName;
	}

	public void setHouseholderName(String householderName) {
		this.householderName = householderName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getFamilyId() {
		return familyId;
	}

	public void setFamilyId(Long familyId) {
		this.familyId = familyId;
	}

	public FamilyInfo getFamilyInfo() {
		return familyInfo;
	}

	public void setFamilyInfo(FamilyInfo familyInfo) {
		this.familyInfo = familyInfo;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHealthProfessional() {
		return healthProfessional;
	}

	public void setHealthProfessional(String healthProfessional) {
		this.healthProfessional = healthProfessional;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getInspHealthProfessional() {
		return inspHealthProfessional;
	}

	public void setInspHealthProfessional(String inspHealthProfessional) {
		this.inspHealthProfessional = inspHealthProfessional;
	}

	public String getSecInspPersonCode() {
		return secInspPersonCode;
	}

	public void setSecInspPersonCode(String secInspPersonCode) {
		this.secInspPersonCode = secInspPersonCode;
	}

	public String getSecInspPersonName() {
		return secInspPersonName;
	}

	public void setSecInspPersonName(String secInspPersonName) {
		this.secInspPersonName = secInspPersonName;
	}


}