package com.founder.rhip.ehr.repository.child;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.child.FrailChildFollowup;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of FrailChildFollowup
 * 
 */
@Repository("frailChildFollowupDao")
public class FrailChildFollowupDaoImpl extends AbstractDao<FrailChildFollowup, String> implements IFrailChildFollowupDao {
	@Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}