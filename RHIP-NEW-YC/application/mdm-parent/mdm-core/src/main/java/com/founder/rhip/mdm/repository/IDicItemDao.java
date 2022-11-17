package com.founder.rhip.mdm.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Dictionary;

import java.util.List;

public interface IDicItemDao extends IDao<DicItem,Long> {
	
	public List<DicItem> getDicItemByVersion(Criteria criteria, Long version);
	
	public PageList<DicItem> getLogList(Page page, Long itemId, String... properties);
	
	public void insertLogs(Criteria criteria);
	
	public void deleteLogs(Criteria criteria);

	public void batchChangeStatus(Dictionary dictionary);
	
	/**
	 * 查询最新字典项不在表Organization_Area中的行政村
	 */
	public List<DicItem> getDicItemsForOrgArea(String parentCode);

	public void updateDicItem(DicItem item);

	PageList<DicItem> getDicItemPageList(Page page, DicItem dicItem, boolean autoSelect);
}
