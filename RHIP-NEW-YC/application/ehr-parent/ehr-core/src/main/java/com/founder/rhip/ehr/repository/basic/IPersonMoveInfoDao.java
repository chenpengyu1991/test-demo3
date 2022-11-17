package com.founder.rhip.ehr.repository.basic;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.basic.PersonMoveInfo;
import com.founder.rhip.mdm.entity.Organization;

/**
 * DAO interface of PersonMoveInfo
 */
public interface IPersonMoveInfoDao extends IDao<PersonMoveInfo, Long> {

	PageList<Map<String, Object>> exportMovePersonRecordList(Page page,
			Criteria criteria, Order order);

	/**
	 * 机构合并引起机构迁移记录
	 * @param oldOrgCodes
	 * @param newOrg
	 * @param operator
	 */
	public void batchInsertMergeOrgan(List<String> oldOrgCodes, Organization newOrg, String operator);

	/**
	 * 机构和村关系变化引起的机构迁移记录
	 * @param newAddVillageCodes
	 * @param newOrg
	 * @param operator
	 */
	public void batchInsertChangeRelationOrgVillage(String[] newAddVillageCodes, Organization newOrg, String operator);

}