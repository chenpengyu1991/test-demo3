package com.founder.rhip.ehr.repository.child;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.child.ChEtbjJkjcthr;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of ChEtbjJkjcthr
 * 
 */
@Repository("chEtbjJkjcthrDao")
public class ChEtbjJkjcthrDaoImpl extends AbstractDao<ChEtbjJkjcthr, Long> implements IChEtbjJkjcthrDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}