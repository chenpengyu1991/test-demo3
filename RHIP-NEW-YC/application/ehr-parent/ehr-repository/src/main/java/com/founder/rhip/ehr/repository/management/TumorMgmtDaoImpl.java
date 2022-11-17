package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.management.TumorMgmt;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of TumorMgmt
 * 
 */
@Repository("tumorMgmtDao")
public class TumorMgmtDaoImpl extends AbstractDao<TumorMgmt, String> implements ITumorMgmtDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}