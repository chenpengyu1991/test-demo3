package com.founder.rhip.ehr.entity.hsa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.service.export.Item;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "HSA_LOCATION_INFO")
public class LocationInfo implements Serializable {

	private static final long serialVersionUID = 1L;

    @Item(column = "编号",index = 1)
    @Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = true)
	private Long id;

	@Column(name = "LOCATION_ID", columnDefinition = "VARCHAR2|本地代码||", length = 20, nullable = true)
	private String locationId;

	@Column(name = "UNIT_CODE", columnDefinition = "VARCHAR2|单位名称代码||", length = 50, nullable = true)
	private String unitCode;

    @Item(column = "单位名称",index = 1)
	@Column(name = "UNIT_NAME", columnDefinition = "VARCHAR2|单位名称||", length = 200, nullable = true)
	private String unitName;

	@Column(name = "UNIT_TYPE_CODE", columnDefinition = "VARCHAR2|单位类型代码||", length = 2, nullable = true)
	private String unitTypeCode;

    @Column(name = "UNIT_TYPE_CODE_ORI", columnDefinition = "VARCHAR2|单位类型代码||", length = 10, nullable = true)
    private String unitTypeCodeOri;

	@Column(name = "UNIT_TYPE_NAME", columnDefinition = "VARCHAR2|单位类型名称||", length = 200, nullable = true)
	private String unitTypeName;

	@Column(name = "REGISTER_ORGN_CODE", columnDefinition = "VARCHAR2|注册地点代码||", length = 50, nullable = true)
	private String registerOrgnCode;

	@Column(name = "REGISTER_ORGN_NAME", columnDefinition = "VARCHAR2|注册地点名称||", length = 200, nullable = true)
	private String registerOrgnName;

	@Column(name = "BUSINESS_ADDRESS_CODE", columnDefinition = "VARCHAR2|经营地址代码||", length = 50, nullable = true)
	private String businessAddressCode;

	@XmlElement(name = "businessAddress")
	@Column(name = "BUSINESS_ADDRESS_NAME", columnDefinition = "VARCHAR2|经营地址名称||", length = 200, nullable = true)
	private String businessAddressName;

	@Column(name = "ZIP_CODE", columnDefinition = "VARCHAR2|邮政编码||", length = 10, nullable = true)
	private String zipCode;

	@Column(name = "ECONOMIC_NATURE_CODE", columnDefinition = "VARCHAR2|经济性质代码||", length = 2, nullable = true)
	private String economicNatureCode;

    @Column(name = "ECONOMIC_NATURE_CODE_ORI", columnDefinition = "VARCHAR2|经济性质代码||", length = 10, nullable = true)
    private String economicNatureCodeOri;

	@Column(name = "ECONOMIC_NATURE_NAME", columnDefinition = "VARCHAR2|经济性质名称||", length = 200, nullable = true)
	private String economicNatureName;

	@Column(name = "CONTACT", columnDefinition = "VARCHAR2|联系人||", length = 50, nullable = true)
	private String contact;

    @Item(column = "负责人",index = 10)
	@Column(name = "PERSON_IN_CHARGE", columnDefinition = "VARCHAR2|负责人||", length = 50, nullable = true)
	private String personInCharge;

    @Item(column = "法人",index = 11)
	@Column(name = "LEGAL", columnDefinition = "VARCHAR2|法人||", length = 50, nullable = true)
	private String legal;

	@Column(name = "QUALITY_CONTROL_STAFF", columnDefinition = "VARCHAR2|质管员||", length = 50, nullable = true)
	private String qualityControlStaff;

    @Item(column = "联系电话",index = 12)
	@Column(name = "CONTACT_PHONE", columnDefinition = "VARCHAR2|联系电话||", length = 30, nullable = true)
	private String contactPhone;

	@Column(name = "AGENCY_PHONE", columnDefinition = "VARCHAR2|代理电话||", length = 30, nullable = true)
	private String agencyPhone;

	@Column(name = "CONTACT_TELEPHONE", columnDefinition = "VARCHAR2|联系手机||", length = 30, nullable = true)
	private String contactTelephone;

	@Column(name = "AGENCY_TELEPHONE", columnDefinition = "VARCHAR2|代理手机||", length = 30, nullable = true)
	private String agencyTelephone;

	@Column(name = "DOCUMENT_TYPE_CODE", columnDefinition = "VARCHAR2|证件类别代码||", length = 2, nullable = true)
	private String documentTypeCode;

    @Column(name = "DOCUMENT_TYPE_CODE_ORI", columnDefinition = "VARCHAR2|证件类别代码||", length = 10, nullable = true)
    private String documentTypeCodeOri;

	@Column(name = "DOCUMENT_TYPE_NAME", columnDefinition = "VARCHAR2|证件类别名称||", length = 200, nullable = true)
	private String documentTypeName;

	@XmlElement(name="idCard")
	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|身份证号||", length = 20, nullable = true)
	private String idcard;

	@Column(name = "TOWNSHIP_LOT_CODE", columnDefinition = "VARCHAR2|乡镇地段代码||", length = 2, nullable = true)
	private String townshipLotCode;

    @Column(name = "TOWNSHIP_LOT_CODE_ORI", columnDefinition = "VARCHAR2|乡镇地段代码||", length = 10, nullable = true)
    private String townshipLotCodeOri;

	@Column(name = "TOWNSHIP_LOT_NAME", columnDefinition = "VARCHAR2|乡镇地段名称||", length = 200, nullable = true)
	private String townshipLotName;


	@Column(name = "EMPLOYEES_COUNT", columnDefinition = "INT|职工总数||", nullable = true)
	private Integer employeesCount;


	@Column(name = "EMAIL", columnDefinition = "VARCHAR2|电子邮件||", length = 30, nullable = true)
	private String email;

	@Column(name = "SITE", columnDefinition = "VARCHAR2|单位网址||", length = 100, nullable = true)
	private String site;

	@Column(name = "HEAD_DEPARTMENT", columnDefinition = "VARCHAR2|主管部门||", length = 30, nullable = true)
	private String headDepartment;

	@Column(name = "SCALE", columnDefinition = "VARCHAR2|单位规模||", length = 10, nullable = true)
	private String scale;

    @Column(name = "SCALE_ORI", columnDefinition = "VARCHAR2|单位规模||", length = 20, nullable = true)
    private String scaleOri;

	@Column(name = "SELF_CODE", columnDefinition = "VARCHAR2|本体代码||", length = 10, nullable = true)
	private String selfCode;

	@Column(name = "CREATE_ORGAN_NAME", columnDefinition = "VARCHAR2|填报机构名称||", length = 70, nullable = true)
	private String createOrganName;

	@Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|填报机构编码||", length = 50, nullable = true)
	private String createOrganCode;

	@Column(name = "CREATE_DOCTOR_NAME", columnDefinition = "VARCHAR2|填报人姓名||", length = 50, nullable = true)
	private String createDoctorName;

	@Column(name = "CREATE_DOCTOR_CODE", columnDefinition = "VARCHAR2|填报人编码||", length = 18, nullable = true)
	private String createDoctorCode;

	@XmlJavaTypeAdapter(value = DateAdapter.class)
	@Column(name = "CREATE_DATE", columnDefinition = "TIMESTAMP|填报时间||", nullable = true)
	private Date createDate;

	@XmlTransient
	@Column(name = "UPDATE_ORGAN_CODE", columnDefinition = "VARCHAR2|更新机构编码||", length = 50, nullable = true)
	private String updateOrganCode;

	@XmlTransient
	@Column(name = "UPDATE_ORGAN_NAME", columnDefinition = "VARCHAR2|更新机构名称||", length = 70, nullable = true)
	private String updateOrganName;

	@XmlTransient
	@Column(name = "UPDATE_DOCTOR_CODE", columnDefinition = "VARCHAR2|更新人编码||", length = 18, nullable = true)
	private String updateDoctorCode;

	@XmlTransient
	@Column(name = "UPDATE_DOCTOR_NAME", columnDefinition = "VARCHAR2|更新人姓名||", length = 50, nullable = true)
	private String updateDoctorName;

	@XmlJavaTypeAdapter(value = DateAdapter.class)
	@Column(name = "UPDATE_DATE", columnDefinition = "TIMESTAMP|更新日期和时间||", nullable = true)
	private Date updateDate;

	@XmlTransient
	@Column(name = "IS_DELETE", columnDefinition = "INT|删除状态||", nullable = true)
	private Integer isDelete;

	@XmlTransient
	@Column(name = "DATA_TYPE", columnDefinition = "VARCHAR2|数据类型||", length = 2, nullable = true)
	private String dataType;

//	@Column(name = "LICENSE_END_TIME", columnDefinition = "TIMESTAMP|许可截止时间|", nullable = true)
//	private Date licenseEndTime;

	@XmlTransient
	@Column(name = "STATUS", columnDefinition = "VARCHAR2|状态||", length = 2, nullable = true)
	private String status;

	// 2013年9月18日 16:34:27
	// 新增
	@Column(name = "OWNER", columnDefinition = "VARCHAR2|业主||", length = 50, nullable = true)
	private String owner;

	@Column(name = "NO_FILE", columnDefinition = "VARCHAR2|无档||", length = 2, nullable = true)
	private String noFile;

    @Column(name = "NO_FILE_ORI", columnDefinition = "VARCHAR2|无档||", length = 10, nullable = true)
    private String noFileOri;

	@Column(name = "ORGANIZATION_CODE", columnDefinition = "VARCHAR2|机构代码||", length = 50, nullable = true)
	private String organizationCode;

	@Column(name = "MAIN_ID", columnDefinition = "VARCHAR2|编号||", length = 20, nullable = true)
	private String mainId;

	@XmlElement(name = "mainUUID")
	@Column(name = "MAIN_UUID", columnDefinition = "VARCHAR2|uuid||", length = 50, nullable = true)
	private String mainUuid;

	@Column(name = "SUPERVISOR_CODE", columnDefinition = "VARCHAR2|责任监督员编号||", length = 50, nullable = true)
	private String supervisorCode;

    @Column(name = "SUPERVISOR_CODE_ORI", columnDefinition = "VARCHAR2|责任监督员编号||", length = 100, nullable = true)
    private String supervisorCodeOri;

	@Column(name = "SUPERVISOR_NAME", columnDefinition = "VARCHAR2|责任监督员姓名||", length = 50, nullable = true)
	private String supervisorName;

    //冗余最新业务数据
    @Item(column = "卫生专业",index = 20,isDic = true,dicType = "HSA00006")
	@Column(name = "HEALTH_PROFESSIONAL", columnDefinition = "VARCHAR2|卫生专业 ||", length = 10, nullable = true)
	private String healthProfessional;

	@Column(name = "MAIN_BUSINESS_CODE", columnDefinition = "VARCHAR2|主营行业分类编号||", length = 100, nullable = true)
	private String mainBusinessCode;

	@Column(name = "BUSINESS_TYPE_CODE", columnDefinition = "VARCHAR2|业务类型||", length = 2, nullable = true)
	private String businessTypeCode;

	@Column(name = "LICENSE_STATE_CODE", columnDefinition = "VARCHAR2|许可状态||", length = 2, nullable = true)
	private String licenseStateCode;

    @Item(column = "许可证到期日期",index = 21,isDate = true)
	@XmlJavaTypeAdapter(value = DateAdapter.class)
	@Column(name = "DUE_DATE", columnDefinition = "TIMESTAMP|到期日期||", nullable = true)
	private Date dueDate;

    //集成数据用
	@Transient
	private String license;
	@Transient
	private String mainBusinessName;
	@Transient
	private String secondaryBusinessCode;
	@Transient
	private String secondaryBusinessName;
	@Transient
	private String businessItem;
	@Transient
	private String noFileId;
    @Transient
    private String noFileIdOri;
    @Transient
    private String newRecordFlag;
    @Transient
    private String healthProfessionalOri;
    @Transient
    private String mainBusinessCodeOri;
    @Transient
    private String businessTypeCodeOri;
    @Transient
    private String licenseStateCodeOri;
    @Transient
    private String newRecordFlagOri;


	@Transient
	@XmlJavaTypeAdapter(value = DateAdapter.class)
	private Date releaseDate;
	@Transient
	private String secondaryId;
	@Transient
	@XmlElement(name = "secondaryUUID")
	private String secondaryUuid;


    //页面显示
	/**
	 * 巡查次数
	 */
    @Item(column = "巡查次数",index = 22)
	@Transient
	@XmlTransient
	private Integer inspCount;

	/**
	 * 指导次数
	 */
    @Item(column = "指导次数",index = 23)
	@Transient
	@XmlTransient
	private Integer guideCount;

	@Transient
	@XmlTransient
	private String licenseExpireType;

	@Transient
	@XmlTransient
	private List<BusinessInfo> businessInfos;

	@Transient
	@XmlTransient
	private Long locationInfoId;

	public static class DateAdapter extends XmlAdapter<String, Date> {

		private String pattern = "yyyyMMdd hh:mm:ss";

		@Override
		public Date unmarshal(String dateStr) throws Exception {
			if (ObjectUtil.isNullOrEmpty(dateStr)) {
				return null;
			}
			return DateUtil.parseSimpleDate(dateStr, pattern);
		}

		@Override
		public String marshal(Date date) throws Exception {
			if (ObjectUtil.isNullOrEmpty(date)) {
				return null;
			}
			return DateUtil.toDateString(date, pattern);
		}

	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUnitCode() {
		return this.unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getUnitName() {
		return this.unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUnitTypeCode() {
		return this.unitTypeCode;
	}

	public void setUnitTypeCode(String unitTypeCode) {
		this.unitTypeCode = unitTypeCode;
	}

	public String getUnitTypeName() {
		return this.unitTypeName;
	}

	public void setUnitTypeName(String unitTypeName) {
		this.unitTypeName = unitTypeName;
	}

	public String getRegisterOrgnCode() {
		return this.registerOrgnCode;
	}

	public void setRegisterOrgnCode(String registerOrgnCode) {
		this.registerOrgnCode = registerOrgnCode;
	}

	public String getRegisterOrgnName() {
		return this.registerOrgnName;
	}

	public void setRegisterOrgnName(String registerOrgnName) {
		this.registerOrgnName = registerOrgnName;
	}

	public String getBusinessAddressCode() {
		return this.businessAddressCode;
	}

	public void setBusinessAddressCode(String businessAddressCode) {
		this.businessAddressCode = businessAddressCode;
	}

	public String getBusinessAddressName() {
		return this.businessAddressName;
	}

	public void setBusinessAddressName(String businessAddressName) {
		this.businessAddressName = businessAddressName;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getEconomicNatureCode() {
		return this.economicNatureCode;
	}

	public void setEconomicNatureCode(String economicNatureCode) {
		this.economicNatureCode = economicNatureCode;
	}

	public String getEconomicNatureName() {
		return this.economicNatureName;
	}

	public void setEconomicNatureName(String economicNatureName) {
		this.economicNatureName = economicNatureName;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPersonInCharge() {
		return this.personInCharge;
	}

	public void setPersonInCharge(String personInCharge) {
		this.personInCharge = personInCharge;
	}

	public String getLegal() {
		return this.legal;
	}

	public void setLegal(String legal) {
		this.legal = legal;
	}

	public String getQualityControlStaff() {
		return this.qualityControlStaff;
	}

	public void setQualityControlStaff(String qualityControlStaff) {
		this.qualityControlStaff = qualityControlStaff;
	}

	public String getContactPhone() {
		return this.contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getAgencyPhone() {
		return this.agencyPhone;
	}

	public void setAgencyPhone(String agencyPhone) {
		this.agencyPhone = agencyPhone;
	}

	public String getContactTelephone() {
		return this.contactTelephone;
	}

	public void setContactTelephone(String contactTelephone) {
		this.contactTelephone = contactTelephone;
	}

	public String getAgencyTelephone() {
		return this.agencyTelephone;
	}

	public void setAgencyTelephone(String agencyTelephone) {
		this.agencyTelephone = agencyTelephone;
	}

	public String getDocumentTypeCode() {
		return this.documentTypeCode;
	}

	public void setDocumentTypeCode(String documentTypeCode) {
		this.documentTypeCode = documentTypeCode;
	}

	public String getDocumentTypeName() {
		return this.documentTypeName;
	}

	public void setDocumentTypeName(String documentTypeName) {
		this.documentTypeName = documentTypeName;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getTownshipLotCode() {
		return this.townshipLotCode;
	}

	public void setTownshipLotCode(String townshipLotCode) {
		this.townshipLotCode = townshipLotCode;
	}

	public String getTownshipLotName() {
		return this.townshipLotName;
	}

	public void setTownshipLotName(String townshipLotName) {
		this.townshipLotName = townshipLotName;
	}

	public Integer getEmployeesCount() {
		return this.employeesCount;
	}

	public void setEmployeesCount(Integer employeesCount) {
		this.employeesCount = employeesCount;
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

	public Integer getInspCount() {
		return inspCount;
	}

	public void setInspCount(Integer inspCount) {
		this.inspCount = inspCount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getHeadDepartment() {
		return headDepartment;
	}

	public void setHeadDepartment(String headDepartment) {
		this.headDepartment = headDepartment;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getSelfCode() {
		return selfCode;
	}

	public void setSelfCode(String selfCode) {
		this.selfCode = selfCode;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
//
//	public Date getLicenseEndTime() {
//		return licenseEndTime;
//	}
//
//	public void setLicenseEndTime(Date licenseEndTime) {
//		this.licenseEndTime = licenseEndTime;
//	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getMainId() {
		return mainId;
	}

	public void setMainId(String mainId) {
		this.mainId = mainId;
	}

	public String getMainUuid() {
		return mainUuid;
	}

	public void setMainUuid(String mainUuid) {
		this.mainUuid = mainUuid;
	}

	public String getNoFileId() {
		return noFileId;
	}

	public void setNoFileId(String noFileId) {
		this.noFileId = noFileId;
	}

	public String getSupervisorCode() {
		return supervisorCode;
	}

	public void setSupervisorCode(String supervisorCode) {
		this.supervisorCode = supervisorCode;
	}

	public String getSupervisorName() {
		return supervisorName;
	}

	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}

	public String getHealthProfessional() {
		return healthProfessional;
	}

	public void setHealthProfessional(String healthProfessional) {
		this.healthProfessional = healthProfessional;
	}

	public String getMainBusinessCode() {
		return mainBusinessCode;
	}

	public void setMainBusinessCode(String mainBusinessCode) {
		this.mainBusinessCode = mainBusinessCode;
	}

	public String getBusinessTypeCode() {
		return businessTypeCode;
	}

	public void setBusinessTypeCode(String businessTypeCode) {
		this.businessTypeCode = businessTypeCode;
	}

	public String getLicenseStateCode() {
		return licenseStateCode;
	}

	public void setLicenseStateCode(String licenseStateCode) {
		this.licenseStateCode = licenseStateCode;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getMainBusinessName() {
		return mainBusinessName;
	}

	public void setMainBusinessName(String mainBusinessName) {
		this.mainBusinessName = mainBusinessName;
	}

	public String getSecondaryBusinessCode() {
		return secondaryBusinessCode;
	}

	public void setSecondaryBusinessCode(String secondaryBusinessCode) {
		this.secondaryBusinessCode = secondaryBusinessCode;
	}

	public String getSecondaryBusinessName() {
		return secondaryBusinessName;
	}

	public void setSecondaryBusinessName(String secondaryBusinessName) {
		this.secondaryBusinessName = secondaryBusinessName;
	}

	public String getBusinessItem() {
		return businessItem;
	}

	public void setBusinessItem(String businessItem) {
		this.businessItem = businessItem;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getNoFile() {
		return noFile;
	}

	public void setNoFile(String noFile) {
		this.noFile = noFile;
	}

	public String getSecondaryId() {
		return secondaryId;
	}

	public void setSecondaryId(String secondaryId) {
		this.secondaryId = secondaryId;
	}

	public String getSecondaryUuid() {
		return secondaryUuid;
	}

	public void setSecondaryUuid(String secondaryUuid) {
		this.secondaryUuid = secondaryUuid;
	}

	public List<BusinessInfo> getBusinessInfos() {
		return businessInfos;
	}

	public void setBusinessInfos(List<BusinessInfo> businessInfos) {
		this.businessInfos = businessInfos;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Long getLocationInfoId() {
		return locationInfoId;
	}

	public void setLocationInfoId(Long locationInfoId) {
		this.locationInfoId = locationInfoId;
	}

	public Integer getGuideCount() {
		return guideCount;
	}

	public void setGuideCount(Integer guideCount) {
		this.guideCount = guideCount;
	}

	public String getLicenseExpireType() {
		return licenseExpireType;
	}

	public void setLicenseExpireType(String licenseExpireType) {
		this.licenseExpireType = licenseExpireType;
	}
    public String getNewRecordFlag() {
        return newRecordFlag;
    }

    public void setNewRecordFlag(String newRecordFlag) {
        this.newRecordFlag = newRecordFlag;
    }

    public String getHealthProfessionalOri() {
        return healthProfessionalOri;
    }

    public void setHealthProfessionalOri(String healthProfessionalOri) {
        this.healthProfessionalOri = healthProfessionalOri;
    }

    public String getMainBusinessCodeOri() {
        return mainBusinessCodeOri;
    }

    public void setMainBusinessCodeOri(String mainBusinessCodeOri) {
        this.mainBusinessCodeOri = mainBusinessCodeOri;
    }

    public String getBusinessTypeCodeOri() {
        return businessTypeCodeOri;
    }

    public void setBusinessTypeCodeOri(String businessTypeCodeOri) {
        this.businessTypeCodeOri = businessTypeCodeOri;
    }

    public String getLicenseStateCodeOri() {
        return licenseStateCodeOri;
    }

    public void setLicenseStateCodeOri(String licenseStateCodeOri) {
        this.licenseStateCodeOri = licenseStateCodeOri;
    }

    public String getNewRecordFlagOri() {
        return newRecordFlagOri;
    }

    public void setNewRecordFlagOri(String newRecordFlagOri) {
        this.newRecordFlagOri = newRecordFlagOri;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUnitTypeCodeOri() {
        return unitTypeCodeOri;
    }

    public void setUnitTypeCodeOri(String unitTypeCodeOri) {
        this.unitTypeCodeOri = unitTypeCodeOri;
    }

    public String getEconomicNatureCodeOri() {
        return economicNatureCodeOri;
    }

    public void setEconomicNatureCodeOri(String economicNatureCodeOri) {
        this.economicNatureCodeOri = economicNatureCodeOri;
    }

    public String getDocumentTypeCodeOri() {
        return documentTypeCodeOri;
    }

    public void setDocumentTypeCodeOri(String documentTypeCodeOri) {
        this.documentTypeCodeOri = documentTypeCodeOri;
    }

    public String getTownshipLotCodeOri() {
        return townshipLotCodeOri;
    }

    public void setTownshipLotCodeOri(String townshipLotCodeOri) {
        this.townshipLotCodeOri = townshipLotCodeOri;
    }

    public String getScaleOri() {
        return scaleOri;
    }

    public void setScaleOri(String scaleOri) {
        this.scaleOri = scaleOri;
    }

    public String getNoFileOri() {
        return noFileOri;
    }

    public void setNoFileOri(String noFileOri) {
        this.noFileOri = noFileOri;
    }

    public String getNoFileIdOri() {
        return noFileIdOri;
    }

    public void setNoFileIdOri(String noFileIdOri) {
        this.noFileIdOri = noFileIdOri;
    }

    public String getSupervisorCodeOri() {
        return supervisorCodeOri;
    }

    public void setSupervisorCodeOri(String supervisorCodeOri) {
        this.supervisorCodeOri = supervisorCodeOri;
    }
}