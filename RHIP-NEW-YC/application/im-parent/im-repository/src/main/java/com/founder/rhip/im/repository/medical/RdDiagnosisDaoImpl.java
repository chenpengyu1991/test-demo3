package com.founder.rhip.im.repository.medical;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.im.entity.medical.RdDiagnosis;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of RdDiagnosis
 * 
 */
@Repository("rdDiagnosisDao")
public class RdDiagnosisDaoImpl extends AbstractDao<RdDiagnosis, Long> implements IRdDiagnosisDao {
    @Resource(name = "phbdbJDBCTemplate")
    protected SimpleJdbcTemplate simpleJdbcTemplate;

    private String RANKING_SQL = "SELECT * FROM( \n" +
            "   SELECT \n" +
            "	    SUBSTR(ltrim(rtrim(DIAGNOSIS_CODE)),0,3) DIAGNOSIS_CODE,SUM(DIAGNOSIS_COUNT) DIAGNOSIS_COUNT\n" +
            "   FROM RD_DIAGNOSIS\n" +
            "   %1$s\n" +
            "   GROUP BY SUBSTR(ltrim(rtrim(DIAGNOSIS_CODE)),0,3)\n" +
            "   ORDER BY DIAGNOSIS_COUNT DESC\n" +
            ")\n" +
            "WHERE rownum <=10\n" +
            "ORDER BY DIAGNOSIS_COUNT ASC";
    @Override
    public List<Map<String, Object>> getRankingMapList(Criteria ca) {
        StringBuilder reportWhere = new StringBuilder();
        SqlBuilder.buildWhereStatement(RdDiagnosis.class, reportWhere, ca);
        String sql = String.format(RANKING_SQL,reportWhere.toString());
        return this.getMapList(sql,ca);
    }
}