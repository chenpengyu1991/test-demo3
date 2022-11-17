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
import com.founder.rhip.mdm.common.OrgGenreCode;

/**
 * DAO implement of RpInhospital
 * 
 */
@Repository("rpInhospitalDao")
public class RpInhospitalDaoImpl extends AbstractDao<RpInhospital, Long> implements IRpInhospitalDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;/*gb_code,center_code,*/
	
	private static final String INPATIENT_RECORD_QUALITY_SQL = "select * from("
			+ " select %7$s"
			+ " decode(grouping_id(%1$s), %5$s, %4$s) AS %4$s,"
			+ " sum(NVL(case_num, 0))case_num,sum(NVL(a_case_num, 0))a_case_num,"
			+ " sum(NVL(b_case_num, 0))b_case_num,sum(NVL(c_case_num, 0))c_case_num"
			+ " from (select org.gb_code,org.center_code,org.organ_code,org.organ_type, t.*"
			+ " from mdm_organization org"
			+ " left join (select rp.organ_code orgCode,rp.case_num,rp.a_case_num,rp.b_case_num,rp.c_case_num"
			+ " from rp_inhospital rp %2$s) t on t.orgCode =org.organ_code where 1=1 %3$s)"
			+ " GROUP BY rollup(%1$s) %6$s ORDER BY %1$s"
			+ " )";
	
	private static final String IN_OUT_HOSPITAL_SQL = "select * from("
			+ " select %7$s"
			+ " decode(grouping_id(%1$s), %5$s, %4$s) AS %4$s,"
			+ " sum(NVL(in_num, 0))in_num,sum(NVL(be_num, 0))be_num,sum(NVL(leave_num, 0))leave_num,"
			+ " sum(NVL(inhospital_day, 0))inhospital_day,sum(NVL(personal_fee, 0))personal_fee,NVL(max(doctor_num),0)doctor_num,"
			+ " sum(NVL(operation_num, 0))operation_num,sum(NVL(anesthesia_num, 0))anesthesia_num,"
			+ " sum(NVL(cooperative_medical_fee, 0))cooperative_medical_fee,sum(NVL(fee_total, 0))fee_total"
			+ " from (select org.gb_code,org.center_code,org.organ_code,org.organ_type, t.*"
			+ " from mdm_organization org"
			+ " left join (select rp.organ_code orgCode,rp.in_num,rp.be_num,rp.leave_num,"
			+ "	rp.inhospital_day,rp.personal_fee,rp.cooperative_medical_fee,rp.fee_total,rp.doctor_num,"
			+ " rp.anesthesia_num,rp.operation_num"
			+ " from rp_inhospital rp %2$s) t on t.orgCode =org.organ_code where 1=1 %3$s)"
			+ " GROUP BY rollup(%1$s) %6$s ORDER BY %1$s"
			+ " )";
	
	private static final String CLINICAL_PATHWAY_SQL = "select * from("
			+ " select %7$s"
			+ " decode(grouping_id(%1$s), %5$s, %4$s) AS %4$s,"
			+ " sum(NVL(clinical_pathway_num, 0))clinical_pathway_num,sum(NVL(outcp_num, 0))outcp_num,"
			+ " sum(NVL(complete_cp_num, 0))complete_cp_num,sum(NVL(cure_cp_num, 0))cure_cp_num,"
			+ " sum(NVL(death_cp_num, 0))death_cp_num"
			+ " from (select org.gb_code,org.center_code,org.organ_code,org.organ_type, t.*"
			+ " from mdm_organization org"
			+ " left join (select rp.organ_code orgCode,rp.clinical_pathway_num,rp.outcp_num,"
			+ "	rp.complete_cp_num,rp.cure_cp_num,rp.death_cp_num"
			+ " from rp_inhospital rp %2$s) t on t.orgCode =org.organ_code where 1=1 %3$s)"
			+ " GROUP BY rollup(%1$s) %6$s ORDER BY %1$s"
			+ " )";
	
	private static final String INHOSPITAL_PERFORMANCE_SQL = "select %7$s %4$s,"
			+ " nvl(round(leave_num / nullif(doctor_num, 0), 0), 0)leave_num,"
			+ " nvl(round(inhospital_day / nullif(doctor_num, 0), 0), 0)inhospital_day,"
			+ " nvl(round(fee_total / nullif(doctor_num, 0), 0), 0)fee_total"
			+ " from("
			+ " select %7$s"
			+ " decode(grouping_id(%1$s), %5$s, %4$s) AS %4$s,"
			+ " sum(NVL(doctor_num, 0))doctor_num,"
			+ " sum(NVL(leave_num, 0))leave_num,sum(NVL(inhospital_day, 0))inhospital_day,"
			+ " sum(NVL(fee_total, 0))fee_total"
			+ " from (select org.gb_code,org.center_code,org.organ_code,org.organ_type, t.*"
			+ " from mdm_organization org"
			+ " left join (select rp.organ_code orgcode,rp.doctor_num,rp.leave_num,"
			+ " rp.inhospital_day,rp.fee_total"
			+ " from rp_inhospital rp %2$s) t on t.orgCode =org.organ_code where 1=1 %3$s)"
			+ " GROUP BY rollup(%1$s) %6$s ORDER BY %1$s"
			+ " )";
	
	
	/**
	 * 病案数量统计
	 * @param paramMap
	 * @return
	 */
	@Override
	public List<RpInhospital> getInhosMedicalRecordQualityStatistics(Map<String, String> paramMap) {
		return this.getBasicStatistics(paramMap, INPATIENT_RECORD_QUALITY_SQL);
	}
	
	/**
	 * 查询出入院相关的数据
	 * @param paramMap
	 * @return
	 */
	@Override
	public List<RpInhospital> getInOrOutHospitalStatistics(Map<String, String> paramMap) {
		return this.getBasicStatistics(paramMap, IN_OUT_HOSPITAL_SQL);
	}
	
	/**
     * 临床路径
     * @param paramMap
     * @return
     */
	@Override
	public List<RpInhospital> getClinicalPathwayStatistics(Map<String, String> paramMap){
		return this.getBasicStatistics(paramMap, CLINICAL_PATHWAY_SQL);
	}
	
	/**
	 * 住院服务绩效考核
	 * @param paramMap
	 * @return
	 */
	@Override
	public List<RpInhospital> getRpInhospitalPerformanceOrg(Map<String, String> paramMap){
		return this.getBasicStatistics(paramMap, INHOSPITAL_PERFORMANCE_SQL);
	}
	
	/**
	 * 统计住院出院相关数据的基础函数
	 * @param paramMap
	 * @param conditionSql
	 * @return
	 */
	private List<RpInhospital> getBasicStatistics(Map<String, String> paramMap, String conditionSql){
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
	
	/**
	 * 综合管理首页住院统计(住院)
	 * @param criteria
	 * @return
	 */
	public Map<String, Object> statisticsFeeInhospital(String dateStr, String dateFormater){
		String sql = "select dd.*,ddd.*,round(nvl(fee_total / nullif(leave_num, 0), 0), 2) percent "
				+ " from (select nvl(sum(nvl(t.leave_num, 0)), 0) leave_num,nvl(sum(nvl(t.personal_fee,0)),0)personal_fee,"
				+ " nvl(sum(nvl(t.cooperative_medical_fee,0)),0)cooperative_medical_fee,nvl(sum(nvl(t.fee_total,0)),0)fee_total"
				+ " from rp_inhospital t where to_char(t.rp_date, '%1$s') = '%2$s')dd,"
				+ " (select nvl(sum(nvl(e.medicine_fee,0)),0) + nvl(sum(nvl(e.chinese_medicine_fee,0)),0) + nvl(sum(nvl(e.western_medicine_fee,0)),0) expenseFee"
				+ " from rp_expense e  where to_char(e.rp_date,'%1$s')='%2$s' and e.rp_type ='3')ddd";
		
		sql = String.format(sql, dateFormater,dateStr);
		return getMap(sql, new Criteria());
	}
}