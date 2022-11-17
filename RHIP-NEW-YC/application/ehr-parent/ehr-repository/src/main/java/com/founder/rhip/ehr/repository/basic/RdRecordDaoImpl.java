package com.founder.rhip.ehr.repository.basic;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.basic.RdRecord;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("rdRecordDao")
public class RdRecordDaoImpl extends AbstractDao<RdRecord, Long> implements IRdRecordDao {
	@Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}
