package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.management.TumorFollowup;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of TumorFollowup
 * 
 */
@Repository("tumorFollowupDao")
public class TumorFollowupDaoImpl extends AbstractDao<TumorFollowup, String> implements ITumorFollowupDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}