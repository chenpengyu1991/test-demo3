package com.founder.rhip.ehr.repository.control.idm.special;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.control.idm.special.ListTr;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of IdmListLc
 * 
 */
@Repository("listTrDao")
public class ListTrDaoImpl extends AbstractDao<ListTr, Long> implements IListTrDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}