package com.founder.rhip.im.repository.medical;

import com.founder.rhip.im.entity.medical.RdInpatientCompositive;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of RdInpatientCompositive
 * 
 */
@Repository("rdInpatientCompositiveDao")
public class RdInpatientCompositiveDaoImpl extends AbstractDao<RdInpatientCompositive, Long> implements IRdInpatientCompositiveDao {
    @Resource(name = "phbdbJDBCTemplate")
    protected SimpleJdbcTemplate simpleJdbcTemplate;
}