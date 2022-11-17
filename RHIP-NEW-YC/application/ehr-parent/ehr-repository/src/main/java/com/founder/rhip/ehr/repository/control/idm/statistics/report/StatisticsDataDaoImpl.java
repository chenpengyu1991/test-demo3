package com.founder.rhip.ehr.repository.control.idm.statistics.report;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.control.idm.statistics.report.StatisticsData;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of IdmInterview
 * 
 */
@Repository("statisticsDataDao")
public class StatisticsDataDaoImpl extends AbstractDao<StatisticsData, Long> implements IStatisticsDataDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    /**
	 * 查询直报报表数据：创建人、创建机构、创建时间
	 * @param type
	 * @param orgCode
	 * @param fillDate
	 * @return	StatisticsData
	 */
	@Override
    public StatisticsData getStatisticsInfo(Integer type, String orgCode, String fillDate){
		StringBuilder sql = new StringBuilder();
		sql.append(" select FILL_ORGAN_CODE,FILL_USER_ID,FILL_DT");
		sql.append(" from IDM_STATISTICS");
		sql.append(" WHERE TO_CHAR(FILL_DATE,'yyyy/mm')='");
		sql.append(fillDate + "'");
		sql.append(" AND FILL_ORGAN_CODE='" + orgCode + "'");
		sql.append(" and TYPE = '" + type + "'");
		sql.append(" and rownum = 1");
		SqlBuilder.buildOrderStatement(sql, " FILL_DT DESC");
		return this.get(sql.toString(),new Criteria());
    }
}