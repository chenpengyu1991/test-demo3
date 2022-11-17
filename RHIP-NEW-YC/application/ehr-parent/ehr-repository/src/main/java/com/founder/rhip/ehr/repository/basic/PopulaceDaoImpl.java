package com.founder.rhip.ehr.repository.basic;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.dto.DoctorSignCensus;
import com.founder.rhip.ehr.dto.FamilyStatisticDto;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.Populace;

/**
 * DAO implement of BiPopulace
 * 
 */
@Repository("populaceDao")
public class PopulaceDaoImpl extends AbstractDao<Populace, Long> implements IPopulaceDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

	// 机构标识
	public static final String ORG_CODE = "orgCode";
	public static final String CENTER_ORG_CODE = "centerOrgCode";
	public static final String GBCODE = "gbcode";


	private static final String POPULACE_SQL_1 = "SELECT ORGAN_CODE ORG_CODE, SUM(NVL(FAMILY_NUM, 0)) FAMILY_NUM, 0 RECORD_FAMILY_NUM " +
			"FROM BI_POPULACE WHERE 1 = 1 %s GROUP BY ORGAN_CODE";

	private static final String POPULACE_SQL_2 = "SELECT fa.INPUT_ORGAN_CODE ORG_CODE, 0 FAMILY_NUM, COUNT(1) RECORD_FAMILY_NUM "+
			"FROM BI_FAMILY_INFO fa  WHERE fa.STATUS = '0' %s GROUP BY fa.INPUT_ORGAN_CODE";


	private static final String POPULACE_TARGET_SQL = "SELECT *"
    		+ " FROM (SELECT decode(grouping_id(%2$s), 1, '合计', %2$s) AS ORGAN_CODE,"
    		+ " SUM(NVL(household_num, 0)+NVL(un_house_hold_num, 0)"
//    		+ " +NVL(un_household_woman_num, 0)+NVL(household_man_num, 0)+NVL(un_household_man_num, 0)"
//    		+ " +NVL(household_six_child_num, 0)+NVL(un_household_six_child_num, 0)+NVL(household_fertile_woman_num, 0)"
//    		+ " +NVL(un_household_fertile_woman_num, 0)+NVL(household_sixo_to_sixf_num, 0)+NVL(household_great_sixf_num, 0)"
//    		+ " +NVL(un_household_great_sixf_num, 0)+NVL(HOUSEHOLD_PHB_NUM, 0)+NVL(UNHOUSEHOLD_PHB_NUM, 0)+NVL(HOUSEHOLD_DI_NUM, 0)+NVL(UNHOUSEHOLD_DI_NUM, 0)+NVL(HOUSEHOLD_MENTAL_NUM, 0)+NVL(UNHOUSEHOLD_MENTAL_NUM, 0)"
    		+ ")  total,"
    		+ " SUM(NVL(household_num, 0)) AS householdNum,"
    		+ " SUM(NVL(un_house_hold_num, 0)) AS unHouseHoldNum,"
    		+ " SUM(NVL(household_woman_num, 0)) AS household_woman_num,"
    		+ " SUM(NVL(un_household_woman_num, 0)) AS un_household_woman_num,"
    		+ " SUM(NVL(household_man_num, 0)) AS household_man_num,"
    		+ " SUM(NVL(un_household_man_num, 0)) AS un_household_man_num,"
    		+ " SUM(NVL(household_six_child_num, 0)) AS household_six_child_num,"
    		+ " SUM(NVL(un_household_six_child_num, 0)) AS un_household_six_child_num,"
    		+ " SUM(NVL(household_fertile_woman_num, 0)) AS household_fertile_woman_num,"
    		+ " SUM(NVL(un_household_fertile_woman_num, 0)) AS un_household_fertile_woman_num,"
    		+ " SUM(NVL(household_sixo_to_sixf_num, 0)) AS household_sixo_to_sixf_num,"
    		+ " SUM(NVL(un_household_sixo_to_sixf_num, 0)) AS un_household_sixo_to_sixf_num,"
    		+ " SUM(NVL(household_great_sixf_num, 0)) AS household_great_sixf_num,"
    		+ " SUM(NVL(un_household_great_sixf_num, 0)) AS un_household_great_sixf_num,"
    		+ " SUM(NVL(HOUSEHOLD_PHB_NUM, 0)) AS HOUSEHOLD_PHB_NUM,SUM(NVL(UNHOUSEHOLD_PHB_NUM, 0)) AS UNHOUSEHOLD_PHB_NUM,"
    		+ " SUM(NVL(HOUSEHOLD_DI_NUM, 0)) AS HOUSEHOLD_DI_NUM,SUM(NVL(UNHOUSEHOLD_DI_NUM, 0)) AS UNHOUSEHOLD_DI_NUM,"
    		+ " SUM(NVL(HOUSEHOLD_MENTAL_NUM, 0)) AS HOUSEHOLD_MENTAL_NUM,SUM(NVL(UNHOUSEHOLD_MENTAL_NUM, 0)) AS UNHOUSEHOLD_MENTAL_NUM"
    		+ " FROM (SELECT org.gb_code,org.parent_code,org.ORGAN_CODE,org.GENRE_CODE,populace.*"
    		+ " FROM MDM_ORGANIZATION ORG"
    		+ " LEFT JOIN (SELECT t.count_year,t.organ_parent_code,t.organ_code organCode,t.gbcode,t.household_num,t.un_house_hold_num,"
    		+ " t.household_woman_num,t.un_household_woman_num,t.household_man_num,t.un_household_man_num,"
    		+ "  t.household_six_child_num,t.un_household_six_child_num,"
    		+ " t.household_fertile_woman_num,t.un_household_fertile_woman_num,"
    		+ "  t.household_sixo_to_sixf_num,t.un_household_sixo_to_sixf_num,"
    		+ " t.household_great_sixf_num,t.un_household_great_sixf_num, "
    		+ " t.HOUSEHOLD_PHB_NUM,t.UNHOUSEHOLD_PHB_NUM,t.HOUSEHOLD_DI_NUM,t.UNHOUSEHOLD_DI_NUM,t.HOUSEHOLD_MENTAL_NUM,t.UNHOUSEHOLD_MENTAL_NUM "
    		+ "  FROM bi_populace t %3$s"
    		+ " ) populace ON populace.organCode = ORG.ORGAN_CODE"
    		+ " WHERE 1 = 1 %1$s)" //paraent_code="" orgb_code=""
    		+ " GROUP BY CUBE(%2$s)  ORDER BY %2$s)"
    		+ " WHERE ORGAN_CODE is not null";
    
    @Override
    public List<String> getOrgCodes(){
    	String sql = "select distinct(organ_code) organ_code from BI_POPULACE";
    	
    	List<String> orgList = new ArrayList<String>();
    	
    	List<Map<String,Object>> mapList = this.getMapList(sql,new Criteria());
    	for(Map<String,Object> map :mapList){
       		String orgCode = "";
       		Object o = map.get("organ_code");
       		if(o != null){
       			orgCode = map.get("organ_code").toString();
       		}
       		orgList.add(orgCode);
       	}
    	return orgList;
    }
    
    /**
     * 根据镇 中心统计人口
     * @param
     * @return
     */
    public List<Populace> getTarget(String gbCode, String organCode, Integer countYear, String genreCode) {
    	
    	StringBuilder sql = new StringBuilder(POPULACE_TARGET_SQL);
		StringBuilder whereSQL1 = new StringBuilder();
		StringBuilder whereSQL2 = new StringBuilder();
		//genreCode   B1：卫生院  0 ：镇
		String orgField = "0".equals(genreCode)?"GB_CODE":"ORGAN_CODE";
		if(ObjectUtil.isNotEmpty(gbCode)){
			whereSQL1.append(" AND ORG.GB_CODE='" + gbCode + "'");
		} else if(ObjectUtil.isNotEmpty(organCode)){
			whereSQL1.append(" AND ORG.ORGAN_CODE='" + organCode + "'");
		}		
		if(ObjectUtil.isNotEmpty(countYear)) {
			whereSQL2.append(" where COUNT_YEAR='" + countYear + "'");
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			whereSQL2.append(" where COUNT_YEAR=" + calendar.get(Calendar.YEAR) + "");
		}
		//SqlBuilder.buildWhereStatement(Populace.class, whereSQL1, criteria);
		String lastSql = String.format(sql.toString(),whereSQL1.toString(), orgField,whereSQL2.toString());
		return this.getList(lastSql);
		
    }
    
    /**
     * 获取户籍非户籍的数据
     * @param dateStr 日期格式必须是yyyy/mm/dd
     * @return
     */
    @Override
    public List<Map<String, Object>> getPopulaceStatistics(String dateStr) {
    	if (ObjectUtil.isNullOrEmpty(dateStr)) {
			throw new IllegalArgumentException("日期不可以为空！");
		}
    	String whereSql = " where p.count_year=" + dateStr;
    	StringBuilder sqlBuilder = new StringBuilder("select p.organ_code, sum(nvl(p.household_num,0))household_num, "
    			+ " sum(nvl(p.un_house_hold_num,0))un_house_hold_num,"
    			+ " sum(nvl(p.household_num,0))+sum(nvl(p.un_house_hold_num,0)) allc"
    			+ " from bi_populace p %1$s group by p.organ_code");
    	
    	String lastSql = String.format(sqlBuilder.toString(),whereSql);
    	return this.getMapList(lastSql, new Criteria());
    }

    public List<Map<String, Object>> getPopolaceReport(Criteria criteria){
		int quarter = Integer.parseInt(criteria.get("quarter").toString());
		int month = 1;
		//根据季度算出月份
		if(quarter == 1){
			month = 1;
		}else if(quarter == 2){
			month = 4;
		}else if(quarter == 3){
			month = 7;
		}else if(quarter == 4){
			month = 10;
		}
    	String countType = criteria.get("countType").toString();
    	String curOrg = (String)criteria.get("curOrg");
		int year = Integer.parseInt(criteria.get("year").toString());
    	StringBuilder stringBuilder = new StringBuilder();
		if(criteria.get("countTotal") == "1"){//合计
			stringBuilder.append("select sum(total) total,sum(elder) elder,sum(phb) phb,sum(di) di,sum(mental) mental," +
					"sum(identificationNum) identificationNum,sum(maternalNum) maternalNum,sum(childNum) childNum from (");
		}
		stringBuilder.append("select basic.orgCode orgCode,basic.total total,basic.elder elder,basic.phb phb,basic.di di,basic.mental mental," +
				"identification.identificationNum identificationNum,maternal.maternalNum maternalNum,child.childNum childNum from ");
		//基本人口
		stringBuilder.append("(select bp.ORGAN_CODE orgCode,bp.allNum total," +
				"round((bp.allNum*0.1),0) elder," +
				"round((bp.allNum*0.172),0) phb," +
				"round((bp.allNum*0.04),0) di," +
				"round((bp.allNum*0.0036),0) mental  " +
				"from (select vmo.ORGAN_CODE ORGAN_CODE,sum(NVL(pop.HOUSEHOLD_NUM,0)+NVL(pop.UN_HOUSE_HOLD_NUM,0)) allNum from " +
				"MDM_ORGANIZATION vmo left join BI_POPULACE pop on vmo.ORGAN_CODE = pop.ORGAN_CODE and pop.COUNT_YEAR = "+year+" ");
		if(criteria.get("roleType") == "02"){
            stringBuilder.append("where vmo.ORGAN_CODE = '"+curOrg+"' group by vmo.ORGAN_CODE");
        }
        if(criteria.get("roleType") == "03"){
        	if(criteria.contains("organCode")){
				stringBuilder.append("where vmo.ORGAN_CODE = '"+criteria.get("organCode")+"' group by vmo.ORGAN_CODE");
			}else {
				stringBuilder.append("where vmo.PARENT_CODE = '" + curOrg + "' or vmo.ORGAN_CODE = '" + curOrg + "' group by vmo.ORGAN_CODE");
			}
		}
		stringBuilder.append(") bp) basic,");
		//体质辨识人数
		stringBuilder.append("(select vmo.ORGAN_CODE input_organ_code,NVL(iden.identificationNum,0) identificationNum from MDM_ORGANIZATION vmo left join (select input_organ_code,count(*) identificationNum from ECH_PHYSICAL_EXAM_RECORD " +
				             "where TCM_STATUS = '1'");
		if(countType.equals("1")){//按年查询
			stringBuilder.append(" and EXAM_YEAR >=to_date('"+year+"0101','yyyymmdd') and EXAM_YEAR < to_date('"+(year+1)+"0101','yyyymmdd')");
		}else if(countType.equals("2")){//按季度查询
			int nextMonth = month +3;
			if(quarter == 4){
				stringBuilder.append(" and EXAM_YEAR >=to_date('" + year + "" + month + "01','yyyymmdd') and EXAM_YEAR < to_date('" + (year+1) + "0101','yyyymmdd')");
			}else if(quarter == 3){
				stringBuilder.append(" and EXAM_YEAR >=to_date('" + year + "0" + month + "01','yyyymmdd') and EXAM_YEAR < to_date('" + year + "" + nextMonth + "01','yyyymmdd')");
			}else {
				stringBuilder.append(" and EXAM_YEAR >=to_date('" + year + "0" + month + "01','yyyymmdd') and EXAM_YEAR < to_date('" + year + "0" + nextMonth + "01','yyyymmdd')");
			}
		}

		stringBuilder.append(" group by input_organ_code) iden on vmo.organ_code = iden.input_organ_code) identification,");
		//产妇人数
		stringBuilder.append("(select vmo.ORGAN_CODE ORG_CODE,NVL(women.maternalNum,0) maternalNum from MDM_ORGANIZATION vmo left join (select ORG_CODE,count(*) maternalNum from WOMEN_CHILD_HEALTH " +
				             "where IDENTITY_TYPE = '2' ");
		if(countType.equals("1")){//按年查询
			stringBuilder.append(" and CREATE_DATE >=to_date('"+year+"0101','yyyymmdd') and CREATE_DATE < to_date('"+(year+1)+"0101','yyyymmdd')");
		}else if(countType.equals("2")){//按季度查询
			int nextMonth = month +3;
			if(quarter == 4){
				stringBuilder.append(" and CREATE_DATE >=to_date('" + year + "" + month + "01','yyyymmdd') and CREATE_DATE < to_date('" + (year+1) + "0101','yyyymmdd')");
			}else if(quarter == 3){
				stringBuilder.append(" and CREATE_DATE >=to_date('" + year + "0" + month + "01','yyyymmdd') and CREATE_DATE < to_date('" + year + "" + nextMonth + "01','yyyymmdd')");
			}else {
				stringBuilder.append(" and CREATE_DATE >=to_date('" + year + "0" + month + "01','yyyymmdd') and CREATE_DATE < to_date('" + year + "0" + nextMonth + "01','yyyymmdd')");
			}
		}
		stringBuilder.append("group by ORG_CODE) women on vmo.organ_code = women.org_code) maternal,");
		//0-6岁儿童数(人)
		stringBuilder.append("(select vmo.ORGAN_CODE ORG_CODE,NVL(a.childNum,0) childNum from MDM_ORGANIZATION vmo left join (select ORG_CODE,count(*) childNum from WOMEN_CHILD_HEALTH " +
			            	 "where IDENTITY_TYPE = '1' ");
		if(countType.equals("1")){//按年查询
			stringBuilder.append(" and child_birthday < to_date('"+(year+1)+"0101','yyyymmdd')");
		}else if(countType.equals("2")){//按季度查询
			int nextMonth = month +3;
			if(quarter == 4){
				stringBuilder.append(" and child_birthday < to_date('" + (year+1) + "0101','yyyymmdd')");
			}else if(quarter == 3){
				stringBuilder.append(" and child_birthday < to_date('" + year + "" + nextMonth + "01','yyyymmdd')");
			}else {
				stringBuilder.append(" and child_birthday < to_date('" + year + "0" + nextMonth + "01','yyyymmdd')");
			}
		}
		stringBuilder.append("group by ORG_CODE) a on vmo.organ_code = a.org_code) child where basic.orgCode = identification.input_organ_code and basic.orgCode = maternal.ORG_CODE and basic.orgCode = child.ORG_CODE");
		if(criteria.get("countTotal") == "1"){//合计
			stringBuilder.append(")");
		}
		return getMapList(stringBuilder.toString(),new Criteria());
	}

	@Override
	public Map<String, Object> getTotalCountByYear(Criteria criteria) {
		StringBuilder sql = new StringBuilder("SELECT SUM(nvl(HOUSEHOLD_MAN_NUM,0)) +  SUM(nvl(UN_HOUSEHOLD_MAN_NUM,0))MAN_NUM, \n" +
				"SUM(nvl(HOUSEHOLD_WOMAN_NUM,0)) + SUM(nvl(UN_HOUSEHOLD_WOMAN_NUM,0)) WOMAN_NUM, \n" +
				"SUM(nvl(HOUSEHOLD_MAN_NUM,0)) +  SUM(nvl(UN_HOUSEHOLD_MAN_NUM,0)) + \n" +
				"SUM(nvl(HOUSEHOLD_WOMAN_NUM,0)) + SUM(nvl(UN_HOUSEHOLD_WOMAN_NUM,0)) TOTAL_NUM FROM bi_POPULACE");

		SqlBuilder.buildWhereStatement(Populace.class, sql, criteria);
		return this.getMap(sql.toString(), criteria);
	};

	@Override
	public List<FamilyStatisticDto> getFamilyStatisticDtoList(Criteria criteria,
															  List<String> organCodeList) {

		String orgCode=(String)criteria.get("orgCode");
		String month=(String)criteria.get("month");
		String year=(String)criteria.get("year");

		StringBuilder finalSql = new StringBuilder();
		List<String> sqlList = new ArrayList<>();

		Map<String, Object> map = SqlBuilder.buildOrganCondition("ORGAN_CODE","COUNT_YEAR", null, null, orgCode, year, null, organCodeList, new MapSqlParameterSource(), 3);
		String sql = String.format(POPULACE_SQL_1, map.get(SqlBuilder.WHERE));
		sqlList.add(sql);

		map = SqlBuilder.buildOrganCondition("fa.INPUT_ORGAN_CODE","fa.INPUT_DATE", null, null, orgCode, year,  month, organCodeList, (MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 1);
		sql = String.format(POPULACE_SQL_2, map.get(SqlBuilder.WHERE));
		sqlList.add(sql);

		map = SqlBuilder.buildOrganCondition("V.ORGAN_CODE",null, null, null, orgCode, null, null, organCodeList, (MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 0);

		builDSSql(criteria, finalSql, sqlList);
		return getList(FamilyStatisticDto.class, String.format(finalSql.toString(), map.get(SqlBuilder.WHERE)), (MapSqlParameterSource) map.get(SqlBuilder.SOURCE));
	}

	private void builDSSql(Criteria criteria, StringBuilder finalSql, List<String> list) {
		StringBuilder sqlb = new StringBuilder();
		for(String sql :list){
			if(sqlb.length()==0){
				sqlb.append("(").append(sql);
			}else{
				sqlb.append(" UNION ALL ").append(sql);
			}
		}
		sqlb.append(")");

		finalSql.append("SELECT V.GB_CODE GB_CODE,V.ORGAN_CODE ORG_CODE," +
				" NVL(FAMILY_NUM, 0) FAMILY_NUM, NVL(RECORD_FAMILY_NUM, 0) RECORD_FAMILY_NUM " +
				" FROM mdm_organization V LEFT JOIN (")
				.append("SELECT ORG_CODE,")
				.append(" NVL(SUM(FAMILY_NUM), 0) FAMILY_NUM, " +
						" NVL(SUM(RECORD_FAMILY_NUM), 0) RECORD_FAMILY_NUM " +
						" FROM  ").append(sqlb).append(" GROUP BY ORG_CODE ) T ON V.ORGAN_CODE=T.ORG_CODE WHERE 1=1 %s ORDER BY V.ORGAN_CODE,V.ORGAN_NAME");
	}
}