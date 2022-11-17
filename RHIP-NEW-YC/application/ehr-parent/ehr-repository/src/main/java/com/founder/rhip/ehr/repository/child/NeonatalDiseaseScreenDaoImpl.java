package com.founder.rhip.ehr.repository.child;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.entity.child.BirthCertificate;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.child.NeonatalDiseaseScreen;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of NeonatalDiseaseScreen
 * 
 */
@Repository("neonatalDiseaseScreenDao")
public class NeonatalDiseaseScreenDaoImpl extends AbstractDao<NeonatalDiseaseScreen, String> implements INeonatalDiseaseScreenDao {
	@Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    public Map countDiseaseScreen(Map<String, String> paramMap, List orgCodes){
        String genreCode = paramMap.get("genreCode");
        String gbCode = paramMap.get("gbCode");
        String superOrganCode = paramMap.get("superOrganCode");
        String organCode = paramMap.get("organCode");
        String beginDateStr = paramMap.get("beginDate");
        String endDateStr = paramMap.get("endDate");
        String diseaseScreenItem = paramMap.get("diseaseScreenItem");
        Criteria ca = new Criteria("NEONATAL_DISEASE_SCREEN_ITEM", diseaseScreenItem); //1甲状腺功能减低症 2苯丙酮尿症
        String orgField = "";
        if("0".equals(genreCode)){
            orgField = "PATOWN_SHIP";
            ca.add(orgField,OP.IN, orgCodes);
        }else{
            orgField = "CREATE_ORGAN_CODE";
            ca.add(orgField, OP.IN, orgCodes);
        }
        /* 时间范围 */
        Date beginDate = DateUtil.parseSimpleDate(beginDateStr, null);
        Date endDate = DateUtil.parseSimpleDate(endDateStr, null);
        DateUtil.getCriteriaByDateRange(ca, "CHECK_DATE", beginDate,endDate);

//        StringBuilder sql = new StringBuilder("SELECT "+orgField+" AS org, COUNT(1) AS bbtnCount FROM CH_NEONATAL_DISEASE_SCREEN ");
        StringBuilder sql = new StringBuilder("SELECT DECODE("+orgField+",null,'合计',"+orgField+") AS org, count(1) AS dsCount FROM CH_NEONATAL_DISEASE_SCREEN ");
        SqlBuilder.buildWhereStatement(BirthCertificate.class, sql, ca);
//        sql.append(" GROUP BY "+orgField);
        sql.append(" GROUP BY "+ " ROLLUP(" + orgField + ")" );
        List<Map<String, Object>> birthCertificates = getMapList(sql.toString(), ca);

        Map resultMap = new HashMap();
        for(Map<String, Object> birthCertificate : birthCertificates){
            resultMap.put(birthCertificate.get("org"), birthCertificate.get("dsCount"));
        }
        return resultMap;
    }

	@Override
	public List<Map<String, Object>> getNeonatalDiseaseScreenMapList(
			String dateStr) {
    	Assert.notNull(dateStr);
    	StringBuilder sqlBuilder = new StringBuilder(" select t.create_organ_code organCode,to_char(t.check_date,'yyyy/MM/dd') dt, sum(decode(t.NEONATAL_DISEASE_SCREEN_ITEM,2,1,0)) pku_num, sum(decode(t.NEONATAL_DISEASE_SCREEN_ITEM,1,1,0)) hy_num from ch_neonatal_disease_screen t where to_char(t.gather_date,'yyyy/MM/dd')='").append(dateStr).append("' group by t.create_organ_code,to_char(t.check_date,'yyyy/MM/dd')");
    	return getMapList(sqlBuilder.toString(), new Criteria()); 
	}

}