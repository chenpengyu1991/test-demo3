/**
 * 新生儿分析
 */
package com.founder.rhip.im.service.whch;

import com.founder.fasf.beans.Criteria;

import java.util.List;
import java.util.Map;

public interface INeonateAnalyseService {
    /**
     * 新生儿出生趋势(1~12月份)
     * @param ca
     * @return
     */
    public Map<String, Object> getBirthTrendMap(Criteria ca);

    /**
     * 新生儿出生缺陷趋势(1~12月份)
     * @param ca
     * @return
     */
    public Map<String, Object> getDefectTrendMap(Criteria ca);

    /**
     * 新生儿出生性别构成
     * @param ca
     * @return
     */
    public Map<String, Object> getGenderComposeMap(Criteria ca);

    /**
     * 新生儿出生缺陷构成
     * @param ca
     * @return
     */
    public List<Map<String, Object>> getDefectTypeMap(Criteria ca);
}