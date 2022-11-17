package com.founder.rhip.ehr.repository.clinic;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.clinic.EquipmentStore;

/**
 * DAO implement of EquipmentStore
 * 
 */
@Repository("equipmentStoreDao")
public class EquipmentStoreDaoImpl extends AbstractDao<EquipmentStore, Long> implements IEquipmentStoreDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}