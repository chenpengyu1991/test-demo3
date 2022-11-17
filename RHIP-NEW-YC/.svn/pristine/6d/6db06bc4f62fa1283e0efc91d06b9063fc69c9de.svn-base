package com.founder.rhip.ehr.repository.management.mhm;

import java.util.Date;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.entity.management.mhm.MhmSeverity;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of MhmManageType
 * 
 */
@Repository("mhmSeverityDao")
public class MhmSeverityDaoImpl extends AbstractDao<MhmSeverity, Long> implements IMhmSeverityDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    public MhmSeverity findMhmSeverity(String eventId){
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT * FROM MHM_SEVERITY T1 ");
        sql.append(" WHERE VERSION = ");
        sql.append(" (SELECT MAX(VERSION) FROM MHM_SEVERITY T2 WHERE T1.EVENT_ID = T2.EVENT_ID) " );
        sql.append(" AND T1.EVENT_ID = " + eventId);
        return get(sql.toString(), null);
    }
    
    /**
     * 根据随访日期查找，对应该时间的历史记录
     * 小于等于随访日期
     * @param eventId
     * @param startDt
     * @return
     * @author Ye jianfei
     */
    public MhmSeverity getMhmSeverity(Long eventId,Date startDt){
    	Criteria criteria = new Criteria("EVENT_ID",eventId);
		DateUtil.getCriteriaByDateRange(criteria, "START_DT", null,startDt);
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT   b.* FROM MHM_SEVERITY b, ( ");
        sql.append(" SELECT event_id, max(start_dt)  dt");
        sql.append(" FROM MHM_SEVERITY" );
        SqlBuilder.buildWhereStatement(MhmSeverity.class, sql, criteria) ;
        sql.append("  GROUP BY event_id) A");
        sql.append(" where b.event_id = a.event_id and b.start_dt = a.dt ");
        return get(sql.toString(), criteria);    	
    }
    /**
     * 查找第一次记录时间
     * @param eventId
     * @return
     * @author Ye jianfei
     */
    public MhmSeverity getFirstMhmSeverity(Long eventId){
    	Criteria criteria = new Criteria("EVENT_ID",eventId);
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT   b.* FROM MHM_SEVERITY b, ( ");
        sql.append(" SELECT event_id, min(start_dt)  dt");
        sql.append(" FROM MHM_SEVERITY" );
        SqlBuilder.buildWhereStatement(MhmSeverity.class, sql, criteria) ;
        sql.append("  GROUP BY event_id) A");
        sql.append(" where b.event_id = a.event_id and b.start_dt = a.dt ");
        return get(sql.toString(), criteria);    	
    }    
}