package com.founder.rhip.ehr.repository.summary;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.summary.TraumaHistory;

/**
 * DAO interface of TraumaHistory
 */
public interface ITraumaHistoryDao extends IDao<TraumaHistory, String> {

	List<Map<String, Object>> getCountByOrgCode(Criteria criteria);

	/** 
	* @Title: getCountBy 
	* @Description: 统计
	* @param @param criteria
	* @param @return
	* @return Integer
	* @throws 
	*/
	Integer getCountBy(Criteria criteria);
	
}