package com.founder.rhip.ehr.repository.healtheducation;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.healtheducation.HeResource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of HealthEducationResource
 * 
 */
@Repository("heResourceDao")
public class HeResourceDaoImpl extends AbstractDao<HeResource, Long> implements IHeResourceDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    public List<Map<String, Object>> getYearReport1(Map paramMap){
        String startDate = (String)paramMap.get("beginDate");
        String endDate = (String)paramMap.get("endDate");
        StringBuilder sql = new StringBuilder("SELECT DEVICE_NAME, COUNT(1) AS TOTAL, SUM(DEVICE_COST) AS COST\n" +
                "  FROM HE_RESOURCE\n" +
                " WHERE RESOURCE_TYPE = 1\n" +
                "   AND RESOURCE_RECORD_TIME >= TO_DATE('"+startDate+"', 'YYYY/MM/DD')\n" +
                "   AND RESOURCE_RECORD_TIME <= TO_DATE('"+endDate+" 23:59:59', 'YYYY/MM/DD HH24:MI:SS')\n" +
                " GROUP BY DEVICE_NAME");
        List<Map<String, Object>> result = getMapList(sql.toString(), new Criteria());
        return result;
    }
}