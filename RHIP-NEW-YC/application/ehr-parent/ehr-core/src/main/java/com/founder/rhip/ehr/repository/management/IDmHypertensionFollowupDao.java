package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.dto.ReportQueryForm;
import com.founder.rhip.ehr.entity.management.DmHypertensionFollowup;
import com.founder.rhip.mdm.entity.Organization;

import java.util.List;
import java.util.Map;

/**
 * 高血压随访
 * 
 * @author liuk
 * 
 */
public interface IDmHypertensionFollowupDao extends IDao<DmHypertensionFollowup, Long> {

	List<DmHypertensionFollowup> getUnDeList(Criteria criteria);

	DmHypertensionFollowup getLastFollowup(Long personId);

	/**
	 * 根据随访方式代码统计各个的随访数量
	 * @param criteria
	 * @return
	 */
	public Map<String, Object> getNumGroupByVisitWayCode(Criteria criteria);

	/**
	 * 随访统计
	 * @param page
	 * @param form
	 * @return
	 */
	PageList<Map<String, Object>> getFollowupStatistics(Page page, ReportQueryForm form, Organization currentOrg);
}
