package com.founder.rhip.ehr.repository.clinic;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.clinic.Consultation;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of EhrPhysiqueExamination
 * 
 */
@Repository("consultationDao")
public class ConsultationDaoImpl extends AbstractDao<Consultation, Long> implements IConsultationDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

}