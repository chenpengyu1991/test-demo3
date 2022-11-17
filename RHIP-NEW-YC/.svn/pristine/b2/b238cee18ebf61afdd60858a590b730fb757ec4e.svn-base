package com.founder.rhip.ehr.repository.women;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.Assert;
import com.founder.rhip.ehr.entity.women.WomanDiseaseCensus;

/**
 * DAO implement of WomanDiseaseCensus
 * 
 */
@Repository("womanDiseaseCensusDao")
public class WomanDiseaseCensusDaoImpl extends AbstractDao<WomanDiseaseCensus, String> implements IWomanDiseaseCensusDao {
	@Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public List<Map<String, Object>> getWomanDiseaseCensusMapList(String dateStr) {
		Assert.notNull(dateStr);
		StringBuilder sqlBuilder = new StringBuilder("select t.create_organ_code organCode,to_char(t.check_date,'yyyy/MM/dd')rpDate,count(1) SCREENING_WOMEN_NUM "
				+ "from wh_woman_disease_census t where to_char(t.gather_date,'yyyy/MM/dd')='").append(dateStr).append("' group by t.create_organ_code,to_char(t.check_date,'yyyy/MM/dd')");
		
		return getMapList(sqlBuilder.toString(), new Criteria());
	}
}