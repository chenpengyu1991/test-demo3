package com.founder.rhip.ehr.repository.control;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.Assert;
import com.founder.rhip.ehr.entity.control.VaccinationInfo;

/**
 * DAO implement of VaccinationInfo
 * 
 */
@Repository("vaccinationInfoDao")
public class VaccinationInfoDaoImpl extends AbstractDao<VaccinationInfo, String> implements IVaccinationInfoDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    private static final String VACCINATION_PA_STATISTICS_SQL = "select vaccination_unit_code,vaccination_doctor_idcard,"
    		+ " vaccination_doctor_code,max(vaccination_doctor_name)doctor_name,to_char(vaccination_date,'yyyy/MM/dd')rpDate,count(1)vaccination_num "
    		+ " from dc_vaccination_info %1$s group by vaccination_unit_code,vaccination_doctor_idcard,vaccination_doctor_code,to_char(vaccination_date,'yyyy/MM/dd')";
    
    private static final String VACCINATION_ORGANIZATION_STATISTICS_SQL = "select vaccination_unit_code,"
    		+ " to_char(vaccination_date,'yyyy/MM/dd')rpDate,count(1)vaccination_num "
    		+ " from dc_vaccination_info %1$s group by vaccination_unit_code,to_char(vaccination_date,'yyyy/MM/dd')";

    @Override
    public List<Map<String,Object>> getCountByOrgCode(Criteria criteria){
    	StringBuilder sql = new StringBuilder("select count(*) count, IMMU_UNIT_ID orgCode from DC_VACCINATION_INFO ");
    	SqlBuilder.buildWhereStatement(VaccinationInfo.class, sql, criteria);
    	sql.append(" GROUP BY IMMU_UNIT_ID ");
    	List<Map<String,Object>> mapList = this.getMapList(sql.toString(), criteria);
    	return mapList;
    }

    /**
     * 预防接种总人数
     * @param criteria
     * @return
     */
    public int vaccinationNum(Criteria criteria){
        StringBuilder sql = new StringBuilder("select count(1)  as total \n" +
                "  from (select person_id from DC_VACCINATION_INFO group by person_id)\n");
        Map<String, Object> result =  this.getMap(sql.toString(), criteria);
        return ((BigDecimal)result.get("total")).intValue();
    }

    /**
     * 本年接种人数
     * @param criteria
     * @return
     */
    public int vaccinationNumByYear(Criteria criteria){
        String year = (String) criteria.get("year");
        StringBuilder sql = new StringBuilder("select count(1) as currentYearNum\n" +
                "  from (select person_id\n" +
                "          from DC_VACCINATION_INFO t\n" +
                "         where to_char(vaccination_date, 'yyyy') = '"+year+"'\n" +
                "         group by person_id)");
        Map<String, Object> result =  this.getMap(sql.toString(), criteria);
        return ((BigDecimal)result.get("currentYearNum")).intValue();
    }

	@Override
	public List<Map<String, Object>> getVaccinationInfoMapList(String dateStr) {
		Assert.notNull(dateStr);
		StringBuilder conditionSqlBuilder = new StringBuilder(" where to_char(gather_date,'yyyy/MM/dd')='").append(dateStr).append("'");
		String sql = String.format(VACCINATION_PA_STATISTICS_SQL, conditionSqlBuilder.toString());
		return getMapList(sql, new Criteria());
	}

	@Override
	public List<Map<String, Object>> getOrganizationVaccinationMapList(
			String dateStr) {
		Assert.notNull(dateStr);
		StringBuilder conditionSqlBuilder = new StringBuilder(" where to_char(gather_date,'yyyy/MM/dd')='").append(dateStr).append("'");
		String sql = String.format(VACCINATION_ORGANIZATION_STATISTICS_SQL, conditionSqlBuilder.toString());
		return getMapList(sql, new Criteria());
	}
	
	@Override
	public List<VaccinationInfo> getDistinctList(Criteria criteria, Order order) {
		ClassMetadata cMetadata = ClassMetadata.getMetadata(VaccinationInfo.class);
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT DISTINCT VACCINATION_DATE,VACCINE_NAME,VACCINATION_UNIT_NAME FROM DC_VACCINATION_INFO");
		sql.append(" WHERE ").append(criteria.toSql(cMetadata, ":"));
		sql.append(order.toString());
		return this.getList(sql.toString(), criteria);
	}
}