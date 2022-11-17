package com.founder.elb.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CV_DICMETA")
public class CvDicmeta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|术语目录标识|8|", length = 8, nullable = false)
	private Integer id;

	@Column(name = "DOMAIN_ID", columnDefinition = "NUMBER|域标识|8|", length = 8, nullable = false)
	private Integer domainId;

	@Column(name = "CODE", columnDefinition = "VARCHAR2|编码|20|", length = 20, nullable = false)
	private String code;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|名称|100|", length = 100, nullable = false)
	private String name;

	@Column(name = "OID", columnDefinition = "VARCHAR2|对象标识|50|", length = 50, nullable = true)
	private String oid;

	@Column(name = "OID_NAME", columnDefinition = "VARCHAR2|对象标识名|100|", length = 100, nullable = true)
	private String oidName;

	@Column(name = "IS_CV", columnDefinition = "NUMBER|术语目录标识|1||是否自定义||", nullable = true)
	private Integer isCv;

	@Column(name = "VERSION", columnDefinition = "VARCHAR2|版本号|20|", length = 20, nullable = true)
	private String version;

	@Column(name = "STATUS", columnDefinition = "NUMBER|状态|1|", length = 1, nullable = true)
	private Integer status;
	
	private List<CvConfig> cvConfigList;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Integer domainId) {
		this.domainId = domainId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOid() {
		return this.oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getOidName() {
		return this.oidName;
	}

	public void setOidName(String oidName) {
		this.oidName = oidName;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<CvConfig> getCvConfigList() {
		return cvConfigList;
	}

	public void setCvConfigList(List<CvConfig> cvConfigList) {
		this.cvConfigList = cvConfigList;
	}

	public Integer getIsCv() {
		return isCv;
	}

	public void setIsCv(Integer isCv) {
		this.isCv = isCv;
	}

}