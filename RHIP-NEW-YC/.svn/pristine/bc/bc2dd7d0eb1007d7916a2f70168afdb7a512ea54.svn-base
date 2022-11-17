package com.founder.rhip.ehr.entity.control.oh;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "OH_HOSPITAL_INFO")
public class OhHospitalInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "FILE_NO", columnDefinition = "VARCHAR2|档案号|50|", length = 50, nullable = true)
	private String fileNo;

	@Column(name = "HOSPITAL_NAME", columnDefinition = "VARCHAR2|医院名称|50|", length = 50, nullable = true)
	private String hospitalName;

	@Column(name = "ORG_CODE", columnDefinition = "VARCHAR2|组织机构代码|20|", length = 20, nullable = true)
	private String orgCode;

	@Column(name = "ADDR", columnDefinition = "VARCHAR2|地址|50|", length = 50, nullable = true)
	private String addr;

	@Column(name = "H_LEVEL", columnDefinition = "VARCHAR2|级别|20|", length = 20, nullable = true)
	private String hLevel;

	@Column(name = "LEGAL_REPR", columnDefinition = "VARCHAR2|法定代表人|20|", length = 20, nullable = true)
	private String legalRepr;

	@Column(name = "PROTECTION_HEAD", columnDefinition = "VARCHAR2|防护责任人|20|", length = 20, nullable = true)
	private String protectionHead;

	@Column(name = "PHONE", columnDefinition = "VARCHAR2|联系电话|20|", length = 20, nullable = true)
	private String phone;

	@Column(name = "VERIFY_STATE", columnDefinition = "VARCHAR2|审核状态|2|", length = 2, nullable = true)
	private String verifyState;

	@Column(name = "VERIFY_DATE", columnDefinition = "DATE|审核时间||", nullable = true)
	private Date verifyDate;

	@Column(name = "VERIFIER", columnDefinition = "VARCHAR2|审核人|20|", length = 20, nullable = true)
	private String verifier;

	@Column(name = "CREATE_TIME", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createTime;

	@Column(name = "CREATE_BY", columnDefinition = "VARCHAR2|创建者|50|", length = 50, nullable = true)
	private String createBy;

	@Column(name = "UPDATE_TIME", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date updateTime;

	@Column(name = "UPDATE_BY", columnDefinition = "VARCHAR2|更新者|50|", length = 50, nullable = true)
	private String updateBy;

	@Column(name = "IS_DELETE", columnDefinition = "INT|删除状态||", nullable = true)
	private Integer isDelete;

    @Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|创建机构|50|", length = 50, nullable = true)
    private String createOrganCode;

    @Column(name = "UPDATE_ORGAN_CODE", columnDefinition = "VARCHAR2|修改机构|50|", length = 50, nullable = true)
    private String updateOrganCode;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileNo() {
		return this.fileNo;
	}

	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}

	public String getHospitalName() {
		return this.hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getOrgCode() {
		return this.orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getHLevel() {
		return this.hLevel;
	}

	public void setHLevel(String hLevel) {
		this.hLevel = hLevel;
	}

	public String getLegalRepr() {
		return this.legalRepr;
	}

	public void setLegalRepr(String legalRepr) {
		this.legalRepr = legalRepr;
	}

	public String getProtectionHead() {
		return this.protectionHead;
	}

	public void setProtectionHead(String protectionHead) {
		this.protectionHead = protectionHead;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getVerifyState() {
		return this.verifyState;
	}

	public void setVerifyState(String verifyState) {
		this.verifyState = verifyState;
	}

	public Date getVerifyDate() {
		return this.verifyDate;
	}

	public void setVerifyDate(Date verifyDate) {
		this.verifyDate = verifyDate;
	}

	public String getVerifier() {
		return this.verifier;
	}

	public void setVerifier(String verifier) {
		this.verifier = verifier;
	}

	public String gethLevel() {
		return hLevel;
	}

	public void sethLevel(String hLevel) {
		this.hLevel = hLevel;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

    public String getCreateOrganCode() {
        return createOrganCode;
    }

    public void setCreateOrganCode(String createOrganCode) {
        this.createOrganCode = createOrganCode;
    }

    public String getUpdateOrganCode() {
        return updateOrganCode;
    }

    public void setUpdateOrganCode(String updateOrganCode) {
        this.updateOrganCode = updateOrganCode;
    }
}