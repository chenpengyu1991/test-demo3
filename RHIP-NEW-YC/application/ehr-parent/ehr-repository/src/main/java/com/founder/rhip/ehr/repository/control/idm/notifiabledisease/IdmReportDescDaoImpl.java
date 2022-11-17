package com.founder.rhip.ehr.repository.control.idm.notifiabledisease;
import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmReportDesc;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of DcInfectionDiseaseReport
 * 
 */
@Repository("idmReportDescDao")
public class IdmReportDescDaoImpl extends AbstractDao<IdmReportDesc, Integer> implements IIdmReportDescDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

}