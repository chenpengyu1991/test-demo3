package com.founder.rhip.ehr.repository.control.idm.statistics.report;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.control.idm.statistics.report.SelfCheck;
import com.founder.rhip.mdm.entity.DicItem;

import java.util.List;

/**
 * DAO interface of IdmSelfCheck
 * 
 */
public interface ISelfCheckDao extends IDao<SelfCheck,Long> {
	
	/**
	 * 查询科室传染病信息
	 * @param criteria
	 * @return List<ListScDc>
	 */    
    public List<SelfCheck> findSelfCheck(Criteria criteria, List<DicItem> departments);

    /**
	 * 查询科室列表
	 * @param criteria
	 * @return List<ListScDc>
	 */
    public List<SelfCheck> findDepartment(Criteria criteria);

	/**
	 * 合计传染病报告
	 * @param criteria
	 * @return SelfCheck
	 */
    public SelfCheck summarySelfCheck(Criteria criteria);

    /**
	 * 合计传染病报告
	 * @param criteria
	 * @return SelfCheck
	 */
    public SelfCheck summaryNeonate(Criteria criteria);

    /**
	 * @param orgCode
	 * @param fillDate
	 * @return	SelfCheck
	 */
    public SelfCheck getSelfCheckInfo(String orgCode, String fillDate);
}