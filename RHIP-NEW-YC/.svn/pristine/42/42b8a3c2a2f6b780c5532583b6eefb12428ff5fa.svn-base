package com.founder.rhip.ehr.repository.clinic;
import javax.annotation.Resource;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.clinic.DiseaseDiagnosisInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of DiseaseDiagnosisInfo
 * 
 */
@Repository("diseaseDiagnosisInfoDao")
public class DiseaseDiagnosisInfoDaoImpl extends AbstractDao<DiseaseDiagnosisInfo, Long> implements IDiseaseDiagnosisInfoDao {

    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    private static final String FORMATER = "yyyy/mm/dd";

    private static final String BASIC_SQL = "select * from MS_DISEASE_DIAGNOSIS_INFO t"
            + " where t.GATHER_DATE = to_date('%2$s', '%1$s')";
    
    private static final String DISEASE_STATISTICS_SQL = "select * from(select diagnosis_code diseaseCode,count(1)diseaseNum from ms_disease_diagnosis_info "
    		+ " %1$s and diagnosis_code is not null and hospital_code in(select organ_code from mdm_organization %2$s)"
    		+ " group by diagnosis_code order by count(1) desc) where rownum <=10";

    @Override
    public List<Map<String, Object>> getDiseasesStatistics(String dateStr) {
        if (ObjectUtil.isNullOrEmpty(dateStr)) {
            throw new IllegalArgumentException("日期不可以为空！");
        }

        StringBuilder sqlBuilder = new StringBuilder("select t1.hospital_code,t1.DIAGNOSE_DATE, a_num, b_num"
                + " from (select count(*) a_num, t.hospital_code,to_char(t.DIAGNOSE_DATE,'%2$s') DIAGNOSE_DATE"
                + " from (%1$s) t"
                + " where t.DISEASE_CODE like 'A%%'"
                + " group by t.hospital_code,to_char(t.DIAGNOSE_DATE,'%2$s')) t1 "
                + " left join (select count(*) b_num, t.hospital_code,to_char(t.DIAGNOSE_DATE,'%2$s') DIAGNOSE_DATE"
                + " from (%1$s) t"
                + " where t.DISEASE_CODE like 'B%%'"
                + " group by t.hospital_code,to_char(t.DIAGNOSE_DATE,'%2$s')) t2 on t1.hospital_code ="
                + " t2.hospital_code and t1.DIAGNOSE_DATE = t2.DIAGNOSE_DATE");

        String basicSql = String.format(BASIC_SQL.toString(), FORMATER, dateStr);
        String sql=String.format(sqlBuilder.toString(), basicSql, FORMATER);
        return this.getMapList(sql, new Criteria());
    }

	@Override
	public List<Map<String, Object>> getDiseaseMapList(Map<String, String> paramMap) {

		String genreCode = paramMap.get("genreCode"); // 机构类型
	    String organCode = paramMap.get("organCode");//站
		String beginDateStr = paramMap.get("beginDate");
        String endDateStr = paramMap.get("endDate");
        String opEmHpMark = paramMap.get("opEmHpMark");// 门诊、住院标识
		String conditionSql = "";
		if (StringUtils.equals(genreCode, "0")) {
			conditionSql = new StringBuilder(" where gb_code ='").append(organCode).append("'").toString();
		} else if (StringUtils.equals(genreCode, "A100") || StringUtils.equals(genreCode, "B100") || StringUtils.equals(genreCode, "B200")) {
			conditionSql = new StringBuilder(" where organ_code ='").append(organCode).append("'").toString();
		} 
		StringBuilder dateConditionSqlBuilder = new StringBuilder();
		Criteria criteria = new Criteria();
		/**门诊包括急诊1：门诊2：急诊3：住院**/
		if (StringUtils.equals(opEmHpMark, "1")) {
			criteria.add("opEmHpMark", OP.NE, "3");
		} else if (ObjectUtil.isNotEmpty(opEmHpMark) && !StringUtils.equals(opEmHpMark, "1")) {
			criteria.add("opEmHpMark", opEmHpMark);
		}
		
		DateUtil.getCriteriaByDateRange(criteria, "diagnoseDate", DateUtil.parseDateString(beginDateStr), DateUtil.parseDateString(endDateStr));
		SqlBuilder.buildWhereStatement(DiseaseDiagnosisInfo.class, dateConditionSqlBuilder, criteria);
		String sql = String.format(DISEASE_STATISTICS_SQL, dateConditionSqlBuilder.toString(), conditionSql);
		return getMapList(sql, criteria);
	}

	//    高脂血症-E78
//    帕金森综合症-G20
//    慢性阻塞性肺病-J44
//    支气管哮喘-J45
	@Override
	public PageList<DiseaseDiagnosisInfo> getDiseaseDiagnosisInfoForCdm(Page page, Criteria criteria){
		StringBuilder sql = new StringBuilder("select * from (SELECT * \n" +
				"FROM MS_DISEASE_DIAGNOSIS_INFO \n" +
				"WHERE (UPPER(SUBSTR(ehr_id,0,2)) ='MZ' OR UPPER(SUBSTR(ehr_id,0,4))='SAAS') \n" +
				"AND SUBSTR(DIAGNOSIS_CODE,0,3) IN ('I10','I11','I12','I13','I14','I15','E10','E11','E12','E13','E14','E15','E78','G20','J44','J45')) ");
		SqlBuilder.buildWhereStatement(DiseaseDiagnosisInfo.class, sql, criteria) ;
//        if(criteria.contains("PERSON_ID")){
//            sql.append(" AND PERSON_ID = " + criteria.get("PERSON_ID"));
//        }
		SqlBuilder.buildOrderStatement(sql, " ID DESC");
		return getPageList(page,sql.toString(), criteria);
	}

	@Override
	public List<String> getRelationOrganCodes(Long personId) {
		StringBuilder sql = new StringBuilder("select DISTINCT(HOSPITAL_CODE) from (SELECT * \n" +
				"FROM MS_DISEASE_DIAGNOSIS_INFO \n" +
				"WHERE (UPPER(SUBSTR(ehr_id,0,2)) ='MZ' OR UPPER(SUBSTR(ehr_id,0,4))='SAAS') \n" +
				"AND SUBSTR(DIAGNOSIS_CODE,0,3) IN ('I10','I11','I12','I13','I14','I15','E10','E11','E12','E13','E14','E15','E78','G20','J44','J45')) WHERE PERSON_ID="+personId);
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		List<String> result = simpleJdbcTemplate.getNamedParameterJdbcOperations().queryForList(sql.toString(), parameterSource, String.class);
		if (ObjectUtil.isNullOrEmpty(result)) {
			return Collections.emptyList();
		}
		return result;
	}

	/**
	 * 按名称分组，取次数最多的
	 * @param criteria
	 * @return
	 */
	public String getDiseaseName(Criteria criteria){
		String result = "";
		StringBuilder sqlBuilder = new StringBuilder("SELECT DIAGNOSIS_DESC FROM(");
		sqlBuilder.append("SELECT DIAGNOSIS_DESC,COUNT(1) NAME_COUNT from MS_DISEASE_DIAGNOSIS_INFO");
		sqlBuilder.append(" %1$s and DIAGNOSIS_DESC is not null ");
		sqlBuilder.append(" GROUP BY DIAGNOSIS_DESC order by  NAME_COUNT DESC");
		sqlBuilder.append(")where rownum <=1");
		StringBuilder conditionSqlBuilder = new StringBuilder();
		SqlBuilder.buildWhereStatement(DiseaseDiagnosisInfo.class, conditionSqlBuilder, criteria);
		String sql = String.format(sqlBuilder.toString(), conditionSqlBuilder.toString());
		DiseaseDiagnosisInfo diseaseDiagnosisInfo = this.get(sql,criteria);
		if(ObjectUtil.isNotEmpty(diseaseDiagnosisInfo)){
			result = diseaseDiagnosisInfo.getDiagnosisDesc();
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> getDiseaseMapList(Criteria ca) {
		ca.add("DIAGNOSIS_CODE",OP.UEMPTY,null);
		StringBuilder  sql = new StringBuilder();
		sql.append(" SELECT * FROM(");
		sql.append("    SELECT \n");
		sql.append("	    HOSPITAL_CODE\n");
		sql.append("	    ,DIAGNOSIS_CODE\n");
		sql.append("	    ,COUNT(1) DIAGNOSE_COUNT\n");
		sql.append("    FROM MS_DISEASE_DIAGNOSIS_INFO\n");
		SqlBuilder.buildWhereStatement(DiseaseDiagnosisInfo.class, sql, ca) ;
		sql.append("    GROUP BY HOSPITAL_CODE,DIAGNOSIS_CODE\n");
		sql.append("    ORDER BY DIAGNOSE_COUNT DESC");
		sql.append(" ) WHERE rownum <=50");
		return this.getMapList(sql.toString(),ca);
	}

}