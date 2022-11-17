package com.founder.rhip.ehr.dto;

import com.founder.rhip.ehr.entity.clinic.DrugUsage;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 临床图表基本信息
 *
 * @author liuk
 */
public class ClinicalChartDataDTO implements Serializable {
    private static final long serialVersionUID = 138934043586324970L;
    private Integer currentWeek;
    private Integer lastDays;
    //周列表 格式化的key
    private List<String> weeks;
    //用药
    private Map<String,  Map<String,DrugUsage>> drugUsagesMap;
    // 检验
    private Map<String, List<Map<String, Object>>> examMap;
    // 检查
    private Map<String, List<Map<String, Object>>> studyMap;
    //病案首页id
    private Long inpatientMedicalRecord;
    //出院小结id
    private Long outhospitalSummary;
    //费用信息
    private Map<String, List<String>> expenseMap;

    public List<String> getWeeks() {
        return weeks;
    }

    public void setWeeks(List<String> weeks) {
        this.weeks = weeks;
    }

    public Map<String,  Map<String,DrugUsage>> getDrugUsagesMap() {
        return drugUsagesMap;
    }

    public void setDrugUsagesMap(Map<String,  Map<String,DrugUsage>> drugUsagesMap) {
        this.drugUsagesMap = drugUsagesMap;
    }

    public Integer getCurrentWeek() {
        return currentWeek;
    }

    public void setCurrentWeek(Integer currentWeek) {
        this.currentWeek = currentWeek;
    }

    public Integer getLastDays() {
        return lastDays;
    }

    public void setLastDays(Integer lastDays) {
        this.lastDays = lastDays;
    }

    public Map<String, List<Map<String, Object>>> getExamMap() {
        return examMap;
    }

    public void setExamMap(Map<String, List<Map<String, Object>>> examMap) {
        this.examMap = examMap;
    }

    public Map<String, List<Map<String, Object>>> getStudyMap() {
        return studyMap;
    }

    public void setStudyMap(Map<String, List<Map<String, Object>>> studyMap) {
        this.studyMap = studyMap;
    }

    public Long getInpatientMedicalRecord() {
        return inpatientMedicalRecord;
    }

    public void setInpatientMedicalRecord(Long inpatientMedicalRecord) {
        this.inpatientMedicalRecord = inpatientMedicalRecord;
    }

    public Long getOuthospitalSummary() {
        return outhospitalSummary;
    }

    public void setOuthospitalSummary(Long outhospitalSummary) {
        this.outhospitalSummary = outhospitalSummary;
    }

    public Map<String, List<String>> getExpenseMap() {
        return expenseMap;
    }

    public void setExpenseMap(Map<String, List<String>> expenseMap) {
        this.expenseMap = expenseMap;
    }

}
