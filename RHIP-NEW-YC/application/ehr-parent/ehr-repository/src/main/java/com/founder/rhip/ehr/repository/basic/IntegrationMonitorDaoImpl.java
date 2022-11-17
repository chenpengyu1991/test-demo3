package com.founder.rhip.ehr.repository.basic;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.IntegrationMonitor;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository("integrationMonitorDao")
public class IntegrationMonitorDaoImpl extends AbstractDao<IntegrationMonitor, Long> implements
		IIntegrationMonitorDao {
	@Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
	
	private static final String ORGAN_CODE = "ORGAN_CODE";
	private static final String RECORD_DATE = "RECORD_DATE";
	private static final String NUMBER_CODE = "NUMBER_CODE";
	
	@Override
	public IntegrationMonitor getIntegrationMonitor(Criteria criteria) {
		if (!criteria.contains(NUMBER_CODE)
				|| !criteria.contains(RECORD_DATE)) {
			return null;
		}
		StringBuilder sb = new StringBuilder("SELECT ID, FRONT_UPLOAD_COUNT,FACT_UPLOAD_COUNT, FACT_ADD_COUNT, FACT_UPDATE_COUNT, FACT_FAIL_COUNT FROM FS_INTEGRATION_MONITOR WHERE 1=1 ");
		if (criteria.contains(ORGAN_CODE)) {
			sb.append(" AND ORGAN_CODE = '");
			sb.append(criteria.get(ORGAN_CODE));
			sb.append("'");
		}
  			sb.append(" AND NUMBER_CODE = '").append(criteria.get(NUMBER_CODE))
  			.append("' AND TO_CHAR(RECORD_DATE, 'yyyy/MM/dd') = '").append(criteria.get(RECORD_DATE)).append("'");
		List<Map<String, Object>> mapList = getMapList(sb.toString(), criteria);
		if (ObjectUtil.isNullOrEmpty(mapList)) {
			return null;
		}
		IntegrationMonitor im = get(mapList.get(0), IntegrationMonitor.class);
		return im;
	}

	@Override
	public Map<String, Object> getIntegrationMonitorNum(Criteria criteria) {

		StringBuilder sb = new StringBuilder("SELECT sum(nvl(FRONT_UPLOAD_COUNT,0))FRONT_UPLOAD_COUNT,sum(nvl(FACT_UPLOAD_COUNT,0))FACT_UPLOAD_COUNT, \n" +
				"sum(nvl(FACT_ADD_COUNT,0))FACT_ADD_COUNT, sum(nvl(FACT_UPDATE_COUNT,0))FACT_UPDATE_COUNT, sum(nvl(FACT_FAIL_COUNT,0)) FACT_FAIL_COUNT \n" +
				"FROM FS_INTEGRATION_MONITOR ");

		SqlBuilder.buildWhereStatement(IntegrationMonitor.class, sb, criteria) ;
		Map<String, Object> map = this.getMap(sb.toString(), criteria);
		return map;
	}
}
