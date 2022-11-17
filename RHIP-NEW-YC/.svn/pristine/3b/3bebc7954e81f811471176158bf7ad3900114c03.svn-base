package com.founder.rhip.mdm.repository;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.mdm.entity.ExplorerSet;

@Repository("explorerSetDao")
public class ExplorerSetDaoImpl extends AbstractDao<ExplorerSet, Long>
		implements IExplorerSetDao {
	
    @Resource(name = "phbdbJDBCTemplate")
    protected SimpleJdbcTemplate simpleJdbcTemplate;

}
