package com.founder.rhip.ehr.repository.management.mhm;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.management.mhm.MhmDrugRecord;
import com.founder.rhip.ehr.repository.management.mhm.IMhmDrugRecordDao;

/**
 * DAO implement of MhmDrugRecord
 * 
 */
@Repository("mhmDrugRecordDao")
public class MhmDrugRecordDaoImpl extends AbstractDao<MhmDrugRecord, Long> implements IMhmDrugRecordDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}