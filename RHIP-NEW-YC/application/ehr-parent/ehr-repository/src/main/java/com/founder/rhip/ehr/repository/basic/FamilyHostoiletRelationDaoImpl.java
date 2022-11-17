package com.founder.rhip.ehr.repository.basic;

import com.founder.rhip.ehr.entity.basic.FamilyHostoiletRelation;
import com.founder.rhip.ehr.repository.basic.IFamilyHostoiletRelationDao;
import com.founder.fasf.repository.AbstractDao;
import org.springframework.expression.spel.ast.Literal;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("familyHostoiletRelationDao")
public class FamilyHostoiletRelationDaoImpl extends AbstractDao<FamilyHostoiletRelation,Long> implements IFamilyHostoiletRelationDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}
