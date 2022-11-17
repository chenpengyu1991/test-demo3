package com.founder.rhip.mdm.service;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Record;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.DicItemMap;
import com.founder.rhip.mdm.entity.Dictionary;

public interface IDictionaryService {
	
	/**
	 * 查询字典结构目录列表
	 * @param criteria
	 * @return List<Dictionary>
	 */
	public List<Dictionary> getDicmetas(Criteria criteria);
	
	/**
	 * 查询字典结构目录列表
	 * @param page
	 * @param criteria
	 * @return List<Dictionary>
	 */
	public PageList<Dictionary> getDicMetas(Page page,Criteria criteria);
	
    /**
     * 查询字典
     * @param criteria
     * @return Dictionary
     */
	public Dictionary getDictionary(Criteria criteria);
	
    /**
     * 查询最新字典项，有缓存
     * @param dicCode
     * @return Map<String, String>
     */
	public Map<String, String> getDicItemMapUseCache(Criteria criteria);
	
	/**
	 * 查询最新字典项
	 * @param page
	 * @param criteria
	 * @return
	 */
	public PageList<DicItem> getDicItems(Page page, Criteria criteria);
	
    /**
     * 查询最新字典项，有缓存
     * @param criteria
     * @return List<DicItem>
     */
	public List<DicItem> getDicItemsUseCache(Criteria criteria);
	
    /**
     * 查询字典项
     * @param criteria
     * @return List<DicItem>
     */
	public List<DicItem> getDicItems(Criteria criteria);
	
	/**
	 * 查询指定版本字典项
	 */
	public List<DicItem> getDicItemByVersion(Criteria criteria, Long version);
	
	/**
	 * 查询版本变更信息
	 */
	//public DictionChangedInfo getChangedItemBetweenVersion(String dicCode, Long fromVersion,Long toVersion);
	
	/**
	 * 查询字典配置信息
	 * @param dicId
	 * @return List<DicConfig>
	 */
	//public List<DicConfig> getDicConfig(Criteria criteria);
    
    /**
     * 查询字典修改历史
     * @param item
     * @return List<Dictionary>
     */
    public List<Dictionary> getDicMetaVersions(String dicCode);
    
	/**
	 * 查询指定版本字典
     * @param dicId
     * @param version
     * @return Dictionary
	 */
	public Dictionary getDictionary(Criteria criteria, Long version);
	
	/**
	 * 创建字典
	 * @param Dictionary
	 * @return
	 */
	public void createDictionary(Dictionary dictionary);
	
	/**
	 * 仅仅更新字典元数据，不更新字典项和字典配置，不升级字典版本
	 * @param dicMeta
	 */
	public void updateDicmeta(Dictionary dicMeta);
	
	/**
	 * 仅仅更新字典配置，不升级字典版本
	 * @param dictionary
	 */
	//public void updateDicConfigs(Dictionary dictionary);
	
	
	/**
	 * 删除字典
	 * @param dicCode
	 * @return
	 */
	public void deleteDictionary(String dicCode);
	
	/**
	 * 	启用/停用 字典
	 * @param dicCode
	 * @param oldStatus
	 */
	public void changeStatus(Dictionary dictionary);
	
	/**
	 * 查询字典项
	 * @param dicCode
	 * @param itemCode
	 * @return
	 */
	public DicItem getDicItem(String dicCode, String itemCode);
	
	/**
	 * 创建字典项
	 * @param item
	 * @return
	 */
    public void createDicItem(DicItem item);
    
    /**
     * 批量创建字典项
     * @param items
     */
    public void createDicItems(List<DicItem> item);

	/**
	 * 更新字典项
	 * @param item
	 * @return
	 */
    public void updateDicItem(DicItem item);
    
    /**
     * 批量更新字典项
     * @param item
     */
    public void updateDicItems(List<DicItem> item);
    
    /**
     * 启用/停用 字典项
     * @param item
     * @return
     */
    public void changeItemStatus(DicItem dicItem);
    
    /**
     * 删除字典
     * @param itemId
     */
    public void deleteDicItem(Long itemId);
    
    /**
     * 发布新版字典（版本+1）
     * @param dicCode
     * @return 新版本号
     */
    public Long publishDictionary(String dicCode);

    /**
     * 查询字典项的变更跟踪
     * @param page
     * @param itemId
     * @return
     */
	public PageList<DicItem> getDicItemLogs(Page page, Long itemId);

	/**
	 * 导入字典项
	 * @param dicCode
	 * @param dicItemList
	 * @return
	 */
	public int importDicItems(String dicCode, List<Record> dicItemList);
    
	/**
	 * 修改镇和村的关系
	 * @param villageCodes
	 * @param townCode
	 * @return
	 */
	public Boolean saveRelation(String villageCodes, String townCode);
	
	/**
	 * 查询最新字典项不在表Organization_Area中的行政村
	 */
	public List<DicItem> getDicItemsForOrgArea(String parentCode);
	
	/**
     * 保存合并镇
     * @param townCodes
     * @param request
     * @param model
     * @return
     */
    public String mergeTown(String newCode, String oldCode, DicItem dicItem);

	/**
	 *
	 * @param criteria
	 * @return
	 */
	public DicItem getDicItem(Criteria criteria);

	public void updateItem(DicItem dicItem);
	
	/**
	 * 查询指定字典且未配置映射的字典项
	 * @param page
	 * @param dicItem
	 * @param autoSelect
	 * @return
	 */
	public PageList<DicItem> getDicItemPageList(Page page, DicItem dicItem, boolean autoSelect);
	
	
	/**
	 * 查询映射字典信息
	 * @param criteria
	 * @return
	 */
	public DicItemMap getDicItemMap(Criteria criteria);

	int importDic(List<Record> dicList);

	void setMajorVersion(List<DicItem> dicItems);

	public DicItem getDicItem(String dicCode, String itemCode, Long version);
}
