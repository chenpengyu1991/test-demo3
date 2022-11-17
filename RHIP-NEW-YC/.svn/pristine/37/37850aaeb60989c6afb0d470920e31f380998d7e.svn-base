package com.founder.rhip.ehr.entity.management;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "DM_TUMOR_FOLLOWUP")
public class DmTumorFollowup implements Serializable {

	private static final long serialVersionUID = -8407559716095144643L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = true)
	private Long id;

	@Column(name = "EHR_ID", columnDefinition = "VARCHAR2|活动索引号||", length = 20, nullable = true)
	private String ehrId;

	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|个人信息唯一编号||", length = 11, nullable = true)
	private Long personId;

	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|居民身份证/健康卡号||", length = 18, nullable = true)
	private String idcard;

	@Column(name = "VISIT_WAY_CODE", columnDefinition = "VARCHAR2|随访方式代码||", length = 1, nullable = true)
	private String visitWayCode;

	@Column(name = "FIRST_DATE", columnDefinition = "DATE|首次发病日期||", nullable = true)
	private Date firstDate;

	@Column(name = "RECUR_DATE", columnDefinition = "DATE|最近复发日期||", nullable = true)
	private Date recurDate;

	@Column(name = "CUR_STATE", columnDefinition = "VARCHAR2|目前病情状况代码||", length = 1, nullable = true)
	private String curState;

	@Column(name = "CURE", columnDefinition = "VARCHAR2|肿瘤患者治疗标志||", length = 1, nullable = true)
	private String cure;

	@Column(name = "CURE_PROJECT", columnDefinition = "VARCHAR2|肿瘤患者治疗方式代码组合||", length = 100, nullable = true)
	private String cureProject;

	@Column(name = "OTHER_CURE", columnDefinition = "VARCHAR2|患者其他治疗方式||", length = 100, nullable = true)
	private String otherCure;

	@Column(name = "THERIOMA_HISTORY_FLAG", columnDefinition = "VARCHAR2|肿瘤家族史标志||", length = 1, nullable = true)
	private String theriomaHistoryFlag;
	
	@Column(name = "THERIOMA_HISTORY_DETAIL", columnDefinition = "VARCHAR2|肿瘤家族史||", length = 100, nullable = true)
	private String theriomaHistoryDetail;

	@Column(name = "OPS", columnDefinition = "VARCHAR2|肿瘤手术标志||", length = 1, nullable = true)
	private String ops;

	@Column(name = "THERIOMA_OPERATION", columnDefinition = "VARCHAR2|肿瘤手术性质代码||", length = 1, nullable = true)
	private String theriomaOperation;

	@Column(name = "METASTASIS", columnDefinition = "VARCHAR2|肿瘤患者转移标志||", length = 1, nullable = true)
	private String metastasis;

	@Column(name = "METASTASIS_PART", columnDefinition = "VARCHAR2|肿瘤患者转移部位||", length = 100, nullable = true)
	private String metastasisPart;

	@Column(name = "OPS_HOSPITAL", columnDefinition = "VARCHAR2|肿瘤手术医院名称||", length = 70, nullable = true)
	private String opsHospital;
	
	@Column(name = "RADIOTHERAPY_HOSPITAL", columnDefinition = "VARCHAR2|肿瘤放疗医院名称||", length = 70, nullable = true)
	private String radiotherapyHospital;
	
	@Column(name = "CHEMOTHERAPY_HOSPITAL", columnDefinition = "VARCHAR2|肿瘤化疗医院名称||", length = 70, nullable = true)
	private String chemotherapyHospital;

	@Column(name = "OPS_DATE", columnDefinition = "DATE|手术日期||", nullable = true)
	private Date opsDate;

	@Column(name = "CRTESIAN_VALUE", columnDefinition = "NUMBER|卡氏评分值||",length = 3, nullable = true)
	private Integer crtesianValue;

	@Column(name = "VISIT_DATE", columnDefinition = "DATE|本次随访日期||", nullable = true)
	private Date visitDate;

	@Column(name = "NEXT_VISIT_DATE", columnDefinition = "DATE|下次随访日期||", nullable = true)
	private Date nextVisitDate;

	@Column(name = "VISIT_ORGAN_CODE", columnDefinition = "VARCHAR2|随访机构编码||", length = 15, nullable = true)
	private String visitOrganCode;

	@Column(name = "VISIT_ORGAN_NAME", columnDefinition = "VARCHAR2|随访机构名称||", length = 70, nullable = true)
	private String visitOrganName;

	@Column(name = "VISIT_IDCARD", columnDefinition = "VARCHAR2|随访人身份证号||", length = 18, nullable = true)
	private String visitIdcard;

	@Column(name = "VISIT_NAME", columnDefinition = "VARCHAR2|随访人姓名||", length = 50, nullable = true)
	private String visitName;

	@Column(name = "CREATE_ORGAN_NAME", columnDefinition = "VARCHAR2|填报机构名称||", length = 70, nullable = true)
	private String createOrganName;

	@Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|填报机构编码||", length = 50, nullable = true)
	private String createOrganCode;

	@Column(name = "CREATE_DOCTOR_NAME", columnDefinition = "VARCHAR2|填报人姓名||", length = 50, nullable = true)
	private String createDoctorName;

	@Column(name = "CREATE_DOCTOR_CODE", columnDefinition = "VARCHAR2|填报人编码||", length = 18, nullable = true)
	private String createDoctorCode;

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

	@Column(name = "IS_DELETE", columnDefinition = "INT|删除状态||", nullable = true)
	private Integer isDelete;
	
	@Column(name = "FOLLOWUP_FLAG", columnDefinition = "VARCHAR2|随访类型 1.首次随访 2.普通随访 3.末次随访||", nullable = true)
	private String followupFlag;
	
	@Column(name = "RECUR", columnDefinition = "VARCHAR2|是否复发标志||", nullable = true)
	private String recur;
	
	@Column(name = "RECUR_TIME", columnDefinition = "INT|复发次数||", nullable = true)
	private Integer recurTime;
	
	@Column(name = "GUIDANCE_CONTENT", columnDefinition = "VARCHAR2|指导内容||", length = 100, nullable = true)
	private String guidanceContent;
	
	@Column(name = "CANCEL_DATE", columnDefinition = "DATE|撤销管理日期||", nullable = true)
	private Date cancelDate;
	
	@Column(name = "DEATH_DATE", columnDefinition = "DATE|死亡日期||", nullable = true)
	private Date deathDate;
	
	@Column(name = "DEATH_REASON", columnDefinition = "VARCHAR2|死亡原因||",length = 100, nullable = true)
	private String deathReason;
	
	@Column(name = "DEATH_PLACE", columnDefinition = "VARCHAR2|死亡地点||", nullable = true)
	private String deathPlace;
	
	@Column(name = "CURRENT_STATUS_FLAG", columnDefinition = "VARCHAR2|目前情况||", length = 2,nullable = true)
	private String currentStatusFlag;
	
	@Column(name = "REMARK", columnDefinition = "VARCHAR2|备注||", length = 100,nullable = true)
	private String remark; 

	@Column(name = "DEFINITION_NEXT_DATE", columnDefinition = "TIMESTAMP|填报时间||", nullable = true)
	private Date definitionNextDate;
	
	@Column(name = "PROCESS_STATUS", columnDefinition = "VARCHAR2|处理状态||", length = 1, nullable = true)
	private String processStatus = "0";

	@Column(name = "COMMENTS", columnDefinition = "VARCHAR2|备注||", length = 1000, nullable = true)
	private String comments;

	@Column(name = "LOSS_VISIT", columnDefinition = "VARCHAR2|是否失访标志||", length = 1, nullable = true)
	private String lossVisit;

	@Column(name = "LOSS_VISIT_REASON", columnDefinition = "VARCHAR2|失访原因||", length = 100, nullable = true)
	private String lossVisitReason;

	@Column(name = "LOSS_VISIT_REASON_DESC", columnDefinition = "VARCHAR2|失访原因(其他)||", length = 100, nullable = true)
	private String lossVisitReasonDesc;

	@Column(name = "FOLLOWUP_PLACE", columnDefinition = "VARCHAR2|随访地址||", length = 1, nullable = true)
	private String followupPlace;

    @Column(name = "FLTOWN_SHIP", columnDefinition = "VARCHAR2|随访地址-街道（乡镇）||", length = 70, nullable = true)
    private String fltownShip;

    @Column(name = "FLSTREET", columnDefinition = "VARCHAR2|随访地址-村||", length = 70, nullable = true)
    private String flstreet;

    @Column(name = "FL_GROUP", columnDefinition = "VARCHAR2|随访小组地址||", length = 70, nullable = true)
	private String flGroup;

    @Column(name = "FLHOUSE_NUMBER", columnDefinition = "VARCHAR2|随访地址-门牌号码||", length = 70, nullable = true)
    private String flhouseNumber;

    @Column(name = "DEATH", columnDefinition = "VARCHAR2|是否死亡||", length = 1, nullable = true)
    private String death;

    @Column(name = "DEATH_FOR_TUMOR", columnDefinition = "VARCHAR2|是否死于肿瘤||", length = 1, nullable = true)
    private String deathForTumor;

    @Column(name = "DEATH_PLACE_CODE", columnDefinition = "VARCHAR2|死亡地址||", length = 1, nullable = true)
    private String deathPlaceCode;

    @Column(name = "CANCEL", columnDefinition = "VARCHAR2|是否撤销随访||", length = 1, nullable = true)
    private String cancel;

    @Column(name = "CANCEL_REASON", columnDefinition = "VARCHAR2|撤销随访原因||", length = 1, nullable = true)
    private String cancelReason;

	@Transient
	private String firstDateDesc;
	
	@Transient
	private String recurDateDesc;
	
	@Transient
	private String visitDateDesc;
	
	@Transient
	private String updateDateDesc;
	
	@Transient
	private String nextVisitDateDesc;
	
	public Date getDefinitionNextDate() {
		return definitionNextDate;
	}

	public void setDefinitionNextDate(Date definitionNextDate) {
		this.definitionNextDate = definitionNextDate;
	}

	@Transient
	private Long planId;//计划id
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getVisitWayCode() {
		return this.visitWayCode;
	}

	public void setVisitWayCode(String visitWayCode) {
		this.visitWayCode = visitWayCode;
	}

	public Date getFirstDate() {
		return this.firstDate;
	}

	public void setFirstDate(Date firstDate) {
		this.firstDate = firstDate;
	}

	public Date getRecurDate() {
		return this.recurDate;
	}

	public void setRecurDate(Date recurDate) {
		this.recurDate = recurDate;
	}

	public String getCurState() {
		return this.curState;
	}

	public void setCurState(String curState) {
		this.curState = curState;
	}

	public String getCure() {
		return this.cure;
	}

	public void setCure(String cure) {
		this.cure = cure;
	}

	public String getCureProject() {
		return this.cureProject;
	}

	public void setCureProject(String cureProject) {
		this.cureProject = cureProject;
	}

	public String getOtherCure() {
		return this.otherCure;
	}

	public void setOtherCure(String otherCure) {
		this.otherCure = otherCure;
	}

	public String getTheriomaHistoryFlag() {
		return this.theriomaHistoryFlag;
	}

	public void setTheriomaHistoryFlag(String theriomaHistoryFlag) {
		this.theriomaHistoryFlag = theriomaHistoryFlag;
	}

	public String getOps() {
		return this.ops;
	}

	public void setOps(String ops) {
		this.ops = ops;
	}

	public String getTheriomaOperation() {
		return this.theriomaOperation;
	}

	public void setTheriomaOperation(String theriomaOperation) {
		this.theriomaOperation = theriomaOperation;
	}

	public String getMetastasis() {
		return this.metastasis;
	}

	public void setMetastasis(String metastasis) {
		this.metastasis = metastasis;
	}

	public String getMetastasisPart() {
		return this.metastasisPart;
	}

	public void setMetastasisPart(String metastasisPart) {
		this.metastasisPart = metastasisPart;
	}

	public String getOpsHospital() {
		return this.opsHospital;
	}

	public void setOpsHospital(String opsHospital) {
		this.opsHospital = opsHospital;
	}

	public Date getOpsDate() {
		return this.opsDate;
	}

	public void setOpsDate(Date opsDate) {
		this.opsDate = opsDate;
	}

	public Integer getCrtesianValue() {
		return this.crtesianValue;
	}

	public void setCrtesianValue(Integer crtesianValue) {
		this.crtesianValue = crtesianValue;
	}

	public Date getVisitDate() {
		return this.visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public Date getNextVisitDate() {
		return this.nextVisitDate;
	}

	public void setNextVisitDate(Date nextVisitDate) {
		this.nextVisitDate = nextVisitDate;
	}

	public String getVisitOrganCode() {
		return this.visitOrganCode;
	}

	public void setVisitOrganCode(String visitOrganCode) {
		this.visitOrganCode = visitOrganCode;
	}

	public String getVisitOrganName() {
		return this.visitOrganName;
	}

	public void setVisitOrganName(String visitOrganName) {
		this.visitOrganName = visitOrganName;
	}

	public String getVisitIdcard() {
		return this.visitIdcard;
	}

	public void setVisitIdcard(String visitIdcard) {
		this.visitIdcard = visitIdcard;
	}

	public String getVisitName() {
		return this.visitName;
	}

	public void setVisitName(String visitName) {
		this.visitName = visitName;
	}

	public String getCreateOrganName() {
		return this.createOrganName;
	}

	public void setCreateOrganName(String createOrganName) {
		this.createOrganName = createOrganName;
	}

	public String getCreateOrganCode() {
		return this.createOrganCode;
	}

	public void setCreateOrganCode(String createOrganCode) {
		this.createOrganCode = createOrganCode;
	}

	public String getCreateDoctorName() {
		return this.createDoctorName;
	}

	public void setCreateDoctorName(String createDoctorName) {
		this.createDoctorName = createDoctorName;
	}

	public String getCreateDoctorCode() {
		return this.createDoctorCode;
	}

	public void setCreateDoctorCode(String createDoctorCode) {
		this.createDoctorCode = createDoctorCode;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateOrganCode() {
		return this.updateOrganCode;
	}

	public void setUpdateOrganCode(String updateOrganCode) {
		this.updateOrganCode = updateOrganCode;
	}

	public String getUpdateOrganName() {
		return this.updateOrganName;
	}

	public void setUpdateOrganName(String updateOrganName) {
		this.updateOrganName = updateOrganName;
	}

	public String getUpdateDoctorCode() {
		return this.updateDoctorCode;
	}

	public void setUpdateDoctorCode(String updateDoctorCode) {
		this.updateDoctorCode = updateDoctorCode;
	}

	public String getUpdateDoctorName() {
		return this.updateDoctorName;
	}

	public void setUpdateDoctorName(String updateDoctorName) {
		this.updateDoctorName = updateDoctorName;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getFollowupFlag() {
		return followupFlag;
	}

	public void setFollowupFlag(String followupFlag) {
		this.followupFlag = followupFlag;
	}

	public String getRecur() {
		return recur;
	}

	public void setRecur(String recur) {
		this.recur = recur;
	}

	public Integer getRecurTime() {
		return recurTime;
	}

	public void setRecurTime(Integer recurTime) {
		this.recurTime = recurTime;
	}

	public String getGuidanceContent() {
		return guidanceContent;
	}

	public void setGuidanceContent(String guidanceContent) {
		this.guidanceContent = guidanceContent;
	}

	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	public Date getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	public String getDeathReason() {
		return deathReason;
	}

	public void setDeathReason(String deathReason) {
		this.deathReason = deathReason;
	}

	public String getDeathPlace() {
		return deathPlace;
	}

	public void setDeathPlace(String deathPlace) {
		this.deathPlace = deathPlace;
	}

	public Long getPlanId() {
		return planId;
	}

	public void setPlanId(Long planId) {
		this.planId = planId;
	}

	public String getRadiotherapyHospital() {
		return radiotherapyHospital;
	}

	public void setRadiotherapyHospital(String radiotherapyHospital) {
		this.radiotherapyHospital = radiotherapyHospital;
	}

	public String getChemotherapyHospital() {
		return chemotherapyHospital;
	}

	public void setChemotherapyHospital(String chemotherapyHospital) {
		this.chemotherapyHospital = chemotherapyHospital;
	}

	public String getTheriomaHistoryDetail() {
		return theriomaHistoryDetail;
	}

	public void setTheriomaHistoryDetail(String theriomaHistoryDetail) {
		this.theriomaHistoryDetail = theriomaHistoryDetail;
	}

	public String getCurrentStatusFlag() {
		return currentStatusFlag;
	}

	public void setCurrentStatusFlag(String currentStatusFlag) {
		this.currentStatusFlag = currentStatusFlag;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	public String getFirstDateDesc() {
		return firstDateDesc;
	}

	
	public void setFirstDateDesc(String firstDateDesc) {
		this.firstDateDesc = firstDateDesc;
	}

	
	public String getRecurDateDesc() {
		return recurDateDesc;
	}

	
	public void setRecurDateDesc(String recurDateDesc) {
		this.recurDateDesc = recurDateDesc;
	}

	
	public String getVisitDateDesc() {
		return visitDateDesc;
	}

	
	public void setVisitDateDesc(String visitDateDesc) {
		this.visitDateDesc = visitDateDesc;
	}

	
	public String getUpdateDateDesc() {
		return updateDateDesc;
	}

	
	public void setUpdateDateDesc(String updateDateDesc) {
		this.updateDateDesc = updateDateDesc;
	}

	
	public String getNextVisitDateDesc() {
		return nextVisitDateDesc;
	}

	
	public void setNextVisitDateDesc(String nextVisitDateDesc) {
		this.nextVisitDateDesc = nextVisitDateDesc;
	}

	
	public String getProcessStatus() {
		return processStatus;
	}

	
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

    public String getLossVisit() {
        return lossVisit;
    }

    public void setLossVisit(String lossVisit) {
        this.lossVisit = lossVisit;
    }

    public String getLossVisitReason() {
        return lossVisitReason;
    }

    public void setLossVisitReason(String lossVisitReason) {
        this.lossVisitReason = lossVisitReason;
    }

    public String getLossVisitReasonDesc() {
        return lossVisitReasonDesc;
    }

    public void setLossVisitReasonDesc(String lossVisitReasonDesc) {
        this.lossVisitReasonDesc = lossVisitReasonDesc;
    }

    public String getFollowupPlace() {
        return followupPlace;
    }

    public void setFollowupPlace(String followupPlace) {
        this.followupPlace = followupPlace;
    }

    public String getFltownShip() {
        return fltownShip;
    }

    public void setFltownShip(String fltownShip) {
        this.fltownShip = fltownShip;
    }

    public String getFlstreet() {
        return flstreet;
    }

    public void setFlstreet(String flstreet) {
        this.flstreet = flstreet;
    }

    public String getFlhouseNumber() {
        return flhouseNumber;
    }

    public void setFlhouseNumber(String flhouseNumber) {
        this.flhouseNumber = flhouseNumber;
    }

    public String getDeathForTumor() {
        return deathForTumor;
    }

    public void setDeathForTumor(String deathForTumor) {
        this.deathForTumor = deathForTumor;
    }

    public String getDeathPlaceCode() {
        return deathPlaceCode;
    }

    public void setDeathPlaceCode(String deathPlaceCode) {
        this.deathPlaceCode = deathPlaceCode;
    }

    public String getCancel() {
        return cancel;
    }

    public void setCancel(String cancel) {
        this.cancel = cancel;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }

	public String getFlGroup() {
		return flGroup;
	}

	public void setFlGroup(String flGroup) {
		this.flGroup = flGroup;
	}
}