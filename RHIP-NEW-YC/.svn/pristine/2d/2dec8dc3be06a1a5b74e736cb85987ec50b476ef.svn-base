package com.founder.rhip.ehr.repository.ihm;

import java.util.List;
import java.util.Map;

import com.founder.rhip.ehr.entity.clinic.Pharmacy;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;

/**
 * DAO interface of 基药管理
 */
public interface IDaTargetDao extends IDao<Pharmacy, Long> {
	
	/**
	 * 统计基药管理出入库数据
	 * @param page
	 * @param criteria
	 * @param orgType
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getChangeTargetList(Page page,Criteria criteria, String orgType);
	
	/**
	 * 统计基药管理库存数据
	 * @param page
	 * @param criteria
	 * @param orgType
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getStorageTargetList(Page page,Criteria criteria, String orgType);

	/**
	 * 统计基药管理出入库数据合计
	 * @param criteria
	 * @param orgType
	 * @return
	 * @author
	 */
	public List<Map<String, Object>> getChangeTargetSum(Criteria criteria,String orgType);

	/**
	 * 统计基药管理库存数据合计
	 * @param criteria
	 * @param orgType
	 * @return
	 * @author
	 */
	public List<Map<String, Object>> getStorageTargetSum(Criteria criteria,String orgType);	
}