package com.founder.rhip.mdm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "MDM_STAFF_ORG")
public class StaffOrg implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "STAFF_CODE", columnDefinition = "VARCHAR2|人员编号|10|", length = 10, nullable = false)
    private String staffCode;

	@Column(name = "SMPI_ID", columnDefinition = "VARCHAR2|人员主索引标识||", length = 50, nullable = false)
	private String smpiId;

	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|医疗卫生机构分类与代码||", length = 15, nullable = true)
	private String organCode;

	@Column(name = "DEPT_CODE", columnDefinition = "VARCHAR2|所在科室编码||", length = 5, nullable = true)
	private String deptCode;

	@Column(name = "LOCAL_ID", columnDefinition = "VARCHAR2|机构本地系统ID||", length = 50, nullable = true)
	private String localId;

	@Column(name = "WORK_ID_CARD", columnDefinition = "VARCHAR2|工作证号||", length = 20, nullable = true)
	private String workIdCard;

	@Column(name = "CARD_NUM", columnDefinition = "VARCHAR2|胸牌号||", length = 20, nullable = true)
	private String cardNum;

    @Column(name = "IS_MAIN", columnDefinition = "VARCHAR2|是否兼职单位 1是 0否||", length = 20, nullable = true)
    private String IS_MAIN = "0";

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

	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getLocalId() {
		return localId;
	}

	public void setLocalId(String localId) {
		this.localId = localId;
	}

	public String getIS_MAIN() {
		return IS_MAIN;
	}

	public void setIS_MAIN(String IS_MAIN) {
		this.IS_MAIN = IS_MAIN;
	}

	public String getWorkIdCard() {
		return workIdCard;
	}

	public void setWorkIdCard(String workIdCard) {
		this.workIdCard = workIdCard;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
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