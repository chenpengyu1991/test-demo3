package com.founder.rhip.ehr.repository.basic;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.ModifyTrace;

@Repository("modifyTraceDao")
public class ModifyTraceDaoImpl extends AbstractDao<ModifyTrace, Long> implements IModifyTraceDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    private static final String FORMATER = "yyyy/mm/dd";
    
    @Override
	public List<Map<String, Object>> getModifyTraceStatistics(String dateStr) {
		if (ObjectUtil.isNullOrEmpty(dateStr)) {
			throw new IllegalArgumentException("日期不可以为空！");
		}
    	String whereSql = " where to_char(m.input_date,'%1$s')='%2$s'";
    	StringBuilder sqlBuilder = new StringBuilder("select m.input_org_code,count(*) modify_num "
    			+ " from modify_trace m %1$s"
    			+ " group by m.input_org_code");
			
		whereSql = String.format(whereSql, FORMATER, dateStr);
		String sql=String.format(sqlBuilder.toString(), whereSql, FORMATER);
		return this.getMapList(sql, new Criteria());
	}
}
