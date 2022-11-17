package com.founder.rhip.ehr.repository.ihm;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmReport;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository("newWchTargetDao")
public class NewWchTargetDaoImpl extends AbstractDao<IdmReport, Long> implements INewWchTargetDao {
	
	@Resource(name = "msdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Override
	public List<Map<String, Object>> getHospitalDelivery(
			Map<String, String> paramMap) {
			String paTownShip = paramMap.get("gbCode");
	        String beginDateStr = paramMap.get("beginDate");
	        String endDateStr = paramMap.get("endDate");

	        StringBuilder sql = new StringBuilder("select gb_code,sum(hospital_delivery) as hospital_delivery,(sum(UNHOSPITAL_DELIVERY)+sum(hospital_delivery)) as totaldelivery from WH_DELIVERY_CONDITIONS where TO_date(delivery_month,'YYYY/MM') >=TO_DATE('"+beginDateStr+"', 'YYYY/MM/DD') and TO_date(delivery_month,'YYYY/MM') <= TO_DATE('"+endDateStr+"', 'YYYY/MM/DD')");
	            if(StringUtil.isNotEmpty(paTownShip)){
	                sql.append("and gb_code = '"+paTownShip+"'");
	             }
	            sql.append("group by gb_code order by gb_code");
	        List<Map<String, Object>> result = getMapList(sql.toString(), new Criteria());
	        return result;
	}

	@Override
	public List<Map<String, Object>> getMaternalDeath(
			Map<String, String> paramMap) {
		String paTownShip = paramMap.get("gbCode");
        String beginDateStr = paramMap.get("beginDate");
        String endDateStr = paramMap.get("endDate");

        StringBuilder sql = new StringBuilder("select gb_code,sum(PREGNANT_TOTAL) as PREGNANT_TOTAL,sum(DEADPREGNANT_TOTAL) as DEADPREGNANT_TOTAL,\tDECODE( sum( PREGNANT_TOTAL ), 0, 0, ROUND(sum( DEADPREGNANT_TOTAL ) / sum( PREGNANT_TOTAL ),4 )) AS PCT  from WH_PREGNAN_CONDITIONS where TO_date(PREGNANT_MONTH,'YYYY/MM') >=TO_DATE('"+beginDateStr+"', 'YYYY/MM/DD') and TO_date(PREGNANT_MONTH,'YYYY/MM') <= TO_DATE('"+endDateStr+"', 'YYYY/MM/DD')");
            if(StringUtil.isNotEmpty(paTownShip)){
                sql.append("and gb_code = '"+paTownShip+"'");
             }
            sql.append("group by gb_code order by gb_code");
        List<Map<String, Object>> result = getMapList(sql.toString(), new Criteria());
        return result;
	}

}
