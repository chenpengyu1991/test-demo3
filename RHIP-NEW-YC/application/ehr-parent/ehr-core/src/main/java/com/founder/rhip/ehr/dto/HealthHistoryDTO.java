package com.founder.rhip.ehr.dto;

import java.io.Serializable;
import java.util.List;

import com.founder.rhip.ehr.entity.control.VaccinationInfo;
import com.founder.rhip.ehr.entity.summary.DiseaseHistory;
import com.founder.rhip.ehr.entity.summary.DrugAllergyHistory;
import com.founder.rhip.ehr.entity.summary.HospitalizedHistory;
import com.founder.rhip.ehr.entity.summary.SurgeryHistory;
import com.founder.rhip.ehr.entity.summary.TransBloodHistory;

public class HealthHistoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<DiseaseHistory> diseaseHistoryList;

    private List<SurgeryHistory> surgeryHistoryList;

    private List<DrugAllergyHistory> drugAllergyHistoryList;

    private List<VaccinationInfo> vaccinationInfoList;

    private List<HospitalizedHistory> hospitalizedHistories;

    private List<TransBloodHistory> transBloodHistories;

    public List<DiseaseHistory> getDiseaseHistoryList() {
        return diseaseHistoryList;
    }

    public void setDiseaseHistoryList(List<DiseaseHistory> diseaseHistoryList) {
        this.diseaseHistoryList = diseaseHistoryList;
    }

    public List<HospitalizedHistory> getHospitalizedHistories() {
        return hospitalizedHistories;
    }

    public void setHospitalizedHistories(List<HospitalizedHistory> hospitalizedHistories) {
        this.hospitalizedHistories = hospitalizedHistories;
    }

    public List<TransBloodHistory> getTransBloodHistories() {
        return transBloodHistories;
    }

    public void setTransBloodHistories(List<TransBloodHistory> transBloodHistories) {
        this.transBloodHistories = transBloodHistories;
    }

    public List<SurgeryHistory> getSurgeryHistoryList() {
        return surgeryHistoryList;
    }

    public void setSurgeryHistoryList(List<SurgeryHistory> surgeryHistoryList) {
        this.surgeryHistoryList = surgeryHistoryList;
    }

    public List<DrugAllergyHistory> getDrugAllergyHistoryList() {
        return drugAllergyHistoryList;
    }

    public void setDrugAllergyHistoryList(
            List<DrugAllergyHistory> drugAllergyHistoryList) {
        this.drugAllergyHistoryList = drugAllergyHistoryList;
    }

    public List<VaccinationInfo> getVaccinationInfoList() {
        return vaccinationInfoList;
    }

    public void setVaccinationInfoList(List<VaccinationInfo> vaccinationInfoList) {
        this.vaccinationInfoList = vaccinationInfoList;
    }

}
