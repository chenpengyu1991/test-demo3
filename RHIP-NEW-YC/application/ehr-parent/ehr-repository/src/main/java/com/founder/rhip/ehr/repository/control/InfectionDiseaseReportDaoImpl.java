package com.founder.rhip.ehr.repository.control;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.control.InfectionDiseaseReport;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of InfectionDiseaseReport
 * 
 */
@Repository("infectionDiseaseReportDao")
public class InfectionDiseaseReportDaoImpl extends AbstractDao<InfectionDiseaseReport, String> implements IInfectionDiseaseReportDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}