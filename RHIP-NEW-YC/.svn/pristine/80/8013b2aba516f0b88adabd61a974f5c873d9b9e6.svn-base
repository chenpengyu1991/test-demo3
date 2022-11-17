package com.founder.rhip.ehr.entity.control.idm.special;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "IDM_LIST_SD")
public class ListSd implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = false)
	private Long id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|本系统唯一编码||", length = 11, nullable = false)
	private Long idmId;

	@Column(name = "DRUG_CARD_ID", columnDefinition = "NUMBER|服药卡ID||", length = 11, nullable = false)
	private Long drugCardId;

	@Column(name = "MONTH_NO", columnDefinition = "NUMBER|月序||", length = 2, nullable = true)
	private Integer monthNo;

	@Column(name = "DAY_NO", columnDefinition = "NUMBER|日期||", length = 2, nullable = true)
	private Integer dayNo;

	@Column(name = "DRUD_TYPE", columnDefinition = "VARCHAR2|服药状态||", length = 2, nullable = true)
	private String drudType;

	@Column(name = "DRUG_DT", columnDefinition = "DATE|用药时间||", length = 20, nullable = true)
	private Date drugDt;

	@Column(name = "DRUG_NAME", columnDefinition = "VARCHAR2|药物名称||", length = 200, nullable = true)
	private String drugName;

	@Column(name = "ADULT_METERING", columnDefinition = "VARCHAR2|成人计量||", length = 20, nullable = true)
	private String adultMetering;

	@Column(name = "AGE_DOSE", columnDefinition = "VARCHAR2|年龄组用药量||", length = 2, nullable = true)
	private String ageDose;

	@Column(name = "PRACTICAL_METERING", columnDefinition = "VARCHAR2|实用计量||", length = 20, nullable = true)
	private String practicalMetering;

	@Column(name = "TOTAL_NUM", columnDefinition = "VARCHAR2|总量||", length = 20, nullable = true)
	private String totalNum;

	@Column(name = "TROCHE_NUM", columnDefinition = "VARCHAR2|片数||", length = 20, nullable = true)
	private String trocheNum;

	@Column(name = "METHOD_DETAIL", columnDefinition = "VARCHAR2|服用方法||", length = 200, nullable = true)
	private String methodDetail;

	@Column(name = "PATIENT_NAME", columnDefinition = "VARCHAR2|患者本人签名||", length = 50, nullable = true)
	private String patientName;

	@Column(name = "CREATE_UNIT", columnDefinition = "VARCHAR2|新增机构||", length = 100, nullable = true)
	private String createUnit;

	@Column(name = "CREATE_DT", columnDefinition = "DATE|新增时间||", length = 2, nullable = true)
	private Date createDt;

	@Column(name = "CREATE_USER", columnDefinition = "VARCHAR2|新增人||", length = 50, nullable = true)
	private String createUser;

	@Column(name = "MODIFY_UNIT", columnDefinition = "VARCHAR2|修改机构||", length = 100, nullable = true)
	private String modifyUnit;

	@Column(name = "MODIFY_DT", columnDefinition = "DATE|修改时间||", length = 50, nullable = true)
	private Date modifyDt;

	@Column(name = "MODIFY_USER", columnDefinition = "VARCHAR2|修改人||", length = 50, nullable = true)
	private String mofigyUser;

	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除标识||", length = 1, nullable = true)
	private Integer isDelete;

	@Column(name = "FLAG", columnDefinition = "VARCHAR2|类型||0:非耐多药患者 1:耐多药患者", length = 20, nullable = true)
	private String flag;

    @Column(name = "DRUG_DOCTOR", columnDefinition = "VARCHAR2|督导人||", length = 50, nullable = true)
    private String drugDoctor;

	public Long getDrugCardId() {
		return drugCardId;
	}

	public void setDrugCardId(Long drugCardId) {
		this.drugCardId = drugCardId;
	}

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

	public Integer getMonthNo() {
		return this.monthNo;
	}

	public void setMonthNo(Integer monthNo) {
		this.monthNo = monthNo;
	}

	public Integer getDayNo() {
		return this.dayNo;
	}

	public void setDayNo(Integer dayNo) {
		this.dayNo = dayNo;
	}

    public String getDrudType() {
        return drudType;
    }

    public void setDrudType(String drudType) {
        this.drudType = drudType;
    }

    public Date getDrugDt() {
		return this.drugDt;
	}

	public void setDrugDt(Date drugDt) {
		this.drugDt = drugDt;
	}

	public String getDrugName() {
		return this.drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getAdultMetering() {
		return this.adultMetering;
	}

	public void setAdultMetering(String adultMetering) {
		this.adultMetering = adultMetering;
	}

	public String getAgeDose() {
		return this.ageDose;
	}

	public void setAgeDose(String ageDose) {
		this.ageDose = ageDose;
	}

	public String getPracticalMetering() {
		return this.practicalMetering;
	}

	public void setPracticalMetering(String practicalMetering) {
		this.practicalMetering = practicalMetering;
	}

	public String getTotalNum() {
		return this.totalNum;
	}

	public void setTotalNum(String totalNum) {
		this.totalNum = totalNum;
	}

	public String getTrocheNum() {
		return this.trocheNum;
	}

	public void setTrocheNum(String trocheNum) {
		this.trocheNum = trocheNum;
	}

	public String getMethodDetail() {
		return this.methodDetail;
	}

	public void setMethodDetail(String methodDetail) {
		this.methodDetail = methodDetail;
	}

	public String getPatientName() {
		return this.patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
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

    public String getDrugDoctor() {
        return this.drugDoctor;
    }

    public void setDrugDoctor(String drugDoctor) {
        this.drugDoctor = drugDoctor;
    }
}