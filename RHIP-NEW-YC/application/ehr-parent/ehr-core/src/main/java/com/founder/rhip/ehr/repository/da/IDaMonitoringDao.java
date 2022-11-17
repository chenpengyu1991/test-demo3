package com.founder.rhip.ehr.repository.da;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.clinic.DrugUsage;

import java.util.Map;

/**
 * DAO interface of 日常监控
 */
public interface IDaMonitoringDao extends IDao<DrugUsage, Long> {

	/**
	 * 获取药品分布监控列表
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getDrugDistributionList(Page page, Criteria criteria);
}