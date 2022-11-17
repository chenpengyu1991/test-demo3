package com.founder.rhip.ehr.repository.control.idm.statistics.report;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.control.idm.statistics.report.StatisticsData;

/**
 * DAO interface of IdmInterview
 * 
 */
public interface IStatisticsDataDao extends IDao<StatisticsData,Long> {

    /**
	 * 查询直报报表数据：创建人、创建机构、创建时间
	 * @param type
	 * @param orgCode
	 * @param fillDate
	 * @return	StatisticsData
	 */
    public StatisticsData getStatisticsInfo(Integer type, String orgCode, String fillDate);
}