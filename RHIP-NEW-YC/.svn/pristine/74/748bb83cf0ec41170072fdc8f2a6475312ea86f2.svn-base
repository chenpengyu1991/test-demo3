package com.founder.rhip.ehr.repository.basic;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.basic.FingerInfo;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by f on 2018/5/8.
 */
@Repository("fingerInfoDao")
public class FingerInfoDaoImpl extends AbstractDao<FingerInfo, Long> implements IFingerInfoDao {
    Logger log = Logger.getLogger(getClass());

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}
