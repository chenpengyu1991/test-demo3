package com.founder.rhip.ehr.repository.nc;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.nc.NcPunishment;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of NcPunishment
 * 
 */
@Repository("ncPunishmentDao")
public class NcPunishmentDaoImpl extends AbstractDao<NcPunishment, String> implements INcPunishmentDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}