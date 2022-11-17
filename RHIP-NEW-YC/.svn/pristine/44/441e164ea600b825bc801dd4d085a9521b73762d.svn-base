package com.founder.rhip.ehr.repository.women;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.women.DeliveryRecordInfo;

/**
 * DAO interface of DeliveryRecordInfo
 */
public interface IDeliveryRecordInfoDao extends IDao<DeliveryRecordInfo, String> {

    public Map countChildDeath(Map<String, String> paramMap, List orgCodes);

    public Map<String, Object> getOrganMapCount(Criteria criteria);
    
    public Map<String, Object> getOrganMapDeliveryAndCount(Criteria criteria);
    
    public List<Map<String, Object>> getDeliveryRecordMapList(String dateStr);

    public Integer getLiveBirthsNum(Integer year,Integer quarter,String orgCode);

    public List<Map<String,Object>> liveBirthNum(Criteria criteria);
}