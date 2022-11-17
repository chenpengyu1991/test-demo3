package com.founder.rhip.ehr.repository.ihm;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.clinic.TransBloodInfo;


@Repository("hospitalBloodUseDao")
public class HospitalBloodUseDaoImpl extends AbstractDao<TransBloodInfo, Long> implements IHospitalBloodUseDao {

    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

}
