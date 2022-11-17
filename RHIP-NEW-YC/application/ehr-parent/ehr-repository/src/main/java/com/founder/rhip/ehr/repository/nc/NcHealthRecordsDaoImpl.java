package com.founder.rhip.ehr.repository.nc;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.nc.NcHealthRecords;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of NcHealthRecords
 * 
 */
@Repository("ncHealthRecordsDao")
public class NcHealthRecordsDaoImpl extends AbstractDao<NcHealthRecords, String> implements INcHealthRecordsDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}