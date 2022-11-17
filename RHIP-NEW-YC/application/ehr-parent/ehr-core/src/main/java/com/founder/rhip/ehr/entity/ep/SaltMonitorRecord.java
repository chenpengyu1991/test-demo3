package com.founder.rhip.ehr.entity.ep;

import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.common.EHRConstants;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "EP_SALT_MONITOR_RECORD")
public class SaltMonitorRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;

	@Column(name = "SAMPLING_ID", columnDefinition = "NUMBER|抽样ID||", length = 11, nullable = true)
	private Long samplingId;

	@Column(name = "FUNCTION", columnDefinition = "VAR2|功能||", length = 20 , nullable = true)
	private String function;

	@Column(name = "SURVEY_TYPE", columnDefinition = "VAR2|监测类型||", length = 20 , nullable = true)
	private String surveyType;

	@Column(name = "GB_CODE", columnDefinition = "VAR2|乡镇代码||", length = 18 , nullable = true)
	private String gbCode;

	@Column(name = "VILLAGE_CODE", columnDefinition = "VAR2|行政村代码||", length = 18 , nullable = true)
	private String villageCode;

	@Column(name = "HOUSE_NUMBER", columnDefinition = "VAR2|门牌号||", length = 50 , nullable = true)
	private String houseNumber;

	@Column(name = "NAME", columnDefinition = "VAR2|户主姓名或企业商店名称||", length = 100 , nullable = true)
	private String name;

	@Column(name = "ID_CARD", columnDefinition = "VAR2|身份证号||", length = 50 , nullable = true)
	private String idCard;

	@Column(name = "MONITOR_ID", columnDefinition = "VAR2|监测编码||", length = 50 , nullable = true)
	private String monitorId;

	@Column(name = "RANDOM_NUMBER", columnDefinition = "VAR2|随机号||", length = 51 , nullable = true)
	private String randomNumber;

	@Column(name = "TELEPHONE", columnDefinition = "VAR2|联系电话||", length = 50 , nullable = true)
	private String telephone;

	@Column(name = "GRAVIDA_STATUS", columnDefinition = "VAR2|家中是否有孕妇||", length = 1 , nullable = true)
	private String gravidaStatus;

	@Column(name = "KNOWN_IDD_FLAG", columnDefinition = "VAR2|是否知道碘缺乏病||", length = 1 , nullable = true)
	private String knownIddFlag;

	@Column(name = "IDD_PREVENTABLE_FLAG", columnDefinition = "VAR2|是否知道碘缺乏病||", length = 1 , nullable = true)
	private String iddPreventableFlag;

	@Column(name = "PREMUNITION", columnDefinition = "VAR2|碘缺乏的主要预防措施||", length = 20 , nullable = true)
	private String premunition;

	@Column(name = "SALT_CHOICE_FACTOR", columnDefinition = "VAR2|家庭选择食盐的主要因素||", length = 20 , nullable = true)
	private String saltChoiceFactor;

	@Column(name = "SALT_SAMPLING_NUMBER", columnDefinition = "VAR2|盐样编号||", length = 50 , nullable = true)
	private String saltSamplingNumber;

	@Column(name = "MONITOR_PERSON", columnDefinition = "VAR2|监测人||", length = 50 , nullable = true)
	private String monitorPerson;

	@Column(name = "RESPONSIBLE_PERSON", columnDefinition = "VAR2|负责人||", length = 50 , nullable = true)
	private String responsiblePerson;

	@Column(name = "MONITOR_UNIT", columnDefinition = "VAR2|监测单位||", length = 50 , nullable = true)
	private String monitorUnit;

	@Column(name = "MONITOR_TIME", columnDefinition = "DATE|监测时间||", nullable = true)
	private Date monitorTime;

	@Column(name = "MONITOR_YEAR", columnDefinition = "VAR2|监测年份||", length = 10 , nullable = true)
	private String monitorYear;

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
	private Integer deleteFlag = EHRConstants.DELETE_FLG_0;

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

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getSurveyType() {
		return this.surveyType;
	}

	public void setSurveyType(String surveyType) {
		this.surveyType = surveyType;
	}

	public String getGbCode() {
		return this.gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	public String getVillageCode() {
		return this.villageCode;
	}

	public void setVillageCode(String villageCode) {
		this.villageCode = villageCode;
	}

	public String getHouseNumber() {
		return this.houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getMonitorId() {
		return this.monitorId;
	}

	public void setMonitorId(String monitorId) {
		this.monitorId = monitorId;
	}

	public String getRandomNumber() {
		return this.randomNumber;
	}

	public void setRandomNumber(String randomNumber) {
		this.randomNumber = randomNumber;
	}

	public String getSaltSamplingNumber() {
		return saltSamplingNumber;
	}

	public void setSaltSamplingNumber(String saltSamplingNumber) {
		this.saltSamplingNumber = saltSamplingNumber;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getGravidaStatus() {
		return this.gravidaStatus;
	}

	public void setGravidaStatus(String gravidaStatus) {
		this.gravidaStatus = gravidaStatus;
	}

	public String getKnownIddFlag() {
		return this.knownIddFlag;
	}

	public void setKnownIddFlag(String knownIddFlag) {
		this.knownIddFlag = knownIddFlag;
	}

	public String getIddPreventableFlag() {
		return iddPreventableFlag;
	}

	public void setIddPreventableFlag(String iddPreventableFlag) {
		this.iddPreventableFlag = iddPreventableFlag;
	}

	public String getPremunition() {
		return this.premunition;
	}

	public void setPremunition(String premunition) {
		this.premunition = premunition;
	}

	public String getSaltChoiceFactor() {
		return this.saltChoiceFactor;
	}

	public void setSaltChoiceFactor(String saltChoiceFactor) {
		this.saltChoiceFactor = saltChoiceFactor;
	}

	public String getMonitorPerson() {
		return this.monitorPerson;
	}

	public void setMonitorPerson(String monitorPerson) {
		this.monitorPerson = monitorPerson;
	}

	public String getResponsiblePerson() {
		return this.responsiblePerson;
	}

	public void setResponsiblePerson(String responsiblePerson) {
		this.responsiblePerson = responsiblePerson;
	}

	public String getMonitorUnit() {
		return this.monitorUnit;
	}

	public void setMonitorUnit(String monitorUnit) {
		this.monitorUnit = monitorUnit;
	}

	public Date getMonitorTime() {
		return this.monitorTime;
	}

	public void setMonitorTime(Date monitorTime) {
		this.monitorTime = monitorTime;
		this.monitorYear = DateUtil.toDateString(monitorTime, "yyyy");
	}

	public String getMonitorYear() {
		return monitorYear;
	}

	public void setMonitorYear(String monitorYear) {
		this.monitorYear = monitorYear;
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