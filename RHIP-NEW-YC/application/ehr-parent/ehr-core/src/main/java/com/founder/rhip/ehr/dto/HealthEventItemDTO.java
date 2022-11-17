package com.founder.rhip.ehr.dto;

import com.founder.rhip.ehr.entity.clinic.EHRHealthEvent;

import java.math.BigDecimal;

public class HealthEventItemDTO {
    private EHRHealthEvent ehrHealthEvent;
    private boolean hasDrug;
    private boolean hasExam;
    private boolean hasStudy;
    private boolean hasElecMedicalRecord;
    private boolean hasPhysicalExamRecord;//老年人体检是否已经生成体检报告
    private String examNumber;//老年人体检编号

    private BigDecimal costSum;//总费用
    public EHRHealthEvent getEhrHealthEvent() {
        return ehrHealthEvent;
    }

    public void setEhrHealthEvent(EHRHealthEvent ehrHealthEvent) {
        this.ehrHealthEvent = ehrHealthEvent;
    }

    public boolean isHasDrug() {
        return hasDrug;
    }

    public void setHasDrug(boolean hasDrug) {
        this.hasDrug = hasDrug;
    }

    public boolean isHasExam() {
        return hasExam;
    }

    public void setHasExam(boolean hasExam) {
        this.hasExam = hasExam;
    }

    public boolean isHasStudy() {
        return hasStudy;
    }

    public void setHasStudy(boolean hasStudy) {
        this.hasStudy = hasStudy;
    }

    public boolean isHasElecMedicalRecord() {
        return hasElecMedicalRecord;
    }

    public void setHasElecMedicalRecord(boolean hasElecMedicalRecord) {
        this.hasElecMedicalRecord = hasElecMedicalRecord;
    }

	public boolean isHasPhysicalExamRecord() {
		return hasPhysicalExamRecord;
	}

	public void setHasPhysicalExamRecord(boolean hasPhysicalExamRecord) {
		this.hasPhysicalExamRecord = hasPhysicalExamRecord;
	}

	public String getExamNumber() {
		return examNumber;
	}

	public void setExamNumber(String examNumber) {
		this.examNumber = examNumber;
	}

    public BigDecimal getCostSum() {
        return costSum;
    }

    public void setCostSum(BigDecimal costSum) {
        this.costSum = costSum;
    }
}
