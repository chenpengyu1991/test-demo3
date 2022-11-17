package com.founder.rhip.ehr.dto;

import java.util.List;

import com.founder.rhip.ehr.entity.clinic.DiseaseDiagnosisInfo;
import com.founder.rhip.ehr.entity.clinic.InpatientInfo;

/**
 * 临床图表基本信息
 *
 * @author liuk
 */
public class ClinicalChartBasicInfoDTO {
    private InpatientInfo inpatientInfo;//住院摘要
    private Integer inhosDays;//住院天数
    private Integer inhosWeeks;//住院周数
    private List<DiseaseDiagnosisInfo> diseaseDiagnosisInfos;//诊断信息

    public InpatientInfo getInpatientInfo() {
        return inpatientInfo;
    }

    public void setInpatientInfo(InpatientInfo inpatientInfo) {
        this.inpatientInfo = inpatientInfo;
    }

    public Integer getInhosDays() {
        return inhosDays;
    }

    public void setInhosDays(Integer inhosDays) {
        this.inhosDays = inhosDays;
    }

    public Integer getInhosWeeks() {
        return inhosWeeks;
    }

    public void setInhosWeeks(Integer inhosWeeks) {
        this.inhosWeeks = inhosWeeks;
    }

    public List<DiseaseDiagnosisInfo> getDiseaseDiagnosisInfos() {
        return diseaseDiagnosisInfos;
    }

    public void setDiseaseDiagnosisInfos(List<DiseaseDiagnosisInfo> diseaseDiagnosisInfos) {
        this.diseaseDiagnosisInfos = diseaseDiagnosisInfos;
    }

}
