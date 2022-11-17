package com.founder.rhip.mdm.app;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Dictionary;

import java.util.List;
import java.util.Map;

public interface IDictionaryApp {
	
	/**
	 * 查询字典目录
	 * @param criteria
	 * @return List<Dictionary>
	 */
	public List<Dictionary> queryDictionaryDir(Criteria criteria);

	/**
	 * 注册字典
	 * @param dictionary
	 * @return String
	 */
	public String registDictionary(Dictionary dictionary) throws CheckException;
	
	/**
	 * 注册字典项
	 * @param dictionary
	 * @return String
	 */
	public int registDicItems(List<DicItem> items) throws CheckException;
	
	/**
	 * 查询字典
	 * @param criteria
	 * @return
	 */
	public Dictionary queryDictionary(String dicCode);
	
	/**
	 * 查询字典项
	 * @param criteria
	 * @return Dictionary
	 */
	public List<DicItem> queryDicItem(String dicCode);
	
	/**
	 * 查询字典项
	 * @param criteria
	 * @return Dictionary
	 */
	public List<DicItem> queryDicItems(String dicCode, String parentCode);
	
	/**
	 * 查询字典值
	 * @param criteria
	 * @return Dictionary
	 */
	public String queryDicItemName(String dicCode, String itemCode);
	
	/**
	 * 查询字典项
	 * @param criteria
	 * @return
	 */
	public DicItem queryDicItem(String dicCode, String itemCode);
	
	/**
	 * 查询字典项
	 * @param criteria
	 * @return
	 */
	public List<DicItem> queryDicItem(Criteria criteria);
	
	/**
	 * 查询字典项
	 * @param criteria
	 * @return Dictionary
	 */
	public Map<String, String> queryDicItemMap(String dicCode);
	
	/**
	 * 查询字典项
	 * @param criteria
	 * @return
	 */
	public Map<String, String> queryDicItemMap(Criteria criteria);
}
