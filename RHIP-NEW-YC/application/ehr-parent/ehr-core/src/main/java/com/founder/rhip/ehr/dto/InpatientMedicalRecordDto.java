package com.founder.rhip.ehr.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.clinic.DiseaseDiagnosisInfo;
import com.founder.rhip.ehr.entity.clinic.InpatientMedicalRecord;
import com.founder.rhip.ehr.entity.clinic.SurgeryInfo;
import com.founder.rhip.ehr.entity.summary.DrugAllergyHistory;

public class InpatientMedicalRecordDto {
    private InpatientMedicalRecord inpatientMedicalRecord;
    private PersonInfo personInfo;
    private Map<String, BigDecimal> expenseInfoMap;
    private List<SurgeryInfo> surgeryInfos;
    private int inhosDays;//实际住院天数
    private Map<String, List<DiseaseDiagnosisInfo>> diseaseDiagnosisInfoMap;
    private List<DrugAllergyHistory> allergyHistories;

    private List<DiseaseDiagnosisInfo> mjzInfoList;
    
    public List<DiseaseDiagnosisInfo> getMjzInfoList() {
		return mjzInfoList;
	}

	public void setMjzInfoList(List<DiseaseDiagnosisInfo> mjzInfoList) {
		this.mjzInfoList = mjzInfoList;
	}

	public InpatientMedicalRecord getInpatientMedicalRecord() {
        return inpatientMedicalRecord;
    }

    public void setInpatientMedicalRecord(InpatientMedicalRecord inpatientMedicalRecord) {
        this.inpatientMedicalRecord = inpatientMedicalRecord;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }

    public Map<String, BigDecimal> getExpenseInfoMap() {
        return expenseInfoMap;
    }

    public void setExpenseInfoMap(Map<String, BigDecimal> expenseInfoMap) {
        this.expenseInfoMap = expenseInfoMap;
    }

    public List<SurgeryInfo> getSurgeryInfos() {
        return surgeryInfos;
    }

    public void setSurgeryInfos(List<SurgeryInfo> surgeryInfos) {
        this.surgeryInfos = surgeryInfos;
    }

    public int getInhosDays() {
        return inhosDays;
    }

    public void setInhosDays(int inhosDays) {
        this.inhosDays = inhosDays;
    }

    public Map<String, List<DiseaseDiagnosisInfo>> getDiseaseDiagnosisInfoMap() {
        return diseaseDiagnosisInfoMap;
    }

    public void setDiseaseDiagnosisInfoMap(Map<String, List<DiseaseDiagnosisInfo>> diseaseDiagnosisInfoMap) {
        this.diseaseDiagnosisInfoMap = diseaseDiagnosisInfoMap;
    }

    public List<DrugAllergyHistory> getAllergyHistories() {
        return allergyHistories;
    }

    public void setAllergyHistories(List<DrugAllergyHistory> allergyHistories) {
        this.allergyHistories = allergyHistories;
    }
}
