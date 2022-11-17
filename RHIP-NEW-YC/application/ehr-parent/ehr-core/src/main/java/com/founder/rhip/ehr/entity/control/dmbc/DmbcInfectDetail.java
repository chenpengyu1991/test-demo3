package com.founder.rhip.ehr.entity.control.dmbc;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.DecimalFormat;
import java.util.Date;

@Entity
@Table(name = "DMBC_INFECT_DETAIL")
public class DmbcInfectDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, scale = 11, nullable = true)
	private Long id;

	@Column(name = "MONITOR_ID", columnDefinition = "NUMBER|院内感染监测ID||", length = 11, scale = 11, nullable = true)
	private Long monitorId;

	@Column(name = "DEPT_NAME", columnDefinition = "VARCHAR2|科室名称||", length = 40, scale = 40, nullable = true)
	private String deptName;

	@Column(name = "SPOT_CHECK_NUM", columnDefinition = "NUMBER|抽查病例数||", length = 11, scale = 11, nullable = true)
	private Long spotCheckNum;

	@Column(name = "BREATHING_SYS", columnDefinition = "NUMBER|呼吸系统||", length = 11, scale = 11, nullable = true)
	private Long breathingSys;

	@Column(name = "CARDIOVASCULAR_SYS", columnDefinition = "NUMBER|心血管系统||", length = 11, scale = 11, nullable = true)
	private Long cardiovascularSys;

	@Column(name = "URINARY_SYS", columnDefinition = "NUMBER|泌尿系统||", length = 11, scale = 11, nullable = true)
	private Long urinarySys;

	@Column(name = "DIGESTIVE_SYS_ABDOMEN", columnDefinition = "NUMBER|消化系统和腹部||", length = 11, scale = 11, nullable = true)
	private Long digestiveSysAbdomen;

	@Column(name = "BLOOD_SYS", columnDefinition = "NUMBER|血液系统||", length = 11, scale = 11, nullable = true)
	private Long bloodSys;

	@Column(name = "CNS", columnDefinition = "NUMBER|中枢神经系统||", length = 11, scale = 11, nullable = true)
	private Long cns;

	@Column(name = "SKIN_SOFTTISSTLE", columnDefinition = "NUMBER|皮肤与软组织||", length = 11, scale = 11, nullable = true)
	private Long skinSofttisstle;

	@Column(name = "RTI", columnDefinition = "NUMBER|生殖道||", length = 11, scale = 11, nullable = true)
	private Long rti;

	@Column(name = "SSI", columnDefinition = "NUMBER|手术部位||", length = 11, scale = 11, nullable = true)
	private Long ssi;

	@Column(name = "ORAL", columnDefinition = "NUMBER|口腔||", length = 11, scale = 11, nullable = true)
	private Long oral;

	@Column(name = "BONE_JOINT", columnDefinition = "NUMBER|骨和关节||", length = 11, scale = 11, nullable = true)
	private Long boneJoint;

	@Column(name = "OTHER_PARTS", columnDefinition = "NUMBER|其他部位||", length = 11, scale = 11, nullable = true)
	private Long otherParts;

	@Column(name = "TOTAL", columnDefinition = "NUMBER|合计||", length = 11, scale = 11, nullable = true)
	private Long total;

	@Column(name = "REMARKS", columnDefinition = "VARCHAR2|备注||", length = 40, scale = 40, nullable = true)
	private String remarks;

	@Column(name = "CREATE_TIME", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createTime;

	@Column(name = "CREATE_BY", columnDefinition = "VARCHAR2|创建者||", length = 20, scale = 20, nullable = true)
	private String createBy;

	@Column(name = "UPDATE_TIME", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date updateTime;

	@Column(name = "UPDATE_BY", columnDefinition = "VARCHAR2|更新者||", length = 20, scale = 20, nullable = true)
	private String updateBy;

	@Column(name = "IS_DELETE", columnDefinition = "INT|删除状态||", nullable = true)
	private Integer isDelete;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMonitorId() {
		return this.monitorId;
	}

	public void setMonitorId(Long monitorId) {
		this.monitorId = monitorId;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Long getSpotCheckNum() {
		return this.spotCheckNum;
	}

	public void setSpotCheckNum(Long spotCheckNum) {
		this.spotCheckNum = spotCheckNum;
	}

	public Long getBreathingSys() {
		return breathingSys;
	}

	public void setBreathingSys(Long breathingSys) {
		this.breathingSys = breathingSys;
	}

	public Long getCardiovascularSys() {
		return cardiovascularSys;
	}

	public void setCardiovascularSys(Long cardiovascularSys) {
		this.cardiovascularSys = cardiovascularSys;
	}

	public Long getUrinarySys() {
		return this.urinarySys;
	}

	public void setUrinarySys(Long urinarySys) {
		this.urinarySys = urinarySys;
	}

	public Long getDigestiveSysAbdomen() {
		return this.digestiveSysAbdomen;
	}

	public void setDigestiveSysAbdomen(Long digestiveSysAbdomen) {
		this.digestiveSysAbdomen = digestiveSysAbdomen;
	}

	public Long getBloodSys() {
		return this.bloodSys;
	}

	public void setBloodSys(Long bloodSys) {
		this.bloodSys = bloodSys;
	}

	public Long getCns() {
		return this.cns;
	}

	public void setCns(Long cns) {
		this.cns = cns;
	}

	public Long getSkinSofttisstle() {
		return this.skinSofttisstle;
	}

	public void setSkinSofttisstle(Long skinSofttisstle) {
		this.skinSofttisstle = skinSofttisstle;
	}

	public Long getRti() {
		return this.rti;
	}

	public void setRti(Long rti) {
		this.rti = rti;
	}

	public Long getSsi() {
		return this.ssi;
	}

	public void setSsi(Long ssi) {
		this.ssi = ssi;
	}

	public Long getOral() {
		return this.oral;
	}

	public void setOral(Long oral) {
		this.oral = oral;
	}

	public Long getBoneJoint() {
		return this.boneJoint;
	}

	public void setBoneJoint(Long boneJoint) {
		this.boneJoint = boneJoint;
	}

	public Long getOtherParts() {
		return this.otherParts;
	}

	public void setOtherParts(Long otherParts) {
		this.otherParts = otherParts;
	}

	public Long getTotal() {
		return this.total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateBy() {
		return this.updateBy;
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

	public String getInfectionRate() {
		double rate = total * 1.0 / spotCheckNum * 1.0;
		DecimalFormat df = new DecimalFormat("0.00%");
		return df.format(rate);
	}
}