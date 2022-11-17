package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.management.DmDiabeticFollowup;

import java.util.List;
import java.util.Map;

/**
 * 糖尿病随访
 * 
 * @author liuk
 * 
 */
public interface IDmDiabeticFollowupDao extends IDao<DmDiabeticFollowup, Long> {

	List<DmDiabeticFollowup> getUnDeList(Criteria criteria);

	DmDiabeticFollowup getLastFollowup(Long personId);

	/**
	 * 根据随访方式代码统计各个的随访数量
	 * @param criteria
	 * @return
	 */
	public Map<String, Object> getNumGroupByVisitWayCode(Criteria criteria);
}
