package com.founder.rhip.ehr.repository.child;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.child.ChEtbjXsefs;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of ChEtbjXsefs
 * 
 */
@Repository("chEtbjXsefsDao")
public class ChEtbjXsefsDaoImpl extends AbstractDao<ChEtbjXsefs, Long> implements IChEtbjXsefsDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}