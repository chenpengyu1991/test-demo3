package com.founder.rhip.ehr.repository.nc;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.nc.NcVaccination;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of NcVaccination
 * 
 */
@Repository("ncVaccinationDao")
public class NcVaccinationDaoImpl extends AbstractDao<NcVaccination, String> implements INcVaccinationDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}