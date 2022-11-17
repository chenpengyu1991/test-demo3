package com.founder.rhip.ehr.repository.summary;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.summary.FamilyBedHistory;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of FamilyBedHistory
 * 
 */
@Repository("familyBedHistoryDao")
public class FamilyBedHistoryDaoImpl extends AbstractDao<FamilyBedHistory, String> implements IFamilyBedHistoryDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}