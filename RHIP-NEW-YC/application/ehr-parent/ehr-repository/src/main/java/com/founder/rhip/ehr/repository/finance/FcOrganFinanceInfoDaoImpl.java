package com.founder.rhip.ehr.repository.finance;
import com.founder.rhip.ehr.entity.finance.FcOrganFinanceInfo;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of FcOrganFinanceInfo
 * 
 */
@Repository("fcOrganFinanceInfoDao")
public class FcOrganFinanceInfoDaoImpl extends AbstractDao<FcOrganFinanceInfo, Long> implements IFcOrganFinanceInfoDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}