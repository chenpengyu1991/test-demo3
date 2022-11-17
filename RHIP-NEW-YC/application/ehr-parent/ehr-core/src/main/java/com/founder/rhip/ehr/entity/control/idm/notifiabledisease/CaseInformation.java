package com.founder.rhip.ehr.entity.control.idm.notifiabledisease;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 卡片信息
 * @author Jiang Haiying
 *
 */
@Entity
@Table(name = "IDM_CASE_INFORMATION")
public class CaseInformation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = false)
	private Long id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|本系统唯一编码||", length = 11, nullable = false)
	private Long idmId;

	@Column(name = "MEDI_RECORD_NUM", columnDefinition = "VARCHAR2|病历编号||", length = 50, nullable = true)
	private String mediRecordNum;

	@Column(name = "SURVEY_ORG", columnDefinition = "VARCHAR2|调查单位||", length = 200, nullable = true)
	private String surveyOrg;

	@Column(name = "MODIFY_SURVEY_ORG", columnDefinition = "VARCHAR2|调查单位(修改)||", length = 200, nullable = true)
	private String modifySurveyOrg;
	
	@Column(name = "RESPONDENTS", columnDefinition = "VARCHAR2|调查者||", length = 50, nullable = true)
	private String respondents;

	@Column(name = "MODIFY_RESPONDENTS", columnDefinition = "VARCHAR2|调查者(修改)||", length = 50, nullable = true)
	private String modifyRespondents;
	
	@Column(name = "AUDITOR", columnDefinition = "VARCHAR2|审核者||", length = 50, nullable = true)
	private String auditor;

	@Column(name = "SURVEY_DATE", columnDefinition = "DATE|调查时间||", nullable = true)
	private Date surveyDate;

	@Column(name = "MODIFY_SURVEY_DATE", columnDefinition = "DATE|调查时间(修改)||", nullable = true)
	private Date modifySurveyDate = new Date();
	
	@Column(name = "REPORT_ORG", columnDefinition = "VARCHAR2|报告单位||", length = 200, nullable = true)
	private String reportOrg;

	@Column(name = "REPORT_DATE", columnDefinition = "TIMESTAMP|报告日期||", nullable = true)
	private Date reportDate;

	@Column(name = "REPORT_PERSON", columnDefinition = "VARCHAR2|报告人姓名||", length = 50, nullable = true)
	private String reportPerson;

	@Column(name = "REPORT_PLACE", columnDefinition = "VARCHAR2|报告人所在地点||", length = 200, nullable = true)
	private String reportPlace;

	@Column(name = "SURVEY_NAME", columnDefinition = "VARCHAR2|调查人姓名||", length = 50, nullable = true)
	private String surveyName;

	@Column(name = "SURVEY_PLACE", columnDefinition = "VARCHAR2|调查人所在地点||", length = 200, nullable = true)
	private String surveyPlace;

	@Column(name = "COUNTY_SURVEY_DATE", columnDefinition = "DATE|县收到本表查表时间||", nullable = true)
	private Date countySurveyDate;

	@Column(name = "PROVINCE_SURVEY_DATE", columnDefinition = "DATE|省收到本调查表时间||", nullable = true)
	private Date provinceSurveyDate;

	@Column(name = "INFORMANT_PATIEN_REL", columnDefinition = "VARCHAR2|被调查者与患者关系||", length = 50, nullable = true)
	private String informantPatienRel;

	@Column(name = "ADMINI_DIV_CODE", columnDefinition = "VARCHAR2|行政区划代码||", length = 50, nullable = true)
	private String adminiDivCode;

	@Column(name = "WAY_RESEARCH_CODE", columnDefinition = "VARCHAR2|调查地点编码||", length = 50, nullable = true)
	private String wayResearchCode;

	@Column(name = "PATIENT_CODE", columnDefinition = "VARCHAR2|患者编码||", length = 50, nullable = true)
	private String patientCode;

	@Column(name = "FIRST_FOUND_ORG", columnDefinition = "VARCHAR2|病例的首次发现单位(具体到科室)||", length = 200, nullable = true)
	private String firstFoundOrg;

	@Column(name = "PHONE", columnDefinition = "VARCHAR2|电话||", length = 50, nullable = true)
	private String phone;

	@Column(name = "FAX", columnDefinition = "VARCHAR2|传真||", length = 50, nullable = true)
	private String fax;

	@Column(name = "MAIL", columnDefinition = "VARCHAR2|E-mail||", length = 50, nullable = true)
	private String mail;

	@Column(name = "DISCOVERY_DATE", columnDefinition = "TIMESTAMP|发现时间||", nullable = true)
	private Date discoveryDate;

	@Column(name = "FIRST_REPORT_ORG", columnDefinition = "VARCHAR2|首次报告单位||", length = 200, nullable = true)
	private String firstReportOrg;

	@Column(name = "RECEIVE_REPORT_ORG", columnDefinition = "VARCHAR2|接到报告单位||", length = 200, nullable = true)
	private String receiveReportOrg;

	@Column(name = "REPORT_TYPE", columnDefinition = "VARCHAR2|报告方式||", length = 2, nullable = true)
	private String reportType;

	@Column(name = "REPORT_DISEASES", columnDefinition = "VARCHAR2|报告疾病名称||", length = 200, nullable = true)
	private String reportDiseases;

	@Column(name = "IS_NETWORK_REPORT", columnDefinition = "VARCHAR2|首次报告时，是否进行网络直报||", length = 2, nullable = true)
	private String isNetworkReport;

	@Column(name = "NETWORK_REPORT_ORG", columnDefinition = "VARCHAR2|若进行网络直报，报告单位为||", length = 200, nullable = true)
	private String networkReportOrg;

	@Column(name = "DIRECT_REPORT_DATE", columnDefinition = "DATE|直报报告时间||", nullable = true)
	private Date directReportDate;

	@Column(name = "DIRECT_REPORT_DISEASES", columnDefinition = "VARCHAR2|直报报告疾病名称||", length = 200, nullable = true)
	private String directReportDiseases;

	@Column(name = "SURVEY_ORG_TYPE", columnDefinition = "VARCHAR2|调查单位类别||", length = 2, nullable = true)
	private String surveyOrgType;

	@Column(name = "REPORT_UNIT_TYPE", columnDefinition = "VARCHAR2|报告单位级别||", length = 2, nullable = true)
	private String reportUnitType;

    @Column(name = "CASE_NO", columnDefinition = "VARCHAR2|卡片编号||", length = 50, nullable = true)
    private String caseNo;

    @Column(name = "FIRST_REPORT_TYPE", columnDefinition = "VARCHAR2|首次报告方式||", length = 50, nullable = true)
    private String firstReportType;

    @Column(name = "REVIEW_UNIT", columnDefinition = "VARCHAR2|复查单位|200|", length = 200, nullable = true)
    private String reviewUnit;

    @Column(name = "RECOMMEND_DT", columnDefinition = "DATE|推荐时间||", nullable = true)
    private Date recommendDt;

    @Column(name = "RECOMMEND_UNIT", columnDefinition = "VARCHAR2|推荐单位|200|", length = 200, nullable = true)
    private String recommendUnit;

    @Column(name = "RECOMMEND_USER", columnDefinition = "VARCHAR2|推荐人|50|", length = 50, nullable = true)
    private String recommendUser;

    @Column(name = "TRANSFER_TREATMENT_UNIT", columnDefinition = "VARCHAR2|转诊单位|200|", length = 200, nullable = true)
    private String transferTreatmentUnit;

    @Column(name = "TRANSFER_TREATMENT_DOCTOR", columnDefinition = "VARCHAR2|转诊医生|50|", length = 50, nullable = true)
    private String transferTreatmentDoctor;

    @Column(name = "TRANSFER_TREATMENT_DT", columnDefinition = "DATE|转诊时间||", nullable = true)
    private Date transferTreatmentDt;

    @Column(name = "REGISTER_NO", columnDefinition = "VARCHAR2|登记号|50|", length = 50, nullable = true)
    private String registerNo;

    @Column(name = "MEDICAL_NO", columnDefinition = "VARCHAR2|病案号|50|", length = 50, nullable = true)
    private String medicalNo;

    @Column(name = "OUTPATIENT_NO", columnDefinition = "VARCHAR2|门诊序号|50|", length = 50, nullable = true)
    private String outpatientNo;

    @Column(name = "ACCEPT_UNIT", columnDefinition = "VARCHAR2|接收单位|100|", length = 100, nullable = true)
    private String acceptUnit;

    @Column(name = "ACCEPT_TOWN", columnDefinition = "VARCHAR2|接收单位所属位置|100|", length = 100, nullable = true)
    private String acceptTown;
    
    @Column(name = "CHANGE_DETAIL", columnDefinition = "VARCHAR2|变更内容|500|", length = 500, nullable = true)
    private String changeDetail;

    @Column(name = "CHANGE_DT", columnDefinition = "DATE|变更时间||", nullable = true)
    private Date changeDt;

    @Column(name = "CHANGE_USER", columnDefinition = "VARCHAR2|变更者|50|", length = 50, nullable = true)
    private String changeUser;

    @Column(name = "REVIEW_DT", columnDefinition = "DATE|复查日期||", nullable = true)
    private Date reviewDt;

    @Column(name = "REVIEW_USER", columnDefinition = "VARCHAR2|复查人|50|", length = 50, nullable = true)
    private String reviewUser;

    @Column(name = "REVIEW_RESULT", columnDefinition = "VARCHAR2|复查结果|2|", length = 2, nullable = true)
    private String reviewResult;

    @Column(name = "DUTY_DOCTOR", columnDefinition = "VARCHAR2|责任医生|50|", length = 50, nullable = true)
    private String dutyDoctor;

    @Column(name = "FOLLOWUP_DT", columnDefinition = "DATE|随访日期||", nullable = true)
    private Date followupDt;
    
    @Column(name = "MODIFY_UNIT", columnDefinition = "VARCHAR2|修改单位|100|", length = 100, nullable = true)
    private String modifyUnit;
    
    @Column(name = "MODIFY_DT", columnDefinition = "DATE|修改时间||", nullable = true)
    private Date modifyDt;

    @Column(name = "MODIFY_USER", columnDefinition = "VARCHAR2|修改人|50|", length = 50, nullable = true)
    private String modifyUser;
    
    @Column(name = "CASE_FILL_ORG", columnDefinition = "VARCHAR2|个案填表单位||", length = 200, nullable = true)
	private String caseFillOrg;

	@Column(name = "CASE_FILL_DATE", columnDefinition = "TIMESTAMP|个案填表日期||", nullable = true)
	private Date caseFillDate;

	@Column(name = "CASE_FILL_PERSON", columnDefinition = "VARCHAR2|个案填写人姓名||", length = 50, nullable = true)
	private String caseFillPerson;

	@Column(name = "SURVEY_ORG_GRADE", columnDefinition = "VARCHAR2|调查单位级别||", length = 2, nullable = true)
	private String surveyOrgGrade;

	@Column(name = "LIVE_TIME", columnDefinition = "VARCHAR2|发病时在现地址居住时间||", length = 2, nullable = true)
	private String liveTime;
	
	@Column(name = "YEARS", columnDefinition = "DATE|年度||",  nullable = true)
	private Date years;
    
    public Date getYears() {
		return years;
	}

	public void setYears(Date years) {
		this.years = years;
	}

	/*调查者姓名*/
    @Transient
    private String respondentsName;

    /*调查单位名称*/
    @Transient
    private String surveyOrgName;

    /*审核者姓名*/
    @Transient
    private String auditorName;

    /*发现时间*/
    @Transient
    private String discoveryDateHM;

    /*网络直报时间*/
    @Transient
    private String directReportDateHM ;

    /*报告时间*/
    @Transient
    private String reportDateHM ;

	public String getLiveTime() {
		return liveTime;
	}

	public void setLiveTime(String liveTime) {
		this.liveTime = liveTime;
	}

	public String getSurveyOrgGrade() {
		return surveyOrgGrade;
	}

	public void setSurveyOrgGrade(String surveyOrgGrade) {
		this.surveyOrgGrade = surveyOrgGrade;
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

	public String getMediRecordNum() {
		return this.mediRecordNum;
	}

	public void setMediRecordNum(String mediRecordNum) {
		this.mediRecordNum = mediRecordNum;
	}

	public String getSurveyOrg() {
		return this.surveyOrg;
	}

	public void setSurveyOrg(String surveyOrg) {
		this.surveyOrg = surveyOrg;
	}

	public String getRespondents() {
		return this.respondents;
	}

	public void setRespondents(String respondents) {
		this.respondents = respondents;
	}

	public String getAuditor() {
		return this.auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	public Date getSurveyDate() {
		return this.surveyDate;
	}

	public void setSurveyDate(Date surveyDate) {
		this.surveyDate = surveyDate;
	}

	public String getReportOrg() {
		return this.reportOrg;
	}

	public void setReportOrg(String reportOrg) {
		this.reportOrg = reportOrg;
	}

	public Date getReportDate() {
		return this.reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getReportPerson() {
		return this.reportPerson;
	}

	public void setReportPerson(String reportPerson) {
		this.reportPerson = reportPerson;
	}

	public String getReportPlace() {
		return this.reportPlace;
	}

	public void setReportPlace(String reportPlace) {
		this.reportPlace = reportPlace;
	}

	public String getSurveyName() {
		return this.surveyName;
	}

	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}

	public String getSurveyPlace() {
		return this.surveyPlace;
	}

	public void setSurveyPlace(String surveyPlace) {
		this.surveyPlace = surveyPlace;
	}

	public Date getCountySurveyDate() {
		return this.countySurveyDate;
	}

	public void setCountySurveyDate(Date countySurveyDate) {
		this.countySurveyDate = countySurveyDate;
	}

	public Date getProvinceSurveyDate() {
		return this.provinceSurveyDate;
	}

	public void setProvinceSurveyDate(Date provinceSurveyDate) {
		this.provinceSurveyDate = provinceSurveyDate;
	}

	public String getInformantPatienRel() {
		return this.informantPatienRel;
	}

	public void setInformantPatienRel(String informantPatienRel) {
		this.informantPatienRel = informantPatienRel;
	}

	public String getAdminiDivCode() {
		return this.adminiDivCode;
	}

	public void setAdminiDivCode(String adminiDivCode) {
		this.adminiDivCode = adminiDivCode;
	}

	public String getWayResearchCode() {
		return this.wayResearchCode;
	}

	public void setWayResearchCode(String wayResearchCode) {
		this.wayResearchCode = wayResearchCode;
	}

	public String getPatientCode() {
		return this.patientCode;
	}

	public void setPatientCode(String patientCode) {
		this.patientCode = patientCode;
	}

	public String getFirstFoundOrg() {
		return this.firstFoundOrg;
	}

	public void setFirstFoundOrg(String firstFoundOrg) {
		this.firstFoundOrg = firstFoundOrg;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getDiscoveryDate() {
		return this.discoveryDate;
	}

	public void setDiscoveryDate(Date discoveryDate) {
		this.discoveryDate = discoveryDate;
	}

	public String getFirstReportOrg() {
		return this.firstReportOrg;
	}

	public void setFirstReportOrg(String firstReportOrg) {
		this.firstReportOrg = firstReportOrg;
	}

	public String getReceiveReportOrg() {
		return this.receiveReportOrg;
	}

	public void setReceiveReportOrg(String receiveReportOrg) {
		this.receiveReportOrg = receiveReportOrg;
	}

	public String getReportType() {
		return this.reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getReportDiseases() {
		return this.reportDiseases;
	}

	public void setReportDiseases(String reportDiseases) {
		this.reportDiseases = reportDiseases;
	}

	public String getIsNetworkReport() {
		return this.isNetworkReport;
	}

	public void setIsNetworkReport(String isNetworkReport) {
		this.isNetworkReport = isNetworkReport;
	}

	public String getNetworkReportOrg() {
		return this.networkReportOrg;
	}

	public void setNetworkReportOrg(String networkReportOrg) {
		this.networkReportOrg = networkReportOrg;
	}

	public Date getDirectReportDate() {
		return this.directReportDate;
	}

	public void setDirectReportDate(Date directReportDate) {
		this.directReportDate = directReportDate;
	}

	public String getDirectReportDiseases() {
		return this.directReportDiseases;
	}

	public void setDirectReportDiseases(String directReportDiseases) {
		this.directReportDiseases = directReportDiseases;
	}

	public String getSurveyOrgType() {
		return this.surveyOrgType;
	}

	public void setSurveyOrgType(String surveyOrgType) {
		this.surveyOrgType = surveyOrgType;
	}

	public String getReportUnitType() {
		return this.reportUnitType;
	}

	public void setReportUnitType(String reportUnitType) {
		this.reportUnitType = reportUnitType;
	}

    public String getCaseNo() {
        return this.caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getRespondentsName() {
        return respondentsName;
    }

    public void setRespondentsName(String respondentsName) {
        this.respondentsName = respondentsName;
    }

    public String getSurveyOrgName() {
        return surveyOrgName;
    }

    public void setSurveyOrgName(String surveyOrgName) {
        this.surveyOrgName = surveyOrgName;
    }

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
    }

	
	/**
	 * @return the modifySurveyOrg
	 */
	public String getModifySurveyOrg() {
		return modifySurveyOrg;
	}

	
	/**
	 * @param modifySurveyOrg the modifySurveyOrg to set
	 */
	public void setModifySurveyOrg(String modifySurveyOrg) {
		this.modifySurveyOrg = modifySurveyOrg;
	}

	
	/**
	 * @return the modifyRespondents
	 */
	public String getModifyRespondents() {
		return modifyRespondents;
	}

	
	/**
	 * @param modifyRespondents the modifyRespondents to set
	 */
	public void setModifyRespondents(String modifyRespondents) {
		this.modifyRespondents = modifyRespondents;
	}

	
	/**
	 * @return the modifySurveyDate
	 */
	public Date getModifySurveyDate() {
		return modifySurveyDate;
	}

	
	/**
	 * @param modifySurveyDate the modifySurveyDate to set
	 */
	public void setModifySurveyDate(Date modifySurveyDate) {
		this.modifySurveyDate = modifySurveyDate;
	}

    public String getDiscoveryDateHM() {
        return discoveryDateHM;
    }

    public void setDiscoveryDateHM(String discoveryDateHM) {
        this.discoveryDateHM = discoveryDateHM;
    }

    public String getDirectReportDateHM() {
        return directReportDateHM;
    }

    public void setDirectReportDateHM(String directReportDateHM) {
        this.directReportDateHM = directReportDateHM;
    }

    public String getReportDateHM() {
        return reportDateHM;
    }

    public void setReportDateHM(String reportDateHM) {
        this.reportDateHM = reportDateHM;
    }

    public String getFirstReportType() {
        return firstReportType;
    }

    public void setFirstReportType(String firstReportType) {
        this.firstReportType = firstReportType;
    }

    public String getReviewUnit() {
        return this.reviewUnit;
    }

    public void setReviewUnit(String reviewUnit) {
        this.reviewUnit = reviewUnit;
    }

    public Date getRecommendDt() {
        return this.recommendDt;
    }

    public void setRecommendDt(Date recommendDt) {
        this.recommendDt = recommendDt;
    }

    public String getRecommendUnit() {
        return this.recommendUnit;
    }

    public void setRecommendUnit(String recommendUnit) {
        this.recommendUnit = recommendUnit;
    }

    public String getRecommendUser() {
        return this.recommendUser;
    }

    public void setRecommendUser(String recommendUser) {
        this.recommendUser = recommendUser;
    }

    public String getTransferTreatmentUnit() {
        return this.transferTreatmentUnit;
    }

    public void setTransferTreatmentUnit(String transferTreatmentUnit) {
        this.transferTreatmentUnit = transferTreatmentUnit;
    }

    public String getTransferTreatmentDoctor() {
        return this.transferTreatmentDoctor;
    }

    public void setTransferTreatmentDoctor(String transferTreatmentDoctor) {
        this.transferTreatmentDoctor = transferTreatmentDoctor;
    }

    public Date getTransferTreatmentDt() {
        return this.transferTreatmentDt;
    }

    public void setTransferTreatmentDt(Date transferTreatmentDt) {
        this.transferTreatmentDt = transferTreatmentDt;
    }

    public String getRegisterNo() {
        return this.registerNo;
    }

    public void setRegisterNo(String registerNo) {
        this.registerNo = registerNo;
    }

    public String getMedicalNo() {
        return this.medicalNo;
    }

    public void setMedicalNo(String medicalNo) {
        this.medicalNo = medicalNo;
    }

    public String getOutpatientNo() {
        return this.outpatientNo;
    }

    public void setOutpatientNo(String outpatientNo) {
        this.outpatientNo = outpatientNo;
    }

    public String getAcceptUnit() {
        return this.acceptUnit;
    }

    public void setAcceptUnit(String acceptUnit) {
        this.acceptUnit = acceptUnit;
    }

    public String getChangeDetail() {
        return this.changeDetail;
    }

    public void setChangeDetail(String changeDetail) {
        this.changeDetail = changeDetail;
    }

    public Date getChangeDt() {
        return this.changeDt;
    }

    public void setChangeDt(Date changeDt) {
        this.changeDt = changeDt;
    }

    public String getChangeUser() {
        return this.changeUser;
    }

    public void setChangeUser(String changeUser) {
        this.changeUser = changeUser;
    }

    public Date getReviewDt() {
        return this.reviewDt;
    }

    public void setReviewDt(Date reviewDt) {
        this.reviewDt = reviewDt;
    }

    public String getReviewUser() {
        return this.reviewUser;
    }

    public void setReviewUser(String reviewUser) {
        this.reviewUser = reviewUser;
    }

    public String getReviewResult() {
        return this.reviewResult;
    }

    public void setReviewResult(String reviewResult) {
        this.reviewResult = reviewResult;
    }

    public String getDutyDoctor() {
        return this.dutyDoctor;
    }

    public void setDutyDoctor(String dutyDoctor) {
        this.dutyDoctor = dutyDoctor;
    }

    public Date getFollowupDt() {
        return this.followupDt;
    }

    public void setFollowupDt(Date followupDt) {
        this.followupDt = followupDt;
    }

	/**
	 * @return the acceptTown
	 */
	public String getAcceptTown() {
		return acceptTown;
	}

	/**
	 * @param acceptTown the acceptTown to set
	 */
	public void setAcceptTown(String acceptTown) {
		this.acceptTown = acceptTown;
	}

	public String getModifyUnit() {
		return modifyUnit;
	}

	public void setModifyUnit(String modifyUnit) {
		this.modifyUnit = modifyUnit;
	}

	public Date getModifyDt() {
		return modifyDt;
	}

	public void setModifyDt(Date modifyDt) {
		this.modifyDt = modifyDt;
	}

	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	public String getCaseFillOrg() {
		return caseFillOrg;
	}

	public void setCaseFillOrg(String caseFillOrg) {
		this.caseFillOrg = caseFillOrg;
	}

	public Date getCaseFillDate() {
		return caseFillDate;
	}

	public void setCaseFillDate(Date caseFillDate) {
		this.caseFillDate = caseFillDate;
	}

	public String getCaseFillPerson() {
		return caseFillPerson;
	}

	public void setCaseFillPerson(String caseFillPerson) {
		this.caseFillPerson = caseFillPerson;
	}


}