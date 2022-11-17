package com.founder.rhip.ehr.repository.control.idm.notifiabledisease;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.EpidemicFocusClose;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of EpidemicFocusClose
 * 
 */
@Repository("epidemicFocusCloseDao")
public class EpidemicFocusCloseDaoImpl extends AbstractDao<EpidemicFocusClose, Integer> implements IEpidemicFocusCloseDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}