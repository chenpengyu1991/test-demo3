package com.founder.rhip.ehr.repository.oh;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.control.oh.OhChemicalsUsed;

public interface IOhChemicalsUsedDao extends IDao<OhChemicalsUsed, Integer>{

	/**
	 * 化学物质使用情况查询
	 * @param       criteria
	 * @return      PageList<OhChemicalsUsed>
	 */
	PageList<OhChemicalsUsed> searchChemicalsUsedList(Page page, Criteria criteria);
	
	/**
	 * 化学物质使用保存
	 * @param       OhChemicalsUsed
	 * @return      Boolean
	 */
	Boolean saveChemicalsUsed(OhChemicalsUsed condition);
}
