package com.founder.rhip.ehr.repository.control.idm.special;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.control.idm.special.ListAs;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of IdmListAs
 * 
 */
@Repository("idmListAsDao")
public class ListAsDaoImpl extends AbstractDao<ListAs, Long> implements IListAsDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}