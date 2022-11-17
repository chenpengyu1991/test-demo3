package com.founder.rhip.ehr.repository.clinic;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.clinic.EquipmentBreakage;

/**
 * DAO implement of EquipmentBreakage
 * 
 */
@Repository("equipmentBreakageDao")
public class EquipmentBreakageDaoImpl extends AbstractDao<EquipmentBreakage, Long> implements IEquipmentBreakageDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}