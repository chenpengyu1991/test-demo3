package com.founder.rhip.ehr.repository.clinic;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.clinic.HealthExamination;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of HealthExamination
 * 
 */
@Repository("healthExamQueryDao")
public class HealthExamQueryDaoImpl extends AbstractDao<HealthExamination, Long> implements IHealthExamQueryDao {

	@Resource(name = "msdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	/**
	 * 获取体检关系列表
	 */
	@Override
	public PageList<HealthExamination> getHealthExaminations(Criteria criteria, Page page,Order order) {
		StringBuilder sql = new StringBuilder("SELECT * FROM MS_HEALTH_EXAMINATION ");
		SqlBuilder.buildWhereStatement(HealthExamination.class, sql, criteria);
		SqlBuilder.buildOrderStatement(sql, order.toString().replaceAll("ORDER BY ", ""));
		PageList<HealthExamination> healthExaminations = this.getPageList(page, sql.toString(), criteria);
		return healthExaminations;
	}

	@Override
	public PageList<HealthExamination> getAnalyzeHealthExams(Criteria criteria, Page page, Order order){
		Object weigth = criteria.get("he_weigth");
		Object hepatitisB = criteria.get("he_hepatitisB");
		StringBuilder sql = new StringBuilder("SELECT health.* FROM MS_HEALTH_EXAMINATION health ");

		criteria.remove("he_weigth");
		criteria.remove("he_hepatitisB");
		
		SqlBuilder.buildWhereStatement(HealthExamination.class, sql, criteria);
		if(ObjectUtil.isNotEmpty(weigth) || ObjectUtil.isNotEmpty(hepatitisB)){
			sql.append(" AND ( ");
		}		
		if(ObjectUtil.isNotEmpty(weigth)){
			sql.append( "  EXISTS(");
			sql.append(getObservationInfoSql(weigth.toString()));
			sql.append( " )");
		}
		if(ObjectUtil.isNotEmpty(hepatitisB)){
			if(ObjectUtil.isNotEmpty(weigth)){
				sql.append( " OR");
			}
			sql.append( " EXISTS(");
			sql.append(getExamineDetailSql(hepatitisB.toString()));
			sql.append( " )");
		}
		if(ObjectUtil.isNotEmpty(weigth) || ObjectUtil.isNotEmpty(hepatitisB)){
			sql.append( " )");
		}
	
		SqlBuilder.buildOrderStatement(sql, order.toString().replaceAll("ORDER BY ", ""));
		PageList<HealthExamination> healthExaminations = this.getPageList(page, sql.toString(),criteria);
		return healthExaminations;
	}
	
	private String getObservationInfoSql(String weigth){
		StringBuilder sql = new StringBuilder();
		if(StringUtil.isNotEmpty(weigth)){
			sql.append("SELECT " +
					"	T1.EHR_ID " +
					" FROM " +
					"	( " +
					"		SELECT " +
					"			PERSON_ID, " +
					"			EHR_ID, " +
					"			DECODE(trim(translate(nvl(OBSERVATION_RESULT,0),'0123456789.',' ')),null,nvl(OBSERVATION_RESULT,0),0) as OBSERVATION_RESULT " +
					"		FROM " +
					"			MS_OBSERVATION_INFO  " +
					"		WHERE " +
					"			OBSERVATION_ITEM_CODE = '010011' " +
					"  AND regexp_like(OBSERVATION_RESULT ,'^(-?[0-9]+)(.[0-9]+)?$') " + 
					"	) T1 " +
					" INNER JOIN ( " +
					"	SELECT " +
					"		EHR_ID,PERSON_ID, " +
	                "		DECODE(trim(translate(nvl(OBSERVATION_RESULT,0),'0123456789.',' ')),null,nvl(OBSERVATION_RESULT,0),0) as OBSERVATION_RESULT " +
					"	FROM " +
					"		MS_OBSERVATION_INFO  " +
					"	WHERE " +
					"		OBSERVATION_ITEM_CODE = '010012' " +
					"  AND regexp_like(OBSERVATION_RESULT ,'^(-?[0-9]+)(.[0-9]+)?$') " + 
					" ) T2 ON T1.PERSON_ID = T2.PERSON_ID " +
					" AND T1.EHR_ID = T2.EHR_ID " +
	                " AND T2.OBSERVATION_RESULT <> 0 " );
			if("1".equals(weigth)){
				sql.append(" AND trunc(DECODE(T2.OBSERVATION_RESULT,0,0,T1.OBSERVATION_RESULT/((T2.OBSERVATION_RESULT*0.01)*(T2.OBSERVATION_RESULT*0.01))),4) > 24");
				sql.append(" AND trunc(DECODE(T2.OBSERVATION_RESULT,0,0,T1.OBSERVATION_RESULT/((T2.OBSERVATION_RESULT*0.01)*(T2.OBSERVATION_RESULT*0.01))),4) < 27.9999");
				
			}else if("2".equals(weigth)){
				sql.append(" AND trunc(DECODE(T2.OBSERVATION_RESULT,0,0,T1.OBSERVATION_RESULT/((T2.OBSERVATION_RESULT*0.01)*(T2.OBSERVATION_RESULT*0.01))),4) > 28");
			}
			sql.append(" WHERE T1.EHR_ID = health.EHR_ID ");
		}
		return sql.toString();
	}
	
	private String getExamineDetailSql(String hepatitisB){
		StringBuilder sql = new StringBuilder();
		if(StringUtil.isNotEmpty(hepatitisB)){
			sql.append(" SELECT EHR_ID FROM MS_EXAMINE_DETAIL examine" +
					" WHERE INSPECTION_ITEM_CODE='5446' AND INSPECTION_RESULT = '1' AND examine.EHR_ID = health.EHR_ID");
		}
		return sql.toString();
		
	}

}