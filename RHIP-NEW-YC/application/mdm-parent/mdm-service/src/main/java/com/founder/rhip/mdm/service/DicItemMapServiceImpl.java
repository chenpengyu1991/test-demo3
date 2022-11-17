package com.founder.rhip.mdm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.DicItemMap;
import com.founder.rhip.mdm.entity.EntityType;
import com.founder.rhip.mdm.repository.IDicItemMapDao;

@Service("mdmDicItemMapService")
public class DicItemMapServiceImpl extends MDMService implements IDicItemMapService {
	
	@Resource(name = "mdmDicItemMapDao")
	private IDicItemMapDao mdmDicItemMapDao;
	
	protected static final String SEQ_DIC_ITEM_MAP = "SEQ_DIC_ITEM_MAP";

	@Override
	public DicItemMap getDicItemMap(String localDicCode,String localItemCode,Long itemCodeVersion) {
		Criteria criteria = new Criteria(DicItemMap.LOCAL_DIC_CODE, localDicCode);
		criteria.add(DicItemMap.LOCAL_ITEM_CODE, localItemCode);
		criteria.add(DicItemMap.ITEM_CODE_VERSION,itemCodeVersion);
		DicItemMap dim = mdmDicItemMapDao.get(criteria);
		return dim;
	}

	@Override
	public void createDicItemMap(DicItemMap dicItemMap) {
		String dicCode = dicItemMap.getDicCode();
		mdmDicItemMapDao.insertWithSeq(dicItemMap, SEQ_DIC_ITEM_MAP);
		removeCache(EntityType.DIC_ITEM_MAP, dicCode);
	}
	
	@Override
	public void updateDicItemMap(DicItemMap dicItemMap) {
		String dicCode = dicItemMap.getDicCode();
		mdmDicItemMapDao.update(dicItemMap);
		removeCache(EntityType.DIC_ITEM_MAP, dicCode);
	}

	@Override
	public PageList<DicItemMap> getDicItemMapPageList(Criteria criteria, Page page) {
		return mdmDicItemMapDao.getPageList(page, criteria);
	}

	@Override
	public DicItemMap getDicItemMap(Criteria criteria) {
		return mdmDicItemMapDao.get(criteria);
	}

	@Override
	public PageList<DicItemMap> getDistinctDicItemMapPageList(DicItemMap dicItemMap, Page page, String hospitalFlag) {
		return mdmDicItemMapDao.getDistinctDicItemMapPageList(dicItemMap, page, hospitalFlag);
	}

}
