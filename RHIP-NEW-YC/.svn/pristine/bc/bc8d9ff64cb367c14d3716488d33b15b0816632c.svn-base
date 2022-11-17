package com.founder.rhip.ehr.entity.control.dmbc;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "DMBC_SEWAGE_TREATMENT")
public class DmbcSewageTreatment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, scale = 11, nullable = true)
	private Long id;

	@Column(name = "ORG_NAME", columnDefinition = "VARCHAR2|医疗机构名称||", length = 50, scale = 50, nullable = true)
	private String orgName;

	@Column(name = "ORIGINAL_POOL_LENGTH", columnDefinition = "VARCHAR2|原液池长||", length = 20, scale = 20, nullable = true)
	private String originalPoolLength;

	@Column(name = "ORIGINAL_POOL_WIDTH", columnDefinition = "VARCHAR2|原液池宽||", length = 20, scale = 20, nullable = true)
	private String originalPoolWidth;

	@Column(name = "ORIGINAL_POOL_HEIGHT", columnDefinition = "VARCHAR2|原液池高||", length = 20, scale = 20, nullable = true)
	private String originalPoolHeight;

	@Column(name = "REACTION_TANK_LENGTH", columnDefinition = "VARCHAR2|反应池长||", length = 20, scale = 20, nullable = true)
	private String reactionTankLength;

	@Column(name = "REACTION_TANK_WIDTH", columnDefinition = "VARCHAR2|反应池宽||", length = 20, scale = 20, nullable = true)
	private String reactionTankWidth;

	@Column(name = "REACTION_TANK_HEIGHT", columnDefinition = "VARCHAR2|反应池高||", length = 20, scale = 20, nullable = true)
	private String reactionTankHeight;

	@Column(name = "AVG_DAILY_OUTPUT", columnDefinition = "VARCHAR2|日均产生量||", length = 20, scale = 20, nullable = true)
	private String avgDailyOutput;

	@Column(name = "PROCESSING_PERIOD", columnDefinition = "VARCHAR2|污水处理周期||", length = 20, scale = 20, nullable = true)
	private String processingPeriod;

	@Column(name = "DISINFECTION_TREATMENT", columnDefinition = "VARCHAR2|消毒处理方式||", length = 20, scale = 20, nullable = true)
	private String disinfectionTreatment;

	@Column(name = "DISINFECTANT_NAME", columnDefinition = "VARCHAR2|消毒剂名称||", length = 40, scale = 40, nullable = true)
	private String disinfectantName;

	@Column(name = "EFFECTIVE_CONSTITUENT", columnDefinition = "VARCHAR2|有效成分||", length = 40, scale = 40, nullable = true)
	private String effectiveConstituent;

	@Column(name = "DIS_USAGE_AMOUNT", columnDefinition = "VARCHAR2|使用量（每次）||", length = 20, scale = 20, nullable = true)
	private String disUsageAmount;

	@Column(name = "PRODUCTION_UNIT", columnDefinition = "VARCHAR2|生产单位||", length = 40, scale = 40, nullable = true)
	private String productionUnit;

	@Column(name = "DIS_PRODUCTION_PERMIT", columnDefinition = "VARCHAR2|消毒剂是否有生产许可证||", length = 20, scale = 20, nullable = true)
	private String disProductionPermit;

	@Column(name = "MATERIAL_NAME", columnDefinition = "VARCHAR2|原料名称||", length = 40, scale = 40, nullable = true)
	private String materialName;

	@Column(name = "MAT_USAGE_AMOUNT", columnDefinition = "VARCHAR2|使用量（每吨）||", length = 20, nullable = true)
	private String matUsageAmount;

	@Column(name = "SOURCE", columnDefinition = "VARCHAR2|原料来源||", length = 40, scale = 40, nullable = true)
	private String source;

	@Column(name = "MAT_PRODUCTION_PERMIT", columnDefinition = "VARCHAR2|原料是否有生产许可证||", length = 20, nullable = true)
	private String matProductionPermit;

	@Column(name = "ASSIGNER_DEPT", columnDefinition = "VARCHAR2|处理人员所属科室||", length = 20, scale = 20, nullable = true)
	private String assignerDept;

	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别||", length = 20, scale = 20, nullable = true)
	private String gender;

	@Column(name = "AGE", columnDefinition = "VARCHAR2|年龄||", length = 20, scale = 20, nullable = true)
	private String age;

	@Column(name = "EDUCATION", columnDefinition = "VARCHAR2|文化程度||", length = 20, scale = 20, nullable = true)
	private String education;

	@Column(name = "YEARS", columnDefinition = "VARCHAR2|从事年数||", length = 20, scale = 20, nullable = true)
	private String years;

	@Column(name = "TRAIN_NUM", columnDefinition = "VARCHAR2|培训次数||", length = 20, scale = 20, nullable = true)
	private String trainNum;

	@Column(name = "COLORIMETRIC_EQ", columnDefinition = "VARCHAR2|余氯比色器材（有/无）||", length = 20, scale = 20, nullable = true)
	private String colorimetricEq;

	@Column(name = "COLORIMETRIC_REAGENT", columnDefinition = "VARCHAR2|余氯比色试剂（有/无）||", length = 20, scale = 20, nullable = true)
	private String colorimetricReagent;

	@Column(name = "KEEP_DARK", columnDefinition = "VARCHAR2|是否避光保存||", length = 20, scale = 20, nullable = true)
	private String keepDark;

	@Column(name = "CHANGE_TIME", columnDefinition = "DATE|试剂更换时间||", nullable = true)
	private Date changeTime;

	@Column(name = "ACCOUNT_RECORD", columnDefinition = "VARCHAR2|记录台帐资料（有/无）||", length = 20, scale = 20, nullable = true)
	private String accountRecord;

	@Column(name = "SUGGEST", columnDefinition = "VARCHAR2|问题和建议||", length = 200, scale = 200, nullable = true)
	private String suggest;

	@Column(name = "PIC_URL", columnDefinition = "VARCHAR2|流程图||", length = 200, scale = 200, nullable = true)
	private String picUrl;

	@Column(name = "MIN_URL", columnDefinition = "VARCHAR2|流程缩略图||", length = 200, scale = 200, nullable = true)
	private String minUrl;

	@Column(name = "CREATE_TIME", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createTime;

	@Column(name = "CREATE_BY", columnDefinition = "VARCHAR2|创建者||", length = 20, scale = 20, nullable = true)
	private String createBy;

	@Column(name = "UPDATE_TIME", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date updateTime;

	@Column(name = "UPDATE_BY", columnDefinition = "VARCHAR2|更新者||", length = 20, scale = 20, nullable = true)
	private String updateBy;

	@Column(name = "IS_DELETE", columnDefinition = "INT|删除状态||", nullable = true)
	private Integer isDelete;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOriginalPoolLength() {
		return this.originalPoolLength;
	}

	public void setOriginalPoolLength(String originalPoolLength) {
		this.originalPoolLength = originalPoolLength;
	}

	public String getOriginalPoolWidth() {
		return this.originalPoolWidth;
	}

	public void setOriginalPoolWidth(String originalPoolWidth) {
		this.originalPoolWidth = originalPoolWidth;
	}

	public String getOriginalPoolHeight() {
		return this.originalPoolHeight;
	}

	public void setOriginalPoolHeight(String originalPoolHeight) {
		this.originalPoolHeight = originalPoolHeight;
	}

	public String getReactionTankLength() {
		return this.reactionTankLength;
	}

	public void setReactionTankLength(String reactionTankLength) {
		this.reactionTankLength = reactionTankLength;
	}

	public String getReactionTankWidth() {
		return this.reactionTankWidth;
	}

	public void setReactionTankWidth(String reactionTankWidth) {
		this.reactionTankWidth = reactionTankWidth;
	}

	public String getReactionTankHeight() {
		return this.reactionTankHeight;
	}

	public void setReactionTankHeight(String reactionTankHeight) {
		this.reactionTankHeight = reactionTankHeight;
	}

	public String getAvgDailyOutput() {
		return this.avgDailyOutput;
	}

	public void setAvgDailyOutput(String avgDailyOutput) {
		this.avgDailyOutput = avgDailyOutput;
	}

	public String getProcessingPeriod() {
		return this.processingPeriod;
	}

	public void setProcessingPeriod(String processingPeriod) {
		this.processingPeriod = processingPeriod;
	}

	public String getDisinfectionTreatment() {
		return this.disinfectionTreatment;
	}

	public void setDisinfectionTreatment(String disinfectionTreatment) {
		this.disinfectionTreatment = disinfectionTreatment;
	}

	public String getDisinfectantName() {
		return this.disinfectantName;
	}

	public void setDisinfectantName(String disinfectantName) {
		this.disinfectantName = disinfectantName;
	}

	public String getEffectiveConstituent() {
		return this.effectiveConstituent;
	}

	public void setEffectiveConstituent(String effectiveConstituent) {
		this.effectiveConstituent = effectiveConstituent;
	}



	public String getProductionUnit() {
		return this.productionUnit;
	}

	public void setProductionUnit(String productionUnit) {
		this.productionUnit = productionUnit;
	}

	public String getMaterialName() {
		return this.materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getDisUsageAmount() {
		return disUsageAmount;
	}

	public void setDisUsageAmount(String disUsageAmount) {
		this.disUsageAmount = disUsageAmount;
	}

	public String getDisProductionPermit() {
		return disProductionPermit;
	}

	public void setDisProductionPermit(String disProductionPermit) {
		this.disProductionPermit = disProductionPermit;
	}

	public String getMatUsageAmount() {
		return matUsageAmount;
	}

	public void setMatUsageAmount(String matUsageAmount) {
		this.matUsageAmount = matUsageAmount;
	}

	public String getMatProductionPermit() {
		return matProductionPermit;
	}

	public void setMatProductionPermit(String matProductionPermit) {
		this.matProductionPermit = matProductionPermit;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getAssignerDept() {
		return this.assignerDept;
	}

	public void setAssignerDept(String assignerDept) {
		this.assignerDept = assignerDept;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getYears() {
		return this.years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public String getTrainNum() {
		return this.trainNum;
	}

	public void setTrainNum(String trainNum) {
		this.trainNum = trainNum;
	}

	public String getColorimetricEq() {
		return this.colorimetricEq;
	}

	public void setColorimetricEq(String colorimetricEq) {
		this.colorimetricEq = colorimetricEq;
	}

	public String getColorimetricReagent() {
		return this.colorimetricReagent;
	}

	public void setColorimetricReagent(String colorimetricReagent) {
		this.colorimetricReagent = colorimetricReagent;
	}

	public String getKeepDark() {
		return this.keepDark;
	}

	public void setKeepDark(String keepDark) {
		this.keepDark = keepDark;
	}

	public Date getChangeTime() {
		return this.changeTime;
	}

	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}

	public String getAccountRecord() {
		return this.accountRecord;
	}

	public void setAccountRecord(String accountRecord) {
		this.accountRecord = accountRecord;
	}

	public String getSuggest() {
		return this.suggest;
	}

	public void setSuggest(String suggest) {
		this.suggest = suggest;
	}

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getMinUrl() {
		return this.minUrl;
	}

	public void setMinUrl(String minUrl) {
		this.minUrl = minUrl;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}