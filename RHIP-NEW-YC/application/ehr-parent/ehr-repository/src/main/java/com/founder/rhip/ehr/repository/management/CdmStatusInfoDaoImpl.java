package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.management.CdmStatusInfo;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of CdmStatusInfo
 * 
 */
@Repository("cdmStatusInfoDao")
public class CdmStatusInfoDaoImpl extends AbstractDao<CdmStatusInfo, Integer> implements ICdmStatusInfoDao {
	@Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

}