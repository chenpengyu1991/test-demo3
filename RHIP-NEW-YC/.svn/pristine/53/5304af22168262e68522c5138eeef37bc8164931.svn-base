package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.management.DmStrtumFollowup;

import java.util.List;
import java.util.Map;

/**
 * 冠心病脑卒中随访
 * 
 * @author liuk
 * 
 */
public interface IDmStrtumFollowupDao extends IDao<DmStrtumFollowup, Long> {

	List<DmStrtumFollowup> getUnDeList(Criteria criteria);

	DmStrtumFollowup getLastStrokeFollowup(Long personId);

	DmStrtumFollowup getLastCoronaryFollowup(Long personId);

	/**
	 * 根据随访方式代码统计各个的随访数量
	 * @param criteria
	 * @return
	 */
	public Map<String, Object> getNumGroupByVisitWayCode(Criteria criteria);

}
