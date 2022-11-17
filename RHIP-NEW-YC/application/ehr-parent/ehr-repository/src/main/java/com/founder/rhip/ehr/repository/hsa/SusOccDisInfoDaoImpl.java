package com.founder.rhip.ehr.repository.hsa;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.hsa.SusOccDisInfo;

/**
 * @author liuk DAO implement of SusOccDisInfo
 * 
 */
@Repository("hsaSusOccDisInfoDao")
public class SusOccDisInfoDaoImpl extends AbstractDao<SusOccDisInfo, Long> implements ISusOccDisInfoDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
}