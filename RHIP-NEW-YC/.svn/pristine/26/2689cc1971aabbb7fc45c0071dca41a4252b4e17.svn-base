package com.founder.rhip.ehr.repository.clinic;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.clinic.OutpatientDrugUsage;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of OutpatientDrugUsage
 * 
 */
@Repository("outpatientDrugUsageDao")
public class OutpatientDrugUsageDaoImpl extends AbstractDao<OutpatientDrugUsage, Long> implements IOutpatientDrugUsageDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}