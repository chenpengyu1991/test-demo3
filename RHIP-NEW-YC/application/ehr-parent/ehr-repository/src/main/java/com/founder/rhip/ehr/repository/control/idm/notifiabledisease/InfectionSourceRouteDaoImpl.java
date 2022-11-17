package com.founder.rhip.ehr.repository.control.idm.notifiabledisease;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.InfectionSourceRoute;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of InfectionSourceRoute
 * 
 */
@Repository("infectionSourceRouteDao")
public class InfectionSourceRouteDaoImpl extends AbstractDao<InfectionSourceRoute, Integer> implements IInfectionSourceRouteDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}