package com.founder.rhip.ehr.repository.control;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.control.ChildrenTaboo;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("childrenTabooDao")
public class ChildrenTabooDaoImpl extends AbstractDao<ChildrenTaboo, Long> implements
		IChildrenTabooDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}
