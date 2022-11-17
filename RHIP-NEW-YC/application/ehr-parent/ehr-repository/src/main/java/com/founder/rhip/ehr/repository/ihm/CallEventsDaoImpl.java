package com.founder.rhip.ehr.repository.ihm;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.jj.JjTalarmevent;
import com.founder.rhip.ehr.entity.jj.JjTtask;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 */
@Repository("callEventsDao")
public class CallEventsDaoImpl extends AbstractDao<JjTalarmevent, Long> implements ICallEventsDao {

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

}