package com.founder.rhip.ehr.repository.ihm;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.message.ReceivedInfo;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 */
@Repository("messageReceivedDao")
public class MessageReceivedDaoImpl extends AbstractDao<ReceivedInfo, Long> implements IMessageReceivedDao {

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

}