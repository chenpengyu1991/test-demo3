package com.founder.rhip.ncp.repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ncp.entity.NcpPatient;
import com.founder.rhip.ncp.entity.NcpReexaminationItem;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Repository("ncpReexamItemDao")
public class ReexaminationItemDaoImpl extends AbstractDao<NcpReexaminationItem, BigDecimal> implements IReexaminationItemDao{

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}
