package com.founder.rhip.im.repository.medical;


import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.im.entity.medical.RdRealnameClinic;

import java.util.List;
import java.util.Map;

/**
 * DAO interface of RdPrescriptionDao
 * 实名就诊
 * 
 */
public interface IRdRealnameClinicDao extends IDao<RdRealnameClinic,Long> {

    /**
     * 按机构汇总，就诊人次，实名就诊人次（每日）
     * @param ca
     * @return
     */
    public List<Map<String,Object>> getOrganSummary(Criteria ca);

    /**
     * 实名制就诊趋势(1~12月份)
     * @param ca
     * @return
     */
    public Map<String, Object> getMonthTrendMap(Criteria ca);

    /**
     * 实名就诊率按机构排名
     * @param ca
     * @return
     */
    public List<Map<String, Object>> getRankingMapList(Criteria ca);

    /**
     * 实名就诊率构成分析
     * @param ca
     * @return
     */
    public Map<String, Object> getRealnameComposeMap(Criteria ca);
}