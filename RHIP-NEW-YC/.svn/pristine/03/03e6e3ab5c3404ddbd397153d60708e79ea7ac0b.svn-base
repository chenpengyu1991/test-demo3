package com.founder.rhip.mdm.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.mdm.entity.OrganizationArea;

@Repository("mdmOrganizationAreaDao")
public class OrganizationAreaDao extends MDMRepository<OrganizationArea, Long> implements IOrganizationAreaDao {
	
	/**
	 * 获取OrganizationArea对象集合
	 * @param criteria
	 * @return
	 */
	@Override
	public List<OrganizationArea> getOrganizationAreas(Criteria criteria) {
		List<OrganizationArea> result = new ArrayList<OrganizationArea>();
		StringBuilder sql = new StringBuilder();
		sql.append(" select oa.organization_code,oa.area_code,o.organ_name,item.item_name from mdm_ORGANIZATION_AREA oa ");
		sql.append(" left join mdm_organization o  on oa.organization_code = o.organ_code and o.status <> '-1'");
		sql.append(" left join dic_item item on item.item_code = oa.area_code and item.dic_code = 'FS990001'");
		
		SqlBuilder.buildWhereStatement(OrganizationArea.class, sql, criteria) ;
		SqlBuilder.buildOrderStatement(sql, " oa.area_code ASC");
		result = this.getList(sql.toString(), criteria);
		return result;
	}
}
