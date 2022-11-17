
package com.founder.rhip.ehr.dto;

import java.math.BigDecimal;

import com.founder.rhip.ehr.common.EHRConstants;

public class PhysicalExaminationProgressStatistics {

	private String orgcode; // 机构编码

	private Integer shouldPhysicalExamQuantity = 0; // 应该体检人数

	private Integer actualPhysicalExamQuantity = 0; // 实际体检人数

	private BigDecimal physicalExamRate; // 体检率

	public String getOrgcode() {
		return orgcode;
	}

	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}

	public Integer getShouldPhysicalExamQuantity() {
		return shouldPhysicalExamQuantity;
	}

	public void setShouldPhysicalExamQuantity(Integer shouldPhysicalExamQuantity) {
		this.shouldPhysicalExamQuantity = shouldPhysicalExamQuantity;
	}

	public Integer getActualPhysicalExamQuantity() {
		return actualPhysicalExamQuantity;
	}

	public void setActualPhysicalExamQuantity(Integer actualPhysicalExamQuantity) {
		this.actualPhysicalExamQuantity = actualPhysicalExamQuantity;
	}

	/**
	 * 计算体检率
	 * @return
	 */
	public BigDecimal getPhysicalExamRate() {
		if (actualPhysicalExamQuantity == 0 || shouldPhysicalExamQuantity == 0) {
			return BigDecimal.ZERO.setScale(EHRConstants.STATISTICS_PRECISION);
		}
		this.physicalExamRate = new BigDecimal(actualPhysicalExamQuantity).divide(new BigDecimal(
				shouldPhysicalExamQuantity), EHRConstants.STATISTICS_PRECISION,
				BigDecimal.ROUND_HALF_UP);
		return physicalExamRate;
	}

	public void setPhysicalExamRate(BigDecimal physicalExamRate) {
		this.physicalExamRate = physicalExamRate;
	}
}
