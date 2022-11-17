package com.founder.rhip.ehr.entity.ep;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "EP_IDD_KNOWLEDGE_SURVEY")
public class IddKnowledgeSurvey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;

	@Column(name = "SAMPLING_ID", columnDefinition = "NUMBER|抽样ID||", length = 11, nullable = true)
	private Long samplingId;

	@Column(name = "SAMPLING_LOCATION_TYPE", columnDefinition = "VAR2|抽样点类型||", length = 50 , nullable = true)
	private String samplingLocationType;

	@Column(name = "SAMPLING_LOCATION_NAME", columnDefinition = "VAR2|抽样点名称||", length = 50 , nullable = true)
	private String samplingLocationName;

	@Column(name = "TOTAL_PERSON_NO", columnDefinition = "NUMBER|调查人数||", length = 5, nullable = true)
	private Integer totalPersonNo;

	@Column(name = "QUESTIONS_FOR_EACH", columnDefinition = "NUMBER|每人应答问题数||", length = 5, nullable = true)
	private Integer questionsForEach;

	@Column(name = "TOTAL_CORRECT_ANSWERS", columnDefinition = "NUMBER|正确答题数之和||", length = 5, nullable = true)
	private Integer totalCorrectAnswers;

	@Column(name = "AWARENESS_RATE", columnDefinition = "NUMBER|知晓率||", scale = 3, precision = 2, nullable = true)
	private Double awarenessRate;

	@Column(name = "INVESTIGATOR", columnDefinition = "VAR2|调查人||", length = 50 , nullable = true)
	private String investigator;

	@Column(name = "VERIFIER", columnDefinition = "VAR2|审核人||", length = 50 , nullable = true)
	private String verifier;

	@Column(name = "INVESTIGATE_UNIT", columnDefinition = "VAR2|调查单位||", length = 50 , nullable = true)
	private String investigateUnit;

	@Column(name = "INVESTIGATE_TIME", columnDefinition = "DATE|调查日期||", nullable = true)
	private Date investigateTime;

	@Column(name = "CREATE_PERSON", columnDefinition = "VAR2|创建人||", length = 50 , nullable = true)
	private String createPerson;

	@Column(name = "CREATE_ORGAN", columnDefinition = "VAR2|创建机构||", length = 50 , nullable = true)
	private String createOrgan;

	@Column(name = "CREATE_TIME", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createTime;

	@Column(name = "UPDATE_PERSON", columnDefinition = "VAR2|更新人||", length = 50 , nullable = true)
	private String updatePerson;

	@Column(name = "UPDATE_ORGAN", columnDefinition = "VAR2|更新机构||", length = 50 , nullable = true)
	private String updateOrgan;

	@Column(name = "UPDATE_TIME", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date updateTime;

	@Column(name = "DELETE_FLAG", columnDefinition = "VAR2|删除标识||", length = 1 , nullable = true)
	private Integer deleteFlag = 0;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSamplingId() {
		return this.samplingId;
	}

	public void setSamplingId(Long samplingId) {
		this.samplingId = samplingId;
	}

	public String getSamplingLocationType() {
		return this.samplingLocationType;
	}

	public void setSamplingLocationType(String samplingLocationType) {
		this.samplingLocationType = samplingLocationType;
	}

	public String getSamplingLocationName() {
		return this.samplingLocationName;
	}

	public void setSamplingLocationName(String samplingLocationName) {
		this.samplingLocationName = samplingLocationName;
	}

	public Integer getTotalPersonNo() {
		return this.totalPersonNo;
	}

	public void setTotalPersonNo(Integer totalPersonNo) {
		this.totalPersonNo = totalPersonNo;
	}

	public Integer getQuestionsForEach() {
		return this.questionsForEach;
	}

	public void setQuestionsForEach(Integer questionsForEach) {
		this.questionsForEach = questionsForEach;
	}

	public Integer getTotalCorrectAnswers() {
		return this.totalCorrectAnswers;
	}

	public void setTotalCorrectAnswers(Integer totalCorrectAnswers) {
		this.totalCorrectAnswers = totalCorrectAnswers;
	}

	public Double getAwarenessRate() {
		return this.awarenessRate;
	}

	public void setAwarenessRate(Double awarenessRate) {
		this.awarenessRate = awarenessRate;
	}

	public String getInvestigator() {
		return this.investigator;
	}

	public void setInvestigator(String investigator) {
		this.investigator = investigator;
	}

	public String getVerifier() {
		return this.verifier;
	}

	public void setVerifier(String verifier) {
		this.verifier = verifier;
	}

	public String getInvestigateUnit() {
		return this.investigateUnit;
	}

	public void setInvestigateUnit(String investigateUnit) {
		this.investigateUnit = investigateUnit;
	}

	public Date getInvestigateTime() {
		return this.investigateTime;
	}

	public void setInvestigateTime(Date investigateTime) {
		this.investigateTime = investigateTime;
	}

	public String getCreatePerson() {
		return this.createPerson;
	}

	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}

	public String getCreateOrgan() {
		return this.createOrgan;
	}

	public void setCreateOrgan(String createOrgan) {
		this.createOrgan = createOrgan;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdatePerson() {
		return this.updatePerson;
	}

	public void setUpdatePerson(String updatePerson) {
		this.updatePerson = updatePerson;
	}

	public String getUpdateOrgan() {
		return this.updateOrgan;
	}

	public void setUpdateOrgan(String updateOrgan) {
		this.updateOrgan = updateOrgan;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}