package com.founder.rhip.ehr.repository.nc;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.nc.NcHealthCertificate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of NcHealthCertificate
 * 
 */
@Repository("ncHealthCertificateDao")
public class NcHealthCertificateDaoImpl extends AbstractDao<NcHealthCertificate, String> implements INcHealthCertificateDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}