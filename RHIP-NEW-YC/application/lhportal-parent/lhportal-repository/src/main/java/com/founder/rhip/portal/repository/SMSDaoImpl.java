package com.founder.rhip.portal.repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.portal.SMS;
import com.founder.rhip.ehr.repository.portal.ISMSDao;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of Interaction
 * 
 */
@Repository("lhsmsDao")
public class SMSDaoImpl extends AbstractDao<SMS, Long> implements ISMSDao {
	@Resource(name = "portaldbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

}