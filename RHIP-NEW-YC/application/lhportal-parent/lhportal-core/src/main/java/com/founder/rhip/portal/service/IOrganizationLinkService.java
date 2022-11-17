package com.founder.rhip.portal.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.rhip.ehr.entity.portal.OrganizationLink;

import java.util.Map;

/**
 * 
 * @author Zhou Yang
 *
 */
public interface IOrganizationLinkService {

	/**
	 * 获取分页式的列表数据
	 * @param criteria
	 * @param page
	 * @return
	 */
	PageList<OrganizationLink> getList(Page page, Criteria criteria);

	/**
	 * 获取
	 * @param id
	 * @return
	 */
	public OrganizationLink get(Long id);
	
	/**
	 * 删除
	 * @param id
	 */
	public int delete(Long id);
	
	/**
	 * 更新医疗机构链接信息
	 * @param organizationLink
	 * boolean
	 */
	public boolean update(OrganizationLink organizationLink, Map<String, String> map, String createUserCode);
	
	/**
	 * 保存医疗机构链接信息
	 * @param organizationLink
	 * boolean
	 */
	public boolean save(OrganizationLink organizationLink, Map<String, String> map, String createUserCode);

	int updateStatus(Parameters parameters, Criteria criteria);
}
