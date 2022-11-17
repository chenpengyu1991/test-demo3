package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.management.CdmApprovalInfo;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of CdmApprovalInfo
 * 
 */
@Repository("cdmApprovalInfoDao")
public class CdmApprovalInfoDaoImpl extends AbstractDao<CdmApprovalInfo, Integer> implements ICdmApprovalInfoDao {
    @SuppressWarnings("unused")
	@Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}