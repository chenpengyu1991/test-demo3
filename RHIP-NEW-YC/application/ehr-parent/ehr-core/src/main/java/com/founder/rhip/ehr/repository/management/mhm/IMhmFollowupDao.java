package com.founder.rhip.ehr.repository.management.mhm;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.management.mhm.MhmFollowup;

/**
 * DAO interface of MhmFollowup
 * 
 */
public interface IMhmFollowupDao extends IDao<MhmFollowup,Long> {

	/**
     * 查看随访列表
     * @param       criteria
     * @return      PageList<MhmFollowup>
     */
	public PageList<MhmFollowup> findList(Criteria criteria,Page page);

	public MhmFollowup getLastFollowup(Criteria criteria);
}