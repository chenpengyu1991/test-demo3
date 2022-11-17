package com.founder.rhip.ehr.repository.nc;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.nc.NcPlatelets;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Map;

/**
 * DAO implement of NcBloodDonation
 * 
 */
@Repository("ncPlateletsDao")
public class NcPlateletsDaoImpl extends AbstractDao<NcPlatelets, Integer> implements INcPlateletsDao {

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Override
    public int getPlatelets5(Criteria ca){
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT SUM(PLATELETS) AS PLATELETS_TOTAL ");
        sql.append(" FROM NC_PLATELETS ");
        SqlBuilder.buildWhereStatement(NcPlatelets.class, sql, ca);
        Map resultMap =  this.getMap(sql.toString(), ca);

        int result = 0;
        if(ObjectUtil.isNotEmpty(resultMap.get("PLATELETS_TOTAL"))){
            result = ((BigDecimal) resultMap.get("PLATELETS_TOTAL")).intValue();
        }
        return result;
    }
}