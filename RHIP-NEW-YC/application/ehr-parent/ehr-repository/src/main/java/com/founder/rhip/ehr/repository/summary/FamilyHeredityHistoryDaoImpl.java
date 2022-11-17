package com.founder.rhip.ehr.repository.summary;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.summary.FamilyHeredityHistory;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of FamilyHeredityHistory
 * 
 */
@Repository("familyHeredityHistoryDao")
public class FamilyHeredityHistoryDaoImpl extends AbstractDao<FamilyHeredityHistory, String> implements IFamilyHeredityHistoryDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}