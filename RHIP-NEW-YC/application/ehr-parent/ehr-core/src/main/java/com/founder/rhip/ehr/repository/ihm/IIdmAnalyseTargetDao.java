package com.founder.rhip.ehr.repository.ihm;

import java.util.List;
import java.util.Map;

import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmReport;
import com.founder.fasf.repository.IDao;

/**
 * DAO interface of 传染病分析
 */
public interface IIdmAnalyseTargetDao extends IDao<IdmReport, Long> {

	/**
	 *  综合管理-传染病疫情趋势分析
	 *
	 * @param beginDate
	 * @param endDate
	 * @param genreCode
	 * @param gbCode
	 * @param parentCode
	 * @param organCode
	 * @param infectiousCode
	 * @return
	 * @author Ye jianfei
	 */
	public Map<String, Object> getTrendMap(String beginDate
			,String endDate
			,String genreCode
			,String gbCode
			,String parentCode
			,String organCode
			,String infectiousCode);
	
	/**
	 * 传染病分地区统计表
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
	public List<Map<String, Object>> getRegionList(String beginDate
			,String endDate
			,String genreCode
			,String gbCode
			,String parentCode
			,String organCode);
}