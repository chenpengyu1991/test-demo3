package com.founder.rhip.ehr.repository.women;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.entity.women.BirthDefectMonitor;
import com.founder.fasf.repository.IDao;

import java.util.List;
import java.util.Map;

/**
 * DAO interface of BirthDefectMonitor
 */
public interface IBirthDefectMonitorDao extends IDao<BirthDefectMonitor, String> {

    public Map countChildDefect(Map<String, String> paramMap, List orgCodes);

    /**
     * 新生儿出生缺陷数趋势(1~12月份)
     * @param ca
     * @return
     */
    public Map<String, Object> getTrendMap(Criteria ca);

    /**
     * 新生儿出生缺陷构成
     * @param ca
     * @return
     */
    public List<Map<String, Object>> getDefectTypeMap(Criteria ca);

}