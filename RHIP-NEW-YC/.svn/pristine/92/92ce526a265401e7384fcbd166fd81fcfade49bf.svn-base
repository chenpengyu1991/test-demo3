package com.founder.rhip.ehr.repository.child;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.child.BirthCertificate;

import java.util.List;
import java.util.Map;

/**
 * DAO interface of BirthCertificate
 */
public interface IBirthCertificateDao extends IDao<BirthCertificate, String> {

    /**
     * 新生儿出生趋势(1~12月份)
     * @param ca
     * @return
     */
    public Map<String, Object> getTrendMap(Criteria ca);

    /**
     * 按照性别统计新生儿构成
     * @param ca
     * @return
     */
    public Map<String,Object> getGenderComposeMap(Criteria ca);

    public Map countChildBirth(Map<String, String> paramMap, List orgCodes);

}