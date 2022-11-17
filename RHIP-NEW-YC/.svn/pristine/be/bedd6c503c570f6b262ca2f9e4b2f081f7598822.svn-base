package com.founder.rhip.ehr.repository.basic;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.fasf.beans.Criteria;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.basic.FamilyPersonRelation;
import com.founder.rhip.ehr.repository.basic.IFamilyPersonRelationDao;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;

import javax.annotation.Resource;
import java.util.List;

/**
 * DAO implement of FamilyPersonRelation
 * 
 */
@Repository("familyPersonRelationDao")
public class FamilyPersonRelationDaoImpl extends AbstractDao<FamilyPersonRelation, Long> implements IFamilyPersonRelationDao {

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    public List<PersonInfo> getList(FamilyPersonRelation familyPersonRelation) {
        StringBuilder sql = new StringBuilder("select pi.idcard,pi.NAME name, pi.BIRTHDAY birthday, pi.ID id, ");
        sql.append("pi.GENDER gender, pir.FAMILY_MEM_TYPE_CODE familyMemTypeCode, pir.FAMILY_MEM_MAN_STATUS familyMemStatus ");
        sql.append(" from BI_PERSON_INFO pi JOIN BI_FAMILY_PERSON_RELATION pir ON ");
        sql.append(" pi.ID = pir.PERSON_ID AND pir.FAMILY_ID = :familyId");
        SqlParameterSource param = new MapSqlParameterSource().addValue("familyId",familyPersonRelation.getFamilyId());
        List<PersonInfo> list = this.getList(PersonInfo.class,sql.toString(), param);
        return list;
    }

	@Override
	public List<FamilyPersonRelation> getFamilyPersonRelations(Criteria criteria) {
		StringBuilder sql = new StringBuilder("SELECT 1 FROM BI_FAMILY_PERSON_RELATION T1 LEFT JOIN BI_FAMILY_INFO T2 ON T1.FAMILY_ID = T2.ID");
		SqlBuilder.buildWhereStatement(FamilyPersonRelation.class, sql, criteria);
		return this.getList(sql.toString(), criteria);
	}
}