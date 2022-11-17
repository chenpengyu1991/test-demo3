package com.founder.rhip.ehr.repository.control.idm.special;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.control.idm.special.ListDd;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of IdmListDd
 * 
 */
@Repository("idmListDdDao")
public class ListDdDaoImpl extends AbstractDao<ListDd, Long> implements IListDdDao {
	 @Resource(name = "phbdbJDBCTemplate")
	    private SimpleJdbcTemplate simpleJdbcTemplate;
	}