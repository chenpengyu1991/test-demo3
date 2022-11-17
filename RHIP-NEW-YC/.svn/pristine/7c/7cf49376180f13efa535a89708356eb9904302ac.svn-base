package com.founder.rhip.ehr.repository.clinic;
import java.math.BigDecimal;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.clinic.ReadHealthRecord;

/**
 * DAO implement of InpatientDrugUsage
 * 
 */
@Repository("readHealthRecordDao")
public class ReadHealthRecordDaoImpl extends AbstractDao<ReadHealthRecord, Long> implements IReadHealthRecordDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    /**
     * 获取满足条件的行数
     * @param criteria
     * @return
     */
    @Override
    public int countRow(Criteria criteria) {
    	StringBuilder sql = new StringBuilder();
    	sql.append("select count(id) allRow from MS_READ_HEALTH_RECORD t");
    	SqlBuilder.buildWhereStatement(ReadHealthRecord.class, sql, criteria);
    	
    	Map<String, Object> map = this.getMap(sql.toString(), criteria);
		return map != null ? ((BigDecimal)map.get("allRow")).intValue(): 0;
    }
    
}