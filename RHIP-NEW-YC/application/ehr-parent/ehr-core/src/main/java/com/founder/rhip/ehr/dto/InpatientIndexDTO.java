package com.founder.rhip.ehr.dto;

import java.io.Serializable;
import java.util.List;

import com.founder.rhip.ehr.entity.clinic.InpatientMedicalRecord;
import com.founder.rhip.ehr.entity.clinic.SurgeryInfo;

public class InpatientIndexDTO implements Serializable {
    private static final long serialVersionUID = -1294948458546505119L;
    private InpatientMedicalRecord inpatientMedicalRecord;
    private List<SurgeryInfo> surgeryInfos;

    public InpatientMedicalRecord getInpatientMedicalRecord() {
        return inpatientMedicalRecord;
    }

    public void setInpatientMedicalRecord(InpatientMedicalRecord inpatientMedicalRecord) {
        this.inpatientMedicalRecord = inpatientMedicalRecord;
    }

    public List<SurgeryInfo> getSurgeryInfos() {
        return surgeryInfos;
    }

    public void setSurgeryInfos(List<SurgeryInfo> surgeryInfos) {
        this.surgeryInfos = surgeryInfos;
    }

}
