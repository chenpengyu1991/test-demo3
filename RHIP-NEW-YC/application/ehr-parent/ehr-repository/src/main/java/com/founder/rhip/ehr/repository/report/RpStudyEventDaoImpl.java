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
import com.founder.rhip.ehr.entity.report.RpStudyEvent;
import com.founder.rhip.mdm.common.OrgGenreCode;

/**
 * DAO implement of RpStudyEvent
 * 
 */
@Repository("rpStudyEventDao")
public class RpStudyEventDaoImpl extends AbstractDao<RpStudyEvent, Long> implements IRpStudyEventDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;/*gb_code,center_code,*/
	
	private static final String STUDY_EVENT_SQL = "WITH STUDY AS ( SELECT organ_code, rp_date, study_code,study_num FROM rp_study_event %2$s),"
			+ " allr AS (select * from (select t.organ_code,t.rp_date from STUDY t group by t.organ_code,t.rp_date)),"
			+ " BUS AS (select * from (select t.organ_code,t.rp_date,sum(t.study_num) count_bus from STUDY t where t.study_code='BUS' group by t.organ_code,t.rp_date)),"
			+ " ct AS(select * from(select t.organ_code,t.rp_date,sum(t.study_num) count_ct from STUDY t where t.study_code='CT' group by t.organ_code,t.rp_date)),"
			+ " ecg AS(select * from(select t.organ_code,t.rp_date,sum(t.study_num) count_ecg from STUDY t where t.study_code='ECG' group by t.organ_code,t.rp_date)),"
			+ " cxr AS(select * from(select t.organ_code,t.rp_date,sum(t.study_num) count_cxr from STUDY t where t.study_code='CXR' group by t.organ_code,t.rp_date))"
			+ " select * from("
			+ " select %7$s"
			+ " decode(grouping_id(%1$s), %5$s, %4$s) AS %4$s,"
			+ " sum(count_bus)count_bus,sum(count_ct)count_ct,sum(count_ecg)count_ecg,sum(count_cxr)count_cxr"
			+ " from (select org.gb_code,org.center_code,org.organ_code,org.organ_type, t.*"
			+ " from mdm_organization org"
			+ " left join (select allr.organ_code orgCode,allr.rp_date,bus.count_bus,"
			+ "	ct.count_ct,ecg.count_ecg,cxr.count_cxr from allr"
			+ "	left join bus on  allr.organ_code = bus.organ_code and allr.rp_date=bus.rp_date"
			+ " left join ct on  allr.organ_code = ct.organ_code and allr.rp_date=ct.rp_date"
			+ " left join ecg on  allr.organ_code = ecg.organ_code and allr.rp_date=ecg.rp_date"
			+ " left join cxr on  allr.organ_code = cxr.organ_code and allr.rp_date=cxr.rp_date"
			+ " ) t on t.orgCode =org.organ_code where 1 = 1 %3$s)"
			+ " GROUP BY rollup(%1$s) %6$s ORDER BY %1$s"
			+ " )";
	
	@Override
	public List<RpStudyEvent> getStudyEventStatistics(Map<String, String> paramMap){
		return this.getBasicStatistics(paramMap, STUDY_EVENT_SQL);
		
	}
	
	/**
	 * 检查相关数据的基础函数
	 * @param paramMap
	 * @param conditionSql
	 * @return
	 */
	private List<RpStudyEvent> getBasicStatistics(Map<String, String> paramMap, String conditionSql){
		StringBuilder whereSQL1 = new StringBuilder();
		StringBuilder whereSQL2 = this.getCondition(paramMap);
		String sql = "";
		String genreCode = paramMap.get("genreCode");
		Criteria criteria = this.getCriteria(paramMap);
		SqlBuilder.buildWhereStatement(RpStudyEvent.class,whereSQL1, criteria);
		
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
}