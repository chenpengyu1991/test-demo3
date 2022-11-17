package com.founder.rhip.ehr.dto;

import com.founder.rhip.ehr.entity.clinic.InpatientInfo;

public class InpatientItemDTO {
    private InpatientInfo inpatientInfo;
    private boolean hasDrug;
    private boolean hasExam;
    private boolean hasStudy;
    private boolean hasElecMedicalRecord;

    public InpatientInfo getInpatientInfo() {
        return inpatientInfo;
    }

    public void setInpatientInfo(InpatientInfo inpatientInfo) {
        this.inpatientInfo = inpatientInfo;
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

}
