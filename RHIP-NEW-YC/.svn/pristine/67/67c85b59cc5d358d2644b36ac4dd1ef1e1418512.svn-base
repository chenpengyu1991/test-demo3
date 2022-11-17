package com.founder.rhip.portal.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.portal.PortalSet;

import java.util.HashMap;
import java.util.List;


public interface IPortalSetService {
	/** 
	* @Title: getSetingByType 
	* @Description: 根据类型查询
	* @param @param type
	* @param @return
	* @return HashMap<String,String>
	* @throws 
	*/
	HashMap<String, String> getSetByType(String type);

	/** 
	* @Title: getSetList 
	* @Description: 根据条件查询
	* @param @param criteria
	* @param @return
	* @return List<PortalSet>
	* @throws 
	*/
	List<PortalSet> getSetList(Criteria criteria);

	/** 
	* @Title: getSet 
	* @Description: 根据条件查询
	* @param @param criteria
	* @param @return
	* @return PortalSet
	* @throws 
	*/
	PortalSet getSet(Criteria criteria);

	/** 
	* @Title: getSetPageList 
	* @Description: 根据条件查询
	* @param @param criteria
	* @param @param page
	* @param @return
	* @return PageList<PortalSet>
	* @throws 
	*/
	PageList<PortalSet> getSetPageList(Criteria criteria, Page page);

	/** 
	* @Title: save 
	* @Description: 保存
	* @param @param portalSet
	* @param @return
	* @return Integer
	* @throws 
	*/
	Integer save(PortalSet portalSet);

	/** 
	* @Title: delete 
	* @Description: 删除
	* @param @param setId
	* @param @return
	* @return Integer
	* @throws 
	*/
	Integer delete(Long setId);

	/** 
	* @Title: getByCode 
	* @Description: 根据CODE查询
	* @param @param code
	* @param @return
	* @return PortalSet
	* @throws 
	*/
	String getByCode(String code);
	
	/** 
	* @Title: getSetByType 
	* @Description: 根据类型查询
	* @param @param criteria
	* @param @return
	* @return HashMap<String,String>
	* @throws 
	*/
	HashMap<String, String> getSetByType(Criteria criteria);
	
	/***
	 * @Title: getNameByCode 
	 * @Description: 根据CODE查询Name
	 * @param code
	 * @return
	 */
	String getNameByCode(String code);
}

