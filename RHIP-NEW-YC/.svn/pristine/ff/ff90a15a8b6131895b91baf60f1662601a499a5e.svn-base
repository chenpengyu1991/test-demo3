package com.founder.rhip.ehr.repository.women;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.founder.fasf.util.ObjectUtil;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.women.DeliveryRecordInfo;
import com.founder.rhip.ehr.entity.women.MotherhoodPeriodFollowup;

/**
 * DAO implement of DeliveryRecordInfo
 * 
 */
@Repository("deliveryRecordInfoDao")
public class DeliveryRecordInfoDaoImpl extends
		AbstractDao<DeliveryRecordInfo, String> implements
		IDeliveryRecordInfoDao {
	@Resource(name = "msdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	public Map countChildDeath(Map<String, String> paramMap, List orgCodes) {
		String queryType = paramMap.get("queryType");
		String selectOrg = paramMap.get("selectOrg");
		String beginDateStr = paramMap.get("beginDate");
		String endDateStr = paramMap.get("endDate");
		String orgField = "";
		if ("1".equals(queryType)) {
			orgField = "MIDWIFERY_CENTER";
		} else if ("2".equals(queryType)) {
			orgField = "MIDWIFERY_CENTER";
		} else if ("3".equals(queryType)) {
			orgField = "MIDWIFERY_STATION";
		} else if ("4".equals(queryType)) {
			orgField = "MIDWIFERY_TOWN";
		}

		Criteria ca = new Criteria();
		if (StringUtil.isNotEmpty(selectOrg)) {
			ca.add(orgField, selectOrg);
		} else {
			ca.add(orgField, OP.IN, orgCodes);
		}
		/* 时间范围 */
		Date beginDate = DateUtil.parseSimpleDate(beginDateStr, null);
		Date endDate = DateUtil.parseSimpleDate(endDateStr, null);
		DateUtil.getCriteriaByDateRange(ca, "BIRTHDAY", beginDate, endDate);

		StringBuilder sql = new StringBuilder(
				"SELECT "
						+ orgField
						+ " AS org, COUNT(1) AS deathCount FROM WH_DELIVERY_RECORD_INFO ");
		SqlBuilder.buildWhereStatement(DeliveryRecordInfo.class, sql, ca);
		sql.append(" GROUP BY " + orgField);
		// List<BirthCertificate> birthCertificates =
		// getList(BirthCertificate.class, sql.toString(), ca);
		List<Map<String, Object>> deliverys = getMapList(sql.toString(), ca);

		Map resultMap = new HashMap();
		for (Map<String, Object> delivery : deliverys) {
			resultMap.put(delivery.get("org"), delivery.get("deathCount"));
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> getOrganMapCount(Criteria criteria) {
		StringBuilder sql = new StringBuilder(" SELECT "
				+ " CREATE_ORGAN_CODE as organCode,COUNT(1) as count"
				+ " FROM " + " WH_DELIVERY_RECORD_INFO ");
		SqlBuilder.buildWhereStatement(MotherhoodPeriodFollowup.class, sql,
				criteria);
		sql.append(" GROUP BY CREATE_ORGAN_CODE");
		List<Map<String, Object>> maplist = this.getMapList(sql.toString(),
				criteria);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		for (Map<String, Object> map : maplist) {
			resultMap.put((String) map.get("organCode"),
					((BigDecimal) map.get("count")).intValue());
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> getOrganMapDeliveryAndCount(Criteria criteria) {
		StringBuilder sql = new StringBuilder(" SELECT "
						+ " CREATE_ORGAN_CODE as organCode,DELIVERY_WAY||','||COUNT(1) as count"
						+ " FROM " + " WH_DELIVERY_RECORD_INFO ");
		SqlBuilder.buildWhereStatement(MotherhoodPeriodFollowup.class, sql, criteria);
		sql.append(" GROUP BY CREATE_ORGAN_CODE,DELIVERY_WAY");
		List<Map<String, Object>> maplist = this.getMapList(sql.toString(), criteria);
		Map<String, Object> resultMap = new HashMap<String, Object>(); // 分娩方式对应人数
		Map<String, Object> deliveryTypes = new LinkedHashMap<String, Object>(); // 本次查询得到的所有的分娩方式
		for (Map<String, Object> map : maplist) {
			String[] arr = ((String) map.get("count")).split(",");
			if (!deliveryTypes.containsKey(arr[0])) {
				deliveryTypes.put(arr[0], 0);
			}
			if(!resultMap.containsKey((String)map.get("organCode"))){
				resultMap.put((String)map.get("organCode"), null);
			}
		}
		for(Map.Entry<String, Object> entry : resultMap.entrySet()){
			entry.setValue(cloneDeliveryTypes(deliveryTypes));
		}
		for (Map<String, Object> map : maplist) {
			String orgCode = (String) map.get("organCode");
			if (resultMap.containsKey(orgCode)) {
				Map<String, Object> lmap = (Map<String, Object>)resultMap.get(orgCode);
				String[] arr = ((String) map.get("count")).split(",");
				if(lmap.containsKey(arr[0])){
					lmap.put(arr[0], Integer.valueOf(arr[1]));
				}
			}
		}
		resultMap.put("deliveryTypes", deliveryTypes);
		return resultMap;
	}
	
	private Map<String, Object> cloneDeliveryTypes(Map<String, Object> map){
		Map<String, Object> linkmap = new LinkedHashMap<String, Object>();
		for(Map.Entry<String, Object> entry : map.entrySet()){
			linkmap.put(entry.getKey(), entry.getValue());
		}
		return linkmap;
	}

	@Override
	public List<Map<String, Object>> getDeliveryRecordMapList(String dateStr) {
		Assert.notNull(dateStr);
		StringBuilder sqlBuilder = new StringBuilder(
				" select t.create_organ_code organCode,to_char(t.delivery_date,'yyyy/MM/dd') rpDate,sum(decode(t.DELIVERY_WAY,'3',1,0))cesarean_num,"
				+ " sum(decode(t.DELIVERY_WAY,'1',1,0))spontaneous_vaginal_num,"
				+ " sum(decode(t.DELIVERY_WAY,'11',1,0))perineal_incision_num,"
				+ " sum(decode(t.DELIVERY_WAY,'12',1,0))perineal_uncut_num,"
				+ " sum(decode(t.DELIVERY_WAY,'2',1,0))vagina_surgical_delivery_num,"
				+ " sum(decode(t.DELIVERY_WAY,'3',1,0))cesarean_num,"
				+ " sum(decode(t.DELIVERY_WAY,'31',1,0))lower_cesarean_num,"
				+ " sum(decode(t.DELIVERY_WAY,'32',1,0))uterine_cesarean_num,"
				+ " sum(decode(t.DELIVERY_WAY,'33',1,0))extraperitoneal_cesarean_num,"
				+ " sum(decode(t.DELIVERY_WAY,'21',1,0))forceps_delivery_num,"
				+ " sum(decode(t.DELIVERY_WAY,'23',1,0))fetal_head_suction_num,"
				+ " sum(decode(t.DELIVERY_WAY,'22',1,0))breech_delivery_num,"
				+ " sum(decode(t.DELIVERY_WAY,'9',1,0))other_delivery_num,"
				+ " count(1) delivery_num from wh_delivery_record_info t where to_char(t.gather_date,'yyyy/MM/dd')='")
				.append(dateStr)
				.append("' group by t.create_organ_code,to_char(t.delivery_date,'yyyy/MM/dd')");
		return getMapList(sqlBuilder.toString(), new Criteria());

	}

	public Integer getLiveBirthsNum(Integer year,Integer quarter,String orgCode){
		int month = 1;
		if(quarter != 0){
			if(quarter == 1){
				month = 1;
			}else if(quarter == 2){
				month = 4;
			}else if(quarter == 3){
				month = 7;
			}else if(quarter == 4){
				month = 10;
			}
		}
		int nextYear = year+1;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select count(*) from WH_DELIVERY_RECORD_INFO where PUERPERA_RESULT = '1' and CREATE_ORGAN_CODE ='"+orgCode+"' and IS_DELETE = 0");
		if(quarter == 0){
			stringBuilder.append(" and DELIVERY_DATE >=to_date('"+year+"0101','yyyymmdd') and DELIVERY_DATE < to_date('"+nextYear+"0101','yyyymmdd')");
		}else {
			int nextMonth = month +3;
			if(quarter == 4){
				stringBuilder.append(" and DELIVERY_DATE >=to_date('" + year + "" + month + "01','yyyymmdd') and DELIVERY_DATE < to_date('" + nextYear + "0101','yyyymmdd')");
			}else if(quarter == 3){
				stringBuilder.append(" and DELIVERY_DATE >=to_date('" + year + "0" + month + "01','yyyymmdd') and DELIVERY_DATE < to_date('" + year + "" + nextMonth + "01','yyyymmdd')");
			}else {
				stringBuilder.append(" and DELIVERY_DATE >=to_date('" + year + "0" + month + "01','yyyymmdd') and DELIVERY_DATE < to_date('" + year + "0" + nextMonth + "01','yyyymmdd')");
			}
			}
		SqlBuilder.buildWhereStatement(DeliveryRecordInfo.class, stringBuilder, new Criteria());
		Long count = this.getSingle(stringBuilder.toString(), new Criteria(), Long.class);
		return Integer.parseInt(count.toString());
	}


	public List<Map<String,Object>> liveBirthNum(Criteria criteria){
        int quarter = Integer.parseInt(criteria.get("quarter").toString());
        int month = 1;
        //根据季度算出月份
        if(quarter == 1){
            month = 1;
        }else if(quarter == 2){
            month = 4;
        }else if(quarter == 3){
            month = 7;
        }else if(quarter == 4){
            month = 10;
        }
        String countType = criteria.get("countType").toString();
        int year = Integer.parseInt(criteria.get("year").toString());
        String curOrg = (String)criteria.get("curOrg");
        int nextYear = year+1;
		StringBuilder stringBuilder = new StringBuilder();
        if(criteria.get("countTotal") == "1"){//合计
            stringBuilder.append("select sum(liveBirthNum) liveBirthNum from (");
         }
		stringBuilder.append("select vmo.ORGAN_CODE CREATE_ORGAN_CODE,NVL(wdr.liveBirthNum,0) liveBirthNum from mdm_organization vmo left join (select CREATE_ORGAN_CODE,sum(GESTATIONAL_NUMBER) liveBirthNum from WH_DELIVERY_RECORD_INFO " +
                "where PUERPERA_RESULT = '1' and IS_DELETE = 0 ");
        if(countType.equals("1")){
            stringBuilder.append(" and DELIVERY_DATE >=to_date('"+year+"0101','yyyymmdd') and DELIVERY_DATE < to_date('"+nextYear+"0101','yyyymmdd')");
        }else {
            int nextMonth = month +3;
            if(quarter == 4){
                stringBuilder.append(" and DELIVERY_DATE >=to_date('" + year + "" + month + "01','yyyymmdd') and DELIVERY_DATE < to_date('" + nextYear + "0101','yyyymmdd')");
            }else if(quarter == 3){
                stringBuilder.append(" and DELIVERY_DATE >=to_date('" + year + "0" + month + "01','yyyymmdd') and DELIVERY_DATE < to_date('" + year + "" + nextMonth + "01','yyyymmdd')");
            }else {
                stringBuilder.append(" and DELIVERY_DATE >=to_date('" + year + "0" + month + "01','yyyymmdd') and DELIVERY_DATE < to_date('" + year + "0" + nextMonth + "01','yyyymmdd')");
            }
        }
        stringBuilder.append(" group by CREATE_ORGAN_CODE) wdr on vmo.organ_code = wdr.CREATE_ORGAN_CODE ");
        if(criteria.get("roleType") == "02"){
            stringBuilder.append("where vmo.ORGAN_CODE = '"+curOrg+"'");
        }
        if(criteria.get("roleType") == "03"){
            if(criteria.contains("organCode")){
                stringBuilder.append("where vmo.ORGAN_CODE = '"+criteria.get("organCode")+"'");
            }else {
                stringBuilder.append("where vmo.CENTER_CODE = '"+curOrg+"' or vmo.ORGAN_CODE = '"+curOrg+"'");
            }
        }
        if(criteria.get("countTotal") == "1"){//合计
            stringBuilder.append(")");
        }
		return getMapList(stringBuilder.toString(),new Criteria());
	}
}