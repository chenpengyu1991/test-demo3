package com.founder.rhip.ehr.entity.management.mhm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "MHM_ASSESS")
public class MhmAssess implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "EVENT_ID", columnDefinition = "NUMBER|本系统唯一编码|11|", length = 11, nullable = false)
	private Long eventId;

	@Column(name = "ASSESS_DT", columnDefinition = "DATE|评估日期||", nullable = true)
	private Date assessDt;

	@Column(name = "PROBLEM_1", columnDefinition = "VARCHAR2|栏1主要问题|2|", length = 2, nullable = true)
	private String problem_1;

	@Column(name = "PROBLEM_2", columnDefinition = "VARCHAR2|栏2目标和指标|2|", length = 2, nullable = true)
	private String problem_2;

	@Column(name = "PROBLEM_3", columnDefinition = "VARCHAR2|栏3采取治疗和康复策略|2|", length = 2, nullable = true)
	private String problem_3;

	@Column(name = "PROBLEM_4_USER", columnDefinition = "VARCHAR2|栏4责任人|2|", length = 2, nullable = true)
	private String problem_4User;

	@Column(name = "PROBLEM_4_FINISH", columnDefinition = "VARCHAR2|栏4按时完成|2|", length = 2, nullable = true)
	private String problem_4Finish;

	@Column(name = "EVALUATION", columnDefinition = "VARCHAR2|病情总体评估|2|", length = 2, nullable = true)
	private String evaluation;

	@Column(name = "LIVE_ARRANGE", columnDefinition = "NUMBER|个人生活料理|3|", length = 3, nullable = true)
	private Integer liveArrange;

	@Column(name = "HOUSEWORK", columnDefinition = "NUMBER|家务劳动|3|", length = 3, nullable = true)
	private Integer housework;

	@Column(name = "PRODUCTIVE_LABOR", columnDefinition = "NUMBER|生产劳动及工作|3|", length = 3, nullable = true)
	private Integer productiveLabor;

	@Column(name = "STUDY_CAPACITY", columnDefinition = "NUMBER|学习能力|3|", length = 3, nullable = true)
	private Integer studyCapacity;

	@Column(name = "INTERPERSONAL_COMMUNICATION", columnDefinition = "NUMBER|社会人际交往|3|", length = 3, nullable = true)
	private Integer interpersonalCommunication;

	@Column(name = "SOCIAL_FUNCTION", columnDefinition = "NUMBER|社会功能总评|3|", length = 3, nullable = true)
	private Integer socialFunction;

	@Column(name = "FILL_ORGAN_CODE", columnDefinition = "VARCHAR2|填写机构|100|", length = 100, nullable = true)
	private String fillOrganCode;

	@Column(name = "FILL_DOCTOR_ID", columnDefinition = "VARCHAR2|填写医生|50|", length = 50, nullable = true)
	private String fillDoctorId;

	@Column(name = "FILL_DATE", columnDefinition = "DATE|填写日期||", nullable = true)
	private Date fillDate;

	@Column(name = "MODIFY_ORGAN_CODE", columnDefinition = "VARCHAR2|修改机构|100|", length = 100, nullable = true)
	private String modifyOrganCode;

	@Column(name = "MODIFY_DOCTOR_ID", columnDefinition = "VARCHAR2|修改医生（评估人签字）|50|", length = 50, nullable = true)
	private String modifyDoctorId;

	@Column(name = "MODIFY_DATE", columnDefinition = "DATE|修改日期||", nullable = true)
	private Date modifyDate;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEventId() {
		return this.eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public Date getAssessDt() {
		return this.assessDt;
	}

	public void setAssessDt(Date assessDt) {
		this.assessDt = assessDt;
	}

	public String getProblem_1() {
		return problem_1;
	}

	public void setProblem_1(String problem_1) {
		this.problem_1 = problem_1;
	}

	public String getProblem_2() {
		return problem_2;
	}

	public void setProblem_2(String problem_2) {
		this.problem_2 = problem_2;
	}

	public String getProblem_3() {
		return problem_3;
	}

	public void setProblem_3(String problem_3) {
		this.problem_3 = problem_3;
	}

	public String getProblem_4User() {
		return problem_4User;
	}

	public void setProblem_4User(String problem_4User) {
		this.problem_4User = problem_4User;
	}

	public String getProblem_4Finish() {
		return problem_4Finish;
	}

	public void setProblem_4Finish(String problem_4Finish) {
		this.problem_4Finish = problem_4Finish;
	}

	public String getEvaluation() {
		return this.evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public Integer getLiveArrange() {
		return this.liveArrange;
	}

	public void setLiveArrange(Integer liveArrange) {
		this.liveArrange = liveArrange;
	}

	public Integer getHousework() {
		return this.housework;
	}

	public void setHousework(Integer housework) {
		this.housework = housework;
	}

	public Integer getProductiveLabor() {
		return this.productiveLabor;
	}

	public void setProductiveLabor(Integer productiveLabor) {
		this.productiveLabor = productiveLabor;
	}

	public Integer getStudyCapacity() {
		return this.studyCapacity;
	}

	public void setStudyCapacity(Integer studyCapacity) {
		this.studyCapacity = studyCapacity;
	}

	public Integer getInterpersonalCommunication() {
		return this.interpersonalCommunication;
	}

	public void setInterpersonalCommunication(Integer interpersonalCommunication) {
		this.interpersonalCommunication = interpersonalCommunication;
	}

	public Integer getSocialFunction() {
		return this.socialFunction;
	}

	public void setSocialFunction(Integer socialFunction) {
		this.socialFunction = socialFunction;
	}

	public String getFillOrganCode() {
		return this.fillOrganCode;
	}

	public void setFillOrganCode(String fillOrganCode) {
		this.fillOrganCode = fillOrganCode;
	}

	public String getFillDoctorId() {
		return this.fillDoctorId;
	}

	public void setFillDoctorId(String fillDoctorId) {
		this.fillDoctorId = fillDoctorId;
	}

	public Date getFillDate() {
		return this.fillDate;
	}

	public void setFillDate(Date fillDate) {
		this.fillDate = fillDate;
	}

	public String getModifyOrganCode() {
		return this.modifyOrganCode;
	}

	public void setModifyOrganCode(String modifyOrganCode) {
		this.modifyOrganCode = modifyOrganCode;
	}

	public String getModifyDoctorId() {
		return this.modifyDoctorId;
	}

	public void setModifyDoctorId(String modifyDoctorId) {
		this.modifyDoctorId = modifyDoctorId;
	}

	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

}