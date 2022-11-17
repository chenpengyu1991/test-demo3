package com.founder.rhip.ehr.repository.ech;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.ech.EchIdentification;

/**
 * DAO implement of EchIdentification
 * 
 */
@Repository("echIdentificationDao")
public class EchIdentificationDaoImpl extends AbstractDao<EchIdentification, Long> implements IEchIdentificationDao {
	 @Resource(name = "phbdbJDBCTemplate")
	 private SimpleJdbcTemplate simpleJdbcTemplate;
}