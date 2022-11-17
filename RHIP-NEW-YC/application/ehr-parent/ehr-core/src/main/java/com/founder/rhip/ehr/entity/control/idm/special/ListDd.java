package com.founder.rhip.ehr.entity.control.idm.special;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "IDM_LIST_DD")
public class ListDd implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|自增长id|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|传染病唯一编码|11|", length = 11, nullable = false)
	private Long idmId;

	@Column(name = "RECORD_DATE", columnDefinition = "DATE|记录日期||", nullable = true)
	private Date recordDate;

	@Column(name = "REPAIR_TREAT_NUMBER", columnDefinition = "VARCHAR2|补治次数|20|", length = 20, nullable = true)
	private String repairTreatNumber;

	@Column(name = "BROKEN_NUM", columnDefinition = "VARCHAR2|断药次数|20|", length = 20, nullable = true)
	private String brokenNum;

	@Column(name = "LEAKAGE_NUM", columnDefinition = "VARCHAR2|漏治次数|20|", length = 20, nullable = true)
	private String leakageNum;

	@Column(name = "LEAKAGE_REASON", columnDefinition = "VARCHAR2|断治原因|20|", length = 20, nullable = true)
	private String leakageReason;

	@Column(name = "CREATE_UNIT", columnDefinition = "VARCHAR2|新增单位||", length = 100, nullable = true)
	private String createUnit;

	@Column(name = "CREATE_DT", columnDefinition = "DATE|新增时间||", nullable = true)
	private Date createDt;

	@Column(name = "CREATE_USER", columnDefinition = "VARCHAR2|新增人||", length = 50, nullable = true)
	private String createUser;

	@Column(name = "MODIFY_UNIT", columnDefinition = "VARCHAR2|修改单位||", length = 100, nullable = true)
	private String modifyUnit;

	@Column(name = "MODIFY_DT", columnDefinition = "DATE|修改时间||", nullable = true)
	private Date modifyDt;

	@Column(name = "MODIFY_USER", columnDefinition = "VARCHAR2|修改人||", length = 50, nullable = true)
	private String mofigyUser;

	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除标识||", length = 1, nullable = true)
	private Integer isDelete;

	@Column(name = "FLAG", columnDefinition = "VARCHAR2|类型||", length = 20, nullable = true)
	private String flag;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdmId() {
		return this.idmId;
	}

	public void setIdmId(Long idmId) {
		this.idmId = idmId;
	}

	public Date getRecordDate() {
		return this.recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public String getRepairTreatNumber() {
		return this.repairTreatNumber;
	}

	public void setRepairTreatNumber(String repairTreatNumber) {
		this.repairTreatNumber = repairTreatNumber;
	}

	public String getBrokenNum() {
		return this.brokenNum;
	}

	public void setBrokenNum(String brokenNum) {
		this.brokenNum = brokenNum;
	}

	public String getLeakageNum() {
		return this.leakageNum;
	}

	public void setLeakageNum(String leakageNum) {
		this.leakageNum = leakageNum;
	}

	public String getLeakageReason() {
		return this.leakageReason;
	}

	public void setLeakageReason(String leakageReason) {
		this.leakageReason = leakageReason;
	}

	public String getCreateUnit() {
		return this.createUnit;
	}

	public void setCreateUnit(String createUnit) {
		this.createUnit = createUnit;
	}

	public Date getCreateDt() {
		return this.createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getModifyUnit() {
		return this.modifyUnit;
	}

	public void setModifyUnit(String modifyUnit) {
		this.modifyUnit = modifyUnit;
	}

	public Date getModifyDt() {
		return this.modifyDt;
	}

	public void setModifyDt(Date modifyDt) {
		this.modifyDt = modifyDt;
	}

	public String getMofigyUser() {
		return this.mofigyUser;
	}

	public void setMofigyUser(String mofigyUser) {
		this.mofigyUser = mofigyUser;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}