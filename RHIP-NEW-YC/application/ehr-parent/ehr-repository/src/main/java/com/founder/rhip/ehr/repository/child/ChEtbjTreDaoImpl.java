package com.founder.rhip.ehr.repository.child;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.child.ChEtbjTre;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of ChEtbjTre
 * 
 */
@Repository("chEtbjTreDao")
public class ChEtbjTreDaoImpl extends AbstractDao<ChEtbjTre, Long> implements IChEtbjTreDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}