package com.founder.rhip.ehr.repository.women;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.Assert;
import com.founder.rhip.ehr.entity.women.PremaritalHealthService;

/**
 * DAO implement of PremaritalHealthService
 * 
 */
@Repository("premaritalHealthServiceDao")
public class PremaritalHealthServiceDaoImpl extends AbstractDao<PremaritalHealthService, String> implements IPremaritalHealthServiceDao {
	@Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
	
	private static final String PREMARITAL_HEALTH_SERVICE_STATISTICS_SQL = "select %3$s"
			+ " sum(decode(mod(to_number(substr(id_card,decode(length(id_card),15,15,18,17),1)),2),0,1,0)) gestational_women_num "
			+ " from wh_premarital_health_service %1$s and to_char(fill_date, 'yyyy') - to_char(birthday, 'yyyy') + "
			+ " decode(sign(to_char(fill_date, 'mmdd') - to_char(birthday, 'mmdd')),-1,-1,0,0,1,0) between 15 and 49"
			+ " group by %2$s";
	
	private static final String FEMALE_AND_MALE_PREMARITA_STATISTICS_SQL = "select %3$s"
			+ " sum(decode(mod(to_number(substr(id_card,decode(length(id_card), 15, 15, 18, 17),1)),2),1,1,0)) female_premarital_num,"
			+ " sum(decode(mod(to_number(substr(id_card,decode(length(id_card), 15, 15, 18, 17),1)),2),0,1,0)) male_premarital_num, "
			+ " sum(decode(mod(to_number(substr(id_card,decode(length(id_card), 15, 15, 18, 17),1)),2),1,1,0))+"
			+ " sum(decode(mod(to_number(substr(id_card,decode(length(id_card), 15, 15, 18, 17),1)),2),0,1,0))premarital_num "
			+ " from wh_premarital_health_service %1$s group by %2$s";

	
	@Override
	public List<Map<String, Object>> getPremaritalHealthServiceMapList(
			String dateStr) {
		Assert.notNull(dateStr);
		String columnNames = "create_organ_code,to_char(check_date, 'yyyy/MM/dd')";
		StringBuilder conditionSqlBuilder = new StringBuilder(" where to_char(gather_date, 'yyyy/MM/dd')='").append(dateStr).append("'");
		String sql = String.format(PREMARITAL_HEALTH_SERVICE_STATISTICS_SQL, conditionSqlBuilder.toString(),columnNames,columnNames+"rpDate,");
		
		return getMapList(sql, new Criteria());
	}

	@Override
	public List<Map<String, Object>> getFemaleAndMalePremaritalMapList(
			String dateStr) {
		Assert.notNull(dateStr);
		String columnNames = "create_organ_code,to_char(check_date, 'yyyy/MM/dd')";
		StringBuilder conditionSqlBuilder = new StringBuilder(" where to_char(gather_date, 'yyyy/MM/dd')='").append(dateStr).append("'");
		String sql = String.format(FEMALE_AND_MALE_PREMARITA_STATISTICS_SQL, conditionSqlBuilder.toString(),columnNames,columnNames+"rpDate,");
		return getMapList(sql, new Criteria());
	}

	@Override
	public List<Map<String, Object>> getPremaritalHealthServiceWorkloadMapList(
			String dateStr) {
		Assert.notNull(dateStr);
		String columnNames = "create_organ_code,check_idcard,check_job_number,to_char(check_date, 'yyyy/mm/dd')";
		StringBuilder conditionSqlBuilder = new StringBuilder(" where to_char(gather_date, 'yyyy/MM/dd')='").append(dateStr).append("'");
		String sql = String.format(PREMARITAL_HEALTH_SERVICE_STATISTICS_SQL, conditionSqlBuilder.toString(),columnNames,columnNames+"rpDate,max(check_name)doctorName,");
		return getMapList(sql, new Criteria());
	}

	@Override
	public List<Map<String, Object>> getFemaleAndMalePremaritalWorkloadMapList(
			String dateStr) {
		Assert.notNull(dateStr);
		String columnNames = "create_organ_code,check_idcard,check_job_number,to_char(check_date, 'yyyy/mm/dd')";
		StringBuilder conditionSqlBuilder = new StringBuilder(" where to_char(gather_date, 'yyyy/MM/dd')='").append(dateStr).append("'");
		String sql = String.format(FEMALE_AND_MALE_PREMARITA_STATISTICS_SQL, conditionSqlBuilder.toString(),columnNames,columnNames+"rpDate,max(check_name)doctorName,");
		return getMapList(sql, new Criteria());
	}
}