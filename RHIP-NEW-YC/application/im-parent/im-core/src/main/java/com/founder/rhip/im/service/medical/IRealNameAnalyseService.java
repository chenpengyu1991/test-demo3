/**
 * 门诊实名制就诊分析
 */
package com.founder.rhip.im.service.medical;

import com.founder.fasf.beans.Criteria;

import java.util.List;
import java.util.Map;

public interface IRealNameAnalyseService {
    /**
     * 实名制就诊趋势(1~12月份)
     * @param ca
     * @return
     */
    public Map<String, Object> getMonthTrendMap(Criteria ca);

    /**
     * 实名制就诊率排名（按机构）
     * @param ca
     * @return
     */
    List<Map<String,Object>> getRankingMapList(Criteria ca);

    /**
     * 实名制就诊构成（实名、非实名）
     * @param ca
     * @return
     */
    public Map<String, Object> getComposeMap(Criteria ca);


}