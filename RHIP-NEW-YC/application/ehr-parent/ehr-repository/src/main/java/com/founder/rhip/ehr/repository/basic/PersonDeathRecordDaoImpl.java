package com.founder.rhip.ehr.repository.basic;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.PersonDeathRecord;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
/**
 * 死亡记录
 *@author liuk
 * @since 2014年5月5日 14:22:31
 */

@Repository("personDeathRecordDao")
public class PersonDeathRecordDaoImpl extends AbstractDao<PersonDeathRecord, Long> implements IPersonDeathRecordDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    private static final String FORMATER = "yyyy/mm/dd";
    
    @Override
	public List<Map<String, Object>> getCureResultHosOperationStatistics(String dateStr) {
		if (ObjectUtil.isNullOrEmpty(dateStr)) {
			throw new IllegalArgumentException("日期不可以为空！");
		}
    	String whereSql = " where to_char(input_date,'%1$s') ='%2$s'";
    	StringBuilder sqlBuilder = new StringBuilder("select p.input_organcode,to_char(p.death_date,'yyyy/mm/dd')death_date,count(*)death_count "
    			+ "from person_death_record p "
    			+ "%1$s and p.death_icd='Y69'"
    			+ "group by p.input_organcode,to_char(p.death_date,'%2$s')");
			
		whereSql = String.format(whereSql, FORMATER, dateStr);
		String sql=String.format(sqlBuilder.toString(), whereSql, FORMATER);
		return this.getMapList(sql, new Criteria());
	}
    
}