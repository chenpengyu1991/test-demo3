package com.founder.rhip.ehr.repository.clinic;

import java.util.List;
import java.util.Map;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.clinic.ClinicalPathway;

/**
 * DAO interface of ClinicalPathway
 * 
 */
public interface IClinicalPathwayDao extends IDao<ClinicalPathway,Long> {

	/**
     * 获取临床路径的数据
     * @param dateStr 日期格式必须是yyyy/mm/dd
     * @return
     */
    public List<Map<String, Object>> getClinicalPathwayStatistics(String dateStr);
}