package com.founder.rhip.im.repository.medical;

import com.founder.rhip.im.entity.medical.RdEquipment;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of RdEquipment
 * 
 */
@Repository("rdEquipmentDao")
public class RdEquipmentDaoImpl extends AbstractDao<RdEquipment, Long> implements IRdEquipmentDao {
    @Resource(name = "phbdbJDBCTemplate")
    protected SimpleJdbcTemplate simpleJdbcTemplate;
}