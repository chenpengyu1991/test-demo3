package com.founder.rhip.ehr.repository.control.idm.special;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.control.idm.special.ListCm;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of IdmListCm
 * 
 */
@Repository("idmListCmDao")
public class ListCmDaoImpl extends AbstractDao<ListCm, Long> implements IListCmDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}