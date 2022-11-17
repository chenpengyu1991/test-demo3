package com.founder.rhip.ehr.repository.oh;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.control.oh.OhContactSituation;

public interface IOhContactSituationDao extends IDao<OhContactSituation, Integer>{

	/**
	 * 化学物质使用情况查询
	 * @param       criteria
	 * @return      PageList<OhContactSituation>
	 */
	PageList<OhContactSituation> searchContactSituationList(Page page, Criteria criteria);
	
	/**
	 * 化学物质使用保存
	 * @param       OhContactSituation
	 * @return      Boolean
	 */
	Boolean saveContactSituation(OhContactSituation ontactSituation);
}
