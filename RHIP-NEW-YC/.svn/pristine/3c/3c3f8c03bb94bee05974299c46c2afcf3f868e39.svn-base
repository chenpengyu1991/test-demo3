package com.founder.rhip.ehr.entity.management;

import com.founder.rhip.ehr.service.export.Item;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "DM_REPORT_INFO")
public class DmReportInfo implements Serializable {

	private static final long serialVersionUID = -2969663235898012052L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = true)
	private Long id;

	@Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = true)
	private String ehrId;

	@Column(name = "CDM_ID", columnDefinition = "NUMBER|状态表ID|11|", length = 11, nullable = false)
	private Integer cdmId;

	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|个人信息唯一编号||", length = 11, nullable = true)
	private Long personId;

	@Column(name = "DM_PERSON_ID", columnDefinition = "NUMBER|报卡人员信息唯一编号||", length = 11, nullable = true)
	private Long dmPersonId;

    @Item(index=2,column ="身份证件号码")
	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|居民身份证/健康卡号||", length = 18, nullable = true)
	private String idcard;

    @Item(column = "患病类型",isDic = true,index = 5,dicType = "DMD00004")
	@Column(name = "DIS_TYPE", columnDefinition = "VARCHAR2|慢病类型||", length = 1, nullable = true)
	private String disType;
	
	@Column(name = "SUB_DIS_TYPE", columnDefinition = "VARCHAR2|二级慢病类型||", length = 1, nullable = true)
	private String subDisType;

	@Column(name = "HBP_TYPE", columnDefinition = "VARCHAR2|高血压类型||", length = 1, nullable = true)
	private String hbpType;

	@Column(name = "HBP_ICD_TEN_CODE", columnDefinition = "VARCHAR2|高血压ICD-10编码||", length = 8, nullable = true)
	private String hbpIcdTenCode;

	@Column(name = "HBP_ACCIDENT_DATE", columnDefinition = "DATE|高血压发病日期||", nullable = true)
	private Date hbpAccidentDate;

	@Column(name = "HBP_DIAGNOSIS_DATE", columnDefinition = "DATE|高血压诊断日期||", nullable = true)
	private Date hbpDiagnosisDate;

	@Column(name = "HBP_DIAGNOSIS_DEPENDS", columnDefinition = "VARCHAR2|高血压诊断依据(多选)||", length = 100, nullable = true)
	private String hbpDiagnosisDepends;

	@Column(name = "DI_TYPE", columnDefinition = "VARCHAR2|糖尿病类型||", length = 1, nullable = true)
	private String diType;

	@Column(name = "DI_ICD_TEN_CODE", columnDefinition = "VARCHAR2|糖尿病ICD-10编码||", length = 8, nullable = true)
	private String diIcdTenCode;

	@Column(name = "DI_ACCIDENT_DATE", columnDefinition = "DATE|糖尿病发病日期||", nullable = true)
	private Date diAccidentDate;

	@Column(name = "DI_DIAGNOSIS_DATE", columnDefinition = "DATE|糖尿病诊断日期||", nullable = true)
	private Date diDiagnosisDate;

	@Column(name = "DI_DIAGNOSIS_DEPENDS", columnDefinition = "VARCHAR2|糖尿病诊断依据(多选)||", length = 100, nullable = true)
	private String diDiagnosisDepends;

	@Column(name = "STROKE_TYPE", columnDefinition = "VARCHAR2|脑卒中类型||", length = 1, nullable = true)
	private String strokeType;

	@Column(name = "STROKE_ICD_TEN_CODE", columnDefinition = "VARCHAR2|脑卒中ICD-10编码||", length = 8, nullable = true)
	private String strokeIcdTenCode;

	@Column(name = "STROKE_ACCIDENT_DATE", columnDefinition = "DATE|脑卒中类型发病日期||", nullable = true)
	private Date strokeAccidentDate;

	@Column(name = "STROKE_DIAGNOSIS_DATE", columnDefinition = "DARE|脑卒中类型诊断日期||", nullable = true)
	private Date strokeDiagnosisDate;

	@Column(name = "STROKE_DIAGNOSIS_DEPENDS", columnDefinition = "VARCHAR2|脑卒中类型诊断依据(多选)||", length = 100, nullable = true)
	private String strokeDiagnosisDepends;

	@Column(name = "CORONARY_TYPE", columnDefinition = "VARCHAR2|冠心病类型||", length = 1, nullable = true)
	private String coronaryType;

	@Column(name = "CORONARY_ICD_TEN_CODE", columnDefinition = "VARCHAR2|冠心病ICD-10编码||", length = 8, nullable = true)
	private String coronaryIcdTenCode;

	@Column(name = "CORONARY_ACCIDENT_DATE", columnDefinition = "DATE|冠心病类型发病日期||", nullable = true)
	private Date coronaryAccidentDate;

	@Column(name = "CORONARY_DIAGNOSIS_DATE", columnDefinition = "DATE|冠心病中类型诊断日期||", nullable = true)
	private Date coronaryDiagnosisDate;

	@Column(name = "CORONARY_DIAGNOSIS_DEPENDS", columnDefinition = "VARCHAR2|冠心病类型诊断依据(多选)||", length = 100, nullable = true)
	private String coronaryDiagnosisDepends;

	@Column(name = "TUMOR_TYPE", columnDefinition = "VARCHAR2|肿瘤病名||", length = 50, nullable = true)
	private String tumorType;

	@Column(name = "TUMOR_ICD_TEN_CODE", columnDefinition = "VARCHAR2|ICD-10编码||", length = 8, nullable = true)
	private String tumorIcdTenCode;

	@Column(name = "TUMOR_ICD_TEN_NAME", columnDefinition = "VARCHAR2|ICD-10名称||", length = 50, nullable = true)
	private String tumorIcdTenName;

	@Column(name = "TUMOR_PRIMARY_PART", columnDefinition = "VARCHAR2|原发部位||", length = 100, nullable = true)
	private String tumorPrimaryPart;

	@Column(name = "TUMOR_METASTASIS_PART", columnDefinition = "VARCHAR2|肿瘤患者转移部位||", length = 100, nullable = true)
	private String tumorMetastasisPart;

	@Column(name = "TUMOR_DIAGNOSIS_DEPENDS", columnDefinition = "VARCHAR2|诊断依据||", length = 100, nullable = true)
	private String tumorDiagnosisDepends;

	@Column(name = "TUMOR_PATHOLOGY_TYPE", columnDefinition = "VARCHAR2|病理类型||", length = 50, nullable = true)
	private String tumorPathologyType;

	@Column(name = "TUMOR_ICD_THREE_CODE", columnDefinition = "VARCHAR2|ICD-0-3编码||", length = 8, nullable = true)
	private String tumorIcdThreeCode;

	@Column(name = "TUMOR_ACCIDENT_DATE", columnDefinition = "DATE|发病日期||", nullable = true)
	private Date tumorAccidentDate;

	@Column(name = "TUMOR_DIAGNOSIS_DATE", columnDefinition = "DATE|诊断日期||", nullable = true)
	private Date tumorDiagnosisDate;

	@Column(name = "TUMOR_INFORMED_FLAG", columnDefinition = "VARCHAR2|知情状态标志||", length = 1, nullable = true)
	private String tumorInformedFlag;
	
	@Column(name = "TUMOR_ICD_TEN_TYPE", columnDefinition = "VARCHAR2|肿瘤类型,恶性和非恶性||", length = 1, nullable = true)
	private String tumorIcdTenType;
	
	@Column(name = "TUMOR_DEATH_FIRST_FLAG", columnDefinition = "VARCHAR2|标志该人第一次报卡||", length = 1, nullable = true)
	private String tumorDeathFirstFlag;

	@Column(name = "EHR_NO", columnDefinition = "VARCHAR2|门诊号||", length = 10, nullable = true)
	private String ehrNo;

	@Column(name = "ADMISSION_NO", columnDefinition = "VARCHAR2|住院号||", length = 10, nullable = true)
	private String admissionNo;

	@Column(name = "DIAGNOSIS_ORGAN_CODE", columnDefinition = "VARCHAR2|诊断机构编码||", length = 50, nullable = true)
	private String diagnosisOrganCode;

	@Column(name = "DIAGNOSIS_ORGAN_NAME", columnDefinition = "VARCHAR2|诊断机构名称||", length = 70, nullable = true)
	private String diagnosisOrganName;

	@Column(name = "DIAGNOSE_DOCTOR", columnDefinition = "VARCHAR2|诊断医生姓名||", length = 50, nullable = true)
	private String diagnoseDoctor;

	@Column(name = "DIAGNOSIS_DATE", columnDefinition = "DATE|诊断日期||", nullable = true)
	private Date diagnosisDate;

	@Column(name = "MANAGE_ORGAN_NAME", columnDefinition = "VARCHAR2|管理机构名称||", length = 70, nullable = true)
	private String manageOrganName;

	@Column(name = "MANAGE_ORGAN_CODE", columnDefinition = "VARCHAR2|管理机构编码||", length = 50, nullable = true)
	private String manageOrganCode;

	@Column(name = "SUPER_MANAGE_ORGAN_NAME", columnDefinition = "VARCHAR2|上级管理机构名称||", length = 70, nullable = true)
	private String superManageOrganName;

	@Column(name = "SUPER_MANAGE_ORGAN_CODE", columnDefinition = "VARCHAR2|上级管理机构编码||", length = 50, nullable = true)
	private String superManageOrganCode;

	@Column(name = "CREATE_ORGAN_NAME", columnDefinition = "VARCHAR2|填报机构名称||", length = 70, nullable = true)
	private String createOrganName;

    @Item(column = "上报机构",isOrganization = true,index = 11)
	@Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|填报机构编码||", length = 50, nullable = true)
	private String createOrganCode;

	@Column(name = "CREATE_DOCTOR_NAME", columnDefinition = "VARCHAR2|填报人姓名||", length = 50, nullable = true)
	private String createDoctorName;

    @Item(column = "上报医生",isUser = true,index = 10)
	@Column(name = "CREATE_DOCTOR_CODE", columnDefinition = "VARCHAR2|填报人编码||", length = 18, nullable = true)
	private String createDoctorCode;

    @Item(column = "上报时间",index = 12,isDate = true,datePattern = "yyyy/MM/dd")
	@Column(name = "CREATE_DATE", columnDefinition = "TIMESTAMP|填报时间||", nullable = true)
	private Date createDate;

	@Column(name = "UPDATE_ORGAN_CODE", columnDefinition = "VARCHAR2|更新机构编码||", length = 50, nullable = true)
	private String updateOrganCode;

	@Column(name = "UPDATE_ORGAN_NAME", columnDefinition = "VARCHAR2|更新机构名称||", length = 70, nullable = true)
	private String updateOrganName;

	@Column(name = "UPDATE_DOCTOR_CODE", columnDefinition = "VARCHAR2|更新人编码||", length = 18, nullable = true)
	private String updateDoctorCode;

	@Column(name = "UPDATE_DOCTOR_NAME", columnDefinition = "VARCHAR2|更新人姓名||", length = 50, nullable = true)
	private String updateDoctorName;

	@Column(name = "UPDATE_DATE", columnDefinition = "TIMESTAMP|更新日期和时间||", nullable = true)
	private Date updateDate;

	@Column(name = "IS_DELETE", columnDefinition = "INT|删除状态 0存在 1删除||", nullable = true)
	private Integer isDelete;

	@Column(name = "OTHER_DIAGNOSIS_ORGAN_NAME", columnDefinition = "VARCHAR2|其它诊断机构名称||", length = 70, nullable = true)
	private String otherDiagnosisOrganName;
	
	@Column(name = "OTHER_DIAGNOSIS_ORGAN_FLAG", columnDefinition = "VARCHAR2|其它诊断机构标志||", length = 2, nullable = true)
	private String otherDiagnosisOrganFlag;
	
	@Column(name = "REPORT_TYPE", columnDefinition = "VARCHAR2|报卡类型||", length = 2, nullable = true)
	private String reportType;
	
	@Column(name = "DEATH_REASON", columnDefinition = "VARCHAR2|死亡原因||", length = 300, nullable = true)
	private String deathReason;
	
	@Column(name = "DEATH_DATE", columnDefinition = "TIMESTAMP|死亡日期||",nullable = true)
	private Date deathDate;
	
	@Column(name = "DEATH_REPORT_ORGAN_CODE", columnDefinition = "VARCHAR2|死亡上报机构||", length = 50, nullable = true)
	private String deathReportOrganCode;

	@Column(name = "IS_SECONDARY", columnDefinition = "VARCHAR2|是否继发|1：是 0 否 默认为0|", length = 2, nullable = true)
	private String isSecondary = "0";

	@Column(name = "SECONDARY_ID", columnDefinition = "NUMBER|继发源Id||", length = 11, nullable = true)
	private Long secondaryId;

	//报卡类型,上报传递参数用
	@Transient
	private String tumorReportType;
	
	@Transient
	private String strokeReportType;
	
	@Transient
	private String hbpReportType;
	
	@Transient
	private String coronaryReportType;
	
	@Transient
	private String diReportType;
	
	@Transient
	//(name = "TUMOR_FLAG", columnDefinition = "VARCHAR2|肿瘤标志||", length = 1, nullable = true)
	private String tumorFlag;
	@Transient
	//@Column(name = "STROKE_FLAG", columnDefinition = "VARCHAR2|脑卒中标志||", length = 1, nullable = true)
	private String strokeFlag;
	@Transient
	//@Column(name = "HBP_FLAG", columnDefinition = "VARCHAR2|高血压标志||", length = 1, nullable = true)
	private String hbpFlag;
	@Transient
	//@Column(name = "CORONARY_FLAG", columnDefinition = "VARCHAR2|冠心病标志||", length = 1, nullable = true)
	private String coronaryFlag;
	@Transient
	//@Column(name = "DI_FLAG", columnDefinition = "VARCHAR2|糖尿病标志||", length = 1, nullable = true)
	private String diFlag;
	
	@Transient
	private String  diseaseCode;//医院报卡的疾病诊断code,通过此转换为二级类型

	@Transient
	private DmPersonInfo personInfo;

	@Transient
	private CdmStatusInfo cdmStatusInfo;

	@Transient
	private List<CdmApprovalInfo> approvalInfos;// 历史审核

	@Transient
	List<DmReportInfo> secondaryReportInfos;//肿瘤继发源

	@Transient
	private CdmApprovalInfo approvalInfo;// 本次审核

	@Transient
	private int approvalFlag;// 当前用户是否可以审核

	@Transient
	private String approvalOp;// 审核动作

	@Transient
	private String comments;// 动作原因

	@Transient
	private boolean allowEdit=false;// 是否有权限修改
	
	@Transient
	private boolean needAlloc=false;// 是否需要分配
	
	@Transient
	private Long hosReportRecordId;// 外部上报记录id

    @Item(column = "姓名",index = 0)
	@Transient
	private String name;

    @Item(column = "出生日期",index = 3,isDate = true,datePattern = "yyyy/MM/dd")
	@Transient
	private Date birthday;

    @Item(column = "性别",index = 1,isDic = true,dicType = "GBT226112003")
	@Transient
	private String gender;

    @Item(column = "报卡状态",index = 20,isDic = true,dicType = "DMD00005")
	@Transient
	private String reportStatus;

	@Column(name = "CREATE_CENTER_ORGAN_CODE", columnDefinition = "VARCHAR2|填报机构 中心冗余||", length = 50, nullable = true)
	private String createCenterOrganCode;

	public String getCreateCenterOrganCode() {
		return createCenterOrganCode;
	}

	public void setCreateCenterOrganCode(String createCenterOrganCode) {
		this.createCenterOrganCode = createCenterOrganCode;
	}

	@Transient
	private boolean modified=false;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEhrId() {
		return ehrId;
	}

	public void setEhrId(String ehrId) {
		this.ehrId = ehrId;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getHbpFlag() {
		return hbpFlag;
	}

	public void setHbpFlag(String hbpFlag) {
		this.hbpFlag = hbpFlag;
	}

	public String getHbpType() {
		return hbpType;
	}

	public void setHbpType(String hbpType) {
		this.hbpType = hbpType;
	}

	public Date getHbpAccidentDate() {
		return hbpAccidentDate;
	}

	public void setHbpAccidentDate(Date hbpAccidentDate) {
		this.hbpAccidentDate = hbpAccidentDate;
	}

	public Date getHbpDiagnosisDate() {
		return hbpDiagnosisDate;
	}

	public void setHbpDiagnosisDate(Date hbpDiagnosisDate) {
		this.hbpDiagnosisDate = hbpDiagnosisDate;
	}

	public String getHbpDiagnosisDepends() {
		return hbpDiagnosisDepends;
	}

	public void setHbpDiagnosisDepends(String hbpDiagnosisDepends) {
		this.hbpDiagnosisDepends = hbpDiagnosisDepends;
	}

	public String getDiFlag() {
		return diFlag;
	}

	public void setDiFlag(String diFlag) {
		this.diFlag = diFlag;
	}

	public String getDiType() {
		return diType;
	}

	public void setDiType(String diType) {
		this.diType = diType;
	}

	public Date getDiAccidentDate() {
		return diAccidentDate;
	}

	public void setDiAccidentDate(Date diAccidentDate) {
		this.diAccidentDate = diAccidentDate;
	}

	public Date getDiDiagnosisDate() {
		return diDiagnosisDate;
	}

	public void setDiDiagnosisDate(Date diDiagnosisDate) {
		this.diDiagnosisDate = diDiagnosisDate;
	}

	public String getDiDiagnosisDepends() {
		return diDiagnosisDepends;
	}

	public void setDiDiagnosisDepends(String diDiagnosisDepends) {
		this.diDiagnosisDepends = diDiagnosisDepends;
	}

	public String getStrokeFlag() {
		return strokeFlag;
	}

	public void setStrokeFlag(String strokeFlag) {
		this.strokeFlag = strokeFlag;
	}

	public String getStrokeType() {
		return strokeType;
	}

	public void setStrokeType(String strokeType) {
		this.strokeType = strokeType;
	}

	public Date getStrokeAccidentDate() {
		return strokeAccidentDate;
	}

	public void setStrokeAccidentDate(Date strokeAccidentDate) {
		this.strokeAccidentDate = strokeAccidentDate;
	}

	public Date getStrokeDiagnosisDate() {
		return strokeDiagnosisDate;
	}

	public void setStrokeDiagnosisDate(Date strokeDiagnosisDate) {
		this.strokeDiagnosisDate = strokeDiagnosisDate;
	}

	public String getStrokeDiagnosisDepends() {
		return strokeDiagnosisDepends;
	}

	public void setStrokeDiagnosisDepends(String strokeDiagnosisDepends) {
		this.strokeDiagnosisDepends = strokeDiagnosisDepends;
	}

	public String getCoronaryFlag() {
		return coronaryFlag;
	}

	public void setCoronaryFlag(String coronaryFlag) {
		this.coronaryFlag = coronaryFlag;
	}

	public String getCoronaryType() {
		return coronaryType;
	}

	public void setCoronaryType(String coronaryType) {
		this.coronaryType = coronaryType;
	}

	public Date getCoronaryAccidentDate() {
		return coronaryAccidentDate;
	}

	public void setCoronaryAccidentDate(Date coronaryAccidentDate) {
		this.coronaryAccidentDate = coronaryAccidentDate;
	}

	public Date getCoronaryDiagnosisDate() {
		return coronaryDiagnosisDate;
	}

	public void setCoronaryDiagnosisDate(Date coronaryDiagnosisDate) {
		this.coronaryDiagnosisDate = coronaryDiagnosisDate;
	}

	public String getCoronaryDiagnosisDepends() {
		return coronaryDiagnosisDepends;
	}

	public void setCoronaryDiagnosisDepends(String coronaryDiagnosisDepends) {
		this.coronaryDiagnosisDepends = coronaryDiagnosisDepends;
	}

	public String getTumorFlag() {
		return tumorFlag;
	}

	public void setTumorFlag(String tumorFlag) {
		this.tumorFlag = tumorFlag;
	}

	public String getTumorType() {
		return tumorType;
	}

	public void setTumorType(String tumorType) {
		this.tumorType = tumorType;
	}

	public String getTumorIcdTenCode() {
		return tumorIcdTenCode;
	}

	public void setTumorIcdTenCode(String tumorIcdTenCode) {
		this.tumorIcdTenCode = tumorIcdTenCode;
	}

	public String getTumorIcdTenName() {
		return tumorIcdTenName;
	}

	public void setTumorIcdTenName(String tumorIcdTenName) {
		this.tumorIcdTenName = tumorIcdTenName;
	}

	public String getTumorPrimaryPart() {
		return tumorPrimaryPart;
	}

	public void setTumorPrimaryPart(String tumorPrimaryPart) {
		this.tumorPrimaryPart = tumorPrimaryPart;
	}

	public String getTumorMetastasisPart() {
		return tumorMetastasisPart;
	}

	public void setTumorMetastasisPart(String tumorMetastasisPart) {
		this.tumorMetastasisPart = tumorMetastasisPart;
	}

	public String getTumorDiagnosisDepends() {
		return tumorDiagnosisDepends;
	}

	public void setTumorDiagnosisDepends(String tumorDiagnosisDepends) {
		this.tumorDiagnosisDepends = tumorDiagnosisDepends;
	}

	public String getTumorPathologyType() {
		return tumorPathologyType;
	}

	public void setTumorPathologyType(String tumorPathologyType) {
		this.tumorPathologyType = tumorPathologyType;
	}

	public String getTumorIcdThreeCode() {
		return tumorIcdThreeCode;
	}

	public void setTumorIcdThreeCode(String tumorIcdThreeCode) {
		this.tumorIcdThreeCode = tumorIcdThreeCode;
	}

	public Date getTumorAccidentDate() {
		return tumorAccidentDate;
	}

	public void setTumorAccidentDate(Date tumorAccidentDate) {
		this.tumorAccidentDate = tumorAccidentDate;
	}

	public Date getTumorDiagnosisDate() {
		return tumorDiagnosisDate;
	}

	public void setTumorDiagnosisDate(Date tumorDiagnosisDate) {
		this.tumorDiagnosisDate = tumorDiagnosisDate;
	}

	public String getTumorInformedFlag() {
		return tumorInformedFlag;
	}

	public void setTumorInformedFlag(String tumorInformedFlag) {
		this.tumorInformedFlag = tumorInformedFlag;
	}

	public String getCreateOrganName() {
		return createOrganName;
	}

	public void setCreateOrganName(String createOrganName) {
		this.createOrganName = createOrganName;
	}

	public String getCreateOrganCode() {
		return createOrganCode;
	}

	public void setCreateOrganCode(String createOrganCode) {
		this.createOrganCode = createOrganCode;
	}

	public String getCreateDoctorName() {
		return createDoctorName;
	}

	public void setCreateDoctorName(String createDoctorName) {
		this.createDoctorName = createDoctorName;
	}

	public String getCreateDoctorCode() {
		return createDoctorCode;
	}

	public void setCreateDoctorCode(String createDoctorCode) {
		this.createDoctorCode = createDoctorCode;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateOrganCode() {
		return updateOrganCode;
	}

	public void setUpdateOrganCode(String updateOrganCode) {
		this.updateOrganCode = updateOrganCode;
	}

	public String getUpdateOrganName() {
		return updateOrganName;
	}

	public void setUpdateOrganName(String updateOrganName) {
		this.updateOrganName = updateOrganName;
	}

	public String getUpdateDoctorCode() {
		return updateDoctorCode;
	}

	public void setUpdateDoctorCode(String updateDoctorCode) {
		this.updateDoctorCode = updateDoctorCode;
	}

	public String getUpdateDoctorName() {
		return updateDoctorName;
	}

	public void setUpdateDoctorName(String updateDoctorName) {
		this.updateDoctorName = updateDoctorName;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public DmPersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(DmPersonInfo personInfo) {
		this.personInfo = personInfo;
	}

	public String getEhrNo() {
		return ehrNo;
	}

	public void setEhrNo(String ehrNo) {
		this.ehrNo = ehrNo;
	}

	public String getAdmissionNo() {
		return admissionNo;
	}

	public void setAdmissionNo(String admissionNo) {
		this.admissionNo = admissionNo;
	}

	public String getDiagnosisOrganCode() {
		return diagnosisOrganCode;
	}

	public void setDiagnosisOrganCode(String diagnosisOrganCode) {
		this.diagnosisOrganCode = diagnosisOrganCode;
	}

	public String getDiagnosisOrganName() {
		return diagnosisOrganName;
	}

	public void setDiagnosisOrganName(String diagnosisOrganName) {
		this.diagnosisOrganName = diagnosisOrganName;
	}

	public String getDiagnoseDoctor() {
		return diagnoseDoctor;
	}

	public void setDiagnoseDoctor(String diagnoseDoctor) {
		this.diagnoseDoctor = diagnoseDoctor;
	}

	public Date getDiagnosisDate() {
		return diagnosisDate;
	}

	public void setDiagnosisDate(Date diagnosisDate) {
		this.diagnosisDate = diagnosisDate;
	}

	public String getDisType() {
		return disType;
	}

	public void setDisType(String disType) {
		this.disType = disType;
	}

	public Integer getCdmId() {
		return cdmId;
	}

	public void setCdmId(Integer cdmId) {
		this.cdmId = cdmId;
	}

	public CdmStatusInfo getCdmStatusInfo() {
		return cdmStatusInfo;
	}

	public void setCdmStatusInfo(CdmStatusInfo cdmStatusInfo) {
		this.cdmStatusInfo = cdmStatusInfo;
	}

	public List<CdmApprovalInfo> getApprovalInfos() {
		return approvalInfos;
	}

	public void setApprovalInfos(List<CdmApprovalInfo> approvalInfos) {
		this.approvalInfos = approvalInfos;
	}

	public int getApprovalFlag() {
		return approvalFlag;
	}

	public void setApprovalFlag(int approvalFlag) {
		this.approvalFlag = approvalFlag;
	}

	public CdmApprovalInfo getApprovalInfo() {
		return approvalInfo;
	}

	public void setApprovalInfo(CdmApprovalInfo approvalInfo) {
		this.approvalInfo = approvalInfo;
	}

	public String getApprovalOp() {
		return approvalOp;
	}

	public void setApprovalOp(String approvalOp) {
		this.approvalOp = approvalOp;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public boolean isAllowEdit() {
		return allowEdit;
	}

	public void setAllowEdit(boolean allowEdit) {
		this.allowEdit = allowEdit;
	}

	public String getManageOrganName() {
		return manageOrganName;
	}

	public void setManageOrganName(String manageOrganName) {
		this.manageOrganName = manageOrganName;
	}

	public String getManageOrganCode() {
		return manageOrganCode;
	}

	public void setManageOrganCode(String manageOrganCode) {
		this.manageOrganCode = manageOrganCode;
	}

	public String getSuperManageOrganName() {
		return superManageOrganName;
	}

	public void setSuperManageOrganName(String superManageOrganName) {
		this.superManageOrganName = superManageOrganName;
	}

	public String getSuperManageOrganCode() {
		return superManageOrganCode;
	}

	public void setSuperManageOrganCode(String superManageOrganCode) {
		this.superManageOrganCode = superManageOrganCode;
	}

	public Long getDmPersonId() {
		return dmPersonId;
	}

	public void setDmPersonId(Long dmPersonId) {
		this.dmPersonId = dmPersonId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}

	public boolean isModified() {
		return modified;
	}

	public void setModified(boolean modified) {
		this.modified = modified;
	}

	public String getSubDisType() {
		return subDisType;
	}

	public void setSubDisType(String subDisType) {
		this.subDisType = subDisType;
	}

	public String getDiseaseCode() {
		return diseaseCode;
	}

	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}

	public String getOtherDiagnosisOrganName() {
		return otherDiagnosisOrganName;
	}

	public void setOtherDiagnosisOrganName(String otherDiagnosisOrganName) {
		this.otherDiagnosisOrganName = otherDiagnosisOrganName;
	}

	public String getOtherDiagnosisOrganFlag() {
		return otherDiagnosisOrganFlag;
	}

	public void setOtherDiagnosisOrganFlag(String otherDiagnosisOrganFlag) {
		this.otherDiagnosisOrganFlag = otherDiagnosisOrganFlag;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getTumorReportType() {
		return tumorReportType;
	}

	public void setTumorReportType(String tumorReportType) {
		this.tumorReportType = tumorReportType;
	}

	public String getStrokeReportType() {
		return strokeReportType;
	}

	public void setStrokeReportType(String strokeReportType) {
		this.strokeReportType = strokeReportType;
	}

	public String getHbpReportType() {
		return hbpReportType;
	}

	public void setHbpReportType(String hbpReportType) {
		this.hbpReportType = hbpReportType;
	}

	public String getCoronaryReportType() {
		return coronaryReportType;
	}

	public void setCoronaryReportType(String coronaryReportType) {
		this.coronaryReportType = coronaryReportType;
	}

	public String getDiReportType() {
		return diReportType;
	}

	public void setDiReportType(String diReportType) {
		this.diReportType = diReportType;
	}

	public String getDeathReason() {
		return deathReason;
	}

	public void setDeathReason(String deathReason) {
		this.deathReason = deathReason;
	}

	public Date getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	public String getDeathReportOrganCode() {
		return deathReportOrganCode;
	}

	public void setDeathReportOrganCode(String deathReportOrganCode) {
		this.deathReportOrganCode = deathReportOrganCode;
	}

	public String getTumorIcdTenType() {
		return tumorIcdTenType;
	}

	public void setTumorIcdTenType(String tumorIcdTenType) {
		this.tumorIcdTenType = tumorIcdTenType;
	}


	public String getTumorDeathFirstFlag() {
		return tumorDeathFirstFlag;
	}

	public void setTumorDeathFirstFlag(String tumorDeathFirstFlag) {
		this.tumorDeathFirstFlag = tumorDeathFirstFlag;
	}

	public boolean isNeedAlloc() {
		return needAlloc;
	}

	public void setNeedAlloc(boolean needAlloc) {
		this.needAlloc = needAlloc;
	}

	public Long getHosReportRecordId() {
		return hosReportRecordId;
	}

	public void setHosReportRecordId(Long hosReportRecordId) {
		this.hosReportRecordId = hosReportRecordId;
	}

	public String getIsSecondary() {
		return isSecondary;
	}

	public void setIsSecondary(String isSecondary) {
		this.isSecondary = isSecondary;
	}

	public Long getSecondaryId() {
		return secondaryId;
	}

	public void setSecondaryId(Long secondaryId) {
		this.secondaryId = secondaryId;
	}

	public List<DmReportInfo> getSecondaryReportInfos() {
		return secondaryReportInfos;
	}

	public void setSecondaryReportInfos(List<DmReportInfo> secondaryReportInfos) {
		this.secondaryReportInfos = secondaryReportInfos;
	}

	public String getHbpIcdTenCode() {
		return hbpIcdTenCode;
	}

	public void setHbpIcdTenCode(String hbpIcdTenCode) {
		this.hbpIcdTenCode = hbpIcdTenCode;
	}

	public String getDiIcdTenCode() {
		return diIcdTenCode;
	}

	public void setDiIcdTenCode(String diIcdTenCode) {
		this.diIcdTenCode = diIcdTenCode;
	}

	public String getStrokeIcdTenCode() {
		return strokeIcdTenCode;
	}

	public void setStrokeIcdTenCode(String strokeIcdTenCode) {
		this.strokeIcdTenCode = strokeIcdTenCode;
	}

	public String getCoronaryIcdTenCode() {
		return coronaryIcdTenCode;
	}

	public void setCoronaryIcdTenCode(String coronaryIcdTenCode) {
		this.coronaryIcdTenCode = coronaryIcdTenCode;
	}
}
