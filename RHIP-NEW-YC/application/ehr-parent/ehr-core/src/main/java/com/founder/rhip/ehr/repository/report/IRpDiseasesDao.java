package com.founder.rhip.ehr.repository.report;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.report.RpDiseases;

import java.util.List;
import java.util.Map;

public interface IRpDiseasesDao extends IDao<RpDiseases, Long> {

    /**
     * 查询诊断记录中统计传染病
     * @param paramMap
     * @return
     */
    public List<RpDiseases> getDiseases(Map<String, String> paramMap);

    /**
     * 1年内按月统计A、B类型传染病
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getDiseaseMonth(Map<String, String> paramMap);

}
