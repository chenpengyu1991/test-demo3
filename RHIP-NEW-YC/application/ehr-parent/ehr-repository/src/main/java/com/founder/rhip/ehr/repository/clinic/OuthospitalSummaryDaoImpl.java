package com.founder.rhip.ehr.repository.clinic;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.clinic.OuthospitalSummary;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of OuthospitalSummary
 * 
 */
@Repository("outhospitalSummaryDao")
public class OuthospitalSummaryDaoImpl extends AbstractDao<OuthospitalSummary, Long> implements IOuthospitalSummaryDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}