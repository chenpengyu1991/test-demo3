package com.founder.rhip.ehr.repository.clinic;

import java.util.List;
import java.util.Map;

import com.founder.rhip.ehr.entity.clinic.InpatientMedicalRecord;
import com.founder.fasf.repository.IDao;

/**
 * DAO interface of InpatientMedicalRecord
 */
public interface IInpatientMedicalRecordDao extends IDao<InpatientMedicalRecord, Long> {

	/**
     * 病案数统计 病案数种类 甲乙丙
     * @param dateStr 日期格式必须是yyyy/mm/dd
     * @return
     */
    public List<Map<String, Object>> getInhosMedicalRecordQualityStatistics(String dateStr);
    
    /**
     * 获取手术麻醉的数据
     * @param dateStr 日期格式必须是yyyy/mm/dd
     * @return
     */
    public List<Map<String, Object>> getAnesthesiaAndSurgeryStatistics(String dateStr);
    
    /**
     * 获取质量质量中有关病案首页的数据
     * @param dateStr 日期格式必须是yyyy/mm/dd
     * @return
     */
    public List<Map<String, Object>> getCureResultRecordStatistics(String dateStr);
}