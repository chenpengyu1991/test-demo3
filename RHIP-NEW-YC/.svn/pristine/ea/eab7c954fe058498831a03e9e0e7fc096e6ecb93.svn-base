package com.founder.rhip.ehr.repository.clinic;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.clinic.SickbedUseState;

/**
 * DAO implement of sickbedUseState
 * 
 */
@Repository("sickbedUseStateDao")
public class SickbedUseStateDaoImpl extends AbstractDao<SickbedUseState, Long> implements ISickbedUseStateDao {
	 @Resource(name = "msdbJDBCTemplate")
	 private SimpleJdbcTemplate simpleJdbcTemplate;
	 
	 private static final String FORMATER = "yyyy/mm/dd";
	 
	 /**
     * 统计住院人数（按照现在的床位数）
     * @param dateStr 日期格式必须是yyyy/mm/dd
     * @return
     */
    @Override
    public List<Map<String, Object>> getBedStatistics(String dateStr) {
    	
    	String whereSql = " where to_char(gather_date,'%1$s') ='%2$s'";
    	String sql = "select hospital_code,to_char(tt.create_date,'%1$s') create_date, count(*)bed_num from ms_sickbed_use_state tt %2$s"
    				+ " group by tt.hospital_code, to_char(tt.create_date,'%1$s') order by tt.hospital_code, to_char(tt.create_date,'%1$s')";
    	whereSql = String.format(whereSql, FORMATER, dateStr);
		sql=String.format(sql, FORMATER ,whereSql);
		return this.getMapList(sql, new Criteria());		
    }
}