package com.founder.rhip.ehr.repository.basic;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.basic.PersonInfoAdditional;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("personInfoAdditionalDao")
public class PersonInfoAdditionalDaoImpl extends
		AbstractDao<PersonInfoAdditional, Long> implements IPersonInfoAdditionalDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}