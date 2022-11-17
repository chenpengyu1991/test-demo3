package com.founder.rhip.ehr.entity.hsa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "HSA_BUSINESS_INFO")
public class BusinessInfo {

	@Column(name = "SECONDARY_ID", columnDefinition = "VARCHAR2|编号||", length = 20, nullable = true)
	private String secondaryId;

	@XmlElement(name = "secondaryUUID")
	@Column(name = "SECONDARY_UUID", columnDefinition = "VARCHAR2|uuid||", length = 50, nullable = true)
	private String secondaryUuid;

	@Column(name = "MAIN_ID", columnDefinition = "VARCHAR2|编号||", length = 20, nullable = true)
	private String mainId;

	@XmlElement(name = "mainUUID")
	@Column(name = "MAIN_UUID", columnDefinition = "VARCHAR2|uuid||", length = 50, nullable = true)
	private String mainUuid;
	
	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = true)
	private Long id;

	@Column(name = "NO_FILE_ID", columnDefinition = "VARCHAR2|无证标识||", length = 2, nullable = true)
	private String noFileId;

    @Column(name = "NO_FILE_ID_ORI", columnDefinition = "VARCHAR2|无证标识||", length = 10, nullable = true)
    private String noFileIdOri;
	
	@Column(name = "LICENSE", columnDefinition = "VARCHAR2|许可证号||", length = 30, nullable = true)
	private String license;

	@Column(name = "HEALTH_PROFESSIONAL", columnDefinition = "VARCHAR2|卫生专业 ||", length = 10, nullable = true)
	private String healthProfessional;

	@Column(name = "MAIN_BUSINESS_CODE", columnDefinition = "VARCHAR2|主营行业分类编号||", length = 100, nullable = true)
	private String mainBusinessCode;

	@Column(name = "MAIN_BUSINESS_NAME", columnDefinition = "VARCHAR2| 主营行业分类名称 ||", length = 500, nullable = true)
	private String mainBusinessName;

	@Column(name = "SECONDARY_BUSINESS_CODE", columnDefinition = "VARCHAR2| 兼营行业分类编号||", length = 100, nullable = true)
	private String secondaryBusinessCode;

	@Column(name = "SECONDARY_BUSINESS_NAME", columnDefinition = "VARCHAR2|兼营行业分类名称||", length = 500, nullable = true)
	private String secondaryBusinessName;

	@Column(name = "BUSINESS_ITEM", columnDefinition = "VARCHAR2|经营项目||", length = 500, nullable = true)
	private String businessItem;

	@Column(name = "DUE_DATE", columnDefinition = "TIMESTAMP|到期日期||", nullable = true)
	private Date dueDate;

	@Column(name = "RELEASE_DATE", columnDefinition = "TIMESTAMP|发证日期||", nullable = true)
	private Date releaseDate;

	@Column(name = "CREATE_DATE", columnDefinition = "TIMESTAMP|创建日期||", nullable = true)
	private Date createDate;

	@Column(name = "UPDATE_DATE", columnDefinition = "TIMESTAMP| 更新日期||", nullable = true)
	private Date updateDate;

	@Column(name = "BUSINESS_TYPE_CODE", columnDefinition = "VARCHAR2|业务类型||", length = 2, nullable = true)
	private String businessTypeCode;

    @Column(name = "BUSINESS_TYPE_CODE_ORI", columnDefinition = "VARCHAR2|业务类型||", length = 10, nullable = true)
    private String businessTypeCodeOri;

	@Column(name = "LICENSE_STATE_CODE", columnDefinition = "VARCHAR2|许可状态||", length = 2, nullable = true)
	private String licenseStateCode;

    @Column(name = "LICENSE_STATE_CODE_ORI", columnDefinition = "VARCHAR2|许可状态||", length = 10, nullable = true)
    private String licenseStateCodeOri;
	
	@Column(name = "LOCATION_INFO_ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = true)
	private Long locationInfoId;

    @Column(name = "NEW_RECORD_FLAG", columnDefinition = "VARCHAR2|新记录标志||", length = 2, nullable = true)
    private String newRecordFlag;

    @Column(name = "NEW_RECORD_FLAG_ORI", columnDefinition = "VARCHAR2|新记录标志||", length = 10, nullable = true)
    private String newRecordFlagOri;

    @Column(name = "HEALTH_PROFESSIONAL_ORI", columnDefinition = "VARCHAR2|卫生专业原始值 ||", length = 10, nullable = true)
    private String healthProfessionalOri;

    @Column(name = "MAIN_BUSINESS_CODE_ORI", columnDefinition = "VARCHAR2|主营行业分类编号原始值||", length = 100, nullable = true)
    private String mainBusinessCodeOri;

    @XmlTransient
    @Column(name = "DATA_TYPE", columnDefinition = "VARCHAR2|数据类型||", length = 2, nullable = true)
    private String dataType;

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getHealthProfessionalOri() {
        return healthProfessionalOri;
    }

    public void setHealthProfessionalOri(String healthProfessionalOri) {
        this.healthProfessionalOri = healthProfessionalOri;
    }

    public String getNewRecordFlag() {

        return newRecordFlag;
    }

    public void setNewRecordFlag(String newRecordFlag) {
        this.newRecordFlag = newRecordFlag;
    }

    public String getMainBusinessCodeOri() {
        return mainBusinessCodeOri;
    }

    public void setMainBusinessCodeOri(String mainBusinessCodeOri) {
        this.mainBusinessCodeOri = mainBusinessCodeOri;
    }

    public String getNoFileId() {
		return noFileId;
	}

	public void setNoFileId(String noFileId) {
		this.noFileId = noFileId;
	}
	
	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
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

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getLocationInfoId() {
		return locationInfoId;
	}

	public void setLocationInfoId(Long locationInfoId) {
		this.locationInfoId = locationInfoId;
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

    public String getNoFileIdOri() {
        return noFileIdOri;
    }

    public void setNoFileIdOri(String noFileIdOri) {
        this.noFileIdOri = noFileIdOri;
    }
}
