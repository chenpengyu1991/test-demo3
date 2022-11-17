package com.founder.rhip.ehr.repository.ihm;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.child.ChildDeathRecord;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("childDeathRecordDao")
public class ChildDeathRecordDaoImpl extends AbstractDao<ChildDeathRecord, Long> implements IChildDeathRecordDao{
	
	@Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
	
	/**
     * 儿童死亡率，修改
     */
	@Override
    public List<ChildDeathRecord> getChildDeathMortality(String criteria , String gbCode){
    	
    	StringBuilder sql = new StringBuilder("SELECT (SUM(FIVE_DEATH)/SUM(SEVEN_NUMBER))*1000 AS underFiveMortality,");
    	sql.append(" (SUM(BABY_DEATH)/SUM(SEVEN_NUMBER))*1000 AS babyMortality,");
    	sql.append(" (SUM(NEWBORN_DEATH)/SUM(SEVEN_NUMBER))*1000 AS newbornMortality, GBCODE as gbCode");
    	sql.append(" FROM CH_CHILD_DEATH_RECORD");
    	
    	sql.append(" WHERE MONTH_RECORD in "+criteria);
    	sql.append(" GROUP BY GBCODE");
    	
    	if(!gbCode.equals("")){
    		sql.append(" HAVING GBCODE = "+gbCode);
    	}
    	List<ChildDeathRecord> list = this.getList(sql.toString());
    	return list;
    }

}
