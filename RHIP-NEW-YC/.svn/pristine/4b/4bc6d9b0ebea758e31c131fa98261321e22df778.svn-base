package com.founder.rhip.ehr.repository.report;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.report.RpSymptom;

import java.util.List;
import java.util.Map;

public interface IRpSymptomDao extends IDao<RpSymptom, Long> {

    /**
     * 从就诊记录统计监测症状--50症状
     * @param paramMap
     * @return
     */
    public List<RpSymptom> getSymptom(Map<String, String> paramMap);

    /**
     * 1年内按月统计
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getSymptomMonth(Map<String, String> paramMap);

}
