package com.founder.rhip.portal.repository;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.portal.AccountInfo;
import com.founder.rhip.ehr.repository.portal.IAccountInfoDao;

/**
 * DAO implement of AccountInfo
 * 
 */
@Repository("lhaccountInfoDao")
public class AccountInfoDaoImpl extends AbstractDao<AccountInfo, Long> implements IAccountInfoDao {

	@Resource(name = "portaldbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
	
}