package com.founder.rhip.ehr.repository.management.mhm;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.management.mhm.MhmApprovalInfo;
import com.founder.rhip.ehr.repository.management.mhm.IMhmApprovalInfoDao;

/**
 * DAO implement of MhmApprovalInfo
 * 
 */
@Repository("mhmApprovalInfoDao")
public class MhmApprovalInfoDaoImpl extends AbstractDao<MhmApprovalInfo, Long> implements IMhmApprovalInfoDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}