
package com.founder.rhip.ehr.dto;

import java.math.BigDecimal;

import javax.persistence.Column;

import com.founder.rhip.ehr.common.EHRConstants;

public class HealthManageStatistics {

	private String orgcode; // 机构编码

	private Integer oldPeopleQuantity = 0; // 65岁老年人数

	private Integer physicalExamQuantity = 0; // 体检人数

	private Integer estimateQuantity = 0; // 评估人数

	private Integer guideQuantity = 0; // 指导人数
	
	private Integer physicalExamOtherQuantity = 0; // 除了新农合之外的65岁老年人数
	
	private Integer estimateGuideQuantity = 0; // 65岁以上老年人完整体检报告数（包括评估指导结果）

	private Integer healthManageQuantity = 0; // 健康管理人数
	
	private Integer  bloodBioQuantity = 0; // 参加血常规、生化人数
	
	private Integer urineRoutineQuantity = 0; // 参加尿常规检查人数
	
	private Integer ecgQuantity = 0; // 参加心电图检查人数
	
	private Integer bUltrasonicQuantity; // 参加B超检查人数
	
	private Integer xRayQuantity; // 参加胸部X线透视检查人数
	
	private Integer bpvQuantity; // 血压异常人数
	
	private Integer ifgQuantity; // 血糖异常人数
	
	private Integer dyslipidemiaQuantity; // 血脂异常人数
	
	private Integer liverAbnormalQuantity; // 肝功能异常人数
	
	private Integer renalAbnormalQuantity; // 肾功能异常人数
	
	private Integer xRayAbnormalQuantity; // 心电图异常人数

	private BigDecimal physicalExamRate; // 体检率

	private BigDecimal estimateRate; // 评估率

	private BigDecimal guideRate; // 指导率

	private BigDecimal healthManageRate; // 健康管理率

	public String getOrgcode() {
		return orgcode;
	}

	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}

	public Integer getOldPeopleQuantity() {
		return oldPeopleQuantity;
	}

	public void setOldPeopleQuantity(Integer oldPeopleQuantity) {
		this.oldPeopleQuantity = oldPeopleQuantity;
	}

	public Integer getEstimateQuantity() {
		return estimateQuantity;
	}

	public void setEstimateQuantity(Integer estimateQuantity) {
		this.estimateQuantity = estimateQuantity;
	}

	public Integer getGuideQuantity() {
		return guideQuantity;
	}

	public void setGuideQuantity(Integer guideQuantity) {
		this.guideQuantity = guideQuantity;
	}

	public Integer getHealthManageQuantity() {
		this.healthManageQuantity = physicalExamOtherQuantity + estimateGuideQuantity;
		return healthManageQuantity;
	}

	public void setHealthManageQuantity(Integer healthManageQuantity) {
		this.healthManageQuantity = healthManageQuantity;
	}

	public Integer getPhysicalExamQuantity() {
		return physicalExamQuantity;
	}

	public void setPhysicalExamQuantity(Integer physicalExamQuantity) {
		this.physicalExamQuantity = physicalExamQuantity;
	}

	public void setGuideRate(BigDecimal guideRate) {
		this.guideRate = guideRate;
	}

	public void setPhysicalExamRate(BigDecimal physicalExamRate) {
		this.physicalExamRate = physicalExamRate;
	}

	public void setEstimateRate(BigDecimal estimateRate) {
		this.estimateRate = estimateRate;
	}

	public void setHealthManageRate(BigDecimal healthManageRate) {
		this.healthManageRate = healthManageRate;
	}
	
	
	public Integer getPhysicalExamOtherQuantity() {
		return physicalExamOtherQuantity;
	}

	
	public void setPhysicalExamOtherQuantity(Integer physicalExamOtherQuantity) {
		this.physicalExamOtherQuantity = physicalExamOtherQuantity;
	}

	
	public Integer getEstimateGuideQuantity() {
		return estimateGuideQuantity;
	}

	
	public void setEstimateGuideQuantity(Integer estimateGuideQuantity) {
		this.estimateGuideQuantity = estimateGuideQuantity;
	}

	
	public Integer getBloodBioQuantity() {
		return bloodBioQuantity;
	}

	
	public void setBloodBioQuantity(Integer bloodBioQuantity) {
		this.bloodBioQuantity = bloodBioQuantity;
	}

	
	public Integer getUrineRoutineQuantity() {
		return urineRoutineQuantity;
	}

	
	public void setUrineRoutineQuantity(Integer urineRoutineQuantity) {
		this.urineRoutineQuantity = urineRoutineQuantity;
	}

	
	public Integer getEcgQuantity() {
		return ecgQuantity;
	}

	
	public void setEcgQuantity(Integer ecgQuantity) {
		this.ecgQuantity = ecgQuantity;
	}

	
	public Integer getbUltrasonicQuantity() {
		return bUltrasonicQuantity;
	}

	
	public void setbUltrasonicQuantity(Integer bUltrasonicQuantity) {
		this.bUltrasonicQuantity = bUltrasonicQuantity;
	}

	
	public Integer getxRayQuantity() {
		return xRayQuantity;
	}

	
	public void setxRayQuantity(Integer xRayQuantity) {
		this.xRayQuantity = xRayQuantity;
	}

	
	public Integer getBpvQuantity() {
		return bpvQuantity;
	}

	
	public void setBpvQuantity(Integer bpvQuantity) {
		this.bpvQuantity = bpvQuantity;
	}

	
	public Integer getIfgQuantity() {
		return ifgQuantity;
	}

	
	public void setIfgQuantity(Integer ifgQuantity) {
		this.ifgQuantity = ifgQuantity;
	}

	
	public Integer getDyslipidemiaQuantity() {
		return dyslipidemiaQuantity;
	}

	
	public void setDyslipidemiaQuantity(Integer dyslipidemiaQuantity) {
		this.dyslipidemiaQuantity = dyslipidemiaQuantity;
	}

	
	public Integer getLiverAbnormalQuantity() {
		return liverAbnormalQuantity;
	}

	
	public void setLiverAbnormalQuantity(Integer liverAbnormalQuantity) {
		this.liverAbnormalQuantity = liverAbnormalQuantity;
	}

	
	public Integer getRenalAbnormalQuantity() {
		return renalAbnormalQuantity;
	}

	
	public void setRenalAbnormalQuantity(Integer renalAbnormalQuantity) {
		this.renalAbnormalQuantity = renalAbnormalQuantity;
	}

	
	public Integer getxRayAbnormalQuantity() {
		return xRayAbnormalQuantity;
	}

	
	public void setxRayAbnormalQuantity(Integer xRayAbnormalQuantity) {
		this.xRayAbnormalQuantity = xRayAbnormalQuantity;
	}

	/**
	 * 计算体检率
	 * @return
	 */
	public BigDecimal getPhysicalExamRate() {
		if (oldPeopleQuantity == 0 || physicalExamQuantity == 0) {
			return BigDecimal.ZERO.setScale(EHRConstants.STATISTICS_PRECISION);
		}
		this.physicalExamRate = new BigDecimal(physicalExamQuantity).divide(new BigDecimal(
				oldPeopleQuantity), EHRConstants.STATISTICS_PRECISION, BigDecimal.ROUND_HALF_UP);
		return physicalExamRate;
	}

	/**
	 * 计算评估率
	 * @return
	 */
	public BigDecimal getEstimateRate() {
		if (oldPeopleQuantity == 0 || estimateQuantity == 0) {
			return BigDecimal.ZERO.setScale(EHRConstants.STATISTICS_PRECISION);
		}
		this.estimateRate = new BigDecimal(estimateQuantity).divide(new BigDecimal(
				oldPeopleQuantity), EHRConstants.STATISTICS_PRECISION, BigDecimal.ROUND_HALF_UP);
		return estimateRate;
	}

	/**
	 * 计算指导率
	 * @return
	 */
	public BigDecimal getGuideRate() {
		if (oldPeopleQuantity == 0 || guideQuantity == 0) {
			return BigDecimal.ZERO.setScale(EHRConstants.STATISTICS_PRECISION);
		}
		this.guideRate = new BigDecimal(guideQuantity).divide(new BigDecimal(oldPeopleQuantity),
				EHRConstants.STATISTICS_PRECISION, BigDecimal.ROUND_HALF_UP);
		return guideRate;
	}

	/**
	 * 计算健康管理率
	 * @return
	 */
	public BigDecimal getHealthManageRate() {
		if (oldPeopleQuantity == 0 || physicalExamOtherQuantity == 0 && estimateGuideQuantity == 0) {
			return BigDecimal.ZERO.setScale(EHRConstants.STATISTICS_PRECISION);
		}
		this.healthManageRate = new BigDecimal(physicalExamOtherQuantity).add(new BigDecimal(estimateGuideQuantity)).divide(new BigDecimal(
				oldPeopleQuantity), EHRConstants.STATISTICS_PRECISION, BigDecimal.ROUND_HALF_UP);
		return healthManageRate;
	}
}
