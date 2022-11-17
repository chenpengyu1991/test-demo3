package com.founder.rhip.ehr.repository.finance;
import com.founder.rhip.ehr.entity.finance.FcPubBaseData;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of FcPubBaseData
 * 
 */
@Repository("fcPubBaseDataDao")
public class FcPubBaseDataDaoImpl extends AbstractDao<FcPubBaseData, Long> implements IFcPubBaseDataDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}