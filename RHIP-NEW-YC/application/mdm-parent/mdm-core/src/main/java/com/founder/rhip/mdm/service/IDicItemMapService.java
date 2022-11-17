package com.founder.rhip.mdm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.DicItemMap;

public interface IDicItemMapService {
	
	/** 查找术语编码配置表
	 * @param criteria
	 * @return
	 */
	public DicItemMap getDicItemMap(String localDicCode,String localItemCode,Long itemCodeVersion);
	
	/**
	 * 创建术语编码配置表
	 * @param criteria
	 * @return
	 */
	public void createDicItemMap(DicItemMap dicItemMap);

	/**
	 * 更新术语编码配置表
	 * @param criteria
	 * @return
	 */
	public void updateDicItemMap(DicItemMap dicItemMap);
	
	/**
	 * 分页查询字典映射
	 * @param criteria
	 * @param page 
	 * @return
	 */
	public PageList<DicItemMap> getDicItemMapPageList(Criteria criteria, Page page);
	
	/**
	 * 查询字典映射对象
	 * @param criteria
	 * @return
	 */
	public DicItemMap getDicItemMap(Criteria criteria);
	
	/**
	 * 分页查询字典映射去重
	 * @param dicItemMap
	 * @param page
	 * @param hospitalFlag
	 * @return
	 */
	public PageList<DicItemMap> getDistinctDicItemMapPageList(DicItemMap dicItemMap, Page page, String hospitalFlag);
}
