package com.founder.rhip.ehr.repository.ihm;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.blood.BsBloodDonorInfo;
import com.founder.rhip.ehr.entity.blood.BsReimbursement;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 */
@Repository("bloodDonationDao")
public class BloodDonationDaoImpl extends AbstractDao<BsBloodDonorInfo, Long> implements IBloodDonationDao {

    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

}