package com.founder.rhip.ehr.repository.report;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.report.RpWeightSet;

/**
 */
public interface IRpWeightSetDao extends IDao<RpWeightSet, Long> {

    PageList<RpWeightSet> getWeightSets(Criteria criteria, Page page);

    /**
	 * 根据机构 类型和时间的查取表中的数据 只有一段时间在此时间段的也算
	 * @param organCode
	 * @param weightIndex
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public List<RpWeightSet> getWeightSets(String gbCode, String organCode, String weightIndex, Date beginDate, Date endDate);

    /**
     * 个人绩效模拟(查询页面)
     * @param organCode
     * @param rpType
     * @param weightIndex
     * @param beginDate
     * @param endDate
     * @return
     */
    public List<Map<String, Object>> getStaffRpPaList(String organCode, String rpType, String weightIndex, String weightIndexColumn, String beginDate, String endDate);
}