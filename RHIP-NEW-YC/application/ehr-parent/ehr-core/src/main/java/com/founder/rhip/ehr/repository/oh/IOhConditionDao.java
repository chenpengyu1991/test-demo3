package com.founder.rhip.ehr.repository.oh;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.control.oh.OhCondition;

public interface IOhConditionDao extends IDao<OhCondition, Integer>{

	/**
	 * 重点企业职业卫生情况查询
	 * @param       criteria
	 * @return      PageList<IdmReport>
	 */
	PageList<OhCondition> searchConditionList(Page page, Criteria criteria);
	
	/**
	 * 职业卫生情况保存
	 * @param       Condition
	 * @return      Boolean
	 */
	Boolean saveCondition(OhCondition condition);
}
