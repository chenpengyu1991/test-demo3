package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.management.DeformityPersonFollowup;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of DeformityPersonFollowup
 * 
 */
@Repository("deformityPersonFollowupDao")
public class DeformityPersonFollowupDaoImpl extends AbstractDao<DeformityPersonFollowup, String> implements IDeformityPersonFollowupDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}