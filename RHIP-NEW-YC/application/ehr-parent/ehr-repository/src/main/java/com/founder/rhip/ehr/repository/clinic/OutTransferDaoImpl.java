package com.founder.rhip.ehr.repository.clinic;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.clinic.OutTransfer;

/**
 * DAO implement of ReferralInfo
 * 
 */
@Repository("outTransferDao")
public class OutTransferDaoImpl extends AbstractDao<OutTransfer, Long> implements IOutTransferDao{
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}