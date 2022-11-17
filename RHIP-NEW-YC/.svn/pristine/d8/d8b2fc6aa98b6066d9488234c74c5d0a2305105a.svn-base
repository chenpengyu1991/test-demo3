package com.founder.rhip.ehr.repository.women;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.women.MotherhoodPeriodFollowup;

/**
 * DAO interface of MotherhoodPeriodFollowup
 */
public interface IMotherhoodPeriodFollowupDao extends IDao<MotherhoodPeriodFollowup, String> {

	public Long getEarlyResponse(Criteria criteria);
	
	public Map<String, Object> getOrganMapCount(Criteria criteria);
	
	public List<Map<String, Object>> getMotherhoodPeriodFollowupMapList(String dateStr);
	
	public List<Map<String, Object>> getMotherhoodPeriodFollowupWorkloadMapList(String dateStr);
}