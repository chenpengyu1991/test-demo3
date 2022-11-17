package com.founder.rhip.ehr.entity.control.idm.statistics.report;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "IDM_STATISTICS")
public class StatisticsData implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "TYPE", columnDefinition = "NUMBER|类型|2|", length = 2, nullable = false)
	private Integer type;
	
	@Column(name = "DISEASE_CODE", columnDefinition = "VARCHAR2|疾病编码（二级编码，3位）|20|", length = 20, nullable = false)
	private String diseaseCode;

	@Column(name = "FILL_DATE", columnDefinition = "DATE|填报年月||", nullable = false)
	private Date fillDate;

	@Column(name = "FILL_ORGAN_CODE", columnDefinition = "VARCHAR2|填报机构编码|100|", length = 100, nullable = false)
	private String fillOrganCode;
	
	@Column(name = "GENRE_CODE", columnDefinition = "VARCHAR2|填报机构类别代码||", length = 20, nullable = true)
	private String genreCode;
	
	@Column(name = "FILL_USER_ID", columnDefinition = "VARCHAR2|填写人|50|", length = 50, nullable = false)
	private String fillUserId;

	@Column(name = "FILL_DT", columnDefinition = "DATE|填报日期||", nullable = false)
	private Date fillDt;

	@Column(name = "UNKNOWN_PERSON", columnDefinition = "NUMBER|访视情况-查无此人|10|", length = 10, nullable = true)
	private Integer unknownPerson;

	@Column(name = "MISDIAGNOSE", columnDefinition = "NUMBER|访视情况-误诊|10|", length = 10, nullable = true)
	private Integer misdiagnose;

	@Column(name = "INTERVIEW_OTHER", columnDefinition = "NUMBER|访视情况-其他人数|10|", length = 10, nullable = true)
	private Integer interviewOther;

	@Column(name = "VACCINATION_NUMBER", columnDefinition = "NUMBER|接种疫苗人数|10|", length = 10, nullable = true)
	private Integer vaccinationNumber;

	@Column(name = "OTHER", columnDefinition = "VARCHAR2|其他|100|", length = 100, nullable = true)
	private String other;

	@Column(name = "CULTURE", columnDefinition = "NUMBER|实验室检查依据-培养|10|", length = 10, nullable = true)
	private Integer culture;
	
	@Column(name = "WATER", columnDefinition = "NUMBER|可能感染因素-水|10|", length = 10, nullable = true)
	private Integer water;
	
	@Column(name = "FOOD", columnDefinition = "NUMBER|可能感染因素-食物|10|", length = 10, nullable = true)
	private Integer food;
	
	@Column(name = "CONTACT", columnDefinition = "NUMBER|可能感染因素-接触|10|", length = 10, nullable = true)
	private Integer contact;
	
	@Column(name = "UNSPECIFIED", columnDefinition = "NUMBER|可能感染因素-不详|10|", length = 10, nullable = true)
	private Integer unspecified;
	
	@Column(name = "CALL", columnDefinition = "NUMBER|病家消毒-上门|10|", length = 10, nullable = true)
	private Integer call;
	
	@Column(name = "SELF", columnDefinition = "NUMBER|病家消毒-自行|10|", length = 10, nullable = true)
	private Integer self;
	
	@Column(name = "BITE_MANY", columnDefinition = "NUMBER|一犬伤多人事件起数|10|", length = 10, nullable = true)
	private Integer biteMany;
	
	@Column(name = "DISPOSE_EPIDEMIC", columnDefinition = "NUMBER|处理疫点数|10|", length = 10, nullable = true)
	private Integer disposeEpidemic;
	
	@Column(name = "RABIES_OTHER", columnDefinition = "VARCHAR2|狂犬病防治-其他|100|", length = 100, nullable = true)
	private String rabiesOther;

	@Column(name = "EFD_DISPOSE", columnDefinition = "NUMBER|伤寒防制-处理数|10|", length = 10, nullable = true)
	private Integer efdDispose;
	
	@Column(name = "EFD_INSULATE", columnDefinition = "NUMBER|伤寒防制-隔离治疗数|10|", length = 10, nullable = true)
	private Integer efdInsulate;
	
	@Column(name = "DYSENTERY_DISPOSE", columnDefinition = "NUMBER|痢疾防制-处理数|10|", length = 10, nullable = true)
	private Integer dysenteryDispose;
	
	@Column(name = "DYSENTERY_INSULATE", columnDefinition = "NUMBER|痢疾防制-隔离治疗数|10|", length = 10, nullable = true)
	private Integer dysenteryInsulate;
	
	@Column(name = "HFMD_GRAVE", columnDefinition = "NUMBER|手足口病-重症病例数|10|", length = 10, nullable = true)
	private Integer hfmdGrave;
	
	@Column(name = "HFMD_DISPOSITION", columnDefinition = "NUMBER|手足口病-调查处置数|10|", length = 10, nullable = true)
	private Integer hfmdDisposition;
	
	@Column(name = "HFMD_AGGREGATION", columnDefinition = "NUMBER|手足口病-聚集性疫情起数|10|", length = 10, nullable = true)
	private Integer hfmdAggregation;
	
	@Column(name = "HFMD_INVESTIGATION", columnDefinition = "NUMBER|手足口病-调查起数|10|", length = 10, nullable = true)
	private Integer hfmdInvestigation;
	
	@Column(name = "HEV_FULMINANT", columnDefinition = "NUMBER|戊肝防制-暴发起数|10|", length = 10, nullable = true)
	private Integer hevFulminant;
	
	@Column(name = "HEV_DISPOSE", columnDefinition = "NUMBER|戊肝防制-处理起数|10|", length = 10, nullable = true)
	private Integer hevDispose;
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDiseaseCode() {
		return this.diseaseCode;
	}

	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}

	public Date getFillDate() {
		return this.fillDate;
	}

	public void setFillDate(Date fillDate) {
		this.fillDate = fillDate;
	}

	public String getFillOrganCode() {
		return this.fillOrganCode;
	}

	public void setFillOrganCode(String fillOrganCode) {
		this.fillOrganCode = fillOrganCode;
	}

	public Integer getUnknownPerson() {
		return this.unknownPerson;
	}

	public void setUnknownPerson(Integer unknownPerson) {
		this.unknownPerson = unknownPerson;
	}

	public Integer getMisdiagnose() {
		return this.misdiagnose;
	}

	public void setMisdiagnose(Integer misdiagnose) {
		this.misdiagnose = misdiagnose;
	}

	public Integer getInterviewOther() {
		return this.interviewOther;
	}

	public void setInterviewOther(Integer interviewOther) {
		this.interviewOther = interviewOther;
	}

	public Integer getVaccinationNumber() {
		return this.vaccinationNumber;
	}

	public void setVaccinationNumber(Integer vaccinationNumber) {
		this.vaccinationNumber = vaccinationNumber;
	}

	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getCulture() {
		return culture;
	}

	public void setCulture(Integer culture) {
		this.culture = culture;
	}

	public Integer getWater() {
		return water;
	}

	public void setWater(Integer water) {
		this.water = water;
	}

	public Integer getFood() {
		return food;
	}

	public void setFood(Integer food) {
		this.food = food;
	}

	public Integer getContact() {
		return contact;
	}

	public void setContact(Integer contact) {
		this.contact = contact;
	}

	public Integer getUnspecified() {
		return unspecified;
	}

	public void setUnspecified(Integer unspecified) {
		this.unspecified = unspecified;
	}

	public Integer getCall() {
		return call;
	}

	public void setCall(Integer call) {
		this.call = call;
	}

	public Integer getSelf() {
		return self;
	}

	public void setSelf(Integer self) {
		this.self = self;
	}

	/**
	 * @return the biteMany
	 */
	public Integer getBiteMany() {
		return biteMany;
	}

	/**
	 * @param biteMany the biteMany to set
	 */
	public void setBiteMany(Integer biteMany) {
		this.biteMany = biteMany;
	}

	/**
	 * @return the disposeEpidemic
	 */
	public Integer getDisposeEpidemic() {
		return disposeEpidemic;
	}

	/**
	 * @param disposeEpidemic the disposeEpidemic to set
	 */
	public void setDisposeEpidemic(Integer disposeEpidemic) {
		this.disposeEpidemic = disposeEpidemic;
	}

	/**
	 * @return the rabiesOther
	 */
	public String getRabiesOther() {
		return rabiesOther;
	}

	/**
	 * @param rabiesOther the rabiesOther to set
	 */
	public void setRabiesOther(String rabiesOther) {
		this.rabiesOther = rabiesOther;
	}

	/**
	 * @return the efdDispose
	 */
	public Integer getEfdDispose() {
		return efdDispose;
	}

	/**
	 * @param efdDispose the efdDispose to set
	 */
	public void setEfdDispose(Integer efdDispose) {
		this.efdDispose = efdDispose;
	}

	/**
	 * @return the efdInsulate
	 */
	public Integer getEfdInsulate() {
		return efdInsulate;
	}

	/**
	 * @param efdInsulate the efdInsulate to set
	 */
	public void setEfdInsulate(Integer efdInsulate) {
		this.efdInsulate = efdInsulate;
	}

	/**
	 * @return the dysenteryDispose
	 */
	public Integer getDysenteryDispose() {
		return dysenteryDispose;
	}

	/**
	 * @param dysenteryDispose the dysenteryDispose to set
	 */
	public void setDysenteryDispose(Integer dysenteryDispose) {
		this.dysenteryDispose = dysenteryDispose;
	}

	/**
	 * @return the dysenteryInsulate
	 */
	public Integer getDysenteryInsulate() {
		return dysenteryInsulate;
	}

	/**
	 * @param dysenteryInsulate the dysenteryInsulate to set
	 */
	public void setDysenteryInsulate(Integer dysenteryInsulate) {
		this.dysenteryInsulate = dysenteryInsulate;
	}

	/**
	 * @return the hfmdGrave
	 */
	public Integer getHfmdGrave() {
		return hfmdGrave;
	}

	/**
	 * @param hfmdGrave the hfmdGrave to set
	 */
	public void setHfmdGrave(Integer hfmdGrave) {
		this.hfmdGrave = hfmdGrave;
	}

	/**
	 * @return the hfmdDisposition
	 */
	public Integer getHfmdDisposition() {
		return hfmdDisposition;
	}

	/**
	 * @param hfmdDisposition the hfmdDisposition to set
	 */
	public void setHfmdDisposition(Integer hfmdDisposition) {
		this.hfmdDisposition = hfmdDisposition;
	}

	/**
	 * @return the hfmdAggregation
	 */
	public Integer getHfmdAggregation() {
		return hfmdAggregation;
	}

	/**
	 * @param hfmdAggregation the hfmdAggregation to set
	 */
	public void setHfmdAggregation(Integer hfmdAggregation) {
		this.hfmdAggregation = hfmdAggregation;
	}

	/**
	 * @return the hfmdInvestigation
	 */
	public Integer getHfmdInvestigation() {
		return hfmdInvestigation;
	}

	/**
	 * @param hfmdInvestigation the hfmdInvestigation to set
	 */
	public void setHfmdInvestigation(Integer hfmdInvestigation) {
		this.hfmdInvestigation = hfmdInvestigation;
	}

	/**
	 * @return the hevFulminant
	 */
	public Integer getHevFulminant() {
		return hevFulminant;
	}

	/**
	 * @param hevFulminant the hevFulminant to set
	 */
	public void setHevFulminant(Integer hevFulminant) {
		this.hevFulminant = hevFulminant;
	}

	/**
	 * @return the hevDispose
	 */
	public Integer getHevDispose() {
		return hevDispose;
	}

	/**
	 * @param hevDispose the hevDispose to set
	 */
	public void setHevDispose(Integer hevDispose) {
		this.hevDispose = hevDispose;
	}

	public String getFillUserId() {
		return fillUserId;
	}

	public void setFillUserId(String fillUserId) {
		this.fillUserId = fillUserId;
	}

	public Date getFillDt() {
		return fillDt;
	}

	public void setFillDt(Date fillDt) {
		this.fillDt = fillDt;
	}

	public String getGenreCode() {
		return genreCode;
	}

	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}

}