package com.founder.rhip.portal.repository;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.portal.InfoType;
import com.founder.rhip.ehr.repository.portal.IInfoTypeDao;

/**
 * DAO implement of InfoType
 * 
 */
@Repository("lhinfoTypeDao")
public class InfoTypeDaoImpl extends AbstractDao<InfoType, Long> implements IInfoTypeDao {
	@Resource(name = "portaldbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}