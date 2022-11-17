package com.founder.rhip.ehr.entity.ihm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "RP_HM_SIMPLE_DISEASE")
public class HmSimpleDisease implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;

	@Column(name = "ORGAN_CODE", columnDefinition = "VARCHAR2|医疗机构编码||", length = 20, nullable = true)
	private String organCode;

	@Column(name = "DISEASE_CODE", columnDefinition = "VARCHAR2|单病种编号||", length = 20, nullable = true)
	private String diseaseCode;

	@Column(name = "OUT_NUM", columnDefinition = "NUMBER|出院病人数||", length = 10, nullable = true)
	private Long outNum;

	@Column(name = "DISEASE_NUM", columnDefinition = "NUMBER|单病种人数||", length = 10, nullable = true)
	private Long diseaseNum;

	@Column(name = "OUT_HOSP_BED_NUM", columnDefinition = "NUMBER|出院病人占总床日数||", length = 10, nullable = true)
	private Long outHospBedNum;

	@Column(name = "INHOSP_3DAY_NUM", columnDefinition = "NUMBER|住院3日确诊人数||", length = 10, nullable = true)
	private Long inhosp3dayNum;

	@Column(name = "OUTHOSP_INHOSP_DAY", columnDefinition = "NUMBER|出院病人住院日||", length = 10, nullable = true)
	private Long outhospInhospDay;

	@Column(name = "INHOSP_DAYS", columnDefinition = "NUMBER|住院天数||", length = 10, nullable = true)
	private Long inhospDays;

	@Column(name = "PRE_OPERATE_DAYS", columnDefinition = "NUMBER|手术前住院日数||", length = 10, nullable = true)
	private Long preOperateDays;

	@Column(name = "AVERAGE_TOTAL", columnDefinition = "NUMBER|平均费用合计||", length = 16, scale = 4, precision = 2, nullable = true)
	private Long averageTotal;

	@Column(name = "AVERAGE_ROOM_FEE", columnDefinition = "NUMBER|平均费用房费||", length = 16, scale = 4, precision = 2, nullable = true)
	private Long averageRoomFee;

	@Column(name = "AVERAGE_MED_FEE", columnDefinition = "NUMBER|平均费用药费||", length = 16, scale = 4, precision = 2, nullable = true)
	private Long averageMedFee;

	@Column(name = "AVERAGE_OPERATE_FEE", columnDefinition = "NUMBER|平均费用手术费||", length = 16, scale = 4, precision = 2, nullable = true)
	private Long averageOperateFee;

	@Column(name = "AVERAGE_EXAM_FEE", columnDefinition = "NUMBER|平均费用检查治疗费||", length = 16, scale = 4, precision = 2, nullable = true)
	private Long averageExamFee;

	@Column(name = "INHOSP_TOTAL_FEE", columnDefinition = "NUMBER|住院人费用合计||", length = 16, scale = 4, precision = 2, nullable = true)
	private Long inhospTotalFee;

	@Column(name = "INHOSP_TOTALMEDCIAL_FEE", columnDefinition = "NUMBER|住院医疗总费用||", length = 16, scale = 4, precision = 2, nullable = true)
	private Long inhospTotalmedcialFee;

	@Column(name = "MED_FEE", columnDefinition = "NUMBER|药费||", length = 16, scale = 4, precision = 2, nullable = true)
	private Long medFee;

	@Column(name = "CURE_NUM", columnDefinition = "NUMBER|治愈人数||", length = 10, nullable = true)
	private Long cureNum;

	@Column(name = "IMPROVE_NUM", columnDefinition = "NUMBER|好转人数||", length = 10, nullable = true)
	private Long improveNum;

	@Column(name = "DIED_10DAY_NUM", columnDefinition = "NUMBER|十日病死人数||", length = 10, nullable = true)
	private Long died10dayNum;

	@Column(name = "DEATH_NUM", columnDefinition = "NUMBER|死亡人数||", length = 10, nullable = true)
	private Long deathNum;

	@Column(name = "OUT_HOSP_ACCORD_NUM", columnDefinition = "NUMBER|出院诊断符合数||", length = 10, nullable = true)
	private Long outHospAccordNum;

	@Column(name = "OPERATE_ACCORD_NUM", columnDefinition = "NUMBER|术前后诊断符合数||", length = 10, nullable = true)
	private Long operateAccordNum;

	@Column(name = "OPERATE_NUM", columnDefinition = "NUMBER|手术病人数||", length = 10, nullable = true)
	private Long operateNum;

	@Column(name = "DATEOPERATE_NUM", columnDefinition = "NUMBER|择期手术人数||", length = 10, nullable = true)
	private Long dateoperateNum;

	@Column(name = "IN_DOUBTFUL_NUM", columnDefinition = "NUMBER|入院疑诊数||", length = 10, nullable = true)
	private Long inDoubtfulNum;

	@Column(name = "PRE_DOUBTFUL_NUM", columnDefinition = "NUMBER|术前疑诊数||", length = 10, nullable = true)
	private Long preDoubtfulNum;

	@Column(name = "NONDIZ_OPERATE_NUM", columnDefinition = "NUMBER|无菌手术例数||", length = 10, nullable = true)
	private Long nondizOperateNum;

	@Column(name = "NONDIZ_OPERATE_INFECT", columnDefinition = "NUMBER|无菌手术感染例数||", length = 10, nullable = true)
	private Long nondizOperateInfect;

	@Column(name = "CREATE_DATE", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createDate;

	@Column(name = "UPDATE_DATE", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date updateDate;

	@Column(name = "INTEGRATION_DATE", columnDefinition = "DATE|集成时间||", nullable = true)
	private Date integrationDate;

	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除标志||", length = 1, nullable = true)
	private Long isDelete;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrganCode() {
		return this.organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getDiseaseCode() {
		return this.diseaseCode;
	}

	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}

	public Long getOutNum() {
		return this.outNum;
	}

	public void setOutNum(Long outNum) {
		this.outNum = outNum;
	}

	public Long getDiseaseNum() {
		return this.diseaseNum;
	}

	public void setDiseaseNum(Long diseaseNum) {
		this.diseaseNum = diseaseNum;
	}

	public Long getOutHospBedNum() {
		return this.outHospBedNum;
	}

	public void setOutHospBedNum(Long outHospBedNum) {
		this.outHospBedNum = outHospBedNum;
	}

	public Long getInhosp3dayNum() {
		return this.inhosp3dayNum;
	}

	public void setInhosp3dayNum(Long inhosp3dayNum) {
		this.inhosp3dayNum = inhosp3dayNum;
	}

	public Long getOuthospInhospDay() {
		return this.outhospInhospDay;
	}

	public void setOuthospInhospDay(Long outhospInhospDay) {
		this.outhospInhospDay = outhospInhospDay;
	}

	public Long getInhospDays() {
		return this.inhospDays;
	}

	public void setInhospDays(Long inhospDays) {
		this.inhospDays = inhospDays;
	}

	public Long getPreOperateDays() {
		return this.preOperateDays;
	}

	public void setPreOperateDays(Long preOperateDays) {
		this.preOperateDays = preOperateDays;
	}

	public Long getAverageTotal() {
		return this.averageTotal;
	}

	public void setAverageTotal(Long averageTotal) {
		this.averageTotal = averageTotal;
	}

	public Long getAverageRoomFee() {
		return this.averageRoomFee;
	}

	public void setAverageRoomFee(Long averageRoomFee) {
		this.averageRoomFee = averageRoomFee;
	}

	public Long getAverageMedFee() {
		return this.averageMedFee;
	}

	public void setAverageMedFee(Long averageMedFee) {
		this.averageMedFee = averageMedFee;
	}

	public Long getAverageOperateFee() {
		return this.averageOperateFee;
	}

	public void setAverageOperateFee(Long averageOperateFee) {
		this.averageOperateFee = averageOperateFee;
	}

	public Long getAverageExamFee() {
		return this.averageExamFee;
	}

	public void setAverageExamFee(Long averageExamFee) {
		this.averageExamFee = averageExamFee;
	}

	public Long getInhospTotalFee() {
		return this.inhospTotalFee;
	}

	public void setInhospTotalFee(Long inhospTotalFee) {
		this.inhospTotalFee = inhospTotalFee;
	}

	public Long getInhospTotalmedcialFee() {
		return this.inhospTotalmedcialFee;
	}

	public void setInhospTotalmedcialFee(Long inhospTotalmedcialFee) {
		this.inhospTotalmedcialFee = inhospTotalmedcialFee;
	}

	public Long getMedFee() {
		return this.medFee;
	}

	public void setMedFee(Long medFee) {
		this.medFee = medFee;
	}

	public Long getCureNum() {
		return this.cureNum;
	}

	public void setCureNum(Long cureNum) {
		this.cureNum = cureNum;
	}

	public Long getImproveNum() {
		return this.improveNum;
	}

	public void setImproveNum(Long improveNum) {
		this.improveNum = improveNum;
	}

	public Long getDied10dayNum() {
		return this.died10dayNum;
	}

	public void setDied10dayNum(Long died10dayNum) {
		this.died10dayNum = died10dayNum;
	}

	public Long getDeathNum() {
		return this.deathNum;
	}

	public void setDeathNum(Long deathNum) {
		this.deathNum = deathNum;
	}

	public Long getOutHospAccordNum() {
		return this.outHospAccordNum;
	}

	public void setOutHospAccordNum(Long outHospAccordNum) {
		this.outHospAccordNum = outHospAccordNum;
	}

	public Long getOperateAccordNum() {
		return this.operateAccordNum;
	}

	public void setOperateAccordNum(Long operateAccordNum) {
		this.operateAccordNum = operateAccordNum;
	}

	public Long getOperateNum() {
		return this.operateNum;
	}

	public void setOperateNum(Long operateNum) {
		this.operateNum = operateNum;
	}

	public Long getDateoperateNum() {
		return this.dateoperateNum;
	}

	public void setDateoperateNum(Long dateoperateNum) {
		this.dateoperateNum = dateoperateNum;
	}

	public Long getInDoubtfulNum() {
		return this.inDoubtfulNum;
	}

	public void setInDoubtfulNum(Long inDoubtfulNum) {
		this.inDoubtfulNum = inDoubtfulNum;
	}

	public Long getPreDoubtfulNum() {
		return this.preDoubtfulNum;
	}

	public void setPreDoubtfulNum(Long preDoubtfulNum) {
		this.preDoubtfulNum = preDoubtfulNum;
	}

	public Long getNondizOperateNum() {
		return this.nondizOperateNum;
	}

	public void setNondizOperateNum(Long nondizOperateNum) {
		this.nondizOperateNum = nondizOperateNum;
	}

	public Long getNondizOperateInfect() {
		return this.nondizOperateInfect;
	}

	public void setNondizOperateInfect(Long nondizOperateInfect) {
		this.nondizOperateInfect = nondizOperateInfect;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getIntegrationDate() {
		return this.integrationDate;
	}

	public void setIntegrationDate(Date integrationDate) {
		this.integrationDate = integrationDate;
	}

	public Long getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Long isDelete) {
		this.isDelete = isDelete;
	}

}