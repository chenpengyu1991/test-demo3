package com.founder.rhip.ehr.repository.ihm;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.women.PremaritalHealthService;

/**
 * DAO interface of 男妇婚检统计
 */
public interface IPremaritalCheckStatisticsDao extends IDao<PremaritalHealthService, Long> {
	
	/**
	 * 男妇婚检统计
	 * 
	 * @param page
	 * @param criteria
	 * @param orgType
	 * @return List<Map<String, Object>> 
	 * @author 	chen_wenbo
	 */
	public List<Map<String, Object>> getstatisticsList(String genreCode, Criteria criteria, String beginDate, String endDate);
	
}