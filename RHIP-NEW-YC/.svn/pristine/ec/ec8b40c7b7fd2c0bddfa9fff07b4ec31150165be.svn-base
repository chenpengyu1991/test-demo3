package com.founder.rhip.ehr.dto;

import java.math.BigDecimal;
import java.util.List;

import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.fasf.util.ObjectUtil;


public class PhysicalExaminationStatisticsSummary {
	private Integer shouldExamQuantity = 0;
	private Integer actualExamQuantity = 0;
	private BigDecimal examRate;
	
	
	public PhysicalExaminationStatisticsSummary(List<PhysicalExaminationProgressStatistics> examStatisticses) {
		if (ObjectUtil.isNullOrEmpty(examStatisticses)) {
			return;
		}
		for (PhysicalExaminationProgressStatistics examStatistics : examStatisticses) {
			this.shouldExamQuantity += examStatistics.getShouldPhysicalExamQuantity();
			this.actualExamQuantity += examStatistics.getActualPhysicalExamQuantity();
		}
		if (shouldExamQuantity == 0 || actualExamQuantity == 0) {
			this.examRate = BigDecimal.ZERO.setScale(EHRConstants.STATISTICS_PRECISION);
			return;
		}
		this.examRate = new BigDecimal(actualExamQuantity).divide(new BigDecimal(
				shouldExamQuantity), EHRConstants.STATISTICS_PRECISION,
				BigDecimal.ROUND_HALF_UP);
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
	
	public BigDecimal getExamRate() {
		return examRate;
	}
	
	public void setExamRate(BigDecimal examRate) {
		this.examRate = examRate;
	}
	
	
}
