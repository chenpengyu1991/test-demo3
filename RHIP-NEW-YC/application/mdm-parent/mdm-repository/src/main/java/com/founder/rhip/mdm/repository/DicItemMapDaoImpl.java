package com.founder.rhip.mdm.repository;

import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.DicItemMap;

@Repository("mdmDicItemMapDao")
public class DicItemMapDaoImpl extends MDMRepository<DicItemMap, Long>
		implements IDicItemMapDao {

	

	@Override
	public PageList<DicItemMap> getDistinctDicItemMapPageList(DicItemMap dicItemMap, Page page, String hospitalFlag) {
		StringBuilder sqlBuilder = new StringBuilder();
		if (ObjectUtil.isNullOrEmpty(hospitalFlag)) {
			sqlBuilder.append(" select distinct item_name,item_code ");
		} else {
			sqlBuilder.append(" select distinct local_item_name,local_item_code ");
		}
		sqlBuilder.append(" from DIC_ITEM_MAP where status=1 %1$S %2$S %3$S %4$S ");
//		String sql = " select distinct item_name,item_code from DIC_ITEM_MAP where status=1 %1$S %2$S %3$S %4$S ";
		
		StringBuilder dicCodeBuilder = new StringBuilder();
		if (ObjectUtil.isNotEmpty(dicItemMap.getDicCode())) {
			dicCodeBuilder.append(" and UPPER(dic_code) ='").append(dicItemMap.getDicCode().toUpperCase()).append("'");
		}
		StringBuilder organCondtionBuilder = new StringBuilder();
		if (ObjectUtil.isNotEmpty(dicItemMap.getDomainId())) {
			organCondtionBuilder.append(" and domain_id='").append(dicItemMap.getDomainId()).append("'");
		}
		StringBuilder itemNameBuilder = new StringBuilder();
		if (ObjectUtil.isNullOrEmpty(hospitalFlag)) {
			itemNameBuilder.append(" and (UPPER(item_name) like '%").append(dicItemMap.getItemName().toUpperCase()).append("%'")
			.append(" or UPPER(item_code) like '%").append(dicItemMap.getItemName().toUpperCase()).append("%'")
			.append(" or UPPER(py_code) like '%").append(dicItemMap.getItemName().toUpperCase()).append("%'")
			.append(" or UPPER(wb_code) like '%").append(dicItemMap.getItemName().toUpperCase()).append("%')");
		} else {
			itemNameBuilder.append(" and (UPPER(local_item_name) like '%").append(dicItemMap.getLocalItemName().toUpperCase()).append("%'")
			.append(" or UPPER(local_item_code) like '%").append(dicItemMap.getLocalItemName().toUpperCase()).append("%')");
		}
		StringBuilder versionBuilder = new StringBuilder();
		if (ObjectUtil.isNotEmpty(dicItemMap.getItemCodeVersion())) {
			versionBuilder.append(" and item_code_version =").append(dicItemMap.getItemCodeVersion());
		}
		if (ObjectUtil.isNullOrEmpty(hospitalFlag)) {
			sqlBuilder.append(" order by item_code ");
		} else {
			sqlBuilder.append(" order by local_item_code ");
		}
		String executeSql = String.format(sqlBuilder.toString(), dicCodeBuilder.toString(), organCondtionBuilder.toString(), itemNameBuilder.toString(), versionBuilder.toString());
		return getPageList(page, executeSql, new Criteria());
	}
	
}
