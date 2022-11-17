package com.founder.rhip.ehr.repository.basic;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.basic.PersonDeathRecord;

/**
 * DAO interface of AdministrativeArea
 */
public interface ILifeEventDao extends IDao<PersonDeathRecord, Long> {

	/**
     * 获取死亡最高的前十种病
     * @return
     */
    public List<PersonDeathRecord> getTopTenDeath(Criteria criteria);
    
    /**
     * 统计死于最高的前十种病的人口数目
     * @param criteria
     * @return
     */
    public List<PersonDeathRecord> getDeathICD10TargetList(Criteria criteria);

    /**
     * 死因统计分析
     * @param ca
     * @return
     */
    public List<Map<String, Object>> getDeathICD10MapList(Criteria ca);

    /**
     * 人群分类分析
     * @param ca
     * @return
     */
    public List<Map<String, Object>> getPersonTypeMapList(Criteria ca);
}