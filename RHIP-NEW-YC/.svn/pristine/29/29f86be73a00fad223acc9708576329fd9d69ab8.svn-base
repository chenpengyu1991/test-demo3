package com.founder.rhip.ehr.repository.report;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.report.RpHealthRecord;
import com.founder.rhip.mdm.common.OrgGenreCode;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of RpExaminationEvent
 * 
 */
@Repository("rpHealthRecordDao")
public class RpHealthRecordDaoImpl extends AbstractDao<RpHealthRecord, Long> implements IRpHealthRecordDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;/*gb_code,center_code,*/
	
	private static final String HEALTH_RECORD_SQL = "select rr.*, "
			+ " nvl(ROUND(create_num / nullif(should_create_num, 0), 4),0) zong_jian,"
			+ "	nvl(ROUND(one_star_num / nullif(create_num, 0), 4),0)one_int,"
			+ "	nvl(ROUND(two_star_num / nullif(create_num, 0), 4),0)two_int,"
			+ "	nvl(ROUND(three_star_num / nullif(create_num, 0), 4),0)three_int,"
			+ "	nvl(ROUND(complete_num / nullif(create_num, 0), 4),0)all_int_comp,"
			+ "	nvl(ROUND(one_star_complete_num / nullif(complete_num, 0), 4),0)one_int_comp,"
			+ "	nvl(ROUND(two_star_complete_num / nullif(complete_num, 0), 4),0)two_int_comp,"
			+ "	nvl(ROUND(three_star_complete_num / nullif(complete_num, 0), 4),0)three_int_comp,"
			+ "	nvl(ROUND(two_up / nullif(create_num, 0), 4),0)two_up_int,"
			+ " nvl(ROUND(two_up_comp / nullif(create_num, 0), 4),0)two_up_int_comp"
			+ " from("
			+ " select %7$s"
			+ " decode(grouping_id(%1$s), %5$s, %4$s) AS %4$s,"
			+ " sum(nvl(create_num, 0))create_num,sum(nvl(one_star_num, 0))one_star_num,"
			+ " sum(nvl(one_star_complete_num, 0))one_star_complete_num,"
			+ " sum(nvl(two_star_num, 0))two_star_num,sum(nvl(two_star_complete_num, 0))two_star_complete_num,"
			+ " sum(nvl(three_star_num, 0))three_star_num,sum(nvl(three_star_complete_num, 0))three_star_complete_num,"
			+ " sum(nvl(should_create_num, 0))should_create_num,"
			+ "	sum(nvl(one_star_complete_num, 0)) +  sum(nvl(two_star_complete_num, 0)) +sum(nvl(three_star_complete_num, 0))complete_num,"
			+ "	sum(nvl(two_star_num, 0)) +  sum(nvl(three_star_num, 0)) two_up,"
			+ "	sum(nvl(two_star_complete_num, 0)) +sum(nvl(three_star_complete_num, 0))two_up_comp"
			+ " from (select org.gb_code,org.center_code,org.organ_code,org.organ_type, t.*"
			+ " from mdm_organization org"
			+ " left join (select rp.organ_code orgCode,rp.create_num,rp.one_star_num,rp.one_star_complete_num,rp.two_star_num,"
			+ " rp.two_star_complete_num,rp.three_star_num,rp.three_star_complete_num,rp.should_create_num"
			+ " from rp_health_record rp %2$s) t on t.orgCode =org.organ_code where 1=1 %3$s)"
			+ " GROUP BY rollup(%1$s) %6$s ORDER BY %1$s"
			+ " )rr";
	
	private static final String MODIFY_TRACE_SQL = "select * from("
			+ " select %7$s"
			+ " decode(grouping_id(%1$s), %5$s, %4$s) AS %4$s,"
			+ " nvl(sum(modify_num),0) modify_num,nvl(max(doctor_num),0)doctor_num,"
			+ " nvl(round(nvl(sum(modify_num),0)/nullif(nvl(max(doctor_num),0),0),0),0) lv"
			+ " from (select org.gb_code,org.center_code,org.organ_code,org.organ_type, t.*"
			+ " from mdm_organization org"
			+ " left join (select rp.organ_code orgCode,rp_date,"
			+ " rp.modify_num,rp.doctor_num"
			+ " from rp_health_record rp %2$s) t on t.orgCode =org.organ_code where 1=1 %3$s)"
			+ " GROUP BY rollup(%1$s) %6$s ORDER BY %1$s"
			+ " )";
	@Override
	public List<Map<String, Object>> getRpHealthRecordStatistics(Map<String, String> paramMap){
		return this.getBasicStatistics(paramMap, HEALTH_RECORD_SQL, true);
		
	}
	
	@Override
	public List<Map<String, Object>> getModifyTraceStatistics(Map<String, String> paramMap){
		return this.getBasicStatistics(paramMap, MODIFY_TRACE_SQL, false);
		
	}
	
	/**
	 * 检查相关数据的基础函数
	 * @param paramMap
	 * @param conditionSql
	 * @return
	 */
	private List<Map<String, Object>> getBasicStatistics(Map<String, String> paramMap, String conditionSql, boolean flag){
		StringBuilder whereSQL1 = new StringBuilder();
		StringBuilder whereSQL2 = this.getCondition(paramMap);
		String sql = "";
		String genreCode = paramMap.get("genreCode");
		Criteria criteria = this.getCriteria(paramMap, false);
		SqlBuilder.buildWhereStatement(RpHealthRecord.class,whereSQL1, criteria);
		String having = "having grouping_id(gb_code,center_code,organ_code)!=3 and grouping_id(gb_code,center_code,organ_code)!=1";
		
		if(StringUtils.equals("0", genreCode)) {
			sql=String.format(conditionSql, "gb_code",whereSQL1,whereSQL2,"gb_code","1, '合计'","","");
		} else if(StringUtils.equals(OrgGenreCode.STATION.getValue(), genreCode)){
			sql=String.format(conditionSql, "gb_code,center_code,organ_code",whereSQL1,whereSQL2,
					"organ_code","1,'小计', 7, '合计'",having,"gb_code,center_code,");
		} else {
			having = "having grouping_id(gb_code,organ_code)!=1";
			sql=String.format(conditionSql, "gb_code,organ_code",whereSQL1,whereSQL2,"organ_code","1,'小计', 3, '合计'",having,"gb_code,");
		}
		
		return this.getMapList(sql, criteria);
	}
	

	/**
	 * 依据时期并按数量统计查询条件组装
	 * @param paramMap
	 * @return
	 */
	private Criteria getCriteria(Map<String, String> paramMap, boolean flag) {
		Criteria criteria = new Criteria();
		String beginDateStr = paramMap.get("beginDate");
		 Date beginDate = DateUtil.parseSimpleDate(beginDateStr, null);
		if(flag) {
			DateUtil.getCriteriaByDateRange(criteria, "rpDate", beginDate,beginDate);
			String householdType = paramMap.get("householdType");
			 if(ObjectUtil.isNotEmpty(householdType)){
				 criteria.add("rpType", householdType);
		        }
		} else {
			String endDateStr = paramMap.get("endDate");
			Date endDate = DateUtil.parseSimpleDate(endDateStr, null);
			DateUtil.getCriteriaByDateRange(criteria, "rpDate", beginDate,endDate);
		}
        
		return criteria;
	}
	
	/**
	 * 依据机构并按数量统计查询条件组装
	 * @param paramMap
	 * @return
	 */
	private StringBuilder getCondition(Map<String, String> paramMap) {
		StringBuilder whereSQL = new StringBuilder();
        String superOrganCode = paramMap.get("superOrganCode");//中心、市级医院
        String organCode = paramMap.get("organCode");//站
        String gbCode = paramMap.get("gbCode");// 镇
        String genreCode = paramMap.get("genreCode");
        
        if(ObjectUtil.isNotEmpty(genreCode) && !StringUtils.equals("0", genreCode)){
        	whereSQL.append(" and organ_Type= '" + genreCode + "'");
        }
        if(ObjectUtil.isNotEmpty(superOrganCode) && ObjectUtil.isNullOrEmpty(organCode)){
        	whereSQL.append(" and organ_Code= '" + superOrganCode + "'");
        }
        if(ObjectUtil.isNotEmpty(organCode)){
        	whereSQL.append(" and organ_Code= '" + organCode + "'");
        }
        if(ObjectUtil.isNotEmpty(gbCode)){
        	whereSQL.append(" and GB_CODE= '" + gbCode + "'");
        }
        return whereSQL;
	}
}