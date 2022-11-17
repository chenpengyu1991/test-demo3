package com.founder.rhip.portal.repository;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.portal.InfromBook;
import com.founder.rhip.ehr.repository.portal.IInfromBookDao;

/**
 * DAO implement of AccountInfo
 * 
 */
@Repository("lhinfromBookDao")
public class InfromBookDaoImpl extends AbstractDao<InfromBook, Long> implements IInfromBookDao {
	@Resource(name = "portaldbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}