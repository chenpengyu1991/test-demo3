package com.founder.rhip.ehr.repository.healtheducation;
import com.founder.rhip.ehr.entity.healtheducation.HeActivityNotice;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of HeActivityNotice
 * 
 */
@Repository("heActivityNoticeDao")
public class HeActivityNoticeDaoImpl extends AbstractDao<HeActivityNotice, Integer> implements IHeActivityNoticeDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}