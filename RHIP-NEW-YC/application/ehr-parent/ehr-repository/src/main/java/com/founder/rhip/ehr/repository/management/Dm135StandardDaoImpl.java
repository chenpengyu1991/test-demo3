package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.management.Dm135Standard;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by jingqiu on 17-4-14.
 */
@Repository("dm135StandardDao")
public class Dm135StandardDaoImpl extends AbstractDao<Dm135Standard, String> implements IDm135StandardDao {

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}
