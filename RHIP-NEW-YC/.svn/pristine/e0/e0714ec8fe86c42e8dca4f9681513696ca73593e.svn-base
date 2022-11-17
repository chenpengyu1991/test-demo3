package com.founder.rhip.ehr.repository.cic;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.repository.cic.ICicTargetDao;
import com.founder.rhip.ehr.entity.cic.CicTarget;
/**
 * DAO implement of CicTarget
 * 
 */
@Repository("cicTargetDao")
public class CicTargetDaoImpl extends AbstractDao<CicTarget, Long> implements ICicTargetDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}