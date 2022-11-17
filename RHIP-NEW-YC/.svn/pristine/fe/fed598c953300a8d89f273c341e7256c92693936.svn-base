package com.founder.rhip.ehr.repository.clinic;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.clinic.RpStatistics;

import java.util.List;
import java.util.Map;

/**
 * Created by wang_zhou on 2015/6/19.
 */
public interface IRpStatisticsDao extends IDao<RpStatistics, Long> {
    List<Map<String, Object>> getRpMapList(Criteria criteria);
    List<Map<String, Object>> getRpStatisticsMapList(Criteria criteria);

    List<Map<String, Object>> getChildMgnt3(Map<String, String> paramMap);

    List<Map<String, Object>> getChildVacc(Map<String, String> paramMap);


}
