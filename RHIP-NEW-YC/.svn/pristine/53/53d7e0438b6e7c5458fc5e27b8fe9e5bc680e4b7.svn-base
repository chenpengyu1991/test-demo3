package com.founder.rhip.ehr.repository.clinic;

import java.util.List;
import java.util.Map;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.clinic.SickbedUseState;

/**
 * DAO interface of SickbedUseState
 * 
 */
public interface ISickbedUseStateDao extends IDao<SickbedUseState,Long> {
	/**
     * 统计住院人数（按照现在的床位数）
     * @param dateStr 日期格式必须是yyyy/mm/dd
     * @return
     */
    public List<Map<String, Object>> getBedStatistics(String dateStr);
    
}