package com.founder.rhip.ehr.repository.hsa;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.hsa.FamilyInfo;

/**
 * @author liuk
 * 
 */
@Repository("hsaFamilyInfoDao")
public class FamilyInfoDaoImpl extends AbstractDao<FamilyInfo, Long> implements IFamilyInfoDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
}