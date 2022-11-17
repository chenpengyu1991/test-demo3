package com.founder.rhip.ehr.repository.management.mhm;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.management.mhm.MhmMove;
import com.founder.rhip.ehr.repository.management.mhm.IMhmMoveDao;

/**
 * DAO implement of MhmMove
 * 
 */
@Repository("mhmMoveDao")
public class MhmMoveDaoImpl extends AbstractDao<MhmMove, Long> implements IMhmMoveDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}