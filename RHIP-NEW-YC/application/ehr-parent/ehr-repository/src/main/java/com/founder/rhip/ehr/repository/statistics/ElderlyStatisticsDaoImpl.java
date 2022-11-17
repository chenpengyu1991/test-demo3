package com.founder.rhip.ehr.repository.statistics;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.founder.fasf.util.ObjectUtil;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.dto.ElderlyStatistical;
@Repository("elderlyStatisticalDao")
public class ElderlyStatisticsDaoImpl extends AbstractDao<ElderlyStatistical, Long> implements IElderlyStatisticalDao{
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	private static final String HEALTH_VIDEO_SQL3="select sum(t.resident_Num) resident_Num, count(t.samsung_Num) samsung_Num, count(t.towstar_Num) towstar_Num,count(t.health_Management_Num) health_Management_Num,t.org_code org_code,t.center_organ_code CENTER_ORG_CODE,t.gbcode GB_CODE from ("
			+" SELECT null resident_Num, b1.id samsung_Num, null towstar_Num,b1.INPUT_ORGAN_CODE ORG_CODE,b1.input_center_organ_code center_organ_code,b1.input_gbcode gbcode,b1.INPUT_DATE INPUT_DATE, null health_Management_Num "
			+" FROM  SY_PHB_BI_PERSON_INFO  b1 WHERE  b1.FILING_FLAG in('1') and (b1.is_delete ='0' or b1.is_delete is null)  AND b1.STAR = 3 %1$s unionflag1 ";
	private static final String HEALTH_VIDEO_SQL4="select sum(t.resident_Num) resident_Num,count(t.samsung_Num) samsung_Num, count(t.towstar_Num) towstar_Num,count(t.health_Management_Num) health_Management_Num,t.ORG_CODE ORG_CODE from ("
			+" SELECT null resident_Num, b1.id samsung_Num, null towstar_Num,b1.INPUT_ORGAN_CODE ORG_CODE,b1.INPUT_DATE INPUT_DATE, null health_Management_Num "
			+" FROM  SY_PHB_BI_PERSON_INFO  b1 WHERE  b1.FILING_FLAG in('1') and (b1.is_delete ='0' or b1.is_delete is null) AND b1.STAR = 3 %1$s unionflag1 ";
	private static final String HEALTH_VIDEO_SQL5=" union all SELECT null resident_Num, null samsung_Num, b2.id towstar_Num,b2.INPUT_ORGAN_CODE  ORG_CODE,b2.INPUT_DATE INPUT_DATE,null health_Management_Num "
			+" FROM SY_PHB_BI_PERSON_INFO b2 WHERE b2.FILING_FLAG in('1') and (b2.is_delete ='0' or b2.is_delete is null) AND b2.STAR >= 2 %1$s"
			+" unionflag2) t "
			+" group by t.ORG_CODE";
	private static final String HEALTH_VIDEO_SQL7=" union all SELECT null resident_Num, null samsung_Num, b2.id towstar_Num,b2.INPUT_ORGAN_CODE  ORG_CODE,b2.input_center_organ_code center_organ_code,b2.input_gbcode gbcode,b2.INPUT_DATE INPUT_DATE,null health_Management_Num "
			+" FROM SY_PHB_BI_PERSON_INFO b2 WHERE b2.FILING_FLAG in ('1') and (b2.is_delete ='0' or b2.is_delete is null) AND b2.STAR >= 2 %1$s"
			+" unionflag2) t group by t.ORG_CODE,t.center_organ_code,t.gbcode order by t.gbcode,t.center_organ_code,t.ORG_CODE";
	private static final String HEALTH_VIDEO_SQL6=" union all select null resident_Num, null samsung_Num, null towstar_Num,b3.INPUT_ORGAN_CODE  ORG_CODE , b3.input_center_organ_code center_organ_code,b3.input_gbcode gbcode,b3.INPUT_DATE INPUT_DATE,m.person_id  health_Management_Num  "
			+ "	from (select distinct(p.person_id) person_id\n" +
			"          from MS_PHYSIQUE_EXAMINATION p\n" +
			"         where (p.hemoglobin_Value is not null or\n" +
			"               p.leukocyte_Count is not null or\n" +
			"               p.platelet_Count is not null or\n" +
			"               p.blood_Routine_Other_Desc is not null)\n" +
			"           and (p.urine_Pro_Quantitative_Value is not null or\n" +
			"               p.urine_Sug_Quantitative_Value is not null or\n" +
			"               p.ket_Quantitative_Value is not null or\n" +
			"               p.ery_Quantitative_Value is not null or\n" +
			"               p.urine_Routines_Other_Desc is not null)\n" +
			"           and (p.serum_Gpt_Value is not null or\n" +
			"               p.serum_Ast_Value is not null or\n" +
			"               p.total_Bilirubin is not null)\n" +
			"           and (p.creatinine is not null or\n" +
			"               p.blood_Urea_Nitrogen_Value is not null)\n" +
			"           and (p.fpg_Mmol is not null or FPG_MG is not null)\n" +
			"           and (p.tc is not null or p.triglyceride_Value is not null or\n" +
			"               p.ldlc_Detect_Value is not null or\n" +
			"               p.hdlc_Detect_Value is not null)\n" +
			"           and (p.ecg_Anomaly_Flag is not null and p.ecg_Anomaly_Flag <> 2)\n" +
			"           and (p.bmode_Anomalyf_Flag is not null and\n" +
			"               p.bmode_Anomalyf_Flag <> 2)\n" +
			"           and (p.abdominal_Tenderness_Flag is not null or\n" +
			"               p.abdominal_Mass_Flag is not null or\n" +
			"               p.liver_Flag is not null or p.splenomegaly_Flag is not null)\n" +
			"           and (p.is_delete = '0' or p.is_delete is null)) m inner join SY_PHB_BI_PERSON_INFO b3 on m.person_id=b3.id  where b3.filing_flag in('1')  and (b3.is_delete ='0' or b3.is_delete is null) \n" +
			" %1$s unionflag3";

	public static final String ORG_CODE = "orgCode";
	public static final String CENTER_ORG_CODE = "centerOrgCode";
	public static final String GBCODE = "gbcode";

	// 时间字段
	public static final String ACTIVE_TIME = "ACTIVE_TIME";
	public static final String RESOURCE_RECORD_TIME = "RESOURCE_RECORD_TIME";
	public static final String USE_TIME = "USE_TIME";
	public static final String ISSUE_TIME = "ISSUE_TIME";
	public static final String CREATE_TIME = "CREATE_TIME";

	@Override
	public ElderlyStatistical getElderlyStatistical(Criteria criteria) {
		String orgCode=(String)criteria.get("orgCode");
		String month=(String)criteria.get("month");
		String year = (String)criteria.get("year");
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		String birthday = "";
		//先将要格式化的字符串转为Date类型
		birthday = dateFormat.format (criteria.get("birthday"));
		Map<String, Object> map = SqlBuilder.buildOrganConditions("b3.INPUT_ORGAN_CODE","b3.INPUT_DATE","b3.birthday",null,null,orgCode, year,month,birthday,null,new MapSqlParameterSource(), 1);
		String finalSql = String.format(HEALTH_VIDEO_SQL6, map.get(SqlBuilder.WHERE));
		map = SqlBuilder.buildOrganConditions("b2.INPUT_ORGAN_CODE","b2.INPUT_DATE","b2.birthday",null,null,orgCode, year,month,birthday,null,(MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 1);
		String finalSql2 = String.format(HEALTH_VIDEO_SQL5, map.get(SqlBuilder.WHERE));

		finalSql2=finalSql2.replace("unionflag2", finalSql);

		map = SqlBuilder.buildOrganConditions("b1.INPUT_ORGAN_CODE","b1.INPUT_DATE","b1.birthday",null,null,orgCode, year,month,birthday,null,(MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 1);
		String finalSql3 = String.format(HEALTH_VIDEO_SQL4, map.get(SqlBuilder.WHERE));

		finalSql3=finalSql3.replace("unionflag1", finalSql2).replace("unionflag3", "union all"
				+ " SELECT (nvl(bp.HOUSEHOLD_GREAT_SIXF_NUM,0)+nvl(bp.UN_HOUSEHOLD_GREAT_SIXF_NUM,0)) resident_Num, "
				+ " null samsung_Num, null towstar_Num,bp.ORGAN_CODE  ORG_CODE,null INPUT_DATE,null health_Management_Num  FROM SY_PHB_BI_POPULACE bp where bp.COUNT_YEAR='"+year+"' and (bp.is_delete ='0' or bp.is_delete is null) and bp.ORGAN_CODE='"+orgCode+"'");


		return get(ElderlyStatistical.class, finalSql3, (MapSqlParameterSource) map.get(SqlBuilder.SOURCE));
	}

	@Override
	public List<ElderlyStatistical> getElderlyStatisticalSum(Criteria criteria, List<String> organCodeList) {
		String orgCode=(String)criteria.get("orgCode");
		String month=(String)criteria.get("month");
		String year = (String)criteria.get("year");
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		String birthday = "";
		//先将要格式化的字符串转为Date类型
		birthday = dateFormat.format (criteria.get("birthday"));
		//然后再格式化


		//Date birthday=DateUtil.convert("yyyy-MM-dd hh:mm:ss", criteria.get("birthday").toString());
		Map<String, Object> map = SqlBuilder.buildOrganConditions("b3.INPUT_ORGAN_CODE","b3.INPUT_DATE","b3.birthday",null, null,orgCode, year,month,birthday,organCodeList, new MapSqlParameterSource(), 1);
		String finalSql = String.format(HEALTH_VIDEO_SQL6, map.get(SqlBuilder.WHERE));

		map = SqlBuilder.buildOrganConditions("b2.INPUT_ORGAN_CODE","b2.INPUT_DATE","b2.birthday",null,null,orgCode, year,month,birthday,organCodeList,(MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 1);
		String finalSql2 = String.format(HEALTH_VIDEO_SQL7, map.get(SqlBuilder.WHERE));

		finalSql2=finalSql2.replace("unionflag2", finalSql);

		map = SqlBuilder.buildOrganConditions("b1.INPUT_ORGAN_CODE","b1.INPUT_DATE","b1.birthday",null,null,orgCode, year,month,birthday,organCodeList,(MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 1);
		String finalSql3 = String.format(HEALTH_VIDEO_SQL3, map.get(SqlBuilder.WHERE));
		String str="";
		for (int i = 0; i < organCodeList.size(); i++) {
			if(i<organCodeList.size()){
				str=str+",'"+organCodeList.get(i)+"'";
			}
		}
		str=str.replaceFirst(",", "");
		finalSql3=finalSql3.replace("unionflag1", finalSql2).replace("unionflag3", "union all"
				+ " SELECT (nvl(bp.HOUSEHOLD_GREAT_SIXF_NUM,0)+nvl(bp.UN_HOUSEHOLD_GREAT_SIXF_NUM,0)) resident_Num,"
				+ " null samsung_Num, null towstar_Num,bp.ORGAN_CODE  ORG_CODE,bp.organ_parent_code center_organ_code,bp.gbcode gbcode,null INPUT_DATE,null health_Management_Num FROM SY_PHB_BI_POPULACE bp where bp.COUNT_YEAR='"+year+"' and (bp.is_delete ='0' or bp.is_delete is null) and bp.ORGAN_CODE in("+str+")");

		return getList(ElderlyStatistical.class, finalSql3, (MapSqlParameterSource) map.get(SqlBuilder.SOURCE));
	}

	@Override
	public List<ElderlyStatistical> getElderlyStatisticalSum1(Criteria criteria, List<String> organCodeList) {
		String HEALTH_VIDEO_SQL3="select sum(t.resident_Num) resident_Num, count(t.samsung_Num) samsung_Num, count(t.towstar_Num) towstar_Num,count(t.health_Management_Num) health_Management_Num,t.center_organ_code ORG_CODE,t.gbcode GB_CODE from ("
				+" SELECT null resident_Num, b1.id samsung_Num, null towstar_Num,b1.INPUT_ORGAN_CODE ORG_CODE,b1.input_center_organ_code center_organ_code,b1.input_gbcode gbcode,b1.INPUT_DATE INPUT_DATE, null health_Management_Num "
				+" FROM  SY_PHB_BI_PERSON_INFO  b1 WHERE  b1.FILING_FLAG in('1') and (b1.is_delete ='0' or b1.is_delete is null)  AND b1.STAR = 3 %1$s unionflag1 ";
		String HEALTH_VIDEO_SQL6=" union all select null resident_Num, null samsung_Num, null towstar_Num,b3.INPUT_ORGAN_CODE  ORG_CODE , b3.input_center_organ_code center_organ_code,b3.input_gbcode gbcode,b3.INPUT_DATE INPUT_DATE,p.id health_Management_Num  "
				+ "	from MS_PHYSIQUE_EXAMINATION p right join SY_PHB_BI_PERSON_INFO b3 on p.person_id=b3.id  and b3.filing_flag in('1')  and (b3.is_delete ='0' or b3.is_delete is null) and (p.is_delete ='0' or p.is_delete is null)"
				+ " where (p.hemoglobin_Value is not null or p.leukocyte_Count is not null or p.platelet_Count is not null or p.blood_Routine_Other_Desc is not null) and "
				+ " (p.urine_Pro_Quantitative_Value is not null or p.urine_Sug_Quantitative_Value is not null "
				+ " or p.ket_Quantitative_Value is not null or p.ery_Quantitative_Value is not null or p.urine_Routines_Other_Desc is not null)"
				+ " and (p.serum_Gpt_Value is not null or p.serum_Ast_Value is not null or p.total_Bilirubin is not null)  "
				+ " and (p.creatinine is not null or p.blood_Urea_Nitrogen_Value is not null)"
				+ " and (p.fpg_Mmol is not null or FPG_MG is not null)"
				+ " and (p.tc is not null or p.triglyceride_Value is not null or p.ldlc_Detect_Value is not null or p.hdlc_Detect_Value is not null)"
				+ " and (p.ecg_Anomaly_Flag is not null and p.ecg_Anomaly_Flag <> 2) and (p.bmode_Anomalyf_Flag is not null and p.bmode_Anomalyf_Flag <> 2)"
				+ " and (p.abdominal_Tenderness_Flag is not null or  p.abdominal_Mass_Flag is not null or p.liver_Flag is not null or p.splenomegaly_Flag is not null )"
				+ " %1$s unionflag3";
		String HEALTH_VIDEO_SQL7=" union all SELECT null resident_Num, null samsung_Num, b2.id towstar_Num,b2.INPUT_ORGAN_CODE  ORG_CODE,b2.input_center_organ_code center_organ_code,b2.input_gbcode gbcode,b2.INPUT_DATE INPUT_DATE,null health_Management_Num "
				+" FROM SY_PHB_BI_PERSON_INFO b2 WHERE b2.FILING_FLAG in ('1') and (b2.is_delete ='0' or b2.is_delete is null) AND b2.STAR >= 2 %1$s"
				+" unionflag2) t "
				+ "where t.center_organ_code not in('749901','759901','759901','72000001','73000001','74000001','769901')"
				+ "group by t.gbcode,t.center_organ_code order by t.gbcode,t.center_organ_code";
		String orgCode=(String)criteria.get("orgCode");
		String month=(String)criteria.get("month");
		String year = (String)criteria.get("year");
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		String birthday = "";
		//先将要格式化的字符串转为Date类型
		birthday = dateFormat.format (criteria.get("birthday"));
		//然后再格式化


		//Date birthday=DateUtil.convert("yyyy-MM-dd hh:mm:ss", criteria.get("birthday").toString());
		Map<String, Object> map = SqlBuilder.buildOrganConditions("b3.INPUT_ORGAN_CODE","b3.INPUT_DATE","b3.birthday",null, null,orgCode, year,month,birthday,organCodeList, new MapSqlParameterSource(), 1);
		String finalSql = String.format(HEALTH_VIDEO_SQL6, map.get(SqlBuilder.WHERE));

		map = SqlBuilder.buildOrganConditions("b2.INPUT_ORGAN_CODE","b2.INPUT_DATE","b2.birthday",null,null,orgCode, year,month,birthday,organCodeList,(MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 1);
		String finalSql2 = String.format(HEALTH_VIDEO_SQL7, map.get(SqlBuilder.WHERE));

		finalSql2=finalSql2.replace("unionflag2", finalSql);

		map = SqlBuilder.buildOrganConditions("b1.INPUT_ORGAN_CODE","b1.INPUT_DATE","b1.birthday",null,null,orgCode, year,month,birthday,organCodeList,(MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 1);
		String finalSql3 = String.format(HEALTH_VIDEO_SQL3, map.get(SqlBuilder.WHERE));
		String str="";
		for (int i = 0; i < organCodeList.size(); i++) {
			if(i<organCodeList.size()){
				str=str+",'"+organCodeList.get(i)+"'";
			}
		}
		str=str.replaceFirst(",", "");
		finalSql3=finalSql3.replace("unionflag1", finalSql2).replace("unionflag3", "union all"
				+ " SELECT (nvl(bp.HOUSEHOLD_GREAT_SIXF_NUM,0)+nvl(bp.UN_HOUSEHOLD_GREAT_SIXF_NUM,0)) resident_Num,"
				+ " null samsung_Num, null towstar_Num,bp.ORGAN_CODE  ORG_CODE,bp.organ_parent_code center_organ_code,bp.gbcode gbcode,null INPUT_DATE,null health_Management_Num FROM SY_PHB_BI_POPULACE bp where bp.COUNT_YEAR='"+year+"' and (bp.is_delete ='0' or bp.is_delete is null) and bp.ORGAN_CODE in("+str+")");

		return getList(ElderlyStatistical.class, finalSql3, (MapSqlParameterSource) map.get(SqlBuilder.SOURCE));


	}

	@Override
	public List<Map<String, Object>> getElderlyManagementSum(Criteria criteria,List<String> orgCodes) {
		Object year = criteria.get("year"); // 年份
		Object birthday = criteria.get("birthday"); // 生日（格式：2018-02-01）
		Object gbcode = criteria.get("gbcode");
		Object centerOrgCode = criteria.get("centerOrgCode");
		Object orgCode = criteria.get("orgCode");
		Object type = criteria.get("type");
		Object startDate = criteria.get("startDate"); // 开始日期（2018-02-01）
		Object endDate = criteria.get("endDate"); // 结束日期（2018-02-01）
		String orgCodesStr="";
		if(ObjectUtil.isNotEmpty(orgCodes)){
			for (int i = 0; i < orgCodes.size(); i++) {
				if(i<orgCodes.size()){
					orgCodesStr=orgCodesStr+",'"+orgCodes.get(i)+"'";
				}
			}
			orgCodesStr=orgCodesStr.replaceFirst(",", "");
		}

		String sql = commonTopSql;
		String whereSql ="";
		if("1".equals(type)) { // 没有选择了镇，查询镇下的全部中心
			String newSql = String.format(allSql,birthday,startDate,endDate,year);
			sql = newSql;
		} else if("2".equals(type)) { // 选择了镇，但是没有选择中心
			whereSql =" where GB_CODE ='"+gbcode +"' and STATUS= '1' and GENRE_CODE='B100' ";
			sql += String.format(commonOrgTopSql,whereSql) ;
			String newSql = String.format(townSql,birthday,startDate,endDate,year,gbcode,orgCodesStr);
			sql += newSql;
			sql += commonBottomSql;
		} else if("3".equals(type)) { // 镇和中心都选择了，没有选择站
			whereSql =" where (PARENT_CODE ='"+centerOrgCode +"' or ORGAN_CODE = '"+centerOrgCode+"') and STATUS= '1' ";
			sql += String.format(commonOrgTopSql,whereSql) ;
			String newSql = String.format(centerSql,birthday,startDate,endDate,year,centerOrgCode,orgCodesStr);
			sql += newSql;
			sql += commonBottomSql;
		} else if("4".equals(type)) { // 所有的都选择了
			whereSql =" where ORGAN_CODE = '"+orgCode+"' and STATUS= '1' ";
			sql += String.format(commonOrgTopSql,whereSql) ;
			String newSql = String.format(siteSql,birthday,startDate,endDate,year,orgCode,orgCodesStr);
			sql += newSql;
			sql += commonBottomSql;
		}
		return this.getMapList(sql ,new Criteria());
	}

	private final String commonTopSql = "SELECT * from ( select \n"
			+"decode(grouping(org.GB_CODE), 1, '合计', org.GB_CODE) GB_CODE, \n"
			+"decode(grouping(org.ORGAN_CODE), 1, '合计', org.ORGAN_CODE) ORG_CODE, \n"
			+"sum(t.resident_Num)resident_Num, \n"
			+"sum(t.samsung_Num) samsung_Num, \n"
			+"sum(t.towstar_Num) towstar_Num, \n"
			+"sum(t.health_Management_Num) health_Management_Num, \n"
			+"sum(t.jy_reserve) jy_reserve \n"
			+"from ( \n";

	private final String commonOrgTopSql = " select GB_CODE,ORGAN_CODE FROM MDM_ORGANIZATION %1$s ) org LEFT JOIN ( ";


	private final String commonBottomSql = ") select t1.gbcode,t1.resident_Num,t1.SAMSUNG_NUM,t1.TOWSTAR_NUM, \n"
			+"t1.ORG_CODE,t1.CENTER_ORGAN_CODE,t1.INPUT_DATE,t1.HEALTH_MANAGEMENT_NUM,t1.jy_reserve from t1 \n"
			+ " inner join mdm_organization mo on t1.ORG_CODE=mo.organ_code \n " + 
			" where mo.status='1'  \n"
			+"union all \n"
			+"select t2.gbcode,t2.resident_Num,t2.SAMSUNG_NUM,t2.TOWSTAR_NUM, \n"
			+"t2.ORG_CODE,t2.CENTER_ORGAN_CODE,t2.INPUT_DATE,t2.HEALTH_MANAGEMENT_NUM,t2.jy_reserve from t2 \n"
			+ " inner join mdm_organization mo on t2.ORG_CODE=mo.organ_code \n " + 
			" where mo.status='1'  \n"
			+"union all \n"
			+"select t3.gbcode,t3.resident_Num,t3.SAMSUNG_NUM,t3.TOWSTAR_NUM, \n"
			+"t3.ORG_CODE,t3.CENTER_ORGAN_CODE,t3.INPUT_DATE,t3.HEALTH_MANAGEMENT_NUM,t3.jy_reserve from t3 \n"
			+ " inner join mdm_organization mo on t3.ORG_CODE=mo.organ_code \n " + 
			" where mo.status='1'  \n"
			+"union all \n"
			+"select t4.gbcode,t4.resident_Num,t4.SAMSUNG_NUM,t4.TOWSTAR_NUM, \n"
			+"t4.ORG_CODE,t4.CENTER_ORGAN_CODE,t4.INPUT_DATE,t4.HEALTH_MANAGEMENT_NUM,t4.jy_reserve from t4 \n"
			+ " inner join mdm_organization mo on t4.ORG_CODE=mo.organ_code \n " + 
			" where mo.status='1'  \n"
			+"union all \n"
			+"select t5.gbcode,t5.resident_Num,t5.SAMSUNG_NUM,t5.TOWSTAR_NUM, \n"
			+"t5.ORG_CODE,t5.CENTER_ORGAN_CODE,t5.INPUT_DATE,t5.HEALTH_MANAGEMENT_NUM,t5.jy_reserve from t5 \n"
			+ " inner join mdm_organization mo on t5.ORG_CODE=mo.organ_code \n " + 
			" where mo.status='1'  \n"
			+") t on org.ORGAN_CODE =t.ORG_CODE group by rollup(org.GB_CODE,org.ORGAN_CODE) \n"
			+") where org_code <> '合计' or gb_code = '合计' order by gb_code asc";


	// 没有选择过镇的情况
	private final  String allSql = "WITH org AS ( SELECT organ_code, GB_CODE, ORGAN_NAME, genre_code , DECODE(genre_code, 'B200', parent_code, organ_code) AS parent_code FROM mdm_organization WHERE genre_code IN ('B100', 'B200') AND STATUS = 1 ),  " +
			"res AS ( SELECT input_gbcode AS gbcode, 0 AS resident_Num, 0 AS samsung_Num , CASE  WHEN STAR >= '2' THEN 1 ELSE 0 END AS towstar_Num, INPUT_ORGAN_CODE AS ORG_CODE, input_center_organ_code AS center_organ_code, INPUT_DATE AS INPUT_DATE," +
			" 0 AS health_Management_Num , 0 AS jy_reserve FROM bi_person_info WHERE (FILING_FLAG = '1' AND (is_delete = '0' OR is_delete IS NULL) AND STAR >= '2' AND TO_CHAR(birthday, 'yyyy') <= '%1$s' AND TO_CHAR(INPUT_DATE, 'yyyy-mm-dd') <= '%3$s' " +
			"AND input_gbcode IS NOT NULL) UNION ALL SELECT b.input_gbcode AS gbcode, 0 AS resident_Num, 0 AS samsung_Num, 0 AS towstar_Num, b.INPUT_ORGAN_CODE AS ORG_CODE , b.input_center_organ_code AS center_organ_code, b.INPUT_DATE AS INPUT_DATE, 1 AS " +
			"health_Management_Num, 0 AS jy_reserve FROM ECH_PHYSICAL_EXAM_RECORD r LEFT JOIN bi_person_info b ON b.ID = r.person_id LEFT JOIN ECH_ELDERLY_PHY_EXAMINATION ep ON ep.person_id = r.person_id " +
			"WHERE (b.filing_Flag = '1' AND b.STAR = '3' AND ep.id in(SELECT max(id) from ECH_ELDERLY_PHY_EXAMINATION p GROUP BY p.PERSON_ID) AND ep.PHYSICAL_EXAM_TYPE = '31'" +
			"AND TO_CHAR (ep.EXAMINATION_DATE, 'yyyy-mm-dd') >= '%2$s'"+
			"AND TO_CHAR (ep.EXAMINATION_DATE, 'yyyy-mm-dd') <= '%3$s'"+
			" AND ((ep.HEALTH_EVALUATE_ANOMALY_FLAG = '1' OR ep.HEALTH_EVALUATE_ANOMALY_FLAG = '1' OR ep.GUIDE_INTO_CHRONIC_DISEASE = '1' " +
			"OR ep.GUIDE_SUGGESTION_REVIEW = '1' OR ep.GUIDE_SUGGESTION_REFERRAL = '1' OR ep.RISK_QUIT_SMOKING = '1' OR ep.RISK_HEALTH_DRINK = '1' OR ep.RISK_DIET = '1' OR ep.RISK_EXERCISE = '1' OR ep.RISK_WEIGHT_REDUCTION = '1' OR ep.GUIDE_VACCINATION = '1'" +
			" OR ep.RISK_OTHER = '1')) AND (FPG_MMOL IS NOT NULL OR FPG_MG IS NOT NULL) AND ((HEMOGLOBIN_VALUE IS NOT NULL AND LEUKOCYTE_COUNT IS NOT NULL AND PLATELET_COUNT IS NOT NULL)) AND ((URINE_PRO_QUANTITATIVE_VALUE IS NOT NULL AND KET_QUANTITATIVE_VALUE " +
			"IS NOT NULL AND URINE_SUG_QUANTITATIVE_VALUE IS NOT NULL AND ERY_QUANTITATIVE_VALUE IS NOT NULL)) AND ((TC IS NOT NULL AND TRIGLYCERIDE_VALUE IS NOT NULL AND LDLC_DETECT_VALUE IS NOT NULL AND HDLC_DETECT_VALUE IS NOT NULL)) AND ((SERUM_GPT_VALUE IS NOT" +
			" NULL AND SERUM_AST_VALUE IS NOT NULL AND TOTAL_BILIRUBIN IS NOT NULL)) AND (creatinine IS NOT NULL AND BLOOD_UREA_NITROGEN_VALUE IS NOT NULL) AND ((BMODE_ANOMALYF_FLAG = '1' OR BMODE_ANOMALYF_FLAG = '0' OR BMODE_OTHER_ANOMALYF_FLAG = '1' OR BMODE_OTHER_ANOMALYF_FLAG = '0'))" +
			" AND (ECG_ANOMALY_FLAG = '1' OR ECG_ANOMALY_FLAG = '0') AND TO_CHAR(b.INPUT_DATE, 'yyyy-mm-dd') <= '%3$s') UNION ALL SELECT bp.gbcode AS gbcode , NVL(bp.HOUSEHOLD_GREAT_SIXF_NUM, 0) + NVL(bp.UN_HOUSEHOLD_GREAT_SIXF_NUM, 0) AS resident_Num , 0 AS samsung_Num, 0 AS towstar_Num, " +
			"bp.ORGAN_CODE AS ORG_CODE, bp.organ_parent_code AS center_organ_code, NULL AS INPUT_DATE , 0 AS health_Management_Num, 0 AS jy_reserve FROM BI_POPULACE bp WHERE bp.COUNT_YEAR = '%4$s' AND (bp.is_delete = '0' OR bp.is_delete IS NULL) UNION ALL SELECT input_gbcode AS gbcode," +
			" 0 AS resident_Num, 0 AS SAMSUNG_NUM, 0 AS TOWSTAR_NUM, INPUT_ORGAN_CODE AS ORG_CODE , input_center_organ_code AS CENTER_ORGAN_CODE, INPUT_DATE AS INPUT_DATE, 0 AS HEALTH_MANAGEMENT_NUM, 1 AS jy_reserve FROM bi_person_info b " +
			//65岁以上老年人家庭医生签约人数  老年人患者 未解约、已付款 签约生效时间和结束时间在所选时间段内
			"left join SY_FDS_SIGN_PERSON sign on sign.IDCARD = b.IDCARD  WHERE ((b.is_delete = '0' OR b.is_delete IS NULL) " +
			" AND TO_CHAR(b.birthday, 'yyyy') <= '%1$s' AND TO_CHAR(sign.EFFECTIVE_END_DATE, 'yyyy-mm-dd') >= '%2$s' AND TO_CHAR(sign.EFFECTIVE_START_DATE, 'yyyy-mm-dd') <= '%3$s' and sign.RESCIND_FLAG ='0' and sign.PAID_FLAG= '1' ) " +
			" UNION ALL SELECT b.input_gbcode AS gbcode, 0 AS resident_Num, 1 AS samsung_Num, 0 AS towstar_Num, b.INPUT_ORGAN_CODE AS ORG_CODE , b.input_center_organ_code AS center_organ_code, b.INPUT_DATE AS INPUT_DATE," +
			" 0 AS health_Management_Num, 0 AS jy_reserve FROM bi_person_info b " +
			//接受健康体检人数  统计规则:人员表是已建档，体检表中有记录
			"inner JOIN  (select person_id from ECH_ELDERLY_PHY_EXAMINATION where PHYSICAL_EXAM_TYPE = '31' and" +
			" TO_CHAR(EXAMINATION_DATE, 'yyyy-mm-dd') >= '%2$s' AND TO_CHAR(EXAMINATION_DATE, 'yyyy-mm-dd') <= '%3$s'" +
			" group by person_id) ec ON b.ID = ec.person_id WHERE b.filing_Flag = '1' " +
			" ) SELECT org_code, nvl(resident_Num,0) resident_Num,nvl(samsung_Num,0) samsung_Num,nvl(towstar_Num,0) towstar_Num,nvl(health_Management_Num,0) health_Management_Num,nvl(jy_reserve,0) jy_reserve" +
			"  FROM ( SELECT DECODE(GROUPING(ORG.parent_code), 1, '合计', ORG.parent_code) AS org_code , SUM(resident_Num) AS resident_Num, SUM(samsung_Num) AS samsung_Num , SUM(towstar_Num) AS towstar_Num, SUM(health_Management_Num) AS health_Management_Num ," +
			" SUM(jy_reserve) AS jy_reserve FROM org LEFT JOIN res ON RES.org_code = org.organ_code GROUP BY ROLLUP (ORG.parent_code) ) T LEFT JOIN org ON org.organ_code = T.org_code ORDER BY GB_CODE, genre_code, NLSSORT(organ_name, 'NLS_SORT=SCHINESE_PINYIN_M')";


	// 选择了镇，但没有选择中心
	private final String townSql = "with t1 as ( \n"
			+"SELECT input_gbcode gbcode,0 resident_Num, \n"
			+"0 samsung_Num, \n"
			+"case when star>='2' then 1 else 0 end towstar_Num, \n"
			+"INPUT_ORGAN_CODE ORG_CODE, \n"
			+"input_center_organ_code center_organ_code, \n"
			+"INPUT_DATE INPUT_DATE, 0 health_Management_Num,0 jy_reserve  FROM  bi_person_info WHERE \n \n"
			+"FILING_FLAG ='1' \n"
			+"and (is_delete ='0' or is_delete is null) AND STAR >= '2' AND  \n"
			+"TO_CHAR(birthday, 'yyyy') <='%1$s' AND  \n"
//			+"TO_CHAR(INPUT_DATE, 'yyyy-mm-dd') >= '%2$s' and  \n"
			+"TO_CHAR(INPUT_DATE, 'yyyy-mm-dd') <= '%3$s' and  \n"
			+"input_gbcode is not null and input_gbcode='%5$s'\n"
			+"),t2 as ( \n"
			+"select b.input_gbcode gbcode,0 resident_Num, 0 samsung_Num, 0 towstar_Num, \n"
			+"b.INPUT_ORGAN_CODE ORG_CODE , b.input_center_organ_code center_organ_code, \n"
			+"b.INPUT_DATE INPUT_DATE,1 health_Management_Num ,0 jy_reserve \n"
			+"FROM ECH_PHYSICAL_EXAM_RECORD r  \n"
			+"left join bi_person_info b on b.id=r.person_id  \n"
			+"left join ECH_ELDERLY_PHY_EXAMINATION ep on ep.person_id=r.person_id  \n"
			+"where b.filing_Flag = '1' AND b.STAR = '3'  \n"
			+"and ep.id in(SELECT max(id) from ECH_ELDERLY_PHY_EXAMINATION p where p.PHYSICAL_EXAM_TYPE='31' GROUP BY p.PERSON_ID) and ep.PHYSICAL_EXAM_TYPE='31'  \n"
			+"AND TO_CHAR (ep.EXAMINATION_DATE, 'yyyy-mm-dd') >= '%2$s'"
			+"AND TO_CHAR (ep.EXAMINATION_DATE, 'yyyy-mm-dd') <= '%3$s'"
            //接受健康管理人数：原来的公式+指导（指导是包括健康评价+健康指导+危险因素控制的健康指导）
            +"and (ep.HEALTH_EVALUATE_ANOMALY_FLAG = '1' OR ep.GUIDE_INTO_CHRONIC_DISEASE = '1' OR ep.GUIDE_SUGGESTION_REVIEW = '1' OR ep.GUIDE_SUGGESTION_REFERRAL = '1' OR ep.RISK_QUIT_SMOKING = '1' OR ep.RISK_HEALTH_DRINK = '1' OR ep.RISK_DIET = '1' OR ep.RISK_EXERCISE = '1' OR ep.RISK_WEIGHT_REDUCTION = '1' OR ep.GUIDE_VACCINATION = '1' OR ep.RISK_OTHER = '1')  \n"
			+"and (FPG_MMOL is not null or FPG_MG is not null)  \n"
			+"and (HEMOGLOBIN_VALUE is not null and LEUKOCYTE_COUNT is not null and PLATELET_COUNT is not null)  \n"
			+"and (URINE_PRO_QUANTITATIVE_VALUE is not null and KET_QUANTITATIVE_VALUE is not null and URINE_SUG_QUANTITATIVE_VALUE is not null and ERY_QUANTITATIVE_VALUE is not null)  \n"
			+"and (TC is not null and TRIGLYCERIDE_VALUE is not null and LDLC_DETECT_VALUE is not null and HDLC_DETECT_VALUE is not null)  \n"
			+"and (SERUM_GPT_VALUE is not null and SERUM_AST_VALUE is not null and TOTAL_BILIRUBIN is not null)     	 \n"
			+"and (creatinine is not null and BLOOD_UREA_NITROGEN_VALUE is not null)   \n"
			+"and (BMODE_ANOMALYF_FLAG='1' or BMODE_ANOMALYF_FLAG='0' or BMODE_OTHER_ANOMALYF_FLAG='1' or BMODE_OTHER_ANOMALYF_FLAG='0')  \n"
			+"and (ECG_ANOMALY_FLAG='1' or ECG_ANOMALY_FLAG='0')\n"
//			+"and TO_CHAR(b.INPUT_DATE, 'yyyy-mm-dd') >= '%2$s' and  \n"
			+"and TO_CHAR(b.INPUT_DATE, 'yyyy-mm-dd') <= '%3$s' and b.input_gbcode ='%5$s' \n"
			+"),t3 as ( \n"
			+"SELECT bp.gbcode gbcode,(nvl(bp.HOUSEHOLD_GREAT_SIXF_NUM,0)+nvl(bp.UN_HOUSEHOLD_GREAT_SIXF_NUM,0)) resident_Num, \n"
			+"0 samsung_Num, 0 towstar_Num,bp.ORGAN_CODE  ORG_CODE,bp.organ_parent_code center_organ_code, \n"
			+"null INPUT_DATE,0 health_Management_Num,0 jy_reserve FROM BI_POPULACE bp where bp.COUNT_YEAR='%4$s' and  \n"
			+"(bp.is_delete ='0' or bp.is_delete is null) and bp.gbcode='%5$s' \n"
			+"),t4 as ( \n"
			+"select input_gbcode gbcode,0 resident_Num,0 SAMSUNG_NUM,0 TOWSTAR_NUM, \n"
			+"INPUT_ORGAN_CODE ORG_CODE,input_center_organ_code CENTER_ORGAN_CODE, \n"
			+"INPUT_DATE INPUT_DATE,0 HEALTH_MANAGEMENT_NUM, \n"
			+"1 jy_reserve from bi_person_info b " +
			//65岁以上老年人家庭医生签约人数  老年人患者 未解约、已付款 签约生效时间和结束时间在所选时间段内
			"left join SY_FDS_SIGN_PERSON sign on sign.IDCARD = b.IDCARD  WHERE (b.is_delete = '0' OR b.is_delete IS NULL) " +
			" AND TO_CHAR(b.birthday, 'yyyy') <= '%1$s' AND TO_CHAR(sign.EFFECTIVE_END_DATE, 'yyyy-mm-dd') >= '%2$s' AND TO_CHAR(sign.EFFECTIVE_START_DATE, 'yyyy-mm-dd') <= '%3$s' and sign.RESCIND_FLAG ='0' and sign.PAID_FLAG= '1' " +
			" and b.input_gbcode ='%5$s'\n"
			+"),t5 as ( \n"
			+"SELECT b.input_gbcode gbcode, 0 resident_Num, 1 samsung_Num, 0 towstar_Num, b.INPUT_ORGAN_CODE ORG_CODE, b.input_center_organ_code center_organ_code, b.INPUT_DATE INPUT_DATE, 0 health_Management_Num, 0 jy_reserve  \n"
			+"FROM bi_person_info b \n"+
			//接受健康体检人数  统计规则:人员表是已建档，体检表中有记录
			"inner JOIN  (select person_id from ECH_ELDERLY_PHY_EXAMINATION where PHYSICAL_EXAM_TYPE = '31' and" +
			" TO_CHAR(EXAMINATION_DATE, 'yyyy-mm-dd') >= '%2$s' AND TO_CHAR(EXAMINATION_DATE, 'yyyy-mm-dd') <= '%3$s'" +
			" group by person_id) ec ON b.ID = ec.person_id WHERE b.filing_Flag = '1' and input_gbcode = %5$s ";
	// 镇和中心都选择了，但是没有选择站
	private final String centerSql = "with t1 as ( \n"
			+"SELECT input_gbcode gbcode,0 resident_Num, \n"
			+"0 samsung_Num, \n"
			+"case when star>='2' then 1 else 0 end towstar_Num, \n"
			+"INPUT_ORGAN_CODE ORG_CODE, \n"
			+"input_center_organ_code center_organ_code, \n"
			+"INPUT_DATE INPUT_DATE, 0 health_Management_Num,0 jy_reserve  FROM  bi_person_info WHERE \n \n"
			+"FILING_FLAG ='1' \n"
			+"and (is_delete ='0' or is_delete is null) AND STAR >= '2' AND  \n"
			+"TO_CHAR(birthday, 'yyyy') <='%1$s' AND  \n"
//			+"TO_CHAR(INPUT_DATE, 'yyyy-mm-dd') >= '%2$s' and  \n"
			+"TO_CHAR(INPUT_DATE, 'yyyy-mm-dd') <= '%3$s' and  \n"
			+"input_gbcode is not null and (input_center_organ_code = '%5$s' or INPUT_ORGAN_CODE = '%5$s')\n"
			+"),t2 as ( \n"
			+"select b.input_gbcode gbcode,0 resident_Num, 0 samsung_Num, 0 towstar_Num, \n"
			+"b.INPUT_ORGAN_CODE ORG_CODE , b.input_center_organ_code center_organ_code, \n"
			+"b.INPUT_DATE INPUT_DATE,1 health_Management_Num ,0 jy_reserve \n"
			+"FROM ECH_PHYSICAL_EXAM_RECORD r  \n"
			+"left join bi_person_info b on b.id=r.person_id  \n"
			+"left join ECH_ELDERLY_PHY_EXAMINATION ep on ep.person_id=r.person_id  \n"
			+"where b.filing_Flag = '1' AND b.STAR = '3'  \n"
			+"and ep.id in(SELECT max(id) from ECH_ELDERLY_PHY_EXAMINATION p where p.PHYSICAL_EXAM_TYPE='31'  GROUP BY p.PERSON_ID) and ep.PHYSICAL_EXAM_TYPE='31'  \n"
			+"AND TO_CHAR (ep.EXAMINATION_DATE, 'yyyy-mm-dd') >= '%2$s'"
			+"AND TO_CHAR (ep.EXAMINATION_DATE, 'yyyy-mm-dd') <= '%3$s'"
            //接受健康管理人数：原来的公式+指导（指导是包括健康评价+健康指导+危险因素控制的健康指导）
            +"and (ep.HEALTH_EVALUATE_ANOMALY_FLAG = '1' OR ep.GUIDE_INTO_CHRONIC_DISEASE = '1' OR ep.GUIDE_SUGGESTION_REVIEW = '1' OR ep.GUIDE_SUGGESTION_REFERRAL = '1' OR ep.RISK_QUIT_SMOKING = '1' OR ep.RISK_HEALTH_DRINK = '1' OR ep.RISK_DIET = '1' OR ep.RISK_EXERCISE = '1' OR ep.RISK_WEIGHT_REDUCTION = '1' OR ep.GUIDE_VACCINATION = '1' OR ep.RISK_OTHER = '1')  \n"
			+"and (FPG_MMOL is not null or FPG_MG is not null)  \n"
			+"and (HEMOGLOBIN_VALUE is not null and LEUKOCYTE_COUNT is not null and PLATELET_COUNT is not null)  \n"
			+"and (URINE_PRO_QUANTITATIVE_VALUE is not null and KET_QUANTITATIVE_VALUE is not null and URINE_SUG_QUANTITATIVE_VALUE is not null and ERY_QUANTITATIVE_VALUE is not null)  \n"
			+"and (TC is not null and TRIGLYCERIDE_VALUE is not null and LDLC_DETECT_VALUE is not null and HDLC_DETECT_VALUE is not null)  \n"
			+"and (SERUM_GPT_VALUE is not null and SERUM_AST_VALUE is not null and TOTAL_BILIRUBIN is not null)     	 \n"
			+"and (creatinine is not null and BLOOD_UREA_NITROGEN_VALUE is not null)   \n"
			+"and (BMODE_ANOMALYF_FLAG='1' or BMODE_ANOMALYF_FLAG='0' or BMODE_OTHER_ANOMALYF_FLAG='1' or BMODE_OTHER_ANOMALYF_FLAG='0')  \n"
			+"and (ECG_ANOMALY_FLAG='1' or ECG_ANOMALY_FLAG='0')\n"
//			+"and TO_CHAR(b.INPUT_DATE, 'yyyy-mm-dd') >= '%2$s' \n"
			+"and TO_CHAR(b.INPUT_DATE, 'yyyy-mm-dd') <= '%3$s' and (b.input_center_organ_code = '%5$s' or b.INPUT_ORGAN_CODE = '%5$s')\n"
			+"),t3 as ( \n"
			+"SELECT bp.gbcode gbcode,(nvl(bp.HOUSEHOLD_GREAT_SIXF_NUM,0)+nvl(bp.UN_HOUSEHOLD_GREAT_SIXF_NUM,0)) resident_Num, \n"
			+"0 samsung_Num, 0 towstar_Num,bp.ORGAN_CODE  ORG_CODE,bp.organ_parent_code center_organ_code, \n"
			+"null INPUT_DATE,0 health_Management_Num,0 jy_reserve FROM BI_POPULACE bp where bp.COUNT_YEAR='%4$s' and  \n"
			+"(bp.is_delete ='0' or bp.is_delete is null) and (bp.organ_parent_code = '%5$s' or bp.ORGAN_CODE = '%5$s') \n"
			+"),t4 as ( \n"
			+"select input_gbcode gbcode,0 resident_Num,0 SAMSUNG_NUM,0 TOWSTAR_NUM, \n"
			+"INPUT_ORGAN_CODE ORG_CODE,input_center_organ_code CENTER_ORGAN_CODE, \n"
			+"INPUT_DATE INPUT_DATE,0 HEALTH_MANAGEMENT_NUM, \n"
			+"1 jy_reserve from bi_person_info b " +
			//65岁以上老年人家庭医生签约人数  老年人患者 未解约、已付款 签约生效时间和结束时间在所选时间段内
			"left join SY_FDS_SIGN_PERSON sign on sign.IDCARD = b.IDCARD  WHERE (b.is_delete = '0' OR b.is_delete IS NULL) " +
			" AND TO_CHAR(b.birthday, 'yyyy') <= '%1$s' AND TO_CHAR(sign.EFFECTIVE_END_DATE, 'yyyy-mm-dd') >= '%2$s' AND TO_CHAR(sign.EFFECTIVE_START_DATE, 'yyyy-mm-dd') <= '%3$s' and sign.RESCIND_FLAG ='0' and sign.PAID_FLAG= '1' " +
			" and (b.input_center_organ_code = '%5$s' or b.INPUT_ORGAN_CODE = '%5$s' )\n"
			+"),t5 as ( \n"
			+"SELECT b.input_gbcode gbcode, 0 resident_Num, 1 samsung_Num, 0 towstar_Num, b.INPUT_ORGAN_CODE ORG_CODE, b.input_center_organ_code center_organ_code, b.INPUT_DATE INPUT_DATE, 0 health_Management_Num, 0 jy_reserve  \n"
			+"FROM  bi_person_info b  \n"+
			//接受健康体检人数  统计规则:人员表是已建档，体检表中有记录
			"inner JOIN  (select person_id from ECH_ELDERLY_PHY_EXAMINATION where PHYSICAL_EXAM_TYPE = '31' and" +
			" TO_CHAR(EXAMINATION_DATE, 'yyyy-mm-dd') >= '%2$s' AND TO_CHAR(EXAMINATION_DATE, 'yyyy-mm-dd') <= '%3$s'" +
			" group by person_id) ec ON b.ID = ec.person_id WHERE b.filing_Flag = '1' and (input_center_organ_code = '%5$s' or INPUT_ORGAN_CODE = '%5$s' ) ";
	// 站什么的都选择了
	private final String siteSql = "with t1 as ( \n"
			+"SELECT input_gbcode gbcode,0 resident_Num, \n"
			+"0 samsung_Num, \n"
			+"case when star>='2' then 1 else 0 end towstar_Num, \n"
			+"INPUT_ORGAN_CODE ORG_CODE, \n"
			+"input_center_organ_code center_organ_code, \n"
			+"INPUT_DATE INPUT_DATE, 0 health_Management_Num,0 jy_reserve  FROM  bi_person_info WHERE \n \n"
			+"FILING_FLAG ='1' \n"
			+"and (is_delete ='0' or is_delete is null) AND STAR >= '2' AND  \n"
			+"TO_CHAR(birthday, 'yyyy') <='%1$s' AND  \n"
//			+"TO_CHAR(INPUT_DATE, 'yyyy-mm-dd') >= '%2$s' and  \n"
			+"TO_CHAR(INPUT_DATE, 'yyyy-mm-dd') <= '%3$s' and  \n"
			+"input_gbcode is not null and INPUT_ORGAN_CODE in (%6$s) \n"
			+"),t2 as ( \n"
			+"select b.input_gbcode gbcode,0 resident_Num, 0 samsung_Num, 0 towstar_Num, \n"
			+"b.INPUT_ORGAN_CODE ORG_CODE , b.input_center_organ_code center_organ_code, \n"
			+"b.INPUT_DATE INPUT_DATE,1 health_Management_Num ,0 jy_reserve \n"
			+"FROM ECH_PHYSICAL_EXAM_RECORD r  \n"
			+"left join bi_person_info b on b.id=r.person_id  \n"
			+"left join ECH_ELDERLY_PHY_EXAMINATION ep on ep.person_id=r.person_id  \n"
			+"where b.filing_Flag = '1' AND b.STAR = '3'  \n"
			+"and ep.id in(SELECT max(id) from ECH_ELDERLY_PHY_EXAMINATION p where p.PHYSICAL_EXAM_TYPE='31' GROUP BY p.PERSON_ID) and ep.PHYSICAL_EXAM_TYPE='31'  \n"
			+"AND TO_CHAR (ep.EXAMINATION_DATE, 'yyyy-mm-dd') >= '%2$s'"
			+"AND TO_CHAR (ep.EXAMINATION_DATE, 'yyyy-mm-dd') <= '%3$s'"
			//接受健康管理人数：原来的公式+指导（指导是包括健康评价+健康指导+危险因素控制的健康指导）
			+"and (ep.HEALTH_EVALUATE_ANOMALY_FLAG = '1' OR ep.GUIDE_INTO_CHRONIC_DISEASE = '1' OR ep.GUIDE_SUGGESTION_REVIEW = '1' OR ep.GUIDE_SUGGESTION_REFERRAL = '1' OR ep.RISK_QUIT_SMOKING = '1' OR ep.RISK_HEALTH_DRINK = '1' OR ep.RISK_DIET = '1' OR ep.RISK_EXERCISE = '1' OR ep.RISK_WEIGHT_REDUCTION = '1' OR ep.GUIDE_VACCINATION = '1' OR ep.RISK_OTHER = '1')  \n"
			+"and (FPG_MMOL is not null or FPG_MG is not null)  \n"
			+"and (HEMOGLOBIN_VALUE is not null and LEUKOCYTE_COUNT is not null and PLATELET_COUNT is not null)  \n"
			+"and (URINE_PRO_QUANTITATIVE_VALUE is not null and KET_QUANTITATIVE_VALUE is not null and URINE_SUG_QUANTITATIVE_VALUE is not null and ERY_QUANTITATIVE_VALUE is not null)  \n"
			+"and (TC is not null and TRIGLYCERIDE_VALUE is not null and LDLC_DETECT_VALUE is not null and HDLC_DETECT_VALUE is not null)  \n"
			+"and (SERUM_GPT_VALUE is not null and SERUM_AST_VALUE is not null and TOTAL_BILIRUBIN is not null)     	 \n"
			+"and (creatinine is not null and BLOOD_UREA_NITROGEN_VALUE is not null)   \n"
			+"and (BMODE_ANOMALYF_FLAG='1' or BMODE_ANOMALYF_FLAG='0' or BMODE_OTHER_ANOMALYF_FLAG='1' or BMODE_OTHER_ANOMALYF_FLAG='0')  \n"
			+"and (ECG_ANOMALY_FLAG='1' or ECG_ANOMALY_FLAG='0')\n"
//			+"and TO_CHAR(b.INPUT_DATE, 'yyyy-mm-dd') >= '%2$s' \n"
			+"and TO_CHAR(b.INPUT_DATE, 'yyyy-mm-dd') <= '%3$s' \n"
			+"and b.INPUT_ORGAN_CODE in (%6$s) \n"
			+"),t3 as ( \n"
			+"SELECT bp.gbcode gbcode,(nvl(bp.HOUSEHOLD_GREAT_SIXF_NUM,0)+nvl(bp.UN_HOUSEHOLD_GREAT_SIXF_NUM,0)) resident_Num, \n"
			+"0 samsung_Num, 0 towstar_Num,bp.ORGAN_CODE  ORG_CODE,bp.organ_parent_code center_organ_code, \n"
			+"null INPUT_DATE,0 health_Management_Num,0 jy_reserve FROM BI_POPULACE bp where bp.COUNT_YEAR='%4$s' and  \n"
			+"(bp.is_delete ='0' or bp.is_delete is null) and bp.ORGAN_CODE in (%6$s) \n"
			+"),t4 as ( \n"
			+"select input_gbcode gbcode,0 resident_Num,0 SAMSUNG_NUM,0 TOWSTAR_NUM, \n"
			+"INPUT_ORGAN_CODE ORG_CODE,input_center_organ_code CENTER_ORGAN_CODE, \n"
			+"INPUT_DATE INPUT_DATE,0 HEALTH_MANAGEMENT_NUM, \n"
			+"1 jy_reserve from bi_person_info b " +
			//65岁以上老年人家庭医生签约人数  老年人患者 未解约、已付款 签约生效时间和结束时间在所选时间段内
			"left join SY_FDS_SIGN_PERSON sign on sign.IDCARD = b.IDCARD  WHERE (b.is_delete = '0' OR b.is_delete IS NULL) " +
			" AND TO_CHAR(b.birthday, 'yyyy') <= '%1$s' AND TO_CHAR(sign.EFFECTIVE_END_DATE, 'yyyy-mm-dd') >= '%2$s' AND TO_CHAR(sign.EFFECTIVE_START_DATE, 'yyyy-mm-dd') <= '%3$s' and sign.RESCIND_FLAG ='0' and sign.PAID_FLAG= '1' " +
			" and b.INPUT_ORGAN_CODE in (%6$s) \n"
			+"),t5 as ( \n"
			+"SELECT b.input_gbcode gbcode, 0 resident_Num, 1 samsung_Num, 0 towstar_Num, b.INPUT_ORGAN_CODE ORG_CODE, b.input_center_organ_code center_organ_code, b.INPUT_DATE INPUT_DATE, 0 health_Management_Num, 0 jy_reserve  \n"
			+"FROM bi_person_info b \n"+
			//接受健康体检人数  统计规则:人员表是已建档，体检表中有记录
			"inner JOIN  (select person_id from ECH_ELDERLY_PHY_EXAMINATION where PHYSICAL_EXAM_TYPE = '31' and" +
			" TO_CHAR(EXAMINATION_DATE, 'yyyy-mm-dd') >= '%2$s' AND TO_CHAR(EXAMINATION_DATE, 'yyyy-mm-dd') <= '%3$s'" +
			" group by person_id) ec ON b.ID = ec.person_id WHERE b.filing_Flag = '1' and INPUT_ORGAN_CODE in (%6$s)";
}
