package com.founder.rhip.ehr.repository.clinic;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.clinic.ConsultationInfo;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of ConsultationInfo
 * 
 */
@Repository("consultationInfoDao")
public class ConsultationInfoDaoImpl extends AbstractDao<ConsultationInfo, Long> implements IConsultationInfoDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}