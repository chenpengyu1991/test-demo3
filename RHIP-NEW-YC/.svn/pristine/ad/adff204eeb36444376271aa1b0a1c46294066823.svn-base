package com.founder.rhip.ehr.repository.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.PersonDeathRecord;

/**
 * DAO implement of AdministrativeArea
 * 
 */
@Repository("lifeEventDao")
public class LifeEventDaoImpl extends
		AbstractDao<PersonDeathRecord, Long> implements ILifeEventDao {

    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    private List<PersonDeathRecord> topTenDeath = new ArrayList<PersonDeathRecord>();
    /*查询出死亡在前十的疾病名称*/
    private static final String TOP_TEN_DEATH_SQL = "select * from ("
    		+ " select t.death_icd,t.death_reason, count(death_icd) total"
    		+ " from person_death_record t" 
    		+ " group by t.death_icd,death_reason"
    		+ " order by total DESC)"
    		+ " where rownum <= 10";
    
    private static final String DEATH_ICD10_SQL = "SELECT *"
    		+ " FROM (SELECT decode(grouping_id(%11$s), 1, '合计', %11$s) AS input_organcode,"
    		+ " count(death_icd) total,"
    		+ " SUM(CASE WHEN death_icd = '%1$s' THEN 1  ELSE 0 END) AS one,"
    		+ " SUM(CASE WHEN death_icd = '%2$s' THEN 1  ELSE 0 END) AS two,"
    		+ " SUM(CASE WHEN death_icd = '%3$s' THEN 1  ELSE 0 END) AS three,"
    		+ " SUM(CASE WHEN death_icd = '%4$s' THEN 1  ELSE 0 END) AS four,"
    		+ " SUM(CASE WHEN death_icd = '%5$s' THEN 1  ELSE 0 END) AS five,"
    		+ " SUM(CASE WHEN death_icd = '%6$s' THEN 1  ELSE 0 END) AS six,"
    		+ " SUM(CASE WHEN death_icd = '%7$s' THEN 1  ELSE 0 END) AS seven,"
    		+ " SUM(CASE WHEN death_icd = '%8$s' THEN 1  ELSE 0 END) AS eight,"
    		+ " SUM(CASE WHEN death_icd = '%9$s' THEN 1  ELSE 0 END) AS nine,"
    		+ " SUM(CASE WHEN death_icd = '%10$s' THEN 1  ELSE 0 END) AS ten"
    		+ " FROM (SELECT org.gb_code,org.parent_code,org.ORGAN_CODE,org.GENRE_CODE,record.*"
    		+ " FROM V_MDM_ORGANIZATION_NOSUB ORG"
    		+ " LEFT JOIN (SELECT t.death_icd,t.death_reason,t.name,t.input_organcode,t.input_date"
    		+ " FROM person_death_record t"
    		+ " %12$s) record ON record.input_organcode = ORG.ORGAN_CODE"
    		+ " WHERE 1 = 1 %13$s)"
			+ " GROUP BY CUBE(%11$s)  ORDER BY ORGAN_CODE)"
    		+ " WHERE input_organcode is not null";

	private static final String DEATH_ICD10_ANALYSE_SQL = "SELECT * FROM(\n" +
			"	SELECT decode(grouping_id(DEATH_ICD), 1, 'TOTAL', 'OTHER') AS GROUPINGID,\n" +
			"		DEATH_ICD,COUNT(1) DEATH_COUNT\n" +
			"	FROM PERSON_DEATH_RECORD\n" +
			"	%1$s" +
			"	GROUP BY rollup(DEATH_ICD)\n" +
			"	ORDER BY DEATH_COUNT DESC\n" +
			")\n" +
			"WHERE ((GROUPINGID = 'OTHER' AND DEATH_ICD IS  NOT NULL) OR GROUPINGID = 'TOTAL')\n" +
			"AND (rownum <=10 or GROUPINGID = 'TOTAL')\n" +
			"ORDER BY DEATH_COUNT DESC";


	private static final String PERSON_TYPE_ANALYSE_SQL = "SELECT SUM(DEATH_COUNT1) DEATH_COUNT1, \n" +
			"	SUM(DEATH_COUNT2) DEATH_COUNT2, \n" +
			"	SUM(DEATH_COUNT3) DEATH_COUNT3 \n" +
			"	FROM(" +
			"		SELECT DECODE(PERSON_TYPE,'1',1,0) DEATH_COUNT1\n" +
			"		,DECODE(PERSON_TYPE,'2',1,0) DEATH_COUNT2\n" +
			"		,DECODE(PERSON_TYPE,'3',1,0) DEATH_COUNT3\n" +
			"	FROM PERSON_DEATH_RECORD\n" +
			"	%1$s" +
			")\n";

    /**
     * 获取死亡最高的前十种病
     * @return
     */
    @Override
    public List<PersonDeathRecord> getTopTenDeath(Criteria criteria) {
    	/*Criteria criteria1 = new Criteria();
    	if(ObjectUtil.isNotEmpty(criteria)) {
    		criteria.remove("GB_CODE");
    		criteria.remove("ORGAN_CODE");
    		criteria.remove("genreCode");
    	}*/
    	/*StringBuilder sql = new StringBuilder(TOP_TEN_DEATH_SQL);
		StringBuilder  whereSQL = new StringBuilder();
		SqlBuilder.buildWhereStatement(PersonDeathRecord.class, whereSQL, criteria);
		String lastSql = String.format(sql.toString(),whereSQL.toString());*/
		/*List<PersonDeathRecord> tempTenDeath = this.getList(lastSql,null);
		topTenDeath = new ArrayList<PersonDeathRecord>();
		if(tempTenDeath.size() > 10) {
			for(int i = 1; i <=10; i++) {
				topTenDeath.add(tempTenDeath.get(i));
			}
		} else {
			topTenDeath = tempTenDeath;
		}*/
    	topTenDeath = this.getList(TOP_TEN_DEATH_SQL,null);
    	return topTenDeath;
    }

    /**
     * 统计死于最高的前十种病的人口数目
     * @param criteria
     * @return
     */
    @Override
    public List<PersonDeathRecord> getDeathICD10TargetList(Criteria criteria) {
    	if(ObjectUtil.isNullOrEmpty(topTenDeath)) {
    		getTopTenDeath(criteria);
    	}
    	//PersonDeathRecord[) topArray = (PersonDeathRecord[)) topTenDeath.toArray();
    	StringBuilder sql = new StringBuilder(DEATH_ICD10_SQL);
		StringBuilder  whereSQL1 = new StringBuilder();
		StringBuilder  whereSQL2 = new StringBuilder();
		String genreCode = criteria.get("genreCode").toString();
		if(!"0".equals(genreCode)){
			whereSQL2.append(" AND GENRE_CODE='" + genreCode + "'");//机构类型
		}
		String orgField = "0".equals(genreCode)?"GB_CODE":"ORGAN_CODE";
		Object gbCode = criteria.get("GB_CODE");
		Object organCode = criteria.get("ORGAN_CODE");
		if(ObjectUtil.isNotEmpty(gbCode)){
			whereSQL2.append(" AND GB_CODE='" + gbCode.toString() + "'");
			criteria.remove("GB_CODE");
		}
		if(ObjectUtil.isNotEmpty(organCode)){
			whereSQL2.append(" AND ORGAN_CODE='" + organCode.toString() + "'");
			criteria.remove("ORGAN_CODE");
		}		
		criteria.remove("genreCode");
		SqlBuilder.buildWhereStatement(PersonDeathRecord.class, whereSQL1, criteria);
		String lastSql = String.format(sql.toString(),
				topTenDeath.size()>=1 ? topTenDeath.get(0).getDeathIcd():"##",
				topTenDeath.size()>=2 ? topTenDeath.get(1).getDeathIcd():"##",
				topTenDeath.size()>=3 ? topTenDeath.get(2).getDeathIcd():"##",
				topTenDeath.size()>=4 ? topTenDeath.get(3).getDeathIcd():"##",
				topTenDeath.size()>=5 ? topTenDeath.get(4).getDeathIcd():"##",
				topTenDeath.size()>=6 ? topTenDeath.get(5).getDeathIcd():"##",
				topTenDeath.size()>=7 ? topTenDeath.get(6).getDeathIcd():"##",
				topTenDeath.size()>=8 ? topTenDeath.get(7).getDeathIcd():"##",
				topTenDeath.size()>=9 ? topTenDeath.get(8).getDeathIcd():"##",
				topTenDeath.size()>=10 ? topTenDeath.get(9).getDeathIcd():"##",
				orgField, whereSQL1.toString(), whereSQL2.toString());
		return this.getList(lastSql, criteria);
    }

	@Override
	public List<Map<String, Object>> getDeathICD10MapList(Criteria ca) {
		StringBuilder reportWhere = new StringBuilder();
		SqlBuilder.buildWhereStatement(PersonDeathRecord.class, reportWhere, ca);
		String sql = String.format(DEATH_ICD10_ANALYSE_SQL,reportWhere.toString());
		return this.getMapList(sql,ca);
	}

	@Override
	public List<Map<String, Object>> getPersonTypeMapList(Criteria ca) {
		StringBuilder reportWhere = new StringBuilder();
		SqlBuilder.buildWhereStatement(PersonDeathRecord.class, reportWhere, ca);
		String sql = String.format(PERSON_TYPE_ANALYSE_SQL,reportWhere.toString());
		return this.getMapList(sql,ca);
	}
}