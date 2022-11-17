package com.founder.rhip.ehr.repository.control.idm.notifiabledisease;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmAnorectaReportTable;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository("idmAnorectaReportTableDao")
public class IdmAnorectaReportTableDaoImpl extends AbstractDao<IdmAnorectaReportTable, Integer> implements IIdmAnorectaReportTableDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    public List<Map<String, Object>> statisticsAnorecta(Criteria ca){
    	/* WITH ORG_RESULT AS 
			( SELECT CASE 
		      WHEN genre_code = 'B100' THEN organ_code
		      WHEN genre_code = 'B200' THEN PARENT_CODE
		      ELSE '-1' END PARENT_CODE, organ_code, genre_code,sort
		    FROM mdm_organization WHERE genre_code IN ('A100', 'B100', 'B200','J100') ORDER BY sort ),
		ANORECTA as ( select FILL_ORGAN_CODE ORGAN_CODE, sum(nvl(TS_DIA_REG_NUM,'0')) TS_DIA_REG_NUM, sum(nvl(VI_DIA_REG_NUM,'0')) VI_DIA_REG_NUM, 
		sum(nvl(ST_DIA_REG_NUM,'0')) ST_DIA_REG_NUM, sum(nvl(RETRIEVAL_NUM,'0')) RETRIEVAL_NUM, sum(nvl(CHOLERA_POSI_O1,'0')) CHOLERA_POSI_O1, sum(nvl(CHOLERA_POSI_O139,'0')) CHOLERA_POSI_O139 
		from IDM_ANORECTA_REPORT_TABLE WHERE TO_CHAR(REPORT_DATE,'yyyy/MM/dd') >= '2017/01/01' and TO_CHAR(REPORT_DATE,'yyyy/MM/dd') <= '2017/12/31' 
		group by FILL_ORGAN_CODE )
		
		SELECT 
		final_result.*, 
				DECODE(final_result.RETRIEVAL_NUM,0,0,final_result.RETRIEVAL_NUM/final_result.ST_DIA_REG_NUM)  RETRIEVAL_RATE,
				ORG_RESULT.sort, ORG_RESULT.genre_code
		FROM (
		SELECT DECODE(grouping_id(ORG.parent_code, ORG.organ_code),3,'合计',ORG.parent_code) parent_code, ORG.organ_code,
			  nvl(sum(TS_DIA_REG_NUM), 0)  TS_DIA_REG_NUM,
			  nvl(sum(VI_DIA_REG_NUM), 0)  VI_DIA_REG_NUM,
			  nvl(sum(ST_DIA_REG_NUM), 0)  ST_DIA_REG_NUM,
			  nvl(sum(RETRIEVAL_NUM), 0)  RETRIEVAL_NUM,
			  nvl(sum(CHOLERA_POSI_O1), 0)  CHOLERA_POSI_O1,
			  nvl(sum(CHOLERA_POSI_O139), 0)  CHOLERA_POSI_O139
			FROM ORG_RESULT ORG
				LEFT JOIN  ANORECTA ANO ON ORG.organ_code = ANO.ORGAN_CODE
				GROUP BY rollup(ORG.parent_code, ORG.organ_code)
				order by ORG.parent_code, ORG.organ_code
		) final_result left join ORG_RESULT on final_result.organ_code = ORG_RESULT.organ_code order by sort
		*/
    	String beginStr;
    	String endStr;
		String orgSql = "";
		if(ObjectUtil.isNotEmpty(ca.get("stationCode"))) {
			orgSql = " and organ_code = '" + ca.get("stationCode").toString() + "'";
		} else if(ObjectUtil.isNotEmpty(ca.get("centreCode"))) {
			orgSql = " and (organ_code = '" + ca.get("centreCode").toString() + "' or parent_code = '" + ca.get("centreCode").toString() + "')";
		}

		StringBuffer sql = new StringBuffer("WITH ORG_RESULT AS(SELECT CASE \n" +
				"      WHEN genre_code = 'B100' THEN organ_code\n" +
				"      WHEN genre_code = 'B200' THEN PARENT_CODE\n" +
				"      ELSE '-1' END PARENT_CODE, organ_code, genre_code,sort\n" +
				"  FROM mdm_organization WHERE genre_code IN ('A100', 'B100', 'B200','J100')" + orgSql +
				" ORDER BY sort),\n" );
	    sql.append("  ANORECTA as ( select FILL_ORGAN_CODE ORGAN_CODE, sum(nvl(TS_DIA_REG_NUM,'0')) TS_DIA_REG_NUM, sum(nvl(VI_DIA_REG_NUM,'0')) VI_DIA_REG_NUM, "
	    		+ " sum(nvl(ST_DIA_REG_NUM,'0')) ST_DIA_REG_NUM, sum(nvl(RETRIEVAL_NUM,'0')) RETRIEVAL_NUM, sum(nvl(CHOLERA_POSI_O1,'0')) CHOLERA_POSI_O1, sum(nvl(CHOLERA_POSI_O139,'0')) CHOLERA_POSI_O139  "
	    		+ " from IDM_ANORECTA_REPORT_TABLE WHERE 1 =1\n");
	    if(ObjectUtil.isNotEmpty(ca.get("beginDate")) && ObjectUtil.isNotEmpty(beginStr = ca.get("beginDate").toString())) {
			sql.append(" AND TO_CHAR(REPORT_DATE,'yyyy/MM/dd') >= '"+ beginStr + "'");
		}
		if(ObjectUtil.isNotEmpty(ca.get("endDate")) && ObjectUtil.isNotEmpty(endStr = ca.get("endDate").toString())) {
			sql.append(" AND TO_CHAR(REPORT_DATE,'yyyy/MM/dd') <= '"+ endStr + "'");
		}
		sql.append("   GROUP BY FILL_ORGAN_CODE)\n" );

		sql.append(" SELECT final_result.*, DECODE(final_result.RETRIEVAL_NUM,0,0,final_result.RETRIEVAL_NUM/final_result.ST_DIA_REG_NUM)  RETRIEVAL_RATE,ORG_RESULT.sort, ORG_RESULT.genre_code "
				+ " FROM ( "
						+ " SELECT DECODE(grouping_id(ORG.parent_code, ORG.organ_code),3,'合计',ORG.parent_code) parent_code, ORG.organ_code, "
						+ "  nvl(sum(TS_DIA_REG_NUM), 0)  TS_DIA_REG_NUM,  nvl(sum(VI_DIA_REG_NUM), 0)  VI_DIA_REG_NUM, "
						+ " nvl(sum(ST_DIA_REG_NUM), 0)  ST_DIA_REG_NUM, nvl(sum(RETRIEVAL_NUM), 0)  RETRIEVAL_NUM, "
						+ "  nvl(sum(CHOLERA_POSI_O1), 0)  CHOLERA_POSI_O1, nvl(sum(CHOLERA_POSI_O139), 0)  CHOLERA_POSI_O139 "
						+ " FROM ORG_RESULT ORG LEFT JOIN  ANORECTA ANO ON ORG.organ_code = ANO.ORGAN_CODE 	GROUP BY rollup(ORG.parent_code, ORG.organ_code) order by ORG.parent_code, ORG.organ_code "
				+ " ) final_result left join ORG_RESULT on final_result.organ_code = ORG_RESULT.organ_code order by sort ");   
    	return this.getMapList(sql.toString(), new Criteria());
    }

}