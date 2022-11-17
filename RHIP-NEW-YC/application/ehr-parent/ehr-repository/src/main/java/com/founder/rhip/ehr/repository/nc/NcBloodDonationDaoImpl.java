package com.founder.rhip.ehr.repository.nc;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.nc.NcBloodDonation;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Map;

/**
 * DAO implement of NcBloodDonation
 * 
 */
@Repository("ncBloodDonationDao")
public class NcBloodDonationDaoImpl extends AbstractDao<NcBloodDonation, Integer> implements INcBloodDonationDao {

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Override
    public int getBloodDonation5(Criteria ca) {

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT SUM(WHOLE_BLOOD) AS BLOOD_TOTAL ");
        sql.append(" FROM NC_BLOOD_DONATION ");
        SqlBuilder.buildWhereStatement(NcBloodDonation.class, sql, ca);
        Map resultMap =  this.getMap(sql.toString(), ca);

        int result = 0;
        if(ObjectUtil.isNotEmpty(resultMap.get("BLOOD_TOTAL"))){
            result = ((BigDecimal) resultMap.get("BLOOD_TOTAL")).intValue();
        }
        return result;
    }

}