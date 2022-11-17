package com.founder.rhip.ehr.entity.portal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "HOSPITAL_INFO")
public class HospitalInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|自增长id|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "HOSPITAL_NO", columnDefinition = "VARCHAR2|医院编号|50|", length = 50, nullable = true)
	private String hospitalNo;

	@Column(name = "HOSPITAL_NAME", columnDefinition = "VARCHAR2|医院名称|50|", length = 50, nullable = true)
	private String hospitalName;

	@Column(name = "BELONG_DISTRICTS", columnDefinition = "VARCHAR2|所属地区|50|", length = 50, nullable = true)
	private String belongDistricts;

	@Column(name = "HOSPITAL_PHONE", columnDefinition = "VARCHAR2|医院电话|50|", length = 50, nullable = true)
	private String hospitalPhone;

	@Column(name = "HOSPITAL_LEVEL", columnDefinition = "VARCHAR2|医院级别|50|", length = 50, nullable = true)
	private String hospitalLevel;

	@Column(name = "HOSPITAL_CATEGORY", columnDefinition = "VARCHAR2|医院类别|50|", length = 50, nullable = true)
	private String hospitalCategory;

	@Column(name = "HOSPITAL_WEBSITE", columnDefinition = "VARCHAR2|医院网址|500|", length = 500, nullable = true)
	private String hospitalWebsite;

	@Column(name = "HOSPITAL_PICTURES", columnDefinition = "VARCHAR2|医院照片|500|", length = 500, nullable = true)
	private String hospitalPictures;

	@Column(name = "HOSPITAL_ADDRESS", columnDefinition = "VARCHAR2|医院地址|1000|", length = 1000, nullable = true)
	private String hospitalAddress;

	@Column(name = "BELONG_AREA", columnDefinition = "VARCHAR2|所属区域|50|", length = 50, nullable = true)
	private String belongArea;

	@Column(name = "HOSPITAL_NATURE", columnDefinition = "VARCHAR2|医院性质|50|", length = 50, nullable = true)
	private String hospitalNature;

	@Column(name = "ORGANIZATION_TYPE", columnDefinition = "VARCHAR2|机构类别|50|", length = 50, nullable = true)
	private String organizationType;

	@Column(name = "REGISTRATION_TIME", columnDefinition = "VARCHAR2|挂号时间|50|", length = 50, nullable = true)
	private String registrationTime;

	@Column(name = "TREATMENT_TIME", columnDefinition = "VARCHAR2|就诊时间|50|", length = 50, nullable = true)
	private String treatmentTime;

	@Column(name = "VISIT_TIME", columnDefinition = "VARCHAR2|探视时间|50|", length = 50, nullable = true)
	private String visitTime;

	@Column(name = "GETTING_THERE", columnDefinition = "VARCHAR2|乘车路线|3000|", length = 3000, nullable = true)
	private String gettingThere;

	@Column(name = "IS_REGISTERED_HOSPITAL", columnDefinition = "VARCHAR2|是否预约挂号医院|50|", length = 50, nullable = true)
	private String isRegisteredHospital;

	@Column(name = "HOSPITAL_INFO", columnDefinition = "VARCHAR2|医院信息|4000|", length = 4000, nullable = true)
	private String hospitalInfo;

	@Column(name = "CREATE_TIME", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createTime;

	@Column(name = "STATUS", columnDefinition = "NUMBER|发布状态:未发布：0,已发布：1|1|", length = 1, nullable = true)
	private Integer status = 0;
	
	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除|1|", length = 1, nullable = true)
	private Integer is_delete = 0;
	
	@Column(name = "UPDATE_TIME", columnDefinition = "DATE|修改时间||", nullable = true)
	private Date updateTime;
	
	@Column(name = "GUIDE_FOR_MEDICAL", columnDefinition = "CLOB|就医指南||", nullable = true)
	private String guideForMedical;

	@Column(name = "CREATE_ORG_CODE", columnDefinition = "VARCHAR2|创建机构|50|", length = 50, nullable = true)
	private String createOrgCode;

	@Column(name = "CREATE_USER_CODE", columnDefinition = "VARCHAR2|创建人|50|", length = 18, nullable = true)
	private String createUserCode;

	@Column(name = "UPDATE_ORG_CODE", columnDefinition = "VARCHAR2|更新机构|50|", length = 50, nullable = true)
	private String updateOrgCode;

	@Column(name = "UPDATE_USER_CODE", columnDefinition = "VARCHAR2|更新人|50|", length = 18, nullable = true)
	private String updateUserCode;

	@Column(name = "MICRO_GUIDANCE", columnDefinition = "CLOB|微导诊||", nullable = true)
	private String microGuidance;
	
	@Column(name = "ORDER_NUM", columnDefinition = "NUMBER|序号|11|", length = 11, nullable = true)
	private Long orderNum;

	@Column(name = "TIPS", columnDefinition = "VARCHAR2|友情提示|500|", length = 500, nullable = true)
	private String tips;

	private Date BeginTime;
	private Date EndTime;
	private String operation;//1查看2修改3新增
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHospitalNo() {
		return this.hospitalNo;
	}

	public void setHospitalNo(String hospitalNo) {
		this.hospitalNo = hospitalNo;
	}

	public String getHospitalName() {
		return this.hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getBelongDistricts() {
		return this.belongDistricts;
	}

	public void setBelongDistricts(String belongDistricts) {
		this.belongDistricts = belongDistricts;
	}

	public String getHospitalPhone() {
		return this.hospitalPhone;
	}

	public void setHospitalPhone(String hospitalPhone) {
		this.hospitalPhone = hospitalPhone;
	}

	public String getHospitalLevel() {
		return this.hospitalLevel;
	}

	public void setHospitalLevel(String hospitalLevel) {
		this.hospitalLevel = hospitalLevel;
	}

	public String getHospitalCategory() {
		return this.hospitalCategory;
	}

	public void setHospitalCategory(String hospitalCategory) {
		this.hospitalCategory = hospitalCategory;
	}

	public String getHospitalWebsite() {
		return this.hospitalWebsite;
	}

	public void setHospitalWebsite(String hospitalWebsite) {
		this.hospitalWebsite = hospitalWebsite;
	}

	public String getHospitalPictures() {
		return this.hospitalPictures;
	}

	public void setHospitalPictures(String hospitalPictures) {
		this.hospitalPictures = hospitalPictures;
	}

	public String getHospitalAddress() {
		return this.hospitalAddress;
	}

	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}

	public String getBelongArea() {
		return this.belongArea;
	}

	public void setBelongArea(String belongArea) {
		this.belongArea = belongArea;
	}

	public String getHospitalNature() {
		return this.hospitalNature;
	}

	public void setHospitalNature(String hospitalNature) {
		this.hospitalNature = hospitalNature;
	}

	public String getOrganizationType() {
		return this.organizationType;
	}

	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}


	public String getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(String registrationTime) {
		this.registrationTime = registrationTime;
	}

	public String getTreatmentTime() {
		return treatmentTime;
	}

	public void setTreatmentTime(String treatmentTime) {
		this.treatmentTime = treatmentTime;
	}

	public String getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}

	public String getGettingThere() {
		return this.gettingThere;
	}

	public void setGettingThere(String gettingThere) {
		this.gettingThere = gettingThere;
	}

	public String getIsRegisteredHospital() {
		return this.isRegisteredHospital;
	}

	public void setIsRegisteredHospital(String isRegisteredHospital) {
		this.isRegisteredHospital = isRegisteredHospital;
	}

	public String getHospitalInfo() {
		return this.hospitalInfo;
	}

	public void setHospitalInfo(String hospitalInfo) {
		this.hospitalInfo = hospitalInfo;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(Integer is_delete) {
		this.is_delete = is_delete;
	}

	public Date getBeginTime() {
		return BeginTime;
	}

	public void setBeginTime(Date beginTime) {
		BeginTime = beginTime;
	}

	public Date getEndTime() {
		return EndTime;
	}

	public void setEndTime(Date endTime) {
		EndTime = endTime;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getGuideForMedical() {
		return guideForMedical;
	}

	public void setGuideForMedical(String guideForMedical) {
		this.guideForMedical = guideForMedical;
	}

	public String getCreateOrgCode() {
		return createOrgCode;
	}

	public void setCreateOrgCode(String createOrgCode) {
		this.createOrgCode = createOrgCode;
	}

	public String getCreateUserCode() {
		return createUserCode;
	}

	public void setCreateUserCode(String createUserCode) {
		this.createUserCode = createUserCode;
	}

	public String getUpdateOrgCode() {
		return updateOrgCode;
	}

	public void setUpdateOrgCode(String updateOrgCode) {
		this.updateOrgCode = updateOrgCode;
	}

	public String getUpdateUserCode() {
		return updateUserCode;
	}

	public void setUpdateUserCode(String updateUserCode) {
		this.updateUserCode = updateUserCode;
	}

	public String getMicroGuidance() {
		return microGuidance;
	}

	public void setMicroGuidance(String microGuidance) {
		this.microGuidance = microGuidance;
	}

	public Long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}
}