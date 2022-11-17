package com.founder.rhip.ehr.entity.portal;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "POLL")
public class Poll implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|自增长id|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "SURVEY_ID", columnDefinition = "NUMBER|调查表ID|11|", length = 11, nullable = true)
	private Long surveyId;

	@Column(name = "SPECIMEN", columnDefinition = "NUMBER|受访者|11|", length = 11, nullable = true)
	private Long specimen;

	@Column(name = "IS_FINISHED", columnDefinition = "VARCHAR2|是否提交|2|", length = 2, nullable = true)
	private String isFinished;

	@Column(name = "IS_ANONYMOUS", columnDefinition = "VARCHAR2|是否匿名|2|", length = 2, nullable = true)
	private String isAnonymous;

	@Column(name = "RECORD_DATE", columnDefinition = "DATE|记录日期||", nullable = true)
	private Date recordDate;

	@Transient
	private List<PollOption> pollOptions;
	
	@Transient
	private List<PollText> pollTexts;
	
	@Transient
	private SurveyRecord survey;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSurveyId() {
		return this.surveyId;
	}

	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}

	public Long getSpecimen() {
		return this.specimen;
	}

	public void setSpecimen(Long specimen) {
		this.specimen = specimen;
	}

	public String getIsFinished() {
		return this.isFinished;
	}

	public void setIsFinished(String isFinished) {
		this.isFinished = isFinished;
	}

	public String getIsAnonymous() {
		return this.isAnonymous;
	}

	public void setIsAnonymous(String isAnonymous) {
		this.isAnonymous = isAnonymous;
	}

	public Date getRecordDate() {
		return this.recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public List<PollOption> getPollOptions() {
		return pollOptions;
	}

	public void setPollOptions(List<PollOption> pollOptions) {
		this.pollOptions = pollOptions;
	}

	public List<PollText> getPollTexts() {
		return pollTexts;
	}

	public void setPollTexts(List<PollText> pollTexts) {
		this.pollTexts = pollTexts;
	}

	public SurveyRecord getSurvey() {
		return survey;
	}

	public void setSurvey(SurveyRecord survey) {
		this.survey = survey;
	}

}