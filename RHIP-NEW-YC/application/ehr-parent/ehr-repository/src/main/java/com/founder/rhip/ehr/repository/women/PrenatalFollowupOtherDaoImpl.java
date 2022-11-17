package com.founder.rhip.ehr.repository.women;

import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.entity.women.PrenatalFollowupOther;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;

/**
 * DAO implement of PrenatalFollowup
 * 
 */
@Repository("prenatalFollowupOtherDao")
public class PrenatalFollowupOtherDaoImpl extends AbstractDao<PrenatalFollowupOther, Long> implements IPrenatalFollowupOtherDao {
	@Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Override
    public void updateOrganByVillage(String inputSuperOrganCode, String orgCode, String[] newAddVillageCodes) {
        String sql = "UPDATE WH_PRENATAL_FOLLOWUP_OTHER ech SET ech.CREATE_ORGAN_CODE = :orgCode,ech.CREATE_SUPER_ORGAN_CODE=:inputSuperOrganCode WHERE EXISTS ( SELECT 1 FROM WOMEN_CHILD_HEALTH w WHERE w.PERSON_ID = ech.PERSON_ID AND w.PASTREET IN (:villages))";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("villages", Arrays.asList(newAddVillageCodes));
        parameterSource.addValue("orgCode", orgCode);
        parameterSource.addValue("inputSuperOrganCode", inputSuperOrganCode);
        simpleJdbcTemplate.update(sql, parameterSource);
    }
}