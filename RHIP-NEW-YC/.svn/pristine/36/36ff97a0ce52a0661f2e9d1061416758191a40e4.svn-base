package com.founder.rhip.ehr.repository.basic;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.basic.FingerVerifyRecord;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by f on 2018/5/8.
 */
@Repository("fingerVerifyRecordDao")
public class FingerVerifyRecordDaoImpl extends AbstractDao<FingerVerifyRecord, Long> implements IFingerVerifyRecordDao {
    Logger log = Logger.getLogger(getClass());

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}
