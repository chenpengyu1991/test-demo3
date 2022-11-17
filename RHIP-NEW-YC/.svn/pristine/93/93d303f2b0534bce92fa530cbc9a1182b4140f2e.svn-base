package com.founder.rhip.mdm.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@Entity
@Table(name = "MDM_STAFF_HONOR")
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class StaffHonor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = false)
    private Long id;

	@Column(name = "STAFF_CODE", columnDefinition = "VARCHAR2|人员编号|10|", length = 10, nullable = true)
	private String staffCode;

	@Column(name = "SMPI_ID", columnDefinition = "VARCHAR2|人员主索引标识||", length = 50, nullable = true)
	private String smpiId;

	@Column(name = "ID_CARD", columnDefinition = "VARCHAR2|身份证号||", length = 20, nullable = true)
	private String idCard;

	@Column(name = "HONOR_ADDR", columnDefinition = "VARCHAR2|执业地点||", length = 100, nullable = true)
	private String honorAddr;

	@Column(name = "HONOR_UNIT", columnDefinition = "VARCHAR2|授予荣誉机构||", length = 100, nullable = true)
	private String honorUnit;

	@Column(name = "HONOR_CONTENT", columnDefinition = "VARCHAR2|荣誉内容||", length = 100, nullable = true)
	private String honorContent;

	@Column(name = "HONOR_DATE", columnDefinition = "VARCHAR2|授予荣誉时间||", length = 50, nullable = true)
	private String honorDate;

	@Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|创建（更新）机构编码||", length = 50, nullable = true)
	private String createOrganCode;

	@Column(name = "CREATE_ORGAN_NAME", columnDefinition = "VARCHAR2|创建（更新）机构名称||", length = 100, nullable = true)
	private String createOrganName;

	@Column(name = "CREATE_USER_ID", columnDefinition = "VARCHAR2|创建（更新）人员编码||", length = 50, nullable = true)
	private String createUserId;

	@Column(name = "CREATE_USER_NAME", columnDefinition = "VARCHAR2|创建（更新）人员名称||", length = 100, nullable = true)
	private String createUserName;

    @Column(name = "CREATE_DATE", columnDefinition = "DATE|创建（更新）时间||", nullable = true)
    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public String getSmpiId() {
        return smpiId;
    }

    public void setSmpiId(String smpiId) {
        this.smpiId = smpiId;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getHonorAddr() {
        return honorAddr;
    }

    public void setHonorAddr(String honorAddr) {
        this.honorAddr = honorAddr;
    }

    public String getHonorUnit() {
        return honorUnit;
    }

    public void setHonorUnit(String honorUnit) {
        this.honorUnit = honorUnit;
    }

    public String getHonorContent() {
        return honorContent;
    }

    public void setHonorContent(String honorContent) {
        this.honorContent = honorContent;
    }

    public String getHonorDate() {
        return honorDate;
    }

    public void setHonorDate(String honorDate) {
        this.honorDate = honorDate;
    }

    public String getCreateOrganCode() {
        return createOrganCode;
    }

    public void setCreateOrganCode(String createOrganCode) {
        this.createOrganCode = createOrganCode;
    }

    public String getCreateOrganName() {
        return createOrganName;
    }

    public void setCreateOrganName(String createOrganName) {
        this.createOrganName = createOrganName;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}