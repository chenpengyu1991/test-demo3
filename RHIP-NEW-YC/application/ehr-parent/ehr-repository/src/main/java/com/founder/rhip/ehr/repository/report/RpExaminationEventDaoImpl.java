package com.founder.rhip.ehr.repository.report;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.report.RpExaminationEvent;
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
@Repository("rpExaminationEventDao")
public class RpExaminationEventDaoImpl extends AbstractDao<RpExaminationEvent, Long> implements IRpExaminationEventDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;/*gb_code,center_code,*/
	
	private static final String EXAM_EVENT_SQL = "WITH examination AS ( SELECT organ_code, rp_date, r.examination_detail_code,r.result_low,r.result_high,r.examination_num "
			+ " FROM rp_examination r %2$s),"
			+ " allr AS (select * from (select t.organ_code,t.rp_date from examination t group by t.organ_code, t.rp_date)),"
			+ " bai AS (select * from (select t.organ_code, t.rp_date,sum(t.result_high)result_high,sum(t.result_low)result_low,sum(t.examination_num)examination_num"
			+ " from examination t where t.examination_detail_code='1010030101' group by t.organ_code,t.rp_date)),"
			+ " hong AS (select * from (select t.organ_code, t.rp_date,sum(t.result_high)result_high,sum(t.result_low)result_low,sum(t.examination_num)examination_num"
			+ " from examination t where t.examination_detail_code='1010020101' group by t.organ_code,t.rp_date)),"
			+ " xiao AS (select * from (select t.organ_code, t.rp_date,sum(t.result_high)result_high,sum(t.result_low)result_low,sum(t.examination_num)examination_num"
			+ " from examination t where t.examination_detail_code='1010190101' group by t.organ_code,t.rp_date))"
			+ " select * from("
			+ " select %7$s"
			+ " decode(grouping_id(%1$s), %5$s, %4$s) AS %4$s,"
			+ " nvl(sum(bresult_high),0)bresult_high,nvl(sum(bresult_low),0)bresult_low,nvl(sum(bexamination_num),0)bexamination_num,"
			+ " nvl(sum(hresult_high),0)hresult_high,nvl(sum(hresult_low),0)hresult_low,nvl(sum(hexamination_num),0)hexamination_num,"
			+ " nvl(sum(xresult_high),0)xresult_high,nvl(sum(xresult_low),0)xresult_low,nvl(sum(xexamination_num),0)xexamination_num,"
			+ " decode(nvl(sum(bexamination_num),0), 0,0,cast((nvl(sum(bresult_high),0)+nvl(sum(bresult_low),0))/sum(bexamination_num)as decimal(18,4)))bbi,"
			+ " decode(nvl(sum(hexamination_num),0), 0,0,cast((nvl(sum(hresult_high),0)+nvl(sum(hresult_low),0))/sum(hexamination_num)as decimal(18,4)))hbi,"
			+ " decode(nvl(sum(xexamination_num),0), 0,0,cast((nvl(sum(xresult_high),0)+nvl(sum(xresult_low),0))/sum(xexamination_num)as decimal(18,4)))xbi"
			+ " from (select org.gb_code,org.center_code,org.organ_code,org.organ_type, t.*"
			+ " from mdm_organization org"
			+ " left join (select allr.organ_code orgCode,allr.rp_date,"
			+ "	bai.result_high bresult_high, bai.result_low bresult_low,bai.examination_num bexamination_num,"
			+ " hong.result_high hresult_high, hong.result_low hresult_low,hong.examination_num hexamination_num,"
			+ " xiao.result_high xresult_high, xiao.result_low xresult_low,xiao.examination_num xexamination_num"
			+ "	from allr"
			+ "	left join bai on  allr.organ_code = bai.organ_code and allr.rp_date=bai.rp_date "
			+ " left join hong on  allr.organ_code = hong.organ_code and allr.rp_date=hong.rp_date "
			+ " left join xiao on  allr.organ_code = xiao.organ_code and allr.rp_date=xiao.rp_date) t "
			+ " on t.orgCode =org.organ_code where 1 = 1 %3$s)"
			+ " GROUP BY rollup(%1$s) %6$s ORDER BY %1$s"
			+ " )";
	
	@Override
	public List<Map<String, Object>> getExaminationEventStatistics(Map<String, String> paramMap){
		return this.getBasicStatistics(paramMap, EXAM_EVENT_SQL);
		
	}
	
	/**
	 * 检查相关数据的基础函数
	 * @param paramMap
	 * @param conditionSql
	 * @return
	 */
	private List<Map<String, Object>> getBasicStatistics(Map<String, String> paramMap, String conditionSql){
		StringBuilder whereSQL1 = new StringBuilder();
		StringBuilder whereSQL2 = this.getCondition(paramMap);
		String sql = "";
		String genreCode = paramMap.get("genreCode");
		Criteria criteria = this.getCriteria(paramMap);
		SqlBuilder.buildWhereStatement(RpExaminationEvent.class,whereSQL1, criteria);
		
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
	private Criteria getCriteria(Map<String, String> paramMap) {
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