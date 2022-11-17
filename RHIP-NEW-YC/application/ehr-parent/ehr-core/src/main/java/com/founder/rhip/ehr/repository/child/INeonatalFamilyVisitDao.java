package com.founder.rhip.ehr.repository.child;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.child.NeonatalFamilyVisit;

import java.util.List;
import java.util.Map;

/**
 * DAO interface of NeonatalFamilyVisit
 */
public interface INeonatalFamilyVisitDao extends IDao<NeonatalFamilyVisit, String> {

	public Long getNeonatalVisitCount(Criteria criteria);

    public Map countChildVisit(Map<String, String> paramMap, List orgCodes);

    public Map countHearing(Map<String, String> paramMap, List orgCodes);
    
    public List<Map<String, Object>> getNeonatalFamilyVisitMapList(String dateStr);
}