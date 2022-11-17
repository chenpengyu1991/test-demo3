package com.founder.rhip.ehr.repository.basic;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.basic.Bulletin;

@Repository("bulletinDao")
public class BulletinDaoImpl extends
		AbstractDao<Bulletin, Long> implements IBulletinDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}