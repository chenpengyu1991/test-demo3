package com.founder.rhip.im.repository.medical;

import com.founder.rhip.im.entity.medical.RdIncome;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of RdIncome
 * 
 */
@Repository("rdIncomeDao")
public class RdIncomeDaoImpl extends AbstractDao<RdIncome, Long> implements IRdIncomeDao {
    @Resource(name = "phbdbJDBCTemplate")
    protected SimpleJdbcTemplate simpleJdbcTemplate;
}