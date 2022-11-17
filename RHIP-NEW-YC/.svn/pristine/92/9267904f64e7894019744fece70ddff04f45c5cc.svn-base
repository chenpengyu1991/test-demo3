package com.founder.rhip.ehr.repository.ihm;

import java.util.List;
import java.util.Map;

import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmReport;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;

/**
 * DAO interface of 疫情分析
 */
public interface IEpidemicTargetDao extends IDao<IdmReport, Long> {
	
	/**
	 * 疫情分析-按职业统计数据
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public List<Map<String, Object>> getOccupationTargetList(Criteria criteria);
	
	/**
	 * 统计职业种类
	 *
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public List<Map<String, Object>> getOccupationTypeList(Criteria criteria);
	/**
	 * 疫情分析-按年龄段统计数据
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public List<Map<String, Object>> getAgeTargetList(Criteria criteria);	
}