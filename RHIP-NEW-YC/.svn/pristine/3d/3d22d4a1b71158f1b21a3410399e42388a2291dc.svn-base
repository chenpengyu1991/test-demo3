package com.founder.rhip.ehr.repository.management.mhm;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.management.mhm.MhmCaseDetail;
import com.founder.rhip.ehr.repository.management.mhm.IMhmCaseDetailDao;

/**
 * DAO implement of MhmCaseDetail
 * 
 */
@Repository("mhmCaseDetailDao")
public class MhmCaseDetailDaoImpl extends AbstractDao<MhmCaseDetail, Long> implements IMhmCaseDetailDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}