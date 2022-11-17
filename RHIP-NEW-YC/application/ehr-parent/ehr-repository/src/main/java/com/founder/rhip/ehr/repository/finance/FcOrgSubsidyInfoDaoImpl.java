package com.founder.rhip.ehr.repository.finance;
import com.founder.rhip.ehr.entity.finance.FcOrgSubsidyInfo;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of FcOrgSubsidyInfo
 * 
 */
@Repository("fcOrgSubsidyInfoDao")
public class FcOrgSubsidyInfoDaoImpl extends AbstractDao<FcOrgSubsidyInfo, Long> implements IFcOrgSubsidyInfoDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}