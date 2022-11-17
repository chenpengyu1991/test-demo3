package com.founder.rhip.ehr.repository.control;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.control.FoodborneDiseaseReport;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of FoodborneDiseaseReport
 * 
 */
@Repository("foodborneDiseaseReportDao")
public class FoodborneDiseaseReportDaoImpl extends AbstractDao<FoodborneDiseaseReport, String> implements IFoodborneDiseaseReportDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}