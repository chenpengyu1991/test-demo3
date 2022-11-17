package com.founder.rhip.ehr.repository.statistics;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedCaseInsensitiveMap;

import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.statisticsdto.TumorMonthSeasonReport;
import com.founder.rhip.mdm.common.OrgGenreCode;

@Repository("cdMonthSeasonStatisticsDao")
public class CdMonthSeasonStatisticsDaoImpl extends AbstractDao<PersonInfo, Long> implements ICdMonthSeasonStatisticsDao {
	@Resource(name = "queryJdbcTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

    //禁用格式化
    //@foff

    private static final String CD_SUM_SQL=""+
            "		\"SUM\"(CASE WHEN DIS_TYPE=2  THEN 1 ELSE 0 END )A5, " +
            "		\"SUM\"(CASE WHEN DIS_TYPE=2 AND SUB_DIS_TYPE=1 THEN 1 ELSE 0 END )A1, " +
            "		\"SUM\"(CASE WHEN DIS_TYPE=2 AND SUB_DIS_TYPE=2 THEN 1 ELSE 0 END )A2, " +
            "		\"SUM\"(CASE WHEN DIS_TYPE=2 AND SUB_DIS_TYPE=3 THEN 1 ELSE 0 END )A3, " +
            "		\"SUM\"(CASE WHEN DIS_TYPE=2 AND SUB_DIS_TYPE=4 THEN 1 ELSE 0 END )A4, " +
            "		\"SUM\"(CASE WHEN DIS_TYPE=3  THEN 1 ELSE 0 END )B5, " +
            "		\"SUM\"(CASE WHEN DIS_TYPE=3 AND SUB_DIS_TYPE=1 THEN 1 ELSE 0 END )B1, " +
            "		\"SUM\"(CASE WHEN DIS_TYPE=3 AND SUB_DIS_TYPE=2 THEN 1 ELSE 0 END )B2, " +
            "		\"SUM\"(CASE WHEN DIS_TYPE=3 AND SUB_DIS_TYPE=3 THEN 1 ELSE 0 END )B3, " +
            "		\"SUM\"(CASE WHEN DIS_TYPE=3 AND SUB_DIS_TYPE=4 THEN 1 ELSE 0 END )B4, " +
            "		\"SUM\"(CASE WHEN DIS_TYPE=4  THEN 1 ELSE 0 END )C5, " +
            "		\"SUM\"(CASE WHEN DIS_TYPE=4 AND SUB_DIS_TYPE=1 THEN 1 ELSE 0 END )C1, " +
            "		\"SUM\"(CASE WHEN DIS_TYPE=4 AND SUB_DIS_TYPE=2 THEN 1 ELSE 0 END )C2, " +
            "		\"SUM\"(CASE WHEN DIS_TYPE=4 AND SUB_DIS_TYPE=3 THEN 1 ELSE 0 END )C3, " +
            "		\"SUM\"(CASE WHEN DIS_TYPE=4 AND SUB_DIS_TYPE=4 THEN 1 ELSE 0 END )C4 " ;

    private static final String CD_UPSUM_SQL=""+

            "		\"SUM\"(CASE WHEN DIS_TYPE=2  THEN 1 ELSE 0 END )A51, " +
            "		\"SUM\"(CASE WHEN DIS_TYPE=2 AND SUB_DIS_TYPE=1 THEN 1 ELSE 0 END )A11, " +
            "		\"SUM\"(CASE WHEN DIS_TYPE=2 AND SUB_DIS_TYPE=2 THEN 1 ELSE 0 END )A21, " +
            "		\"SUM\"(CASE WHEN DIS_TYPE=2 AND SUB_DIS_TYPE=3 THEN 1 ELSE 0 END )A31, " +
            "		\"SUM\"(CASE WHEN DIS_TYPE=2 AND SUB_DIS_TYPE=4 THEN 1 ELSE 0 END )A41, " +
            "		\"SUM\"(CASE WHEN DIS_TYPE=3  THEN 1 ELSE 0 END )B51, " +
            "		\"SUM\"(CASE WHEN DIS_TYPE=3 AND SUB_DIS_TYPE=1 THEN 1 ELSE 0 END )B11, " +
            "		\"SUM\"(CASE WHEN DIS_TYPE=3 AND SUB_DIS_TYPE=2 THEN 1 ELSE 0 END )B21, " +
            "		\"SUM\"(CASE WHEN DIS_TYPE=3 AND SUB_DIS_TYPE=3 THEN 1 ELSE 0 END )B31, " +
            "		\"SUM\"(CASE WHEN DIS_TYPE=3 AND SUB_DIS_TYPE=4 THEN 1 ELSE 0 END )B41, " +
            "		\"SUM\"(CASE WHEN DIS_TYPE=4  THEN 1 ELSE 0 END )C51, " +
            "		\"SUM\"(CASE WHEN DIS_TYPE=4 AND SUB_DIS_TYPE=1 THEN 1 ELSE 0 END )C11, " +
            "		\"SUM\"(CASE WHEN DIS_TYPE=4 AND SUB_DIS_TYPE=2 THEN 1 ELSE 0 END )C21, " +
            "		\"SUM\"(CASE WHEN DIS_TYPE=4 AND SUB_DIS_TYPE=3 THEN 1 ELSE 0 END )C31, " +
            "		\"SUM\"(CASE WHEN DIS_TYPE=4 AND SUB_DIS_TYPE=4 THEN 1 ELSE 0 END )C41 " ;


    private static final String TOWN_SQL=""+
            "WITH TOWN AS ( " +
            "	SELECT " +
            "		* " +
            "	FROM " +
            "		V_MDM_TOWN     " +
            "	UNION " +
            "		SELECT '-2' AS GB_CODE, '外地诊断' AS GB_NAME FROM dual " +
            "	UNION " +
            "		SELECT '-1' AS GB_CODE, '合计' AS GB_NAME FROM dual  " +
            ")  " +
            "SELECT " +
            "	TOWN.GB_CODE AS ORGAN_CODE, " +
            "	A.*,B.* " +
            "FROM " +
            "	TOWN town " +
            "LEFT JOIN ( " +
            "	SELECT " +
            "		DECODE ( GROUPING_ID (ORGAN_CODE), 1, '-1', ORGAN_CODE ) ORGAN_CODE1, " +
            "  %3$s "+

            "	FROM " +
            "		( " +
            "			SELECT " +
            "				R.*,  	O.GB_CODE " +
            "			END AS ORGAN_CODE " +
            "			FROM " +
            "				V_DM_REPORT_INFO R " +
            "			LEFT JOIN V_MDM_ORGANIZATION_NOSUB O ON R.CREATE_ORGAN_CODE = O.ORGAN_CODE " +
            "			WHERE R.REPORT_TYPE='1' AND   R.REPORT_STATUS !=5  AND   %1$s  " +
            "		) GROUP BY  rollup (ORGAN_CODE) " +
            ") A ON A.ORGAN_CODE1 = TOWN.gb_code " +
            "LEFT JOIN ( " +
            "	SELECT " +
            "		DECODE ( GROUPING_ID (ORGAN_CODE), 1, '-1', ORGAN_CODE ) ORGAN_CODE2, " +
            "  %4$s "+
            "	FROM " +
            "		( " +
            "			SELECT " +
            "				R.*, O.GB_CODE " +
            "			END AS ORGAN_CODE " +

            "			FROM " +
            "				V_DM_REPORT_INFO R " +
            "			LEFT JOIN V_MDM_ORGANIZATION_NOSUB O ON R.CREATE_ORGAN_CODE = O.ORGAN_CODE " +
            "			WHERE R.REPORT_STATUS !=5   AND R.REPORT_TYPE='1' AND    %2$s  " +
            "		) GROUP BY  rollup (ORGAN_CODE) " +
            ")B ON B.ORGAN_CODE2 = TOWN.GB_CODE" +
            " ORDER BY ORGAN_CODE";


    private final static String SINGLE_ORG_SQL=""+
            "WITH ORG AS ( " +
            "			SELECT ORGAN_CODE,ORGAN_NAME FROM  " +
            "					V_MDM_ORGANIZATION_NOSUB O " +
            "					WHERE " +
            "					O.ORGAN_CODE=:orgCode And O.GENRE_CODE in("+"'"+OrgGenreCode.CENTRE.getValue() +"','"+ OrgGenreCode.HOSPITAL.getValue()+ "','"+ OrgGenreCode.OTHER.getValue()+ "'" +")  " +
            "	)  " +
            "	SELECT * FROM(  " +
            "	SELECT " +
            "		DECODE ( GROUPING_ID (ORGAN_CODE), 1, '-1', ORGAN_CODE ) ORGAN_CODE, " +
            "  %3$s "+
            "	FROM " +
            "		( " +
            "			SELECT " +
            "				O.ORGAN_CODE	ORGAN_CODE,O.ORGAN_NAME,R.* " +
            "			FROM " +
            "				(SELECT * FROM V_DM_REPORT_INFO R  WHERE R.REPORT_STATUS !=5  AND  R.REPORT_TYPE='1'    AND   %1$s " +//TODO 不用!=实现
            "				)R " +
            "			RIGHT  JOIN ORG O ON R.CREATE_ORGAN_CODE = O.ORGAN_CODE " +
            "		) A " +
            "		GROUP BY  rollup (A.ORGAN_CODE))A  INNER JOIN  " +
            "( " +
            "	 " +
            "	SELECT " +
            "		DECODE ( GROUPING_ID (ORGAN_CODE), 1, '-1', ORGAN_CODE ) ORGAN_CODE2, " +
            "  %4$s "+
            "	FROM " +
            "		( " +
            "			SELECT " +
            "				O.ORGAN_CODE	ORGAN_CODE,O.ORGAN_NAME,R.* " +
            "			FROM " +
            "				(SELECT * FROM V_DM_REPORT_INFO R WHERE  R.REPORT_STATUS !=5 AND R.REPORT_TYPE='1'     AND %2$s " +

            "				)R " +
            "			RIGHT  JOIN ORG O ON R.CREATE_ORGAN_CODE = O.ORGAN_CODE " +
            "		) A " +
            "		GROUP BY  rollup (A.ORGAN_CODE))B ON A.ORGAN_CODE=B.ORGAN_CODE2";

    private final static String ORG_SQL=""+
            "WITH ORG AS ( " +
            "			SELECT ORGAN_CODE,ORGAN_NAME FROM  " +
            "					V_MDM_ORGANIZATION_NOSUB O " +
            "					WHERE " +
            "					O.GB_CODE=:orgCode And O.GENRE_CODE in("+"'"+OrgGenreCode.CENTRE.getValue() +"','"+ OrgGenreCode.HOSPITAL.getValue()+ "','"+ OrgGenreCode.OTHER.getValue()+ "'" +")  " +
            "	)  " +
            "	SELECT * FROM(  " +
            "	SELECT " +
            "		DECODE ( GROUPING_ID (ORGAN_CODE), 1, '-1', ORGAN_CODE ) ORGAN_CODE, " +
            "  %3$s "+
            "	FROM " +
            "		( " +
            "			SELECT " +
            "				O.ORGAN_CODE	ORGAN_CODE,O.ORGAN_NAME,R.* " +
            "			FROM " +
            "				(SELECT * FROM V_DM_REPORT_INFO R  WHERE R.REPORT_STATUS !=5  AND  R.REPORT_TYPE='1'    AND   %1$s " +//TODO 不用!=实现
            "				)R " +
            "			RIGHT  JOIN ORG O ON R.CREATE_ORGAN_CODE = O.ORGAN_CODE " +
            "		) A " +
            "		GROUP BY  rollup (A.ORGAN_CODE))A  INNER JOIN  " +
            "( " +
            "	 " +
            "	SELECT " +
            "		DECODE ( GROUPING_ID (ORGAN_CODE), 1, '-1', ORGAN_CODE ) ORGAN_CODE2, " +
            "  %4$s "+
            "	FROM " +
            "		( " +
            "			SELECT " +
            "				O.ORGAN_CODE	ORGAN_CODE,O.ORGAN_NAME,R.* " +
            "			FROM " +
            "				(SELECT * FROM V_DM_REPORT_INFO R WHERE  R.REPORT_STATUS !=5 AND R.REPORT_TYPE='1'   AND %2$s " +

            "				)R " +
            "			RIGHT  JOIN ORG O ON R.CREATE_ORGAN_CODE = O.ORGAN_CODE " +
            "		) A " +
            "		GROUP BY  rollup (A.ORGAN_CODE))B ON A.ORGAN_CODE=B.ORGAN_CODE2";
    //显示镇和机构
    private final static String TOWN_ORG_SQL=""+
            "WITH ORG AS ( " +
            "			SELECT ORGAN_CODE,ORGAN_NAME,GB_CODE FROM  " +
            "					V_MDM_ORGANIZATION_NOSUB O " +
            "					WHERE " +
            "					 O.GENRE_CODE in("+"'"+OrgGenreCode.CENTRE.getValue() +"','"+ OrgGenreCode.HOSPITAL.getValue()+ "','"+ OrgGenreCode.OTHER.getValue()+ "'" +")  " +
            "	)  " +
            "	SELECT * FROM(  " +
            "	SELECT " +
            "		DECODE ( GROUPING_ID (GB_CODE), 1, '-1', GB_CODE ) GB_CODE, " +
            "		DECODE ( GROUPING_ID (ORGAN_CODE), 1, '-1', ORGAN_CODE ) ORGAN_CODE, " +
            "  %4$s "+
            "	FROM " +
            "		( " +
            "			SELECT " +
            "				O.ORGAN_CODE	ORGAN_CODE,O.GB_CODE GB_CODE ,O.ORGAN_NAME,R.* " +
            "			FROM " +
            "				(SELECT * FROM V_DM_REPORT_INFO R WHERE  R.REPORT_STATUS !=5 AND R.REPORT_TYPE='1'   AND %2$s " +

            "				)R " +
            "			RIGHT  JOIN ORG O ON R.CREATE_ORGAN_CODE = O.ORGAN_CODE " +
            "		) A " +
            "		GROUP BY  rollup (A.GB_CODE,A.ORGAN_CODE))A  LEFT JOIN  " +
            "( " +
            "	SELECT " +
            "		DECODE ( GROUPING_ID (GB_CODE), 1, '-1', GB_CODE ) GB_CODE2, " +
            "		DECODE ( GROUPING_ID (ORGAN_CODE), 1, '-1', ORGAN_CODE ) ORGAN_CODE2, " +
            "  %3$s "+
            "	FROM " +
            "		( " +
            "			SELECT " +
            "				O.ORGAN_CODE	ORGAN_CODE, O.GB_CODE GB_CODE ,O.ORGAN_NAME,R.* " +
            "			FROM " +
            "				(SELECT * FROM V_DM_REPORT_INFO R  WHERE R.REPORT_STATUS !=5  AND  R.REPORT_TYPE='1'   AND   %1$s " +
            "				)R " +
            "			RIGHT  JOIN ORG O ON R.CREATE_ORGAN_CODE = O.ORGAN_CODE " +
            "		) A " +
            "		GROUP BY  rollup (A.GB_CODE,A.ORGAN_CODE))B ON A.ORGAN_CODE=B.ORGAN_CODE2 AND A.GB_CODE=B.GB_CODE2 ";

    private static final String TUMOR_SUM_SQL=""+
            "		\"SUM\"(CASE WHEN TUMOR_ICD_TEN_TYPE='1' OR TUMOR_ICD_TEN_TYPE='2'   THEN 1 ELSE 0 END) %1$sTOTAL, " ;
    private static final String MA_TUMOR_SUM_SQL=""+

            "		\"SUM\"(CASE WHEN TUMOR_ICD_TEN_TYPE='1'  THEN 1 ELSE 0 END ) %1$sMA_TOTAL, " +
            "		\"SUM\"(CASE WHEN TUMOR_ICD_TEN_TYPE='1' AND TUMOR_ICD_TEN_SHORT_CODE='C11' THEN 1 ELSE 0 END ) %1$sC11, " +
            "		\"SUM\"(CASE WHEN TUMOR_ICD_TEN_TYPE='1' AND TUMOR_ICD_TEN_SHORT_CODE='C15' THEN 1 ELSE 0 END ) %1$sC15, " +
            "		\"SUM\"(CASE WHEN TUMOR_ICD_TEN_TYPE='1' AND TUMOR_ICD_TEN_SHORT_CODE='C16' THEN 1 ELSE 0 END ) %1$sC16, " +
            "		\"SUM\"(CASE WHEN TUMOR_ICD_TEN_TYPE='1' AND TUMOR_ICD_TEN_SHORT_CODE='C18' THEN 1 ELSE 0 END ) %1$sC18, " +
            "		\"SUM\"(CASE WHEN TUMOR_ICD_TEN_TYPE='1' AND (TUMOR_ICD_TEN_SHORT_CODE='C19' OR TUMOR_ICD_TEN_SHORT_CODE='C20') THEN 1 ELSE 0 END ) %1$sC19, " +
            "		\"SUM\"(CASE WHEN TUMOR_ICD_TEN_TYPE='1' AND TUMOR_ICD_TEN_SHORT_CODE='C22' THEN 1 ELSE 0 END ) %1$sC22, " +
            "		\"SUM\"(CASE WHEN TUMOR_ICD_TEN_TYPE='1' AND (TUMOR_ICD_TEN_SHORT_CODE='C23' OR TUMOR_ICD_TEN_SHORT_CODE='C24') THEN 1 ELSE 0 END ) %1$sC23, " +
            "		\"SUM\"(CASE WHEN TUMOR_ICD_TEN_TYPE='1' AND TUMOR_ICD_TEN_SHORT_CODE='C25' THEN 1 ELSE 0 END ) %1$sC25, " +
            "		\"SUM\"(CASE WHEN TUMOR_ICD_TEN_TYPE='1' AND (TUMOR_ICD_TEN_SHORT_CODE='C33' OR TUMOR_ICD_TEN_SHORT_CODE='C34') THEN 1 ELSE 0 END ) %1$sC33, " +
            "		\"SUM\"(CASE WHEN TUMOR_ICD_TEN_TYPE='1' AND TUMOR_ICD_TEN_SHORT_CODE='C50' THEN 1 ELSE 0 END ) %1$sC50, " +
            "		\"SUM\"(CASE WHEN TUMOR_ICD_TEN_TYPE='1' AND TUMOR_ICD_TEN_SHORT_CODE='C53' THEN 1 ELSE 0 END ) %1$sC53, " +
            "		\"SUM\"(CASE WHEN TUMOR_ICD_TEN_TYPE='1' AND TUMOR_ICD_TEN_SHORT_CODE='C61' THEN 1 ELSE 0 END ) %1$sC61, " +
            "		\"SUM\"(CASE WHEN TUMOR_ICD_TEN_TYPE='1' AND TUMOR_ICD_TEN_SHORT_CODE='C67' THEN 1 ELSE 0 END ) %1$sC67, " +
            "		\"SUM\"(CASE WHEN TUMOR_ICD_TEN_TYPE='1' AND (TUMOR_ICD_TEN_SHORT_CODE='C70' OR TUMOR_ICD_TEN_SHORT_CODE='C71' OR TUMOR_ICD_TEN_SHORT_CODE='C72' ) THEN 1 ELSE 0 END ) %1$sC70, " +
            "		\"SUM\"(CASE WHEN TUMOR_ICD_TEN_TYPE='1' AND (TUMOR_ICD_TEN_SHORT_CODE='C81' OR TUMOR_ICD_TEN_SHORT_CODE='C82' OR TUMOR_ICD_TEN_SHORT_CODE='C83' OR TUMOR_ICD_TEN_SHORT_CODE='C84' OR TUMOR_ICD_TEN_SHORT_CODE='C85' OR TUMOR_ICD_TEN_SHORT_CODE='C88' OR TUMOR_ICD_TEN_SHORT_CODE='C90'  OR TUMOR_ICD_TEN_SHORT_CODE='C96'  ) THEN 1 ELSE 0 END ) %1$sC81, " +
            "		\"SUM\"(CASE WHEN TUMOR_ICD_TEN_TYPE='1' AND ( TUMOR_ICD_TEN_SHORT_CODE='C91' OR TUMOR_ICD_TEN_SHORT_CODE='C92' OR TUMOR_ICD_TEN_SHORT_CODE='C93' OR TUMOR_ICD_TEN_SHORT_CODE='C94' OR TUMOR_ICD_TEN_SHORT_CODE='C95'  ) THEN 1 ELSE 0 END ) %1$sC91, " ;
    private static final String NONMA_TUMOR_SUM_SQL=""+

            "		\"SUM\"(CASE WHEN TUMOR_ICD_TEN_TYPE='2'  THEN 1 ELSE 0 END ) %1$sNONMA_TOTAL, " +
            "		\"SUM\"(CASE WHEN TUMOR_ICD_TEN_TYPE='2' AND TUMOR_ICD_TEN_SHORT_CODE='D33' THEN 1 ELSE 0 END ) %1$sD33, ";



    private final static String SINGLE_ORG_ICD_SQL=""+
            "WITH ORG AS ( " +
            "			SELECT ORGAN_CODE,ORGAN_NAME FROM  " +
            "					V_MDM_ORGANIZATION_NOSUB O " +
            "					WHERE " +
            "					O.ORGAN_CODE=:orgCode And O.GENRE_CODE in("+"'"+OrgGenreCode.CENTRE.getValue() +"','"+ OrgGenreCode.HOSPITAL.getValue()+ "','"+ OrgGenreCode.OTHER.getValue()+ "'" +")  " +
            "	)  " +
            "	SELECT " +
            "		ICD_CODE,TUMOR_TYPE  " +
            "	FROM " +
            "		( " +
            "			SELECT " +
            "				TUMOR_ICD_TEN_SHORT_CODE AS ICD_CODE,TUMOR_ICD_TEN_TYPE AS TUMOR_TYPE " +
            "			FROM " +
            "				(SELECT * FROM V_DM_REPORT_INFO R  WHERE R.REPORT_STATUS !=5  AND  R.REPORT_TYPE='1'    AND   %1$s " +//TODO 不用!=实现
            "				)R " +
            "			RIGHT  JOIN ORG O ON R.CREATE_ORGAN_CODE = O.ORGAN_CODE " +
            "		) A " +
            "		GROUP BY A.ICD_CODE,A.TUMOR_TYPE  ";

    private final static String ORG_ICD_SQL=""+
            "WITH ORG AS ( " +
            "			SELECT ORGAN_CODE,ORGAN_NAME FROM  " +
            "					V_MDM_ORGANIZATION_NOSUB O " +
            "					WHERE " +
            "					O.GB_CODE=:orgCode And O.GENRE_CODE in("+"'"+OrgGenreCode.CENTRE.getValue() +"','"+ OrgGenreCode.HOSPITAL.getValue()+ "','"+ OrgGenreCode.OTHER.getValue()+ "'" +")  " +
            "	)  " +
            "	SELECT  	ICD_CODE,TUMOR_TYPE " +
            "	FROM " +
            "		( " +
            "			SELECT " +
            "				TUMOR_ICD_TEN_SHORT_CODE AS ICD_CODE,TUMOR_ICD_TEN_TYPE AS TUMOR_TYPE " +
            "			FROM " +
            "				(SELECT * FROM V_DM_REPORT_INFO R  WHERE R.REPORT_STATUS !=5  AND  R.REPORT_TYPE='1'    AND   %1$s " +//TODO 不用!=实现
            "				)R " +
            "			RIGHT  JOIN ORG O ON R.CREATE_ORGAN_CODE = O.ORGAN_CODE " +
            "		) A " +
            "		GROUP BY　 A.ICD_CODE,A.TUMOR_TYPE";
    //显示镇和机构
    private final static String TOWN_ORG_ICD_SQL2=""+
            "WITH ORG AS ( " +
            "			SELECT ORGAN_CODE,ORGAN_NAME,GB_CODE FROM  " +
            "					V_MDM_ORGANIZATION_NOSUB O " +
            "					WHERE " +
            "					 O.GENRE_CODE in("+"'"+OrgGenreCode.CENTRE.getValue() +"','"+ OrgGenreCode.HOSPITAL.getValue()+ "','"+ OrgGenreCode.OTHER.getValue()+ "'" +")  " +
            "	)  " +

            "	SELECT  ICD_CODE,TUMOR_TYPE" +
            "	FROM " +
            "		( " +
            "			SELECT TUMOR_ICD_TEN_SHORT_CODE AS ICD_CODE,TUMOR_ICD_TEN_TYPE AS TUMOR_TYPE  " +
            "			FROM " +
            "				(SELECT * FROM V_DM_REPORT_INFO R WHERE  R.REPORT_STATUS !=5 AND R.REPORT_TYPE='1'   AND %1$s " +

            "				)R " +
            "			RIGHT  JOIN ORG O ON R.CREATE_ORGAN_CODE = O.ORGAN_CODE " +
            "		) A " +
            "		GROUP BY A.ICD_CODE,A.TUMOR_TYPE ";


    //@fon

	private static Set<String> tumorKnownIcd10;

	@Override
	public List<Map<String, Object>> getCdMonthReport(String type, String gbCode, String orgCode, String month, String year) {
		List<Map<String, Object>> reports = buildCdSqlAndQuery(type, gbCode, orgCode, month, year, true, CD_SUM_SQL, CD_UPSUM_SQL);
		return reports;
	}

	@Override
	public List<Map<String, Object>> getCdSeasonReport(String type, String gbCode, String orgCode, String season, String year) {
		List<Map<String, Object>> reports = buildCdSqlAndQuery(type, gbCode, orgCode, season, year, false, CD_SUM_SQL, CD_UPSUM_SQL);
		return reports;
	}

	@Override
	public TumorMonthSeasonReport getTumorSeasonReport(String type, String gbCode, String orgCode, String season, String year) {
		TumorMonthSeasonReport reports = getTumorResult(type, gbCode, orgCode, season, year, false);
		return reports;
	}

	@Override
	public TumorMonthSeasonReport getTumorMonthReport(String type, String gbCode, String orgCode, String month, String year) {
		TumorMonthSeasonReport reports = getTumorResult(type, gbCode, orgCode, month, year, true);
		return reports;
	}

	private TumorMonthSeasonReport getTumorResult(String type, String gbCode, String orgCode, String month, String year, boolean isMonth) {
		Set<String> malignants = new HashSet<>();// 恶性
		Set<String> nonMalignants = new HashSet<>();// 非恶性
		// 查找指定icd之外的全部肿瘤
		findOtherTumorIcd(malignants, nonMalignants,type, gbCode, orgCode, month, year, isMonth);

		// 生成 合计 select 字段sql
		String tumorTotalSqlString = buildTumorSelectFieldSql(malignants, nonMalignants, "");
		// 生成 累计 select 字段sql
		String tumorUpTotalSqlString = buildTumorSelectFieldSql(malignants, nonMalignants, "UP_");

		List<Map<String, Object>> reports = buildCdSqlAndQuery(type, gbCode, orgCode, month, year, isMonth, tumorTotalSqlString, tumorUpTotalSqlString);

		TumorMonthSeasonReport report = new TumorMonthSeasonReport();
		report.setMalignants(malignants);
		report.setNonMalignants(nonMalignants);
		report.setReports(reports);

		return report;
	}

	private void findOtherTumorIcd(Set<String> malignants, Set<String> nonMalignants,String type, String gbCode, String orgCode, String month, String year, boolean isMonth) {
		List<Map<String, Object>> tumorIcdList = getTumorAllIcdCodeAndType(type,gbCode,orgCode,month,year,isMonth);
		for (Map<String, Object> map : tumorIcdList) {
			String icdString = (String) map.get("icdCode");
			if (ObjectUtil.isNotEmpty(icdString)&&!tumorKnownIcd10.contains(icdString)) {
				if (EHRConstants.DM_TUMOR_MALIGNANT_TYPE.equals(map.get("tumorType"))) {
					malignants.add(icdString);
				} else {
					nonMalignants.add(icdString);
				}
			}
		}
	}

	private String buildTumorSelectFieldSql(Set<String> malignants, Set<String> nonMalignants, String preFix) {
		StringBuilder tumorTotalSqlBuilder = new StringBuilder(String.format(TUMOR_SUM_SQL, preFix));
		tumorTotalSqlBuilder.append(String.format(MA_TUMOR_SUM_SQL, preFix));
		for (String icd : malignants) {
			tumorTotalSqlBuilder.append(" \"SUM\"(CASE WHEN TUMOR_ICD_TEN_TYPE=1 AND TUMOR_ICD_TEN_SHORT_CODE= '").append(icd).append("'  THEN 1 ELSE 0 END ) \"").append(preFix).append(icd)
					.append("\" , \n");
		}
		tumorTotalSqlBuilder.append(String.format(NONMA_TUMOR_SUM_SQL, preFix));
		for (String icd : nonMalignants) {
			tumorTotalSqlBuilder.append(" \"SUM\"(CASE WHEN TUMOR_ICD_TEN_TYPE =2 AND TUMOR_ICD_TEN_SHORT_CODE= '").append(icd).append("'  THEN 1 ELSE 0 END ) \"").append(preFix).append(icd)
					.append("\",\n  ");
		}
		return tumorTotalSqlBuilder.substring(0, tumorTotalSqlBuilder.lastIndexOf(","));
	}


    @Override
    public List<Map<String, Object>> getTumorAllIcdCodeAndType() {
        String sql = "" + "SELECT\n" + "	TUMOR_ICD_TEN_SHORT_CODE AS ICD_CODE,\n" + "	TUMOR_ICD_TEN_TYPE AS TUMOR_TYPE\n" + "FROM\n" + "	V_DM_REPORT_INFO\n" + "WHERE\n" + "	DIS_TYPE = 5\n"
                + "GROUP BY\n" + "	TUMOR_ICD_TEN_SHORT_CODE,\n" + "	TUMOR_ICD_TEN_TYPE ";
        List<Map<String, Object>> resultList = query(sql, null);
        return resultList;
    }


	private List<Map<String, Object>> getTumorAllIcdCodeAndType(String type, String gbCode, String orgCode, String month, String year, boolean isMonth) {
        String sql = "";
        // 参数设置
        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        sqlParameterSource.addValue("year", year);
        sqlParameterSource.addValue("month", month);

        // sql
        StringBuilder condition = new StringBuilder();
        buildCondition(type, isMonth, condition);// 合计sql 条件
        StringBuilder upTotalCondition = new StringBuilder();
        buildUpTotalCondition(type, isMonth, upTotalCondition);// 累计sql 条件

        if (ObjectUtil.isNotEmpty(orgCode)) {
            sql = String.format(SINGLE_ORG_ICD_SQL,  upTotalCondition);//
            sqlParameterSource.addValue("orgCode", orgCode); // 加入机构参数
        } else if (ObjectUtil.isNotEmpty(gbCode)) {
            sql = String.format(ORG_ICD_SQL, upTotalCondition);//
            sqlParameterSource.addValue("orgCode", gbCode); // 加入机构参数
        } else {
            sql = String.format(TOWN_ORG_ICD_SQL2,  upTotalCondition);//
        }
		List<Map<String, Object>> resultList = query(sql, sqlParameterSource);
		return resultList;
	}

	private List<Map<String, Object>> buildCdSqlAndQuery(String type, String gbCode, String orgCode, String month, String year, boolean isMonth, String sum, String upSum) {
		String sql = "";
		// 参数设置
		MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
		sqlParameterSource.addValue("year", year);
		sqlParameterSource.addValue("month", month);

		// sql
		StringBuilder condition = new StringBuilder();
		buildCondition(type, isMonth, condition);// 合计sql 条件
		StringBuilder upTotalCondition = new StringBuilder();
		buildUpTotalCondition(type, isMonth, upTotalCondition);// 累计sql 条件

		if (ObjectUtil.isNotEmpty(orgCode)) {
			sql = String.format(SINGLE_ORG_SQL, condition, upTotalCondition, sum, upSum);//
			sqlParameterSource.addValue("orgCode", orgCode); // 加入机构参数
		} else if (ObjectUtil.isNotEmpty(gbCode)) {
			sql = String.format(ORG_SQL, condition, upTotalCondition, sum, upSum);//
			sqlParameterSource.addValue("orgCode", gbCode); // 加入机构参数
		} else {
			//sql = String.format(TOWN_SQL, condition, upTotalCondition, sum, upSum);//
			sql = String.format(TOWN_ORG_SQL, condition, upTotalCondition, sum, upSum);//
		}

		// execute
		List<Map<String, Object>> reports = query(sql, sqlParameterSource);
		return reports;
	}

	private List<Map<String, Object>> query(String sql, MapSqlParameterSource sqlParameterSource) {
		if (null == sqlParameterSource) {
			return simpleJdbcTemplate.query(sql, new ColumnMapRowMapper());
		}
		return simpleJdbcTemplate.query(sql, new ColumnMapRowMapper(), sqlParameterSource);
	}

	private void buildCondition(String dateType, boolean isMonthReport, StringBuilder sql) {
		if ("2".equals(dateType)) {
			sql.append("EXTRACT ( YEAR FROM R.CD_DIAGNOSIS_DATE ) = :year \n");
			if (isMonthReport) {
				sql.append("	AND EXTRACT ( MONTH FROM R.CD_DIAGNOSIS_DATE ) = :month \n");
			} else {
				sql.append("AND CEIL(EXTRACT (MONTH FROM R.CD_DIAGNOSIS_DATE )/3) = :month \n");
			}

		} else {
			sql.append("EXTRACT ( YEAR FROM R.CREATE_DATE ) = :year \n");
			if (isMonthReport) {
				sql.append("	AND EXTRACT ( MONTH FROM R.CREATE_DATE ) = :month \n");
			} else {
				sql.append("AND CEIL(EXTRACT (MONTH FROM R.CREATE_DATE)/3) = :month \n");
			}
		}
	}

	private void buildUpTotalCondition(String dateType, boolean isMonthReport, StringBuilder sql) {
		if ("2".endsWith(dateType)) {
			sql.append("EXTRACT ( YEAR FROM R.CD_DIAGNOSIS_DATE ) = :year \n");
			if (isMonthReport) {
				sql.append("	AND EXTRACT ( MONTH FROM R.CD_DIAGNOSIS_DATE )  <= :month \n");
			} else {
				sql.append("AND CEIL(EXTRACT (MONTH FROM R.CD_DIAGNOSIS_DATE )/3)  <= :month \n");
			}

		} else {
			sql.append("EXTRACT ( YEAR FROM R.CREATE_DATE ) = :year \n");
			if (isMonthReport) {
				sql.append("	AND EXTRACT ( MONTH FROM R.CREATE_DATE )  <= :month \n");
			} else {
				sql.append("AND CEIL(EXTRACT (MONTH FROM R.CREATE_DATE)/3)  <= :month \n");
			}
		}
	}

	@PostConstruct
	public void init() {
		tumorKnownIcd10 = new HashSet<>();
		tumorKnownIcd10.add("C11"); // 鼻咽
		tumorKnownIcd10.add("C15"); // 食管
		tumorKnownIcd10.add("C16"); // 胃
		tumorKnownIcd10.add("C18"); // 结肠

		tumorKnownIcd10.add("C19"); // 直肠
		tumorKnownIcd10.add("C20"); // 直肠

		tumorKnownIcd10.add("C22"); // 肝和肝内胆管 C22

		tumorKnownIcd10.add("C23"); // 胆囊和肝外胆管 C23,C24
		tumorKnownIcd10.add("C24");// 胆囊和肝外胆管 C23,C24

		tumorKnownIcd10.add("C25"); // 胰腺 C25

		tumorKnownIcd10.add("C33"); // 气管、支气管和肺 C33,C34
		tumorKnownIcd10.add("C34"); // 气管、支气管和肺 C33,C34

		tumorKnownIcd10.add("C50"); // 乳房 C50

		tumorKnownIcd10.add("C53"); // 宫颈 C53

		tumorKnownIcd10.add("C61"); // 前列腺 C61

		tumorKnownIcd10.add("C67"); // 膀胱 C67

		tumorKnownIcd10.add("C70");// 脑、神经系统 C70-C72
		tumorKnownIcd10.add("C71");// 脑、神经系统 C70-C72
		tumorKnownIcd10.add("C72");// 脑、神经系统 C70-C72

		tumorKnownIcd10.add("C81"); // 恶性淋巴瘤 C81-C85；C88；C90；C96
		tumorKnownIcd10.add("C82"); // 恶性淋巴瘤 C81-C85；C88；C90；C96
		tumorKnownIcd10.add("C83"); // 恶性淋巴瘤 C81-C85；C88；C90；C96
		tumorKnownIcd10.add("C84"); // 恶性淋巴瘤 C81-C85；C88；C90；C96
		tumorKnownIcd10.add("C85"); // 恶性淋巴瘤 C81-C85；C88；C90；C96
		tumorKnownIcd10.add("C88"); // 恶性淋巴瘤 C81-C85；C88；C90；C96
		tumorKnownIcd10.add("C90"); // 恶性淋巴瘤 C81-C85；C88；C90；C96
		tumorKnownIcd10.add("C96"); // 恶性淋巴瘤 C81-C85；C88；C90；C96

		tumorKnownIcd10.add("C91"); // 白血病 C91-C95
		tumorKnownIcd10.add("C92"); // 白血病 C91-C95
		tumorKnownIcd10.add("C93"); // 白血病 C91-C95
		tumorKnownIcd10.add("C94"); // 白血病 C91-C95
		tumorKnownIcd10.add("C95"); // 白血病 C91-C95

		tumorKnownIcd10.add("D33"); // 脑/神经系统良性肿瘤
	}

	@Override
	protected SimpleJdbcTemplate getSimpleJdbcTemplate() {
		return simpleJdbcTemplate;
	}



	/**
	 * 将column 转成javabean标准属性名
	 * 
	 * @author liuk
	 * 
	 */
	private class ColumnMapRowMapper implements RowMapper<Map<String, Object>> {

		public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			Map<String, Object> mapOfColValues = createColumnMap(columnCount);
			for (int i = 1; i <= columnCount; i++) {
				String key = getColumnKey(JdbcUtils.lookupColumnName(rsmd, i));
				Object obj = getColumnValue(rs, i);
				mapOfColValues.put(key, obj);
			}
			return mapOfColValues;
		}

		protected Map<String, Object> createColumnMap(int columnCount) {
			return new LinkedCaseInsensitiveMap<Object>(columnCount);
		}

		protected String getColumnKey(String columnName) {
			return JdbcUtils.convertUnderscoreNameToPropertyName(columnName.toLowerCase());
		}

		protected Object getColumnValue(ResultSet rs, int index) throws SQLException {
			return JdbcUtils.getResultSetValue(rs, index);
		}

	}

}
