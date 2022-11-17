package com.founder.rhip.ehr.repository.child;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.child.ChEtbjTresf;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of ChEtbjTresf
 * 
 */
@Repository("chEtbjTresfDao")
public class ChEtbjTresfDaoImpl extends AbstractDao<ChEtbjTresf, Long> implements IChEtbjTresfDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}