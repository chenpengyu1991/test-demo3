package com.founder.rhip.ehr.repository.nc;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.nc.NcChildExamination;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of NcChildExamination
 * 
 */
@Repository("ncChildExaminationDao")
public class NcChildExaminationDaoImpl extends AbstractDao<NcChildExamination, String> implements INcChildExaminationDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}