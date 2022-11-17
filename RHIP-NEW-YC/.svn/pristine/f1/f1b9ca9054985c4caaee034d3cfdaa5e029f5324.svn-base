package com.founder.rhip.ehr.repository.clinic;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.clinic.DrugUsage;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of InpatientDrugUsage
 * 
 */
@Repository("inpatientDrugUsageDao")
public class InpatientDrugUsageDaoImpl extends AbstractDao<DrugUsage, Long> implements IInpatientDrugUsageDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}