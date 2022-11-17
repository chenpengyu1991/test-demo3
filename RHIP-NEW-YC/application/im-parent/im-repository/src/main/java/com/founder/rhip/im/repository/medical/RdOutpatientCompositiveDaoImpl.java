package com.founder.rhip.im.repository.medical;

import com.founder.rhip.im.entity.medical.RdOutpatientCompositive;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of RdOutpatientCompositive
 * 
 */
@Repository("rdOutpatientCompositiveDao")
public class RdOutpatientCompositiveDaoImpl extends AbstractDao<RdOutpatientCompositive, Long> implements IRdOutpatientCompositiveDao {
    @Resource(name = "phbdbJDBCTemplate")
    protected SimpleJdbcTemplate simpleJdbcTemplate;
}