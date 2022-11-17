package com.founder.rhip.ehr.entity.basic;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.founder.rhip.ehr.common.EHRConstants;

@Entity
@Table(name = "ECH_ELDERLY_HEALTH_STATISTICS")
public class ElderlyHealthStatistics {
	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|主键||", length = 11, nullable = true)
	private Long id;
	
	@Column(name = "ORG_CODE", columnDefinition = "VARCHAR|机构代码||", nullable = true)
	private String orgCode;
	
	@Column(name = "SHOULD_EXAM_QUANTITY", columnDefinition = "NUMBER|应体检人数||", nullable = true)
	private Integer shouldExamQuantity;
	
	@Column(name = "ACTUAL_EXAM_QUANTITY", columnDefinition = "NUMBER|实际检人数||", nullable = true)
	private Integer actualExamQuantity;
	
	@Column(name = "BLOOD_BIO_QUANTITY", columnDefinition = "NUMBER|参加血常规、生化人数||", nullable = true)
	private Integer  bloodBioQuantity;
	
	@Column(name = "URINE_ROUTINE_QUANTITY", columnDefinition = "NUMBER|参加尿常规检查人数||", nullable = true)
	private Integer urineRoutineQuantity;
	
	@Column(name = "ECG_QUANTITY", columnDefinition = "NUMBER|参加心电图检查人数||", nullable = true)
	private Integer ecgQuantity;
	
	@Column(name = "B_ULTRASONIC_QUANTITY", columnDefinition = "NUMBER|参加B超检查人数||", nullable = true)
	private Integer bUltrasonicQuantity;
	
	@Column(name = "X_RAY_QUANTITY", columnDefinition = "NUMBER|参加胸部X线透视检查人数||", nullable = true)
	private Integer xRayQuantity;
	
	@Column(name = "BPV_QUANTITY", columnDefinition = "NUMBER|血压异常人数||", nullable = true)
	private Integer bpvQuantity;
	
	@Column(name = "IFG_QUANTITY", columnDefinition = "NUMBER|血糖异常人数||", nullable = true)
	private Integer ifgQuantity;
	
	@Column(name = "DYSLIPIDEMIA_QUANTITY", columnDefinition = "NUMBER|血脂异常人数||", nullable = true)
	private Integer dyslipidemiaQuantity;
	
	@Column(name = "LIVER_ABNORMAL_QUANTITY", columnDefinition = "NUMBER|肝功能异常人数||", nullable = true)
	private Integer liverAbnormalQuantity;
	
	@Column(name = "RENAL_ABNORMAL_QUANTITY", columnDefinition = "NUMBER|肾功能异常人数||", nullable = true)
	private Integer renalAbnormalQuantity;
	
	@Column(name = "X_RAY_ABNORMAL_QUANTITY", columnDefinition = "NUMBER|心电图异常人数||", nullable = true)
	private Integer xRayAbnormalQuantity;
	
	@Column(name = "HEPATIC_CYST_QUANTITY", columnDefinition = "NUMBER|肝囊肿人数||", nullable = true)
	private Integer hepaticCystQuantity;
	
	@Column(name = "FATTY_LIVER_QUANTITY", columnDefinition = "NUMBER|脂肪肝人数||", nullable = true)
	private Integer fattyLiverQuantity;
	
	@Column(name = "GALL_STONE_QUANTITY", columnDefinition = "NUMBER|胆结石人数||", nullable = true)
	private Integer gallStoneQuantity;
	
	@Column(name = "CHOLECYSTITIS_QUANTITY", columnDefinition = "NUMBER|胆囊炎人数||", nullable = true)
	private Integer cholecystitisQuantity;
	
	@Column(name = "RENAL_CYST_QUANTITY", columnDefinition = "NUMBER|肾囊肿人数||", nullable = true)
	private Integer renalCystQuantity;
	
	@Column(name = "KIDNEY_STONE_QUANTITY", columnDefinition = "NUMBER|肾结石人数||", nullable = true)
	private Integer kidneyStoneQuantity;
	
	@Column(name = "TUMOR_QUANTITY", columnDefinition = "NUMBER|可疑肿瘤人数||", nullable = true)
	private Integer tumorQuantity;
	
	@Column(name = "TUBERCULOSIS_QUANTITY", columnDefinition = "NUMBER|可疑肺结核人数||", nullable = true)
	private Integer tuberculosisQuantity;
	
	@Column(name = "EXAM_YEAR", columnDefinition = "DATE|体检年份||", nullable = true)
	private Date examYear;
	
	private BigDecimal physicalExamRate;

	
	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	
	public Integer getShouldExamQuantity() {
		return shouldExamQuantity;
	}

	
	public void setShouldExamQuantity(Integer shouldExamQuantity) {
		this.shouldExamQuantity = shouldExamQuantity;
	}

	
	public Integer getActualExamQuantity() {
		return actualExamQuantity;
	}

	
	public void setActualExamQuantity(Integer actualExamQuantity) {
		this.actualExamQuantity = actualExamQuantity;
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


	
	public Date getExamYear() {
		return examYear;
	}


	
	public void setExamYear(Date examYear) {
		this.examYear = examYear;
	}


	
	public String getOrgCode() {
		return orgCode;
	}


	
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}


	@Transient
	public BigDecimal getPhysicalExamRate() {
		this.physicalExamRate = (actualExamQuantity == 0 || shouldExamQuantity == 0) ? BigDecimal.ZERO
				.setScale(EHRConstants.STATISTICS_PRECISION) : new BigDecimal(actualExamQuantity)
				.divide(new BigDecimal(shouldExamQuantity), EHRConstants.STATISTICS_PRECISION,
						BigDecimal.ROUND_HALF_UP);
		return physicalExamRate;
	}


	
	public void setPhysicalExamRate(BigDecimal physicalExamRate) {
		this.physicalExamRate = physicalExamRate;
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
