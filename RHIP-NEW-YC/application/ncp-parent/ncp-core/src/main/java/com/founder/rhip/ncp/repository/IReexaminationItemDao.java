package com.founder.rhip.ncp.repository;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ncp.entity.NcpPatient;
import com.founder.rhip.ncp.entity.NcpReexaminationItem;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import javax.annotation.Resource;
import java.math.BigDecimal;

public interface IReexaminationItemDao extends IDao<NcpReexaminationItem, BigDecimal> {

}
