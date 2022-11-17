package com.founder.rhip.mdm.app;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Record;
import com.founder.rhip.mdm.common.OperateType;
import com.founder.rhip.mdm.common.StatusValue;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Dictionary;
import com.founder.rhip.mdm.entity.EntityType;
import com.founder.rhip.mdm.service.IDictionaryService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service("dictionaryApp")
public class DictionaryApp extends MDMBaseApp implements IDictionaryApp {
	
	@Resource(name="mdmDictionaryService")
	private IDictionaryService dictionaryService;

	@Override
	public List<Dictionary> queryDictionaryDir(Criteria criteria) {
		setStatusToCriteria(criteria);
		List<Dictionary> dir = dictionaryService.getDicmetas(criteria);
		return dir;
	}

	@Override
	public String registDictionary(Dictionary dictionary) throws CheckException {
		String dicCode = dictionary.getDicCode();
		Long operateTime = getOperatorTime();
		dictionary.setOperateTime(operateTime);
		dictionary.setOperateType(OperateType.regist.getName());
		Record record = new Record(dictionary);
		List<String> chkMessageList = new ArrayList<String>();
		notNullCheck(chkMessageList, record, EntityType.DICTIONARY);
		maxLengthCheck(chkMessageList, record, EntityType.DICTIONARY);
		
		List<DicItem> items = dictionary.getItems();
		if (items != null) {
			for (DicItem item : items) {
				item.setDicCode(dicCode);
				item.setOperateTime(operateTime);
				Record recordItem = new Record(item);
				notNullCheck(chkMessageList, recordItem, EntityType.DIC_ITEM);
				maxLengthCheck(chkMessageList, recordItem, EntityType.DIC_ITEM);
			}
		}
		
		if (chkMessageList.size() > 0) {
			throw getCheckException(chkMessageList);
		}
		
		Dictionary dbDictionary = dictionaryService.getDictionary(new Criteria(Dictionary.DIC_CODE, dicCode));
		if (dbDictionary == null) {
			dictionaryService.createDictionary(dictionary);
		} else {
			dictionaryService.updateDicmeta(dictionary);
		}
		return dicCode;
	}
	
	@Override
	public int registDicItems(List<DicItem> items) throws CheckException {
		List<String> chkMessageList = new ArrayList<String>();
		Long operateTime = getOperatorTime();
		if (items != null) {
			Set<String> dicCodes = new HashSet<String>();
			for (DicItem item : items) {
				item.setOperateTime(operateTime);
				item.setOperateType(OperateType.regist.getName());
				Record recordItem = new Record(item);
				notNullCheck(chkMessageList, recordItem, EntityType.DIC_ITEM);
				maxLengthCheck(chkMessageList, recordItem, EntityType.DIC_ITEM);
				
				String dicCode = item.getDicCode();
				if (!dicCodes.contains(dicCode)) {
					Dictionary dbDictionary = dictionaryService.getDictionary(new Criteria(Dictionary.DIC_CODE, dicCode));
					if (dbDictionary == null) {
						chkMessageList.add("字典编码（" + dicCode + ")不存在");
					}
					dicCodes.add(dicCode);
				}
			}
		}
		if (chkMessageList.size() > 0) {
			throw getCheckException(chkMessageList);
		}
		
		List<DicItem> createList = new ArrayList<DicItem>();
		List<DicItem> updateList = new ArrayList<DicItem>();
		for (DicItem item : items) {
			String dicCode = item.getDicCode();
			String itemCode = item.getItemCode();
			DicItem dbItem = dictionaryService.getDicItem(dicCode, itemCode);
			if (dbItem == null) {
				createList.add(item);
			} else {
				item.setItemId(dbItem.getItemId());
				item.setStatus(dbItem.getStatus());
				updateList.add(item);
			}
		}
		dictionaryService.createDicItems(createList);
		dictionaryService.updateDicItems(updateList);
		return items.size();
	}

	@Override
	public Dictionary queryDictionary(String dicCode) {
		Criteria criteria = new Criteria(Dictionary.DIC_CODE, dicCode);
		Dictionary dictionary = dictionaryService.getDictionary(criteria);
		return dictionary;
	}

	@Override
	public List<DicItem> queryDicItem(String dicCode) {
		Criteria criteria = new Criteria(Dictionary.DIC_CODE, dicCode);
		return queryDicItem(criteria);
	}
	
	@Override
	public List<DicItem> queryDicItems(String dicCode, String parentCode) {
		Criteria criteria = new Criteria(Dictionary.DIC_CODE, dicCode);
		criteria.add(DicItem.PARENT_CODE, parentCode);
		return queryDicItem(criteria);
	}
	
	@Override
	public DicItem queryDicItem(String dicCode, String itemCode) {
		Criteria criteria = new Criteria(Dictionary.DIC_CODE, dicCode);
		criteria.add(DicItem.ITEM_CODE, itemCode);
		List<DicItem> dicItems = queryDicItem(criteria);
		if (dicItems != null && dicItems.size() > 0) {
			return dicItems.get(0);
		}
		return null;
	}
	
	@Override
	public String queryDicItemName(String dicCode, String itemCode) {
		DicItem item = queryDicItem(dicCode, itemCode);
		return (item == null) ? "" : item.getItemName();
	}

	@Override
	public Map<String, String> queryDicItemMap(String dicCode) {
		Criteria criteria = new Criteria(Dictionary.DIC_CODE, dicCode);
		setStatusToCriteria(criteria);
		return queryDicItemMap(criteria);
	}

	@Override
	public List<DicItem> queryDicItem(Criteria criteria) {
		setStatusToCriteria(criteria);
		List<DicItem> items = dictionaryService.getDicItemsUseCache(criteria);
		return items;
	}

	@Override
	public Map<String, String> queryDicItemMap(Criteria criteria) {
		setStatusToCriteria(criteria);
		Map<String, String> map = dictionaryService.getDicItemMapUseCache(criteria);
		return map;
	}
	
	private Criteria setStatusToCriteria(Criteria criteria) {
		if (criteria == null) {
			return criteria;
		}
		if (!criteria.contains(Dictionary.STATUS)) {
			criteria.add(Dictionary.STATUS, StatusValue.normalValue.getValue());
		}
		return criteria;
	}

}
