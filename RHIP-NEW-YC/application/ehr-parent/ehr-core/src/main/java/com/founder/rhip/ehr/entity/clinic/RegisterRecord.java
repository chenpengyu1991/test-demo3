package com.founder.rhip.ehr.entity.clinic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.util.Date;

@Entity
@Table(name = "MS_REGISTER_RECORD")
public class RegisterRecord implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;
    
	@Column(name = "OUTPATIENT_NO", columnDefinition = "VARCHAR2|门诊号||", length = 18, nullable = true)
	private String outpatientNo;

	@Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = true)
	private String ehrId;

	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|个人信息唯一编号||", length = 11, nullable = true)
	private Long personId;

	@Column(name = "HEALTH_FILE_NO", columnDefinition = "VARCHAR2|城乡居民健康档案编号||", length = 17, nullable = true)
	private String healthFileNo;

	@Column(name = "OTHERCARDTYPE", columnDefinition = "VARCHAR2|其他就医卡证类型||", length = 2, nullable = true)
	private String othercardtype;

	@Column(name = "OTHERCARDNO", columnDefinition = "VARCHAR2|其他就医卡证号码||", length = 24, nullable = true)
	private String othercardno;

	@Column(name = "DPT_CODE", columnDefinition = "VARCHAR2|就诊科室||", length = 24, nullable = true)
	private String dptCode;

	@Column(name = "EXPERT_IDCARD", columnDefinition = "VARCHAR2|就诊专家身份证号||", length = 18, nullable = true)
	private String expertIdcard;

	@Column(name = "VISIT_DATE", columnDefinition = "DATE|就诊日期||", nullable = true)
	private Date visitDate;

	@Column(name = "VISIT_TIME", columnDefinition = "VARCHAR2|就诊时间||", length = 1, nullable = true)
	private String visitTime = "0";

	@Column(name = "OP_EM_MARK", columnDefinition = "VARCHAR2|门诊/急诊标志||", length = 1, nullable = true)
	private String opEmMark;

	@Column(name = "OP_EM_NO", columnDefinition = "VARCHAR2|门诊/急诊编号||", length = 20, nullable = true)
	private String opEmNo;

	@Column(name = "OP_EM_SD_NO", columnDefinition = "VARCHAR2|门诊/急诊顺序号||", length = 6, nullable = true)
	private String opEmSdNo;

	@Column(name = "REGI_FEE", columnDefinition = "NUMBER|挂号费用||", length = 10, scale = 1 , nullable = true)
	private Double regiFee;

	@Column(name = "IND_PAY", columnDefinition = "NUMBER|个人支付挂号费用||", length = 10, scale = 1, nullable = true)
	private Double indPay;

	@Column(name = "VISIT_STATUS", columnDefinition = "VARCHAR2|就诊状态||", length = 1, nullable = true)
	private String visitStatus;
	
	@Column(name = "REC_IDCARD", columnDefinition = "VARCHAR2|填报人身份证号||", length = 18, nullable = true)
	private String recIdcard;
	
	@Column(name = "REC_DT", columnDefinition = "DATE|填报时间||", nullable = true)
	private Date recDt;

	@Column(name = "FILL_USER_NAME", columnDefinition = "VARCHAR2|填报人姓名||", length = 50, nullable = true)
	private String fillUserName;

	@Column(name = "UPDATE_DATE", columnDefinition = "DATE|更新日期和时间||", nullable = true)
	private Date updateDate;

	@Column(name = "UPDATE_NAME", columnDefinition = "VARCHAR2|更新人姓名||", length = 50, nullable = true)
	private String updateName;

	@Column(name = "UPDATE_IDCARD", columnDefinition = "VARCHAR2|更新人身份证号||", length = 18, nullable = true)
	private String updateIdcard;
	
	@Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|填报机构代码||", length = 20, nullable = true)
	private String createOrganCode;

	@Column(name = "CREATE_ORGAN_NAME", columnDefinition = "VARCHAR2|填报机构名称||", length = 70, nullable = true)
	private String createOrganName;

	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除状态||", length = 1, nullable = true)
	private Long isDelete;
	
	@Column(name = "PROCESS_STATUS", columnDefinition = "VARCHAR2|处理状态||", length = 1, nullable = true)
	private String processStatus = "0";
	
    @Column(name = "IS_LIMIT", columnDefinition = "NUMBER|是否限制||", length = 1, nullable = true)
    private Integer isLimit = -1;

	@Column(name = "MEDICAL_COST_PAY_WAY", columnDefinition = "VARCHAR2|医疗费用支付方式代码|CV0710003|", length = 2, nullable = true)
	private String medicalCostPayWay;

	@Column(name = "IS_WITHDRAWAL", columnDefinition = "VARCHAR2|是否退号|0:未退号 1:退号 若为空按照未退号处理|", length = 2, nullable = true)
	private String isWithdrawal;

	@Column(name = "DOCTOR_NAME", columnDefinition = "VARCHAR2|就诊专家/医生的姓名||", length = 2, nullable = true)
	private String doctorName;

	@Column(name = "DOCTOR_NO", columnDefinition = "VARCHAR2|就诊专家/医生的工号||", length = 2, nullable = true)
	private String doctorNo;

	@Column(name = "GATHER_DATE", columnDefinition = "DATE|采集时间||", nullable = true)
	private Date gatherDate;
    
    @Transient
    private String recDtDesc;
    
    @Transient
    private String opEmMarkDesc;
    
    @Transient
    private String visitStatusDesc;

	public String getOutpatientNo() {
		return this.outpatientNo;
	}

	public void setOutpatientNo(String outpatientNo) {
		this.outpatientNo = outpatientNo;
	}

	public String getEhrId() {
		return this.ehrId;
	}

	public void setEhrId(String ehrId) {
		this.ehrId = ehrId;
	}

	public Long getPersonId() {
		return this.personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getHealthFileNo() {
		return this.healthFileNo;
	}

	public void setHealthFileNo(String healthFileNo) {
		this.healthFileNo = healthFileNo;
	}

	public String getOthercardtype() {
		return this.othercardtype;
	}

	public void setOthercardtype(String othercardtype) {
		this.othercardtype = othercardtype;
	}

	public String getOthercardno() {
		return this.othercardno;
	}

	public void setOthercardno(String othercardno) {
		this.othercardno = othercardno;
	}

	public String getDptCode() {
		return this.dptCode;
	}

	public void setDptCode(String dptCode) {
		this.dptCode = dptCode;
	}

	public String getExpertIdcard() {
		return this.expertIdcard;
	}

	public void setExpertIdcard(String expertIdcard) {
		this.expertIdcard = expertIdcard;
	}

	public Date getVisitDate() {
		return this.visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public String getVisitTime() {
		return this.visitTime;
	}

	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}

	public String getOpEmMark() {
		return this.opEmMark;
	}

	public void setOpEmMark(String opEmMark) {
		this.opEmMark = opEmMark;
	}

	public String getOpEmNo() {
		return this.opEmNo;
	}

	public void setOpEmNo(String opEmNo) {
		this.opEmNo = opEmNo;
	}

	public String getOpEmSdNo() {
		return this.opEmSdNo;
	}

	public void setOpEmSdNo(String opEmSdNo) {
		this.opEmSdNo = opEmSdNo;
	}

	public Double getRegiFee() {
		return this.regiFee;
	}

	public void setRegiFee(Double regiFee) {
		this.regiFee = regiFee;
	}

	public Double getIndPay() {
		return this.indPay;
	}

	public void setIndPay(Double indPay) {
		this.indPay = indPay;
	}

	public String getVisitStatus() {
		return this.visitStatus;
	}

	public void setVisitStatus(String visitStatus) {
		this.visitStatus = visitStatus;
	}

	public Long getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Long isDelete) {
		this.isDelete = isDelete;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	public String getUpdateIdcard() {
		return updateIdcard;
	}

	public void setUpdateIdcard(String updateIdcard) {
		this.updateIdcard = updateIdcard;
	}

	public Date getRecDt() {
		return recDt;
	}

	public void setRecDt(Date recDt) {
		this.recDt = recDt;
	}

	public String getRecIdcard() {
		return recIdcard;
	}

	public void setRecIdcard(String recIdcard) {
		this.recIdcard = recIdcard;
	}

	public String getFillUserName() {
		return fillUserName;
	}

	public void setFillUserName(String fillUserName) {
		this.fillUserName = fillUserName;
	}

	
	public String getProcessStatus() {
		return processStatus;
	}

	
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	
	public Integer getIsLimit() {
		return isLimit;
	}

	
	public void setIsLimit(Integer isLimit) {
		this.isLimit = isLimit;
	}

	
	public String getRecDtDesc() {
		return recDtDesc;
	}

	
	public void setRecDtDesc(String recDtDesc) {
		this.recDtDesc = recDtDesc;
	}

	
	public String getOpEmMarkDesc() {
		return opEmMarkDesc;
	}

	
	public void setOpEmMarkDesc(String opEmMarkDesc) {
		this.opEmMarkDesc = opEmMarkDesc;
	}

	
	public String getVisitStatusDesc() {
		return visitStatusDesc;
	}

	
	public void setVisitStatusDesc(String visitStatusDesc) {
		this.visitStatusDesc = visitStatusDesc;
	}

	public Date getGatherDate() {
		return gatherDate;
	}

	public void setGatherDate(Date gatherDate) {
		this.gatherDate = gatherDate;
	}

	public String getMedicalCostPayWay() {
		return medicalCostPayWay;
	}

	public void setMedicalCostPayWay(String medicalCostPayWay) {
		this.medicalCostPayWay = medicalCostPayWay;
	}

	public String getIsWithdrawal() {
		return isWithdrawal;
	}

	public void setIsWithdrawal(String isWithdrawal) {
		this.isWithdrawal = isWithdrawal;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorNo() {
		return doctorNo;
	}

	public void setDoctorNo(String doctorNo) {
		this.doctorNo = doctorNo;
	}
}