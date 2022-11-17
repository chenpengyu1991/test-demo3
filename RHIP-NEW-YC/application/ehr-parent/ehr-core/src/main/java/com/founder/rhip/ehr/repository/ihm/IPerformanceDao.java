package com.founder.rhip.ehr.repository.ihm;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmReport;

/**
 * DAO interface
 */
public interface IPerformanceDao extends IDao<IdmReport, Long> {
	
    public List<Map<String, Object>> getTrainingPerformance(Map<String, String> paramMap);

    public List<Map<String, Object>> getVaccinationPerformance(Map<String, String> paramMap);

    public List<Map<String, Object>> getHealthExamPerformance(Map<String, String> paramMap);
    
    public PageList<Map<String, Object>> getAntibacterials(Map<String, String> paramMap, Page page);
    
    public List<Map<String, Object>> getDoctors(String orgCode, String medicalCode, String beginDateA, String endDateA);
    
    public PageList<Map<String, Object>> getInpatientMedicalRecord(Map<String, String> paramMap, Page page);
    
    public List<Map<String, Object>> getAntibacterialPrescriptions(Map<String, String> paramMap);

}