package com.founder.rhip.ehr.dto;

import java.math.BigDecimal;
import java.util.List;

import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.basic.ElderlyHealthStatistics;
import com.founder.fasf.util.ObjectUtil;


public class HealthManageStatisticsSummary {
	private Integer oldPeopleQuantity = 0;

	private Integer physicalExamQuantity = 0;

	private Integer estimateQuantity = 0;

	private Integer guideQuantity = 0;

	private Integer healthManageQuantity = 0;
	
	private Integer bloodBioQuantity = 0;
	
	private Integer urineRoutineQuantity = 0;
	
	private Integer ecgQuantity = 0;
	
	private Integer bUltrasonicQuantity = 0;
	
	private Integer xRayQuantity = 0;
	
	private Integer bpvQuantity = 0; // 血压异常人数
	
	private Integer ifgQuantity = 0; // 血糖异常人数
	
	private Integer dyslipidemiaQuantity = 0; // 血脂异常人数
	
	private Integer liverAbnormalQuantity = 0; // 肝功能异常人数
	
	private Integer renalAbnormalQuantity = 0; // 肾功能异常人数
	
	private Integer xRayAbnormalQuantity = 0; // 心电图异常人数
	
	private Integer hepaticCystQuantity = 0; // 肝囊肿人数
	
	private Integer fattyLiverQuantity = 0; // 脂肪肝人数
	
	private Integer gallStoneQuantity = 0; // 胆结石人数
	
	private Integer cholecystitisQuantity = 0; // 胆囊炎人数
	
	private Integer renalCystQuantity = 0; // 肾囊肿人数
	
	private Integer kidneyStoneQuantity = 0; // 肾结石人数
	
	private Integer tumorQuantity = 0; // 可疑肿瘤人数
	
	private Integer tuberculosisQuantity = 0; // 可疑肺结核人数

	private BigDecimal physicalExamRate;

	private BigDecimal estimateRate;

	private BigDecimal guideRate;

	private BigDecimal healthManageRate;

	
	public HealthManageStatisticsSummary(List<ElderlyHealthStatistics> elderlyHealthStatisticsList) {
		if (ObjectUtil.isNullOrEmpty(elderlyHealthStatisticsList)) {
			return;
		}
		
		for (ElderlyHealthStatistics elderlyHealthStatistics : elderlyHealthStatisticsList) {
			this.oldPeopleQuantity += elderlyHealthStatistics.getShouldExamQuantity() == null ? 0 : elderlyHealthStatistics.getShouldExamQuantity();
			this.physicalExamQuantity += elderlyHealthStatistics.getActualExamQuantity() == null ? 0 : elderlyHealthStatistics.getActualExamQuantity();
			this.bloodBioQuantity += elderlyHealthStatistics.getBloodBioQuantity() == null ? 0 : elderlyHealthStatistics.getBloodBioQuantity();
			this.urineRoutineQuantity += elderlyHealthStatistics.getUrineRoutineQuantity() == null ? 0 : elderlyHealthStatistics.getUrineRoutineQuantity();
			this.ecgQuantity += elderlyHealthStatistics.getEcgQuantity() == null ? 0 : elderlyHealthStatistics.getEcgQuantity();
			this.bUltrasonicQuantity += elderlyHealthStatistics.getbUltrasonicQuantity() == null ? 0 : elderlyHealthStatistics.getbUltrasonicQuantity();
			this.xRayQuantity += elderlyHealthStatistics.getxRayQuantity() == null ? 0 : elderlyHealthStatistics.getxRayQuantity();
			this.bpvQuantity += elderlyHealthStatistics.getBpvQuantity() == null ? 0 : elderlyHealthStatistics.getBpvQuantity();
			this.ifgQuantity += elderlyHealthStatistics.getIfgQuantity() == null ? 0 : elderlyHealthStatistics.getIfgQuantity();
			this.dyslipidemiaQuantity += elderlyHealthStatistics.getDyslipidemiaQuantity() == null ? 0 : elderlyHealthStatistics.getDyslipidemiaQuantity();
			this.liverAbnormalQuantity += elderlyHealthStatistics.getLiverAbnormalQuantity() == null ? 0 : elderlyHealthStatistics.getLiverAbnormalQuantity();
			this.renalAbnormalQuantity += elderlyHealthStatistics.getRenalAbnormalQuantity() == null ? 0 : elderlyHealthStatistics.getRenalAbnormalQuantity();
			this.xRayAbnormalQuantity += elderlyHealthStatistics.getxRayAbnormalQuantity() == null ? 0 : elderlyHealthStatistics.getxRayAbnormalQuantity();
			this.hepaticCystQuantity += elderlyHealthStatistics.getHepaticCystQuantity() == null ? 0 : elderlyHealthStatistics.getHepaticCystQuantity();
			this.fattyLiverQuantity += elderlyHealthStatistics.getFattyLiverQuantity() == null ? 0 : elderlyHealthStatistics.getFattyLiverQuantity();
			this.gallStoneQuantity += elderlyHealthStatistics.getGallStoneQuantity() == null ? 0 : elderlyHealthStatistics.getGallStoneQuantity();
			this.cholecystitisQuantity += elderlyHealthStatistics.getCholecystitisQuantity() == null ? 0 : elderlyHealthStatistics.getCholecystitisQuantity();
			this.renalCystQuantity += elderlyHealthStatistics.getRenalCystQuantity() == null ? 0 : elderlyHealthStatistics.getRenalCystQuantity();
			this.kidneyStoneQuantity += elderlyHealthStatistics.getKidneyStoneQuantity() == null ? 0 : elderlyHealthStatistics.getKidneyStoneQuantity();
			this.tumorQuantity += elderlyHealthStatistics.getTumorQuantity() == null ? 0 : elderlyHealthStatistics.getTumorQuantity();
			this.tuberculosisQuantity += elderlyHealthStatistics.getTuberculosisQuantity() == null ? 0 : elderlyHealthStatistics.getTuberculosisQuantity();
		}
		
		this.physicalExamRate = (physicalExamQuantity == 0 || oldPeopleQuantity == 0) ? BigDecimal.ZERO
				.setScale(EHRConstants.STATISTICS_PRECISION) : new BigDecimal(physicalExamQuantity)
				.divide(new BigDecimal(oldPeopleQuantity), EHRConstants.STATISTICS_PRECISION,
						BigDecimal.ROUND_HALF_UP);
		
		this.estimateRate = (estimateQuantity == 0 || oldPeopleQuantity == 0) ? BigDecimal.ZERO
				.setScale(EHRConstants.STATISTICS_PRECISION) : new BigDecimal(estimateQuantity)
				.divide(new BigDecimal(oldPeopleQuantity), EHRConstants.STATISTICS_PRECISION,
						BigDecimal.ROUND_HALF_UP);
			
		this.guideRate = (guideQuantity == 0 || oldPeopleQuantity == 0) ? BigDecimal.ZERO
				.setScale(EHRConstants.STATISTICS_PRECISION) : new BigDecimal(guideQuantity)
				.divide(new BigDecimal(oldPeopleQuantity), EHRConstants.STATISTICS_PRECISION,
						BigDecimal.ROUND_HALF_UP);
				
		this.healthManageRate = (healthManageQuantity == 0 || oldPeopleQuantity == 0) ? BigDecimal.ZERO
				.setScale(EHRConstants.STATISTICS_PRECISION) : new BigDecimal(healthManageQuantity)
				.divide(new BigDecimal(oldPeopleQuantity), EHRConstants.STATISTICS_PRECISION,
						BigDecimal.ROUND_HALF_UP);
		
	}
	
	public Integer getOldPeopleQuantity() {
		return oldPeopleQuantity;
	}

	
	public void setOldPeopleQuantity(Integer oldPeopleQuantity) {
		this.oldPeopleQuantity = oldPeopleQuantity;
	}

	
	public Integer getPhysicalExamQuantity() {
		return physicalExamQuantity;
	}

	
	public void setPhysicalExamQuantity(Integer physicalExamQuantity) {
		this.physicalExamQuantity = physicalExamQuantity;
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
		return healthManageQuantity;
	}

	
	public void setHealthManageQuantity(Integer healthManageQuantity) {
		this.healthManageQuantity = healthManageQuantity;
	}

	
	public BigDecimal getPhysicalExamRate() {
		return physicalExamRate;
	}

	
	public void setPhysicalExamRate(BigDecimal physicalExamRate) {
		this.physicalExamRate = physicalExamRate;
	}

	public BigDecimal getEstimateRate() {
		return estimateRate;
	}

	
	public void setEstimateRate(BigDecimal estimateRate) {
		this.estimateRate = estimateRate;
	}

	
	public BigDecimal getGuideRate() {
		return guideRate;
	}

	
	public void setGuideRate(BigDecimal guideRate) {
		this.guideRate = guideRate;
	}

	
	public BigDecimal getHealthManageRate() {
		return healthManageRate;
	}

	
	public void setHealthManageRate(BigDecimal healthManageRate) {
		this.healthManageRate = healthManageRate;
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

	
	public Integer getHepaticCystQuantity() {
		return hepaticCystQuantity;
	}

	
	public void setHepaticCystQuantity(Integer hepaticCystQuantity) {
		this.hepaticCystQuantity = hepaticCystQuantity;
	}

	
	public Integer getFattyLiverQuantity() {
		return fattyLiverQuantity;
	}

	
	public void setFattyLiverQuantity(Integer fattyLiverQuantity) {
		this.fattyLiverQuantity = fattyLiverQuantity;
	}

	
	public Integer getGallStoneQuantity() {
		return gallStoneQuantity;
	}

	
	public void setGallStoneQuantity(Integer gallStoneQuantity) {
		this.gallStoneQuantity = gallStoneQuantity;
	}

	
	public Integer getCholecystitisQuantity() {
		return cholecystitisQuantity;
	}

	
	public void setCholecystitisQuantity(Integer cholecystitisQuantity) {
		this.cholecystitisQuantity = cholecystitisQuantity;
	}

	
	public Integer getRenalCystQuantity() {
		return renalCystQuantity;
	}

	
	public void setRenalCystQuantity(Integer renalCystQuantity) {
		this.renalCystQuantity = renalCystQuantity;
	}

	
	public Integer getKidneyStoneQuantity() {
		return kidneyStoneQuantity;
	}

	
	public void setKidneyStoneQuantity(Integer kidneyStoneQuantity) {
		this.kidneyStoneQuantity = kidneyStoneQuantity;
	}

	
	public Integer getTumorQuantity() {
		return tumorQuantity;
	}

	
	public void setTumorQuantity(Integer tumorQuantity) {
		this.tumorQuantity = tumorQuantity;
	}

	
	public Integer getTuberculosisQuantity() {
		return tuberculosisQuantity;
	}

	
	public void setTuberculosisQuantity(Integer tuberculosisQuantity) {
		this.tuberculosisQuantity = tuberculosisQuantity;
	}
	
	
}
