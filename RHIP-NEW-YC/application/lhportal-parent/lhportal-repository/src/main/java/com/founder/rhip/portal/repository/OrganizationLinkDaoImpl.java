package com.founder.rhip.portal.repository;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.portal.OrganizationLink;
import com.founder.rhip.ehr.repository.portal.IOrganizationLinkDao;

/**
 * DAO implement of OrganizationLink
 * 
 */
@Repository("lhorganizationLinkDao")
public class OrganizationLinkDaoImpl extends AbstractDao<OrganizationLink, Long> implements IOrganizationLinkDao {
	@Resource(name = "portaldbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}