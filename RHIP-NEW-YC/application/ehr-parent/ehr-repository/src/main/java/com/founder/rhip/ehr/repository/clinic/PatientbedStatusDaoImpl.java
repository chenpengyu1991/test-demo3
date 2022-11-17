package com.founder.rhip.ehr.repository.clinic;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.clinic.PaitentbedStatus;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by f on 2016/12/12.
 */
@Repository("patientbedStatusDao")
public class PatientbedStatusDaoImpl extends AbstractDao<PaitentbedStatus,Long> implements IPatientbedStatusDao{
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}
