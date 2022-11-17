package com.founder.rhip.ehr.repository.control;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.control.OccupationDiseaseReport;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of OccupationDiseaseReport
 * 
 */
@Repository("occupationDiseaseReportDao")
public class OccupationDiseaseReportDaoImpl extends AbstractDao<OccupationDiseaseReport, String> implements IOccupationDiseaseReportDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}