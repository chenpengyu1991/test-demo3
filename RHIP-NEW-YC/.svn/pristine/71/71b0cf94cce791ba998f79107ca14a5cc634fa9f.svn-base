package com.founder.rhip.ehr.entity.control.idm.notifiabledisease;

import com.founder.rhip.ehr.dto.idm.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "IDM_STATUS_INFO")
public class IdmStatusInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|状态表ID|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "PIX_ID", columnDefinition = "VARCHAR2|患者唯一编码|32|", length = 32, nullable = false)
	private String pixId;

	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|BI_PERSON_INFO表ID|11|", length = 11, nullable = false)
	private Long personId;
	
	@Column(name = "TYPE", columnDefinition = "VARCHAR2|传染病类型|20|", length = 20, nullable = true)
	private String type;

	@Column(name = "REPORT_STATUS", columnDefinition = "NUMBER|上报审批状态|11|", length = 11, nullable = true)
	private Integer reportStatus;

	@Column(name = "ASSIGNMENT_STATUS", columnDefinition = "VARCHAR2|分配状态|20|", length = 20, nullable = true)
	private String assignmentStatus;

	@Column(name = "CASE_INFO_STATUS", columnDefinition = "VARCHAR2|个案填写状态|20|", length = 20, nullable = true)
	private String caseInfoStatus;

	@Column(name = "CASE_STATUS", columnDefinition = "VARCHAR2|个案审批状态|20|", length = 20, nullable = true)
	private String caseStatus;

	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|是否删除|1|", length = 1, nullable = true)
	private Integer isDelete;

    @Column(name = "SPECIAL_STATUS", columnDefinition = "NUMBER|专项状态|11|", length = 11, nullable = true)
    private Integer specialStatus;

    @Column(name = "IDM_TYPE", columnDefinition = "VARCHAR2|专项与法定区分字段|20|", length = 20, nullable = true)
    private String idmType;
    
    @Column(name = "PLACE_STATUS", columnDefinition = "VARCHAR2|到位状态|20|", length = 20, nullable = true)
    private String placeStatus;

    @Column(name = "LAST_TOWN", columnDefinition = "VARCHAR2|上次管理机构所在镇|100|", length = 100, nullable = true)
    private String lastTown;
    
    @Column(name = "LAST_UNIT", columnDefinition = "VARCHAR2|上次管理机构|50|", length = 100, nullable = true)
    private String lastUnit;

    @Column(name = "CURRENT_TOWN", columnDefinition = "VARCHAR2|CURRENT_TOWN|100|", length = 100, nullable = true)
    private String currentTown;
    
    @Column(name = "CURRENT_UNIT", columnDefinition = "VARCHAR2|当前管理机构|50|", length = 100, nullable = true)
    private String currentUnit;

    @Column(name = "FR_STATUS", columnDefinition = "VARCHAR2|随访状态|20|", length = 20, nullable = true)
    private String frStatus;

    @Column(name = "TS_STATUS", columnDefinition = "VARCHAR2|采样状态|20|", length = 20, nullable = true)
    private String tsStatus;

    @Column(name = "LOGOFF", columnDefinition = "NUMBER|注销标志（0正常，1注销）|1|", length = 1, nullable = false)
    private Integer logoff = 0;
    
    @Column(name = "REPORT_SOURCE", columnDefinition = "VARCHAR2|报卡来源：0外部 1平台||", length = 1, nullable = true)
	private String reportSource;
    
    @Column(name = "ASSIGNED_TO_UNIT", columnDefinition = "VARCHAR2|待纳入管理机构|50|", length = 100, nullable = true)
    private String assignedToUnit;
    
	@Column(name = "CASE_PASS_STATUS", columnDefinition = "VARCHAR2|个案合格状态|1|", length = 1, nullable = true)
	private String casePassStatus;
	
	@Column(name = "VALID_CASE_STATUS", columnDefinition = "VARCHAR2|个案作废状态：0 作废 |1|", length = 1, nullable = true)
	private String validCaseStatus;

	@Column(name = "discontinued_time", columnDefinition = "DATE|停止治疗日期||", nullable = true)
	private Date discontinuedTime;

	@Column(name = "discontinued_reason", columnDefinition = "VARCHAR2|停止治疗原因 |50|", length = 50, nullable = true)
	private String discontinuedReason;

	@Column(name = "plan_visit_count", columnDefinition = "VARCHAR2|应访视次数 |50|", length = 50, nullable = true)
	private Long planVisitCount;

	@Column(name = "visit_count", columnDefinition = "VARCHAR2|实际访视次数 |50|", length = 50, nullable = true)
	private Long visitCount;

	@Column(name = "plan_dose_count", columnDefinition = "VARCHAR2|应服药次数 |50|", length = 50, nullable = true)
	private Long planDoseCount;

	@Column(name = "DOSE_COUNT", columnDefinition = "VARCHAR2|实际服药次数 |50|", length = 50, nullable = true)
	private Long doseCount;

	@Column(name = "DOSE_RATE", columnDefinition = "DOUBLE|服药率 |50|", length = 50, nullable = true)
	private Double doseRate;

	@Column(name = "DOCTOR", columnDefinition = "VARCHAR2|医生 |50|", length = 50, nullable = true)
	private String doctor;

	@Column(name = "DANGER_FLAG1", columnDefinition = "VARCHAR2|5大高危人群分类1 |2|", length = 2, nullable = true)
	private String dangerFlag1;

	@Column(name = "DANGER_FLAG2", columnDefinition = "VARCHAR2|5大高危人群分类2 |2|", length = 2, nullable = true)
	private String dangerFlag2;

	@Column(name = "DANGER_FLAG3", columnDefinition = "VARCHAR2|5大高危人群分类3 |2|", length = 2, nullable = true)
	private String dangerFlag3;

	@Column(name = "DANGER_FLAG4", columnDefinition = "VARCHAR2|5大高危人群分类4 |2|", length = 2, nullable = true)
	private String dangerFlag4;

	@Column(name = "DANGER_FLAG5", columnDefinition = "VARCHAR2|5大高危人群分类5 |2|", length = 2, nullable = true)
	private String dangerFlag5;

	@Column(name = "NDY_FLAG", columnDefinition = "VARCHAR2|耐多药患者标记 |1|", length = 2, nullable = true)
	private String ndyFlag;
	/*专项：疟疾*/
	@Transient
	private MalariaQueryDto malariaQueryDto;
	
	/*专项：结核病*/
	@Transient
	private TbQueryDto tbDto;
	
	/*专项：血吸虫病*/
	@Transient
	private SchistosomeQueryDto schDto;

    /*专项：丝虫病*/
    @Transient
    private FilariasisQueryDto filDto;
    
    /*专项：麻风病*/
    @Transient
    private LeprosyQueryDto leprosyQueryDto;

	public Date getDiscontinuedTime() {
		return discontinuedTime;
	}

	public void setDiscontinuedTime(Date discontinuedTime) {
		this.discontinuedTime = discontinuedTime;
	}

	public String getDiscontinuedReason() {
		return discontinuedReason;
	}

	public void setDiscontinuedReason(String discontinuedReason) {
		this.discontinuedReason = discontinuedReason;
	}

	public Long getPlanVisitCount() {
		return planVisitCount;
	}

	public void setPlanVisitCount(Long planVisitCount) {
		this.planVisitCount = planVisitCount;
	}

	public Long getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(Long visitCount) {
		this.visitCount = visitCount;
	}

	public Long getPlanDoseCount() {
		return planDoseCount;
	}

	public void setPlanDoseCount(Long planDoseCount) {
		this.planDoseCount = planDoseCount;
	}

	public Long getDoseCount() {
		return doseCount;
	}

	public void setDoseCount(Long doseCount) {
		this.doseCount = doseCount;
	}

	public Double getDoseRate() {
		return doseRate;
	}

	public void setDoseRate(Double doseRate) {
		this.doseRate = doseRate;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPixId() {
		return this.pixId;
	}

	public void setPixId(String pixId) {
		this.pixId = pixId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getReportStatus() {
		return this.reportStatus;
	}

	public void setReportStatus(Integer reportStatus) {
		this.reportStatus = reportStatus;
	}

	public String getAssignmentStatus() {
		return this.assignmentStatus;
	}

	public void setAssignmentStatus(String assignmentStatus) {
		this.assignmentStatus = assignmentStatus;
	}

	public String getCaseInfoStatus() {
		return this.caseInfoStatus;
	}

	public void setCaseInfoStatus(String caseInfoStatus) {
		this.caseInfoStatus = caseInfoStatus;
	}

	public String getCaseStatus() {
		return this.caseStatus;
	}

	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

    public String getIdmType() {
        return idmType;
    }

    public void setIdmType(String idmType) {
        this.idmType = idmType;
    }

    public Integer getSpecialStatus() {
        return specialStatus;
    }

    public void setSpecialStatus(Integer specialStatus) {
        this.specialStatus = specialStatus;
    }

	/**
	 * @return the malariaDto
	 */
	public MalariaQueryDto getMalariaQueryDto() {
		return malariaQueryDto;
	}

	/**
	 * @param malariaQueryDto the malariaDto to set
	 */
	public void setMalariaQueryDto(MalariaQueryDto malariaQueryDto) {
		this.malariaQueryDto = malariaQueryDto;
	}

	public TbQueryDto getTbDto() {
		return tbDto;
	}

	public void setTbDto(TbQueryDto tbDto) {
		this.tbDto = tbDto;
	}

	public String getPlaceStatus() {
		return placeStatus;
	}

	public void setPlaceStatus(String placeStatus) {
		this.placeStatus = placeStatus;
	}

	/**
	 * @return the schDto
	 */
	public SchistosomeQueryDto getSchDto() {
		return schDto;
	}

	/**
	 * @param schDto the schDto to set
	 */
	public void setSchDto(SchistosomeQueryDto schDto) {
		this.schDto = schDto;
	}

    public FilariasisQueryDto getFilDto() {
        return filDto;
    }

    public void setFilDto(FilariasisQueryDto filDto) {
        this.filDto = filDto;
    }

    public LeprosyQueryDto getLeprosyQueryDto() {
		return leprosyQueryDto;
	}

	public void setLeprosyQueryDto(LeprosyQueryDto leprosyQueryDto) {
		this.leprosyQueryDto = leprosyQueryDto;
	}

	public String getLastUnit() {
		return lastUnit;
	}

	public void setLastUnit(String lastUnit) {
		this.lastUnit = lastUnit;
	}

	public String getCurrentUnit() {
		return currentUnit;
	}

	public void setCurrentUnit(String currentUnit) {
		this.currentUnit = currentUnit;
	}

    public String getFrStatus() {
        return frStatus;
    }

    public void setFrStatus(String frStatus) {
        this.frStatus = frStatus;
    }

    public String getTsStatus() {
        return tsStatus;
    }

    public void setTsStatus(String tsStatus) {
        this.tsStatus = tsStatus;
    }

    public Integer getLogoff() {
        return logoff == null ? 0 : logoff;
    }

    public void setLogoff(Integer logoff) {
        this.logoff = logoff;
    }

	public String getLastTown() {
		return lastTown;
	}

	public void setLastTown(String lastTown) {
		this.lastTown = lastTown;
	}

	public String getCurrentTown() {
		return currentTown;
	}

	public void setCurrentTown(String currentTown) {
		this.currentTown = currentTown;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

    public String getReportSource() {
		return reportSource;
	}

	public void setReportSource(String reportSource) {
		this.reportSource = reportSource;
	}
	
	public String getAssignedToUnit() {
		return assignedToUnit;
	}

	public void setAssignedToUnit(String assignedToUnit) {
		this.assignedToUnit = assignedToUnit;
	}

    public String getCasePassStatus() {
		return casePassStatus;
	}

	public void setCasePassStatus(String casePassStatus) {
		this.casePassStatus = casePassStatus;
	}
	
    public String getValidCaseStatus() {
		return validCaseStatus;
	}

	public void setValidCaseStatus(String validCaseStatus) {
		this.validCaseStatus = validCaseStatus;
	}

	public String getDangerFlag1() {
		return dangerFlag1;
	}

	public void setDangerFlag1(String dangerFlag1) {
		this.dangerFlag1 = dangerFlag1;
	}

	public String getDangerFlag2() {
		return dangerFlag2;
	}

	public void setDangerFlag2(String dangerFlag2) {
		this.dangerFlag2 = dangerFlag2;
	}

	public String getDangerFlag3() {
		return dangerFlag3;
	}

	public void setDangerFlag3(String dangerFlag3) {
		this.dangerFlag3 = dangerFlag3;
	}

	public String getDangerFlag4() {
		return dangerFlag4;
	}

	public void setDangerFlag4(String dangerFlag4) {
		this.dangerFlag4 = dangerFlag4;
	}

	public String getDangerFlag5() {
		return dangerFlag5;
	}

	public void setDangerFlag5(String dangerFlag5) {
		this.dangerFlag5 = dangerFlag5;
	}

	public String getNdyFlag() {
		return ndyFlag;
	}

	public void setNdyFlag(String ndyFlag) {
		this.ndyFlag = ndyFlag;
	}
}