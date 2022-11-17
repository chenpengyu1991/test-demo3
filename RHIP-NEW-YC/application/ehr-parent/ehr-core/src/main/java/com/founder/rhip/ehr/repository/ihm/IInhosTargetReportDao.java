package com.founder.rhip.ehr.repository.ihm;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.ihm.InhosTargetReport;

import java.util.List;
import java.util.Map;

/**
 * DAO interface of IhmInhosTargetReport
 * 
 */
public interface IInhosTargetReportDao extends IDao<InhosTargetReport,Long> {
    /**
     * 获取十八种住院重点疾病监测指标报表
     * @param year
     * @param genreCode
     * @param gbCode
     * @param organCode
     * @return
     */
    public List<Map<String, Object>> getMdList(Integer year,String genreCode,String gbCode,String organCode);
}