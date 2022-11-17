package com.founder.rhip.ehr.repository.control.idm.notifiabledisease;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.ListHc;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of IdmListHc
 * 
 */
@Repository("listHcDao")
public class ListHcDaoImpl extends AbstractDao<ListHc, Integer> implements IListHcDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}