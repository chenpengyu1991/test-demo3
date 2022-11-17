package com.founder.rhip.ehr.repository.child;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.child.ChEtbjJkjcone;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of ChEtbjJkjcone
 * 
 */
@Repository("chEtbjJkjconeDao")
public class ChEtbjJkjconeDaoImpl extends AbstractDao<ChEtbjJkjcone, Long> implements IChEtbjJkjconeDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}