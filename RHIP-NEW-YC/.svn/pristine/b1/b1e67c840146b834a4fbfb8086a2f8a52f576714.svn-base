package com.founder.rhip.ehr.repository.report;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.report.RpInhospital;
import com.founder.rhip.ehr.entity.report.RpTreatmentQuality;
import com.founder.rhip.mdm.common.OrgGenreCode;

/**
 * DAO implement of RpInhospital
 * 
 */
@Repository("rpTreatmentQualityDao")
public class RpTreatmentQualityDaoImpl extends AbstractDao<RpTreatmentQuality, Long> implements IRpTreatmentQualityDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;/*gb_code,center_code,*/
	
	private static final String TREATMENT_QUALITY_SQL = "select * from("
			+ " select %7$s"
			+ " decode(grouping_id(%1$s), %5$s, %4$s) AS %4$s,"
			+ " sum(nvl(inhospital_death_num, 0))inhospital_death_num,sum(nvl(auto_leave_num, 0))auto_leave_num,"
			+ " sum(nvl(inhospital_surgery_num, 0))inhospital_surgery_num,sum(nvl(operative_death_num, 0))operative_death_num,"
			+ " sum(nvl(critical_rescue_num, 0))critical_rescue_num,sum(nvl(critical_death_num, 0))critical_death_num,"
			+ " sum(nvl(neonatal_death_num, 0))neonatal_death_num,sum(nvl(newborn_num, 0))newborn_num"
			+ " from (select org.gb_code,org.center_code,org.organ_code,org.organ_type, t.*"
			+ " from mdm_organization org"
			+ " left join (select rp.organ_code orgCode,"
			+ " rp.inhospital_death_num,rp.auto_leave_num,rp.inhospital_surgery_num,rp.operative_death_num,"
			+ " rp.critical_rescue_num,rp.critical_death_num,rp.neonatal_death_num,rp.newborn_num"
			+ " from rp_treatment_quality rp %2$s) t on t.orgCode =org.organ_code where 1=1 %3$s)"
			+ " GROUP BY rollup(%1$s) %6$s ORDER BY %1$s"
			+ " )";
	
	/**
	 * 统计住院出院相关数据的基础函数
	 * @param paramMap
	 * @param conditionSql
	 * @return
	 */
	private List<RpTreatmentQuality> getBasicStatistics(Map<String, String> paramMap, String conditionSql){
		StringBuilder whereSQL1 = new StringBuilder();
		StringBuilder whereSQL2 = this.getCondition(paramMap);
		String sql = "";
		String genreCode = paramMap.get("genreCode");
		Criteria criteria = this.getCriteria(paramMap);
		SqlBuilder.buildWhereStatement(RpInhospital.class,whereSQL1, criteria);
		
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
		
		return this.getList(sql, criteria);
	}
	

	/**
	 * 依据时期并按数量统计查询条件组装
	 * @param paramMap
	 * @return
	 */
	private Criteria getCriteria(Map<String, String> paramMap){
		Criteria criteria = new Criteria();
		String beginDateStr = paramMap.get("beginDate");
        String endDateStr = paramMap.get("endDate");
        Date beginDate = DateUtil.parseSimpleDate(beginDateStr, null);
		Date endDate = DateUtil.parseSimpleDate(endDateStr, null);
		DateUtil.getCriteriaByDateRange(criteria, "rpDate", beginDate,endDate);
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

	@Override
	public List<RpTreatmentQuality> getRpTreatmentQualityStatistics(
			Map<String, String> paramMap) {
		return this.getBasicStatistics(paramMap, TREATMENT_QUALITY_SQL);
	}
}