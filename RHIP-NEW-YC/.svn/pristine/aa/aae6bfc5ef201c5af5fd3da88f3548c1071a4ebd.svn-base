package com.founder.rhip.ehr.repository.basic;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.basic.UserOperationLog;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Andy
 * Date: 13-6-5
 * Time: 下午4:00
 */
@Repository("userOperationLogDao")
public class UserOperationLogDaoImpl extends AbstractDao<UserOperationLog, Long> implements IUserOperationLogDao {

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}
