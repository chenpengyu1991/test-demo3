package com.founder.rhip.ehr.repository.management.mhm;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.management.mhm.MhmEconomy;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of MhmManageType
 * 
 */
@Repository("mhmEconomyDao")
public class MhmEconomyDaoImpl extends AbstractDao<MhmEconomy, Long> implements IMhmEconomyDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    public MhmEconomy findMhmEconomy(String eventId){
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT * FROM MHM_ECONOMY T1 ");
        sql.append(" WHERE VERSION = ");
        sql.append(" (SELECT MAX(VERSION) FROM MHM_ECONOMY T2 WHERE T1.EVENT_ID = T2.EVENT_ID) " );
        sql.append(" AND T1.EVENT_ID = " + eventId);
        return get(sql.toString(), null);
    }

}