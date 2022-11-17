package com.founder.rhip.portal.repository;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.portal.OutReginfo;
import com.founder.rhip.ehr.repository.portal.IOutReginfoDao;

/**
 * DAO implement of InfoType
 * 
 */
@Repository("outReginfoDao")
public class OutReginfoDaoImpl extends AbstractDao<OutReginfo, Long> implements IOutReginfoDao {
	@Resource(name = "portaldbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}