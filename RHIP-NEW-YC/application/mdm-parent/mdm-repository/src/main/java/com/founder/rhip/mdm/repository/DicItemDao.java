
package com.founder.rhip.mdm.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Dictionary;

@Repository("mdmDicItemDao")
public class DicItemDao extends MDMRepository<DicItem, Long> implements IDicItemDao {

	protected static final String DIC_ITEM_LOG = "DIC_ITEM_LOG";

	protected static final String DIC_ITEM = "DIC_ITEM";

	@Override
	public List<DicItem> getDicItemByVersion(Criteria criteria, Long version) {
		criteria.add(Dictionary.VERSION, version);
		setTableName(DIC_ITEM_LOG);
		List<DicItem> itemLogs = getList(criteria);
		setTableName(DIC_ITEM);
		criteria.remove(Dictionary.VERSION);
		criteria.add("VERSION", OP.LT, version);// <
		List<DicItem> items = getList(criteria);
		Map<String, Integer> itemMap = new HashMap<String, Integer>();
		for (int i = 0; i < items.size(); i++) {
			DicItem item = items.get(i);
			itemMap.put(item.getDicCode() + "|" + item.getItemCode(), i);
		}
		for (DicItem logItem : itemLogs) {
			String key = logItem.getDicCode() + "|" + logItem.getItemCode();
			if (itemMap.containsKey(key)) {
				items.set(itemMap.get(key), logItem);
			}
		}
		return items;
	}

	@Override
	public void deleteLogs(Criteria criteria) {
		setTableName(DIC_ITEM_LOG);
		delete(criteria);
		setTableName(DIC_ITEM);
	}

	@Override
	public void insertLogs(Criteria criteria) {
		insertLogRecord(DIC_ITEM_LOG, criteria);
	}
	
	@Override
	public void batchChangeStatus(Dictionary dictionary) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE ").append(DIC_ITEM)
		.append(" SET STATUS = ?, OPERATOR = ?, OPERATE_TIME = ?, OPERATE_TYPE = ? ")
		.append(" WHERE DIC_CODE = '").append(dictionary.getDicCode()).append("'");
		//setDynamicDataSource();
		simpleJdbcTemplate.update(sql.toString(), dictionary.getStatus(), dictionary.getOperator(), dictionary.getOperateTime(), dictionary.getOperateType());
	}

	@Override
	public PageList<DicItem> getLogList(Page page, Long itemId, String... properties) {
		String fields = StringUtil.join(coverPropertiesToFields(properties));
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ").append(fields).append(" FROM ").append(DIC_ITEM).append(" WHERE ITEM_ID = ").append(itemId)
			.append(" UNION ").append("SELECT ").append(fields).append(" FROM ").append(DIC_ITEM_LOG).append(" WHERE ITEM_ID = ").append(itemId)
			.append(" ORDER BY OPERATE_TIME DESC");
		return getPageList(page, sql.toString(), null);
	}
	
	/**
	 * 查询最新字典项不在表Organization_Area中的行政村
	 */
	@Override
	public List<DicItem> getDicItemsForOrgArea(String parentCode) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM DIC_ITEM WHERE DIC_CODE = 'FS990001'");
		sql.append(" AND NOT EXISTS  (SELECT * FROM MDM_ORGANIZATION_AREA O WHERE O.AREA_CODE = ITEM_CODE)");
		if(StringUtil.isNotEmpty(parentCode)) {
			sql.append(" AND PARENT_CODE = '"+ parentCode +"'");
		}
		sql.append(" AND length(ITEM_CODE) = 12 AND substr(ITEM_CODE, -3, 3) <> '000' ORDER BY ITEM_CODE");
		return this.getList(sql.toString());
	}

	@Override
	public void updateDicItem(DicItem item) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE ").append(DIC_ITEM)
		.append(" SET ICD_CODE = ? ")
		.append(" WHERE DIC_CODE = '").append(item.getDicCode()).append("' AND ITEM_CODE='").append(item.getItemCode()).append("'");
		simpleJdbcTemplate.update(sql.toString(), item.getIcdCode());
	}
	
	@Override
	public PageList<DicItem> getDicItemPageList(Page page, DicItem dicItem, boolean autoSelect) {
		StringBuilder sqlBuilder = new StringBuilder();
		if (autoSelect) {
			sqlBuilder.append(" select distinct t.item_code,t.item_name,t.item_id ");
		} else {
			sqlBuilder.append(" select t.*  ");
		}
		sqlBuilder.append(" from dic_item t inner join dic_version dv on t.dic_code=dv.dic_code "
				+ " and t.version=dv.version_number and dv.major_version=1 %1$S and t.status=1 %2$S %3$S "
				+ " and not exists (select 1 from dic_item_map dp where dp.item_code_version = %4$S %5$S "
				+ " and dp.local_item_code = t.item_code and dp.status=1) order by t.item_id ");
		/*String sql = " select t.* from dic_item t inner join dic_version dv on t.dic_code=dv.dic_code "
				+ " and t.version=dv.version_number and dv.major_version=1 %1$S and t.status=1 %2$S %3$S "
				+ " and not exists (select 1 from dic_item_map dp where dp.item_code_version = %4$S "
				+ " and dp.local_item_code = t.item_code and dp.status=1) ";*/
		StringBuilder dicCodeBuilder = new StringBuilder();
		if (ObjectUtil.isNotEmpty(dicItem.getDicCode())) {
			dicCodeBuilder.append(" and UPPER(t.dic_code) ='").append(dicItem.getDicCode().toUpperCase()).append("'");
		}
		StringBuilder organCondtionBuilder = new StringBuilder();
		if (ObjectUtil.isNotEmpty(dicItem.getOrganCode())) {
			organCondtionBuilder.append(" and UPPER(t.cs1)='").append(dicItem.getOrganCode().toUpperCase()).append("'");
		}
		StringBuilder itemNameBuilder = new StringBuilder();
		if (ObjectUtil.isNotEmpty(dicItem.getItemName())) {
			if (autoSelect) {
				itemNameBuilder.append(" and (UPPER(t.item_name) like '%").append(dicItem.getItemName().toUpperCase()).append("%'")
				.append(" or UPPER(t.item_code) like '%").append(dicItem.getItemName().toUpperCase()).append("%'")
				.append(" or UPPER(t.py_code) like '%").append(dicItem.getItemName().toUpperCase()).append("%'")
				.append(" or UPPER(t.wb_code) like '%").append(dicItem.getItemName().toUpperCase()).append("%')");
			} else {
				itemNameBuilder.append(" and t.ITEM_NAME like '%").append(dicItem.getItemName()).append("%'");
			}
		}
		StringBuilder itemMapOrgCondition = new StringBuilder();
		if (ObjectUtil.isNotEmpty(dicItem.getOrganCode())) {
			itemMapOrgCondition.append(" and UPPER(dp.domain_id)='").append(dicItem.getOrganCode().toUpperCase()).append("'");
		}
		String executeSql = String.format(sqlBuilder.toString(), dicCodeBuilder.toString(), organCondtionBuilder.toString(), itemNameBuilder.toString(), dicItem.getVersion(), itemMapOrgCondition.toString());
		return getPageList(page, executeSql, new Criteria());
	}
}
