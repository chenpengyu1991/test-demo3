package com.founder.rhip.ehr.repository.management.mhm;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.management.mhm.MhmEventInfo;
import com.founder.rhip.ehr.repository.management.mhm.IMhmEventInfoDao;

/**
 * DAO implement of MhmEventInfo
 * 
 */
@Repository("mhmEventInfoDao")
public class MhmEventInfoDaoImpl extends AbstractDao<MhmEventInfo, Long> implements IMhmEventInfoDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}