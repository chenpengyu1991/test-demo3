package com.founder.rhip.ehr.repository.clinic;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.clinic.OutpatientInfo;

/**
 * DAO interface of OutpatientInfo
 */
public interface IOutpatientInfoDao extends IDao<OutpatientInfo, Long> {
	/**
	 * 查询门诊统计
	 * @param dateStr
	 * @param isGroupByOutpatientType 是否按门诊类型分组
	 * @return
	 */
	List<Map<String,Object>> getOutpatientStatistics(String dateStr, boolean isGroupByOutpatientType);

	/**
	 * 通过personId参数查询门诊相关表信息集合
	 * @param personId
	 * @return
	 */
	List<Map<String,Object>> getPatientAllInfos(String personId);

	/**
	 * 通过EhrId参数查询门诊相关表信息
	 * @param EhrId
	 * @return
	 */
	Map<String,Object> getOutPatientInfo(String EhrId);

	/**
	 * 查找去重的门诊信息
	 * @param criteria
	 * @param order
	 * @return
	 */
	public List<OutpatientInfo> getDistinctList(Criteria criteria, Order order);

	PageList<OutpatientInfo> getOutpatientInfoWithIdCard(Page page, Criteria criteria, Order order);

	PageList<OutpatientInfo> getOutpatientInfoWithIdCard1(Page page, Criteria criteria, Order order);

}