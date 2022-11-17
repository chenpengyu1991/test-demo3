package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.management.DmTumorFollowup;

import java.util.List;
import java.util.Map;

/**
 * 肿瘤随访
 * 
 * @author liuk
 * 
 */
public interface IDmTumorFollowupDao extends IDao<DmTumorFollowup, Long> {

	List<DmTumorFollowup> getUnDeList(Criteria criteria);

	DmTumorFollowup getLastFollowup(Long personId);

	/**
	 * 根据随访方式代码统计各个的随访数量
	 * @param criteria
	 * @return
	 */
	public Map<String, Object> getNumGroupByVisitWayCode(Criteria criteria);
}
