package com.founder.rhip.im.repository.medical;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.im.entity.medical.RdPrescription;
import com.founder.rhip.mdm.common.OrgGenreCode;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of RdBedDistribution
 * 
 */
@Repository("rdPrescriptionDao")
public class RdPrescriptionDaoImpl extends AbstractDao<RdPrescription, Long> implements IRdPrescriptionDao {
    @Resource(name = "phbdbJDBCTemplate")
    protected SimpleJdbcTemplate simpleJdbcTemplate;

    /**
     * 平均处方，最大处方
     */
    private String PRESCRIPTION_COST_SQL = "SELECT %1$s\n" +
            "	,DECODE(p_count,null,0,ROUND(p_cost/p_count,2)) avg_cost\n" +
            "	,m_cost,p_count\n" +
            "FROM(\n" +
            "	SELECT %1$s\n" +
            "		,SUM(PRESCRIPTION_TOTAL_COST) p_cost\n" +
            "		,SUM(PRESCRIPTION_COUNT) p_count\n" +
            "		,MAX(PRESCRIPTION_MAX_COST) m_cost\n" +
            "	FROM RD_PRESCRIPTION\n" +
            "	%2$s\n" +
            "	GROUP BY %1$s\n" +
            ")" +
            "ORDER by avg_cost desc\n" ;


    @Override
    public List<Map<String, Object>> getPrescriptionCostMapList(Criteria ca) {
        StringBuilder reportWhere = new StringBuilder();
        String groupField = getGroupField(ca);
        SqlBuilder.buildWhereStatement(RdPrescription.class, reportWhere, ca);
        String sql = String.format(PRESCRIPTION_COST_SQL,groupField,reportWhere.toString());
        return this.getMapList(sql,ca);
    }

    private String getGroupField(Criteria ca ){
        String result = "ORGAN_CODE";
        Object genreCode = ca.get("GENRE_CODE");
        //按镇
        if("0".equals(genreCode)){
            result = "GB_CODE";
            ca.remove("GENRE_CODE");
        }
        if(OrgGenreCode.CENTRE.getValue().equals(genreCode)){
            result = "ORGAN_CODE";
        }
        if(OrgGenreCode.HOSPITAL.getValue().equals(genreCode)){
            result = "ORGAN_CODE";
        }
        return result;
    }
}