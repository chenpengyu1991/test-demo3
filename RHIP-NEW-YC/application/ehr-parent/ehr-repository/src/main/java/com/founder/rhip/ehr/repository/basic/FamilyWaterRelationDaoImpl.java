package com.founder.rhip.ehr.repository.basic;

import com.founder.rhip.ehr.entity.basic.FamilyPersonRelation;
import com.founder.rhip.ehr.entity.basic.FamilyWaterRelation;
import com.founder.fasf.repository.AbstractDao;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;


@Repository("familyWaterRelationDao")
public class FamilyWaterRelationDaoImpl extends AbstractDao<FamilyWaterRelation,Long> implements IFamilyWaterRelationDao{
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}
