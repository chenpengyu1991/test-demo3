package com.founder.rhip.ehr.repository.ism;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.ism.ApprovalInfo;

/**
 * DAO implement of CdmApprovalInfo
 * 
 */
@Repository("isApprovalInfoDao")
public class ApprovalInfoDaoImpl extends AbstractDao<ApprovalInfo, Integer> implements IApprovalInfoDao {
	@SuppressWarnings("unused")
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
}