package com.founder.rhip.ep.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.ep.WaterIodineMonitor;

/**
 * Created with IntelliJ IDEA.
 * User: Jingqiu
 * Date: 13-6-24
 * Time: 下午4:42
 * To change this template use File | Settings | File Templates.
 */
public interface IWaterIodineService {
	
	/**
	 * 查询水碘监测列表
	 * @param page
	 * @param criteria
	 * @return
	 */
	PageList<WaterIodineMonitor> getPageList(Page page, Criteria criteria);

	/**
	 * 查询水碘监测明细
	 * @param id
	 * @return
	 */
	WaterIodineMonitor getDetail(Long id);

	/**
	 * 保存水碘监测记录
	 * @param monitor
	 */
	void save(WaterIodineMonitor monitor);

	/**
	 * 删除水碘监测记录
	 * @param monitor
	 */
	void delete(WaterIodineMonitor monitor);

	/**
	 * 查询水碘监测明细
	 * @param id
	 * @return
	 */
	WaterIodineMonitor getDetail(Criteria criteria);

	/**
	 * 删除水碘监测记录
	 * @param id
	 */
	void delete(Long id);
	
}
