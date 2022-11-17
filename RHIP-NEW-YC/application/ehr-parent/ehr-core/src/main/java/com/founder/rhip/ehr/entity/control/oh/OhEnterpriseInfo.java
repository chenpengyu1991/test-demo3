package com.founder.rhip.ehr.entity.control.oh;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "OH_ENTERPRISE_INFO")
public class OhEnterpriseInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "FILE_NO", columnDefinition = "VARCHAR2|档案号|20|", length = 20, nullable = true)
	private String fileNo;

	@Column(name = "COMPANY_NAME", columnDefinition = "VARCHAR2|企业名称|50|", length = 50, nullable = true)
	private String companyName;

	@Column(name = "ORG_CODE", columnDefinition = "VARCHAR2|组织机构代码|18|", length = 18, nullable = true)
	private String orgCode;

	@Column(name = "ADDR", columnDefinition = "VARCHAR2|地址|50|", length = 50, nullable = true)
	private String addr;

	@Column(name = "POSTCODE", columnDefinition = "VARCHAR2|邮编|50|", length = 50, nullable = true)
	private String postcode;

	@Column(name = "ECONOMIC_TYPE", columnDefinition = "VARCHAR2|经济类型|50|", length = 50, nullable = true)
	private String economicType;

	@Column(name = "INDUSTRY_TYPE", columnDefinition = "VARCHAR2|行业分类|50|", length = 50, nullable = true)
	private String industryType;

	@Column(name = "FOUNDED_DATE", columnDefinition = "DATE|创立时间||", nullable = true)
	private Date foundedDate;

	@Column(name = "LEGAL_REPR", columnDefinition = "VARCHAR2|法人代表|20|", length = 20, nullable = true)
	private String legalRepr;

	@Column(name = "CONTACTS_DEPT", columnDefinition = "VARCHAR2|联系部门|20|", length = 20, nullable = true)
	private String contactsDept;

	@Column(name = "CONTACTS_NAME", columnDefinition = "VARCHAR2|联系人|20|", length = 20, nullable = true)
	private String contactsName;

	@Column(name = "POSITION", columnDefinition = "VARCHAR2|职务|20|", length = 20, nullable = true)
	private String position;

	@Column(name = "PHONE", columnDefinition = "VARCHAR2|固定电话|20|", length = 20, nullable = true)
	private String phone;

	@Column(name = "MOBILEPHONE", columnDefinition = "VARCHAR2|手机|20|", length = 20, nullable = true)
	private String mobilephone;

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

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getEconomicType() {
		return this.economicType;
	}

	public void setEconomicType(String economicType) {
		this.economicType = economicType;
	}

	public String getIndustryType() {
		return this.industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

	public Date getFoundedDate() {
		return this.foundedDate;
	}

	public void setFoundedDate(Date foundedDate) {
		this.foundedDate = foundedDate;
	}

	public String getLegalRepr() {
		return this.legalRepr;
	}

	public void setLegalRepr(String legalRepr) {
		this.legalRepr = legalRepr;
	}

	public String getContactsDept() {
		return this.contactsDept;
	}

	public void setContactsDept(String contactsDept) {
		this.contactsDept = contactsDept;
	}

	public String getContactsName() {
		return this.contactsName;
	}

	public void setContactsName(String contactsName) {
		this.contactsName = contactsName;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobilephone() {
		return this.mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
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

}