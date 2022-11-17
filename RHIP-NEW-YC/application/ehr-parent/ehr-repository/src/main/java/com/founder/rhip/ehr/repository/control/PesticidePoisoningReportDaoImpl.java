package com.founder.rhip.ehr.repository.control;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.control.PesticidePoisoningReport;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of PesticidePoisoningReport
 * 
 */
@Repository("pesticidePoisoningReportDao")
public class PesticidePoisoningReportDaoImpl extends AbstractDao<PesticidePoisoningReport, String> implements IPesticidePoisoningReportDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}