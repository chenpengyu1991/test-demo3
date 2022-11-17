
package com.founder.rhip.mdm.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.beans.Record;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.common.StatusValue;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.DicItemMap;
import com.founder.rhip.mdm.entity.DicVersion;
import com.founder.rhip.mdm.entity.Dictionary;
import com.founder.rhip.mdm.entity.EntityType;
import com.founder.rhip.mdm.repository.IDicItemDao;
import com.founder.rhip.mdm.repository.IDicItemMapDao;
import com.founder.rhip.mdm.repository.IDicVersionDao;
import com.founder.rhip.mdm.repository.IDictionaryDao;
import com.founder.rhip.mdm.repository.IOrganizationAreaDao;

@Service("mdmDictionaryService")
public class DictionaryService extends MDMService implements IDictionaryService {

	@Resource(name="mdmDictionaryDao")
	private IDictionaryDao dictionaryDao;

	@Resource(name="dictionaryApp")
	private IDictionaryApp dictionaryApp;
	
	@Resource(name="mdmDicItemDao")
	private IDicItemDao dicItemDao;
	
	@Resource(name = "mdmDicVersionDao")
	private IDicVersionDao mdmDicVersionDao;
	
	
	@Resource(name = "mdmDicItemMapDao")
	private IDicItemMapDao mdmDicItemMapDao;
	
	@Resource(name="mergerTownListenerManager")
	private IMergerTownListenerManager mergerTownListenerManager;

	@Resource(name="mdmOrganizationAreaDao")
	private IOrganizationAreaDao mdmOrganizationAreaDao;
	
	protected static final String SEQ_DIC_CONFIG = "SEQ_DIC_CONFIG";

	protected static final String SEQ_DIC_ITEM = "SEQ_DIC_ITEM";

	/**
	 * 查询字典结构目录列表
	 */
	@Override
	public List<Dictionary> getDicmetas(Criteria criteria) {
		Order order = new Order("DIC_CODE");
		List<Dictionary> dicmateList = dictionaryDao.getList(criteria, order);
		return dicmateList;
	}

	/**
	 * 查询字典结构目录列表
	 */
	@Override
	public PageList<Dictionary> getDicMetas(Page page, Criteria criteria) {
		Order order = new Order("DIC_CODE");
		PageList<Dictionary> dicmateList = dictionaryDao.getPageList(page, criteria, order);
		return dicmateList;
	}

	/**
	 * 查询字典
	 */
	@Override
	public Dictionary getDictionary(Criteria criteria) {
		Dictionary dict = dictionaryDao.get(criteria);
		if (isNotNull(dict)) {
			List<DicItem> items = dicItemDao.getList(criteria);
			dict.setItems(items);
			//List<DicConfig> configs = getDicConfig(criteria);
			//dict.setConfigs(configs);
		}
		return dict;
	}
	
	@Override
	public PageList<DicItem> getDicItems(Page page, Criteria criteria) {
		Order order = new Order("ITEM_CODE");
		PageList<DicItem> dicItems = dicItemDao.getPageList(page, criteria, order);
		return dicItems;
	}

	/**
	 * 查询最新字典项,有缓存
	 */
	@Override
	public List<DicItem> getDicItemsUseCache(Criteria criteria) {
		String key = LSIT_KEY + criteriaToKey(criteria);
		@SuppressWarnings("unchecked")
		List<DicItem> retList = (List<DicItem>) getCache(EntityType.DICTIONARY, key);
		if (retList == null) {
			retList = getDicItems(criteria);
			if (retList != null && retList.size() > 0) {
				setCache(EntityType.DICTIONARY, key, retList);
			}
		}
		return retList;
	}
	
	/**
	 * 查询最新字典项
	 */
	@Override
	public List<DicItem> getDicItems(Criteria criteria) {
		Order order = new Order("SORT");
		order.asc("ITEM_CODE");
		List<DicItem> retList = dicItemDao.getList(criteria, order);
		return retList;
	}

	/**
	 * 查询最新字典项不在表Organization_Area中的行政村
	 */
	@Override
	public List<DicItem> getDicItemsForOrgArea(String parentCode) {
		List<DicItem> retList = dicItemDao.getDicItemsForOrgArea(parentCode);
		return retList;
	}
	
	
	/**
	 * 查询最新字典项,有缓存
	 */
	@Override
	public Map<String, String> getDicItemMapUseCache(Criteria criteria) {
		String key = MAP_KEY + criteriaToKey(criteria);
		@SuppressWarnings("unchecked")
		Map<String, String> retMap = (Map<String, String>) getCache(EntityType.DICTIONARY, key);
		if (retMap == null) {
			retMap = new HashMap<String, String>();
			List<DicItem> items = dicItemDao.getList(criteria);
			for (DicItem item : items) {
				retMap.put(item.getItemCode(), item.getItemName());
			}
			if (retMap.size() > 0) {
				setCache(EntityType.DICTIONARY, key, retMap);
			}
		}
		return retMap;
	}

	/**
	 * 查询指定版本字典项
	 */
	@Override
	public List<DicItem> getDicItemByVersion(Criteria criteria, Long version) {
		return dicItemDao.getDicItemByVersion(criteria, version);
	}

	/**
	 * 查询版本变更信息
	 */
	//public DictionChangedInfo getChangedItemBetweenVersion(String dicCode, Long fromVersion, Long toVersion) {
		//DictionChangedInfo changedInfo = new DictionChangedInfo(fromVersion, toVersion);
		/*Dictionary fromDictionary = getDictionary(new Criteria(Dictionary.DIC_CODE, dicCode), fromVersion);
		Dictionary toDictionary = getDictionary(new Criteria(Dictionary.DIC_CODE, dicCode), toVersion);
		changedInfo.setFromDictionary(fromDictionary);
		changedInfo.setToDictionary(toDictionary);
		List<DicItem> fromList = dicItemDao.getLogList(new Criteria(Dictionary.DIC_CODE, dicCode).add(Dictionary.VERSION, OP.BETWEEN, new Long[] { fromVersion, toVersion - 1 }));
		Map<String, DicItem> fromMap = new HashMap<String, DicItem>();
		Set<String> itemCodeSet= new HashSet<String>();
		for (DicItem item : fromList) {
			if (fromMap.containsKey(item.getItemCode())) {
				DicItem fromItem = fromMap.get(item.getItemCode());
				if (fromItem.getVersion() < item.getVersion()) {
					continue;
				}
			}
			fromMap.put(item.getItemCode(), item);
			itemCodeSet.add(item.getItemCode());
		}
		List<DicItem> toList = getDicItemByVersion(new Criteria(Dictionary.DIC_CODE, dicCode).add("itemCode",OP.IN,itemCodeSet.toArray()), toVersion);
		Map<String, DicItem> toMap = new HashMap<String, DicItem>();
		for (DicItem item : toList) {
			toMap.put(item.getItemCode(), item);
		}
		List<DicItem> createList = dicItemDao.getList(new Criteria(Dictionary.DIC_CODE, dicCode).add(Dictionary.VERSION,OP.BETWEEN, new Long[] { fromVersion, toVersion - 1 }));
		for (DicItem item : createList) {
			changedInfo.setChangedInfo(null, item);
			if(toMap.containsKey(item.getItemCode())){
				toMap.remove(item.getItemCode());
			}
			if(fromMap.containsKey(item.getItemCode())){
				fromMap.remove(item.getItemCode());
			}
		}
		for(String code:fromMap.keySet()){
			changedInfo.setChangedInfo(fromMap.get(code), toMap.get(code));
		}*/
		//return changedInfo;
	//}

	/**
	 * 查询字典历史版本列表
	 */
	@Override
	public List<Dictionary> getDicMetaVersions(String dicCode) {
		Criteria criteria = new Criteria(Dictionary.DIC_CODE, dicCode);
		return dictionaryDao.getDicMetaVersions(criteria);
	}

	/**
	 * 查询指定版本字典
	 */
	@Override
	public Dictionary getDictionary(Criteria criteria, Long version) {
		Dictionary dict = dictionaryDao.get(criteria);
		if (isNotNull(dict)) {
			//List<DicConfig> configs = getDicConfig(criteria);
			//dict.setConfigs(configs);
			List<DicItem> items = getDicItemByVersion(criteria, version);
			dict.setItems(items);
		}
		return dict;
	}

	/**
	 * 创建字典
	 */
	@Transactional
	@Override
	public void createDictionary(Dictionary dictionary) {
		//List<DicConfig> configs = dictionary.getConfigs();
		//if (isNotNull(configs)) {
		//	dicConfigDao.batchInsertWithSeq(configs, SEQ_DIC_CONFIG);
		//}
		List<DicItem> items = dictionary.getItems();
		if (isNotNull(items)) {
			for (DicItem item : items) {
				item.setVersion(0L);
			}
			dicItemDao.batchInsertWithSeq(items, SEQ_DIC_ITEM);
		}
		dictionary.setVersion(1L);
		dictionaryDao.insert(dictionary);
	}

	/**
	 * 仅仅更新字典元数据，不更新字典项和字典配置，不升级字典版本
	 */
	@Transactional
	@Override
	public void updateDicmeta(Dictionary dictionary) {
		dictionaryDao.update(dictionary);
	}

	/**
	 * 仅仅更新更新字典配置,不升级字典版本
	 */
	/*@Transactional
	@Override
	public void updateDicConfigs(Dictionary dictionary) {
		List<DicConfig> configs = dictionary.getConfigs();
		if (isNotNull(configs)) {
			String dicCode = dictionary.getDicCode();
			Criteria criteria = new Criteria(Dictionary.DIC_CODE, dicCode);
			dicConfigDao.delete(criteria);
			dicConfigDao.batchInsertWithSeq(configs, SEQ_DIC_CONFIG);
		}
	}*/
	
	/**
	 * 启用/停用 字典
	 */
	@Transactional
	@Override
	public void changeStatus(Dictionary dictionary) {
		Parameters params = new Parameters(Dictionary.STATUS, dictionary.getStatus());
		Criteria criteria = new Criteria(Dictionary.DIC_CODE, dictionary.getDicCode());
		dictionaryDao.update(params, criteria);
		dicItemDao.insertLogs(criteria);
		dicItemDao.batchChangeStatus(dictionary);
	}

	/**
	 * 删除字典
	 */
	@Transactional
	@Override
	public void deleteDictionary(String dicCode) {
		dictionaryDao.delete(dicCode);
		Criteria criteria = new Criteria(Dictionary.DIC_CODE, dicCode);
		//dicConfigDao.delete(criteria);
		dicItemDao.delete(criteria);
		dicItemDao.deleteLogs(criteria);
	}
	
	/**
	 * 查询字典项
	 */
	@Override
	public DicItem getDicItem(String dicCode, String itemCode) {
		Criteria criteria = new Criteria(Dictionary.DIC_CODE, dicCode);
		criteria.add(DicItem.ITEM_CODE, itemCode);
		DicItem item = dicItemDao.get(criteria);
		return item;
	}

	/**
	 * 添加字典项
	 */
	@Transactional
	@Override
	public void createDicItem(DicItem item) {
		String dicCode = item.getDicCode();
		Dictionary dictionary = dictionaryDao.get(dicCode);
		item.setVersion(dictionary.getVersion());
		dicItemDao.insertWithSeq(item, SEQ_DIC_ITEM);
		removeCache(EntityType.DICTIONARY, dicCode);
	}
	
	/**
	 * 批量添加字典项
	 */
	@Transactional
	@Override
	public void createDicItems(List<DicItem> items) {
		if (items == null || items.size() == 0) {
			return;
		}
		Map<String, Long> versions = new HashMap<String, Long>();
		for (DicItem item : items) {
			String dicCode = item.getDicCode();
			if (versions.containsKey(dicCode)) {
				item.setVersion(versions.get(dicCode));
			} else {
				Dictionary dictionary = dictionaryDao.get(dicCode);
				Long version = dictionary.getVersion();
				item.setVersion(version);
				versions.put(dicCode, version);
			}
		}
		dicItemDao.batchInsertWithSeq(items, SEQ_DIC_ITEM);
		
		for (String dicCode : versions.keySet()) {
			removeCache(EntityType.DICTIONARY, dicCode);
		}
	}

	/**
	 * 修改字典项
	 */
	@Transactional
	@Override
	public void updateDicItem(DicItem item) {
		Long itemId = item.getItemId();
		String dicCode = item.getDicCode();
		Dictionary dictionary = dictionaryDao.get(dicCode);
		Criteria criteria = new Criteria(DicItem.ITEM_ID, itemId);
		dicItemDao.insertLogs(criteria);
		item.setVersion(dictionary.getVersion());
		dicItemDao.update(item);
		removeCache(EntityType.DICTIONARY, dicCode);
	}

	public void updateItem(DicItem item) {
		Long itemId = item.getItemId();
		String dicCode = item.getDicCode();
		Dictionary dictionary = dictionaryDao.get(dicCode);
		Criteria criteria = new Criteria(DicItem.ITEM_ID, itemId);
		dicItemDao.insertLogs(criteria);
		item.setVersion(dictionary.getVersion());
		dicItemDao.updateDicItem(item);
		removeCache(EntityType.DICTIONARY, dicCode);
	}
	
	/**
	 * 批量修改字典项
	 */
	@Transactional
	@Override
	public void updateDicItems(List<DicItem> items) {
		if (items == null || items.size() == 0) {
			return;
		}
		List<Long> itemIds = new ArrayList<Long>();
		Map<String, Long> versions = new HashMap<String, Long>();
		for (DicItem item : items) {
			itemIds.add(item.getItemId());
			String dicCode = item.getDicCode();
			if (versions.containsKey(dicCode)) {
				item.setVersion(versions.get(dicCode));
			} else {
				Dictionary dictionary = dictionaryDao.get(dicCode);
				Long version = dictionary.getVersion();
				item.setVersion(version);
				versions.put(dicCode, version);
			}
		}
		Criteria criteria = new Criteria(DicItem.ITEM_ID, OP.IN, itemIds);
		dicItemDao.insertLogs(criteria);
		dicItemDao.batchUpdate(items);
		
		for (String dicCode : versions.keySet()) {
			removeCache(EntityType.DICTIONARY, dicCode);
		}
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public int importDicItems(String dicCode, List<Record> dicItemList) {
		List<Record> insertDicItemList = new ArrayList<Record>();
		List<Record> updateDicItemList = new ArrayList<Record>();
		List<Long> updateDicItemCodes = new ArrayList<Long>();
		Long version = dictionaryDao.get(dicCode).getVersion();
		for (Record record : dicItemList) {
			record.set(Dictionary.VERSION, version);
			Criteria criteria = new Criteria(Dictionary.DIC_CODE, dicCode);
			criteria.add(DicItem.ITEM_CODE, record.get(DicItem.ITEM_CODE));
			criteria.add(DicItem.PARENT_CODE, record.get(DicItem.PARENT_CODE));
			DicItem item = dicItemDao.get(criteria);
			if (item == null) {
				record.set(DicItem.ITEM_ID, dicItemDao.getSequenceNextVal(SEQ_DIC_ITEM, Long.class));
				insertDicItemList.add(record);
			} else {
				record.set(DicItem.ITEM_ID, item.getItemId());
				updateDicItemCodes.add(item.getItemId());
				updateDicItemList.add(record);
			}
		}
		
		List<List> logList = getInsertLogs(updateDicItemCodes);
		for (List ids : logList) {
			Criteria criteria = new Criteria(DicItem.ITEM_ID, OP.IN, ids);
			dicItemDao.insertLogs(criteria);
			ids.clear();
			ids = null;
		}
		logList.clear();
		logList = null;
		updateDicItemCodes.clear();
		updateDicItemCodes = null;
		
		String[] properties = dicItemList.get(0).keySet().toArray(new String[]{});
		dicItemDao.batchMapInsert(insertDicItemList, properties);
		dicItemDao.batchMapUpdate(updateDicItemList, properties);
		insertDicItemList.clear();
		insertDicItemList = null;
		updateDicItemList.clear();
		updateDicItemList = null;
		
		return dicItemList.size();
	}
	
	/**
	 * 启用/停用 字典项
	 */
	@Transactional
	@Override
	public void changeItemStatus(DicItem dicItem) {
		Long itemId = dicItem.getItemId();
		DicItem item = dicItemDao.get(itemId);
		Criteria criteria = new Criteria(DicItem.ITEM_ID, itemId);
		dicItemDao.insertLogs(criteria);
		
		item.setStatus(dicItem.getStatus());
		item.setOperator(dicItem.getOperator());
		item.setOperateType(dicItem.getOperateType());
		item.setOperateTime(dicItem.getOperateTime());
		dicItemDao.update(item);
		
		removeCache(EntityType.DICTIONARY, item.getDicCode());
	}
	
	@Transactional
	@Override
	public void deleteDicItem(Long itemId) {
		DicItem item = dicItemDao.get(itemId);
		Criteria criteria = new Criteria(DicItem.ITEM_ID, itemId);
		dicItemDao.deleteLogs(criteria);
		dicItemDao.delete(itemId);
		removeCache(EntityType.DICTIONARY, item.getDicCode());
	}
	/*
	private void deleteVersions(Criteria criteria) {
		//dictionaryDao.deleteVersions(criteria);
		dicItemDao.deleteVersions(criteria);
	}
	*/
	/**
     * 查询字典项的变更跟踪
     * @param page
     * @param itemId
     * @return
     */
	public PageList<DicItem> getDicItemLogs(Page page, Long itemId) {
		return dicItemDao.getLogList(page, itemId);
	}

	/**
	 * 发布新版字典（版本+1）
	 */
	@Transactional
	@Override
	public Long publishDictionary(String dicCode) {
		Dictionary dic = dictionaryDao.get(new Criteria(Dictionary.DIC_CODE, dicCode));
		Long versionInt = dic.getVersion();
		dic.setVersion(++versionInt);
		dictionaryDao.update(dic, Dictionary.VERSION);
		//removeCache(EntityType.DICTIONARY, dicCode);
		return versionInt;
	}
	
	/**
	 * 修改镇和村的关系
	 * @param villageCodes
	 * @param townCode
	 * @return
	 */
	@Transactional
	@Override
	public Boolean saveRelation(String villageCodes, String townCode) {
		String villageArray[] = villageCodes.split(",");
		/*当一些行政村和镇的关系解除以后  级联解除该镇下所有机构与该行政村的关系*/
		mdmOrganizationAreaDao.delete(new Criteria("AREA_CODE", OP.IN, getUncludeVillageCodes(villageArray, townCode)));
		
		Criteria criteria = new Criteria(Dictionary.DIC_CODE, "FS990001");
		criteria.add(DicItem.PARENT_CODE, townCode);
		
		List<DicItem> oldRelations = dicItemDao.getList(criteria);
		//修改之前先清空以前的关系
		dicItemDao.update(new Parameters(DicItem.PARENT_CODE, ""), criteria);
		
		//保存新的关系
		dicItemDao.update(new Parameters(DicItem.PARENT_CODE, townCode), new Criteria(DicItem.ITEM_CODE, OP.IN, villageArray));
		removeCache(EntityType.DICTIONARY, "FS990001");
		String []newAddVillageCodes = this.getNewAddRelation(oldRelations, villageArray);
		if(ObjectUtil.isNotEmpty(newAddVillageCodes)) {
			mergerTownListenerManager.sendTownVillageRelation(townCode, newAddVillageCodes);
		}
		return true;
	}
	
	/**
	 * 获取镇中新增加的新政村的code
	 * @param oldRelations
	 * @param villageArray
	 * @return
	 */
	private String[] getNewAddRelation(List<DicItem> oldRelations, String villageArray[]) {
		List<String> newAddVillageCodes = new ArrayList<String>();
		List<String> oldRelationVillageCodes = new ArrayList<String>();
		for(DicItem item : oldRelations) {
			oldRelationVillageCodes.add(item.getItemCode());
		}
		
		for(String villageCode : villageArray) {
			if(!oldRelationVillageCodes.contains(villageCode)) {
				newAddVillageCodes.add(villageCode);
			}
		}
		return newAddVillageCodes.toArray(new String[newAddVillageCodes.size()]);
	}
	/**
	 * 当一些行政村和镇的关系解除以后  级联解除该镇下所有机构与该行政村的关系
	 * @param villageArray
	 * @param townCode
	 */
	private List<String> getUncludeVillageCodes(String villageArray[], String townCode) {
		Criteria criteria = new Criteria(Dictionary.DIC_CODE, "FS990001");
		criteria.add(DicItem.PARENT_CODE, townCode);
		List<DicItem> villages = getDicItems(criteria);
		List<String> newVillages = Arrays.asList(villageArray);
		List<String> uncludeVillageCodes = new ArrayList<String>();
		
		for (DicItem oldItem : villages) {
			if(ObjectUtil.isNullOrEmpty(newVillages) || !newVillages.contains(oldItem.getItemCode())) {
				uncludeVillageCodes.add(oldItem.getItemCode());
			}
		}
		return uncludeVillageCodes;
	}
	/**
     * 保存合并镇
     * @param townCodes
     * @param request
     * @param model
     * @return
     */
	@Override
    @Transactional
    public String mergeTown(String newCode, String oldCode, DicItem dicItem) {
		Criteria criteriaDicCode = new Criteria(Dictionary.DIC_CODE, "FS990001");
		Criteria criteriaOldParentCode = new Criteria(DicItem.PARENT_CODE, OP.IN, oldCode.split(",")).add(criteriaDicCode);
		Parameters parametersDelete = new Parameters("STATUS", StatusValue.deleteValue.getValue());
		Criteria criteriaItemCode = new Criteria(DicItem.ITEM_CODE, OP.IN, oldCode.split(",")).add(criteriaDicCode);
    	if(StringUtils.isEmpty(newCode)) {
    		//判断新编码是否已存在
    		if (isExistDicItem(dicItem)) {
    			return "exist";
    		}
			this.createDicItem(dicItem);
			dicItemDao.update(parametersDelete,criteriaItemCode);
			//级联更新 Dic_item
			dicItemDao.update(new Parameters(DicItem.PARENT_CODE, dicItem.getItemCode()), criteriaOldParentCode);
			newCode = dicItem.getItemCode();
    	} else {
    		//删除其余数据
    		dicItemDao.update(parametersDelete,criteriaItemCode);
    		dicItemDao.update(new Parameters("STATUS", StatusValue.normalValue.getValue()), new Criteria(DicItem.ITEM_CODE, newCode).add(criteriaDicCode));
    		//级联更新 Dic_item
    		dicItemDao.update(new Parameters(DicItem.PARENT_CODE, newCode), criteriaOldParentCode);
    	}
    	removeCache(EntityType.DICTIONARY, "FS990001");
    	mergerTownListenerManager.sendMergeTown(newCode, oldCode.split(","));
    	return "success";
    }
    
    /**
     * 判断新增时 判断ItemCode是否已存在
     * @param dicItem
     * @return
     */
    private Boolean isExistDicItem(DicItem dicItem) {
    	String dicCode = dicItem.getDicCode();
		String itemCode = dicItem.getItemCode();
		Criteria criteria = new Criteria(Dictionary.DIC_CODE, dicCode);
		criteria.add(DicItem.ITEM_CODE, itemCode);
		DicItem dbItem = this.getDicItem(dicCode, itemCode);
		if (dbItem != null) {
			return true;
		}
		return false;
    }

	@Override
	public DicItem getDicItem(Criteria criteria) {
		DicItem item = dicItemDao.get(criteria);
		return item;
	}
	
	@Override
	public int importDic(List<Record> dicList) {
		List<Record> insertDicList = new ArrayList<Record>();
		List<Record> updateDicList = new ArrayList<Record>();
		List<Long> updateDicCodes = new ArrayList<Long>();
		for (Record record : dicList) {
			String localItemCode = record.getAsString("localItemCode");
			String localDicCode = record.getAsString("localDicCode");
			String domainId = record.getAsString("domainId");
			DicItemMap dicItemMap = mdmDicItemMapDao.get(new Criteria("localItemCode", localItemCode).add("localDicCode", localDicCode).add("domainId", domainId));
			if (dicItemMap == null) {
				//record.set("id", hospitalDicDao.getSequenceNextVal("SEQ_HOSPITAL_DIC", Long.class));
				insertDicList.add(record);
			} else {
				record.set("mapId", dicItemMap.getMapId());
				updateDicCodes.add(dicItemMap.getMapId());
				updateDicList.add(record);
			}
		}
		List<List> logList = getInsertLogs(updateDicCodes);
		for (List ids : logList) {
			Criteria criteria = new Criteria("mapId", OP.IN, ids);
			//standardDictionaryDao.insertLog(criteria);
			ids.clear();
			ids = null;
		}
		logList.clear();
		logList = null;
		updateDicCodes.clear();
		updateDicCodes = null;

		String[] properties = dicList.get(0).keySet().toArray(new String[] {});
		mdmDicItemMapDao.batchMapInsert(insertDicList, properties);
		mdmDicItemMapDao.batchMapUpdate(updateDicList, properties);
		insertDicList.clear();
		insertDicList = null;
		updateDicList.clear();
		updateDicList = null;
		removeCache(EntityType.DIC_ITEM_MAP);
		return dicList.size();
	}
	@Override
	public void setMajorVersion(List<DicItem> dicItems) {
		if (ObjectUtil.isNullOrEmpty(dicItems)) {
			return;
		}
		for (DicItem dicItem : dicItems) {
			if (ObjectUtil.isNullOrEmpty(dicItem) || ObjectUtil.isNullOrEmpty(dicItem.getVersion()) 
					|| ObjectUtil.isNullOrEmpty(dicItem.getItemCode())) {
				continue;
			}
			DicVersion dicVersion = mdmDicVersionDao.get(new Criteria("dicCode", dicItem.getDicCode()).add("versionNumber", dicItem.getVersion()));
			if (dicVersion != null) {
				dicItem.setVersionDesc(dicVersion.getVersionDesc());
				if (ObjectUtil.isNotEmpty(dicVersion.getMajorVersion())) {
					if (dicVersion.getMajorVersion().equals(1)) {
						dicItem.setMajorVersion(1);
					}
				}
			}
		}
	}
	
	public DicItem getDicItem(String dicCode, String itemCode,Long version) {
		Criteria criteria = new Criteria(Dictionary.DIC_CODE, dicCode);
		criteria.add(DicItem.ITEM_CODE, itemCode);
		criteria.add(DicItem.VERSION,version);
		DicItem item = dicItemDao.get(criteria);
		return item;
	}

	@Override
	public PageList<DicItem> getDicItemPageList(Page page, DicItem dicItem, boolean autoSelect) {
		return dicItemDao.getDicItemPageList(page, dicItem, autoSelect);
	}
	
	@Override
	public DicItemMap getDicItemMap(Criteria criteria) {
		return mdmDicItemMapDao.get(criteria);
	}
}
