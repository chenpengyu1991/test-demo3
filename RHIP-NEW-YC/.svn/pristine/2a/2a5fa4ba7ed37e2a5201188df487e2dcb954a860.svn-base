package com.founder.rhip.mdm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DIC_VERSION")
public class DicVersion implements Serializable {

	private static final long serialVersionUID = 8969227539116367262L;

	public static final String ID = "id";

	public static final String DIC_CODE = "dicCode";

	public static final String VERSION_NUMBER = "versionNumber";

	public static final String VERSION_STATUS = "versionStatus";

	public static final String MAJOR_VERSION = "majorVersion";

	public static  final String VERSION_DESC = "versionDesc";

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "VERSION_NUMBER", columnDefinition = "VARCHAR2|版本号|20|", length = 20, nullable = true)
	private String versionNumber;

	@Column(name = "VERSION_DESC", columnDefinition = "VARCHAR2|版本描述|200|", length = 200, nullable = true)
	private String versionDesc;

	@Column(name = "VERSION_STATUS", columnDefinition = "NUMBER|版本状态|1|", length = 1, nullable = true)
	private Integer versionStatus;

	@Column(name = "MAJOR_VERSION", columnDefinition = "NUMBER|主版本标识|1|", length = 1, nullable = true)
	private Integer majorVersion;
	
	@Column(name = "DIC_CODE", columnDefinition = "VARCHAR2|字典编码|20|", length = 20, nullable = true)
	private String dicCode;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getVersionDesc() {
		return versionDesc;
	}

	public void setVersionDesc(String versionDesc) {
		this.versionDesc = versionDesc;
	}

	
	public Integer getVersionStatus() {
		return versionStatus;
	}

	public void setVersionStatus(Integer versionStatus) {
		this.versionStatus = versionStatus;
	}

	public Integer getMajorVersion() {
		return majorVersion;
	}

	public void setMajorVersion(Integer majorVersion) {
		this.majorVersion = majorVersion;
	}

	public String getDicCode() {
		return dicCode;
	}

	public void setDicCode(String dicCode) {
		this.dicCode = dicCode;
	}
	
	
}
