package com.founder.rhip.ehr.entity.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "DM_HIGHRISK_MANAGE_PLAN")
public class DmHighriskManagePlan implements Serializable {

	private static final long serialVersionUID = 7336088812756056820L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = true)
	private Long id;

	@Column(name = "PERSON_ID", columnDefinition = "NUMBER|个人信息唯一编号||", length = 11, nullable = true)
	private Long personId;

	@Column(name = "IDCARD", columnDefinition = "VARCHAR2|居民身份证/健康卡号||", length = 18, nullable = true)
	private String idcard;

	@Column(name = "GRADATION", columnDefinition = "VARCHAR2|阶段||", length = 1, nullable = true)
	private String gradation;

	@Column(name = "BODY_MASS_INDEX", columnDefinition = "DECIMAL|体重指数||", length = 2, scale = 2, nullable = true)
	private BigDecimal bodyMassIndex;

	@Column(name = "WAOSTLINE", columnDefinition = "DECIMAL|腰围(cm)||", length = 5, scale = 1, nullable = true)
	private BigDecimal waostline;

	@Column(name = "WEEKLY_TRAIN", columnDefinition = "INT|运动（次/周）||", nullable = true)
	private Integer weeklyTrain;

	@Column(name = "DAILY_SMOKE", columnDefinition = "DECIMAL|日吸烟量(支)||", length = 5, scale = 1, nullable = true)
	private BigDecimal dailySmoke;

	@Column(name = "WEEKLY_DRINNK", columnDefinition = "INT|饮酒（次/周）||", nullable = true)
	private Integer weeklyDrinnk;

	@Column(name = "DAILY_FISH", columnDefinition = "INT|每天吃鱼肉（两）||", nullable = true)
	private Integer dailyFish;

	@Column(name = "TC", columnDefinition = "DECIMAL|总胆固醇值(mmol/L)||", length = 5, scale = 2, nullable = true)
	private BigDecimal tc;

	@Column(name = "TRIGLYCERIDE_VALUE", columnDefinition = "DECIMAL|甘油三酯值(mmol/L)||", length = 3, scale = 1, nullable = true)
	private BigDecimal triglycerideValue;

	@Column(name = "FORMULATE_DATE", columnDefinition = "DATE|制定时间||", nullable = true)
	private Date formulateDate;

	@Column(name = "FORMULATE_DOCTOR_NAME", columnDefinition = "VARCHAR2|制定人姓名||", length = 50, nullable = true)
	private String formulateDoctorName;

	@Column(name = "FORMULATE_DOCTOR_CODE", columnDefinition = "VARCHAR2|制定人编码||", length = 18, nullable = true)
	private String formulateDoctorCode;

	@Column(name = "FORMULATE_ORGAN_NAME", columnDefinition = "VARCHAR2|制定机构名称||", length = 70, nullable = true)
	private String formulateOrganName;

	@Column(name = "FORMULATE_ORGAN_CODE", columnDefinition = "VARCHAR2|制定机构编码||", length = 50, nullable = true)
	private String formulateOrganCode;

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

	@Column(name = "YEAR", columnDefinition = "VARCHAR2|年度||", length = 4, nullable = true)
	private String year;
	
	@Column(name = "NEXT_VISIT_DATE", columnDefinition = "DATE|下次随访日期||", nullable = true)
	private Date nextVisitDate;
	
	public Date getNextVisitDate() {
		return nextVisitDate;
	}
	public void setNextVisitDate(Date nextVisitDate) {
		this.nextVisitDate = nextVisitDate;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getGradation() {
		return this.gradation;
	}

	public void setGradation(String gradation) {
		this.gradation = gradation;
	}

	public BigDecimal getBodyMassIndex() {
		return this.bodyMassIndex;
	}

	public void setBodyMassIndex(BigDecimal bodyMassIndex) {
		this.bodyMassIndex = bodyMassIndex;
	}

	public BigDecimal getWaostline() {
		return this.waostline;
	}

	public void setWaostline(BigDecimal waostline) {
		this.waostline = waostline;
	}

	public Integer getWeeklyTrain() {
		return this.weeklyTrain;
	}

	public void setWeeklyTrain(Integer weeklyTrain) {
		this.weeklyTrain = weeklyTrain;
	}

	public BigDecimal getDailySmoke() {
		return this.dailySmoke;
	}

	public void setDailySmoke(BigDecimal dailySmoke) {
		this.dailySmoke = dailySmoke;
	}

	public Integer getWeeklyDrinnk() {
		return this.weeklyDrinnk;
	}

	public void setWeeklyDrinnk(Integer weeklyDrinnk) {
		this.weeklyDrinnk = weeklyDrinnk;
	}

	public Integer getDailyFish() {
		return this.dailyFish;
	}

	public void setDailyFish(Integer dailyFish) {
		this.dailyFish = dailyFish;
	}

	public BigDecimal getTc() {
		return this.tc;
	}

	public void setTc(BigDecimal tc) {
		this.tc = tc;
	}

	public BigDecimal getTriglycerideValue() {
		return this.triglycerideValue;
	}

	public void setTriglycerideValue(BigDecimal triglycerideValue) {
		this.triglycerideValue = triglycerideValue;
	}

	public Date getFormulateDate() {
		return formulateDate;
	}

	public void setFormulateDate(Date formulateDate) {
		this.formulateDate = formulateDate;
	}

	public String getFormulateDoctorName() {
		return formulateDoctorName;
	}

	public void setFormulateDoctorName(String formulateDoctorName) {
		this.formulateDoctorName = formulateDoctorName;
	}

	public String getFormulateDoctorCode() {
		return formulateDoctorCode;
	}

	public void setFormulateDoctorCode(String formulateDoctorCode) {
		this.formulateDoctorCode = formulateDoctorCode;
	}

	public String getFormulateOrganName() {
		return formulateOrganName;
	}

	public void setFormulateOrganName(String formulateOrganName) {
		this.formulateOrganName = formulateOrganName;
	}

	public String getFormulateOrganCode() {
		return formulateOrganCode;
	}

	public void setFormulateOrganCode(String formulateOrganCode) {
		this.formulateOrganCode = formulateOrganCode;
	}

	public String getCreateOrganName() {
		return createOrganName;
	}

	public void setCreateOrganName(String createOrganName) {
		this.createOrganName = createOrganName;
	}

	public String getCreateOrganCode() {
		return createOrganCode;
	}

	public void setCreateOrganCode(String createOrganCode) {
		this.createOrganCode = createOrganCode;
	}

	public String getCreateDoctorName() {
		return createDoctorName;
	}

	public void setCreateDoctorName(String createDoctorName) {
		this.createDoctorName = createDoctorName;
	}

	public String getCreateDoctorCode() {
		return createDoctorCode;
	}

	public void setCreateDoctorCode(String createDoctorCode) {
		this.createDoctorCode = createDoctorCode;
	}

	public Date getCreateDate() {
		return createDate;
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

}