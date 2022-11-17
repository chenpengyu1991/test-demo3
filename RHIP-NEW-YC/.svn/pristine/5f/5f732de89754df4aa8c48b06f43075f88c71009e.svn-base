package com.founder.rhip.ehr.repository.summary;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.clinic.EHRHealthEvent;
import com.founder.rhip.ehr.entity.summary.TraumaHistory;

/**
 * DAO implement of TraumaHistory
 * 
 */
@Repository("traumaHistoryDao")
public class TraumaHistoryDaoImpl extends AbstractDao<TraumaHistory, String> implements ITraumaHistoryDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    @Override
    public List<Map<String,Object>> getCountByOrgCode(Criteria criteria){
    	StringBuilder sql = new StringBuilder("select count(*) count,EHE.CREATE_ORGAN_CODE from DHS_TRAUMA_HISTORY DTH");
    	sql.append(" INNER JOIN V_MS_HEALTH_EVENT EHE ON DTH.EHR_ID = EHE.EHR_ID ");
    	SqlBuilder.buildWhereStatement(EHRHealthEvent.class, sql, criteria);
    	sql.append(" GROUP BY EHE.CREATE_ORGAN_CODE ");
    	
    	List<Map<String,Object>> mapList = this.getMapList(sql.toString(), criteria);
    	return mapList;
    }
    
    @Override
    public Integer getCountBy(Criteria criteria){
    	StringBuilder sql = new StringBuilder("select count(*) count from DHS_TRAUMA_HISTORY DTH");
    	sql.append(" INNER JOIN V_MS_HEALTH_EVENT EHE ON DTH.EHR_ID = EHE.EHR_ID ");
    	SqlBuilder.buildWhereStatement(EHRHealthEvent.class, sql, criteria);
    	
    	Map<String,Object> map = this.getMap(sql.toString(), criteria);
    	
    	Integer count = Integer.parseInt( map.get("count").toString() );
    	return count;
    }
    
}