package com.founder.rhip.ehr.repository.clinic;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.clinic.TransBloodInfo;

@Repository("transBloodInfoDao")
public class TransBloodInfoDaoImpl extends AbstractDao<TransBloodInfo, Long> implements
		ITransBloodInfoDao {
	
	@Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}
