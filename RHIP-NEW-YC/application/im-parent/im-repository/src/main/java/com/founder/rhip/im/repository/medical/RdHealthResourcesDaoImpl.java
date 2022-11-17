package com.founder.rhip.im.repository.medical;

import com.founder.rhip.im.entity.medical.RdHealthResources;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of RdHealthResources
 * 
 */
@Repository("rdHealthResourcesDao")
public class RdHealthResourcesDaoImpl extends AbstractDao<RdHealthResources, Long> implements IRdHealthResourcesDao {
    @Resource(name = "phbdbJDBCTemplate")
    protected SimpleJdbcTemplate simpleJdbcTemplate;
}