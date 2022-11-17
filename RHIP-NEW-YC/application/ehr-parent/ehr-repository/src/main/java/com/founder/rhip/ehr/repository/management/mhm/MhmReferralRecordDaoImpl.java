package com.founder.rhip.ehr.repository.management.mhm;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.management.mhm.MhmReferralRecord;
import com.founder.rhip.ehr.repository.management.mhm.IMhmReferralRecordDao;

/**
 * DAO implement of MhmReferralRecord
 * 
 */
@Repository("mhmReferralRecordDao")
public class MhmReferralRecordDaoImpl extends AbstractDao<MhmReferralRecord, Long> implements IMhmReferralRecordDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}