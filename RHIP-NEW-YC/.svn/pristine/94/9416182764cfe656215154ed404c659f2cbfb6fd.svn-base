package com.founder.rhip.mdm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.mdm.entity.Domain;

import java.util.List;
import java.util.Map;

public interface IDomainService {
	
	/**
	 * 查询域
	 * @return      List<Domain>
	 */
	public PageList<Domain> queryDomains(Page page, Criteria criteria);
	
	/**
	 * 查询域
	 * @return      List<Domain>
	 */
	public List<Domain> queryDomains(Criteria criteria);
	
	/**
	 * 注册域
	 * @param     Domain
	 * @return      String
	 */
	public String insertDomain(Domain domain);
	
	/**
	 * 修改域
	 * @param     Domain
	 * @return      String
	 */
	public String updateDomain(Domain domain);
	
	/**
	 * 删除域
	 * @param     Domains
	 * @return      Boolean
	 */
	public Boolean deleteDomain(String domainCode);

	/**
	 * 取得系统域的MAP
	 * @param criteria
	 * @return
	 */
	public Map<String, String> getDomainMapUseCache(Criteria criteria);

	/**
	 * 取得系统域
	 * @param domainCode
	 * @return
	 */
	public Domain getDomain(String domainCode);

	

}
