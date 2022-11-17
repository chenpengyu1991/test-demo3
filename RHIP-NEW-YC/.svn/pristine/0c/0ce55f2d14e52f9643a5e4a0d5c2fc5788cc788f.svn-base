package com.founder.rhip.ehr.repository.women;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.women.PostpartumDaysHealthInfo;

/**
 * DAO interface of PostpartumDaysHealthInfo
 */
public interface IPostpartumDaysHealthInfoDao extends IDao<PostpartumDaysHealthInfo, String> {

	public Long postpartumDaysCount(Criteria criteria);
	
	public Map<String, Object> getOrganMapCount(Criteria criteria);
	
	public List<Map<String, Object>> getPostpartumDaysHealthInfoMapList(String dateStr);
}