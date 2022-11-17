package com.founder.rhip.ehr.repository.summary;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.summary.DeformityHistory;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of DhsDeformityHistory
 * 
 */
@Repository("deformityHistoryDao")
public class DeformityHistoryDaoImpl extends AbstractDao<DeformityHistory, Long> implements IDeformityHistoryDao {

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}