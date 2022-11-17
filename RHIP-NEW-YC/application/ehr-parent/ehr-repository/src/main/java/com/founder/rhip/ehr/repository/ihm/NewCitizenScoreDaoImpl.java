package com.founder.rhip.ehr.repository.ihm;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.nc.NcLog;


@Repository("newCitizenScoreDao")
public class NewCitizenScoreDaoImpl extends AbstractDao<NcLog, Integer> implements INewCitizenScoreDao {

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

}
