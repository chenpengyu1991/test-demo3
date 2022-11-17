package com.founder.rhip.ehr.repository.summary;
import java.util.List;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.summary.HospitalizedHistory;
import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of HospitalizedHistory
 * 
 */
@Repository("hospitalizedHistoryDao")
public class HospitalizedHistoryDaoImpl extends AbstractDao<HospitalizedHistory, String> implements IHospitalizedHistoryDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
	@Override
	public List<HospitalizedHistory> getDistinctList(Criteria criteria, Order order) {
		ClassMetadata cMetadata = ClassMetadata.getMetadata(HospitalizedHistory.class);
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT DISTINCT IN_DATE,OUTHOS_DATE,HOS_NAME,INPUT_ORGAN_NAME FROM DHS_HOSPITALIZED_HISTORY");
		sql.append(" WHERE ").append(criteria.toSql(cMetadata, ":"));
		sql.append(order.toString());
		return this.getList(sql.toString(), criteria);
	}
}