package com.founder.rhip.ehr.repository.women;


import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.women.HighriskMaternalReg;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of HighriskMaternalReg
 * 
 */
@Repository("highriskMaternalRegDao")
public class HighriskMaternalRegDaoImpl extends AbstractDao<HighriskMaternalReg, Long> implements IHighriskMaternalRegDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}