package com.founder.rhip.portal.repository;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.portal.PortalSet;
import com.founder.rhip.ehr.repository.portal.IPortalSetDao;

/**
 * DAO implement of PortalSet
 * 
 */
@Repository("lhportalSetDao")
public class PortalSetDaoImpl extends AbstractDao<PortalSet, Long> implements IPortalSetDao {
	@Resource(name = "portaldbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}