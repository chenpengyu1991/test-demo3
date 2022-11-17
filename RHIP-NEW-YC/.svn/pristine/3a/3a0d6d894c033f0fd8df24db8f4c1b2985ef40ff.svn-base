package com.founder.rhip.mdm.repository;

import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.mdm.entity.DicItemMap;

public interface IDicItemMapDao extends IDao<DicItemMap, Long> {
	
	/**
	 * 分页查询字典映射去重复
	 * @param dicItemMap
	 * @param page 
	 * @param hospitalFlag
	 * @return
	 */
	public PageList<DicItemMap> getDistinctDicItemMapPageList(DicItemMap dicItemMap, Page page, String hospitalFlag);

}
