package com.founder.rhip.ehr.repository.statistics;

import com.founder.fasf.beans.*;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.TargetConstants;
import com.founder.rhip.ehr.entity.basic.PhysicalExamRecord;
import com.founder.rhip.ehr.entity.clinic.HealthExamination;
import com.founder.rhip.mdm.common.OrgGenreCode;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * DAO implement of PhysicalExamRecord
 * 
 */
@Repository("physicalExamRecordDao")
public class PhysicalExamRecordDaoImpl extends AbstractDao<PhysicalExamRecord, Long> implements IPhysicalExamRecordDao {
	
	public static final String ALL_NUM = "allNum";
	
	private static final String PHYSICAL_EXAM_STATISTICS_SQL = "select orgCode, sum(shouldExamQuantity) shouldExamQuantity, sum(actualExamQuantity) actualExamQuantity from ( " +
			"         select input_super_organ_code orgCode, count(id) shouldExamQuantity, 0 actualExamQuantity from ECH_physical_exam_record %1$s group by input_super_organ_code union all " +
			"         select EXAMINATION_ORGAN_CODE orgCode, 0 shouldExamQuantity, count(distinct (PERSON_ID)) actualExamQuantity from ECH_ELDERLY_PHY_STATUS %2$s group by EXAMINATION_ORGAN_CODE) temp " +
			"group by orgCode";
	
	// 体检进度统计
	private static final String PHYSICAL_EXAM_PROGRESS_STATISTICS_SQL = "select * from("
			+ " select %7$s"
			+ " decode(grouping_id(%1$s), %5$s, %4$s) AS %4$s,"
			+ " sum(NVL(shouldNum, 0))shouldNum,sum(NVL(actualNum, 0))actualNum,"
			+ " decode(sum(NVL(shouldNum, 0)),0,0,sum(NVL(actualNum, 0))/sum(NVL(shouldNum, 0)))examRate"
			+ " from (select org.gb_code,org.parent_code,org.organ_code, t.*"
			+ " from mdm_organization org"
			+ " left join (select pr.gbcode, pr.input_super_organ_code orgCode,sum(decode(pr.confirm,1,1,0))shouldNum,sum(decode(pr.exam_status,1,1,0))actualNum"
			+ " from ECH_physical_exam_record pr %2$s group by pr.gbcode,pr.input_super_organ_code) t on t.orgCode =org.organ_code where 1=1 %3$s)"
			+ " GROUP BY rollup(%1$s) %6$s ORDER BY %1$s )";
	

	/**
	 * 综合管理-老年人保健-管理率
	 */
	private static final String HMTARGET_SQL="SELECT COUNT(1) applyNum"
			+ " ,COUNT(CASE WHEN HEALTH_GUIDE_STATUS = 1 AND ESTIMATE_STATUS = 1 THEN 1  ELSE NULL END ) wholeNum"
			+ " FROM ECH_PHYSICAL_EXAM_RECORD WHERE 1 = 1 ";
	
	 @Resource(name = "phbdbJDBCTemplate")
	 private SimpleJdbcTemplate simpleJdbcTemplate;
	
	/**
	 * 根据体检前缀查找最大流水号
	 * @param examNoPre
	 * @return
	 */
	public String findMaxExamNo(String examNoPre) {
		final String sql = "SELECT MAX(EXAM_NUMBER) FROM ECH_PHYSICAL_EXAM_RECORD WHERE EXAM_NUMBER LIKE '" + examNoPre + "%'";
		String examNo = simpleJdbcTemplate.queryForObject(sql, String.class);
		return examNo;
	}
	
	public PhysicalExamRecord get(long personId, int year) {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT * ");
		sqlBuilder.append(" FROM ECH_PHYSICAL_EXAM_RECORD WHERE PERSON_ID = ");
		sqlBuilder.append(personId);
		sqlBuilder.append("  AND TO_CHAR(EXAM_YEAR,'YYYY')='");
		sqlBuilder.append(year);
		sqlBuilder.append("' ORDER BY PERSON_ID");
		return get(sqlBuilder.toString(), (Criteria)null);
	}
	
	@Override
	public List<Map<String, Object>> getRecordInCurrentYear(List ids, String... properties) {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT ");
		sqlBuilder.append(StringUtil.join(properties));
		sqlBuilder.append(" FROM ECH_PHYSICAL_EXAM_RECORD WHERE PERSON_ID IN ( ");
		sqlBuilder.append(StringUtil.join(ids));
		sqlBuilder.append(" ) AND TO_CHAR(EXAM_YEAR,'YYYY')='");
		sqlBuilder.append(DateUtil.getCurrentYear());
		sqlBuilder.append("' ORDER BY PERSON_ID");
		return getMapList(sqlBuilder.toString(), (Criteria)null);
	}
	

	@Override
	public Float getHMTarget(Criteria criteria, String targetCode) {
		StringBuilder sqlBuilder = new StringBuilder();
		if (StringUtils.equalsIgnoreCase(TargetConstants.HM_APPLY_PERSON_QUANTITY, targetCode)) {
			sqlBuilder.append("SELECT COUNT(1) allNum FROM ECH_PHYSICAL_EXAM_RECORD  WHERE 1 = 1 ");
		} else if (StringUtils.equalsIgnoreCase(TargetConstants.HM_WHOLE_PHYSICAL_EXAMINATION_REPORT, targetCode)) {
			sqlBuilder.append("SELECT COUNT(1) allNum FROM ECH_PHYSICAL_EXAM_RECORD  WHERE HEALTH_GUIDE_STATUS = 1 AND ESTIMATE_STATUS = 1 ");
		}
		sqlBuilder.append(" AND ").append(criteria.toSql(ClassMetadata.getMetadata(PhysicalExamRecord.class), ":")).toString();
		Map<String, Object> map = this.getMap(sqlBuilder.toString(), criteria);
		if (map != null && ObjectUtil.isNotEmpty(map.get(ALL_NUM))) {
			return ((BigDecimal)map.get(ALL_NUM)).floatValue();
		} else {
			return 0f;
		}
	}

	@Override
	public Map<String, Object> getHmTarget(Criteria criteria){
		StringBuilder sqlBuilder = new StringBuilder(HMTARGET_SQL);
		sqlBuilder.append(" AND ").append(criteria.toSql(ClassMetadata.getMetadata(PhysicalExamRecord.class), ":")).toString();
		return this.getMap(sqlBuilder.toString(), criteria);
	}

	private StringBuilder echPhysicalExamsSql(Page page,Criteria ca , boolean isExport){
		StringBuilder sqlBuilder = new StringBuilder();
		String pastreet = (String)ca.get("pastreet");
		String patownship = (String)ca.get("patown_ship");
		Date date1=DateUtil.parseSimpleDate((String)ca.get("createBeginDate"), "yyyy/MM/dd");
		Date date2=DateUtil.parseSimpleDate((String)ca.get("createEndDate"), "yyyy/MM/dd");
		String tcmConclusion = (String)ca.get("tcmConclusion");
		String examStatus = (String)ca.get("examStatus");
		String examYearStr = (String)ca.get("examYearStr");
		String isTcm = (String)ca.get("IS_TCM");
		ca.remove("pastreet");
		ca.remove("patown_ship");
		ca.remove("tcmConclusion");
		ca.remove("createBeginDate");
		ca.remove("createEndDate");
		ca.remove("examYearStr");
		ca.remove("examStatus");
//		ca.remove("IS_TCM");
		
		sqlBuilder.append("SELECT DISTINCT record.ID,record.NAME,record.PERSON_ID,record.BIRTHDAY,record.GENDER,record.IDCARD,record.INPUT_SUPER_ORGAN_CODE,record.INPUT_ORGAN_CODE");
		sqlBuilder.append(" ,record.logoff,to_char(sysdate,'yyyy')-to_char(RECORD .BIRTHDAY,'yyyy') age,nvl(IS_TCM,0) IS_TCM, org.ORGAN_NAME as org_name, CASE WHEN IS_TCM >=1 THEN '是' else '否' END as sfbs ");
		if(isExport && ( StringUtil.isNullOrEmpty(isTcm) || "1".equals(isTcm))){
			sqlBuilder.append(",TEMP.TCM_CONCLUSION");
		}
		sqlBuilder.append(" FROM ECH_PHYSICAL_EXAM_RECORD record");
		sqlBuilder.append(" LEFT JOIN ECH_IDENTIFICATION IDEN ON IDEN.PERSON_ID = RECORD .PERSON_ID");
		sqlBuilder.append(" LEFT JOIN MDM_ORGANIZATION org  ON org.organ_code = record.INPUT_ORGAN_CODE ");
		sqlBuilder.append(" LEFT JOIN (select PERSON_ID, sum(NVL(IS_TCM, 0)) IS_TCM from (SELECT PERSON_ID, COUNT(1) IS_TCM from ECH_IDENTIFICATION where to_char(create_date,'yyyy')='"+examYearStr+"' group by PERSON_ID");
		sqlBuilder.append(" UNION all SELECT PERSON_ID, COUNT(1) IS_TCM from ECH_ELDERLY_PHY_EXAMINATION where EXAM_YEAR='"+examYearStr+"' and IDENTIFICATION_ID is not null and IDENTIFICATION_ID <>0  group by PERSON_ID) group by PERSON_ID) status on status.PERSON_ID = RECORD .PERSON_ID");
		
		if(StringUtil.isNullOrEmpty(isTcm) || "1".equals(isTcm)){
			sqlBuilder.append(" LEFT JOIN (SELECT \n" +
						"	T.*, ROW_NUMBER() OVER (PARTITION BY PERSON_ID ORDER BY CREATE_DATE DESC) RN \n" +
						" FROM ( SELECT PERSON_ID, CREATE_DATE,TCM_CONCLUSION FROM ECH_IDENTIFICATION\n" +
						"		WHERE TO_CHAR(CREATE_DATE,'YYYY')='"+examYearStr+"'\n" +
						"	UNION ALL \n" +
						"		SELECT PERSON_ID, EXAMINATION_DATE CREATE_DATE, TCM_CONCLUSION FROM ECH_ELDERLY_PHY_EXAMINATION\n" +
						"		WHERE PHYSICAL_EXAM_TYPE='31' AND IDENTIFICATION_ID IS NOT NULL AND IDENTIFICATION_ID <>0 AND EXAM_YEAR='"+examYearStr+"' \n" +
						")T )TEMP ON TEMP.PERSON_ID = RECORD .PERSON_ID");
		}
			
		//是否体检
		if(StringUtil.isNotEmpty(examStatus)){
			sqlBuilder.append(" left JOIN (SELECT PERSON_ID, COUNT(1) is_exam from ECH_ELDERLY_PHY_STATUS where exam_year='"+examYearStr+"' group by person_id ) p on p.PERSON_ID = RECORD.PERSON_ID");
		}
		
		SqlBuilder.buildWhereStatement(PhysicalExamRecord.class, sqlBuilder, ca);
		//填表日期
		if(ObjectUtil.isNotEmpty(date1) || ObjectUtil.isNotEmpty(date2)){
			sqlBuilder.append(toDateSql(date1,date2,"IDEN.CREATE_DATE"));
		}
		//体质类型
		if(StringUtil.isNotEmpty(tcmConclusion)){
			sqlBuilder.append(" AND IDEN.TCM_CONCLUSION LIKE '%"+tcmConclusion+"%'");
		}
		//辨识状态为是
		if("1".equals(isTcm)){
			sqlBuilder.append(" AND temp.rn=1");
		}
		if(StringUtil.isNotEmpty(pastreet) || StringUtil.isNotEmpty(patownship)){
			String sql=" (SELECT 1 FROM BI_PERSON_INFO B WHERE B.ID=RECORD.PERSON_ID ";
			if(StringUtil.isNotEmpty(pastreet))
				sql += " AND PASTREET='"+pastreet+"')";
			else if(StringUtil.isNotEmpty(patownship))
				sql += " AND PATOWN_SHIP='"+patownship+"')";

			sqlBuilder.append(" AND EXISTS " + sql);
		}
		SqlBuilder.buildOrderStatement(sqlBuilder, "RECORD.person_id desc");
		return sqlBuilder;
	}
	
	/**
	 * 体质辨识列表
	 *
	 * @param page
	 * @param ca
	 * @return
	 * @author Ye jianfei
	 */
	@Override
	public PageList<PhysicalExamRecord> getEchPhysicalExams(Page page,Criteria ca){
		StringBuilder sqlBuilder = this.echPhysicalExamsSql(page,ca, false);
		return this.getPageList(page, sqlBuilder.toString(), ca);
	}

	@Override
	public List<Map<String, Object>> exportEchPhysicalExams(Page page, Criteria ca) {
		StringBuilder sqlBuilder = this.echPhysicalExamsSql(page,ca, true);
		PageList<Map<String, Object>> pageList = this.getPageMapList(page,sqlBuilder.toString(), ca);
		List<Map<String, Object>> result = null == pageList ? null : pageList.getList();
		return result;
	}


	@Override
    public Map<String,Object> getPhysicalExam(Criteria criteria) {
    	Map<String,Object> result = null;
        StringBuilder sql = new StringBuilder("SELECT ROW_.* FROM ( SELECT * FROM SY_MS_HEALTH_EXAM ");
        SqlBuilder.buildWhereStatement(HealthExamination.class, sql, criteria);
        SqlBuilder.buildOrderStatement(sql, "EXAMINATION_DATE DESC NULLS LAST ");
        sql.append(") ROW_  WHERE 	ROWNUM = 1 ");
        List<Map<String,Object>> list = this.getMapList(sql.toString(), criteria);
        if(ObjectUtil.isNotEmpty(list)){
        	result = list.get(0);
        }
        return result;
    }

	@Override
	public List<Map<String, Object>> getPhysicalExamProgressMapList(
			Map<String, String> paramMap) {
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		if (ObjectUtil.isNullOrEmpty(paramMap)) {
			return mapList;
		}
		StringBuilder sqlBuilder = new StringBuilder();
		Criteria criteria = organizeCriteria(paramMap);
		SqlBuilder.buildWhereStatement(PhysicalExamRecord.class,sqlBuilder, criteria);
		StringBuilder orgConditionBuilder = getOrganizationCondition(paramMap);
		String genreCode = paramMap.get("genreCode");
		String having = "having grouping_id(gb_code,center_code,organ_code)!=3 and grouping_id(gb_code,center_code,organ_code)!=1";
		String sql = "";
		if(StringUtils.equals(genreCode, "0")) {
			sql=String.format(PHYSICAL_EXAM_PROGRESS_STATISTICS_SQL, "gb_code",sqlBuilder,orgConditionBuilder,"gb_code","1, '合计'","","");
		}  else {
			having = "having grouping_id(gb_code,organ_code)!=1";
			sql=String.format(PHYSICAL_EXAM_PROGRESS_STATISTICS_SQL, "gb_code,organ_code",sqlBuilder,orgConditionBuilder,"organ_code","1,'小计', 3, '合计'",having,"gb_code,");
		}
		return getMapList(sql, criteria);
	}
	
	private Criteria organizeCriteria(Map<String, String> paramMap) {
		Criteria criteria = new Criteria();
		if (ObjectUtil.isNullOrEmpty(paramMap)) {
			return criteria;
		}
		String beginDateStr = paramMap.get("beginDate");
        String endDateStr = paramMap.get("endDate");
        Date beginDate = DateUtil.parseSimpleDate(beginDateStr, null);
		Date endDate = DateUtil.parseSimpleDate(endDateStr, null);
		DateUtil.getCriteriaByDateRange(criteria, "examYear", beginDate,endDate);
        if (ObjectUtil.isNotEmpty(paramMap.get("gbcode"))) {
			criteria.add("gbcode", paramMap.get("gbcode"));
		}
        if (ObjectUtil.isNotEmpty(paramMap.get("inputSuperOrganCode"))) {
        	criteria.add("inputSuperOrganCode", paramMap.get("inputSuperOrganCode"));
		}
        if (ObjectUtil.isNotEmpty(paramMap.get("inputOrganCode"))) {
        	criteria.add("inputOrganCode", paramMap.get("inputOrganCode"));
		}
        return criteria;
	}
	
	private StringBuilder getOrganizationCondition(Map<String, String> paramMap) {
		StringBuilder sqlBuilder = new StringBuilder();
		String superOrganCode = paramMap.get("superOrganCode");//中心、市级医院
        String gbCode = paramMap.get("gbCode");// 镇

        String genreCode = paramMap.get("genreCode");
        if(ObjectUtil.isNotEmpty(genreCode) && !StringUtils.equals("0", genreCode)){
        	sqlBuilder.append(" and genre_code= '" + genreCode + "'");
        }
        if(StringUtils.equals(genreCode, OrgGenreCode.CENTRE.getValue()) && ObjectUtil.isNotEmpty(superOrganCode)){
        	sqlBuilder.append(" and organ_code= '" + superOrganCode + "'");
        }
       
        if(ObjectUtil.isNotEmpty(gbCode)){
        	sqlBuilder.append(" and GB_CODE= '" + gbCode + "'");
        }
        
        return sqlBuilder;
	}

	@Override
	public List<Map<String, Object>> getPhysicalExamMapList(
			String dateStr) {
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		if (ObjectUtil.isNullOrEmpty(dateStr)) {
			return mapList;
		}
		String dateConditionSql1 = new StringBuilder(" where to_char(exam_year, 'yyyy') <='").append(dateStr).append("'").toString();
		String dateConditionSql2 = new StringBuilder(" where exam_year ='").append(dateStr).append("'").toString();
		String sql = String.format(PHYSICAL_EXAM_STATISTICS_SQL, dateConditionSql1, dateConditionSql2);
		return getMapList(sql, new Criteria());
	}

	@Override
	public PageList<Map<String, Object>> getPersonInfoListMap(List<String> orgCodes, Page page, Criteria criteria,String examinationDateStart,String examinationDateEnd ) {
		StringBuilder sql = new StringBuilder();
//		Order order = new Order("P.ID",false);
		String criterionExamination = (String)criteria.get("criterionExamination");
		String estimateStatus = (String)criteria.get("estimateStatus");
		String healthGuideStatus = (String)criteria.get("healthGuideStatus");
		String examStatus = (String)criteria.get("examStatus");
		String examYearStr = (String)criteria.get("examYearStr");
		criteria.remove("criterionExamination");
		criteria.remove("estimateStatus");
		criteria.remove("healthGuideStatus");
		criteria.remove("examStatus");
		criteria.remove("examYearStr");
		
		Date date1=DateUtil.parseSimpleDate(examinationDateStart, "yyyy/MM/dd");
		Date date2=DateUtil.parseSimpleDate(examinationDateEnd, "yyyy/MM/dd");
		ClassMetadata cMetadata = ClassMetadata.getMetadata(PhysicalExamRecord.class);
		
		sql.append("SELECT ROWNUM AS NUM,T.* FROM (SELECT RECORD.NAME,RECORD.IDCARD,B.HOUSEHOLD_TYPE,B.GENDER,B.BIRTHDAY ,B.UPDATE_DATE,B.PAPROVINCE,"
				+ "B.PACITY,B.PACOUNTY,B.PATOWN_SHIP, B.PASTREET,B.PAHOUSE_NUMBER,B.FILING_FLAG,B.STAR,B.PHONE_NUMBER,B.NATION,B.HRCOUNTY,"
				+ "B.HRTOWN_SHIP,B.HRSTREET,B.HRHOUSE_NUMBER, B.INPUT_DATE,B.PHYSICIANS_CARING_ID,B.PHYSICIANS_CARING_NAME,B.INPUT_ORGAN_CODE,"
				+ "B.GUARDIAN_PHONE_ONE,B.INPUTER_ID,B.INPUT_NAME,B.HEALTH_FILE_NO,B.REMARKS,E.EXAMINATION_DATE,"
				+ "decode(sign(NVL(p.IS_HEALTH_GUIDE_STATUS, 0)),1 ,1,0) health_Guide_Status " +
				" FROM ECH_PHYSICAL_EXAM_RECORD RECORD  LEFT JOIN BI_PERSON_INFO B ON B.ID=RECORD.PERSON_ID ");
			
		sql.append(" left join ( SELECT PERSON_ID, SUM(CRITERION_EXAMINATION) IS_CRITERION_EXAMINATION, SUM(ESTIMATE_STATUS) IS_ESTIMATE_STATUS,"
				+ " SUM(HEALTH_GUIDE_STATUS) IS_HEALTH_GUIDE_STATUS, COUNT(PERSON_ID) IS_EXAM "
				+ "	FROM  ECH_ELDERLY_PHY_STATUS WHERE TO_CHAR(examination_date,'yyyy')='" + examYearStr +"'");
		
		//体检时间
		if(ObjectUtil.isNotEmpty(date1) || ObjectUtil.isNotEmpty(date2)){
			sql.append(toDateSql(date1,date2,"examination_date"));
		}
		sql.append(" GROUP BY PERSON_ID ) P ON RECORD.PERSON_ID=P.PERSON_ID");
		sql.append(" LEFT JOIN ((SELECT T .* FROM ( SELECT A .*, ROW_NUMBER () OVER ( PARTITION BY A .person_id ORDER BY A .EXAMINATION_DATE DESC ) rw FROM ( SELECT T .person_id, T .EXAMINATION_DATE FROM ECH_ELDERLY_PHY_STATUS T GROUP BY T .person_id, T .EXAMINATION_DATE ) A ) T WHERE T .rw = 1)) E ON b. ID = E .person_id");
		sql.append(" WHERE  ").append(criteria.toSql(cMetadata, ":", "RECORD"));
		//是否规范年检
		if(StringUtil.isNotEmpty(criterionExamination)){
			sql.append(criterionExamination.equals("0")?" AND (IS_CRITERION_EXAMINATION is null or IS_CRITERION_EXAMINATION=0)":" AND IS_CRITERION_EXAMINATION >=1");
		}
		//体检状态
		if(StringUtil.isNotEmpty(examStatus)){
			sql.append(examStatus.equals("0")?" AND (is_exam is null or is_exam=0)":" AND is_exam >=1");
		}
		//是否评估
		if(StringUtil.isNotEmpty(estimateStatus)){
			sql.append(estimateStatus.equals("0")?" AND (is_ESTIMATE_STATUS is null or is_ESTIMATE_STATUS=0)":" AND is_ESTIMATE_STATUS >=1");
		}
		//是否中医指导
		if(StringUtil.isNotEmpty(healthGuideStatus)){
			sql.append(healthGuideStatus.equals("0")?" AND (is_HEALTH_GUIDE_STATUS is null or is_HEALTH_GUIDE_STATUS=0)":" AND is_HEALTH_GUIDE_STATUS >=1");
		}
		Order order = new Order("RECORD.ID",false);
		sql.append(order.toString() + ") T");	
		return this.getPageMapList(page, sql.toString(), criteria);
	}

	@Override
	public PageList<PhysicalExamRecord> getPhysicalExamRecordList(Page page, List<String> orgCodes, Criteria criteria,String examinationDateStart,String examinationDateEnd ) {
		Date date1=DateUtil.parseSimpleDate(examinationDateStart, "yyyy/MM/dd");
		Date date2=DateUtil.parseSimpleDate(examinationDateEnd, "yyyy/MM/dd");
		
		String criterionExamination = (String)criteria.get("criterionExamination");
		String estimateStatus = (String)criteria.get("estimateStatus");
		String healthGuideStatus = (String)criteria.get("healthGuideStatus");
		String examStatus = (String)criteria.get("examStatus");
		String examYearStr = (String)criteria.get("examYearStr");
		String pastreet = (String)criteria.get("pastreet");
		String patownship = (String)criteria.get("patown_ship");
		
		criteria.remove("criterionExamination");
		criteria.remove("pastreet");
		criteria.remove("patown_ship");
		//criteria.remove("orgCode");
		criteria.remove("estimateStatus");
		criteria.remove("healthGuideStatus");
		criteria.remove("examStatus");
		criteria.remove("examYearStr");

		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT DISTINCT"
				+ "	record.ID,record.PERSON_ID,record.NAME,record.BIRTHDAY,record.CONFIRM,record.GENDER,record.IDCARD,record.INPUT_SUPER_ORGAN_CODE,"
				+ " record.INPUT_ORGAN_CODE, record.EXAM_YEAR,record.GBCODE,record.PAYMENT_PATTERN_CODE,record.MARRIAGE,"
				+ "	record.TELEPHONE,record.MOIBLE,record.EMPOYEE_NUMBER,record.DEPARTMENT,record.E_MAIL,"
				+ "	record.LOGOFF,NVL(IS_CRITERION_EXAMINATION, 0) IS_CRITERION_EXAMINATION,"
				+ "	NVL(IS_ESTIMATE_STATUS, 0) IS_ESTIMATE_STATUS,NVL(IS_HEALTH_GUIDE_STATUS, 0) IS_HEALTH_GUIDE_STATUS,NVL(IS_EXAM, 0) IS_EXAM "
				+ "	FROM ECH_PHYSICAL_EXAM_RECORD record");
		sqlBuilder.append(" left join ( SELECT  PERSON_ID, SUM(CRITERION_EXAMINATION) IS_CRITERION_EXAMINATION, SUM(ESTIMATE_STATUS) IS_ESTIMATE_STATUS,  SUM(HEALTH_GUIDE_STATUS) IS_HEALTH_GUIDE_STATUS, COUNT(PERSON_ID) IS_EXAM "
				+ "FROM  ECH_ELDERLY_PHY_STATUS WHERE TO_CHAR(EXAMINATION_DATE,'yyyy') ='" + examYearStr +"'");
		//体检时间
		if(ObjectUtil.isNotEmpty(date1) || ObjectUtil.isNotEmpty(date2)){
			sqlBuilder.append(toDateSql(date1,date2,"examination_date"));
		}
		sqlBuilder.append(" GROUP BY PERSON_ID ) P ON RECORD.PERSON_ID=P.PERSON_ID");
		
		ClassMetadata cMetadata = ClassMetadata.getMetadata(PhysicalExamRecord.class);
		String criteriaSql =  criteria.toSql(cMetadata, ":", "record");
		sqlBuilder.append(" WHERE ").append(StringUtil.isEmpty(criteriaSql)? " 1=1 " : criteriaSql);
		
		//是否规范年检
		if(StringUtil.isNotEmpty(criterionExamination)){
			sqlBuilder.append(criterionExamination.equals("0")?" AND (IS_CRITERION_EXAMINATION is null or IS_CRITERION_EXAMINATION=0)":" AND IS_CRITERION_EXAMINATION >=1");
		}
		//体检状态
		if(StringUtil.isNotEmpty(examStatus)){
			sqlBuilder.append(examStatus.equals("0")?" AND (is_exam is null or is_exam=0)":" AND is_exam >=1");
		}
		//是否评估
		if(StringUtil.isNotEmpty(estimateStatus)){
			sqlBuilder.append(estimateStatus.equals("0")?" AND (is_ESTIMATE_STATUS is null or is_ESTIMATE_STATUS=0)":" AND is_ESTIMATE_STATUS >=1");
		}
		//是否中医指导
		if(StringUtil.isNotEmpty(healthGuideStatus)){
			sqlBuilder.append(healthGuideStatus.equals("0")?" AND (is_HEALTH_GUIDE_STATUS is null or is_HEALTH_GUIDE_STATUS=0)":" AND is_HEALTH_GUIDE_STATUS >=1");
		}
		
		if(StringUtil.isNotEmpty(pastreet) || StringUtil.isNotEmpty(patownship)){
			String sql=" (SELECT 1 FROM BI_PERSON_INFO B WHERE B.ID=RECORD.PERSON_ID ";
			if(StringUtil.isNotEmpty(pastreet))
				sql += " AND PASTREET='"+pastreet+"')";
			else if(StringUtil.isNotEmpty(patownship))
				sql += " AND PATOWN_SHIP='"+patownship+"')";
			
			sqlBuilder.append(" AND EXISTS " + sql);
		}
		SqlBuilder.buildOrderStatement(sqlBuilder, "record.ID desc");
		return this.getPageList (page, sqlBuilder.toString(), criteria);
	}

	@Override
	public List<PhysicalExamRecord> getPhysicalExamRecordList(Criteria criteria,String examinationDateStart,String examinationDateEnd ) {
		// TODO Auto-generated method stub
		Date date1=DateUtil.parseSimpleDate(examinationDateStart, "yyyy/MM/dd");
		Date date2=DateUtil.parseSimpleDate(examinationDateEnd, "yyyy/MM/dd");
		StringBuilder sqlBuilder = new StringBuilder();
		criteria.get("pt.examination_date");
		String criterionExamination = (String)criteria.get("criterionExamination");
		criteria.remove("criterionExamination");
		sqlBuilder.append("SELECT record.ID,record.PERSON_ID,record.EXAM_NUMBER,record.NAME,record.BIRTHDAY,record.CONFIRM,record.GENDER,record.IDCARD,record.PHYSICAL_EXAM_TYPE,record.INPUT_SUPER_ORGAN_CODE,record.INPUT_ORGAN_CODE,record.EXAM_STATUS,record.HEALTH_GUIDE_STATUS,record.ESTIMATE_STATUS,record.EXAM_YEAR,record.GBCODE,record.PAYMENT_PATTERN_CODE,record.EXAM_DATA_STATUS,record.MARRIAGE,record.TELEPHONE,record.MOIBLE,record.EMPOYEE_NUMBER,record.DEPARTMENT,record.E_MAIL,record.TCM_STATUS,record.TCM_CONCLUSION,record.LOGOFF FROM ECH_physical_exam_record record");
		if(ObjectUtil.isNotEmpty(date1) || ObjectUtil.isNotEmpty(date2)){
			String sql1="  right join (select distinct(pe.person_id) person_id from MSDB.MS_ELDERLY_PHY_EXAMINATION pe"
					+ " where 1=1 "+toDateSql(date1,date2,"pe.examination_date")+") pt  on record.person_id=pt.person_id  ";
			sqlBuilder.append(sql1);
		}
		SqlBuilder.buildWhereStatement(PhysicalExamRecord.class, sqlBuilder, criteria);

		if(StringUtil.isNotEmpty(criterionExamination)){
			String sql=" (SELECT 1 FROM MSDB.MS_ELDERLY_PHY_EXAMINATION P WHERE RECORD.PERSON_ID = P.PERSON_ID  AND RECORD.EXAM_NUMBER=P.PHYSICAL_EXAM_CODE  AND PHYSICAL_EXAM_TYPE='31'" +
					//血常规
					" AND (P.HEMOGLOBIN_VALUE IS NOT NULL OR  P.LEUKOCYTE_COUNT IS NOT NULL OR P.PLATELET_COUNT IS NOT NULL OR P.BLOOD_ROUTINE_OTHER_DESC IS NOT NULL)" +
					//尿常规
					" AND (P.URINE_PRO_QUANTITATIVE_VALUE IS NOT NULL OR  P.URINE_SUG_QUANTITATIVE_VALUE IS NOT NULL OR P.KET_QUANTITATIVE_VALUE IS NOT NULL OR  P.ERY_QUANTITATIVE_VALUE IS NOT NULL OR P.URINE_ROUTINES_OTHER_DESC IS NOT NULL)" +
					//肝功能
					" AND (P.SERUM_GPT_VALUE IS NOT NULL OR  P.SERUM_AST_VALUE IS NOT NULL OR P.TOTAL_BILIRUBIN IS NOT NULL)" +
					//肾功能
					" AND (P.CREATININE IS NOT NULL OR  P.BLOOD_UREA_NITROGEN_VALUE IS NOT NULL)" +
					//空腹血糖
					" AND (P.FPG_MMOL IS NOT NULL OR FPG_MG IS NOT NULL)" +
					//血脂
					" AND (P.TC IS NOT NULL OR P.TRIGLYCERIDE_VALUE IS NOT NULL OR  P.LDLC_DETECT_VALUE IS NOT NULL OR P.HDLC_DETECT_VALUE IS NOT NULL)" +
					//心电图检测
					" AND (P.ECG_ANOMALY_FLAG IS NOT NULL AND P.ECG_ANOMALY_FLAG <> 2)" +
					//腹部B超
					" AND (P.BMODE_ANOMALYF_FLAG IS NOT NULL AND P.BMODE_ANOMALYF_FLAG <> 2)" +
					//自我评估
					" AND P.HEALTH_SELF_ASSESSMENT IS NOT NULL AND P.LIFE_ABILITY_SELF_ASSESSMENT IS NOT NULL AND P.EATING_ASSESSMENT IS NOT NULL AND P.CLEANING_ASSESSMENT IS NOT NULL AND P.CLOTHING_ASSESSMENT IS NOT NULL AND P.DEFECATION_ASSESSMENT IS NOT NULL AND P.EXERCISE_ASSESSMENT IS NOT NULL AND P.COGNITION_SCREEN_RESULT IS NOT NULL AND P.EMOTION_SCREEN_RESULT IS NOT NULL" +
					//中医体质辨识
					" AND (P.TCM_PEACEFUL_QUALITY IS NOT NULL OR P.TCM_QI_QUALITY IS NOT NULL OR P.TCM_YANG_QUALITY IS NOT NULL OR P.TCM_YIN_DEFICIENCY IS NOT NULL OR P.TCM_PHLEGM_WETNESS IS NOT NULL OR P.TCM_HEAT_MEDIUM IS NOT NULL OR P.TCM_BLOOD_QUALITY IS NOT NULL OR P.TCM_QI_STAGNATION IS NOT NULL OR P.TCM_SPECIAL_QUALITY IS NOT NULL)" +
					//中医健康指导
					" AND RECORD.HEALTH_GUIDE_STATUS = 1)";

			sqlBuilder.append((criterionExamination.equals("0")?" AND NOT EXISTS ":" AND EXISTS ") + sql);
		}

		SqlBuilder.buildOrderStatement(sqlBuilder, "record.ID desc");
		return this.getList (sqlBuilder.toString(), criteria);
	}

	/**
    *
    * @param beginDate
    * @param endDate
    * @param columnName
    * @return 返回拼接的sql
    */
	private String toDateSql(Date beginDate,Date endDate,String columnName){
	    StringBuffer sql = new StringBuffer(100);
       if (null != beginDate && null == endDate) {
           sql.append( " AND "+columnName+">=to_date('"+DateUtil.toDateString(beginDate,"yyyy-MM-dd")+"','yyyy-mm-dd')");
       } else if (null == beginDate && null != endDate) {
           sql.append(" AND "+columnName+"<=to_date('"+DateUtil.toDateString(endDate,"yyyy-MM-dd")+"','yyyy-mm-dd')");
       }
       else if (null != beginDate && null != endDate) {
           sql.append(" AND "+columnName+">=to_date('"+DateUtil.toDateString(beginDate,"yyyy-MM-dd")+"','yyyy-mm-dd')");
           sql.append(" AND "+columnName+"<=to_date('"+DateUtil.toDateString(endDate,"yyyy-MM-dd")+"','yyyy-mm-dd')");
       }else{
           return "";
       }
	    return sql.toString();
   }

    @Override
    public List<Map<String, Object>> getPhysicalExamProgressMapList(Criteria criteria) {

        Date ageDate = DateUtil.lastDateOfYear(DateUtil.getBirthdayByAge(65));
        String ageDateStr =Integer.parseInt(criteria.get("endDate").toString().substring(0, 4))- 65 + "/12/31";

        StringBuilder sql = new StringBuilder("");

        if(criteria.contains("jksy")){
            sql.append(" WITH ORG_RESULT AS (SELECT CASE WHEN genre_code = 'B200' THEN parent_code ELSE organ_code END parent_code,  organ_code, genre_code,sort FROM mdm_organization WHERE genre_code IN ('A100', 'B100', 'B200','J100') ORDER BY sort), ");
            sql.append(" EXAM_NUM_RECORD AS ( SELECT INPUT_ORGAN_CODE , SUM(DECODE(NVL(EXAM_STATUS,0),1,1,0)) EXAM_NUM FROM ECH_PHYSICAL_EXAM_RECORD "
                + "  WHERE TO_CHAR(EXAM_YEAR,'yyyy/MM/dd') >= '" + criteria.get("beginDate") + "'"
                + "  and  TO_CHAR(EXAM_YEAR,'yyyy/MM/dd')  <= '" + criteria.get("endDate") + "' GROUP BY INPUT_ORGAN_CODE), ");
            sql.append(" ESTIMATE_NUM_RECORD AS (SELECT INPUT_ORGAN_CODE , SUM(DECODE(NVL(ESTIMATE_STATUS,0),1,1,0)) ESTIMATE_NUM FROM ECH_PHYSICAL_EXAM_RECORD "
                + "  WHERE TO_CHAR(EXAM_YEAR,'yyyy/MM/dd') >= '" + criteria.get("beginDate") + "'"
                + "  and  TO_CHAR(EXAM_YEAR,'yyyy/MM/dd')  <= '" + criteria.get("endDate") + "' GROUP BY INPUT_ORGAN_CODE ),");
            sql.append(" GUIDE_NUM_RECORD AS ( SELECT INPUT_ORGAN_CODE , SUM(DECODE(NVL(HEALTH_GUIDE_STATUS,0),1,1,0)) HEALTH_GUIDE_NUM "
                + " FROM ECH_PHYSICAL_EXAM_RECORD "
                + "  WHERE TO_CHAR(EXAM_YEAR,'yyyy/MM/dd') >= '" + criteria.get("beginDate") + "'"
                + "  and  TO_CHAR(EXAM_YEAR,'yyyy/MM/dd')  <= '" + criteria.get("endDate") + "'  GROUP BY INPUT_ORGAN_CODE ), ");

            sql.append(" PHY_GUIDE_NUM AS (SELECT E.INPUT_ORGAN_CODE, SUM(NVL2(PHYSICAL_EXAM_CODE,1,0)) GUIDE_NUM\n"
                + "  FROM (SELECT PHYSICAL_EXAM_CODE\n"
                + "          FROM ECH_ELDERLY_PHY_EXAMINATION\n"
                + "         WHERE (NVL(GUIDE_INTO_CHRONIC_DISEASE, 0) +\n"
                + "               NVL(GUIDE_SUGGESTION_REVIEW, 0) +\n"
                + "               NVL(GUIDE_SUGGESTION_REFERRAL, 0)) > 0 \n"
                + "               AND PHYSICAL_EXAM_TYPE = '31') T,\n"
                + "       ECH_PHYSICAL_EXAM_RECORD E\n"
                + "  WHERE TO_CHAR(E.EXAM_YEAR,'yyyy/MM/dd') >= '" + criteria.get("beginDate") + "'"
                + "  and  TO_CHAR(E.EXAM_YEAR,'yyyy/MM/dd')  <= '" + criteria.get("endDate") + "'"
                + " AND T.PHYSICAL_EXAM_CODE(+) = E.EXAM_NUMBER\n"
                + " GROUP BY E.INPUT_ORGAN_CODE),");

            sql.append(" TCM_NUM_RECORD AS (SELECT CREATE_ORG ECH_ORGAN_CODE , count(1) TCM_NUM  FROM ECH_IDENTIFICATION ");
            sql.append(" WHERE TO_CHAR(CREATE_DATE,'yyyy/MM/dd') >= '" + criteria.get("beginDate") + "'"
                + "  and  TO_CHAR(CREATE_DATE,'yyyy/MM/dd')  <= '" + criteria.get("endDate") + "' GROUP BY CREATE_ORG ), ");
            sql.append(" MANAGE_NUM_RECORD1 AS  (SELECT INPUT_ORGAN_CODE, COUNT(DECODE(ESTIMATE_STATUS,1,1,NULL)) MANAGE_NUM1 "
                + "  FROM ECH_PHYSICAL_EXAM_RECORD "
                + "  WHERE TO_CHAR(EXAM_YEAR,'yyyy/MM/dd') >= '" + criteria.get("beginDate") + "' "
                + "  and  TO_CHAR(EXAM_YEAR,'yyyy/MM/dd')  <= '" + criteria.get("endDate") + "' "
                + "  GROUP BY INPUT_ORGAN_CODE )");
            sql.append("  select organCode , householdNum, fillNum, examNum, estimateNum, healthGuideNum,tcmNum, manageNum , guideNum,"
				+ "  ROUND(DECODE(SIGN(NVL(householdNum,0)),0,0,NVL(fillNum,0)       /householdNum),4) fillNumRate , "//建档率
                + "  ROUND(DECODE(SIGN(NVL(householdNum,0)),0,0,NVL(examNum,0)       /householdNum),4) examRate , "
                + "  ROUND(DECODE(SIGN(NVL(householdNum,0)),0,0,NVL(estimateNum,0)   /householdNum),4) estimateRate , "
                + "  ROUND(DECODE(SIGN(NVL(householdNum,0)),0,0,NVL(healthGuideNum,0)/householdNum),4) healthGuideRate , "
                + "  ROUND(DECODE(SIGN(NVL(householdNum,0)),0,0,NVL(tcmNum,0)        /householdNum),4) tcmRate , "
                + "  ROUND(DECODE(SIGN(NVL(householdNum,0)),0,0,NVL(guideNum,0)        /householdNum),4) guideRate , "
                + "  ROUND(DECODE(SIGN(NVL(householdNum,0)),0,0,NVL(manageNum,0)     /householdNum),4) manageRate from (  "
                + " SELECT populace.parent_code organCode, "
                + " SUM(NVL(person.fill_num,0)) fillNum, "
                + " SUM(populace.HOUSEHOLD_NUM) householdNum , "
                + " SUM(NVL(EXAM_NUM_RECORD.EXAM_NUM,0)) examNum ,"
                + " SUM(NVL(ESTIMATE_NUM_RECORD.ESTIMATE_NUM,0)) estimateNum ,"
                + " SUM(NVL(GUIDE_NUM_RECORD.HEALTH_GUIDE_NUM,0)) healthGuideNum ,"
                + " SUM(NVL(TCM_NUM_RECORD.TCM_NUM,0)) tcmNum ,"
                + " SUM(NVL(PHY_GUIDE_NUM.guide_num, 0)) guideNum,"
                + " SUM(NVL(MANAGE_NUM_RECORD1.MANAGE_NUM1,0)) manageNum "
                + " FROM (SELECT org.parent_code , org.organ_code orgCode,NVL(HOUSEHOLD_GREAT_SIXF_NUM,0)+NVL(UN_HOUSEHOLD_GREAT_SIXF_NUM,0) HOUSEHOLD_NUM FROM ORG_RESULT ORG LEFT JOIN "
                + " (SELECT organ_code, HOUSEHOLD_GREAT_SIXF_NUM, COUNT_YEAR, UN_HOUSEHOLD_GREAT_SIXF_NUM FROM BI_POPULACE WHERE COUNT_YEAR = '" + criteria.get("endDate").toString().substring(0, 4) + "' ) bi_populace "
                + " ON org.organ_code= bi_populace.organ_code ) populace "
                + "   left join  (select INPUT_ORGAN_CODE , count(*) fill_num from BI_PERSON_INFO where filing_Flag ='1' AND STAR >= '2' AND TO_CHAR(BIRTHDAY,'YYYY')<=TO_CHAR(SYSDATE,'YYYY')-65 GROUP BY INPUT_ORGAN_CODE )   person ON person.INPUT_ORGAN_CODE = populace.orgCode "
                + "	  LEFT JOIN EXAM_NUM_RECORD ON EXAM_NUM_RECORD.INPUT_ORGAN_CODE = populace.orgCode "
                + "	  LEFT JOIN ESTIMATE_NUM_RECORD ON ESTIMATE_NUM_RECORD.INPUT_ORGAN_CODE = populace.orgCode "
                + "	  LEFT JOIN GUIDE_NUM_RECORD  ON GUIDE_NUM_RECORD.INPUT_ORGAN_CODE = populace.orgCode "
                + "	  LEFT JOIN TCM_NUM_RECORD  ON TCM_NUM_RECORD.ECH_ORGAN_CODE = populace.orgCode "
                + "	  LEFT JOIN MANAGE_NUM_RECORD1  ON MANAGE_NUM_RECORD1.INPUT_ORGAN_CODE = populace.orgCode "
                +"    LEFT JOIN PHY_GUIDE_NUM   ON PHY_GUIDE_NUM.INPUT_ORGAN_CODE = populace.orgCode"
                + "	  WHERE populace.orgCode IS NOT NULL GROUP BY rollup (populace.parent_code) ) ");
        }else{
            sql.append(" WITH ");
            sql.append(" EXAM_NUM_RECORD AS ");
            sql.append(" ( SELECT INPUT_ORGAN_CODE , "
                + " SUM(DECODE(NVL(EXAM_STATUS,0),1,1,0)) EXAM_NUM "
                + "  FROM ECH_PHYSICAL_EXAM_RECORD "
                + "  WHERE TO_CHAR(EXAM_YEAR,'yyyy/MM/dd') >= '" + criteria.get("beginDate") + "'"
                + "  and  TO_CHAR(EXAM_YEAR,'yyyy/MM/dd')  <= '" + criteria.get("endDate") + "'");
            sql.append(" and  INPUT_ORGAN_CODE in  (" + criteria.get("orgCode")  + ") GROUP BY INPUT_ORGAN_CODE ), ");

            sql.append(" ESTIMATE_NUM_RECORD AS  ( SELECT INPUT_ORGAN_CODE ,  SUM(DECODE(NVL(ESTIMATE_STATUS,0),1,1,0)) ESTIMATE_NUM  FROM ECH_PHYSICAL_EXAM_RECORD ");
            sql.append(" WHERE TO_CHAR(EXAM_YEAR,'yyyy/MM/dd') >= '" + criteria.get("beginDate") + "'"
                + "  and  TO_CHAR(EXAM_YEAR,'yyyy/MM/dd')  <= '" + criteria.get("endDate") + "'");
            sql.append(" and  INPUT_ORGAN_CODE in  (" + criteria.get("orgCode")  + ") GROUP BY INPUT_ORGAN_CODE ), ");

            sql.append("  GUIDE_NUM_RECORD AS ( SELECT INPUT_ORGAN_CODE ,  SUM(DECODE(NVL(HEALTH_GUIDE_STATUS,0),1,1,0)) HEALTH_GUIDE_NUM   FROM ECH_PHYSICAL_EXAM_RECORD ");
            sql.append(" WHERE TO_CHAR(EXAM_YEAR,'yyyy/MM/dd') >= '" + criteria.get("beginDate") + "'"
                + "  and  TO_CHAR(EXAM_YEAR,'yyyy/MM/dd')  <= '" + criteria.get("endDate") + "'");
            sql.append(" and  INPUT_ORGAN_CODE in  (" + criteria.get("orgCode")  + ") GROUP BY INPUT_ORGAN_CODE ), ");

            sql.append(" PHY_GUIDE_NUM AS (SELECT E.INPUT_ORGAN_CODE, SUM(NVL2(PHYSICAL_EXAM_CODE,1,0)) GUIDE_NUM\n"
                + "  FROM (SELECT PHYSICAL_EXAM_CODE\n"
                + "          FROM ECH_ELDERLY_PHY_EXAMINATION\n"
                + "         WHERE (NVL(GUIDE_INTO_CHRONIC_DISEASE, 0) +\n"
                + "               NVL(GUIDE_SUGGESTION_REVIEW, 0) +\n"
                + "               NVL(GUIDE_SUGGESTION_REFERRAL, 0)) > 0 \n"
                + "               AND PHYSICAL_EXAM_TYPE = '31') T,\n"
                + "       ECH_PHYSICAL_EXAM_RECORD E\n"
                + "  WHERE TO_CHAR(E.EXAM_YEAR,'yyyy/MM/dd') >= '" + criteria.get("beginDate") + "'"
                + "  and  TO_CHAR(E.EXAM_YEAR,'yyyy/MM/dd')  <= '" + criteria.get("endDate") + "'"
                + " AND T.PHYSICAL_EXAM_CODE(+) = E.EXAM_NUMBER\n"
                + " and  E.INPUT_ORGAN_CODE in  (" + criteria.get("orgCode")  + ")GROUP BY E.INPUT_ORGAN_CODE),");

            sql.append("   TCM_NUM_RECORD AS ( SELECT CREATE_ORG ECH_ORGAN_CODE , count(1) TCM_NUM  FROM ECH_IDENTIFICATION ");
            sql.append(" WHERE TO_CHAR(CREATE_DATE,'yyyy/MM/dd') >= '" + criteria.get("beginDate") + "'"
                + "  and  TO_CHAR(CREATE_DATE,'yyyy/MM/dd')  <= '" + criteria.get("endDate") + "'");
            sql.append(" and  CREATE_ORG in  (" + criteria.get("orgCode")  + ") GROUP BY CREATE_ORG ), ");

            sql.append("  MANAGE_NUM_RECORD1 AS (SELECT INPUT_ORGAN_CODE MANAGE_ORGAN1, COUNT(DECODE(ESTIMATE_STATUS,1,1,NULL))  MANAGE_NUM1  FROM ECH_PHYSICAL_EXAM_RECORD ");
            sql.append(" WHERE TO_CHAR(EXAM_YEAR,'yyyy/MM/dd') >= '" + criteria.get("beginDate") + "' "
                + "  and  TO_CHAR(EXAM_YEAR,'yyyy/MM/dd')  <= '" + criteria.get("endDate") + "' ");
            sql.append(" and  INPUT_ORGAN_CODE in  (" + criteria.get("orgCode")  + ") GROUP BY INPUT_ORGAN_CODE )");

            sql.append(" SELECT orgCode organCode, householdNum, fillNum, examNum, estimateNum, healthGuideNum, tcmNum, manageNum , guideNum,");
            sql.append(" ROUND(DECODE(SIGN(NVL(householdNum,0)),0,0,NVL(examNum,0)       /householdNum),4) examRate , ");
            sql.append(" ROUND(DECODE(SIGN(NVL(householdNum,0)),0,0,NVL(estimateNum,0)   /householdNum),4) estimateRate , ");
            sql.append(" ROUND(DECODE(SIGN(NVL(householdNum,0)),0,0,NVL(healthGuideNum,0)/householdNum),4) healthGuideRate , ");
            sql.append(" ROUND(DECODE(SIGN(NVL(householdNum,0)),0,0,NVL(tcmNum,0)        /householdNum),4) tcmRate , ");
            sql.append(" ROUND(DECODE(SIGN(NVL(householdNum,0)),0,0,NVL(guideNum,0)        /householdNum),4) guideRate , ");
            sql.append(" ROUND(DECODE(SIGN(NVL(householdNum,0)),0,0,NVL(manageNum,0)     /householdNum),4) manageRate ");
            sql.append(" FROM ");
            sql.append(" ( SELECT populace.orgCode ,SUM(populace.HOUSEHOLD_NUM) householdNum ,  SUM(NVL(person.fill_num,0)) fillNum, SUM(NVL(EXAM_NUM_RECORD.EXAM_NUM,0)) examNum , SUM(NVL(ESTIMATE_NUM_RECORD.ESTIMATE_NUM,0)) estimateNum , SUM(NVL(GUIDE_NUM_RECORD.HEALTH_GUIDE_NUM,0)) healthGuideNum , SUM(NVL(TCM_NUM_RECORD.TCM_NUM,0)) tcmNum , SUM(NVL(PHY_GUIDE_NUM.guide_num, 0)) guideNum,SUM(NVL(MANAGE_NUM_RECORD1.MANAGE_NUM1,0)) manageNum  FROM  ");
            sql.append(" ( SELECT org.parent_code , org.organ_code orgCode, NVL(HOUSEHOLD_GREAT_SIXF_NUM,0)+NVL(UN_HOUSEHOLD_GREAT_SIXF_NUM,0) HOUSEHOLD_NUM FROM MDM_ORGANIZATION ORG LEFT JOIN ");
            sql.append(" (SELECT organ_code, HOUSEHOLD_GREAT_SIXF_NUM, COUNT_YEAR, UN_HOUSEHOLD_GREAT_SIXF_NUM FROM BI_POPULACE WHERE COUNT_YEAR = '"+ criteria.get("endDate").toString().substring(0, 4) + "' ) bi_populace ");
            sql.append(" ON org.organ_code  = bi_populace.organ_code   WHERE  org.ORGAN_CODE  in (" + criteria.get("orgCode") + ") ) populace ");
            sql.append(" left join  (select INPUT_ORGAN_CODE , count(*) fill_num from BI_PERSON_INFO where filing_Flag ='1' AND STAR >= '2' AND TO_CHAR(BIRTHDAY,'YYYY')<=TO_CHAR(SYSDATE,'YYYY')-65 GROUP BY INPUT_ORGAN_CODE )   person ON person.INPUT_ORGAN_CODE = populace.orgCode  "
                + "  LEFT JOIN EXAM_NUM_RECORD ON EXAM_NUM_RECORD.INPUT_ORGAN_CODE = populace.orgCode "
                + "  LEFT JOIN ESTIMATE_NUM_RECORD ON ESTIMATE_NUM_RECORD.INPUT_ORGAN_CODE = populace.orgCode LEFT JOIN GUIDE_NUM_RECORD ON GUIDE_NUM_RECORD.INPUT_ORGAN_CODE = populace.orgCode LEFT JOIN TCM_NUM_RECORD ON TCM_NUM_RECORD.ECH_ORGAN_CODE = populace.orgCode LEFT JOIN MANAGE_NUM_RECORD1 ON MANAGE_NUM_RECORD1.MANAGE_ORGAN1 = populace.orgCode  "
                +"    LEFT JOIN PHY_GUIDE_NUM   ON PHY_GUIDE_NUM.INPUT_ORGAN_CODE = populace.orgCode"
                + " WHERE populace.orgCode IS NOT NULL  GROUP BY ROLLUP(populace.orgCode) ) ");

        }
        return this.getMapList(sql.toString(), new Criteria());
    }

	@Override
	public void updateOrganByVillage(String inputSuperOrganCode, String orgCode, String[] newAddVillageCodes) {
		String sql = "UPDATE ECH_PHYSICAL_EXAM_RECORD ech SET ech.INPUT_ORGAN_CODE = :inputOrganCode,ech.INPUT_SUPER_ORGAN_CODE=:inputSuperOrganCode WHERE EXISTS ( SELECT 1 FROM BI_PERSON_INFO bi WHERE ech.PERSON_ID = bi.id AND bi.PASTREET IN (:villages))";
		String historySql = "INSERT INTO ECH_PHYSICAL_EXAM_RECORD_RH(ID,input_organ_code,input_super_organ_code,RECORD_CHANGE_TIME) SELECT ech.ID, ech.input_organ_code,ech.input_super_organ_code,to_date('" + DateUtil.toDateString(new Date(), "yyyy-MM-dd HH:mm:ss")
				+ "','yyyy-mm-dd hh24:mi:ss') FROM ECH_PHYSICAL_EXAM_RECORD ech, BI_PERSON_INFO bi  WHERE ech.PERSON_ID = bi.id AND bi.PASTREET IN (:villages)";
		MapSqlParameterSource parameterSource = new MapSqlParameterSource("villages", Arrays.asList(newAddVillageCodes));
		parameterSource.addValue("inputOrganCode", orgCode);
		parameterSource.addValue("inputSuperOrganCode", inputSuperOrganCode);
		simpleJdbcTemplate.update(historySql, parameterSource);
		simpleJdbcTemplate.update(sql, parameterSource);
	}
}