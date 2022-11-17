package com.founder.rhip.ehr.repository.control.idm.notifiabledisease;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.EpidemiologicalSurvey;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of EpidemiologicalSurvey
 * 
 */
@Repository("epidemiologicalSurveyDao")
public class EpidemiologicalSurveyDaoImpl extends AbstractDao<EpidemiologicalSurvey, Integer> implements IEpidemiologicalSurveyDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}