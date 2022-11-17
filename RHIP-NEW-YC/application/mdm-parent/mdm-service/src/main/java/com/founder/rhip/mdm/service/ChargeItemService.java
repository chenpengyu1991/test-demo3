package com.founder.rhip.mdm.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.mdm.entity.EntityType;
import com.founder.rhip.mdm.entity.SzdTophoschargeitem;
import com.founder.rhip.mdm.repository.IChargeItemDao;
import com.founder.rhip.mdm.service.IChargeItemService;
import com.founder.rhip.mdm.service.IMDMConfigService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("mdmChargeItemService")
public class ChargeItemService extends MDMService implements IChargeItemService {

	@Resource(name = "mdmChargeItemDao")
	private IChargeItemDao chargeItemDao;

	@Resource(name = "mdmConfigService")
	private IMDMConfigService mdmConfigService;

	private String[] CHARGE_ITEM_PROPERTIES;

	@Override
	public List<Map<String, Object>> getLatestChargeItems(String organCode, Date lastDate) {
		Criteria criteria = new Criteria();
		if (StringUtil.isNotEmpty(organCode)) {
			criteria.add("tenantId", organCode);
		}
		if (ObjectUtil.isNotEmpty(lastDate)) {
			criteria.add("uploadtime", OP.GT, lastDate);
		}
		List<SzdTophoschargeitem> items = chargeItemDao.getList(criteria, getProp());
		if (ObjectUtil.isNullOrEmpty(items)) {
			return null;
		}
		List<Map<String, Object>> list = new ArrayList<>();
		for (SzdTophoschargeitem item : items) {
			list.add(new Record(item).getMap());
		}
		return list;
	}

	public List<SzdTophoschargeitem> getLatestChargeItems(String organCode, Integer type, Date lastDate) {
		Criteria criteria = new Criteria();
		if (StringUtil.isNotEmpty(organCode)) {
			criteria.add("tenantId", organCode);
		}
		if (ObjectUtil.isNotEmpty(type)) {
			criteria.add("type", type);
		}
		if (ObjectUtil.isNotEmpty(lastDate)) {
			criteria.add("uploadtime", OP.GT, lastDate);
		}
		List<SzdTophoschargeitem> items = chargeItemDao.getList(criteria, getProp());
		return items;
	}

	@Override
	public Map<String, Object> getChargeItemInMap(Long catalogId, String tenantId) {
		Criteria criteria = new Criteria("catalogid", catalogId).add("tenantId", tenantId);
		SzdTophoschargeitem item = chargeItemDao.get(criteria, getProp());
		if (item == null) {
			return null;
		}
		return new Record(item).getMap();
	}

	@Transactional
	@Override
	public int syncChargeItems(List<Map<String, Object>> chargeItems) {
		List<Map<String, Object>> insertList = new ArrayList<>();
		List<Map<String, Object>> updateList = new ArrayList<>();
		for (Map<String, Object> item : chargeItems) {
			String catalogId = (String) item.get("catalogid");
			String tenantId = (String) item.get("tenantId");
			Criteria criteria = new Criteria("catalogid", catalogId).add("tenantId", tenantId);
			SzdTophoschargeitem oldItem = chargeItemDao.get(criteria, getProp());
			if (oldItem == null) {
				item.put("uploadtime", new Date());
				insertList.add(item);
			} else if (needUpdate(item, oldItem)) {
				item.put("uploadtime", new Date());
				updateList.add(item);
			}
		}
		int processed = 0;
		if (ObjectUtil.isNotEmpty(insertList)) {
			processed += insertChargeItems(insertList);
		}
		if (ObjectUtil.isNotEmpty(updateList)) {
			processed += updateChargeItems(updateList);
		}
		return processed;
	}
	
	private boolean needUpdate(Map<String, Object> item, SzdTophoschargeitem oldItem) {
		Record left = new Record(item, SzdTophoschargeitem.class);
		Record right = new Record(oldItem);
		Record result = MDMService.getChangedValue(left, right, "basecode", "mediinsucode", 
				"ncmscode", "itemName", "spec", "dosageFormCd", "costPrice", "doseMethodCd");
		return (result.keySet().size() > 0);
	}

	@Transactional
	@Override
	public int syncChargeItem(Map<String, Object> item) {
		String catalogId = (String) item.get("catalogid");
		String tenantId = (String) item.get("tenantId");
		Criteria criteria = new Criteria("catalogid", catalogId).add("tenantId", tenantId);
		SzdTophoschargeitem oldItem = chargeItemDao.get(criteria, getProp());
		int sync = 0;
		if (oldItem == null) {
			item.put("uploadtime", new Date());
			sync = chargeItemDao.insert(item, getProp());
		} else if (needUpdate(item, oldItem)) {
			item.put("uploadtime", new Date());
			chargeItemDao.insertChargeItemLog(new Criteria("catalogid", catalogId));
			sync = chargeItemDao.update(item, getProp());
		}
		return sync;
	}

	@Override
	@Transactional
	public int insertChargeItems(List<Map<String, Object>> chargeItems) {
		chargeItemDao.batchMapInsert(chargeItems, getProp());
		return chargeItems.size();
	}

	@Override
	@Transactional
	public int updateChargeItems(List<Map<String, Object>> chargeItems) {
		List<String> catalogids = new ArrayList<>();
		for (int i = 0; i < chargeItems.size(); i++) {
			String catalogid = (String) chargeItems.get(i).get("catalogid");
			catalogids.add(catalogid);
		}
		List<List> logList = getInsertLogs(catalogids);
		for (List ids : logList) {
			Criteria criteria = new Criteria("catalogid", OP.IN, ids);
			chargeItemDao.insertChargeItemLog(criteria);
			ids.clear();
			ids = null;
		}
		chargeItemDao.batchMapUpdate(chargeItems, getProp());
		return chargeItems.size();
	}

	private String[] getProp() {
		if (CHARGE_ITEM_PROPERTIES == null) {
			CHARGE_ITEM_PROPERTIES = mdmConfigService.getEntityProperties(EntityType.SZD_TOPHOSCHARGEITEM);
		}
		return CHARGE_ITEM_PROPERTIES;
	}
	
	@Override
	public SzdTophoschargeitem getChargeItem(String catalogId) {
		return chargeItemDao.get(catalogId);
	}

	@Override
	public PageList<SzdTophoschargeitem> getChargeItems(Page page, Criteria criteria) {
		PageList<SzdTophoschargeitem> pageList = chargeItemDao.getPageList(page, criteria);
		return pageList;
	}

	@Override
	@Transactional
	public void updateChargeItemMapping(List<SzdTophoschargeitem> items) {
		List<String> itemIds = new ArrayList<String>();
		for (SzdTophoschargeitem item : items) {
			itemIds.add(item.getCatalogid());
		}
		List<List> logList = getInsertLogs(itemIds);
		for (List ids : logList) {
			Criteria criteria = new Criteria("catalogid", OP.IN, ids);
			chargeItemDao.insertChargeItemLog(criteria);
			ids.clear();
			ids = null;
		}
		chargeItemDao.batchUpdate(items, "basecode", "uploader", "uploadtime");
	}

}
