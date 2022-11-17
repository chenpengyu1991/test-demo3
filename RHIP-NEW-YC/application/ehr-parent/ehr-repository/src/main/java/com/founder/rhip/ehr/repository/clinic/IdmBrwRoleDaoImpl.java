package com.founder.rhip.ehr.repository.clinic;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.clinic.IdmBrwRole;

/**
 * DAO implement of IIdmBrwRoleDao
 *
 */
@Repository("idmBrwRoleDao")
public class IdmBrwRoleDaoImpl extends AbstractDao<IdmBrwRole, Long> implements IIdmBrwRoleDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

}