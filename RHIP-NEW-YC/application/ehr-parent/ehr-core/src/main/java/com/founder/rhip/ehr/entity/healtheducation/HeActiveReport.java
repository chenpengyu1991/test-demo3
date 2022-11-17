package com.founder.rhip.ehr.entity.healtheducation;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "HE_ACTIVE_REPORT")
public class HeActiveReport implements Serializable {

	
	private static final long serialVersionUID = 1963006323231286809L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;

	@Column(name = "ORG_CODE", columnDefinition = "VARCHAR2|机构代码||", length = 18, nullable = true)
	private String orgCode;
	
	@Column(name = "CENTER_ORG_CODE", columnDefinition = "VARCHAR2|上级机构代码||", length = 18, nullable = true)
	private String centerOrgCode;

	@Column(name = "GBCODE", columnDefinition = "VARCHAR2|乡镇代码||", length = 18, nullable = true)
	private String gbcode;

	@Column(name = "REPORT_TYPE", columnDefinition = "VARCHAR2|报表类型||", length = 1, nullable = true)
	private String reportType;	

	@Column(name = "REPORT_YEAR", columnDefinition = "NUMBER|报表年份||", length = 4, nullable = true)
	private Integer reportYear;
	
	@Column(name = "REPORT_QUARTER", columnDefinition = "NUMBER|报表季度||", length = 1, nullable = true)
	private Integer reportQuarter;

	@Column(name = "PUBLICITY_DAY_NUM", columnDefinition = "NUMBER|卫生宣传日次数||", length = 5, nullable = true)
	private Integer publicityDayNum;

	@Column(name = "PARTICIPANT_NUM", columnDefinition = "NUMBER|参加人员（医务人员）数||", length = 5, nullable = true)
	private Integer participantNum;

	@Column(name = "LEADER_NUM", columnDefinition = "NUMBER|单位领导人次||", length = 5, nullable = true)
	private Integer leaderNum;	
	
	@Column(name = "PUBLICITY_SERVICE_NUM", columnDefinition = "NUMBER|卫生宣传服务对象人次||", length = 5, nullable = true)
	private Integer publicityServiceNum;

	@Column(name = "TELE_CONSULTATION_NUM", columnDefinition = "NUMBER|电话咨询人次||", length = 5, nullable = true)
	private Integer teleConsultationNum;

	@Column(name = "TELE_DUTY_NUM", columnDefinition = "NUMBER|电话咨询专人负责人数||", length = 5, nullable = true)
	private Integer teleDutyNum;		
		
	@Column(name = "INFORMATION_CONSULTATION_NUM", columnDefinition = "NUMBER|咨询台咨询人次||", length = 5, nullable = true)
	private Integer informationConsultationNum;

	@Column(name = "INFORMATION_DUTY_NUM", columnDefinition = "NUMBER|咨询台咨询专人负责人数||", length = 5, nullable = true)
	private Integer informationDutyNum;

	@Column(name = "STREET_CONSULTATION_NUM", columnDefinition = "NUMBER|街头咨询次数||", length = 5, nullable = true)
	private Integer streetConsultationNum;	
	
	@Column(name = "STREET_SERVICE_NUM", columnDefinition = "NUMBER|街头咨询服务对象人次||", length = 5, nullable = true)
	private Integer streetServiceNum;
	
	@Column(name = "STREET_DUTY_NUM", columnDefinition = "NUMBER|街头咨询专家人次||", length = 5, nullable = true)
	private Integer streetDutyNum;

	@Column(name = "LECTURE_NUM", columnDefinition = "NUMBER|讲座次数||", length = 5, nullable = true)
	private Integer lectureNum;

	@Column(name = "LECTURE_SERVICE_NUM", columnDefinition = "NUMBER|讲座服务对象人次||", length = 5, nullable = true)
	private Integer lectureServiceNum;
	
	@Column(name = "LECTURE_EXPERT_NUM", columnDefinition = "NUMBER|讲座专家人次||", length = 5, nullable = true)
	private Integer lectureExpertNum;
	
	@Column(name = "SPECIAL_MEETING_NUM", columnDefinition = "NUMBER|专题会议次数||", length = 5, nullable = true)
	private Integer specialMeetingNum;

	@Column(name = "MEETING_PERSONNEL_NUM", columnDefinition = "NUMBER|到会人员人次||", length = 5, nullable = true)
	private Integer meetingPersonnelNum;
	
	@Column(name = "MEETING_EXPERT_NUM", columnDefinition = "NUMBER|专题会议专家人次||", length = 5, nullable = true)
	private Integer meetingExpertNum;
	
	@Column(name = "TRAINING_NUM", columnDefinition = "NUMBER|培训次数||", length = 5, nullable = true)
	private Integer trainingNum;

	@Column(name = "TRAINING_OBJECT_NUM", columnDefinition = "NUMBER|培训对象人次||", length = 5, nullable = true)
	private Integer trainingObjectNum;
	
	@Column(name = "TRAINING_EXPERT_NUM", columnDefinition = "NUMBER|培训专家人次||", length = 5, nullable = true)
	private Integer trainingExpertNum;
	
	@Column(name = "VIDEO_NUM", columnDefinition = "NUMBER|放映录像次数||", length = 5, nullable = true)
	private Integer videoNum;

	@Column(name = "VIDEO_SERVICE_NUM", columnDefinition = "NUMBER|放映录像服务对象人次||", length = 5, nullable = true)
	private Integer videoServiceNum;
	
	@Column(name = "PROPAGANDA_COLUMN_NUM", columnDefinition = "NUMBER|宣传栏个数||", length = 5, nullable = true)
	private Integer propagandaColumnNum;
	
	@Column(name = "PUBLISHED_PERIOD_NUM", columnDefinition = "NUMBER|刊出期数||", length = 5, nullable = true)
	private Integer publishedPeriodNum;
	
	@Column(name = "EVALUATION_SURVEY_NUM", columnDefinition = "NUMBER|效果评测调研次数||", length = 5, nullable = true)
	private Integer evaluationSurveyNum;
	
	@Column(name = "SURVEY_OBJECT_NUM", columnDefinition = "NUMBER|调研对象人次||", length = 5, nullable = true)
	private Integer surveyObjectNum;
	
	@Column(name = "FILL_USER_CODE", columnDefinition = "VARCHAR2|填报人|50|", length = 50, nullable = false)
	private String fillUserCode;

	@Column(name = "FILL_DATE", columnDefinition = "DATE|填报日期||", nullable = true)
	private Date fillDate;

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public Integer getReportYear() {
		return reportYear;
	}

	public void setReportYear(Integer reportYear) {
		this.reportYear = reportYear;
	}

	public Integer getReportQuarter() {
		return reportQuarter;
	}

	public void setReportQuarter(Integer reportQuarter) {
		this.reportQuarter = reportQuarter;
	}

	public Integer getPublicityDayNum() {
		return publicityDayNum;
	}

	public void setPublicityDayNum(Integer publicityDayNum) {
		this.publicityDayNum = publicityDayNum;
	}

	public Integer getParticipantNum() {
		return participantNum;
	}

	public void setParticipantNum(Integer participantNum) {
		this.participantNum = participantNum;
	}

	public Integer getLeaderNum() {
		return leaderNum;
	}

	public void setLeaderNum(Integer leaderNum) {
		this.leaderNum = leaderNum;
	}

	public Integer getPublicityServiceNum() {
		return publicityServiceNum;
	}

	public void setPublicityServiceNum(Integer publicityServiceNum) {
		this.publicityServiceNum = publicityServiceNum;
	}

	public Integer getTeleConsultationNum() {
		return teleConsultationNum;
	}

	public void setTeleConsultationNum(Integer teleConsultationNum) {
		this.teleConsultationNum = teleConsultationNum;
	}

	public Integer getTeleDutyNum() {
		return teleDutyNum;
	}

	public void setTeleDutyNum(Integer teleDutyNum) {
		this.teleDutyNum = teleDutyNum;
	}

	public Integer getInformationConsultationNum() {
		return informationConsultationNum;
	}

	public void setInformationConsultationNum(Integer informationConsultationNum) {
		this.informationConsultationNum = informationConsultationNum;
	}

	public Integer getInformationDutyNum() {
		return informationDutyNum;
	}

	public void setInformationDutyNum(Integer informationDutyNum) {
		this.informationDutyNum = informationDutyNum;
	}

	public Integer getStreetConsultationNum() {
		return streetConsultationNum;
	}

	public void setStreetConsultationNum(Integer streetConsultationNum) {
		this.streetConsultationNum = streetConsultationNum;
	}

	public Integer getStreetServiceNum() {
		return streetServiceNum;
	}

	public void setStreetServiceNum(Integer streetServiceNum) {
		this.streetServiceNum = streetServiceNum;
	}

	public Integer getStreetDutyNum() {
		return streetDutyNum;
	}

	public void setStreetDutyNum(Integer streetDutyNum) {
		this.streetDutyNum = streetDutyNum;
	}

	public Integer getLectureNum() {
		return lectureNum;
	}

	public void setLectureNum(Integer lectureNum) {
		this.lectureNum = lectureNum;
	}

	public Integer getLectureServiceNum() {
		return lectureServiceNum;
	}

	public void setLectureServiceNum(Integer lectureServiceNum) {
		this.lectureServiceNum = lectureServiceNum;
	}

	public Integer getLectureExpertNum() {
		return lectureExpertNum;
	}

	public void setLectureExpertNum(Integer lectureExpertNum) {
		this.lectureExpertNum = lectureExpertNum;
	}

	public Integer getSpecialMeetingNum() {
		return specialMeetingNum;
	}

	public void setSpecialMeetingNum(Integer specialMeetingNum) {
		this.specialMeetingNum = specialMeetingNum;
	}

	public Integer getMeetingPersonnelNum() {
		return meetingPersonnelNum;
	}

	public void setMeetingPersonnelNum(Integer meetingPersonnelNum) {
		this.meetingPersonnelNum = meetingPersonnelNum;
	}

	public Integer getMeetingExpertNum() {
		return meetingExpertNum;
	}

	public void setMeetingExpertNum(Integer meetingExpertNum) {
		this.meetingExpertNum = meetingExpertNum;
	}

	public Integer getTrainingNum() {
		return trainingNum;
	}

	public void setTrainingNum(Integer trainingNum) {
		this.trainingNum = trainingNum;
	}

	public Integer getTrainingObjectNum() {
		return trainingObjectNum;
	}

	public void setTrainingObjectNum(Integer trainingObjectNum) {
		this.trainingObjectNum = trainingObjectNum;
	}

	public Integer getTrainingExpertNum() {
		return trainingExpertNum;
	}

	public void setTrainingExpertNum(Integer trainingExpertNum) {
		this.trainingExpertNum = trainingExpertNum;
	}

	public Integer getVideoNum() {
		return videoNum;
	}

	public void setVideoNum(Integer videoNum) {
		this.videoNum = videoNum;
	}

	public Integer getVideoServiceNum() {
		return videoServiceNum;
	}

	public void setVideoServiceNum(Integer videoServiceNum) {
		this.videoServiceNum = videoServiceNum;
	}

	public Integer getPropagandaColumnNum() {
		return propagandaColumnNum;
	}

	public void setPropagandaColumnNum(Integer propagandaColumnNum) {
		this.propagandaColumnNum = propagandaColumnNum;
	}

	public Integer getPublishedPeriodNum() {
		return publishedPeriodNum;
	}

	public void setPublishedPeriodNum(Integer publishedPeriodNum) {
		this.publishedPeriodNum = publishedPeriodNum;
	}

	public Integer getEvaluationSurveyNum() {
		return evaluationSurveyNum;
	}

	public void setEvaluationSurveyNum(Integer evaluationSurveyNum) {
		this.evaluationSurveyNum = evaluationSurveyNum;
	}

	public Integer getSurveyObjectNum() {
		return surveyObjectNum;
	}

	public void setSurveyObjectNum(Integer surveyObjectNum) {
		this.surveyObjectNum = surveyObjectNum;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrgCode() {
		return this.orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	

	
	public String getCenterOrgCode() {
		return centerOrgCode;
	}

	
	public void setCenterOrgCode(String centerOrgCode) {
		this.centerOrgCode = centerOrgCode;
	}

	
	public String getGbcode() {
		return gbcode;
	}

	public void setGbcode(String gbcode) {
		this.gbcode = gbcode;
	}
	
	public String getFillUserCode() {
		return fillUserCode;
	}

	public void setFillUserCode(String fillUserCode) {
		this.fillUserCode = fillUserCode;
	}

	public Date getFillDate() {
		return fillDate;
	}

	public void setFillDate(Date fillDate) {
		this.fillDate = fillDate;
	}
}
