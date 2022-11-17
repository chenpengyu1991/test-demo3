package com.founder.rhip.ehr.repository.child;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.child.ChildHealthCard;

import java.util.List;
import java.util.Map;

/**
 * DAO interface of ChildHealthCard
 */
public interface IChildHealthCardDao extends IDao<ChildHealthCard, String> {

    public Map countChildCard(Map<String, String> paramMap, List orgCodes);

    public Map countChildCardByAge(Map<String, String> paramMap, List orgCodes, int age);

    public List<Map<String, Object>> getChildCount(Map<String, String> paramMap, List orgCodes);
    
    public List<Map<String, Object>> getChildAgeStatisticsMapList(String dateStr);

}