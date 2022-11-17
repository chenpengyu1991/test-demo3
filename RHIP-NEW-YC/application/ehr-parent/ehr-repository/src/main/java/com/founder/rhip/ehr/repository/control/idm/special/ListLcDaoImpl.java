package com.founder.rhip.ehr.repository.control.idm.special;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.control.idm.special.ListLc;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of IdmListLc
 * 
 */
@Repository("idmListLcDao")
public class ListLcDaoImpl extends AbstractDao<ListLc, Long> implements IListLcDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}