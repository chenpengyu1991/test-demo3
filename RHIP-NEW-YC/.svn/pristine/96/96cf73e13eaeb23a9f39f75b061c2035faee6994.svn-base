package com.founder.rhip.ehr.repository.ihm;

import java.util.List;
import java.util.Map;

import com.founder.rhip.ehr.entity.clinic.HealthExamination;
import com.founder.fasf.repository.IDao;

/**
 * DAO interface of 居民体检分析
 */
public interface IHmTargetDao extends IDao<HealthExamination, Long> {
	
	/**
	 * 体检人次月、季、年统计表
	 *
	 * @param beginDate
	 * @param endDate
	 * @param genreCode
	 * @param gbCode
	 * @param parentCode
	 * @param organCode
	 * @return
	 * @author Ye jianfei
	 */
	public List<Map<String, Object>> getPersonTimeList(String beginDate
			,String endDate
			,String genreCode
			,String gbCode
			,String parentCode
			,String organCode);
}