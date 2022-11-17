package com.founder.rhip.ehr.dto;

import java.util.List;

import com.founder.rhip.ehr.entity.clinic.DiseaseDiagnosisInfo;
import com.founder.rhip.ehr.entity.clinic.DrugUsage;
import com.founder.rhip.ehr.entity.clinic.InpatientInfo;
import com.founder.rhip.ehr.entity.clinic.OuthospitalSummary;
import com.founder.rhip.ehr.entity.clinic.StudyEvent;

/**
 * 住院摘要
 *
 * @author liuk
 */
public class InpatientSummaryDTO {

    private InpatientInfo inpatientInfo;
    private OuthospitalSummary outhospitalSummary;
    private List<DrugUsage> drugUsages;
    private List<StudyEvent> studyEvents;
    private List<DiseaseDiagnosisInfo> diseaseDiagnosisInfos;

    public InpatientInfo getInpatientInfo() {
        return inpatientInfo;
    }

    public void setInpatientInfo(InpatientInfo inpatientInfo) {
        this.inpatientInfo = inpatientInfo;
    }

    public OuthospitalSummary getOuthospitalSummary() {
        return outhospitalSummary;
    }

    public void setOuthospitalSummary(OuthospitalSummary outhospitalSummary) {
        this.outhospitalSummary = outhospitalSummary;
    }

    public List<DrugUsage> getDrugUsages() {
        return drugUsages;
    }

    public void setDrugUsages(List<DrugUsage> drugUsages) {
        this.drugUsages = drugUsages;
    }

    public List<StudyEvent> getStudyEvents() {
        return studyEvents;
    }

    public void setStudyEvents(List<StudyEvent> studyEvents) {
        this.studyEvents = studyEvents;
    }

    public List<DiseaseDiagnosisInfo> getDiseaseDiagnosisInfos() {
        return diseaseDiagnosisInfos;
    }

    public void setDiseaseDiagnosisInfos(List<DiseaseDiagnosisInfo> diseaseDiagnosisInfos) {
        this.diseaseDiagnosisInfos = diseaseDiagnosisInfos;
    }

}
